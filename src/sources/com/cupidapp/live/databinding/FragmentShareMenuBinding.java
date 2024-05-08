package com.cupidapp.live.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.share.fragment.ShareBottomViewModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FragmentShareMenuBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f13927b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f13928c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f13929d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f13930e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f13931f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f13932g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f13933h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f13934i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageLoaderView f13935j;

    /* renamed from: k, reason: collision with root package name */
    @Bindable
    public ShareBottomViewModel f13936k;

    public FragmentShareMenuBinding(Object obj, View view, int i10, View view2, View view3, View view4, View view5, View view6, ProgressBar progressBar, RelativeLayout relativeLayout, View view7, ImageLoaderView imageLoaderView) {
        super(obj, view, i10);
        this.f13927b = view2;
        this.f13928c = view3;
        this.f13929d = view4;
        this.f13930e = view5;
        this.f13931f = view6;
        this.f13932g = progressBar;
        this.f13933h = relativeLayout;
        this.f13934i = view7;
        this.f13935j = imageLoaderView;
    }

    @NonNull
    public static FragmentShareMenuBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentShareMenuBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (FragmentShareMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.fragment_share_menu, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable ShareBottomViewModel shareBottomViewModel);
}
