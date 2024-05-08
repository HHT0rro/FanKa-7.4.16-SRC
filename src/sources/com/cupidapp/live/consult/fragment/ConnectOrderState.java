package com.cupidapp.live.consult.fragment;

import kotlin.d;

/* compiled from: ConsultConnectOrderFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ConnectOrderState {
    WaitConnect(0),
    Connecting(1);

    private final int state;

    ConnectOrderState(int i10) {
        this.state = i10;
    }

    public final int getState() {
        return this.state;
    }
}
