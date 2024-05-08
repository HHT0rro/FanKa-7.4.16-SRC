package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a implements Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1712a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1713b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Listener f1714c;

    public a(Context context, int i10, Listener listener) {
        this.f1712a = context;
        this.f1713b = i10;
        this.f1714c = listener;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        DUHelper dUHelper;
        String b4;
        dUHelper = DUHelper.f1682d;
        b4 = dUHelper.b(this.f1712a, this.f1713b);
        this.f1714c.handler(b4);
    }
}
