package com.cupidapp.live.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;
import v0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FragmentEditStoryLabelBindingImpl extends FragmentEditStoryLabelBinding {

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13923i = null;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f13924j;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f13925g;

    /* renamed from: h, reason: collision with root package name */
    public long f13926h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13924j = sparseIntArray;
        sparseIntArray.put(R$id.edit_story_label_title_layout, 4);
    }

    public FragmentEditStoryLabelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13923i, f13924j));
    }

    @Override // com.cupidapp.live.databinding.FragmentEditStoryLabelBinding
    public void d(@Nullable FKStoryLabelViewModel fKStoryLabelViewModel) {
        this.f13922f = fKStoryLabelViewModel;
        synchronized (this) {
            this.f13926h |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    public final boolean e(LiveData<FKStoryLabelItemModel> liveData, int i10) {
        if (i10 != 0) {
            return false;
        }
        synchronized (this) {
            this.f13926h |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j10;
        long j11;
        String str;
        String str2;
        int i10;
        boolean z10;
        LiveData<FKStoryLabelItemModel> liveData;
        String str3;
        synchronized (this) {
            j10 = this.f13926h;
            this.f13926h = 0L;
        }
        FKStoryLabelViewModel fKStoryLabelViewModel = this.f13922f;
        long j12 = j10 & 7;
        String str4 = null;
        int i11 = 0;
        if (j12 != 0) {
            if (fKStoryLabelViewModel != null) {
                i10 = fKStoryLabelViewModel.getMaxEnterTextCount();
                liveData = fKStoryLabelViewModel.getSelectedStoryLabelLiveData();
            } else {
                liveData = null;
                i10 = 0;
            }
            updateLiveDataRegistration(0, liveData);
            FKStoryLabelItemModel value = liveData != null ? liveData.getValue() : null;
            if (value != null) {
                str4 = value.getContent();
                str2 = value.getQuestion();
                str3 = value.getDefaultContent();
            } else {
                str3 = null;
                str2 = null;
            }
            int length = str4 != null ? str4.length() : 0;
            boolean z11 = length < i10;
            z10 = length >= i10;
            String string = this.f13921e.getResources().getString(R$string.proportion, Integer.valueOf(length), Integer.valueOf(i10));
            if (j12 != 0) {
                j10 |= z11 ? 16L : 8L;
            }
            i11 = ViewDataBinding.getColorFromResource(this.f13921e, z11 ? R$color.text_gray : R$color.prime_red);
            j11 = 7;
            str4 = str3;
            str = string;
        } else {
            j11 = 7;
            str = null;
            str2 = null;
            i10 = 0;
            z10 = false;
        }
        if ((j11 & j10) != 0) {
            this.f13918b.setHint(str4);
            TextViewBindingAdapter.setText(this.f13919c, str2);
            TextViewBindingAdapter.setText(this.f13921e, str);
            this.f13921e.setTextColor(i11);
            a.b(this.f13921e, z10);
        }
        if ((j10 & 6) != 0) {
            TextViewBindingAdapter.setMaxLength(this.f13918b, i10);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13926h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13926h = 4L;
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

    public FragmentEditStoryLabelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[2], (TextView) objArr[1], (FKTitleBarLayout) objArr[4], (TextView) objArr[3]);
        this.f13926h = -1L;
        this.f13918b.setTag(null);
        this.f13919c.setTag(null);
        this.f13921e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13925g = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
