package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorLogActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorLogActivity {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorLogActivity f12204a = new SensorLogActivity();

    /* compiled from: SensorLogActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Type {
        MATCH("HOMEPAGE_ICON"),
        ACTIVITY("ACT_PENDANT"),
        PROFILE("PROFILE_MENU_BAR"),
        LIVE_SHOW_AD("LIVE_ROOM_AD"),
        CONTEST("CONTEST"),
        HIGHLIGHT_MOMENT_COUNT_DOWN("HIGHLIGHT_MOMENT_COUNT_DOWN"),
        COMMON_CONTEST("COMMON_CONTEST"),
        HIGH_RANK_CONTEST("HIGH_RANK_CONTEST"),
        CHAT_ACTIVITY("CHAT_ACTIVITY"),
        TOP_RED_PACKET("TOP_RED_PACKET"),
        TREASURE_BOX("TREASURE_BOX"),
        GIFT_BANNER("LUCKY_GIFT_REWARD_DIAMOND");


        @NotNull
        private final String type;

        Type(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        GroupOthersLog.f18702a.a(str, str2, str3);
    }

    public final void b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        GroupOthersLog.f18702a.b(str, str2, str3);
    }
}
