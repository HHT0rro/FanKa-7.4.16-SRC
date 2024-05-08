package com.cupidapp.live.setting.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import j1.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: OpenNotificationLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OpenNotificationLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18211d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static boolean f18212e;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f18213b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18214c;

    /* compiled from: OpenNotificationLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenNotificationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18214c = new LinkedHashMap();
        e();
    }

    public static final void g(DialogInterface dialogInterface) {
        f18212e = true;
    }

    public static final void h(DialogInterface dialogInterface) {
        f18212e = false;
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f18214c;
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

    public final void e() {
        z.a(this, R$layout.layout_open_notification, true);
        FKUniversalButton pushGoToOpen = (FKUniversalButton) c(R$id.pushGoToOpen);
        s.h(pushGoToOpen, "pushGoToOpen");
        y.d(pushGoToOpen, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.OpenNotificationLayout$initView$1
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
                alertDialog = OpenNotificationLayout.this.f18213b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                r0.f12373a.c(OpenNotificationLayout.this.getContext());
                i.f50236a.a(PopupName.PUSH_SYSTEM_OPT, PopupButtonName.GotoOpen, SensorPosition.Message);
            }
        });
        i.g(i.f50236a, PopupName.PUSH_SYSTEM_OPT, SensorPosition.Message, null, 4, null);
    }

    public final void f() {
        Window window;
        if (f18212e) {
            return;
        }
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f18213b = create;
        if (create != null) {
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.setting.view.b
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    OpenNotificationLayout.g(dialogInterface);
                }
            });
        }
        AlertDialog alertDialog = this.f18213b;
        if (alertDialog != null) {
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.setting.view.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    OpenNotificationLayout.h(dialogInterface);
                }
            });
        }
        AlertDialog alertDialog2 = this.f18213b;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f18213b;
        if (alertDialog3 == null || (window = alertDialog3.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenNotificationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18214c = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenNotificationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18214c = new LinkedHashMap();
        e();
    }
}
