package com.cupidapp.live.setting.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.adapter.EditUserAvatarAdapter;
import com.cupidapp.live.setting.model.AvatarMoveEndEvent;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: EditUserAvatarViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserAvatarViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18188c = new a(null);

    /* compiled from: EditUserAvatarViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EditUserAvatarViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new EditUserAvatarViewHolder(z.b(parent, R$layout.view_holder_edit_user_avatar, false, 2, null));
        }
    }

    /* compiled from: EditUserAvatarViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18189b;

        public b(boolean z10) {
            this.f18189b = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (this.f18189b) {
                EventBus.c().l(new AvatarMoveEndEvent());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserAvatarViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof EditUserAvatarUiModel) {
            EditUserAvatarAdapter.a aVar = EditUserAvatarAdapter.f18085f;
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            Size a10 = aVar.a(itemView);
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.user_avatar_root);
            s.h(relativeLayout, "itemView.user_avatar_root");
            y.n(relativeLayout, Integer.valueOf(a10.getWidth()), Integer.valueOf(a10.getHeight()));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.userAvatarImageView);
            s.h(imageLoaderView, "itemView.userAvatarImageView");
            EditUserAvatarUiModel editUserAvatarUiModel = (EditUserAvatarUiModel) obj;
            ImageLoaderView.g(imageLoaderView, editUserAvatarUiModel.getAvatarModel().getAvatarImage(), (editUserAvatarUiModel.isVideoAvatarValid() || editUserAvatarUiModel.getAvatarModel().getAvatarVideo() == null) ? null : new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(10.0f, 1), false, 0, 0, false, null, null, 520191, null), null, 4, null);
            ((ImageView) this.itemView.findViewById(R$id.videoAvatarTagImageView)).setVisibility(editUserAvatarUiModel.getAvatarModel().getAvatarVideo() == null ? 4 : 0);
            ((ImageView) this.itemView.findViewById(R$id.user_avatar_del)).setVisibility(editUserAvatarUiModel.getCanDel() ? 0 : 4);
            ((RelativeLayout) this.itemView.findViewById(R$id.user_change_avatar_rl)).setVisibility(editUserAvatarUiModel.getOnlyDefaultAvatar() ? 0 : 4);
            ((RelativeLayout) this.itemView.findViewById(R$id.user_invalid_avatar_rl)).setVisibility((editUserAvatarUiModel.isVideoAvatarValid() || editUserAvatarUiModel.getAvatarModel().getAvatarVideo() == null) ? 8 : 0);
        }
    }

    public final void r(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.itemView, View.SCALE_X, 1.1f, 1.0f);
        animatorSet.play(ofFloat).with(ObjectAnimator.ofFloat(this.itemView, View.SCALE_Y, 1.1f, 1.0f));
        animatorSet.setDuration(100L);
        animatorSet.addListener(new b(z10));
        animatorSet.start();
    }

    public final void s() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.itemView, View.SCALE_X, 1.0f, 1.1f);
        animatorSet.play(ofFloat).with(ObjectAnimator.ofFloat(this.itemView, View.SCALE_Y, 1.0f, 1.1f));
        animatorSet.setDuration(100L);
        animatorSet.start();
        if (Build.VERSION.SDK_INT >= 26) {
            VibrationEffect createOneShot = VibrationEffect.createOneShot(100L, -1);
            Object systemService = this.itemView.getContext().getSystemService("vibrator");
            s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(createOneShot);
            return;
        }
        Object systemService2 = this.itemView.getContext().getSystemService("vibrator");
        s.g(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService2).vibrate(100L);
    }
}
