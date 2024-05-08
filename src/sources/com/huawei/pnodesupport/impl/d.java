package com.huawei.pnodesupport.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLPNodeData;
import com.huawei.uikit.hwviewpager.widget.HwPagerAdapter;

/* compiled from: PNodePagerAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d extends HwPagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final g f33077a;

    /* renamed from: b, reason: collision with root package name */
    private FLPNodeData f33078b;

    public d(@NonNull g gVar) {
        this.f33077a = gVar;
    }

    public void a(FLPNodeData fLPNodeData) {
        boolean z10 = this.f33078b != fLPNodeData;
        this.f33078b = fLPNodeData;
        this.f33077a.a(fLPNodeData);
        if (z10) {
            notifyDataSetChanged();
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            FLCell<FLCardData> a10 = fVar.a();
            if (a10.getRootView().getParent() instanceof ViewGroup) {
                ((ViewGroup) a10.getRootView().getParent()).removeView(a10.getRootView());
            }
            this.f33077a.a(fVar);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        FLPNodeData fLPNodeData = this.f33078b;
        if (fLPNodeData == null) {
            return 0;
        }
        return fLPNodeData.getSize();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        f a10 = this.f33077a.a(i10, this.f33078b.getChild(i10));
        if (a10 == null) {
            return new Object();
        }
        viewGroup.addView(a10.a().getRootView());
        return a10;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return (obj instanceof f) && ((f) obj).a().getRootView() == view;
    }
}
