package com.cupidapp.live.vip.wrapper;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserRankModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import x2.a;

/* compiled from: BasePurchasePresenter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BasePurchasePresenter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final c f18814a;

    public BasePurchasePresenter(@NotNull c view) {
        kotlin.jvm.internal.s.i(view, "view");
        this.f18814a = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "context");
        User X = p1.g.f52734a.X();
        if (X != null) {
            NetworkClient networkClient = NetworkClient.f11868a;
            Observable z10 = a.C0836a.z(networkClient.N(), X.userId(), null, null, false, null, 30, null);
            boolean z11 = context instanceof com.cupidapp.live.base.network.g;
            com.cupidapp.live.base.network.g gVar = z11 ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = z10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchasePresenter$refreshLocalUser$$inlined$handleByContext$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                    m2833invoke(profileResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2833invoke(ProfileResult profileResult) {
                    p1.g.f52734a.A2(profileResult.getUser());
                    EventBus.c().o(new PurchaseSuccessEvent());
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
            Observable<Result<UserRankModel>> a10 = networkClient.M().a();
            BasePurchasePresenter$refreshLocalUser$3 basePurchasePresenter$refreshLocalUser$3 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchasePresenter$refreshLocalUser$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return Boolean.TRUE;
                }
            };
            com.cupidapp.live.base.network.g gVar2 = z11 ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed2 = a10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserRankModel, kotlin.p>() { // from class: com.cupidapp.live.vip.wrapper.BasePurchasePresenter$refreshLocalUser$$inlined$handleByContext$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(UserRankModel userRankModel) {
                    m2832invoke(userRankModel);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2832invoke(UserRankModel userRankModel) {
                    UserRankModel userRankModel2 = userRankModel;
                    j1.n.f50241a.b(userRankModel2);
                    p1.g.f52734a.F1().d(userRankModel2);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(basePurchasePresenter$refreshLocalUser$3, gVar2)));
            if (disposed2 != null) {
                kotlin.jvm.internal.s.h(disposed2, "disposed");
                if (gVar2 != null) {
                    gVar2.H(disposed2);
                }
            }
            kotlin.jvm.internal.s.h(disposed2, "disposed");
        }
    }
}
