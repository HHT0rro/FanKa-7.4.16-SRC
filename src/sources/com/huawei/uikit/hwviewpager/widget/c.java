package com.huawei.uikit.hwviewpager.widget;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwPagerTabStrip f35445a;

    public c(HwPagerTabStrip hwPagerTabStrip) {
        this.f35445a = hwPagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HwViewPager hwViewPager = this.f35445a.f35314i;
        hwViewPager.setCurrentItem(hwViewPager.getCurrentItem() + 1);
    }
}
