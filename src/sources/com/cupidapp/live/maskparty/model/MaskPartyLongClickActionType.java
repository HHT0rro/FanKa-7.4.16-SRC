package com.cupidapp.live.maskparty.model;

import androidx.annotation.StringRes;
import com.cupidapp.live.R$string;
import kotlin.d;

/* compiled from: MaskPartyChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MaskPartyLongClickActionType {
    Copy(R$string.copy),
    Cancel(R$string.revocation),
    Destroy(R$string.destroy),
    Delete(R$string.delete),
    Report(R$string.report);

    private final int resId;

    MaskPartyLongClickActionType(@StringRes int i10) {
        this.resId = i10;
    }

    public final int getResId() {
        return this.resId;
    }
}
