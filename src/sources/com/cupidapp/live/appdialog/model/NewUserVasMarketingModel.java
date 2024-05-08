package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewUserVasMarketingModel extends AppDialogModel {

    @Nullable
    private final String activationType;

    @Nullable
    private final Boolean fullscreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserVasMarketingModel(@NotNull String scene, @NotNull String windowType, @Nullable String str, @Nullable Boolean bool) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        this.activationType = str;
        this.fullscreen = bool;
    }

    @Nullable
    public final String getActivationType() {
        return this.activationType;
    }

    @Nullable
    public final Boolean getFullscreen() {
        return this.fullscreen;
    }
}
