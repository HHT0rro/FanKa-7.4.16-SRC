package com.cupidapp.live.vip.wrapper;

import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.g;
import com.cupidapp.live.track.group.SensorVipType;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.MarketPopInfoModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.model.VipOptionsCombineModel;
import com.cupidapp.live.vip.model.VipOptionsModel;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import com.cupidapp.live.vip.model.VipStrategyModel;
import com.cupidapp.live.vip.model.VipType;
import com.cupidapp.live.visitors.model.VisitorPurchaseResult;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePresenter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchasePresenter extends BasePurchasePresenter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final d f18847b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final CompositeDisposable f18848c;

    /* compiled from: VipPurchasePresenter.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18849a;

        static {
            int[] iArr = new int[SensorVipType.values().length];
            try {
                iArr[SensorVipType.A_DIO_RAINBOW_MIXTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorVipType.DIO_RAINBOW_MIXTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorVipType.VISITOR_RAINBOW_MIXTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18849a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchasePresenter(@NotNull d mView) {
        super(mView);
        kotlin.jvm.internal.s.i(mView, "mView");
        this.f18847b = mView;
        this.f18848c = new CompositeDisposable();
    }

    public static final VipOptionsModel A(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (VipOptionsModel) tmp0.invoke(obj);
    }

    public static final VipOptionsModel C(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (VipOptionsModel) tmp0.invoke(obj);
    }

    public static final VipOptionsCombineModel E(VipOptionsModel sVip, VipOptionsModel rainbowVip) {
        kotlin.jvm.internal.s.i(sVip, "sVip");
        kotlin.jvm.internal.s.i(rainbowVip, "rainbowVip");
        return new VipOptionsCombineModel(null, null, sVip, rainbowVip, null, 16, null);
    }

    public static final VipOptionsModel G(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (VipOptionsModel) tmp0.invoke(obj);
    }

    public static final VipOptionsCombineModel I(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (VipOptionsCombineModel) tmp0.invoke(obj);
    }

    public static final VipOptionsModel L(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (VipOptionsModel) tmp0.invoke(obj);
    }

    public static final VipOptionsModel M(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (VipOptionsModel) tmp0.invoke(obj);
    }

    public static final VipOptionsCombineModel O(VipOptionsModel visitor, VipOptionsModel rainbowVip) {
        kotlin.jvm.internal.s.i(visitor, "visitor");
        kotlin.jvm.internal.s.i(rainbowVip, "rainbowVip");
        return new VipOptionsCombineModel(null, null, null, rainbowVip, visitor);
    }

    public static final void Q(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void T(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void s(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void t(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final VipOptionsCombineModel w(VipStrategyModel strategy, VipOptionsModel normalVip, VipOptionsModel sVip, VipOptionsModel rainbowVip) {
        VipPurchasePriceModel vipPurchasePriceModel;
        kotlin.jvm.internal.s.i(strategy, "strategy");
        kotlin.jvm.internal.s.i(normalVip, "normalVip");
        kotlin.jvm.internal.s.i(sVip, "sVip");
        kotlin.jvm.internal.s.i(rainbowVip, "rainbowVip");
        if (kotlin.jvm.internal.s.d(strategy.getShowPopup(), Boolean.TRUE)) {
            boolean z10 = false;
            if (strategy.getSkuCodes() != null && (!r0.isEmpty())) {
                z10 = true;
            }
            if (z10) {
                Iterator<VipPurchasePriceModel> iterator2 = normalVip.getAllAlipayOptions().iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        vipPurchasePriceModel = null;
                        break;
                    }
                    vipPurchasePriceModel = iterator2.next();
                    if (CollectionsKt___CollectionsKt.L(strategy.getSkuCodes(), vipPurchasePriceModel.getSkuCode())) {
                        break;
                    }
                }
                VipPurchasePriceModel vipPurchasePriceModel2 = vipPurchasePriceModel;
                if (vipPurchasePriceModel2 != null) {
                    vipPurchasePriceModel2.setAnimationType(strategy.getType());
                }
            }
        }
        return new VipOptionsCombineModel(strategy, normalVip, sVip, rainbowVip, null, 16, null);
    }

    public final Observable<VipOptionsModel> B() {
        Observable<R> flatMap = NetworkClient.f11868a.p().q(9).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<Throwable, VipOptionsModel> function1 = new Function1<Throwable, VipOptionsModel>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$getRainbowVipData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VipOptionsModel invoke(@NotNull Throwable it) {
                VipOptionsModel x10;
                kotlin.jvm.internal.s.i(it, "it");
                x10 = VipPurchasePresenter.this.x();
                return x10;
            }
        };
        Observable<VipOptionsModel> onErrorReturn = flatMap.onErrorReturn(new Function() { // from class: com.cupidapp.live.vip.wrapper.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VipOptionsModel C;
                C = VipPurchasePresenter.C(Function1.this, obj);
                return C;
            }
        });
        kotlin.jvm.internal.s.h(onErrorReturn, "private fun getRainbowVi…DefaultVipOptionModel() }");
        return onErrorReturn;
    }

    public final Observable<VipOptionsCombineModel> D() {
        Observable<VipOptionsCombineModel> zip = Observable.zip(F(), B(), new BiFunction() { // from class: com.cupidapp.live.vip.wrapper.f
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                VipOptionsCombineModel E;
                E = VipPurchasePresenter.E((VipOptionsModel) obj, (VipOptionsModel) obj2);
                return E;
            }
        });
        kotlin.jvm.internal.s.h(zip, "zip(\n            getSVip…         )\n            })");
        return zip;
    }

    public final Observable<VipOptionsModel> F() {
        Observable<R> flatMap = NetworkClient.f11868a.p().q(5).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<Throwable, VipOptionsModel> function1 = new Function1<Throwable, VipOptionsModel>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$getSVipData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VipOptionsModel invoke(@NotNull Throwable it) {
                VipOptionsModel x10;
                kotlin.jvm.internal.s.i(it, "it");
                x10 = VipPurchasePresenter.this.x();
                return x10;
            }
        };
        Observable<VipOptionsModel> onErrorReturn = flatMap.onErrorReturn(new Function() { // from class: com.cupidapp.live.vip.wrapper.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VipOptionsModel G;
                G = VipPurchasePresenter.G(Function1.this, obj);
                return G;
            }
        });
        kotlin.jvm.internal.s.h(onErrorReturn, "private fun getSVipData(…DefaultVipOptionModel() }");
        return onErrorReturn;
    }

    public final Observable<VipOptionsCombineModel> H() {
        Observable<VipOptionsModel> B = B();
        final VipPurchasePresenter$getSingleRainbowVipData$1 vipPurchasePresenter$getSingleRainbowVipData$1 = new Function1<VipOptionsModel, VipOptionsCombineModel>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$getSingleRainbowVipData$1
            @Override // kotlin.jvm.functions.Function1
            public final VipOptionsCombineModel invoke(@NotNull VipOptionsModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                return new VipOptionsCombineModel(null, null, null, it, null, 16, null);
            }
        };
        Observable map = B.map(new Function() { // from class: com.cupidapp.live.vip.wrapper.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VipOptionsCombineModel I;
                I = VipPurchasePresenter.I(Function1.this, obj);
                return I;
            }
        });
        kotlin.jvm.internal.s.h(map, "getRainbowVipData().map …inbowVip = it\n        ) }");
        return map;
    }

    @NotNull
    public final Observable<VipStrategyModel> J() {
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null ? kotlin.jvm.internal.s.d(q10.getCheckStrategyPopup(), Boolean.TRUE) : false) {
            Observable<VipStrategyModel> onErrorReturnItem = NetworkClient.f11868a.p().o(1, 1).flatMap(new com.cupidapp.live.base.network.i()).onErrorReturnItem(new VipStrategyModel(Boolean.FALSE, null, null));
            kotlin.jvm.internal.s.h(onErrorReturnItem, "{\n            NetworkCli…              )\n        }");
            return onErrorReturnItem;
        }
        Observable<VipStrategyModel> just = Observable.just(new VipStrategyModel(Boolean.FALSE, null, null));
        kotlin.jvm.internal.s.h(just, "{\n            Observable…e, null, null))\n        }");
        return just;
    }

    public final Observable<VipOptionsModel> K() {
        Observable<R> flatMap = NetworkClient.f11868a.p().h().flatMap(new com.cupidapp.live.base.network.i());
        final VipPurchasePresenter$getVisitor$1 vipPurchasePresenter$getVisitor$1 = new Function1<VisitorPurchaseResult, VipOptionsModel>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$getVisitor$1
            @Override // kotlin.jvm.functions.Function1
            public final VipOptionsModel invoke(@NotNull VisitorPurchaseResult it) {
                kotlin.jvm.internal.s.i(it, "it");
                List<VipPurchasePriceModel> visitorAlipayOptions = it.getVisitorAlipayOptions();
                if (visitorAlipayOptions == null) {
                    visitorAlipayOptions = kotlin.collections.s.j();
                }
                List<VipPurchasePriceModel> list = visitorAlipayOptions;
                List<VipPurchasePriceModel> visitorWechatOptions = it.getVisitorWechatOptions();
                if (visitorWechatOptions == null) {
                    visitorWechatOptions = kotlin.collections.s.j();
                }
                List<VipPurchasePriceModel> list2 = visitorWechatOptions;
                List<VipPurchasePriceModel> vipWechatHideOptions = it.getVipWechatHideOptions();
                if (vipWechatHideOptions == null) {
                    vipWechatHideOptions = kotlin.collections.s.j();
                }
                List<VipPurchasePriceModel> list3 = vipWechatHideOptions;
                List<VipPurchasePriceModel> vipWechatPublicOptions = it.getVipWechatPublicOptions();
                if (vipWechatPublicOptions == null) {
                    vipWechatPublicOptions = kotlin.collections.s.j();
                }
                List<VipPurchasePriceModel> list4 = vipWechatPublicOptions;
                List<VipPurchasePriceModel> vipAlipayPublicOptions = it.getVipAlipayPublicOptions();
                if (vipAlipayPublicOptions == null) {
                    vipAlipayPublicOptions = kotlin.collections.s.j();
                }
                List<VipPurchasePriceModel> list5 = vipAlipayPublicOptions;
                List<VipPurchasePriceModel> vipAlipayHideOptions = it.getVipAlipayHideOptions();
                if (vipAlipayHideOptions == null) {
                    vipAlipayHideOptions = kotlin.collections.s.j();
                }
                List<VipPurchasePriceModel> list6 = vipAlipayHideOptions;
                Long userStrategyEndTime = it.getUserStrategyEndTime();
                return new VipOptionsModel(list, list5, list6, list2, list4, list3, false, null, userStrategyEndTime != null ? userStrategyEndTime.longValue() : 0L, null, 704, null);
            }
        };
        Observable map = flatMap.map(new Function() { // from class: com.cupidapp.live.vip.wrapper.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VipOptionsModel L;
                L = VipPurchasePresenter.L(Function1.this, obj);
                return L;
            }
        });
        final Function1<Throwable, VipOptionsModel> function1 = new Function1<Throwable, VipOptionsModel>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$getVisitor$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VipOptionsModel invoke(@NotNull Throwable it) {
                VipOptionsModel x10;
                kotlin.jvm.internal.s.i(it, "it");
                x10 = VipPurchasePresenter.this.x();
                return x10;
            }
        };
        Observable<VipOptionsModel> onErrorReturn = map.onErrorReturn(new Function() { // from class: com.cupidapp.live.vip.wrapper.s
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VipOptionsModel M;
                M = VipPurchasePresenter.M(Function1.this, obj);
                return M;
            }
        });
        kotlin.jvm.internal.s.h(onErrorReturn, "private fun getVisitor()…DefaultVipOptionModel() }");
        return onErrorReturn;
    }

    public final Observable<VipOptionsCombineModel> N() {
        Observable<VipOptionsCombineModel> zip = Observable.zip(K(), B(), new BiFunction() { // from class: com.cupidapp.live.vip.wrapper.k
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                VipOptionsCombineModel O;
                O = VipPurchasePresenter.O((VipOptionsModel) obj, (VipOptionsModel) obj2);
                return O;
            }
        });
        kotlin.jvm.internal.s.h(zip, "zip(getVisitor(), getRai…         )\n            })");
        return zip;
    }

    public final void P(@NotNull SensorVipType sensorVipType) {
        Observable<VipOptionsCombineModel> v2;
        kotlin.jvm.internal.s.i(sensorVipType, "sensorVipType");
        int i10 = a.f18849a[sensorVipType.ordinal()];
        if (i10 == 1) {
            v2 = v();
        } else if (i10 == 2) {
            v2 = D();
        } else if (i10 != 3) {
            v2 = H();
        } else {
            v2 = N();
        }
        Observable<VipOptionsCombineModel> observeOn = v2.observeOn(AndroidSchedulers.mainThread());
        final Function1<VipOptionsCombineModel, kotlin.p> function1 = new Function1<VipOptionsCombineModel, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$initData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(VipOptionsCombineModel vipOptionsCombineModel) {
                invoke2(vipOptionsCombineModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VipOptionsCombineModel it) {
                d y10 = VipPurchasePresenter.this.y();
                kotlin.jvm.internal.s.h(it, "it");
                y10.j(it);
            }
        };
        Consumer<? super VipOptionsCombineModel> consumer = new Consumer() { // from class: com.cupidapp.live.vip.wrapper.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VipPurchasePresenter.R(Function1.this, obj);
            }
        };
        final VipPurchasePresenter$initData$2 vipPurchasePresenter$initData$2 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$initData$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                kotlin.jvm.internal.s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        this.f18848c.add(observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.vip.wrapper.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VipPurchasePresenter.Q(Function1.this, obj);
            }
        }));
    }

    public final void S(@NotNull List<Integer> productType) {
        kotlin.jvm.internal.s.i(productType, "productType");
        Observable<Result<MarketPopInfoModel>> observeOn = NetworkClient.f11868a.p().b(productType).observeOn(AndroidSchedulers.mainThread());
        final Function1<Result<? extends MarketPopInfoModel>, kotlin.p> function1 = new Function1<Result<? extends MarketPopInfoModel>, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$showMarketPopInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Result<? extends MarketPopInfoModel> result) {
                invoke2((Result<MarketPopInfoModel>) result);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<MarketPopInfoModel> result) {
                d y10 = VipPurchasePresenter.this.y();
                MarketPopInfoModel data = result.getData();
                y10.c(data != null ? data.getUrl() : null);
            }
        };
        this.f18848c.add(observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.vip.wrapper.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VipPurchasePresenter.T(Function1.this, obj);
            }
        }));
    }

    public final void q(int i10) {
        Disposable disposed = g.a.a(NetworkClient.f11868a.p(), i10, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$animLoadedCallBack$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void r(@NotNull VipPurchasePriceModel model, @NotNull final PayType payType, @Nullable Integer num) {
        Observable<Result<CreateOrderModel>> p10;
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(payType, "payType");
        if (model.getVipType() == VipType.VISITOR) {
            p10 = NetworkClient.f11868a.p().d(payType.getType(), model.getId(), model.getSkuCode(), model.getActCodes(), model.getPromoCodes(), num);
        } else {
            p10 = NetworkClient.f11868a.p().p(model.getId(), payType.getType(), model.getSkuCode(), model.getActCodes(), model.getPromoCodes(), num);
        }
        Observable<Result<CreateOrderModel>> observeOn = p10.observeOn(AndroidSchedulers.mainThread());
        final Function1<Result<? extends CreateOrderModel>, kotlin.p> function1 = new Function1<Result<? extends CreateOrderModel>, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$createOrder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Result<? extends CreateOrderModel> result) {
                invoke2((Result<CreateOrderModel>) result);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<CreateOrderModel> result) {
                CreateOrderModel data = result.getData();
                if (data != null) {
                    VipPurchasePresenter vipPurchasePresenter = VipPurchasePresenter.this;
                    vipPurchasePresenter.y().h(data, payType);
                }
            }
        };
        Consumer<? super Result<CreateOrderModel>> consumer = new Consumer() { // from class: com.cupidapp.live.vip.wrapper.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VipPurchasePresenter.s(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$createOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                VipPurchasePresenter.this.y().a();
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                kotlin.jvm.internal.s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        this.f18848c.add(observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.vip.wrapper.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VipPurchasePresenter.t(Function1.this, obj);
            }
        }));
    }

    public final void u() {
        this.f18848c.dispose();
    }

    public final Observable<VipOptionsCombineModel> v() {
        Observable<VipOptionsCombineModel> zip = Observable.zip(J(), z(), F(), B(), new Function4() { // from class: com.cupidapp.live.vip.wrapper.q
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                VipOptionsCombineModel w3;
                w3 = VipPurchasePresenter.w((VipStrategyModel) obj, (VipOptionsModel) obj2, (VipOptionsModel) obj3, (VipOptionsModel) obj4);
                return w3;
            }
        });
        kotlin.jvm.internal.s.h(zip, "zip(\n            getVipS…)\n            }\n        )");
        return zip;
    }

    public final VipOptionsModel x() {
        return new VipOptionsModel(kotlin.collections.s.j(), kotlin.collections.s.j(), kotlin.collections.s.j(), kotlin.collections.s.j(), kotlin.collections.s.j(), kotlin.collections.s.j(), false, null, 0L, null, 960, null);
    }

    @NotNull
    public final d y() {
        return this.f18847b;
    }

    public final Observable<VipOptionsModel> z() {
        Observable flatMap = g.a.b(NetworkClient.f11868a.p(), null, 1, null).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<Throwable, VipOptionsModel> function1 = new Function1<Throwable, VipOptionsModel>() { // from class: com.cupidapp.live.vip.wrapper.VipPurchasePresenter$getNormalVipData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final VipOptionsModel invoke(@NotNull Throwable it) {
                VipOptionsModel x10;
                kotlin.jvm.internal.s.i(it, "it");
                x10 = VipPurchasePresenter.this.x();
                return x10;
            }
        };
        Observable<VipOptionsModel> onErrorReturn = flatMap.onErrorReturn(new Function() { // from class: com.cupidapp.live.vip.wrapper.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VipOptionsModel A;
                A = VipPurchasePresenter.A(Function1.this, obj);
                return A;
            }
        });
        kotlin.jvm.internal.s.h(onErrorReturn, "private fun getNormalVip…DefaultVipOptionModel() }");
        return onErrorReturn;
    }
}
