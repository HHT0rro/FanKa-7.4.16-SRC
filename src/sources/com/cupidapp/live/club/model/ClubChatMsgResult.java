package com.cupidapp.live.club.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatMsgResult {

    @Nullable
    private final String firstUnreadMsgId;

    @Nullable
    private final List<ClubChatMsgModel> list;

    @Nullable
    private final String unreadTip;

    public ClubChatMsgResult(@Nullable List<ClubChatMsgModel> list, @Nullable String str, @Nullable String str2) {
        this.list = list;
        this.unreadTip = str;
        this.firstUnreadMsgId = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClubChatMsgResult copy$default(ClubChatMsgResult clubChatMsgResult, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = clubChatMsgResult.list;
        }
        if ((i10 & 2) != 0) {
            str = clubChatMsgResult.unreadTip;
        }
        if ((i10 & 4) != 0) {
            str2 = clubChatMsgResult.firstUnreadMsgId;
        }
        return clubChatMsgResult.copy(list, str, str2);
    }

    @Nullable
    public final List<ClubChatMsgModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.unreadTip;
    }

    @Nullable
    public final String component3() {
        return this.firstUnreadMsgId;
    }

    @NotNull
    public final ClubChatMsgResult copy(@Nullable List<ClubChatMsgModel> list, @Nullable String str, @Nullable String str2) {
        return new ClubChatMsgResult(list, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubChatMsgResult)) {
            return false;
        }
        ClubChatMsgResult clubChatMsgResult = (ClubChatMsgResult) obj;
        return s.d(this.list, clubChatMsgResult.list) && s.d(this.unreadTip, clubChatMsgResult.unreadTip) && s.d(this.firstUnreadMsgId, clubChatMsgResult.firstUnreadMsgId);
    }

    @Nullable
    public final String getFirstUnreadMsgId() {
        return this.firstUnreadMsgId;
    }

    @Nullable
    public final List<ClubChatMsgModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getUnreadTip() {
        return this.unreadTip;
    }

    public int hashCode() {
        List<ClubChatMsgModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.unreadTip;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.firstUnreadMsgId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<ClubChatMsgModel> list = this.list;
        return "ClubChatMsgResult(list=" + ((Object) list) + ", unreadTip=" + this.unreadTip + ", firstUnreadMsgId=" + this.firstUnreadMsgId + ")";
    }
}
