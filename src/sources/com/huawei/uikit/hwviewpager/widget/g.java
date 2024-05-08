package com.huawei.uikit.hwviewpager.widget;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwViewPager f35458a;

    public g(HwViewPager hwViewPager) {
        this.f35458a = hwViewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f35458a.setScrollState(0);
        this.f35458a.e();
    }
}
