package com.cupidapp.live.liveshow.miniwindow;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.google.android.material.badge.BadgeDrawable;
import j1.l;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: FKLiveMiniWindowUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniWindowUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FKLiveMiniWindowUtil f15095a = new FKLiveMiniWindowUtil();

    public static /* synthetic */ void g(FKLiveMiniWindowUtil fKLiveMiniWindowUtil, Activity activity, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        fKLiveMiniWindowUtil.f(activity, str, z10);
    }

    public final void a(@Nullable Activity activity) {
        g gVar = g.f52734a;
        Boolean c4 = gVar.K1().c();
        Boolean bool = Boolean.TRUE;
        if (s.d(c4, bool)) {
            p1.d<Boolean> K1 = gVar.K1();
            Boolean bool2 = Boolean.FALSE;
            K1.d(bool2);
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(activity)) {
                gVar.P().d(bool);
                l.f50239a.a(false);
            } else {
                gVar.P().d(bool2);
                l.f50239a.a(true);
            }
        }
    }

    public final boolean b(@Nullable Context context) {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context)) {
            l.f50239a.a(false);
            return false;
        }
        l.f50239a.a(true);
        return true;
    }

    public final void c(@NotNull WindowManager.LayoutParams layoutParams, @NotNull Context context) {
        s.i(layoutParams, "<this>");
        s.i(context, "context");
        layoutParams.windowAnimations = 16973827;
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        FKLiveMiniWindow.f15074m.a().J(layoutParams);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            layoutParams.type = i10 >= 26 ? 2038 : 2002;
        } else {
            PackageManager packageManager = context.getPackageManager();
            boolean z10 = false;
            if (packageManager != null && packageManager.checkPermission("android.permission.SYSTEM_ALERT_WINDOW", context.getPackageName()) == 0) {
                z10 = true;
            }
            layoutParams.type = z10 ? 2002 : 2005;
        }
        layoutParams.flags = 8;
        layoutParams.format = 1;
    }

    public final void d() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel != null) {
            liveShowModel.setStrategyId(fKLiveConstantsData.getFkLiveStrategyId());
            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, AppApplication.f11612d.h().getBaseContext(), new FKLiveForViewerViewModel(liveShowModel, null, new LiveInRoomSensorModel("LiveShowEnterMiniLive", null, null, null, null, null, 48, null), true), false, 4, null);
        }
    }

    @Nullable
    public final Boolean e(@Nullable final Activity activity, @Nullable final Function1<? super Boolean, p> function1) {
        if (activity == null) {
            return Boolean.FALSE;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(activity)) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, activity, false, 2, null).n(activity.getString(R$string.mini_live_permission)).j(false), R$string.go_to_open, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowUtil$openMiniWindowPermission$1
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
                    Intent action = new Intent().setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    s.h(action, "Intent().setAction(Setti…ANAGE_OVERLAY_PERMISSION)");
                    action.setData(Uri.parse("package:" + activity.getPackageName()));
                    try {
                        activity.startActivityForResult(action, 200);
                    } catch (ActivityNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowUtil$openMiniWindowPermission$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
                    Activity activity2 = activity;
                    FKLiveForViewerActivity fKLiveForViewerActivity = activity2 instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity2 : null;
                    FKLiveUtil.o(fKLiveUtil, true, fKLiveForViewerActivity != null ? fKLiveForViewerActivity.W1() : null, false, 4, null);
                    l.f50239a.a(false);
                    Function1<Boolean, p> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(Boolean.FALSE);
                    }
                }
            }, 1, null), null, 1, null);
            return null;
        }
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        return Boolean.TRUE;
    }

    public final void f(@Nullable Activity activity, @Nullable String str, boolean z10) {
        if (b(activity)) {
            FKLiveMiniWindow.V(FKLiveMiniWindow.f15074m.a(), activity, str, null, 4, null);
            return;
        }
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        fKLiveUtil.n(z10, fKLiveForViewerActivity != null ? fKLiveForViewerActivity.W1() : null, z10);
    }

    public final void h(@NotNull MiniWindowCloseMethod closeMethod) {
        s.i(closeMethod, "closeMethod");
        FKLiveConstantsData.INSTANCE.setMiniLiveViewDuration(null);
    }

    public final void i(@NotNull WindowManager.LayoutParams layoutParams, boolean z10) {
        s.i(layoutParams, "<this>");
        if (z10) {
            layoutParams.width = h.c(layoutParams, 130.0f);
            layoutParams.height = -2;
        } else {
            layoutParams.width = h.c(layoutParams, 178.0f);
            layoutParams.height = -2;
        }
    }
}
