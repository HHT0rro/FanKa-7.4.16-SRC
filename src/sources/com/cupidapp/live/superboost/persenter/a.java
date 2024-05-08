package com.cupidapp.live.superboost.persenter;

import com.cupidapp.live.superboost.purchase.SuperBoostType;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.PayType;
import org.jetbrains.annotations.NotNull;

/* compiled from: SuperBoostPurchasePresenter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a extends com.cupidapp.live.vip.wrapper.c {
    void b();

    void d();

    void e(@NotNull SuperLikePurchaseModel superLikePurchaseModel, @NotNull SuperLikePurchaseModel superLikePurchaseModel2, @NotNull SuperLikePurchaseModel superLikePurchaseModel3, @NotNull SuperBoostType superBoostType);

    void g(@NotNull SuperLikePurchaseSkuModel superLikePurchaseSkuModel, @NotNull PayType payType);

    void i(@NotNull SuperLikePurchaseSkuModel superLikePurchaseSkuModel, @NotNull PayType payType);
}
