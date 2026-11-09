package co.edu.umb.masterdetail.courses.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.umb.masterdetail.courses.domain.GetCourseByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CourseDetailViewModel(
    private val courseId: String,
    private val getCourseById: GetCourseByIdUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CourseDetailUiState())
    val uiState: StateFlow<CourseDetailUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            runCatching { getCourseById(courseId) }
                .onSuccess { course -> _uiState.update { it.copy(isLoading = false, course = course) } }
                .onFailure { e -> _uiState.update { it.copy(isLoading = false, error = e.message) } }
        }
    }
}
