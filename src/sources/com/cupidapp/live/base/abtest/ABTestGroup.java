package com.cupidapp.live.base.abtest;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: GroupTestManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ABTestGroup {
    A("A"),
    B("B"),
    C("C");


    @NotNull
    private final String value;

    ABTestGroup(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
