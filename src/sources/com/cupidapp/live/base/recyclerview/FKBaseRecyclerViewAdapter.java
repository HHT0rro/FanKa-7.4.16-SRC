package com.cupidapp.live.base.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseRecyclerViewAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseRecyclerViewAdapter extends RecyclerView.Adapter<FKBaseRecyclerViewHolder> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final d f12027b = new d();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<Class<? extends Object>> f12028c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<Object> f12029d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public RecyclerExposureHelper f12030e;

    public void c(int i10, @NotNull Object model) {
        s.i(model, "model");
        this.f12029d.add(i10, model);
    }

    public void d(@NotNull Object model) {
        s.i(model, "model");
        if (CollectionsKt___CollectionsKt.f0(this.f12029d) instanceof FKFooterViewModel) {
            List<Object> list = this.f12029d;
            list.add(kotlin.collections.s.l(list), model);
        } else {
            this.f12029d.add(model);
        }
    }

    public int e(@Nullable List<? extends Object> list) {
        if (list == null) {
            return this.f12029d.size();
        }
        if (CollectionsKt___CollectionsKt.f0(this.f12029d) instanceof FKFooterViewModel) {
            int l10 = kotlin.collections.s.l(this.f12029d);
            this.f12029d.addAll(l10, list);
            return l10;
        }
        int size = this.f12029d.size();
        this.f12029d.addAll(list);
        return size;
    }

    public final boolean f(int i10) {
        return i10 >= 0 && i10 < this.f12029d.size();
    }

    @Nullable
    public final RecyclerExposureHelper g() {
        return this.f12030e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12029d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (this.f12028c.isEmpty() || this.f12029d.isEmpty()) {
            return 0;
        }
        int size = this.f12029d.size();
        int i11 = -1;
        for (Class<? extends Object> cls : this.f12028c) {
            if (size > i10 && cls.isInstance(this.f12029d.get(i10))) {
                i11 = this.f12028c.indexOf(cls);
            }
        }
        if (i11 != -1) {
            return i11;
        }
        throw new IllegalStateException(("not find model class int type list:" + this.f12029d.get(i10)).toString());
    }

    @Nullable
    public final FKFooterViewModel h() {
        Object f02 = CollectionsKt___CollectionsKt.f0(this.f12029d);
        if (f02 instanceof FKFooterViewModel) {
            return (FKFooterViewModel) f02;
        }
        return null;
    }

    @Nullable
    public final Integer i(@NotNull Object model) {
        s.i(model, "model");
        int indexOf = this.f12029d.indexOf(model);
        if (indexOf == -1) {
            return null;
        }
        return Integer.valueOf(indexOf + 1);
    }

    @NotNull
    public final List<Object> j() {
        return this.f12029d;
    }

    @NotNull
    public final List<Class<? extends Object>> k() {
        return this.f12028c;
    }

    @NotNull
    public final d l() {
        return this.f12027b;
    }

    public void m(@Nullable List<? extends Object> list) {
    }

    public final int n() {
        return CollectionsKt___CollectionsKt.f0(this.f12029d) instanceof FKFooterViewModel ? this.f12029d.size() - 1 : this.f12029d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        s.i(holder, "holder");
        if (-1 == i10) {
            return;
        }
        if (i10 >= 0 && i10 < this.f12029d.size()) {
            holder.p(this.f12029d.get(i10));
            return;
        }
        throw new IndexOutOfBoundsException("BaseRecyclerAdapter onBindViewHolder IndexOutOfBounds position:" + i10 + "  count:" + this.f12029d.size() + " holder:" + holder.getClass().getSimpleName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        RecyclerExposureHelper recyclerExposureHelper = this.f12030e;
        if (recyclerExposureHelper != null) {
            recyclerExposureHelper.k(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        RecyclerExposureHelper recyclerExposureHelper = this.f12030e;
        if (recyclerExposureHelper != null) {
            recyclerExposureHelper.l(holder);
        }
    }

    public final void r() {
        x.B(this.f12029d, new Function1<Object, Boolean>() { // from class: com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter$removeEmptyView$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Object it) {
                s.i(it, "it");
                return Boolean.valueOf(it instanceof FKEmptyViewModel);
            }
        });
    }

    public final void s() {
        if (CollectionsKt___CollectionsKt.f0(this.f12029d) instanceof FKFooterViewModel) {
            List<Object> list = this.f12029d;
            list.remove(CollectionsKt___CollectionsKt.e0(list));
        }
    }

    public final void t(@Nullable RecyclerExposureHelper recyclerExposureHelper) {
        this.f12030e = recyclerExposureHelper;
    }
}
