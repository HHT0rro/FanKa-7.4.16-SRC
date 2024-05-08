package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowDiamondBalanceModel {

    @Nullable
    private final String balance;
    private final boolean closeShowRequest;

    @NotNull
    private final String roomId;

    @Nullable
    private final String tips;

    public ShowDiamondBalanceModel(@Nullable String str, @NotNull String roomId, @Nullable String str2, boolean z10) {
        s.i(roomId, "roomId");
        this.balance = str;
        this.roomId = roomId;
        this.tips = str2;
        this.closeShowRequest = z10;
    }

    public static /* synthetic */ ShowDiamondBalanceModel copy$default(ShowDiamondBalanceModel showDiamondBalanceModel, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = showDiamondBalanceModel.balance;
        }
        if ((i10 & 2) != 0) {
            str2 = showDiamondBalanceModel.roomId;
        }
        if ((i10 & 4) != 0) {
            str3 = showDiamondBalanceModel.tips;
        }
        if ((i10 & 8) != 0) {
            z10 = showDiamondBalanceModel.closeShowRequest;
        }
        return showDiamondBalanceModel.copy(str, str2, str3, z10);
    }

    @Nullable
    public final String component1() {
        return this.balance;
    }

    @NotNull
    public final String component2() {
        return this.roomId;
    }

    @Nullable
    public final String component3() {
        return this.tips;
    }

    public final boolean component4() {
        return this.closeShowRequest;
    }

    @NotNull
    public final ShowDiamondBalanceModel copy(@Nullable String str, @NotNull String roomId, @Nullable String str2, boolean z10) {
        s.i(roomId, "roomId");
        return new ShowDiamondBalanceModel(str, roomId, str2, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowDiamondBalanceModel)) {
            return false;
        }
        ShowDiamondBalanceModel showDiamondBalanceModel = (ShowDiamondBalanceModel) obj;
        return s.d(this.balance, showDiamondBalanceModel.balance) && s.d(this.roomId, showDiamondBalanceModel.roomId) && s.d(this.tips, showDiamondBalanceModel.tips) && this.closeShowRequest == showDiamondBalanceModel.closeShowRequest;
    }

    @Nullable
    public final String getBalance() {
        return this.balance;
    }

    public final boolean getCloseShowRequest() {
        return this.closeShowRequest;
    }

    @NotNull
    public final String getRoomId() {
        return this.roomId;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.balance;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.roomId.hashCode()) * 31;
        String str2 = this.tips;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.closeShowRequest;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    @NotNull
    public String toString() {
        return "ShowDiamondBalanceModel(balance=" + this.balance + ", roomId=" + this.roomId + ", tips=" + this.tips + ", closeShowRequest=" + this.closeShowRequest + ")";
    }
}
