pluginManagement {
    includeBuild("gradle/conventions")
}

rootProject.name = "kotlin-starter"

include(":app")

project(":app").projectDir = file("modules/app")
