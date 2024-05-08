package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.advertisement.AdvertisementProtos;
import com.irisdt.client.others.OthersProtos;
import com.irisdt.client.post.PostAndSocialProtos;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.q;
import z3.c;

/* compiled from: SensorsLogFeed.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogFeed {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogFeed f12208a = new SensorsLogFeed();

    /* compiled from: SensorsLogFeed.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum BtnName {
        STICKER("贴纸"),
        SAVE("保存"),
        ABANDON("不用了"),
        CUT("裁剪"),
        COMMENT_BTN("点击评论按钮"),
        DESCRIBE("点击描述文案"),
        COMMENT("点击评论文案"),
        TIME_LIMIT("TIME_LIMIT_FEED");


        @NotNull
        private final String value;

        BtnName(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: SensorsLogFeed.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LikeCommentType {
        Feed("动态"),
        FirstLevelComment("一级评论"),
        SecondLevelComment("二级评论");


        @NotNull
        private final String type;

        LikeCommentType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: SensorsLogFeed.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum UploadFileType {
        FEED,
        CHAT_PHOTO,
        AVATAR,
        WEB,
        BURN_AFTER_READING,
        LIVE_SHOW_COVER,
        CONSULT_COVER
    }

    /* compiled from: SensorsLogFeed.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12209a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12210b;

        static {
            int[] iArr = new int[FeedSort.values().length];
            try {
                iArr[FeedSort.Time.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeedSort.Intimacy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeedSort.CloseFriend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FeedSort.Focus.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f12209a = iArr;
            int[] iArr2 = new int[BtnName.values().length];
            try {
                iArr2[BtnName.ABANDON.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BtnName.SAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BtnName.STICKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BtnName.CUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BtnName.COMMENT_BTN.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[BtnName.COMMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[BtnName.DESCRIBE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            f12210b = iArr2;
        }
    }

    public final void A(@Nullable SensorScene sensorScene, @NotNull SensorPosition sensorPosition, @Nullable String str) {
        s.i(sensorPosition, "sensorPosition");
        c.C(c.f54829a, PostAndSocialProtos.Event.PUBLISH_BTN_CLICK, str, null, null, null, null, null, null, sensorScene != null ? sensorScene.getValue() : null, sensorPosition.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -772, -1, 31, null);
    }

    public final void B(@Nullable SensorPosition sensorPosition, @Nullable SensorPosition sensorPosition2, @Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool4) {
        c.C(c.f54829a, PostAndSocialProtos.Event.SEND_INBOX_MESSAGE, null, sensorPosition2 != null ? sensorPosition2.getValue() : null, str3, null, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, bool, bool3, null, null, null, null, null, null, null, null, null, null, null, str, false, null, str4, null, null, null, null, bool2, null, null, null, null, null, null, str2, null, null, null, null, null, null, null, null, null, null, null, bool4, null, null, null, -100663822, -2114113, 29, null);
    }

    public final void D(@Nullable String str, @Nullable String str2, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable FeedSort feedSort, @Nullable String str5, int i10, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str6) {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_DRAW, str5, null, str, bool, str3, null, str2, sensorScene != null ? sensorScene.getValue() : null, sensorPosition != null ? sensorPosition.getValue() : null, null, Integer.valueOf(i10), str4, l(feedSort), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, str6, null, null, bool2, bool3, null, null, null, null, null, null, null, -15292, -838860801, 31, null);
    }

    public final void F(@Nullable String str, @NotNull String postId) {
        s.i(postId, "postId");
        if (str == null) {
            return;
        }
        c.q(c.f54829a, AdvertisementProtos.Event.SPONSOR_POST_CLICK, null, null, null, null, null, null, str, postId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741438, null);
    }

    public final void G(@Nullable String str, @NotNull String postId) {
        s.i(postId, "postId");
        c.q(c.f54829a, AdvertisementProtos.Event.SPONSOR_POST_SHOW, null, null, null, null, null, null, str, postId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741438, null);
    }

    public final void H(@Nullable BtnName btnName, @Nullable String str, @Nullable String str2) {
        PostAndSocialProtos.Type type;
        int i10 = btnName == null ? -1 : a.f12210b[btnName.ordinal()];
        if (i10 == 1) {
            type = PostAndSocialProtos.Type.ABANDON;
        } else if (i10 == 2) {
            type = PostAndSocialProtos.Type.SAVE;
        } else if (i10 == 3) {
            type = PostAndSocialProtos.Type.STICKER;
        } else if (i10 != 4) {
            type = PostAndSocialProtos.Type.UNKNOWN_TYPE;
        } else {
            type = PostAndSocialProtos.Type.CUT;
        }
        c.C(c.f54829a, PostAndSocialProtos.Event.STICKER_ACT_BTN_CLICK, str, null, null, null, null, null, null, null, null, null, null, str2, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -12292, -1, 31, null);
    }

    public final void I(@NotNull FeedSort feedSort) {
        s.i(feedSort, "feedSort");
        c.C(c.f54829a, PostAndSocialProtos.Event.SWITCH_POST_SORT_MODE, null, null, null, null, null, null, null, null, null, null, null, null, l(feedSort), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8194, -1, 31, null);
    }

    public final void J(@Nullable SensorPosition sensorPosition, boolean z10, boolean z11, boolean z12, @Nullable String str, @Nullable String str2) {
        c.C(c.f54829a, PostAndSocialProtos.Event.TIME_LIMIT_FEED_PUBLISH, null, null, null, null, null, null, str2, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12), str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -642, -3932161, 31, null);
    }

    public final void K(@NotNull SensorScene scene) {
        s.i(scene, "scene");
        c.C(c.f54829a, PostAndSocialProtos.Event.TOPIC_ENTRANCE_CLICK, null, null, null, null, null, null, null, scene.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -258, -1, 31, null);
    }

    public final void L(@NotNull SensorPosition sensorPosition, @Nullable String str, @Nullable String str2) {
        s.i(sensorPosition, "sensorPosition");
        c.C(c.f54829a, PostAndSocialProtos.Event.TOPIC_PAGE_BTN_CLICK, null, null, null, null, str, null, null, null, sensorPosition.getValue(), null, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4642, -1, 31, null);
    }

    public final void M(@Nullable SensorScene sensorScene, @NotNull SensorPosition sensorPosition, @Nullable SensorPosition sensorPosition2, @Nullable String str, @Nullable String str2) {
        s.i(sensorPosition, "sensorPosition");
        c.C(c.f54829a, PostAndSocialProtos.Event.TOPIC_PAGE_SHOW, str2, sensorPosition2 != null ? sensorPosition2.getValue() : null, null, null, null, null, null, sensorScene != null ? sensorScene.getValue() : null, sensorPosition.getValue(), null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4872, -1, 31, null);
    }

    public final void O(long j10, long j11, int i10, int i11, @NotNull UploadFileType uploadType, @NotNull String fileType, @Nullable SensorPosition sensorPosition, boolean z10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        OthersProtos.Enum_type enum_type;
        s.i(uploadType, "uploadType");
        s.i(fileType, "fileType");
        if (s.d(fileType, "图片")) {
            enum_type = OthersProtos.Enum_type.PICTURE;
        } else {
            enum_type = s.d(fileType, "视频") ? OthersProtos.Enum_type.VIDEO : OthersProtos.Enum_type.UNKNOWN_ENUM_TYPE;
        }
        OthersProtos.Enum_type enum_type2 = enum_type;
        c.A(c.f54829a, OthersProtos.Event.UPLOAD_FILES, null, null, uploadType.name(), null, null, str2, null, null, str3, null, null, null, null, sensorPosition != null ? sensorPosition.getValue() : null, Boolean.valueOf(z10), null, null, null, str, Integer.valueOf((int) j11), null, null, null, enum_type2, null, null, null, str4, null, Long.valueOf(j10), null, Integer.valueOf(i10), Integer.valueOf(i11), null, null, null, null, null, null, null, null, null, -1360577098, 2044, null);
    }

    public final void a(@Nullable String str, @Nullable SensorPosition sensorPosition) {
        c.C(c.f54829a, PostAndSocialProtos.Event.CANCEL_POST_TOP, null, null, null, null, null, null, str, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -642, -1, 31, null);
    }

    public final void b(@Nullable String str, @Nullable String str2, @NotNull SensorPosition position, boolean z10) {
        s.i(position, "position");
        GroupSocialLog.f18708a.d(str, str2, position, Boolean.valueOf(z10));
    }

    public final void c(@NotNull String authorId, @NotNull String feedId, @Nullable SensorScene sensorScene, @Nullable SensorPosition sensorPosition, @Nullable String str, boolean z10, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable FeedSort feedSort) {
        s.i(authorId, "authorId");
        s.i(feedId, "feedId");
        c cVar = c.f54829a;
        PostAndSocialProtos.Event event = PostAndSocialProtos.Event.POST_COMMENT;
        String value = sensorScene != null ? sensorScene.getValue() : null;
        String value2 = sensorPosition != null ? sensorPosition.getValue() : null;
        c.C(cVar, event, null, null, authorId, Boolean.valueOf(z10), str, null, feedId, value, value2, null, null, str2, l(feedSort), null, null, null, null, null, null, null, null, str3, str4, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -12596154, -1, 31, null);
    }

    public final void d(@NotNull PostAndSocialProtos.Type type, @Nullable String str) {
        s.i(type, "type");
        c.C(c.f54829a, PostAndSocialProtos.Event.CONTENT_EDIT_PAGE_BTN_CLICK, str, null, null, null, null, null, null, null, null, null, null, null, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8196, -1, 31, null);
    }

    public final void e(@Nullable String str, @Nullable String str2, boolean z10, boolean z11, @Nullable FrameAspectRatio frameAspectRatio) {
        FrameAspectRatio frameAspectRatio2;
        if (frameAspectRatio != null) {
            float c4 = q.c(frameAspectRatio.getRatio());
            FrameAspectRatio[] values = FrameAspectRatio.values();
            ArrayList<FrameAspectRatio> arrayList = new ArrayList();
            int length = values.length;
            for (int i10 = 0; i10 < length; i10++) {
                FrameAspectRatio frameAspectRatio3 = values[i10];
                if (frameAspectRatio3 != FrameAspectRatio.DEFAULT) {
                    arrayList.add(frameAspectRatio3);
                }
            }
            frameAspectRatio2 = frameAspectRatio;
            for (FrameAspectRatio frameAspectRatio4 : arrayList) {
                if (q.c(frameAspectRatio4.getRatio()) == c4) {
                    frameAspectRatio2 = frameAspectRatio4;
                }
            }
        } else {
            frameAspectRatio2 = frameAspectRatio;
        }
        String scale = frameAspectRatio2 != null ? frameAspectRatio2.getScale() : null;
        c.C(c.f54829a, PostAndSocialProtos.Event.CONTENT_EDIT_PUSH_BTN_CLICK, null, null, null, Boolean.valueOf(z10), str, null, null, null, null, null, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(z11 ? 1 : 0), null, null, Boolean.valueOf(scale != null), scale, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147479502, -13, 31, null);
    }

    public final void f(@Nullable String str, @NotNull String cardId, @NotNull SensorPosition position) {
        s.i(cardId, "cardId");
        s.i(position, "position");
        c.q(c.f54829a, AdvertisementProtos.Event.CARD_AD_CLICK, null, cardId, null, null, null, null, str, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073740666, null);
    }

    public final void g(@Nullable String str, @Nullable String str2, @NotNull SensorPosition position) {
        s.i(position, "position");
        c.q(c.f54829a, AdvertisementProtos.Event.CARD_AD_SHOW, null, str2, null, null, null, null, str, null, null, position.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073740666, null);
    }

    public final void h(@Nullable SensorPosition sensorPosition, int i10) {
        GroupOthersLog.f18702a.e(sensorPosition, i10);
    }

    public final void i() {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_MATCH_GUIDE_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
    }

    public final void j() {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_MATCH_GUIDE_SHOW, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
    }

    public final void k(@Nullable String str, @Nullable SensorPosition sensorPosition) {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_TOP, null, null, null, null, null, null, str, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -642, -1, 31, null);
    }

    @NotNull
    public final PostAndSocialProtos.Type l(@Nullable FeedSort feedSort) {
        int i10 = feedSort == null ? -1 : a.f12209a[feedSort.ordinal()];
        if (i10 == 1) {
            return PostAndSocialProtos.Type.TIME;
        }
        if (i10 == 2) {
            return PostAndSocialProtos.Type.FOLLOW;
        }
        if (i10 == 3) {
            return PostAndSocialProtos.Type.CLOSE_FRIENDS;
        }
        if (i10 != 4) {
            return PostAndSocialProtos.Type.UNKNOWN_TYPE;
        }
        return PostAndSocialProtos.Type.SPECIAL_ATTENTION;
    }

    public final void m(@NotNull String authorId, @NotNull String feedId, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene, @NotNull LikeCommentType likeType, boolean z10, @Nullable String str, @Nullable FeedSort feedSort) {
        s.i(authorId, "authorId");
        s.i(feedId, "feedId");
        s.i(likeType, "likeType");
        if (LikeCommentType.Feed == likeType) {
            c cVar = c.f54829a;
            PostAndSocialProtos.Event event = PostAndSocialProtos.Event.POST_LIKE;
            String value = sensorScene != null ? sensorScene.getValue() : null;
            String value2 = sensorPosition != null ? sensorPosition.getValue() : null;
            c.C(cVar, event, null, null, authorId, Boolean.valueOf(z10), null, null, feedId, value, value2, null, null, null, l(feedSort), null, null, null, null, null, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8397722, -1, 31, null);
        }
    }

    public final void n(@Nullable SensorScene sensorScene, @Nullable SensorPosition sensorPosition, @Nullable String str, @Nullable String str2, boolean z10, @Nullable String str3, @Nullable FeedSort feedSort) {
        c cVar = c.f54829a;
        PostAndSocialProtos.Event event = PostAndSocialProtos.Event.POST_CANCEL_LIKE;
        String value = sensorScene != null ? sensorScene.getValue() : null;
        String value2 = sensorPosition != null ? sensorPosition.getValue() : null;
        c.C(cVar, event, null, null, str2, Boolean.valueOf(z10), null, null, str, value, value2, null, null, str3, l(feedSort), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -13210, -1, 31, null);
    }

    public final void o(@Nullable SensorScene sensorScene, @Nullable SensorPosition sensorPosition, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable FeedSort feedSort) {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_COMMENT_DELETE, null, null, str2, bool, str3, null, str, sensorScene != null ? sensorScene.getValue() : null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, str4, l(feedSort), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -13242, -1, 31, null);
    }

    public final void p() {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_CONTENT_LOAD_FAILED, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
    }

    public final void q(@Nullable BtnName btnName) {
        PostAndSocialProtos.Type type;
        int i10 = btnName == null ? -1 : a.f12210b[btnName.ordinal()];
        if (i10 == 5) {
            type = PostAndSocialProtos.Type.COMMENT_BTN;
        } else if (i10 == 6) {
            type = PostAndSocialProtos.Type.COMMENT;
        } else if (i10 != 7) {
            type = PostAndSocialProtos.Type.UNKNOWN_TYPE;
        } else {
            type = PostAndSocialProtos.Type.DESCRIBE;
        }
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_DETAIL_ENTRANCE_CLICK, null, null, null, null, null, null, null, null, null, null, null, null, type, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8194, -1, 31, null);
    }

    public final void r(@NotNull SensorPosition position, @NotNull SensorPosition source, @Nullable SensorScene sensorScene, @Nullable String str, @Nullable String str2, boolean z10, @Nullable String str3, @Nullable FeedSort feedSort) {
        s.i(position, "position");
        s.i(source, "source");
        c cVar = c.f54829a;
        PostAndSocialProtos.Event event = PostAndSocialProtos.Event.POST_DETAIL_SHOW;
        String value = position.getValue();
        String value2 = source.getValue();
        String value3 = sensorScene != null ? sensorScene.getValue() : null;
        c.C(cVar, event, null, value2, str2, Boolean.valueOf(z10), null, null, str, value3, value, null, null, null, l(feedSort), null, null, null, null, null, null, null, null, null, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8397726, -1, 31, null);
    }

    public final void s(@Nullable String str, int i10, @Nullable String str2) {
        c.C(c.f54829a, PostAndSocialProtos.Event.TIME_LIMIT_FEED_AVATAR_DRAW, null, null, str, null, null, null, null, null, null, null, Integer.valueOf(i10), str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6154, -1, 31, null);
    }

    public final void t(@Nullable SensorPosition sensorPosition, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4) {
        c.C(c.f54829a, PostAndSocialProtos.Event.TIME_LIMIT_FEED_ENTRANCE_CLICK, str3, null, str, null, null, null, str4, null, sensorPosition != null ? sensorPosition.getValue() : null, null, num, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -6796, -1, 31, null);
    }

    public final void v(@Nullable String str, @Nullable SensorPosition sensorPosition) {
        c.C(c.f54829a, PostAndSocialProtos.Event.SHOW_POST, null, null, null, null, null, null, str, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -642, -1, 31, null);
    }

    public final void w(@NotNull SensorPosition sensorPosition) {
        s.i(sensorPosition, "sensorPosition");
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_PAGE_SHOW, null, null, null, null, null, null, null, null, sensorPosition.getValue(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -514, -1, 31, null);
    }

    public final void x(@Nullable String str, @Nullable SensorPosition sensorPosition) {
        c.C(c.f54829a, PostAndSocialProtos.Event.HIDE_POST, null, null, null, null, null, null, str, null, sensorPosition != null ? sensorPosition.getValue() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -642, -1, 31, null);
    }

    public final void y(@Nullable SensorScene sensorScene, @Nullable String str, @Nullable String str2) {
        c.C(c.f54829a, PostAndSocialProtos.Event.POST_TOPIC_CLICK, null, null, null, null, null, null, str, sensorScene != null ? sensorScene.getValue() : null, null, null, null, str2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4482, -1, 31, null);
    }

    public final void z() {
        c.C(c.f54829a, PostAndSocialProtos.Event.PRIVATE_POST_PAGE_SHOW, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
    }
}
