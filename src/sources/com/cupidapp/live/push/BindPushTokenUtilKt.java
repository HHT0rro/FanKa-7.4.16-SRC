package com.cupidapp.live.push;

import android.app.Activity;
import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.utils.i0;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.push.model.FKPushTokenModel;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: BindPushTokenUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BindPushTokenUtilKt {

    /* compiled from: BindPushTokenUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17883a;

        static {
            int[] iArr = new int[FKPushTunnel.values().length];
            try {
                iArr[FKPushTunnel.Huawei.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKPushTunnel.Xiaomi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKPushTunnel.Vivo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FKPushTunnel.Oppo.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f17883a = iArr;
        }
    }

    /* compiled from: BindPushTokenUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements ICallBackResultService {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17884a;

        public b(Activity activity) {
            this.f17884a = activity;
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetNotificationStatus(int i10, int i11) {
            j.f12332a.a("PushMessage", "onGetNotificationStatus p0 " + i10 + "  p1 " + i11);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetPushStatus(int i10, int i11) {
            j.f12332a.a("PushMessage", "onGetPushStatus p0 " + i10 + "  p1 " + i11);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onRegister(int i10, @Nullable String str) {
            j.f12332a.a("PushMessage", "onRegister p0 " + i10 + "  p1 " + str);
            if (str != null) {
                BindPushTokenUtilKt.d(this.f17884a, str, 3, FKPushTunnel.Oppo);
            }
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onSetPushTime(int i10, @Nullable String str) {
            j.f12332a.a("PushMessage", "onSetPushTime p0 " + i10 + "  p1 " + str);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onUnRegister(int i10) {
            j.f12332a.a("PushMessage", "onUnRegister p0 " + i10 + "  ");
        }
    }

    /* compiled from: BindPushTokenUtil.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements fc.a {
        @Override // fc.a
        public void log(@NotNull String content, @NotNull Throwable t2) {
            s.i(content, "content");
            s.i(t2, "t");
            j.f12332a.b("MiPushClient", content, t2);
        }

        @Override // fc.a
        public void log(@NotNull String content) {
            s.i(content, "content");
            j.f12332a.a("MiPushClient", content);
        }
    }

    public static final void b(@NotNull final Activity activity) {
        s.i(activity, "<this>");
        g gVar = g.f52734a;
        if (gVar.L0() == null) {
            gVar.e3(new FKPushTokenModel(null, null, 3, null));
        }
        i0 i0Var = i0.f12331a;
        if (i0Var.b()) {
            new Thread(new Runnable() { // from class: com.cupidapp.live.push.a
                @Override // java.lang.Runnable
                public final void run() {
                    BindPushTokenUtilKt.c(activity);
                }
            }).start();
            return;
        }
        if (i0Var.d()) {
            if (g(activity)) {
                MiPushClient.J(activity, "2882303761518389465", "5481838980465");
                com.xiaomi.mipush.sdk.g.d(activity, new c());
                return;
            }
            return;
        }
        m3.d dVar = m3.d.f51803a;
        if (dVar.f(activity)) {
            dVar.e(activity);
            dVar.g(activity, new Function1<String, p>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$bindNotificationPush$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str) {
                    invoke2(str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    BindPushTokenUtilKt.d(activity, str, 3, FKPushTunnel.Vivo);
                }
            });
        } else {
            HeytapPushManager.init(activity, true);
            if (HeytapPushManager.isSupportPush()) {
                HeytapPushManager.register(activity, "9cf503f74dff45e39a70bba52775bc10", "656a73316c5b4a129b442bc640a838c5", new b(activity));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:3:0x0005, B:5:0x0013, B:10:0x001f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(android.app.Activity r4) {
        /*
            java.lang.String r0 = "$this_bindNotificationPush"
            kotlin.jvm.internal.s.i(r4, r0)
            com.huawei.hms.aaid.HmsInstanceId r0 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r4)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "102160561"
            java.lang.String r2 = "HCM"
            java.lang.String r0 = r0.getToken(r1, r2)     // Catch: java.lang.Exception -> L2b
            if (r0 == 0) goto L1c
            int r1 = r0.length()     // Catch: java.lang.Exception -> L2b
            if (r1 != 0) goto L1a
            goto L1c
        L1a:
            r1 = 0
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 != 0) goto L54
            java.lang.String r1 = "getToken"
            kotlin.jvm.internal.s.h(r0, r1)     // Catch: java.lang.Exception -> L2b
            r1 = 3
            com.cupidapp.live.push.FKPushTunnel r2 = com.cupidapp.live.push.FKPushTunnel.Huawei     // Catch: java.lang.Exception -> L2b
            d(r4, r0, r1, r2)     // Catch: java.lang.Exception -> L2b
            goto L54
        L2b:
            r4 = move-exception
            com.cupidapp.live.base.utils.j$a r0 = com.cupidapp.live.base.utils.j.f12332a
            java.lang.String r1 = r4.getMessage()
            java.lang.Throwable r4 = r4.getCause()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "error "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " "
            r2.append(r1)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String r1 = "HuaweiHmsMessage"
            r0.a(r1, r4)
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.push.BindPushTokenUtilKt.c(android.app.Activity):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(@NotNull final Context context, @NotNull final String token, final int i10, @NotNull final FKPushTunnel tunnel) {
        Observable<Result<Object>> k10;
        s.i(context, "<this>");
        s.i(token, "token");
        s.i(tunnel, "tunnel");
        if (i10 > 0) {
            if (token.length() == 0) {
                return;
            }
            boolean a10 = r0.f12373a.a(context);
            int i11 = a.f17883a[tunnel.ordinal()];
            if (i11 == 1) {
                k10 = NetworkClient.f11868a.F().k(token, a10);
            } else if (i11 == 2) {
                k10 = NetworkClient.f11868a.F().d(token, a10);
            } else if (i11 == 3) {
                k10 = NetworkClient.f11868a.F().a(token, a10);
            } else if (i11 != 4) {
                k10 = NetworkClient.f11868a.F().k(token, a10);
            } else {
                k10 = NetworkClient.f11868a.F().l(token, a10);
            }
            Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$bindPushToken$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    j.a aVar = j.f12332a;
                    FKPushTunnel fKPushTunnel = FKPushTunnel.this;
                    aVar.a("PushMessage", "bindPushToken " + ((Object) fKPushTunnel) + "   " + i10 + " token " + token);
                    BindPushTokenUtilKt.d(context, token, i10 + (-1), FKPushTunnel.this);
                    return Boolean.TRUE;
                }
            };
            com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = k10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$bindPushToken$$inlined$handleByContext$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    g gVar2 = g.f52734a;
                    FKPushTokenModel L0 = gVar2.L0();
                    if (L0 != null) {
                        L0.setToken(String.this);
                    }
                    if (L0 != null) {
                        L0.setType(tunnel.getType());
                    }
                    gVar2.e3(L0);
                    j.a aVar = j.f12332a;
                    FKPushTunnel fKPushTunnel = tunnel;
                    FKPushTokenModel L02 = gVar2.L0();
                    String token2 = L02 != null ? L02.getToken() : null;
                    FKPushTokenModel L03 = gVar2.L0();
                    aVar.a("PushMessage", "bindPushToken " + ((Object) fKPushTunnel) + "  token: " + token2 + " " + (L03 != null ? L03.getType() : null));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(@NotNull Context context, @NotNull FKPushMessageModel pushModel) {
        s.i(context, "<this>");
        s.i(pushModel, "pushModel");
        Observable<Result<Object>> g3 = NetworkClient.f11868a.F().g(pushModel);
        BindPushTokenUtilKt$pushArrive$2 bindPushTokenUtilKt$pushArrive$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$pushArrive$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = g3.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$pushArrive$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(bindPushTokenUtilKt$pushArrive$2, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void f(@NotNull Context context, @NotNull FKPushMessageModel pushModel) {
        s.i(context, "<this>");
        s.i(pushModel, "pushModel");
        Observable<Result<Object>> c4 = NetworkClient.f11868a.F().c(pushModel);
        BindPushTokenUtilKt$pushClick$2 bindPushTokenUtilKt$pushClick$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$pushClick$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = c4.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$pushClick$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(bindPushTokenUtilKt$pushClick$2, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public static final boolean g(@NotNull Activity activity) {
        s.i(activity, "<this>");
        return s.d(com.cupidapp.live.base.utils.c.a(activity), activity.getApplicationInfo().processName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(@NotNull Context context, @Nullable final Function0<p> function0) {
        Observable<Result<Object>> i10;
        s.i(context, "<this>");
        g gVar = g.f52734a;
        FKPushTokenModel L0 = gVar.L0();
        final String token = L0 != null ? L0.getToken() : null;
        if (!(token == null || token.length() == 0)) {
            FKPushTokenModel L02 = gVar.L0();
            String type = L02 != null ? L02.getType() : null;
            if (!(type == null || type.length() == 0)) {
                FKPushTokenModel L03 = gVar.L0();
                String type2 = L03 != null ? L03.getType() : null;
                if (s.d(type2, FKPushTunnel.Huawei.getType())) {
                    i10 = NetworkClient.f11868a.F().i(token);
                } else if (s.d(type2, FKPushTunnel.Xiaomi.getType())) {
                    i10 = NetworkClient.f11868a.F().j(token);
                } else if (s.d(type2, FKPushTunnel.Vivo.getType())) {
                    i10 = NetworkClient.f11868a.F().b(token);
                } else if (s.d(type2, FKPushTunnel.Oppo.getType())) {
                    i10 = NetworkClient.f11868a.F().e(token);
                } else {
                    i10 = NetworkClient.f11868a.F().i(token);
                }
                Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$unbindPushToken$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        s.i(it, "it");
                        j.f12332a.a("PushMessage", "unbindVivoPushToken failed: ");
                        Function0<p> function02 = function0;
                        if (function02 != null) {
                            function02.invoke();
                        }
                        return Boolean.TRUE;
                    }
                };
                com.cupidapp.live.base.network.g gVar2 = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                Disposable disposed = i10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.push.BindPushTokenUtilKt$unbindPushToken$$inlined$handleByContext$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        j.f12332a.a("PushMessage", "unbindPushToken succeed " + String.this);
                        g.f52734a.e3(null);
                        Function0 function02 = function0;
                        if (function02 != null) {
                            function02.invoke();
                        }
                    }
                }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar2)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (gVar2 != null) {
                        gVar2.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
                return;
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
    }
}
