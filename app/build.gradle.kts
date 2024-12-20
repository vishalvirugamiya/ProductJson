plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.productsjs"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.productsjs"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.volley)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation( "com.github.bumptech.glide:glide:4.12.0")
    implementation("com.android.volley:volley:1.2.1")
   // implementation ("com.squareup.picasso:picasso:2.5.2")
    implementation("com.intuit.sdp:sdp-android:1.1.1")
    implementation("com.intuit.ssp:ssp-android:1.1.1")

   // implementation ("androidx.recyclerview:recyclerview:1.2.5")
    implementation ("ru.tinkoff.scrollingpagerindicator:scrollingpagerindicator:1.2.5")


    // annotationProcessor("om.github.bumptech.glide:compiler:4.12.0")
}