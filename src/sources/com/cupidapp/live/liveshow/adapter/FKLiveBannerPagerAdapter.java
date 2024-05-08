package com.cupidapp.live.liveshow.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import ce.n;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveBannerPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBannerPagerAdapter extends PagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<View> f14803a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public List<ImageModel> f14804b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f14805c;

    @NotNull
    public final List<ImageModel> a() {
        return this.f14804b;
    }

    @Nullable
    public final Function1<Integer, p> b() {
        return this.f14805c;
    }

    @NotNull
    public final List<View> c() {
        return this.f14803a;
    }

    public final void d(@Nullable Function1<? super Integer, p> function1) {
        this.f14805c = function1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int i10, @NotNull Object object) {
        s.i(container, "container");
        s.i(object, "object");
        if (i10 < this.f14803a.size()) {
            container.removeView(this.f14803a.get(i10));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f14804b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, final int i10) {
        View view;
        s.i(container, "container");
        if (this.f14803a.size() <= i10) {
            view = z.b(container, R$layout.layout_banner_content, false, 2, null);
            this.f14803a.add(view);
        } else {
            view = this.f14803a.get(i10);
        }
        int i11 = R$id.bannerImageView;
        ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i11);
        s.h(imageLoaderView, "bannerView.bannerImageView");
        ImageLoaderView.g(imageLoaderView, this.f14804b.get(i10), null, null, 6, null);
        ImageLoaderView imageLoaderView2 = (ImageLoaderView) view.findViewById(i11);
        s.h(imageLoaderView2, "bannerView.bannerImageView");
        y.d(imageLoaderView2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.adapter.FKLiveBannerPagerAdapter$instantiateItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                Function1<Integer, p> b4 = FKLiveBannerPagerAdapter.this.b();
                if (b4 != null) {
                    b4.invoke(Integer.valueOf(i10));
                }
            }
        });
        IntRange i12 = n.i(0, container.getChildCount());
        ArrayList arrayList = new ArrayList();
        for (Integer num : i12) {
            if (s.d(view, container.getChildAt(num.intValue()))) {
                arrayList.add(num);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        if (iterator2.hasNext()) {
            ((Number) iterator2.next()).intValue();
            return view;
        }
        container.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object p12) {
        s.i(view, "view");
        s.i(p12, "p1");
        return s.d(view, p12);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        int i10 = 0;
        for (View view : this.f14803a) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(R$id.bannerImageView);
            s.h(imageLoaderView, "view.bannerImageView");
            ImageLoaderView.g(imageLoaderView, this.f14804b.get(i10), null, null, 6, null);
            i10 = i11;
        }
        super.notifyDataSetChanged();
    }
}
