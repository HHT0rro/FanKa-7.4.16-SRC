package com.cupidapp.live.base.network;

import com.cupidapp.live.base.network.model.Result;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResultDataHandler.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i<T> implements Function<Result<? extends T>, Observable<T>> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(Result result, ObservableEmitter subscribe) {
        s.i(result, "$result");
        s.i(subscribe, "subscribe");
        if (subscribe.isDisposed()) {
            return;
        }
        if (result.getSuccess() && result.getData() != null) {
            subscribe.onNext(result.getData());
            subscribe.onComplete();
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.c(j.class.getSimpleName(), "result:" + ((Object) result));
        subscribe.onError(new ResultException(result.getStatus(), result.getMessage(), result.getStyle(), result.getJumpUrl(), result.getButtonName()));
    }

    @Override // io.reactivex.functions.Function
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Observable<T> apply(@NotNull final Result<? extends T> result) {
        s.i(result, "result");
        return Observable.create(new ObservableOnSubscribe() { // from class: com.cupidapp.live.base.network.h
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                i.c(Result.this, observableEmitter);
            }
        });
    }
}
