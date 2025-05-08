group = ""
version = "0.1.0-SNAPSHOT"

description = "Directory structure and settings for starting a new Kotlin project"

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    implementation(versionCatalogUnsafe.findLibrary("dotenv.kotlin").get())
    implementation(versionCatalogUnsafe.findLibrary("kotlin.logging.jvm").get())
    implementation(versionCatalogUnsafe.findLibrary("kotlinx.coroutines").get())
    implementation(versionCatalogUnsafe.findLibrary("slf4j").get())
    runtimeOnly(versionCatalogUnsafe.findLibrary("logback.classic").get())
    testImplementation(versionCatalogUnsafe.findLibrary("kotlinx.coroutines.test").get())
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)

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
            useJUnitJupiter(versionCatalogUnsafe.findVersion("junit").get().toString())

            targets.all {
                testTask.configure {
                    testLogging { events("passed", "skipped", "failed") }
                }
            }
        }
    }
}

ktlint {
    version.set("1.5.0")
}

val verify by tasks.registering {
    dependsOn("ktlintCheck", "test")
    description = "run formatting check and tests"
}
