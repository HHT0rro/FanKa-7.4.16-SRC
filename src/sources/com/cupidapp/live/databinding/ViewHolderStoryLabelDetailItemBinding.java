package com.cupidapp.live.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ViewHolderStoryLabelDetailItemBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f13999b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageLoaderView f14000c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f14001d;

    /* renamed from: e, reason: collision with root package name */
    @Bindable
    public FKStoryLabelItemModel f14002e;

    public ViewHolderStoryLabelDetailItemBinding(Object obj, View view, int i10, TextView textView, ImageLoaderView imageLoaderView, TextView textView2) {
        super(obj, view, i10);
        this.f13999b = textView;
        this.f14000c = imageLoaderView;
        this.f14001d = textView2;
    }

    @NonNull
    public static ViewHolderStoryLabelDetailItemBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewHolderStoryLabelDetailItemBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ViewHolderStoryLabelDetailItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.view_holder_story_label_detail_item, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable FKStoryLabelItemModel fKStoryLabelItemModel);
}
