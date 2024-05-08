package com.cupidapp.live.profile.viewmodel;

import kotlin.d;

/* compiled from: ContactManagerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum CancelFollowRemindRange {
    NOT_REMIND(0),
    MATCH_REMIND(1),
    ALL_REMIND(2);

    private final int value;

    CancelFollowRemindRange(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
