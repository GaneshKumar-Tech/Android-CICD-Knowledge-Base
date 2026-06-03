plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.githubactionsdemo"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.githubactionsdemo"
        minSdk = 24
        targetSdk = 35
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

    flavorDimensions += "environment"

    productFlavors {

        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            versionCode = 1
            versionName = "1.0"
            buildConfigField("String", "BASE_URL", "\"https://dev.example.com\"")
            //buildConfigField("String", "API_KEY", "dev-api-key")
            buildConfigField("String", "ENVIRONMENT", "\"DEV\"")
            resValue("string", "app_name", "GitHub-Actions-Demo-DEV")
        }

        create("qa") {
            dimension = "environment"
            applicationIdSuffix = ".qa"
            versionNameSuffix = "-qa"
            versionCode = 1
            versionName = "1.0"
            buildConfigField("String", "BASE_URL", "\"https://qa.example.com\"")
            //buildConfigField("String", "API_KEY", "qa-api-key")
            buildConfigField("String", "ENVIRONMENT", "\"QA\"")
            resValue("string", "app_name", "GitHub-Actions-Demo-QA")
        }

        create("prod") {
            dimension = "environment"
            versionCode = 1
            versionName = "1.0"
            buildConfigField("String", "BASE_URL", "\"https://prod.example.com\"")
            //buildConfigField("String", "API_KEY", "prod-api-key")
            buildConfigField("String", "ENVIRONMENT", "\"PROD\"")
            resValue("string", "app_name", "GitHub-Actions-Demo")
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}