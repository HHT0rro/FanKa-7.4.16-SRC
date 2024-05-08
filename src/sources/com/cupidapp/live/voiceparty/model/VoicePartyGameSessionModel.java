package com.cupidapp.live.voiceparty.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyGameSessionModel implements Serializable {
    private final int btnCountdownSec;

    @Nullable
    private final String desc;
    private final int showCountdownSec;

    @Nullable
    private final String tip;

    @Nullable
    private final String title;

    @NotNull
    private final VoicePartyGameSessionType type;

    public VoicePartyGameSessionModel(@NotNull VoicePartyGameSessionType type, @Nullable String str, @Nullable String str2, int i10, int i11, @Nullable String str3) {
        s.i(type, "type");
        this.type = type;
        this.title = str;
        this.desc = str2;
        this.btnCountdownSec = i10;
        this.showCountdownSec = i11;
        this.tip = str3;
    }

    public static /* synthetic */ VoicePartyGameSessionModel copy$default(VoicePartyGameSessionModel voicePartyGameSessionModel, VoicePartyGameSessionType voicePartyGameSessionType, String str, String str2, int i10, int i11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            voicePartyGameSessionType = voicePartyGameSessionModel.type;
        }
        if ((i12 & 2) != 0) {
            str = voicePartyGameSessionModel.title;
        }
        String str4 = str;
        if ((i12 & 4) != 0) {
            str2 = voicePartyGameSessionModel.desc;
        }
        String str5 = str2;
        if ((i12 & 8) != 0) {
            i10 = voicePartyGameSessionModel.btnCountdownSec;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = voicePartyGameSessionModel.showCountdownSec;
        }
        int i14 = i11;
        if ((i12 & 32) != 0) {
            str3 = voicePartyGameSessionModel.tip;
        }
        return voicePartyGameSessionModel.copy(voicePartyGameSessionType, str4, str5, i13, i14, str3);
    }

    @NotNull
    public final VoicePartyGameSessionType component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.desc;
    }

    public final int component4() {
        return this.btnCountdownSec;
    }

    public final int component5() {
        return this.showCountdownSec;
    }

    @Nullable
    public final String component6() {
        return this.tip;
    }

    @NotNull
    public final VoicePartyGameSessionModel copy(@NotNull VoicePartyGameSessionType type, @Nullable String str, @Nullable String str2, int i10, int i11, @Nullable String str3) {
        s.i(type, "type");
        return new VoicePartyGameSessionModel(type, str, str2, i10, i11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoicePartyGameSessionModel)) {
            return false;
        }
        VoicePartyGameSessionModel voicePartyGameSessionModel = (VoicePartyGameSessionModel) obj;
        return this.type == voicePartyGameSessionModel.type && s.d(this.title, voicePartyGameSessionModel.title) && s.d(this.desc, voicePartyGameSessionModel.desc) && this.btnCountdownSec == voicePartyGameSessionModel.btnCountdownSec && this.showCountdownSec == voicePartyGameSessionModel.showCountdownSec && s.d(this.tip, voicePartyGameSessionModel.tip);
    }

    public final int getBtnCountdownSec() {
        return this.btnCountdownSec;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public final int getShowCountdownSec() {
        return this.showCountdownSec;
    }

    @Nullable
    public final String getTip() {
        return this.tip;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final VoicePartyGameSessionType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.desc;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.btnCountdownSec) * 31) + this.showCountdownSec) * 31;
        String str3 = this.tip;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isShowVoiceGameBtn() {
        VoicePartyGameSessionType voicePartyGameSessionType = this.type;
        return voicePartyGameSessionType == VoicePartyGameSessionType.ASK_QUESTION || voicePartyGameSessionType == VoicePartyGameSessionType.LOSE_SHOW_QUESTION_CONTENT;
    }

    @NotNull
    public String toString() {
        VoicePartyGameSessionType voicePartyGameSessionType = this.type;
        return "VoicePartyGameSessionModel(type=" + ((Object) voicePartyGameSessionType) + ", title=" + this.title + ", desc=" + this.desc + ", btnCountdownSec=" + this.btnCountdownSec + ", showCountdownSec=" + this.showCountdownSec + ", tip=" + this.tip + ")";
    }

    public /* synthetic */ VoicePartyGameSessionModel(VoicePartyGameSessionType voicePartyGameSessionType, String str, String str2, int i10, int i11, String str3, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(voicePartyGameSessionType, str, str2, (i12 & 8) != 0 ? 0 : i10, (i12 & 16) != 0 ? 0 : i11, (i12 & 32) != 0 ? null : str3);
    }
}
