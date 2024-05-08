package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkStartModel {
    private final int countdownSec;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String pkPairId;

    @NotNull
    private final String pkPrepareId;

    public MultiPkStartModel(int i10, @NotNull String pkPrepareId, @NotNull String pkPairId, @NotNull String jumpUrl) {
        s.i(pkPrepareId, "pkPrepareId");
        s.i(pkPairId, "pkPairId");
        s.i(jumpUrl, "jumpUrl");
        this.countdownSec = i10;
        this.pkPrepareId = pkPrepareId;
        this.pkPairId = pkPairId;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ MultiPkStartModel copy$default(MultiPkStartModel multiPkStartModel, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = multiPkStartModel.countdownSec;
        }
        if ((i11 & 2) != 0) {
            str = multiPkStartModel.pkPrepareId;
        }
        if ((i11 & 4) != 0) {
            str2 = multiPkStartModel.pkPairId;
        }
        if ((i11 & 8) != 0) {
            str3 = multiPkStartModel.jumpUrl;
        }
        return multiPkStartModel.copy(i10, str, str2, str3);
    }

    public final int component1() {
        return this.countdownSec;
    }

    @NotNull
    public final String component2() {
        return this.pkPrepareId;
    }

    @NotNull
    public final String component3() {
        return this.pkPairId;
    }

    @NotNull
    public final String component4() {
        return this.jumpUrl;
    }

    @NotNull
    public final MultiPkStartModel copy(int i10, @NotNull String pkPrepareId, @NotNull String pkPairId, @NotNull String jumpUrl) {
        s.i(pkPrepareId, "pkPrepareId");
        s.i(pkPairId, "pkPairId");
        s.i(jumpUrl, "jumpUrl");
        return new MultiPkStartModel(i10, pkPrepareId, pkPairId, jumpUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkStartModel)) {
            return false;
        }
        MultiPkStartModel multiPkStartModel = (MultiPkStartModel) obj;
        return this.countdownSec == multiPkStartModel.countdownSec && s.d(this.pkPrepareId, multiPkStartModel.pkPrepareId) && s.d(this.pkPairId, multiPkStartModel.pkPairId) && s.d(this.jumpUrl, multiPkStartModel.jumpUrl);
    }

    public final int getCountdownSec() {
        return this.countdownSec;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getPkPairId() {
        return this.pkPairId;
    }

    @NotNull
    public final String getPkPrepareId() {
        return this.pkPrepareId;
    }

    public int hashCode() {
        return (((((this.countdownSec * 31) + this.pkPrepareId.hashCode()) * 31) + this.pkPairId.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkStartModel(countdownSec=" + this.countdownSec + ", pkPrepareId=" + this.pkPrepareId + ", pkPairId=" + this.pkPairId + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
