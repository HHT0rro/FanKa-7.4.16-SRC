package com.cupidapp.live.profile.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.ScrollControlStaggeredGridLayoutManager;
import com.cupidapp.live.base.view.decoration.ProfileGridDecoration;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.chat.model.SerializableContext;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.club.fragment.ClubListDialogFragment;
import com.cupidapp.live.feed.activity.FeedDetailListActivity;
import com.cupidapp.live.feed.layout.FeedTopBottomDialog;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.match.view.FKClickAnimationLayout;
import com.cupidapp.live.mediapicker.activity.MediaPickerActivity;
import com.cupidapp.live.mediapicker.event.FeedPublishSuccessEvent;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.MediaPickerActivityModel;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.profile.adapter.UserProfileAdapter;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.holder.FKProfileStoryLabelModel;
import com.cupidapp.live.profile.holder.ProfileBlackListTipsViewModel;
import com.cupidapp.live.profile.holder.ProfileFriendPraiseModel;
import com.cupidapp.live.profile.holder.ProfileHeaderViewHolder;
import com.cupidapp.live.profile.holder.ProfileHeaderViewModel;
import com.cupidapp.live.profile.holder.ProfileLiveStatusViewHolder;
import com.cupidapp.live.profile.holder.ProfileLiveStatusViewModel;
import com.cupidapp.live.profile.holder.ProfilePostCountTitleViewModel;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.FriendPraiseBundleData;
import com.cupidapp.live.profile.model.LookOtherPraiseBundleData;
import com.cupidapp.live.profile.model.SceneType;
import com.cupidapp.live.profile.model.SuperLikeGuideResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.profile.view.FriendPraiseEditLayout;
import com.cupidapp.live.setting.activity.EditUserInfoActivity;
import com.cupidapp.live.setting.activity.FKStoryLabelDetailActivity;
import com.cupidapp.live.setting.fragment.StoryLabelFollowEvent;
import com.cupidapp.live.superlike.helper.CancelAttentionHelper;
import com.cupidapp.live.superlike.helper.SuperLikeClickHelper;
import com.cupidapp.live.superlike.view.SuperLikeDeliveryAnimLayout;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.track.group.BtnActionType;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.cupidapp.live.voiceparty.activity.VoicePartyActivity;
import com.huawei.openalliance.ad.constant.ad;
import f2.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: UserProfileActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserProfileActivity extends FKBaseActivity {

    @NotNull
    public static final a G = new a(null);

    @Nullable
    public ObjectAnimator D;

    @Nullable
    public ObjectAnimator E;

    /* renamed from: q */
    public User f17677q;

    /* renamed from: r */
    public ProfileSensorContext f17678r;

    /* renamed from: t */
    public boolean f17680t;

    /* renamed from: u */
    @Nullable
    public LiveShowModel f17681u;

    /* renamed from: v */
    @Nullable
    public String f17682v;

    /* renamed from: w */
    @Nullable
    public String f17683w;

    /* renamed from: y */
    public int f17685y;

    /* renamed from: z */
    @Nullable
    public com.cupidapp.live.base.utils.o f17686z;

    @NotNull
    public Map<Integer, View> F = new LinkedHashMap();

    /* renamed from: s */
    @NotNull
    public final Lazy f17679s = kotlin.c.b(new Function0<Map<String, ? extends Object>>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$recommendContext$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Map<String, ? extends Object> invoke() {
            Intent intent = UserProfileActivity.this.getIntent();
            kotlin.jvm.internal.s.h(intent, "intent");
            SerializableContext serializableContext = (SerializableContext) z0.g.a(intent, SerializableContext.class);
            if (serializableContext != null) {
                return serializableContext.getMap();
            }
            return null;
        }
    });

    /* renamed from: x */
    @NotNull
    public final Lazy f17684x = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final UserProfileActivity userProfileActivity = UserProfileActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$loadMoreListener$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String str2;
                    str = UserProfileActivity.this.f17682v;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    UserProfileActivity userProfileActivity2 = UserProfileActivity.this;
                    str2 = userProfileActivity2.f17682v;
                    userProfileActivity2.E2(str2);
                }
            });
        }
    });

    @NotNull
    public final Lazy A = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$isUsingMap$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Intent intent = UserProfileActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("isUsingMap", false) : false);
        }
    });

    @NotNull
    public final Lazy B = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(UserProfileActivity.this);
        }
    });

    @NotNull
    public final Lazy C = kotlin.c.b(new Function0<UserProfileAdapter>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final UserProfileAdapter invoke() {
            Lifecycle lifecycle = UserProfileActivity.this.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            UserProfileAdapter userProfileAdapter = new UserProfileAdapter(lifecycle);
            final UserProfileActivity userProfileActivity = UserProfileActivity.this;
            userProfileAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    ProfileSensorContext profileSensorContext;
                    ProfileSensorContext profileSensorContext2;
                    ProfileSensorContext profileSensorContext3;
                    if (obj instanceof FeedModel) {
                        UserProfileActivity.this.N2((FeedModel) obj);
                    }
                    if (obj instanceof FKProfileStoryLabelModel) {
                        FKProfileStoryLabelModel fKProfileStoryLabelModel = (FKProfileStoryLabelModel) obj;
                        List<FKStoryLabelItemModel> storyLabelList = fKProfileStoryLabelModel.getUser().getStoryLabelList();
                        if ((storyLabelList != null ? storyLabelList.size() : 0) > 1) {
                            FKStoryLabelDetailActivity.a aVar = FKStoryLabelDetailActivity.f17960r;
                            UserProfileActivity userProfileActivity2 = UserProfileActivity.this;
                            SensorPosition sensorPosition = SensorPosition.Profile;
                            profileSensorContext = userProfileActivity2.f17678r;
                            ProfileSensorContext profileSensorContext4 = null;
                            if (profileSensorContext == null) {
                                kotlin.jvm.internal.s.A("sensorContext");
                                profileSensorContext = null;
                            }
                            SensorPosition position = profileSensorContext.getPosition();
                            profileSensorContext2 = UserProfileActivity.this.f17678r;
                            if (profileSensorContext2 == null) {
                                kotlin.jvm.internal.s.A("sensorContext");
                                profileSensorContext2 = null;
                            }
                            SensorPosition source = profileSensorContext2.getSource();
                            profileSensorContext3 = UserProfileActivity.this.f17678r;
                            if (profileSensorContext3 == null) {
                                kotlin.jvm.internal.s.A("sensorContext");
                            } else {
                                profileSensorContext4 = profileSensorContext3;
                            }
                            aVar.a(userProfileActivity2, fKProfileStoryLabelModel, new FKSensorContext(sensorPosition, position, source, profileSensorContext4.getScene()));
                        }
                        GroupSocialLog.f18708a.L();
                    }
                    if (obj instanceof ProfileLiveStatusViewModel) {
                        UserProfileActivity.this.m2();
                    }
                }
            });
            userProfileAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.followImageView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof ProfileHeaderViewModel) {
                        User user = UserProfileActivity.this.f17677q;
                        if (user == null) {
                            kotlin.jvm.internal.s.A(UserData.NAME);
                            user = null;
                        }
                        if (user.getAloha()) {
                            UserProfileActivity.this.g2(i10);
                        } else {
                            UserProfileActivity.this.p2(((ProfileHeaderViewModel) obj).getUser(), i10);
                        }
                        UserProfileActivity.this.O2();
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.highRiskLearnMoreTextView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, UserProfileActivity.this, NetworkClient.f11868a.O() + "/doc/antifraud-tips", null, 4, null);
                }
            }), kotlin.f.a(Integer.valueOf(R$id.messageImageView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof ProfileHeaderViewModel) {
                        UserProfileActivity.this.L2(false);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.editMyProfileImageView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof ProfileHeaderViewModel) {
                        EditUserInfoActivity.a.b(EditUserInfoActivity.f17947y, UserProfileActivity.this, null, false, 6, null);
                        SensorsLogKeyButtonClick.Profile.EditInformation.click();
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.removeBlackListTextView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$6
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof ProfileBlackListTipsViewModel) {
                        UserProfileActivity.this.R2();
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.profile_label_chat_image), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$7
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof FKProfileStoryLabelModel) {
                        UserProfileActivity.this.L2(true);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.profile_friend_praise_bg), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$8
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof ProfileFriendPraiseModel) {
                        UserProfileActivity.this.M2((ProfileFriendPraiseModel) obj);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.profile_club_entrance_imageview), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$9
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    if (obj instanceof ProfileHeaderViewModel) {
                        ClubListDialogFragment.a aVar = ClubListDialogFragment.f13571h;
                        FragmentManager supportFragmentManager = UserProfileActivity.this.getSupportFragmentManager();
                        kotlin.jvm.internal.s.h(supportFragmentManager, "supportFragmentManager");
                        ProfileHeaderViewModel profileHeaderViewModel = (ProfileHeaderViewModel) obj;
                        String userId = profileHeaderViewModel.getUser().userId();
                        String name = profileHeaderViewModel.getUser().getName();
                        if (name == null) {
                            name = "";
                        }
                        aVar.a(supportFragmentManager, userId, name);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.post_top_tag), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$userProfileAdapter$2$1$10
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                    invoke(obj, num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(@Nullable Object obj, int i10) {
                    com.cupidapp.live.profile.logic.c cVar = com.cupidapp.live.profile.logic.c.f17839a;
                    User user = UserProfileActivity.this.f17677q;
                    if (user == null) {
                        kotlin.jvm.internal.s.A(UserData.NAME);
                        user = null;
                    }
                    if (cVar.a(user.userId())) {
                        return;
                    }
                    FeedTopBottomDialog.f14489f.a(UserProfileActivity.this).e(UserProfileActivity.this.Q0()).f();
                }
            })));
            return userProfileAdapter;
        }
    });

    /* compiled from: UserProfileActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, User user, ProfileSensorContext profileSensorContext, boolean z10, Map map, BtnActionType btnActionType, String str, boolean z11, int i10, Object obj) {
            aVar.a(context, user, profileSensorContext, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? null : map, (i10 & 32) != 0 ? null : btnActionType, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? false : z11);
        }

        public final void a(@Nullable Context context, @Nullable User user, @NotNull ProfileSensorContext sensorContext, boolean z10, @Nullable Map<String, ? extends Object> map, @Nullable BtnActionType btnActionType, @Nullable String str, boolean z11) {
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            if (context == null || user == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) UserProfileActivity.class);
            z0.g.c(intent, user);
            intent.putExtra("CARE_USER_DATA_CHANGE_KEY", z10);
            intent.putExtra("statisticsSource", str);
            z0.g.c(intent, sensorContext);
            if (map != null) {
                z0.g.c(intent, new SerializableContext(map));
            }
            if (btnActionType != null) {
                intent.putExtra("btn_name", btnActionType);
            }
            intent.putExtra("isUsingMap", z11);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: UserProfileActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements o.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.Profile;
            User user = UserProfileActivity.this.f17677q;
            if (user == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
                user = null;
            }
            kVar.a(sensorPosition, "HOMEPAGE", user.userId(), j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            kotlin.jvm.internal.s.i(imageUriString, "imageUriString");
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.Profile;
            User user = UserProfileActivity.this.f17677q;
            if (user == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
                user = null;
            }
            kVar.c(sensorPosition, "HOMEPAGE", user.userId(), z10);
        }
    }

    /* compiled from: UserProfileActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            ObjectAnimator objectAnimator = UserProfileActivity.this.E;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            ((TextView) UserProfileActivity.this.n1(R$id.swipe_down_see_more)).setVisibility(0);
        }
    }

    /* compiled from: UserProfileActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            ((TextView) UserProfileActivity.this.n1(R$id.swipe_down_see_more)).setVisibility(8);
        }
    }

    public static final void B2(UserProfileActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Iterator<Object> iterator2 = this$0.v2().j().iterator2();
        final int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (iterator2.next() instanceof ProfileHeaderViewModel) {
                break;
            } else {
                i10++;
            }
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) this$0.n1(R$id.userProfileRecyclerView)).findViewHolderForLayoutPosition(i10);
        ProfileHeaderViewHolder profileHeaderViewHolder = findViewHolderForLayoutPosition instanceof ProfileHeaderViewHolder ? (ProfileHeaderViewHolder) findViewHolderForLayoutPosition : null;
        if (profileHeaderViewHolder != null) {
            SuperLikeClickHelper superLikeClickHelper = SuperLikeClickHelper.f18616a;
            Lifecycle lifecycle = this$0.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            SensorPosition Q0 = this$0.Q0();
            FKClickAnimationLayout fKClickAnimationLayout = (FKClickAnimationLayout) profileHeaderViewHolder.itemView.findViewById(R$id.profile_super_liked_by_me_btn_fl);
            kotlin.jvm.internal.s.h(fKClickAnimationLayout, "viewHolder.itemView.prof…_super_liked_by_me_btn_fl");
            SuperLikeDeliveryAnimLayout superlikeDelivery = (SuperLikeDeliveryAnimLayout) this$0.n1(R$id.superlikeDelivery);
            kotlin.jvm.internal.s.h(superlikeDelivery, "superlikeDelivery");
            superLikeClickHelper.g(this$0, lifecycle, Q0, fKClickAnimationLayout, superlikeDelivery, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initSuperLikeClick$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.cupidapp.live.base.utils.j.f12332a.a("FKClickAnimationClick listener", "stopScroll");
                    UserProfileActivity userProfileActivity = UserProfileActivity.this;
                    int i11 = R$id.userProfileRecyclerView;
                    RecyclerView.LayoutManager layoutManager = ((RecyclerView) userProfileActivity.n1(i11)).getLayoutManager();
                    kotlin.jvm.internal.s.g(layoutManager, "null cannot be cast to non-null type com.cupidapp.live.base.view.ScrollControlStaggeredGridLayoutManager");
                    ((ScrollControlStaggeredGridLayoutManager) layoutManager).a(false);
                    ((RecyclerView) UserProfileActivity.this.n1(i11)).stopScroll();
                }
            }, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initSuperLikeClick$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                    invoke(num.intValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(int i11) {
                    com.cupidapp.live.base.utils.j.f12332a.a("FKClickAnimationClick listener", "RE :" + i11);
                    RecyclerView.LayoutManager layoutManager = ((RecyclerView) UserProfileActivity.this.n1(R$id.userProfileRecyclerView)).getLayoutManager();
                    kotlin.jvm.internal.s.g(layoutManager, "null cannot be cast to non-null type com.cupidapp.live.base.view.ScrollControlStaggeredGridLayoutManager");
                    ((ScrollControlStaggeredGridLayoutManager) layoutManager).a(true);
                    UserProfileActivity userProfileActivity = UserProfileActivity.this;
                    User user = userProfileActivity.f17677q;
                    if (user == null) {
                        kotlin.jvm.internal.s.A(UserData.NAME);
                        user = null;
                    }
                    userProfileActivity.a3(user, i11, i10);
                }
            });
        }
    }

    public static /* synthetic */ void F2(UserProfileActivity userProfileActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        userProfileActivity.E2(str);
    }

    public static final Triple H2(SuperLikeGuideResult t12, ProfileResult t2, ListResult t32) {
        kotlin.jvm.internal.s.i(t12, "t1");
        kotlin.jvm.internal.s.i(t2, "t2");
        kotlin.jvm.internal.s.i(t32, "t3");
        return new Triple(t12, t2, t32);
    }

    public static final void I2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void f2(UserProfileActivity userProfileActivity, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        userProfileActivity.e2(num);
    }

    public final void A2() {
        ((RecyclerView) n1(R$id.userProfileRecyclerView)).postDelayed(new Runnable() { // from class: com.cupidapp.live.profile.activity.y
            @Override // java.lang.Runnable
            public final void run() {
                UserProfileActivity.B2(UserProfileActivity.this);
            }
        }, 500L);
    }

    public final void C2() {
        RecyclerView initView$lambda$4 = (RecyclerView) n1(R$id.userProfileRecyclerView);
        initView$lambda$4.setLayoutManager(new ScrollControlStaggeredGridLayoutManager(v2().v(), 1));
        initView$lambda$4.setAdapter(v2());
        UserProfileAdapter v2 = v2();
        kotlin.jvm.internal.s.h(initView$lambda$4, "initView$lambda$4");
        initView$lambda$4.addItemDecoration(new ProfileGridDecoration(v2, z0.h.c(initView$lambda$4, 2.0f)));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$4.getItemAnimator();
        User user = null;
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        initView$lambda$4.addOnScrollListener(s2());
        s2().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
                int i12;
                int i13;
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                SuperLikeClickHelper.f18616a.f((SuperLikeDeliveryAnimLayout) UserProfileActivity.this.n1(R$id.superlikeDelivery));
                UserProfileActivity userProfileActivity = UserProfileActivity.this;
                i12 = userProfileActivity.f17685y;
                userProfileActivity.f17685y = i12 + i11;
                i13 = UserProfileActivity.this.f17685y;
                if (i13 > 100) {
                    ((FKTitleBarLayout) UserProfileActivity.this.n1(R$id.userProfileTitleLayout)).setSingleTitleVisible(true);
                    UserProfileActivity.this.l2();
                } else {
                    FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) UserProfileActivity.this.n1(R$id.userProfileTitleLayout);
                    fKTitleBarLayout.setSingleTitleVisible(false);
                    fKTitleBarLayout.setRightTextViewVisible(false);
                }
            }
        });
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) n1(R$id.userProfileTitleLayout);
        User user2 = this.f17677q;
        if (user2 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user2 = null;
        }
        fKTitleBarLayout.setSingleTitle(user2.getName(), 12);
        k2();
        fKTitleBarLayout.setSingleTitleVisible(false);
        fKTitleBarLayout.setRightTextViewVisible(false);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initView$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                UserProfileActivity.this.onBackPressed();
            }
        });
        fKTitleBarLayout.setRightImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initView$2$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                UserProfileActivity.this.V2();
            }
        });
        int i10 = R$id.profilePublishButton;
        TextView textView = (TextView) n1(i10);
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user = user3;
        }
        textView.setVisibility(user.getMe() ? 0 : 8);
        ((TextView) n1(i10)).getPaint().setFakeBoldText(true);
        TextView profilePublishButton = (TextView) n1(i10);
        kotlin.jvm.internal.s.h(profilePublishButton, "profilePublishButton");
        z0.y.d(profilePublishButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                xb.b u22;
                ProfileSensorContext profileSensorContext;
                FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
                UserProfileActivity userProfileActivity = UserProfileActivity.this;
                u22 = userProfileActivity.u2();
                final UserProfileActivity userProfileActivity2 = UserProfileActivity.this;
                companion.m(userProfileActivity, u22, (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$initView$3.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.p invoke() {
                        invoke2();
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        UserProfileAdapter v22;
                        int i11;
                        UserProfileAdapter v23;
                        UserProfileAdapter v24;
                        v22 = UserProfileActivity.this.v2();
                        List<Object> j10 = v22.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : j10) {
                            if (obj instanceof FeedModel) {
                                arrayList.add(obj);
                            }
                        }
                        Object obj2 = (FeedModel) CollectionsKt___CollectionsKt.V(arrayList);
                        if (obj2 == null) {
                            v24 = UserProfileActivity.this.v2();
                            List<Object> j11 = v24.j();
                            ArrayList arrayList2 = new ArrayList();
                            for (Object obj3 : j11) {
                                if (obj3 instanceof ProfilePostCountTitleViewModel) {
                                    arrayList2.add(obj3);
                                }
                            }
                            obj2 = CollectionsKt___CollectionsKt.V(arrayList2);
                        }
                        if (obj2 != null) {
                            v23 = UserProfileActivity.this.v2();
                            i11 = v23.j().indexOf(obj2);
                        } else {
                            i11 = 0;
                        }
                        ((RecyclerView) UserProfileActivity.this.n1(R$id.userProfileRecyclerView)).scrollToPosition(i11);
                        MediaPickerActivity.A.a(UserProfileActivity.this, new MediaPickerActivityModel(null, false, -1, MediaType.ALL, null, null, null, null, SensorPosition.MyProfile, CameraStartPosition.FeedPublish, 243, null));
                    }
                }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                profileSensorContext = UserProfileActivity.this.f17678r;
                if (profileSensorContext == null) {
                    kotlin.jvm.internal.s.A("sensorContext");
                    profileSensorContext = null;
                }
                sensorsLogFeed.A(profileSensorContext.getScene(), UserProfileActivity.this.Q0(), null);
            }
        });
    }

    public final boolean D2() {
        return ((Boolean) this.A.getValue()).booleanValue();
    }

    public final void E2(final String str) {
        f2.a l10 = NetworkClient.f11868a.l();
        User user = this.f17677q;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        Disposable disposed = a.C0731a.f(l10, user.userId(), 0, str, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FeedModel>, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$loadUserPostData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<FeedModel> listResult) {
                m2761invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2761invoke(ListResult<FeedModel> listResult) {
                FKLoadMoreListener s2;
                UserProfileActivity.this.S2(listResult, str);
                s2 = UserProfileActivity.this.s2();
                s2.c(false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$loadUserPostData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener s2;
                kotlin.jvm.internal.s.i(it, "it");
                s2 = UserProfileActivity.this.s2();
                s2.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void G2(final boolean z10) {
        NetworkClient networkClient = NetworkClient.f11868a;
        x2.a N = networkClient.N();
        int value = SceneType.Profile.getValue();
        User user = this.f17677q;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        Observable onErrorReturnItem = N.h0(value, user.userId()).flatMap(new com.cupidapp.live.base.network.i()).onErrorReturnItem(new SuperLikeGuideResult(null, null));
        x2.a N2 = networkClient.N();
        User user2 = this.f17677q;
        if (user2 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user2 = null;
        }
        String userId = user2.userId();
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        Observable flatMap = a.C0836a.z(N2, userId, null, profileSensorContext.getRefer(), D2(), this.f17683w, 2, null).flatMap(new com.cupidapp.live.base.network.i());
        f2.a l10 = networkClient.l();
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user3 = null;
        }
        Observable observeOn = Observable.zip(onErrorReturnItem, flatMap, a.C0731a.f(l10, user3.userId(), 0, null, 2, null).flatMap(new com.cupidapp.live.base.network.i()).onErrorReturnItem(new ListResult(new ArrayList(), null)), new Function3() { // from class: com.cupidapp.live.profile.activity.x
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Triple H2;
                H2 = UserProfileActivity.H2((SuperLikeGuideResult) obj, (ProfileResult) obj2, (ListResult) obj3);
                return H2;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<Triple<? extends SuperLikeGuideResult, ? extends ProfileResult, ? extends ListResult<FeedModel>>, kotlin.p> function1 = new Function1<Triple<? extends SuperLikeGuideResult, ? extends ProfileResult, ? extends ListResult<FeedModel>>, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$loadUserProfileData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Triple<? extends SuperLikeGuideResult, ? extends ProfileResult, ? extends ListResult<FeedModel>> triple) {
                invoke2((Triple<SuperLikeGuideResult, ProfileResult, ListResult<FeedModel>>) triple);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:179:0x02bc, code lost:
            
                if ((r1 == null || r1.isEmpty()) == false) goto L132;
             */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0300  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0317  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0321  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0338  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0347  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0351  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0360  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0370  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x038a  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x039a  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x03a5  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x039e  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x0357  */
            /* JADX WARN: Removed duplicated region for block: B:77:0x033c  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x0323  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(kotlin.Triple<com.cupidapp.live.profile.model.SuperLikeGuideResult, com.cupidapp.live.base.network.model.ProfileResult, com.cupidapp.live.base.network.model.ListResult<com.cupidapp.live.feed.model.FeedModel>> r17) {
                /*
                    Method dump skipped, instructions count: 956
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.activity.UserProfileActivity$loadUserProfileData$2.invoke2(kotlin.Triple):void");
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.profile.activity.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserProfileActivity.I2(Function1.this, obj);
            }
        };
        final UserProfileActivity$loadUserProfileData$3 userProfileActivity$loadUserProfileData$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$loadUserProfileData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.profile.activity.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserProfileActivity.J2(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "private fun loadUserProf…       })\n        )\n    }");
        H(subscribe);
    }

    public final void K2(User user) {
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        if (kotlin.jvm.internal.s.d(profileSensorContext.getRefer(), ViewProfilePrefer.AlohaToProfile.getValue())) {
            ProfileSensorContext profileSensorContext2 = this.f17678r;
            if (profileSensorContext2 == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                profileSensorContext2 = null;
            }
            if (profileSensorContext2.getSource() == SensorPosition.Match) {
                return;
            }
        }
        user.setZodiacInfo(null);
    }

    public final void L2(boolean z10) {
        User user;
        ProfileSensorContext profileSensorContext;
        User user2 = this.f17677q;
        if (user2 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        } else {
            user = user2;
        }
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user3 = null;
        }
        String userId = user3.userId();
        ProfileSensorContext profileSensorContext2 = this.f17678r;
        if (profileSensorContext2 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        } else {
            profileSensorContext = profileSensorContext2;
        }
        ChatDetailActivity.f13276r.a(this, new ChatBundleData(user, userId, profileSensorContext, null, z10, false, true, false, false, ad.f32204q, null));
    }

    public final void M2(ProfileFriendPraiseModel profileFriendPraiseModel) {
        if (profileFriendPraiseModel.getMe()) {
            if (profileFriendPraiseModel.getCount() == 0) {
                SensorsLogKeyButtonClick.Profile.Share.click();
            }
            FriendPraiseActivity.A.a(this, new FriendPraiseBundleData(Q0()));
            return;
        }
        User user = null;
        if (profileFriendPraiseModel.getCount() > 0) {
            User user2 = this.f17677q;
            if (user2 == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
            } else {
                user = user2;
            }
            LookOtherFriendPraiseActivity.f17633v.a(this, new LookOtherPraiseBundleData(user.userId(), false, Q0()));
            return;
        }
        FriendPraiseEditLayout.Companion companion = FriendPraiseEditLayout.f17854h;
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user = user3;
        }
        companion.c(this, user.userId(), Q0());
    }

    public final void N2(FeedModel feedModel) {
        List<Object> j10 = v2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedModel) {
                arrayList.add(obj);
            }
        }
        int indexOf = arrayList.indexOf(feedModel);
        FKEmptyViewModel fKEmptyViewModel = new FKEmptyViewModel(null, Integer.valueOf(R$string.no_new_post), null, null, null, null, null, false, null, null, 1021, null);
        String str = this.f17682v;
        com.cupidapp.live.profile.logic.c cVar = com.cupidapp.live.profile.logic.c.f17839a;
        User user = this.f17677q;
        User user2 = null;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        com.cupidapp.live.feed.helper.i iVar = new com.cupidapp.live.feed.helper.i(true, fKEmptyViewModel, arrayList, indexOf, str, cVar.a(user.userId()), new Function1<String, Observable<Result<? extends ListResult<FeedModel>>>>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$openPostStreamPage$dataSource$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Observable<Result<ListResult<FeedModel>>> invoke(@Nullable String str2) {
                f2.a l10 = NetworkClient.f11868a.l();
                User user3 = UserProfileActivity.this.f17677q;
                if (user3 == null) {
                    kotlin.jvm.internal.s.A(UserData.NAME);
                    user3 = null;
                }
                return l10.s(user3.userId(), 21, str2);
            }
        });
        SensorPosition sensorPosition = SensorPosition.PostStream;
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        SensorPosition position = profileSensorContext.getPosition();
        ProfileSensorContext profileSensorContext2 = this.f17678r;
        if (profileSensorContext2 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext2 = null;
        }
        SensorPosition source = profileSensorContext2.getSource();
        ProfileSensorContext profileSensorContext3 = this.f17678r;
        if (profileSensorContext3 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext3 = null;
        }
        FeedSensorContext feedSensorContext = new FeedSensorContext(sensorPosition, position, source, profileSensorContext3.getScene());
        FeedDetailListActivity.a aVar = FeedDetailListActivity.f14060v;
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user2 = user3;
        }
        aVar.a(this, iVar, user2.getName(), feedSensorContext, true);
    }

    public final void O2() {
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        if (profileSensorContext.getSource() == SensorPosition.Match) {
            w2.a.f54095a.c();
            p1.g.f52734a.M0().d(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void P2(boolean z10) {
        if (z10) {
            com.cupidapp.live.base.view.h.f12779a.c(this, R$string.has_dont_look_him);
        } else {
            com.cupidapp.live.base.view.h.f12779a.c(this, R$string.has_cancel_dont_look);
        }
        User user = this.f17677q;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        user.setSkipReceiveFeed(z10);
        i2();
        List<Object> j10 = v2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedModel) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((FeedModel) iterator2.next()).getUser().setSkipReceiveFeed(z10);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        User user = this.f17677q;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        return user.getMe() ? SensorPosition.MyProfile : SensorPosition.Profile;
    }

    public final void Q2(boolean z10, boolean z11, boolean z12) {
        List<Object> j10 = v2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FKProfileStoryLabelModel) {
                arrayList.add(obj);
            }
        }
        FKProfileStoryLabelModel fKProfileStoryLabelModel = (FKProfileStoryLabelModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (fKProfileStoryLabelModel != null) {
            fKProfileStoryLabelModel.getUser().setAloha(z10);
            fKProfileStoryLabelModel.getUser().setMatch(z11);
            fKProfileStoryLabelModel.getUser().setCloseFriend(z12);
            v2().notifyItemChanged(v2().j().indexOf(fKProfileStoryLabelModel));
        }
    }

    public final void R2() {
        x2.a N = NetworkClient.f11868a.N();
        User user = this.f17677q;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        Disposable disposed = N.H0(user.userId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$removeBlackList$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                com.cupidapp.live.base.view.h.f12779a.c(UserProfileActivity.this, R$string.remove_blacklist_success);
                UserProfileActivity.this.y2();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void S2(ListResult<FeedModel> listResult, String str) {
        int n10 = v2().n();
        List<FeedModel> list = listResult.getList();
        boolean z10 = true;
        if (list == null || list.isEmpty()) {
            FKFooterViewModel h10 = v2().h();
            if (h10 != null) {
                h10.setShowProgress(false);
            }
        } else {
            this.f17682v = listResult.getNextCursorId();
            if (str == null) {
                List<Object> j10 = v2().j();
                ArrayList arrayList = new ArrayList();
                for (Object obj : j10) {
                    if ((obj instanceof FeedModel) || (obj instanceof FKFooterViewModel)) {
                        arrayList.add(obj);
                    }
                }
                v2().j().removeAll(arrayList);
                v2().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
            }
            v2().e(listResult.getList());
            String str2 = this.f17682v;
            if (str2 != null && str2.length() != 0) {
                z10 = false;
            }
            if (z10) {
                v2().s();
            }
        }
        if (str == null) {
            v2().notifyDataSetChanged();
            return;
        }
        int n11 = v2().n() - n10;
        if (n10 == -1 || n11 == -1) {
            return;
        }
        v2().notifyItemRangeChanged(n10, n11);
    }

    public final void T2(boolean z10) {
        User user = null;
        if (z10) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            User user2 = this.f17677q;
            if (user2 == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
                user2 = null;
            }
            String userId = user2.userId();
            SensorPosition sensorPosition = SensorPosition.Profile;
            ProfileSensorContext profileSensorContext = this.f17678r;
            if (profileSensorContext == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                profileSensorContext = null;
            }
            SensorScene scene = profileSensorContext.getScene();
            User user3 = this.f17677q;
            if (user3 == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
                user3 = null;
            }
            boolean match = user3.getMatch();
            User user4 = this.f17677q;
            if (user4 == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
            } else {
                user = user4;
            }
            groupSocialLog.n(userId, sensorPosition, scene, match, user.getAloha());
            return;
        }
        GroupSocialLog groupSocialLog2 = GroupSocialLog.f18708a;
        User user5 = this.f17677q;
        if (user5 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user5 = null;
        }
        String userId2 = user5.userId();
        SensorPosition sensorPosition2 = SensorPosition.Profile;
        ProfileSensorContext profileSensorContext2 = this.f17678r;
        if (profileSensorContext2 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext2 = null;
        }
        SensorScene scene2 = profileSensorContext2.getScene();
        User user6 = this.f17677q;
        if (user6 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user6 = null;
        }
        boolean match2 = user6.getMatch();
        User user7 = this.f17677q;
        if (user7 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user = user7;
        }
        groupSocialLog2.N(userId2, sensorPosition2, scene2, match2, user.getAloha());
    }

    public final void U2() {
        com.cupidapp.live.base.utils.o c4 = com.cupidapp.live.base.utils.o.f12354i.c(this);
        this.f17686z = c4;
        if (c4 != null) {
            c4.l(new b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void V2() {
        /*
            r19 = this;
            r0 = r19
            com.cupidapp.live.profile.model.User r1 = r0.f17677q
            java.lang.String r2 = "user"
            r3 = 0
            if (r1 != 0) goto Ld
            kotlin.jvm.internal.s.A(r2)
            r1 = r3
        Ld:
            boolean r1 = r1.getLocked()
            if (r1 != 0) goto L36
            com.cupidapp.live.profile.model.User r1 = r0.f17677q
            if (r1 != 0) goto L1b
            kotlin.jvm.internal.s.A(r2)
            r1 = r3
        L1b:
            boolean r1 = r1.getHasPrivacy()
            if (r1 == 0) goto L22
            goto L36
        L22:
            com.cupidapp.live.base.share.helper.d r1 = com.cupidapp.live.base.share.helper.d.f12255a
            com.cupidapp.live.profile.model.User r4 = r0.f17677q
            if (r4 != 0) goto L2c
            kotlin.jvm.internal.s.A(r2)
            r4 = r3
        L2c:
            com.cupidapp.live.base.sensorslog.SensorPosition r5 = r19.Q0()
            com.cupidapp.live.base.share.helper.ShareBuilder r1 = r1.c(r0, r4, r5, r3)
            r7 = r1
            goto L37
        L36:
            r7 = r3
        L37:
            com.cupidapp.live.base.share.helper.a r1 = com.cupidapp.live.base.share.helper.a.f12253a
            com.cupidapp.live.profile.model.User r4 = r0.f17677q
            if (r4 != 0) goto L41
            kotlin.jvm.internal.s.A(r2)
            r4 = r3
        L41:
            java.util.List r9 = r1.b(r4)
            com.cupidapp.live.profile.model.User r4 = r0.f17677q
            if (r4 != 0) goto L4d
            kotlin.jvm.internal.s.A(r2)
            r4 = r3
        L4d:
            java.util.List r13 = r1.a(r4)
            com.cupidapp.live.base.share.fragment.ShareBottomFragment$a r1 = com.cupidapp.live.base.share.fragment.ShareBottomFragment.f12224k
            com.cupidapp.live.base.share.fragment.ShareBottomFragment r1 = r1.a()
            androidx.fragment.app.FragmentManager r15 = r19.getSupportFragmentManager()
            java.lang.String r4 = "supportFragmentManager"
            kotlin.jvm.internal.s.h(r15, r4)
            com.cupidapp.live.profile.model.User r4 = r0.f17677q
            if (r4 != 0) goto L68
            kotlin.jvm.internal.s.A(r2)
            r4 = r3
        L68:
            java.lang.String r5 = r4.userId()
            com.cupidapp.live.base.sensorslog.SensorPosition r10 = r19.Q0()
            com.cupidapp.live.profile.model.User r4 = r0.f17677q
            if (r4 != 0) goto L78
            kotlin.jvm.internal.s.A(r2)
            goto L79
        L78:
            r3 = r4
        L79:
            boolean r2 = r3.getSuperLikedByMe()
            java.lang.String r14 = r0.f17683w
            com.cupidapp.live.base.share.fragment.ShareModel r3 = new com.cupidapp.live.base.share.fragment.ShareModel
            r6 = 0
            r8 = 0
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r2)
            r12 = 0
            r2 = 0
            r16 = 1162(0x48a, float:1.628E-42)
            r17 = 0
            r4 = r3
            r18 = r15
            r15 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.cupidapp.live.profile.activity.UserProfileActivity$showProfileMenuDialog$1 r2 = new com.cupidapp.live.profile.activity.UserProfileActivity$showProfileMenuDialog$1
            r2.<init>()
            r4 = r18
            r1.v1(r4, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.activity.UserProfileActivity.V2():void");
    }

    public final void W2() {
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        if (profileSensorContext.getScene() != SensorScene.Match) {
            return;
        }
        p1.g gVar = p1.g.f52734a;
        Boolean p12 = gVar.p1();
        Boolean bool = Boolean.FALSE;
        if (kotlin.jvm.internal.s.d(p12, bool)) {
            return;
        }
        gVar.z3(bool);
        int i10 = R$id.swipe_down_see_more;
        ((TextView) n1(i10)).measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        float a10 = z0.s.f54824a.a();
        TextView swipe_down_see_more = (TextView) n1(i10);
        kotlin.jvm.internal.s.h(swipe_down_see_more, "swipe_down_see_more");
        ViewGroup.LayoutParams layoutParams = swipe_down_see_more.getLayoutParams();
        float measuredHeight = ((a10 - ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r1.bottomMargin : 0)) - ((TextView) n1(i10)).getMeasuredHeight()) - z0.h.f(this);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) n1(i10), (Property<TextView, Float>) View.Y, a10, measuredHeight);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new c());
        this.D = ofFloat;
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) n1(i10), (Property<TextView, Float>) View.Y, measuredHeight, a10);
        ofFloat2.setStartDelay(2500L);
        ofFloat2.setDuration(500L);
        ofFloat2.addListener(new d());
        this.E = ofFloat2;
    }

    public final void X2(boolean z10) {
        Iterator<Object> iterator2 = v2().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (iterator2.next() instanceof ProfileLiveStatusViewModel) {
                break;
            } else {
                i10++;
            }
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) n1(R$id.userProfileRecyclerView)).findViewHolderForLayoutPosition(i10);
        ProfileLiveStatusViewHolder profileLiveStatusViewHolder = findViewHolderForLayoutPosition instanceof ProfileLiveStatusViewHolder ? (ProfileLiveStatusViewHolder) findViewHolderForLayoutPosition : null;
        if (profileLiveStatusViewHolder != null) {
            if (z10) {
                profileLiveStatusViewHolder.s();
            } else {
                profileLiveStatusViewHolder.r();
            }
        }
    }

    public final void Y2() {
        SuperLikeClickHelper.f18616a.f((SuperLikeDeliveryAnimLayout) n1(R$id.superlikeDelivery));
    }

    public final void Z2() {
        Iterator<Object> iterator2 = v2().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (iterator2.next() instanceof ProfileHeaderViewModel) {
                break;
            } else {
                i10++;
            }
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) n1(R$id.userProfileRecyclerView)).findViewHolderForLayoutPosition(i10);
        ProfileHeaderViewHolder profileHeaderViewHolder = findViewHolderForLayoutPosition instanceof ProfileHeaderViewHolder ? (ProfileHeaderViewHolder) findViewHolderForLayoutPosition : null;
        if (profileHeaderViewHolder != null) {
            profileHeaderViewHolder.z();
        }
    }

    public final void a3(final User user, int i10, final int i11) {
        if (i11 == -1) {
            return;
        }
        SuperLikeDialogLayout.Companion companion = SuperLikeDialogLayout.f18632h;
        Lifecycle lifecycle = getLifecycle();
        String userId = user.userId();
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        String refer = profileSensorContext.getRefer();
        String str = this.f17683w;
        VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.SuperLikeProfile;
        SensorPosition Q0 = Q0();
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        companion.b(this, lifecycle, userId, null, refer, vipPurchaseEntranceType, str, Q0, i10, new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$superLikeUser$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                invoke2(swipeCardUserLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SwipeCardUserLikeResult it) {
                kotlin.jvm.internal.s.i(it, "it");
                UserProfileActivity.this.o2(it, user, i11, true);
            }
        }, new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$superLikeUser$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                invoke2(swipeCardUserLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SwipeCardUserLikeResult result) {
                String r22;
                boolean z10;
                kotlin.jvm.internal.s.i(result, "result");
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                r22 = UserProfileActivity.this.r2();
                String userId2 = user.userId();
                boolean isAlohaMatched = result.getUser().isAlohaMatched();
                Map<String, Object> recommendContext = result.getRecommendContext();
                boolean superLikedByMe = result.getUser().getSuperLikedByMe();
                Integer superLikedByMeCombos = result.getUser().getSuperLikedByMeCombos();
                SensorPosition sensorPosition = SensorPosition.Profile;
                boolean z11 = result.getUser().getProfileLevelIcon() != null;
                ZodiacElfInfoModel zodiacInfo = result.getUser().getZodiacInfo();
                String subTitle = zodiacInfo != null ? zodiacInfo.getSubTitle() : null;
                String travelCity = user.getTravelCity();
                if (travelCity != null) {
                    if (travelCity.length() > 0) {
                        z10 = true;
                        groupSocialLog.B(true, r22, userId2, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : sensorPosition, (r52 & 512) != 0 ? false : superLikedByMe, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : superLikedByMeCombos, (262144 & r52) != 0 ? null : Boolean.valueOf(z11), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : subTitle, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z10));
                    }
                }
                z10 = false;
                groupSocialLog.B(true, r22, userId2, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : sensorPosition, (r52 & 512) != 0 ? false : superLikedByMe, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : superLikedByMeCombos, (262144 & r52) != 0 ? null : Boolean.valueOf(z11), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : subTitle, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z10));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e2(final java.lang.Integer r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L3
            goto Lb
        L3:
            int r0 = r8.intValue()
            r1 = -1
            if (r0 != r1) goto Lb
            return
        Lb:
            java.util.Map r0 = r7.t2()
            if (r0 == 0) goto L1a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L18
            goto L1a
        L18:
            r0 = 0
            goto L1b
        L1a:
            r0 = 1
        L1b:
            java.lang.String r1 = "user"
            r2 = 0
            if (r0 == 0) goto L22
        L20:
            r0 = r2
            goto L2a
        L22:
            com.cupidapp.live.profile.model.User r0 = r7.f17677q
            if (r0 != 0) goto L2a
            kotlin.jvm.internal.s.A(r1)
            goto L20
        L2a:
            com.cupidapp.live.base.sensorslog.SensorsLogFeed r3 = com.cupidapp.live.base.sensorslog.SensorsLogFeed.f12208a
            com.cupidapp.live.base.sensorslog.ProfileSensorContext r4 = r7.f17678r
            java.lang.String r5 = "sensorContext"
            if (r4 != 0) goto L36
            kotlin.jvm.internal.s.A(r5)
            r4 = r2
        L36:
            com.cupidapp.live.base.sensorslog.SensorScene r4 = r4.getScene()
            if (r4 == 0) goto L41
            java.lang.String r4 = r4.getValue()
            goto L42
        L41:
            r4 = r2
        L42:
            if (r0 == 0) goto L49
            java.lang.String r0 = r0.userId()
            goto L4a
        L49:
            r0 = r2
        L4a:
            com.cupidapp.live.base.sensorslog.ProfileSensorContext r6 = r7.f17678r
            if (r6 != 0) goto L52
            kotlin.jvm.internal.s.A(r5)
            r6 = r2
        L52:
            com.cupidapp.live.base.sensorslog.SensorPosition r5 = r6.getPosition()
            com.cupidapp.live.profile.model.User r6 = r7.f17677q
            if (r6 != 0) goto L5e
            kotlin.jvm.internal.s.A(r1)
            r6 = r2
        L5e:
            boolean r6 = r6.getSuperLikedByMe()
            r3.b(r4, r0, r5, r6)
            com.cupidapp.live.base.network.NetworkClient r0 = com.cupidapp.live.base.network.NetworkClient.f11868a
            x2.a r0 = r0.N()
            com.cupidapp.live.profile.model.User r3 = r7.f17677q
            if (r3 != 0) goto L73
            kotlin.jvm.internal.s.A(r1)
            r3 = r2
        L73:
            java.lang.String r1 = r3.userId()
            io.reactivex.Observable r0 = r0.D0(r1, r2, r2)
            com.cupidapp.live.base.network.i r1 = new com.cupidapp.live.base.network.i
            r1.<init>()
            io.reactivex.Observable r0 = r0.flatMap(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r1)
            com.cupidapp.live.profile.activity.UserProfileActivity$cancelFollow$$inlined$handle$default$1 r1 = new com.cupidapp.live.profile.activity.UserProfileActivity$cancelFollow$$inlined$handle$default$1
            r1.<init>()
            com.cupidapp.live.base.network.e r8 = new com.cupidapp.live.base.network.e
            r8.<init>(r1)
            com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r1 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
            r1.<init>(r2, r7)
            com.cupidapp.live.base.network.e r2 = new com.cupidapp.live.base.network.e
            r2.<init>(r1)
            io.reactivex.disposables.Disposable r8 = r0.subscribe(r8, r2)
            java.lang.String r0 = "disposed"
            if (r8 == 0) goto Lae
            kotlin.jvm.internal.s.h(r8, r0)
            r7.H(r8)
        Lae:
            kotlin.jvm.internal.s.h(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.activity.UserProfileActivity.e2(java.lang.Integer):void");
    }

    public final void g2(final int i10) {
        User user = this.f17677q;
        User user2 = null;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        final boolean z10 = !user.getSkipReceiveFeed();
        int i11 = z10 ? R$string.dont_look_him_feed : R$string.remove_dont_look_him_feed;
        ArrayList arrayList = new ArrayList();
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user2 = user3;
        }
        if (!kotlin.jvm.internal.s.d(user2.getOfficialAccount(), Boolean.TRUE) || !z10) {
            arrayList.add(new FKActionSheetItemModel(i11, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$cancelFollowAndDontLookHim$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    UserProfileActivity userProfileActivity = UserProfileActivity.this;
                    User user4 = userProfileActivity.f17677q;
                    if (user4 == null) {
                        kotlin.jvm.internal.s.A(UserData.NAME);
                        user4 = null;
                    }
                    userProfileActivity.z2(user4.userId(), z10);
                }
            }, 30, null));
        }
        arrayList.add(new FKActionSheetItemModel(R$string.cancel_follow, ActionSheetItemType.Warning, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$cancelFollowAndDontLookHim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                User user4 = UserProfileActivity.this.f17677q;
                User user5 = null;
                if (user4 == null) {
                    kotlin.jvm.internal.s.A(UserData.NAME);
                    user4 = null;
                }
                if (user4.getSuperLikedByMe()) {
                    CancelAttentionHelper cancelAttentionHelper = CancelAttentionHelper.f18615a;
                    UserProfileActivity userProfileActivity = UserProfileActivity.this;
                    User user6 = userProfileActivity.f17677q;
                    if (user6 == null) {
                        kotlin.jvm.internal.s.A(UserData.NAME);
                    } else {
                        user5 = user6;
                    }
                    final UserProfileActivity userProfileActivity2 = UserProfileActivity.this;
                    final int i12 = i10;
                    cancelAttentionHelper.b(userProfileActivity, user5, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$cancelFollowAndDontLookHim$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ kotlin.p invoke() {
                            invoke2();
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            UserProfileActivity.this.e2(Integer.valueOf(i12));
                        }
                    });
                    return;
                }
                UserProfileActivity.this.e2(Integer.valueOf(i10));
            }
        }, 28, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }

    public final void h2() {
        List<Object> j10 = v2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ProfileHeaderViewModel) {
                arrayList.add(obj);
            }
        }
        ProfileHeaderViewModel profileHeaderViewModel = (ProfileHeaderViewModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (profileHeaderViewModel != null) {
            e2(Integer.valueOf(v2().j().indexOf(profileHeaderViewModel)));
        } else {
            f2(this, null, 1, null);
        }
    }

    public final void i2() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) n1(R$id.userProfileTitleLayout);
        com.cupidapp.live.base.share.helper.a aVar = com.cupidapp.live.base.share.helper.a.f12253a;
        User user = this.f17677q;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        fKTitleBarLayout.setRightImageVisible(aVar.c(user));
    }

    public final void j2(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        User user = this.f17677q;
        User user2 = null;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        user.setAloha(z10);
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user3 = null;
        }
        user3.setMatch(z11);
        User user4 = this.f17677q;
        if (user4 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user4 = null;
        }
        user4.setCanSendInboxMessage(z12);
        User user5 = this.f17677q;
        if (user5 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user5 = null;
        }
        user5.setFocus(z13);
        User user6 = this.f17677q;
        if (user6 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user2 = user6;
        }
        user2.setCloseFriend(z14);
        List<Object> j10 = v2().j();
        ArrayList<FeedModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedModel) {
                arrayList.add(obj);
            }
        }
        for (FeedModel feedModel : arrayList) {
            feedModel.getUser().setCanSendInboxMessage(z12);
            feedModel.getUser().setAloha(z10);
            feedModel.getUser().setMatch(z11);
            feedModel.getUser().setFocus(z13);
            feedModel.getUser().setCloseFriend(z14);
        }
    }

    public final void k2() {
        int i10 = R$id.userProfileTitleLayout;
        FKTitleBarLayout userProfileTitleLayout = (FKTitleBarLayout) n1(i10);
        kotlin.jvm.internal.s.h(userProfileTitleLayout, "userProfileTitleLayout");
        FKTitleBarLayout.setRightText$default(userProfileTitleLayout, getString(R$string.concern), -49088, 0, false, 12, null);
        TextView rightTextView = ((FKTitleBarLayout) n1(i10)).getRightTextView();
        rightTextView.setBackgroundResource(R$drawable.shape_red_stroke_bg);
        rightTextView.setPadding(z0.h.c(rightTextView, 12.0f), z0.h.c(rightTextView, 4.0f), z0.h.c(rightTextView, 12.0f), z0.h.c(rightTextView, 4.0f));
        ViewGroup.LayoutParams layoutParams = rightTextView.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.height = -2;
        }
        rightTextView.setLayoutParams(layoutParams2);
        z0.y.d(rightTextView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$configTitleFollowButton$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                UserProfileActivity.this.q2();
            }
        });
    }

    public final void l2() {
        User user = this.f17677q;
        User user2 = null;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        String userId = user.userId();
        User X = p1.g.f52734a.X();
        if (kotlin.jvm.internal.s.d(userId, X != null ? X.userId() : null)) {
            ((FKTitleBarLayout) n1(R$id.userProfileTitleLayout)).setRightTextViewVisible(false);
            return;
        }
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user3 = null;
        }
        if (!user3.getAloha()) {
            User user4 = this.f17677q;
            if (user4 == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
            } else {
                user2 = user4;
            }
            if (!user2.getMatch()) {
                ((FKTitleBarLayout) n1(R$id.userProfileTitleLayout)).setRightTextViewVisible(true);
                return;
            }
        }
        ((FKTitleBarLayout) n1(R$id.userProfileTitleLayout)).setRightTextViewVisible(false);
    }

    public final void m2() {
        if (VoicePartyActivity.f18981y.b()) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.cannot_enter_live_room);
            return;
        }
        LiveShowModel liveShowModel = this.f17681u;
        if (liveShowModel == null) {
            return;
        }
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        ProfileSensorContext profileSensorContext = (ProfileSensorContext) z0.g.a(intent, ProfileSensorContext.class);
        FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, this, new FKLiveForViewerViewModel(liveShowModel, null, new LiveInRoomSensorModel("PROFILE", null, profileSensorContext != null ? profileSensorContext.getScene() : null, SensorPosition.Profile, null, null, 48, null), false, 8, null), false, 4, null);
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.F;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void n2(FocusResultModel focusResultModel, boolean z10) {
        boolean z11;
        User user = null;
        if (!this.f17680t) {
            if (z10) {
                User user2 = this.f17677q;
                if (user2 == null) {
                    kotlin.jvm.internal.s.A(UserData.NAME);
                    user2 = null;
                }
                if (!user2.getAloha()) {
                    z11 = true;
                    this.f17680t = z11;
                }
            }
            z11 = false;
            this.f17680t = z11;
        }
        User user3 = this.f17677q;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user3 = null;
        }
        user3.setFocus(z10);
        User user4 = this.f17677q;
        if (user4 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user4 = null;
        }
        user4.setAloha(focusResultModel.getAloha());
        User user5 = this.f17677q;
        if (user5 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user5 = null;
        }
        user5.setMatch(focusResultModel.getMatch());
        i2();
        boolean aloha = focusResultModel.getAloha();
        User user6 = this.f17677q;
        if (user6 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user6 = null;
        }
        boolean match = user6.getMatch();
        User user7 = this.f17677q;
        if (user7 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user7 = null;
        }
        boolean canSendInboxMessage = user7.getCanSendInboxMessage();
        User user8 = this.f17677q;
        if (user8 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user8 = null;
        }
        j2(aloha, match, canSendInboxMessage, z10, user8.getCloseFriend());
        v2().notifyItemChanged(0);
        ((FKTitleBarLayout) n1(R$id.userProfileTitleLayout)).setRightTextViewVisible(!focusResultModel.getAloha());
        boolean aloha2 = focusResultModel.getAloha();
        boolean match2 = focusResultModel.getMatch();
        User user9 = this.f17677q;
        if (user9 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user = user9;
        }
        Q2(aloha2, match2, user.getCloseFriend());
    }

    public final void o2(SwipeCardUserLikeResult swipeCardUserLikeResult, User user, int i10, boolean z10) {
        if (i10 == -1) {
            return;
        }
        j2(true, swipeCardUserLikeResult.getUser().getMatch(), swipeCardUserLikeResult.getUser().getCanSendInboxMessage(), user.getFocus(), user.getCloseFriend());
        user.setSuperLikedByMe(swipeCardUserLikeResult.getUser().getSuperLikedByMe());
        user.setSuperLikedByMeCombos(swipeCardUserLikeResult.getUser().getSuperLikedByMeCombos());
        v2().notifyItemChanged(i10);
        boolean z11 = false;
        ((FKTitleBarLayout) n1(R$id.userProfileTitleLayout)).setRightTextViewVisible(false);
        this.f17680t = true;
        if (!z10) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            String r22 = r2();
            String userId = user.userId();
            boolean isAlohaMatched = swipeCardUserLikeResult.getUser().isAlohaMatched();
            Map<String, Object> recommendContext = swipeCardUserLikeResult.getRecommendContext();
            boolean superLikedByMe = swipeCardUserLikeResult.getUser().getSuperLikedByMe();
            Integer superLikedByMeCombos = swipeCardUserLikeResult.getUser().getSuperLikedByMeCombos();
            SensorPosition sensorPosition = SensorPosition.Profile;
            boolean z12 = swipeCardUserLikeResult.getUser().getProfileLevelIcon() != null;
            ZodiacElfInfoModel zodiacInfo = swipeCardUserLikeResult.getUser().getZodiacInfo();
            String subTitle = zodiacInfo != null ? zodiacInfo.getSubTitle() : null;
            String travelCity = user.getTravelCity();
            if (travelCity != null) {
                if (travelCity.length() > 0) {
                    z11 = true;
                }
            }
            groupSocialLog.B(true, r22, userId, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : sensorPosition, (r52 & 512) != 0 ? false : superLikedByMe, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : superLikedByMeCombos, (262144 & r52) != 0 ? null : Boolean.valueOf(z12), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : subTitle, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z11));
        }
        Q2(true, swipeCardUserLikeResult.getUser().getMatch(), user.getCloseFriend());
        v2().x(swipeCardUserLikeResult.getUser());
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_user_profile);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        User user = (User) z0.g.a(intent, User.class);
        Intent intent2 = getIntent();
        kotlin.jvm.internal.s.h(intent2, "intent");
        ProfileSensorContext profileSensorContext = (ProfileSensorContext) z0.g.a(intent2, ProfileSensorContext.class);
        this.f17683w = getIntent().getStringExtra("statisticsSource");
        if (user != null && profileSensorContext != null) {
            this.f17677q = user;
            this.f17678r = profileSensorContext;
            K2(user);
            C2();
            G2(true);
            U2();
            W2();
            return;
        }
        finish();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (getIntent().getBooleanExtra("CARE_USER_DATA_CHANGE_KEY", false) && this.f17677q != null) {
            EventBus c4 = EventBus.c();
            User user = this.f17677q;
            if (user == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
                user = null;
            }
            c4.o(new UserProfileDataChangeEvent(user, this.f17680t));
        }
        super.onDestroy();
        ObjectAnimator objectAnimator = this.D;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.E;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FeedPublishSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        F2(this, null, 1, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.cupidapp.live.base.utils.o oVar = this.f17686z;
        if (oVar != null) {
            oVar.n();
        }
        Z2();
        X2(false);
        Y2();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (v2().j().size() > 0) {
            G2(false);
        }
        com.cupidapp.live.base.utils.o oVar = this.f17686z;
        if (oVar != null) {
            oVar.m();
        }
        X2(true);
    }

    public final void p2(final User user, final int i10) {
        if (i10 == -1) {
            return;
        }
        x2.a N = NetworkClient.f11868a.N();
        String userId = user.userId();
        ProfileSensorContext profileSensorContext = this.f17678r;
        if (profileSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            profileSensorContext = null;
        }
        Disposable disposed = a.C0836a.o(N, userId, null, null, profileSensorContext.getRefer(), 0, this.f17683w, null, null, 214, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$followUser$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2760invoke(swipeCardUserLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2760invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                UserProfileActivity.this.o2(swipeCardUserLikeResult, user, i10, false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void q2() {
        List<Object> j10 = v2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ProfileHeaderViewModel) {
                arrayList.add(obj);
            }
        }
        ProfileHeaderViewModel profileHeaderViewModel = (ProfileHeaderViewModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (profileHeaderViewModel != null) {
            p2(profileHeaderViewModel.getUser(), v2().j().indexOf(profileHeaderViewModel));
        }
    }

    public final String r2() {
        SensorScene scene;
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        ProfileSensorContext profileSensorContext = (ProfileSensorContext) z0.g.a(intent, ProfileSensorContext.class);
        if (profileSensorContext == null || (scene = profileSensorContext.getScene()) == null) {
            return null;
        }
        return scene.getValue();
    }

    public final FKLoadMoreListener s2() {
        return (FKLoadMoreListener) this.f17684x.getValue();
    }

    public final Map<String, Object> t2() {
        return (Map) this.f17679s.getValue();
    }

    public final xb.b u2() {
        return (xb.b) this.B.getValue();
    }

    public final UserProfileAdapter v2() {
        return (UserProfileAdapter) this.C.getValue();
    }

    public final void w2() {
        CloseFriendManagerActivity.f17591r.a(this, new FKSensorContext(Q0(), Q0(), null, null));
    }

    public final void x2() {
        FocusUserManageActivity.f17618r.a(this, new FKSensorContext(Q0(), Q0(), null, null));
    }

    public final void y2() {
        Object obj;
        User user;
        User user2 = this.f17677q;
        User user3 = null;
        if (user2 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user2 = null;
        }
        User user4 = this.f17677q;
        if (user4 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user4 = null;
        }
        user2.setBlock(!user4.getBlock());
        j2(false, false, false, false, false);
        i2();
        User user5 = this.f17677q;
        if (user5 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user5 = null;
        }
        if (user5.getHasPrivacy()) {
            return;
        }
        List<Object> j10 = v2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : j10) {
            if (obj2 instanceof ProfileBlackListTipsViewModel) {
                arrayList.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                obj = iterator2.next();
                if (((ProfileBlackListTipsViewModel) obj).getBlock()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ProfileBlackListTipsViewModel profileBlackListTipsViewModel = (ProfileBlackListTipsViewModel) obj;
        if (profileBlackListTipsViewModel != null) {
            v2().j().remove(profileBlackListTipsViewModel);
        } else {
            List<Object> j11 = v2().j();
            User user6 = this.f17677q;
            if (user6 == null) {
                kotlin.jvm.internal.s.A(UserData.NAME);
            } else {
                user3 = user6;
            }
            j11.add(0, new ProfileBlackListTipsViewModel(user3.getBlock()));
        }
        List<Object> j12 = v2().j();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : j12) {
            if (obj3 instanceof ProfileHeaderViewModel) {
                arrayList2.add(obj3);
            }
        }
        ProfileHeaderViewModel profileHeaderViewModel = (ProfileHeaderViewModel) CollectionsKt___CollectionsKt.V(arrayList2);
        if (profileHeaderViewModel != null && (user = profileHeaderViewModel.getUser()) != null) {
            user.setMatch(false);
            user.setAlohaGet(false);
            user.setSuperLikedByMe(false);
            user.setCloseFriend(false);
        }
        v2().notifyDataSetChanged();
    }

    public final void z2(String str, final boolean z10) {
        Observable<Result<Object>> O;
        T2(z10);
        if (z10) {
            O = NetworkClient.f11868a.N().P(str);
        } else {
            O = NetworkClient.f11868a.N().O(str);
        }
        Disposable disposed = O.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.UserProfileActivity$handleDontLookHim$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                UserProfileActivity.this.P2(z10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull StoryLabelFollowEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        this.f17680t = event.isFollow();
    }
}
