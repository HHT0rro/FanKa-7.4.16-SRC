package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f48580a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f48581b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f48580a = sharedPreferences;
            this.f48581b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.f48581b.putString("kwtk", str);
        this.f48581b.commit();
    }

    public boolean a() {
        return this.f48580a.getBoolean("xytk", true);
    }

    public String b() {
        return this.f48580a.getString("kwtk", "");
    }
}
