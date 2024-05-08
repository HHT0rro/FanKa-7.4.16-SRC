package com.cupidapp.live.maskparty.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatRoomModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class QuitRoomModel {
    private final boolean propCardTipWindow;

    public QuitRoomModel(boolean z10) {
        this.propCardTipWindow = z10;
    }

    public static /* synthetic */ QuitRoomModel copy$default(QuitRoomModel quitRoomModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = quitRoomModel.propCardTipWindow;
        }
        return quitRoomModel.copy(z10);
    }

    public final boolean component1() {
        return this.propCardTipWindow;
    }

    @NotNull
    public final QuitRoomModel copy(boolean z10) {
        return new QuitRoomModel(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QuitRoomModel) && this.propCardTipWindow == ((QuitRoomModel) obj).propCardTipWindow;
    }

    public final boolean getPropCardTipWindow() {
        return this.propCardTipWindow;
    }

    public int hashCode() {
        boolean z10 = this.propCardTipWindow;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "QuitRoomModel(propCardTipWindow=" + this.propCardTipWindow + ")";
    }
}
