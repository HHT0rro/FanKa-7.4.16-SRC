package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchSuccessModel {

    @NotNull
    private final String roomId;

    @Nullable
    private final Integer sdkAppID;
    private final int type;

    @Nullable
    private final String userSig;

    public MaskPartyMatchSuccessModel(@NotNull String roomId, int i10, @Nullable Integer num, @Nullable String str) {
        s.i(roomId, "roomId");
        this.roomId = roomId;
        this.type = i10;
        this.sdkAppID = num;
        this.userSig = str;
    }

    public static /* synthetic */ MaskPartyMatchSuccessModel copy$default(MaskPartyMatchSuccessModel maskPartyMatchSuccessModel, String str, int i10, Integer num, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = maskPartyMatchSuccessModel.roomId;
        }
        if ((i11 & 2) != 0) {
            i10 = maskPartyMatchSuccessModel.type;
        }
        if ((i11 & 4) != 0) {
            num = maskPartyMatchSuccessModel.sdkAppID;
        }
        if ((i11 & 8) != 0) {
            str2 = maskPartyMatchSuccessModel.userSig;
        }
        return maskPartyMatchSuccessModel.copy(str, i10, num, str2);
    }

    @NotNull
    public final String component1() {
        return this.roomId;
    }

    public final int component2() {
        return this.type;
    }

    @Nullable
    public final Integer component3() {
        return this.sdkAppID;
    }

    @Nullable
    public final String component4() {
        return this.userSig;
    }

    @NotNull
    public final MaskPartyMatchSuccessModel copy(@NotNull String roomId, int i10, @Nullable Integer num, @Nullable String str) {
        s.i(roomId, "roomId");
        return new MaskPartyMatchSuccessModel(roomId, i10, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyMatchSuccessModel)) {
            return false;
        }
        MaskPartyMatchSuccessModel maskPartyMatchSuccessModel = (MaskPartyMatchSuccessModel) obj;
        return s.d(this.roomId, maskPartyMatchSuccessModel.roomId) && this.type == maskPartyMatchSuccessModel.type && s.d(this.sdkAppID, maskPartyMatchSuccessModel.sdkAppID) && s.d(this.userSig, maskPartyMatchSuccessModel.userSig);
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final Integer getSdkAppID() {
        return this.sdkAppID;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final String getUserSig() {
        return this.userSig;
    }

    public int hashCode() {
        int hashCode = ((this.roomId.hashCode() * 31) + this.type) * 31;
        Integer num = this.sdkAppID;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.userSig;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.roomId;
        int i10 = this.type;
        Integer num = this.sdkAppID;
        return "MaskPartyMatchSuccessModel(roomId=" + str + ", type=" + i10 + ", sdkAppID=" + ((Object) num) + ", userSig=" + this.userSig + ")";
    }
}
