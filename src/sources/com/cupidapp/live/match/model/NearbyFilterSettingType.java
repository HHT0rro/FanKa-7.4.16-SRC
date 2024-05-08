package com.cupidapp.live.match.model;

import kotlin.d;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum NearbyFilterSettingType {
    NO_FILTER(0),
    COMMON_FILTER(1);

    private final int value;

    NearbyFilterSettingType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
