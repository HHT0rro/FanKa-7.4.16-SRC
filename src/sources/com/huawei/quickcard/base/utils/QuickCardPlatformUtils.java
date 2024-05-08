package com.huawei.quickcard.base.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.BuildConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardPlatformUtils {
    public static final int DEFAULT_PLATFORM_VER = 1000;
    public static final int INVALID_VER_LEVEL = -1;
    public static final String MIN_PLATFORM_VER = "minPlatformVer";
    public static final String MIN_PLATFORM_VERSION = "minPlatformVersion";
    public static final int VER_LEVEL_1000 = 1000;
    public static final int VER_LEVEL_1001 = 1001;
    public static final int VER_LEVEL_1002 = 1002;
    public static final int VER_LEVEL_1003 = 1003;
    public static final int VER_LEVEL_1004 = 1004;
    public static final int VER_LEVEL_1005 = 1005;
    public static final int VER_LEVEL_1008 = 1008;

    public static int getEngineVer() {
        return 1012;
    }

    public static String getLibraryId() {
        return BuildConfig.QUICK_CARD_HA_APP_ID;
    }

    public static String getLibraryVer() {
        return BuildConfig.QUICKCARD_ENGINE_VERSION_NAME;
    }

    public static int getLibraryVerCode() {
        return BuildConfig.QUICKCARD_ENGINE_VERSION_CODE;
    }

    public static int readPlatformVerFromUrl(@NonNull String str) {
        Uri parse = Uri.parse(str);
        try {
            String queryParameter = parse.getQueryParameter("minPlatformVer");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = parse.getQueryParameter(MIN_PLATFORM_VERSION);
            }
            return Integer.parseInt(queryParameter);
        } catch (Exception unused) {
            return 1000;
        }
    }
}
