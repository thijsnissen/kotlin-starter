val msg: String =
    ClassLoader.getSystemResourceAsStream("hello-world.txt")?.use { s ->
        s.bufferedReader().readText().trim()
    } ?: error("Resource not found!")

fun main() {
    println(msg)
}
