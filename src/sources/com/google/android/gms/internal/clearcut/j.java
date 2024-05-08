package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j extends e<Boolean> {
    public j(o oVar, String str, Boolean bool) {
        super(oVar, str, bool, null);
    }

    @Override // com.google.android.gms.internal.clearcut.e
    public final /* synthetic */ Boolean m(String str) {
        if (k5.f23935c.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (k5.f23936d.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.f23845b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb2.append("Invalid boolean value for ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str);
        return null;
    }

    @Override // com.google.android.gms.internal.clearcut.e
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final Boolean f(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.f23845b, false));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f23845b);
            if (valueOf.length() == 0) {
                return null;
            }
            "Invalid boolean value in SharedPreferences for ".concat(valueOf);
            return null;
        }
    }
}
