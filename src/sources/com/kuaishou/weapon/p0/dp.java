package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class dp {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36096a = "plc001_t_re";

    /* renamed from: b, reason: collision with root package name */
    public static final String f36097b = "wlpauct2";

    /* renamed from: c, reason: collision with root package name */
    public static final String f36098c = "plc001_pd_ptip_pi";

    /* renamed from: d, reason: collision with root package name */
    public static final String f36099d = "wiipaot";

    /* renamed from: e, reason: collision with root package name */
    public static final int f36100e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final String f36101f = "a1_p_s_p_s";

    /* renamed from: g, reason: collision with root package name */
    public static final String f36102g = "a1_p_s_p_s_c_b";

    /* renamed from: j, reason: collision with root package name */
    private static dp f36103j;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f36104h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f36105i;

    private dp(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bi.f35848r, 4);
            this.f36104h = sharedPreferences;
            this.f36105i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized dp a(Context context) {
        dp dpVar;
        synchronized (dp.class) {
            try {
                if (f36103j == null) {
                    f36103j = new dp(context);
                }
                dpVar = f36103j;
            } catch (Exception unused) {
                return null;
            }
        }
        return dpVar;
    }

    public boolean b(String str) {
        return this.f36104h.getBoolean(str, false);
    }

    public void b(String str, String str2) {
        try {
            this.f36105i.putString(str, str2);
            this.f36105i.apply();
        } catch (Exception unused) {
        }
    }

    public static dp a() {
        return f36103j;
    }

    public long a(String str) {
        return this.f36104h.getLong(str, 0L);
    }

    public void a(String str, long j10, boolean z10) {
        try {
            this.f36105i.putLong(str, j10);
            if (z10) {
                this.f36105i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int a(String str, int i10) {
        try {
            return this.f36104h.getInt(str, i10);
        } catch (Throwable unused) {
            return i10;
        }
    }

    public void a(String str, int i10, boolean z10) {
        try {
            this.f36105i.putInt(str, i10);
            if (z10) {
                this.f36105i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z10) {
        try {
            SharedPreferences.Editor editor = this.f36105i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z10) {
                    this.f36105i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public String a(String str, String str2) {
        return this.f36104h.getString(str, str2);
    }
}
