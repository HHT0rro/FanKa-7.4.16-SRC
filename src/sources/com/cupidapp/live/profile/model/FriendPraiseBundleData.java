package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FriendPraiseModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseBundleData implements Serializable {

    @NotNull
    private final SensorPosition source;

    public FriendPraiseBundleData(@NotNull SensorPosition source) {
        s.i(source, "source");
        this.source = source;
    }

    public static /* synthetic */ FriendPraiseBundleData copy$default(FriendPraiseBundleData friendPraiseBundleData, SensorPosition sensorPosition, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sensorPosition = friendPraiseBundleData.source;
        }
        return friendPraiseBundleData.copy(sensorPosition);
    }

    @NotNull
    public final SensorPosition component1() {
        return this.source;
    }

    @NotNull
    public final FriendPraiseBundleData copy(@NotNull SensorPosition source) {
        s.i(source, "source");
        return new FriendPraiseBundleData(source);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FriendPraiseBundleData) && this.source == ((FriendPraiseBundleData) obj).source;
    }

    @NotNull
    public final SensorPosition getSource() {
        return this.source;
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "FriendPraiseBundleData(source=" + ((Object) this.source) + ")";
    }
}
