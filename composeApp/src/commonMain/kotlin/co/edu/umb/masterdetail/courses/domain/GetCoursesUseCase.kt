package co.edu.umb.masterdetail.courses.domain

class GetCoursesUseCase(private val repository: CourseRepository) {
    operator fun invoke(): List<Course> = repository.getCourses()
}
