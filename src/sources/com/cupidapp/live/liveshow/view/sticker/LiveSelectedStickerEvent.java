package com.cupidapp.live.liveshow.view.sticker;

import com.cupidapp.live.liveshow.model.LiveStickerViewInfoModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveStickerEditMaskLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveSelectedStickerEvent {

    @NotNull
    private final LiveStickerViewInfoModel model;

    public LiveSelectedStickerEvent(@NotNull LiveStickerViewInfoModel model) {
        s.i(model, "model");
        this.model = model;
    }

    @NotNull
    public final LiveStickerViewInfoModel getModel() {
        return this.model;
    }
}
