package com.huawei.uikit.hwdotspageindicator.widget;

import android.database.DataSetObserver;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwDotsPageIndicator f35119a;

    public f(HwDotsPageIndicator hwDotsPageIndicator) {
        this.f35119a = hwDotsPageIndicator;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        HwViewPager hwViewPager;
        HwDotsPageIndicator hwDotsPageIndicator = this.f35119a;
        hwViewPager = hwDotsPageIndicator.f35035za;
        hwDotsPageIndicator.setPageCount(hwViewPager.getAdapter().getCount());
    }
}
