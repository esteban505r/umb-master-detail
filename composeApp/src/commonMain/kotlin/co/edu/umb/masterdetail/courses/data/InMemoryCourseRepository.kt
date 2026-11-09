package co.edu.umb.masterdetail.courses.data

import co.edu.umb.masterdetail.courses.domain.Course
import co.edu.umb.masterdetail.courses.domain.CourseRepository

class InMemoryCourseRepository : CourseRepository {

    private val courses = listOf(
        Course(
            id = "1",
            name = "Interfaz del Usuario",
            eje = "Unidad Didáctica 1",
            sessions = 1,
            description = "Desarrolla aplicaciones móviles con vistas o formularios que exponen un " +
                "menú maestro y páginas de detalle, permitiendo una navegación limpia y estándar " +
                "para los usuarios.",
        ),
        Course(
            id = "2",
            name = "Control de Código Fuente",
            eje = "Unidad Didáctica 2",
            sessions = 2,
            description = "Introduce el control de versiones y el uso de Team Foundation Server " +
                "como herramientas de trabajo colaborativo en el desarrollo móvil.",
        ),
        Course(
            id = "3",
            name = "Computación Paralela",
            eje = "Unidad Didáctica 3",
            sessions = 1,
            description = "Explora el estado del arte sobre computación paralela y las API " +
                "disponibles para aprovechar procesadores multi-núcleo en aplicaciones móviles.",
        ),
        Course(
            id = "4",
            name = "Acceso a Hardware Nativo",
            eje = "Unidad Didáctica 4",
            sessions = 1,
            description = "Cubre el uso de GPS y otras propiedades nativas del dispositivo desde " +
                "código compartido, y cuándo recurrir a componentes nativos adicionales.",
        ),
    )

    override fun getCourses(): List<Course> = courses

    override fun getCourseById(id: String): Course? = courses.find { it.id == id }
}
