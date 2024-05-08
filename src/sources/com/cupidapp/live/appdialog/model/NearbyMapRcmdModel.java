package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NearbyMapRcmdModel extends AppDialogModel {

    @Nullable
    private final String text;

    @Nullable
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyMapRcmdModel(@NotNull String scene, @NotNull String windowType, @Nullable String str, @Nullable String str2) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        this.text = str;
        this.title = str2;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
