package com.cupidapp.live.base.router.jumper;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.permission.FKRxPermissionOpenModel;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PermissionJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LocationPermissionUrlJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        final FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity == null) {
            return;
        }
        final boolean booleanQueryParameter = uri.getBooleanQueryParameter("showCoordinateToast", false);
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (companion.d(context)) {
            xb.b bVar = new xb.b(fragmentActivity);
            PermissionType permissionType = PermissionType.LocationPermission;
            FKRxPermissionAlertDialog.f12016a.g(context, bVar, new FKRxPermissionOpenModel(R$string.no_have_location_permission, permissionType, null, kotlin.collections.r.e(permissionType), false, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.LocationPermissionUrlJumper$jump$model$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.cupidapp.live.base.utils.j.f12332a.a("LocationPermissionUrlJumper", "permissionSucceed");
                }
            }, null, null, null, true, null, null, 3520, null));
        } else if (companion.a().f()) {
            com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, null, false, 3, null);
            LocationUtils.o(companion.a(), context, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.LocationPermissionUrlJumper$jump$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    com.cupidapp.live.base.view.dialog.h.f12743a.b();
                    LocationPermissionUrlJumper.this.c(fragmentActivity, booleanQueryParameter);
                }
            }, new Function2<Integer, String, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.LocationPermissionUrlJumper$jump$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, String str2) {
                    invoke2(num, str2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num, @Nullable String str2) {
                    com.cupidapp.live.base.view.dialog.h.f12743a.b();
                    com.cupidapp.live.base.view.h.f12779a.m(context, ((FragmentActivity) context).getString(R$string.location_failed) + com.huawei.openalliance.ad.constant.u.bD + ((Object) num));
                }
            }, null, 8, null);
        } else {
            c(fragmentActivity, booleanQueryParameter);
        }
    }

    public final void c(Activity activity, boolean z10) {
        if (z10) {
            com.cupidapp.live.base.view.h.f12779a.l(activity, R$string.location_success);
        }
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        com.cupidapp.live.base.web.bridge.b.f13062a.c(activity, j10.getLongitude(), j10.getLatitude());
    }
}
