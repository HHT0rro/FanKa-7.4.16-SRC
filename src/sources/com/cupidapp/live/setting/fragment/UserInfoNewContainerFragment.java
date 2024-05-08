package com.cupidapp.live.setting.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.model.BottomTabName;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.EquityModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.InnerFunctionModel;
import com.cupidapp.live.base.network.model.MarketingSpotModel;
import com.cupidapp.live.base.network.model.NewUserTaskModel;
import com.cupidapp.live.base.network.model.ProfileTaskResult;
import com.cupidapp.live.base.network.model.TaskInfoModel;
import com.cupidapp.live.base.network.model.TodayLuckyScoreModel;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.BubbleGuideModel;
import com.cupidapp.live.base.view.FKPopupWindowBubbleGuideView;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.b;
import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.liveshow.model.AdViewModel;
import com.cupidapp.live.liveshow.view.BannerLayout;
import com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent;
import com.cupidapp.live.main.view.FKUnreadCountTextView;
import com.cupidapp.live.profile.activity.RelationUserListActivity;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.dialog.InnerFunctionDialog;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.activity.EditUserInfoActivity;
import com.cupidapp.live.setting.activity.SettingMenuActivity;
import com.cupidapp.live.setting.adapter.UserServiceListAdapter;
import com.cupidapp.live.setting.adapter.UserTasksAdapter;
import com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment;
import com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment;
import com.cupidapp.live.setting.model.EditInfoPromptModel;
import com.cupidapp.live.setting.model.ProfilePasterAdModel;
import com.cupidapp.live.setting.model.UserFunctionEntranceUiModel;
import com.cupidapp.live.setting.model.UserInfoUiModel;
import com.cupidapp.live.setting.view.TodayLuckyScoreLayout;
import com.cupidapp.live.setting.view.UserEntranceCardLayout;
import com.cupidapp.live.setting.view.UserInfoFunctionEntranceLayout;
import com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel;
import com.cupidapp.live.track.group.BtnActionType;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.bean.CardElement;
import com.irisdt.client.others.OthersProtos;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.y;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;

