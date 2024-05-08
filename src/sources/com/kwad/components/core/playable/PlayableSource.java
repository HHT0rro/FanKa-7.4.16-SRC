package com.kwad.components.core.playable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum PlayableSource {
    UNKNOWN_TRYPLAY_ENTRY_SOURCE(0),
    PLAY_FINISHED_NORMAL(1),
    PENDANT_CLICK_NOT_AUTO(2),
    PENDANT_CLICK_AUTO(3),
    PENDANT_AUTO(4),
    ACTIONBAR_CLICK(5),
    ENDCARD_CLICK(6);

    private int code;

    PlayableSource(int i10) {
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }
}
