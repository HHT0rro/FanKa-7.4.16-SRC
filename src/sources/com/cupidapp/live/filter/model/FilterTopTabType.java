package com.cupidapp.live.filter.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: FilterTopTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FilterTopTabType {
    Range("Range"),
    Select("Select");


    @NotNull
    private final String value;

    FilterTopTabType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
