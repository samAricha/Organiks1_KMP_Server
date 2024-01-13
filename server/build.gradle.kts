plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.ktor)
    application
}

group = "org.teka.project"
version = "1.0.0"
application {
    mainClass.set("org.teka.project.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["development"] ?: "false"}")
}

dependencies {
//    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
}