package com.cupidapp.live.club.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubRedPacketResult {

    @Nullable
    private final List<ClubRedPacketModel> list;

    @Nullable
    private final String walletPayUrl;

    public ClubRedPacketResult(@Nullable List<ClubRedPacketModel> list, @Nullable String str) {
        this.list = list;
        this.walletPayUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClubRedPacketResult copy$default(ClubRedPacketResult clubRedPacketResult, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = clubRedPacketResult.list;
        }
        if ((i10 & 2) != 0) {
            str = clubRedPacketResult.walletPayUrl;
        }
        return clubRedPacketResult.copy(list, str);
    }

    @Nullable
    public final List<ClubRedPacketModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.walletPayUrl;
    }

    @NotNull
    public final ClubRedPacketResult copy(@Nullable List<ClubRedPacketModel> list, @Nullable String str) {
        return new ClubRedPacketResult(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubRedPacketResult)) {
            return false;
        }
        ClubRedPacketResult clubRedPacketResult = (ClubRedPacketResult) obj;
        return s.d(this.list, clubRedPacketResult.list) && s.d(this.walletPayUrl, clubRedPacketResult.walletPayUrl);
    }

    @Nullable
    public final List<ClubRedPacketModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getWalletPayUrl() {
        return this.walletPayUrl;
    }

    public int hashCode() {
        List<ClubRedPacketModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.walletPayUrl;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<ClubRedPacketModel> list = this.list;
        return "ClubRedPacketResult(list=" + ((Object) list) + ", walletPayUrl=" + this.walletPayUrl + ")";
    }
}
