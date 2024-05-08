package com.mobile.auth.n;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static Context f37522a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SharedPreferences.Editor f37523a;

        public a(SharedPreferences.Editor editor) {
            this.f37523a = editor;
        }

        public void a() {
            this.f37523a.apply();
        }

        public void a(String str) {
            this.f37523a.remove(d.a(str));
        }

        public void a(String str, int i10) {
            this.f37523a.putInt(d.a(str), i10);
        }

        public void a(String str, long j10) {
            this.f37523a.putLong(d.a(str), j10);
        }

        public void a(String str, String str2) {
            this.f37523a.putString(d.a(str), str2);
        }

        public void b() {
            this.f37523a.commit();
        }

        public void c() {
            this.f37523a.clear();
        }
    }

    public static int a(String str, int i10) {
        return f37522a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(str), i10);
    }

    public static int a(String str, String str2, int i10) {
        return f37522a.getSharedPreferences(str, 0).getInt(d.a(str2), i10);
    }

    public static long a(String str, long j10) {
        return f37522a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(str), j10);
    }

    public static long a(String str, String str2, long j10) {
        return f37522a.getSharedPreferences(str, 0).getLong(d.a(str2), j10);
    }

    public static a a() {
        return new a(f37522a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    public static String a(String str, String str2, String str3) {
        return f37522a.getSharedPreferences(str, 0).getString(d.a(str2), str3);
    }

    public static void a(Context context) {
        f37522a = context.getApplicationContext();
    }

    public static void a(String str) {
        SharedPreferences sharedPreferences = f37522a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().remove(d.a(str)).commit();
    }

    public static void a(String str, String str2) {
        SharedPreferences sharedPreferences = f37522a.getSharedPreferences("ssoconfigs", 0);
        sharedPreferences.edit().putString(d.a(str), str2).commit();
    }

    public static void a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = f37522a.getSharedPreferences("ssoconfigs", 0).edit();
        for (String str : map.h()) {
            Object obj = map.get(str);
            String a10 = d.a(str);
            if (obj instanceof String) {
                edit.putString(a10, (String) obj);
            } else if (obj instanceof Integer) {
                edit.putInt(a10, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(a10, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                edit.putBoolean(a10, ((Boolean) obj).booleanValue());
            }
        }
        edit.commit();
    }

    public static a b(String str) {
        return new a(f37522a.getSharedPreferences(str, 0).edit());
    }

    public static String b(String str, String str2) {
        return f37522a.getSharedPreferences("ssoconfigs", 0).getString(d.a(str), str2);
    }
}
