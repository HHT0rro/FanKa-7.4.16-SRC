package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f23830a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Handler handler) {
        super(null);
        this.f23830a = bVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        this.f23830a.d();
        this.f23830a.f();
    }
}
