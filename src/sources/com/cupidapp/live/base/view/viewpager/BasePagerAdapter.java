package com.cupidapp.live.base.view.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBasePagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class BasePagerAdapter extends PagerAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<? extends Object> f12943a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final b f12944b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.base.recyclerview.d f12945c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12946d;

    public /* synthetic */ BasePagerAdapter(List list, b bVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i10 & 2) != 0 ? null : bVar);
    }

    public abstract void a(@NotNull View view, @NotNull Object obj, int i10, boolean z10);

    @NotNull
    public List<? extends Object> b() {
        return this.f12943a;
    }

    @NotNull
    public abstract View c(@NotNull ViewGroup viewGroup, @NotNull Object obj, int i10);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int i10, @NotNull Object object) {
        s.i(container, "container");
        s.i(object, "object");
        a aVar = object instanceof a ? (a) object : null;
        container.removeView(aVar != null ? aVar.a() : null);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return b().size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object object) {
        s.i(object, "object");
        a aVar = object instanceof a ? (a) object : null;
        if (aVar == null) {
            return -1;
        }
        Object b4 = aVar.b();
        int Y = CollectionsKt___CollectionsKt.Y(b(), b4);
        int i10 = Y == -1 ? -2 : Y;
        if (i10 >= 0) {
            if (Y != aVar.c()) {
                aVar.d(i10);
            }
            a(aVar.a(), b4, i10, false);
        }
        return i10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int i10) {
        s.i(container, "container");
        Object obj = b().get(i10);
        View c4 = c(container, obj, i10);
        a(c4, obj, i10, true);
        container.addView(c4);
        return new a(c4, obj, i10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        s.i(view, "view");
        s.i(object, "object");
        a aVar = object instanceof a ? (a) object : null;
        return s.d(aVar != null ? aVar.a() : null, view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup container, int i10, @NotNull Object object) {
        s.i(container, "container");
        s.i(object, "object");
        super.setPrimaryItem(container, i10, object);
        if (this.f12946d || b().size() - i10 > 4) {
            return;
        }
        this.f12946d = true;
        b bVar = this.f12944b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public BasePagerAdapter(@NotNull List<? extends Object> modelList, @Nullable b bVar) {
        s.i(modelList, "modelList");
        this.f12943a = modelList;
        this.f12944b = bVar;
        this.f12945c = new com.cupidapp.live.base.recyclerview.d();
    }
}
