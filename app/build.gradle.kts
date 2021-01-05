/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import dependencies.Dependencies
import dependencies.DebugDependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.addTestsDependencies
import extensions.implementation
import extensions.debugImplementation
import extensions.kapt

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
//    id(BuildPlugins.DAGGER_HILT)
    id(BuildPlugins.KOTLIN_KAPT)
}

//allOpen {
    // allows mocking for classes w/o directly opening them for release builds
//    annotation("com.vmadalin.core.annotations.OpenClass")
//}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

//        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArguments.putAll(BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER_ARGUMENTS)

    }
    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }

        getByName(BuildType.DEBUG) {
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
        }
    }
//    flavorDimensions(BuildProductDimensions.ENVIRONMENT)
//    productFlavors {
//        ProductFlavorDevelop.appCreate(this)
//        ProductFlavorQA.appCreate(this)
//        ProductFlavorProduction.appCreate(this)
//    }
//
//    dynamicFeatures = mutableSetOf(
//        BuildModules.Features.HOME,
//        BuildModules.Features.CHARACTERS_LIST,
//        BuildModules.Features.CHARACTERS_FAVORITES
//    )

    buildFeatures {
        dataBinding = true
    }

//    androidExtensions {
//        isExperimental = true
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
}


dependencies {
//    implementation(project(BuildModules.CORE))

    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.LOGGING)
    implementation(Dependencies.PLAY_CORE)
    implementation(Dependencies.DAGGER)

    debugImplementation(DebugDependencies.LEAKCANARY)

    kapt(AnnotationProcessorsDependencies.DAGGER)

    addTestsDependencies()
}


//import io.techministry.android.missionchurch.buildsrc.AndroidSdk
//import io.techministry.android.missionchurch.buildsrc.BuildPlugins.Versions.buildToolsVersion
//import io.techministry.android.missionchurch.buildsrc.Libs
//import io.techministry.android.missionchurch.buildsrc.BuildPluginsMaster
//
//plugins {
//    id(BuildPluginsMaster.ANDROID_APPLICATION)
//    id(BuildPluginsMaster.KOTLIN_ANDROID)
//    id(BuildPluginsMaster.NAVIGATION_SAFE_ARGS)
//    id(BuildPluginsMaster.DAGGER_HILT)
//    id(BuildPluginsMaster.KOTLIN_KAPT)
//
//}
//
//
//android {
//    compileSdkVersion(AndroidSdk.compile)
//    buildToolsVersion "30.0.2"
//
//    defaultConfig {
//        applicationId "io.techministry.android.missionchurch"
//        minSdkVersion(AndroidSdk.min)
//        targetSdkVersion(AndroidSdk.target)
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    buildFeatures {
//        dataBinding true
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//
//        // Enable Coroutines and Flow APIs
//        freeCompilerArgs += "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
////        freeCompilerArgs += "-Xopt-in=kotlinx.coroutines.FlowPreview"
//    }
////    packagingOptions {
//////        exclude 'META-INF/DEPENDENCIES'
////    }
//}
//
//dependencies {
////    implementation('com.getkeepsafe.dexcount:dexcount-gradle-plugin:2.0.0')
////    classpath 'com.getkeepsafe.dexcount:dexcount-gradle-plugin:2.0.0'
//
//    implementation fileTree(dir: "libs", include: ["*.jar"])
//    implementation(Libs.AndroidX.appcompat)
//    implementation(Libs.AndroidX.constraintlayout)
//    implementation(Libs.AndroidX.Navigation.fragment)
//    implementation(Libs.AndroidX.Navigation.ui)
//
//    implementation(Libs.AndroidX.Fragment.fragmentKtx)
//    implementation(Libs.AndroidX.Room.runtime)
//    kapt(Libs.AndroidX.Room.compiler)
//    implementation(Libs.AndroidX.Room.ktx)
//
//    implementation(Libs.AndroidX.Lifecycle.livedata)
//    implementation(Libs.AndroidX.Lifecycle.viewmodel)
//    implementation(Libs.AndroidX.Lifecycle.savedState)
////    implementation(Libs.AndroidX.Lifecycle.runtime)
//    kapt(Libs.AndroidX.Lifecycle.kaptCompiler)
//
////    commented out dependencies to avoid MultiDex
//
//
//    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
//    androidTestImplementation(Libs.AndroidX.Test.archCore)
//    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
//    androidTestImplementation(Libs.AndroidX.Hilt.testing)
//
////    implementation(Libs.swiperefresh)
//    implementation(Libs.Google.material)
//    implementation(Libs.AndroidX.work)
//    implementation(Libs.Google.gson)
//
//    implementation(Libs.AndroidX.Hilt.library)
//    kapt(Libs.AndroidX.Hilt.compiler)
//    implementation(Libs.AndroidX.Hilt.viewModel.viewModel)
//    kapt(Libs.AndroidX.Hilt.viewModel.kaptCompiler)
//
//    //Glide
//    implementation(Libs.Glide.glide)
//    kapt(Libs.Glide.glideKapt)
//
