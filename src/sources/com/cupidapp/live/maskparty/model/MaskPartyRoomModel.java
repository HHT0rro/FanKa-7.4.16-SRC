package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyRecommendModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyRoomModel {

    @NotNull
    private final String roomId;

    public MaskPartyRoomModel(@NotNull String roomId) {
        s.i(roomId, "roomId");
        this.roomId = roomId;
    }

    public static /* synthetic */ MaskPartyRoomModel copy$default(MaskPartyRoomModel maskPartyRoomModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = maskPartyRoomModel.roomId;
        }
        return maskPartyRoomModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.roomId;
    }

    @NotNull
    public final MaskPartyRoomModel copy(@NotNull String roomId) {
        s.i(roomId, "roomId");
        return new MaskPartyRoomModel(roomId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MaskPartyRoomModel) && s.d(this.roomId, ((MaskPartyRoomModel) obj).roomId);
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return this.roomId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyRoomModel(roomId=" + this.roomId + ")";
    }
}
