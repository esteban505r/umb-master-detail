package co.edu.umb.masterdetail.courses.domain

data class Course(
    val id: String,
    val name: String,
    val eje: String,
    val sessions: Int,
    val description: String,
)
