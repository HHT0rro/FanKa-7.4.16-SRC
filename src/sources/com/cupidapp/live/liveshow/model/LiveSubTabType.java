package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveContainerFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveSubTabType {
    RECOMMEND("RECOMMEND"),
    HOT("HOT"),
    NEARBY("NEARBY"),
    FOLLOW("FOLLOW"),
    GENERAL("GENERAL"),
    VOICE_ROOM("VOICEROOM"),
    WEB("WEB");


    @NotNull
    private final String value;

    LiveSubTabType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
