package com.cupidapp.live.liveshow.pk.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkMixSuccessModel {

    @NotNull
    private final String mixStreamId;

    @Nullable
    private final List<MultiPkUserInfoModel> pkUsers;

    public MultiPkMixSuccessModel(@NotNull String mixStreamId, @Nullable List<MultiPkUserInfoModel> list) {
        s.i(mixStreamId, "mixStreamId");
        this.mixStreamId = mixStreamId;
        this.pkUsers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiPkMixSuccessModel copy$default(MultiPkMixSuccessModel multiPkMixSuccessModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiPkMixSuccessModel.mixStreamId;
        }
        if ((i10 & 2) != 0) {
            list = multiPkMixSuccessModel.pkUsers;
        }
        return multiPkMixSuccessModel.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.mixStreamId;
    }

    @Nullable
    public final List<MultiPkUserInfoModel> component2() {
        return this.pkUsers;
    }

    @NotNull
    public final MultiPkMixSuccessModel copy(@NotNull String mixStreamId, @Nullable List<MultiPkUserInfoModel> list) {
        s.i(mixStreamId, "mixStreamId");
        return new MultiPkMixSuccessModel(mixStreamId, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkMixSuccessModel)) {
            return false;
        }
        MultiPkMixSuccessModel multiPkMixSuccessModel = (MultiPkMixSuccessModel) obj;
        return s.d(this.mixStreamId, multiPkMixSuccessModel.mixStreamId) && s.d(this.pkUsers, multiPkMixSuccessModel.pkUsers);
    }

    @NotNull
    public final String getMixStreamId() {
        return this.mixStreamId;
    }

    @Nullable
    public final List<MultiPkUserInfoModel> getPkUsers() {
        return this.pkUsers;
    }

    public int hashCode() {
        int hashCode = this.mixStreamId.hashCode() * 31;
        List<MultiPkUserInfoModel> list = this.pkUsers;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "MultiPkMixSuccessModel(mixStreamId=" + this.mixStreamId + ", pkUsers=" + ((Object) this.pkUsers) + ")";
    }
}
