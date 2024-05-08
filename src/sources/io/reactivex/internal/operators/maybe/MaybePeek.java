package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    public final Action onAfterTerminate;
    public final Action onCompleteCall;
    public final Action onDisposeCall;
    public final Consumer<? super Throwable> onErrorCall;
    public final Consumer<? super Disposable> onSubscribeCall;
    public final Consumer<? super T> onSuccessCall;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        public final MaybeObserver<? super T> downstream;
        public final MaybePeek<T> parent;
        public Disposable upstream;

        public MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.downstream = maybeObserver;
            this.parent = maybePeek;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                this.parent.onDisposeCall.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onAfterTerminate() {
            try {
                this.parent.onAfterTerminate.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Disposable disposable = this.upstream;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            try {
                this.parent.onCompleteCall.run();
                this.upstream = disposableHelper;
                this.downstream.onComplete();
                onAfterTerminate();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onErrorInner(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
            } else {
                onErrorInner(th);
            }
        }

        public void onErrorInner(Throwable th) {
            try {
                this.parent.onErrorCall.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
            onAfterTerminate();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                try {
                    this.parent.onSubscribeCall.accept(disposable);
                    this.upstream = disposable;
                    this.downstream.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    this.upstream = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.downstream);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t2) {
            Disposable disposable = this.upstream;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            try {
                this.parent.onSuccessCall.accept(t2);
                this.upstream = disposableHelper;
                this.downstream.onSuccess(t2);
                onAfterTerminate();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onErrorInner(th);
            }
        }
    }

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.onSubscribeCall = consumer;
        this.onSuccessCall = consumer2;
        this.onErrorCall = consumer3;
        this.onCompleteCall = action;
        this.onAfterTerminate = action2;
        this.onDisposeCall = action3;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new MaybePeekObserver(maybeObserver, this));
    }
}
