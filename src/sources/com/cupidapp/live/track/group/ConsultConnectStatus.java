package com.cupidapp.live.track.group;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultLiveLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum ConsultConnectStatus {
    NonConnect("NON_CONNECT"),
    Connect("CONNECT"),
    Finish("FINISH"),
    Block("BLOCK"),
    Hang("HANG");


    @NotNull
    private final String status;

    ConsultConnectStatus(String str) {
        this.status = str;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }
}
