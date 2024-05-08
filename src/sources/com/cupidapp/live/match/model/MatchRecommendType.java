package com.cupidapp.live.match.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MatchRecommendType {
    Recommend("Recommend"),
    GroupCampaign("GroupActivity"),
    HighEndDating("AD"),
    Marketing("AD_FS");


    @NotNull
    private final String type;

    MatchRecommendType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
