package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkMuteOthersModel {
    private final boolean close;

    @NotNull
    private final String liveShowId;

    public MultiPkMuteOthersModel(@NotNull String liveShowId, boolean z10) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.close = z10;
    }

    public static /* synthetic */ MultiPkMuteOthersModel copy$default(MultiPkMuteOthersModel multiPkMuteOthersModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkMuteOthersModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            z10 = multiPkMuteOthersModel.close;
        }
        return multiPkMuteOthersModel.copy(str, z10);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    public final boolean component2() {
        return this.close;
    }

    @NotNull
    public final MultiPkMuteOthersModel copy(@NotNull String liveShowId, boolean z10) {
        s.i(liveShowId, "liveShowId");
        return new MultiPkMuteOthersModel(liveShowId, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkMuteOthersModel)) {
            return false;
        }
        MultiPkMuteOthersModel multiPkMuteOthersModel = (MultiPkMuteOthersModel) obj;
        return s.d(this.liveShowId, multiPkMuteOthersModel.liveShowId) && this.close == multiPkMuteOthersModel.close;
    }

    public final boolean getClose() {
        return this.close;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        boolean z10 = this.close;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return "MultiPkMuteOthersModel(liveShowId=" + this.liveShowId + ", close=" + this.close + ")";
    }
}
