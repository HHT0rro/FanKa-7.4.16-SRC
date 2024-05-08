package com.cupidapp.live.profile.holder;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: NonexistentUserEnterViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum RelationType {
    Matched("匹配"),
    FollowYou("人气"),
    YouFollowed("关注");


    @NotNull
    private final String type;

    RelationType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
