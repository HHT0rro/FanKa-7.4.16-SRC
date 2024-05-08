package com.cupidapp.live.appdialog.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GuideOpenPushDialogModel extends AppDialogModel {

    @NotNull
    private final ImageModel image;

    @Nullable
    private final Long ruleId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideOpenPushDialogModel(@NotNull String scene, @NotNull String windowType, @Nullable Long l10, @NotNull ImageModel image) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(image, "image");
        this.ruleId = l10;
        this.image = image;
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final Long getRuleId() {
        return this.ruleId;
    }
}
