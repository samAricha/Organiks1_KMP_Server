plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.compose.multiplatform)
}

android {
    namespace = "com.teka.organiks.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.teka.organiks.android"
        minSdk = 24
        targetSdk = compileSdk
        versionCode = 4
        versionName = "1.0.3"
    }
    buildTypes {
        // debug
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.compose.activity)
    implementation(libs.koin.android)
    coreLibraryDesugaring(libs.core.library.desugaring)
}
