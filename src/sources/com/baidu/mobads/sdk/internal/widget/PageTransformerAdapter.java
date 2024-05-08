package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f10323a;

    /* renamed from: b, reason: collision with root package name */
    private ViewPager2.PageTransformer f10324b;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f10323a = linearLayoutManager;
    }

    public ViewPager2.PageTransformer a() {
        return this.f10324b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f10324b == null) {
            return;
        }
        float f11 = -f10;
        for (int i12 = 0; i12 < this.f10323a.getChildCount(); i12++) {
            View childAt = this.f10323a.getChildAt(i12);
            if (childAt != null) {
                this.f10324b.transformPage(childAt, (this.f10323a.getPosition(childAt) - i10) + f11);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i12), Integer.valueOf(this.f10323a.getChildCount())));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i10) {
    }

    public void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f10324b = pageTransformer;
    }
}
