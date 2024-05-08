package com.cupidapp.live.track.group;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultLiveLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum EnterConsultRoomSource {
    Card("CARD"),
    QuickJoin("QUICK_ENTER"),
    Switch("SWITCH"),
    Web("WEB"),
    ConsultWindow("CONSULT_WINDOW");


    @NotNull
    private final String source;

    EnterConsultRoomSource(String str) {
        this.source = str;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }
}
