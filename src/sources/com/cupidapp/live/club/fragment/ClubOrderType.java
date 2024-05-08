package com.cupidapp.live.club.fragment;

import com.cupidapp.live.R$string;
import javax.annotation.Resource;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ClubOrderType {
    All(R$string.all, "defaultSort"),
    NotJoined(R$string.not_joined, "notJoinedSort");


    @Resource
    private final int title;

    @NotNull
    private final String type;

    ClubOrderType(int i10, String str) {
        this.title = i10;
        this.type = str;
    }

    public final int getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
