package cn.shuzilm.core;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1794a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DUHelper f1795b;

    public t(DUHelper dUHelper, int i10) {
        this.f1795b = dUHelper;
        this.f1794a = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DUHelper.getQueryID(DUHelper.mContext, "NA", "", 1, null, this.f1794a + 100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
