package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {
    public final ObservableSource<T> source;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final ObservableSource<T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        public NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.items = observableSource;
            this.observer = nextObserver;
        }

        private boolean moveToNext() {
            if (!this.started) {
                this.started = true;
                this.observer.setWaiting();
                new ObservableMaterialize(this.items).subscribe(this.observer);
            }
            try {
                Notification<T> takeNext = this.observer.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnComplete()) {
                    return false;
                }
                Throwable error = takeNext.getError();
                this.error = error;
                throw ExceptionHelper.wrapOrThrow(error);
            } catch (InterruptedException e2) {
                this.observer.dispose();
                this.error = e2;
                throw ExceptionHelper.wrapOrThrow(e2);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.error;
            if (th == null) {
                if (this.hasNext) {
                    return !this.isNextConsumed || moveToNext();
                }
                return false;
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.error;
            if (th == null) {
                if (hasNext()) {
                    this.isNextConsumed = true;
                    return this.next;
                }
                throw new NoSuchElementException("No more elements");
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NextObserver<T> extends DisposableObserver<Notification<T>> {
        private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue(1);
        public final AtomicInteger waiting = new AtomicInteger();

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        public void setWaiting() {
            this.waiting.set(1);
        }

        public Notification<T> takeNext() throws InterruptedException {
            setWaiting();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        @Override // io.reactivex.Observer
        public void onNext(Notification<T> notification) {
            if (this.waiting.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<T> poll = this.buf.poll();
                    if (poll != null && !poll.isOnNext()) {
                        notification = poll;
                    }
                }
            }
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<T> iterator2() {
        return new NextIterator(this.source, new NextObserver());
    }
}
