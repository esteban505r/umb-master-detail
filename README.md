# UMB Master-Detail

Aplicación móvil Cross Platform (Kotlin Multiplatform + Compose Multiplatform) que implementa el patrón **Master-Detail**:

- **Vista Principal (Main):** pantalla de entrada de la aplicación.
- **Vista Maestro:** lista de unidades didácticas (cursos).
- **Vista Detalle:** información completa de la unidad didáctica seleccionada.

## Stack

- Kotlin Multiplatform (Android + Desktop)
- Compose Multiplatform (Material 3)
- Koin (inyección de dependencias)
- Navigation Compose Multiplatform

## Estructura

```
composeApp/
└── src/
    ├── commonMain/   # dominio, datos, presentación y UI compartidos
    ├── androidMain/  # MainActivity (host de la app compartida)
    └── desktopMain/  # entry point de escritorio
```

El módulo `courses` sigue la separación `domain / data / presentation / ui`:

- `domain`: modelo `Course` y casos de uso (`GetCoursesUseCase`, `GetCourseByIdUseCase`).
- `data`: `InMemoryCourseRepository`.
- `presentation`: `CourseListViewModel` / `CourseDetailViewModel` con sus `UiState`.
- `ui`: `CourseListScreen` (Maestro) y `CourseDetailScreen` (Detalle).

## Cómo ejecutar

**Android:**

```bash
./gradlew :composeApp:installDebug
```

**Escritorio:**

```bash
./gradlew :composeApp:run
```

## Captura de evidencias

Para el informe de laboratorio, ejecuta la app y toma pantallazos de:

1. Vista Principal (Main)
2. Vista Maestro (lista de unidades didácticas)
3. Vista Detalle (al seleccionar una unidad)
