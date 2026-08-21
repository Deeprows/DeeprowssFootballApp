plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.deeprows.football"

    compileSdk = 35

    defaultConfig {
        applicationId = "com.deeprows.football"

        minSdk = 23
        targetSdk = 35

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    /*
     * AndroidX
     */
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.activity:activity-compose:1.12.1")

    /*
     * Jetpack Compose
     */
    implementation(platform("androidx.compose:compose-bom:2025.09.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    implementation("androidx.compose.material3:material3")

    /*
     * AndroidX Lifecycle
     */
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")

    /*
     * Media3 / ExoPlayer
     *
     * Native Android video playback.
     */
    implementation("androidx.media3:media3-exoplayer:1.11.0")
    implementation("androidx.media3:media3-ui:1.11.0")
    implementation("androidx.media3:media3-common:1.11.0")

    /*
     * HLS support
     *
     * Important for .m3u8 football streams.
     */
    implementation("androidx.media3:media3-exoplayer-hls:1.11.0")

    /*
     * Testing
     */
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation(
        platform("androidx.compose:compose-bom:2025.09.00")
    )

    androidTestImplementation(
        "androidx.compose.ui:ui-test-junit4"
    )

    debugImplementation(
        "androidx.compose.ui:ui-tooling"
    )

    debugImplementation(
        "androidx.compose.ui:ui-test-manifest"
    )
}
