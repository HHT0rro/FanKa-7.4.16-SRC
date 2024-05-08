package com.cupidapp.live.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.mediapicker.activity.ImagePasterViewModel;
import com.cupidapp.live.mediapicker.model.PasterModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ItemPasterBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageLoaderView f13984b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f13985c;

    /* renamed from: d, reason: collision with root package name */
    @Bindable
    public ImagePasterViewModel f13986d;

    /* renamed from: e, reason: collision with root package name */
    @Bindable
    public PasterModel f13987e;

    public ItemPasterBinding(Object obj, View view, int i10, ImageLoaderView imageLoaderView, TextView textView) {
        super(obj, view, i10);
        this.f13984b = imageLoaderView;
        this.f13985c = textView;
    }

    public abstract void b(@Nullable PasterModel pasterModel);

    public abstract void c(@Nullable ImagePasterViewModel imagePasterViewModel);
}
