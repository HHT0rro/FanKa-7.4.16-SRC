package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GeneralMatchFilterModel extends AppDialogModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneralMatchFilterModel(@NotNull String scene, @NotNull String windowType) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
    }
}
