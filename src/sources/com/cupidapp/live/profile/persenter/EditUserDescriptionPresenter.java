package com.cupidapp.live.profile.persenter;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.main.model.UserModifyResult;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: EditUserDescriptionPresenter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserDescriptionPresenter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final a f17845a;

    public EditUserDescriptionPresenter(@NotNull a view) {
        s.i(view, "view");
        this.f17845a = view;
    }

    @NotNull
    public final a a() {
        return this.f17845a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(@Nullable String str, @NotNull final Context context) {
        s.i(context, "context");
        final Map h10 = i0.h(f.a(Integer.valueOf(RequestErrorCode.ImproperContent.getValue()), new Function1<String, p>() { // from class: com.cupidapp.live.profile.persenter.EditUserDescriptionPresenter$saveDes$serverErrorInterceptor$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str2) {
                invoke2(str2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str2) {
                h.f12779a.t(str2);
            }
        }));
        Observable y10 = a.C0836a.y(NetworkClient.f11868a.N(), null, str, 1, null);
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.persenter.EditUserDescriptionPresenter$saveDes$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                j.f(j.f12008a, it, context, h10, null, 8, null);
                return Boolean.FALSE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = y10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UserModifyResult, p>() { // from class: com.cupidapp.live.profile.persenter.EditUserDescriptionPresenter$saveDes$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserModifyResult userModifyResult) {
                m2764invoke(userModifyResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2764invoke(UserModifyResult userModifyResult) {
                p1.g gVar2 = p1.g.f52734a;
                gVar2.B2(true);
                gVar2.A2(userModifyResult.getUser());
                EditUserDescriptionPresenter.this.a().a();
                EventBus.c().o(new v1.a());
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
}
