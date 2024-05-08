package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkAppointRejectModel {
    private final boolean isAppointed;

    @NotNull
    private final String pkLiveShowId;

    @NotNull
    private final String userName;

    public LivePkAppointRejectModel(@NotNull String userName, @NotNull String pkLiveShowId, boolean z10) {
        s.i(userName, "userName");
        s.i(pkLiveShowId, "pkLiveShowId");
        this.userName = userName;
        this.pkLiveShowId = pkLiveShowId;
        this.isAppointed = z10;
    }

    public static /* synthetic */ LivePkAppointRejectModel copy$default(LivePkAppointRejectModel livePkAppointRejectModel, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = livePkAppointRejectModel.userName;
        }
        if ((i10 & 2) != 0) {
            str2 = livePkAppointRejectModel.pkLiveShowId;
        }
        if ((i10 & 4) != 0) {
            z10 = livePkAppointRejectModel.isAppointed;
        }
        return livePkAppointRejectModel.copy(str, str2, z10);
    }

    @NotNull
    public final String component1() {
        return this.userName;
    }

    @NotNull
    public final String component2() {
        return this.pkLiveShowId;
    }

    public final boolean component3() {
        return this.isAppointed;
    }

    @NotNull
    public final LivePkAppointRejectModel copy(@NotNull String userName, @NotNull String pkLiveShowId, boolean z10) {
        s.i(userName, "userName");
        s.i(pkLiveShowId, "pkLiveShowId");
        return new LivePkAppointRejectModel(userName, pkLiveShowId, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkAppointRejectModel)) {
            return false;
        }
        LivePkAppointRejectModel livePkAppointRejectModel = (LivePkAppointRejectModel) obj;
        return s.d(this.userName, livePkAppointRejectModel.userName) && s.d(this.pkLiveShowId, livePkAppointRejectModel.pkLiveShowId) && this.isAppointed == livePkAppointRejectModel.isAppointed;
    }

    @NotNull
    public final String getPkLiveShowId() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.userName.hashCode() * 31) + this.pkLiveShowId.hashCode()) * 31;
        boolean z10 = this.isAppointed;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isAppointed() {
        return this.isAppointed;
    }

    @NotNull
    public String toString() {
        return "LivePkAppointRejectModel(userName=" + this.userName + ", pkLiveShowId=" + this.pkLiveShowId + ", isAppointed=" + this.isAppointed + ")";
    }
}
