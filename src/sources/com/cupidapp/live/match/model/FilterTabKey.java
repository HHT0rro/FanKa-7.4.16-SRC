package com.cupidapp.live.match.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FilterTabKey {
    MBTI("mbti"),
    ROLE("role"),
    ZODIAC("zodiac");


    @NotNull
    private final String value;

    FilterTabKey(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
