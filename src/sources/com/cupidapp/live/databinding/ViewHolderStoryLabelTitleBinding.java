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
import com.cupidapp.live.setting.adapter.FKStoryLabelTitleModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ViewHolderStoryLabelTitleBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageLoaderView f14012b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f14013c;

    /* renamed from: d, reason: collision with root package name */
    @Bindable
    public FKStoryLabelTitleModel f14014d;

    public ViewHolderStoryLabelTitleBinding(Object obj, View view, int i10, ImageLoaderView imageLoaderView, TextView textView) {
        super(obj, view, i10);
        this.f14012b = imageLoaderView;
        this.f14013c = textView;
    }

    @NonNull
    public static ViewHolderStoryLabelTitleBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewHolderStoryLabelTitleBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ViewHolderStoryLabelTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.view_holder_story_label_title, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable FKStoryLabelTitleModel fKStoryLabelTitleModel);
}
