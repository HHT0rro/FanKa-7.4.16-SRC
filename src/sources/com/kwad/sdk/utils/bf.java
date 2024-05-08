package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class bf {
    public static final String TAG = "bf";

    public static void a(String str, String str2, int i10) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().putInt(str2, i10).apply();
    }

    public static void au(String str, String str2) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().remove(str2).apply();
    }

    public static int b(String str, String str2, int i10) {
        SharedPreferences gO = gO(str);
        return gO == null ? i10 : gO.getInt(str2, i10);
    }

    @Nullable
    public static SharedPreferences gO(String str) {
        try {
            return ServiceProvider.KO().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static void i(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    public static String j(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences gO = gO(str);
            if (gO != null && (string = gO.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.dJ(string)) ? string : com.kwad.sdk.core.a.c.dI(string);
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    public static void k(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.dJ(str)) {
            return;
        }
        i(str2, str3, com.kwad.sdk.core.a.c.dH(str));
    }

    public static void l(String str, String str2, boolean z10) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().putBoolean(str2, z10).apply();
    }

    public static boolean m(String str, String str2, boolean z10) {
        SharedPreferences gO = gO(str);
        return gO == null ? z10 : gO.getBoolean(str2, z10);
    }

    public static void a(String str, String str2, long j10) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().putLong(str2, j10).apply();
    }

    public static long b(String str, String str2, long j10) {
        SharedPreferences gO = gO(str);
        return gO == null ? j10 : gO.getLong(str2, j10);
    }

    public static void a(String str, String str2, String str3, boolean z10) {
        try {
            SharedPreferences gO = gO(str);
            if (gO == null) {
                return;
            }
            if (z10 && !com.kwad.sdk.core.a.c.dJ(str3)) {
                gO.edit().putString(str2, com.kwad.sdk.core.a.c.dH(str3)).apply();
            } else {
                gO.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        SharedPreferences.Editor edit = gO.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}
