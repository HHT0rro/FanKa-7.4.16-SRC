package com.cupidapp.live.setting.model;

import kotlin.d;

/* compiled from: PostLimitSettingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum LimitRangeType {
    PUBLIC(0),
    FANS(1),
    MATCH(2);

    private final int value;

    LimitRangeType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
