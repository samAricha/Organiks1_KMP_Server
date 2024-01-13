plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinX.serialization.plugin)
    alias(libs.plugins.sqlDelight.plugin)
    alias(libs.plugins.compose.multiplatform)
}

android {
    namespace = "com.joelkanyi.focusbloom.shared"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/commonMain/resources")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    jvm()


    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
            transitiveExport = true
            compilations.all {
                kotlinOptions.freeCompilerArgs += arrayOf("-linker-options", "-lsqlite3")
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.koin.core)
                api(libs.koin.compose)

                implementation(compose.material3)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)

                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation(libs.voyager.navigator)
                implementation(libs.voyager.bottomSheetNavigator)
                implementation(libs.voyager.transitions)
                implementation(libs.voyager.tabNavigator)

                implementation(libs.kotlinX.serializationJson)

                implementation(libs.material3.window.size.multiplatform)

               implementation(libs.sqlDelight.runtime)
                implementation(libs.sqlDelight.coroutine)
                implementation(libs.primitive.adapters)

                api(libs.multiplatformSettings.noArg)
                api(libs.multiplatformSettings.coroutines)

                api(libs.napier)

                implementation(libs.kotlinX.dateTime)
                implementation(libs.koalaplot.core)

                implementation(libs.stdlib)

                val ktorVersion = "2.3.7"
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.sqlDelight.android)
                implementation(libs.accompanist.systemUIController)
                implementation(libs.core)
                implementation(libs.compose.activity)
            }
        }

//        val nativeMain by creating {
//            dependsOn(commonMain)
//        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.sqlDelight.jvm)
                implementation(libs.kotlinx.coroutines.swing)

                // Toaster for Windows
                implementation(libs.toast4j)

                // JNA for Linux
                implementation("de.jangassen:jfa:1.2.0") {
                    // not excluding this leads to a strange error during build:
                    // > Could not find jna-5.13.0-jpms.jar (net.java.dev.jna:jna:5.13.0)
                    exclude(group = "net.java.dev.jna", module = "jna")
                }

                // JNA for Windows
                implementation(libs.jna)
            }
        }

    }
}

sqldelight {
    databases {
        create("BloomDatabase") {
            packageName.set("com.joelkanyi.focusbloom.database")
        }
    }
}
