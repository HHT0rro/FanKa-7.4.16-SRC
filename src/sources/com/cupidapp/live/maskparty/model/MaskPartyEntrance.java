package com.cupidapp.live.maskparty.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyRecommendModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MaskPartyEntrance {
    RecommendMatch("CHAT_ROOM_TOP_BANNER");


    @NotNull
    private final String entrance;

    MaskPartyEntrance(String str) {
        this.entrance = str;
    }

    @NotNull
    public final String getEntrance() {
        return this.entrance;
    }
}
