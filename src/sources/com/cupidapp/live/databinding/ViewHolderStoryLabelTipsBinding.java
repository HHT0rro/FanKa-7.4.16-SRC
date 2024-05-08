package com.cupidapp.live.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.setting.adapter.FKStoryLabelTipsModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ViewHolderStoryLabelTipsBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @Bindable
    public FKStoryLabelTipsModel f14007b;

    public ViewHolderStoryLabelTipsBinding(Object obj, View view, int i10) {
        super(obj, view, i10);
    }

    @NonNull
    public static ViewHolderStoryLabelTipsBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewHolderStoryLabelTipsBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (ViewHolderStoryLabelTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.view_holder_story_label_tips, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable FKStoryLabelTipsModel fKStoryLabelTipsModel);
}
