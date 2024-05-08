package com.cupidapp.live.match.model;

import kotlin.d;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum SpecialInfoType {
    Hobby(1),
    Sports(2),
    Profession(3),
    Industry(4);

    private final int type;

    SpecialInfoType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
