package com.cupidapp.live.appdialog.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FakeAvatarModel extends AppDialogModel {
    private final boolean canClose;

    @NotNull
    private final String content;

    @Nullable
    private final ImageModel fakeAvatar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeAvatarModel(@NotNull String scene, @NotNull String windowType, @Nullable ImageModel imageModel, boolean z10, @NotNull String content) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(content, "content");
        this.fakeAvatar = imageModel;
        this.canClose = z10;
        this.content = content;
    }

    public final boolean getCanClose() {
        return this.canClose;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ImageModel getFakeAvatar() {
        return this.fakeAvatar;
    }
}
