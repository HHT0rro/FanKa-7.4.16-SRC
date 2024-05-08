package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.share.fragment.ShareBottomViewModel;
import v0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FragmentShareMenuBindingImpl extends FragmentShareMenuBinding {

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13937m = null;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13938n;

    /* renamed from: l, reason: collision with root package name */
    public long f13939l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13938n = sparseIntArray;
        sparseIntArray.put(R$id.shareSelect, 2);
        sparseIntArray.put(R$id.blackLayout, 3);
        sparseIntArray.put(R$id.cancelLikeLayout, 4);
        sparseIntArray.put(R$id.deleteLayout, 5);
        sparseIntArray.put(R$id.dontLookHimLayout, 6);
        sparseIntArray.put(R$id.delOrPrivateLayout, 7);
        sparseIntArray.put(R$id.snap_web_content_image, 8);
    }

    public FragmentShareMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13937m, f13938n));
    }

    @Override // com.cupidapp.live.databinding.FragmentShareMenuBinding
    public void d(@Nullable ShareBottomViewModel shareBottomViewModel) {
        this.f13936k = shareBottomViewModel;
        synchronized (this) {
            this.f13939l |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    public final boolean e(LiveData<Integer> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13939l |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        synchronized (this) {
            j10 = this.f13939l;
            this.f13939l = 0L;
        }
        ShareBottomViewModel shareBottomViewModel = this.f13936k;
        long j11 = j10 & 7;
        if (j11 != 0) {
            LiveData<Integer> dialogType = shareBottomViewModel != null ? shareBottomViewModel.getDialogType() : null;
            updateLiveDataRegistration(0, dialogType);
            int safeUnbox = ViewDataBinding.safeUnbox(dialogType != null ? dialogType.getValue() : null);
            z13 = safeUnbox == 3;
            z16 = safeUnbox == 5;
            boolean z17 = safeUnbox == 0;
            boolean z18 = safeUnbox == 1;
            z14 = safeUnbox == 4;
            z15 = safeUnbox == 2;
            boolean z19 = safeUnbox == -1;
            if (j11 != 0) {
                j10 = z14 ? j10 | 16 : j10 | 8;
            }
            z10 = z17;
            z11 = z18;
            z12 = z19;
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = false;
        }
        boolean showDontLookConfirm = ((16 & j10) == 0 || shareBottomViewModel == null) ? false : shareBottomViewModel.showDontLookConfirm();
        long j12 = j10 & 7;
        boolean z20 = (j12 == 0 || !z14) ? false : showDontLookConfirm;
        if (j12 != 0) {
            a.g(this.f13927b, z15);
            a.g(this.f13928c, z11);
            a.g(this.f13929d, z16);
            a.g(this.f13930e, z13);
            a.g(this.f13931f, z20);
            a.g(this.f13932g, z12);
            a.g(this.f13934i, z10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13939l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13939l = 4L;
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
        d((ShareBottomViewModel) obj);
        return true;
    }

    public FragmentShareMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (View) objArr[3], (View) objArr[4], (View) objArr[7], (View) objArr[5], (View) objArr[6], (ProgressBar) objArr[1], (RelativeLayout) objArr[0], (View) objArr[2], (ImageLoaderView) objArr[8]);
        this.f13939l = -1L;
        this.f13932g.setTag(null);
        this.f13933h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
