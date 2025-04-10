val catalog = VersionCatalogUnsafe(project)

group = ""
version = "0.1.0-SNAPSHOT"

description = "Directory structure and settings for starting a new Kotlin project"

plugins {
    id("com.google.cloud.tools.jib")
    id("org.jetbrains.kotlin.jvm")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    catalog.libs("dotenv.kotlin") { implementation(it) }
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)

    kotlinDaemonJvmArgs = listOf(
        "-XX:MaxRAMPercentage=50.0",
        "-XX:+HeapDumpOnOutOfMemoryError",
        "-XX:+UseG1GC"
    )

    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-Werror",
            "-Wextra",
            "-verbose"
        )
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter(catalog.versions("junit"))

            targets.all {
                testTask.configure {
                    testLogging { events("passed", "skipped", "failed") }
                }
            }
        }
    }
}

val verify by tasks.registering {
    dependsOn("ktlintCheck", "test")
    description = "run formatting check and tests"
}
