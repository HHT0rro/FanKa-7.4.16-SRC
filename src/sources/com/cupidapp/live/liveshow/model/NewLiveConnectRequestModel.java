package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewLiveConnectRequestModel {
    private final int waitingToConnectCount;

    public NewLiveConnectRequestModel() {
        this(0, 1, null);
    }

    public NewLiveConnectRequestModel(int i10) {
        this.waitingToConnectCount = i10;
    }

    public static /* synthetic */ NewLiveConnectRequestModel copy$default(NewLiveConnectRequestModel newLiveConnectRequestModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = newLiveConnectRequestModel.waitingToConnectCount;
        }
        return newLiveConnectRequestModel.copy(i10);
    }

    public final int component1() {
        return this.waitingToConnectCount;
    }

    @NotNull
    public final NewLiveConnectRequestModel copy(int i10) {
        return new NewLiveConnectRequestModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NewLiveConnectRequestModel) && this.waitingToConnectCount == ((NewLiveConnectRequestModel) obj).waitingToConnectCount;
    }

    public final int getWaitingToConnectCount() {
        return this.waitingToConnectCount;
    }

    public int hashCode() {
        return this.waitingToConnectCount;
    }

    @NotNull
    public String toString() {
        return "NewLiveConnectRequestModel(waitingToConnectCount=" + this.waitingToConnectCount + ")";
    }

    public /* synthetic */ NewLiveConnectRequestModel(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
