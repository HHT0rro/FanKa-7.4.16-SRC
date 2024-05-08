package com.cupidapp.live.track.group;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.liveshow.model.LiveCommentGuideType;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.PropsType;
import com.cupidapp.live.liveshow.pk.view.MultiPersonPkState;
import com.irisdt.client.live.LiveProtos;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z3.c;

/* compiled from: GroupLiveLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GroupLiveLog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GroupLiveLog f18698a = new GroupLiveLog();

    /* compiled from: GroupLiveLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum LiveUserTag {
        NEW_PEOPLE
    }

    /* compiled from: GroupLiveLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18699a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18700b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f18701c;

        static {
            int[] iArr = new int[LivePkType.values().length];
            try {
                iArr[LivePkType.DoublePk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LivePkType.MultiPk.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18699a = iArr;
            int[] iArr2 = new int[MultiPersonPkState.values().length];
            try {
                iArr2[MultiPersonPkState.PKPrepare.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MultiPersonPkState.PKing.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MultiPersonPkState.PKInteract.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f18700b = iArr2;
            int[] iArr3 = new int[LiveCommentGuideType.values().length];
            try {
                iArr3[LiveCommentGuideType.AlohaType.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[LiveCommentGuideType.AlohaAlertType.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[LiveCommentGuideType.ChatType.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[LiveCommentGuideType.SendGiftType.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f18701c = iArr3;
        }
    }

    public static /* synthetic */ void i(GroupLiveLog groupLiveLog, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        groupLiveLog.h(str, str2);
    }

    public final void A(@NotNull String roomId, @Nullable String str, @NotNull SensorPosition position, @NotNull SensorScene scene, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable LiveProtos.CoverType coverType, @Nullable String str6, @Nullable String str7, @Nullable Double d10, @Nullable String str8) {
        s.i(roomId, "roomId");
        s.i(position, "position");
        s.i(scene, "scene");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_DRAW, null, roomId, str, str2 != null ? Integer.valueOf(t.q(str2)) : null, str3, null, Boolean.valueOf(num != null), null, null, null, position.getValue(), scene.getValue(), null, null, null, str5, str4, coverType, str6, str7, null, d10, null, null, null, str8, null, null, null, null, null, null, null, null, null, null, null, null, -73341118, 127, null);
    }

    public final void B(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @NotNull String viewerCount, @Nullable String str4, @Nullable SensorScene sensorScene, @Nullable Integer num, @Nullable String str5, @NotNull LiveProtos.CoverType coverType, @Nullable String str6, @Nullable String str7, @Nullable Double d10, @Nullable String str8) {
        s.i(viewerCount, "viewerCount");
        s.i(coverType, "coverType");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_ENTER, null, str2, str3, Integer.valueOf(t.q(viewerCount)), str4, null, bool, null, null, null, str, sensorScene != null ? sensorScene.getValue() : null, null, Boolean.valueOf(num != null), null, null, str5, coverType, str6, str7, null, d10, null, null, null, str8, null, null, null, null, null, null, null, null, null, null, null, null, -73291966, 127, null);
    }

    public final void C(@Nullable String str, @Nullable String str2, @Nullable String str3, int i10, float f10, int i11, @Nullable Boolean bool, @Nullable String str4, @Nullable SensorScene sensorScene, @Nullable String str5, @Nullable Boolean bool2) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_EXIT, null, str, str2, Integer.valueOf(i11), str4, null, bool, Integer.valueOf(i10), Float.valueOf(f10), null, str3, sensorScene != null ? sensorScene.getValue() : null, null, null, null, str5, null, null, null, null, null, null, null, null, bool2, null, null, null, null, null, null, null, null, null, null, null, null, null, -33627070, 127, null);
    }

    public final void D(@NotNull String roomId, @Nullable String str, @NotNull String giftId, @Nullable Integer num, int i10, @Nullable String str2, @Nullable Integer num2, boolean z10, @Nullable Integer num3, int i11, @Nullable String str3) {
        s.i(roomId, "roomId");
        s.i(giftId, "giftId");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_GIFT_SEND_SUCCESS, null, roomId, str, Integer.valueOf(i10), giftId, null, null, null, num != null ? Float.valueOf(num.intValue() * i10) : null, null, null, str3, num2, null, null, str2, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z10), num3, Integer.valueOf(i11), null, null, null, null, null, null, null, null, null, -939602494, 127, null);
    }

    public final void E(@NotNull String roomId, @NotNull String anchorId, @NotNull String giftTabName) {
        s.i(roomId, "roomId");
        s.i(anchorId, "anchorId");
        s.i(giftTabName, "giftTabName");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_GIFT_SHOW, null, roomId, anchorId, null, giftTabName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -46, 127, null);
    }

    public final void F(@NotNull LiveCommentGuideType guideType) {
        LiveProtos.Type type;
        s.i(guideType, "guideType");
        int i10 = a.f18701c[guideType.ordinal()];
        if (i10 == 1) {
            type = LiveProtos.Type.COMMENT_FOLLOW_GUIDE;
        } else if (i10 == 2) {
            type = LiveProtos.Type.BOTTOM_FOLLOW_GUIDE;
        } else if (i10 != 3) {
            type = i10 != 4 ? null : LiveProtos.Type.GIFT_GUIDE;
        } else {
            type = LiveProtos.Type.CHAT_GUIDE;
        }
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_GUIDE_CLICK, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, guideType.getType(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388612, 127, null);
    }

    public final void G(@NotNull LiveCommentGuideType guideType) {
        LiveProtos.Type type;
        s.i(guideType, "guideType");
        int i10 = a.f18701c[guideType.ordinal()];
        if (i10 == 1) {
            type = LiveProtos.Type.COMMENT_FOLLOW_GUIDE;
        } else if (i10 == 2) {
            type = LiveProtos.Type.BOTTOM_FOLLOW_GUIDE;
        } else if (i10 != 3) {
            type = i10 != 4 ? null : LiveProtos.Type.GIFT_GUIDE;
        } else {
            type = LiveProtos.Type.CHAT_GUIDE;
        }
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_GUIDE_SHOW, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, guideType.getType(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388612, 127, null);
    }

    public final void H(@NotNull String message) {
        s.i(message, "message");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_QUICK_CHAT_CLICK, null, null, null, null, null, null, null, null, null, message, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1026, 127, null);
    }

    public final void I(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, @Nullable Integer num, float f10, int i10) {
        LiveProtos.Result result;
        if (num != null && num.intValue() == 0) {
            result = LiveProtos.Result.DRAW;
        } else if (num != null && num.intValue() == 1) {
            result = LiveProtos.Result.SUCCESS;
        } else {
            result = (num != null && num.intValue() == 2) ? LiveProtos.Result.FAIL : null;
        }
        c.w(c.f54829a, LiveProtos.Event.PK_FINISH, e(Boolean.valueOf(z10)), str2, str3, Integer.valueOf((int) f10), str, null, null, Integer.valueOf(i10), null, null, null, null, null, null, result, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33088, 127, null);
    }

    public final void J(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @NotNull LivePkType pkType, @Nullable MultiPersonPkState multiPersonPkState) {
        LiveProtos.Type e2;
        s.i(pkType, "pkType");
        c cVar = c.f54829a;
        LiveProtos.Event event = LiveProtos.Event.PK_FINISH_CLICK;
        int i10 = a.f18699a[pkType.ordinal()];
        if (i10 == 1) {
            e2 = e(bool);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            e2 = d(multiPersonPkState);
        }
        c.w(cVar, event, e2, str2, str3, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -48, 127, null);
    }

    public final void K(@Nullable String str, @Nullable String str2, int i10, @Nullable String str3) {
        LiveProtos.Type type;
        if (i10 == 0) {
            type = LiveProtos.Type.RANDOM_MATCH;
        } else if (i10 != 1) {
            type = i10 != 2 ? null : LiveProtos.Type.ACCEPT_PK;
        } else {
            type = LiveProtos.Type.START_PK;
        }
        c.w(c.f54829a, LiveProtos.Event.PK_MATCH_SUCCESS, type, str2, str3, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -48, 127, null);
    }

    public final void L(@NotNull String sku, boolean z10) {
        s.i(sku, "sku");
        c.w(c.f54829a, LiveProtos.Event.GIFT_RECHARGE_SUCCESS, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, sku, Boolean.valueOf(z10), null, null, null, null, -2, 121, null);
    }

    public final void M(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10) {
        c.w(c.f54829a, LiveProtos.Event.MULTI_PK_START, z10 ? LiveProtos.Type.START_MULTI_PK : LiveProtos.Type.ACCEPT_MULTI_PK, str2, str3, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -48, 127, null);
    }

    public final void N(@NotNull String roomId, int i10) {
        LiveProtos.Type type;
        s.i(roomId, "roomId");
        if (i10 == 0) {
            type = LiveProtos.Type.RANDOM_MATCH;
        } else if (i10 != 1) {
            type = i10 != 2 ? null : LiveProtos.Type.MULTI_PK;
        } else {
            type = LiveProtos.Type.START_PK;
        }
        c.w(c.f54829a, LiveProtos.Event.LAUNCH_PK, type, null, null, null, roomId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -36, 127, null);
    }

    public final void O(boolean z10) {
        c.w(c.f54829a, LiveProtos.Event.TEENAGER_MODE_SWITCH, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, z10 ? "IN" : "OUT", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65538, 127, null);
    }

    public final void a(@Nullable String str) {
        c.w(c.f54829a, LiveProtos.Event.ACCEPT_INVITE_MULTI_PK, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6, 127, null);
    }

    public final void b(boolean z10, @NotNull String anchorId, boolean z11) {
        s.i(anchorId, "anchorId");
        c.w(c.f54829a, LiveProtos.Event.ANCHOR_FANS_GROUP_SHOW, z11 ? LiveProtos.Type.TOP_FANS_GROUP : LiveProtos.Type.FANS_GROUP, null, anchorId, null, null, null, Boolean.valueOf(z10), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -140, 127, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(@org.jetbrains.annotations.Nullable java.lang.String r48, @org.jetbrains.annotations.Nullable java.lang.String r49, @org.jetbrains.annotations.Nullable java.lang.String r50, @org.jetbrains.annotations.NotNull com.cupidapp.live.liveshow.pk.view.MultiPersonPkState r51, @org.jetbrains.annotations.Nullable java.lang.String r52, @org.jetbrains.annotations.Nullable java.lang.Integer r53, int r54) {
        /*
            r47 = this;
            r0 = r52
            java.lang.String r1 = "pkState"
            r2 = r51
            kotlin.jvm.internal.s.i(r2, r1)
            int[] r1 = com.cupidapp.live.track.group.GroupLiveLog.a.f18700b
            int r2 = r51.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 0
            if (r1 == r2) goto L1d
            r2 = 3
            if (r1 == r2) goto L1a
            r6 = r3
            goto L20
        L1a:
            com.irisdt.client.live.LiveProtos$Type r1 = com.irisdt.client.live.LiveProtos.Type.MULTI_PK_PUNISHMENT
            goto L1f
        L1d:
            com.irisdt.client.live.LiveProtos$Type r1 = com.irisdt.client.live.LiveProtos.Type.MULTI_PK
        L1f:
            r6 = r1
        L20:
            z3.c r4 = z3.c.f54829a
            com.irisdt.client.live.LiveProtos$Event r5 = com.irisdt.client.live.LiveProtos.Event.MULTI_PK_FINISH
            com.cupidapp.live.liveshow.pk.model.MultiLivePkResult r1 = com.cupidapp.live.liveshow.pk.model.MultiLivePkResult.LivePkWin
            java.lang.String r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.s.d(r0, r1)
            if (r1 == 0) goto L35
            com.irisdt.client.live.LiveProtos$Result r3 = com.irisdt.client.live.LiveProtos.Result.SUCCESS
        L32:
            r20 = r3
            goto L53
        L35:
            com.cupidapp.live.liveshow.pk.model.MultiLivePkResult r1 = com.cupidapp.live.liveshow.pk.model.MultiLivePkResult.LivePkFailed
            java.lang.String r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.s.d(r0, r1)
            if (r1 == 0) goto L44
            com.irisdt.client.live.LiveProtos$Result r3 = com.irisdt.client.live.LiveProtos.Result.FAIL
            goto L32
        L44:
            com.cupidapp.live.liveshow.pk.model.MultiLivePkResult r1 = com.cupidapp.live.liveshow.pk.model.MultiLivePkResult.LivePkDraw
            java.lang.String r1 = r1.getValue()
            boolean r0 = kotlin.jvm.internal.s.d(r0, r1)
            if (r0 == 0) goto L32
            com.irisdt.client.live.LiveProtos$Result r3 = com.irisdt.client.live.LiveProtos.Result.DRAW
            goto L32
        L53:
            r11 = 0
            r12 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r54)
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = -33088(0xffffffffffff7ec0, float:NaN)
            r45 = 127(0x7f, float:1.78E-43)
            r46 = 0
            r7 = r49
            r8 = r50
            r9 = r53
            r10 = r48
            z3.c.w(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.track.group.GroupLiveLog.c(java.lang.String, java.lang.String, java.lang.String, com.cupidapp.live.liveshow.pk.view.MultiPersonPkState, java.lang.String, java.lang.Integer, int):void");
    }

    public final LiveProtos.Type d(MultiPersonPkState multiPersonPkState) {
        int i10 = multiPersonPkState == null ? -1 : a.f18700b[multiPersonPkState.ordinal()];
        if (i10 == 1) {
            return LiveProtos.Type.MULTI_BEFORE_START;
        }
        if (i10 == 2) {
            return LiveProtos.Type.MULTI_PK;
        }
        if (i10 != 3) {
            return null;
        }
        return LiveProtos.Type.MULTI_PK_PUNISHMENT;
    }

    public final LiveProtos.Type e(Boolean bool) {
        return s.d(bool, Boolean.TRUE) ? LiveProtos.Type.PK_ING : LiveProtos.Type.PUNISHMENT;
    }

    public final void f(boolean z10) {
        if (z10) {
            c.w(c.f54829a, LiveProtos.Event.AUDIENCE_HEARTBEAT, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 127, null);
        } else {
            c.w(c.f54829a, LiveProtos.Event.ANCHOR_HEARTBEAT, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 127, null);
        }
    }

    public final void g(@Nullable String str, @Nullable String str2) {
        c.w(c.f54829a, LiveProtos.Event.INVITE_JOIN_MULTI_PK, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str2, -6, 63, null);
    }

    public final void h(@NotNull String name, @Nullable String str) {
        s.i(name, "name");
        c.w(c.f54829a, LiveProtos.Event.LIVE_BEAUTY_FUNCTION_USE_SUCCESS, null, null, null, null, name, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1058, 127, null);
    }

    public final void j(@NotNull String name) {
        s.i(name, "name");
        c.w(c.f54829a, LiveProtos.Event.LIVE_BEAUTY_ITEM_SHOW, null, null, null, null, name, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -34, 127, null);
    }

    public final void k(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_GIFT_SHOW, null, str, str2, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -46, 127, null);
    }

    public final void l(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.w(c.f54829a, LiveProtos.Event.IN_LIVE_ROOM_SHOW, null, str, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2097166, 127, null);
    }

    public final void m(int i10) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_ACTIVITY_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(i10), null, null, null, null, null, null, -2, 126, null);
    }

    public final void n(@NotNull List<String> selectList) {
        s.i(selectList, "selectList");
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_ACTIVITY_SAVE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (String) CollectionsKt___CollectionsKt.V(selectList), selectList.size() <= 1 ? null : selectList.get(1), null, null, null, null, null, null, null, 1073741822, 127, null);
    }

    public final void o() {
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_OPEN_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 127, null);
    }

    public final void p(@Nullable String str) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_OPEN_MENU_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388610, 127, null);
    }

    public final void q(@NotNull String roomId, @Nullable String str, @NotNull String pushStatus) {
        s.i(roomId, "roomId");
        s.i(pushStatus, "pushStatus");
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_START_SUCCESS, null, roomId, null, null, null, str, null, null, null, null, null, null, null, null, null, pushStatus, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65606, 127, null);
    }

    public final void r() {
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_TOTAL_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 127, null);
    }

    public final void s(@Nullable String str) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_PAGE_TOTAL_MENU_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388610, 127, null);
    }

    public final void t(@Nullable String str, @Nullable String str2, @Nullable Integer num) {
        PropsType propsType = PropsType.DiscountCard;
        int value = propsType.getValue();
        if (num == null || num.intValue() != value) {
            propsType = PropsType.BarrageCard;
            int value2 = propsType.getValue();
            if (num == null || num.intValue() != value2) {
                propsType = PropsType.HornCard;
                int value3 = propsType.getValue();
                if (num == null || num.intValue() != value3) {
                    propsType = PropsType.NobleExperienceCard;
                    int value4 = propsType.getValue();
                    if (num == null || num.intValue() != value4) {
                        propsType = null;
                    }
                }
            }
        }
        c.w(c.f54829a, LiveProtos.Event.LIVE_PROP_USE_CLICK, null, str, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, propsType != null ? propsType.getPropName() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388622, 127, null);
    }

    public final void u(@Nullable String str, @Nullable String str2, @NotNull LiveProtos.Type type, @Nullable String str3, @Nullable String str4) {
        s.i(type, "type");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_BTN_CLICK, type, str, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str4, -131088, 63, null);
    }

    public final void v(@NotNull String roomId, @NotNull String anchorId, int i10, int i11, int i12) {
        s.i(roomId, "roomId");
        s.i(anchorId, "anchorId");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_CLOSE, null, roomId, anchorId, Integer.valueOf(i11), null, null, null, Integer.valueOf(i10), null, null, null, null, Integer.valueOf(i12), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8478, 127, null);
    }

    public final void w(@NotNull String roomId, @Nullable String str, @NotNull LiveProtos.Type type, @NotNull String commentContent, @Nullable String str2) {
        s.i(roomId, "roomId");
        s.i(type, "type");
        s.i(commentContent, "commentContent");
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_COMMENT_SUCCESS, type, roomId, str, null, null, null, null, null, null, commentContent, null, null, null, null, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -66576, 127, null);
    }

    public final void x(@Nullable String str, @Nullable String str2, int i10, @Nullable String str3) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_CONNECT_END, null, str, str2, null, null, null, null, Integer.valueOf(i10), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777486, 127, null);
    }

    public final void y(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_CONNECT_LAUNCH, null, str, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777230, 127, null);
    }

    public final void z(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.w(c.f54829a, LiveProtos.Event.LIVE_ROOM_CONNECT_SUCCESS, null, str, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777230, 127, null);
    }
}
