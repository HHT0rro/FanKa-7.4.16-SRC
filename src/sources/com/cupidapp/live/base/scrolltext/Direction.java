package com.cupidapp.live.base.scrolltext;

import kotlin.d;

/* compiled from: CharOrderStrategy.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum Direction {
    SCROLL_UP(-1, 1),
    SCROLL_DOWN(1, 1),
    SCROLL_LEFT(-1, 0),
    SCROLL_RIGHT(1, 0);

    private final int orientation;
    private final int value;

    Direction(int i10, int i11) {
        this.value = i10;
        this.orientation = i11;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getValue() {
        return this.value;
    }
}
