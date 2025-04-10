pluginManagement {
    includeBuild("build-logic")
}

rootProject.name = "kotlin-starter"

include(":app")

project(":app").projectDir = file("modules/app")
