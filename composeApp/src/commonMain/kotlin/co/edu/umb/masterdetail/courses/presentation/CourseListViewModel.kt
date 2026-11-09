package co.edu.umb.masterdetail.courses.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.umb.masterdetail.courses.domain.GetCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CourseListViewModel(private val getCourses: GetCoursesUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(CourseListUiState())
    val uiState: StateFlow<CourseListUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            runCatching { getCourses() }
                .onSuccess { courses -> _uiState.update { it.copy(isLoading = false, courses = courses) } }
                .onFailure { e -> _uiState.update { it.copy(isLoading = false, error = e.message) } }
        }
    }
}
