package com.cupidapp.live.appdialog.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FakeMaskPartyModel extends AppDialogModel {

    @Nullable
    private final ImageModel bgImage;

    @NotNull
    private final String buttonDesc;

    @Nullable
    private final String content;

    @Nullable
    private final String gameTrackName;

    @Nullable
    private final String giveMsg;
    private final int playType;

    @Nullable
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FakeMaskPartyModel(@NotNull String scene, @NotNull String windowType, @Nullable String str, @Nullable String str2, @Nullable String str3, int i10, @Nullable String str4, @Nullable ImageModel imageModel, @NotNull String buttonDesc) {
        super(scene, windowType, false, 4, null);
        s.i(scene, "scene");
        s.i(windowType, "windowType");
        s.i(buttonDesc, "buttonDesc");
        this.title = str;
        this.content = str2;
        this.giveMsg = str3;
        this.playType = i10;
        this.gameTrackName = str4;
        this.bgImage = imageModel;
        this.buttonDesc = buttonDesc;
    }

    @Nullable
    public final ImageModel getBgImage() {
        return this.bgImage;
    }

    @NotNull
    public final String getButtonDesc() {
        return this.buttonDesc;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getGameTrackName() {
        return this.gameTrackName;
    }

    @Nullable
    public final String getGiveMsg() {
        return this.giveMsg;
    }

    public final int getPlayType() {
        return this.playType;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
