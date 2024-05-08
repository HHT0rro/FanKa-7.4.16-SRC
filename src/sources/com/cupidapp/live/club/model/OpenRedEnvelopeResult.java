package com.cupidapp.live.club.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenRedEnvelopeResult {

    @Nullable
    private final String earningJumpUrl;

    @NotNull
    private final List<WinLotteryUserModel> list;

    @Nullable
    private final String ticket;

    @Nullable
    private final String tipMessage;

    public OpenRedEnvelopeResult(@Nullable String str, @Nullable String str2, @NotNull List<WinLotteryUserModel> list, @Nullable String str3) {
        s.i(list, "list");
        this.ticket = str;
        this.earningJumpUrl = str2;
        this.list = list;
        this.tipMessage = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenRedEnvelopeResult copy$default(OpenRedEnvelopeResult openRedEnvelopeResult, String str, String str2, List list, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = openRedEnvelopeResult.ticket;
        }
        if ((i10 & 2) != 0) {
            str2 = openRedEnvelopeResult.earningJumpUrl;
        }
        if ((i10 & 4) != 0) {
            list = openRedEnvelopeResult.list;
        }
        if ((i10 & 8) != 0) {
            str3 = openRedEnvelopeResult.tipMessage;
        }
        return openRedEnvelopeResult.copy(str, str2, list, str3);
    }

    @Nullable
    public final String component1() {
        return this.ticket;
    }

    @Nullable
    public final String component2() {
        return this.earningJumpUrl;
    }

    @NotNull
    public final List<WinLotteryUserModel> component3() {
        return this.list;
    }

    @Nullable
    public final String component4() {
        return this.tipMessage;
    }

    @NotNull
    public final OpenRedEnvelopeResult copy(@Nullable String str, @Nullable String str2, @NotNull List<WinLotteryUserModel> list, @Nullable String str3) {
        s.i(list, "list");
        return new OpenRedEnvelopeResult(str, str2, list, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenRedEnvelopeResult)) {
            return false;
        }
        OpenRedEnvelopeResult openRedEnvelopeResult = (OpenRedEnvelopeResult) obj;
        return s.d(this.ticket, openRedEnvelopeResult.ticket) && s.d(this.earningJumpUrl, openRedEnvelopeResult.earningJumpUrl) && s.d(this.list, openRedEnvelopeResult.list) && s.d(this.tipMessage, openRedEnvelopeResult.tipMessage);
    }

    @Nullable
    public final String getEarningJumpUrl() {
        return this.earningJumpUrl;
    }

    @NotNull
    public final List<WinLotteryUserModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getTicket() {
        return this.ticket;
    }

    @Nullable
    public final String getTipMessage() {
        return this.tipMessage;
    }

    public int hashCode() {
        String str = this.ticket;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.earningJumpUrl;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.list.hashCode()) * 31;
        String str3 = this.tipMessage;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.ticket;
        String str2 = this.earningJumpUrl;
        List<WinLotteryUserModel> list = this.list;
        return "OpenRedEnvelopeResult(ticket=" + str + ", earningJumpUrl=" + str2 + ", list=" + ((Object) list) + ", tipMessage=" + this.tipMessage + ")";
    }
}
