package com.cupidapp.live.vip;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.match.model.PurchaseProductType;
import com.cupidapp.live.superboost.purchase.SuperBoostPurchaseWrapper;
import com.cupidapp.live.superlike.view.SuperlikePurchaseWrapper;
import com.cupidapp.live.superlike.view.g;
import com.cupidapp.live.track.group.SensorVipType;
import com.cupidapp.live.vip.PurchaseDialogManager$superLikePurchaseCallBack$2;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.vip.wrapper.VipFullScreenPurchaseWrapper;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.cupidapp.live.vip.wrapper.VipPurchaseWrapper;
import com.cupidapp.live.visitors.model.VisitorRecallResult;
import com.cupidapp.live.visitors.wrapper.VisitorDiscountPurchaseWrapper;
import com.cupidapp.live.visitors.wrapper.VisitorsPurchaseWrapper;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PurchaseDialogManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PurchaseDialogManager {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f18716a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lifecycle f18717b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f18718c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18719d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18720e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18721f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f18722g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f18723h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f18724i;

    public PurchaseDialogManager(@Nullable Context context, @NotNull Lifecycle lifecycle) {
        s.i(lifecycle, "lifecycle");
        this.f18716a = context;
        this.f18717b = lifecycle;
        this.f18718c = kotlin.c.b(new Function0<SuperlikePurchaseWrapper>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$superlikePurchaseWrapper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperlikePurchaseWrapper invoke() {
                SuperlikePurchaseWrapper superlikePurchaseWrapper = new SuperlikePurchaseWrapper();
                superlikePurchaseWrapper.B(PurchaseDialogManager.this.b());
                return superlikePurchaseWrapper;
            }
        });
        this.f18719d = kotlin.c.b(new Function0<SuperBoostPurchaseWrapper>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$superBoostWrapper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SuperBoostPurchaseWrapper invoke() {
                SuperBoostPurchaseWrapper superBoostPurchaseWrapper = new SuperBoostPurchaseWrapper();
                superBoostPurchaseWrapper.B(PurchaseDialogManager.this.b());
                return superBoostPurchaseWrapper;
            }
        });
        this.f18720e = kotlin.c.b(new Function0<VipPurchaseWrapper>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$vipPurchaseWrapper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipPurchaseWrapper invoke() {
                VipPurchaseWrapper vipPurchaseWrapper = new VipPurchaseWrapper();
                vipPurchaseWrapper.B(PurchaseDialogManager.this.b());
                return vipPurchaseWrapper;
            }
        });
        this.f18721f = kotlin.c.b(new Function0<VipFullScreenPurchaseWrapper>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$vipFullScreenPurchaseWrapper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VipFullScreenPurchaseWrapper invoke() {
                VipFullScreenPurchaseWrapper vipFullScreenPurchaseWrapper = new VipFullScreenPurchaseWrapper();
                vipFullScreenPurchaseWrapper.B(PurchaseDialogManager.this.b());
                return vipFullScreenPurchaseWrapper;
            }
        });
        this.f18722g = kotlin.c.b(new Function0<VisitorDiscountPurchaseWrapper>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$visitorDiscountPurchaseWrapper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorDiscountPurchaseWrapper invoke() {
                VisitorDiscountPurchaseWrapper visitorDiscountPurchaseWrapper = new VisitorDiscountPurchaseWrapper();
                visitorDiscountPurchaseWrapper.B(PurchaseDialogManager.this.b());
                return visitorDiscountPurchaseWrapper;
            }
        });
        this.f18723h = kotlin.c.b(new Function0<VisitorsPurchaseWrapper>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$visitorsPurchaseWrapper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final VisitorsPurchaseWrapper invoke() {
                VisitorsPurchaseWrapper visitorsPurchaseWrapper = new VisitorsPurchaseWrapper();
                visitorsPurchaseWrapper.B(PurchaseDialogManager.this.b());
                return visitorsPurchaseWrapper;
            }
        });
        this.f18724i = kotlin.c.b(new Function0<PurchaseDialogManager$superLikePurchaseCallBack$2.a>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$superLikePurchaseCallBack$2

            /* compiled from: PurchaseDialogManager.kt */
            @d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class a implements g {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ PurchaseDialogManager f18725a;

                public a(PurchaseDialogManager purchaseDialogManager) {
                    this.f18725a = purchaseDialogManager;
                }

                @Override // com.cupidapp.live.superlike.view.g
                public void a(@NotNull VipPurchaseEntranceType vipPurchaseEntranceType) {
                    s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
                    PurchaseDialogManager.q(this.f18725a, vipPurchaseEntranceType, null, null, true, false, 22, null);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(PurchaseDialogManager.this);
            }
        });
    }

    public static /* synthetic */ void j(PurchaseDialogManager purchaseDialogManager, VipPurchaseEntranceType vipPurchaseEntranceType, String str, VipType vipType, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            vipType = VipType.SUPER;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        purchaseDialogManager.i(vipPurchaseEntranceType, str, vipType, z10);
    }

    public static /* synthetic */ void o(PurchaseDialogManager purchaseDialogManager, VipPurchaseEntranceType vipPurchaseEntranceType, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        purchaseDialogManager.n(vipPurchaseEntranceType, str, z10, z11);
    }

    public static /* synthetic */ void q(PurchaseDialogManager purchaseDialogManager, VipPurchaseEntranceType vipPurchaseEntranceType, String str, VipType vipType, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            vipType = VipType.SUPER;
        }
        purchaseDialogManager.p(vipPurchaseEntranceType, str2, vipType, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ void u(PurchaseDialogManager purchaseDialogManager, VipPurchaseEntranceType vipPurchaseEntranceType, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        purchaseDialogManager.t(vipPurchaseEntranceType, str, z10);
    }

    @NotNull
    public final Lifecycle b() {
        return this.f18717b;
    }

    public final SuperBoostPurchaseWrapper c() {
        return (SuperBoostPurchaseWrapper) this.f18719d.getValue();
    }

    public final PurchaseDialogManager$superLikePurchaseCallBack$2.a d() {
        return (PurchaseDialogManager$superLikePurchaseCallBack$2.a) this.f18724i.getValue();
    }

    public final SuperlikePurchaseWrapper e() {
        return (SuperlikePurchaseWrapper) this.f18718c.getValue();
    }

    public final VipFullScreenPurchaseWrapper f() {
        return (VipFullScreenPurchaseWrapper) this.f18721f.getValue();
    }

    public final VipPurchaseWrapper g() {
        return (VipPurchaseWrapper) this.f18720e.getValue();
    }

    public final VisitorDiscountPurchaseWrapper h() {
        return (VisitorDiscountPurchaseWrapper) this.f18722g.getValue();
    }

    public final void i(@NotNull VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable String str, @NotNull VipType defaultType, boolean z10) {
        s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
        s.i(defaultType, "defaultType");
        Context context = this.f18716a;
        if (context != null) {
            f().d0(context, (r20 & 2) != 0 ? VipType.SUPER : VipType.SUPER, SensorVipType.A_DIO_RAINBOW_MIXTURE, vipPurchaseEntranceType, (r20 & 16) != 0 ? null : str, (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? false : z10, (r20 & 128) != 0 ? null : null);
        }
    }

    public final void k(@Nullable String str) {
        Context context = this.f18716a;
        if (context != null) {
            c().O(context, str);
        }
    }

    public final void l(@NotNull VipPurchaseEntranceType entranceType, @Nullable String str, int i10) {
        s.i(entranceType, "entranceType");
        if (i10 == PurchaseProductType.SSVIP.getValue()) {
            o(this, entranceType, str, false, false, 12, null);
        } else if (i10 == PurchaseProductType.SVIP.getValue()) {
            q(this, entranceType, str, null, false, false, 28, null);
        } else if (i10 == PurchaseProductType.VIP.getValue()) {
            j(this, entranceType, str, null, false, 12, null);
        }
    }

    public final void m(@NotNull VipPurchaseEntranceType vipPurchaseEntranceType) {
        s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
        if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
            r(vipPurchaseEntranceType);
        } else {
            q(this, vipPurchaseEntranceType, null, null, true, false, 22, null);
        }
    }

    public final void n(@NotNull final VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable String str, boolean z10, boolean z11) {
        s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
        Context context = this.f18716a;
        if (context != null) {
            f().d0(context, VipType.RAINBOW, SensorVipType.RAINBOW_A_PLUS, vipPurchaseEntranceType, str, z11, z10, new Function0<p>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$showRainbowVipPurchaseDialog$1$1
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
                    PurchaseDialogManager.this.r(vipPurchaseEntranceType);
                }
            });
        }
    }

    public final void p(@NotNull final VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable String str, @NotNull VipType defaultType, boolean z10, boolean z11) {
        s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
        s.i(defaultType, "defaultType");
        Context context = this.f18716a;
        if (context != null) {
            f().d0(context, VipType.SUPER, SensorVipType.DIO_RAINBOW_MIXTURE, vipPurchaseEntranceType, str, z10, z11, new Function0<p>() { // from class: com.cupidapp.live.vip.PurchaseDialogManager$showSVipAndRainbowVipPurchaseDialog$1$1
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
                    PurchaseDialogManager.this.r(vipPurchaseEntranceType);
                }
            });
        }
    }

    public final void r(VipPurchaseEntranceType vipPurchaseEntranceType) {
        Context context = this.f18716a;
        if (context != null) {
            e().S(this.f18717b, context, vipPurchaseEntranceType.getFrom(), vipPurchaseEntranceType, d());
        }
    }

    public final void s(@Nullable String str, @NotNull VisitorRecallResult model) {
        s.i(model, "model");
        Context context = this.f18716a;
        if (context != null) {
            h().U(context, str, model);
        }
    }

    public final void t(@NotNull VipPurchaseEntranceType vipPurchaseEntranceType, @Nullable String str, boolean z10) {
        s.i(vipPurchaseEntranceType, "vipPurchaseEntranceType");
        Context context = this.f18716a;
        if (context != null) {
            g().d0(context, (r20 & 2) != 0 ? VipType.SUPER : VipType.VISITOR, SensorVipType.VISITOR_RAINBOW_MIXTURE, vipPurchaseEntranceType, (r20 & 16) != 0 ? null : str, (r20 & 32) != 0 ? false : false, (r20 & 64) != 0 ? false : z10, (r20 & 128) != 0 ? null : null);
        }
    }
}
