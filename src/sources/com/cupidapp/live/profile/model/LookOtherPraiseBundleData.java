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
public final class LookOtherPraiseBundleData implements Serializable {
    private final boolean fromShare;

    @NotNull
    private final SensorPosition source;

    @NotNull
    private final String userId;

    public LookOtherPraiseBundleData(@NotNull String userId, boolean z10, @NotNull SensorPosition source) {
        s.i(userId, "userId");
        s.i(source, "source");
        this.userId = userId;
        this.fromShare = z10;
        this.source = source;
    }

    public static /* synthetic */ LookOtherPraiseBundleData copy$default(LookOtherPraiseBundleData lookOtherPraiseBundleData, String str, boolean z10, SensorPosition sensorPosition, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = lookOtherPraiseBundleData.userId;
        }
        if ((i10 & 2) != 0) {
            z10 = lookOtherPraiseBundleData.fromShare;
        }
        if ((i10 & 4) != 0) {
            sensorPosition = lookOtherPraiseBundleData.source;
        }
        return lookOtherPraiseBundleData.copy(str, z10, sensorPosition);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    public final boolean component2() {
        return this.fromShare;
    }

    @NotNull
    public final SensorPosition component3() {
        return this.source;
    }

    @NotNull
    public final LookOtherPraiseBundleData copy(@NotNull String userId, boolean z10, @NotNull SensorPosition source) {
        s.i(userId, "userId");
        s.i(source, "source");
        return new LookOtherPraiseBundleData(userId, z10, source);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookOtherPraiseBundleData)) {
            return false;
        }
        LookOtherPraiseBundleData lookOtherPraiseBundleData = (LookOtherPraiseBundleData) obj;
        return s.d(this.userId, lookOtherPraiseBundleData.userId) && this.fromShare == lookOtherPraiseBundleData.fromShare && this.source == lookOtherPraiseBundleData.source;
    }

    public final boolean getFromShare() {
        return this.fromShare;
    }

    @NotNull
    public final SensorPosition getSource() {
        return this.source;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        boolean z10 = this.fromShare;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.source.hashCode();
    }

    @NotNull
    public String toString() {
        return "LookOtherPraiseBundleData(userId=" + this.userId + ", fromShare=" + this.fromShare + ", source=" + ((Object) this.source) + ")";
    }
}
