package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l extends e {

    /* renamed from: m, reason: collision with root package name */
    public final Object f23946m;

    /* renamed from: n, reason: collision with root package name */
    public String f23947n;

    /* renamed from: o, reason: collision with root package name */
    public Object f23948o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n f23949p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(o oVar, String str, Object obj, n nVar) {
        super(oVar, str, obj, null);
        this.f23949p = nVar;
        this.f23946m = new Object();
    }

    @Override // com.google.android.gms.internal.clearcut.e
    public final Object f(SharedPreferences sharedPreferences) {
        try {
            return m(sharedPreferences.getString(this.f23845b, ""));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f23845b);
            if (valueOf.length() == 0) {
                return null;
            }
            "Invalid byte[] value in SharedPreferences for ".concat(valueOf);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.e
    public final Object m(String str) {
        Object obj;
        try {
            synchronized (this.f23946m) {
                if (!str.equals(this.f23947n)) {
                    Object a10 = this.f23949p.a(Base64.decode(str, 3));
                    this.f23947n = str;
                    this.f23948o = a10;
                }
                obj = this.f23948o;
            }
            return obj;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.f23845b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb2.append("Invalid byte[] value for ");
            sb2.append(str2);
            sb2.append(": ");
            sb2.append(str);
            return null;
        }
    }
}
