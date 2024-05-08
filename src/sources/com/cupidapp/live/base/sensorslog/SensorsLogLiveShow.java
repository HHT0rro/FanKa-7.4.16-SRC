package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.irisdt.client.advertisement.AdvertisementProtos;
import com.irisdt.client.live.LiveProtos;
import com.mobile.auth.gatewayauth.ResultCode;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.c;

/* compiled from: SensorsLogLiveShow.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogLiveShow {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogLiveShow f12212a = new SensorsLogLiveShow();

    /* renamed from: b, reason: collision with root package name */
    public static long f12213b;

    /* renamed from: c, reason: collision with root package name */
    public static long f12214c;

    /* compiled from: SensorsLogLiveShow.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum EnterLiveShowSource {
        FOLLOWING_LIST,
        LIVE_HOT,
        LIVE_NEARBY,
        PUSH,
        SHARE,
        PROFILE,
        MINI_PROFILE,
        SWITCH,
        OTHERS,
        LiveShowEnterMiniLive,
        MATCH,
        LIVE_RECOMMEND,
        LIVE_COMPONENT,
        LIVE_WINDOW,
        LIVE_CONFIGURABLE,
        PUSH_CARD,
        MULTI_PK
    }

    /* compiled from: SensorsLogLiveShow.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LivePkResult {
        LivePkDraw(0, "平局"),
        LivePkWin(1, "胜利"),
        LivePkFailed(2, ResultCode.MSG_FAILED);


        @NotNull
        private final String result;
        private final int type;

        LivePkResult(int i10, String str) {
            this.type = i10;
            this.result = str;
        }

        @NotNull
        public final String getResult() {
            return this.result;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: SensorsLogLiveShow.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PkRequestType {
        RandomPkMatch(0),
        ChallengeFriends(1),
        MultiPk(2);

        private final int type;

        PkRequestType(int i10) {
            this.type = i10;
        }

        public final int getType() {
            return this.type;
        }
    }

    public final void a(@NotNull String roomId, @Nullable String str, int i10, int i11, @NotNull String giftId, @NotNull FKLiveType liveType, @Nullable Integer num, boolean z10, @Nullable Integer num2, int i12, @Nullable String str2) {
        s.i(roomId, "roomId");
        s.i(giftId, "giftId");
        s.i(liveType, "liveType");
        GroupLiveLog.f18698a.D(roomId, str, giftId, Integer.valueOf(i10), i11, liveType.name(), num, z10, num2, i12, str2);
    }

    public final void b(@NotNull String criticalHitType, int i10) {
        s.i(criticalHitType, "criticalHitType");
        c.f54829a.p(AdvertisementProtos.Event.HIGHLIGHT_MOMENT, (r62 & 2) != 0 ? null : criticalHitType, (r62 & 4) != 0 ? null : null, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : null, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : Integer.valueOf(i10), (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }

    public final void c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable SensorScene sensorScene, @NotNull String viewerCount, @Nullable Integer num, @Nullable String str4, @Nullable SensorPosition sensorPosition, @NotNull LiveProtos.CoverType coverType, @Nullable String str5, @Nullable String str6, @Nullable Double d10, @Nullable String str7) {
        s.i(viewerCount, "viewerCount");
        s.i(coverType, "coverType");
        GroupLiveLog.f18698a.B(sensorPosition != null ? sensorPosition.getValue() : null, str2, str3, bool, viewerCount, str4, sensorScene, num, str, coverType, str5, str6, d10, str7);
    }

    public final void d(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, int i10, @Nullable SensorScene sensorScene, @Nullable String str3, @Nullable String str4, @NotNull FKLiveType liveType, @Nullable Boolean bool2) {
        s.i(liveType, "liveType");
        GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        groupLiveLog.C(str, str2, str4, i10, fKLiveConstantsData.getTotalDiamondCount(), fKLiveConstantsData.getTotalCommentCount(), bool, str3, sensorScene, liveType.name(), bool2);
    }

    public final void e(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.f54829a.v(LiveProtos.Event.LIVE_PASTER_USE_SUCCESS, (r79 & 2) != 0 ? null : null, (r79 & 4) != 0 ? null : str, (r79 & 8) != 0 ? null : str2, (r79 & 16) != 0 ? null : null, (r79 & 32) != 0 ? null : str3, (r79 & 64) != 0 ? null : null, (r79 & 128) != 0 ? null : null, (r79 & 256) != 0 ? null : null, (r79 & 512) != 0 ? null : null, (r79 & 1024) != 0 ? null : null, (r79 & 2048) != 0 ? null : null, (r79 & 4096) != 0 ? null : null, (r79 & 8192) != 0 ? null : null, (r79 & 16384) != 0 ? null : null, (r79 & 32768) != 0 ? null : null, (r79 & 65536) != 0 ? null : null, (r79 & 131072) != 0 ? null : null, (r79 & 262144) != 0 ? null : null, (r79 & 524288) != 0 ? null : null, (r79 & 1048576) != 0 ? null : null, (r79 & 2097152) != 0 ? null : null, (r79 & 4194304) != 0 ? null : null, (r79 & 8388608) != 0 ? null : null, (r79 & 16777216) != 0 ? null : null, (r79 & 33554432) != 0 ? null : null, (r79 & 67108864) != 0 ? null : null, (r79 & 134217728) != 0 ? null : null, (r79 & 268435456) != 0 ? null : null, (r79 & 536870912) != 0 ? null : null, (r79 & 1073741824) != 0 ? null : null, (r79 & Integer.MIN_VALUE) != 0 ? null : null, (r80 & 1) != 0 ? null : null, (r80 & 2) != 0 ? null : null, (r80 & 4) != 0 ? null : null, (r80 & 8) != 0 ? null : null, (r80 & 16) != 0 ? null : null, (r80 & 32) != 0 ? null : null, (r80 & 64) == 0 ? null : null);
    }

    public final void f(@Nullable String str, @Nullable String str2, @NotNull LiveProtos.Type type, @Nullable String str3, @Nullable String str4) {
        s.i(type, "type");
        GroupLiveLog.f18698a.u(str, str2, type, str3, str4);
    }

    public final void h(@NotNull String roomId, @NotNull String anchorId, int i10, int i11, int i12) {
        s.i(roomId, "roomId");
        s.i(anchorId, "anchorId");
        GroupLiveLog.f18698a.v(roomId, anchorId, i10, i11, i12);
    }

    public final void i(@NotNull String roomId, @NotNull String anchorId, @NotNull String giftTabName) {
        s.i(roomId, "roomId");
        s.i(anchorId, "anchorId");
        s.i(giftTabName, "giftTabName");
        GroupLiveLog.f18698a.E(roomId, anchorId, giftTabName);
    }

    public final void j(@NotNull String id2, @Nullable String str) {
        s.i(id2, "id");
        c.f54829a.p(AdvertisementProtos.Event.HORN_CLICK, (r62 & 2) != 0 ? null : null, (r62 & 4) != 0 ? null : id2, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : str, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }

    public final void k(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, int i10, int i11, @Nullable LivePkResult livePkResult, float f10) {
        GroupLiveLog.f18698a.I(str, str2, str3, z10, livePkResult != null ? Integer.valueOf(livePkResult.getType()) : null, f10, i10);
    }

    public final void l(@NotNull String matchId, @NotNull String roomId, @Nullable String str, boolean z10) {
        s.i(matchId, "matchId");
        s.i(roomId, "roomId");
        GroupLiveLog.f18698a.J(matchId, roomId, str, Boolean.valueOf(z10), LivePkType.DoublePk, null);
    }

    public final void m(@Nullable String str, @Nullable String str2, @Nullable String str3, int i10) {
        GroupLiveLog.f18698a.K(str, str2, i10, str3);
    }

    public final void n() {
        f12213b = 0L;
        f12214c = 0L;
    }

    public final void o(@NotNull String roomId, @Nullable String str, @NotNull SensorPosition position, @NotNull SensorScene scene, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable EnterLiveShowSource enterLiveShowSource, @Nullable FKLiveType fKLiveType, @Nullable LiveProtos.CoverType coverType, @Nullable String str4, @Nullable String str5, @Nullable Double d10, @Nullable String str6) {
        s.i(roomId, "roomId");
        s.i(position, "position");
        s.i(scene, "scene");
        GroupLiveLog.f18698a.A(roomId, str, position, scene, str2, str3, num, enterLiveShowSource != null ? enterLiveShowSource.name() : null, fKLiveType != null ? fKLiveType.name() : null, coverType, str4, str5, d10, str6);
    }

    public final void q(@NotNull String roomId, @Nullable String str, @NotNull LiveProtos.Type type, @NotNull String commentContent, @NotNull FKLiveType liveType) {
        s.i(roomId, "roomId");
        s.i(type, "type");
        s.i(commentContent, "commentContent");
        s.i(liveType, "liveType");
        GroupLiveLog.f18698a.w(roomId, str, type, commentContent, liveType.name());
    }

    public final void r(@NotNull PkRequestType pkType) {
        s.i(pkType, "pkType");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            GroupLiveLog.f18698a.N(liveShowModel.getItemId(), pkType.getType());
        }
    }

    public final void s(@Nullable String str, @Nullable FKHornType fKHornType, @Nullable String str2) {
        c.f54829a.p(AdvertisementProtos.Event.HORN_SHOW, (r62 & 2) != 0 ? null : fKHornType != null ? fKHornType.getHornName() : null, (r62 & 4) != 0 ? null : str, (r62 & 8) != 0 ? null : null, (r62 & 16) != 0 ? null : null, (r62 & 32) != 0 ? null : null, (r62 & 64) != 0 ? null : str2, (r62 & 128) != 0 ? null : null, (r62 & 256) != 0 ? null : null, (r62 & 512) != 0 ? null : null, (r62 & 1024) != 0 ? null : null, (r62 & 2048) != 0 ? null : null, (r62 & 4096) != 0 ? null : null, (r62 & 8192) != 0 ? null : null, (r62 & 16384) != 0 ? null : null, (r62 & 32768) != 0 ? null : null, (r62 & 65536) != 0 ? null : null, (r62 & 131072) != 0 ? null : null, (r62 & 262144) != 0 ? null : null, (r62 & 524288) != 0 ? null : null, (r62 & 1048576) != 0 ? null : null, (r62 & 2097152) != 0 ? null : null, (r62 & 4194304) != 0 ? null : null, (r62 & 8388608) != 0 ? null : null, (r62 & 16777216) != 0 ? null : null, (r62 & 33554432) != 0 ? null : null, (r62 & 67108864) != 0 ? null : null, (r62 & 134217728) != 0 ? null : null, (r62 & 268435456) != 0 ? null : null, (r62 & 536870912) == 0 ? null : null);
    }

    public final void t(@NotNull String roomId, @Nullable String str, @NotNull String pushStatus) {
        s.i(roomId, "roomId");
        s.i(pushStatus, "pushStatus");
        GroupLiveLog.f18698a.q(roomId, str, pushStatus);
    }
}
