package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: f, reason: collision with root package name */
    private HybridADListener f38149f;

    /* renamed from: g, reason: collision with root package name */
    private CountDownLatch f38150g = new CountDownLatch(1);

    /* renamed from: h, reason: collision with root package name */
    private HybridADSetting f38151h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f38151h = hybridADSetting;
        this.f38149f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    public HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f38151h, this.f38149f);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        HybridADListener hybridADListener = this.f38149f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i10));
        }
        this.f38150g.countDown();
    }

    public void c() {
        this.f38150g.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f38150g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || HybridAD.this.f38089a == null) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                HybridAD.this.a(2001);
                            } else {
                                ((HADI) HybridAD.this.f38089a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            HybridAD.this.a(2001);
                        }
                    }
                }).start();
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((HADI) t2).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
