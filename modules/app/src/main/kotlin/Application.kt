import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {}

val msg: String =
    ClassLoader.getSystemResourceAsStream("hello-world.txt")?.use { s ->
        s.bufferedReader().readText().trim()
    } ?: error("Resource not found!")

fun main() {
    logger.info { "starting application" }

    println(msg)
}
