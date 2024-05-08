package com.cupidapp.live.vip.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: PayType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum PayType {
    AliPay(2, "支付宝支付"),
    WeChatPay(8, "微信支付"),
    AliPayHuaBei(9, "花呗支付");

    private final int type;

    @NotNull
    private final String typeName;

    PayType(int i10, String str) {
        this.type = i10;
        this.typeName = str;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }
}
