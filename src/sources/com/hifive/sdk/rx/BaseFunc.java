package com.hifive.sdk.rx;

import com.hifive.sdk.protocol.BaseResp;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseFunc.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class BaseFunc<T> implements Function<BaseResp<? extends T>, Flowable<T>> {
    @Override // io.reactivex.functions.Function
    @NotNull
    public Flowable<T> apply(@NotNull BaseResp<? extends T> t2) {
        Flowable<T> just;
        String str;
        s.j(t2, "t");
        if (t2.getCode() != 200) {
            Flowable<T> error = Flowable.error(new BaseException(Integer.valueOf(t2.getCode()), t2.getMsg()));
            s.e(error, "Flowable.error(BaseException(t.code, t.msg))");
            return error;
        }
        if (t2.getData() != null) {
            just = Flowable.just(t2.getData());
            str = "Flowable.just(t.data)";
        } else {
            just = Flowable.just("");
            str = "Flowable.just(\"\" as T)";
        }
        s.e(just, str);
        return just;
    }
}
