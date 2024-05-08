package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1720a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1721b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1722c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1723d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Listener f1724e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DUHelper f1725f;

    public c(DUHelper dUHelper, Context context, String str, String str2, int i10, Listener listener) {
        this.f1725f = dUHelper;
        this.f1720a = context;
        this.f1721b = str;
        this.f1722c = str2;
        this.f1723d = i10;
        this.f1724e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String a10;
        try {
            dUHelper = DUHelper.f1682d;
            a10 = dUHelper.a(this.f1720a, this.f1721b, this.f1722c, this.f1723d);
            if (this.f1724e != null) {
                if (a10 == null) {
                    a10 = this.f1725f.g(this.f1720a);
                }
                this.f1724e.handler(a10);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
