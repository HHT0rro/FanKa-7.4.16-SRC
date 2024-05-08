package com.cupidapp.live.track.group;

import com.cupidapp.live.base.network.model.TaskBtnStatus;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.ShareContent;
import com.cupidapp.live.feed.FeedSort;
import com.irisdt.client.others.OthersProtos;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z3.c;

/* compiled from: GroupOthersLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GroupOthersLog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GroupOthersLog f18702a = new GroupOthersLog();

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum EmptyPlaceHolderName {
        DAILY_HEART_EMPTY("DAILY_HEART_EMPTY"),
        DAILY_HEART_ERROR("DAILY_HEART_ERROR");


        @NotNull
        private final String value;

        EmptyPlaceHolderName(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GuideName {
        NEARBY_AE
    }

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum GuideType {
        ANM_GUIDE,
        NEW_USER_ANM,
        HE_LIKES_YOU,
        DELETE_VISIT_RECORD,
        REMAIN_TIPS,
        GUIDE_BUBBLE,
        GUIDE_BUBBLE_REMAIN_TIPS,
        SUPER_BOOST_AE,
        UPLOAD_AVATAR_NO_FAKE,
        CLICK_TO_UPLOAD_AVATAR,
        NO_CLEAR_FACE,
        WHY_GET_FAKE_LIKE,
        SPEED_CARD,
        NEW_USER_ANM_AE,
        CHANNEL_FIRST_BUY_GUIDE
    }

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ItemCardEntrance {
        PROP_CARD("PROP_CARD"),
        MATCH_PROP_CARD("MATCH_PROP_CARD");


        @NotNull
        private final String entrance;

        ItemCardEntrance(String str) {
            this.entrance = str;
        }

        @NotNull
        public final String getEntrance() {
            return this.entrance;
        }
    }

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum SwitchStatusName {
        WANT_CHAT,
        DO_NOT_WANT_CHAT,
        UNKNOWN
    }

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum TipsType {
        MSG_PAGE_OPEN_PUSH,
        SPECIAL_ATTENTION,
        CHAT_OPEN_SPECIAL_ATTENTION_PUSH,
        PUSH_HAS_PROBLEM,
        CLOSE_FRIENDS
    }

    /* compiled from: GroupOthersLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18703a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18704b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f18705c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f18706d;

        static {
            int[] iArr = new int[ShareContent.values().length];
            try {
                iArr[ShareContent.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShareContent.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShareContent.PHOTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18703a = iArr;
            int[] iArr2 = new int[FeedSort.values().length];
            try {
                iArr2[FeedSort.Time.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FeedSort.Intimacy.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FeedSort.CloseFriend.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FeedSort.Focus.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f18704b = iArr2;
            int[] iArr3 = new int[GuideType.values().length];
            try {
                iArr3[GuideType.ANM_GUIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[GuideType.NEW_USER_ANM.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[GuideType.HE_LIKES_YOU.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[GuideType.DELETE_VISIT_RECORD.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[GuideType.REMAIN_TIPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[GuideType.GUIDE_BUBBLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[GuideType.GUIDE_BUBBLE_REMAIN_TIPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[GuideType.SUPER_BOOST_AE.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[GuideType.UPLOAD_AVATAR_NO_FAKE.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[GuideType.CLICK_TO_UPLOAD_AVATAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[GuideType.NO_CLEAR_FACE.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr3[GuideType.WHY_GET_FAKE_LIKE.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[GuideType.SPEED_CARD.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[GuideType.NEW_USER_ANM_AE.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr3[GuideType.CHANNEL_FIRST_BUY_GUIDE.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
            f18705c = iArr3;
            int[] iArr4 = new int[TipsType.values().length];
            try {
                iArr4[TipsType.MSG_PAGE_OPEN_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr4[TipsType.SPECIAL_ATTENTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr4[TipsType.CHAT_OPEN_SPECIAL_ATTENTION_PUSH.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr4[TipsType.PUSH_HAS_PROBLEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr4[TipsType.CLOSE_FRIENDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused27) {
            }
            f18706d = iArr4;
        }
    }

    public static /* synthetic */ void H(GroupOthersLog groupOthersLog, GuideType guideType, SensorPosition sensorPosition, SensorScene sensorScene, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sensorScene = null;
        }
        groupOthersLog.F(guideType, sensorPosition, sensorScene);
    }

    public static /* synthetic */ void I(GroupOthersLog groupOthersLog, String str, SensorPosition sensorPosition, String str2, SensorScene sensorScene, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            sensorScene = null;
        }
        groupOthersLog.G(str, sensorPosition, str2, sensorScene);
    }

    public static /* synthetic */ void L(GroupOthersLog groupOthersLog, SensorPosition sensorPosition, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        groupOthersLog.J(sensorPosition, str, str2);
    }

    public static /* synthetic */ void M(GroupOthersLog groupOthersLog, GuideType guideType, SensorPosition sensorPosition, SensorScene sensorScene, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sensorScene = null;
        }
        if ((i10 & 8) != 0) {
            str = null;
        }
        groupOthersLog.K(guideType, sensorPosition, sensorScene, str);
    }

    public static /* synthetic */ void W(GroupOthersLog groupOthersLog, SensorPosition sensorPosition, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        groupOthersLog.V(sensorPosition, str);
    }

    public static /* synthetic */ void Y(GroupOthersLog groupOthersLog, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        groupOthersLog.X(str, str2, str3, str4);
    }

    public static /* synthetic */ void a0(GroupOthersLog groupOthersLog, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        groupOthersLog.Z(str, str2, str3);
    }

    public static /* synthetic */ void d(GroupOthersLog groupOthersLog, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        groupOthersLog.c(str, str2, str3);
    }

    public static /* synthetic */ void j(GroupOthersLog groupOthersLog, String str, SensorPosition sensorPosition, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        groupOthersLog.i(str, sensorPosition, num);
    }

    public static /* synthetic */ void l(GroupOthersLog groupOthersLog, SensorPosition sensorPosition, String str, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        groupOthersLog.k(sensorPosition, str, num);
    }

    public static /* synthetic */ void l0(GroupOthersLog groupOthersLog, AppSetting appSetting, boolean z10, SensorPosition sensorPosition, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sensorPosition = null;
        }
        if ((i10 & 8) != 0) {
            str = null;
        }
        groupOthersLog.k0(appSetting, z10, sensorPosition, str);
    }

    public static /* synthetic */ void p(GroupOthersLog groupOthersLog, OthersProtos.Enum_type enum_type, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        groupOthersLog.o(enum_type, str, str2);
    }

    public static /* synthetic */ void p0(GroupOthersLog groupOthersLog, TipsType tipsType, FeedSort feedSort, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            feedSort = null;
        }
        groupOthersLog.o0(tipsType, feedSort);
    }

    public static /* synthetic */ void r(GroupOthersLog groupOthersLog, OthersProtos.Enum_type enum_type, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        groupOthersLog.q(enum_type, str);
    }

    public final void A(@Nullable String str, @Nullable String str2) {
        c.A(c.f54829a, OthersProtos.Event.FLIP_CARD_CLICK, null, null, str2, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -74, 2047, null);
    }

    @NotNull
    public final OthersProtos.Enum_type B(@NotNull GuideType type) {
        s.i(type, "type");
        switch (a.f18705c[type.ordinal()]) {
            case 1:
                return OthersProtos.Enum_type.ANM_GUIDE;
            case 2:
                return OthersProtos.Enum_type.NEW_USER_ANM;
            case 3:
                return OthersProtos.Enum_type.HE_LIKES_YOU;
            case 4:
                return OthersProtos.Enum_type.DELETE_VISIT_RECORD;
            case 5:
                return OthersProtos.Enum_type.REMAIN_TIPS;
            case 6:
                return OthersProtos.Enum_type.GUIDE_BUBBLE;
            case 7:
                return OthersProtos.Enum_type.GUIDE_BUBBLE_REMAIN_TIPS;
            case 8:
                return OthersProtos.Enum_type.SUPER_BOOST_AE;
            case 9:
                return OthersProtos.Enum_type.UPLOAD_AVATAR_NO_FAKE;
            case 10:
                return OthersProtos.Enum_type.CLICK_TO_UPLOAD_AVATAR;
            case 11:
                return OthersProtos.Enum_type.NO_CLEAR_FACE;
            case 12:
                return OthersProtos.Enum_type.WHY_GET_FAKE_LIKE;
            case 13:
                return OthersProtos.Enum_type.SPEED_CARD;
            case 14:
                return OthersProtos.Enum_type.NEW_USER_ANM_AE;
            case 15:
                return OthersProtos.Enum_type.CHANNEL_FIRST_BUY_GUIDE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final OthersProtos.SortType C(FeedSort feedSort) {
        int i10 = feedSort == null ? -1 : a.f18704b[feedSort.ordinal()];
        if (i10 == 1) {
            return OthersProtos.SortType.TIME;
        }
        if (i10 == 2) {
            return OthersProtos.SortType.FOLLOW;
        }
        if (i10 == 3) {
            return OthersProtos.SortType.CLOSE_FRIENDS;
        }
        if (i10 != 4) {
            return OthersProtos.SortType.UNKNOWN_SORT_TYPE;
        }
        return OthersProtos.SortType.SPECIAL_ATTENTION;
    }

    public final OthersProtos.Enum_type D(TipsType tipsType) {
        int i10 = a.f18706d[tipsType.ordinal()];
        if (i10 == 1) {
            return OthersProtos.Enum_type.MSG_PAGE_OPEN_PUSH;
        }
        if (i10 == 2) {
            return OthersProtos.Enum_type.MANAGE_SPECIAL_ATTENTION;
        }
        if (i10 == 3) {
            return OthersProtos.Enum_type.CHAT_OPEN_SPECIAL_ATTENTION_PUSH;
        }
        if (i10 == 4) {
            return OthersProtos.Enum_type.PUSH_HAS_PROBLEM;
        }
        if (i10 == 5) {
            return OthersProtos.Enum_type.MANAGE_CLOSE_FRIENDS;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void E(int i10, int i11, int i12) {
        c.A(c.f54829a, OthersProtos.Event.GOODS_IN_STOCK, null, null, "SUPER_EXPOSURE", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -7340042, 2047, null);
    }

    public final void F(@NotNull GuideType type, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene) {
        s.i(type, "type");
        c cVar = c.f54829a;
        OthersProtos.Event event = OthersProtos.Event.GUIDE_CLICK;
        OthersProtos.Enum_type B = B(type);
        c.A(cVar, event, null, null, null, null, sensorScene != null ? sensorScene.getValue() : null, null, null, null, null, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, B, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16793634, 2047, null);
    }

    public final void G(@Nullable String str, @Nullable SensorPosition sensorPosition, @Nullable String str2, @Nullable SensorScene sensorScene) {
        c.A(c.f54829a, OthersProtos.Event.GUIDE_CLICK, null, null, null, str2, sensorScene != null ? sensorScene.getValue() : null, null, null, null, str, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16946, 2047, null);
    }

    public final void J(@Nullable SensorPosition sensorPosition, @Nullable String str, @Nullable String str2) {
        c.A(c.f54829a, OthersProtos.Event.GUIDE_SHOW, null, null, null, str2, null, null, null, null, str, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16914, 2047, null);
    }

    public final void K(@NotNull GuideType type, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene, @Nullable String str) {
        s.i(type, "type");
        c cVar = c.f54829a;
        OthersProtos.Event event = OthersProtos.Event.GUIDE_SHOW;
        OthersProtos.Enum_type B = B(type);
        c.A(cVar, event, null, null, null, str, sensorScene != null ? sensorScene.getValue() : null, null, null, null, null, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, B, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16793650, 2047, null);
    }

    public final void N(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.A(c.f54829a, OthersProtos.Event.INBOX_MSG_CLICK, str3, null, str, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -28, 2047, null);
    }

    public final void O(@NotNull String type, @Nullable Double d10, @Nullable Double d11, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.LOCATION_SUCCESS, null, null, type, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "lon:" + ((Object) d10) + ",lat:" + ((Object) d11), num, str2, str3, str4, str5, str6, str7, null, -26, 1027, null);
    }

    public final void Q(@NotNull String pageName, @NotNull String btnName) {
        s.i(pageName, "pageName");
        s.i(btnName, "btnName");
        c.A(c.f54829a, OthersProtos.Event.MAIN_BTN_CLICK, null, null, null, null, null, null, null, null, btnName, null, null, null, null, pageName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16898, 2047, null);
    }

    public final void R(@NotNull String pageName, @NotNull String btnName) {
        s.i(pageName, "pageName");
        s.i(btnName, "btnName");
        c.A(c.f54829a, OthersProtos.Event.MAIN_BTN_SHOW, null, null, null, null, null, null, null, null, btnName, null, null, null, null, pageName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16898, 2047, null);
    }

    public final void S(@Nullable String str) {
        c.A(c.f54829a, OthersProtos.Event.NOTICE_CENTER_FOLLOW_PAGE_NOTICE_SHOW, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -18, 2047, null);
    }

    public final void T(@Nullable SensorPosition sensorPosition, @Nullable Boolean bool) {
        c.A(c.f54829a, OthersProtos.Event.PAGE_LOAD_COMPLETE, null, null, null, null, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, bool, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33282, 2047, null);
    }

    public final void U(@Nullable SensorPosition sensorPosition, @NotNull OthersProtos.Enum_type mediaType, @Nullable String str) {
        s.i(mediaType, "mediaType");
        c.A(c.f54829a, OthersProtos.Event.PICK_SHOW_PICTURE, null, null, null, null, null, null, null, null, str, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, mediaType, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16794114, 2047, null);
    }

    public final void V(@NotNull SensorPosition position, @Nullable String str) {
        s.i(position, "position");
        c.A(c.f54829a, OthersProtos.Event.PLACE_HOLDER_PAGE_SHOW, null, null, null, null, null, null, null, null, str, null, null, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16898, 2047, null);
    }

    public final void X(@NotNull String popupName, @Nullable String str, @NotNull String btnName, @Nullable String str2) {
        s.i(popupName, "popupName");
        s.i(btnName, "btnName");
        c.A(c.f54829a, OthersProtos.Event.POPUP_BTN_CLICK, null, null, null, btnName, null, null, null, null, popupName, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str2, -16914, 1023, null);
    }

    public final void Z(@NotNull String popupName, @Nullable String str, @Nullable String str2) {
        s.i(popupName, "popupName");
        c.A(c.f54829a, OthersProtos.Event.POPUP_SHOW, null, null, null, null, null, null, null, null, popupName, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str2, -16898, 1023, null);
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.A(c.f54829a, OthersProtos.Event.ACTIVITY_ENTRANCE_CLICK, str2, null, str3, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16396, 2047, null);
    }

    public final void b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        c.A(c.f54829a, OthersProtos.Event.ACTIVITY_ENTRANCE_SHOW, str2, null, str3, null, null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16396, 2047, null);
    }

    public final void b0(@Nullable String str) {
        c.A(c.f54829a, OthersProtos.Event.SEARCH_KEYWORD_CLICK, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -18, 2047, null);
    }

    public final void c(@NotNull String position, @Nullable String str, @Nullable String str2) {
        s.i(position, "position");
        c.A(c.f54829a, OthersProtos.Event.APP_BROWSE_PAGE, null, null, null, null, null, null, null, null, str, null, null, null, null, position, null, null, null, null, null, null, null, null, null, null, null, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -134234626, 2047, null);
    }

    public final void c0(@NotNull SensorPosition position, @Nullable String str) {
        s.i(position, "position");
        c.A(c.f54829a, OthersProtos.Event.SEARCH_RECORD, null, null, null, str, null, null, null, null, null, null, null, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16402, 2047, null);
    }

    public final void d0(int i10, @NotNull OthersProtos.Enum_type photoType, @NotNull SensorPosition position, @Nullable String str) {
        s.i(photoType, "photoType");
        s.i(position, "position");
        c.A(c.f54829a, OthersProtos.Event.SELECT_PHOTOS, null, null, null, null, null, null, null, null, str, null, null, null, null, position.getValue(), null, null, null, null, null, Integer.valueOf(i10), null, null, null, photoType, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -17842690, 2047, null);
    }

    public final void e(@Nullable SensorPosition sensorPosition, int i10) {
        c.A(c.f54829a, OthersProtos.Event.APP_BROWSE_PAGE_TIME, null, null, null, null, null, null, null, null, null, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, Integer.valueOf(i10), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1064962, 2047, null);
    }

    public final void e0(@NotNull String position, @Nullable String str, @Nullable ShareContent shareContent, @Nullable String str2, @Nullable String str3) {
        s.i(position, "position");
        f0(OthersProtos.Event.SHARE_BTN_CLICK, position, null, str, shareContent, str2, str3, null);
    }

    public final void f(@NotNull String name, @Nullable String str, @NotNull String type) {
        s.i(name, "name");
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.APP_SCORE_POPUP_CLICK, null, null, type, null, null, null, null, null, name, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -262666, 2047, null);
    }

    public final void f0(OthersProtos.Event event, String str, String str2, String str3, ShareContent shareContent, String str4, String str5, String str6) {
        String str7;
        String str8;
        String str9;
        String str10;
        int i10 = shareContent == null ? -1 : a.f18703a[shareContent.ordinal()];
        if (i10 == 1) {
            str7 = str3;
            str8 = str4;
            str9 = null;
            str10 = null;
        } else if (i10 == 2 || i10 == 3) {
            str10 = str4;
            str9 = null;
            str8 = null;
            str7 = null;
        } else {
            str9 = str4;
            str8 = null;
            str7 = null;
            str10 = null;
        }
        c.A(c.f54829a, event, str6, null, shareContent != null ? shareContent.name() : null, null, null, str9, str2, null, str5, str3, str8, str7, str10, str, null, null, null, null, null, null, null, null, null, null, null, C(g.f52734a.x()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -67141324, 2047, null);
    }

    public final void g(@NotNull String mode, @NotNull String type) {
        s.i(mode, "mode");
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.APP_SCORE_POPUP_SHOW, null, null, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, mode, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -262154, 2047, null);
    }

    public final void g0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ShareContent shareContent, @Nullable String str4) {
        f0(OthersProtos.Event.SHARE_SUCCESS, str, str2, str3, shareContent, str4, null, null);
    }

    public final void h(@NotNull String screenName, @Nullable String str, @NotNull String screenShotType, @Nullable String str2) {
        s.i(screenName, "screenName");
        s.i(screenShotType, "screenShotType");
        c.A(c.f54829a, OthersProtos.Event.APP_SCREENSHOT, null, null, screenShotType, str, null, null, null, null, screenName, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1562, 2047, null);
    }

    public final void h0(@NotNull SensorPosition position, @NotNull SpreadItemName name, @NotNull ActionName actionName) {
        s.i(position, "position");
        s.i(name, "name");
        s.i(actionName, "actionName");
        c cVar = c.f54829a;
        OthersProtos.Event event = OthersProtos.Event.SPREAD_ITEM_CLICK;
        String value = position.getValue();
        c.A(cVar, event, null, null, null, actionName.name(), null, null, null, null, name.name(), null, null, null, null, value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16914, 2047, null);
    }

    public final void i(@Nullable String str, @NotNull SensorPosition position, @Nullable Integer num) {
        s.i(position, "position");
        if (str == null) {
            return;
        }
        c.A(c.f54829a, OthersProtos.Event.BANNER_CLICK, null, null, null, null, null, str, null, null, null, null, null, null, null, position.getValue(), null, null, null, null, null, num, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1065026, 2047, null);
    }

    public final void i0(@NotNull SensorPosition position, @NotNull SpreadItemName name) {
        s.i(position, "position");
        s.i(name, "name");
        c.A(c.f54829a, OthersProtos.Event.SPREAD_ITEM_SHOW, null, null, null, null, null, null, null, null, name.name(), null, null, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16898, 2047, null);
    }

    public final void j0(@NotNull SpreadPositionType name, @NotNull SensorPosition position) {
        s.i(name, "name");
        s.i(position, "position");
        c.A(c.f54829a, OthersProtos.Event.SPREAD_POSITION_SHOW, null, null, null, null, null, null, null, null, name.name(), null, null, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16898, 2047, null);
    }

    public final void k(@NotNull SensorPosition position, @Nullable String str, @Nullable Integer num) {
        s.i(position, "position");
        c.A(c.f54829a, OthersProtos.Event.BANNER_SHOW, null, null, null, null, null, str, null, null, null, null, null, null, null, position.getValue(), null, null, null, null, null, num, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1065026, 2047, null);
    }

    public final void k0(@NotNull AppSetting switchName, boolean z10, @Nullable SensorPosition sensorPosition, @Nullable String str) {
        s.i(switchName, "switchName");
        c.A(c.f54829a, OthersProtos.Event.SWITCH_STATUS, null, null, null, null, null, null, null, null, switchName.name(), str, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, Boolean.valueOf(z10), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -50690, 2047, null);
    }

    public final void m(@Nullable String str, @Nullable String str2) {
        c.A(c.f54829a, OthersProtos.Event.BEHAVIOR_REMINDER_POPUP_BTN_CLICK, null, null, str2, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -26, 2047, null);
    }

    public final void m0(@NotNull String name, boolean z10, @Nullable Boolean bool, @Nullable Boolean bool2) {
        s.i(name, "name");
        c.A(c.f54829a, OthersProtos.Event.SYSTEM_PERMISSIONS_SWITCH_STATUS_CHANGE, null, null, null, null, null, null, null, null, name, null, null, null, null, null, Boolean.valueOf(z10), bool, bool2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -229890, 2047, null);
    }

    public final void n(@Nullable String str, @Nullable String str2) {
        c.A(c.f54829a, OthersProtos.Event.BEHAVIOR_REMINDER_POPUP_SHOW, null, null, str2, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -26, 2047, null);
    }

    public final void n0(@Nullable Integer num, int i10) {
        ActionName actionName;
        if (i10 == TaskBtnStatus.UnDone.getValue()) {
            actionName = ActionName.DO_TASK;
        } else {
            actionName = i10 == TaskBtnStatus.ReWard.getValue() ? ActionName.GET_REWARD : null;
        }
        c.A(c.f54829a, OthersProtos.Event.TASK_BTN_CLICK, null, null, null, null, null, null, null, null, actionName != null ? actionName.name() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, num, null, null, null, null, null, null, null, null, null, null, null, null, null, -536871426, 2047, null);
    }

    public final void o(@NotNull OthersProtos.Enum_type type, @Nullable String str, @Nullable String str2) {
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.BUBBLE_CLICK, null, null, null, str2, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777298, 2047, null);
    }

    public final void o0(@NotNull TipsType type, @Nullable FeedSort feedSort) {
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.TIPS_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, D(type), null, C(feedSort), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -83886082, 2047, null);
    }

    public final void q(@NotNull OthersProtos.Enum_type type, @Nullable String str) {
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.BUBBLE_SHOW, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16777282, 2047, null);
    }

    public final void q0(@NotNull TipsType type, @Nullable FeedSort feedSort) {
        s.i(type, "type");
        c.A(c.f54829a, OthersProtos.Event.TIPS_SHOW, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, D(type), null, C(feedSort), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -83886082, 2047, null);
    }

    public final void r0(@NotNull String reason, @Nullable String str) {
        s.i(reason, "reason");
        c.A(c.f54829a, OthersProtos.Event.TURN_OVER_FAIL_MSG, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, reason, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -524306, 2047, null);
    }

    public final void s(@NotNull String position, @Nullable String str, @Nullable String str2, @Nullable ShareContent shareContent, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        s.i(position, "position");
        f0(OthersProtos.Event.CHOICE_SHARE_WAY, position, str, str2, shareContent, str3, str4, str5);
    }

    public final void s0() {
        c.A(c.f54829a, OthersProtos.Event.FACE_IDENTIFY_USE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 2047, null);
    }

    public final void t(int i10) {
        c.A(c.f54829a, OthersProtos.Event.CHOOSE_VIDEO_PORTRAIT, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(i10), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8388610, 2047, null);
    }

    public final void t0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        c.A(c.f54829a, OthersProtos.Event.WAKE_UP_APP_BUY_LINK, str3, null, "CLIENT", str2, null, null, null, null, str4, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -134219292, 2047, null);
    }

    public final void u(@Nullable String str, @NotNull String stage, @Nullable String str2, @Nullable String str3, @Nullable Long l10) {
        s.i(stage, "stage");
        c.A(c.f54829a, OthersProtos.Event.CLIENT_PAGE_LOAD, str, str2, null, str3, null, null, null, stage, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, l10, null, null, null, null, null, null, null, null, null, null, null, null, -1073742104, 2047, null);
    }

    public final void v(@NotNull SensorPosition position, @NotNull ItemCardEntrance entrance) {
        s.i(position, "position");
        s.i(entrance, "entrance");
        c.A(c.f54829a, OthersProtos.Event.COMMON_ENTRANCE_CLICK, null, null, null, entrance.getEntrance(), null, null, null, null, null, null, null, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16402, 2047, null);
    }

    public final void w(@NotNull String content) {
        s.i(content, "content");
        c.A(c.f54829a, OthersProtos.Event.EDIT_ICON_PROFILE, null, null, null, content, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -18, 2047, null);
    }

    public final void x(@NotNull String name, @NotNull String sensorPosition) {
        s.i(name, "name");
        s.i(sensorPosition, "sensorPosition");
        c.A(c.f54829a, OthersProtos.Event.EDIT_PROFILE, null, null, null, null, null, null, null, null, name, null, null, null, null, sensorPosition, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -16898, 2047, null);
    }

    public final void y(@NotNull String endRecordPageName, @Nullable String str, @Nullable String str2, int i10) {
        s.i(endRecordPageName, "endRecordPageName");
        c.A(c.f54829a, OthersProtos.Event.END_RECORD_SCREEN, null, null, str, null, null, UUID.randomUUID().toString(), null, null, endRecordPageName, str2, null, null, null, null, null, null, null, null, null, Integer.valueOf(i10), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1050186, 2047, null);
    }

    public final void z(boolean z10, @Nullable String str) {
        c.A(c.f54829a, OthersProtos.Event.PAGE_LOAD_COMPLETE, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z10), null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -557058, 2047, null);
    }
}
