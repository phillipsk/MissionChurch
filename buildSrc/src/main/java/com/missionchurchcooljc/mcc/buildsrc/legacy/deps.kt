/*
 * Copyright (c) 2021 Kevin Phillips, Mission Church of Our Lord Jesus Christ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.mcc.buildsrc.legacy

import Versions.butterKnifeVersion
import Versions.circleImageVersion
import Versions.daggerVersion
import Versions.fireStoreVersion
import Versions.firebaseCoreVersion
import Versions.firebaseVersion
import Versions.fuelHTTPversion
import Versions.googleMapsVersion
import Versions.gsonVersion
import Versions.okhttpVersion
import Versions.picassoVersion
import Versions.playServicesVersion
import Versions.retrofitConvertersVersion
import Versions.retrofitVersion
import Versions.timeAgoVersion

object LegacyJava {


    object AndroidX {

        const val appcompat = "androidx.appcompat:appcompat:1.0.2"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
        const val legacysupport = "androidx.legacy:legacy-support-v4:1.0.0"
        const val browser = "androidx.browser:browser:1.0.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"

    }

    object Google {
        const val material = "com.google.android.material:material:1.0.0"
        const val gson = "com.google.code.gson:gson:$gsonVersion"

        object PlayServices {

            const val auth = "com.google.android.gms:play-services-auth:$playServicesVersion"
            const val maps = "com.google.android.gms:play-services-maps:$googleMapsVersion"
        }

        object Firebase {

            const val database = "com.google.firebase:firebase-database:$firebaseVersion"
            const val firestore = "com.google.firebase:firebase-firestore:$fireStoreVersion"
            const val auth = "com.google.firebase:firebase-auth:$firebaseVersion"
            const val storage = "com.google.firebase:firebase-storage:$firebaseVersion"
            const val core = "com.google.firebase:firebase-core:$firebaseCoreVersion"


        }

        ////// Dagger II ////
        object Dagger {

            const val android = "com.google.dagger:dagger-android:$daggerVersion"
            const val support = "com.google.dagger:dagger-android-support:$daggerVersion"

            //    annotationProcessor "com.google.dagger:dagger-android-processor:$daggerVersion"
//    annotationProcessor "com.google.dagger:dagger-compiler:$daggerVersion"
            const val processorAP = "com.google.dagger:dagger-android-processor:$daggerVersion"
            const val compilerAP = "com.google.dagger:dagger-compiler:$daggerVersion"
        }

    }

    ///// Network Libraries ///////
    object Network {

        object Okhttp {

            const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"
            const val interceptor = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
        }

        object Retrofit {

            const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
            const val gson = "com.squareup.retrofit2:converter-gson:$retrofitConvertersVersion"
            const val rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
            const val rxjava =
                "com.squareup.retrofit2:adapter-rxjava:$retrofitConvertersVersion"
            const val moshi = "com.squareup.retrofit2:converter-moshi:2.5.0"
        }

        object Setho {
            const val setho = "com.facebook.stetho:stetho:1.4.1"
            const val okhttp = "com.facebook.stetho:stetho-okhttp3:1.4.1"
        }

        object Fuel {

            const val fuel = "com.github.kittinunf.fuel:fuel:$fuelHTTPversion" //for JVM
            const val android =
                "com.github.kittinunf.fuel:fuel-android:$fuelHTTPversion" //for Android
        }
    }


    object Onesignal {
        const val onesignal = "com.onesignal:OneSignal:3.5.4"
    }


    object FirebaseUI {
        // FirebaseUI for Firebase Realtime Database
        const val firebaseui = "com.firebaseui:firebase-ui-database:2.4.0"
    }

    object SDK {
        const val twitter = "com.twitter.sdk.android:twitter-core:3.1.1"
        const val facebook = "com.facebook.android:facebook-android-sdk:[5,6)"
    }

    ///// Other Libraries ////
    const val picasso = "com.squareup.picasso:picasso:$picassoVersion"
    const val circleimageview = "de.hdodenhof:circleimageview:$circleImageVersion"
    const val butterknife = "com.jakewharton:butterknife:$butterKnifeVersion"

    //    annotationProcessor "com.jakewharton:butterknife-compiler:$butterKnifeVersion"
    const val butterknifeAP = "com.jakewharton:butterknife-compiler:$butterKnifeVersion"


    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val timeago = "com.github.marlonlom:timeago:$timeAgoVersion"
//    const val easyvideoplayer = "com.afollestad:easyvideoplayer:0.3.0"
    const val jcplayer = "io.github.jeancsanchez.jcplayer:jcplayer:2.6.0-alpha"
    const val greendao = "org.greenrobot:greendao:3.2.0"

    //RXJava
    object Reactivex {

        const val rxandroid = "io.reactivex:rxandroid:1.2.1"
        const val rxjava = "io.reactivex:rxjava:1.3.0"
        const val rxjava2 = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }


    const val moshi = "com.squareup.moshi:moshi:1.8.0"

    // workaround from SO --> Duplicate class com.google.common.util.concurrent.ListenableFuture
    const val workaround = "com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava"
}