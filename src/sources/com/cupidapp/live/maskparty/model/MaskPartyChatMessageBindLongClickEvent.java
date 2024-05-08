package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.base.utils.PopupWindowLocationModel;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatMessageBindLongClickEvent {

    @NotNull
    private final ArrayList<MaskPartyLongClickActionType> actions;

    @NotNull
    private final MaskPartyChatMessageModel model;

    @NotNull
    private final PopupWindowLocationModel popupLocation;

    public MaskPartyChatMessageBindLongClickEvent(@NotNull ArrayList<MaskPartyLongClickActionType> actions, @NotNull MaskPartyChatMessageModel model, @NotNull PopupWindowLocationModel popupLocation) {
        s.i(actions, "actions");
        s.i(model, "model");
        s.i(popupLocation, "popupLocation");
        this.actions = actions;
        this.model = model;
        this.popupLocation = popupLocation;
    }

    @NotNull
    public final ArrayList<MaskPartyLongClickActionType> getActions() {
        return this.actions;
    }

    @NotNull
    public final MaskPartyChatMessageModel getModel() {
        return this.model;
    }

    @NotNull
    public final PopupWindowLocationModel getPopupLocation() {
        return this.popupLocation;
    }
}
