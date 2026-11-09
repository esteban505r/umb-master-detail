package co.edu.umb.masterdetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/** Vista Principal (Main): punto de entrada de la aplicación. */
@Composable
fun MainScreen(onEnterCourses: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("UMB · Master-Detail") }) },
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "Guía 1 · Trabajo con Vistas Master Detail",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
            )
            Text(
                "Aplicación de ejemplo que expone una Vista Principal, una Vista Maestro " +
                    "(lista de unidades didácticas) y una Vista Detalle.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
            Button(onClick = onEnterCourses) {
                Text("Ver Unidades Didácticas")
            }
        }
    }
}
