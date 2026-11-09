package co.edu.umb.masterdetail.courses.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.edu.umb.masterdetail.courses.domain.Course
import co.edu.umb.masterdetail.courses.presentation.CourseDetailUiState
import co.edu.umb.masterdetail.courses.presentation.CourseDetailViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

/** Vista Detalle: muestra la información completa del curso seleccionado en el Maestro. */
@Composable
fun CourseDetailScreen(
    courseId: String,
    onBack: () -> Unit,
    viewModel: CourseDetailViewModel = koinViewModel(key = courseId) { parametersOf(courseId) },
) {
    val uiState by viewModel.uiState.collectAsState()
    CourseDetailContent(uiState = uiState, onBack = onBack)
}

@Composable
fun CourseDetailContent(uiState: CourseDetailUiState, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Vista Detalle") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver al Maestro")
                    }
                },
            )
        },
    ) { padding ->
        when {
            uiState.isLoading -> Box(Modifier.fillMaxSize().padding(padding), Alignment.Center) {
                CircularProgressIndicator()
            }
            uiState.course == null -> Box(Modifier.fillMaxSize().padding(padding), Alignment.Center) {
                Text(uiState.error ?: "Curso no encontrado")
            }
            else -> CourseDetailBody(course = uiState.course, modifier = Modifier.padding(padding))
        }
    }
}

@Composable
private fun CourseDetailBody(course: Course, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(course.name, style = MaterialTheme.typography.headlineSmall)
        Text(course.eje, style = MaterialTheme.typography.titleMedium)
        HorizontalDivider()
        Text("Sesiones: ${course.sessions}", style = MaterialTheme.typography.bodyLarge)
        Text(course.description, style = MaterialTheme.typography.bodyMedium)
    }
}
