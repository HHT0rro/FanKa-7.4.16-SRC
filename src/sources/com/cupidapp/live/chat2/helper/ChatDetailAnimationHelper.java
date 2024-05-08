package com.cupidapp.live.chat2.helper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$raw;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.animation.a;
import com.cupidapp.live.chat2.helper.ChatDetailAnimationHelper;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ChatDetailAnimationHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailAnimationHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatDetailAnimationHelper f13343a = new ChatDetailAnimationHelper();

    /* compiled from: ChatDetailAnimationHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.cupidapp.live.base.view.animation.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13344a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f13345b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f13346c;

        public a(View view, AlertDialog alertDialog, ImageView imageView) {
            this.f13344a = view;
            this.f13345b = alertDialog;
            this.f13346c = imageView;
        }

        public static final void b(AlertDialog dialog, ImageView imageView) {
            s.h(dialog, "dialog");
            z0.d.g(dialog, 0.4f);
            imageView.setVisibility(0);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationCancel(@NotNull Animator animator) {
            a.C0145a.a(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationEnd(@Nullable Animator animator) {
            a.C0145a.b(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationPause(@Nullable Animator animator) {
            a.C0145a.c(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationRepeat(@NotNull Animator animator) {
            a.C0145a.d(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationResume(@Nullable Animator animator) {
            a.C0145a.e(this, animator);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationStart(@Nullable Animator animator) {
            View view = this.f13344a;
            final AlertDialog alertDialog = this.f13345b;
            final ImageView imageView = this.f13346c;
            view.postDelayed(new Runnable() { // from class: com.cupidapp.live.chat2.helper.f
                @Override // java.lang.Runnable
                public final void run() {
                    ChatDetailAnimationHelper.a.b(alertDialog, imageView);
                }
            }, 1200L);
        }

        @Override // com.cupidapp.live.base.view.animation.a
        public void onAnimationUpdate(@NotNull ValueAnimator valueAnimator) {
            a.C0145a.g(this, valueAnimator);
        }
    }

    public static final void c(View view, final SensorPosition position, final AlertDialog alertDialog, final Context context, final String str, DialogInterface dialogInterface) {
        s.i(position, "$position");
        final FKLottieAnimationView lottieView = (FKLottieAnimationView) view.findViewById(R$id.chat_detail_animation_lottie_view);
        ImageView closeView = (ImageView) view.findViewById(R$id.chat_detail_animation_close_btn);
        lottieView.setLottieAnimation(R$raw.lottie_chat_detail_constellation_matching_degree);
        lottieView.F(new a(view, alertDialog, closeView));
        lottieView.L();
        s.h(lottieView, "lottieView");
        y.d(lottieView, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.helper.ChatDetailAnimationHelper$showConstellationMatchingDegreeAnimation$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                j1.i.f50236a.a(PopupName.FINKA_ASTROLOGY_GUIDE, PopupButtonName.TRY, SensorPosition.this);
                lottieView.M();
                j.a.b(j.f12156c, context, str, null, 4, null);
                alertDialog.dismiss();
            }
        });
        s.h(closeView, "closeView");
        y.d(closeView, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.helper.ChatDetailAnimationHelper$showConstellationMatchingDegreeAnimation$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                j1.i.f50236a.a(PopupName.FINKA_ASTROLOGY_GUIDE, PopupButtonName.Close, SensorPosition.this);
                alertDialog.dismiss();
            }
        });
        j1.i.g(j1.i.f50236a, PopupName.FINKA_ASTROLOGY_GUIDE, position, null, 4, null);
    }

    public final void b(@Nullable final Context context, @Nullable final String str, @NotNull final SensorPosition position) {
        s.i(position, "position");
        if (context != null) {
            if (str == null || str.length() == 0) {
                return;
            }
            final View inflate = View.inflate(context, R$layout.layout_chat_detail_animation, null);
            final AlertDialog dialog = z0.b.f54812a.e(context).setView(inflate).create();
            s.h(dialog, "dialog");
            z0.d.g(dialog, 0.0f);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.chat2.helper.e
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ChatDetailAnimationHelper.c(View.this, position, dialog, context, str, dialogInterface);
                }
            });
            dialog.show();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -2);
            }
        }
    }
}
