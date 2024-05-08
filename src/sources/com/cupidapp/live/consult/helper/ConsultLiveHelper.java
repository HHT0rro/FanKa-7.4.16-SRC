package com.cupidapp.live.consult.helper;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.consult.model.ConsultConnectUserResult;
import com.cupidapp.live.consult.model.ConsultLiveCategory;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultLiveHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ConsultLiveHelper f13820a = new ConsultLiveHelper();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Disposable f13821b;

    public static final void h(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(ConsultLiveHelper consultLiveHelper, int i10, String str, String str2, Function1 function1, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        consultLiveHelper.j(i10, str, str2, function1);
    }

    public static final void l(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final int e(@NotNull String category) {
        s.i(category, "category");
        if (s.d(category, ConsultLiveCategory.ASTROLABE.getValue())) {
            return R$mipmap.bg_consult_astrolabe;
        }
        if (s.d(category, ConsultLiveCategory.TAROT.getValue())) {
            return R$mipmap.bg_consult_tarot;
        }
        s.d(category, ConsultLiveCategory.PSYCHOLOGY.getValue());
        return R$mipmap.bg_consult_psychology;
    }

    public final int f(@NotNull String category) {
        s.i(category, "category");
        if (s.d(category, ConsultLiveCategory.ASTROLABE.getValue())) {
            return R$mipmap.ic_consult_astrolabe_tag;
        }
        if (s.d(category, ConsultLiveCategory.TAROT.getValue())) {
            return R$mipmap.ic_consult_tarot_tag;
        }
        s.d(category, ConsultLiveCategory.PSYCHOLOGY.getValue());
        return R$mipmap.ic_consult_psychology_tag;
    }

    public final void g(String str, String str2, final Function1<? super ConsultConnectUserResult, p> function1) {
        Observable observeOn = NetworkClient.f11868a.v().a(str, str2).flatMap(new i()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ConsultConnectUserResult, p> function12 = new Function1<ConsultConnectUserResult, p>() { // from class: com.cupidapp.live.consult.helper.ConsultLiveHelper$reportHeartBeat$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultConnectUserResult consultConnectUserResult) {
                invoke2(consultConnectUserResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultConnectUserResult it) {
                Function1<ConsultConnectUserResult, p> function13 = function1;
                if (function13 != null) {
                    s.h(it, "it");
                    function13.invoke(it);
                }
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.consult.helper.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConsultLiveHelper.h(Function1.this, obj);
            }
        };
        final ConsultLiveHelper$reportHeartBeat$2 consultLiveHelper$reportHeartBeat$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.consult.helper.ConsultLiveHelper$reportHeartBeat$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.consult.helper.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConsultLiveHelper.i(Function1.this, obj);
            }
        });
    }

    public final void j(int i10, @NotNull final String roomId, @NotNull final String requestId, @Nullable final Function1<? super ConsultConnectUserResult, p> function1) {
        s.i(roomId, "roomId");
        s.i(requestId, "requestId");
        if (f13821b == null) {
            Observable<Long> observeOn = Observable.interval(i10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, p> function12 = new Function1<Long, p>() { // from class: com.cupidapp.live.consult.helper.ConsultLiveHelper$startReportHeartBeat$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke2(l10);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    ConsultLiveHelper.f13820a.g(String.this, requestId, function1);
                }
            };
            f13821b = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.consult.helper.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ConsultLiveHelper.l(Function1.this, obj);
                }
            });
        }
    }

    public final void m() {
        Disposable disposable = f13821b;
        if (disposable != null) {
            disposable.dispose();
        }
        f13821b = null;
    }
}
