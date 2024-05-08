package com.cupidapp.live.match.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MatchFilterKey {
    FilterAge("filterAge"),
    FilterHeight("filterHeight"),
    FilterWeight("filterWeight"),
    FilterActiveTime("filterActiveTime"),
    FilterDistance("filterDistance");


    @NotNull
    private final String key;

    MatchFilterKey(String str) {
        this.key = str;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
