package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.hashtag.list.HashTagListViewModel;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import java.util.List;
import kotlin.Pair;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class HashtagListFragmentBindingImpl extends HashtagListFragmentBinding {

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13961g = null;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13962h = null;

    /* renamed from: f, reason: collision with root package name */
    public long f13963f;

    public HashtagListFragmentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13961g, f13962h));
    }

    @Override // com.cupidapp.live.databinding.HashtagListFragmentBinding
    public void d(@Nullable HashTagListViewModel hashTagListViewModel) {
        this.f13960e = hashTagListViewModel;
        synchronized (this) {
            this.f13963f |= 4;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    public final boolean e(LiveData<List<HashTagClassifyModel>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13963f |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.f13963f     // Catch: java.lang.Throwable -> L67
            r2 = 0
            r14.f13963f = r2     // Catch: java.lang.Throwable -> L67
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L67
            com.cupidapp.live.hashtag.list.HashTagListViewModel r4 = r14.f13960e
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L50
            long r5 = r0 & r9
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L31
            if (r4 == 0) goto L23
            androidx.lifecycle.LiveData r5 = r4.getClassifiesLiveData()
            goto L24
        L23:
            r5 = r11
        L24:
            r6 = 0
            r14.updateLiveDataRegistration(r6, r5)
            if (r5 == 0) goto L31
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            goto L32
        L31:
            r5 = r11
        L32:
            long r12 = r0 & r7
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L4d
            if (r4 == 0) goto L3f
            androidx.lifecycle.LiveData r4 = r4.getContentsLiveData()
            goto L40
        L3f:
            r4 = r11
        L40:
            r6 = 1
            r14.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L4d
            java.lang.Object r4 = r4.getValue()
            r11 = r4
            kotlin.Pair r11 = (kotlin.Pair) r11
        L4d:
            r4 = r11
            r11 = r5
            goto L51
        L50:
            r4 = r11
        L51:
            long r5 = r0 & r9
            int r9 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r9 == 0) goto L5c
            androidx.recyclerview.widget.RecyclerView r5 = r14.f13958c
            com.cupidapp.live.hashtag.list.b.a(r5, r11)
        L5c:
            long r0 = r0 & r7
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L66
            androidx.recyclerview.widget.RecyclerView r0 = r14.f13959d
            com.cupidapp.live.hashtag.list.b.b(r0, r4)
        L66:
            return
        L67:
            r0 = move-exception
            monitor-exit(r14)     // Catch: java.lang.Throwable -> L67
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.databinding.HashtagListFragmentBindingImpl.executeBindings():void");
    }

    public final boolean f(LiveData<Pair<Boolean, List<HashTag>>> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13963f |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13963f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13963f = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return e((LiveData) obj, i11);
        }
        if (i10 != 1) {
            return false;
        }
        return f((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (8 != i10) {
            return false;
        }
        d((HashTagListViewModel) obj);
        return true;
    }

    public HashtagListFragmentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FKSwipeRefreshLayout) objArr[0], (RecyclerView) objArr[1], (RecyclerView) objArr[2]);
        this.f13963f = -1L;
        this.f13957b.setTag(null);
        this.f13958c.setTag(null);
        this.f13959d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
