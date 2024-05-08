package z3;

import com.cupidapp.live.track.group.EventTrackMessageTopicClickType;
import com.cupidapp.live.track.group.EventTrackMessageType;
import com.irisdt.client.chat.ChatProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GroupChatLog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f54828a = new b();

    public final void a(@NotNull ChatProtos.Enum_type btn) {
        s.i(btn, "btn");
        c.f54829a.r(ChatProtos.Event.CHAT_BOX_BTN_CLICK, (r19 & 2) != 0 ? null : btn, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void b() {
        c.f54829a.r(ChatProtos.Event.CHAT_BOX_STROKE_LEFT_OR_LONG_PRESS, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void c() {
        c.f54829a.r(ChatProtos.Event.CHAT_BOX_SECRET_VIEW_MSG_TIPS, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void d(@Nullable String str, int i10) {
        c.f54829a.r(ChatProtos.Event.DELETE_VISIT_RECORD, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : str, (r19 & 8) != 0 ? null : Integer.valueOf(i10), (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void e(@NotNull EventTrackMessageType type, @Nullable String str) {
        s.i(type, "type");
        c.f54829a.r(ChatProtos.Event.GROUP_MESSAGE_CLICK, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : type.name(), (r19 & 256) == 0 ? str : null);
    }

    public final void f() {
        c.f54829a.r(ChatProtos.Event.INSTANT_MSG_TIPS, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : null, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void g(@Nullable String str, @Nullable EventTrackMessageTopicClickType eventTrackMessageTopicClickType) {
        c.f54829a.r(ChatProtos.Event.MESSAGE_TOPIC_CLICK, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : str, (r19 & 32) != 0 ? null : eventTrackMessageTopicClickType != null ? eventTrackMessageTopicClickType.name() : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void h(@Nullable String str) {
        c.f54829a.r(ChatProtos.Event.MESSAGE_TOPIC_SHOW, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : null, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : str, (r19 & 32) != 0 ? null : null, (r19 & 64) != 0 ? null : null, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void i(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        c.f54829a.r(ChatProtos.Event.MARKET_NOTICE_CLICK, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : str, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : str2, (r19 & 32) != 0 ? null : str3, (r19 & 64) != 0 ? null : str4, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }

    public final void j(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        c.f54829a.r(ChatProtos.Event.MARKET_NOTICE_SHOW, (r19 & 2) != 0 ? null : null, (r19 & 4) != 0 ? null : str, (r19 & 8) != 0 ? null : null, (r19 & 16) != 0 ? null : str2, (r19 & 32) != 0 ? null : str3, (r19 & 64) != 0 ? null : str4, (r19 & 128) != 0 ? null : null, (r19 & 256) == 0 ? null : null);
    }
}
