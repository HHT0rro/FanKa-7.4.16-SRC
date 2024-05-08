package com.cupidapp.live.liveshow.pk.util;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkPrepareModel;
import com.cupidapp.live.liveshow.pk.model.StartMultiPkResult;
import com.cupidapp.live.liveshow.pk.view.MultiPersonPkState;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkPresenter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPersonPkPresenter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f15152a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public b f15153b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f15154c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f15155d;

    /* compiled from: MultiPersonPkPresenter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15156a;

        static {
            int[] iArr = new int[MultiPersonPkState.values().length];
            try {
                iArr[MultiPersonPkState.PKPrepare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MultiPersonPkState.PKing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MultiPersonPkState.PKInteract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15156a = iArr;
        }
    }

    public MultiPersonPkPresenter(@NotNull Context context) {
        s.i(context, "context");
        this.f15152a = context;
    }

    public final void d() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || this.f15154c == null) {
            return;
        }
        b bVar = this.f15153b;
        if (bVar != null) {
            bVar.b();
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str = this.f15154c;
        s.f(str);
        Observable<Result<Object>> m10 = r10.m(itemId, str);
        Object obj = this.f15152a;
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$cancelPrepareMultiPk$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                b bVar2;
                s.i(it, "it");
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                return Boolean.FALSE;
            }
        };
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = m10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$cancelPrepareMultiPk$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                invoke2(obj2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                b bVar2;
                b bVar3;
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                bVar3 = MultiPersonPkPresenter.this.f15153b;
                if (bVar3 != null) {
                    bVar3.d();
                }
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

    public final void e(@NotNull MultiPersonPkState pkState) {
        s.i(pkState, "pkState");
        int i10 = a.f15156a[pkState.ordinal()];
        if (i10 == 1) {
            d();
        } else if (i10 == 2 || i10 == 3) {
            n();
        }
        i(pkState);
    }

    @Nullable
    public final String f() {
        return this.f15154c;
    }

    public final void g() {
        LiveShowModel liveShowModel;
        String itemId;
        if (this.f15154c == null || (liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel()) == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str = this.f15154c;
        s.f(str);
        Observable<Result<Object>> y02 = r10.y0(str, itemId);
        Object obj = this.f15152a;
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = y02.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$mixStreamSuccess$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                invoke2(obj2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void h() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        b bVar = this.f15153b;
        if (bVar != null) {
            bVar.b();
        }
        Observable<Result<MultiPkPrepareModel>> y10 = NetworkClient.f11868a.r().y(itemId);
        Object obj = this.f15152a;
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$prepareMultiPk$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                b bVar2;
                s.i(it, "it");
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                return Boolean.FALSE;
            }
        };
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = y10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MultiPkPrepareModel, p>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$prepareMultiPk$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MultiPkPrepareModel multiPkPrepareModel) {
                m2632invoke(multiPkPrepareModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2632invoke(MultiPkPrepareModel multiPkPrepareModel) {
                b bVar2;
                b bVar3;
                MultiPkPrepareModel multiPkPrepareModel2 = multiPkPrepareModel;
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                MultiPersonPkPresenter.this.f15154c = multiPkPrepareModel2.getPkPrepareId();
                bVar3 = MultiPersonPkPresenter.this.f15153b;
                if (bVar3 != null) {
                    bVar3.c(multiPkPrepareModel2);
                }
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

    public final void i(MultiPersonPkState multiPersonPkState) {
        User user;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        GroupLiveLog.f18698a.J(this.f15155d, liveShowModel != null ? liveShowModel.getItemId() : null, (liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.userId(), null, LivePkType.MultiPk, multiPersonPkState);
    }

    public final void j(@NotNull String pairId) {
        s.i(pairId, "pairId");
        this.f15155d = pairId;
    }

    public final void k(@NotNull String prepareId) {
        s.i(prepareId, "prepareId");
        this.f15154c = prepareId;
    }

    public final void l(@NotNull b listener) {
        s.i(listener, "listener");
        this.f15153b = listener;
    }

    public final void m() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || this.f15154c == null) {
            return;
        }
        b bVar = this.f15153b;
        if (bVar != null) {
            bVar.b();
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str = this.f15154c;
        s.f(str);
        Observable<Result<StartMultiPkResult>> p02 = r10.p0(itemId, str);
        Object obj = this.f15152a;
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$startMultiPk$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                b bVar2;
                s.i(it, "it");
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                return Boolean.FALSE;
            }
        };
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = p02.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<StartMultiPkResult, p>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$startMultiPk$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(StartMultiPkResult startMultiPkResult) {
                m2633invoke(startMultiPkResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2633invoke(StartMultiPkResult startMultiPkResult) {
                b bVar2;
                StartMultiPkResult startMultiPkResult2 = startMultiPkResult;
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                MultiPersonPkPresenter.this.f15155d = startMultiPkResult2.getPkPairId();
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

    public final void n() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || this.f15155d == null) {
            return;
        }
        b bVar = this.f15153b;
        if (bVar != null) {
            bVar.b();
        }
        u2.a r10 = NetworkClient.f11868a.r();
        String str = this.f15155d;
        s.f(str);
        Observable<Result<Object>> c02 = r10.c0(itemId, str);
        Object obj = this.f15152a;
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$stopMultiPk$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                b bVar2;
                s.i(it, "it");
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                return Boolean.FALSE;
            }
        };
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = c02.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter$stopMultiPk$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                invoke2(obj2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
                b bVar2;
                b bVar3;
                bVar2 = MultiPersonPkPresenter.this.f15153b;
                if (bVar2 != null) {
                    bVar2.a();
                }
                bVar3 = MultiPersonPkPresenter.this.f15153b;
                if (bVar3 != null) {
                    bVar3.d();
                }
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
