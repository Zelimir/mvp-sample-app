package com.zelimir.android.mvpsampleapp.config;

import com.zelimir.android.mvpsampleapp.BuildConfig;

/**
 * Helper class to allow us easy access to some often used app
 * configuration (e.g. app name, build info, etc)
 */
public class AppInfo {

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

}
