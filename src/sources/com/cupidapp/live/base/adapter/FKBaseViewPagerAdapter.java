package com.cupidapp.live.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseViewPagerAdapter extends PagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<a> f11774a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public List<Object> f11775b = new ArrayList();

    /* compiled from: FKBaseViewPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final View f11776a;

        public abstract void a(@Nullable Object obj);

        @NotNull
        public final View b() {
            return this.f11776a;
        }
    }

    @NotNull
    public abstract a a(@NotNull ViewGroup viewGroup);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int i10, @NotNull Object object) {
        s.i(container, "container");
        s.i(object, "object");
        container.removeView(this.f11774a.get(i10).b());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11775b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int i10) {
        a aVar;
        s.i(container, "container");
        if (this.f11774a.size() <= i10) {
            aVar = a(container);
            this.f11774a.add(aVar);
        } else {
            aVar = this.f11774a.get(i10);
        }
        aVar.a(this.f11775b.get(i10));
        container.addView(aVar.b());
        return aVar.b();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object p12) {
        s.i(view, "view");
        s.i(p12, "p1");
        return s.d(view, p12);
    }
}
