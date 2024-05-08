package com.cupidapp.live.superboost.dialog;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.model.ABTestKey;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.match.activity.TravelMapActivity;
import com.cupidapp.live.superboost.model.SuperBoostRemainAssetsResult;
import com.cupidapp.live.superboost.purchase.SuperBoostType;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.huawei.openalliance.ad.constant.u;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xb.b;
import z0.v;

/* compiled from: SuperBoostManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostManager {

    /* renamed from: a */
    @NotNull
    public static final SuperBoostManager f18580a = new SuperBoostManager();

    /* renamed from: b */
    @Nullable
    public static a f18581b;

    /* renamed from: c */
    @Nullable
    public static a f18582c;

    /* renamed from: d */
    @Nullable
    public static i f18583d;

    /* renamed from: e */
    @Nullable
    public static SuperBoostRemainTimeDialog f18584e;

    /* compiled from: SuperBoostManager.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a();

        void b(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void c(boolean z10);
    }

    public static /* synthetic */ void p(SuperBoostManager superBoostManager, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = null;
        }
        superBoostManager.o(context);
    }

    public static /* synthetic */ void u(SuperBoostManager superBoostManager, Context context, int i10, int i11, int i12, String str, Function0 function0, Function0 function02, int i13, Object obj) {
        superBoostManager.t(context, i10, i11, i12, (i13 & 16) != 0 ? null : str, function0, function02);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(final Context context, int i10, int i11, int i12, String str, final PurchaseDialogManager purchaseDialogManager, final String str2, String str3, final Function0<p> function0) {
        if (i11 > 0) {
            DirectSuperBoostFilterDialog.f18570f.a(context).h(new Function1<FormBody, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$useSuperBoost$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(FormBody formBody) {
                    invoke2(formBody);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FormBody it) {
                    s.i(it, "it");
                    Observable<Result<Object>> N = NetworkClient.f11868a.N().N(it);
                    Object obj = context;
                    final Function0<p> function02 = function0;
                    g gVar = obj instanceof g ? (g) obj : null;
                    Disposable disposed = N.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$useSuperBoost$1$invoke$$inlined$handleByContext$default$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                            invoke2(obj2);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj2) {
                            Function0.this.invoke();
                            z3.d.f54832a.H(SuperBoostType.DIRECT.getValue());
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            });
            z3.d.f54832a.b(i11, SuperBoostType.DIRECT.getValue());
            return;
        }
        if (i10 > 0) {
            if (i10 >= 2) {
                w(context, i10, str, function0);
                return;
            } else {
                v(context, i10, function0);
                return;
            }
        }
        if (i12 > 0) {
            if (context != 0) {
                n(context, str2);
                return;
            }
            return;
        }
        if (str3 == null || str3.length() == 0) {
            Observable<Result<ABTestListResult>> g3 = NetworkClient.f11868a.i().g(ABTestKey.SUPER_BOOST_ENTRANCE.getValue());
            g gVar = context instanceof g ? (g) context : null;
            Disposable disposed = g3.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ABTestListResult, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$useSuperBoost$$inlined$handleByContext$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ABTestListResult aBTestListResult) {
                    m2819invoke(aBTestListResult);
                    return p.f51048a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
                
                    if ((r0.length() > 0) == true) goto L31;
                 */
                /* renamed from: invoke, reason: collision with other method in class */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m2819invoke(com.cupidapp.live.base.network.model.ABTestListResult r8) {
                    /*
                        r7 = this;
                        com.cupidapp.live.base.network.model.ABTestListResult r8 = (com.cupidapp.live.base.network.model.ABTestListResult) r8
                        java.util.List r8 = r8.getTestResults()
                        r0 = 0
                        if (r8 == 0) goto L2f
                        java.util.Iterator r8 = r8.iterator2()
                    Ld:
                        boolean r1 = r8.hasNext()
                        if (r1 == 0) goto L2b
                        java.lang.Object r1 = r8.next()
                        r2 = r1
                        com.cupidapp.live.base.network.model.ABTestModel r2 = (com.cupidapp.live.base.network.model.ABTestModel) r2
                        java.lang.String r2 = r2.getName()
                        com.cupidapp.live.base.network.model.ABTestKey r3 = com.cupidapp.live.base.network.model.ABTestKey.SUPER_BOOST_ENTRANCE
                        java.lang.String r3 = r3.getValue()
                        boolean r2 = kotlin.jvm.internal.s.d(r2, r3)
                        if (r2 == 0) goto Ld
                        goto L2c
                    L2b:
                        r1 = r0
                    L2c:
                        com.cupidapp.live.base.network.model.ABTestModel r1 = (com.cupidapp.live.base.network.model.ABTestModel) r1
                        goto L30
                    L2f:
                        r1 = r0
                    L30:
                        if (r1 == 0) goto L37
                        java.lang.String r8 = r1.getResult()
                        goto L38
                    L37:
                        r8 = r0
                    L38:
                        com.cupidapp.live.base.abtest.ABTestGroup r1 = com.cupidapp.live.base.abtest.ABTestGroup.B
                        java.lang.String r1 = r1.getValue()
                        boolean r8 = kotlin.jvm.internal.s.d(r8, r1)
                        p1.g r1 = p1.g.f52734a
                        com.cupidapp.live.base.network.model.ConstantsResult r1 = r1.q()
                        if (r1 == 0) goto L54
                        com.cupidapp.live.base.network.model.ConstantsUrlModel r1 = r1.getUrlModel()
                        if (r1 == 0) goto L54
                        java.lang.String r0 = r1.getSuperBoostUrl()
                    L54:
                        if (r8 == 0) goto L8a
                        r8 = 1
                        r1 = 0
                        if (r0 == 0) goto L66
                        int r2 = r0.length()
                        if (r2 <= 0) goto L62
                        r2 = 1
                        goto L63
                    L62:
                        r2 = 0
                    L63:
                        if (r2 != r8) goto L66
                        goto L67
                    L66:
                        r8 = 0
                    L67:
                        if (r8 == 0) goto L8a
                        com.cupidapp.live.base.router.j$a r1 = com.cupidapp.live.base.router.j.f12156c
                        android.content.Context r2 = r1
                        java.lang.String r8 = r2
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        r3.append(r0)
                        java.lang.String r0 = "&entrance_name="
                        r3.append(r0)
                        r3.append(r8)
                        java.lang.String r3 = r3.toString()
                        r4 = 0
                        r5 = 4
                        r6 = 0
                        com.cupidapp.live.base.router.j.a.b(r1, r2, r3, r4, r5, r6)
                        goto L91
                    L8a:
                        com.cupidapp.live.vip.PurchaseDialogManager r8 = r3
                        java.lang.String r0 = r2
                        r8.k(r0)
                    L91:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.superboost.dialog.SuperBoostManager$useSuperBoost$$inlined$handleByContext$default$1.m2819invoke(java.lang.Object):void");
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
            return;
        }
        j.a.b(j.f12156c, context, str3, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(@Nullable final Context context, @NotNull final PurchaseDialogManager purchaseDialogManager, @NotNull final String from, @Nullable final String str) {
        s.i(purchaseDialogManager, "purchaseDialogManager");
        s.i(from, "from");
        Observable<Result<SuperBoostRemainAssetsResult>> g02 = NetworkClient.f11868a.N().g0();
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = g02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SuperBoostRemainAssetsResult, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$boostClick$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SuperBoostRemainAssetsResult superBoostRemainAssetsResult) {
                m2817invoke(superBoostRemainAssetsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2817invoke(SuperBoostRemainAssetsResult superBoostRemainAssetsResult) {
                SuperBoostRemainAssetsResult superBoostRemainAssetsResult2 = superBoostRemainAssetsResult;
                Long exposureEnd = superBoostRemainAssetsResult2.getExposureEnd();
                long longValue = exposureEnd != null ? exposureEnd.longValue() : 0L;
                if (longValue > System.currentTimeMillis()) {
                    Long travelboostStatus = superBoostRemainAssetsResult2.getTravelboostStatus();
                    if ((travelboostStatus != null ? travelboostStatus.longValue() : 0L) - System.currentTimeMillis() > 0) {
                        h hVar = h.f12779a;
                        Context context2 = context;
                        hVar.n(context2 != null ? context2.getString(R$string.traveling_tip) : null);
                        return;
                    } else {
                        SuperBoostManager superBoostManager = SuperBoostManager.f18580a;
                        superBoostManager.x(longValue - System.currentTimeMillis());
                        superBoostManager.s(context);
                        return;
                    }
                }
                SuperBoostManager superBoostManager2 = SuperBoostManager.f18580a;
                Context context3 = context;
                Integer superboostRemains = superBoostRemainAssetsResult2.getSuperboostRemains();
                int intValue = superboostRemains != null ? superboostRemains.intValue() : 0;
                Integer targetedSuperboostRemains = superBoostRemainAssetsResult2.getTargetedSuperboostRemains();
                int intValue2 = targetedSuperboostRemains != null ? targetedSuperboostRemains.intValue() : 0;
                Integer travelboostRemains = superBoostRemainAssetsResult2.getTravelboostRemains();
                int intValue3 = travelboostRemains != null ? travelboostRemains.intValue() : 0;
                String extraCountInfo = superBoostRemainAssetsResult2.getExtraCountInfo();
                PurchaseDialogManager purchaseDialogManager2 = purchaseDialogManager;
                String str2 = from;
                String str3 = str;
                final Context context4 = context;
                superBoostManager2.A(context3, intValue, intValue2, intValue3, extraCountInfo, purchaseDialogManager2, str2, str3, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$boostClick$1$1
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
                        SuperBoostManager.f18580a.o(context4);
                    }
                });
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void k(boolean z10) {
        a aVar = f18581b;
        if (aVar != null) {
            aVar.c(z10);
        }
        a aVar2 = f18582c;
        if (aVar2 != null) {
            aVar2.c(z10);
        }
    }

    public final void l() {
        a aVar = f18581b;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = f18582c;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public final void m(String str, String str2, String str3) {
        a aVar = f18581b;
        if (aVar != null) {
            aVar.b(str, str2, str3);
        }
        a aVar2 = f18582c;
        if (aVar2 != null) {
            aVar2.b(str, str2, str3);
        }
    }

    public final void n(final Context context, final String str) {
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            LocationUtils.f12270h.e(context, new b(fragmentActivity), new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$openTravelMap$1$1
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
                    TravelMapActivity.f16565x.a(context, str);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(@Nullable Context context) {
        Observable<Result<SuperBoostRemainAssetsResult>> g02 = NetworkClient.f11868a.N().g0();
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = g02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SuperBoostRemainAssetsResult, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$refreshSuperBoostTime$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SuperBoostRemainAssetsResult superBoostRemainAssetsResult) {
                m2818invoke(superBoostRemainAssetsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2818invoke(SuperBoostRemainAssetsResult superBoostRemainAssetsResult) {
                SuperBoostRemainAssetsResult superBoostRemainAssetsResult2 = superBoostRemainAssetsResult;
                Long travelboostStatus = superBoostRemainAssetsResult2.getTravelboostStatus();
                if ((travelboostStatus != null ? travelboostStatus.longValue() : 0L) - System.currentTimeMillis() > 0) {
                    SuperBoostManager.f18580a.k(false);
                    return;
                }
                Long exposureEnd = superBoostRemainAssetsResult2.getExposureEnd();
                long longValue = (exposureEnd != null ? exposureEnd.longValue() : 0L) - System.currentTimeMillis();
                SuperBoostManager superBoostManager = SuperBoostManager.f18580a;
                superBoostManager.k(longValue > 0);
                if (longValue > 0) {
                    superBoostManager.x(longValue);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void q(@NotNull a listener) {
        s.i(listener, "listener");
        f18582c = listener;
    }

    public final void r(@NotNull a listener) {
        s.i(listener, "listener");
        f18581b = listener;
    }

    public final void s(Context context) {
        SuperBoostRemainTimeDialog superBoostRemainTimeDialog = f18584e;
        if (!s.d(superBoostRemainTimeDialog != null ? superBoostRemainTimeDialog.getContext() : null, context)) {
            f18584e = SuperBoostRemainTimeDialog.f18585d.a(context);
        }
        SuperBoostRemainTimeDialog superBoostRemainTimeDialog2 = f18584e;
        if (superBoostRemainTimeDialog2 != null) {
            superBoostRemainTimeDialog2.e();
        }
    }

    public final void t(Context context, int i10, int i11, int i12, String str, final Function0<p> function0, final Function0<p> function02) {
        SuperBoostUseDialog.i(SuperBoostUseDialog.f18588d.a(context).g(R$string.super_boost_twice_msg).e(i10, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$showOpenSuperBoostConfirmDialog$1
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
                function0.invoke();
            }
        }).d(i11, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$showOpenSuperBoostConfirmDialog$2
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
                function02.invoke();
            }
        }).f(str), null, 1, null);
        z3.d.f54832a.b(i12, SuperBoostType.NON_DIRECT.getValue());
    }

    public final void v(Context context, int i10, final Function0<p> function0) {
        u(this, context, R$string.use, 2131886363, i10, null, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$showUseOneConfirmDialog$1
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
                SuperBoostManager.f18580a.z(1, function0);
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$showUseOneConfirmDialog$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        }, 16, null);
    }

    public final void w(Context context, int i10, String str, final Function0<p> function0) {
        t(context, R$string.use_twice, R$string.use, i10, str, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$showUseTwiceConfirmDialog$1
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
                SuperBoostManager.f18580a.z(2, function0);
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$showUseTwiceConfirmDialog$2
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
                SuperBoostManager.f18580a.z(1, function0);
            }
        });
    }

    public final void x(long j10) {
        if (f18583d == null) {
            f18583d = new i();
            String e2 = v.e(j10);
            String i10 = v.i(j10);
            m(e2 + u.bD + i10, e2, i10);
            i iVar = f18583d;
            if (iVar != null) {
                iVar.e(j10, 1000L, new Function0<p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$startCountDown$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SuperBoostManager superBoostManager = SuperBoostManager.f18580a;
                        SuperBoostManager.f18583d = null;
                        SuperBoostManager.f18584e = null;
                        superBoostManager.l();
                    }
                }, new Function1<Long, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$startCountDown$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Long l10) {
                        invoke(l10.longValue());
                        return p.f51048a;
                    }

                    public final void invoke(long j11) {
                        SuperBoostRemainTimeDialog superBoostRemainTimeDialog;
                        String e10 = v.e(j11);
                        String i11 = v.i(j11);
                        SuperBoostManager.f18580a.m(e10 + u.bD + i11, e10, i11);
                        superBoostRemainTimeDialog = SuperBoostManager.f18584e;
                        if (superBoostRemainTimeDialog != null) {
                            superBoostRemainTimeDialog.c(e10 + u.bD + i11);
                        }
                    }
                });
            }
        }
    }

    public final void y() {
        i iVar = f18583d;
        if (iVar != null) {
            iVar.g();
        }
        f18583d = null;
        f18584e = null;
        f18581b = null;
        f18582c = null;
    }

    public final void z(int i10, final Function0<p> function0) {
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        builder.add("type", "0");
        builder.add("times", String.valueOf(i10));
        Disposable disposed = NetworkClient.f11868a.N().N(builder.build()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostManager$useBoost$$inlined$handle$default$1
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
                Function0.this.invoke();
                z3.d.f54832a.H(SuperBoostType.NON_DIRECT.getValue());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
