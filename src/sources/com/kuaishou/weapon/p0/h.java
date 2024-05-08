package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36126a = "re_po_rt";

    /* renamed from: e, reason: collision with root package name */
    private static h f36127e;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f36128b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences.Editor f36129c;

    /* renamed from: d, reason: collision with root package name */
    private Context f36130d;

    public h(Context context, String str) {
        try {
            this.f36130d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f36128b = sharedPreferences;
            this.f36129c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized h a(Context context, String str) {
        h hVar;
        synchronized (h.class) {
            if (f36127e == null) {
                synchronized (h.class) {
                    if (f36127e == null) {
                        f36127e = new h(context, str);
                    }
                }
            }
            hVar = f36127e;
        }
        return hVar;
    }

    public Context b() {
        return this.f36130d;
    }

    public void c(String str, String str2) {
        try {
            this.f36129c.putString(str, str2);
            this.f36129c.apply();
        } catch (Exception unused) {
        }
    }

    public void d(String str, int i10) {
        this.f36129c.putInt(str, i10);
        this.f36129c.apply();
    }

    public boolean e(String str) {
        return this.f36128b.getBoolean(str, false);
    }

    public int b(String str) {
        try {
            return this.f36128b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int b(String str, int i10) {
        try {
            return this.f36128b.getInt(str, i10);
        } catch (Exception unused) {
            return i10;
        }
    }

    public void c(String str, String str2, boolean z10) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z10) {
                str2 = c.b(str2.getBytes(), 2);
            }
            this.f36129c.putString(str, str2);
            this.f36129c.apply();
        } catch (Throwable unused) {
        }
    }

    public long d(String str) {
        return this.f36128b.getLong(str, 0L);
    }

    public String b(String str, String str2) {
        return this.f36128b.getString(str, str2);
    }

    public h(Context context) {
        try {
            this.f36130d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f36128b = sharedPreferences;
            this.f36129c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public String b(String str, String str2, boolean z10) {
        String b4 = b(str, "");
        return !TextUtils.isEmpty(b4) ? z10 ? c.b(b4, 2) : b4 : str2;
    }

    public static h a() {
        return f36127e;
    }

    public int c(String str, int i10) {
        try {
            return this.f36128b.getInt(str, i10);
        } catch (Exception unused) {
            return i10;
        }
    }

    public void a(Context context) {
        this.f36130d = context;
    }

    public void b(String str, long j10) {
        this.f36129c.putLong(str, j10);
        this.f36129c.apply();
    }

    public int c(String str) {
        try {
            return this.f36128b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f36129c.putString(str, str2);
            this.f36129c.apply();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            this.f36129c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, boolean z10) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f36129c.putString(str, str2);
            if (z10) {
                this.f36129c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        return this.f36128b.getString(str, "");
    }

    public void a(String str, int i10) {
        try {
            this.f36129c.putInt(str, i10);
            this.f36129c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, int i10, boolean z10) {
        try {
            this.f36129c.putInt(str, i10);
            if (z10) {
                this.f36129c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public long a(String str, long j10) {
        return this.f36128b.getLong(str, j10);
    }

    public void a(String str, Boolean bool) {
        this.f36129c.putBoolean(str, bool.booleanValue());
        this.f36129c.apply();
    }
}
