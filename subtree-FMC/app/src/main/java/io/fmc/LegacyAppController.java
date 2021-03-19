//package io.fmc;
//
//import android.app.Application;
//
//import io.fmc.di.LegacyAppComponent;
//
//public class LegacyAppController extends Application {
////    private LegacyAppComponent legacyAppComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        //TODO: review multi-module DI
//        // outside the legacy module
//        // as first need to get an instance
//        // Create a 3rd 'Core' or 'Base' module in the middle, with both app's
//        // implementing the core
////        legacyAppComponent = DaggerLegacyAppComponent.builder()
////                .postModule(new PostModule())
////                .build();
//    }
//
////    public LegacyAppComponent getComponent() {
////        return legacyAppComponent;
////    }
//
//}