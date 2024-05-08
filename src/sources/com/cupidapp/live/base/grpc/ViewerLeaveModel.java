package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ViewerLeaveModel {

    @Nullable
    private final String userId;

    public ViewerLeaveModel(@Nullable String str) {
        this.userId = str;
    }

    public static /* synthetic */ ViewerLeaveModel copy$default(ViewerLeaveModel viewerLeaveModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = viewerLeaveModel.userId;
        }
        return viewerLeaveModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final ViewerLeaveModel copy(@Nullable String str) {
        return new ViewerLeaveModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ViewerLeaveModel) && kotlin.jvm.internal.s.d(this.userId, ((ViewerLeaveModel) obj).userId);
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ViewerLeaveModel(userId=" + this.userId + ")";
    }
}
