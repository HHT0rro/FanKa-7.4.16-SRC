package com.cupidapp.live.match.model;

import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PurchaseProductType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum PurchaseProductType {
    SVIP(5),
    SSVIP(9),
    VIP(1),
    NO(0);


    @NotNull
    public static final a Companion = new a(null);
    private final int value;

    /* compiled from: PurchaseProductType.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PurchaseProductType a(int i10, int i11) {
            if (i11 >= i10) {
                return PurchaseProductType.NO;
            }
            a aVar = PurchaseProductType.Companion;
            if (aVar.d(i10)) {
                return PurchaseProductType.VIP;
            }
            if (aVar.c(i10)) {
                return PurchaseProductType.SVIP;
            }
            if (aVar.b(i10)) {
                return PurchaseProductType.SSVIP;
            }
            return PurchaseProductType.NO;
        }

        public final boolean b(int i10) {
            return i10 == PurchaseProductType.SSVIP.getValue();
        }

        public final boolean c(int i10) {
            return i10 == PurchaseProductType.SVIP.getValue();
        }

        public final boolean d(int i10) {
            return i10 == PurchaseProductType.VIP.getValue();
        }

        public final boolean e(@Nullable String str, int i10, @NotNull VipPurchaseEntranceType entranceType) {
            s.i(entranceType, "entranceType");
            PurchaseProductType f10 = PurchaseProductType.Companion.f(i10);
            if (f10 == PurchaseProductType.NO) {
                return false;
            }
            EventBus.c().l(new ShowPurchaseDialogEvent(entranceType, str, f10));
            return true;
        }

        @NotNull
        public final PurchaseProductType f(int i10) {
            a aVar = PurchaseProductType.Companion;
            if (aVar.d(i10) && !c.f17839a.f()) {
                return PurchaseProductType.VIP;
            }
            if (aVar.c(i10) && !c.f17839a.c()) {
                return PurchaseProductType.SVIP;
            }
            if (aVar.b(i10) && !c.f17839a.b()) {
                return PurchaseProductType.SSVIP;
            }
            return PurchaseProductType.NO;
        }
    }

    PurchaseProductType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
