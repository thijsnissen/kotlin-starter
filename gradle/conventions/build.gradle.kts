plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.jib)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.ktlint)
}
