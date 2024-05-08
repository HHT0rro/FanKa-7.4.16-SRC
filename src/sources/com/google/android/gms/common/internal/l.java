package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l extends j {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f23686b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f23687c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f23688d;

    public l(Intent intent, Activity activity, int i10) {
        this.f23686b = intent;
        this.f23687c = activity;
        this.f23688d = i10;
    }

    @Override // com.google.android.gms.common.internal.j
    public final void b() {
        Intent intent = this.f23686b;
        if (intent != null) {
            this.f23687c.startActivityForResult(intent, this.f23688d);
        }
    }
}
