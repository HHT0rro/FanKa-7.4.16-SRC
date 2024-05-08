package com.cupidapp.live.startup.helper;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.NoAdReason;
import com.cupidapp.live.startup.activity.StartupIsShowAdType;
import com.cupidapp.live.startup.model.EventTrackAdEndType;
import com.cupidapp.live.startup.model.EventTrackAdType;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaBaseInfoModel;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.FKStartupMediaModel;
import com.cupidapp.live.startup.model.SplashAdRequestModel;
import com.cupidapp.live.startup.splashad.ApiSplashAd;
import com.cupidapp.live.startup.splashad.BDSplashAd;
import com.cupidapp.live.startup.splashad.CSJSplash;
import com.cupidapp.live.startup.splashad.FKBaseSplashAd;
import com.cupidapp.live.startup.splashad.GDTSplashAd;
import com.cupidapp.live.startup.splashad.HuaweiJHSplashAd;
import com.cupidapp.live.startup.splashad.JDSplashAd;
import com.cupidapp.live.startup.splashad.KSSplashAd;
import com.cupidapp.live.startup.splashad.WMSplashAd;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;
import z0.v;

/* compiled from: SplashAdSelectHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SplashAdSelectHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SplashAdSelectHelper f18415a = new SplashAdSelectHelper();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static String f18416b;

    public static final void D(FKBaseSplashAd fKBaseSplashAd, WeakReference activity) {
        s.i(activity, "$activity");
        if (fKBaseSplashAd != null) {
            fKBaseSplashAd.i((LifecycleOwner) activity.get());
        }
    }

    public static final Publisher G(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public static final boolean H(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final SplashAdRequestModel I(SplashAdRequestModel max, SplashAdRequestModel current) {
        s.i(max, "max");
        s.i(current, "current");
        return current.getPrice() > max.getPrice() ? current : max;
    }

    public static final Publisher K(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public static final boolean L(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final Publisher T(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public static final void U(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void V(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w(FKStartupMediaConfigModel model, WeakReference activity, boolean z10, long j10, FlowableEmitter emitter) {
        s.i(model, "$model");
        s.i(activity, "$activity");
        s.i(emitter, "emitter");
        SplashAdSelectHelper splashAdSelectHelper = f18415a;
        model.setResourcePath(splashAdSelectHelper.E(model.getAdvertisementBaseInfo().getAdId()));
        boolean canShow = model.canShow();
        if (canShow) {
            splashAdSelectHelper.P(activity, model, z10);
        }
        b.f18418a.a(((Object) model.getMAdType()) + " 自家广告 创建Flowable: isSuccess:" + canShow);
        SplashAdRequestModel splashAdRequestModel = new SplashAdRequestModel(null, canShow, model.getAdvertisementBaseInfo().getPrice(), j10, System.currentTimeMillis(), null, model, splashAdSelectHelper.M(z10));
        if (canShow) {
            splashAdSelectHelper.Q(splashAdRequestModel);
        }
        emitter.onNext(splashAdRequestModel);
        emitter.onComplete();
    }

    public static final void y(WeakReference activity, final FKStartupMediaConfigModel model, com.cupidapp.live.startup.view.b bVar, final boolean z10, final long j10, final FlowableEmitter emitter) {
        s.i(activity, "$activity");
        s.i(model, "$model");
        s.i(emitter, "emitter");
        SplashAdSelectHelper splashAdSelectHelper = f18415a;
        final FKBaseSplashAd C = splashAdSelectHelper.C(activity, model, bVar, z10);
        if (C == null) {
            b.f18418a.a(((Object) model.getMAdType()) + " 第三方广告 创建Flowable splashAd = null");
            emitter.onNext(new SplashAdRequestModel(null, false, model.getAdvertisementBaseInfo().getPrice(), j10, System.currentTimeMillis(), null, model, splashAdSelectHelper.M(z10)));
            emitter.onComplete();
            return;
        }
        splashAdSelectHelper.P(activity, model, z10);
        C.j(new Function2<Boolean, String, p>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$createThirdPartyRequestAdFlowable$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return p.f51048a;
            }

            public final void invoke(boolean z11, @Nullable String str) {
                boolean M;
                FKBaseSplashAd fKBaseSplashAd = FKBaseSplashAd.this;
                int c4 = fKBaseSplashAd.c();
                long j11 = j10;
                long currentTimeMillis = System.currentTimeMillis();
                FKStartupMediaConfigModel fKStartupMediaConfigModel = model;
                SplashAdSelectHelper splashAdSelectHelper2 = SplashAdSelectHelper.f18415a;
                M = splashAdSelectHelper2.M(z10);
                SplashAdRequestModel splashAdRequestModel = new SplashAdRequestModel(fKBaseSplashAd, z11, c4, j11, currentTimeMillis, str, fKStartupMediaConfigModel, M);
                splashAdSelectHelper2.Q(splashAdRequestModel);
                emitter.onNext(splashAdRequestModel);
                emitter.onComplete();
            }
        });
    }

    @Nullable
    public final String A() {
        return f18416b;
    }

    public final FKBaseSplashAd B(FKStartupMediaBaseInfoModel fKStartupMediaBaseInfoModel, FKStartupMediaConfigModel fKStartupMediaConfigModel, String str, String str2, String str3) {
        if (fKStartupMediaBaseInfoModel.getByApi()) {
            return new ApiSplashAd(fKStartupMediaConfigModel, FKAdType.APIAD);
        }
        String thirdPartySource = fKStartupMediaBaseInfoModel.getThirdPartySource();
        if (s.d(thirdPartySource, FKAdType.JD.getSource())) {
            return new JDSplashAd(fKStartupMediaConfigModel, str, str2);
        }
        if (s.d(thirdPartySource, FKAdType.BD.getSource())) {
            return new BDSplashAd(fKStartupMediaConfigModel, str, str2);
        }
        if (s.d(thirdPartySource, FKAdType.KS.getSource())) {
            return new KSSplashAd(fKStartupMediaConfigModel, str, str2);
        }
        if (s.d(thirdPartySource, FKAdType.WM.getSource())) {
            return new WMSplashAd(fKStartupMediaConfigModel, str, str3, str2);
        }
        if (s.d(thirdPartySource, FKAdType.HUAWEI_JH.getSource())) {
            return new HuaweiJHSplashAd(fKStartupMediaConfigModel, str2);
        }
        if (s.d(thirdPartySource, FKAdType.GDT.getSource())) {
            return new GDTSplashAd(fKStartupMediaConfigModel, str, str2);
        }
        if (s.d(thirdPartySource, FKAdType.CSJ.getSource())) {
            return new CSJSplash(fKStartupMediaConfigModel, str, str2);
        }
        return null;
    }

    public final FKBaseSplashAd C(final WeakReference<FragmentActivity> weakReference, FKStartupMediaConfigModel fKStartupMediaConfigModel, com.cupidapp.live.startup.view.b bVar, boolean z10) {
        FragmentActivity fragmentActivity;
        FKStartupMediaBaseInfoModel advertisementBaseInfo = fKStartupMediaConfigModel.getAdvertisementBaseInfo();
        String thirdPartyId = advertisementBaseInfo.getThirdPartyId();
        if (thirdPartyId == null || thirdPartyId.length() == 0) {
            return null;
        }
        final FKBaseSplashAd B = B(advertisementBaseInfo, fKStartupMediaConfigModel, advertisementBaseInfo.getAdAppId(), thirdPartyId, advertisementBaseInfo.getAdAppKey());
        if (B != null) {
            B.l(weakReference);
        }
        if (B != null) {
            B.k(bVar);
        }
        b.f18418a.a("getSplashAd thirdPartySource:" + advertisementBaseInfo.getThirdPartySource() + " splashAd:" + ((Object) B));
        if (z10 && (fragmentActivity = weakReference.get()) != null) {
            fragmentActivity.runOnUiThread(new Runnable() { // from class: com.cupidapp.live.startup.helper.d
                @Override // java.lang.Runnable
                public final void run() {
                    SplashAdSelectHelper.D(FKBaseSplashAd.this, weakReference);
                }
            });
        }
        return B;
    }

    @Nullable
    public final String E(@NotNull String key) {
        s.i(key, "key");
        return p1.g.f52734a.N3(key).c();
    }

    public final Flowable<SplashAdRequestModel> F(final WeakReference<FragmentActivity> weakReference, List<FKStartupMediaConfigModel> list, final com.cupidapp.live.startup.view.b bVar, final boolean z10) {
        Integer num;
        Iterator<FKStartupMediaConfigModel> iterator2 = list.iterator2();
        if (iterator2.hasNext()) {
            Integer adTimeout = iterator2.next().getAdvertisementBaseInfo().getAdTimeout();
            Integer valueOf = Integer.valueOf(adTimeout != null ? adTimeout.intValue() : 3);
            while (iterator2.hasNext()) {
                Integer adTimeout2 = iterator2.next().getAdvertisementBaseInfo().getAdTimeout();
                Integer valueOf2 = Integer.valueOf(adTimeout2 != null ? adTimeout2.intValue() : 3);
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        } else {
            num = null;
        }
        Integer num2 = num;
        int intValue = num2 != null ? num2.intValue() : 3;
        Flowable onBackpressureBuffer = Flowable.fromIterable(list).onBackpressureBuffer();
        final Function1<FKStartupMediaConfigModel, Publisher<? extends SplashAdRequestModel>> function1 = new Function1<FKStartupMediaConfigModel, Publisher<? extends SplashAdRequestModel>>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$handleParallelSplashAd$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Publisher<? extends SplashAdRequestModel> invoke(@NotNull FKStartupMediaConfigModel it) {
                Flowable x10;
                Flowable v2;
                s.i(it, "it");
                b.f18418a.a("第 3 层 -> 开始并行  AdType:" + ((Object) it.getMAdType()));
                if (it.isSelfOperatedAdvertising()) {
                    v2 = SplashAdSelectHelper.f18415a.v(weakReference, it, z10);
                    return v2;
                }
                x10 = SplashAdSelectHelper.f18415a.x(weakReference, it, bVar, z10);
                return x10;
            }
        };
        Flowable take = onBackpressureBuffer.flatMap(new Function() { // from class: com.cupidapp.live.startup.helper.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher G;
                G = SplashAdSelectHelper.G(Function1.this, obj);
                return G;
            }
        }).take(intValue, TimeUnit.SECONDS);
        final SplashAdSelectHelper$handleParallelSplashAd$2 splashAdSelectHelper$handleParallelSplashAd$2 = new Function1<SplashAdRequestModel, Boolean>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$handleParallelSplashAd$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull SplashAdRequestModel it) {
                s.i(it, "it");
                b.f18418a.a("第 3 层 -> 并行结果  AdType:" + ((Object) it.getConfigModel().getMAdType()) + "  " + ((Object) it));
                return Boolean.valueOf(it.isSuccess());
            }
        };
        Flowable<SplashAdRequestModel> flowable = take.filter(new Predicate() { // from class: com.cupidapp.live.startup.helper.l
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean H;
                H = SplashAdSelectHelper.H(Function1.this, obj);
                return H;
            }
        }).reduce(new BiFunction() { // from class: com.cupidapp.live.startup.helper.f
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SplashAdRequestModel I;
                I = SplashAdSelectHelper.I((SplashAdRequestModel) obj, (SplashAdRequestModel) obj2);
                return I;
            }
        }).toFlowable();
        s.h(flowable, "activity: WeakReference<…            .toFlowable()");
        return flowable;
    }

    public final Flowable<SplashAdRequestModel> J(final WeakReference<FragmentActivity> weakReference, List<? extends List<FKStartupMediaConfigModel>> list, final com.cupidapp.live.startup.view.b bVar, final boolean z10) {
        Flowable onBackpressureBuffer = Flowable.fromIterable(list).onBackpressureBuffer();
        final Function1<List<? extends FKStartupMediaConfigModel>, Publisher<? extends SplashAdRequestModel>> function1 = new Function1<List<? extends FKStartupMediaConfigModel>, Publisher<? extends SplashAdRequestModel>>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$handleSerialSplashAd$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Publisher<? extends SplashAdRequestModel> invoke(List<? extends FKStartupMediaConfigModel> list2) {
                return invoke2((List<FKStartupMediaConfigModel>) list2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Publisher<? extends SplashAdRequestModel> invoke2(@NotNull List<FKStartupMediaConfigModel> it) {
                Flowable F;
                s.i(it, "it");
                b.f18418a.a("第 2 层 -> 开始串行");
                F = SplashAdSelectHelper.f18415a.F(weakReference, it, bVar, z10);
                return F;
            }
        };
        Flowable concatMap = onBackpressureBuffer.concatMap(new Function() { // from class: com.cupidapp.live.startup.helper.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher K;
                K = SplashAdSelectHelper.K(Function1.this, obj);
                return K;
            }
        });
        final SplashAdSelectHelper$handleSerialSplashAd$2 splashAdSelectHelper$handleSerialSplashAd$2 = new Function1<SplashAdRequestModel, Boolean>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$handleSerialSplashAd$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull SplashAdRequestModel it) {
                s.i(it, "it");
                b.f18418a.a("第 2 层 -> 串行结果  AdType:" + ((Object) it.getConfigModel().getMAdType()) + "  " + ((Object) it));
                return Boolean.valueOf(it.isSuccess());
            }
        };
        Flowable<SplashAdRequestModel> flowable = concatMap.filter(new Predicate() { // from class: com.cupidapp.live.startup.helper.m
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean L;
                L = SplashAdSelectHelper.L(Function1.this, obj);
                return L;
            }
        }).firstElement().toFlowable();
        s.h(flowable, "activity: WeakReference<…            .toFlowable()");
        return flowable;
    }

    public final boolean M(boolean z10) {
        return !z10;
    }

    public final void N(@NotNull SplashAdRequestModel requestModel) {
        s.i(requestModel, "requestModel");
        FKStartupMediaConfigModel configModel = requestModel.getConfigModel();
        j1.m.f50240a.a(f18416b, configModel.getAdvertisementBaseInfo().getAdId(), configModel.getSensorAdType(), configModel.getAdvertisementBaseInfo().getThirdPartyId(), EventTrackAdType.SPLASH, configModel.getRequestType(), requestModel.getPrice(), configModel.getClickType(), requestModel.isCache());
    }

    public final void O(@NotNull SplashAdRequestModel requestModel, @NotNull EventTrackAdEndType endType) {
        s.i(requestModel, "requestModel");
        s.i(endType, "endType");
        FKStartupMediaConfigModel configModel = requestModel.getConfigModel();
        j1.m.f50240a.b(f18416b, configModel.getAdvertisementBaseInfo().getAdId(), configModel.getSensorAdType(), configModel.getAdvertisementBaseInfo().getThirdPartyId(), EventTrackAdType.SPLASH, configModel.getRequestType(), requestModel.getAdShowToEndDuration(), configModel.getClickType(), requestModel.getPrice(), endType, requestModel.isCache());
    }

    public final void P(WeakReference<FragmentActivity> weakReference, final FKStartupMediaConfigModel fKStartupMediaConfigModel, boolean z10) {
        Observable<Result<Object>> b4 = NetworkClient.f11868a.x().b(fKStartupMediaConfigModel.getAdvertisementBaseInfo().getAdId());
        FragmentActivity fragmentActivity = weakReference.get();
        com.cupidapp.live.base.network.g gVar = fragmentActivity instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) fragmentActivity : null;
        Disposable disposed = b4.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$reportAdRequestLog$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                b bVar = b.f18418a;
                FKAdType adType = FKStartupMediaConfigModel.this.getAdType();
                bVar.a("/ad/request 广告请求接口success， AdType:" + ((Object) adType) + "  thirdPartyId:" + FKStartupMediaConfigModel.this.getAdvertisementBaseInfo().getThirdPartyId());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        j1.m.f50240a.c(f18416b, fKStartupMediaConfigModel.getReqCount(), fKStartupMediaConfigModel.getAdvertisementBaseInfo().getAdId(), fKStartupMediaConfigModel.getSensorAdType(), fKStartupMediaConfigModel.getAdvertisementBaseInfo().getThirdPartyId(), EventTrackAdType.SPLASH, fKStartupMediaConfigModel.getRequestType(), M(z10));
    }

    public final void Q(SplashAdRequestModel splashAdRequestModel) {
        FKStartupMediaConfigModel configModel = splashAdRequestModel.getConfigModel();
        j1.m.f50240a.d(f18416b, configModel.getReqCount(), configModel.getAdvertisementBaseInfo().getAdId(), configModel.getSensorAdType(), configModel.getAdvertisementBaseInfo().getThirdPartyId(), EventTrackAdType.SPLASH, configModel.getRequestType(), splashAdRequestModel.getAdReqDuration(), splashAdRequestModel.isSuccess(), splashAdRequestModel.getReason(), splashAdRequestModel.isCache());
    }

    public final void R(@NotNull SplashAdRequestModel requestModel, boolean z10, @Nullable String str) {
        s.i(requestModel, "requestModel");
        FKStartupMediaConfigModel configModel = requestModel.getConfigModel();
        j1.m.f50240a.e(f18416b, configModel.getAdvertisementBaseInfo().getAdId(), configModel.getSensorAdType(), configModel.getAdvertisementBaseInfo().getThirdPartyId(), EventTrackAdType.SPLASH, configModel.getRequestType(), z10, requestModel.getAdReturnToShowDuration(), configModel.getClickType(), requestModel.getPrice(), str, requestModel.isCache());
    }

    public final void S(@Nullable FragmentActivity fragmentActivity, @Nullable FKStartupMediaModel fKStartupMediaModel, final boolean z10, @Nullable final com.cupidapp.live.startup.view.b bVar, @NotNull final Function1<? super SplashAdRequestModel, p> callback) {
        s.i(callback, "callback");
        f18416b = UUID.randomUUID().toString();
        final FKBaseActivity fKBaseActivity = fragmentActivity instanceof FKBaseActivity ? (FKBaseActivity) fragmentActivity : null;
        if (fKBaseActivity != null && fKStartupMediaModel != null) {
            List<List<List<FKStartupMediaConfigModel>>> startupMediaList = z10 ? fKStartupMediaModel.getStartupMediaList() : fKStartupMediaModel.getStartupMediaHotStartList();
            if (startupMediaList != null) {
                Iterator<List<List<FKStartupMediaConfigModel>>> iterator2 = startupMediaList.iterator2();
                while (iterator2.hasNext()) {
                    int i10 = 0;
                    for (List<FKStartupMediaConfigModel> list : iterator2.next()) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            kotlin.collections.s.s();
                        }
                        Iterator<FKStartupMediaConfigModel> iterator22 = list.iterator2();
                        while (iterator22.hasNext()) {
                            iterator22.next().setReqCount(i11);
                        }
                        i10 = i11;
                    }
                }
            }
            long r10 = v.r(fKStartupMediaModel.getTimeOut()) - 500;
            Flowable onBackpressureBuffer = Flowable.fromIterable(startupMediaList).onBackpressureBuffer();
            final Function1<List<? extends List<? extends FKStartupMediaConfigModel>>, Publisher<? extends SplashAdRequestModel>> function1 = new Function1<List<? extends List<? extends FKStartupMediaConfigModel>>, Publisher<? extends SplashAdRequestModel>>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$selectSplashAd$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Publisher<? extends SplashAdRequestModel> invoke(List<? extends List<? extends FKStartupMediaConfigModel>> list2) {
                    return invoke2((List<? extends List<FKStartupMediaConfigModel>>) list2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Publisher<? extends SplashAdRequestModel> invoke2(@NotNull List<? extends List<FKStartupMediaConfigModel>> it) {
                    Flowable J;
                    s.i(it, "it");
                    b.f18418a.a("第 1 层 -> 开始并行");
                    J = SplashAdSelectHelper.f18415a.J(new WeakReference(FKBaseActivity.this), it, bVar, z10);
                    return J;
                }
            };
            Single observeOn = onBackpressureBuffer.flatMap(new Function() { // from class: com.cupidapp.live.startup.helper.i
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher T;
                    T = SplashAdSelectHelper.T(Function1.this, obj);
                    return T;
                }
            }).take(r10, TimeUnit.MILLISECONDS).toList().observeOn(AndroidSchedulers.mainThread());
            final Function1<List<SplashAdRequestModel>, p> function12 = new Function1<List<SplashAdRequestModel>, p>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$selectSplashAd$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(List<SplashAdRequestModel> list2) {
                    invoke2(list2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<SplashAdRequestModel> list2) {
                    SplashAdSelectHelper splashAdSelectHelper = SplashAdSelectHelper.f18415a;
                    s.h(list2, "list");
                    splashAdSelectHelper.z(list2, callback);
                }
            };
            Consumer consumer = new Consumer() { // from class: com.cupidapp.live.startup.helper.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SplashAdSelectHelper.U(Function1.this, obj);
                }
            };
            final Function1<Throwable, p> function13 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.startup.helper.SplashAdSelectHelper$selectSplashAd$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    callback.invoke(null);
                }
            };
            Disposable it = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.startup.helper.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SplashAdSelectHelper.V(Function1.this, obj);
                }
            });
            s.h(it, "it");
            fKBaseActivity.H(it);
            return;
        }
        b.f18418a.a("selectSplashAd fail mActivity:" + ((Object) fKBaseActivity) + " model:" + ((Object) fKStartupMediaModel));
        callback.invoke(null);
    }

    public final void W(@NotNull String key, @NotNull String path) {
        s.i(key, "key");
        s.i(path, "path");
        b.f18418a.a("缓存自家广告本地文件路径  key:" + key + "  path:" + path);
        p1.g.f52734a.N3(key).d(path);
    }

    public final void s(@Nullable StartupIsShowAdType startupIsShowAdType, @NotNull Function1<? super Boolean, p> toMainCallback, @NotNull Function1<? super Boolean, p> toAdCallback) {
        s.i(toMainCallback, "toMainCallback");
        s.i(toAdCallback, "toAdCallback");
        if (startupIsShowAdType == StartupIsShowAdType.MustNotShowing) {
            toMainCallback.invoke(Boolean.FALSE);
            return;
        }
        StartupIsShowAdType startupIsShowAdType2 = StartupIsShowAdType.MustShow;
        boolean z10 = startupIsShowAdType != startupIsShowAdType2;
        if (startupIsShowAdType != startupIsShowAdType2 && startupIsShowAdType != StartupIsShowAdType.MustShowAndStartToMain) {
            if (t()) {
                toAdCallback.invoke(Boolean.valueOf(z10));
                return;
            } else {
                j1.m.f50240a.f(NoAdReason.NOT_REACH_COLD_START_INTERVAL);
                toMainCallback.invoke(Boolean.valueOf(z10));
                return;
            }
        }
        toAdCallback.invoke(Boolean.valueOf(z10));
    }

    public final boolean t() {
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if (q10 == null) {
            return false;
        }
        int splashColdBootInterval = q10.getSplashColdBootInterval();
        Long c4 = gVar.p().c();
        long longValue = c4 != null ? c4.longValue() : 0L;
        long p10 = v.p(System.currentTimeMillis() - longValue);
        gVar.p().d(Long.valueOf(System.currentTimeMillis()));
        b.f18418a.a("冷启动间隔时长判断  real:" + p10 + "  指定时间:" + splashColdBootInterval + "  lastCold:" + longValue);
        return p10 >= ((long) splashColdBootInterval);
    }

    public final boolean u() {
        Integer splashHotBootInterval;
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 == null || (splashHotBootInterval = q10.getSplashHotBootInterval()) == null) {
            return false;
        }
        int intValue = splashHotBootInterval.intValue();
        long a10 = FKBaseActivity.f11750o.a();
        long p10 = v.p(System.currentTimeMillis() - a10);
        b.f18418a.a("热启动间隔时长判断  real:" + p10 + "  指定时间:" + intValue + "  lastBack:" + a10);
        return a10 != 0 && p10 >= ((long) intValue);
    }

    public final Flowable<SplashAdRequestModel> v(final WeakReference<FragmentActivity> weakReference, final FKStartupMediaConfigModel fKStartupMediaConfigModel, final boolean z10) {
        final long currentTimeMillis = System.currentTimeMillis();
        Flowable<SplashAdRequestModel> create = Flowable.create(new FlowableOnSubscribe() { // from class: com.cupidapp.live.startup.helper.c
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                SplashAdSelectHelper.w(FKStartupMediaConfigModel.this, weakReference, z10, currentTimeMillis, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER);
        s.h(create, "create({ emitter ->\n    …kpressureStrategy.BUFFER)");
        return create;
    }

    public final Flowable<SplashAdRequestModel> x(final WeakReference<FragmentActivity> weakReference, final FKStartupMediaConfigModel fKStartupMediaConfigModel, final com.cupidapp.live.startup.view.b bVar, final boolean z10) {
        final long currentTimeMillis = System.currentTimeMillis();
        Flowable<SplashAdRequestModel> create = Flowable.create(new FlowableOnSubscribe() { // from class: com.cupidapp.live.startup.helper.e
            @Override // io.reactivex.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                SplashAdSelectHelper.y(WeakReference.this, fKStartupMediaConfigModel, bVar, z10, currentTimeMillis, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER);
        s.h(create, "create({ emitter ->\n    …kpressureStrategy.BUFFER)");
        return create;
    }

    public final void z(List<SplashAdRequestModel> list, Function1<? super SplashAdRequestModel, p> function1) {
        SplashAdRequestModel next;
        Object obj;
        FKStartupMediaConfigModel configModel;
        FKStartupMediaBaseInfoModel advertisementBaseInfo;
        Iterator<SplashAdRequestModel> iterator2 = list.iterator2();
        if (iterator2.hasNext()) {
            next = iterator2.next();
            if (iterator2.hasNext()) {
                int price = next.getPrice();
                do {
                    SplashAdRequestModel next2 = iterator2.next();
                    int price2 = next2.getPrice();
                    if (price < price2) {
                        next = next2;
                        price = price2;
                    }
                } while (iterator2.hasNext());
            }
        } else {
            next = null;
        }
        SplashAdRequestModel splashAdRequestModel = next;
        if (splashAdRequestModel == null) {
            b.f18418a.a("请求广告 符合条件广告List：找到最大值为null");
            function1.invoke(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SplashAdRequestModel splashAdRequestModel2 : list) {
            b.f18418a.a("请求广告 符合条件广告List：SplashAdRequestModel:" + ((Object) splashAdRequestModel2));
            if (splashAdRequestModel2.getPrice() == splashAdRequestModel.getPrice()) {
                arrayList.add(splashAdRequestModel2);
            }
        }
        Iterator<E> iterator22 = arrayList.iterator2();
        while (true) {
            if (iterator22.hasNext()) {
                obj = iterator22.next();
                if (s.d(((SplashAdRequestModel) obj).getConfigModel().getAdvertisementBaseInfo().getBidding(), Boolean.FALSE)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj == null) {
            obj = CollectionsKt___CollectionsKt.V(arrayList);
        }
        b.f18418a.a("请求广告 最终符合条件的广告：SplashAdRequestModel:" + obj);
        for (SplashAdRequestModel splashAdRequestModel3 : list) {
            SplashAdRequestModel splashAdRequestModel4 = (SplashAdRequestModel) obj;
            if (!s.d((splashAdRequestModel4 == null || (configModel = splashAdRequestModel4.getConfigModel()) == null || (advertisementBaseInfo = configModel.getAdvertisementBaseInfo()) == null) ? null : advertisementBaseInfo.getAdId(), splashAdRequestModel3.getConfigModel().getAdvertisementBaseInfo().getAdId())) {
                f18415a.R(splashAdRequestModel3, false, "BID_FAIL");
            }
        }
        SplashAdRequestModel splashAdRequestModel5 = (SplashAdRequestModel) obj;
        if (splashAdRequestModel5 != null) {
            splashAdRequestModel5.setMAdShowTime(System.currentTimeMillis());
        }
        function1.invoke(obj);
    }
}
