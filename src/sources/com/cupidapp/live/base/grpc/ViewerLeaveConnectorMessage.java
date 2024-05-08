package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ViewerLeaveConnectorMessage {

    @Nullable
    private final ViewerLeaveModel entity;

    public ViewerLeaveConnectorMessage(@Nullable ViewerLeaveModel viewerLeaveModel) {
        this.entity = viewerLeaveModel;
    }

    public static /* synthetic */ ViewerLeaveConnectorMessage copy$default(ViewerLeaveConnectorMessage viewerLeaveConnectorMessage, ViewerLeaveModel viewerLeaveModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            viewerLeaveModel = viewerLeaveConnectorMessage.entity;
        }
        return viewerLeaveConnectorMessage.copy(viewerLeaveModel);
    }

    @Nullable
    public final ViewerLeaveModel component1() {
        return this.entity;
    }

    @NotNull
    public final ViewerLeaveConnectorMessage copy(@Nullable ViewerLeaveModel viewerLeaveModel) {
        return new ViewerLeaveConnectorMessage(viewerLeaveModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ViewerLeaveConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((ViewerLeaveConnectorMessage) obj).entity);
    }

    @Nullable
    public final ViewerLeaveModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        ViewerLeaveModel viewerLeaveModel = this.entity;
        if (viewerLeaveModel == null) {
            return 0;
        }
        return viewerLeaveModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "ViewerLeaveConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
