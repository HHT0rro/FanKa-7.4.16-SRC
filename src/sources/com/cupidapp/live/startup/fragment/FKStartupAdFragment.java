package com.cupidapp.live.startup.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.sensorslog.NoAdReason;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.performance.time.LoadAdResult;
import com.cupidapp.live.startup.helper.ADMonitorHelper;
import com.cupidapp.live.startup.helper.SplashAdSelectHelper;
import com.cupidapp.live.startup.model.EventTrackAdEndType;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMaterialType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.FKStartupMediaModel;
import com.cupidapp.live.startup.model.FKStartupMediaResult;
import com.cupidapp.live.startup.model.SplashAdRequestModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.model.StartCacheSplashAdDataEvent;
import com.cupidapp.live.startup.splashad.FKBaseSplashAd;
import com.cupidapp.live.startup.view.FKStartupImageLayout;
import com.cupidapp.live.startup.view.FKStartupSplashLayout;
import com.cupidapp.live.startup.view.FKStartupVideoLayout;
import com.cupidapp.live.startup.view.b;
import com.cupidapp.live.startup.viewmodel.FKStartupViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j1.m;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.z;

/* compiled from: FKStartupAdFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupAdFragment extends FKBaseFragment implements com.cupidapp.live.startup.view.b {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f18400m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static long f18401n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public static SplashAdRequestModel f18402o;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18403e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public SplashAdRequestModel f18404f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public c f18405g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final i f18406h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final i f18407i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18408j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f18409k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18410l = new LinkedHashMap();

    /* compiled from: FKStartupAdFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKStartupAdFragment a(boolean z10, @NotNull c listener) {
            s.i(listener, "listener");
            FKStartupAdFragment fKStartupAdFragment = new FKStartupAdFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("IS_COLD_START", z10);
            fKStartupAdFragment.setArguments(bundle);
            fKStartupAdFragment.f18405g = listener;
            return fKStartupAdFragment;
        }

        public final void b(@Nullable SplashAdRequestModel splashAdRequestModel) {
            FKStartupAdFragment.f18402o = splashAdRequestModel;
            FKStartupAdFragment.f18401n = splashAdRequestModel == null ? 0L : System.currentTimeMillis();
        }
    }

    /* compiled from: FKStartupAdFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Observer, p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f18411a;

        public b(Function1 function) {
            s.i(function, "function");
            this.f18411a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof p)) {
                return s.d(getFunctionDelegate(), ((p) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.p
        @NotNull
        public final kotlin.b<?> getFunctionDelegate() {
            return this.f18411a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f18411a.invoke(obj);
        }
    }

    public FKStartupAdFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$special$$inlined$viewModels$default$1
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
        this.f18403e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(FKStartupViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$special$$inlined$viewModels$default$2
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
        }, null);
        this.f18406h = new i();
        this.f18407i = new i();
        this.f18409k = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$mIsColdStart$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Bundle arguments = FKStartupAdFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("IS_COLD_START") : false);
            }
        });
    }

    public static final void g1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void h1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.cupidapp.live.startup.view.b
    public void I(@NotNull FKAdType type, @Nullable String str) {
        c cVar;
        s.i(type, "type");
        b.a.a(this, type, str);
        t1();
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        if (splashAdRequestModel != null) {
            FKStartupMediaConfigModel configModel = splashAdRequestModel.getConfigModel();
            SplashAdSelectHelper splashAdSelectHelper = SplashAdSelectHelper.f18415a;
            splashAdSelectHelper.N(splashAdRequestModel);
            splashAdSelectHelper.O(splashAdRequestModel, EventTrackAdEndType.CLICK);
            if (configModel.isSelfOperatedAdvertising()) {
                ADMonitorHelper.f18414a.b(getContext(), configModel.getAdvertisementBaseInfo().getClickMonitorLink());
            }
            if ((str == null || str.length() == 0) || (cVar = this.f18405g) == null) {
                return;
            }
            cVar.b(str);
        }
    }

    @Override // com.cupidapp.live.startup.view.b
    public void J0(@NotNull FKAdType type) {
        s.i(type, "type");
        b.a.h(this, type);
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        if (splashAdRequestModel != null) {
            SplashAdSelectHelper.f18415a.O(splashAdRequestModel, EventTrackAdEndType.SKIP);
        }
        c cVar = this.f18405g;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18410l.clear();
    }

    @Override // com.cupidapp.live.startup.view.b
    public void P(@NotNull FKAdType type) {
        s.i(type, "type");
        b.a.g(this, type);
        u1();
        r1();
        i3.a aVar = i3.a.f49713a;
        boolean l12 = l1();
        SplashAdSelectHelper splashAdSelectHelper = SplashAdSelectHelper.f18415a;
        aVar.d(l12, splashAdSelectHelper.A(), LoadAdResult.LOAD_SUCCEED);
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        if (splashAdRequestModel != null) {
            FKStartupMediaConfigModel configModel = splashAdRequestModel.getConfigModel();
            i1(configModel);
            splashAdSelectHelper.R(splashAdRequestModel, true, null);
            if (configModel.isThirdAdvertising()) {
                m1().setVipRemoveAdEvent(configModel.getVipButtonEnabled());
                m1().setAdType(type);
            }
            m1().reportStartupAd(configModel.getAdvertisementBaseInfo().getAdId());
            if (configModel.isSelfOperatedAdvertising()) {
                ADMonitorHelper.f18414a.b(getContext(), configModel.getAdvertisementBaseInfo().getExposureMonitorLink());
            }
            if (configModel.isThirdAdvertising()) {
                m1().setJumpButtonAndClickAreaEvent(configModel.showJumpButton(), configModel.getClickHotArea());
            }
        }
        f18400m.b(null);
    }

    @Override // com.cupidapp.live.startup.view.b
    public void Q(@NotNull FKAdType type, @Nullable Integer num, @Nullable String str) {
        s.i(type, "type");
        b.a.f(this, type, num, str);
        i3.a aVar = i3.a.f49713a;
        boolean l12 = l1();
        SplashAdSelectHelper splashAdSelectHelper = SplashAdSelectHelper.f18415a;
        aVar.d(l12, splashAdSelectHelper.A(), LoadAdResult.LOAD_FAILED);
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        if (splashAdRequestModel != null) {
            splashAdSelectHelper.R(splashAdRequestModel, false, str);
        }
        f18400m.b(null);
        c cVar = this.f18405g;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18410l;
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

    @Override // com.cupidapp.live.startup.view.b
    public void c(@NotNull FKAdType fKAdType, @Nullable Integer num, @Nullable String str, boolean z10) {
        b.a.c(this, fKAdType, num, str, z10);
    }

    @Override // com.cupidapp.live.startup.view.b
    public void c0(@NotNull FKAdType type, @NotNull SplashAdShowState state) {
        s.i(type, "type");
        s.i(state, "state");
        b.a.i(this, type, state);
        n1();
    }

    public final void f1() {
        com.cupidapp.live.startup.helper.b.f18418a.a("开始调用/ad/list接口");
        Observable observeOn = NetworkClient.f11868a.x().a().flatMap(new com.cupidapp.live.base.network.i()).timeout(2000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<FKStartupMediaResult, kotlin.p> function1 = new Function1<FKStartupMediaResult, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$callAdListApi$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FKStartupMediaResult fKStartupMediaResult) {
                invoke2(fKStartupMediaResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FKStartupMediaResult fKStartupMediaResult) {
                boolean l12;
                c cVar;
                com.cupidapp.live.startup.helper.b.f18418a.a("/ad/list接口请求成功");
                FKStartupMediaModel splashAdNew = fKStartupMediaResult.getSplashAdNew();
                if (splashAdNew == null) {
                    i3.a aVar = i3.a.f49713a;
                    l12 = FKStartupAdFragment.this.l1();
                    aVar.d(l12, null, LoadAdResult.NOT_LOAD);
                    m.f50240a.f(NoAdReason.SERVER_NOT_RETURN_AD_DATA);
                    cVar = FKStartupAdFragment.this.f18405g;
                    if (cVar != null) {
                        cVar.a();
                        return;
                    }
                    return;
                }
                LaunchDownloader.f11925a.m(FKStartupAdFragment.this.getContext(), splashAdNew.getStartupMediaList());
                FKStartupAdFragment.this.q1(splashAdNew);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.startup.fragment.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKStartupAdFragment.g1(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$callAdListApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                boolean l12;
                c cVar;
                com.cupidapp.live.startup.helper.b.f18418a.a("/ad/list接口请求失败  throwable:" + ((Object) th));
                i3.a aVar = i3.a.f49713a;
                l12 = FKStartupAdFragment.this.l1();
                aVar.d(l12, null, LoadAdResult.ADLIST_LOAD_FAILED);
                cVar = FKStartupAdFragment.this.f18405g;
                if (cVar != null) {
                    cVar.a();
                }
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.startup.fragment.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKStartupAdFragment.h1(Function1.this, obj);
            }
        });
        s.h(subscribe, "this");
        H(subscribe);
    }

    public final void i1(final FKStartupMediaConfigModel fKStartupMediaConfigModel) {
        Disposable disposed = NetworkClient.f11868a.x().c(fKStartupMediaConfigModel.getAdvertisementBaseInfo().getAdId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$callAdShowApi$$inlined$handle$default$1
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
                com.cupidapp.live.startup.helper.b bVar = com.cupidapp.live.startup.helper.b.f18418a;
                FKAdType adType = FKStartupMediaConfigModel.this.getAdType();
                bVar.a("/ad/show 广告展示接口success， AdType:" + ((Object) adType) + "  thirdPartyId:" + FKStartupMediaConfigModel.this.getAdvertisementBaseInfo().getThirdPartyId());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void j1() {
        SplashAdRequestModel splashAdRequestModel = f18402o;
        ConstantsResult q10 = g.f52734a.q();
        Integer splashCacheTimeInterval = q10 != null ? q10.getSplashCacheTimeInterval() : null;
        boolean z10 = false;
        boolean z11 = splashCacheTimeInterval != null && splashCacheTimeInterval.intValue() > 0 && f18401n > 0 && System.currentTimeMillis() - f18401n <= ((long) splashCacheTimeInterval.intValue()) * 1000;
        if (splashAdRequestModel != null && splashAdRequestModel.isNotHuaweiJHSplashAd()) {
            z10 = true;
        }
        if (z10 && z11) {
            s1();
            this.f18404f = splashAdRequestModel;
            com.cupidapp.live.startup.helper.b.f18418a.a("FKStartupAdFragment 缓存广告 selectSplashAd mRequestModel:" + ((Object) splashAdRequestModel));
            k1(splashAdRequestModel, true);
        } else {
            f18400m.b(null);
            f1();
        }
        EventBus.c().o(new StartCacheSplashAdDataEvent());
    }

    public final void k1(SplashAdRequestModel splashAdRequestModel, boolean z10) {
        FKBaseSplashAd splashAd;
        FKStartupMediaConfigModel configModel = splashAdRequestModel.getConfigModel();
        if (configModel.isSelfOperatedAdvertising()) {
            Integer materialType = configModel.getAdvertisementBaseInfo().getMaterialType();
            int type = FKStartupMaterialType.Image.getType();
            if (materialType != null && materialType.intValue() == type) {
                ((FKStartupImageLayout) U0(R$id.start_up_image_layout)).h(configModel);
                return;
            }
            int type2 = FKStartupMaterialType.Video.getType();
            if (materialType != null && materialType.intValue() == type2) {
                ((FKStartupVideoLayout) U0(R$id.start_up_video_layout)).h(configModel);
                return;
            }
            return;
        }
        if (configModel.isThirdAdvertising()) {
            if (com.cupidapp.live.vip.c.f18740a.i()) {
                m.f50240a.f(NoAdReason.AD_PRIVILEGE_TURN_ON);
                c cVar = this.f18405g;
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            if (z10) {
                FragmentActivity activity = getActivity();
                if (activity != null && (splashAd = splashAdRequestModel.getSplashAd()) != null) {
                    splashAd.l(new WeakReference<>(activity));
                }
                FKBaseSplashAd splashAd2 = splashAdRequestModel.getSplashAd();
                if (splashAd2 != null) {
                    splashAd2.k(this);
                }
                FKBaseSplashAd splashAd3 = splashAdRequestModel.getSplashAd();
                if (splashAd3 != null) {
                    splashAd3.i(this);
                }
            }
            ((FKStartupSplashLayout) U0(R$id.start_up_splash_layout)).o(configModel.getAdType(), splashAdRequestModel.getSplashAd());
        }
    }

    public final boolean l1() {
        return ((Boolean) this.f18409k.getValue()).booleanValue();
    }

    public final FKStartupViewModel m1() {
        return (FKStartupViewModel) this.f18403e.getValue();
    }

    public final void n1() {
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        if (splashAdRequestModel != null) {
            SplashAdSelectHelper.f18415a.O(splashAdRequestModel, EventTrackAdEndType.CLOSE);
        }
        c cVar = this.f18405g;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void o1() {
        m1().getJumpButtonAndClickAreaEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Boolean, ? extends Integer>, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends Boolean, ? extends Integer> pair) {
                invoke2((Pair<Boolean, Integer>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, Integer> it) {
                s.i(it, "it");
                ((FKStartupSplashLayout) FKStartupAdFragment.this.U0(R$id.start_up_splash_layout)).i(it.getFirst().booleanValue(), it.getSecond().intValue());
            }
        }));
        m1().getShowVipRemoveAdEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((FKStartupSplashLayout) FKStartupAdFragment.this.U0(R$id.start_up_splash_layout)).setVipRemoveAdVisible(z10);
            }
        }));
        m1().getShowAdType().observe(getViewLifecycleOwner(), new b(new Function1<FKAdType, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FKAdType fKAdType) {
                invoke2(fKAdType);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FKAdType it) {
                FKStartupSplashLayout fKStartupSplashLayout = (FKStartupSplashLayout) FKStartupAdFragment.this.U0(R$id.start_up_splash_layout);
                s.h(it, "it");
                fKStartupSplashLayout.setAdType(it);
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_start_up_ad, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        u1();
        t1();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f18408j) {
            n1();
        } else {
            this.f18408j = true;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        p1();
        o1();
        j1();
    }

    @Override // com.cupidapp.live.startup.view.b
    public void p0(@NotNull FKAdType type) {
        s.i(type, "type");
        b.a.e(this, type);
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        FKStartupMediaConfigModel configModel = splashAdRequestModel != null ? splashAdRequestModel.getConfigModel() : null;
        if (configModel != null && configModel.isThirdAdvertising()) {
            m1().setJumpButtonAndClickAreaEvent(configModel.showJumpButton(), configModel.getClickHotArea());
        }
    }

    public final void p1() {
        int i10 = R$id.start_up_image_layout;
        ((FKStartupImageLayout) U0(i10)).setStartupListener(this);
        ((FKStartupImageLayout) U0(i10)).i(this);
        int i11 = R$id.start_up_video_layout;
        ((FKStartupVideoLayout) U0(i11)).setStartupListener(this);
        ((FKStartupVideoLayout) U0(i11)).i(this);
        int i12 = R$id.start_up_splash_layout;
        ((FKStartupSplashLayout) U0(i12)).setStartupListener(this);
        ((FKStartupSplashLayout) U0(i12)).m(this);
    }

    public final void q1(FKStartupMediaModel fKStartupMediaModel) {
        List<List<List<FKStartupMediaConfigModel>>> startupMediaList = fKStartupMediaModel.getStartupMediaList();
        if (startupMediaList == null || startupMediaList.isEmpty()) {
            i3.a.f49713a.d(l1(), null, LoadAdResult.NOT_LOAD);
            m.f50240a.f(NoAdReason.SERVER_NOT_RETURN_AD_DATA);
            c cVar = this.f18405g;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        SplashAdSelectHelper.f18415a.S(getActivity(), fKStartupMediaModel, true, this, new Function1<SplashAdRequestModel, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$selectSplashAd$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SplashAdRequestModel splashAdRequestModel) {
                invoke2(splashAdRequestModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable SplashAdRequestModel splashAdRequestModel) {
                boolean l12;
                c cVar2;
                if (splashAdRequestModel == null) {
                    i3.a aVar = i3.a.f49713a;
                    l12 = FKStartupAdFragment.this.l1();
                    aVar.d(l12, SplashAdSelectHelper.f18415a.A(), LoadAdResult.LOAD_FAILED);
                    cVar2 = FKStartupAdFragment.this.f18405g;
                    if (cVar2 != null) {
                        cVar2.a();
                        return;
                    }
                    return;
                }
                FKStartupAdFragment.this.s1();
                FKStartupAdFragment.this.f18404f = splashAdRequestModel;
                FKStartupAdFragment.this.k1(splashAdRequestModel, false);
            }
        });
    }

    public final void r1() {
        this.f18407i.c(6, 1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$startAdShowCountDown$1
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
                c cVar;
                SplashAdRequestModel splashAdRequestModel;
                FKStartupMediaConfigModel configModel;
                cVar = FKStartupAdFragment.this.f18405g;
                if (cVar != null) {
                    cVar.a();
                }
                com.cupidapp.live.startup.helper.b bVar = com.cupidapp.live.startup.helper.b.f18418a;
                splashAdRequestModel = FKStartupAdFragment.this.f18404f;
                bVar.a(((Object) ((splashAdRequestModel == null || (configModel = splashAdRequestModel.getConfigModel()) == null) ? null : configModel.getAdType())) + "  6秒广告结束倒计时 -> 进入主页");
            }
        }, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$startAdShowCountDown$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                SplashAdRequestModel splashAdRequestModel;
                FKStartupMediaConfigModel configModel;
                com.cupidapp.live.startup.helper.b bVar = com.cupidapp.live.startup.helper.b.f18418a;
                splashAdRequestModel = FKStartupAdFragment.this.f18404f;
                bVar.a(((Object) ((splashAdRequestModel == null || (configModel = splashAdRequestModel.getConfigModel()) == null) ? null : configModel.getAdType())) + "  展示成功 -> 6秒广告结束倒计时 time:" + i10);
            }
        });
    }

    public final void s1() {
        this.f18406h.c(4, 1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$startReadyShowAdCountDown$1
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
                c cVar;
                m.f50240a.f(NoAdReason.AD_REQUEST_SUCCESS_BUT_SHOW_TIMEOUT);
                cVar = FKStartupAdFragment.this.f18405g;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.startup.fragment.FKStartupAdFragment$startReadyShowAdCountDown$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                SplashAdRequestModel splashAdRequestModel;
                FKStartupMediaConfigModel configModel;
                com.cupidapp.live.startup.helper.b bVar = com.cupidapp.live.startup.helper.b.f18418a;
                splashAdRequestModel = FKStartupAdFragment.this.f18404f;
                bVar.a(((Object) ((splashAdRequestModel == null || (configModel = splashAdRequestModel.getConfigModel()) == null) ? null : configModel.getAdType())) + "  请求已成功，展示未成功前的倒计时 time:" + i10);
            }
        });
    }

    public final void t1() {
        this.f18407i.g();
    }

    public final void u1() {
        this.f18406h.g();
    }

    @Override // com.cupidapp.live.startup.view.b
    public void v(@Nullable FKAdType fKAdType, @NotNull String url) {
        s.i(url, "url");
        b.a.j(this, fKAdType, url);
        SplashAdRequestModel splashAdRequestModel = this.f18404f;
        if (splashAdRequestModel != null) {
            SplashAdSelectHelper.f18415a.O(splashAdRequestModel, EventTrackAdEndType.VIP_CLOSE);
        }
        c cVar = this.f18405g;
        if (cVar != null) {
            cVar.b(url);
        }
    }
}
