package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveGiftCollectionConnectorMessage {

    @NotNull
    private final String liveShowId;

    public LiveGiftCollectionConnectorMessage(@NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveGiftCollectionConnectorMessage copy$default(LiveGiftCollectionConnectorMessage liveGiftCollectionConnectorMessage, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveGiftCollectionConnectorMessage.liveShowId;
        }
        return liveGiftCollectionConnectorMessage.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveGiftCollectionConnectorMessage copy(@NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveGiftCollectionConnectorMessage(liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveGiftCollectionConnectorMessage) && kotlin.jvm.internal.s.d(this.liveShowId, ((LiveGiftCollectionConnectorMessage) obj).liveShowId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        return this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveGiftCollectionConnectorMessage(liveShowId=" + this.liveShowId + ")";
    }
}
