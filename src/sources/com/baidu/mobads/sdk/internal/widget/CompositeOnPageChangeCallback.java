package com.baidu.mobads.sdk.internal.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final List<ViewPager2.OnPageChangeCallback> f10314a;

    public CompositeOnPageChangeCallback(int i10) {
        this.f10314a = new ArrayList(i10);
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f10314a.add(onPageChangeCallback);
    }

    public void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f10314a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i10) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> iterator2 = this.f10314a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onPageScrollStateChanged(i10);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i10, float f10, @Px int i11) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> iterator2 = this.f10314a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onPageScrolled(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i10) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> iterator2 = this.f10314a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onPageSelected(i10);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
        }
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
