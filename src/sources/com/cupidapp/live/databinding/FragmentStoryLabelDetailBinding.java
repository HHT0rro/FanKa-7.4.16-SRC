package com.cupidapp.live.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FragmentStoryLabelDetailBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f13948b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f13949c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13950d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FKTitleBarLayout f13951e;

    /* renamed from: f, reason: collision with root package name */
    @Bindable
    public FKStoryLabelViewModel f13952f;

    public FragmentStoryLabelDetailBinding(Object obj, View view, int i10, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, FKTitleBarLayout fKTitleBarLayout) {
        super(obj, view, i10);
        this.f13948b = imageView;
        this.f13949c = imageView2;
        this.f13950d = recyclerView;
        this.f13951e = fKTitleBarLayout;
    }

    @NonNull
    public static FragmentStoryLabelDetailBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentStoryLabelDetailBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (FragmentStoryLabelDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.fragment_story_label_detail, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable FKStoryLabelViewModel fKStoryLabelViewModel);
}
