package com.cupidapp.live.base.permission;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.y;

/* compiled from: FKRxPermissionAlertDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKRxPermissionAlertDialog {

    /* renamed from: a */
    @NotNull
    public static final Companion f12016a = new Companion(null);

    /* renamed from: b */
    @Nullable
    public static AlertDialog f12017b;

    /* renamed from: c */
    @Nullable
    public static FKPermissionLayout f12018c;

    /* compiled from: FKRxPermissionAlertDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {

        /* compiled from: FKRxPermissionAlertDialog.kt */
        @d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements b {

            /* renamed from: a */
            public final /* synthetic */ FKRxPermissionOpenModel f12019a;

            /* renamed from: b */
            public final /* synthetic */ Context f12020b;

            /* renamed from: c */
            public final /* synthetic */ xb.b f12021c;

            public a(FKRxPermissionOpenModel fKRxPermissionOpenModel, Context context, xb.b bVar) {
                this.f12019a = fKRxPermissionOpenModel;
                this.f12020b = context;
                this.f12021c = bVar;
            }

            @Override // com.cupidapp.live.base.permission.b
            public void a() {
                Function0<p> permissionSucceed = this.f12019a.getPermissionSucceed();
                if (permissionSucceed != null) {
                    permissionSucceed.invoke();
                }
            }

            @Override // com.cupidapp.live.base.permission.b
            public void b() {
                Function0<p> alertToSetting = this.f12019a.getAlertToSetting();
                if (alertToSetting != null) {
                    alertToSetting.invoke();
                }
            }

            @Override // com.cupidapp.live.base.permission.b
            public void c() {
                if (this.f12019a.getOverridePermissionCancel()) {
                    Function0<p> permissionCancel = this.f12019a.getPermissionCancel();
                    if (permissionCancel != null) {
                        permissionCancel.invoke();
                        return;
                    }
                    return;
                }
                this.f12019a.setReply(true);
                FKRxPermissionAlertDialog.f12016a.h(this.f12020b, this.f12021c, this.f12019a);
            }

            @Override // com.cupidapp.live.base.permission.b
            public void d() {
                Function0<p> alertCancel = this.f12019a.getAlertCancel();
                if (alertCancel != null) {
                    alertCancel.invoke();
                }
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(Companion companion, Context context, Function0 function0, Function0 function02, Function0 function03, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                function0 = null;
            }
            if ((i10 & 4) != 0) {
                function02 = null;
            }
            if ((i10 & 8) != 0) {
                function03 = null;
            }
            companion.b(context, function0, function02, function03);
        }

        public static /* synthetic */ void n(Companion companion, Context context, xb.b bVar, Function0 function0, Function0 function02, Function0 function03, int i10, int i11, Object obj) {
            companion.m(context, bVar, (i11 & 4) != 0 ? null : function0, (i11 & 8) != 0 ? null : function02, (i11 & 16) != 0 ? null : function03, (i11 & 32) != 0 ? R$string.need_access_media_upload_better : i10);
        }

        public final void b(Context context, final Function0<p> function0, final Function0<p> function02, final Function0<p> function03) {
            Window window;
            Window window2;
            Window window3;
            TextView textView;
            Button button;
            Button button2;
            d();
            AlertDialog.Builder e2 = z0.b.f54812a.e(context);
            FKRxPermissionAlertDialog.f12018c = new FKPermissionLayout(context);
            FKPermissionLayout fKPermissionLayout = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout != null && (button2 = (Button) fKPermissionLayout.a(R$id.alertFirstButton)) != null) {
                y.d(button2, new Function1<View, p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$alertDialogBindClick$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AlertDialog alertDialog = FKRxPermissionAlertDialog.f12017b;
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                        FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
                        FKRxPermissionAlertDialog.f12018c = null;
                        Function0<p> function04 = function0;
                        if (function04 != null) {
                            function04.invoke();
                        }
                    }
                });
            }
            FKPermissionLayout fKPermissionLayout2 = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout2 != null && (button = (Button) fKPermissionLayout2.a(R$id.alertSecondButton)) != null) {
                y.d(button, new Function1<View, p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$alertDialogBindClick$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AlertDialog alertDialog = FKRxPermissionAlertDialog.f12017b;
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                        FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
                        FKRxPermissionAlertDialog.f12018c = null;
                        Function0<p> function04 = function02;
                        if (function04 != null) {
                            function04.invoke();
                        }
                    }
                });
            }
            FKPermissionLayout fKPermissionLayout3 = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout3 != null && (textView = (TextView) fKPermissionLayout3.a(R$id.alertIgnoreButton)) != null) {
                y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$alertDialogBindClick$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        AlertDialog alertDialog = FKRxPermissionAlertDialog.f12017b;
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                        FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
                        FKRxPermissionAlertDialog.f12018c = null;
                        Function0<p> function04 = function03;
                        if (function04 != null) {
                            function04.invoke();
                        }
                    }
                });
            }
            e2.setView(FKRxPermissionAlertDialog.f12018c);
            FKRxPermissionAlertDialog.f12017b = e2.create();
            AlertDialog alertDialog = FKRxPermissionAlertDialog.f12017b;
            if (alertDialog != null) {
                alertDialog.setCanceledOnTouchOutside(false);
            }
            AlertDialog alertDialog2 = FKRxPermissionAlertDialog.f12017b;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            AlertDialog alertDialog3 = FKRxPermissionAlertDialog.f12017b;
            if (alertDialog3 != null && (window3 = alertDialog3.getWindow()) != null) {
                window3.setBackgroundDrawableResource(R$drawable.shape_white_bg_thirty_corners);
            }
            AlertDialog alertDialog4 = FKRxPermissionAlertDialog.f12017b;
            if (alertDialog4 != null && (window2 = alertDialog4.getWindow()) != null) {
                window2.setWindowAnimations(R$style.dialog_no_animation);
            }
            AlertDialog alertDialog5 = FKRxPermissionAlertDialog.f12017b;
            WindowManager.LayoutParams attributes = (alertDialog5 == null || (window = alertDialog5.getWindow()) == null) ? null : window.getAttributes();
            if (attributes != null) {
                attributes.width = h.c(this, 300.0f);
            }
            AlertDialog alertDialog6 = FKRxPermissionAlertDialog.f12017b;
            Window window4 = alertDialog6 != null ? alertDialog6.getWindow() : null;
            if (window4 == null) {
                return;
            }
            window4.setAttributes(attributes);
        }

        public final void d() {
            AlertDialog alertDialog = FKRxPermissionAlertDialog.f12017b;
            if (alertDialog != null && alertDialog.isShowing()) {
                try {
                    AlertDialog alertDialog2 = FKRxPermissionAlertDialog.f12017b;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            FKRxPermissionAlertDialog.f12017b = null;
            FKRxPermissionAlertDialog.f12018c = null;
        }

        public final boolean e() {
            return FKRxPermissionAlertDialog.f12018c != null;
        }

        public final boolean f() {
            AlertDialog alertDialog = FKRxPermissionAlertDialog.f12017b;
            if (alertDialog != null && alertDialog.isShowing()) {
                return true;
            }
            FKAlertDialog e2 = RxPermissionHelperKt.e();
            return e2 != null && e2.i();
        }

        public final void g(@NotNull final Context context, @NotNull final xb.b rxPermissions, @NotNull final FKRxPermissionOpenModel model) {
            s.i(context, "context");
            s.i(rxPermissions, "rxPermissions");
            s.i(model, "model");
            String string = !LocationUtils.f12270h.b(context) ? context.getString(R$string.open_the_location_service) : null;
            model.setPermissionCancel(new Function0<p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$openLocationPermissionRequestDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKRxPermissionOpenModel.this.setReply(true);
                    FKRxPermissionAlertDialog.f12016a.g(context, rxPermissions, FKRxPermissionOpenModel.this);
                }
            });
            c(this, context, new Function0<p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$openLocationPermissionRequestDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKRxPermissionAlertDialog.f12016a.l(context, rxPermissions, model);
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$openLocationPermissionRequestDialog$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                }
            }, null, 8, null);
            FKPermissionLayout fKPermissionLayout = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout != null) {
                fKPermissionLayout.setAlertText(context.getString(R$string.authorize_app_permission), context.getString(model.getRequestContent()), null, string, context.getString(R$string.skip));
            }
            FKPermissionLayout fKPermissionLayout2 = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout2 != null) {
                fKPermissionLayout2.d(PermissionType.LocationPermission, string, model.isReply());
            }
        }

        public final void h(@Nullable final Context context, @NotNull final xb.b rxPermissions, @NotNull final FKRxPermissionOpenModel model) {
            s.i(rxPermissions, "rxPermissions");
            s.i(model, "model");
            if (context == null) {
                return;
            }
            if (RxPermissionHelperKt.h(context, model.getFirstPermission()) && (model.getSecondPermission() == null || RxPermissionHelperKt.h(context, model.getSecondPermission()))) {
                Function0<p> permissionSucceed = model.getPermissionSucceed();
                if (permissionSucceed != null) {
                    permissionSucceed.invoke();
                    return;
                }
                return;
            }
            b(context, new Function0<p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$openPermissionRequestDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKRxPermissionAlertDialog.f12016a.l(context, rxPermissions, model);
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.base.permission.FKRxPermissionAlertDialog$Companion$openPermissionRequestDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKRxPermissionAlertDialog.f12016a.l(context, rxPermissions, model);
                }
            }, model.getIgnoreClick());
            FKPermissionLayout fKPermissionLayout = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout != null) {
                fKPermissionLayout.setAlertText(context.getString(R$string.authorize_app_permission), context.getString(model.getRequestContent()), null, null, model.getIgnoreContent() == null ? null : context.getString(model.getIgnoreContent().intValue()));
            }
            if (model.getOverridePermissionCancel()) {
                FKPermissionLayout fKPermissionLayout2 = FKRxPermissionAlertDialog.f12018c;
                if (fKPermissionLayout2 != null) {
                    fKPermissionLayout2.e();
                    return;
                }
                return;
            }
            FKPermissionLayout fKPermissionLayout3 = FKRxPermissionAlertDialog.f12018c;
            if (fKPermissionLayout3 != null) {
                fKPermissionLayout3.c(model.getFirstPermission(), model.getSecondPermission(), model.isReply());
            }
        }

        public final void i(@Nullable Context context, @NotNull xb.b rxPermissions, @NotNull Function0<p> permissionSucceed) {
            s.i(rxPermissions, "rxPermissions");
            s.i(permissionSucceed, "permissionSucceed");
            if (context == null) {
                return;
            }
            PermissionType permissionType = PermissionType.AudioPermission;
            FKRxPermissionOpenModel fKRxPermissionOpenModel = new FKRxPermissionOpenModel(R$string.need_ask_microphone_permission, permissionType, null, r.e(permissionType), false, permissionSucceed, null, null, null, false, null, null, 4052, null);
            g gVar = g.f52734a;
            if (s.d(gVar.h().c(), Boolean.TRUE)) {
                gVar.h().d(Boolean.FALSE);
                h(context, rxPermissions, fKRxPermissionOpenModel);
            } else {
                l(context, rxPermissions, fKRxPermissionOpenModel);
            }
        }

        public final void j(@NotNull Context context, @NotNull xb.b rxPermissions, @NotNull FKRxPermissionOpenModel model) {
            s.i(context, "context");
            s.i(rxPermissions, "rxPermissions");
            s.i(model, "model");
            g gVar = g.f52734a;
            if (s.d(gVar.F0().c(), Boolean.TRUE)) {
                gVar.F0().d(Boolean.FALSE);
                h(context, rxPermissions, model);
            } else {
                l(context, rxPermissions, model);
            }
        }

        public final void k(@Nullable Context context, @NotNull xb.b rxPermissions, @NotNull Function0<p> permissionSucceed, @NotNull Function0<p> ignoreClick, @NotNull Function0<p> permissionCancel, @NotNull Function0<p> alertCancel, @NotNull Function0<p> alertToSetting) {
            s.i(rxPermissions, "rxPermissions");
            s.i(permissionSucceed, "permissionSucceed");
            s.i(ignoreClick, "ignoreClick");
            s.i(permissionCancel, "permissionCancel");
            s.i(alertCancel, "alertCancel");
            s.i(alertToSetting, "alertToSetting");
            if (context == null) {
                return;
            }
            PermissionType permissionType = PermissionType.CameraPermission;
            FKRxPermissionOpenModel fKRxPermissionOpenModel = new FKRxPermissionOpenModel(R$string.need_ask_only_camera_permission, permissionType, null, r.e(permissionType), false, permissionSucceed, ignoreClick, permissionCancel, null, false, alertCancel, alertToSetting, 260, null);
            g gVar = g.f52734a;
            if (s.d(gVar.E0(), Boolean.TRUE)) {
                gVar.b3(Boolean.FALSE);
                h(context, rxPermissions, fKRxPermissionOpenModel);
            } else {
                l(context, rxPermissions, fKRxPermissionOpenModel);
            }
        }

        public final void l(Context context, xb.b bVar, FKRxPermissionOpenModel fKRxPermissionOpenModel) {
            RxPermissionHelperKt.m(context, bVar, fKRxPermissionOpenModel.getMustPermission(), new a(fKRxPermissionOpenModel, context, bVar), false, 16, null);
        }

        public final void m(@NotNull Context context, @NotNull xb.b rxPermissions, @Nullable Function0<p> function0, @Nullable Function0<p> function02, @Nullable Function0<p> function03, int i10) {
            s.i(context, "context");
            s.i(rxPermissions, "rxPermissions");
            PermissionType permissionType = PermissionType.StoragePermission;
            FKRxPermissionOpenModel fKRxPermissionOpenModel = new FKRxPermissionOpenModel(i10, permissionType, null, r.e(permissionType), false, function0, function03, function02, null, false, null, null, 3328, null);
            g gVar = g.f52734a;
            if (s.d(gVar.J0().c(), Boolean.TRUE)) {
                gVar.J0().d(Boolean.FALSE);
                h(context, rxPermissions, fKRxPermissionOpenModel);
            } else {
                l(context, rxPermissions, fKRxPermissionOpenModel);
            }
        }
    }
}
