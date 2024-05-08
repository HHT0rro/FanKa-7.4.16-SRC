package com.cupidapp.live.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FragmentStoryLabelBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13940b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FKSwipeRefreshLayout f13941c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FKTitleBarLayout f13942d;

    /* renamed from: e, reason: collision with root package name */
    @Bindable
    public FKStoryLabelViewModel f13943e;

    public FragmentStoryLabelBinding(Object obj, View view, int i10, RecyclerView recyclerView, FKSwipeRefreshLayout fKSwipeRefreshLayout, FKTitleBarLayout fKTitleBarLayout) {
        super(obj, view, i10);
        this.f13940b = recyclerView;
        this.f13941c = fKSwipeRefreshLayout;
        this.f13942d = fKTitleBarLayout;
    }

    @NonNull
    public static FragmentStoryLabelBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentStoryLabelBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (FragmentStoryLabelBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.fragment_story_label, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable FKStoryLabelViewModel fKStoryLabelViewModel);
}
