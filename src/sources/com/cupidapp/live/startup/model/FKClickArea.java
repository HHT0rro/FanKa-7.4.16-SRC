package com.cupidapp.live.startup.model;

import kotlin.d;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FKClickArea {
    FullScreen(1),
    JumpButton(2),
    Programmatic(3);

    private final int area;

    FKClickArea(int i10) {
        this.area = i10;
    }

    public final int getArea() {
        return this.area;
    }
}
