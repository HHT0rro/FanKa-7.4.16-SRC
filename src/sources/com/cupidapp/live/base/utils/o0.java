package com.cupidapp.live.base.utils;

import android.content.Context;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.sensorslog.SensorsLogUserStatusSwitch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsSystemPermissionLog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o0 f12367a = new o0();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12368b;

    public final void a(Context context) {
        p1.g gVar = p1.g.f52734a;
        SystemPermissionStatusModel Y = gVar.Y();
        boolean b4 = LocationUtils.f12270h.b(context);
        if (Y == null) {
            Y = new SystemPermissionStatusModel(SensorsLogUserStatusSwitch.SystemPermission.LocationInformation, b4, false, 4, null);
            SensorsLogUserStatusSwitch.f12217a.c(Y.getPermission(), b4, Boolean.valueOf(b4), Boolean.TRUE);
        } else if (Y.getOpen() != b4) {
            Y.setOpen(b4);
            SensorsLogUserStatusSwitch.f12217a.c(Y.getPermission(), b4, Boolean.valueOf(b4), Boolean.FALSE);
        }
        gVar.C2(Y);
    }

    public final void b(Context context) {
        p1.g gVar = p1.g.f52734a;
        SystemPermissionStatusModel Z = gVar.Z();
        boolean h10 = RxPermissionHelperKt.h(context, PermissionType.LocationPermission);
        if (Z == null) {
            Z = new SystemPermissionStatusModel(SensorsLogUserStatusSwitch.SystemPermission.LocationPermission, h10, false, 4, null);
        } else if (Z.getOpen() != h10) {
            Z.setOpen(h10);
            SensorsLogUserStatusSwitch.f12217a.c(Z.getPermission(), h10, Boolean.valueOf(h10), Boolean.FALSE);
        }
        gVar.D2(Z);
    }

    public final void c(Context context) {
        p1.g gVar = p1.g.f52734a;
        SystemPermissionStatusModel K0 = gVar.K0();
        boolean a10 = r0.f12373a.a(context);
        if (K0 == null) {
            K0 = new SystemPermissionStatusModel(SensorsLogUserStatusSwitch.SystemPermission.PushPermission, a10, false, 4, null);
        } else if (K0.getOpen() != a10) {
            if (a10) {
                SensorsLogUserStatusSwitch.f12217a.c(K0.getPermission(), a10, Boolean.valueOf(f12368b), Boolean.valueOf(f12368b ? K0.isFirst() : false));
                K0.setFirst(false);
                f12368b = false;
            } else {
                SensorsLogUserStatusSwitch.d(SensorsLogUserStatusSwitch.f12217a, K0.getPermission(), a10, null, null, 12, null);
            }
            K0.setOpen(a10);
        }
        gVar.d3(K0);
    }

    public final void d(@Nullable Context context) {
        if (context == null) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        SystemPermissionStatusModel Z = gVar.Z();
        boolean h10 = RxPermissionHelperKt.h(context, PermissionType.LocationPermission);
        if (Z == null) {
            SensorsLogUserStatusSwitch.SystemPermission systemPermission = SensorsLogUserStatusSwitch.SystemPermission.LocationPermission;
            Z = new SystemPermissionStatusModel(systemPermission, h10, false, 4, null);
            SensorsLogUserStatusSwitch sensorsLogUserStatusSwitch = SensorsLogUserStatusSwitch.f12217a;
            Boolean bool = Boolean.TRUE;
            sensorsLogUserStatusSwitch.c(systemPermission, h10, bool, bool);
        } else if (Z.isFirst() || Z.getOpen() != h10) {
            SensorsLogUserStatusSwitch.f12217a.c(Z.getPermission(), h10, Boolean.TRUE, Boolean.valueOf(Z.isFirst()));
            Z.setOpen(h10);
            Z.setFirst(false);
        }
        gVar.D2(Z);
    }

    public final void e(@Nullable Context context) {
        if (context == null) {
            return;
        }
        h(context);
    }

    public final void f(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "context");
        h(context);
        b(context);
        a(context);
        c(context);
    }

    public final void g(boolean z10) {
        f12368b = z10;
    }

    public final void h(Context context) {
        p1.g gVar = p1.g.f52734a;
        SystemPermissionStatusModel x12 = gVar.x1();
        boolean h10 = RxPermissionHelperKt.h(context, PermissionType.StoragePermission);
        if (x12 == null) {
            x12 = new SystemPermissionStatusModel(SensorsLogUserStatusSwitch.SystemPermission.StoragePermission, h10, false, 4, null);
        } else if (x12.getOpen() != h10) {
            x12.setOpen(h10);
            SensorsLogUserStatusSwitch.f12217a.c(x12.getPermission(), h10, Boolean.valueOf(h10), Boolean.FALSE);
        }
        gVar.G3(x12);
    }
}
