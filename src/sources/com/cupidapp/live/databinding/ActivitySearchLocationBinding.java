package com.cupidapp.live.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.match.viewmodel.SearchLocationViewModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ActivitySearchLocationBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f13899b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f13900c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f13901d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f13902e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f13903f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f13904g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final EditText f13905h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13906i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FlowLayout f13907j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RecyclerView f13908k;

    /* renamed from: l, reason: collision with root package name */
    @Bindable
    public SearchLocationViewModel f13909l;

    public ActivitySearchLocationBinding(Object obj, View view, int i10, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView, EditText editText, RecyclerView recyclerView, FlowLayout flowLayout, RecyclerView recyclerView2) {
        super(obj, view, i10);
        this.f13899b = textView;
        this.f13900c = textView2;
        this.f13901d = textView3;
        this.f13902e = textView4;
        this.f13903f = textView5;
        this.f13904g = imageView;
        this.f13905h = editText;
        this.f13906i = recyclerView;
        this.f13907j = flowLayout;
        this.f13908k = recyclerView2;
    }

    public abstract void b(@Nullable SearchLocationViewModel searchLocationViewModel);
}
