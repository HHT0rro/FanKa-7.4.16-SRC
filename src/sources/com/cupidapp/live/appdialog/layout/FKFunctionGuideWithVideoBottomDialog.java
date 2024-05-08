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
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
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

/* compiled from: FKFunctionGuideWithVideoBottomDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFunctionGuideWithVideoBottomDialog extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f11675e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f11676b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11677c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11678d;

    /* compiled from: FKFunctionGuideWithVideoBottomDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKFunctionGuideWithVideoBottomDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKFunctionGuideWithVideoBottomDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFunctionGuideWithVideoBottomDialog(Context context) {
        super(context);
        this.f11678d = new LinkedHashMap();
        this.f11677c = true;
        d();
    }

    public /* synthetic */ FKFunctionGuideWithVideoBottomDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final void k(FKFunctionGuideWithVideoBottomDialog this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) this$0.b(R$id.dialog_bottom_svga);
        if (fKSVGAImageView != null) {
            fKSVGAImageView.K();
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f11678d;
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
        z.a(this, R$layout.dialog_funtion_with_video, true);
    }

    @NotNull
    public final FKFunctionGuideWithVideoBottomDialog e(@Nullable final Function0<kotlin.p> function0) {
        int i10 = R$id.dialog_bottom_function_close;
        ((ImageView) b(i10)).setVisibility(0);
        ImageView dialog_bottom_function_close = (ImageView) b(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_function_close, "dialog_bottom_function_close");
        y.d(dialog_bottom_function_close, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFunctionGuideWithVideoBottomDialog$setCloseIcon$1
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
                alertDialog = FKFunctionGuideWithVideoBottomDialog.this.f11676b;
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
    public final FKFunctionGuideWithVideoBottomDialog f(@NotNull String des) {
        kotlin.jvm.internal.s.i(des, "des");
        int i10 = R$id.dialog_bottom_function_desc;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(des);
        return this;
    }

    @NotNull
    public final FKFunctionGuideWithVideoBottomDialog g(@StringRes int i10, @Nullable final Function0<kotlin.p> function0) {
        int i11 = R$id.function_btn;
        ((FKUniversalButton) b(i11)).setVisibility(0);
        ((FKUniversalButton) b(i11)).setText(getContext().getString(i10));
        FKUniversalButton function_btn = (FKUniversalButton) b(i11);
        kotlin.jvm.internal.s.h(function_btn, "function_btn");
        y.d(function_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFunctionGuideWithVideoBottomDialog$setPositiveButton$1
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
                alertDialog = this.f11676b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKFunctionGuideWithVideoBottomDialog h(@NotNull String fileName, @Nullable Integer num) {
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
    public final FKFunctionGuideWithVideoBottomDialog i(@NotNull String title) {
        kotlin.jvm.internal.s.i(title, "title");
        int i10 = R$id.dialog_bottom_function_title;
        ((TextView) b(i10)).setVisibility(0);
        ((TextView) b(i10)).setText(title);
        TextView dialog_bottom_function_title = (TextView) b(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_function_title, "dialog_bottom_function_title");
        u.a(dialog_bottom_function_title);
        return this;
    }

    public final void j() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11676b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f11677c);
        }
        AlertDialog alertDialog = this.f11676b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11676b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        AlertDialog alertDialog3 = this.f11676b;
        if (alertDialog3 != null) {
            alertDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.appdialog.layout.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKFunctionGuideWithVideoBottomDialog.k(FKFunctionGuideWithVideoBottomDialog.this, dialogInterface);
                }
            });
        }
    }
}
