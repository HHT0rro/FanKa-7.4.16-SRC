package com.cupidapp.live.performance.time;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: LaunchTimer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum LoadAdResult {
    LOAD_SUCCEED("LOAD_SUCCEED"),
    LOAD_FAILED("LOAD_FAILED"),
    NOT_LOAD("NOT_LOAD"),
    ADLIST_LOAD_FAILED("ADLIST_LOAD_FAILED");


    @NotNull
    private final String value;

    LoadAdResult(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
