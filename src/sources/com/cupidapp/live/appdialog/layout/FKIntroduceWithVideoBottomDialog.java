package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.video.BaseExoMediaPlayer;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKIntroduceWithVideoBottomDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKIntroduceWithVideoBottomDialog extends FrameLayout {

    /* renamed from: f */
    @NotNull
    public static final a f11685f = new a(null);

    /* renamed from: b */
    @Nullable
    public AlertDialog f11686b;

    /* renamed from: c */
    public boolean f11687c;

    /* renamed from: d */
    @NotNull
    public final Lazy f11688d;

    /* renamed from: e */
    @NotNull
    public Map<Integer, View> f11689e;

    /* compiled from: FKIntroduceWithVideoBottomDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKIntroduceWithVideoBottomDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKIntroduceWithVideoBottomDialog(context, null);
        }
    }

    /* compiled from: FKIntroduceWithVideoBottomDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements BaseExoMediaPlayer.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.video.BaseExoMediaPlayer.c
        public void a(@NotNull BaseExoMediaPlayer.PlayState state) {
            kotlin.jvm.internal.s.i(state, "state");
            if (state == BaseExoMediaPlayer.PlayState.READY) {
                FKIntroduceWithVideoBottomDialog.this.b(R$id.cover_image).setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKIntroduceWithVideoBottomDialog(Context context) {
        super(context);
        this.f11689e = new LinkedHashMap();
        this.f11687c = true;
        this.f11688d = kotlin.c.b(new Function0<BaseExoMediaPlayer>() { // from class: com.cupidapp.live.appdialog.layout.FKIntroduceWithVideoBottomDialog$mPlayer$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BaseExoMediaPlayer invoke() {
                return new BaseExoMediaPlayer();
            }
        });
        d();
    }

    public /* synthetic */ FKIntroduceWithVideoBottomDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKIntroduceWithVideoBottomDialog g(FKIntroduceWithVideoBottomDialog fKIntroduceWithVideoBottomDialog, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        return fKIntroduceWithVideoBottomDialog.f(function0);
    }

    private final BaseExoMediaPlayer getMPlayer() {
        return (BaseExoMediaPlayer) this.f11688d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKIntroduceWithVideoBottomDialog k(FKIntroduceWithVideoBottomDialog fKIntroduceWithVideoBottomDialog, int i10, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = R$string.use_quickly;
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        return fKIntroduceWithVideoBottomDialog.j(i10, function0);
    }

    public static /* synthetic */ FKIntroduceWithVideoBottomDialog m(FKIntroduceWithVideoBottomDialog fKIntroduceWithVideoBottomDialog, String str, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        return fKIntroduceWithVideoBottomDialog.l(str, num);
    }

    public static final void r(FKIntroduceWithVideoBottomDialog this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.getMPlayer().r();
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f11689e;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void d() {
        z.a(this, R$layout.dialog_introduce_with_video, true);
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog e(boolean z10) {
        this.f11687c = z10;
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog f(@Nullable final Function0<kotlin.p> function0) {
        int i10 = R$id.dialog_bottom_intro_close;
        ((ImageView) b(i10)).setVisibility(0);
        ImageView dialog_bottom_intro_close = (ImageView) b(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_intro_close, "dialog_bottom_intro_close");
        y.d(dialog_bottom_intro_close, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKIntroduceWithVideoBottomDialog$setCloseIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = FKIntroduceWithVideoBottomDialog.this.f11686b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                Function0<kotlin.p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog h(@StringRes int i10) {
        int i11 = R$id.dialog_bottom_intro_desc;
        ((TextView) b(i11)).setVisibility(0);
        ((TextView) b(i11)).setText(getContext().getString(i10));
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog i(@StringRes int i10, @Nullable final Function0<kotlin.p> function0) {
        TextView secondaryBtn = (TextView) b(R$id.horizontal_secondary_button);
        secondaryBtn.setVisibility(0);
        secondaryBtn.setText(getContext().getString(i10));
        kotlin.jvm.internal.s.h(secondaryBtn, "secondaryBtn");
        y.d(secondaryBtn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKIntroduceWithVideoBottomDialog$setNegativeButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                Function0<kotlin.p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                alertDialog = this.f11686b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog j(@StringRes int i10, @Nullable final Function0<kotlin.p> function0) {
        int i11 = R$id.horizontal_main_button;
        ((TextView) b(i11)).setVisibility(0);
        ((TextView) b(i11)).setText(getContext().getString(i10));
        TextView horizontal_main_button = (TextView) b(i11);
        kotlin.jvm.internal.s.h(horizontal_main_button, "horizontal_main_button");
        y.d(horizontal_main_button, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKIntroduceWithVideoBottomDialog$setPositiveButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                Function0<kotlin.p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                alertDialog = this.f11686b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog l(@NotNull String fileName, @Nullable Integer num) {
        kotlin.jvm.internal.s.i(fileName, "fileName");
        int i10 = R$id.dialog_bottom_rounded_frame_layout;
        ((RoundedFrameLayout) b(i10)).setCornerRadius(z0.h.c(this, 16.0f));
        int i11 = R$id.dialog_bottom_intro_player;
        ((FrameLayout) b(i11)).removeAllViews();
        ((FrameLayout) b(i11)).setVisibility(8);
        b(R$id.cover_image).setVisibility(8);
        int i12 = R$id.dialog_bottom_svga;
        ((FKSVGAImageView) b(i12)).setVisibility(0);
        if (num != null) {
            TextView dialog_bottom_intro_title = (TextView) b(R$id.dialog_bottom_intro_title);
            kotlin.jvm.internal.s.h(dialog_bottom_intro_title, "dialog_bottom_intro_title");
            y.g(dialog_bottom_intro_title, null, num, null, null, 13, null);
            RoundedFrameLayout dialog_bottom_rounded_frame_layout = (RoundedFrameLayout) b(i10);
            kotlin.jvm.internal.s.h(dialog_bottom_rounded_frame_layout, "dialog_bottom_rounded_frame_layout");
            y.o(dialog_bottom_rounded_frame_layout, null, num, 1, null);
        }
        TextView dialog_bottom_intro_title2 = (TextView) b(R$id.dialog_bottom_intro_title);
        kotlin.jvm.internal.s.h(dialog_bottom_intro_title2, "dialog_bottom_intro_title");
        y.g(dialog_bottom_intro_title2, null, num, null, null, 13, null);
        FKSVGAImageView dialog_bottom_svga = (FKSVGAImageView) b(i12);
        kotlin.jvm.internal.s.h(dialog_bottom_svga, "dialog_bottom_svga");
        FKSVGAImageView.F(dialog_bottom_svga, fileName, null, null, 6, null);
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog n(@StringRes int i10) {
        int i11 = R$id.dialog_bottom_intro_title;
        ((TextView) b(i11)).setVisibility(0);
        ((TextView) b(i11)).setText(getContext().getString(i10));
        TextView dialog_bottom_intro_title = (TextView) b(i11);
        kotlin.jvm.internal.s.h(dialog_bottom_intro_title, "dialog_bottom_intro_title");
        u.a(dialog_bottom_intro_title);
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog o(@NotNull String title) {
        kotlin.jvm.internal.s.i(title, "title");
        int i10 = R$id.dialog_bottom_intro_title;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(title);
        TextView dialog_bottom_intro_title = (TextView) b(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_intro_title, "dialog_bottom_intro_title");
        u.a(dialog_bottom_intro_title);
        return this;
    }

    @NotNull
    public final FKIntroduceWithVideoBottomDialog p(@NotNull String fileAbsolutePath) {
        kotlin.jvm.internal.s.i(fileAbsolutePath, "fileAbsolutePath");
        ((FKSVGAImageView) b(R$id.dialog_bottom_svga)).setVisibility(8);
        int i10 = R$id.dialog_bottom_intro_player;
        ((FrameLayout) b(i10)).removeAllViews();
        b(R$id.cover_image).setVisibility(0);
        getMPlayer().e(new b());
        BaseExoMediaPlayer.q(getMPlayer(), fileAbsolutePath, false, null, false, 14, null);
        ((FrameLayout) b(i10)).addView(getMPlayer().k(true));
        return this;
    }

    public final void q() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11686b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f11687c);
        }
        AlertDialog alertDialog = this.f11686b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11686b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        AlertDialog alertDialog3 = this.f11686b;
        if (alertDialog3 != null) {
            alertDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.appdialog.layout.j
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKIntroduceWithVideoBottomDialog.r(FKIntroduceWithVideoBottomDialog.this, dialogInterface);
                }
            });
        }
    }
}
