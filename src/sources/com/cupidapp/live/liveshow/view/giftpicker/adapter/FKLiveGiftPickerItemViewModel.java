package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftPickerItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerItemViewModel {

    @NotNull
    private GiftItemModel giftItemModel;
    private boolean isSelected;

    @Nullable
    private AnimatorSet itemAnimator;

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f15427b;

        public a(View view) {
            this.f15427b = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
            this.f15427b.setScaleX(1.0f);
            this.f15427b.setScaleY(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    public FKLiveGiftPickerItemViewModel(@NotNull GiftItemModel giftItemModel, boolean z10) {
        s.i(giftItemModel, "giftItemModel");
        this.giftItemModel = giftItemModel;
        this.isSelected = z10;
    }

    public static /* synthetic */ FKLiveGiftPickerItemViewModel copy$default(FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel, GiftItemModel giftItemModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            giftItemModel = fKLiveGiftPickerItemViewModel.giftItemModel;
        }
        if ((i10 & 2) != 0) {
            z10 = fKLiveGiftPickerItemViewModel.isSelected;
        }
        return fKLiveGiftPickerItemViewModel.copy(giftItemModel, z10);
    }

    @NotNull
    public final GiftItemModel component1() {
        return this.giftItemModel;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    @NotNull
    public final FKLiveGiftPickerItemViewModel copy(@NotNull GiftItemModel giftItemModel, boolean z10) {
        s.i(giftItemModel, "giftItemModel");
        return new FKLiveGiftPickerItemViewModel(giftItemModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveGiftPickerItemViewModel)) {
            return false;
        }
        FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel = (FKLiveGiftPickerItemViewModel) obj;
        return s.d(this.giftItemModel, fKLiveGiftPickerItemViewModel.giftItemModel) && this.isSelected == fKLiveGiftPickerItemViewModel.isSelected;
    }

    @NotNull
    public final GiftItemModel getGiftItemModel() {
        return this.giftItemModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.giftItemModel.hashCode() * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setGiftItemModel(@NotNull GiftItemModel giftItemModel) {
        s.i(giftItemModel, "<set-?>");
        this.giftItemModel = giftItemModel;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public final void showItemAnimator(@NotNull View view) {
        s.i(view, "view");
        AnimatorSet animatorSet = this.itemAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f, 1.1f);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f, 1.1f);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat).with(ofFloat2);
        animatorSet2.setDuration(480L);
        animatorSet2.addListener(new a(view));
        this.itemAnimator = animatorSet2;
        animatorSet2.start();
    }

    public final void stopItemAnimator() {
        AnimatorSet animatorSet = this.itemAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.itemAnimator = null;
    }

    @NotNull
    public String toString() {
        GiftItemModel giftItemModel = this.giftItemModel;
        return "FKLiveGiftPickerItemViewModel(giftItemModel=" + ((Object) giftItemModel) + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ FKLiveGiftPickerItemViewModel(GiftItemModel giftItemModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(giftItemModel, (i10 & 2) != 0 ? false : z10);
    }
}
