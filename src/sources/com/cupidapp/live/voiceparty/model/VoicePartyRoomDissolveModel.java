package com.cupidapp.live.voiceparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyRoomDissolveModel {

    @NotNull
    private final String reason;

    @NotNull
    private final String roomId;

    @NotNull
    private final String title;

    public VoicePartyRoomDissolveModel(@NotNull String roomId, @NotNull String title, @NotNull String reason) {
        s.i(roomId, "roomId");
        s.i(title, "title");
        s.i(reason, "reason");
        this.roomId = roomId;
        this.title = title;
        this.reason = reason;
    }

    public static /* synthetic */ VoicePartyRoomDissolveModel copy$default(VoicePartyRoomDissolveModel voicePartyRoomDissolveModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = voicePartyRoomDissolveModel.roomId;
        }
        if ((i10 & 2) != 0) {
            str2 = voicePartyRoomDissolveModel.title;
        }
        if ((i10 & 4) != 0) {
            str3 = voicePartyRoomDissolveModel.reason;
        }
        return voicePartyRoomDissolveModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.roomId;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.reason;
    }

    @NotNull
    public final VoicePartyRoomDissolveModel copy(@NotNull String roomId, @NotNull String title, @NotNull String reason) {
        s.i(roomId, "roomId");
        s.i(title, "title");
        s.i(reason, "reason");
        return new VoicePartyRoomDissolveModel(roomId, title, reason);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoicePartyRoomDissolveModel)) {
            return false;
        }
        VoicePartyRoomDissolveModel voicePartyRoomDissolveModel = (VoicePartyRoomDissolveModel) obj;
        return s.d(this.roomId, voicePartyRoomDissolveModel.roomId) && s.d(this.title, voicePartyRoomDissolveModel.title) && s.d(this.reason, voicePartyRoomDissolveModel.reason);
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.roomId.hashCode() * 31) + this.title.hashCode()) * 31) + this.reason.hashCode();
    }

    @NotNull
    public String toString() {
        return "VoicePartyRoomDissolveModel(roomId=" + this.roomId + ", title=" + this.title + ", reason=" + this.reason + ")";
    }
}
