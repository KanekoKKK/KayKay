plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "jp.ac.meijou.android.kaykay"
    compileSdk = 34

    defaultConfig {
        applicationId = "jp.ac.meijou.android.kaykay"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.appcompat.v161)
    implementation(libs.material.v190)
    implementation(libs.okhttp)
    implementation("com.google.code.gson:gson:2.10")
}