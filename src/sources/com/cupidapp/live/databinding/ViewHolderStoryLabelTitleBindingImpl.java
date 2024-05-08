package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.setting.adapter.FKStoryLabelTitleModel;
import v0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewHolderStoryLabelTitleBindingImpl extends ViewHolderStoryLabelTitleBinding {

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14015g = null;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f14016h = null;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14017e;

    /* renamed from: f, reason: collision with root package name */
    public long f14018f;

    public ViewHolderStoryLabelTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f14015g, f14016h));
    }

    @Override // com.cupidapp.live.databinding.ViewHolderStoryLabelTitleBinding
    public void d(@Nullable FKStoryLabelTitleModel fKStoryLabelTitleModel) {
        this.f14014d = fKStoryLabelTitleModel;
        synchronized (this) {
            this.f14018f |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        String str;
        synchronized (this) {
            j10 = this.f14018f;
            this.f14018f = 0L;
        }
        FKStoryLabelTitleModel fKStoryLabelTitleModel = this.f14014d;
        long j11 = j10 & 3;
        ImageModel imageModel = null;
        if (j11 == 0 || fKStoryLabelTitleModel == null) {
            str = null;
        } else {
            String title = fKStoryLabelTitleModel.getTitle();
            imageModel = fKStoryLabelTitleModel.getIcon();
            str = title;
        }
        if (j11 != 0) {
            a.c(this.f14012b, imageModel);
            TextViewBindingAdapter.setText(this.f14013c, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14018f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14018f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (6 != i10) {
            return false;
        }
        d((FKStoryLabelTitleModel) obj);
        return true;
    }

    public ViewHolderStoryLabelTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageLoaderView) objArr[1], (TextView) objArr[2]);
        this.f14018f = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14017e = constraintLayout;
        constraintLayout.setTag(null);
        this.f14012b.setTag(null);
        this.f14013c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
