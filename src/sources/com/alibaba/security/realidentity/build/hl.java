package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Build;
import java.util.zip.ZipFile;

/* compiled from: SoChecker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hl {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3848a = "SoChecker";

    public static boolean a(Context context, String str) {
        try {
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            zipFile.entries();
            if (zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + str) == null) {
                return false;
            }
            zipFile.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
