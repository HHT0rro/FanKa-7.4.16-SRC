package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubCancelMsgData {
    private final boolean isMeCancel;

    @NotNull
    private final String messageId;

    @NotNull
    private final ClubChatMsgModel msgModel;

    public ClubCancelMsgData(@NotNull String messageId, @NotNull ClubChatMsgModel msgModel, boolean z10) {
        s.i(messageId, "messageId");
        s.i(msgModel, "msgModel");
        this.messageId = messageId;
        this.msgModel = msgModel;
        this.isMeCancel = z10;
    }

    public static /* synthetic */ ClubCancelMsgData copy$default(ClubCancelMsgData clubCancelMsgData, String str, ClubChatMsgModel clubChatMsgModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubCancelMsgData.messageId;
        }
        if ((i10 & 2) != 0) {
            clubChatMsgModel = clubCancelMsgData.msgModel;
        }
        if ((i10 & 4) != 0) {
            z10 = clubCancelMsgData.isMeCancel;
        }
        return clubCancelMsgData.copy(str, clubChatMsgModel, z10);
    }

    @NotNull
    public final String component1() {
        return this.messageId;
    }

    @NotNull
    public final ClubChatMsgModel component2() {
        return this.msgModel;
    }

    public final boolean component3() {
        return this.isMeCancel;
    }

    @NotNull
    public final ClubCancelMsgData copy(@NotNull String messageId, @NotNull ClubChatMsgModel msgModel, boolean z10) {
        s.i(messageId, "messageId");
        s.i(msgModel, "msgModel");
        return new ClubCancelMsgData(messageId, msgModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubCancelMsgData)) {
            return false;
        }
        ClubCancelMsgData clubCancelMsgData = (ClubCancelMsgData) obj;
        return s.d(this.messageId, clubCancelMsgData.messageId) && s.d(this.msgModel, clubCancelMsgData.msgModel) && this.isMeCancel == clubCancelMsgData.isMeCancel;
    }

    @NotNull
    public final String getMessageId() {
        return this.messageId;
    }

    @NotNull
    public final ClubChatMsgModel getMsgModel() {
        return this.msgModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.messageId.hashCode() * 31) + this.msgModel.hashCode()) * 31;
        boolean z10 = this.isMeCancel;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isMeCancel() {
        return this.isMeCancel;
    }

    @NotNull
    public String toString() {
        String str = this.messageId;
        ClubChatMsgModel clubChatMsgModel = this.msgModel;
        return "ClubCancelMsgData(messageId=" + str + ", msgModel=" + ((Object) clubChatMsgModel) + ", isMeCancel=" + this.isMeCancel + ")";
    }
}
