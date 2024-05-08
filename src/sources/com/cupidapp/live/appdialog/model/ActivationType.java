package com.cupidapp.live.appdialog.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ActivationType {
    SuperLike("superlike"),
    SuperBoost("superboost"),
    Recall("Recall");


    @NotNull
    private final String value;

    ActivationType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
