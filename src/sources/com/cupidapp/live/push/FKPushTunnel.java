package com.cupidapp.live.push;

import org.jetbrains.annotations.NotNull;

/* compiled from: FKPushTunnel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKPushTunnel {
    Huawei("Huawei"),
    GRPC("Grpc"),
    Xiaomi("Xiaomi"),
    Meizu("Meizu"),
    Vivo("Vivo"),
    Oppo("Oppo");


    @NotNull
    private final String type;

    FKPushTunnel(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
