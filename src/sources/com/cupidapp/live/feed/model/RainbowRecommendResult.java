package com.cupidapp.live.feed.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitFriendsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RainbowRecommendResult {

    @NotNull
    private final List<User> list;

    @Nullable
    private final String nextCursorId;
    private final boolean specialExposureSetting;
    private final boolean ssvipRequired;

    public RainbowRecommendResult(@Nullable String str, boolean z10, boolean z11, @NotNull List<User> list) {
        s.i(list, "list");
        this.nextCursorId = str;
        this.specialExposureSetting = z10;
        this.ssvipRequired = z11;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RainbowRecommendResult copy$default(RainbowRecommendResult rainbowRecommendResult, String str, boolean z10, boolean z11, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = rainbowRecommendResult.nextCursorId;
        }
        if ((i10 & 2) != 0) {
            z10 = rainbowRecommendResult.specialExposureSetting;
        }
        if ((i10 & 4) != 0) {
            z11 = rainbowRecommendResult.ssvipRequired;
        }
        if ((i10 & 8) != 0) {
            list = rainbowRecommendResult.list;
        }
        return rainbowRecommendResult.copy(str, z10, z11, list);
    }

    @Nullable
    public final String component1() {
        return this.nextCursorId;
    }

    public final boolean component2() {
        return this.specialExposureSetting;
    }

    public final boolean component3() {
        return this.ssvipRequired;
    }

    @NotNull
    public final List<User> component4() {
        return this.list;
    }

    @NotNull
    public final RainbowRecommendResult copy(@Nullable String str, boolean z10, boolean z11, @NotNull List<User> list) {
        s.i(list, "list");
        return new RainbowRecommendResult(str, z10, z11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RainbowRecommendResult)) {
            return false;
        }
        RainbowRecommendResult rainbowRecommendResult = (RainbowRecommendResult) obj;
        return s.d(this.nextCursorId, rainbowRecommendResult.nextCursorId) && this.specialExposureSetting == rainbowRecommendResult.specialExposureSetting && this.ssvipRequired == rainbowRecommendResult.ssvipRequired && s.d(this.list, rainbowRecommendResult.list);
    }

    @NotNull
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public final boolean getSpecialExposureSetting() {
        return this.specialExposureSetting;
    }

    public final boolean getSsvipRequired() {
        return this.ssvipRequired;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.nextCursorId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.specialExposureSetting;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.ssvipRequired;
        return ((i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "RainbowRecommendResult(nextCursorId=" + this.nextCursorId + ", specialExposureSetting=" + this.specialExposureSetting + ", ssvipRequired=" + this.ssvipRequired + ", list=" + ((Object) this.list) + ")";
    }
}
