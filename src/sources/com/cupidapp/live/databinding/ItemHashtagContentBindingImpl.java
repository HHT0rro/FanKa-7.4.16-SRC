package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.hashtag.list.HashTagListViewModel;
import com.cupidapp.live.hashtag.model.HashTag;
import h2.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ItemHashtagContentBindingImpl extends ItemHashtagContentBinding implements a.InterfaceC0742a {

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13978l = null;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13979m = null;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final CardView f13980h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f13981i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final View.OnClickListener f13982j;

    /* renamed from: k, reason: collision with root package name */
    public long f13983k;

    public ItemHashtagContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13978l, f13979m));
    }

    @Override // h2.a.InterfaceC0742a
    public final void a(int i10, View view) {
        HashTag hashTag = this.f13977g;
        HashTagListViewModel hashTagListViewModel = this.f13976f;
        if (hashTagListViewModel != null) {
            hashTagListViewModel.clickHashTag(hashTag);
        }
    }

    @Override // com.cupidapp.live.databinding.ItemHashtagContentBinding
    public void b(@Nullable HashTag hashTag) {
        this.f13977g = hashTag;
        synchronized (this) {
            this.f13983k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.cupidapp.live.databinding.ItemHashtagContentBinding
    public void c(@Nullable HashTagListViewModel hashTagListViewModel) {
        this.f13976f = hashTagListViewModel;
        synchronized (this) {
            this.f13983k |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        ImageModel imageModel;
        String str;
        String str2;
        synchronized (this) {
            j10 = this.f13983k;
            this.f13983k = 0L;
        }
        int i10 = 0;
        HashTag hashTag = this.f13977g;
        long j11 = 5 & j10;
        String str3 = null;
        if (j11 == 0 || hashTag == null) {
            imageModel = null;
            str = null;
            str2 = null;
        } else {
            i10 = hashTag.getCornerRes();
            ImageModel backgroundImage = hashTag.getBackgroundImage();
            String userCountDesc = hashTag.getUserCountDesc();
            str2 = hashTag.getDescription();
            str = hashTag.getName();
            imageModel = backgroundImage;
            str3 = userCountDesc;
        }
        if (j11 != 0) {
            TextViewBindingAdapter.setText(this.f13972b, str3);
            TextViewBindingAdapter.setText(this.f13973c, str2);
            v0.a.c(this.f13974d, imageModel);
            TextViewBindingAdapter.setText(this.f13975e, str);
            v0.a.d(this.f13975e, i10, R$mipmap.icon_black_hashtag);
        }
        if ((j10 & 4) != 0) {
            this.f13981i.setOnClickListener(this.f13982j);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13983k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13983k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, @Nullable Object obj) {
        if (2 == i10) {
            b((HashTag) obj);
        } else {
            if (8 != i10) {
                return false;
            }
            c((HashTagListViewModel) obj);
        }
        return true;
    }

    public ItemHashtagContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[4], (ImageLoaderView) objArr[5], (TextView) objArr[3]);
        this.f13983k = -1L;
        this.f13972b.setTag(null);
        this.f13973c.setTag(null);
        this.f13974d.setTag(null);
        this.f13975e.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.f13980h = cardView;
        cardView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f13981i = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.f13982j = new a(this, 1);
        invalidateAll();
    }
}
