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
import com.cupidapp.live.hashtag.list.HashTagListViewModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class HashtagListFragmentBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FKSwipeRefreshLayout f13957b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13958c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13959d;

    /* renamed from: e, reason: collision with root package name */
    @Bindable
    public HashTagListViewModel f13960e;

    public HashtagListFragmentBinding(Object obj, View view, int i10, FKSwipeRefreshLayout fKSwipeRefreshLayout, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(obj, view, i10);
        this.f13957b = fKSwipeRefreshLayout;
        this.f13958c = recyclerView;
        this.f13959d = recyclerView2;
    }

    @NonNull
    public static HashtagListFragmentBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HashtagListFragmentBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (HashtagListFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.hashtag_list_fragment, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable HashTagListViewModel hashTagListViewModel);
}
