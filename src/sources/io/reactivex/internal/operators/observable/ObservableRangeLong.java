package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        public final Observer<? super Long> downstream;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(Observer<? super Long> observer, long j10, long j11) {
            this.downstream = observer;
            this.index = j10;
            this.end = j11;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        public void run() {
            if (this.fused) {
                return;
            }
            Observer<? super Long> observer = this.downstream;
            long j10 = this.end;
            for (long j11 = this.index; j11 != j10 && get() == 0; j11++) {
                observer.onNext(Long.valueOf(j11));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Long poll() throws Exception {
            long j10 = this.index;
            if (j10 != this.end) {
                this.index = 1 + j10;
                return Long.valueOf(j10);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j10, long j11) {
        this.start = j10;
        this.count = j11;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        long j10 = this.start;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j10, j10 + this.count);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
