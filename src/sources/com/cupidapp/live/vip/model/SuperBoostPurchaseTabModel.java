package com.cupidapp.live.vip.model;

import com.cupidapp.live.superboost.purchase.SuperBoostType;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VipPurchaseTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostPurchaseTabModel extends PurchaseTabModel {

    @NotNull
    private final SuperBoostType purchaseType;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ SuperBoostPurchaseTabModel(com.cupidapp.live.superboost.purchase.SuperBoostType r16, java.lang.String r17, java.lang.String r18, float r19, java.util.List r20, java.util.List r21, int r22, boolean r23, boolean r24, java.util.List r25, float r26, float r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 4
            if (r1 == 0) goto La
            java.lang.String r1 = ""
            r5 = r1
            goto Lc
        La:
            r5 = r18
        Lc:
            r1 = r0 & 8
            if (r1 == 0) goto L15
            r1 = 1098907648(0x41800000, float:16.0)
            r6 = 1098907648(0x41800000, float:16.0)
            goto L17
        L15:
            r6 = r19
        L17:
            r1 = r0 & 16
            if (r1 == 0) goto L28
            r1 = -15066598(0xffffffffff1a1a1a, float:-2.0483664E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.util.List r1 = kotlin.collections.r.e(r1)
            r7 = r1
            goto L2a
        L28:
            r7 = r20
        L2a:
            r1 = r0 & 32
            if (r1 == 0) goto L30
            r8 = r7
            goto L32
        L30:
            r8 = r21
        L32:
            r1 = r0 & 64
            if (r1 == 0) goto L3d
            r1 = -5658199(0xffffffffffa9a9a9, float:NaN)
            r9 = -5658199(0xffffffffffa9a9a9, float:NaN)
            goto L3f
        L3d:
            r9 = r22
        L3f:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L46
            r1 = 0
            r10 = 0
            goto L48
        L46:
            r10 = r23
        L48:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L4f
            r1 = 1
            r11 = 1
            goto L51
        L4f:
            r11 = r24
        L51:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L62
            r1 = -144373(0xfffffffffffdcc0b, float:NaN)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.util.List r1 = kotlin.collections.r.e(r1)
            r12 = r1
            goto L64
        L62:
            r12 = r25
        L64:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 1092616192(0x41200000, float:10.0)
            if (r1 == 0) goto L6d
            r13 = 1092616192(0x41200000, float:10.0)
            goto L6f
        L6d:
            r13 = r26
        L6f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L76
            r14 = 1092616192(0x41200000, float:10.0)
            goto L78
        L76:
            r14 = r27
        L78:
            r2 = r15
            r3 = r16
            r4 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.vip.model.SuperBoostPurchaseTabModel.<init>(com.cupidapp.live.superboost.purchase.SuperBoostType, java.lang.String, java.lang.String, float, java.util.List, java.util.List, int, boolean, boolean, java.util.List, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public final SuperBoostType getPurchaseType() {
        return this.purchaseType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchaseTabModel(@NotNull SuperBoostType purchaseType, @NotNull String title, @NotNull String content, float f10, @NotNull List<Integer> titleSelectColor, @NotNull List<Integer> contentSelector, int i10, boolean z10, boolean z11, @NotNull List<Integer> indicatorColor, float f11, float f12) {
        super(title, content, f10, titleSelectColor, contentSelector, i10, z10, z11, indicatorColor, f11, f12);
        s.i(purchaseType, "purchaseType");
        s.i(title, "title");
        s.i(content, "content");
        s.i(titleSelectColor, "titleSelectColor");
        s.i(contentSelector, "contentSelector");
        s.i(indicatorColor, "indicatorColor");
        this.purchaseType = purchaseType;
    }
}
