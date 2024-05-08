package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.others.OthersProtos;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.c;

/* compiled from: SensorsLogKeyButtonClick.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogKeyButtonClick {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogKeyButtonClick f12211a = new SensorsLogKeyButtonClick();

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum AiIdentify implements a {
        UPLOAD_PICTURE("UPLOAD_PICTURE"),
        BEGIN_AI_SEARCH("BEGIN_AI_SEARCH");


        @NotNull
        private final String buttonName;

        AiIdentify(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.AiIdentify;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum AnchorLiveShowRoom implements a {
        BeautySwitch("美颜开关"),
        MoreOperation("更多选项"),
        PlayMusic("播放音乐"),
        Music("音乐"),
        EndPk("结束PK"),
        Mall("商城"),
        FanClub("粉丝团");


        @NotNull
        private final String buttonName;

        AnchorLiveShowRoom(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.AnchorLiveShowRoom;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum BirthdayFill implements a {
        Next("NEXT");


        @NotNull
        private final String buttonName;

        BirthdayFill(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.BirthdayFill;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum CancelAloha implements a {
        UpdateToRainbow("UP_TO_RAINBOW");


        @NotNull
        private final String buttonName;

        CancelAloha(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.CancelAloha;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ChatRecommend implements a {
        GREET("GREET"),
        NEXT("NEXT"),
        LOOK_UP_FRIEND_STATUS("LOOK_UP_FRIEND_STATUS");


        @NotNull
        private final String buttonName;

        ChatRecommend(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.RecommendedChat;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ChatRoom implements a {
        Reedit("REEDIT");


        @NotNull
        private final String buttonName;

        ChatRoom(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ChatRoom;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ChatState implements a {
        GREET("GREET"),
        CHANGE_STATUS("CHANGE_STATUS"),
        SET_STATUS("CHANGE_STATUS"),
        CLOSE_STATUS("CLOSE_STATUS");


        @NotNull
        private final String buttonName;

        ChatState(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ChatStatus;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ClickButtonName {
        MANAGE
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ClubActivity implements a {
        Newest("NEWEST"),
        Shortest("SHORTEST");


        @NotNull
        private final String buttonName;

        ClubActivity(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ClubActivity;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ClubActivityBtn {
        ActivityOrder("ACTIVITY_ORDER"),
        RichScan("RICH_SCAN"),
        ActivityMedal("ACTIVITY_MEDAL"),
        MyCoin("MY_COIN");


        @NotNull
        private final String buttonName;

        ClubActivityBtn(String str) {
            this.buttonName = str;
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ClubGroupActivity implements a {
        CreateActivity("CREATE_ACTIVITY");


        @NotNull
        private final String buttonName;

        ClubGroupActivity(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ClubGroupActivity;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ClubGroupChat implements a {
        UnreadMessage("UNREAD_MESSAGE"),
        NewMessage("NEW_MESSAGE");


        @NotNull
        private final String buttonName;

        ClubGroupChat(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ClubGroupChat;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ClubList implements a {
        AllClub("ALL_CLUB"),
        NotJoin("NOT_JOIN");


        @NotNull
        private final String buttonName;

        ClubList(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ClubList;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ContactAlohaNotMatchBtn {
        BATCH_CANCEL_FOLLOW("BATCH_CANCEL_FOLLOW"),
        CLEAN_LIST("CLEAN_LIST"),
        CONFIRM("CONFIRM");


        @NotNull
        private final String buttonName;

        ContactAlohaNotMatchBtn(String str) {
            this.buttonName = str;
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum DailyHeart implements a {
        UNLOCK("UNLOCK");


        @NotNull
        private final String buttonName;

        DailyHeart(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.DailyHeart;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum EditProfile implements a {
        NewAddPhoto("新增大头贴"),
        ReplacePhoto("更换大头贴"),
        UPLOAD_DYNAMIC_AVATAR("UPLOAD_DYNAMIC_AVATAR"),
        UPLOAD_AVATAR("UPLOAD_AVATAR"),
        EDIT_PROFILE_PERSONAL_SHOW("EDIT_PROFILE_PERSONAL_SHOW");


        @NotNull
        private final String buttonName;

        EditProfile(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.EditProfile;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum FeedList implements a {
        Vip("会员去广告"),
        POST_SPREAD("POST_SPREAD"),
        REDUCE_RECOMMENDATION_TO_ME("REDUCE_RECOMMENDATION_TO_ME"),
        SeaAll("查看全部"),
        StartRecommend("START_RECOMMEND");


        @NotNull
        private final String buttonName;

        FeedList(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Feed;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LiveShow implements a {
        LeaderBoard("排行榜");


        @NotNull
        private final String buttonName;

        LiveShow(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.LiveShow;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LiveShowRoom implements a {
        RechargePackage("充值礼包"),
        SendGift("送礼物"),
        MessageBox("留言框"),
        Task("任务"),
        FanClub("粉丝团");


        @NotNull
        private final String buttonName;

        LiveShowRoom(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.LiveShowRoom;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Login implements a {
        Help("帮助");


        @NotNull
        private final String buttonName;

        Login(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Login;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LookOtherFriendPraise implements a {
        EDIT("EDIT");


        @NotNull
        private final String buttonName;

        LookOtherFriendPraise(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PraiseDetail;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Match implements a {
        Filter("搜索设定"),
        Nearby("身边"),
        UndoNope("撤销Nope"),
        AllowAccess("允许访问"),
        Reload("重新加载"),
        ModifyFilter("修改筛选条件");


        @NotNull
        private final String buttonName;

        Match(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Match;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum MatchFilter implements a {
        City("漫游"),
        Age("年龄"),
        Height("身高"),
        ActiveTime("ACTIVE_TIME"),
        Weight("体重");


        @NotNull
        private final String buttonName;

        MatchFilter(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.MatchFilter;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum MenuSetting implements a {
        TeenMode("TEENAGER_MODE");


        @NotNull
        private final String buttonName;

        MenuSetting(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.MenuSetting;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Message implements a {
        AllMatchUser("全部匹配"),
        MaskParty("MASK_PARTY"),
        RICH_SCAN("RICH_SCAN");


        @NotNull
        private final String buttonName;

        Message(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Message;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum MessageDetail implements a {
        Reedit("REEDIT"),
        TOPIC("TOPIC"),
        EMOJI("EMOJI"),
        CHANGE("CHANGE"),
        MESSAGE_DETAIL_BUBBLE_PERSONAL("MESSAGE_DETAIL_BUBBLE_PERSONAL");


        @NotNull
        private final String buttonName;

        MessageDetail(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.MessageDetail;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum MyVisitors implements a {
        RenewNow("立即续费");


        @NotNull
        private final String buttonName;

        MyVisitors(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.MyVisitors;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Nearby implements a {
        OpenVipSeeNearbyUser("开通会员查看身边用户");


        @NotNull
        private final String buttonName;

        Nearby(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Nearby;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum NearbyCoverCard implements a {
        Chat("聊天"),
        UNLOCK("UNLOCK");


        @NotNull
        private final String buttonName;

        NearbyCoverCard(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.NearbyCoverCard;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum NickNameFill implements a {
        Next("NEXT");


        @NotNull
        private final String buttonName;

        NickNameFill(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.NickNameFill;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum OnePassLogin implements a {
        OnePassClick("ONE_PASS_CLICK"),
        OthersWayClick("OTHERS_WAY_CLICK");


        @NotNull
        private final String buttonName;

        OnePassLogin(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.OnePassLogin;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum OpenPush implements a {
        Huawei("HUAWEI"),
        Xiaomi("XIAOMI"),
        Oppo("OPPO"),
        Oneplus("ONEPLUS"),
        Vivo("VIVO");


        @NotNull
        private final String buttonName;

        OpenPush(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.NewMsgNotice;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PasswordLogin implements a {
        ForgetPassword("忘记密码");


        @NotNull
        private final String buttonName;

        PasswordLogin(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PasswordLogin;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PersonalAppIcon implements a {
        SAVE("SAVE");


        @NotNull
        private final String buttonName;

        PersonalAppIcon(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PersonalIcon;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PersonalSetting implements a {
        PERSONAL_FRAME("PERSONAL_FRAME"),
        CUSTOM_CHAT_BUBBLE("CUSTOM_CHAT_BUBBLE");


        @NotNull
        private final String buttonName;

        PersonalSetting(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PERSONAL_SETTING;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PostLimit implements a {
        DEL_TIME_LIMIT_FEED("DEL_TIME_LIMIT_FEED");


        @NotNull
        private final String buttonName;

        PostLimit(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PostLimit;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PreviewConsultShow implements a {
        Start("START");


        @NotNull
        private final String buttonName;

        PreviewConsultShow(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PREVIEW_CONSULT_SHOW;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PrivacySetting implements a {
        HideMyActiveTime("隐藏我的活跃时间"),
        HideWealthLevel("HIDE_WEALTH_LEVEL");


        @NotNull
        private final String buttonName;

        PrivacySetting(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PrivacySetting;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum Profile implements a {
        EditInformation("修改资料"),
        Share("SHARE");


        @NotNull
        private final String buttonName;

        Profile(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Profile;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PropCard implements a {
        CARD_INTRODUCE("CARD_INTRODUCE"),
        BUY_PROP("BUY_PROP"),
        CHOOSE_ROLE("CHOOSE_ROLE"),
        SEME_UKE("SEME_UKE"),
        SAME_CITY("SAME_CITY"),
        SPEED("SPEED"),
        SINGLE("SINGLE"),
        TOP("TOP"),
        VERS_TOP("VERS_TOP"),
        VERS("VERS"),
        VERS_BOTTOM("VERS_BOTTOM"),
        BOTTOM("BOTTOM"),
        OTHERS("OTHERS");


        @NotNull
        private final String buttonName;

        PropCard(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.PropCard;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum RainbowRecommend implements a {
        StartRecommend("START_RECOMMEND");


        @NotNull
        private final String buttonName;

        RainbowRecommend(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.RainbowRecommend;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ReceivedFriendPraise implements a {
        SHARE("SHARE");


        @NotNull
        private final String buttonName;

        ReceivedFriendPraise(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.ReceivedPraise;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum RegisterAddAvatar implements a {
        AddPhoto("添加照片"),
        SKIP_HELP("SKIP_HELP"),
        SKIP_UPLOAD("SKIP_UPLOAD");


        @NotNull
        private final String buttonName;

        RegisterAddAvatar(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.RegisterAddAvatar;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum RegisterImageCrop implements a {
        Complete("完成");


        @NotNull
        private final String buttonName;

        RegisterImageCrop(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.RegisterImageCrop;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum SplashVipClick implements a {
        Vip("会员去广告");


        @NotNull
        private final String buttonName;

        SplashVipClick(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Splash;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum SuperExposure implements a {
        StartSuperExposure("START_SUPER_EXPOSURE");


        @NotNull
        private final String buttonName;

        SuperExposure(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.SuperExposure;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum SwitchAccount implements a {
        ADD_ACCOUNT("ADD_ACCOUNT");


        @NotNull
        private final String buttonName;

        SwitchAccount(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.SwitchAccount;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum UnlockNearby implements a {
        UNLOCK("UNLOCK");


        @NotNull
        private final String buttonName;

        UnlockNearby(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.UnlockNearBy;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum UploadAvatar implements a {
        Next("NEXT");


        @NotNull
        private final String buttonName;

        UploadAvatar(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.RegisterAddAvatar;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum UserSetting implements a {
        Avatar("头像"),
        EditInformation("修改资料"),
        Popularity("人气"),
        Like("喜欢"),
        Vip("会员"),
        MyLiveShow("我的直播"),
        CanUseBalance("可用钻石"),
        LikedPhotos("赞过的照片"),
        PrivateFeed("我的私人影集"),
        Setting("设置"),
        ADD_ACCOUNT("ADD_ACCOUNT"),
        CustomName("自定义");


        @NotNull
        private String buttonName;

        UserSetting(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @NotNull
        public final String getButtonName() {
            return this.buttonName;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.Setting;
        }

        public final void setButtonName(@NotNull String str) {
            s.i(str, "<set-?>");
            this.buttonName = str;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum VerifySMSLogin implements a {
        UsePasswordLogin("使用密码登录"),
        InvalidNumber("手机号已失效");


        @NotNull
        private final String buttonName;

        VerifySMSLogin(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.VerifySMSLogin;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum VoiceRoom implements a {
        REPORT("REPORT"),
        SWITCH_MIKE("SWITCH_MIKE"),
        SWITCH_LOUDSPEAKER("SWITCH_LOUDSPEAKER"),
        SHARE_PROFILE("SHARE_PROFILE"),
        LIKE("LIKE"),
        INVITE_LIKE("INVITE_LIKE");


        @NotNull
        private final String buttonName;

        VoiceRoom(String str) {
            this.buttonName = str;
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public String buttonName() {
            return this.buttonName;
        }

        public void click() {
            a.C0143a.a(this);
        }

        public void clickWithUserId(@Nullable String str) {
            a.C0143a.b(this, str);
        }

        @Override // com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick.a
        @NotNull
        public SensorPosition screenName() {
            return SensorPosition.VoiceRoom;
        }

        public void show() {
            a.C0143a.c(this);
        }
    }

    /* compiled from: SensorsLogKeyButtonClick.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {

        /* compiled from: SensorsLogKeyButtonClick.kt */
        @d
        /* renamed from: com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0143a {
            public static void a(@NotNull a aVar) {
                SensorsLogKeyButtonClick.f12211a.c(aVar.screenName().getValue(), aVar.buttonName());
            }

            public static void b(@NotNull a aVar, @Nullable String str) {
                SensorsLogKeyButtonClick.f12211a.d(aVar.screenName().getValue(), aVar.buttonName(), str);
            }

            public static void c(@NotNull a aVar) {
                GroupOthersLog.f18702a.R(aVar.screenName().getValue(), aVar.buttonName());
            }
        }

        @NotNull
        String buttonName();

        @NotNull
        SensorPosition screenName();
    }

    public final void b(@NotNull SensorPosition position, @NotNull ClickButtonName name) {
        s.i(position, "position");
        s.i(name, "name");
        c(position.getValue(), name.name());
    }

    public final void c(@NotNull String screenName, @NotNull String buttonName) {
        s.i(screenName, "screenName");
        s.i(buttonName, "buttonName");
        GroupOthersLog.f18702a.Q(screenName, buttonName);
    }

    public final void d(String str, String str2, String str3) {
        c.f54829a.z(OthersProtos.Event.USER_RELATED_BTN_CLICK, (r85 & 2) != 0 ? null : null, (r85 & 4) != 0 ? null : null, (r85 & 8) != 0 ? null : null, (r85 & 16) != 0 ? null : null, (r85 & 32) != 0 ? null : null, (r85 & 64) != 0 ? null : null, (r85 & 128) != 0 ? null : null, (r85 & 256) != 0 ? null : null, (r85 & 512) != 0 ? null : str2, (r85 & 1024) != 0 ? null : str3, (r85 & 2048) != 0 ? null : null, (r85 & 4096) != 0 ? null : null, (r85 & 8192) != 0 ? null : null, (r85 & 16384) != 0 ? null : str, (r85 & 32768) != 0 ? null : null, (r85 & 65536) != 0 ? null : null, (r85 & 131072) != 0 ? null : null, (r85 & 262144) != 0 ? null : null, (r85 & 524288) != 0 ? null : null, (r85 & 1048576) != 0 ? null : null, (r85 & 2097152) != 0 ? null : null, (r85 & 4194304) != 0 ? null : null, (r85 & 8388608) != 0 ? null : null, (r85 & 16777216) != 0 ? null : null, (r85 & 33554432) != 0 ? null : null, (r85 & 67108864) != 0 ? null : null, (r85 & 134217728) != 0 ? null : null, (r85 & 268435456) != 0 ? null : null, (r85 & 536870912) != 0 ? null : null, (r85 & 1073741824) != 0 ? null : null, (r85 & Integer.MIN_VALUE) != 0 ? null : null, (r86 & 1) != 0 ? null : null, (r86 & 2) != 0 ? null : null, (r86 & 4) != 0 ? null : null, (r86 & 8) != 0 ? null : null, (r86 & 16) != 0 ? null : null, (r86 & 32) != 0 ? null : null, (r86 & 64) != 0 ? null : null, (r86 & 128) != 0 ? null : null, (r86 & 256) != 0 ? null : null, (r86 & 512) != 0 ? null : null, (r86 & 1024) != 0 ? null : null);
    }
}
