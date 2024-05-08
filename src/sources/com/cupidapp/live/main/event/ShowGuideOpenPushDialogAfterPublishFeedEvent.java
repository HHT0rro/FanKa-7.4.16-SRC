package com.cupidapp.live.main.event;

import com.cupidapp.live.appdialog.model.GuideOpenPushDialogModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MainEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ShowGuideOpenPushDialogAfterPublishFeedEvent {

    @NotNull
    private final GuideOpenPushDialogModel model;

    public ShowGuideOpenPushDialogAfterPublishFeedEvent(@NotNull GuideOpenPushDialogModel model) {
        s.i(model, "model");
        this.model = model;
    }

    @NotNull
    public final GuideOpenPushDialogModel getModel() {
        return this.model;
    }
}
