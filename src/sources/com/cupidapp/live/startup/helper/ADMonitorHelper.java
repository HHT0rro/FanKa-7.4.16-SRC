package com.cupidapp.live.startup.helper;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.utils.j;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ADMonitorHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ADMonitorHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ADMonitorHelper f18414a = new ADMonitorHelper();

    public static final p c(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (p) tmp0.invoke(obj);
    }

    public final void b(@Nullable final Context context, @Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.length() > 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Flowable subscribeOn = Flowable.fromIterable(arrayList).onBackpressureLatest().subscribeOn(Schedulers.io());
        final Function1<String, p> function1 = new Function1<String, p>() { // from class: com.cupidapp.live.startup.helper.ADMonitorHelper$requestADMonitorApi$1

            /* compiled from: ADMonitorHelper.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class a implements Callback {
                @Override // okhttp3.Callback
                public void onFailure(@NotNull Call call, @NotNull IOException e2) {
                    s.i(call, "call");
                    s.i(e2, "e");
                    com.cupidapp.live.base.utils.j.f12332a.a("ADMonitorHelper", "onFailure e:" + ((Object) e2));
                }

                @Override // okhttp3.Callback
                public void onResponse(@NotNull Call call, @NotNull Response response) {
                    s.i(call, "call");
                    s.i(response, "response");
                    j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
                    ResponseBody body = response.body();
                    aVar.a("ADMonitorHelper", "onResponse body:" + ((Object) body) + "  code:" + response.code());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str2) {
                invoke2(str2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String url) {
                s.i(url, "url");
                Request.Builder removeHeader = new Request.Builder().url(url).removeHeader("User-Agent");
                String c4 = f1.c.c(context);
                s.h(c4, "getWebUserAgent(context)");
                try {
                    NetworkClient.f11868a.D().newCall(removeHeader.addHeader("User-Agent", c4).build()).enqueue(new a());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        subscribeOn.map(new Function() { // from class: com.cupidapp.live.startup.helper.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                p c4;
                c4 = ADMonitorHelper.c(Function1.this, obj);
                return c4;
            }
        }).ignoreElements().subscribe();
    }
}
