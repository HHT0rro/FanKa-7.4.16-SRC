package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkEndModel {
    private final boolean ended;
    private final int endingType;

    @NotNull
    private final String liveShowId;

    @Nullable
    private final String tips;

    public MultiPkEndModel(@NotNull String liveShowId, int i10, boolean z10, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.endingType = i10;
        this.ended = z10;
        this.tips = str;
    }

    public static /* synthetic */ MultiPkEndModel copy$default(MultiPkEndModel multiPkEndModel, String str, int i10, boolean z10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = multiPkEndModel.liveShowId;
        }
        if ((i11 & 2) != 0) {
            i10 = multiPkEndModel.endingType;
        }
        if ((i11 & 4) != 0) {
            z10 = multiPkEndModel.ended;
        }
        if ((i11 & 8) != 0) {
            str2 = multiPkEndModel.tips;
        }
        return multiPkEndModel.copy(str, i10, z10, str2);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    public final int component2() {
        return this.endingType;
    }

    public final boolean component3() {
        return this.ended;
    }

    @Nullable
    public final String component4() {
        return this.tips;
    }

    @NotNull
    public final MultiPkEndModel copy(@NotNull String liveShowId, int i10, boolean z10, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        return new MultiPkEndModel(liveShowId, i10, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkEndModel)) {
            return false;
        }
        MultiPkEndModel multiPkEndModel = (MultiPkEndModel) obj;
        return s.d(this.liveShowId, multiPkEndModel.liveShowId) && this.endingType == multiPkEndModel.endingType && this.ended == multiPkEndModel.ended && s.d(this.tips, multiPkEndModel.tips);
    }

    public final boolean getEnded() {
        return this.ended;
    }

    public final int getEndingType() {
        return this.endingType;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.liveShowId.hashCode() * 31) + this.endingType) * 31;
        boolean z10 = this.ended;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.tips;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isInitiator() {
        return this.endingType == PkRoleType.Initiator.getType();
    }

    @NotNull
    public String toString() {
        return "MultiPkEndModel(liveShowId=" + this.liveShowId + ", endingType=" + this.endingType + ", ended=" + this.ended + ", tips=" + this.tips + ")";
    }
}
