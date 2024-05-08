package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendInvitationModel {
    private final int waitSec;

    public SendInvitationModel(int i10) {
        this.waitSec = i10;
    }

    public static /* synthetic */ SendInvitationModel copy$default(SendInvitationModel sendInvitationModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = sendInvitationModel.waitSec;
        }
        return sendInvitationModel.copy(i10);
    }

    public final int component1() {
        return this.waitSec;
    }

    @NotNull
    public final SendInvitationModel copy(int i10) {
        return new SendInvitationModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SendInvitationModel) && this.waitSec == ((SendInvitationModel) obj).waitSec;
    }

    public final int getWaitSec() {
        return this.waitSec;
    }

    public int hashCode() {
        return this.waitSec;
    }

    @NotNull
    public String toString() {
        return "SendInvitationModel(waitSec=" + this.waitSec + ")";
    }
}
