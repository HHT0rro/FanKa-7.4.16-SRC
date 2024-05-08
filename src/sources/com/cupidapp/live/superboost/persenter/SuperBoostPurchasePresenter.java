package com.cupidapp.live.superboost.persenter;

import android.content.Context;
import com.cupidapp.live.base.abtest.ABTestGroup;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.ResultException;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ABTestKey;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.ABTestModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
import com.cupidapp.live.superboost.purchase.SuperBoostType;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchasePresenter;
import com.cupidapp.live.vip.wrapper.CreateOrderScene;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.i0;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperBoostPurchasePresenter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostPurchasePresenter extends BasePurchasePresenter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final a f18591b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Disposable f18592c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostPurchasePresenter(@NotNull a boostView) {
        super(boostView);
        s.i(boostView, "boostView");
        this.f18591b = boostView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Triple j(Ref$ObjectRef defaultTab, SuperLikePurchaseModel t12, SuperLikePurchaseModel t2, SuperLikePurchaseModel t32, ABTestListResult t42) {
        ABTestModel aBTestModel;
        T t10;
        ABTestModel aBTestModel2;
        s.i(defaultTab, "$defaultTab");
        s.i(t12, "t1");
        s.i(t2, "t2");
        s.i(t32, "t3");
        s.i(t42, "t4");
        List<ABTestModel> testResults = t42.getTestResults();
        if (testResults != null) {
            Iterator<ABTestModel> iterator2 = testResults.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    aBTestModel2 = null;
                    break;
                }
                aBTestModel2 = iterator2.next();
                if (s.d(aBTestModel2.getName(), ABTestKey.SUPER_BOOST_PURCHASE_DEFAULT_TAB.getValue())) {
                    break;
                }
            }
            aBTestModel = aBTestModel2;
        } else {
            aBTestModel = null;
        }
        if (s.d(aBTestModel != null ? aBTestModel.getResult() : null, ABTestGroup.B.getValue())) {
            t10 = SuperBoostType.DIRECT;
        } else {
            t10 = SuperBoostType.NON_DIRECT;
        }
        defaultTab.element = t10;
        return new Triple(t12, t2, t32);
    }

    public static final void k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(@NotNull Context context, @NotNull final SuperLikePurchaseSkuModel skuModel, @NotNull final PayType payType) {
        s.i(context, "context");
        s.i(skuModel, "skuModel");
        s.i(payType, "payType");
        Observable<Result<PrivacySettingDataResult>> F0 = NetworkClient.f11868a.N().F0();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$checkCustomStealth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SuperBoostPurchasePresenter.this.h().i(skuModel, payType);
                return Boolean.TRUE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = F0.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PrivacySettingDataResult, p>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$checkCustomStealth$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PrivacySettingDataResult privacySettingDataResult) {
                m2821invoke(privacySettingDataResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2821invoke(PrivacySettingDataResult privacySettingDataResult) {
                PrivacySettingDataResult privacySettingDataResult2 = privacySettingDataResult;
                if (privacySettingDataResult2.getMatchExcludeDistanceKm() != null) {
                    Integer matchExcludeDistanceKm = privacySettingDataResult2.getMatchExcludeDistanceKm();
                    s.f(matchExcludeDistanceKm);
                    if (matchExcludeDistanceKm.intValue() > 0) {
                        SuperBoostPurchasePresenter.this.h().g(skuModel, payType);
                        return;
                    }
                }
                SuperBoostPurchasePresenter.this.h().i(skuModel, payType);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(@NotNull Context context, @NotNull SuperLikePurchaseSkuModel model, @NotNull final PayType payType) {
        s.i(context, "context");
        s.i(model, "model");
        s.i(payType, "payType");
        Observable<Result<CreateOrderModel>> m10 = NetworkClient.f11868a.p().m("superboost", payType.getType(), model.getCode(), model.getActCodes(), model.getPromoCodes(), Integer.valueOf(CreateOrderScene.SuperBoost.getValue()));
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$createSuperBoostPurchaseOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SuperBoostPurchasePresenter.this.h().a();
                j jVar = j.f12008a;
                Integer valueOf = Integer.valueOf(RequestErrorCode.ForUserExposureExperience.getValue());
                final SuperBoostPurchasePresenter superBoostPurchasePresenter = SuperBoostPurchasePresenter.this;
                j.f(jVar, it, null, i0.h(f.a(valueOf, new Function1<String, p>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$createSuperBoostPurchaseOrder$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(String str) {
                        invoke2(str);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str) {
                        SuperBoostPurchasePresenter.this.h().b();
                        SuperBoostPurchasePresenter.this.h().d();
                    }
                })), null, 10, null);
                if ((it instanceof ResultException) && s.d(((ResultException) it).getStyle(), "alert")) {
                    SuperBoostPurchasePresenter.this.h().b();
                }
                return Boolean.TRUE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = m10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CreateOrderModel, p>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$createSuperBoostPurchaseOrder$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CreateOrderModel createOrderModel) {
                m2822invoke(createOrderModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2822invoke(CreateOrderModel createOrderModel) {
                SuperBoostPurchasePresenter.this.h().h(createOrderModel, payType);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void g() {
        Disposable disposable = this.f18592c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f18592c;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @NotNull
    public final a h() {
        return this.f18591b;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.cupidapp.live.superboost.purchase.SuperBoostType] */
    public final void i() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = SuperBoostType.NON_DIRECT;
        NetworkClient networkClient = NetworkClient.f11868a;
        Observable observeOn = Observable.zip(networkClient.p().f("superboost").flatMap(new i()), networkClient.p().f("targetedsuperboost").flatMap(new i()), networkClient.p().f("travelboost").flatMap(new i()), networkClient.i().g(ABTestKey.SUPER_BOOST_PURCHASE_DEFAULT_TAB.getValue()).flatMap(new i()).onErrorReturnItem(new ABTestListResult(null)), new Function4() { // from class: com.cupidapp.live.superboost.persenter.d
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                Triple j10;
                j10 = SuperBoostPurchasePresenter.j(Ref$ObjectRef.this, (SuperLikePurchaseModel) obj, (SuperLikePurchaseModel) obj2, (SuperLikePurchaseModel) obj3, (ABTestListResult) obj4);
                return j10;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<Triple<? extends SuperLikePurchaseModel, ? extends SuperLikePurchaseModel, ? extends SuperLikePurchaseModel>, p> function1 = new Function1<Triple<? extends SuperLikePurchaseModel, ? extends SuperLikePurchaseModel, ? extends SuperLikePurchaseModel>, p>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$initData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Triple<? extends SuperLikePurchaseModel, ? extends SuperLikePurchaseModel, ? extends SuperLikePurchaseModel> triple) {
                invoke2((Triple<SuperLikePurchaseModel, SuperLikePurchaseModel, SuperLikePurchaseModel>) triple);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Triple<SuperLikePurchaseModel, SuperLikePurchaseModel, SuperLikePurchaseModel> triple) {
                SuperBoostPurchasePresenter.this.h().e(triple.getFirst(), triple.getSecond(), triple.getThird(), ref$ObjectRef.element);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.superboost.persenter.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SuperBoostPurchasePresenter.k(Function1.this, obj);
            }
        };
        final SuperBoostPurchasePresenter$initData$3 superBoostPurchasePresenter$initData$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.superboost.persenter.SuperBoostPurchasePresenter$initData$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                j jVar = j.f12008a;
                s.h(it, "it");
                j.f(jVar, it, null, null, null, 14, null);
            }
        };
        this.f18592c = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.superboost.persenter.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SuperBoostPurchasePresenter.l(Function1.this, obj);
            }
        });
    }
}
