package co.edu.umb.masterdetail.courses.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.edu.umb.masterdetail.courses.domain.Course

@Composable
fun CourseListItem(course: Course, onClick: () -> Unit) {
    ListItem(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick).padding(horizontal = 4.dp),
        headlineContent = { Text(course.name) },
        supportingContent = {
            Column {
                Text(course.eje)
                Text("${course.sessions} sesión(es)")
            }
        },
        trailingContent = { Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null) },
    )
}
