package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1715a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1717c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DUListener f1718d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DUHelper f1719e;

    public b(DUHelper dUHelper, Context context, String str, String str2, DUListener dUListener) {
        this.f1719e = dUHelper;
        this.f1715a = context;
        this.f1716b = str;
        this.f1717c = str2;
        this.f1718d = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        DUHelper dUHelper2;
        int i10;
        String a10;
        try {
            dUHelper = DUHelper.f1682d;
            Context context = this.f1715a;
            String str = this.f1716b;
            String str2 = this.f1717c;
            dUHelper2 = DUHelper.f1682d;
            i10 = dUHelper2.f1701w;
            a10 = dUHelper.a(context, str, str2, i10);
            if (this.f1718d != null) {
                if (a10 == null) {
                    a10 = this.f1719e.g(this.f1715a);
                }
                this.f1718d.handle(a10);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
