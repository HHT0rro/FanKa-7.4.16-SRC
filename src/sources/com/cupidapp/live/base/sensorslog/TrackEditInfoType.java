package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogChangeInfo.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum TrackEditInfoType {
    NICK_NAME("昵称"),
    SELF_DESCRIPTION("个人简介");


    @NotNull
    private final String value;

    TrackEditInfoType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
