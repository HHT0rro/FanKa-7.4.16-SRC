package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class VasExpireTextRemindModel extends AppDialogModel {

    @Nullable
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasExpireTextRemindModel(@NotNull String scene, @NotNull String windowType, @Nullable String str) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        this.text = str;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }
}
