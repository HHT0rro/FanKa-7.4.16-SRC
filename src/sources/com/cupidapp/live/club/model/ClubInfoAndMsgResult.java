package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubInfoAndMsgResult {

    @Nullable
    private final ClubChatMsgResult chatMsg;

    @Nullable
    private final ClubInfoDetailModel clubInfo;

    public ClubInfoAndMsgResult(@Nullable ClubInfoDetailModel clubInfoDetailModel, @Nullable ClubChatMsgResult clubChatMsgResult) {
        this.clubInfo = clubInfoDetailModel;
        this.chatMsg = clubChatMsgResult;
    }

    public static /* synthetic */ ClubInfoAndMsgResult copy$default(ClubInfoAndMsgResult clubInfoAndMsgResult, ClubInfoDetailModel clubInfoDetailModel, ClubChatMsgResult clubChatMsgResult, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            clubInfoDetailModel = clubInfoAndMsgResult.clubInfo;
        }
        if ((i10 & 2) != 0) {
            clubChatMsgResult = clubInfoAndMsgResult.chatMsg;
        }
        return clubInfoAndMsgResult.copy(clubInfoDetailModel, clubChatMsgResult);
    }

    @Nullable
    public final ClubInfoDetailModel component1() {
        return this.clubInfo;
    }

    @Nullable
    public final ClubChatMsgResult component2() {
        return this.chatMsg;
    }

    @NotNull
    public final ClubInfoAndMsgResult copy(@Nullable ClubInfoDetailModel clubInfoDetailModel, @Nullable ClubChatMsgResult clubChatMsgResult) {
        return new ClubInfoAndMsgResult(clubInfoDetailModel, clubChatMsgResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubInfoAndMsgResult)) {
            return false;
        }
        ClubInfoAndMsgResult clubInfoAndMsgResult = (ClubInfoAndMsgResult) obj;
        return s.d(this.clubInfo, clubInfoAndMsgResult.clubInfo) && s.d(this.chatMsg, clubInfoAndMsgResult.chatMsg);
    }

    @Nullable
    public final ClubChatMsgResult getChatMsg() {
        return this.chatMsg;
    }

    @Nullable
    public final ClubInfoDetailModel getClubInfo() {
        return this.clubInfo;
    }

    public int hashCode() {
        ClubInfoDetailModel clubInfoDetailModel = this.clubInfo;
        int hashCode = (clubInfoDetailModel == null ? 0 : clubInfoDetailModel.hashCode()) * 31;
        ClubChatMsgResult clubChatMsgResult = this.chatMsg;
        return hashCode + (clubChatMsgResult != null ? clubChatMsgResult.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClubInfoAndMsgResult(clubInfo=" + ((Object) this.clubInfo) + ", chatMsg=" + ((Object) this.chatMsg) + ")";
    }
}