/* compiled from: UserInfoNewContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserInfoNewContainerFragment extends FKBaseMainPagerFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f18140i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f18141j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f18142k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public InnerFunctionDialog f18143l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public FKPopupWindowBubbleGuideView f18144m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.router.j f18145n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final Lazy f18146o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18147p = new LinkedHashMap();

    /* compiled from: UserInfoNewContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final WeakReference<UserInfoNewContainerFragment> f18148a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull UserInfoNewContainerFragment fragment) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.s.i(fragment, "fragment");
            this.f18148a = new WeakReference<>(fragment);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            UserInfoNewContainerFragment userInfoNewContainerFragment;
            kotlin.jvm.internal.s.i(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != 10086 || (userInfoNewContainerFragment = this.f18148a.get()) == null) {
                return;
            }
            userInfoNewContainerFragment.e2();
        }
    }

    /* compiled from: UserInfoNewContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements b.a {
        @Override // com.cupidapp.live.base.web.b.a
        public void a(@Nullable WebView webView, int i10, boolean z10) {
            b.a.C0148a.a(this, webView, i10, z10);
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void b(int i10) {
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void c(@NotNull String str) {
            b.a.C0148a.b(this, str);
        }
    }

    public UserInfoNewContainerFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f18140i = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(UserInfoContainerViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f18141j = kotlin.c.b(new Function0<UserTasksAdapter>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$userTasksAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UserTasksAdapter invoke() {
                UserTasksAdapter userTasksAdapter = new UserTasksAdapter();
                final UserInfoNewContainerFragment userInfoNewContainerFragment = UserInfoNewContainerFragment.this;
                userTasksAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$userTasksAdapter$2$1$1
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
                        if (obj instanceof NewUserTaskModel) {
                            NewUserTaskModel newUserTaskModel = (NewUserTaskModel) obj;
                            String toast = newUserTaskModel.getToast();
                            if (!(toast == null || toast.length() == 0)) {
                                com.cupidapp.live.base.view.h.f12779a.m(UserInfoNewContainerFragment.this.getContext(), newUserTaskModel.getToast());
                            }
                            String jumpUrl = newUserTaskModel.getJumpUrl();
                            if (jumpUrl == null || jumpUrl.length() == 0) {
                                return;
                            }
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, UserInfoNewContainerFragment.this.getContext(), newUserTaskModel.getJumpUrl(), null, 4, null);
                            GroupOthersLog.f18702a.n0(newUserTaskModel.getTaskType(), newUserTaskModel.getFlowStep());
                        }
                    }
                });
                return userTasksAdapter;
            }
        });
        this.f18142k = kotlin.c.b(new Function0<UserServiceListAdapter>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$serviceAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UserServiceListAdapter invoke() {
                RecyclerView service_rv = (RecyclerView) UserInfoNewContainerFragment.this.u1(R$id.service_rv);
                kotlin.jvm.internal.s.h(service_rv, "service_rv");
                UserServiceListAdapter userServiceListAdapter = new UserServiceListAdapter(service_rv);
                final UserInfoNewContainerFragment userInfoNewContainerFragment = UserInfoNewContainerFragment.this;
                userServiceListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$serviceAdapter$2$1$1
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
                        if (obj instanceof EquityModel) {
                            EquityModel equityModel = (EquityModel) obj;
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, UserInfoNewContainerFragment.this.getContext(), equityModel.getUrl(), null, 4, null);
                            SensorsLogKeyButtonClick.UserSetting userSetting = SensorsLogKeyButtonClick.UserSetting.CustomName;
                            String trackName = equityModel.getTrackName();
                            if (trackName == null) {
                                trackName = "";
                            }
                            userSetting.setButtonName(trackName);
                            userSetting.click();
                        }
                    }
                });
                return userServiceListAdapter;
            }
        });
        this.f18146o = kotlin.c.b(new Function0<a>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$handler$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UserInfoNewContainerFragment.a invoke() {
                return new UserInfoNewContainerFragment.a(UserInfoNewContainerFragment.this);
            }
        });
    }

    public static final void J1(UserInfoNewContainerFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            this$0.A1(context, list);
        }
    }

    public static final void K1(UserInfoNewContainerFragment this$0, TodayLuckyScoreModel todayLuckyScoreModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.b2(todayLuckyScoreModel);
    }

    public static final void L1(UserInfoNewContainerFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.c2(list);
    }

    public static final void M1(UserInfoNewContainerFragment this$0, ProfileTaskResult profileTaskResult) {
        ImageModel icon;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (profileTaskResult != null) {
            List<NewUserTaskModel> newUserTaskList = profileTaskResult.getNewUserTaskList();
            if (!(newUserTaskList == null || newUserTaskList.isEmpty())) {
                Context context = this$0.getContext();
                if (context != null) {
                    ((LinearLayout) this$0.u1(R$id.tasks_tip_ll)).setBackgroundResource(R$drawable.rect_cor_8_sd_ffffff);
                    int i10 = R$id.tasks_title_txt;
                    TextView textView = (TextView) this$0.u1(i10);
                    TaskInfoModel taskInfo = profileTaskResult.getTaskInfo();
                    textView.setText(taskInfo != null ? taskInfo.getTitle() : null);
                    ((TextView) this$0.u1(i10)).setTextSize(12.0f);
                    int i11 = R$id.tasks_done_txt;
                    ((TextView) this$0.u1(i11)).setTextSize(12.0f);
                    ((TextView) this$0.u1(i10)).setTextColor(-5658199);
                    TextView tasks_title_txt = (TextView) this$0.u1(i10);
                    kotlin.jvm.internal.s.h(tasks_title_txt, "tasks_title_txt");
                    z0.u.a(tasks_title_txt);
                    this$0.u1(R$id.tasks_root_view).setVisibility(0);
                    y yVar = y.f51038a;
                    String string = context.getString(R$string.proportion);
                    kotlin.jvm.internal.s.h(string, "it.getString(R.string.proportion)");
                    Object[] objArr = new Object[2];
                    TaskInfoModel taskInfo2 = profileTaskResult.getTaskInfo();
                    objArr[0] = taskInfo2 != null ? Integer.valueOf(taskInfo2.getDoneNum()) : null;
                    TaskInfoModel taskInfo3 = profileTaskResult.getTaskInfo();
                    objArr[1] = taskInfo3 != null ? Integer.valueOf(taskInfo3.getTotalNum()) : null;
                    String format = String.format(string, Arrays.copyOf(objArr, 2));
                    kotlin.jvm.internal.s.h(format, "format(format, *args)");
                    String string2 = context.getString(R$string.has_done);
                    kotlin.jvm.internal.s.h(string2, "it.getString(R.string.has_done)");
                    Object[] objArr2 = new Object[2];
                    TaskInfoModel taskInfo4 = profileTaskResult.getTaskInfo();
                    objArr2[0] = taskInfo4 != null ? Integer.valueOf(taskInfo4.getDoneNum()) : null;
                    TaskInfoModel taskInfo5 = profileTaskResult.getTaskInfo();
                    objArr2[1] = taskInfo5 != null ? Integer.valueOf(taskInfo5.getTotalNum()) : null;
                    String format2 = String.format(string2, Arrays.copyOf(objArr2, 2));
                    kotlin.jvm.internal.s.h(format2, "format(format, *args)");
                    ((TextView) this$0.u1(i11)).setText(z0.t.k(format2, -16084993, new String[]{format}, false, 4, null));
                    TaskInfoModel taskInfo6 = profileTaskResult.getTaskInfo();
                    if (taskInfo6 != null && (icon = taskInfo6.getIcon()) != null) {
                        int c4 = z0.h.c(this$0, 36.0f);
                        int scaleWidthByHeight = icon.getScaleWidthByHeight(z0.h.c(this$0, 36.0f));
                        int i12 = R$id.tasks_gift_icon;
                        ImageLoaderView tasks_gift_icon = (ImageLoaderView) this$0.u1(i12);
                        kotlin.jvm.internal.s.h(tasks_gift_icon, "tasks_gift_icon");
                        z0.y.n(tasks_gift_icon, Integer.valueOf(scaleWidthByHeight), Integer.valueOf(c4));
                        ImageLoaderView tasks_gift_icon2 = (ImageLoaderView) this$0.u1(i12);
                        kotlin.jvm.internal.s.h(tasks_gift_icon2, "tasks_gift_icon");
                        ImageLoaderView.g(tasks_gift_icon2, icon, null, null, 6, null);
                    }
                    this$0.F1().j().clear();
                    this$0.F1().e(profileTaskResult.getNewUserTaskList());
                    this$0.F1().notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
        this$0.u1(R$id.tasks_root_view).setVisibility(8);
    }

    public static final void N1(UserInfoNewContainerFragment this$0, EditInfoPromptModel editInfoPromptModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (kotlin.jvm.internal.s.d(editInfoPromptModel != null ? Boolean.valueOf(editInfoPromptModel.isNotShowEditTips()) : null, Boolean.TRUE)) {
            TextView edit_user_info_text_view = (TextView) this$0.u1(R$id.edit_user_info_text_view);
            kotlin.jvm.internal.s.h(edit_user_info_text_view, "edit_user_info_text_view");
            z0.u.e(edit_user_info_text_view, 0, 0, 0, 0, 14, null);
        } else {
            TextView edit_user_info_text_view2 = (TextView) this$0.u1(R$id.edit_user_info_text_view);
            kotlin.jvm.internal.s.h(edit_user_info_text_view2, "edit_user_info_text_view");
            z0.u.e(edit_user_info_text_view2, R$mipmap.icon_red_exclamation, 0, 0, 0, 14, null);
        }
    }

    public static final void O1(UserInfoNewContainerFragment this$0, Integer count) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKUnreadCountTextView fKUnreadCountTextView = (FKUnreadCountTextView) this$0.u1(R$id.multi_account_total_unread_count);
        kotlin.jvm.internal.s.h(count, "count");
        fKUnreadCountTextView.setUnreadCount(count.intValue());
    }

    public static final void P1(UserInfoNewContainerFragment this$0, MarketingSpotModel marketingSpotModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.C1(marketingSpotModel);
    }

    public static final void Q1(UserInfoNewContainerFragment this$0, UserInfoUiModel userInfoUiModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ImageLoaderView user_info_avatar_img = (ImageLoaderView) this$0.u1(R$id.user_info_avatar_img);
        kotlin.jvm.internal.s.h(user_info_avatar_img, "user_info_avatar_img");
        ImageLoaderView.g(user_info_avatar_img, userInfoUiModel.getAvatarImage(), null, null, 6, null);
        ((TextView) this$0.u1(R$id.user_info_name_text_view)).setText(userInfoUiModel.getName());
        ((TextView) this$0.u1(R$id.match_count_text_view)).setText(userInfoUiModel.getMatchCount());
        ((TextView) this$0.u1(R$id.popularity_count_text_view)).setText(userInfoUiModel.getAlohaGetCount());
        ((TextView) this$0.u1(R$id.attention_count_text_view)).setText(userInfoUiModel.getAlohaCount());
        ((TextView) this$0.u1(R$id.feed_count_text_view)).setText(userInfoUiModel.getPostCount());
        String summary = userInfoUiModel.getSummary();
        if (!(summary == null || summary.length() == 0)) {
            int i10 = R$id.user_introduce_txt;
            ((TextView) this$0.u1(i10)).setText(userInfoUiModel.getSummary());
            TextView user_introduce_txt = (TextView) this$0.u1(i10);
            kotlin.jvm.internal.s.h(user_introduce_txt, "user_introduce_txt");
            z0.u.e(user_introduce_txt, 0, 0, 0, 0, 11, null);
            ((TextView) this$0.u1(i10)).setTextColor(-12566464);
            return;
        }
        int i11 = R$id.user_introduce_txt;
        ((TextView) this$0.u1(i11)).setTextColor(-5658199);
        ((TextView) this$0.u1(i11)).setText(this$0.getString(R$string.introduce_yourself_quickly));
        TextView user_introduce_txt2 = (TextView) this$0.u1(i11);
        kotlin.jvm.internal.s.h(user_introduce_txt2, "user_introduce_txt");
        z0.u.e(user_introduce_txt2, 0, 0, R$mipmap.ic_intro_edit, 0, 11, null);
    }

    public static final void R1(UserInfoNewContainerFragment this$0, Pair pair) {
        List<AdModel> list;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        AdViewModel adViewModel = (AdViewModel) pair.getFirst();
        boolean z10 = false;
        if (adViewModel != null && (list = adViewModel.getList()) != null && (!list.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            this$0.a2(adViewModel);
        } else {
            ((BannerLayout) this$0.u1(R$id.user_active_rv)).setVisibility(8);
        }
    }

    public static final void S1(UserInfoNewContainerFragment this$0, ProfilePasterAdModel profilePasterAdModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ImageLoaderView user_info_vip_publicity_img = (ImageLoaderView) this$0.u1(R$id.user_info_vip_publicity_img);
        kotlin.jvm.internal.s.h(user_info_vip_publicity_img, "user_info_vip_publicity_img");
        ImageLoaderView.g(user_info_vip_publicity_img, profilePasterAdModel != null ? profilePasterAdModel.getPasterImage() : null, null, null, 6, null);
    }

    public static final void T1(UserInfoNewContainerFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            this$0.B1(context, list);
        }
    }

    public static final void V1(UserInfoNewContainerFragment this$0, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        RecyclerExposureHelper g3 = this$0.E1().g();
        if (g3 != null) {
            g3.j();
        }
        RecyclerExposureHelper g10 = this$0.E1().g();
        if (g10 != null) {
            g10.d();
        }
    }

    public static final void W1(UserInfoNewContainerFragment this$0, NestedScrollView v2, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(v2, "v");
        RecyclerExposureHelper g3 = this$0.E1().g();
        if (g3 != null) {
            g3.j();
        }
        if (i11 <= i13 || this$0.E1().n() <= 0) {
            return;
        }
        this$0.D1().removeCallbacksAndMessages(null);
        this$0.D1().sendEmptyMessageDelayed(10086, 400L);
    }

    public static final void g2(UserInfoNewContainerFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (this$0.Y1()) {
            return;
        }
        p1.g.f52734a.D3(Boolean.FALSE);
        View view = this$0.u1(R$id.edit_user_info_bg);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Context context = view.getContext();
        kotlin.jvm.internal.s.h(context, "view.context");
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = new FKPopupWindowBubbleGuideView(context);
        String string = this$0.getString(R$string.mbti_guide);
        kotlin.jvm.internal.s.h(string, "getString(R.string.mbti_guide)");
        fKPopupWindowBubbleGuideView.c(new BubbleGuideModel(string, -1, Integer.valueOf(R$drawable.bg_black_up), 0, 8, null));
        int c4 = z0.h.c(fKPopupWindowBubbleGuideView, 28.0f);
        int height = iArr[1] + view.getHeight() + z0.h.c(fKPopupWindowBubbleGuideView, 8.0f);
        kotlin.jvm.internal.s.h(view, "view");
        FKPopupWindowBubbleGuideView.f(fKPopupWindowBubbleGuideView, view, BadgeDrawable.TOP_END, c4, height, 5, false, true, 32, null);
        this$0.f18144m = fKPopupWindowBubbleGuideView;
    }

    public final void A1(Context context, List<EquityModel> list) {
        if (list != null && (list.isEmpty() ^ true)) {
            int i10 = R$id.user_twice_equality;
            ((LinearLayout) u1(i10)).removeAllViews();
            ((LinearLayout) u1(i10)).setVisibility(0);
            ((LinearLayout) u1(i10)).setWeightSum(list.size());
            int i11 = 0;
            for (EquityModel equityModel : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                UserEntranceCardLayout userEntranceCardLayout = new UserEntranceCardLayout(context);
                userEntranceCardLayout.b(equityModel);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                if (i11 != list.size() - 1) {
                    layoutParams.setMarginEnd(z0.h.c(this, 7.0f));
                }
                ((LinearLayout) u1(R$id.user_twice_equality)).addView(userEntranceCardLayout, layoutParams);
                i11 = i12;
            }
            return;
        }
        ((LinearLayout) u1(R$id.user_twice_equality)).setVisibility(8);
    }

    public final void B1(Context context, List<UserFunctionEntranceUiModel> list) {
        boolean z10 = false;
        if (list != null && (!list.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            ((LinearLayout) u1(R$id.user_entrance_layout)).removeAllViews();
            double l10 = (z0.h.l(this) - z0.h.c(this, 42.0f)) / (list.size() <= 5 ? list.size() : 5.5d);
            for (UserFunctionEntranceUiModel userFunctionEntranceUiModel : list) {
                UserInfoFunctionEntranceLayout userInfoFunctionEntranceLayout = new UserInfoFunctionEntranceLayout(context);
                userInfoFunctionEntranceLayout.b(userFunctionEntranceUiModel);
                ((LinearLayout) u1(R$id.user_entrance_layout)).addView(userInfoFunctionEntranceLayout, new LinearLayout.LayoutParams((int) l10, -2));
            }
        }
    }

    public final void C1(MarketingSpotModel marketingSpotModel) {
        FKWebView webView = (FKWebView) u1(R$id.appWebView);
        webView.setBackgroundColor(0);
        webView.getBackground().setAlpha(0);
        String url = marketingSpotModel != null ? marketingSpotModel.getUrl() : null;
        if (url == null || url.length() == 0) {
            webView.stopLoading();
            webView.setVisibility(8);
            return;
        }
        if (webView.getVisibility() == 8) {
            GroupOthersLog.L(GroupOthersLog.f18702a, O0(), marketingSpotModel.getActName(), null, 4, null);
        }
        if (kotlin.jvm.internal.s.d(webView.getUrl(), url)) {
            com.cupidapp.live.base.web.bridge.b bVar = com.cupidapp.live.base.web.bridge.b.f13062a;
            kotlin.jvm.internal.s.h(webView, "webView");
            bVar.i(webView);
            return;
        }
        if (this.f18145n == null) {
            kotlin.jvm.internal.s.h(webView, "webView");
            FragmentActivity activity = getActivity();
            Lifecycle lifecycle = getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            FKWebView.w(webView, activity, lifecycle, null, null, 12, null);
            com.cupidapp.live.base.router.j jVar = new com.cupidapp.live.base.router.j(getContext());
            this.f18145n = jVar;
            Lifecycle lifecycle2 = getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle2, "lifecycle");
            jVar.f(lifecycle2, null);
            webView.q(this.f18145n);
            webView.setLoadProgressListener(new b());
        }
        webView.setVisibility(0);
        webView.stopLoading();
        String queryParameter = Uri.parse(url).getQueryParameter(Attributes.Style.ASPECT_RATIO);
        Float i10 = queryParameter != null ? kotlin.text.n.i(queryParameter) : null;
        int c4 = z0.h.c(this, 16.0f);
        int l10 = z0.h.l(this) - (c4 * 2);
        kotlin.jvm.internal.s.h(webView, "webView");
        z0.y.m(webView, Integer.valueOf(c4), null, Integer.valueOf(c4), null, 10, null);
        z0.y.n(webView, Integer.valueOf(l10), Integer.valueOf((int) ((i10 != null ? i10.floatValue() : 0.175f) * l10)));
        webView.u(url);
    }

    public final a D1() {
        return (a) this.f18146o.getValue();
    }

    public final UserServiceListAdapter E1() {
        return (UserServiceListAdapter) this.f18142k.getValue();
    }

    public final UserTasksAdapter F1() {
        return (UserTasksAdapter) this.f18141j.getValue();
    }

    public final UserInfoContainerViewModel G1() {
        return (UserInfoContainerViewModel) this.f18140i.getValue();
    }

    public final void H1() {
        FKPopupWindowBubbleGuideView fKPopupWindowBubbleGuideView = this.f18144m;
        if (fKPopupWindowBubbleGuideView != null) {
            fKPopupWindowBubbleGuideView.g();
        }
        this.f18144m = null;
    }

    public final void I1() {
        G1().getMatchListGuideLiveData().observe(getViewLifecycleOwner(), new EventObserver(new UserInfoNewContainerFragment$initObserve$1(this)));
        G1().getUserLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.Q1(UserInfoNewContainerFragment.this, (UserInfoUiModel) obj);
            }
        });
        G1().getAdLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.R1(UserInfoNewContainerFragment.this, (Pair) obj);
            }
        });
        G1().getProfilePasterAdLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.S1(UserInfoNewContainerFragment.this, (ProfilePasterAdModel) obj);
            }
        });
        G1().getEntranceListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.T1(UserInfoNewContainerFragment.this, (List) obj);
            }
        });
        G1().getValueEquityTopLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.J1(UserInfoNewContainerFragment.this, (List) obj);
            }
        });
        G1().getLuckyScoreLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.K1(UserInfoNewContainerFragment.this, (TodayLuckyScoreModel) obj);
            }
        });
        G1().getFeaturedServicesListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.L1(UserInfoNewContainerFragment.this, (List) obj);
            }
        });
        G1().getUserTasksLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.M1(UserInfoNewContainerFragment.this, (ProfileTaskResult) obj);
            }
        });
        G1().getEditInfoPromptData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.N1(UserInfoNewContainerFragment.this, (EditInfoPromptModel) obj);
            }
        });
        G1().getMultiAccountUnreadCount().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.O1(UserInfoNewContainerFragment.this, (Integer) obj);
            }
        });
        G1().getMarketingSpotData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserInfoNewContainerFragment.P1(UserInfoNewContainerFragment.this, (MarketingSpotModel) obj);
            }
        });
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18147p.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.Setting;
    }

    public final void U1() {
        TextView equality_title = (TextView) u1(R$id.equality_title);
        kotlin.jvm.internal.s.h(equality_title, "equality_title");
        z0.u.a(equality_title);
        TextView select_service_title = (TextView) u1(R$id.select_service_title);
        kotlin.jvm.internal.s.h(select_service_title, "select_service_title");
        z0.u.a(select_service_title);
        TextView user_info_name_text_view = (TextView) u1(R$id.user_info_name_text_view);
        kotlin.jvm.internal.s.h(user_info_name_text_view, "user_info_name_text_view");
        z0.u.a(user_info_name_text_view);
        TextView edit_user_info_text_view = (TextView) u1(R$id.edit_user_info_text_view);
        kotlin.jvm.internal.s.h(edit_user_info_text_view, "edit_user_info_text_view");
        z0.u.a(edit_user_info_text_view);
        ((TextView) u1(R$id.tasks_tip_text)).getPaint().setFakeBoldText(true);
        int i10 = R$id.user_tasks_rl;
        ((RecyclerView) u1(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) u1(i10)).setAdapter(F1());
        ((RecyclerView) u1(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, z0.h.c(this, 8.0f), 0, 0, 0, 32, null));
        int i11 = R$id.service_rv;
        RecyclerView recyclerView = (RecyclerView) u1(i11);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), E1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$initView$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i12) {
                UserServiceListAdapter E1;
                E1 = UserInfoNewContainerFragment.this.E1();
                return E1.u(i12);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        ((RecyclerView) u1(i11)).addItemDecoration(new MutableColumnDecoration(E1(), z0.h.c(this, 7.0f)));
        ((RecyclerView) u1(i11)).setAdapter(E1());
        ((TextView) u1(R$id.match_guide)).setVisibility(8);
        if (getContext() != null) {
            f2();
        }
        int i12 = R$id.nested_scroll;
        ((NestedScrollView) u1(i12)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.cupidapp.live.setting.fragment.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                UserInfoNewContainerFragment.V1(UserInfoNewContainerFragment.this, view, i13, i14, i15, i16, i17, i18, i19, i20);
            }
        });
        ((NestedScrollView) u1(i12)).setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.cupidapp.live.setting.fragment.m
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i13, int i14, int i15, int i16) {
                UserInfoNewContainerFragment.W1(UserInfoNewContainerFragment.this, nestedScrollView, i13, i14, i15, i16);
            }
        });
    }

    public final void X1() {
        if (!isAdded() || getContext() == null) {
            return;
        }
        RecyclerExposureHelper.f12092j.d(ExposureScene.ProfileService);
        G1().loadUserData();
        G1().loadUserTasks();
        G1().callMultiAccountUnreadCountApi();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Y0(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "context");
        p1.g gVar = p1.g.f52734a;
        if (gVar.D0()) {
            GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.PROFILE_RED_DOT, null, null, 6, null);
            gVar.a3(false);
            EventBus.c().l(new RefreshSpecifyTabUnreadCountEvent(MainActivity.MainPagerType.Setting));
        }
        e1(BottomTabName.Profile);
    }

    public final boolean Y1() {
        return isHidden() || kotlin.jvm.internal.s.d(p1.g.f52734a.t1(), Boolean.FALSE);
    }

    public final void Z1(BtnActionType btnActionType) {
        User user;
        SensorsLogKeyButtonClick.UserSetting.Avatar.click();
        UserInfoUiModel value = G1().getUserLiveData().getValue();
        if (value == null || (user = value.getUser()) == null) {
            return;
        }
        String value2 = ViewProfilePrefer.SettingToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.Setting;
        UserProfileActivity.a.b(UserProfileActivity.G, getContext(), user, new ProfileSensorContext(value2, null, me2, sensorPosition, sensorPosition, SensorScene.PersonalData), false, null, btnActionType, null, false, 216, null);
    }

    public final void a2(AdViewModel adViewModel) {
        int i10 = R$id.user_active_rv;
        ((BannerLayout) u1(i10)).setVisibility(0);
        ((BannerLayout) u1(i10)).setBgColor(0);
        ((BannerLayout) u1(i10)).setCornerRadius(z0.h.c(this, 8.0f));
        List<AdModel> list = adViewModel.getList();
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
        Iterator<AdModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getImage());
        }
        int l10 = z0.h.l(this) - z0.h.c(this, 32.0f);
        int scaleHeightByWidth = ((ImageModel) CollectionsKt___CollectionsKt.T(arrayList)).getScaleHeightByWidth(l10);
        int i11 = R$id.user_active_rv;
        BannerLayout user_active_rv = (BannerLayout) u1(i11);
        kotlin.jvm.internal.s.h(user_active_rv, "user_active_rv");
        z0.y.n(user_active_rv, Integer.valueOf(l10), Integer.valueOf(scaleHeightByWidth));
        BannerLayout bannerLayout = (BannerLayout) u1(i11);
        List<AdModel> list2 = adViewModel.getList();
        ArrayList arrayList2 = new ArrayList(kotlin.collections.t.t(list2, 10));
        Iterator<AdModel> iterator22 = list2.iterator2();
        while (iterator22.hasNext()) {
            arrayList2.add(iterator22.next().getImage());
        }
        bannerLayout.setImageModelList(arrayList2);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void b1(long j10) {
        j1.k.f50238a.a(O0(), (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
    }

    public final void b2(TodayLuckyScoreModel todayLuckyScoreModel) {
        if (todayLuckyScoreModel == null) {
            ((TodayLuckyScoreLayout) u1(R$id.lucky_score)).setVisibility(8);
            return;
        }
        int i10 = R$id.lucky_score;
        ((TodayLuckyScoreLayout) u1(i10)).b(todayLuckyScoreModel);
        ((TodayLuckyScoreLayout) u1(i10)).setVisibility(0);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void c1(boolean z10) {
        j1.k.f50238a.d(O0(), z10);
    }

    public final void c2(List<EquityModel> list) {
        if (list == null || list.isEmpty()) {
            ((TextView) u1(R$id.select_service_title)).setVisibility(8);
            ((RecyclerView) u1(R$id.service_rv)).setVisibility(8);
            return;
        }
        ((TextView) u1(R$id.select_service_title)).setVisibility(0);
        ((RecyclerView) u1(R$id.service_rv)).setVisibility(0);
        E1().j().clear();
        E1().e(list);
        E1().notifyDataSetChanged();
    }

    public final void d2() {
        j1.c.b(j1.c.f50228a, O0(), null, null, 6, null);
    }

    public final void e2() {
        RecyclerExposureHelper g3 = E1().g();
        if (g3 != null) {
            g3.d();
        }
    }

    public final void f2() {
        ImageView imageView;
        if (Y1() || (imageView = (ImageView) u1(R$id.switch_account_arrow_down)) == null) {
            return;
        }
        imageView.postDelayed(new Runnable() { // from class: com.cupidapp.live.setting.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                UserInfoNewContainerFragment.g2(UserInfoNewContainerFragment.this);
            }
        }, 200L);
    }

    public final void h2() {
        List<List<InnerFunctionModel>> innerFunction = G1().getInnerFunction();
        if (innerFunction != null) {
            if (this.f18143l == null) {
                this.f18143l = InnerFunctionDialog.f17721f.a(getContext()).e(innerFunction).f();
            }
            InnerFunctionDialog innerFunctionDialog = this.f18143l;
            if (innerFunctionDialog != null) {
                innerFunctionDialog.k();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_user_info_container_new, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        D1().removeCallbacksAndMessages(null);
        InnerFunctionDialog innerFunctionDialog = this.f18143l;
        if (innerFunctionDialog != null) {
            innerFunctionDialog.i();
        }
        this.f18143l = null;
        N0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            H1();
        } else {
            X1();
            d2();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        X1();
        if (isVisible()) {
            d2();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        U1();
        I1();
        z1();
        ((ImageView) u1(R$id.ic_dev_img)).setVisibility(8);
    }

    @Nullable
    public View u1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18147p;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void z1() {
        int i10 = R$id.user_active_rv;
        ((BannerLayout) u1(i10)).setLiveBannerShowLoggerListener(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i11) {
                UserInfoContainerViewModel G1;
                AdViewModel first;
                List<AdModel> list;
                G1 = UserInfoNewContainerFragment.this.G1();
                Pair<AdViewModel, String> value = G1.getAdLiveData().getValue();
                AdModel adModel = (value == null || (first = value.getFirst()) == null || (list = first.getList()) == null) ? null : (AdModel) CollectionsKt___CollectionsKt.W(list, i11);
                GroupOthersLog.l(GroupOthersLog.f18702a, UserInfoNewContainerFragment.this.O0(), adModel != null ? adModel.getItemId() : null, null, 4, null);
            }
        });
        ((BannerLayout) u1(i10)).setListener(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i11) {
                UserInfoContainerViewModel G1;
                AdViewModel first;
                List<AdModel> list;
                G1 = UserInfoNewContainerFragment.this.G1();
                Pair<AdViewModel, String> value = G1.getAdLiveData().getValue();
                AdModel adModel = (value == null || (first = value.getFirst()) == null || (list = first.getList()) == null) ? null : (AdModel) CollectionsKt___CollectionsKt.W(list, i11);
                j.a.b(com.cupidapp.live.base.router.j.f12156c, UserInfoNewContainerFragment.this.getContext(), adModel != null ? adModel.getAdUrl() : null, null, 4, null);
                GroupOthersLog.j(GroupOthersLog.f18702a, adModel != null ? adModel.getItemId() : null, UserInfoNewContainerFragment.this.O0(), null, 4, null);
            }
        });
        ImageView ic_more_img = (ImageView) u1(R$id.ic_more_img);
        kotlin.jvm.internal.s.h(ic_more_img, "ic_more_img");
        z0.y.d(ic_more_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$3
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
                UserInfoNewContainerFragment.this.h2();
            }
        });
        ImageView ic_setting_img = (ImageView) u1(R$id.ic_setting_img);
        kotlin.jvm.internal.s.h(ic_setting_img, "ic_setting_img");
        z0.y.d(ic_setting_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$4
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
                SensorsLogKeyButtonClick.UserSetting.Setting.click();
                SettingMenuActivity.f18012s.a(UserInfoNewContainerFragment.this.getContext());
            }
        });
        View user_intro_click_range_view = u1(R$id.user_intro_click_range_view);
        kotlin.jvm.internal.s.h(user_intro_click_range_view, "user_intro_click_range_view");
        z0.y.d(user_intro_click_range_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$5
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
                EditUserInfoActivity.a.b(EditUserInfoActivity.f17947y, UserInfoNewContainerFragment.this.getContext(), null, false, 6, null);
            }
        });
        ImageLoaderView user_info_avatar_img = (ImageLoaderView) u1(R$id.user_info_avatar_img);
        kotlin.jvm.internal.s.h(user_info_avatar_img, "user_info_avatar_img");
        z0.y.d(user_info_avatar_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$6
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
                UserInfoNewContainerFragment.this.Z1(BtnActionType.PROFILE_PORTRAIT);
            }
        });
        TextView user_info_name_text_view = (TextView) u1(R$id.user_info_name_text_view);
        kotlin.jvm.internal.s.h(user_info_name_text_view, "user_info_name_text_view");
        z0.y.d(user_info_name_text_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$7
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
                UserInfoNewContainerFragment.this.Z1(BtnActionType.PROFILE_NAME);
            }
        });
        TextView see_me_feed_text_view = (TextView) u1(R$id.see_me_feed_text_view);
        kotlin.jvm.internal.s.h(see_me_feed_text_view, "see_me_feed_text_view");
        z0.y.d(see_me_feed_text_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$8
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
                UserInfoNewContainerFragment.this.Z1(BtnActionType.LOOK_UP_POST);
            }
        });
        View edit_user_info_bg = u1(R$id.edit_user_info_bg);
        kotlin.jvm.internal.s.h(edit_user_info_bg, "edit_user_info_bg");
        z0.y.d(edit_user_info_bg, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$9
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
                SensorsLogKeyButtonClick.UserSetting.EditInformation.click();
                EditUserInfoActivity.a.b(EditUserInfoActivity.f17947y, UserInfoNewContainerFragment.this.getContext(), null, false, 6, null);
            }
        });
        TextView match_count_text_view = (TextView) u1(R$id.match_count_text_view);
        kotlin.jvm.internal.s.h(match_count_text_view, "match_count_text_view");
        z0.y.d(match_count_text_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$10
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
                RelationUserListActivity.f17672s.b(UserInfoNewContainerFragment.this.getContext(), 0);
            }
        });
        TextView popularity_count_text_view = (TextView) u1(R$id.popularity_count_text_view);
        kotlin.jvm.internal.s.h(popularity_count_text_view, "popularity_count_text_view");
        z0.y.d(popularity_count_text_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$11
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
                SensorsLogKeyButtonClick.UserSetting.Popularity.click();
                RelationUserListActivity.f17672s.b(UserInfoNewContainerFragment.this.getContext(), 1);
            }
        });
        TextView attention_count_text_view = (TextView) u1(R$id.attention_count_text_view);
        kotlin.jvm.internal.s.h(attention_count_text_view, "attention_count_text_view");
        z0.y.d(attention_count_text_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$12
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
                SensorsLogKeyButtonClick.UserSetting.Like.click();
                RelationUserListActivity.f17672s.b(UserInfoNewContainerFragment.this.getContext(), 2);
            }
        });
        TextView feed_count_text_view = (TextView) u1(R$id.feed_count_text_view);
        kotlin.jvm.internal.s.h(feed_count_text_view, "feed_count_text_view");
        z0.y.d(feed_count_text_view, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$13
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
                UserInfoNewContainerFragment.this.Z1(BtnActionType.PROFILE_PHOTO);
            }
        });
        ImageLoaderView user_info_vip_publicity_img = (ImageLoaderView) u1(R$id.user_info_vip_publicity_img);
        kotlin.jvm.internal.s.h(user_info_vip_publicity_img, "user_info_vip_publicity_img");
        z0.y.d(user_info_vip_publicity_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$14
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
                ConstantsUrlModel urlModel;
                String urlVipMe;
                SensorsLogKeyButtonClick.UserSetting.Vip.click();
                ConstantsResult q10 = p1.g.f52734a.q();
                if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlVipMe = urlModel.getUrlVipMe()) == null) {
                    return;
                }
                UserInfoNewContainerFragment userInfoNewContainerFragment = UserInfoNewContainerFragment.this;
                z3.d.f54832a.j("个人页VIP按钮");
                j.a.b(com.cupidapp.live.base.router.j.f12156c, userInfoNewContainerFragment.getContext(), x.a(urlVipMe, CardElement.Field.REF, UserIconViewLayout.VipIconPositionRef.Setting.getValue()), null, 4, null);
            }
        });
        ImageView switch_account_arrow_down = (ImageView) u1(R$id.switch_account_arrow_down);
        kotlin.jvm.internal.s.h(switch_account_arrow_down, "switch_account_arrow_down");
        z0.y.d(switch_account_arrow_down, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$15

            /* compiled from: UserInfoNewContainerFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class a implements SwitchAccountDialogFragment.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UserInfoNewContainerFragment f18149a;

                public a(UserInfoNewContainerFragment userInfoNewContainerFragment) {
                    this.f18149a = userInfoNewContainerFragment;
                }

                @Override // com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment.b
                public void a() {
                    ((ImageView) this.f18149a.u1(R$id.switch_account_arrow_down)).setRotation(0.0f);
                }
            }

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
                UserInfoContainerViewModel G1;
                ((ImageView) UserInfoNewContainerFragment.this.u1(R$id.switch_account_arrow_down)).setRotation(180.0f);
                a aVar = new a(UserInfoNewContainerFragment.this);
                SwitchAccountDialogFragment.a aVar2 = SwitchAccountDialogFragment.f18132l;
                FragmentManager parentFragmentManager = UserInfoNewContainerFragment.this.getParentFragmentManager();
                kotlin.jvm.internal.s.h(parentFragmentManager, "parentFragmentManager");
                G1 = UserInfoNewContainerFragment.this.G1();
                aVar2.a(parentFragmentManager, G1.getMSwitchAccountResult(), aVar);
            }
        });
        TextView match_guide = (TextView) u1(R$id.match_guide);
        kotlin.jvm.internal.s.h(match_guide, "match_guide");
        z0.y.d(match_guide, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.UserInfoNewContainerFragment$bindClickEvent$16
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
                ((TextView) UserInfoNewContainerFragment.this.u1(R$id.match_guide)).setVisibility(8);
            }
        });
    }
}
