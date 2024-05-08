package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class u3 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f48377b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f48378c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f48379d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f48380e;

    public u3(Context context, String str, int i10, String str2) {
        this.f48377b = context;
        this.f48378c = str;
        this.f48379d = i10;
        this.f48380e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        t3.e(this.f48377b, this.f48378c, this.f48379d, this.f48380e);
    }
}
