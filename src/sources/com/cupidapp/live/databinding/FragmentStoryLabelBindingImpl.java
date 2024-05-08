package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.model.FKStoryLabelListModel;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;
import java.util.List;
import v0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FragmentStoryLabelBindingImpl extends FragmentStoryLabelBinding {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13944h = null;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13945i;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f13946f;

    /* renamed from: g, reason: collision with root package name */
    public long f13947g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13945i = sparseIntArray;
        sparseIntArray.put(R$id.story_label_title_layout, 2);
        sparseIntArray.put(R$id.story_label_refresh_layout, 3);
    }

    public FragmentStoryLabelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13944h, f13945i));
    }

    @Override // com.cupidapp.live.databinding.FragmentStoryLabelBinding
    public void d(@Nullable FKStoryLabelViewModel fKStoryLabelViewModel) {
        this.f13943e = fKStoryLabelViewModel;
        synchronized (this) {
            this.f13947g |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    public final boolean e(LiveData<StateResult<List<FKStoryLabelListModel>>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13947g |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        synchronized (this) {
            j10 = this.f13947g;
            this.f13947g = 0L;
        }
        FKStoryLabelViewModel fKStoryLabelViewModel = this.f13943e;
        long j11 = j10 & 7;
        List<FKStoryLabelListModel> list = null;
        if (j11 != 0) {
            LiveData<StateResult<List<FKStoryLabelListModel>>> storyLabelLiveData = fKStoryLabelViewModel != null ? fKStoryLabelViewModel.getStoryLabelLiveData() : null;
            updateLiveDataRegistration(0, storyLabelLiveData);
            StateResult<List<FKStoryLabelListModel>> value = storyLabelLiveData != null ? storyLabelLiveData.getValue() : null;
            if (value != null) {
                list = value.getData();
            }
        }
        if (j11 != 0) {
            a.a(this.f13940b, list);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13947g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13947g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return e((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (7 != i10) {
            return false;
        }
        d((FKStoryLabelViewModel) obj);
        return true;
    }

    public FragmentStoryLabelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[1], (FKSwipeRefreshLayout) objArr[3], (FKTitleBarLayout) objArr[2]);
        this.f13947g = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13946f = constraintLayout;
        constraintLayout.setTag(null);
        this.f13940b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
