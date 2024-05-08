package com.cupidapp.live.liveshow.view.liveinfo;

import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKActorInfoAndAudienceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class JoinedFanClubEvent {

    @NotNull
    private final FanClubStatus status;

    public JoinedFanClubEvent(@NotNull FanClubStatus status) {
        s.i(status, "status");
        this.status = status;
    }

    public static /* synthetic */ JoinedFanClubEvent copy$default(JoinedFanClubEvent joinedFanClubEvent, FanClubStatus fanClubStatus, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fanClubStatus = joinedFanClubEvent.status;
        }
        return joinedFanClubEvent.copy(fanClubStatus);
    }

    @NotNull
    public final FanClubStatus component1() {
        return this.status;
    }

    @NotNull
    public final JoinedFanClubEvent copy(@NotNull FanClubStatus status) {
        s.i(status, "status");
        return new JoinedFanClubEvent(status);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof JoinedFanClubEvent) && this.status == ((JoinedFanClubEvent) obj).status;
    }

    @NotNull
    public final FanClubStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinedFanClubEvent(status=" + ((Object) this.status) + ")";
    }
}
