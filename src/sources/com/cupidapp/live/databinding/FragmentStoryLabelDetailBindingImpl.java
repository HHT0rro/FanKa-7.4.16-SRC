package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelModel;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;
import java.util.List;
import v0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FragmentStoryLabelDetailBindingImpl extends FragmentStoryLabelDetailBinding {

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13953i = null;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13954j;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f13955g;

    /* renamed from: h, reason: collision with root package name */
    public long f13956h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13954j = sparseIntArray;
        sparseIntArray.put(R$id.story_label_detail_title_layout, 4);
    }

    public FragmentStoryLabelDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13953i, f13954j));
    }

    @Override // com.cupidapp.live.databinding.FragmentStoryLabelDetailBinding
    public void d(@Nullable FKStoryLabelViewModel fKStoryLabelViewModel) {
        this.f13952f = fKStoryLabelViewModel;
        synchronized (this) {
            this.f13956h |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    public final boolean e(LiveData<FKProfileStoryLabelModel> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13956h |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        boolean z10;
        int i10;
        boolean z11;
        LiveData<FKProfileStoryLabelModel> liveData;
        boolean z12;
        boolean z13;
        synchronized (this) {
            j10 = this.f13956h;
            this.f13956h = 0L;
        }
        FKStoryLabelViewModel fKStoryLabelViewModel = this.f13952f;
        long j11 = j10 & 7;
        List<FKStoryLabelItemModel> list = null;
        boolean z14 = false;
        if (j11 != 0) {
            if (fKStoryLabelViewModel != null) {
                liveData = fKStoryLabelViewModel.getStoryLabelDetailLiveData();
                z12 = fKStoryLabelViewModel.isMe();
            } else {
                liveData = null;
                z12 = false;
            }
            updateLiveDataRegistration(0, liveData);
            FKProfileStoryLabelModel value = liveData != null ? liveData.getValue() : null;
            z10 = !z12;
            if (j11 != 0) {
                j10 = z10 ? j10 | 16 : j10 | 8;
            }
            User user = value != null ? value.getUser() : null;
            if (user != null) {
                list = user.getStoryLabelList();
                z11 = user.getMatch();
                z13 = user.getAloha();
            } else {
                z13 = false;
                z11 = false;
            }
            if ((j10 & 7) != 0) {
                j10 |= z13 ? 64L : 32L;
            }
            i10 = z13 ? R$mipmap.icon_user_profile_followed : R$mipmap.match_follow_button;
        } else {
            z10 = false;
            i10 = 0;
            z11 = false;
        }
        boolean z15 = (16 & j10) != 0 ? !z11 : false;
        long j12 = j10 & 7;
        if (j12 != 0 && z10) {
            z14 = z15;
        }
        if (j12 != 0) {
            a.f(this.f13948b, i10);
            a.g(this.f13948b, z14);
            a.g(this.f13949c, z11);
            a.a(this.f13950d, list);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13956h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13956h = 4L;
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

    public FragmentStoryLabelDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[2], (ImageView) objArr[3], (RecyclerView) objArr[1], (FKTitleBarLayout) objArr[4]);
        this.f13956h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13955g = constraintLayout;
        constraintLayout.setTag(null);
        this.f13948b.setTag(null);
        this.f13949c.setTag(null);
        this.f13950d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
