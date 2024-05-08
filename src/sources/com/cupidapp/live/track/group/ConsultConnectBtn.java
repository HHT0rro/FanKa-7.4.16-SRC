package com.cupidapp.live.track.group;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultLiveLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum ConsultConnectBtn {
    Connect("CONNECT"),
    Refuse("REFUSE"),
    Answer("ANSWER"),
    HangUp("HANG_UP");


    @NotNull
    private final String btnName;

    ConsultConnectBtn(String str) {
        this.btnName = str;
    }

    @NotNull
    public final String getBtnName() {
        return this.btnName;
    }
}
