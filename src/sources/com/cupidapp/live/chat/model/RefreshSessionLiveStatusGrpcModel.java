package com.cupidapp.live.chat.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InboxSessionModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RefreshSessionLiveStatusGrpcModel {

    @Nullable
    private final String liveShowId;

    @NotNull
    private final String sessionId;
    private final long time;

    public RefreshSessionLiveStatusGrpcModel(@NotNull String sessionId, @Nullable String str, long j10) {
        s.i(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.liveShowId = str;
        this.time = j10;
    }

    public static /* synthetic */ RefreshSessionLiveStatusGrpcModel copy$default(RefreshSessionLiveStatusGrpcModel refreshSessionLiveStatusGrpcModel, String str, String str2, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = refreshSessionLiveStatusGrpcModel.sessionId;
        }
        if ((i10 & 2) != 0) {
            str2 = refreshSessionLiveStatusGrpcModel.liveShowId;
        }
        if ((i10 & 4) != 0) {
            j10 = refreshSessionLiveStatusGrpcModel.time;
        }
        return refreshSessionLiveStatusGrpcModel.copy(str, str2, j10);
    }

    @NotNull
    public final String component1() {
        return this.sessionId;
    }

    @Nullable
    public final String component2() {
        return this.liveShowId;
    }

    public final long component3() {
        return this.time;
    }

    @NotNull
    public final RefreshSessionLiveStatusGrpcModel copy(@NotNull String sessionId, @Nullable String str, long j10) {
        s.i(sessionId, "sessionId");
        return new RefreshSessionLiveStatusGrpcModel(sessionId, str, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefreshSessionLiveStatusGrpcModel)) {
            return false;
        }
        RefreshSessionLiveStatusGrpcModel refreshSessionLiveStatusGrpcModel = (RefreshSessionLiveStatusGrpcModel) obj;
        return s.d(this.sessionId, refreshSessionLiveStatusGrpcModel.sessionId) && s.d(this.liveShowId, refreshSessionLiveStatusGrpcModel.liveShowId) && this.time == refreshSessionLiveStatusGrpcModel.time;
    }

    @Nullable
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        int hashCode = this.sessionId.hashCode() * 31;
        String str = this.liveShowId;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.time);
    }

    @NotNull
    public String toString() {
        return "RefreshSessionLiveStatusGrpcModel(sessionId=" + this.sessionId + ", liveShowId=" + this.liveShowId + ", time=" + this.time + ")";
    }
}
