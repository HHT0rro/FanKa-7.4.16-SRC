package com.cupidapp.live.club.model;

import com.cupidapp.live.chat2.model.LongClickActionType;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatMsgBindLongClickEvent {

    @NotNull
    private final ArrayList<LongClickActionType> actions;

    @NotNull
    private final ClubChatMsgModel model;

    public ClubChatMsgBindLongClickEvent(@NotNull ArrayList<LongClickActionType> actions, @NotNull ClubChatMsgModel model) {
        s.i(actions, "actions");
        s.i(model, "model");
        this.actions = actions;
        this.model = model;
    }

    @NotNull
    public final ArrayList<LongClickActionType> getActions() {
        return this.actions;
    }

    @NotNull
    public final ClubChatMsgModel getModel() {
        return this.model;
    }
}
