package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.cupidapp.live.setting.adapter.FKStoryLabelTipsModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewHolderStoryLabelTipsBindingImpl extends ViewHolderStoryLabelTipsBinding {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14008e = null;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f14009f = null;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f14010c;

    /* renamed from: d, reason: collision with root package name */
    public long f14011d;

    public ViewHolderStoryLabelTipsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f14008e, f14009f));
    }

    @Override // com.cupidapp.live.databinding.ViewHolderStoryLabelTipsBinding
    public void d(@Nullable FKStoryLabelTipsModel fKStoryLabelTipsModel) {
        this.f14007b = fKStoryLabelTipsModel;
        synchronized (this) {
            this.f14011d |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f14011d;
            this.f14011d = 0L;
        }
        FKStoryLabelTipsModel fKStoryLabelTipsModel = this.f14007b;
        int i10 = 0;
        long j11 = j10 & 3;
        if (j11 != 0 && fKStoryLabelTipsModel != null) {
            i10 = fKStoryLabelTipsModel.getTips();
        }
        if (j11 != 0) {
            this.f14010c.setText(i10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14011d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14011d = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (5 != i10) {
            return false;
        }
        d((FKStoryLabelTipsModel) obj);
        return true;
    }

    public ViewHolderStoryLabelTipsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f14011d = -1L;
        TextView textView = (TextView) objArr[0];
        this.f14010c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
