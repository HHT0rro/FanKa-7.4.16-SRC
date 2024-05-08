package com.cupidapp.live.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FragmentEditStoryLabelBinding extends ViewDataBinding {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f13918b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f13919c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FKTitleBarLayout f13920d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f13921e;

    /* renamed from: f, reason: collision with root package name */
    @Bindable
    public FKStoryLabelViewModel f13922f;

    public FragmentEditStoryLabelBinding(Object obj, View view, int i10, EditText editText, TextView textView, FKTitleBarLayout fKTitleBarLayout, TextView textView2) {
        super(obj, view, i10);
        this.f13918b = editText;
        this.f13919c = textView;
        this.f13920d = fKTitleBarLayout;
        this.f13921e = textView2;
    }

    @NonNull
    public static FragmentEditStoryLabelBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        return c(layoutInflater, viewGroup, z10, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentEditStoryLabelBinding c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10, @Nullable Object obj) {
        return (FragmentEditStoryLabelBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.fragment_edit_story_label, viewGroup, z10, obj);
    }

    public abstract void d(@Nullable FKStoryLabelViewModel fKStoryLabelViewModel);
}
