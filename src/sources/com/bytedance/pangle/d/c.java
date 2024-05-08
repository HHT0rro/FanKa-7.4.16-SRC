package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.android.internal.content.NativeLibraryHelper;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.g;
import com.bytedance.pangle.util.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static File f10681a;

    /* renamed from: b, reason: collision with root package name */
    private static File f10682b;

    /* renamed from: c, reason: collision with root package name */
    private static File f10683c;

    private static String a(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (f10683c == null) {
            f10683c = new File(appApplication.getFilesDir(), ".pangle" + g.f10773a);
        }
        return a(f10683c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + g.f10774b);
            if (externalFilesDir != null) {
                return a(externalFilesDir);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (f10681a == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + g.f10775c);
            f10681a = file;
            a(file);
        }
    }

    public static String e(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk")).getPath();
    }

    public static String g(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i10) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i10)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i10)), "dalvik-cache");
    }

    public static String i(String str, int i10) {
        return a(str, "version-".concat(String.valueOf(i10)), "secondary-dexes");
    }

    private static String a(String... strArr) {
        d();
        File file = f10681a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i10) {
        return a(str, "version-".concat(String.valueOf(i10)), NativeLibraryHelper.LIB_DIR_NAME);
    }

    public static String b(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk"), "base-1.apk").getPath();
    }

    public static String c(String str, int i10) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i10)), "apk", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i10)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (f10682b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + g.f10774b);
            }
            f10682b = downloadDir;
        }
        return a(f10682b);
    }

    public static String a(String str, int i10) {
        d();
        File file = f10681a;
        String[] strArr = {str, "version-".concat(String.valueOf(i10))};
        for (int i11 = 0; i11 < 2; i11++) {
            String str2 = strArr[i11];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }
}
