package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkResultModel {

    @NotNull
    private final String liveShowId;

    @Nullable
    private final String pkResult;

    public MultiPkResultModel(@NotNull String liveShowId, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.pkResult = str;
    }

    public static /* synthetic */ MultiPkResultModel copy$default(MultiPkResultModel multiPkResultModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkResultModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            str2 = multiPkResultModel.pkResult;
        }
        return multiPkResultModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @Nullable
    public final String component2() {
        return this.pkResult;
    }

    @NotNull
    public final MultiPkResultModel copy(@NotNull String liveShowId, @Nullable String str) {
        s.i(liveShowId, "liveShowId");
        return new MultiPkResultModel(liveShowId, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkResultModel)) {
            return false;
        }
        MultiPkResultModel multiPkResultModel = (MultiPkResultModel) obj;
        return s.d(this.liveShowId, multiPkResultModel.liveShowId) && s.d(this.pkResult, multiPkResultModel.pkResult);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final String getPkResult() {
        return this.pkResult;
    }

    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        String str = this.pkResult;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "MultiPkResultModel(liveShowId=" + this.liveShowId + ", pkResult=" + this.pkResult + ")";
    }
}
