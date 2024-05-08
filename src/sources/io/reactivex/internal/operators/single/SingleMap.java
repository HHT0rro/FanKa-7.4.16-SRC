package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SingleMap<T, R> extends Single<R> {
    public final Function<? super T, ? extends R> mapper;
    public final SingleSource<? extends T> source;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        public final Function<? super T, ? extends R> mapper;

        /* renamed from: t, reason: collision with root package name */
        public final SingleObserver<? super R> f50159t;

        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f50159t = singleObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f50159t.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.f50159t.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t2) {
            try {
                this.f50159t.onSuccess(ObjectHelper.requireNonNull(this.mapper.apply(t2), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new MapSingleObserver(singleObserver, this.mapper));
    }
}
