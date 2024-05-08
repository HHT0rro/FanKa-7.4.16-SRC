package com.cupidapp.live.consult.helper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.model.BaseConsultLiveGrpcModel;
import com.cupidapp.live.consult.model.ConsultApplyConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultRequestConnectGrpcModel;
import com.cupidapp.live.consult.view.ConsultFloatWindowLayout;
import com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel;
import com.cupidapp.live.track.group.EnterConsultRoomSource;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import com.google.android.material.badge.BadgeDrawable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: ConsultFloatWindowHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultFloatWindowHelper implements IGrpcMessageListener {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ConsultFloatWindowHelper f13810b = new ConsultFloatWindowHelper();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static WindowManager f13811c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static ConsultFloatWindowLayout f13812d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static ConsultLiveModel f13813e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static String f13814f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static String f13815g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static com.cupidapp.live.consult.helper.a f13816h;

    /* compiled from: ConsultFloatWindowHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13817a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.NewVoiceRoomEnded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectAnchorAgree.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectApplyChange.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13817a = iArr;
        }
    }

    /* compiled from: ConsultFloatWindowHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements ConsultFloatWindowLayout.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConsultLiveModel f13818a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WindowManager.LayoutParams f13819b;

        public b(ConsultLiveModel consultLiveModel, WindowManager.LayoutParams layoutParams) {
            this.f13818a = consultLiveModel;
            this.f13819b = layoutParams;
        }

        @Override // com.cupidapp.live.consult.view.ConsultFloatWindowLayout.a
        public void a() {
            WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
            ConsultViewerActivity.f13732x.a(a10 != null ? a10.get() : null, this.f13818a.createConfig(null, EnterConsultRoomSource.ConsultWindow.getSource()));
        }

        @Override // com.cupidapp.live.consult.view.ConsultFloatWindowLayout.a
        public void b() {
            ConsultFloatWindowHelper.f13810b.i();
        }

        @Override // com.cupidapp.live.consult.view.ConsultFloatWindowLayout.a
        public void c(int i10, int i11) {
            WindowManager.LayoutParams layoutParams = this.f13819b;
            layoutParams.f816x -= i10;
            layoutParams.f817y -= i11;
            WindowManager windowManager = ConsultFloatWindowHelper.f13811c;
            if (windowManager != null) {
                windowManager.updateViewLayout(ConsultFloatWindowHelper.f13812d, this.f13819b);
            }
        }

        @Override // com.cupidapp.live.consult.view.ConsultFloatWindowLayout.a
        public void d() {
            ConsultFloatWindowHelper.f13810b.o(this.f13819b);
        }
    }

    public final void f() {
        String str = f13814f;
        if (str == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.v().g(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.helper.ConsultFloatWindowHelper$callVoiceRoomLeaveApi$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
        q();
        GrpcMessageRouter.notifyGrpc$default(GrpcMessageRouter.INSTANCE, false, null, null, 6, null);
    }

    public final boolean g(@NotNull Context context) {
        s.i(context, "context");
        return Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context);
    }

    public final void h() {
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
        WindowManager windowManager = f13811c;
        if (windowManager != null) {
            windowManager.removeViewImmediate(f13812d);
        }
        f13811c = null;
        f13812d = null;
        f13813e = null;
        f13814f = null;
        f13815g = null;
        f13816h = null;
    }

    public final void i() {
        f();
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.e();
        }
        h();
        ConsultViewerViewModel.Companion.d();
        ConsultLiveHelper.f13820a.m();
    }

    public final void j() {
        f();
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.f();
        }
        h();
        ConsultViewerViewModel.Companion.d();
        ConsultLiveHelper.f13820a.m();
    }

    @Nullable
    public final String k() {
        return f13814f;
    }

    public final int l(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return i10 >= 26 ? 2038 : 2002;
        }
        return context.getPackageManager().checkPermission("android.permission.SYSTEM_ALERT_WINDOW", context.getPackageName()) == 0 ? 2002 : 2005;
    }

    @RequiresApi(23)
    public final void m(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        try {
            activity.startActivityForResult(intent, 231031);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            com.cupidapp.live.consult.helper.a aVar = f13816h;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final void n(Context context, ConsultLiveModel consultLiveModel) {
        f13816h = null;
        Object systemService = context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        f13811c = windowManager;
        if (windowManager == null) {
            com.cupidapp.live.consult.helper.a aVar = f13816h;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        f13813e = consultLiveModel;
        f13814f = consultLiveModel.getId();
        f13815g = consultLiveModel.getCategory();
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.windowAnimations = 16973827;
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams.f816x = h.c(layoutParams, 8.0f);
        layoutParams.f817y = h.c(layoutParams, 124.0f);
        layoutParams.type = f13810b.l(context);
        layoutParams.flags = 8;
        layoutParams.format = 1;
        ConsultFloatWindowLayout consultFloatWindowLayout = new ConsultFloatWindowLayout(context);
        consultFloatWindowLayout.h(consultLiveModel);
        consultFloatWindowLayout.setOnFloatWindowClickListener(new b(consultLiveModel, layoutParams));
        f13812d = consultFloatWindowLayout;
        WindowManager windowManager2 = f13811c;
        if (windowManager2 != null) {
            windowManager2.addView(consultFloatWindowLayout, layoutParams);
        }
    }

    public final void o(WindowManager.LayoutParams layoutParams) {
        ConsultFloatWindowLayout consultFloatWindowLayout = f13812d;
        if (consultFloatWindowLayout == null) {
            return;
        }
        int l10 = h.l(this);
        if (layoutParams.f816x + (consultFloatWindowLayout.getWidth() / 2) > l10 / 2) {
            layoutParams.f816x = l10 - consultFloatWindowLayout.getWidth();
        } else {
            layoutParams.f816x = 0;
        }
        WindowManager windowManager = f13811c;
        if (windowManager != null) {
            windowManager.updateViewLayout(consultFloatWindowLayout, layoutParams);
        }
        consultFloatWindowLayout.l();
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        s.i(type, "type");
        s.i(model, "model");
        if ((model instanceof BaseConsultLiveGrpcModel) && s.d(((BaseConsultLiveGrpcModel) model).getRoomId(), f13814f)) {
            int i10 = a.f13817a[type.ordinal()];
            boolean z10 = true;
            if (i10 == 1) {
                ConsultFloatWindowLayout consultFloatWindowLayout = f13812d;
                if (consultFloatWindowLayout != null) {
                    consultFloatWindowLayout.i();
                }
                ConsultViewerViewModel.Companion.d();
                ConsultLiveHelper.f13820a.m();
                return;
            }
            if (i10 != 2) {
                if (i10 == 3 && (model instanceof ConsultRequestConnectGrpcModel)) {
                    ConsultViewerViewModel.Companion companion = ConsultViewerViewModel.Companion;
                    ConsultRequestConnectGrpcModel consultRequestConnectGrpcModel = (ConsultRequestConnectGrpcModel) model;
                    if (s.d(companion.b(), consultRequestConnectGrpcModel.getRequestId()) && consultRequestConnectGrpcModel.getCancel()) {
                        com.cupidapp.live.base.view.h.f12779a.k(R$string.connect_be_refused);
                        companion.d();
                        ConsultLiveHelper.f13820a.m();
                        return;
                    }
                    return;
                }
                return;
            }
            if (model instanceof ConsultApplyConnectGrpcModel) {
                ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel = (ConsultApplyConnectGrpcModel) model;
                if (s.d(ConsultViewerViewModel.Companion.b(), consultApplyConnectGrpcModel.getRequestId())) {
                    ConsultFloatWindowLayout consultFloatWindowLayout2 = f13812d;
                    if (consultFloatWindowLayout2 != null) {
                        consultFloatWindowLayout2.j();
                    }
                    WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
                    Activity activity = a10 != null ? a10.get() : null;
                    String str = f13814f;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    String str2 = f13815g;
                    if (str2 != null && str2.length() != 0) {
                        z10 = false;
                    }
                    if (z10) {
                        return;
                    }
                    String str3 = f13814f;
                    s.f(str3);
                    String str4 = f13815g;
                    s.f(str4);
                    ConsultViewerActivity.f13732x.a(activity, new ConsultViewerActivity.Config(str3, str4, null, EnterConsultRoomSource.ConsultWindow.getSource(), consultApplyConnectGrpcModel, 4, null));
                }
            }
        }
    }

    public final void p() {
        h();
    }

    public final void q() {
        ConsultLiveModel consultLiveModel = f13813e;
        if (consultLiveModel != null) {
            ConsultViewerViewModel.Companion companion = ConsultViewerViewModel.Companion;
            Long a10 = companion.a();
            Long valueOf = a10 != null ? Long.valueOf((System.currentTimeMillis() - a10.longValue()) / 1000) : null;
            z3.a.f54827a.h(consultLiveModel.getId(), consultLiveModel.getUser().userId(), valueOf != null ? Integer.valueOf((int) valueOf.longValue()) : null, Boolean.valueOf(consultLiveModel.getUser().getAloha()));
            companion.e(null);
        }
    }

    public final void r(@NotNull Context context, @NotNull ConsultLiveModel model, @NotNull com.cupidapp.live.consult.helper.a listener) {
        s.i(context, "context");
        s.i(model, "model");
        s.i(listener, "listener");
        f13816h = listener;
        if (s.d(g.f52734a.o0().c(), Boolean.FALSE)) {
            com.cupidapp.live.consult.helper.a aVar = f13816h;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (g(context)) {
            s(context);
            return;
        }
        Context c4 = AppApplication.f11612d.c();
        if (c4 == null) {
            com.cupidapp.live.consult.helper.a aVar2 = f13816h;
            if (aVar2 != null) {
                aVar2.b();
                return;
            }
            return;
        }
        com.cupidapp.live.consult.helper.a aVar3 = f13816h;
        if (aVar3 != null) {
            aVar3.a();
        }
        n(c4, model);
    }

    @RequiresApi(23)
    public final void s(final Context context) {
        if (!(context instanceof Activity)) {
            com.cupidapp.live.consult.helper.a aVar = f13816h;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).n(context.getString(R$string.mini_live_permission)).k(true), R$string.go_to_open, null, new Function0<p>() { // from class: com.cupidapp.live.consult.helper.ConsultFloatWindowHelper$showOpenPermissionDialog$1
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
                ConsultFloatWindowHelper.f13810b.m((Activity) context);
            }
        }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.consult.helper.ConsultFloatWindowHelper$showOpenPermissionDialog$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a aVar2;
                aVar2 = ConsultFloatWindowHelper.f13816h;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        }, 1, null), null, 1, null);
    }
}
