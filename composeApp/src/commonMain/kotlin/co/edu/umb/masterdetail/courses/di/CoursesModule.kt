package co.edu.umb.masterdetail.courses.di

import co.edu.umb.masterdetail.courses.data.InMemoryCourseRepository
import co.edu.umb.masterdetail.courses.domain.CourseRepository
import co.edu.umb.masterdetail.courses.domain.GetCourseByIdUseCase
import co.edu.umb.masterdetail.courses.domain.GetCoursesUseCase
import co.edu.umb.masterdetail.courses.presentation.CourseDetailViewModel
import co.edu.umb.masterdetail.courses.presentation.CourseListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val coursesModule = module {
    single<CourseRepository> { InMemoryCourseRepository() }
    factory { GetCoursesUseCase(get()) }
    factory { GetCourseByIdUseCase(get()) }
    viewModel { CourseListViewModel(get()) }
    viewModel { (courseId: String) -> CourseDetailViewModel(courseId, get()) }
}
