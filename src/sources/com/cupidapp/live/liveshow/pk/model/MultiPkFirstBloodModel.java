package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkFirstBloodModel {

    @NotNull
    private final String liveShowId;

    public MultiPkFirstBloodModel(@NotNull String liveShowId) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ MultiPkFirstBloodModel copy$default(MultiPkFirstBloodModel multiPkFirstBloodModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkFirstBloodModel.liveShowId;
        }
        return multiPkFirstBloodModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @NotNull
    public final MultiPkFirstBloodModel copy(@NotNull String liveShowId) {
        s.i(liveShowId, "liveShowId");
        return new MultiPkFirstBloodModel(liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkFirstBloodModel) && s.d(this.liveShowId, ((MultiPkFirstBloodModel) obj).liveShowId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        return this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkFirstBloodModel(liveShowId=" + this.liveShowId + ")";
    }
}
