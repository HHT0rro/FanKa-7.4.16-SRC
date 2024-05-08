package com.cupidapp.live.push.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPushTokenModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushAlertShowModel {
    private final boolean show;

    public PushAlertShowModel(boolean z10) {
        this.show = z10;
    }

    public static /* synthetic */ PushAlertShowModel copy$default(PushAlertShowModel pushAlertShowModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = pushAlertShowModel.show;
        }
        return pushAlertShowModel.copy(z10);
    }

    public final boolean component1() {
        return this.show;
    }

    @NotNull
    public final PushAlertShowModel copy(boolean z10) {
        return new PushAlertShowModel(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PushAlertShowModel) && this.show == ((PushAlertShowModel) obj).show;
    }

    public final boolean getShow() {
        return this.show;
    }

    public int hashCode() {
        boolean z10 = this.show;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "PushAlertShowModel(show=" + this.show + ")";
    }
}
