package com.hifive.sdk.ext;

import com.hifive.sdk.protocol.BaseResp;
import com.hifive.sdk.rx.BaseFunc;
import com.hifive.sdk.rx.BaseSubscribe;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommonExt.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CommonExtKt {
    @NotNull
    public static final <T> Flowable<T> convert(@NotNull Flowable<BaseResp<T>> convert) {
        s.j(convert, "$this$convert");
        Flowable<T> flowable = (Flowable<T>) convert.flatMap(new BaseFunc());
        s.e(flowable, "this.flatMap(BaseFunc())");
        return flowable;
    }

    public static final <T> void execute(@NotNull Flowable<T> execute, @NotNull BaseSubscribe<T> subscribe) {
        s.j(execute, "$this$execute");
        s.j(subscribe, "subscribe");
        execute.onBackpressureDrop().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((FlowableSubscriber) subscribe);
    }

    public static final <T> void request(@NotNull Flowable<T> request, @NotNull BaseSubscribe<T> subscribe) {
        s.j(request, "$this$request");
        s.j(subscribe, "subscribe");
        execute(request, subscribe);
    }
}
