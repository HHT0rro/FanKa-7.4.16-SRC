package com.vivo.push.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* compiled from: SettingsCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class ac implements e {

    /* renamed from: a, reason: collision with root package name */
    private ContentResolver f46391a;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (!n.b()) {
            return false;
        }
        this.f46391a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        try {
            Settings.System.putString(this.f46391a, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("SettingsCache", "putString error by ".concat(String.valueOf(str)));
        }
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        try {
            return Settings.System.getString(this.f46391a, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("SettingsCache", "getString error by ".concat(String.valueOf(str)));
            return str2;
        }
    }
}
