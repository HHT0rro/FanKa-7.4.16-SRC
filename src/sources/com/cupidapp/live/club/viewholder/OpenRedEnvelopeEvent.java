package com.cupidapp.live.club.viewholder;

import com.cupidapp.live.club.model.ClubChatMsgModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatRedPacketViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenRedEnvelopeEvent {

    @NotNull
    private final ClubChatMsgModel message;

    public OpenRedEnvelopeEvent(@NotNull ClubChatMsgModel message) {
        s.i(message, "message");
        this.message = message;
    }

    public static /* synthetic */ OpenRedEnvelopeEvent copy$default(OpenRedEnvelopeEvent openRedEnvelopeEvent, ClubChatMsgModel clubChatMsgModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            clubChatMsgModel = openRedEnvelopeEvent.message;
        }
        return openRedEnvelopeEvent.copy(clubChatMsgModel);
    }

    @NotNull
    public final ClubChatMsgModel component1() {
        return this.message;
    }

    @NotNull
    public final OpenRedEnvelopeEvent copy(@NotNull ClubChatMsgModel message) {
        s.i(message, "message");
        return new OpenRedEnvelopeEvent(message);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenRedEnvelopeEvent) && s.d(this.message, ((OpenRedEnvelopeEvent) obj).message);
    }

    @NotNull
    public final ClubChatMsgModel getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpenRedEnvelopeEvent(message=" + ((Object) this.message) + ")";
    }
}
