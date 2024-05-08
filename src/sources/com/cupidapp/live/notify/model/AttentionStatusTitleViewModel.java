package com.cupidapp.live.notify.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AttentionStatusTitleViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionStatusTitleViewModel {

    @NotNull
    private final String statusTitle;
    private final boolean unread;

    public AttentionStatusTitleViewModel(@NotNull String statusTitle, boolean z10) {
        s.i(statusTitle, "statusTitle");
        this.statusTitle = statusTitle;
        this.unread = z10;
    }

    public static /* synthetic */ AttentionStatusTitleViewModel copy$default(AttentionStatusTitleViewModel attentionStatusTitleViewModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = attentionStatusTitleViewModel.statusTitle;
        }
        if ((i10 & 2) != 0) {
            z10 = attentionStatusTitleViewModel.unread;
        }
        return attentionStatusTitleViewModel.copy(str, z10);
    }

    @NotNull
    public final String component1() {
        return this.statusTitle;
    }

    public final boolean component2() {
        return this.unread;
    }

    @NotNull
    public final AttentionStatusTitleViewModel copy(@NotNull String statusTitle, boolean z10) {
        s.i(statusTitle, "statusTitle");
        return new AttentionStatusTitleViewModel(statusTitle, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttentionStatusTitleViewModel)) {
            return false;
        }
        AttentionStatusTitleViewModel attentionStatusTitleViewModel = (AttentionStatusTitleViewModel) obj;
        return s.d(this.statusTitle, attentionStatusTitleViewModel.statusTitle) && this.unread == attentionStatusTitleViewModel.unread;
    }

    @NotNull
    public final String getStatusTitle() {
        return this.statusTitle;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.statusTitle.hashCode() * 31;
        boolean z10 = this.unread;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return "AttentionStatusTitleViewModel(statusTitle=" + this.statusTitle + ", unread=" + this.unread + ")";
    }
}
