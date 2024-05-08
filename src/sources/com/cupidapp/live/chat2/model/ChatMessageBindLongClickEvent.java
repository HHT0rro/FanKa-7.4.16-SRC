package com.cupidapp.live.chat2.model;

import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMessageBindLongClickEvent {

    @NotNull
    private final ArrayList<LongClickActionType> actions;

    @NotNull
    private final ChatMessageModel model;

    public ChatMessageBindLongClickEvent(@NotNull ArrayList<LongClickActionType> actions, @NotNull ChatMessageModel model) {
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
    public final ChatMessageModel getModel() {
        return this.model;
    }
}
