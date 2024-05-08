package com.cupidapp.live.appdialog.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FillBirthdayModel extends AppDialogModel {

    @Nullable
    private final String content;

    @NotNull
    private final String itemId;

    @Nullable
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillBirthdayModel(@NotNull String scene, @NotNull String windowType, @NotNull String itemId, @Nullable String str, @Nullable String str2) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(itemId, "itemId");
        this.itemId = itemId;
        this.title = str;
        this.content = str2;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
