package com.cupidapp.live.appdialog.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FakeScene {
    ChangeTab("ChangeTab"),
    Match("Match");


    @NotNull
    private final String scene;

    FakeScene(String str) {
        this.scene = str;
    }

    @NotNull
    public final String getScene() {
        return this.scene;
    }
}
