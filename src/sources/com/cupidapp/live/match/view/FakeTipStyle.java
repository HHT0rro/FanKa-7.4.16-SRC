package com.cupidapp.live.match.view;

import org.jetbrains.annotations.NotNull;

/* compiled from: FKSwipeCardFakeAvatarTipLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FakeTipStyle {
    CAN_SEE_DETAIL,
    UPLOAD_TIP_GUIDE,
    UPLOAD_TIP,
    NONE;

    @NotNull
    public final FakeTipStyle next() {
        if (this == CAN_SEE_DETAIL) {
            return UPLOAD_TIP_GUIDE;
        }
        return UPLOAD_TIP;
    }
}
