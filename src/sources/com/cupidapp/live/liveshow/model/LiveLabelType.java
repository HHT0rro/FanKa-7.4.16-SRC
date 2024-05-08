package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveLabelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveLabelType {
    Admin("admin"),
    New("new"),
    Other("other"),
    Rank("rank"),
    FanClub("fanClub"),
    DailyList("dailyList"),
    WeeklyList("weeklyList"),
    Noble("noble");


    @NotNull
    private final String type;

    LiveLabelType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
