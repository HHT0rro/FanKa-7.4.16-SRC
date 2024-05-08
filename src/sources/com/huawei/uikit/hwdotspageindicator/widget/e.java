package com.huawei.uikit.hwdotspageindicator.widget;

import android.os.Handler;
import com.huawei.uikit.hwviewpager.widget.HwPagerAdapter;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35118a;

    public e(HwDotsPageIndicator hwDotsPageIndicator) {
        this.f35118a = hwDotsPageIndicator;
    }

    @Override // java.lang.Runnable
    public void run() {
        HwViewPager hwViewPager;
        HwViewPager hwViewPager2;
        HwViewPager hwViewPager3;
        HwViewPager hwViewPager4;
        HwViewPager hwViewPager5;
        HwViewPager hwViewPager6;
        boolean z10;
        Handler handler;
        Runnable runnable;
        int i10;
        hwViewPager = this.f35118a.f35035za;
        if (hwViewPager != null) {
            hwViewPager2 = this.f35118a.f35035za;
            if (hwViewPager2.getAdapter() == null) {
                return;
            }
            hwViewPager3 = this.f35118a.f35035za;
            HwPagerAdapter adapter = hwViewPager3.getAdapter();
            if (adapter.getCount() < 2) {
                return;
            }
            hwViewPager4 = this.f35118a.f35035za;
            int currentItem = hwViewPager4.getCurrentItem();
            hwViewPager5 = this.f35118a.f35035za;
            int i11 = (hwViewPager5.isSupportLoop() || currentItem < adapter.getCount() - 1) ? currentItem + 1 : 0;
            hwViewPager6 = this.f35118a.f35035za;
            hwViewPager6.setCurrentItem(i11, true);
            z10 = this.f35118a.A;
            if (z10) {
                handler = this.f35118a.Ba;
                runnable = this.f35118a.Ua;
                i10 = this.f35118a.f35034z;
                handler.postDelayed(runnable, i10);
            }
        }
    }
}
