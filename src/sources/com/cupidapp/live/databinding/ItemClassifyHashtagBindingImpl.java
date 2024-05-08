package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.hashtag.list.HashTagListViewModel;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import h2.a;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ItemClassifyHashtagBindingImpl extends ItemClassifyHashtagBinding implements a.InterfaceC0742a {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13968h = null;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13969i = null;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f13970f;

    /* renamed from: g, reason: collision with root package name */
    public long f13971g;

    public ItemClassifyHashtagBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13968h, f13969i));
    }

    @Override // h2.a.InterfaceC0742a
    public final void a(int i10, View view) {
        HashTagClassifyModel hashTagClassifyModel = this.f13967e;
        HashTagListViewModel hashTagListViewModel = this.f13966d;
        if (hashTagListViewModel != null) {
            hashTagListViewModel.changeSelectHashTagClassify(hashTagClassifyModel);
        }
    }

    @Override // com.cupidapp.live.databinding.ItemClassifyHashtagBinding
    public void b(@Nullable HashTagClassifyModel hashTagClassifyModel) {
        this.f13967e = hashTagClassifyModel;
        synchronized (this) {
            this.f13971g |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.cupidapp.live.databinding.ItemClassifyHashtagBinding
    public void c(@Nullable HashTagListViewModel hashTagListViewModel) {
        this.f13966d = hashTagListViewModel;
        synchronized (this) {
            this.f13971g |= 4;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    public final boolean d(LiveData<HashTagClassifyModel> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13971g |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        String str;
        boolean z10;
        long j11;
        long j12;
        synchronized (this) {
            j10 = this.f13971g;
            this.f13971g = 0L;
        }
        HashTagClassifyModel hashTagClassifyModel = this.f13967e;
        HashTagListViewModel hashTagListViewModel = this.f13966d;
        long j13 = j10 & 15;
        int i10 = 0;
        if (j13 != 0) {
            str = ((j10 & 10) == 0 || hashTagClassifyModel == null) ? null : hashTagClassifyModel.getName();
            LiveData<HashTagClassifyModel> selectClassifyLiveData = hashTagListViewModel != null ? hashTagListViewModel.getSelectClassifyLiveData() : null;
            updateLiveDataRegistration(0, selectClassifyLiveData);
            boolean equals = Objects.equals(hashTagClassifyModel, selectClassifyLiveData != null ? selectClassifyLiveData.getValue() : null);
            if (j13 != 0) {
                if (equals) {
                    j11 = j10 | 32;
                    j12 = 128;
                } else {
                    j11 = j10 | 16;
                    j12 = 64;
                }
                j10 = j11 | j12;
            }
            int colorFromResource = ViewDataBinding.getColorFromResource(this.f13965c, equals ? R$color.text_black : R$color.gray_7C7C7C);
            r14 = equals ? AppCompatResources.getDrawable(this.f13965c.getContext(), R$drawable.small_shape_black_bg_sixteen_corners) : null;
            i10 = colorFromResource;
            z10 = equals;
        } else {
            str = null;
            z10 = false;
        }
        if ((8 & j10) != 0) {
            this.f13964b.setOnClickListener(this.f13970f);
        }
        if ((j10 & 15) != 0) {
            TextViewBindingAdapter.setDrawableLeft(this.f13965c, r14);
            this.f13965c.setTextColor(i10);
            v0.a.e(this.f13965c, z10);
        }
        if ((j10 & 10) != 0) {
            TextViewBindingAdapter.setText(this.f13965c, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13971g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13971g = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return d((LiveData) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (1 == i10) {
            b((HashTagClassifyModel) obj);
            return true;
        }
        if (8 != i10) {
            return false;
        }
        c((HashTagListViewModel) obj);
        return true;
    }

    public ItemClassifyHashtagBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[0], (TextView) objArr[1]);
        this.f13971g = -1L;
        this.f13964b.setTag(null);
        this.f13965c.setTag(null);
        setRootTag(view);
        this.f13970f = new a(this, 1);
        invalidateAll();
    }
}
