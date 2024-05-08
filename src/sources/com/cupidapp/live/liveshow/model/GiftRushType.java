package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum GiftRushType {
    Regular("regular"),
    Lucky("lucky"),
    Rocket("rocket"),
    Car("car");


    @NotNull
    private final String type;

    GiftRushType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
