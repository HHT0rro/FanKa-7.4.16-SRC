package com.wangmai.appsdkdex.utils;

import android.os.Environment;
import java.io.File;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMAppEnvironment {
    public static String SD_CARD_DIR;
    public static String VERSION_UPDATE_APP_DOWNLOAD_DIR;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        SD_CARD_DIR = sb2.toString();
        VERSION_UPDATE_APP_DOWNLOAD_DIR = SD_CARD_DIR + b.a("xnbmmpdbujpo") + str + b.a("dpogjhvsf");
    }
}
