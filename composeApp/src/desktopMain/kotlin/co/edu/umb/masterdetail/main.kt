package co.edu.umb.masterdetail

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "UMB Master-Detail") {
        App()
    }
}
