package com.cupidapp.live.chat2.holder;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatOptionsMessageViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SelectionOptionEvent {

    @NotNull
    private final String messageId;

    @NotNull
    private final String optionId;

    public SelectionOptionEvent(@NotNull String messageId, @NotNull String optionId) {
        s.i(messageId, "messageId");
        s.i(optionId, "optionId");
        this.messageId = messageId;
        this.optionId = optionId;
    }

    public static /* synthetic */ SelectionOptionEvent copy$default(SelectionOptionEvent selectionOptionEvent, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = selectionOptionEvent.messageId;
        }
        if ((i10 & 2) != 0) {
            str2 = selectionOptionEvent.optionId;
        }
        return selectionOptionEvent.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.messageId;
    }

    @NotNull
    public final String component2() {
        return this.optionId;
    }

    @NotNull
    public final SelectionOptionEvent copy(@NotNull String messageId, @NotNull String optionId) {
        s.i(messageId, "messageId");
        s.i(optionId, "optionId");
        return new SelectionOptionEvent(messageId, optionId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionOptionEvent)) {
            return false;
        }
        SelectionOptionEvent selectionOptionEvent = (SelectionOptionEvent) obj;
        return s.d(this.messageId, selectionOptionEvent.messageId) && s.d(this.optionId, selectionOptionEvent.optionId);
    }

    @NotNull
    public final String getMessageId() {
        return this.messageId;
    }

    @NotNull
    public final String getOptionId() {
        return this.optionId;
    }

    public int hashCode() {
        return (this.messageId.hashCode() * 31) + this.optionId.hashCode();
    }

    @NotNull
    public String toString() {
        return "SelectionOptionEvent(messageId=" + this.messageId + ", optionId=" + this.optionId + ")";
    }
}
