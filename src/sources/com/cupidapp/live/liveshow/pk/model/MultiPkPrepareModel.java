package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkPrepareModel {

    @NotNull
    private final String mixStreamId;

    @NotNull
    private final String pkPrepareId;

    @Nullable
    private final String rtmpUrlPrefix;

    public MultiPkPrepareModel(@NotNull String mixStreamId, @NotNull String pkPrepareId, @Nullable String str) {
        s.i(mixStreamId, "mixStreamId");
        s.i(pkPrepareId, "pkPrepareId");
        this.mixStreamId = mixStreamId;
        this.pkPrepareId = pkPrepareId;
        this.rtmpUrlPrefix = str;
    }

    public static /* synthetic */ MultiPkPrepareModel copy$default(MultiPkPrepareModel multiPkPrepareModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkPrepareModel.mixStreamId;
        }
        if ((i10 & 2) != 0) {
            str2 = multiPkPrepareModel.pkPrepareId;
        }
        if ((i10 & 4) != 0) {
            str3 = multiPkPrepareModel.rtmpUrlPrefix;
        }
        return multiPkPrepareModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.mixStreamId;
    }

    @NotNull
    public final String component2() {
        return this.pkPrepareId;
    }

    @Nullable
    public final String component3() {
        return this.rtmpUrlPrefix;
    }

    @NotNull
    public final MultiPkPrepareModel copy(@NotNull String mixStreamId, @NotNull String pkPrepareId, @Nullable String str) {
        s.i(mixStreamId, "mixStreamId");
        s.i(pkPrepareId, "pkPrepareId");
        return new MultiPkPrepareModel(mixStreamId, pkPrepareId, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkPrepareModel)) {
            return false;
        }
        MultiPkPrepareModel multiPkPrepareModel = (MultiPkPrepareModel) obj;
        return s.d(this.mixStreamId, multiPkPrepareModel.mixStreamId) && s.d(this.pkPrepareId, multiPkPrepareModel.pkPrepareId) && s.d(this.rtmpUrlPrefix, multiPkPrepareModel.rtmpUrlPrefix);
    }

    @NotNull
    public final String getMixStreamId() {
        return this.mixStreamId;
    }

    @NotNull
    public final String getPkPrepareId() {
        return this.pkPrepareId;
    }

    @Nullable
    public final String getRtmpUrlPrefix() {
        return this.rtmpUrlPrefix;
    }

    public int hashCode() {
        int hashCode = ((this.mixStreamId.hashCode() * 31) + this.pkPrepareId.hashCode()) * 31;
        String str = this.rtmpUrlPrefix;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "MultiPkPrepareModel(mixStreamId=" + this.mixStreamId + ", pkPrepareId=" + this.pkPrepareId + ", rtmpUrlPrefix=" + this.rtmpUrlPrefix + ")";
    }
}
