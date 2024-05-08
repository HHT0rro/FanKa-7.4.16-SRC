package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SocialGameConfigModel {

    @Nullable
    private final MaskPartyAddTimesModel audioGameRoom;

    @Nullable
    private final MaskPartyAddTimesModel maskRoom;

    public SocialGameConfigModel(@Nullable MaskPartyAddTimesModel maskPartyAddTimesModel, @Nullable MaskPartyAddTimesModel maskPartyAddTimesModel2) {
        this.maskRoom = maskPartyAddTimesModel;
        this.audioGameRoom = maskPartyAddTimesModel2;
    }

    public static /* synthetic */ SocialGameConfigModel copy$default(SocialGameConfigModel socialGameConfigModel, MaskPartyAddTimesModel maskPartyAddTimesModel, MaskPartyAddTimesModel maskPartyAddTimesModel2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            maskPartyAddTimesModel = socialGameConfigModel.maskRoom;
        }
        if ((i10 & 2) != 0) {
            maskPartyAddTimesModel2 = socialGameConfigModel.audioGameRoom;
        }
        return socialGameConfigModel.copy(maskPartyAddTimesModel, maskPartyAddTimesModel2);
    }

    @Nullable
    public final MaskPartyAddTimesModel component1() {
        return this.maskRoom;
    }

    @Nullable
    public final MaskPartyAddTimesModel component2() {
        return this.audioGameRoom;
    }

    @NotNull
    public final SocialGameConfigModel copy(@Nullable MaskPartyAddTimesModel maskPartyAddTimesModel, @Nullable MaskPartyAddTimesModel maskPartyAddTimesModel2) {
        return new SocialGameConfigModel(maskPartyAddTimesModel, maskPartyAddTimesModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SocialGameConfigModel)) {
            return false;
        }
        SocialGameConfigModel socialGameConfigModel = (SocialGameConfigModel) obj;
        return s.d(this.maskRoom, socialGameConfigModel.maskRoom) && s.d(this.audioGameRoom, socialGameConfigModel.audioGameRoom);
    }

    @Nullable
    public final MaskPartyAddTimesModel getAudioGameRoom() {
        return this.audioGameRoom;
    }

    @Nullable
    public final MaskPartyAddTimesModel getMaskRoom() {
        return this.maskRoom;
    }

    public int hashCode() {
        MaskPartyAddTimesModel maskPartyAddTimesModel = this.maskRoom;
        int hashCode = (maskPartyAddTimesModel == null ? 0 : maskPartyAddTimesModel.hashCode()) * 31;
        MaskPartyAddTimesModel maskPartyAddTimesModel2 = this.audioGameRoom;
        return hashCode + (maskPartyAddTimesModel2 != null ? maskPartyAddTimesModel2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SocialGameConfigModel(maskRoom=" + ((Object) this.maskRoom) + ", audioGameRoom=" + ((Object) this.audioGameRoom) + ")";
    }
}
