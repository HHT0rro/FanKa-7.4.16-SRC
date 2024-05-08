package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkCancelPrepareModel {
    private final int cancelType;

    @NotNull
    private final String liveShowId;

    @Nullable
    private final String tips;

    public MultiPkCancelPrepareModel(@NotNull String liveShowId, int i10, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.cancelType = i10;
        this.tips = str;
    }

    public static /* synthetic */ MultiPkCancelPrepareModel copy$default(MultiPkCancelPrepareModel multiPkCancelPrepareModel, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = multiPkCancelPrepareModel.liveShowId;
        }
        if ((i11 & 2) != 0) {
            i10 = multiPkCancelPrepareModel.cancelType;
        }
        if ((i11 & 4) != 0) {
            str2 = multiPkCancelPrepareModel.tips;
        }
        return multiPkCancelPrepareModel.copy(str, i10, str2);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    public final int component2() {
        return this.cancelType;
    }

    @Nullable
    public final String component3() {
        return this.tips;
    }

    @NotNull
    public final MultiPkCancelPrepareModel copy(@NotNull String liveShowId, int i10, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        return new MultiPkCancelPrepareModel(liveShowId, i10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkCancelPrepareModel)) {
            return false;
        }
        MultiPkCancelPrepareModel multiPkCancelPrepareModel = (MultiPkCancelPrepareModel) obj;
        return s.d(this.liveShowId, multiPkCancelPrepareModel.liveShowId) && this.cancelType == multiPkCancelPrepareModel.cancelType && s.d(this.tips, multiPkCancelPrepareModel.tips);
    }

    public final int getCancelType() {
        return this.cancelType;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        int hashCode = ((this.liveShowId.hashCode() * 31) + this.cancelType) * 31;
        String str = this.tips;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isInitiator() {
        return this.cancelType == PkRoleType.Initiator.getType();
    }

    @NotNull
    public String toString() {
        return "MultiPkCancelPrepareModel(liveShowId=" + this.liveShowId + ", cancelType=" + this.cancelType + ", tips=" + this.tips + ")";
    }
}
