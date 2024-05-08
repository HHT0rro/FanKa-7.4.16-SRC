package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1782a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1783b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1784c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1785d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DUListener f1786e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DUHelper f1787f;

    public r(DUHelper dUHelper, Context context, String str, String str2, String str3, DUListener dUListener) {
        this.f1787f = dUHelper;
        this.f1782a = context;
        this.f1783b = str;
        this.f1784c = str2;
        this.f1785d = str3;
        this.f1786e = dUListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String b4;
        try {
            dUHelper = DUHelper.f1682d;
            b4 = dUHelper.b(this.f1782a, this.f1783b, this.f1784c, this.f1785d);
            DUListener dUListener = this.f1786e;
            if (dUListener != null) {
                dUListener.handle(b4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
