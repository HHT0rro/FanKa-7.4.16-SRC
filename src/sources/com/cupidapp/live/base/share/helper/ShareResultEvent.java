package com.cupidapp.live.base.share.helper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareResultEvent {
    private boolean success;

    public ShareResultEvent(boolean z10) {
        this.success = z10;
    }

    public static /* synthetic */ ShareResultEvent copy$default(ShareResultEvent shareResultEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = shareResultEvent.success;
        }
        return shareResultEvent.copy(z10);
    }

    public final boolean component1() {
        return this.success;
    }

    @NotNull
    public final ShareResultEvent copy(boolean z10) {
        return new ShareResultEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShareResultEvent) && this.success == ((ShareResultEvent) obj).success;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        boolean z10 = this.success;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    public final void setSuccess(boolean z10) {
        this.success = z10;
    }

    @NotNull
    public String toString() {
        return "ShareResultEvent(success=" + this.success + ")";
    }
}
