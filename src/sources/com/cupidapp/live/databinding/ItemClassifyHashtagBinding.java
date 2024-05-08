package com.cupidapp.live.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.hashtag.list.HashTagListViewModel;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ItemClassifyHashtagBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f13964b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f13965c;

    /* renamed from: d, reason: collision with root package name */
    @Bindable
    public HashTagListViewModel f13966d;

    /* renamed from: e, reason: collision with root package name */
    @Bindable
    public HashTagClassifyModel f13967e;

    public ItemClassifyHashtagBinding(Object obj, View view, int i10, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i10);
        this.f13964b = constraintLayout;
        this.f13965c = textView;
    }

    public abstract void b(@Nullable HashTagClassifyModel hashTagClassifyModel);

    public abstract void c(@Nullable HashTagListViewModel hashTagListViewModel);
}
