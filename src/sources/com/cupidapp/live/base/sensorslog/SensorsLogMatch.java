package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.c;

/* compiled from: SensorsLogMatch.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogMatch {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogMatch f12215a = new SensorsLogMatch();

    /* compiled from: SensorsLogMatch.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum AlohaGetPosition {
        CurrentAnchor("当前主播"),
        Connection("连麦"),
        PkAnchor("PK的主播"),
        AudienceList("观众列表"),
        SendGift("送礼物"),
        Comment("评论"),
        Others("其他");


        @NotNull
        private final String value;

        AlohaGetPosition(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    public final void a(@NotNull String failReason, @Nullable String str) {
        s.i(failReason, "failReason");
        GroupOthersLog.f18702a.r0(failReason, str);
    }

    public final void b(boolean z10, @NotNull String viewGetUserId, @NotNull InboxMessageType msgType, @NotNull String msgContent, boolean z11, @Nullable String str) {
        s.i(viewGetUserId, "viewGetUserId");
        s.i(msgType, "msgType");
        s.i(msgContent, "msgContent");
        GroupSocialLog.f18708a.r(z10, viewGetUserId, msgType, msgContent, z11, str);
    }

    public final void c(boolean z10, @NotNull String viewGetUserId, boolean z11, @Nullable String str) {
        s.i(viewGetUserId, "viewGetUserId");
        GroupSocialLog.f18708a.s(z10, viewGetUserId, z11, str);
    }

    public final void d(@NotNull String viewGetUserId, int i10, int i11, @Nullable String str, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene, @Nullable String str2, @Nullable String str3) {
        s.i(viewGetUserId, "viewGetUserId");
        c.f54829a.B(PostAndSocialProtos.Event.PHOTOS_SLIDE, (r137 & 2) != 0 ? null : null, (r137 & 4) != 0 ? null : null, (r137 & 8) != 0 ? null : viewGetUserId, (r137 & 16) != 0 ? null : null, (r137 & 32) != 0 ? null : str2, (r137 & 64) != 0 ? null : null, (r137 & 128) != 0 ? null : str, (r137 & 256) != 0 ? null : sensorScene != null ? sensorScene.getValue() : null, (r137 & 512) != 0 ? null : null, (r137 & 1024) != 0 ? null : Integer.valueOf(i11), (r137 & 2048) != 0 ? null : Integer.valueOf(i10), (r137 & 4096) != 0 ? null : null, (r137 & 8192) != 0 ? null : null, (r137 & 16384) != 0 ? null : null, (r137 & 32768) != 0 ? null : null, (r137 & 65536) != 0 ? null : null, (r137 & 131072) != 0 ? null : null, (r137 & 262144) != 0 ? null : null, (r137 & 524288) != 0 ? null : null, (r137 & 1048576) != 0 ? null : null, (r137 & 2097152) != 0 ? null : null, (r137 & 4194304) != 0 ? null : null, (r137 & 8388608) != 0 ? null : null, (r137 & 16777216) != 0 ? null : null, (r137 & 33554432) != 0 ? null : null, (r137 & 67108864) != 0 ? null : null, (r137 & 134217728) != 0 ? null : null, (r137 & 268435456) != 0 ? null : str3, (r137 & 536870912) != 0 ? null : null, (r137 & 1073741824) != 0 ? null : null, (r137 & Integer.MIN_VALUE) != 0 ? null : null, (r138 & 1) != 0 ? null : null, (r138 & 2) != 0 ? null : null, (r138 & 4) != 0 ? null : null, (r138 & 8) != 0 ? null : null, (r138 & 16) != 0 ? null : null, (r138 & 32) != 0 ? null : null, (r138 & 64) != 0 ? null : null, (r138 & 128) != 0 ? false : false, (r138 & 256) != 0 ? null : null, (r138 & 512) != 0 ? null : null, (r138 & 1024) != 0 ? null : null, (r138 & 2048) != 0 ? null : null, (r138 & 4096) != 0 ? null : null, (r138 & 8192) != 0 ? null : null, (r138 & 16384) != 0 ? null : null, (r138 & 32768) != 0 ? null : null, (r138 & 65536) != 0 ? null : null, (r138 & 131072) != 0 ? null : null, (r138 & 262144) != 0 ? null : null, (r138 & 524288) != 0 ? null : null, (r138 & 1048576) != 0 ? null : null, (r138 & 2097152) != 0 ? null : null, (r138 & 4194304) != 0 ? null : null, (r138 & 8388608) != 0 ? null : null, (r138 & 16777216) != 0 ? null : null, (r138 & 33554432) != 0 ? null : null, (r138 & 67108864) != 0 ? null : null, (r138 & 134217728) != 0 ? null : null, (r138 & 268435456) != 0 ? null : null, (r138 & 536870912) != 0 ? null : null, (r138 & 1073741824) != 0 ? null : null, (r138 & Integer.MIN_VALUE) != 0 ? null : null, (r139 & 1) != 0 ? null : null, (r139 & 2) != 0 ? null : null, (r139 & 4) != 0 ? null : null, (r139 & 8) != 0 ? null : null, (r139 & 16) != 0 ? null : null);
    }
}
