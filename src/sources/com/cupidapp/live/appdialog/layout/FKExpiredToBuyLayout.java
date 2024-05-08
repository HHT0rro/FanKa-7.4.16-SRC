package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.ExpiredDialogModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKExpiredToBuyLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKExpiredToBuyLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public AlertDialog f11662d;

    /* renamed from: e, reason: collision with root package name */
    public ExpiredDialogModel f11663e;

    /* renamed from: f, reason: collision with root package name */
    public SensorPosition f11664f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11665g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKExpiredToBuyLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11665g = new LinkedHashMap();
        j();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f11665g;
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

    public final void i() {
        TextView confirm_txt = (TextView) e(R$id.confirm_txt);
        kotlin.jvm.internal.s.h(confirm_txt, "confirm_txt");
        y.d(confirm_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKExpiredToBuyLayout$bindClickEvent$1
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
                ExpiredDialogModel expiredDialogModel;
                SensorPosition sensorPosition;
                alertDialog = FKExpiredToBuyLayout.this.f11662d;
                SensorPosition sensorPosition2 = null;
                if (alertDialog == null) {
                    kotlin.jvm.internal.s.A("dialog");
                    alertDialog = null;
                }
                alertDialog.dismiss();
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = FKExpiredToBuyLayout.this.getContext();
                expiredDialogModel = FKExpiredToBuyLayout.this.f11663e;
                if (expiredDialogModel == null) {
                    kotlin.jvm.internal.s.A("expiredModel");
                    expiredDialogModel = null;
                }
                j.a.b(aVar, context, expiredDialogModel.getUrl(), null, 4, null);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.HIDE_DISTANCE_EXPIRE;
                PopupButtonName popupButtonName = PopupButtonName.Upload;
                sensorPosition = FKExpiredToBuyLayout.this.f11664f;
                if (sensorPosition == null) {
                    kotlin.jvm.internal.s.A("sensorPosition");
                } else {
                    sensorPosition2 = sensorPosition;
                }
                iVar.a(popupName, popupButtonName, sensorPosition2);
            }
        });
        TextView cancel_txt = (TextView) e(R$id.cancel_txt);
        kotlin.jvm.internal.s.h(cancel_txt, "cancel_txt");
        y.d(cancel_txt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKExpiredToBuyLayout$bindClickEvent$2
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
                SensorPosition sensorPosition;
                alertDialog = FKExpiredToBuyLayout.this.f11662d;
                SensorPosition sensorPosition2 = null;
                if (alertDialog == null) {
                    kotlin.jvm.internal.s.A("dialog");
                    alertDialog = null;
                }
                alertDialog.dismiss();
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.HIDE_DISTANCE_EXPIRE;
                PopupButtonName popupButtonName = PopupButtonName.Close;
                sensorPosition = FKExpiredToBuyLayout.this.f11664f;
                if (sensorPosition == null) {
                    kotlin.jvm.internal.s.A("sensorPosition");
                } else {
                    sensorPosition2 = sensorPosition;
                }
                iVar.a(popupName, popupButtonName, sensorPosition2);
            }
        });
    }

    public final void j() {
        z.a(this, R$layout.dialog_notitle_base_view, true);
        ((TextView) e(R$id.confirm_txt)).setText(R$string.confirm_to_update);
        i();
    }

    public final void k(@NotNull ExpiredDialogModel model, @NotNull SensorPosition position) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(position, "position");
        this.f11663e = model;
        this.f11664f = position;
        ((TextView) e(R$id.content_txt)).setText(model.getContent());
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        kotlin.jvm.internal.s.h(create, "AlertDialogExtension.cre…is)\n            .create()");
        this.f11662d = create;
        AlertDialog alertDialog = null;
        if (create == null) {
            kotlin.jvm.internal.s.A("dialog");
            create = null;
        }
        create.setCanceledOnTouchOutside(false);
        AlertDialog alertDialog2 = this.f11662d;
        if (alertDialog2 == null) {
            kotlin.jvm.internal.s.A("dialog");
            alertDialog2 = null;
        }
        alertDialog2.show();
        AlertDialog alertDialog3 = this.f11662d;
        if (alertDialog3 == null) {
            kotlin.jvm.internal.s.A("dialog");
        } else {
            alertDialog = alertDialog3;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(z0.h.c(window, 300.0f), -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.HIDE_DISTANCE_EXPIRE, position, null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKExpiredToBuyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11665g = new LinkedHashMap();
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKExpiredToBuyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11665g = new LinkedHashMap();
        j();
    }
}
