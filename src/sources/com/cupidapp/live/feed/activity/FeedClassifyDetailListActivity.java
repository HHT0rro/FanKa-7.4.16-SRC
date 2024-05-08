package com.cupidapp.live.feed.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKRecyclerTitleLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.FKTitleViewModel;
import com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$pageCallback$2;
import com.cupidapp.live.feed.adapter.FeedClassifyPagerAdapter;
import com.cupidapp.live.feed.model.TopShowGuideModel;
import com.cupidapp.live.feed.viewmodel.ClassifyFeedTabViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyDetailListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyDetailListActivity extends FKBaseActivity {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f14021x = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f14026u;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14028w = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14022q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$tagId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String stringExtra = FeedClassifyDetailListActivity.this.getIntent().getStringExtra("tagId");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f14023r = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$tagName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FeedClassifyDetailListActivity.this.getIntent().getStringExtra("tagName");
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f14024s = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$defaultSelectTab$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FeedClassifyDetailListActivity.this.getIntent().getStringExtra("tab");
        }
    });

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f14025t = kotlin.c.b(new Function0<FeedSensorContext>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FeedSensorContext invoke() {
            FeedSensorContext feedSensorContext = (FeedSensorContext) FeedClassifyDetailListActivity.this.getIntent().getStringExtra("feedSensorContext");
            return feedSensorContext == null ? new FeedSensorContext(SensorPosition.FindPageCategory, SensorPosition.RecommendFeed, null, SensorScene.RecommendFeed) : feedSensorContext;
        }
    });

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Lazy f14027v = kotlin.c.b(new Function0<FeedClassifyDetailListActivity$pageCallback$2.AnonymousClass1>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$pageCallback$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$pageCallback$2$1] */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AnonymousClass1 invoke() {
            final FeedClassifyDetailListActivity feedClassifyDetailListActivity = FeedClassifyDetailListActivity.this;
            return new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$pageCallback$2.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i10) {
                    ((FKRecyclerTitleLayout) FeedClassifyDetailListActivity.this.l1(R$id.classify_tab)).g(i10);
                }
            };
        }
    });

    /* compiled from: FeedClassifyDetailListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull String tagId, @NotNull String tagName, @Nullable String str, @NotNull FeedSensorContext sensorContext) {
            kotlin.jvm.internal.s.i(tagId, "tagId");
            kotlin.jvm.internal.s.i(tagName, "tagName");
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            Intent intent = new Intent(context, (Class<?>) FeedClassifyDetailListActivity.class);
            intent.putExtra("tagId", tagId);
            intent.putExtra("tagName", tagName);
            intent.putExtra("tab", str);
            intent.putExtra("feedSensorContext", sensorContext);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public FeedClassifyDetailListActivity() {
        final Function0 function0 = null;
        this.f14026u = new ViewModelLazy(kotlin.jvm.internal.v.b(ClassifyFeedTabViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void v1(FeedClassifyDetailListActivity this$0, ClassifyTabUiModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        List<FKTitleViewModel> tabs = it.getTabs();
        if (tabs == null || tabs.isEmpty()) {
            this$0.m1();
        } else {
            kotlin.jvm.internal.s.h(it, "it");
            this$0.n1(it);
        }
    }

    public static final void w1(final FeedClassifyDetailListActivity this$0, final TopShowGuideModel topShowGuideModel) {
        ImageModel icon;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        String title = topShowGuideModel != null ? topShowGuideModel.getTitle() : null;
        if (title == null || title.length() == 0) {
            ((LinearLayout) this$0.l1(R$id.classify_ad_top_tip)).setVisibility(8);
            return;
        }
        int i10 = R$id.classify_ad_top_tip;
        ((LinearLayout) this$0.l1(i10)).setVisibility(0);
        Integer valueOf = (topShowGuideModel == null || (icon = topShowGuideModel.getIcon()) == null) ? null : Integer.valueOf(icon.getScaleWidthByHeight(z0.h.c(this$0, 20.0f)));
        int i11 = R$id.classify_ad_icon;
        ImageLoaderView classify_ad_icon = (ImageLoaderView) this$0.l1(i11);
        kotlin.jvm.internal.s.h(classify_ad_icon, "classify_ad_icon");
        z0.y.o(classify_ad_icon, valueOf, null, 2, null);
        ImageLoaderView classify_ad_icon2 = (ImageLoaderView) this$0.l1(i11);
        kotlin.jvm.internal.s.h(classify_ad_icon2, "classify_ad_icon");
        ImageLoaderView.g(classify_ad_icon2, topShowGuideModel != null ? topShowGuideModel.getIcon() : null, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, ContextCompat.getColor(this$0, R$color.app_transparent), 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
        ((TextView) this$0.l1(R$id.classify_ad_title)).setText(topShowGuideModel != null ? topShowGuideModel.getTitle() : null);
        LinearLayout classify_ad_top_tip = (LinearLayout) this$0.l1(i10);
        kotlin.jvm.internal.s.h(classify_ad_top_tip, "classify_ad_top_tip");
        z0.y.d(classify_ad_top_tip, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$initObserve$2$1
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
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                FeedClassifyDetailListActivity feedClassifyDetailListActivity = FeedClassifyDetailListActivity.this;
                TopShowGuideModel topShowGuideModel2 = topShowGuideModel;
                j.a.b(aVar, feedClassifyDetailListActivity, topShowGuideModel2 != null ? topShowGuideModel2.getJumpUrl() : null, null, 4, null);
            }
        });
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f14028w;
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

    public final void m1() {
        ((FKRecyclerTitleLayout) l1(R$id.classify_tab)).setVisibility(8);
        ViewPager2 viewPager2 = (ViewPager2) l1(R$id.view_pager);
        FeedSensorContext q12 = q1();
        String tagId = r1();
        kotlin.jvm.internal.s.h(tagId, "tagId");
        viewPager2.setAdapter(new FeedClassifyPagerAdapter(q12, tagId, null, this));
    }

    public final void n1(ClassifyTabUiModel classifyTabUiModel) {
        int i10 = R$id.classify_tab;
        ((FKRecyclerTitleLayout) l1(i10)).setVisibility(0);
        int i11 = R$id.view_pager;
        ViewPager2 viewPager2 = (ViewPager2) l1(i11);
        FeedSensorContext q12 = q1();
        String tagId = r1();
        kotlin.jvm.internal.s.h(tagId, "tagId");
        viewPager2.setAdapter(new FeedClassifyPagerAdapter(q12, tagId, classifyTabUiModel.getTabIds(), this));
        ((ViewPager2) l1(i11)).setOffscreenPageLimit((classifyTabUiModel.getTabIds() != null ? r4.size() : 2) - 1);
        List<FKTitleViewModel> tabs = classifyTabUiModel.getTabs();
        if (tabs != null) {
            FKRecyclerTitleLayout classify_tab = (FKRecyclerTitleLayout) l1(i10);
            kotlin.jvm.internal.s.h(classify_tab, "classify_tab");
            FKRecyclerTitleLayout.d(classify_tab, tabs, 0, 2, null);
        }
        ViewPager2 viewPager22 = (ViewPager2) l1(i11);
        List<String> tabIds = classifyTabUiModel.getTabIds();
        viewPager22.setCurrentItem(tabIds != null ? CollectionsKt___CollectionsKt.Y(tabIds, o1()) : 0);
    }

    public final String o1() {
        return (String) this.f14024s.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_classify_feed);
        String tagId = r1();
        kotlin.jvm.internal.s.h(tagId, "tagId");
        if (tagId.length() == 0) {
            finish();
            return;
        }
        x1();
        ClassifyFeedTabViewModel t12 = t1();
        String tagId2 = r1();
        kotlin.jvm.internal.s.h(tagId2, "tagId");
        t12.loadTab(tagId2, o1());
        u1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ViewPager2 viewPager2 = (ViewPager2) l1(R$id.view_pager);
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(p1());
        }
        super.onDestroy();
    }

    @NotNull
    public final ViewPager2.OnPageChangeCallback p1() {
        return (ViewPager2.OnPageChangeCallback) this.f14027v.getValue();
    }

    public final FeedSensorContext q1() {
        return (FeedSensorContext) this.f14025t.getValue();
    }

    public final String r1() {
        return (String) this.f14022q.getValue();
    }

    public final String s1() {
        return (String) this.f14023r.getValue();
    }

    public final ClassifyFeedTabViewModel t1() {
        return (ClassifyFeedTabViewModel) this.f14026u.getValue();
    }

    public final void u1() {
        t1().getTopAdLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.feed.activity.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedClassifyDetailListActivity.v1(FeedClassifyDetailListActivity.this, (ClassifyTabUiModel) obj);
            }
        });
        t1().getAdEntranceLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.feed.activity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedClassifyDetailListActivity.w1(FeedClassifyDetailListActivity.this, (TopShowGuideModel) obj);
            }
        });
    }

    public final void x1() {
        FKTitleBarLayout initView$lambda$2 = (FKTitleBarLayout) l1(R$id.classify_title_layout);
        kotlin.jvm.internal.s.h(initView$lambda$2, "initView$lambda$2");
        FKTitleBarLayout.setSingleTitle$default(initView$lambda$2, s1(), null, 2, null);
        initView$lambda$2.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$initView$1$1
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
                FeedClassifyDetailListActivity.this.finish();
            }
        });
        ViewPager2 viewPager2 = (ViewPager2) l1(R$id.view_pager);
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(p1());
        }
        ((FKRecyclerTitleLayout) l1(R$id.classify_tab)).setTitleClickListener(new Function2<Integer, FKTitleViewModel, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedClassifyDetailListActivity$initView$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, FKTitleViewModel fKTitleViewModel) {
                invoke(num.intValue(), fKTitleViewModel);
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10, @NotNull FKTitleViewModel fKTitleViewModel) {
                kotlin.jvm.internal.s.i(fKTitleViewModel, "<anonymous parameter 1>");
                ((ViewPager2) FeedClassifyDetailListActivity.this.l1(R$id.view_pager)).setCurrentItem(i10);
            }
        });
    }
}
