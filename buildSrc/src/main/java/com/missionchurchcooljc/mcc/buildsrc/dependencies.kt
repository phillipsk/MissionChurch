package com.missionchurchcooljc.mcc.buildsrc

const val kotlinVersion = "1.4.10"

object PluginVersions {
    const val kotlin = "1.4.10"
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.0.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val gmsGoogleServices = "com.google.gms:google-services:4.3.4"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
//    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:2.29.1-alpha"
//    const val kotlinAndroidExtensions = "kotlin-android-extensions" // deprecated in KT v1.4

}

object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}

object Versions {
//    const val ktlint = "0.39.0"
}

object Libs {
    //    const val androidGradlePlugin = "com.android.tools.build:gradle:4.0.0" // replaced above
    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val test = "com.squareup.okhttp3:mockwebserver:4.9.0"
    }

    //
    object Kotlin {
//        private const val version = "1.3.72"
//        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version" // replaced above

        //        private const val version = "1.4.10"
//        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
//        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Hilt {
        private const val version = "2.29.1-alpha"
        const val library = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"

        object viewModel {
            private const val version = "1.0.0-alpha02"
            const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val kaptCompiler = "androidx.hilt:hilt-compiler:$version"
        }
    }

    object Dagger {
        private const val version = "2.32"
        const val dagger = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
    }

    object Google {

        private const val version = "1.3.72"
        const val material = "com.google.android.material:material:1.2.1"
        const val gson = "com.google.code.gson:gson:2.8.2"

    }

    object Glide {
        private const val version = "4.10.0"
        const val glideKapt = "com.github.bumptech.glide:compiler:$version"
        const val glide = "com.github.bumptech.glide:glide:$version"


    }

    //
//    object Coroutines {
//        private const val version = "1.3.9"
//        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
//        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
//        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
//    }
    object Test {
        const val junit = "junit:junit:4.13.1"
    }

    //
    object AndroidX {
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val work = "androidx.work:work-runtime-ktx:2.4.0"


        object Fragment {
            private const val version = "1.2.5"

            //            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Navigation {
            private const val version = "2.3.2"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Room {
            private const val version = "2.2.5"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"

            // optional - Kotlin Extensions and Coroutines support for Room
            const val ktx = "androidx.room:room-ktx:$version"
        }


        object Lifecycle {
            private const val version = "2.2.0"
//            deprecated
//            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"

            // ViewModel
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"

            // LiveData
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"

            // Lifecycles only (without ViewModel or LiveData)
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"

            // Saved state module for ViewModel
            const val savedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"

            // Annotation processor
            const val kaptCompiler = "androidx.lifecycle:lifecycle-compiler:$version"
        }

        object Test {
            private const val version = "2.0.0"
            const val archCore = "androidx.arch.core:core-testing:$version"

            // TODO: how is hamcreset imiplemented if not directly implemented
//            const val hamcrest = "org.hamcrest:hamcrest-library:1.3"
            const val core = "androidx.test:core:1.3.1-alpha02"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    const val swiperefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

}

//        const val browser = "androidx.browser:browser:1.0.0"
//        const val collection = "androidx.collection:collection-ktx:1.1.0"
//        const val palette = "androidx.palette:palette:1.0.0"
//        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha06"
//        const val emoji = "androidx.emoji:emoji:1.1.0"
//

//
//        const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"
//
//        object Paging {
//            private const val version = "2.1.2"
//            const val common = "androidx.paging:paging-common-ktx:$version"
//            const val runtime = "androidx.paging:paging-runtime-ktx:$version"
//        }
//
//        const val preference = "androidx.preference:preference:1.1.1"
//
//
//        const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha04"
//

//

//
//        object Work {
//            private const val version = "2.4.0"
//            const val runtimeKtx = "androidx.work:work-runtime-ktx:$version"
//        }
//
//        object Compose {
//            const val snapshot = "6922857"
//            const val version = "1.0.0-SNAPSHOT"
//
//            @get:JvmStatic
//            val snapshotUrl: String
//                get() = "https://androidx.dev/snapshots/builds/$snapshot/artifacts/repository/"
//
//            const val compiler = "androidx.compose.compiler:compiler:$version"
//
//            const val runtime = "androidx.compose.runtime:runtime:$version"
//            const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
//
//            const val foundation = "androidx.compose.foundation:foundation:$version"
//            const val layout = "androidx.compose.foundation:foundation-layout:$version"
//
//            const val ui = "androidx.compose.ui:ui:$version"
//            const val material = "androidx.compose.material:material:$version"
//
//            const val animation = "androidx.compose.animation:animation:$version"
//
//            const val tooling = "androidx.ui:ui-tooling:$version"
//            const val test = "androidx.ui:ui-test:$version"
//        }
//
//        object Hilt {
//            private const val version = "1.0.0-alpha02"
//            const val work = "androidx.hilt:hilt-work:$version"
//            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
//            const val compiler = "androidx.hilt:hilt-compiler:$version"
//        }
//    }
//
