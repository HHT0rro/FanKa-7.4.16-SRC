package com.cupidapp.live.liveshow.view.tag;

import kotlin.d;

/* compiled from: LiveShowTagView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum TagScrollingType {
    OverallScrolling(0),
    InternalScrolling(1),
    PartialScrolling(2);

    private final int type;

    TagScrollingType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
