package com.cupidapp.live.superlike.presenter;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayType;
import com.cupidapp.live.vip.wrapper.BasePurchasePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperlikePurchasePresenter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperlikePurchasePresenter extends BasePurchasePresenter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final a f18627b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Disposable f18628c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperlikePurchasePresenter(@NotNull a superlikeView) {
        super(superlikeView);
        s.i(superlikeView, "superlikeView");
        this.f18627b = superlikeView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@NotNull Context context, @NotNull SuperLikePurchaseSkuModel model, @NotNull final PayType payType, int i10) {
        s.i(context, "context");
        s.i(model, "model");
        s.i(payType, "payType");
        Observable<Result<CreateOrderModel>> m10 = NetworkClient.f11868a.p().m("superlike", payType.getType(), model.getCode(), model.getActCodes(), model.getPromoCodes(), Integer.valueOf(i10));
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.superlike.presenter.SuperlikePurchasePresenter$createSuperlikePurchaseOrder$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SuperlikePurchasePresenter.this.d().a();
                return Boolean.FALSE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = m10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CreateOrderModel, p>() { // from class: com.cupidapp.live.superlike.presenter.SuperlikePurchasePresenter$createSuperlikePurchaseOrder$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CreateOrderModel createOrderModel) {
                m2823invoke(createOrderModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2823invoke(CreateOrderModel createOrderModel) {
                SuperlikePurchasePresenter.this.d().h(createOrderModel, payType);
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

    public final void c() {
        Disposable disposable = this.f18628c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f18628c;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @NotNull
    public final a d() {
        return this.f18627b;
    }

    public final void e() {
        Disposable disposed = NetworkClient.f11868a.p().f("superlike").flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SuperLikePurchaseModel, p>() { // from class: com.cupidapp.live.superlike.presenter.SuperlikePurchasePresenter$initData$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SuperLikePurchaseModel superLikePurchaseModel) {
                m2824invoke(superLikePurchaseModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2824invoke(SuperLikePurchaseModel superLikePurchaseModel) {
                SuperlikePurchasePresenter.this.d().f(superLikePurchaseModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
        this.f18628c = disposed;
    }
}
