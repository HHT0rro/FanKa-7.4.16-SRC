package com.cupidapp.live.voiceparty.model;

import kotlin.d;

/* compiled from: VoicePartyGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum VoicePartyGameRequestType {
    COMMON_GAME_INVITE(1),
    LATE_NIGHT_INVITE(2),
    FOLLOW_INVITE(3);

    private final int type;

    VoicePartyGameRequestType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
