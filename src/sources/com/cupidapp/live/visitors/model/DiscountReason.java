package com.cupidapp.live.visitors.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum DiscountReason {
    FirstTime("FirstTime"),
    ReBuy("Rebuy");


    @NotNull
    private final String value;

    DiscountReason(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
