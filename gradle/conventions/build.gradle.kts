plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.jib)
    implementation(libs.kotlin)
    implementation(libs.ktlint)
}
