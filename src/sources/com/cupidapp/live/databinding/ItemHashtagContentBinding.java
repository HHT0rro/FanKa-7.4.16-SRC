package com.cupidapp.live.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.hashtag.list.HashTagListViewModel;
import com.cupidapp.live.hashtag.model.HashTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ItemHashtagContentBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f13972b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f13973c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageLoaderView f13974d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f13975e;

    /* renamed from: f, reason: collision with root package name */
    @Bindable
    public HashTagListViewModel f13976f;

    /* renamed from: g, reason: collision with root package name */
    @Bindable
    public HashTag f13977g;

    public ItemHashtagContentBinding(Object obj, View view, int i10, TextView textView, TextView textView2, ImageLoaderView imageLoaderView, TextView textView3) {
        super(obj, view, i10);
        this.f13972b = textView;
        this.f13973c = textView2;
        this.f13974d = imageLoaderView;
        this.f13975e = textView3;
    }

    public abstract void b(@Nullable HashTag hashTag);

    public abstract void c(@Nullable HashTagListViewModel hashTagListViewModel);
}
