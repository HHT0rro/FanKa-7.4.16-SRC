package com.ishumei.smantifraud.l111l11111I1l;

import android.content.Context;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.File;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111llIl {
    public static String l1111l111111Il() {
        int i10;
        int i11;
        int i12;
        DisplayMetrics displayMetrics;
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return "";
        }
        try {
            displayMetrics = context.getResources().getDisplayMetrics();
            i10 = displayMetrics.widthPixels;
        } catch (Exception unused) {
            i10 = 0;
        }
        try {
            i11 = displayMetrics.heightPixels;
        } catch (Exception unused2) {
            i11 = 0;
            i12 = 0;
            return String.format(Locale.US, "%d,%d,%d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
        try {
            i12 = displayMetrics.densityDpi;
        } catch (Exception unused3) {
            i12 = 0;
            return String.format(Locale.US, "%d,%d,%d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
        return String.format(Locale.US, "%d,%d,%d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public static int l111l11111I1l() {
        try {
            return ((PowerManager) com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getSystemService("power")).isScreenOn() ? 1 : 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static StatFs l111l11111Il() {
        try {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String l111l11111lIl() {
        int i10;
        int i11;
        DisplayMetrics displayMetrics;
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return "";
        }
        try {
            displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i10 = displayMetrics.widthPixels;
        } catch (Exception unused) {
            i10 = 0;
        }
        try {
            i11 = displayMetrics.heightPixels;
        } catch (Exception unused2) {
            i11 = 0;
            return String.format(Locale.US, "%d,%d", Integer.valueOf(i10), Integer.valueOf(i11));
        }
        return String.format(Locale.US, "%d,%d", Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public static int l111l1111l1Il() {
        try {
            File[] listFiles = new File("/proc").listFiles();
            if (listFiles == null) {
                return 0;
            }
            return listFiles.length;
        } catch (Exception unused) {
            return -1;
        }
    }
}
