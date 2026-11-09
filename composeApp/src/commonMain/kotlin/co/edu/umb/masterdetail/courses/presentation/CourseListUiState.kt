package co.edu.umb.masterdetail.courses.presentation

import co.edu.umb.masterdetail.courses.domain.Course

data class CourseListUiState(
    val isLoading: Boolean = false,
    val courses: List<Course> = emptyList(),
    val error: String? = null,
)
