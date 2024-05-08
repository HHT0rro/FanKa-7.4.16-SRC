package com.huawei.quickcard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.soloader.DirectorySoSource;
import com.facebook.soloader.SoLoader;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class YogaLoadHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33256a = "YogaLoadHelper";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f33257b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    private static boolean a() throws a {
        try {
            CardLogUtils.d(f33256a, "start system load yoga");
            System.loadLibrary("yoga");
            CardLogUtils.d(f33256a, "load yoga so success");
            return true;
        } catch (Throwable th) {
            CardLogUtils.e(f33256a, "load yoga so fail");
            throw new a("load yoga so fail " + th.getMessage());
        }
    }

    public static boolean initYogaSource(Context context) throws a {
        if (context == null) {
            CardLogUtils.e(f33256a, "yoga init fail context is empty");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                CardLogUtils.d(f33256a, "SoLoader prependSoSource fail cause application info is null");
                return false;
            }
            SoLoader.prependSoSource(new DirectorySoSource(new File(applicationInfo.nativeLibraryDir), 2));
            CardLogUtils.d(f33256a, "SoLoader prependSoSource success");
            return true;
        } catch (IOException e2) {
            throw new a("init so source fail " + e2.getMessage());
        }
    }

    public static boolean isLoadYoga() {
        return f33257b;
    }

    public static void loadYoga() throws a {
        if (!a()) {
            setIsLoadYoga(false);
            return;
        }
        try {
            CardLogUtils.d(f33256a, "add yoga to SoLoader list start");
            Field declaredField = SoLoader.class.getDeclaredField("sLoadedLibraries");
            declaredField.setAccessible(true);
            HashSet hashSet = (HashSet) declaredField.get(null);
            if (hashSet != null) {
                hashSet.add("libyoga.so");
                hashSet.add("libfb.so");
            }
            setIsLoadYoga(true);
            CardLogUtils.d(f33256a, "add yoga to SoLoader list success");
        } catch (Throwable th) {
            setIsLoadYoga(false);
            CardLogUtils.e(f33256a, "add yoga to SoLoader list fail");
            throw new a("add yoga to SoLoader list fail " + th.getMessage());
        }
    }

    public static boolean loadYogaLibrary(Context context) throws RuntimeException {
        SoLoader.init(context, false);
        if (!initYogaSource(context)) {
            return true;
        }
        loadYoga();
        return true;
    }

    public static void setIsLoadYoga(boolean z10) {
        f33257b = z10;
    }
}
