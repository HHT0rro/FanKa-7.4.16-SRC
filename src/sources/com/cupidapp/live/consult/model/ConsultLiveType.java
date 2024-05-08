package com.cupidapp.live.consult.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ConsultLiveType {
    ConsultLiveRoom("voiceRoom"),
    ConsultBanner("banners");


    @NotNull
    private final String type;

    ConsultLiveType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
