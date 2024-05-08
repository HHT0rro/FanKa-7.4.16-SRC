package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p extends n.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f48063c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f48064d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n f48065e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n nVar, n.a aVar, boolean z10, String str) {
        super(aVar);
        this.f48065e = nVar;
        this.f48063c = z10;
        this.f48064d = str;
    }

    @Override // com.xiaomi.push.n.b
    public void a() {
        super.a();
    }

    @Override // com.xiaomi.push.n.b
    public void b() {
        SharedPreferences sharedPreferences;
        if (this.f48063c) {
            return;
        }
        sharedPreferences = this.f48065e.f47981d;
        sharedPreferences.edit().putLong(this.f48064d, System.currentTimeMillis()).commit();
    }
}
