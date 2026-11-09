package co.edu.umb.masterdetail

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import co.edu.umb.masterdetail.courses.di.coursesModule
import co.edu.umb.masterdetail.navigation.AppNavHost
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = { modules(coursesModule) }) {
        MaterialTheme {
            AppNavHost()
        }
    }
}
