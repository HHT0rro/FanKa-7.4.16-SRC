package com.cupidapp.live.chat.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatStateFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ChatState {
    ;

    private final int contentRes;

    @Nullable
    private final Integer value;

    ChatState(Integer num, int i10) {
        this.value = num;
        this.contentRes = i10;
    }

    public final int getContentRes() {
        return this.contentRes;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }
}
