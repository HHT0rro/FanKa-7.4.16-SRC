package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.ForceUpdateModel;
import com.cupidapp.live.appdialog.model.ShowForceUpdateType;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import e1.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKForceUpdateLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKForceUpdateLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public AlertDialog f11671d;

    /* renamed from: e, reason: collision with root package name */
    public ForceUpdateModel f11672e;

    /* renamed from: f, reason: collision with root package name */
    public SensorPosition f11673f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11674g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKForceUpdateLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11674g = new LinkedHashMap();
        p();
    }

    public static final void s(ForceUpdateModel model, FKForceUpdateLayout this$0, SensorPosition position, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(model, "$model");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(position, "$position");
        Disposable disposed = a.C0726a.c(NetworkClient.f11868a.i(), model.getScene(), WindowType.ForceUpdate.getType(), null, null, null, null, null, Long.valueOf(model.getRuleId()), null, null, MetricsProto.MetricsEvent.ACTION_APPOP_GRANT_WRITE_SETTINGS, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKForceUpdateLayout$showForceUpdateDialog$lambda$1$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this$0)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            this$0.H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        j1.i.g(j1.i.f50236a, this$0.o(model.getShowType()), position, null, 4, null);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f11674g;
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

    public final void l() {
        FKUniversalButton updateButton = (FKUniversalButton) f(R$id.updateButton);
        kotlin.jvm.internal.s.h(updateButton, "updateButton");
        y.d(updateButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKForceUpdateLayout$bindClickEvent$1
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
                ForceUpdateModel forceUpdateModel;
                PopupName o10;
                SensorPosition sensorPosition;
                FKForceUpdateLayout.this.q();
                j1.i iVar = j1.i.f50236a;
                FKForceUpdateLayout fKForceUpdateLayout = FKForceUpdateLayout.this;
                forceUpdateModel = fKForceUpdateLayout.f11672e;
                SensorPosition sensorPosition2 = null;
                if (forceUpdateModel == null) {
                    kotlin.jvm.internal.s.A("updateModel");
                    forceUpdateModel = null;
                }
                o10 = fKForceUpdateLayout.o(forceUpdateModel.getShowType());
                PopupButtonName popupButtonName = PopupButtonName.UpdateImmediately;
                sensorPosition = FKForceUpdateLayout.this.f11673f;
                if (sensorPosition == null) {
                    kotlin.jvm.internal.s.A("sensorPosition");
                } else {
                    sensorPosition2 = sensorPosition;
                }
                iVar.a(o10, popupButtonName, sensorPosition2);
            }
        });
        TextView notYetUpdateButton = (TextView) f(R$id.notYetUpdateButton);
        kotlin.jvm.internal.s.h(notYetUpdateButton, "notYetUpdateButton");
        y.d(notYetUpdateButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKForceUpdateLayout$bindClickEvent$2
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
                ForceUpdateModel forceUpdateModel;
                PopupName o10;
                SensorPosition sensorPosition;
                alertDialog = FKForceUpdateLayout.this.f11671d;
                SensorPosition sensorPosition2 = null;
                if (alertDialog == null) {
                    kotlin.jvm.internal.s.A("dialog");
                    alertDialog = null;
                }
                alertDialog.dismiss();
                j1.i iVar = j1.i.f50236a;
                FKForceUpdateLayout fKForceUpdateLayout = FKForceUpdateLayout.this;
                forceUpdateModel = fKForceUpdateLayout.f11672e;
                if (forceUpdateModel == null) {
                    kotlin.jvm.internal.s.A("updateModel");
                    forceUpdateModel = null;
                }
                o10 = fKForceUpdateLayout.o(forceUpdateModel.getShowType());
                PopupButtonName popupButtonName = PopupButtonName.NotYetUpdate;
                sensorPosition = FKForceUpdateLayout.this.f11673f;
                if (sensorPosition == null) {
                    kotlin.jvm.internal.s.A("sensorPosition");
                } else {
                    sensorPosition2 = sensorPosition;
                }
                iVar.a(o10, popupButtonName, sensorPosition2);
            }
        });
    }

    public final void m(ForceUpdateModel forceUpdateModel) {
        ((TextView) f(R$id.forceUpdateTitle)).setText(forceUpdateModel.getTitle());
        ((TextView) f(R$id.forceUpdateContent)).setText(forceUpdateModel.getContent());
        ((FKUniversalButton) f(R$id.updateButton)).setText(forceUpdateModel.getBtnText());
        TextView textView = (TextView) f(R$id.notYetUpdateButton);
        String showType = forceUpdateModel.getShowType();
        int i10 = 8;
        if (kotlin.jvm.internal.s.d(showType, ShowForceUpdateType.Notify.getType())) {
            i10 = 0;
        } else {
            kotlin.jvm.internal.s.d(showType, ShowForceUpdateType.Force.getType());
        }
        textView.setVisibility(i10);
    }

    public final PopupName o(String str) {
        if (kotlin.jvm.internal.s.d(str, ShowForceUpdateType.Notify.getType())) {
            return PopupName.VersionUpdatePrompt;
        }
        return PopupName.ForceUpdate;
    }

    public final void p() {
        z.a(this, R$layout.layout_force_update, true);
        ((TextView) f(R$id.forceUpdateTitle)).getPaint().setFakeBoldText(true);
        ((TextView) f(R$id.notYetUpdateButton)).getPaint().setFakeBoldText(true);
        l();
    }

    public final void q() {
        m1.a aVar = m1.a.f51796a;
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        if (aVar.a(context)) {
            Context context2 = getContext();
            kotlin.jvm.internal.s.h(context2, "context");
            aVar.b(context2, new Function0<kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKForceUpdateLayout$jumpToAppStoreToDownload$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ForceUpdateModel forceUpdateModel;
                    j.a aVar2 = com.cupidapp.live.base.router.j.f12156c;
                    Context context3 = FKForceUpdateLayout.this.getContext();
                    forceUpdateModel = FKForceUpdateLayout.this.f11672e;
                    if (forceUpdateModel == null) {
                        kotlin.jvm.internal.s.A("updateModel");
                        forceUpdateModel = null;
                    }
                    j.a.b(aVar2, context3, forceUpdateModel.getUrl(), null, 4, null);
                }
            });
        } else {
            ForceUpdateModel forceUpdateModel = this.f11672e;
            if (forceUpdateModel == null) {
                kotlin.jvm.internal.s.A("updateModel");
                forceUpdateModel = null;
            }
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(forceUpdateModel.getUrl())));
        }
    }

    public final void r(@NotNull final ForceUpdateModel model, @NotNull final SensorPosition position) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(position, "position");
        this.f11672e = model;
        this.f11673f = position;
        m(model);
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        kotlin.jvm.internal.s.h(create, "AlertDialogExtension.cre…is)\n            .create()");
        this.f11671d = create;
        AlertDialog alertDialog = null;
        if (create == null) {
            kotlin.jvm.internal.s.A("dialog");
            create = null;
        }
        create.setCanceledOnTouchOutside(false);
        AlertDialog alertDialog2 = this.f11671d;
        if (alertDialog2 == null) {
            kotlin.jvm.internal.s.A("dialog");
            alertDialog2 = null;
        }
        alertDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FKForceUpdateLayout.s(ForceUpdateModel.this, this, position, dialogInterface);
            }
        });
        AlertDialog alertDialog3 = this.f11671d;
        if (alertDialog3 == null) {
            kotlin.jvm.internal.s.A("dialog");
            alertDialog3 = null;
        }
        alertDialog3.show();
        AlertDialog alertDialog4 = this.f11671d;
        if (alertDialog4 == null) {
            kotlin.jvm.internal.s.A("dialog");
        } else {
            alertDialog = alertDialog4;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKForceUpdateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11674g = new LinkedHashMap();
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKForceUpdateLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11674g = new LinkedHashMap();
        p();
    }
}
