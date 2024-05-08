package com.cupidapp.live.voiceparty.model;

import kotlin.d;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum VoicePartyRoomDissolveReasonType {
    NOT_PUBLIC_PROFILE(1),
    PUBLIC_PROFILE_BUT_NOT_MATCH(2),
    PUBLIC_PROFILE_AND_MATCH_BUT_TIMEOUT(3);

    private final int value;

    VoicePartyRoomDissolveReasonType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
