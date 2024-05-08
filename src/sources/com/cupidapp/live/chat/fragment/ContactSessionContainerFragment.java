package com.cupidapp.live.chat.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.BottomTabName;
import com.cupidapp.live.appdialog.model.RateScene;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.router.jumper.OpenNewMatchProfileEvent;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.c0;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.utils.s0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.chat.activity.ChatRecommendActivity;
import com.cupidapp.live.chat.activity.ChatStateActivity;
import com.cupidapp.live.chat.adapter.ContactSessionAdapter;
import com.cupidapp.live.chat.event.ClickChatSuperBoostEntranceEvent;
import com.cupidapp.live.chat.event.CloseTwoLevelFloorEvent;
import com.cupidapp.live.chat.event.EnableSecondPullCloseEvent;
import com.cupidapp.live.chat.event.OpenChatStateEvent;
import com.cupidapp.live.chat.event.OpenChatWindowEvent;
import com.cupidapp.live.chat.event.UpdateSessionListEvent;
import com.cupidapp.live.chat.model.ChatMatchUIModel;
import com.cupidapp.live.chat.model.ChatSessionTitleUIModel;
import com.cupidapp.live.chat.model.InboxSessionModel;
import com.cupidapp.live.chat.model.InboxSessionType;
import com.cupidapp.live.chat.model.RefreshSessionLiveStatusEvent;
import com.cupidapp.live.chat.service.ClubEntranceModel;
import com.cupidapp.live.chat.service.SuperBoostEntranceModel;
import com.cupidapp.live.chat.service.VisitorInfoModel;
import com.cupidapp.live.chat.util.FKDeleteSessionUtil;
import com.cupidapp.live.chat.viewmodel.ChatSessionViewModel;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.activity.SurveyChatActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.club.activity.ClubChatActivity;
import com.cupidapp.live.club.activity.ClubListActivity;
import com.cupidapp.live.club.model.DeleteSessionByDeleteAndExitClubEvent;
import com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity;
import com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent;
import com.cupidapp.live.maskparty.fragment.MaskPartyMatchFragment;
import com.cupidapp.live.maskparty.view.HideMaskPartyRecommendEvent;
import com.cupidapp.live.maskparty.view.MaskPartyRecommendLayout;
import com.cupidapp.live.match.activity.NearGuideUnLockActivity;
import com.cupidapp.live.match.activity.NearUnLockUserModel;
import com.cupidapp.live.profile.activity.RelationUserListActivity;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.push.d;
import com.cupidapp.live.push.event.RouterUrlJumperSelectSecondTabEvent;
import com.cupidapp.live.scan.activity.ScanCodeActivity;
import com.cupidapp.live.setting.activity.CustomPushActivity;
import com.cupidapp.live.smartrefresh.header.TwoLevelHeader;
import com.cupidapp.live.smartrefresh.layout.SmartRefreshLayout;
import com.cupidapp.live.smartrefresh.layout.constant.RefreshState;
import com.cupidapp.live.superboost.dialog.SuperBoostManager;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.layout.VipDiscountPromptLayout;
import com.cupidapp.live.vip.model.DiscountShowPlace;
import com.cupidapp.live.vip.model.VipDiscountPromptModel;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;
import z0.y;

