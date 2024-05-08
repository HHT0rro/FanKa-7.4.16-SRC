package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FunctionGuideWithImgDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FunctionGuideWithImgDialog extends FrameLayout {

    /* renamed from: e */
    @NotNull
    public static final a f11698e = new a(null);

    /* renamed from: b */
    @Nullable
    public AlertDialog f11699b;

    /* renamed from: c */
    public boolean f11700c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f11701d;

    /* compiled from: FunctionGuideWithImgDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FunctionGuideWithImgDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FunctionGuideWithImgDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionGuideWithImgDialog(Context context) {
        super(context);
        this.f11701d = new LinkedHashMap();
        this.f11700c = true;
        c();
    }

    public /* synthetic */ FunctionGuideWithImgDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FunctionGuideWithImgDialog e(FunctionGuideWithImgDialog functionGuideWithImgDialog, int i10, int i11, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = R$string.go_to_try;
        }
        if ((i12 & 2) != 0) {
            i11 = R$drawable.shape_heart_btn;
        }
        if ((i12 & 4) != 0) {
            function0 = null;
        }
        return functionGuideWithImgDialog.d(i10, i11, function0);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f11701d;
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

    public final void c() {
        z.a(this, R$layout.dialog_svip_funtion, true);
        ((RoundedFrameLayout) a(R$id.svip_guide_root)).setCornerRadius(z0.h.c(this, 16.0f), 0.0f, z0.h.c(this, 16.0f), 0.0f);
    }

    @NotNull
    public final FunctionGuideWithImgDialog d(@StringRes int i10, int i11, @Nullable final Function0<kotlin.p> function0) {
        int i12 = R$id.ssvip_function_btn;
        ((TextView) a(i12)).setText(getContext().getString(i10));
        ((TextView) a(i12)).setBackgroundResource(i11);
        TextView ssvip_function_btn = (TextView) a(i12);
        kotlin.jvm.internal.s.h(ssvip_function_btn, "ssvip_function_btn");
        y.d(ssvip_function_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FunctionGuideWithImgDialog$setButton$1
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
                alertDialog = this.f11699b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FunctionGuideWithImgDialog f(@Nullable final Function0<kotlin.p> function0) {
        int i10 = R$id.dialog_bottom_function_close;
        ((ImageView) a(i10)).setVisibility(0);
        ImageView dialog_bottom_function_close = (ImageView) a(i10);
        kotlin.jvm.internal.s.h(dialog_bottom_function_close, "dialog_bottom_function_close");
        y.d(dialog_bottom_function_close, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FunctionGuideWithImgDialog$setCloseIcon$1
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
                alertDialog = FunctionGuideWithImgDialog.this.f11699b;
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
    public final FunctionGuideWithImgDialog g(@NotNull String content) {
        kotlin.jvm.internal.s.i(content, "content");
        ((TextView) a(R$id.svip_guide_content)).setText(content);
        return this;
    }

    @NotNull
    public final FunctionGuideWithImgDialog h(int i10) {
        ((ImageView) a(R$id.dialog_bottom_image)).setImageResource(i10);
        return this;
    }

    @NotNull
    public final FunctionGuideWithImgDialog i(@NotNull String title) {
        kotlin.jvm.internal.s.i(title, "title");
        ((TextView) a(R$id.svip_guide_title)).setText(title);
        return this;
    }

    public final void j() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11699b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f11700c);
        }
        AlertDialog alertDialog = this.f11699b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11699b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(80);
    }
}
