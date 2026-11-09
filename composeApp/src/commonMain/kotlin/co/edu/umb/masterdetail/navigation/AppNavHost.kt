package co.edu.umb.masterdetail.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.umb.masterdetail.courses.ui.CourseDetailScreen
import co.edu.umb.masterdetail.courses.ui.CourseListScreen
import co.edu.umb.masterdetail.ui.MainScreen

private object Routes {
    const val MAIN = "main"
    const val MASTER = "master"
    const val DETAIL_PATTERN = "detail/{courseId}"
    fun detail(courseId: String) = "detail/$courseId"
}

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.MAIN) {
        composable(Routes.MAIN) {
            MainScreen(onEnterCourses = { navController.navigate(Routes.MASTER) })
        }
        composable(Routes.MASTER) {
            CourseListScreen(
                onCourseSelected = { course -> navController.navigate(Routes.detail(course.id)) },
            )
        }
        composable(Routes.DETAIL_PATTERN) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getString("courseId").orEmpty()
            CourseDetailScreen(courseId = courseId, onBack = { navController.popBackStack() })
        }
    }
}
