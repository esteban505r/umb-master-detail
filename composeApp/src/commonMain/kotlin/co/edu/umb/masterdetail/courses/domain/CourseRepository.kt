package co.edu.umb.masterdetail.courses.domain

interface CourseRepository {
    fun getCourses(): List<Course>
    fun getCourseById(id: String): Course?
}
