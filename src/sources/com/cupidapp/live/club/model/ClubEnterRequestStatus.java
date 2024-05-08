package com.cupidapp.live.club.model;

import kotlin.d;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ClubEnterRequestStatus {
    TO_CONFIRM(0),
    ALREADY_CONFIRM(1),
    INVALID(2);

    private final int value;

    ClubEnterRequestStatus(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
