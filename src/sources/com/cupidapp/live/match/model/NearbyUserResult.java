package com.cupidapp.live.match.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyUserResult {

    @NotNull
    private final List<MatchCardDescriptionModel> postAvatars;

    @NotNull
    private final NearbyUserProfileModel user;

    public NearbyUserResult(@NotNull NearbyUserProfileModel user, @NotNull List<MatchCardDescriptionModel> postAvatars) {
        s.i(user, "user");
        s.i(postAvatars, "postAvatars");
        this.user = user;
        this.postAvatars = postAvatars;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyUserResult copy$default(NearbyUserResult nearbyUserResult, NearbyUserProfileModel nearbyUserProfileModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            nearbyUserProfileModel = nearbyUserResult.user;
        }
        if ((i10 & 2) != 0) {
            list = nearbyUserResult.postAvatars;
        }
        return nearbyUserResult.copy(nearbyUserProfileModel, list);
    }

    @NotNull
    public final NearbyUserProfileModel component1() {
        return this.user;
    }

    @NotNull
    public final List<MatchCardDescriptionModel> component2() {
        return this.postAvatars;
    }

    @NotNull
    public final NearbyUserResult copy(@NotNull NearbyUserProfileModel user, @NotNull List<MatchCardDescriptionModel> postAvatars) {
        s.i(user, "user");
        s.i(postAvatars, "postAvatars");
        return new NearbyUserResult(user, postAvatars);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyUserResult)) {
            return false;
        }
        NearbyUserResult nearbyUserResult = (NearbyUserResult) obj;
        return s.d(this.user, nearbyUserResult.user) && s.d(this.postAvatars, nearbyUserResult.postAvatars);
    }

    @NotNull
    public final List<MatchCardDescriptionModel> getPostAvatars() {
        return this.postAvatars;
    }

    @NotNull
    public final NearbyUserProfileModel getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.user.hashCode() * 31) + this.postAvatars.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearbyUserResult(user=" + ((Object) this.user) + ", postAvatars=" + ((Object) this.postAvatars) + ")";
    }

    public /* synthetic */ NearbyUserResult(NearbyUserProfileModel nearbyUserProfileModel, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(nearbyUserProfileModel, (i10 & 2) != 0 ? new ArrayList() : list);
    }
}
