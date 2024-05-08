package com.cupidapp.live.base.network.gson;

import kotlin.d;

/* compiled from: LiveShowTagJsonDeserializer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveShowTagType {
    LiveTag(1),
    FanClubTag(2);

    private final int type;

    LiveShowTagType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
