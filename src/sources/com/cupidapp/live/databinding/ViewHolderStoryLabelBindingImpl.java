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
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewHolderStoryLabelBindingImpl extends ViewHolderStoryLabelBinding {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13994f = null;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13995g = null;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f13996c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f13997d;

    /* renamed from: e, reason: collision with root package name */
    public long f13998e;

    public ViewHolderStoryLabelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13994f, f13995g));
    }

    @Override // com.cupidapp.live.databinding.ViewHolderStoryLabelBinding
    public void d(@Nullable FKStoryLabelItemModel fKStoryLabelItemModel) {
        this.f13993b = fKStoryLabelItemModel;
        synchronized (this) {
            this.f13998e |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f13998e;
            this.f13998e = 0L;
        }
        FKStoryLabelItemModel fKStoryLabelItemModel = this.f13993b;
        String str = null;
        long j11 = j10 & 3;
        if (j11 != 0 && fKStoryLabelItemModel != null) {
            str = fKStoryLabelItemModel.getQuestion();
        }
        if (j11 != 0) {
            TextViewBindingAdapter.setText(this.f13997d, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13998e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13998e = 2L;
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

    public ViewHolderStoryLabelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13998e = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13996c = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13997d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
