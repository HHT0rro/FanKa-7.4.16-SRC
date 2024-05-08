package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SpCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ae implements e {

    /* renamed from: a, reason: collision with root package name */
    private static String f46393a = "SpCache";

    /* renamed from: b, reason: collision with root package name */
    private static String f46394b = "com.vivo.push.cache";

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f46395c;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (this.f46395c != null) {
            return true;
        }
        this.f46395c = context.getSharedPreferences(f46394b, 0);
        return true;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f46395c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            c.a(edit);
            u.d(f46393a, "putString by ".concat(String.valueOf(str)));
            return;
        }
        u.b(f46393a, "putString error by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        String string = this.f46395c.getString(str, str2);
        u.d(f46393a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f46395c.edit();
        if (edit != null) {
            edit.clear();
            c.a(edit);
        }
        u.d(f46393a, "system cache is cleared");
    }
}
