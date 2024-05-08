package cn.shuzilm.core;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1788a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1789b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1790c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1791d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Listener f1792e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DUHelper f1793f;

    public s(DUHelper dUHelper, Context context, String str, String str2, String str3, Listener listener) {
        this.f1793f = dUHelper;
        this.f1788a = context;
        this.f1789b = str;
        this.f1790c = str2;
        this.f1791d = str3;
        this.f1792e = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DUHelper dUHelper;
        String b4;
        try {
            dUHelper = DUHelper.f1682d;
            b4 = dUHelper.b(this.f1788a, this.f1789b, this.f1790c, this.f1791d);
            Listener listener = this.f1792e;
            if (listener != null) {
                listener.handler(b4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
