package com.cupidapp.live.match.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyListModel implements Serializable {

    @NotNull
    private final NearbyUserModel nearbyUser;

    public NearbyListModel(@NotNull NearbyUserModel nearbyUser) {
        s.i(nearbyUser, "nearbyUser");
        this.nearbyUser = nearbyUser;
    }

    public static /* synthetic */ NearbyListModel copy$default(NearbyListModel nearbyListModel, NearbyUserModel nearbyUserModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            nearbyUserModel = nearbyListModel.nearbyUser;
        }
        return nearbyListModel.copy(nearbyUserModel);
    }

    @NotNull
    public final NearbyUserModel component1() {
        return this.nearbyUser;
    }

    @NotNull
    public final NearbyListModel copy(@NotNull NearbyUserModel nearbyUser) {
        s.i(nearbyUser, "nearbyUser");
        return new NearbyListModel(nearbyUser);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NearbyListModel) && s.d(this.nearbyUser, ((NearbyListModel) obj).nearbyUser);
    }

    @NotNull
    public final NearbyUserModel getNearbyUser() {
        return this.nearbyUser;
    }

    public int hashCode() {
        return this.nearbyUser.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearbyListModel(nearbyUser=" + ((Object) this.nearbyUser) + ")";
    }
}
