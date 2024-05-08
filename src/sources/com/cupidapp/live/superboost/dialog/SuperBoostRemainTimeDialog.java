package com.cupidapp.live.superboost.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import j1.i;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.z;

/* compiled from: SuperBoostRemainTimeDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostRemainTimeDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18585d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f18586b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18587c;

    /* compiled from: SuperBoostRemainTimeDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SuperBoostRemainTimeDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new SuperBoostRemainTimeDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostRemainTimeDialog(Context context) {
        super(context);
        this.f18587c = new LinkedHashMap();
        d();
    }

    public /* synthetic */ SuperBoostRemainTimeDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18587c;
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

    public final void c(@NotNull String time) {
        TextView textView;
        s.i(time, "time");
        AlertDialog alertDialog = this.f18586b;
        if (!(alertDialog != null && alertDialog.isShowing()) || (textView = (TextView) a(R$id.boost_remain_time)) == null) {
            return;
        }
        y yVar = y.f51038a;
        String string = getContext().getString(R$string.remain_time);
        s.h(string, "context.getString(R.string.remain_time)");
        String format = String.format(string, Arrays.copyOf(new Object[]{time}, 1));
        s.h(format, "format(format, *args)");
        textView.setText(format);
    }

    public final void d() {
        z.a(this, R$layout.dialog_boost_remain, true);
        FKUniversalButton i_know_btn = (FKUniversalButton) a(R$id.i_know_btn);
        s.h(i_know_btn, "i_know_btn");
        z0.y.d(i_know_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostRemainTimeDialog$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = SuperBoostRemainTimeDialog.this.f18586b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void e() {
        Window window;
        if (this.f18586b == null) {
            this.f18586b = b.f54812a.e(getContext()).setView(this).create();
        }
        AlertDialog alertDialog = this.f18586b;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = this.f18586b;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f18586b;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(17);
        }
        FKSVGAImageView boost_svga = (FKSVGAImageView) a(R$id.boost_svga);
        s.h(boost_svga, "boost_svga");
        FKSVGAImageView.F(boost_svga, "popup_superboost.svga", null, null, 6, null);
        i.g(i.f50236a, PopupName.SUPER_EXPOSURE_PROCESSING, SensorPosition.Match, null, 4, null);
    }
}
