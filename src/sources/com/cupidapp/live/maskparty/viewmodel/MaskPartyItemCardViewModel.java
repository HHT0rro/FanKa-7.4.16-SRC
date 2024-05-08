package com.cupidapp.live.maskparty.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.superboost.model.RemainAssetsResult;
import com.cupidapp.live.superboost.model.UnLimitRemainsUIModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.CreateOrderScene;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyItemCardViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<StateResult<Pair<CreateOrderModel, PayType>>> _createOrderLiveData;

    @NotNull
    private final MutableLiveData<UnLimitRemainsUIModel> _exchangeMatchNumberLiveData;

    @NotNull
    private final MutableLiveData<UnLimitRemainsUIModel> _itemCardCountLiveData;

    @NotNull
    private final MutableLiveData<SuperLikePurchaseModel> _itemCardPurchaseDataLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<UnLimitRemainsUIModel, ItemCardFeaturesItemModel>>> _useItemCardEventLiveData;

    @NotNull
    private final Application context;

    @NotNull
    private final LiveData<StateResult<Pair<CreateOrderModel, PayType>>> createOrderLiveData;

    @NotNull
    private final LiveData<UnLimitRemainsUIModel> exchangeMatchNumberLiveData;

    @NotNull
    private final LiveData<UnLimitRemainsUIModel> itemCardCountLiveData;

    @NotNull
    private final LiveData<SuperLikePurchaseModel> itemCardPurchaseDataLiveData;

    @NotNull
    private final LiveData<Event<Pair<UnLimitRemainsUIModel, ItemCardFeaturesItemModel>>> useItemCardEventLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardViewModel(@NotNull Application context) {
        super(context);
        s.i(context, "context");
        this.context = context;
        MutableLiveData<SuperLikePurchaseModel> mutableLiveData = new MutableLiveData<>();
        this._itemCardPurchaseDataLiveData = mutableLiveData;
        this.itemCardPurchaseDataLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<StateResult<Pair<CreateOrderModel, PayType>>> mutableLiveData2 = new MutableLiveData<>();
        this._createOrderLiveData = mutableLiveData2;
        this.createOrderLiveData = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<UnLimitRemainsUIModel> mutableLiveData3 = new MutableLiveData<>();
        this._itemCardCountLiveData = mutableLiveData3;
        this.itemCardCountLiveData = mutableLiveData3;
        MutableLiveData<Event<Pair<UnLimitRemainsUIModel, ItemCardFeaturesItemModel>>> mutableLiveData4 = new MutableLiveData<>();
        this._useItemCardEventLiveData = mutableLiveData4;
        this.useItemCardEventLiveData = mutableLiveData4;
        MutableLiveData<UnLimitRemainsUIModel> mutableLiveData5 = new MutableLiveData<>();
        this._exchangeMatchNumberLiveData = mutableLiveData5;
        this.exchangeMatchNumberLiveData = mutableLiveData5;
    }

    public final void createOrder(@NotNull SuperLikePurchaseSkuModel model, @NotNull final PayType payType) {
        s.i(model, "model");
        s.i(payType, "payType");
        this._createOrderLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.p().m("maskItemCard", payType.getType(), model.getCode(), model.getActCodes(), model.getPromoCodes(), Integer.valueOf(CreateOrderScene.MaskPartyItemCard.getValue())).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CreateOrderModel, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyItemCardViewModel$createOrder$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CreateOrderModel createOrderModel) {
                m2690invoke(createOrderModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2690invoke(CreateOrderModel createOrderModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MaskPartyItemCardViewModel.this._createOrderLiveData;
                mutableLiveData.setValue(new StateResult.c(new Pair(createOrderModel, payType), null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyItemCardViewModel$createOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = MaskPartyItemCardViewModel.this._createOrderLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void exchangeMatchNumber() {
        Disposable disposed = NetworkClient.f11868a.z().r().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyItemCardViewModel$exchangeMatchNumber$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                Integer m2820getRemains;
                mutableLiveData = MaskPartyItemCardViewModel.this._itemCardCountLiveData;
                UnLimitRemainsUIModel unLimitRemainsUIModel = (UnLimitRemainsUIModel) mutableLiveData.getValue();
                if (unLimitRemainsUIModel != null && (m2820getRemains = unLimitRemainsUIModel.m2820getRemains()) != null) {
                    Integer valueOf = Integer.valueOf(m2820getRemains.intValue() - 1);
                    MaskPartyItemCardViewModel maskPartyItemCardViewModel = MaskPartyItemCardViewModel.this;
                    maskPartyItemCardViewModel.setItemCardCount(UnLimitRemainsUIModel.Companion.a(maskPartyItemCardViewModel.getContext(), valueOf));
                }
                mutableLiveData2 = MaskPartyItemCardViewModel.this._exchangeMatchNumberLiveData;
                mutableLiveData3 = MaskPartyItemCardViewModel.this._itemCardCountLiveData;
                mutableLiveData2.setValue(mutableLiveData3.getValue());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<StateResult<Pair<CreateOrderModel, PayType>>> getCreateOrderLiveData() {
        return this.createOrderLiveData;
    }

    @NotNull
    public final LiveData<UnLimitRemainsUIModel> getExchangeMatchNumberLiveData() {
        return this.exchangeMatchNumberLiveData;
    }

    public final void getItemCardCount() {
        Disposable disposed = NetworkClient.f11868a.N().B("maskItemCard").flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<RemainAssetsResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyItemCardViewModel$getItemCardCount$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(RemainAssetsResult remainAssetsResult) {
                m2691invoke(remainAssetsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2691invoke(RemainAssetsResult remainAssetsResult) {
                MaskPartyItemCardViewModel maskPartyItemCardViewModel = MaskPartyItemCardViewModel.this;
                maskPartyItemCardViewModel.setItemCardCount(UnLimitRemainsUIModel.Companion.a(maskPartyItemCardViewModel.getContext(), remainAssetsResult.getRemains()));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<UnLimitRemainsUIModel> getItemCardCountLiveData() {
        return this.itemCardCountLiveData;
    }

    public final void getItemCardPurchaseData() {
        Disposable disposed = NetworkClient.f11868a.p().f("maskItemCard").flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SuperLikePurchaseModel, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyItemCardViewModel$getItemCardPurchaseData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SuperLikePurchaseModel superLikePurchaseModel) {
                m2692invoke(superLikePurchaseModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2692invoke(SuperLikePurchaseModel superLikePurchaseModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MaskPartyItemCardViewModel.this._itemCardPurchaseDataLiveData;
                mutableLiveData.setValue(superLikePurchaseModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<SuperLikePurchaseModel> getItemCardPurchaseDataLiveData() {
        return this.itemCardPurchaseDataLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<UnLimitRemainsUIModel, ItemCardFeaturesItemModel>>> getUseItemCardEventLiveData() {
        return this.useItemCardEventLiveData;
    }

    public final void setItemCardCount(@NotNull UnLimitRemainsUIModel count) {
        s.i(count, "count");
        this._itemCardCountLiveData.setValue(count);
    }

    public final void userItemCard(@NotNull ItemCardFeaturesItemModel itemCard) {
        s.i(itemCard, "itemCard");
        this._useItemCardEventLiveData.setValue(new Event<>(new Pair(this._itemCardCountLiveData.getValue(), itemCard)));
    }
}
