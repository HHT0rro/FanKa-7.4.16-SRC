package com.cupidapp.live.chat.event;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpenChatWindowEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenChatWindowEvent {

    @NotNull
    private final User user;

    public OpenChatWindowEvent(@NotNull User user) {
        s.i(user, "user");
        this.user = user;
    }

    public static /* synthetic */ OpenChatWindowEvent copy$default(OpenChatWindowEvent openChatWindowEvent, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = openChatWindowEvent.user;
        }
        return openChatWindowEvent.copy(user);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @NotNull
    public final OpenChatWindowEvent copy(@NotNull User user) {
        s.i(user, "user");
        return new OpenChatWindowEvent(user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenChatWindowEvent) && s.d(this.user, ((OpenChatWindowEvent) obj).user);
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpenChatWindowEvent(user=" + ((Object) this.user) + ")";
    }
}
