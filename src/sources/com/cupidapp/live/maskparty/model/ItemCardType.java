package com.cupidapp.live.maskparty.model;

import kotlin.d;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum ItemCardType {
    AttackMatch(0),
    CitySearch(1),
    SpeedUpMatch(2),
    MatchNumber(3);

    private final int type;

    ItemCardType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
