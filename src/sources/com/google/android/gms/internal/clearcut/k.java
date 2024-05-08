package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k extends e<String> {
    public k(o oVar, String str, String str2) {
        super(oVar, str, str2, null);
    }

    @Override // com.google.android.gms.internal.clearcut.e
    public final /* synthetic */ String m(String str) {
        return str;
    }

    @Override // com.google.android.gms.internal.clearcut.e
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final String f(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.f23845b, null);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f23845b);
            if (valueOf.length() != 0) {
                "Invalid string value in SharedPreferences for ".concat(valueOf);
            }
            return null;
        }
    }
}
