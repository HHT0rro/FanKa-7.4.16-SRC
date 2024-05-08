package com.cupidapp.live.feed.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.layout.FKGuideOpenPushDialogLayout;
import com.cupidapp.live.appdialog.model.BottomTabName;
import com.cupidapp.live.appdialog.model.RateScene;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.club.fragment.ActivityListFragment;
import com.cupidapp.live.club.model.FeedGroupEntryResult;
import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.feed.adapter.FeedContainerViewPagerAdapter;
import com.cupidapp.live.feed.event.ChangeFeedTabEvent;
import com.cupidapp.live.feed.fragment.FeedContainerFragment;
import com.cupidapp.live.feed.layout.BaseViewPagerForShortVideo;
import com.cupidapp.live.feed.layout.MapFloatLayout;
import com.cupidapp.live.feed.model.FeedFloatBubbleModel;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FloatBubbleResult;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.main.event.ShowGuideOpenPushDialogAfterPublishFeedEvent;
import com.cupidapp.live.match.model.MapOverPopResult;
import com.cupidapp.live.match.model.NearByFloatModel;
import com.cupidapp.live.mediapicker.activity.MediaPickerActivity;
import com.cupidapp.live.mediapicker.event.ChangeFeedSortEvent;
import com.cupidapp.live.mediapicker.event.FeedSortSwitchEvent;
import com.cupidapp.live.mediapicker.event.TabRedDotEvent;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.MediaPickerActivityModel;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.notify.activity.NotifyActivity;
import com.cupidapp.live.notify.fragment.NotifyPageType;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.helper.PersonalizedRecommendHelper;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.others.OthersProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedContainerFragment extends FKBaseMainPagerFragment implements j, com.cupidapp.live.club.fragment.d {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f14221u = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public int f14229p;

    /* renamed from: q, reason: collision with root package name */
    public long f14230q;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14233t = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final List<FeedTabType> f14222i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final List<FKBaseFragment> f14223j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final ActivityListFragment f14224k = ActivityListFragment.f13535n.a(SensorPosition.FeedActivity, this);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final TrendFeedListFragment f14225l = new TrendFeedListFragment();

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final FeedRecommendFragment f14226m = new FeedRecommendFragment();

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f14227n = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(FeedContainerFragment.this);
        }
    });

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final Lazy f14228o = kotlin.c.b(new Function0<PopupWindow>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$sortPopupWindow$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PopupWindow invoke() {
            PopupWindow popupWindow = new PopupWindow();
            popupWindow.setWidth(-1);
            popupWindow.setHeight(-2);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            return popupWindow;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f14231r = kotlin.c.b(new Function0<FeedContainerViewPagerAdapter>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$feedAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FeedContainerViewPagerAdapter invoke() {
            FragmentManager childFragmentManager = FeedContainerFragment.this.getChildFragmentManager();
            kotlin.jvm.internal.s.h(childFragmentManager, "childFragmentManager");
            return new FeedContainerViewPagerAdapter(childFragmentManager);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14232s = kotlin.c.b(new Function0<View>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$darkAlphaBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final View invoke() {
            View view = new View(FeedContainerFragment.this.getContext());
            view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
            view.setBackgroundResource(R$color.app_black_30_alpha);
            return view;
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FeedContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class FeedTabType {
        private int index;

        @NotNull
        private String title;
        public static final FeedTabType ClubActivity = new ClubActivity("ClubActivity", 0);
        public static final FeedTabType Follow = new Follow("Follow", 1);
        public static final FeedTabType Recommend = new Recommend("Recommend", 2);
        private static final /* synthetic */ FeedTabType[] $VALUES = $values();

        /* compiled from: FeedContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class ClubActivity extends FeedTabType {
            public ClubActivity(String str, int i10) {
                super(str, i10, -1, "", null);
            }

            @Override // com.cupidapp.live.feed.fragment.FeedContainerFragment.FeedTabType
            public int getPageIndex() {
                return getIndex();
            }

            @Override // com.cupidapp.live.feed.fragment.FeedContainerFragment.FeedTabType
            @NotNull
            public String getPageName() {
                return "activity";
            }
        }

        /* compiled from: FeedContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Follow extends FeedTabType {
            public Follow(String str, int i10) {
                super(str, i10, 0, "", null);
            }

            @Override // com.cupidapp.live.feed.fragment.FeedContainerFragment.FeedTabType
            public int getPageIndex() {
                return getIndex();
            }

            @Override // com.cupidapp.live.feed.fragment.FeedContainerFragment.FeedTabType
            @NotNull
            public String getPageName() {
                return "follow";
            }
        }

        /* compiled from: FeedContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class Recommend extends FeedTabType {
            public Recommend(String str, int i10) {
                super(str, i10, 1, "", null);
            }

            @Override // com.cupidapp.live.feed.fragment.FeedContainerFragment.FeedTabType
            public int getPageIndex() {
                return getIndex();
            }

            @Override // com.cupidapp.live.feed.fragment.FeedContainerFragment.FeedTabType
            @NotNull
            public String getPageName() {
                return "recommend";
            }
        }

        private static final /* synthetic */ FeedTabType[] $values() {
            return new FeedTabType[]{ClubActivity, Follow, Recommend};
        }

        private FeedTabType(String str, int i10, int i11, String str2) {
            this.index = i11;
            this.title = str2;
        }

        public /* synthetic */ FeedTabType(String str, int i10, int i11, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i10, i11, str2);
        }

        public static FeedTabType valueOf(String str) {
            return (FeedTabType) Enum.valueOf(FeedTabType.class, str);
        }

        public static FeedTabType[] values() {
            return (FeedTabType[]) $VALUES.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public abstract /* synthetic */ int getPageIndex();

        @NotNull
        public abstract /* synthetic */ String getPageName();

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }

        public final void setTitle(@NotNull String str) {
            kotlin.jvm.internal.s.i(str, "<set-?>");
            this.title = str;
        }
    }

    /* compiled from: FeedContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void G1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b2(FeedContainerFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.E1(false, null);
        int i10 = R$id.feedContainerTitleLayout;
        ((FKTitleBarLayout) this$0.j1(i10)).b(true);
        ((FKTitleBarLayout) this$0.j1(i10)).m(FeedTabType.Follow.getPageIndex(), R$mipmap.ic_title_arrow_down);
    }

    @Override // com.cupidapp.live.feed.fragment.j
    public void C(int i10) {
        MapFloatLayout mapFloatLayout;
        if (i10 > 2) {
            MapFloatLayout mapFloatLayout2 = (MapFloatLayout) j1(R$id.feed_float_ll);
            if (mapFloatLayout2 != null) {
                mapFloatLayout2.g();
                return;
            }
            return;
        }
        if (i10 >= -2 || (mapFloatLayout = (MapFloatLayout) j1(R$id.feed_float_ll)) == null) {
            return;
        }
        mapFloatLayout.k();
    }

    @Override // com.cupidapp.live.club.fragment.d
    public void E0(boolean z10) {
        ((FKTitleBarLayout) j1(R$id.feedContainerTitleLayout)).setViewPagerTitleRedTip(FeedTabType.ClubActivity.getPageIndex(), z10);
    }

    public final void E1(boolean z10, Integer num) {
        Window window;
        FragmentActivity activity = getActivity();
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        if (decorView instanceof ViewGroup) {
            if (z10) {
                y.l(O1(), 0, Integer.valueOf(num != null ? num.intValue() : 0), 0, 0);
                ViewParent parent = O1().getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(O1());
                }
                ((ViewGroup) decorView).addView(O1());
                return;
            }
            ((ViewGroup) decorView).removeView(O1());
        }
    }

    public final void F1(int i10) {
        Observable<Long> observeOn = Observable.timer(i10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, kotlin.p> function1 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$bubbleTimedCancel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                invoke2(l10);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l10) {
                ImageLoaderView imageLoaderView = (ImageLoaderView) FeedContainerFragment.this.j1(R$id.feed_activity_img);
                if (imageLoaderView != null) {
                    imageLoaderView.setVisibility(8);
                }
                ImageView imageView = (ImageView) FeedContainerFragment.this.j1(R$id.feed_activity_close_img);
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(8);
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: com.cupidapp.live.feed.fragment.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedContainerFragment.G1(Function1.this, obj);
            }
        };
        final FeedContainerFragment$bubbleTimedCancel$2 feedContainerFragment$bubbleTimedCancel$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$bubbleTimedCancel$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.feed.fragment.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedContainerFragment.H1(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(subscribe, "private fun bubbleTimedC…   }, {})\n        )\n    }");
        H(subscribe);
    }

    public final void I1() {
        int i10 = this.f14229p;
        if (i10 == FeedTabType.Follow.getPageIndex()) {
            this.f14225l.K2();
        } else if (i10 == FeedTabType.Recommend.getPageIndex()) {
            this.f14226m.p1();
        }
    }

    public final void J1() {
        Disposable disposed = NetworkClient.f11868a.u().B().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedGroupEntryResult, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$configClubActivityTab$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedGroupEntryResult feedGroupEntryResult) {
                m2559invoke(feedGroupEntryResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2559invoke(FeedGroupEntryResult feedGroupEntryResult) {
                List list;
                List list2;
                int pageIndex;
                FeedContainerViewPagerAdapter P1;
                ActivityListFragment activityListFragment;
                int i10;
                int i11;
                ActivityListFragment activityListFragment2;
                int i12;
                ActivityListFragment activityListFragment3;
                ActivityListFragment activityListFragment4;
                FeedGroupEntryResult feedGroupEntryResult2 = feedGroupEntryResult;
                String groupActivityFeedEntryName = feedGroupEntryResult2.getGroupActivityFeedEntryName();
                if (groupActivityFeedEntryName == null || groupActivityFeedEntryName.length() == 0) {
                    return;
                }
                list = FeedContainerFragment.this.f14222i;
                FeedContainerFragment.FeedTabType feedTabType = FeedContainerFragment.FeedTabType.ClubActivity;
                if (list.contains(feedTabType)) {
                    if (!kotlin.jvm.internal.s.d(feedTabType.getTitle(), groupActivityFeedEntryName)) {
                        feedTabType.setTitle(groupActivityFeedEntryName);
                        ((FKTitleBarLayout) FeedContainerFragment.this.j1(R$id.feedContainerTitleLayout)).c(feedTabType.getPageIndex(), groupActivityFeedEntryName, true);
                        i12 = FeedContainerFragment.this.f14229p;
                        if (i12 == feedTabType.getPageIndex()) {
                            activityListFragment4 = FeedContainerFragment.this.f14224k;
                            activityListFragment4.q1();
                        } else {
                            activityListFragment3 = FeedContainerFragment.this.f14224k;
                            activityListFragment3.r1(true);
                        }
                    } else {
                        i11 = FeedContainerFragment.this.f14229p;
                        if (i11 == feedTabType.getPageIndex()) {
                            activityListFragment2 = FeedContainerFragment.this.f14224k;
                            activityListFragment2.p1(feedGroupEntryResult2.getGroupPayOrderUnread());
                        }
                    }
                    FeedContainerFragment.this.E0(feedGroupEntryResult2.getGroupPayOrderUnread());
                    FeedContainerFragment.this.Z1();
                    return;
                }
                FeedContainerFragment feedContainerFragment = FeedContainerFragment.this;
                int i13 = R$id.feedContainerViewPager;
                int currentItem = ((BaseViewPagerForShortVideo) feedContainerFragment.j1(i13)).getCurrentItem();
                list2 = FeedContainerFragment.this.f14222i;
                feedTabType.setTitle(groupActivityFeedEntryName);
                kotlin.p pVar = kotlin.p.f51048a;
                list2.add(0, feedTabType);
                feedTabType.setIndex(0);
                FeedContainerFragment.FeedTabType feedTabType2 = FeedContainerFragment.FeedTabType.Follow;
                feedTabType2.setIndex(1);
                FeedContainerFragment.FeedTabType feedTabType3 = FeedContainerFragment.FeedTabType.Recommend;
                feedTabType3.setIndex(2);
                FeedContainerFragment feedContainerFragment2 = FeedContainerFragment.this;
                if (currentItem == 0) {
                    pageIndex = feedTabType2.getPageIndex();
                } else {
                    pageIndex = feedTabType3.getPageIndex();
                }
                feedContainerFragment2.f14229p = pageIndex;
                FeedContainerFragment.this.K1();
                P1 = FeedContainerFragment.this.P1();
                activityListFragment = FeedContainerFragment.this.f14224k;
                P1.b(activityListFragment, 0);
                BaseViewPagerForShortVideo baseViewPagerForShortVideo = (BaseViewPagerForShortVideo) FeedContainerFragment.this.j1(i13);
                i10 = FeedContainerFragment.this.f14229p;
                baseViewPagerForShortVideo.setCurrentItem(i10, false);
                FeedContainerFragment.this.E0(feedGroupEntryResult2.getGroupPayOrderUnread());
                FeedContainerFragment.this.Z1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$configClubActivityTab$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FeedContainerFragment.this.Z1();
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void K1() {
        final FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
        List<FeedTabType> list = this.f14222i;
        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
        Iterator<FeedTabType> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getTitle());
        }
        fKTitleBarLayout.e(new com.cupidapp.live.base.view.p(arrayList, 0.0f, 0, 0, false, 30, null), (BaseViewPagerForShortVideo) j1(R$id.feedContainerViewPager), this.f14229p, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$configFeedContainerTitleLayout$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                TrendFeedListFragment trendFeedListFragment;
                TrendFeedListFragment trendFeedListFragment2;
                int i11;
                if (i10 == FeedContainerFragment.FeedTabType.ClubActivity.getPageIndex()) {
                    FKTitleBarLayout.this.m(FeedContainerFragment.FeedTabType.Follow.getPageIndex(), 0);
                    this.c2();
                } else {
                    FeedContainerFragment.FeedTabType feedTabType = FeedContainerFragment.FeedTabType.Follow;
                    if (i10 == feedTabType.getPageIndex()) {
                        if (kotlin.jvm.internal.s.d(p1.g.f52734a.w(), Boolean.TRUE)) {
                            FKTitleBarLayout.this.m(feedTabType.getPageIndex(), R$mipmap.ic_title_arrow_down);
                        } else {
                            FKTitleBarLayout.this.m(feedTabType.getPageIndex(), 0);
                        }
                        trendFeedListFragment = this.f14225l;
                        trendFeedListFragment.N1();
                        this.e2();
                        trendFeedListFragment2 = this.f14225l;
                        trendFeedListFragment2.M2();
                    } else {
                        FeedContainerFragment.FeedTabType feedTabType2 = FeedContainerFragment.FeedTabType.Recommend;
                        if (i10 == feedTabType2.getPageIndex()) {
                            FKTitleBarLayout.this.m(feedTabType.getPageIndex(), 0);
                            this.c2();
                            if (FKTitleBarLayout.this.j(feedTabType2.getPageIndex())) {
                                FKTitleBarLayout.this.setViewPagerTitleRedTip(feedTabType2.getPageIndex(), false);
                                GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.FIND_RED_DOT, null, null, 6, null);
                            }
                        }
                    }
                }
                i11 = this.f14229p;
                if (i11 != i10) {
                    this.X1();
                    this.f14229p = i10;
                    this.f14230q = System.currentTimeMillis();
                    this.W1();
                }
            }
        });
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$configFeedContainerTitleLayout$1$3
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
                NotifyActivity.a.b(NotifyActivity.f17492s, FeedContainerFragment.this.getContext(), NotifyPageType.Follow, false, 4, null);
            }
        });
        fKTitleBarLayout.setRightImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$configFeedContainerTitleLayout$1$4
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
                SensorScene N1;
                FragmentActivity activity = FeedContainerFragment.this.getActivity();
                if (activity != null) {
                    FeedContainerFragment feedContainerFragment = FeedContainerFragment.this;
                    feedContainerFragment.T1(activity);
                    SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                    N1 = feedContainerFragment.N1();
                    sensorsLogFeed.A(N1, feedContainerFragment.O0(), null);
                }
            }
        });
        fKTitleBarLayout.setTabClickCallback(new FeedContainerFragment$configFeedContainerTitleLayout$1$5(fKTitleBarLayout, this));
        if (kotlin.jvm.internal.s.d(p1.g.f52734a.w(), Boolean.TRUE)) {
            fKTitleBarLayout.m(FeedTabType.Follow.getPageIndex(), R$mipmap.ic_title_arrow_down);
        }
    }

    public final void L1() {
        Observable<Result<NearByFloatModel>> h10 = NetworkClient.f11868a.A().h();
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = h10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NearByFloatModel, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$configNearByFloat$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NearByFloatModel nearByFloatModel) {
                m2560invoke(nearByFloatModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2560invoke(NearByFloatModel nearByFloatModel) {
                TrendFeedListFragment trendFeedListFragment;
                FeedRecommendFragment feedRecommendFragment;
                TrendFeedListFragment trendFeedListFragment2;
                FeedRecommendFragment feedRecommendFragment2;
                NearByFloatModel nearByFloatModel2 = nearByFloatModel;
                MapOverPopResult result = nearByFloatModel2 != null ? nearByFloatModel2.getResult() : null;
                List<ImageModel> avatars = result != null ? result.getAvatars() : null;
                if (avatars == null || avatars.isEmpty()) {
                    ((MapFloatLayout) FeedContainerFragment.this.j1(R$id.feed_float_ll)).setVisibility(8);
                    trendFeedListFragment2 = FeedContainerFragment.this.f14225l;
                    if (trendFeedListFragment2 != null) {
                        trendFeedListFragment2.Q1(null);
                    }
                    feedRecommendFragment2 = FeedContainerFragment.this.f14226m;
                    if (feedRecommendFragment2 != null) {
                        feedRecommendFragment2.q1(null);
                        return;
                    }
                    return;
                }
                if (result != null) {
                    ((MapFloatLayout) FeedContainerFragment.this.j1(R$id.feed_float_ll)).f(result, OthersProtos.Enum_type.NEARBY_PEOPLE, z0.h.c(FeedContainerFragment.this, 166.0f));
                }
                trendFeedListFragment = FeedContainerFragment.this.f14225l;
                if (trendFeedListFragment != null) {
                    trendFeedListFragment.Q1(FeedContainerFragment.this);
                }
                feedRecommendFragment = FeedContainerFragment.this.f14226m;
                if (feedRecommendFragment != null) {
                    feedRecommendFragment.q1(FeedContainerFragment.this);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void M1() {
        this.f14222i.clear();
        int b4 = PersonalizedRecommendHelper.f18179a.b();
        List<FeedTabType> list = this.f14222i;
        FeedTabType feedTabType = FeedTabType.Follow;
        FeedSort x10 = p1.g.f52734a.x();
        String string = getString(x10 != null ? x10.getValueRes() : R$string.concern);
        kotlin.jvm.internal.s.h(string, "getString(LocalStore.fee…eRes ?: R.string.concern)");
        feedTabType.setTitle(string);
        list.add(feedTabType);
        List<FeedTabType> list2 = this.f14222i;
        FeedTabType feedTabType2 = FeedTabType.Recommend;
        String string2 = getString(b4);
        kotlin.jvm.internal.s.h(string2, "getString(recommendTitleResId)");
        feedTabType2.setTitle(string2);
        list2.add(feedTabType2);
        this.f14229p = feedTabType.getPageIndex();
        W1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14233t.clear();
    }

    public final SensorScene N1() {
        int i10 = this.f14229p;
        if (i10 == FeedTabType.Follow.getPageIndex()) {
            return SensorScene.Feed;
        }
        if (i10 == FeedTabType.Recommend.getPageIndex()) {
            return SensorScene.RecommendFeed;
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        int i10 = this.f14229p;
        return i10 == FeedTabType.Follow.getPageIndex() ? SensorPosition.Feed : i10 == FeedTabType.Recommend.getPageIndex() ? SensorPosition.RecommendFeed : SensorPosition.FeedActivity;
    }

    @NotNull
    public final View O1() {
        return (View) this.f14232s.getValue();
    }

    public final FeedContainerViewPagerAdapter P1() {
        return (FeedContainerViewPagerAdapter) this.f14231r.getValue();
    }

    public final xb.b Q1() {
        return (xb.b) this.f14227n.getValue();
    }

    public final PopupWindow R1() {
        return (PopupWindow) this.f14228o.getValue();
    }

    public final void S1(HashTag hashTag) {
        MediaPickerActivity.A.a(getActivity(), new MediaPickerActivityModel(hashTag != null ? hashTag.getSimpleHashTag() : null, true, -1, MediaType.ALL, null, null, null, null, O0(), CameraStartPosition.FeedPublish, 128, null));
    }

    public final void T1(FragmentActivity fragmentActivity) {
        FKRxPermissionAlertDialog.f12016a.m(fragmentActivity, Q1(), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$gotoPublish$1
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
                FeedContainerFragment.this.S1(null);
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    public final void U1(TextView textView, final FeedSort feedSort) {
        Context context = getContext();
        if (context != null) {
            if (p1.g.f52734a.x() == feedSort) {
                if (textView != null) {
                    textView.setSelected(true);
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(context, R$color.text_black));
                }
            } else {
                if (textView != null) {
                    textView.setSelected(false);
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(context, R$color.gray_7C7C7C));
                }
            }
            TextPaint paint = textView != null ? textView.getPaint() : null;
            if (paint != null) {
                paint.setFakeBoldText(true);
            }
            if (textView != null) {
                y.d(textView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$initItemView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        TrendFeedListFragment trendFeedListFragment;
                        PopupWindow R1;
                        trendFeedListFragment = FeedContainerFragment.this.f14225l;
                        if (trendFeedListFragment != null) {
                            trendFeedListFragment.p2(feedSort);
                        }
                        R1 = FeedContainerFragment.this.R1();
                        R1.dismiss();
                    }
                });
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void V0() {
        this.f14225l.F1();
    }

    public final void V1() {
        Observable<Result<FeedFloatBubbleModel>> m10 = NetworkClient.f11868a.l().m();
        Object context = getContext();
        FeedContainerFragment$loadActivity$2 feedContainerFragment$loadActivity$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$loadActivity$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = m10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedFloatBubbleModel, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$loadActivity$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedFloatBubbleModel feedFloatBubbleModel) {
                m2561invoke(feedFloatBubbleModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2561invoke(FeedFloatBubbleModel feedFloatBubbleModel) {
                final FloatBubbleResult floatBubble = feedFloatBubbleModel.getFloatBubble();
                if ((floatBubble != null ? floatBubble.getImage() : null) != null) {
                    int c4 = z0.h.c(FeedContainerFragment.this, 84.0f);
                    int scaleWidthByHeight = floatBubble.getImage().getScaleWidthByHeight(c4);
                    FeedContainerFragment feedContainerFragment = FeedContainerFragment.this;
                    int i10 = R$id.feed_activity_img;
                    ImageLoaderView feed_activity_img = (ImageLoaderView) feedContainerFragment.j1(i10);
                    kotlin.jvm.internal.s.h(feed_activity_img, "feed_activity_img");
                    y.n(feed_activity_img, Integer.valueOf(scaleWidthByHeight), Integer.valueOf(c4));
                    ImageLoaderView feed_activity_img2 = (ImageLoaderView) FeedContainerFragment.this.j1(i10);
                    kotlin.jvm.internal.s.h(feed_activity_img2, "feed_activity_img");
                    ImageLoaderView.g(feed_activity_img2, floatBubble.getImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
                    ((ImageLoaderView) FeedContainerFragment.this.j1(i10)).setVisibility(0);
                    ((ImageView) FeedContainerFragment.this.j1(R$id.feed_activity_close_img)).setVisibility(0);
                    GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.PRIDE_2023, null, 2, null);
                    ImageLoaderView feed_activity_img3 = (ImageLoaderView) FeedContainerFragment.this.j1(i10);
                    kotlin.jvm.internal.s.h(feed_activity_img3, "feed_activity_img");
                    final FeedContainerFragment feedContainerFragment2 = FeedContainerFragment.this;
                    y.d(feed_activity_img3, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$loadActivity$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FeedContainerFragment.this.getContext(), floatBubble.getUrl(), null, 4, null);
                            GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.PRIDE_2023, null, null, 6, null);
                        }
                    });
                } else {
                    ((ImageLoaderView) FeedContainerFragment.this.j1(R$id.feed_activity_img)).setVisibility(8);
                    ((ImageView) FeedContainerFragment.this.j1(R$id.feed_activity_close_img)).setVisibility(8);
                }
                if ((floatBubble != null ? floatBubble.getSecond() : 0) > 0) {
                    FeedContainerFragment.this.F1(floatBubble != null ? floatBubble.getSecond() : 0);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(feedContainerFragment$loadActivity$2, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void W0() {
        this.f14225l.O1();
    }

    public final void W1() {
        j1.c.b(j1.c.f50228a, O0(), null, null, 6, null);
        SensorsLogFeed.f12208a.w(O0());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void X0() {
        I1();
    }

    public final void X1() {
        if (this.f14230q != 0) {
            SensorsLogFeed.f12208a.h(O0(), (int) ((System.currentTimeMillis() - this.f14230q) / 1000));
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Y0(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "context");
        J1();
        f1();
        d2();
        p1.g gVar = p1.g.f52734a;
        if (gVar.A0() == 0) {
            new FKAppRatingLayout(context).p(RateScene.LeaveNotify);
        }
        e1(BottomTabName.Feed);
        if (this.f14229p == FeedTabType.Follow.getPageIndex() && gVar.J()) {
            this.f14225l.K2();
        }
    }

    public final void Y1() {
        Context context;
        User X = p1.g.f52734a.X();
        if ((X != null ? X.getPostCount() : 0) < 5 || (context = getContext()) == null) {
            return;
        }
        new FKAppRatingLayout(context).p(RateScene.PublishNewFeed);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Z0() {
        this.f14225l.T1();
        com.cupidapp.live.feed.helper.c.f14310a.b();
    }

    public final void Z1() {
        View g3;
        Context context = getContext();
        if (context == null || (g3 = ((FKTitleBarLayout) j1(R$id.feedContainerTitleLayout)).g(FeedTabType.Recommend.getPageIndex())) == null) {
            return;
        }
        com.cupidapp.live.base.utils.t.f12377a.d(g3, context);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void a1(@Nullable String str) {
        super.a1(str);
        if (str == null) {
            return;
        }
        int i10 = R$id.feedContainerViewPager;
        if (((BaseViewPagerForShortVideo) j1(i10)) == null) {
            return;
        }
        Locale ENGLISH = Locale.ENGLISH;
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase = str.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase2 = "Follow".toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        if (kotlin.jvm.internal.s.d(lowerCase, lowerCase2)) {
            ((BaseViewPagerForShortVideo) j1(i10)).setCurrentItem(FeedTabType.Follow.getPageIndex());
            return;
        }
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase3 = "Recommend".toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
        if (kotlin.jvm.internal.s.d(lowerCase, lowerCase3)) {
            ((BaseViewPagerForShortVideo) j1(i10)).setCurrentItem(FeedTabType.Recommend.getPageIndex());
            return;
        }
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase4 = "ClubActivity".toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
        if (kotlin.jvm.internal.s.d(lowerCase, lowerCase4)) {
            List<FeedTabType> list = this.f14222i;
            FeedTabType feedTabType = FeedTabType.ClubActivity;
            if (list.contains(feedTabType)) {
                ((BaseViewPagerForShortVideo) j1(i10)).setCurrentItem(feedTabType.getPageIndex());
            }
        }
    }

    public final void a2(View view, int i10) {
        View inflate = View.inflate(getContext(), R$layout.dialog_feed_sort, null);
        TextView textView = (TextView) inflate.findViewById(R$id.concernTxt);
        TextView textView2 = (TextView) inflate.findViewById(R$id.newTxt);
        TextView textView3 = (TextView) inflate.findViewById(R$id.close_friend_txt);
        TextView textView4 = (TextView) inflate.findViewById(R$id.focus_txt);
        U1(textView2, FeedSort.Time);
        U1(textView, FeedSort.Intimacy);
        U1(textView3, FeedSort.CloseFriend);
        textView4.setVisibility(0);
        U1(textView4, FeedSort.Focus);
        R1().setContentView(inflate);
        R1().showAsDropDown(view);
        R1().setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.cupidapp.live.feed.fragment.e
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                FeedContainerFragment.b2(FeedContainerFragment.this);
            }
        });
        ((FKTitleBarLayout) j1(R$id.feedContainerTitleLayout)).b(false);
        E1(true, Integer.valueOf(i10 + z0.h.c(this, 68.0f)));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void b1(long j10) {
        User user;
        FeedModel m12 = this.f14225l.m1();
        j1.k.f50238a.a(SensorPosition.Feed, m12 != null ? m12.getFeedContentType() : null, (m12 == null || (user = m12.getUser()) == null) ? null : user.userId(), j10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void c1(boolean z10) {
        User user;
        int i10 = this.f14229p;
        if (i10 == FeedTabType.Follow.getPageIndex()) {
            FeedModel m12 = this.f14225l.m1();
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.Feed;
            String str = null;
            String feedContentType = m12 != null ? m12.getFeedContentType() : null;
            if (m12 != null && (user = m12.getUser()) != null) {
                str = user.userId();
            }
            kVar.c(sensorPosition, feedContentType, str, z10);
            return;
        }
        if (i10 == FeedTabType.Recommend.getPageIndex()) {
            j1.k.f50238a.d(SensorPosition.RecommendFeed, z10);
        }
    }

    public final void c2() {
        this.f14225l.F1();
    }

    public final void d2() {
        if (this.f14223j.size() > 0 && this.f14229p == FeedTabType.Follow.getPageIndex()) {
            this.f14225l.S1();
            this.f14225l.N1();
        }
    }

    public final void e2() {
        this.f14225l.O1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void f1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
        if (fKTitleBarLayout != null) {
            fKTitleBarLayout.setLeftImageUnreadCount(p1.g.f52734a.A0());
        }
    }

    @Nullable
    public View j1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14233t;
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        Bundle extras;
        super.onActivityResult(i10, i11, intent);
        if (i10 != 1) {
            if (i10 == 1212 && i11 == -1) {
                Y1();
                return;
            }
            return;
        }
        if (i11 == -1) {
            Serializable serializable = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable("select_hashtag_result");
            S1(serializable instanceof HashTag ? (HashTag) serializable : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_feed_container, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChangeFeedSortEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
        if (fKTitleBarLayout != null) {
            FeedTabType feedTabType = FeedTabType.Follow;
            int pageIndex = feedTabType.getPageIndex();
            FeedSort x10 = p1.g.f52734a.x();
            String string = getString(x10 != null ? x10.getValueRes() : R$string.concern);
            kotlin.jvm.internal.s.h(string, "getString(LocalStore.fee…eRes ?: R.string.concern)");
            fKTitleBarLayout.c(pageIndex, string, this.f14229p != feedTabType.getPageIndex());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            X1();
        } else {
            W1();
            this.f14230q = System.currentTimeMillis();
            if (this.f14229p == FeedTabType.Follow.getPageIndex()) {
                this.f14225l.M2();
            }
        }
        if (this.f14229p == FeedTabType.Follow.getPageIndex()) {
            EventBus.c().l(new com.cupidapp.live.feed.layout.i(!z10));
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isVisible()) {
            X1();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            this.f14230q = System.currentTimeMillis();
            if (this.f14229p == FeedTabType.Follow.getPageIndex()) {
                this.f14225l.M2();
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        M1();
        K1();
        int i10 = R$id.feedContainerViewPager;
        ((BaseViewPagerForShortVideo) j1(i10)).setAdapter(P1());
        ((BaseViewPagerForShortVideo) j1(i10)).setCanScrollCheck(new Function2<Integer, Integer, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$onViewCreated$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Boolean mo1743invoke(@Nullable Integer num, @Nullable Integer num2) {
                return Boolean.valueOf((num == null || num2 == null) ? false : true);
            }
        });
        this.f14223j.clear();
        this.f14223j.add(this.f14225l);
        this.f14223j.add(this.f14226m);
        P1().c(this.f14223j);
        V1();
        ImageView feed_activity_close_img = (ImageView) j1(R$id.feed_activity_close_img);
        kotlin.jvm.internal.s.h(feed_activity_close_img, "feed_activity_close_img");
        y.d(feed_activity_close_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedContainerFragment$onViewCreated$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                ((ImageLoaderView) FeedContainerFragment.this.j1(R$id.feed_activity_img)).setVisibility(8);
                ((ImageView) FeedContainerFragment.this.j1(R$id.feed_activity_close_img)).setVisibility(8);
            }
        });
        L1();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FeedSortSwitchEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        int i10 = this.f14229p;
        FeedTabType feedTabType = FeedTabType.Follow;
        if (i10 == feedTabType.getPageIndex() && kotlin.jvm.internal.s.d(p1.g.f52734a.w(), Boolean.TRUE)) {
            FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
            if (fKTitleBarLayout != null) {
                fKTitleBarLayout.m(feedTabType.getPageIndex(), R$mipmap.ic_title_arrow_down);
                return;
            }
            return;
        }
        FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
        if (fKTitleBarLayout2 != null) {
            fKTitleBarLayout2.m(feedTabType.getPageIndex(), 0);
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull TabRedDotEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (event.getSensorPosition() == SensorPosition.RecommendFeed) {
            if (event.isShow()) {
                GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.FIND_RED_DOT, null, 2, null);
            }
            int i10 = this.f14229p;
            FeedTabType feedTabType = FeedTabType.Recommend;
            if (i10 == feedTabType.getPageIndex() && event.isShow()) {
                FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
                if (fKTitleBarLayout != null) {
                    fKTitleBarLayout.setViewPagerTitleRedTip(feedTabType.getPageIndex(), false);
                    return;
                }
                return;
            }
            FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) j1(R$id.feedContainerTitleLayout);
            if (fKTitleBarLayout2 != null) {
                fKTitleBarLayout2.setViewPagerTitleRedTip(feedTabType.getPageIndex(), event.isShow());
            }
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowGuideOpenPushDialogAfterPublishFeedEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        Context context = getContext();
        if (context != null) {
            FKGuideOpenPushDialogLayout.f11679c.a(context, event.getModel(), O0());
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ChangeFeedTabEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        a1(event.getTabName());
    }
}
