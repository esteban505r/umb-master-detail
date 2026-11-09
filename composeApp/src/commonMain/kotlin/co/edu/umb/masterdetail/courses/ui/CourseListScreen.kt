package co.edu.umb.masterdetail.courses.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import co.edu.umb.masterdetail.courses.domain.Course
import co.edu.umb.masterdetail.courses.presentation.CourseListUiState
import co.edu.umb.masterdetail.courses.presentation.CourseListViewModel
import org.koin.compose.viewmodel.koinViewModel

/** Vista Maestro: lista de cursos. Al seleccionar uno navega al Detalle. */
@Composable
fun CourseListScreen(
    onCourseSelected: (Course) -> Unit,
    viewModel: CourseListViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    CourseListContent(uiState = uiState, onCourseSelected = onCourseSelected)
}

@Composable
fun CourseListContent(
    uiState: CourseListUiState,
    onCourseSelected: (Course) -> Unit,
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Vista Maestro · Unidades Didácticas") }) },
    ) { padding ->
        when {
            uiState.isLoading -> Box(Modifier.fillMaxSize().padding(padding), Alignment.Center) {
                CircularProgressIndicator()
            }
            uiState.error != null -> Box(Modifier.fillMaxSize().padding(padding), Alignment.Center) {
                Text("Error: ${uiState.error}")
            }
            else -> LazyColumn(Modifier.fillMaxSize().padding(padding)) {
                items(uiState.courses, key = { it.id }) { course ->
                    CourseListItem(course = course, onClick = { onCourseSelected(course) })
                }
            }
        }
    }
}
