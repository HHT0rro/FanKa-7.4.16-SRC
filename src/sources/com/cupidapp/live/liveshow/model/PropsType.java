package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PropsType {
    DiscountCard(0, "DISCOUNT_CARD"),
    BarrageCard(1, "BULLET_SCREEN_CARD"),
    HornCard(2, "TRUMPET_CARD"),
    NobleExperienceCard(3, "EXPERIENCE_CARD");


    @NotNull
    private final String propName;
    private final int value;

    PropsType(int i10, String str) {
        this.value = i10;
        this.propName = str;
    }

    @NotNull
    public final String getPropName() {
        return this.propName;
    }

    public final int getValue() {
        return this.value;
    }
}
