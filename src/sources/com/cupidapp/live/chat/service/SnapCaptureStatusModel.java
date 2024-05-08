package com.cupidapp.live.chat.service;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SnapCaptureStatusModel {

    @Nullable
    private final Boolean snapCapture;

    public SnapCaptureStatusModel(@Nullable Boolean bool) {
        this.snapCapture = bool;
    }

    public static /* synthetic */ SnapCaptureStatusModel copy$default(SnapCaptureStatusModel snapCaptureStatusModel, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = snapCaptureStatusModel.snapCapture;
        }
        return snapCaptureStatusModel.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.snapCapture;
    }

    @NotNull
    public final SnapCaptureStatusModel copy(@Nullable Boolean bool) {
        return new SnapCaptureStatusModel(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SnapCaptureStatusModel) && s.d(this.snapCapture, ((SnapCaptureStatusModel) obj).snapCapture);
    }

    @Nullable
    public final Boolean getSnapCapture() {
        return this.snapCapture;
    }

    public int hashCode() {
        Boolean bool = this.snapCapture;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        return "SnapCaptureStatusModel(snapCapture=" + ((Object) this.snapCapture) + ")";
    }
}
