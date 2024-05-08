package com.ishumei.smantifraud.l111l11111I1l;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import com.huawei.quickcard.base.code.AbilityCode;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I1l {
    public static String l1111l111111Il() {
        try {
            Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
            if (context == null) {
                return "";
            }
            String str = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il("android.provider.Settings$Secure", "getString", new Class[]{ContentResolver.class, String.class}, new Object[]{context.getContentResolver(), "android_id"});
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int l111l11111I1l() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return -1;
        }
        try {
            return ((Integer) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il("android.provider.Settings$System", "getInt", new Class[]{ContentResolver.class, String.class}, new Object[]{context.getContentResolver(), "screen_brightness"})).intValue();
        } catch (SecurityException unused) {
            return AbilityCode.SHARE_INSTALLED_ERROR;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static int l111l11111Il() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return 0;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0 ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long l111l11111lIl() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < 11; i10++) {
                arrayList.add(Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            }
            Collections.sort(arrayList);
            return ((Long) arrayList.get(5)).longValue();
        } catch (Exception unused) {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        }
    }

    public static int l111l1111l1Il() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return Settings.Global.getInt(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getContentResolver(), "boot_count");
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static long l111l1111llIl() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }
}
