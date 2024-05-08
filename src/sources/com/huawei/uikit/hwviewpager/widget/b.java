package com.huawei.uikit.hwviewpager.widget;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwPagerTabStrip f35444a;

    public b(HwPagerTabStrip hwPagerTabStrip) {
        this.f35444a = hwPagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f35444a.f35314i.setCurrentItem(r2.getCurrentItem() - 1);
    }
}
