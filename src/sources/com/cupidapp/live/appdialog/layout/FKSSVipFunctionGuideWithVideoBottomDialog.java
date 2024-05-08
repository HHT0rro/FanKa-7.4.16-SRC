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
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKSSVipFunctionGuideWithVideoBottomDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSSVipFunctionGuideWithVideoBottomDialog extends FrameLayout {

    /* renamed from: e */
    @NotNull
    public static final a f11694e = new a(null);

    /* renamed from: b */
    @Nullable
    public AlertDialog f11695b;

    /* renamed from: c */
    public boolean f11696c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f11697d;

    /* compiled from: FKSSVipFunctionGuideWithVideoBottomDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKSSVipFunctionGuideWithVideoBottomDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKSSVipFunctionGuideWithVideoBottomDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSSVipFunctionGuideWithVideoBottomDialog(Context context) {
        super(context);
        this.f11697d = new LinkedHashMap();
        this.f11696c = true;
        e();
    }

    public /* synthetic */ FKSSVipFunctionGuideWithVideoBottomDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKSSVipFunctionGuideWithVideoBottomDialog j(FKSSVipFunctionGuideWithVideoBottomDialog fKSSVipFunctionGuideWithVideoBottomDialog, int i10, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = R$string.goto_setting;
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        return fKSSVipFunctionGuideWithVideoBottomDialog.i(i10, function0);
    }

    public static final void n(FKSSVipFunctionGuideWithVideoBottomDialog this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) this$0.b(R$id.dialog_bottom_svga);
        if (fKSVGAImageView != null) {
            fKSVGAImageView.K();
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f11697d;
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

    @NotNull
    public final FKSSVipFunctionGuideWithVideoBottomDialog d(boolean z10) {
        if (z10) {
            TextView dialog_bottom_function_title = (TextView) b(R$id.dialog_bottom_function_title);
            kotlin.jvm.internal.s.h(dialog_bottom_function_title, "dialog_bottom_function_title");
            u.e(dialog_bottom_function_title, 0, 0, R$mipmap.rainbow_aplus_logo_big, 0, 11, null);
        } else {
            TextView dialog_bottom_function_title2 = (TextView) b(R$id.dialog_bottom_function_title);
            kotlin.jvm.internal.s.h(dialog_bottom_function_title2, "dialog_bottom_function_title");
            u.e(dialog_bottom_function_title2, 0, 0, 0, 0, 11, null);
        }
        return this;
    }

    public final void e() {
        z.a(this, R$layout.dialog_ssvip_funtion_with_video, true);
    }

    @NotNull
    public final FKSSVipFunctionGuideWithVideoBottomDialog f(boolean z10) {
        this.f11696c = z10;
        return this;
    }

    @NotNull
    public final FKSSVipFunctionGuideWithVideoBottomDialog g(@Nullable final Function0<kotlin.p> function0) {
        int i10 = R$id.dialog_bottom_function_close;
        ((ImageView) b(i10)).setVisibility(0);
        ImageView dialog_bottom_function_close = (ImageView) b(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_function_close, "dialog_bottom_function_close");
        y.d(dialog_bottom_function_close, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKSSVipFunctionGuideWithVideoBottomDialog$setCloseIcon$1
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
                alertDialog = FKSSVipFunctionGuideWithVideoBottomDialog.this.f11695b;
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
    public final FKSSVipFunctionGuideWithVideoBottomDialog h(@StringRes int i10) {
        int i11 = R$id.dialog_bottom_function_desc;
        ((TextView) b(i11)).setVisibility(0);
        ((TextView) b(i11)).setText(getContext().getString(i10));
        return this;
    }

    @NotNull
    public final FKSSVipFunctionGuideWithVideoBottomDialog i(@StringRes int i10, @Nullable final Function0<kotlin.p> function0) {
        int i11 = R$id.ssvip_function_btn;
        ((TextView) b(i11)).setVisibility(0);
        ((TextView) b(i11)).setText(getContext().getString(i10));
        TextView ssvip_function_btn = (TextView) b(i11);
        kotlin.jvm.internal.s.h(ssvip_function_btn, "ssvip_function_btn");
        y.d(ssvip_function_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKSSVipFunctionGuideWithVideoBottomDialog$setPositiveButton$1
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
                alertDialog = this.f11695b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKSSVipFunctionGuideWithVideoBottomDialog k(@NotNull String fileName, @Nullable Integer num) {
        kotlin.jvm.internal.s.i(fileName, "fileName");
        int i10 = R$id.dialog_bottom_rounded_frame_layout;
        ((RoundedFrameLayout) b(i10)).setCornerRadius(z0.h.c(this, 16.0f));
        int i11 = R$id.dialog_bottom_svga;
        ((FKSVGAImageView) b(i11)).setVisibility(0);
        if (num != null) {
            TextView dialog_bottom_function_title = (TextView) b(R$id.dialog_bottom_function_title);
            kotlin.jvm.internal.s.h(dialog_bottom_function_title, "dialog_bottom_function_title");
            y.g(dialog_bottom_function_title, null, num, null, null, 13, null);
            RoundedFrameLayout dialog_bottom_rounded_frame_layout = (RoundedFrameLayout) b(i10);
            kotlin.jvm.internal.s.h(dialog_bottom_rounded_frame_layout, "dialog_bottom_rounded_frame_layout");
            y.o(dialog_bottom_rounded_frame_layout, null, num, 1, null);
        }
        TextView dialog_bottom_function_title2 = (TextView) b(R$id.dialog_bottom_function_title);
        kotlin.jvm.internal.s.h(dialog_bottom_function_title2, "dialog_bottom_function_title");
        y.g(dialog_bottom_function_title2, null, num, null, null, 13, null);
        FKSVGAImageView dialog_bottom_svga = (FKSVGAImageView) b(i11);
        kotlin.jvm.internal.s.h(dialog_bottom_svga, "dialog_bottom_svga");
        FKSVGAImageView.F(dialog_bottom_svga, fileName, null, null, 6, null);
        return this;
    }

    @NotNull
    public final FKSSVipFunctionGuideWithVideoBottomDialog l(@NotNull String title) {
        kotlin.jvm.internal.s.i(title, "title");
        int i10 = R$id.dialog_bottom_function_title;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(title);
        TextView dialog_bottom_function_title = (TextView) b(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_function_title, "dialog_bottom_function_title");
        u.a(dialog_bottom_function_title);
        return this;
    }

    public final void m() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11695b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f11696c);
        }
        AlertDialog alertDialog = this.f11695b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11695b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        AlertDialog alertDialog3 = this.f11695b;
        if (alertDialog3 != null) {
            alertDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.appdialog.layout.k
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKSSVipFunctionGuideWithVideoBottomDialog.n(FKSSVipFunctionGuideWithVideoBottomDialog.this, dialogInterface);
                }
            });
        }
    }
}
