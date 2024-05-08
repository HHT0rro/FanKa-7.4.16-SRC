package com.cupidapp.live.liveshow.view.miniprofile;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FollowActorEvent {

    @NotNull
    private final User userModel;

    public FollowActorEvent(@NotNull User userModel) {
        s.i(userModel, "userModel");
        this.userModel = userModel;
    }

    public static /* synthetic */ FollowActorEvent copy$default(FollowActorEvent followActorEvent, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = followActorEvent.userModel;
        }
        return followActorEvent.copy(user);
    }

    @NotNull
    public final User component1() {
        return this.userModel;
    }

    @NotNull
    public final FollowActorEvent copy(@NotNull User userModel) {
        s.i(userModel, "userModel");
        return new FollowActorEvent(userModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FollowActorEvent) && s.d(this.userModel, ((FollowActorEvent) obj).userModel);
    }

    @NotNull
    public final User getUserModel() {
        return this.userModel;
    }

    public int hashCode() {
        return this.userModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "FollowActorEvent(userModel=" + ((Object) this.userModel) + ")";
    }
}
