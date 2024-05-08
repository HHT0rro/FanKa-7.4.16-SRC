package com.cupidapp.live.chat.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InboxSessionModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RefreshSessionLiveStatusEvent {

    @NotNull
    private final RefreshSessionLiveStatusGrpcModel model;

    public RefreshSessionLiveStatusEvent(@NotNull RefreshSessionLiveStatusGrpcModel model) {
        s.i(model, "model");
        this.model = model;
    }

    public static /* synthetic */ RefreshSessionLiveStatusEvent copy$default(RefreshSessionLiveStatusEvent refreshSessionLiveStatusEvent, RefreshSessionLiveStatusGrpcModel refreshSessionLiveStatusGrpcModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            refreshSessionLiveStatusGrpcModel = refreshSessionLiveStatusEvent.model;
        }
        return refreshSessionLiveStatusEvent.copy(refreshSessionLiveStatusGrpcModel);
    }

    @NotNull
    public final RefreshSessionLiveStatusGrpcModel component1() {
        return this.model;
    }

    @NotNull
    public final RefreshSessionLiveStatusEvent copy(@NotNull RefreshSessionLiveStatusGrpcModel model) {
        s.i(model, "model");
        return new RefreshSessionLiveStatusEvent(model);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RefreshSessionLiveStatusEvent) && s.d(this.model, ((RefreshSessionLiveStatusEvent) obj).model);
    }

    @NotNull
    public final RefreshSessionLiveStatusGrpcModel getModel() {
        return this.model;
    }

    public int hashCode() {
        return this.model.hashCode();
    }

    @NotNull
    public String toString() {
        return "RefreshSessionLiveStatusEvent(model=" + ((Object) this.model) + ")";
    }
}
