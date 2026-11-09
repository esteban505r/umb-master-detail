package co.edu.umb.masterdetail.courses.domain

class GetCourseByIdUseCase(private val repository: CourseRepository) {
    operator fun invoke(id: String): Course? = repository.getCourseById(id)
}
