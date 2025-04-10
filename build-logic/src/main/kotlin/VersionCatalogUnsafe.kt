import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class VersionCatalogUnsafe(val project: Project) {
    private val catalog: VersionCatalog = project
        .extensions
        .getByType<VersionCatalogsExtension>()
        .named("libs")

    private fun notFound(name: String): Exception =
        IllegalArgumentException("not found in version catalog: '$name'")

    fun <A> libs(
        name: String,
        handler: (String) -> A
    ): A = handler(
        catalog
            .findLibrary(name)
            .map { it.get().toString() }
            .orElseThrow { notFound(name) }
    )

    fun versions(name: String): String =
        catalog
            .findVersion(name)
            .map { it.toString() }
            .orElseThrow { notFound(name) }
}
