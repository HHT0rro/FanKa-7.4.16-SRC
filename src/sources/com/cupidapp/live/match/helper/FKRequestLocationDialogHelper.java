package com.cupidapp.live.match.helper;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.permission.FKRxPermissionOpenModel;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.permission.b;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.o0;
import com.heytap.msp.push.HeytapPushManager;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FKRequestLocationDialogHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKRequestLocationDialogHelper {

    /* renamed from: a */
    @NotNull
    public static final FKRequestLocationDialogHelper f16752a = new FKRequestLocationDialogHelper();

    /* compiled from: FKRequestLocationDialogHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements com.cupidapp.live.base.permission.b {

        /* renamed from: a */
        public final /* synthetic */ Function0<p> f16753a;

        /* renamed from: b */
        public final /* synthetic */ Context f16754b;

        public a(Function0<p> function0, Context context) {
            this.f16753a = function0;
            this.f16754b = context;
        }

        @Override // com.cupidapp.live.base.permission.b
        public void a() {
            this.f16753a.invoke();
            LocationUtils.o(LocationUtils.f12270h.a(), this.f16754b, null, null, null, 14, null);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void b() {
            b.a.b(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void c() {
            b.a.c(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void d() {
            b.a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(FKRequestLocationDialogHelper fKRequestLocationDialogHelper, Context context, xb.b bVar, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function0 = null;
        }
        fKRequestLocationDialogHelper.c(context, bVar, function0);
    }

    public final void a() {
        try {
            HeytapPushManager.requestNotificationPermission();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(@Nullable Context context, @NotNull xb.b rxPermissions, @NotNull Function0<p> requestCallback) {
        s.i(rxPermissions, "rxPermissions");
        s.i(requestCallback, "requestCallback");
        if (context == null) {
            return;
        }
        RxPermissionHelperKt.m(context, rxPermissions, r.e(PermissionType.LocationPermission), new a(requestCallback, context), false, 16, null);
    }

    public final void c(@Nullable final Context context, @NotNull xb.b rxPermissions, @Nullable final Function0<p> function0) {
        s.i(rxPermissions, "rxPermissions");
        if (context == null) {
            return;
        }
        g gVar = g.f52734a;
        if (s.d(gVar.G0().c(), Boolean.TRUE)) {
            gVar.G0().d(Boolean.FALSE);
            FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
            PermissionType permissionType = PermissionType.LocationPermission;
            companion.h(context, rxPermissions, new FKRxPermissionOpenModel(R$string.authorize_aloha_permission_match, permissionType, null, r.e(permissionType), false, new Function0<p>() { // from class: com.cupidapp.live.match.helper.FKRequestLocationDialogHelper$requestPermissionDialog$1
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
                    LocationUtils.o(LocationUtils.f12270h.a(), context, null, null, null, 14, null);
                    o0.f12367a.d(context);
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.match.helper.FKRequestLocationDialogHelper$requestPermissionDialog$2
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
                    Function0<p> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    o0.f12367a.d(context);
                }
            }, null, null, false, new Function0<p>() { // from class: com.cupidapp.live.match.helper.FKRequestLocationDialogHelper$requestPermissionDialog$3
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
                    Function0<p> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    o0.f12367a.d(context);
                }
            }, null, 2944, null));
        }
    }
}
