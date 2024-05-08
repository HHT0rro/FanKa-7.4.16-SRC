package com.cupidapp.live.chat2.model;

import androidx.annotation.StringRes;
import com.cupidapp.live.R$string;
import kotlin.d;

/* compiled from: ChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LongClickActionType {
    Copy(R$string.copy),
    Quote(R$string.quote),
    Cancel(R$string.revocation),
    Destroy(R$string.destroy),
    Delete(R$string.delete),
    Report(R$string.report),
    Personal(R$string.personal);

    private final int resId;

    LongClickActionType(@StringRes int i10) {
        this.resId = i10;
    }

    public final int getResId() {
        return this.resId;
    }
}
