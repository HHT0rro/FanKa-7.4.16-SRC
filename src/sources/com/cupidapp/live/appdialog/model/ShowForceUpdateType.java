package com.cupidapp.live.appdialog.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ShowForceUpdateType {
    Notify("notify"),
    Force("force");


    @NotNull
    private final String type;

    ShowForceUpdateType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
