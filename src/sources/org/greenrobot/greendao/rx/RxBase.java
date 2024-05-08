package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.Observable;
import rx.Scheduler;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class RxBase {
    public final Scheduler scheduler;

    public RxBase() {
        this.scheduler = null;
    }

    @Experimental
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    public <R> Observable<R> wrap(Callable<R> callable) {
        return wrap(RxUtils.fromCallable(callable));
    }

    public <R> Observable<R> wrap(Observable<R> observable) {
        Scheduler scheduler = this.scheduler;
        return scheduler != null ? observable.subscribeOn(scheduler) : observable;
    }

    @Experimental
    public RxBase(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
