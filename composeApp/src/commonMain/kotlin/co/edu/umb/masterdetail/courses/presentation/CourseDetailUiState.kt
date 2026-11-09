package co.edu.umb.masterdetail.courses.presentation

import co.edu.umb.masterdetail.courses.domain.Course

data class CourseDetailUiState(
    val isLoading: Boolean = false,
    val course: Course? = null,
    val error: String? = null,
)
