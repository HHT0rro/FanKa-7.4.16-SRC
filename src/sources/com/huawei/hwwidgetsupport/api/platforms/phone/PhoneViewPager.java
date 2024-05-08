package com.huawei.hwwidgetsupport.api.platforms.phone;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import com.huawei.uikit.phone.hwviewpager.widget.HwViewPager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PhoneViewPager extends HwViewPager {

    /* renamed from: b, reason: collision with root package name */
    private final Set<HwViewPager.OnPageChangeListener> f31993b;

    public PhoneViewPager(@NonNull Context context) {
        this(context, null);
    }

    public void addOnPageChangeListener(@NonNull HwViewPager.OnPageChangeListener onPageChangeListener) {
        super.addOnPageChangeListener(onPageChangeListener);
        this.f31993b.add(onPageChangeListener);
    }

    public void clearOnPageChangeListeners() {
        super.clearOnPageChangeListeners();
        this.f31993b.clear();
    }

    public void removeOnPageChangeListener(@NonNull HwViewPager.OnPageChangeListener onPageChangeListener) {
        super.removeOnPageChangeListener(onPageChangeListener);
        this.f31993b.remove(onPageChangeListener);
    }

    public void setSupportLoop(boolean z10) {
        if (z10 == isSupportLoop()) {
            return;
        }
        super.clearOnPageChangeListeners();
        super.setSupportLoop(z10);
        Iterator<HwViewPager.OnPageChangeListener> iterator2 = this.f31993b.iterator2();
        while (iterator2.hasNext()) {
            super.addOnPageChangeListener(iterator2.next());
        }
    }

    public PhoneViewPager(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhoneViewPager(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f31993b = new HashSet();
        addOnPageChangeListener(new HwViewPager.OnPageChangeListener() { // from class: com.huawei.hwwidgetsupport.api.platforms.phone.PhoneViewPager.1
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