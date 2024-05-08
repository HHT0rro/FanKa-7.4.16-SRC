package com.huawei.hwwidgetsupport.api.platforms.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BaseViewPager extends HwViewPager {

    /* renamed from: b, reason: collision with root package name */
    private final Set<HwViewPager.OnPageChangeListener> f31988b;

    public BaseViewPager(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager
    public void addOnPageChangeListener(@NonNull HwViewPager.OnPageChangeListener onPageChangeListener) {
        super.addOnPageChangeListener(onPageChangeListener);
        this.f31988b.add(onPageChangeListener);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager
    public void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
        this.f31988b.clear();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager
    public void removeOnPageChangeListener(@NonNull HwViewPager.OnPageChangeListener onPageChangeListener) {
        super.removeOnPageChangeListener(onPageChangeListener);
        this.f31988b.remove(onPageChangeListener);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager
    public void setSupportLoop(boolean z10) {
        if (z10 == isSupportLoop()) {
            return;
        }
        super.clearOnPageChangeListeners();
        super.setSupportLoop(z10);
        Iterator<HwViewPager.OnPageChangeListener> iterator2 = this.f31988b.iterator2();
        while (iterator2.hasNext()) {
            super.addOnPageChangeListener(iterator2.next());
        }
    }

    public BaseViewPager(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseViewPager(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f31988b = new HashSet();
        addOnPageChangeListener(new HwViewPager.OnPageChangeListener() { // from class: com.huawei.hwwidgetsupport.api.platforms.base.BaseViewPager.1
            @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i11) {
            }

            @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
            public void onPageScrolled(int i11, float f10, int i12) {
            }

            @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
            public void onPageSelected(int i11) {
            }
        });
    }
}
