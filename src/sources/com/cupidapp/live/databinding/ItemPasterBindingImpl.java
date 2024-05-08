package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.cupidapp.live.R$color;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.mediapicker.activity.ImagePasterViewModel;
import com.cupidapp.live.mediapicker.model.PasterModel;
import h2.a;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ItemPasterBindingImpl extends ItemPasterBinding implements a.InterfaceC0742a {

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13988i = null;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13989j = null;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f13990f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f13991g;

    /* renamed from: h, reason: collision with root package name */
    public long f13992h;

    public ItemPasterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13988i, f13989j));
    }

    @Override // h2.a.InterfaceC0742a
    public final void a(int i10, View view) {
        PasterModel pasterModel = this.f13987e;
        ImagePasterViewModel imagePasterViewModel = this.f13986d;
        if (imagePasterViewModel != null) {
            imagePasterViewModel.changePaster(pasterModel);
        }
    }

    @Override // com.cupidapp.live.databinding.ItemPasterBinding
    public void b(@Nullable PasterModel pasterModel) {
        this.f13987e = pasterModel;
        synchronized (this) {
            this.f13992h |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.cupidapp.live.databinding.ItemPasterBinding
    public void c(@Nullable ImagePasterViewModel imagePasterViewModel) {
        this.f13986d = imagePasterViewModel;
        synchronized (this) {
            this.f13992h |= 4;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    public final boolean d(LiveData<PasterModel> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13992h |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        String str;
        ImageModel imageModel;
        TextView textView;
        int i10;
        synchronized (this) {
            j10 = this.f13992h;
            this.f13992h = 0L;
        }
        PasterModel pasterModel = this.f13987e;
        ImagePasterViewModel imagePasterViewModel = this.f13986d;
        long j11 = j10 & 15;
        int i11 = 0;
        ImageModel imageModel2 = null;
        if (j11 != 0) {
            if ((j10 & 10) == 0 || pasterModel == null) {
                imageModel = null;
                str = null;
            } else {
                imageModel = pasterModel.getImage();
                str = pasterModel.getName();
            }
            LiveData<PasterModel> imagePasterSelect = imagePasterViewModel != null ? imagePasterViewModel.getImagePasterSelect() : null;
            updateLiveDataRegistration(0, imagePasterSelect);
            boolean equals = Objects.equals(imagePasterSelect != null ? imagePasterSelect.getValue() : null, pasterModel);
            if (j11 != 0) {
                j10 |= equals ? 32L : 16L;
            }
            if (equals) {
                textView = this.f13985c;
                i10 = R$color.app_white;
            } else {
                textView = this.f13985c;
                i10 = R$color.gray_7C7C7C;
            }
            i11 = ViewDataBinding.getColorFromResource(textView, i10);
            imageModel2 = imageModel;
        } else {
            str = null;
        }
        if ((8 & j10) != 0) {
            this.f13990f.setOnClickListener(this.f13991g);
        }
        if ((10 & j10) != 0) {
            v0.a.c(this.f13984b, imageModel2);
            TextViewBindingAdapter.setText(this.f13985c, str);
        }
        if ((j10 & 15) != 0) {
            this.f13985c.setTextColor(i11);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13992h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13992h = 8L;
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
        if (3 == i10) {
            b((PasterModel) obj);
        } else {
            if (7 != i10) {
                return false;
            }
            c((ImagePasterViewModel) obj);
        }
        return true;
    }

    public ItemPasterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageLoaderView) objArr[2], (TextView) objArr[1]);
        this.f13992h = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13990f = linearLayout;
        linearLayout.setTag(null);
        this.f13984b.setTag(null);
        this.f13985c.setTag(null);
        setRootTag(view);
        this.f13991g = new a(this, 1);
        invalidateAll();
    }
}
