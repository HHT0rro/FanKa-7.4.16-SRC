package p1;

import com.cupidapp.live.appdialog.model.ActivationType;
import com.cupidapp.live.base.network.model.BaseUrlModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.EnableButtonsModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.permission.PermissionRequestModel;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.SystemPermissionStatusModel;
import com.cupidapp.live.consult.view.StayGuideShowTimeModel;
import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.feed.model.FeedPostLimitGuideModel;
import com.cupidapp.live.feed.model.FeedPraiseGuideModel;
import com.cupidapp.live.feed.model.FeedZoomGuideModel;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditCacheModel;
import com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel;
import com.cupidapp.live.liveshow.model.LiveConnectType;
import com.cupidapp.live.liveshow.view.LivePopupWindowSettingModel;
import com.cupidapp.live.main.model.CountDataModel;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.RoleType;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.SearchHideResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserRankModel;
import com.cupidapp.live.push.model.FKPushTokenModel;
import com.cupidapp.live.setting.model.CheckNonageModel;
import com.cupidapp.live.setting.model.MultiAccountUserIdsModel;
import com.cupidapp.live.setting.model.NewPushSettingResult;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
import com.cupidapp.live.startup.model.FKExpressAdLocalModel;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.huawei.openalliance.ad.constant.u;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalStore.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    @Nullable
    public static SearchHideResult A;

    @Nullable
    public static Boolean A2;

    @Nullable
    public static String B;

    @Nullable
    public static FeedZoomGuideModel B0;

    @Nullable
    public static Boolean B1;

    @Nullable
    public static Boolean C2;

    @Nullable
    public static FeedSort D;

    @Nullable
    public static Boolean D1;

    @Nullable
    public static Boolean E2;

    @Nullable
    public static Boolean F;

    @Nullable
    public static Boolean F0;

    @Nullable
    public static Boolean F1;
    public static boolean G;

    @Nullable
    public static LiveConnectType G2;

    @Nullable
    public static Boolean I1;

    @Nullable
    public static Boolean I2;

    @Nullable
    public static String J;

    @Nullable
    public static Boolean K1;

    @Nullable
    public static Boolean L;

    @Nullable
    public static SystemPermissionStatusModel L0;

    @Nullable
    public static Boolean L2;

    @Nullable
    public static Boolean M1;

    @Nullable
    public static Boolean N;

    @Nullable
    public static SystemPermissionStatusModel N0;

    @Nullable
    public static Boolean N2;

    @NotNull
    public static final a<Boolean> O;

    @Nullable
    public static Boolean O1;

    @Nullable
    public static SystemPermissionStatusModel P0;

    @Nullable
    public static Boolean P2;

    @Nullable
    public static Boolean Q;

    @Nullable
    public static Boolean Q1;

    @Nullable
    public static SystemPermissionStatusModel R0;

    @Nullable
    public static Boolean R2;

    @Nullable
    public static Boolean S1;

    @Nullable
    public static Boolean T2;

    @Nullable
    public static FKPushTokenModel U;

    @Nullable
    public static MultiAccountUserIdsModel U1;

    @NotNull
    public static final d<Integer> V0;

    @Nullable
    public static CoordinateModel V2;

    @NotNull
    public static final d<Boolean> X0;

    @Nullable
    public static Boolean X1;

    @Nullable
    public static Boolean X2;
    public static boolean Y;

    @NotNull
    public static final d<Boolean> Y0;

    @NotNull
    public static final d<Boolean> Z0;

    @Nullable
    public static Boolean Z1;

    @Nullable
    public static Boolean Z2;

    /* renamed from: a1, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52736a1;

    /* renamed from: a2, reason: collision with root package name */
    @NotNull
    public static final a<Integer> f52737a2;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f52739b;

    /* renamed from: b2, reason: collision with root package name */
    @Nullable
    public static Integer f52742b2;

    /* renamed from: b3, reason: collision with root package name */
    @Nullable
    public static Boolean f52743b3;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static Triple<Boolean, CheckNonageModel, String> f52744c;

    /* renamed from: d, reason: collision with root package name */
    public static int f52749d;

    /* renamed from: d0, reason: collision with root package name */
    @Nullable
    public static Boolean f52750d0;

    /* renamed from: d2, reason: collision with root package name */
    @Nullable
    public static Boolean f52752d2;

    /* renamed from: d3, reason: collision with root package name */
    @Nullable
    public static StayGuideShowTimeModel f52753d3;

    /* renamed from: e, reason: collision with root package name */
    public static int f52754e;

    /* renamed from: f, reason: collision with root package name */
    public static int f52758f;

    /* renamed from: f1, reason: collision with root package name */
    @NotNull
    public static final d<Integer> f52760f1;

    /* renamed from: f2, reason: collision with root package name */
    @Nullable
    public static Boolean f52761f2;

    /* renamed from: f3, reason: collision with root package name */
    @Nullable
    public static Boolean f52762f3;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f52763g;

    /* renamed from: g1, reason: collision with root package name */
    @NotNull
    public static final d<Long> f52765g1;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static String f52767h;

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    public static ConstantsResult f52768h0;

    /* renamed from: h1, reason: collision with root package name */
    @Nullable
    public static Long f52769h1;

    /* renamed from: h2, reason: collision with root package name */
    @NotNull
    public static final a<Integer> f52770h2;

    /* renamed from: h3, reason: collision with root package name */
    @Nullable
    public static Boolean f52771h3;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static List<ImageModel> f52772i;

    /* renamed from: i2, reason: collision with root package name */
    public static int f52775i2;

    /* renamed from: j, reason: collision with root package name */
    public static int f52777j;

    /* renamed from: j0, reason: collision with root package name */
    @Nullable
    public static User f52778j0;

    /* renamed from: j1, reason: collision with root package name */
    @Nullable
    public static Boolean f52779j1;

    /* renamed from: j3, reason: collision with root package name */
    @Nullable
    public static Boolean f52781j3;

    /* renamed from: k, reason: collision with root package name */
    public static int f52782k;

    /* renamed from: k0, reason: collision with root package name */
    public static boolean f52783k0;

    /* renamed from: k2, reason: collision with root package name */
    @Nullable
    public static Boolean f52785k2;

    /* renamed from: l, reason: collision with root package name */
    public static int f52787l;

    /* renamed from: l1, reason: collision with root package name */
    @Nullable
    public static Boolean f52789l1;

    /* renamed from: m, reason: collision with root package name */
    public static int f52791m;

    /* renamed from: m0, reason: collision with root package name */
    @Nullable
    public static String f52792m0;

    /* renamed from: m2, reason: collision with root package name */
    @Nullable
    public static Boolean f52794m2;

    /* renamed from: n, reason: collision with root package name */
    public static int f52795n;

    /* renamed from: n1, reason: collision with root package name */
    @Nullable
    public static Boolean f52797n1;

    /* renamed from: o, reason: collision with root package name */
    public static int f52799o;

    /* renamed from: p, reason: collision with root package name */
    public static long f52803p;

    /* renamed from: p0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52804p0;

    /* renamed from: p1, reason: collision with root package name */
    @Nullable
    public static Boolean f52805p1;

    /* renamed from: p2, reason: collision with root package name */
    @Nullable
    public static y2.b f52806p2;

    /* renamed from: r, reason: collision with root package name */
    public static long f52811r;

    /* renamed from: r1, reason: collision with root package name */
    @Nullable
    public static Boolean f52813r1;

    @Nullable
    public static y2.c s2;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f52818t;

    /* renamed from: t1, reason: collision with root package name */
    @Nullable
    public static Boolean f52820t1;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f52821u;

    /* renamed from: u0, reason: collision with root package name */
    @NotNull
    public static final d<Long> f52822u0;

    /* renamed from: u2, reason: collision with root package name */
    @Nullable
    public static Boolean f52824u2;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f52825v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public static Integer f52828w;

    /* renamed from: w1, reason: collision with root package name */
    @Nullable
    public static Boolean f52830w1;

    /* renamed from: w2, reason: collision with root package name */
    @Nullable
    public static Boolean f52831w2;

    /* renamed from: x0, reason: collision with root package name */
    @Nullable
    public static Boolean f52833x0;

    /* renamed from: x1, reason: collision with root package name */
    @NotNull
    public static final d<Long> f52834x1;

    /* renamed from: y2, reason: collision with root package name */
    @Nullable
    public static FeedPostLimitGuideModel f52838y2;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f52839z;

    /* renamed from: z0, reason: collision with root package name */
    @Nullable
    public static FeedPraiseGuideModel f52840z0;

    @Nullable
    public static Boolean z1;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f52734a = new g();

    /* renamed from: q, reason: collision with root package name */
    public static boolean f52807q = true;

    /* renamed from: s, reason: collision with root package name */
    public static long f52815s = u.as;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f52832x = true;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public static VipPurchaseEntranceType f52836y = VipPurchaseEntranceType.NearByMapFilter;

    @NotNull
    public static final d<FeedSort> C = new d<>(new f("feedListSort", new k(FeedSort.class)));

    @NotNull
    public static final d<Boolean> E = new d<>(new f("feedChangeSort", new b(false)));

    @NotNull
    public static final a<String> H = new a<>(new f("IntranetDomainNameKey", new l()));

    @NotNull
    public static final a<String> I = new a<>(new f("APP_GUID", new l()));

    @NotNull
    public static final a<Boolean> K = new a<>(new f("DEBUG_ENDPOINT_CACHE_KEY", new b(false)));

    @NotNull
    public static final a<Boolean> M = new a<>(new f("PrivacyPermissionDialogGuide", new b(true)));

    @NotNull
    public static final a<Boolean> P = new a<>(new f("AgreePrivacyUpdateKey", new b(true)));

    @NotNull
    public static final a<Boolean> R = new a<>(new f("needGetGuidFromExternalStorage", new b(true)));

    @NotNull
    public static final a<Boolean> S = new a<>(new f("IsSaveGuidFileToExternalStorageInAndroidTenKey", new b(false)));

    @NotNull
    public static final a<FKPushTokenModel> T = new a<>(new f("PushTokenModel", new k(FKPushTokenModel.class)));

    @NotNull
    public static final a<Boolean> V = new a<>(new f("SWIPE_CARD_ANIMATION_GUIDE", new b(true)));

    @NotNull
    public static final a<Boolean> W = new a<>(new f("SWIPE_CARD_Click_GUIDE", new b(true)));

    @NotNull
    public static final a<Boolean> X = new a<>(new f("NewMatchProfileGuide", new b(true)));

    @NotNull
    public static final a<Boolean> Z = new a<>(new f("PrivacyCameraPermissionGuide", new b(true)));

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52735a0 = new a<>(new f("privacyStoragePermissionGuide", new b(true)));

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52740b0 = new a<>(new f("audioPermissionGuide", new b(true)));

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52745c0 = new a<>(new f("onlyCameraPermissionGuide", new b(true)));

    /* renamed from: e0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52755e0 = new d<>(new f("PrivacyLocationPermissionGuide", new b(true)));

    /* renamed from: f0, reason: collision with root package name */
    @NotNull
    public static final d<BaseUrlModel> f52759f0 = new d<>(new f("APP_BASE_URL_KEY", new k(BaseUrlModel.class)));

    /* renamed from: g0, reason: collision with root package name */
    @NotNull
    public static final d<ConstantsResult> f52764g0 = new d<>(new f("ConstantsResultKey", new k(ConstantsResult.class)));

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    public static final d<User> f52773i0 = new d<>(new f("LOCAL_USER_KEY", new k(User.class)));

    /* renamed from: l0, reason: collision with root package name */
    @NotNull
    public static final d<String> f52788l0 = new d<>(new f("LOCAL_USER_TICKET_KEY", new l()));

    /* renamed from: n0, reason: collision with root package name */
    public static boolean f52796n0 = true;

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    public static final d<UserRankModel> f52800o0 = new d<>(new f("UserRankResultKeys", new k(UserRankModel.class)));

    /* renamed from: q0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52808q0 = new d<>(new f("MiniLiveOpen", new b(true)));

    /* renamed from: r0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52812r0 = new d<>(new f("LastMiniLiveSettingIsOpen", new b(true)));

    /* renamed from: s0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52816s0 = new d<>(new f("IsFirstMiniLiveOpen", new b(true)));

    /* renamed from: t0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52819t0 = new d<>(new f("LiveShowClearScreenGuideKey", new b(true)));

    /* renamed from: v0, reason: collision with root package name */
    @NotNull
    public static final d<Long> f52826v0 = new d<>(new f("UPDATE_NEW_VERSION_DOWNLOAD_ID", new i(-1)));

    /* renamed from: w0, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52829w0 = new d<>(new f("FeedMultiImageGuide", new b(true)));

    /* renamed from: y0, reason: collision with root package name */
    @NotNull
    public static final d<FeedPraiseGuideModel> f52837y0 = new d<>(new f("FeedPraiseGuideDisplay", new k(FeedPraiseGuideModel.class)));

    @NotNull
    public static final d<FeedZoomGuideModel> A0 = new d<>(new f("FeedZoomGuideDisplayKey", new k(FeedZoomGuideModel.class)));

    @NotNull
    public static final d<FKExpressAdLocalModel> C0 = new d<>(new f("FKExpressAdLocalModel", new k(FKExpressAdLocalModel.class)));

    @NotNull
    public static final d<MatchSettingResult> D0 = new d<>(new f("MatchSettingResultKey", new k(MatchSettingResult.class)));

    @NotNull
    public static final d<Boolean> E0 = new d<>(new f("NearProfileTips", new b(true)));

    @NotNull
    public static final d<PrivacySettingDataResult> G0 = new d<>(new f("PRIVACY_RESULT_KEY", new k(PrivacySettingDataResult.class)));

    @NotNull
    public static final d<NewPushSettingResult> H0 = new d<>(new f("NEW_PUSH_SETTING_RESULT_KEY", new k(NewPushSettingResult.class)));

    @NotNull
    public static final a<String> I0 = new a<>(new f("AndroidOAID", new l()));

    @NotNull
    public static final a<FKLiveBeautyEditCacheModel> J0 = new a<>(new f("FKLiveDataBeautyEffectKey", new k(FKLiveBeautyEditCacheModel.class)));

    @NotNull
    public static final d<SystemPermissionStatusModel> K0 = new d<>(new f("StoragePermissionStatusKey", new k(SystemPermissionStatusModel.class)));

    @NotNull
    public static final d<SystemPermissionStatusModel> M0 = new d<>(new f("LocationPermissionStatusKey", new k(SystemPermissionStatusModel.class)));

    @NotNull
    public static final d<SystemPermissionStatusModel> O0 = new d<>(new f("LocationInformationStatusKey", new k(SystemPermissionStatusModel.class)));

    @NotNull
    public static final d<SystemPermissionStatusModel> Q0 = new d<>(new f("PushPermissionStatusKey", new k(SystemPermissionStatusModel.class)));

    @NotNull
    public static final d<SharePlatform> S0 = new d<>(new f("StartLiveStreamingShareChannelKey", new k(SharePlatform.class)));

    @NotNull
    public static final d<Long> T0 = new d<>(new f("AlohaOrNopeInMatchTimeKey", new i(System.currentTimeMillis())));

    @NotNull
    public static final d<LivePopupWindowSettingModel> U0 = new d<>(new f("LIVE_SHOW_POPUP_WINDOW_KEY", new k(LivePopupWindowSettingModel.class)));

    @NotNull
    public static final d<Boolean> W0 = new d<>(new f("SHOW_LIVE_MULTI_PK_GUIDE_KEY", new b(true)));

    /* renamed from: b1, reason: collision with root package name */
    @NotNull
    public static final d<String> f52741b1 = new d<>(new f("feed_list_ad_close_time", new l()));

    /* renamed from: c1, reason: collision with root package name */
    @NotNull
    public static final a<LiveBeautyResourceSaveModel> f52746c1 = new a<>(new f("LIVE_BEAUTY_RESOURCES", new k(LiveBeautyResourceSaveModel.class)));

    /* renamed from: d1, reason: collision with root package name */
    @NotNull
    public static final a<PermissionRequestModel> f52751d1 = new a<>(new f("SYSTEM_PERMISSION_STATUS", new k(PermissionRequestModel.class)));

    /* renamed from: e1, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52756e1 = new d<>(new f("SHOW_VIP_VISITOR_DIFFERENCE", new b(true)));

    /* renamed from: i1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52774i1 = new a<>(new f("VIEW_SNAP_IMAGE_PROMPT_KEY", new b(true)));

    /* renamed from: k1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52784k1 = new a<>(new f("SHARE_FOCUS_NEW", new b(true)));

    /* renamed from: m1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52793m1 = new a<>(new f("LONG_CLICK_TRIM_TIP", new b(true)));

    /* renamed from: o1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52801o1 = new a<>(new f("SETTING_LOCATION_TIP", new b(true)));

    /* renamed from: q1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52809q1 = new a<>(new f("SETTING_DISTANCE_TIP", new b(true)));

    /* renamed from: s1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52817s1 = new a<>(new f("SHOW_SWIPE_DOWN_PROMPT", new b(true)));

    /* renamed from: u1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52823u1 = new a<>(new f("SHOW_SUPER_LIKE_POP", new b(true)));

    /* renamed from: v1, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52827v1 = new a<>(new f("SHOW_AT_TIP", new b(true)));

    @NotNull
    public static final a<Boolean> y1 = new a<>(new f("FOCUS_INTRO_TIP", new b(true)));

    @NotNull
    public static final a<Boolean> A1 = new a<>(new f("CLOSE_FRIEND_INTRO_TIP", new b(true)));

    @NotNull
    public static final a<Boolean> C1 = new a<>(new f("FOCUS_TIP_ON_FEED", new b(true)));

    @NotNull
    public static final a<Boolean> E1 = new a<>(new f("FEED_TOP_ON_FEED", new b(true)));

    @NotNull
    public static final a<Boolean> G1 = new a<>(new f("STORY_LABEL_TIPS", new b(true)));

    @NotNull
    public static final a<Boolean> H1 = new a<>(new f("CHAT_RECOMMEND_GUIDE", new b(true)));

    @NotNull
    public static final a<Boolean> J1 = new a<>(new f("MASK_PARTY_CHAT_SEND_MESSAGE", new b(true)));

    @NotNull
    public static final a<Boolean> L1 = new a<>(new f("MASK_PARTY_CHAT_SEND_IMAGE", new b(true)));

    @NotNull
    public static final a<Boolean> N1 = new a<>(new f("chat_rcmd_long_click_tip", new b(true)));

    @NotNull
    public static final a<Boolean> P1 = new a<>(new f("state_hi_long_click_tip", new b(true)));

    @NotNull
    public static final a<Boolean> R1 = new a<>(new f("state_swipe_avatar_tip", new b(true)));

    @NotNull
    public static final a<MultiAccountUserIdsModel> T1 = new a<>(new f("MULTI_ACCOUNT_USER_IDS_MODEL", new k(MultiAccountUserIdsModel.class)));

    @NotNull
    public static final a<Boolean> V1 = new a<>(new f("SHOW_SWITCH_ACCOUNT_GUIDE_BUBBLE", new b(true)));

    @NotNull
    public static final a<Boolean> W1 = new a<>(new f("SHOW_MBTI_BUBBLE", new b(true)));

    @NotNull
    public static final a<Boolean> Y1 = new a<>(new f("daily_heart_new_icon", new b(true)));

    /* renamed from: c2, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52747c2 = new a<>(new f("SHOW_COMPLETE_INFO_PROMPT", new b(true)));

    @NotNull
    public static final a<Boolean> e2 = new a<>(new f("SHOW_VOICE_PARTY_CORNER_ON_MASK_PARTY_MATCH", new b(true)));

    /* renamed from: g2, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52766g2 = new a<>(new f("SHOW_VOICE_PARTY_CORNER_ON_MESSAGE", new b(true)));

    /* renamed from: j2, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52780j2 = new a<>(new f("MASK_ENTRANCE_GUIDE", new b(true)));

    /* renamed from: l2, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52790l2 = new a<>(new f("SHOW_CHAT_TOPIC_GUIDE_BUBBLE", new b(true)));

    /* renamed from: n2, reason: collision with root package name */
    @NotNull
    public static final a<y2.b> f52798n2 = new a<>(new f("MASK_PARTY_ITEM_CARD", new k(y2.b.class)));

    /* renamed from: o2, reason: collision with root package name */
    @NotNull
    public static final a<y2.b> f52802o2 = new a<>(new f("MASK_PARTY_ITEM_CARD_MODEL", new k(y2.b.class)));

    /* renamed from: q2, reason: collision with root package name */
    @NotNull
    public static final a<y2.a> f52810q2 = new a<>(new f("SELECTED_ROLE", new k(y2.a.class)));

    /* renamed from: r2, reason: collision with root package name */
    @NotNull
    public static final a<y2.c> f52814r2 = new a<>(new f("SELECTED_ROLE_LIST", new k(y2.c.class)));

    @NotNull
    public static final a<Boolean> t2 = new a<>(new f("SHOW_POST_SWIPE_GUIDE", new b(true)));

    @NotNull
    public static final a<Boolean> v2 = new a<>(new f("SHOW_POST_CLICK_GUIDE", new b(true)));

    /* renamed from: x2, reason: collision with root package name */
    @NotNull
    public static final d<FeedPostLimitGuideModel> f52835x2 = new d<>(new f("POST_LIMIT_GUIDE_IN_FEED", new k(FeedPostLimitGuideModel.class)));

    /* renamed from: z2, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52841z2 = new a<>(new f("SHOW_POST_LIMIT_FIRST_HINT_DIALOG", new b(true)));

    @NotNull
    public static final a<Boolean> B2 = new a<>(new f("SHOW_POST_LIMIT_ADD_MULTI_TEXT_GUIDE_BUBBLE", new b(true)));

    @NotNull
    public static final a<Boolean> D2 = new a<>(new f("SHOW_POST_LIMIT_CHANGE_TEXT_BG_GUIDE_BUBBLE", new b(true)));

    @NotNull
    public static final a<LiveConnectType> F2 = new a<>(new f("LIVE_CONNECT_TYPE", new k(LiveConnectType.class)));

    @NotNull
    public static final a<Boolean> H2 = new a<>(new f("SWIPE_CARD_UPLOAD_AVATAR_GUIDE", new b(true)));

    @NotNull
    public static final a<Boolean> J2 = new a<>(new f("PROFILE_MATCH_GUIDE", new b(true)));

    @NotNull
    public static final a<Boolean> K2 = new a<>(new f("SET_SHOW_IN_PROFILE_GUIDE_BUBBLE", new b(true)));

    @NotNull
    public static final a<Boolean> M2 = new a<>(new f("SHOW_GIFT_EFFECTS", new b(true)));

    @NotNull
    public static final d<Boolean> O2 = new d<>(new f("TEEN_MODE", new b(false)));

    @NotNull
    public static final d<Boolean> Q2 = new d<>(new f("FILTER_MBTI_RED_DOT", new b(true)));

    @NotNull
    public static final d<Boolean> S2 = new d<>(new f("TEST_MBTI_ENTR", new b(true)));

    @NotNull
    public static final d<CoordinateModel> U2 = new d<>(new f("TEST_CUSTOM_LOCATION", new k(CoordinateModel.class)));

    @NotNull
    public static final a<Boolean> W2 = new a<>(new f("APP_IS_FIRST_ACTIVATION", new b(true)));

    @NotNull
    public static final a<Boolean> Y2 = new a<>(new f("SHOW_SPREAD_FEED_UNREAD", new b(true)));

    /* renamed from: a3, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52738a3 = new a<>(new f("FIRST_ENTER_CONSULT_ROOM_GUIDE", new b(true)));

    /* renamed from: c3, reason: collision with root package name */
    @NotNull
    public static final a<StayGuideShowTimeModel> f52748c3 = new a<>(new f("SHOW_CONSULT_ROOM_STAY_GUIDE", new k(StayGuideShowTimeModel.class)));

    /* renamed from: e3, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52757e3 = new a<>(new f("MATCH_REVERT_GUIDE_SHOW", new b(true)));

    @NotNull
    public static final a<Boolean> g3 = new a<>(new f("MAP_INTRO_TIP", new b(true)));

    /* renamed from: i3, reason: collision with root package name */
    @NotNull
    public static final a<Boolean> f52776i3 = new a<>(new f("FEED_RCMD_GUIDE", new b(true)));

    /* renamed from: k3, reason: collision with root package name */
    @NotNull
    public static final d<Boolean> f52786k3 = new d<>(new f("SHOW_QUICK_GIFT_CONFIRM", new b(true)));

    static {
        int i10 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        O = new a<>(new f("IsShowedPrivacyPermissionDialogGuide", new b(false, i10, defaultConstructorMarker)));
        f52804p0 = new d<>(new f("IS_NEW_REGISTER_USER", new b(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        long j10 = 0;
        f52822u0 = new d<>(new f("LAST_CHECK_VERSION_TIME_KEY", new i(j10, i10, defaultConstructorMarker)));
        V0 = new d<>(new f("ENTER_OTHERS_LIVE_ROOM_KEY", new e(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        X0 = new d<>(new f("SHOW_LIVE_PK_MUTE_GUIDE_KEY", new b(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        Y0 = new d<>(new f("SHOW_LIVE_PK_RULE_GUIDE_KEY", new b(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        Z0 = new d<>(new f("SHOW_LIVE_PK_ENTER_OTHERS_ROOM_GUIDE_KEY", new b(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        f52736a1 = new d<>(new f("SHOW_LIVE_PK_PUNISH_PROMPT_GUIDE_KEY", new b(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        f52760f1 = new d<>(new f("VIP_MENU_COUNT", new e(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        f52765g1 = new d<>(new f("NOTIFY_PAGE_MOVE_PLACE_GUIDE", new i(j10, i10, defaultConstructorMarker)));
        f52834x1 = new d<>(new f("COLD_StART_APP_TIME", new i(j10, i10, defaultConstructorMarker)));
        f52737a2 = new a<>(new f("ENTER_MASK_PARTY_MATCH_TIMES", new e(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
        f52770h2 = new a<>(new f("KEYBOARD_HEIGHT", new e(0 == true ? 1 : 0, i10, defaultConstructorMarker)));
    }

    @Nullable
    public final FeedPraiseGuideModel A() {
        if (f52840z0 == null) {
            FeedPraiseGuideModel c4 = f52837y0.c();
            if (c4 == null) {
                c4 = new FeedPraiseGuideModel(false, 0, false, 7, null);
            }
            f52840z0 = c4;
        }
        return f52840z0;
    }

    public final int A0() {
        return f52777j;
    }

    @Nullable
    public final Boolean A1() {
        if (I2 == null) {
            I2 = H2.c();
        }
        return I2;
    }

    public final void A2(@Nullable User user) {
        if (f52783k0) {
            f52778j0 = user;
            f52773i0.d(user);
            f52783k0 = false;
            return;
        }
        User user2 = f52778j0;
        if ((user2 != null ? user2.userId() : null) != null) {
            if ((user != null ? user.userId() : null) != null) {
                User user3 = f52778j0;
                if (!s.d(user3 != null ? user3.userId() : null, user.userId())) {
                    return;
                }
            }
        }
        f52778j0 = user;
        f52773i0.d(user);
    }

    public final void A3(@Nullable Boolean bool) {
        f52779j1 = bool;
        f52774i1.d(bool);
    }

    @Nullable
    public final Boolean B() {
        if (f52781j3 == null) {
            f52781j3 = f52776i3.c();
        }
        return f52781j3;
    }

    public final int B0() {
        return f52787l;
    }

    @NotNull
    public final a<PermissionRequestModel> B1() {
        return f52751d1;
    }

    public final void B2(boolean z10) {
        G = z10;
    }

    public final void B3(@Nullable Boolean bool) {
        f52761f2 = bool;
        e2.d(bool);
    }

    @Nullable
    public final Boolean C() {
        if (F1 == null) {
            F1 = E1.c();
        }
        return F1;
    }

    public final int C0() {
        return f52791m;
    }

    @Nullable
    public final Boolean C1() {
        if (P2 == null) {
            P2 = O2.c();
        }
        return P2;
    }

    public final void C2(@Nullable SystemPermissionStatusModel systemPermissionStatusModel) {
        P0 = systemPermissionStatusModel;
        O0.d(systemPermissionStatusModel);
    }

    public final void C3(boolean z10) {
        f52839z = z10;
    }

    @Nullable
    public final FeedZoomGuideModel D() {
        if (B0 == null) {
            FeedZoomGuideModel c4 = A0.c();
            if (c4 == null) {
                c4 = new FeedZoomGuideModel(false, 0, 0, 7, null);
            }
            B0 = c4;
        }
        return B0;
    }

    public final boolean D0() {
        return f52821u;
    }

    @NotNull
    public final d<Long> D1() {
        return f52826v0;
    }

    public final void D2(@Nullable SystemPermissionStatusModel systemPermissionStatusModel) {
        N0 = systemPermissionStatusModel;
        M0.d(systemPermissionStatusModel);
    }

    public final void D3(@Nullable Boolean bool) {
        X1 = bool;
        W1.d(bool);
    }

    @NotNull
    public final d<FKExpressAdLocalModel> E() {
        return C0;
    }

    @Nullable
    public final Boolean E0() {
        if (f52750d0 == null) {
            f52750d0 = f52745c0.c();
        }
        return f52750d0;
    }

    @Nullable
    public final Long E1() {
        if (f52769h1 == null) {
            f52769h1 = f52765g1.c();
        }
        return f52769h1;
    }

    public final void E2(int i10) {
        f52775i2 = i10;
        f52770h2.d(Integer.valueOf(i10));
    }

    public final void E3(@Nullable Boolean bool) {
        Q1 = bool;
        P1.d(bool);
    }

    public final int F() {
        return f52795n;
    }

    @NotNull
    public final a<Boolean> F0() {
        return Z;
    }

    @NotNull
    public final d<UserRankModel> F1() {
        return f52800o0;
    }

    public final void F2(@Nullable SearchHideResult searchHideResult) {
        A = searchHideResult;
    }

    public final void F3(@Nullable Boolean bool) {
        S1 = bool;
        R1.d(bool);
    }

    @Nullable
    public final Boolean G() {
        if (z1 == null) {
            z1 = y1.c();
        }
        return z1;
    }

    @NotNull
    public final d<Boolean> G0() {
        return f52755e0;
    }

    @Nullable
    public final String G1() {
        String str = f52792m0;
        if (str == null || str.length() == 0) {
            f52792m0 = f52788l0.c();
        }
        return f52792m0;
    }

    public final void G2(boolean z10) {
        f52739b = z10;
    }

    public final void G3(@Nullable SystemPermissionStatusModel systemPermissionStatusModel) {
        L0 = systemPermissionStatusModel;
        K0.d(systemPermissionStatusModel);
    }

    @Nullable
    public final Boolean H() {
        if (D1 == null) {
            D1 = C1.c();
        }
        return D1;
    }

    public final Boolean H0() {
        if (N == null) {
            N = M.c();
        }
        return N;
    }

    @NotNull
    public final d<Integer> H1() {
        return f52760f1;
    }

    public final void H2(@Nullable String str) {
        B = str;
    }

    public final void H3(@Nullable Boolean bool) {
        I2 = bool;
        H2.d(bool);
    }

    @Nullable
    public final List<ImageModel> I() {
        return f52772i;
    }

    @NotNull
    public final d<PrivacySettingDataResult> I0() {
        return G0;
    }

    @Nullable
    public final Boolean I1() {
        if (L == null) {
            L = K.c();
        }
        return L;
    }

    public final void I2(@Nullable Boolean bool) {
        f52771h3 = bool;
        g3.d(bool);
    }

    public final void I3(@Nullable Boolean bool) {
        P2 = bool;
        O2.d(bool);
    }

    public final boolean J() {
        return f52818t;
    }

    @NotNull
    public final a<Boolean> J0() {
        return f52735a0;
    }

    @Nullable
    public final Boolean J1() {
        if (X2 == null) {
            X2 = W2.c();
        }
        return X2;
    }

    public final void J2(@NotNull VipPurchaseEntranceType vipPurchaseEntranceType) {
        s.i(vipPurchaseEntranceType, "<set-?>");
        f52836y = vipPurchaseEntranceType;
    }

    public final void J3(@Nullable Long l10) {
        f52769h1 = l10;
        f52765g1.d(l10);
    }

    @Nullable
    public final Boolean K() {
        if (O1 == null) {
            O1 = N1.c();
        }
        return O1;
    }

    @Nullable
    public final SystemPermissionStatusModel K0() {
        if (R0 == null) {
            R0 = Q0.c();
        }
        return R0;
    }

    @NotNull
    public final d<Boolean> K1() {
        return f52816s0;
    }

    public final void K2(@Nullable Boolean bool) {
        f52785k2 = bool;
        f52780j2.d(bool);
    }

    public final void K3(@Nullable String str) {
        f52792m0 = str;
        f52788l0.d(str);
    }

    public final int L() {
        return f52754e;
    }

    @Nullable
    public final FKPushTokenModel L0() {
        if (U == null) {
            U = T.c();
        }
        return U;
    }

    @NotNull
    public final a<Boolean> L1() {
        return S;
    }

    public final void L2(@Nullable Boolean bool) {
        M1 = bool;
        L1.d(bool);
    }

    public final boolean L3() {
        EnableButtonsModel enableButtons;
        ConstantsResult q10 = q();
        if ((q10 != null ? q10.getEnableButtons() : null) != null) {
            ConstantsResult q11 = q();
            if (!((q11 == null || (enableButtons = q11.getEnableButtons()) == null || !enableButtons.getShowSuperboost()) ? false : true)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final a<String> M() {
        return H;
    }

    @NotNull
    public final d<Long> M0() {
        return T0;
    }

    public final void M1(boolean z10) {
        c3(Boolean.valueOf(z10));
    }

    public final void M2(@Nullable Boolean bool) {
        K1 = bool;
        J1.d(bool);
    }

    public final boolean M3() {
        EnableButtonsModel enableButtons;
        ConstantsResult q10 = q();
        if ((q10 != null ? q10.getEnableButtons() : null) != null) {
            ConstantsResult q11 = q();
            if (!((q11 == null || (enableButtons = q11.getEnableButtons()) == null || !enableButtons.getShowSuperlike()) ? false : true)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final ItemCardFeaturesItemModel N() {
        String userId;
        Map<String, ItemCardFeaturesItemModel> a10;
        User X3 = X();
        if (X3 != null && (userId = X3.userId()) != null) {
            a<y2.b> aVar = f52798n2;
            y2.b c4 = aVar.c();
            if ((c4 == null || (a10 = c4.a()) == null || !a10.containsKey(userId)) ? false : true) {
                ItemCardFeaturesItemModel itemCardFeaturesItemModel = c4.a().get(userId);
                if ((itemCardFeaturesItemModel != null ? itemCardFeaturesItemModel.getValue() : null) != null) {
                    Integer value = itemCardFeaturesItemModel.getValue();
                    s.f(value);
                    itemCardFeaturesItemModel.setValues(r.e(value));
                    P1(itemCardFeaturesItemModel);
                    c4.a().remove(userId);
                    aVar.d(c4.a().isEmpty() ? null : c4);
                    return itemCardFeaturesItemModel;
                }
            }
            y2.b k02 = k0();
            Map<String, ItemCardFeaturesItemModel> a11 = k02 != null ? k02.a() : null;
            if (a11 != null && a11.containsKey(userId)) {
                return a11.get(userId);
            }
        }
        return null;
    }

    @Nullable
    public final Boolean N0() {
        if (f52762f3 == null) {
            f52762f3 = f52757e3.c();
        }
        return f52762f3;
    }

    public final boolean N1() {
        Long c4 = T0.c();
        return c4 != null && System.currentTimeMillis() - c4.longValue() > 86400000;
    }

    public final void N2(y2.b bVar) {
        f52806p2 = bVar;
        f52802o2.d(bVar);
    }

    @NotNull
    public final d<String> N3(@Nullable String str) {
        return new d<>(new f("StartUpMediaPathKey_" + str, new l()));
    }

    @NotNull
    public final d<Long> O() {
        return f52822u0;
    }

    @Nullable
    public final List<RoleType> O0() {
        String userId;
        RoleType roleType;
        Map<String, RoleType> a10;
        User X3 = X();
        if (X3 != null && (userId = X3.userId()) != null) {
            a<y2.a> aVar = f52810q2;
            y2.a c4 = aVar.c();
            if (((c4 == null || (a10 = c4.a()) == null || !a10.containsKey(userId)) ? false : true) && (roleType = c4.a().get(userId)) != null) {
                List<RoleType> e10 = r.e(roleType);
                Q1(e10);
                c4.a().remove(userId);
                aVar.d(c4.a().isEmpty() ? null : c4);
                return e10;
            }
            y2.c P02 = P0();
            Map<String, List<RoleType>> a11 = P02 != null ? P02.a() : null;
            if (a11 != null && a11.containsKey(userId)) {
                return a11.get(userId);
            }
        }
        return null;
    }

    public final void O1() {
        f52811r = System.currentTimeMillis();
    }

    public final void O2(@Nullable Boolean bool) {
        T2 = bool;
        S2.d(bool);
    }

    public final void O3(int i10) {
        f52749d -= i10;
    }

    @NotNull
    public final d<Boolean> P() {
        return f52812r0;
    }

    public final y2.c P0() {
        if (s2 == null) {
            s2 = f52814r2.c();
        }
        return s2;
    }

    public final void P1(@Nullable ItemCardFeaturesItemModel itemCardFeaturesItemModel) {
        String userId;
        Map<String, ItemCardFeaturesItemModel> a10;
        Map<String, ItemCardFeaturesItemModel> a11;
        User X3 = X();
        if (X3 == null || (userId = X3.userId()) == null) {
            return;
        }
        if (k0() == null) {
            N2(new y2.b(new LinkedHashMap()));
        }
        y2.b k02 = k0();
        if (itemCardFeaturesItemModel == null) {
            if ((k02 == null || (a11 = k02.a()) == null || !a11.containsKey(userId)) ? false : true) {
                k02.a().remove(userId);
            }
        } else if (k02 != null && (a10 = k02.a()) != null) {
            a10.put(userId, itemCardFeaturesItemModel);
        }
        N2(k02);
    }

    public final void P2(@Nullable Boolean bool) {
        R2 = bool;
        Q2.d(bool);
    }

    public final void P3(@NotNull User user) {
        s.i(user, "user");
        f52783k0 = true;
        A2(user);
        g2(null);
        h2(null);
    }

    @NotNull
    public final a<LiveBeautyResourceSaveModel> Q() {
        return f52746c1;
    }

    @Nullable
    public final Boolean Q0() {
        if (L2 == null) {
            L2 = K2.c();
        }
        return L2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q1(@Nullable List<? extends RoleType> list) {
        String userId;
        Map<String, List<RoleType>> a10;
        Map<String, List<RoleType>> a11;
        User X3 = X();
        if (X3 == null || (userId = X3.userId()) == null) {
            return;
        }
        if (P0() == null) {
            g3(new y2.c(new LinkedHashMap()));
        }
        y2.c P02 = P0();
        boolean z10 = false;
        if (list == 0 || list.isEmpty()) {
            if (P02 != null && (a11 = P02.a()) != null && a11.containsKey(userId)) {
                z10 = true;
            }
            if (z10) {
                P02.a().remove(userId);
            }
        } else if (P02 != null && (a10 = P02.a()) != null) {
            a10.put(userId, list);
        }
        g3(P02);
    }

    public final void Q2(@Nullable MultiAccountUserIdsModel multiAccountUserIdsModel) {
        U1 = multiAccountUserIdsModel;
        T1.d(multiAccountUserIdsModel);
    }

    public final boolean Q3() {
        return s.d(H0(), Boolean.FALSE);
    }

    @Nullable
    public final LiveConnectType R() {
        if (G2 == null) {
            G2 = F2.c();
        }
        return G2;
    }

    @Nullable
    public final Boolean R0() {
        if (f52830w1 == null) {
            f52830w1 = f52827v1.c();
        }
        return f52830w1;
    }

    public final void R1(@Nullable Boolean bool) {
        Q = bool;
        P.d(bool);
    }

    public final void R2(boolean z10) {
        f52807q = z10;
    }

    @NotNull
    public final a<FKLiveBeautyEditCacheModel> S() {
        return J0;
    }

    @Nullable
    public final Boolean S0() {
        if (I1 == null) {
            I1 = H1.c();
        }
        return I1;
    }

    public final void S1(@NotNull CountDataModel model) {
        s.i(model, "model");
        f52754e = model.getInboxNewMatchCount();
        f52749d = model.getMessageCount();
        f52777j = model.getNotifyAlohaCount() + model.getNotifyPostLikeCount() + model.getNotifyWithoutAlohaPostLikeCount();
        f52818t = model.getNewFeed();
        f52821u = model.getNoviceTask();
        f52782k = model.getNotifyAlohaCount();
        f52787l = model.getNotifyPostLikeCount();
        f52791m = model.getNotifyWithoutAlohaPostLikeCount();
    }

    public final void S2(@Nullable Boolean bool) {
        F0 = bool;
        E0.d(bool);
    }

    public final boolean T() {
        return f52796n0;
    }

    @Nullable
    public final Boolean T0() {
        if (f52794m2 == null) {
            f52794m2 = f52790l2.c();
        }
        return f52794m2;
    }

    public final void T1(@Nullable Boolean bool) {
        L = bool;
        K.d(bool);
    }

    public final void T2(int i10) {
        f52758f = i10;
    }

    @NotNull
    public final d<LivePopupWindowSettingModel> U() {
        return U0;
    }

    @Nullable
    public final Boolean U0() {
        if (f52752d2 == null) {
            f52752d2 = f52747c2.c();
        }
        return f52752d2;
    }

    public final void U1(@Nullable String str) {
        J = str;
        I.d(str);
    }

    public final void U2(boolean z10) {
        f52832x = z10;
    }

    @Nullable
    public final String V() {
        return f52767h;
    }

    @Nullable
    public final StayGuideShowTimeModel V0() {
        if (f52753d3 == null) {
            f52753d3 = f52748c3.c();
        }
        return f52753d3;
    }

    public final void V1(@Nullable Integer num) {
        f52828w = num;
    }

    public final void V2(@Nullable Triple<Boolean, CheckNonageModel, String> triple) {
        f52744c = triple;
    }

    public final boolean W() {
        return f52763g;
    }

    @Nullable
    public final Boolean W0() {
        if (f52813r1 == null) {
            f52813r1 = f52809q1.c();
        }
        return f52813r1;
    }

    public final void W1(long j10) {
        f52803p = j10;
    }

    public final void W2(int i10) {
        f52782k = i10;
    }

    @Nullable
    public final User X() {
        if (f52778j0 == null) {
            f52778j0 = f52773i0.c();
        }
        return f52778j0;
    }

    @Nullable
    public final Boolean X0() {
        if (f52743b3 == null) {
            f52743b3 = f52738a3.c();
        }
        return f52743b3;
    }

    public final void X1(int i10) {
        f52749d = i10;
    }

    public final void X2(int i10) {
        f52777j = i10;
    }

    @Nullable
    public final SystemPermissionStatusModel Y() {
        if (P0 == null) {
            P0 = O0.c();
        }
        return P0;
    }

    @Nullable
    public final Boolean Y0() {
        if (N2 == null) {
            N2 = M2.c();
        }
        return N2;
    }

    public final void Y1(boolean z10) {
        Y = z10;
    }

    public final void Y2(int i10) {
        f52787l = i10;
    }

    @Nullable
    public final SystemPermissionStatusModel Z() {
        if (N0 == null) {
            N0 = M0.c();
        }
        return N0;
    }

    @NotNull
    public final d<Boolean> Z0() {
        return W0;
    }

    public final void Z1(int i10) {
        f52799o = i10;
    }

    public final void Z2(int i10) {
        f52791m = i10;
    }

    public final void a(@Nullable String str) {
        EnableButtonsModel enableButtons;
        if (s.d(str, ActivationType.SuperLike.getValue())) {
            ConstantsResult q10 = q();
            enableButtons = q10 != null ? q10.getEnableButtons() : null;
            if (enableButtons == null) {
                return;
            }
            enableButtons.setShowSuperlike(true);
            return;
        }
        if (s.d(str, ActivationType.SuperBoost.getValue())) {
            ConstantsResult q11 = q();
            enableButtons = q11 != null ? q11.getEnableButtons() : null;
            if (enableButtons == null) {
                return;
            }
            enableButtons.setShowSuperboost(true);
            return;
        }
        f3(Boolean.FALSE);
    }

    public final int a0() {
        if (f52775i2 <= 0) {
            a<Integer> aVar = f52770h2;
            Integer c4 = aVar.c();
            if (c4 != null && c4.intValue() > 0) {
                f52775i2 = c4.intValue();
            } else {
                int k10 = (z0.h.k(this) / 5) * 2;
                f52775i2 = k10;
                aVar.d(Integer.valueOf(k10));
            }
        }
        return f52775i2;
    }

    @NotNull
    public final d<Boolean> a1() {
        return Z0;
    }

    public final void a2(@Nullable Boolean bool) {
        B1 = bool;
        A1.d(bool);
    }

    public final void a3(boolean z10) {
        f52821u = z10;
    }

    public final boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = f52811r;
        return currentTimeMillis - j10 > f52815s || j10 == 0;
    }

    @Nullable
    public final SearchHideResult b0() {
        return A;
    }

    @NotNull
    public final d<Boolean> b1() {
        return X0;
    }

    public final void b2(@Nullable ConstantsResult constantsResult) {
        f52768h0 = constantsResult;
        f52764g0.d(constantsResult);
    }

    public final void b3(@Nullable Boolean bool) {
        f52750d0 = bool;
        f52745c0.d(bool);
    }

    public final void c() {
        f52811r = 0L;
    }

    public final boolean c0() {
        return f52739b;
    }

    @NotNull
    public final d<Boolean> c1() {
        return Y0;
    }

    public final void c2(@Nullable CoordinateModel coordinateModel) {
        V2 = coordinateModel;
        U2.d(coordinateModel);
    }

    public final void c3(Boolean bool) {
        N = bool;
        M.d(bool);
    }

    @Nullable
    public final Boolean d() {
        if (Q == null) {
            Q = P.c();
        }
        return Q;
    }

    @NotNull
    public final d<Boolean> d0() {
        return f52786k3;
    }

    @NotNull
    public final d<Boolean> d1() {
        return f52819t0;
    }

    public final void d2(@Nullable Boolean bool) {
        Z1 = bool;
        Y1.d(bool);
    }

    public final void d3(@Nullable SystemPermissionStatusModel systemPermissionStatusModel) {
        R0 = systemPermissionStatusModel;
        Q0.d(systemPermissionStatusModel);
    }

    @NotNull
    public final d<BaseUrlModel> e() {
        return f52759f0;
    }

    @Nullable
    public final String e0() {
        return B;
    }

    @Nullable
    public final Boolean e1() {
        if (f52805p1 == null) {
            f52805p1 = f52801o1.c();
        }
        return f52805p1;
    }

    public final void e2(boolean z10) {
        f52825v = z10;
    }

    public final void e3(@Nullable FKPushTokenModel fKPushTokenModel) {
        U = fKPushTokenModel;
        T.d(fKPushTokenModel);
    }

    @NotNull
    public final a<String> f() {
        return I0;
    }

    @Nullable
    public final Boolean f0() {
        if (f52771h3 == null) {
            f52771h3 = g3.c();
        }
        return f52771h3;
    }

    @Nullable
    public final Boolean f1() {
        if (f52797n1 == null) {
            f52797n1 = f52793m1.c();
        }
        return f52797n1;
    }

    public final void f2(@Nullable Integer num) {
        f52742b2 = num;
        f52737a2.d(num);
    }

    public final void f3(@Nullable Boolean bool) {
        f52762f3 = bool;
        f52757e3.d(bool);
    }

    @Nullable
    public final String g() {
        String str = J;
        if (str == null || str.length() == 0) {
            J = I.c();
        }
        return J;
    }

    @NotNull
    public final VipPurchaseEntranceType g0() {
        return f52836y;
    }

    @Nullable
    public final Boolean g1() {
        if (f52831w2 == null) {
            f52831w2 = v2.c();
        }
        return f52831w2;
    }

    public final void g2(@Nullable Boolean bool) {
        F = bool;
        E.d(bool);
    }

    public final void g3(y2.c cVar) {
        s2 = cVar;
        f52814r2.d(cVar);
    }

    @NotNull
    public final a<Boolean> h() {
        return f52740b0;
    }

    @Nullable
    public final Boolean h0() {
        if (f52785k2 == null) {
            f52785k2 = f52780j2.c();
        }
        return f52785k2;
    }

    @Nullable
    public final Boolean h1() {
        if (C2 == null) {
            C2 = B2.c();
        }
        return C2;
    }

    public final void h2(@Nullable FeedSort feedSort) {
        D = feedSort;
        C.d(feedSort);
    }

    public final void h3(@Nullable Boolean bool) {
        L2 = bool;
        K2.d(bool);
    }

    @Nullable
    public final Integer i() {
        return f52828w;
    }

    @Nullable
    public final Boolean i0() {
        if (M1 == null) {
            M1 = L1.c();
        }
        return M1;
    }

    @Nullable
    public final Boolean i1() {
        if (E2 == null) {
            E2 = D2.c();
        }
        return E2;
    }

    public final void i2(@Nullable Boolean bool) {
        f52833x0 = bool;
        f52829w0.d(bool);
    }

    public final void i3(@Nullable Boolean bool) {
        f52830w1 = bool;
        f52827v1.d(bool);
    }

    public final long j() {
        return f52803p;
    }

    @Nullable
    public final Boolean j0() {
        if (K1 == null) {
            K1 = J1.c();
        }
        return K1;
    }

    @Nullable
    public final Boolean j1() {
        if (A2 == null) {
            A2 = f52841z2.c();
        }
        return A2;
    }

    public final void j2(@Nullable FeedPostLimitGuideModel feedPostLimitGuideModel) {
        f52838y2 = feedPostLimitGuideModel;
        f52835x2.d(feedPostLimitGuideModel);
    }

    public final void j3(@Nullable Boolean bool) {
        I1 = bool;
        H1.d(bool);
    }

    public final int k() {
        return f52749d;
    }

    public final y2.b k0() {
        if (f52806p2 == null) {
            f52806p2 = f52802o2.c();
        }
        return f52806p2;
    }

    @Nullable
    public final Boolean k1() {
        if (f52824u2 == null) {
            f52824u2 = t2.c();
        }
        return f52824u2;
    }

    public final void k2(@Nullable FeedPraiseGuideModel feedPraiseGuideModel) {
        f52840z0 = feedPraiseGuideModel;
        f52837y0.d(feedPraiseGuideModel);
    }

    public final void k3(@Nullable Boolean bool) {
        f52794m2 = bool;
        f52790l2.d(bool);
    }

    public final boolean l() {
        return Y;
    }

    @NotNull
    public final d<MatchSettingResult> l0() {
        return D0;
    }

    @NotNull
    public final d<Boolean> l1() {
        return f52736a1;
    }

    public final void l2(@Nullable Boolean bool) {
        f52781j3 = bool;
        f52776i3.d(bool);
    }

    public final void l3(@Nullable Boolean bool) {
        f52752d2 = bool;
        f52747c2.d(bool);
    }

    @NotNull
    public final d<String> m() {
        return f52741b1;
    }

    @Nullable
    public final Boolean m0() {
        if (T2 == null) {
            T2 = S2.c();
        }
        return T2;
    }

    @Nullable
    public final Boolean m1() {
        if (f52789l1 == null) {
            f52789l1 = f52784k1.c();
        }
        return f52789l1;
    }

    public final void m2(@Nullable Boolean bool) {
        F1 = bool;
        E1.d(bool);
    }

    public final void m3(@Nullable StayGuideShowTimeModel stayGuideShowTimeModel) {
        f52753d3 = stayGuideShowTimeModel;
        f52748c3.d(stayGuideShowTimeModel);
    }

    public final int n() {
        return f52799o;
    }

    @Nullable
    public final Boolean n0() {
        if (R2 == null) {
            R2 = Q2.c();
        }
        return R2;
    }

    @Nullable
    public final Boolean n1() {
        if (Z2 == null) {
            Z2 = Y2.c();
        }
        return Z2;
    }

    public final void n2(@Nullable FeedZoomGuideModel feedZoomGuideModel) {
        B0 = feedZoomGuideModel;
        A0.d(feedZoomGuideModel);
    }

    public final void n3(@Nullable Boolean bool) {
        f52813r1 = bool;
        f52809q1.d(bool);
    }

    @Nullable
    public final Boolean o() {
        if (B1 == null) {
            B1 = A1.c();
        }
        return B1;
    }

    @NotNull
    public final d<Boolean> o0() {
        return f52808q0;
    }

    @NotNull
    public final a<Boolean> o1() {
        return G1;
    }

    public final void o2(@Nullable Boolean bool) {
        X2 = bool;
        W2.d(bool);
    }

    public final void o3(@Nullable Boolean bool) {
        f52743b3 = bool;
        f52738a3.d(bool);
    }

    @NotNull
    public final d<Long> p() {
        return f52834x1;
    }

    @Nullable
    public final MultiAccountUserIdsModel p0() {
        if (U1 == null) {
            a<MultiAccountUserIdsModel> aVar = T1;
            MultiAccountUserIdsModel c4 = aVar.c();
            if (c4 == null) {
                User X3 = X();
                String userId = X3 != null ? X3.userId() : null;
                if (!(userId == null || userId.length() == 0)) {
                    MultiAccountUserIdsModel multiAccountUserIdsModel = new MultiAccountUserIdsModel(kotlin.collections.s.o(userId));
                    aVar.d(multiAccountUserIdsModel);
                    U1 = multiAccountUserIdsModel;
                }
            } else {
                U1 = c4;
            }
        }
        return U1;
    }

    @Nullable
    public final Boolean p1() {
        if (f52820t1 == null) {
            f52820t1 = f52817s1.c();
        }
        return f52820t1;
    }

    public final void p2(int i10) {
        f52795n = i10;
    }

    public final void p3(@Nullable Boolean bool) {
        N2 = bool;
        M2.d(bool);
    }

    @Nullable
    public final ConstantsResult q() {
        if (f52768h0 == null) {
            f52768h0 = f52764g0.c();
        }
        return f52768h0;
    }

    public final boolean q0() {
        return f52807q;
    }

    @Nullable
    public final Boolean q1() {
        if (f52779j1 == null) {
            f52779j1 = f52774i1.c();
        }
        return f52779j1;
    }

    public final void q2(@Nullable Boolean bool) {
        z1 = bool;
        y1.d(bool);
    }

    public final void q3(@Nullable Boolean bool) {
        f52805p1 = bool;
        f52801o1.d(bool);
    }

    @Nullable
    public final CoordinateModel r() {
        if (V2 == null) {
            V2 = U2.c();
        }
        return V2;
    }

    @Nullable
    public final Boolean r0() {
        if (F0 == null) {
            F0 = E0.c();
        }
        return F0;
    }

    @Nullable
    public final Boolean r1() {
        if (f52761f2 == null) {
            f52761f2 = e2.c();
        }
        return f52761f2;
    }

    public final void r2(@Nullable Boolean bool) {
        D1 = bool;
        C1.d(bool);
    }

    public final void r3(@Nullable Boolean bool) {
        f52797n1 = bool;
        f52793m1.d(bool);
    }

    @Nullable
    public final Boolean s() {
        if (Z1 == null) {
            Z1 = Y1.c();
        }
        return Z1;
    }

    @NotNull
    public final a<Boolean> s0() {
        return R;
    }

    public final boolean s1() {
        return f52839z;
    }

    public final void s2(@Nullable List<ImageModel> list) {
        f52772i = list;
    }

    public final void s3(@Nullable Boolean bool) {
        f52831w2 = bool;
        v2.d(bool);
    }

    public final boolean t() {
        return f52825v;
    }

    public final int t0() {
        return f52758f;
    }

    @Nullable
    public final Boolean t1() {
        if (X1 == null) {
            X1 = W1.c();
        }
        return X1;
    }

    public final void t2(boolean z10) {
        f52818t = z10;
    }

    public final void t3(@Nullable Boolean bool) {
        C2 = bool;
        B2.d(bool);
    }

    @Nullable
    public final Integer u() {
        if (f52742b2 == null) {
            f52742b2 = f52737a2.c();
        }
        return f52742b2;
    }

    @NotNull
    public final a<Boolean> u0() {
        return X;
    }

    @NotNull
    public final d<SharePlatform> u1() {
        return S0;
    }

    public final void u2(@Nullable Boolean bool) {
        O1 = bool;
        N1.d(bool);
    }

    public final void u3(@Nullable Boolean bool) {
        E2 = bool;
        D2.d(bool);
    }

    @NotNull
    public final d<Integer> v() {
        return V0;
    }

    @NotNull
    public final d<NewPushSettingResult> v0() {
        return H0;
    }

    @Nullable
    public final Boolean v1() {
        if (Q1 == null) {
            Q1 = P1.c();
        }
        return Q1;
    }

    public final void v2(int i10) {
        f52754e = i10;
    }

    public final void v3(@Nullable Boolean bool) {
        A2 = bool;
        f52841z2.d(bool);
    }

    @Nullable
    public final Boolean w() {
        if (F == null) {
            F = E.c();
        }
        return F;
    }

    @NotNull
    public final d<Boolean> w0() {
        return f52804p0;
    }

    @Nullable
    public final Boolean w1() {
        if (S1 == null) {
            S1 = R1.c();
        }
        return S1;
    }

    public final void w2(@Nullable LiveConnectType liveConnectType) {
        G2 = liveConnectType;
        F2.d(liveConnectType);
    }

    public final void w3(@Nullable Boolean bool) {
        f52824u2 = bool;
        t2.d(bool);
    }

    @Nullable
    public final FeedSort x() {
        if (D == null) {
            D = C.c();
        }
        return D;
    }

    public final boolean x0() {
        return f52832x;
    }

    @Nullable
    public final SystemPermissionStatusModel x1() {
        if (L0 == null) {
            L0 = K0.c();
        }
        return L0;
    }

    public final void x2(boolean z10) {
        f52796n0 = z10;
    }

    public final void x3(@Nullable Boolean bool) {
        f52789l1 = bool;
        f52784k1.d(bool);
    }

    @Nullable
    public final Boolean y() {
        if (f52833x0 == null) {
            f52833x0 = f52829w0.c();
        }
        return f52833x0;
    }

    @Nullable
    public final Triple<Boolean, CheckNonageModel, String> y0() {
        return f52744c;
    }

    @NotNull
    public final a<Boolean> y1() {
        return V;
    }

    public final void y2(@Nullable String str) {
        f52767h = str;
    }

    public final void y3(@Nullable Boolean bool) {
        Z2 = bool;
        Y2.d(bool);
    }

    @Nullable
    public final FeedPostLimitGuideModel z() {
        if (f52838y2 == null) {
            FeedPostLimitGuideModel c4 = f52835x2.c();
            if (c4 == null) {
                c4 = new FeedPostLimitGuideModel(false, 0 == true ? 1 : 0, 3, null);
            }
            f52838y2 = c4;
        }
        return f52838y2;
    }

    public final int z0() {
        return f52782k;
    }

    @NotNull
    public final a<Boolean> z1() {
        return W;
    }

    public final void z2(boolean z10) {
        f52763g = z10;
    }

    public final void z3(@Nullable Boolean bool) {
        f52820t1 = bool;
        f52817s1.d(bool);
    }
}
