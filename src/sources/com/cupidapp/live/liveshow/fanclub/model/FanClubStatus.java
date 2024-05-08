package com.cupidapp.live.liveshow.fanclub.model;

import kotlin.d;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FanClubStatus {
    NotJoined(1),
    HasJoined(2),
    Exited(3),
    Expired(4);

    private final int status;

    FanClubStatus(int i10) {
        this.status = i10;
    }

    public final int getStatus() {
        return this.status;
    }
}
