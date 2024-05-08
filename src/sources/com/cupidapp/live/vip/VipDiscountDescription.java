package com.cupidapp.live.vip;

import android.content.Context;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.vip.VipDiscountDescription;
import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipDiscountDescription.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipDiscountDescription implements g {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final VipDiscountDescription f18726b = new VipDiscountDescription();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static String f18727c;

    /* compiled from: VipDiscountDescription.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@Nullable String str);
    }

    @Override // com.cupidapp.live.base.network.g
    public void H(@NotNull Disposable disposable) {
        s.i(disposable, "disposable");
    }

    public final void b(@Nullable g gVar, @Nullable final a aVar) {
        String userId;
        User X = p1.g.f52734a.X();
        if (X == null || (userId = X.userId()) == null) {
            return;
        }
        if (gVar == null) {
            gVar = this;
        }
        Disposable disposed = NetworkClient.f11868a.p().e(userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<VipDiscountDescriptionResult, p>() { // from class: com.cupidapp.live.vip.VipDiscountDescription$requestDesc$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VipDiscountDescriptionResult vipDiscountDescriptionResult) {
                m2831invoke(vipDiscountDescriptionResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2831invoke(VipDiscountDescriptionResult vipDiscountDescriptionResult) {
                VipDiscountDescriptionResult vipDiscountDescriptionResult2 = vipDiscountDescriptionResult;
                VipDiscountDescription vipDiscountDescription = VipDiscountDescription.f18726b;
                VipDiscountDescription.f18727c = vipDiscountDescriptionResult2.getDescription();
                VipDiscountDescription.a aVar2 = VipDiscountDescription.a.this;
                if (aVar2 != null) {
                    aVar2.a(vipDiscountDescriptionResult2.getDescription());
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            gVar.H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.network.g
    @Nullable
    public Context getStartApiRequestContext() {
        return AppApplication.f11612d.h();
    }
}
