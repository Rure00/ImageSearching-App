import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("kotlin-parcelize")
}

android {
    namespace = "com.project.imagesearchingapp"
    compileSdk = 34

    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").inputStream())

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.project.imagesearchingapp"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        buildConfigField("String",
            "KAKAO_API_KEY",
            properties.getProperty("kakao_app_key")
        )
        buildConfigField("String",
            "KAKAO_REST_KEY",
            properties.getProperty("kakao_rest_key")
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        viewBinding {
            enable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.play.services.fitness)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    testImplementation(libs.kotlinx.coroutines.test)

    implementation(libs.glide)
}