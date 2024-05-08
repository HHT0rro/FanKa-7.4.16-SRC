package com.cupidapp.live.match.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.FKNearbyGuideResult;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.MatchPageActivityModel;
import com.cupidapp.live.base.network.model.MatchPageActivityResult;
import com.cupidapp.live.base.network.model.MatchWebTabInfoModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.FKViewPagerTitleLayout;
import com.cupidapp.live.base.view.dialog.BgColor;
import com.cupidapp.live.base.view.dialog.BgType;
import com.cupidapp.live.base.view.dialog.FKPointerDialog;
import com.cupidapp.live.base.view.dialog.PointerPos;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.base.web.model.CloseTransparentWebEvent;
import com.cupidapp.live.match.activity.FKMatchFilterNewActivity;
import com.cupidapp.live.match.activity.MapFilterNewActivity;
import com.cupidapp.live.match.activity.SearchActivity;
import com.cupidapp.live.match.event.MapIsUsingEvent;
import com.cupidapp.live.match.fragment.FKMatchContainerFragment;
import com.cupidapp.live.match.model.MatchFilterSettingType;
import com.cupidapp.live.match.model.MatchRecommendModel;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.model.SearchHideResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.event.RouterUrlJumperSelectSecondTabEvent;
import com.cupidapp.live.setting.helper.PersonalizedRecommendHelper;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.SensorIconType;
import com.cupidapp.live.vip.model.MarketPopInfoModel;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.irisdt.client.others.OthersProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMatchContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchContainerFragment extends FKBaseMainPagerFragment {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16640u = new a(null);

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public FKWebViewFragment f16644l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16646n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f16648p;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public FKPointerDialog f16650r;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16652t = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public MatchTabType f16641i = MatchTabType.Match;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final FKSwipeCardFragment f16642j = new FKSwipeCardFragment();

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public FKNearByFragment f16643k = new FKNearByFragment();

    /* renamed from: m, reason: collision with root package name */
    public long f16645m = System.currentTimeMillis();

    /* renamed from: o, reason: collision with root package name */
    public boolean f16647o = true;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16649q = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(FKMatchContainerFragment.this);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16651s = kotlin.c.b(new FKMatchContainerFragment$handler$2(this));

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FKMatchContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class MatchTabType {
        public static final MatchTabType Match = new Match("Match", 0);
        public static final MatchTabType Near = new Near("Near", 1);
        public static final MatchTabType Web = new Web("Web", 2);
        private static final /* synthetic */ MatchTabType[] $VALUES = $values();

        /* compiled from: FKMatchContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class Match extends MatchTabType {
            public Match(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType
            public int getPageIndex() {
                return 0;
            }

            @Override // com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType
            @NotNull
            public String getPageName() {
                return "Match";
            }
        }

        /* compiled from: FKMatchContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class Near extends MatchTabType {
            public Near(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType
            public int getPageIndex() {
                return 1;
            }

            @Override // com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType
            @NotNull
            public String getPageName() {
                return "Near";
            }
        }

        /* compiled from: FKMatchContainerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class Web extends MatchTabType {
            public Web(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType
            public int getPageIndex() {
                return 2;
            }

            @Override // com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType
            @NotNull
            public String getPageName() {
                return "matchWebTab";
            }
        }

        private static final /* synthetic */ MatchTabType[] $values() {
            return new MatchTabType[]{Match, Near, Web};
        }

        private MatchTabType(String str, int i10) {
        }

        public /* synthetic */ MatchTabType(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i10);
        }

        public static MatchTabType valueOf(String str) {
            return (MatchTabType) Enum.valueOf(MatchTabType.class, str);
        }

        public static MatchTabType[] values() {
            return (MatchTabType[]) $VALUES.clone();
        }

        public abstract /* synthetic */ int getPageIndex();

        @NotNull
        public abstract /* synthetic */ String getPageName();
    }

    /* compiled from: FKMatchContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull MatchTabType type) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(type, "type");
            return MainActivity.F.a(context, MainActivity.MainPagerType.Match, type.getPageName());
        }
    }

    /* compiled from: FKMatchContainerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16653a;

        static {
            int[] iArr = new int[MatchTabType.values().length];
            try {
                iArr[MatchTabType.Near.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MatchTabType.Match.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MatchTabType.Web.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16653a = iArr;
        }
    }

    public static final void A1(FKMatchContainerFragment this$0, View view, FKNearbyGuideResult guide) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(guide, "$guide");
        if (this$0.J1()) {
            return;
        }
        this$0.r1(view, guide.getText(), guide.getTemplateId());
        this$0.s1(guide.getAvatar(), guide.getAvatarShowTime());
    }

    public static final void o1(FKMatchContainerFragment this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f16642j.s2();
    }

    public final void B1() {
        FKViewPagerTitleLayout fKViewPagerTitleLayout;
        FKViewPagerTitleLayout fKViewPagerTitleLayout2;
        int i10 = b.f16653a[this.f16641i.ordinal()];
        if (i10 == 1) {
            p0.b(getActivity(), true, -15066598);
            int i11 = R$id.matchContainerTitleLayout;
            FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(i11);
            if (fKTitleBarLayout != null) {
                fKTitleBarLayout.setTitleBackgroundColor(-15066598);
            }
            FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) i1(i11);
            if (fKTitleBarLayout2 == null || (fKViewPagerTitleLayout = (FKViewPagerTitleLayout) fKTitleBarLayout2.a(R$id.viewPagerTitleLayout)) == null) {
                return;
            }
            fKViewPagerTitleLayout.setCheckColorAndUnCheckColor(-1, -5658199, -1);
            return;
        }
        if (i10 == 2 || i10 == 3) {
            p0.c(getActivity(), false, 0, 3, null);
            int i12 = R$id.matchContainerTitleLayout;
            FKTitleBarLayout fKTitleBarLayout3 = (FKTitleBarLayout) i1(i12);
            if (fKTitleBarLayout3 != null) {
                fKTitleBarLayout3.setTitleBackgroundColor(-1);
            }
            FKTitleBarLayout fKTitleBarLayout4 = (FKTitleBarLayout) i1(i12);
            if (fKTitleBarLayout4 == null || (fKViewPagerTitleLayout2 = (FKViewPagerTitleLayout) fKTitleBarLayout4.a(R$id.viewPagerTitleLayout)) == null) {
                return;
            }
            fKViewPagerTitleLayout2.setCheckColorAndUnCheckColor(-15066598, com.cupidapp.live.base.utils.h.a(-15066598, 0.3f), -15066598);
        }
    }

    @NotNull
    public final List<Float> C1() {
        return ((FKTitleBarLayout) i1(R$id.matchContainerTitleLayout)).getRightImageLocation();
    }

    public final Handler D1() {
        return (Handler) this.f16651s.getValue();
    }

    public final int E1() {
        ConstantsResult q10 = p1.g.f52734a.q();
        Integer matchFilterSettingType = q10 != null ? q10.getMatchFilterSettingType() : null;
        int value = MatchFilterSettingType.COMMON_FILTER.getValue();
        if (matchFilterSettingType != null && matchFilterSettingType.intValue() == value) {
            return R$mipmap.icon_main_match_filter_check;
        }
        int value2 = MatchFilterSettingType.RAINBOW_FILTER.getValue();
        if (matchFilterSettingType != null && matchFilterSettingType.intValue() == value2) {
            return R$mipmap.icon_main_match_filter_rainbow;
        }
        MatchFilterSettingType.NO_FILTER.getValue();
        if (matchFilterSettingType == null) {
            return R$mipmap.icon_main_match_filter_uncheck;
        }
        matchFilterSettingType.intValue();
        return R$mipmap.icon_main_match_filter_uncheck;
    }

    public final Integer F1() {
        return null;
    }

    public final xb.b G1() {
        return (xb.b) this.f16649q.getValue();
    }

    public final void H1() {
        FKPointerDialog fKPointerDialog = this.f16650r;
        if (fKPointerDialog != null) {
            fKPointerDialog.g(false);
        }
        this.f16650r = null;
    }

    public final void I1() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        FKSwipeCardFragment fKSwipeCardFragment = this.f16642j;
        beginTransaction.replace(R$id.matchContainerFragmentContainerLayout, fKSwipeCardFragment, fKSwipeCardFragment.getClass().getSimpleName()).commitAllowingStateLoss();
        boolean z10 = true;
        List o10 = kotlin.collections.s.o(getString(PersonalizedRecommendHelper.f18179a.d()), getString(R$string.match_nearby));
        ConstantsResult q10 = p1.g.f52734a.q();
        MatchWebTabInfoModel matchWebTabInfo = q10 != null ? q10.getMatchWebTabInfo() : null;
        String name = matchWebTabInfo != null ? matchWebTabInfo.getName() : null;
        String url = matchWebTabInfo != null ? matchWebTabInfo.getUrl() : null;
        if (matchWebTabInfo != null) {
            if (!(name == null || name.length() == 0)) {
                if (url != null && url.length() != 0) {
                    z10 = false;
                }
                if (!z10) {
                    this.f16644l = FKWebViewFragment.a.e(FKWebViewFragment.f13075p, url, null, new WebConfigViewModel(false, false, false, false, false, null, false, 102, null), 2, null);
                    o10.add(name);
                }
            }
        }
        FKTitleBarLayout initView$lambda$0 = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
        kotlin.jvm.internal.s.h(initView$lambda$0, "initView$lambda$0");
        FKTitleBarLayout.f(initView$lambda$0, new com.cupidapp.live.base.view.p(o10, 0.0f, 0, 0, false, 30, null), null, 0, null, 12, null);
        initView$lambda$0.setLeftImageRes(R$mipmap.icon_main_match_cancel_nope);
        w1(false);
        o1.a.f52250a.a(initView$lambda$0);
        n1(initView$lambda$0);
    }

    public final boolean J1() {
        return (!isHidden() && isResumed() && this.f16641i == MatchTabType.Match) ? false : true;
    }

    public final void K1() {
        String userId;
        User X = p1.g.f52734a.X();
        if (X == null || (userId = X.userId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.i().h(userId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MatchPageActivityResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$refreshActivityIcon$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchPageActivityResult matchPageActivityResult) {
                m2706invoke(matchPageActivityResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2706invoke(MatchPageActivityResult matchPageActivityResult) {
                MatchPageActivityResult matchPageActivityResult2 = matchPageActivityResult;
                ConstantsResult q10 = p1.g.f52734a.q();
                if (q10 != null) {
                    q10.setActivityView(matchPageActivityResult2.getActivityView());
                }
                FKMatchContainerFragment.this.t1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void L1(FragmentTransaction fragmentTransaction) {
        if (getChildFragmentManager().findFragmentByTag(this.f16642j.getClass().getSimpleName()) != null) {
            fragmentTransaction.hide(this.f16642j);
        }
        if (getChildFragmentManager().findFragmentByTag(this.f16643k.getClass().getSimpleName()) != null) {
            fragmentTransaction.hide(this.f16643k);
        }
        FKWebViewFragment fKWebViewFragment = this.f16644l;
        if (fKWebViewFragment == null || getChildFragmentManager().findFragmentByTag(FKWebViewFragment.class.getSimpleName()) == null) {
            return;
        }
        fragmentTransaction.hide(fKWebViewFragment);
    }

    public final void M1() {
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null ? kotlin.jvm.internal.s.d(q10.getVasPolling(), Boolean.TRUE) : false) {
            Disposable disposed = NetworkClient.f11868a.p().b(kotlin.collections.s.m(1, 5, 9)).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MarketPopInfoModel, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$showMarketPopInfo$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(MarketPopInfoModel marketPopInfoModel) {
                    m2707invoke(marketPopInfoModel);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2707invoke(MarketPopInfoModel marketPopInfoModel) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, FKMatchContainerFragment.this.getContext(), marketPopInfoModel.getUrl(), null, 4, null);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$showMarketPopInfo$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16652t.clear();
    }

    public final void N1() {
        Disposable disposed = NetworkClient.f11868a.i().n().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FKNearbyGuideResult, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$showNearbyBubbleGuide$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FKNearbyGuideResult fKNearbyGuideResult) {
                m2708invoke(fKNearbyGuideResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2708invoke(FKNearbyGuideResult fKNearbyGuideResult) {
                FKMatchContainerFragment.this.z1(fKNearbyGuideResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        int i10 = b.f16653a[this.f16641i.ordinal()];
        if (i10 == 1) {
            return SensorPosition.Nearby;
        }
        if (i10 == 2) {
            return SensorPosition.Match;
        }
        if (i10 == 3) {
            return SensorPosition.Web;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void O1(@NotNull MatchTabType type) {
        Fragment fragment;
        FKViewPagerTitleLayout fKViewPagerTitleLayout;
        MatchWebTabInfoModel matchWebTabInfo;
        String trackName;
        kotlin.jvm.internal.s.i(type, "type");
        if (this.f16641i == type) {
            return;
        }
        int[] iArr = b.f16653a;
        int i10 = iArr[type.ordinal()];
        if (i10 == 1) {
            fragment = this.f16643k;
        } else if (i10 == 2) {
            fragment = this.f16642j;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            fragment = this.f16644l;
        }
        if (fragment == null) {
            return;
        }
        this.f16641i = type;
        int i11 = iArr[type.ordinal()];
        if (i11 == 1) {
            w1(false);
            FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
            if (fKTitleBarLayout != null) {
                fKTitleBarLayout.l();
            }
            H1();
            SensorsLogKeyButtonClick.Match.Nearby.click();
        } else if (i11 == 2) {
            this.f16642j.C1();
            this.f16642j.onResume();
        } else if (i11 == 3) {
            w1(false);
            ConstantsResult q10 = p1.g.f52734a.q();
            if (q10 != null && (matchWebTabInfo = q10.getMatchWebTabInfo()) != null && (trackName = matchWebTabInfo.getTrackName()) != null) {
                SensorsLogKeyButtonClick.f12211a.c(SensorPosition.Match.getValue(), trackName);
            }
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        kotlin.jvm.internal.s.h(beginTransaction, "childFragmentManager.beginTransaction()");
        L1(beginTransaction);
        if (getChildFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName()) == null && !fragment.isAdded()) {
            beginTransaction.add(R$id.matchContainerFragmentContainerLayout, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
        } else {
            beginTransaction.show(fragment).commitAllowingStateLoss();
        }
        u1();
        FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
        if (fKTitleBarLayout2 == null || (fKViewPagerTitleLayout = (FKViewPagerTitleLayout) fKTitleBarLayout2.a(R$id.viewPagerTitleLayout)) == null) {
            return;
        }
        fKViewPagerTitleLayout.w(this.f16641i.getPageIndex());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void X0() {
        if (this.f16641i == MatchTabType.Near) {
            FKNearByFragment fKNearByFragment = this.f16643k;
            if (!(fKNearByFragment instanceof FKNearByFragment)) {
                fKNearByFragment = null;
            }
            if (fKNearByFragment != null) {
                fKNearByFragment.K1();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Y0(@org.jetbrains.annotations.NotNull android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.s.i(r4, r0)
            com.cupidapp.live.match.fragment.FKMatchContainerFragment$MatchTabType r4 = r3.f16641i
            com.cupidapp.live.match.fragment.FKMatchContainerFragment$MatchTabType r0 = com.cupidapp.live.match.fragment.FKMatchContainerFragment.MatchTabType.Match
            if (r4 != r0) goto L18
            p1.g r4 = p1.g.f52734a
            boolean r4 = r4.c0()
            if (r4 == 0) goto L18
            com.cupidapp.live.match.fragment.FKSwipeCardFragment r4 = r3.f16642j
            r4.f2()
        L18:
            org.greenrobot.eventbus.EventBus r4 = org.greenrobot.eventbus.EventBus.c()
            com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent r0 = new com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent
            com.cupidapp.live.MainActivity$MainPagerType r1 = com.cupidapp.live.MainActivity.MainPagerType.Match
            r0.<init>(r1)
            r4.l(r0)
            p1.g r4 = p1.g.f52734a
            p1.a r4 = r4.y1()
            java.lang.Object r4 = r4.c()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.s.d(r4, r0)
            r0 = 1
            if (r4 != 0) goto L63
            com.cupidapp.live.base.utils.i0 r4 = com.cupidapp.live.base.utils.i0.f12331a
            boolean r1 = r4.c()
            if (r1 == 0) goto L46
            boolean r1 = r3.f16647o
            if (r1 == 0) goto L46
            goto L63
        L46:
            boolean r1 = r4.c()
            if (r1 == 0) goto L50
            boolean r1 = r3.f16647o
            if (r1 != 0) goto L6c
        L50:
            boolean r4 = r4.c()
            if (r4 == 0) goto L5d
            android.os.Handler r4 = r3.D1()
            r4.removeMessages(r0)
        L5d:
            com.cupidapp.live.appdialog.model.BottomTabName r4 = com.cupidapp.live.appdialog.model.BottomTabName.Match
            r3.e1(r4)
            goto L6c
        L63:
            android.os.Handler r4 = r3.D1()
            r1 = 30000(0x7530, double:1.4822E-319)
            r4.sendEmptyMessageDelayed(r0, r1)
        L6c:
            r4 = 0
            r3.f16647o = r4
            com.cupidapp.live.base.sensorslog.SensorPosition r4 = r3.O0()
            com.cupidapp.live.base.sensorslog.SensorPosition r0 = com.cupidapp.live.base.sensorslog.SensorPosition.Match
            if (r4 != r0) goto L8b
            com.cupidapp.live.AppApplication$a r4 = com.cupidapp.live.AppApplication.f11612d
            com.cupidapp.live.AppApplication r4 = r4.h()
            android.os.Handler r4 = r4.j()
            com.cupidapp.live.match.fragment.a r0 = new com.cupidapp.live.match.fragment.a
            r0.<init>()
            r1 = 500(0x1f4, double:2.47E-321)
            r4.postDelayed(r0, r1)
        L8b:
            r3.M1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.fragment.FKMatchContainerFragment.Y0(android.content.Context):void");
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Z0() {
        p0.c(getActivity(), false, 0, 3, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void a1(@Nullable String str) {
        super.a1(str);
        if (str == null) {
            return;
        }
        Locale ENGLISH = Locale.ENGLISH;
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase = str.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        MatchTabType matchTabType = MatchTabType.Match;
        String pageName = matchTabType.getPageName();
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase2 = pageName.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        if (kotlin.jvm.internal.s.d(lowerCase, lowerCase2)) {
            O1(matchTabType);
            return;
        }
        MatchTabType matchTabType2 = MatchTabType.Near;
        String pageName2 = matchTabType2.getPageName();
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase3 = pageName2.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
        if (kotlin.jvm.internal.s.d(lowerCase, lowerCase3)) {
            O1(matchTabType2);
            return;
        }
        MatchTabType matchTabType3 = MatchTabType.Web;
        String pageName3 = matchTabType3.getPageName();
        kotlin.jvm.internal.s.h(ENGLISH, "ENGLISH");
        String lowerCase4 = pageName3.toLowerCase(ENGLISH);
        kotlin.jvm.internal.s.h(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
        if (kotlin.jvm.internal.s.d(lowerCase, lowerCase4)) {
            O1(matchTabType3);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void b1(long j10) {
        SensorPosition O0 = O0();
        int i10 = b.f16653a[this.f16641i.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                MatchRecommendModel E1 = this.f16642j.E1();
                MatchRecommendUserModel matchRecommendUserModel = E1 instanceof MatchRecommendUserModel ? (MatchRecommendUserModel) E1 : null;
                User user = matchRecommendUserModel != null ? matchRecommendUserModel.getUser() : null;
                j1.k.f50238a.a(O0, "HOMEPAGE", user != null ? user.userId() : null, j10);
                return;
            }
            if (i10 != 3) {
                return;
            }
        }
        j1.k.f50238a.a(O0, (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void c1(boolean z10) {
        SensorPosition O0 = O0();
        int i10 = b.f16653a[this.f16641i.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                MatchRecommendModel E1 = this.f16642j.E1();
                MatchRecommendUserModel matchRecommendUserModel = E1 instanceof MatchRecommendUserModel ? (MatchRecommendUserModel) E1 : null;
                User user = matchRecommendUserModel != null ? matchRecommendUserModel.getUser() : null;
                j1.k.f50238a.c(O0, "HOMEPAGE", user != null ? user.userId() : null, z10);
                return;
            }
            if (i10 != 3) {
                return;
            }
        }
        j1.k.f50238a.d(O0, z10);
    }

    @Nullable
    public View i1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16652t;
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

    public final void n1(FKTitleBarLayout fKTitleBarLayout) {
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$1
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
                FKSwipeCardFragment fKSwipeCardFragment;
                SensorsLogKeyButtonClick.Match.UndoNope.click();
                fKSwipeCardFragment = FKMatchContainerFragment.this.f16642j;
                fKSwipeCardFragment.z1();
            }
        });
        fKTitleBarLayout.setLeftSpareImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$2
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
                SearchActivity.f16547y.a(FKMatchContainerFragment.this.getContext());
            }
        });
        ((FKViewPagerTitleLayout) fKTitleBarLayout.a(R$id.viewPagerTitleLayout)).setTabClickCallBack(new Function2<Integer, Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10, boolean z10) {
                FKMatchContainerFragment.MatchTabType matchTabType = FKMatchContainerFragment.MatchTabType.Match;
                if (i10 == matchTabType.getPageIndex()) {
                    FKMatchContainerFragment.this.O1(matchTabType);
                    return;
                }
                FKMatchContainerFragment.MatchTabType matchTabType2 = FKMatchContainerFragment.MatchTabType.Near;
                if (i10 == matchTabType2.getPageIndex()) {
                    FKMatchContainerFragment.this.O1(matchTabType2);
                    return;
                }
                FKMatchContainerFragment.MatchTabType matchTabType3 = FKMatchContainerFragment.MatchTabType.Web;
                if (i10 == matchTabType3.getPageIndex()) {
                    FKMatchContainerFragment.this.O1(matchTabType3);
                }
            }
        });
        fKTitleBarLayout.setRightImageLoaderClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$4
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
                ConstantsResult q10 = p1.g.f52734a.q();
                MatchPageActivityModel activityView = q10 != null ? q10.getActivityView() : null;
                com.cupidapp.live.base.router.j.f12156c.a(FKMatchContainerFragment.this.getContext(), activityView != null ? activityView.getActivityUrl() : null, new WebStyleViewModel(null, false, FKMatchContainerFragment.this.C1(), 3, null));
                SensorLogActivity.f12204a.a(SensorPosition.Match.getValue(), activityView != null ? activityView.getActivityUrl() : null, SensorLogActivity.Type.MATCH.getType());
            }
        });
        fKTitleBarLayout.setRightImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$5
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
                FKMatchContainerFragment.MatchTabType matchTabType;
                SensorsLogKeyButtonClick.Match.Filter.click();
                FKMatchFilterNewActivity.a aVar = FKMatchFilterNewActivity.f16488t;
                Context context = FKMatchContainerFragment.this.getContext();
                matchTabType = FKMatchContainerFragment.this.f16641i;
                aVar.a(context, matchTabType == FKMatchContainerFragment.MatchTabType.Near, false, "");
            }
        });
        fKTitleBarLayout.setFirstRightImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$6
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
                xb.b G1;
                final Context context = FKMatchContainerFragment.this.getContext();
                if (context != null) {
                    LocationUtils.Companion companion = LocationUtils.f12270h;
                    G1 = FKMatchContainerFragment.this.G1();
                    final FKMatchContainerFragment fKMatchContainerFragment = FKMatchContainerFragment.this;
                    companion.e(context, G1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$bindTitleBtnClickEvent$6.1
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
                            CoordinateModel j10 = LocationUtils.f12270h.a().j();
                            Context context2 = context;
                            if (context2 != null) {
                                MapFilterNewActivity.f16502z.a(context2, Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), fKMatchContainerFragment.O0(), VipPurchaseEntranceType.NearByMapFilter);
                            }
                        }
                    });
                }
                z3.d.f54832a.y(SensorIconType.ICON, SensorPosition.Nearby);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z0.z.b(viewGroup, R$layout.fragment_match_container, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RouterUrlJumperSelectSecondTabEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        String type = event.getType();
        MatchTabType matchTabType = MatchTabType.Match;
        if (kotlin.jvm.internal.s.d(type, matchTabType.getPageName())) {
            O1(matchTabType);
            return;
        }
        MatchTabType matchTabType2 = MatchTabType.Near;
        if (kotlin.jvm.internal.s.d(type, matchTabType2.getPageName())) {
            O1(matchTabType2);
            return;
        }
        MatchTabType matchTabType3 = MatchTabType.Web;
        if (kotlin.jvm.internal.s.d(type, matchTabType3.getPageName())) {
            O1(matchTabType3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            this.f16642j.u2();
            this.f16642j.D1();
            if (this.f16643k.isAdded() && !this.f16643k.isHidden()) {
                this.f16643k.w2();
            }
            H1();
        } else {
            this.f16642j.B1();
            this.f16642j.t2();
            if (this.f16643k.isAdded() && !this.f16643k.isHidden()) {
                this.f16643k.v2();
            }
            p1();
            u1();
        }
        q1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        u1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        I1();
    }

    public final void p1() {
        int i10 = b.f16653a[this.f16641i.ordinal()];
        if (i10 == 1) {
            this.f16643k.j2();
            this.f16643k.n2();
        } else {
            if (i10 != 2) {
                return;
            }
            this.f16642j.h2();
        }
    }

    public final void q1() {
        if (System.currentTimeMillis() - this.f16645m > com.huawei.openalliance.ad.constant.u.as) {
            this.f16645m = System.currentTimeMillis();
            O1(MatchTabType.Match);
        }
    }

    public final void r1(View view, String str, final String str2) {
        if (str == null || str.length() == 0) {
            return;
        }
        view.getLocationInWindow(new int[2]);
        Context context = getContext();
        if (context != null) {
            FKPointerDialog p10 = FKPointerDialog.f12718p.a(context).l(BgType.GRADIENT).k(kotlin.collections.s.m(-21248, -32256)).n(str).q(PointerPos.TOP_CENTER, BgColor.DEFAULT).m(false).j(Float.valueOf(0.0f)).p(new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$checkShowBubbleGuide$1$1
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
                    FKMatchContainerFragment.this.O1(FKMatchContainerFragment.MatchTabType.Near);
                    GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.NEARBY_BUBBLE, str2, null, 4, null);
                }
            }, true);
            this.f16650r = p10;
            if (p10 != null) {
                FKPointerDialog.y(p10, view, 0, z0.h.c(this, 3.0f), 0, 10, null);
            }
        }
        GroupOthersLog.f18702a.q(OthersProtos.Enum_type.NEARBY_BUBBLE, str2);
    }

    public final void s1(ImageModel imageModel, int i10) {
        if (imageModel == null) {
            return;
        }
        ((FKTitleBarLayout) i1(R$id.matchContainerTitleLayout)).d(MatchTabType.Near.getPageIndex(), imageModel, i10, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.fragment.FKMatchContainerFragment$checkShowNearByGuideAvatar$1
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
                FKMatchContainerFragment.this.O1(FKMatchContainerFragment.MatchTabType.Near);
            }
        });
        GroupOthersLog.L(GroupOthersLog.f18702a, SensorPosition.Match, "NEARBY_AE", null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t1() {
        /*
            r7 = this;
            p1.g r0 = p1.g.f52734a
            com.cupidapp.live.base.network.model.ConstantsResult r0 = r0.q()
            r1 = 0
            if (r0 == 0) goto Le
            com.cupidapp.live.base.network.model.MatchPageActivityModel r0 = r0.getActivityView()
            goto Lf
        Le:
            r0 = r1
        Lf:
            int r2 = com.cupidapp.live.R$id.matchContainerTitleLayout
            android.view.View r3 = r7.i1(r2)
            com.cupidapp.live.base.view.FKTitleBarLayout r3 = (com.cupidapp.live.base.view.FKTitleBarLayout) r3
            if (r3 == 0) goto L24
            if (r0 == 0) goto L20
            com.cupidapp.live.base.network.model.ImageModel r4 = r0.getActivityImage()
            goto L21
        L20:
            r4 = r1
        L21:
            r3.setRightImageLoaderView(r4)
        L24:
            com.cupidapp.live.match.fragment.FKMatchContainerFragment$MatchTabType r3 = r7.f16641i
            int[] r4 = com.cupidapp.live.match.fragment.FKMatchContainerFragment.b.f16653a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 0
            r5 = 1
            if (r3 == r5) goto L41
            r6 = 2
            if (r3 == r6) goto L3f
            r6 = 3
            if (r3 != r6) goto L39
            goto L41
        L39:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L3f:
            r3 = 1
            goto L42
        L41:
            r3 = 0
        L42:
            if (r3 == 0) goto L4f
            if (r0 == 0) goto L4b
            com.cupidapp.live.base.network.model.ImageModel r3 = r0.getActivityImage()
            goto L4c
        L4b:
            r3 = r1
        L4c:
            if (r3 == 0) goto L4f
            r4 = 1
        L4f:
            android.view.View r2 = r7.i1(r2)
            com.cupidapp.live.base.view.FKTitleBarLayout r2 = (com.cupidapp.live.base.view.FKTitleBarLayout) r2
            if (r2 == 0) goto L5a
            r2.setRightImageLoaderViewVisible(r4)
        L5a:
            if (r4 == 0) goto L79
            boolean r2 = r7.f16646n
            if (r2 != 0) goto L79
            com.cupidapp.live.base.sensorslog.SensorLogActivity r2 = com.cupidapp.live.base.sensorslog.SensorLogActivity.f12204a
            com.cupidapp.live.base.sensorslog.SensorPosition r3 = com.cupidapp.live.base.sensorslog.SensorPosition.Match
            java.lang.String r3 = r3.getValue()
            if (r0 == 0) goto L6e
            java.lang.String r1 = r0.getActivityUrl()
        L6e:
            com.cupidapp.live.base.sensorslog.SensorLogActivity$Type r0 = com.cupidapp.live.base.sensorslog.SensorLogActivity.Type.MATCH
            java.lang.String r0 = r0.getType()
            r2.b(r3, r1, r0)
            r7.f16646n = r5
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.fragment.FKMatchContainerFragment.t1():void");
    }

    public final void u1() {
        x1();
        B1();
        t1();
        v1();
        y1();
    }

    public final void v1() {
        Integer F1;
        MatchTabType matchTabType = this.f16641i;
        int[] iArr = b.f16653a;
        int i10 = iArr[matchTabType.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            F1 = F1();
        } else if (i10 == 2) {
            F1 = Integer.valueOf(E1());
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            F1 = null;
        }
        int i11 = R$id.matchContainerTitleLayout;
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(i11);
        if (fKTitleBarLayout != null) {
            fKTitleBarLayout.setRightImageRes(F1);
        }
        int i12 = iArr[this.f16641i.ordinal()];
        if (i12 != 1 && i12 != 2) {
            if (i12 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            z10 = false;
        }
        FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) i1(i11);
        if (fKTitleBarLayout2 != null) {
            fKTitleBarLayout2.setRightImageVisible(z10);
        }
    }

    public final void w1(boolean z10) {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
        if (fKTitleBarLayout != null) {
            fKTitleBarLayout.setLeftImageVisible(z10);
        }
    }

    public final void x1() {
        int i10;
        SearchHideResult b02 = p1.g.f52734a.b0();
        if (b02 != null ? kotlin.jvm.internal.s.d(b02.getHideSearch(), Boolean.FALSE) : false) {
            MatchTabType matchTabType = this.f16641i;
            if (matchTabType == MatchTabType.Near) {
                FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
                if (fKTitleBarLayout != null) {
                    fKTitleBarLayout.setLeftSpareVisible(false);
                    return;
                }
                return;
            }
            int i11 = b.f16653a[matchTabType.ordinal()];
            if (i11 == 1) {
                i10 = R$mipmap.icon_main_nearby_search;
            } else {
                if (i11 != 2 && i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                i10 = R$mipmap.icon_main_match_search;
            }
            FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
            if (fKTitleBarLayout2 != null) {
                fKTitleBarLayout2.setLeftSpareImageRes(i10);
            }
        }
    }

    public final void y1() {
        int i10 = this.f16648p ? R$mipmap.ic_map_filter_yellow_with_txt : R$mipmap.ic_map_filter_white_with_txt;
        int i11 = R$id.matchContainerTitleLayout;
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(i11);
        if (fKTitleBarLayout != null) {
            fKTitleBarLayout.setFirstRightImageRes(i10);
        }
        int i12 = b.f16653a[this.f16641i.ordinal()];
        if (i12 != 1 && i12 != 2 && i12 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) i1(i11);
        if (fKTitleBarLayout2 != null) {
            fKTitleBarLayout2.setFirstRightImageVisible(false);
        }
    }

    public final void z1(final FKNearbyGuideResult fKNearbyGuideResult) {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) i1(R$id.matchContainerTitleLayout);
        final View g3 = fKTitleBarLayout != null ? fKTitleBarLayout.g(MatchTabType.Near.getPageIndex()) : null;
        if (g3 != null) {
            g3.post(new Runnable() { // from class: com.cupidapp.live.match.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    FKMatchContainerFragment.A1(FKMatchContainerFragment.this, g3, fKNearbyGuideResult);
                }
            });
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull CloseTransparentWebEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        K1();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull MapIsUsingEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        this.f16648p = event.isUsing();
        y1();
    }
}
