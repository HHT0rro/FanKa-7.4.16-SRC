package com.cupidapp.live.startup.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKExpressAdLocalModel {
    private long feedTime;
    private long postStreamTime;

    public FKExpressAdLocalModel() {
        this(0L, 0L, 3, null);
    }

    public FKExpressAdLocalModel(long j10, long j11) {
        this.feedTime = j10;
        this.postStreamTime = j11;
    }

    public static /* synthetic */ FKExpressAdLocalModel copy$default(FKExpressAdLocalModel fKExpressAdLocalModel, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = fKExpressAdLocalModel.feedTime;
        }
        if ((i10 & 2) != 0) {
            j11 = fKExpressAdLocalModel.postStreamTime;
        }
        return fKExpressAdLocalModel.copy(j10, j11);
    }

    public final long component1() {
        return this.feedTime;
    }

    public final long component2() {
        return this.postStreamTime;
    }

    @NotNull
    public final FKExpressAdLocalModel copy(long j10, long j11) {
        return new FKExpressAdLocalModel(j10, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKExpressAdLocalModel)) {
            return false;
        }
        FKExpressAdLocalModel fKExpressAdLocalModel = (FKExpressAdLocalModel) obj;
        return this.feedTime == fKExpressAdLocalModel.feedTime && this.postStreamTime == fKExpressAdLocalModel.postStreamTime;
    }

    public final long getFeedTime() {
        return this.feedTime;
    }

    public final long getPostStreamTime() {
        return this.postStreamTime;
    }

    public int hashCode() {
        return (a.a(this.feedTime) * 31) + a.a(this.postStreamTime);
    }

    public final void setFeedTime(long j10) {
        this.feedTime = j10;
    }

    public final void setPostStreamTime(long j10) {
        this.postStreamTime = j10;
    }

    @NotNull
    public String toString() {
        return "FKExpressAdLocalModel(feedTime=" + this.feedTime + ", postStreamTime=" + this.postStreamTime + ")";
    }

    public /* synthetic */ FKExpressAdLocalModel(long j10, long j11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0L : j10, (i10 & 2) != 0 ? 0L : j11);
    }
}
