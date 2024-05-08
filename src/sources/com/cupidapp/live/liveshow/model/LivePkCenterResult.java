package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkCenterResult {

    @Nullable
    private final Boolean multiplayerSwitch;
    private final int onlineLiveFriendCount;
    private final int onlineLiveShowCount;
    private final int pkRequestCount;

    @NotNull
    private final String pkRulePath;

    public LivePkCenterResult(int i10, int i11, @NotNull String pkRulePath, int i12, @Nullable Boolean bool) {
        s.i(pkRulePath, "pkRulePath");
        this.pkRequestCount = i10;
        this.onlineLiveFriendCount = i11;
        this.pkRulePath = pkRulePath;
        this.onlineLiveShowCount = i12;
        this.multiplayerSwitch = bool;
    }

    public static /* synthetic */ LivePkCenterResult copy$default(LivePkCenterResult livePkCenterResult, int i10, int i11, String str, int i12, Boolean bool, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = livePkCenterResult.pkRequestCount;
        }
        if ((i13 & 2) != 0) {
            i11 = livePkCenterResult.onlineLiveFriendCount;
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            str = livePkCenterResult.pkRulePath;
        }
        String str2 = str;
        if ((i13 & 8) != 0) {
            i12 = livePkCenterResult.onlineLiveShowCount;
        }
        int i15 = i12;
        if ((i13 & 16) != 0) {
            bool = livePkCenterResult.multiplayerSwitch;
        }
        return livePkCenterResult.copy(i10, i14, str2, i15, bool);
    }

    public final int component1() {
        return this.pkRequestCount;
    }

    public final int component2() {
        return this.onlineLiveFriendCount;
    }

    @NotNull
    public final String component3() {
        return this.pkRulePath;
    }

    public final int component4() {
        return this.onlineLiveShowCount;
    }

    @Nullable
    public final Boolean component5() {
        return this.multiplayerSwitch;
    }

    @NotNull
    public final LivePkCenterResult copy(int i10, int i11, @NotNull String pkRulePath, int i12, @Nullable Boolean bool) {
        s.i(pkRulePath, "pkRulePath");
        return new LivePkCenterResult(i10, i11, pkRulePath, i12, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkCenterResult)) {
            return false;
        }
        LivePkCenterResult livePkCenterResult = (LivePkCenterResult) obj;
        return this.pkRequestCount == livePkCenterResult.pkRequestCount && this.onlineLiveFriendCount == livePkCenterResult.onlineLiveFriendCount && s.d(this.pkRulePath, livePkCenterResult.pkRulePath) && this.onlineLiveShowCount == livePkCenterResult.onlineLiveShowCount && s.d(this.multiplayerSwitch, livePkCenterResult.multiplayerSwitch);
    }

    @Nullable
    public final Boolean getMultiplayerSwitch() {
        return this.multiplayerSwitch;
    }

    public final int getOnlineLiveFriendCount() {
        return this.onlineLiveFriendCount;
    }

    public final int getOnlineLiveShowCount() {
        return this.onlineLiveShowCount;
    }

    public final int getPkRequestCount() {
        return this.pkRequestCount;
    }

    @NotNull
    public final String getPkRulePath() {
        return this.pkRulePath;
    }

    public int hashCode() {
        int hashCode = ((((((this.pkRequestCount * 31) + this.onlineLiveFriendCount) * 31) + this.pkRulePath.hashCode()) * 31) + this.onlineLiveShowCount) * 31;
        Boolean bool = this.multiplayerSwitch;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    @NotNull
    public String toString() {
        return "LivePkCenterResult(pkRequestCount=" + this.pkRequestCount + ", onlineLiveFriendCount=" + this.onlineLiveFriendCount + ", pkRulePath=" + this.pkRulePath + ", onlineLiveShowCount=" + this.onlineLiveShowCount + ", multiplayerSwitch=" + ((Object) this.multiplayerSwitch) + ")";
    }
}
