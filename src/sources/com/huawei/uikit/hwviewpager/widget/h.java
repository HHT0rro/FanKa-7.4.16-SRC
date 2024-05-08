package com.huawei.uikit.hwviewpager.widget;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h implements HwGenericEventDetector.OnChangePageListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwViewPager f35459a;

    public h(HwViewPager hwViewPager) {
        this.f35459a = hwViewPager;
    }

    @Override // com.huawei.uikit.hwunifiedinteract.widget.HwGenericEventDetector.OnChangePageListener
    public boolean onChangePage(float f10, @NonNull MotionEvent motionEvent) {
        boolean a10;
        int i10;
        a10 = this.f35459a.a(f10, 0.0f);
        if (a10) {
            return false;
        }
        i10 = this.f35459a.f35382mb;
        if (i10 != 0) {
            return false;
        }
        if ((f10 > 0.0f ? (char) 1 : (char) 65535) == 1) {
            this.f35459a.d();
        } else {
            this.f35459a.c();
        }
        return true;
    }
}
