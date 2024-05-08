package com.cupidapp.live.hashtag.detail;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$menu;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.share.view.b;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.HashTagInfoResult;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.activity.MediaPickerActivity;
import com.cupidapp.live.mediapicker.event.FeedPublishSuccessEvent;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.MediaPickerActivityModel;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: HashTagMainActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagMainActivity extends FKBaseActivity {

    @NotNull
    public static final a A = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public boolean f14684q;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14687t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public HashTag f14688u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public String f14689v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public String f14690w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public FKSensorContext f14691x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public SectionsPagerAdapter f14692y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14693z = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f14685r = kotlin.c.b(new Function0<AppBarLayout.OnOffsetChangedListener>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$onOffsetChangedListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AppBarLayout.OnOffsetChangedListener invoke() {
            AppBarLayout.OnOffsetChangedListener I1;
            I1 = HashTagMainActivity.this.I1();
            return I1;
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14686s = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(HashTagMainActivity.this);
        }
    });

    /* compiled from: HashTagMainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String hashTagId, @Nullable String str, @NotNull FeedSensorContext lastPageSensorContext) {
            s.i(context, "context");
            s.i(hashTagId, "hashTagId");
            s.i(lastPageSensorContext, "lastPageSensorContext");
            Intent intent = new Intent(context, (Class<?>) HashTagMainActivity.class);
            intent.putExtra("hashTagId", hashTagId);
            intent.putExtra("hashTagName", str);
            intent.putExtra(FeedSensorContext.class.getSimpleName(), lastPageSensorContext);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: HashTagMainActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.share.view.b {
        public b() {
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void a(@NotNull ShareItemHandledResult shareItemHandledResult) {
            b.a.a(this, shareItemHandledResult);
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void b(@NotNull ShareBaseType type) {
            HashTag hashTag;
            s.i(type, "type");
            if (!(type instanceof SharePlatform) || (hashTag = HashTagMainActivity.this.f14688u) == null) {
                return;
            }
            HashTagMainActivity.this.C1(hashTag);
        }
    }

    public static final void G1(HashTagMainActivity this$0) {
        s.i(this$0, "this$0");
        this$0.onRefresh();
    }

    public static final void H1(HashTagMainActivity this$0, View view) {
        s.i(this$0, "this$0");
        HashTag hashTag = this$0.f14688u;
        if (hashTag != null) {
            this$0.B1(hashTag);
        }
    }

    public static final void J1(HashTagMainActivity this$0, AppBarLayout appBarLayout, int i10) {
        HashTagFragment a10;
        s.i(this$0, "this$0");
        SectionsPagerAdapter sectionsPagerAdapter = this$0.f14692y;
        if (sectionsPagerAdapter != null && (a10 = sectionsPagerAdapter.a()) != null) {
            a10.r1();
        }
        if (appBarLayout.getTotalScrollRange() - Math.abs(i10) < 5) {
            this$0.x1(true);
        } else {
            this$0.x1(false);
        }
    }

    public static final void L1(HashTagMainActivity this$0, int i10) {
        s.i(this$0, "this$0");
        int i11 = R$id.toolbar;
        MaterialToolbar toolbar = (MaterialToolbar) this$0.p1(i11);
        s.h(toolbar, "toolbar");
        com.cupidapp.live.base.view.s.a(toolbar, i10);
        ((CollapsingToolbarLayout) this$0.p1(R$id.toolbar_layout)).setScrimVisibleHeightTrigger(i10 + ((MaterialToolbar) this$0.p1(i11)).getHeight() + h.c(this$0, 5.0f));
    }

    public static final void M1(HashTagMainActivity this$0, View view) {
        s.i(this$0, "this$0");
        this$0.finish();
    }

    public static final boolean N1(HashTagMainActivity this$0, MenuItem menuItem) {
        HashTagFragment a10;
        FeedModel j12;
        s.i(this$0, "this$0");
        HashTag hashTag = this$0.f14688u;
        if (hashTag == null) {
            return true;
        }
        com.cupidapp.live.base.share.helper.d dVar = com.cupidapp.live.base.share.helper.d.f12255a;
        s.f(hashTag);
        SectionsPagerAdapter sectionsPagerAdapter = this$0.f14692y;
        ShareBuilder e2 = dVar.e(this$0, hashTag, (sectionsPagerAdapter == null || (a10 = sectionsPagerAdapter.a()) == null || (j12 = a10.j1()) == null) ? null : j12.getImageListFirst(), this$0.y1());
        if (e2 == null) {
            return true;
        }
        ShareBottomFragment a11 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        s.h(supportFragmentManager, "supportFragmentManager");
        a11.v1(supportFragmentManager, new ShareModel(null, null, e2, null, null, this$0.y1(), null, null, null, null, null, 2011, null), new b());
        return true;
    }

    public final xb.b A1() {
        return (xb.b) this.f14686s.getValue();
    }

    public final void B1(final HashTag hashTag) {
        FKRxPermissionAlertDialog.f12016a.m(this, A1(), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$gotoMediaPickerActivity$1
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
                SensorPosition y1;
                HashTagSimpleModel simpleHashTag = HashTag.this.getSimpleHashTag();
                MediaType mediaType = MediaType.ALL;
                y1 = this.y1();
                MediaPickerActivity.A.a(this, new MediaPickerActivityModel(simpleHashTag, false, -1, mediaType, null, null, null, null, y1, CameraStartPosition.FeedPublish, 242, null));
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
        SensorsLogFeed.f12208a.A(SensorScene.Hashtag, y1(), null);
    }

    public final void C1(HashTag hashTag) {
        com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
        String itemId = hashTag.getItemId();
        UserActionType userActionType = UserActionType.Share;
        SensorPosition y1 = y1();
        FKSensorContext fKSensorContext = this.f14691x;
        hVar.e(itemId, null, userActionType, y1, fKSensorContext != null ? fKSensorContext.getPosition() : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
    }

    public final void D1(HashTag hashTag) {
        if (TextUtils.isEmpty(hashTag.getUrl())) {
            return;
        }
        j.f12156c.a(this, hashTag.getUrl(), new WebStyleViewModel(WebStyleEnum.CardStyle, false, null, 6, null));
    }

    public final void E1() {
        String str = this.f14689v;
        if (str != null) {
            Disposable disposed = NetworkClient.f11868a.l().t(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<HashTagInfoResult, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$initData$lambda$5$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(HashTagInfoResult hashTagInfoResult) {
                    m2590invoke(hashTagInfoResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2590invoke(HashTagInfoResult hashTagInfoResult) {
                    HashTagInfoResult hashTagInfoResult2 = hashTagInfoResult;
                    HashTagMainActivity.this.f14688u = hashTagInfoResult2.getHashtag();
                    HashTagMainActivity.this.P1(hashTagInfoResult2.getHashtag());
                    HashTagMainActivity.this.invalidateOptionsMenu();
                    ((FKSwipeRefreshLayout) HashTagMainActivity.this.p1(R$id.hashtagMainRefreshLayout)).setRefreshing(false);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$initData$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    ((FKSwipeRefreshLayout) HashTagMainActivity.this.p1(R$id.hashtagMainRefreshLayout)).setRefreshing(false);
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void F1() {
        ((FKSwipeRefreshLayout) p1(R$id.hashtagMainRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.hashtag.detail.e
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HashTagMainActivity.G1(HashTagMainActivity.this);
            }
        });
        ((TextView) p1(R$id.fab)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.hashtag.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HashTagMainActivity.H1(HashTagMainActivity.this, view);
            }
        });
    }

    public final AppBarLayout.OnOffsetChangedListener I1() {
        return new AppBarLayout.OnOffsetChangedListener() { // from class: com.cupidapp.live.hashtag.detail.f
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
                HashTagMainActivity.J1(HashTagMainActivity.this, appBarLayout, i10);
            }
        };
    }

    public final void K1() {
        final int m10 = h.m(this);
        int i10 = R$id.toolbar;
        ((MaterialToolbar) p1(i10)).post(new Runnable() { // from class: com.cupidapp.live.hashtag.detail.g
            @Override // java.lang.Runnable
            public final void run() {
                HashTagMainActivity.L1(HashTagMainActivity.this, m10);
            }
        });
        setSupportActionBar((MaterialToolbar) p1(i10));
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        ((MaterialToolbar) p1(i10)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.hashtag.detail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HashTagMainActivity.M1(HashTagMainActivity.this, view);
            }
        });
        ((MaterialToolbar) p1(i10)).setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.cupidapp.live.hashtag.detail.d
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean N1;
                N1 = HashTagMainActivity.N1(HashTagMainActivity.this, menuItem);
                return N1;
            }
        });
        ((AppBarLayout) p1(R$id.appbarLayout)).addOnOffsetChangedListener(z1());
    }

    public final void O1() {
        String str = this.f14689v;
        if (str == null) {
            return;
        }
        String str2 = this.f14690w;
        s.f(str);
        FKSensorContext fKSensorContext = this.f14691x;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        s.h(supportFragmentManager, "supportFragmentManager");
        this.f14692y = new SectionsPagerAdapter(str2, str, fKSensorContext, this, supportFragmentManager, 1);
        int i10 = R$id.viewPager;
        ((ViewPager) p1(i10)).setAdapter(this.f14692y);
        ((TabLayout) p1(R$id.tabs)).setupWithViewPager((ViewPager) p1(i10));
    }

    public final void P1(final HashTag hashTag) {
        ((TextView) p1(R$id.titleTxt)).setText(hashTag.getName());
        ((TextView) p1(R$id.subTitleTxt)).setText(hashTag.getCountDesc());
        ((TextView) p1(R$id.contentTitle)).setText(hashTag.getName());
        ((TextView) p1(R$id.contentCount)).setText(hashTag.getCountDesc());
        ((TextView) p1(R$id.contentDesc)).setText(hashTag.getSummary());
        if (hashTag.getBackgroundImage() == null) {
            this.f14687t = false;
            LinearLayout contentDes = (LinearLayout) p1(R$id.contentDes);
            s.h(contentDes, "contentDes");
            com.cupidapp.live.base.view.s.a(contentDes, ((MaterialToolbar) p1(R$id.toolbar)).getHeight());
        } else {
            this.f14687t = true;
            ImageModel backgroundImage = hashTag.getBackgroundImage();
            int scaleHeightByWidth = backgroundImage.getScaleHeightByWidth(h.l(this));
            int i10 = R$id.headImageView;
            ImageLoaderView headImageView = (ImageLoaderView) p1(i10);
            s.h(headImageView, "headImageView");
            y.o(headImageView, null, Integer.valueOf(scaleHeightByWidth), 1, null);
            ImageLoaderView headImageView2 = (ImageLoaderView) p1(i10);
            s.h(headImageView2, "headImageView");
            ImageLoaderView.g(headImageView2, backgroundImage, null, null, 6, null);
            ImageLoaderView headImageView3 = (ImageLoaderView) p1(i10);
            s.h(headImageView3, "headImageView");
            y.d(headImageView3, new Function1<View, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$renderHashTagContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    HashTagMainActivity.this.D1(hashTag);
                }
            });
        }
        if (hashTag.getBannerImage() == null) {
            ((ImageLoaderView) p1(R$id.hashTagBannerImg)).setVisibility(8);
            return;
        }
        int i11 = R$id.hashTagBannerImg;
        ViewGroup.LayoutParams layoutParams = ((ImageLoaderView) p1(i11)).getLayoutParams();
        int c4 = h.c(this, 16.0f);
        layoutParams.width = h.l(this) - c4;
        layoutParams.height = hashTag.getBannerImage().getScaleHeightByWidth(h.l(this) - c4);
        ((ImageLoaderView) p1(i11)).setLayoutParams(layoutParams);
        ImageLoaderView hashTagBannerImg = (ImageLoaderView) p1(i11);
        s.h(hashTagBannerImg, "hashTagBannerImg");
        ImageLoaderView.g(hashTagBannerImg, hashTag.getBannerImage(), null, null, 6, null);
        ((ImageLoaderView) p1(i11)).setVisibility(0);
        ImageLoaderView hashTagBannerImg2 = (ImageLoaderView) p1(i11);
        s.h(hashTagBannerImg2, "hashTagBannerImg");
        y.d(hashTagBannerImg2, new Function1<View, p>() { // from class: com.cupidapp.live.hashtag.detail.HashTagMainActivity$renderHashTagContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                j.f12156c.a(HashTagMainActivity.this, hashTag.getBannerUrl(), new WebStyleViewModel(WebStyleEnum.CardStyle, false, null, 6, null));
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_hashtag_main);
        Intent intent = getIntent();
        s.h(intent, "intent");
        this.f14691x = (FKSensorContext) z0.g.a(intent, FeedSensorContext.class);
        this.f14689v = getIntent().getStringExtra("hashTagId");
        this.f14690w = getIntent().getStringExtra("hashTagName");
        K1();
        O1();
        F1();
        E1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        getMenuInflater().inflate(R$menu.menu_share, menu);
        return true;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RecyclerExposureHelper.a aVar = RecyclerExposureHelper.f12092j;
        aVar.c(ExposureScene.HashtagHot);
        aVar.c(ExposureScene.HashtagNew);
        ((AppBarLayout) p1(R$id.appbarLayout)).removeOnOffsetChangedListener(z1());
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FeedPublishSuccessEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        ((ViewPager) p1(R$id.viewPager)).setCurrentItem(1);
        onRefresh();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        int color;
        MenuItem findItem;
        Drawable icon;
        if (this.f14687t && !this.f14684q) {
            color = ContextCompat.getColor(getBaseContext(), R$color.app_white);
        } else {
            color = ContextCompat.getColor(getBaseContext(), R$color.app_black);
        }
        Drawable navigationIcon = ((MaterialToolbar) p1(R$id.toolbar)).getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        if (menu != null && (findItem = menu.findItem(R$id.action_share)) != null && (icon = findItem.getIcon()) != null) {
            icon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public final void onRefresh() {
        HashTagFragment a10;
        E1();
        SectionsPagerAdapter sectionsPagerAdapter = this.f14692y;
        if (sectionsPagerAdapter == null || (a10 = sectionsPagerAdapter.a()) == null) {
            return;
        }
        a10.p1(null, Boolean.TRUE);
    }

    @Nullable
    public View p1(int i10) {
        Map<Integer, View> map = this.f14693z;
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

    public final void x1(boolean z10) {
        if (this.f14684q != z10) {
            this.f14684q = z10;
            if (z10) {
                invalidateOptionsMenu();
                ((LinearLayout) p1(R$id.titleLayout)).setVisibility(0);
            } else {
                invalidateOptionsMenu();
                ((LinearLayout) p1(R$id.titleLayout)).setVisibility(4);
            }
        }
    }

    public final SensorPosition y1() {
        int i10 = R$id.tabs;
        if (((TabLayout) p1(i10)).getSelectedTabPosition() < com.cupidapp.live.hashtag.detail.a.a().length && ((TabLayout) p1(i10)).getSelectedTabPosition() >= 0) {
            return com.cupidapp.live.hashtag.detail.a.a()[((TabLayout) p1(i10)).getSelectedTabPosition()].getThird();
        }
        return com.cupidapp.live.hashtag.detail.a.a()[0].getThird();
    }

    public final AppBarLayout.OnOffsetChangedListener z1() {
        return (AppBarLayout.OnOffsetChangedListener) this.f14685r.getValue();
    }
}
