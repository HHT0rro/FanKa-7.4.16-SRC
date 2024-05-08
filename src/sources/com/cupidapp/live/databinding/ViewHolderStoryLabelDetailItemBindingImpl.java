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
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import v0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewHolderStoryLabelDetailItemBindingImpl extends ViewHolderStoryLabelDetailItemBinding {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14003h = null;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f14004i = null;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14005f;

    /* renamed from: g, reason: collision with root package name */
    public long f14006g;

    public ViewHolderStoryLabelDetailItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f14003h, f14004i));
    }

    @Override // com.cupidapp.live.databinding.ViewHolderStoryLabelDetailItemBinding
    public void d(@Nullable FKStoryLabelItemModel fKStoryLabelItemModel) {
        this.f14002e = fKStoryLabelItemModel;
        synchronized (this) {
            this.f14006g |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        ImageModel imageModel;
        String str;
        synchronized (this) {
            j10 = this.f14006g;
            this.f14006g = 0L;
        }
        FKStoryLabelItemModel fKStoryLabelItemModel = this.f14002e;
        long j11 = 3 & j10;
        String str2 = null;
        if (j11 == 0 || fKStoryLabelItemModel == null) {
            imageModel = null;
            str = null;
        } else {
            ImageModel icon = fKStoryLabelItemModel.getIcon();
            String content = fKStoryLabelItemModel.getContent();
            str = fKStoryLabelItemModel.getQuestion();
            imageModel = icon;
            str2 = content;
        }
        if (j11 != 0) {
            TextViewBindingAdapter.setText(this.f13999b, str2);
            a.c(this.f14000c, imageModel);
            TextViewBindingAdapter.setText(this.f14001d, str);
        }
        if ((j10 & 2) != 0) {
            a.e(this.f14001d, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14006g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14006g = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (4 != i10) {
            return false;
        }
        d((FKStoryLabelItemModel) obj);
        return true;
    }

    public ViewHolderStoryLabelDetailItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[3], (ImageLoaderView) objArr[1], (TextView) objArr[2]);
        this.f14006g = -1L;
        this.f13999b.setTag(null);
        this.f14000c.setTag(null);
        this.f14001d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14005f = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
