package com.cupidapp.live.voiceparty.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyRoomModel implements Serializable {

    @NotNull
    private final VoicePartyDurationModel audioGameInfo;

    @NotNull
    private final ImageModel maskAvatar;
    private final int matchStatus;

    @NotNull
    private final String roomId;

    @NotNull
    private final User targetUserInfo;

    public VoicePartyRoomModel(@NotNull String roomId, @NotNull ImageModel maskAvatar, @NotNull User targetUserInfo, @NotNull VoicePartyDurationModel audioGameInfo, int i10) {
        s.i(roomId, "roomId");
        s.i(maskAvatar, "maskAvatar");
        s.i(targetUserInfo, "targetUserInfo");
        s.i(audioGameInfo, "audioGameInfo");
        this.roomId = roomId;
        this.maskAvatar = maskAvatar;
        this.targetUserInfo = targetUserInfo;
        this.audioGameInfo = audioGameInfo;
        this.matchStatus = i10;
    }

    private final int component5() {
        return this.matchStatus;
    }

    public static /* synthetic */ VoicePartyRoomModel copy$default(VoicePartyRoomModel voicePartyRoomModel, String str, ImageModel imageModel, User user, VoicePartyDurationModel voicePartyDurationModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voicePartyRoomModel.roomId;
        }
        if ((i11 & 2) != 0) {
            imageModel = voicePartyRoomModel.maskAvatar;
        }
        ImageModel imageModel2 = imageModel;
        if ((i11 & 4) != 0) {
            user = voicePartyRoomModel.targetUserInfo;
        }
        User user2 = user;
        if ((i11 & 8) != 0) {
            voicePartyDurationModel = voicePartyRoomModel.audioGameInfo;
        }
        VoicePartyDurationModel voicePartyDurationModel2 = voicePartyDurationModel;
        if ((i11 & 16) != 0) {
            i10 = voicePartyRoomModel.matchStatus;
        }
        return voicePartyRoomModel.copy(str, imageModel2, user2, voicePartyDurationModel2, i10);
    }

    @NotNull
    public final String component1() {
        return this.roomId;
    }

    @NotNull
    public final ImageModel component2() {
        return this.maskAvatar;
    }

    @NotNull
    public final User component3() {
        return this.targetUserInfo;
    }

    @NotNull
    public final VoicePartyDurationModel component4() {
        return this.audioGameInfo;
    }

    @NotNull
    public final VoicePartyRoomModel copy(@NotNull String roomId, @NotNull ImageModel maskAvatar, @NotNull User targetUserInfo, @NotNull VoicePartyDurationModel audioGameInfo, int i10) {
        s.i(roomId, "roomId");
        s.i(maskAvatar, "maskAvatar");
        s.i(targetUserInfo, "targetUserInfo");
        s.i(audioGameInfo, "audioGameInfo");
        return new VoicePartyRoomModel(roomId, maskAvatar, targetUserInfo, audioGameInfo, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoicePartyRoomModel)) {
            return false;
        }
        VoicePartyRoomModel voicePartyRoomModel = (VoicePartyRoomModel) obj;
        return s.d(this.roomId, voicePartyRoomModel.roomId) && s.d(this.maskAvatar, voicePartyRoomModel.maskAvatar) && s.d(this.targetUserInfo, voicePartyRoomModel.targetUserInfo) && s.d(this.audioGameInfo, voicePartyRoomModel.audioGameInfo) && this.matchStatus == voicePartyRoomModel.matchStatus;
    }

    @NotNull
    public final VoicePartyDurationModel getAudioGameInfo() {
        return this.audioGameInfo;
    }

    @NotNull
    public final ImageModel getMaskAvatar() {
        return this.maskAvatar;
    }

    @NotNull
    public final VoicePartyRelationStatus getRelationStatus() {
        int i10 = this.matchStatus;
        if (i10 == 0) {
            return VoicePartyRelationStatus.NO_RELATIONSHIP;
        }
        if (i10 == 1) {
            return VoicePartyRelationStatus.ME_FOLLOW_OTHER;
        }
        if (i10 == 2) {
            return VoicePartyRelationStatus.OTHER_FOLLOW_ME;
        }
        if (i10 != 3) {
            return VoicePartyRelationStatus.NO_RELATIONSHIP;
        }
        return VoicePartyRelationStatus.MATCH;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final User getTargetUserInfo() {
        return this.targetUserInfo;
    }

    public int hashCode() {
        return (((((((this.roomId.hashCode() * 31) + this.maskAvatar.hashCode()) * 31) + this.targetUserInfo.hashCode()) * 31) + this.audioGameInfo.hashCode()) * 31) + this.matchStatus;
    }

    @NotNull
    public String toString() {
        String str = this.roomId;
        ImageModel imageModel = this.maskAvatar;
        User user = this.targetUserInfo;
        VoicePartyDurationModel voicePartyDurationModel = this.audioGameInfo;
        return "VoicePartyRoomModel(roomId=" + str + ", maskAvatar=" + ((Object) imageModel) + ", targetUserInfo=" + ((Object) user) + ", audioGameInfo=" + ((Object) voicePartyDurationModel) + ", matchStatus=" + this.matchStatus + ")";
    }
}
