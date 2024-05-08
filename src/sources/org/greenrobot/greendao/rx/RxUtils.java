package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.Observable;
import rx.functions.Func0;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class RxUtils {
    @Internal
    public static <T> Observable<T> fromCallable(final Callable<T> callable) {
        return Observable.defer(new Func0<Observable<T>>() { // from class: org.greenrobot.greendao.rx.RxUtils.1
            public Observable<T> call() {
                try {
                    return Observable.just(Callable.this.call());
                } catch (Exception e2) {
                    return Observable.error(e2);
                }
            }
        });
    }
}
