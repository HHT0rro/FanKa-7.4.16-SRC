package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkAppointRequestModel implements Serializable {

    @NotNull
    private final String pkLiveShowId;

    @NotNull
    private final User pkUser;

    public LivePkAppointRequestModel(@NotNull User pkUser, @NotNull String pkLiveShowId) {
        s.i(pkUser, "pkUser");
        s.i(pkLiveShowId, "pkLiveShowId");
        this.pkUser = pkUser;
        this.pkLiveShowId = pkLiveShowId;
    }

    public static /* synthetic */ LivePkAppointRequestModel copy$default(LivePkAppointRequestModel livePkAppointRequestModel, User user, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = livePkAppointRequestModel.pkUser;
        }
        if ((i10 & 2) != 0) {
            str = livePkAppointRequestModel.pkLiveShowId;
        }
        return livePkAppointRequestModel.copy(user, str);
    }

    @NotNull
    public final User component1() {
        return this.pkUser;
    }

    @NotNull
    public final String component2() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final LivePkAppointRequestModel copy(@NotNull User pkUser, @NotNull String pkLiveShowId) {
        s.i(pkUser, "pkUser");
        s.i(pkLiveShowId, "pkLiveShowId");
        return new LivePkAppointRequestModel(pkUser, pkLiveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkAppointRequestModel)) {
            return false;
        }
        LivePkAppointRequestModel livePkAppointRequestModel = (LivePkAppointRequestModel) obj;
        return s.d(this.pkUser, livePkAppointRequestModel.pkUser) && s.d(this.pkLiveShowId, livePkAppointRequestModel.pkLiveShowId);
    }

    @NotNull
    public final String getPkLiveShowId() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final User getPkUser() {
        return this.pkUser;
    }

    public int hashCode() {
        return (this.pkUser.hashCode() * 31) + this.pkLiveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        User user = this.pkUser;
        return "LivePkAppointRequestModel(pkUser=" + ((Object) user) + ", pkLiveShowId=" + this.pkLiveShowId + ")";
    }
}