/* compiled from: ContactSessionContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ContactSessionContainerFragment extends FKBaseMainPagerFragment {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f13146u = new a(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f13147i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Disposable f13148j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public Disposable f13149k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final Lazy f13150l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f13151m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f13152n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public MaskPartyMatchFragment f13153o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13154p;

    /* renamed from: q, reason: collision with root package name */
    public int f13155q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f13156r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13157s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13158t = new LinkedHashMap();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ContactSessionContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ContactType {
        public static final ContactType Contact = new Contact("Contact", 0);
        private static final /* synthetic */ ContactType[] $VALUES = $values();

        /* compiled from: ContactSessionContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Contact extends ContactType {
            public Contact(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.chat.fragment.ContactSessionContainerFragment.ContactType
            public int getPageIndex() {
                return 0;
            }

            @Override // com.cupidapp.live.chat.fragment.ContactSessionContainerFragment.ContactType
            @NotNull
            public String getPageName() {
                return "Contact";
            }
        }

        private static final /* synthetic */ ContactType[] $values() {
            return new ContactType[]{Contact};
        }

        private ContactType(String str, int i10) {
        }

        public /* synthetic */ ContactType(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i10);
        }

        public static ContactType valueOf(String str) {
            return (ContactType) Enum.valueOf(ContactType.class, str);
        }

        public static ContactType[] values() {
            return (ContactType[]) $VALUES.clone();
        }

        public abstract /* synthetic */ int getPageIndex();

        @NotNull
        public abstract /* synthetic */ String getPageName();
    }

    /* compiled from: ContactSessionContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(a aVar, Context context, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = null;
            }
            return aVar.a(context, str);
        }

        @NotNull
        public final Intent a(@NotNull Context context, @Nullable String str) {
            s.i(context, "context");
            return MainActivity.F.a(context, MainActivity.MainPagerType.Chat, s0.f12376a.a(ContactType.Contact.getPageName(), str));
        }
    }

    /* compiled from: ContactSessionContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements o3.a {
        public b() {
        }

        @Override // o3.a
        public boolean a(@NotNull q3.d refreshLayout) {
            s.i(refreshLayout, "refreshLayout");
            j1.c.b(j1.c.f50228a, SensorPosition.MaskParty, null, SensorPosition.Message.getValue(), 2, null);
            FragmentActivity activity = ContactSessionContainerFragment.this.getActivity();
            if (activity != null) {
                p0.c(activity, true, 0, 2, null);
            }
            com.cupidapp.live.push.d.f17892a.j(true);
            return true;
        }
    }

    /* compiled from: ContactSessionContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends t3.b {
        public c() {
        }

        @Override // s3.c
        public void a(@Nullable q3.a aVar, boolean z10, float f10, int i10, int i11, int i12) {
            View view;
            View view2;
            if (ContactSessionContainerFragment.this.b2()) {
                MaskPartyMatchFragment maskPartyMatchFragment = ContactSessionContainerFragment.this.f13153o;
                View l12 = maskPartyMatchFragment != null ? maskPartyMatchFragment.l1() : null;
                MaskPartyMatchFragment maskPartyMatchFragment2 = ContactSessionContainerFragment.this.f13153o;
                view2 = l12;
                view = maskPartyMatchFragment2 != null ? maskPartyMatchFragment2.o1() : null;
            } else {
                view = null;
                view2 = null;
            }
            com.cupidapp.live.chat.util.a.f13181a.c(ContactSessionContainerFragment.this.f13155q, f10, ((SmartRefreshLayout) ContactSessionContainerFragment.this.s1(R$id.messageRefresh)).getHeaderTriggerRate(), view, view2, ContactSessionContainerFragment.this.getView());
        }

        @Override // t3.b, s3.d
        public void c(@NotNull q3.d refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
            s.i(refreshLayout, "refreshLayout");
            s.i(oldState, "oldState");
            s.i(newState, "newState");
            RefreshState refreshState = RefreshState.None;
            if (newState == refreshState) {
                com.cupidapp.live.push.d.f17892a.j(false);
                FragmentActivity activity = ContactSessionContainerFragment.this.getActivity();
                if (activity != null) {
                    p0.c(activity, false, 0, 2, null);
                }
            }
            com.cupidapp.live.chat.util.a.f13181a.b(newState, ContactSessionContainerFragment.this.s1(R$id.top_level_tip), (LinearLayout) ContactSessionContainerFragment.this.s1(R$id.session_root));
            if (newState == RefreshState.PullDownToRefresh) {
                ContactSessionContainerFragment.this.B1();
            } else if (newState == refreshState) {
                ContactSessionContainerFragment.this.e2();
                View shield_view = ContactSessionContainerFragment.this.s1(R$id.shield_view);
                s.h(shield_view, "shield_view");
                shield_view.setVisibility(0);
            }
            if (newState == RefreshState.TwoLevel) {
                View shield_view2 = ContactSessionContainerFragment.this.s1(R$id.shield_view);
                s.h(shield_view2, "shield_view");
                shield_view2.setVisibility(8);
                if (MaskPartyRecommendLayout.f16437o.b()) {
                    EventBus.c().l(new HideMaskPartyRecommendEvent());
                }
            }
            super.c(refreshLayout, oldState, newState);
        }
    }

    public ContactSessionContainerFragment() {
        ContactSessionContainerFragment$viewModel$2 contactSessionContainerFragment$viewModel$2 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        s.i(p02, "p0");
                        return new ChatSessionViewModel(AppApplication.f11612d.h());
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$special$$inlined$viewModels$default$1
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
        this.f13147i = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ChatSessionViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, contactSessionContainerFragment$viewModel$2);
        this.f13150l = kotlin.c.b(new Function0<ContactSessionAdapter>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ContactSessionAdapter invoke() {
                ContactSessionAdapter contactSessionAdapter = new ContactSessionAdapter();
                final ContactSessionContainerFragment contactSessionContainerFragment = ContactSessionContainerFragment.this;
                contactSessionAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof InboxSessionModel) {
                            ContactSessionContainerFragment.this.W1((InboxSessionModel) obj);
                        }
                    }
                });
                contactSessionAdapter.l().h(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof InboxSessionModel) {
                            ContactSessionContainerFragment.this.k2((InboxSessionModel) obj);
                        }
                    }
                });
                contactSessionAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.sessionUserAvatarImageView), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof InboxSessionModel) {
                            InboxSessionModel inboxSessionModel = (InboxSessionModel) obj;
                            if (inboxSessionModel.inLiveShow()) {
                                FKStartLiveShowActivity.f14790s.a(ContactSessionContainerFragment.this.getContext(), inboxSessionModel.getLiveShowId(), null, SensorPosition.Message.getValue());
                            } else {
                                ContactSessionContainerFragment.this.W1(inboxSessionModel);
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.all_match_text), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof ChatSessionTitleUIModel) {
                            SensorsLogKeyButtonClick.Message.AllMatchUser.click();
                            RelationUserListActivity.f17672s.b(ContactSessionContainerFragment.this.getContext(), 0);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.chat_all_match_text), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof ChatSessionTitleUIModel) {
                            SensorsLogKeyButtonClick.Message.AllMatchUser.click();
                            RelationUserListActivity.f17672s.b(ContactSessionContainerFragment.this.getContext(), 0);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.close_view_privately), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        ChatSessionViewModel L1;
                        if (obj instanceof ChatSessionTitleUIModel) {
                            L1 = ContactSessionContainerFragment.this.L1();
                            L1.closeViewMessagePrivately();
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.chat_push_tip), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        GroupOthersLog.p0(GroupOthersLog.f18702a, GroupOthersLog.TipsType.MSG_PAGE_OPEN_PUSH, null, 2, null);
                        Context context = ContactSessionContainerFragment.this.getContext();
                        if (context != null) {
                            CustomPushActivity.f17944s.a(context);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.emptyPromptBtn), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof FKEmptyViewModel) {
                            ContactSessionContainerFragment.this.G0();
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.club_entrance_imageview), new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionAdapter$2$1$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof ChatSessionTitleUIModel) {
                            ClubEntranceModel clubEntrance = ((ChatSessionTitleUIModel) obj).getClubEntrance();
                            String welcomePageUrl = clubEntrance != null ? clubEntrance.getWelcomePageUrl() : null;
                            if (welcomePageUrl == null || welcomePageUrl.length() == 0) {
                                ClubListActivity.a.b(ClubListActivity.f13485s, ContactSessionContainerFragment.this.getContext(), 0, SensorPosition.Message, 2, null);
                            } else {
                                j.a.b(com.cupidapp.live.base.router.j.f12156c, ContactSessionContainerFragment.this.getContext(), clubEntrance != null ? clubEntrance.getWelcomePageUrl() : null, null, 4, null);
                            }
                        }
                    }
                })));
                return contactSessionAdapter;
            }
        });
        this.f13151m = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final ContactSessionContainerFragment contactSessionContainerFragment = ContactSessionContainerFragment.this;
                return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$loadMoreListener$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ChatSessionViewModel L1;
                        L1 = ContactSessionContainerFragment.this.L1();
                        L1.loadMore();
                    }
                });
            }
        });
        this.f13152n = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$purchaseManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PurchaseDialogManager invoke() {
                Context context = ContactSessionContainerFragment.this.getContext();
                Lifecycle lifecycle = ContactSessionContainerFragment.this.getLifecycle();
                s.h(lifecycle, "this.lifecycle");
                return new PurchaseDialogManager(context, lifecycle);
            }
        });
        this.f13156r = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$mSensorContext$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKSensorContext invoke() {
                SensorPosition O0 = ContactSessionContainerFragment.this.O0();
                return new FKSensorContext(O0, O0, null, SensorScene.Chat);
            }
        });
    }

    public static final void O1(ContactSessionContainerFragment this$0, StateResult stateResult) {
        SuperBoostEntranceModel superBoostEntrance;
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            ((FKSwipeRefreshLayout) this$0.s1(R$id.refresh)).setRefreshing(true);
            return;
        }
        ((FKSwipeRefreshLayout) this$0.s1(R$id.refresh)).setRefreshing(false);
        this$0.H1().c(false);
        this$0.K1().j().clear();
        this$0.K1().e((List) stateResult.getData());
        this$0.K1().notifyDataSetChanged();
        List list = (List) stateResult.getData();
        Object V = list != null ? CollectionsKt___CollectionsKt.V(list) : null;
        if (this$0.f13157s || !(V instanceof ChatSessionTitleUIModel)) {
            return;
        }
        ChatMatchUIModel matchUserModel = ((ChatSessionTitleUIModel) V).getMatchUserModel();
        if (((matchUserModel == null || (superBoostEntrance = matchUserModel.getSuperBoostEntrance()) == null) ? null : superBoostEntrance.getUrl()) != null) {
            SuperBoostManager.p(SuperBoostManager.f18580a, null, 1, null);
            this$0.f13157s = true;
        }
    }

    public static final void P1(ContactSessionContainerFragment this$0, Integer num) {
        s.i(this$0, "this$0");
        if (num == null) {
            ((FKSwipeRefreshLayout) this$0.s1(R$id.refresh)).setBackgroundColor(-1);
        } else {
            ((FKSwipeRefreshLayout) this$0.s1(R$id.refresh)).setBackgroundColor(num.intValue());
        }
    }

    public static final void Q1(ContactSessionContainerFragment this$0, Boolean bool) {
        s.i(this$0, "this$0");
        if (s.d(bool, Boolean.TRUE)) {
            this$0.X1();
        }
    }

    public static final void R1(ContactSessionContainerFragment this$0, Boolean bool) {
        s.i(this$0, "this$0");
        if (s.d(bool, Boolean.TRUE)) {
            this$0.g2();
        }
    }

    public static final void S1(ContactSessionContainerFragment this$0, VipDiscountPromptModel it) {
        s.i(this$0, "this$0");
        VipDiscountPromptLayout vipDiscountPromptLayout = (VipDiscountPromptLayout) this$0.s1(R$id.vip_discount_prompt_layout);
        s.h(it, "it");
        vipDiscountPromptLayout.b(it, DiscountShowPlace.Session);
    }

    public static final void T1(ContactSessionContainerFragment this$0, Boolean show) {
        s.i(this$0, "this$0");
        s.h(show, "show");
        if (show.booleanValue()) {
            ((ImageView) this$0.s1(R$id.scan_code_img)).setVisibility(0);
        } else {
            ((ImageView) this$0.s1(R$id.scan_code_img)).setVisibility(8);
        }
    }

    public static final void Y1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Z1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void h2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void i2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void j2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void B1() {
        if (this.f13154p) {
            return;
        }
        this.f13154p = true;
        MaskPartyMatchFragment a10 = MaskPartyMatchFragment.f16296o.a(false, false, true);
        this.f13153o = a10;
        if (a10 != null) {
            getChildFragmentManager().beginTransaction().replace(R$id.second_floor_content, a10).commitNowAllowingStateLoss();
        }
    }

    public final void C1() {
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.h0(), Boolean.TRUE)) {
            gVar.K2(Boolean.FALSE);
            Context context = getContext();
            if (context != null) {
                FKPointerDialog f10 = FKPointerDialog.f12718p.a(context).f(false);
                String string = context.getString(R$string.pull_or_click_to_mask);
                s.h(string, "it.getString(R.string.pull_or_click_to_mask)");
                FKPointerDialog.B(f10.n(string).j(Float.valueOf(0.1f)).q(PointerPos.TOP_CENTER, BgColor.DEFAULT).p(null, true), (ImageView) s1(R$id.mask_img), 0, z0.h.c(this, 10.0f), 0, Integer.valueOf(R$style.PointerDialog), 10, null);
            }
        }
    }

    public final void D1(InboxSessionModel inboxSessionModel) {
        Disposable disposed = NetworkClient.f11868a.h().q(inboxSessionModel.getItemId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$clearMarketingSessionRedDot$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$clearMarketingSessionRedDot$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void E1() {
        d.a aVar = com.cupidapp.live.push.d.f17892a;
        aVar.b(FKPushType.InboxMessageNew);
        aVar.b(FKPushType.InboxMessageNewFocus);
        aVar.b(FKPushType.InboxMessageNewIntimate);
    }

    public final void F1(InboxSessionModel inboxSessionModel) {
        L1().clearUnreadCount(inboxSessionModel);
    }

    public final void G0() {
        RecyclerView recyclerView;
        L1().initData();
        if ((!K1().j().isEmpty()) && (recyclerView = (RecyclerView) s1(R$id.contactSessionRecyclerView)) != null) {
            recyclerView.scrollToPosition(0);
        }
        K1().y();
    }

    public final void G1() {
        TwoLevelHeader twoLevelHeader = (TwoLevelHeader) s1(R$id.header);
        if (twoLevelHeader != null) {
            twoLevelHeader.e();
        }
    }

    public final FKLoadMoreListener H1() {
        return (FKLoadMoreListener) this.f13151m.getValue();
    }

    public final FKSensorContext I1() {
        return (FKSensorContext) this.f13156r.getValue();
    }

    public final PurchaseDialogManager J1() {
        return (PurchaseDialogManager) this.f13152n.getValue();
    }

    public final ContactSessionAdapter K1() {
        return (ContactSessionAdapter) this.f13150l.getValue();
    }

    public final ChatSessionViewModel L1() {
        return (ChatSessionViewModel) this.f13147i.getValue();
    }

    public final void M1() {
        SensorPosition sensorPosition = SensorPosition.Message;
        FKSensorContext fKSensorContext = new FKSensorContext(sensorPosition, sensorPosition, null, SensorScene.Chat);
        Context context = getContext();
        if (context != null) {
            ChatStateActivity.f13122t.a(context, fKSensorContext);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13158t.clear();
    }

    public final void N1() {
        L1().getResultListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactSessionContainerFragment.O1(ContactSessionContainerFragment.this, (StateResult) obj);
            }
        });
        L1().getBgColor().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactSessionContainerFragment.P1(ContactSessionContainerFragment.this, (Integer) obj);
            }
        });
        L1().getMaskTimeEventLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactSessionContainerFragment.Q1(ContactSessionContainerFragment.this, (Boolean) obj);
            }
        });
        L1().getSessionTimeEventLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactSessionContainerFragment.R1(ContactSessionContainerFragment.this, (Boolean) obj);
            }
        });
        L1().getOpenUserProfileEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                invoke2(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ProfileResult result) {
                s.i(result, "result");
                String value = ViewProfilePrefer.MatchPushToProfile.getValue();
                boolean me2 = result.getUser().getMe();
                SensorPosition sensorPosition = SensorPosition.MatchSuccess;
                UserProfileActivity.G.a(ContactSessionContainerFragment.this.getContext(), result.getUser(), new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition, null), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
            }
        }));
        L1().getShowDiscountPrompt().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactSessionContainerFragment.S1(ContactSessionContainerFragment.this, (VipDiscountPromptModel) obj);
            }
        });
        L1().getShowScanCodeView().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactSessionContainerFragment.T1(ContactSessionContainerFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.Message;
    }

    public final void U1() {
        ((FKSwipeRefreshLayout) s1(R$id.refresh)).setEnabled(false);
        int i10 = R$id.header;
        ((TwoLevelHeader) s1(i10)).g(true);
        ImageView mask_img = (ImageView) s1(R$id.mask_img);
        s.h(mask_img, "mask_img");
        y.d(mask_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$initSecondFloorView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SensorsLogKeyButtonClick.Message.MaskParty.click();
                ContactSessionContainerFragment.this.B1();
                ((TwoLevelHeader) ContactSessionContainerFragment.this.s1(R$id.header)).f(true);
            }
        });
        ImageView scan_code_img = (ImageView) s1(R$id.scan_code_img);
        s.h(scan_code_img, "scan_code_img");
        y.d(scan_code_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$initSecondFloorView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SensorsLogKeyButtonClick.Message.RICH_SCAN.click();
                ScanCodeActivity.a.c(ScanCodeActivity.f17907u, ContactSessionContainerFragment.this.getContext(), null, 2, null);
            }
        });
        ((TwoLevelHeader) s1(i10)).h(new b());
        ((SmartRefreshLayout) s1(R$id.messageRefresh)).J(new c());
    }

    public final void V1() {
        U1();
        ContactSessionAdapter K1 = K1();
        int i10 = R$id.contactSessionRecyclerView;
        RecyclerView contactSessionRecyclerView = (RecyclerView) s1(i10);
        s.h(contactSessionRecyclerView, "contactSessionRecyclerView");
        K1.z(contactSessionRecyclerView);
        RecyclerView recyclerView = (RecyclerView) s1(i10);
        recyclerView.setAdapter(K1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.addOnScrollListener(H1());
        C1();
    }

    public final void W1(InboxSessionModel inboxSessionModel) {
        String jumpUrl;
        E1();
        String type = inboxSessionModel.getType();
        if (s.d(type, InboxSessionType.InboxSession.getType())) {
            User sender = inboxSessionModel.getSender();
            if (sender == null) {
                return;
            }
            c2(sender, I1().getScene(), inboxSessionModel.inLiveShow(), inboxSessionModel.isLimitSendMsg());
            F1(inboxSessionModel);
            return;
        }
        if (s.d(type, InboxSessionType.UrlSession.getType())) {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, getContext(), inboxSessionModel.getUrl(), null, 4, null);
            F1(inboxSessionModel);
            return;
        }
        if (s.d(type, InboxSessionType.VisitorSession.getType())) {
            j.a aVar = com.cupidapp.live.base.router.j.f12156c;
            Context context = getContext();
            VisitorInfoModel visitorInfo = inboxSessionModel.getVisitorInfo();
            if (visitorInfo != null && (jumpUrl = visitorInfo.getJumpUrl()) != null) {
                String lastMessage = inboxSessionModel.getLastMessage();
                if (lastMessage == null) {
                    lastMessage = "";
                }
                r2 = x.a(jumpUrl, "entranceContent", lastMessage);
            }
            j.a.b(aVar, context, r2, null, 4, null);
            return;
        }
        if (s.d(type, InboxSessionType.ChatStatusSession.getType())) {
            j1.e.c(j1.e.f50230a, "RECOMMENDED_CHAT", inboxSessionModel.getChatStatusDot(), null, null, 12, null);
            ChatRecommendActivity.f13113w.a(getContext());
            return;
        }
        if (s.d(type, InboxSessionType.MarketingSession.getType())) {
            String trackName = inboxSessionModel.getTrackName();
            if (!(trackName == null || trackName.length() == 0)) {
                j1.e.c(j1.e.f50230a, inboxSessionModel.getTrackName(), Boolean.valueOf(inboxSessionModel.getMarketingDot()), null, null, 12, null);
            }
            j.a.b(com.cupidapp.live.base.router.j.f12156c, getContext(), inboxSessionModel.getMarketingUrl(), null, 4, null);
            D1(inboxSessionModel);
            return;
        }
        if (s.d(type, InboxSessionType.GroupSession.getType())) {
            ClubChatActivity.f13469x.a(getContext(), inboxSessionModel.getItemId());
            j1.e.c(j1.e.f50230a, "GROUP_SESSION", null, inboxSessionModel.getItemId(), null, 10, null);
            return;
        }
        if (s.d(type, InboxSessionType.NearBySession.getType())) {
            j1.e.c(j1.e.f50230a, "NEARBY_CHAT", null, null, null, 14, null);
            User sender2 = inboxSessionModel.getSender();
            if (sender2 != null) {
                NearGuideUnLockActivity.f16519u.a(getContext(), new NearUnLockUserModel(sender2.getAvatarImage(), sender2.userId(), inboxSessionModel.getLastMessage(), inboxSessionModel.getCountdown()));
                return;
            }
            return;
        }
        if (s.d(type, InboxSessionType.OperationSession.getType())) {
            F1(inboxSessionModel);
            SurveyChatActivity.f13293u.a(getContext(), inboxSessionModel.getTemplateMsgId());
            j1.e eVar = j1.e.f50230a;
            User sender3 = inboxSessionModel.getSender();
            j1.e.c(eVar, "MATKET_COMMON", null, null, sender3 != null ? sender3.userId() : null, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void X0() {
        super.X0();
        G0();
    }

    public final void X1() {
        if (this.f13148j == null) {
            Observable<Long> observeOn = Observable.interval(60L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$maskTimer$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    ChatSessionViewModel L1;
                    L1 = ContactSessionContainerFragment.this.L1();
                    L1.updateSessionMaskRemain();
                }
            };
            Observable<Long> doOnNext = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.chat.fragment.m
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactSessionContainerFragment.Y1(Function1.this, obj);
                }
            });
            final ContactSessionContainerFragment$maskTimer$2 contactSessionContainerFragment$maskTimer$2 = new Function1<Long, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$maskTimer$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                }
            };
            Consumer<? super Long> consumer = new Consumer() { // from class: com.cupidapp.live.chat.fragment.l
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactSessionContainerFragment.Z1(Function1.this, obj);
                }
            };
            final ContactSessionContainerFragment$maskTimer$3 contactSessionContainerFragment$maskTimer$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$maskTimer$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }
            };
            this.f13148j = doOnNext.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.chat.fragment.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactSessionContainerFragment.a2(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Y0(@NotNull Context context) {
        s.i(context, "context");
        j1.c.b(j1.c.f50228a, SensorPosition.Message, null, null, 6, null);
        E1();
        if (p1.g.f52734a.A0() == 0) {
            new FKAppRatingLayout(context).p(RateScene.LeaveNotify);
        }
        EventBus.c().l(new RefreshSpecifyTabUnreadCountEvent(MainActivity.MainPagerType.Setting));
        e1(BottomTabName.Inbox);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            p0.c(activity, false, 0, 2, null);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void b1(long j10) {
        j1.k.f50238a.a(SensorPosition.Message, (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
    }

    public final boolean b2() {
        if (this.f13154p) {
            MaskPartyMatchFragment maskPartyMatchFragment = this.f13153o;
            if (maskPartyMatchFragment != null && maskPartyMatchFragment.isAdded()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void c1(boolean z10) {
        j1.k.f50238a.d(SensorPosition.Message, z10);
    }

    public final void c2(User user, SensorScene sensorScene, boolean z10, boolean z11) {
        ChatDetailActivity.f13276r.a(getContext(), new ChatBundleData(user, user.userId(), new FKSensorContext(I1().getPosition(), I1().getSource(), I1().getOriginSource(), sensorScene), null, false, false, false, z10, z11, 120, null));
    }

    public final void d2() {
        L1().refreshImportantData();
    }

    public final void e2() {
        if (this.f13154p) {
            MaskPartyMatchFragment maskPartyMatchFragment = this.f13153o;
            if (maskPartyMatchFragment != null) {
                getChildFragmentManager().beginTransaction().remove(maskPartyMatchFragment).commitNowAllowingStateLoss();
            }
            this.f13154p = false;
        }
    }

    public final void f2(String str, String str2) {
        Object obj;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        List<Object> j10 = K1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : j10) {
            if (obj2 instanceof InboxSessionModel) {
                arrayList.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                obj = iterator2.next();
                if (s.d(((InboxSessionModel) obj).getItemId(), str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        InboxSessionModel inboxSessionModel = (InboxSessionModel) obj;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) s1(R$id.contactSessionRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || inboxSessionModel == null) {
            return;
        }
        int indexOf = K1().j().indexOf(inboxSessionModel);
        Pair<Integer, Integer> a10 = c0.a(linearLayoutManager);
        if (a10 == null) {
            return;
        }
        if (indexOf <= a10.getSecond().intValue() && a10.getFirst().intValue() <= indexOf) {
            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
            User sender = inboxSessionModel.getSender();
            sensorsLogLiveShow.o(str2, sender != null ? sender.userId() : null, SensorPosition.Message, SensorScene.Chat, (r33 & 16) != 0 ? null : null, (r33 & 32) != 0 ? null : null, (r33 & 64) != 0 ? null : null, (r33 & 128) != 0 ? null : null, (r33 & 256) != 0 ? null : null, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : null);
        }
    }

    public final void g2() {
        if (this.f13149k == null) {
            Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionCountDown$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    ChatSessionViewModel L1;
                    L1 = ContactSessionContainerFragment.this.L1();
                    L1.updateSessionCountDown();
                }
            };
            Observable<Long> doOnNext = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.chat.fragment.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactSessionContainerFragment.h2(Function1.this, obj);
                }
            });
            final ContactSessionContainerFragment$sessionCountDown$2 contactSessionContainerFragment$sessionCountDown$2 = new Function1<Long, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionCountDown$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                }
            };
            Consumer<? super Long> consumer = new Consumer() { // from class: com.cupidapp.live.chat.fragment.n
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactSessionContainerFragment.i2(Function1.this, obj);
                }
            };
            final ContactSessionContainerFragment$sessionCountDown$3 contactSessionContainerFragment$sessionCountDown$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$sessionCountDown$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }
            };
            this.f13149k = doOnNext.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.chat.fragment.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ContactSessionContainerFragment.j2(Function1.this, obj);
                }
            });
        }
    }

    public final void k2(final InboxSessionModel inboxSessionModel) {
        if (s.d(inboxSessionModel.getType(), InboxSessionType.VisitorSession.getType()) || s.d(inboxSessionModel.getType(), InboxSessionType.ChatStatusSession.getType()) || s.d(inboxSessionModel.getType(), InboxSessionType.MarketingSession.getType()) || s.d(inboxSessionModel.getType(), InboxSessionType.NearBySession.getType())) {
            return;
        }
        FKDeleteSessionUtil.f13177a.d(getContext(), J1(), VipPurchaseEntranceType.ViewPrivatelyMessage, inboxSessionModel.getType(), new Function0<p>() { // from class: com.cupidapp.live.chat.fragment.ContactSessionContainerFragment$showDeleteSessionDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChatSessionViewModel L1;
                L1 = ContactSessionContainerFragment.this.L1();
                L1.deleteSession(inboxSessionModel);
            }
        });
        z3.b.f54828a.b();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        if (!b2()) {
            return false;
        }
        MaskPartyMatchFragment maskPartyMatchFragment = this.f13153o;
        s.f(maskPartyMatchFragment);
        return maskPartyMatchFragment.onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_contact_session_container, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SuperBoostManager.f18580a.y();
        this.f13157s = false;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TwoLevelHeader twoLevelHeader = (TwoLevelHeader) s1(R$id.header);
        if (twoLevelHeader != null) {
            twoLevelHeader.e();
        }
        Disposable disposable = this.f13148j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f13148j = null;
        Disposable disposable2 = this.f13149k;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f13149k = null;
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenChatWindowEvent event) {
        s.i(event, "event");
        c2(event.getUser(), SensorScene.NewMatchList, false, false);
        L1().clearNewMatch(event.getUser().userId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            return;
        }
        d2();
        E1();
        L1().showDiscountPrompt();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            d2();
            L1().showDiscountPrompt();
        }
        E1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            View top_level_tip = s1(R$id.top_level_tip);
            s.h(top_level_tip, "top_level_tip");
            com.cupidapp.live.base.view.s.b(context, top_level_tip);
        }
        ViewGroup.LayoutParams layoutParams = s1(R$id.top_level_tip).getLayoutParams();
        s.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.f13155q = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        V1();
        L1().initData();
        N1();
    }

    @Nullable
    public View s1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13158t;
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

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenChatStateEvent event) {
        s.i(event, "event");
        M1();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenNewMatchProfileEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        String userId = event.getUserId();
        if (userId != null) {
            L1().openUserProfile(userId);
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RouterUrlJumperSelectSecondTabEvent event) {
        s.i(event, "event");
        if (s.d(event.getType(), ContactType.Contact.getPageName())) {
            EventBus.c().r(event);
            RelationUserListActivity.f17672s.b(getContext(), 0);
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull CloseTwoLevelFloorEvent closeEvent) {
        s.i(closeEvent, "closeEvent");
        EventBus.c().r(closeEvent);
        G1();
        TwoLevelHeader twoLevelHeader = (TwoLevelHeader) s1(R$id.header);
        if (twoLevelHeader != null) {
            twoLevelHeader.g(true);
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull EnableSecondPullCloseEvent event) {
        s.i(event, "event");
        TwoLevelHeader twoLevelHeader = (TwoLevelHeader) s1(R$id.header);
        if (twoLevelHeader != null) {
            twoLevelHeader.g(event.getCanPull());
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UpdateSessionListEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        L1().updateSessionList();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull v1.a event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (L1().hasUserGuide()) {
            G0();
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DeleteSessionByDeleteAndExitClubEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        L1().deleteSessionByDeleteAndExitClub(event.getClubId());
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshSessionLiveStatusEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        f2(event.getModel().getSessionId(), event.getModel().getLiveShowId());
        L1().updateSessionList();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ClickChatSuperBoostEntranceEvent event) {
        s.i(event, "event");
        SuperBoostManager.f18580a.j(getContext(), J1(), O0().getValue(), event.getUrl());
    }
}
