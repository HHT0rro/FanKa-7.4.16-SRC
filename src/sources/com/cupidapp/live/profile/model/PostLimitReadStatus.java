package com.cupidapp.live.profile.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum PostLimitReadStatus {
    Read(0),
    UnRead(1),
    NoPostLimit(null);


    @Nullable
    private final Integer value;

    PostLimitReadStatus(Integer num) {
        this.value = num;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
