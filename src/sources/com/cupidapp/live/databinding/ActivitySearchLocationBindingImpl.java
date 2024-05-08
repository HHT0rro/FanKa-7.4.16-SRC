package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.feed.layout.FlowLayout;
import com.cupidapp.live.match.viewmodel.SearchLocationViewModel;
import h2.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ActivitySearchLocationBindingImpl extends ActivitySearchLocationBinding implements a.InterfaceC0742a {

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13910s = null;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13911t;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f13912m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f13913n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f13914o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f13915p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f13916q;

    /* renamed from: r, reason: collision with root package name */
    public long f13917r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13911t = sparseIntArray;
        sparseIntArray.put(R$id.search_edit, 9);
        sparseIntArray.put(R$id.search_clear_img, 10);
        sparseIntArray.put(R$id.search_cancel_txt, 11);
        sparseIntArray.put(R$id.search_history_rv, 12);
    }

    public ActivitySearchLocationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f13910s, f13911t));
    }

    @Override // h2.a.InterfaceC0742a
    public final void a(int i10, View view) {
        if (i10 == 1) {
            SearchLocationViewModel searchLocationViewModel = this.f13909l;
            if (searchLocationViewModel != null) {
                searchLocationViewModel.changeHotCity();
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        SearchLocationViewModel searchLocationViewModel2 = this.f13909l;
        if (searchLocationViewModel2 != null) {
            searchLocationViewModel2.clearHistory();
        }
    }

    @Override // com.cupidapp.live.databinding.ActivitySearchLocationBinding
    public void b(@Nullable SearchLocationViewModel searchLocationViewModel) {
        this.f13909l = searchLocationViewModel;
        synchronized (this) {
            this.f13917r |= 8;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    public final boolean c(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13917r |= 1;
        }
        return true;
    }

    public final boolean d(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13917r |= 4;
        }
        return true;
    }

    public final boolean e(LiveData<Boolean> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13917r |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.databinding.ActivitySearchLocationBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13917r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13917r = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return c((LiveData) obj, i11);
        }
        if (i10 == 1) {
            return e((LiveData) obj, i11);
        }
        if (i10 != 2) {
            return false;
        }
        return d((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (7 != i10) {
            return false;
        }
        b((SearchLocationViewModel) obj);
        return true;
    }

    public ActivitySearchLocationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[11], (TextView) objArr[3], (ImageView) objArr[10], (EditText) objArr[9], (RecyclerView) objArr[12], (FlowLayout) objArr[4], (RecyclerView) objArr[8]);
        this.f13917r = -1L;
        this.f13899b.setTag(null);
        this.f13900c.setTag(null);
        this.f13901d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13912m = constraintLayout;
        constraintLayout.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[1];
        this.f13913n = nestedScrollView;
        nestedScrollView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[7];
        this.f13914o = relativeLayout;
        relativeLayout.setTag(null);
        this.f13903f.setTag(null);
        this.f13907j.setTag(null);
        this.f13908k.setTag(null);
        setRootTag(view);
        this.f13915p = new a(this, 1);
        this.f13916q = new a(this, 2);
        invalidateAll();
    }
}
