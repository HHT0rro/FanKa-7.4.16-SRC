package com.cupidapp.live.voiceparty.model;

import java.io.Serializable;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyDurationModel implements Serializable {
    private final int audioGameSysTipCountdownSec;
    private final int inviteCountdownSec;
    private final int maskDurationSec;
    private final int matchDurationSec;
    private final int maxDurationSec;
    private final int profileUnableDurationSec;

    public VoicePartyDurationModel(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.profileUnableDurationSec = i10;
        this.inviteCountdownSec = i11;
        this.audioGameSysTipCountdownSec = i12;
        this.maskDurationSec = i13;
        this.matchDurationSec = i14;
        this.maxDurationSec = i15;
    }

    public static /* synthetic */ VoicePartyDurationModel copy$default(VoicePartyDurationModel voicePartyDurationModel, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i10 = voicePartyDurationModel.profileUnableDurationSec;
        }
        if ((i16 & 2) != 0) {
            i11 = voicePartyDurationModel.inviteCountdownSec;
        }
        int i17 = i11;
        if ((i16 & 4) != 0) {
            i12 = voicePartyDurationModel.audioGameSysTipCountdownSec;
        }
        int i18 = i12;
        if ((i16 & 8) != 0) {
            i13 = voicePartyDurationModel.maskDurationSec;
        }
        int i19 = i13;
        if ((i16 & 16) != 0) {
            i14 = voicePartyDurationModel.matchDurationSec;
        }
        int i20 = i14;
        if ((i16 & 32) != 0) {
            i15 = voicePartyDurationModel.maxDurationSec;
        }
        return voicePartyDurationModel.copy(i10, i17, i18, i19, i20, i15);
    }

    public final int component1() {
        return this.profileUnableDurationSec;
    }

    public final int component2() {
        return this.inviteCountdownSec;
    }

    public final int component3() {
        return this.audioGameSysTipCountdownSec;
    }

    public final int component4() {
        return this.maskDurationSec;
    }

    public final int component5() {
        return this.matchDurationSec;
    }

    public final int component6() {
        return this.maxDurationSec;
    }

    @NotNull
    public final VoicePartyDurationModel copy(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new VoicePartyDurationModel(i10, i11, i12, i13, i14, i15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoicePartyDurationModel)) {
            return false;
        }
        VoicePartyDurationModel voicePartyDurationModel = (VoicePartyDurationModel) obj;
        return this.profileUnableDurationSec == voicePartyDurationModel.profileUnableDurationSec && this.inviteCountdownSec == voicePartyDurationModel.inviteCountdownSec && this.audioGameSysTipCountdownSec == voicePartyDurationModel.audioGameSysTipCountdownSec && this.maskDurationSec == voicePartyDurationModel.maskDurationSec && this.matchDurationSec == voicePartyDurationModel.matchDurationSec && this.maxDurationSec == voicePartyDurationModel.maxDurationSec;
    }

    public final int getAudioGameSysTipCountdownSec() {
        return this.audioGameSysTipCountdownSec;
    }

    public final int getInviteCountdownSec() {
        return this.inviteCountdownSec;
    }

    public final int getMaskDurationSec() {
        return this.maskDurationSec;
    }

    public final int getMatchDurationSec() {
        return this.matchDurationSec;
    }

    public final int getMaxDurationSec() {
        return this.maxDurationSec;
    }

    public final int getProfileUnableDurationSec() {
        return this.profileUnableDurationSec;
    }

    public int hashCode() {
        return (((((((((this.profileUnableDurationSec * 31) + this.inviteCountdownSec) * 31) + this.audioGameSysTipCountdownSec) * 31) + this.maskDurationSec) * 31) + this.matchDurationSec) * 31) + this.maxDurationSec;
    }

    @NotNull
    public String toString() {
        return "VoicePartyDurationModel(profileUnableDurationSec=" + this.profileUnableDurationSec + ", inviteCountdownSec=" + this.inviteCountdownSec + ", audioGameSysTipCountdownSec=" + this.audioGameSysTipCountdownSec + ", maskDurationSec=" + this.maskDurationSec + ", matchDurationSec=" + this.matchDurationSec + ", maxDurationSec=" + this.maxDurationSec + ")";
    }
}
