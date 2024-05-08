package com.cupidapp.live.base.network;

import java.io.IOException;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetworkHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f11923a = new a(null);

    /* compiled from: NetworkHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* compiled from: NetworkHelper.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.base.network.d$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0137a implements Callback {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function2<Boolean, String, p> f11924b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0137a(Function2<? super Boolean, ? super String, p> function2) {
                this.f11924b = function2;
            }

            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e2) {
                s.i(call, "call");
                s.i(e2, "e");
                Function2<Boolean, String, p> function2 = this.f11924b;
                if (function2 != null) {
                    function2.mo1743invoke(Boolean.FALSE, e2.getMessage() + ((Object) e2.getCause()));
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                s.i(call, "call");
                s.i(response, "response");
                Function2<Boolean, String, p> function2 = this.f11924b;
                if (function2 != null) {
                    Boolean bool = Boolean.TRUE;
                    ResponseBody body = response.body();
                    function2.mo1743invoke(bool, body != null ? body.string() : null);
                }
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Request request, Function2<? super Boolean, ? super String, p> function2) {
            NetworkClient.f11868a.D().newCall(request).enqueue(new C0137a(function2));
        }

        public final void b(@Nullable String str, @Nullable Function2<? super Boolean, ? super String, p> function2) {
            if (str == null) {
                return;
            }
            a(new Request.Builder().url(str).build(), function2);
        }

        public final void c(@Nullable String str, @Nullable Map<String, ? extends Object> map, @Nullable Function2<? super Boolean, ? super String, p> function2) {
            if (str == null || map == null) {
                return;
            }
            FormBody.Builder builder = new FormBody.Builder(null, 1, null);
            for (String str2 : map.h()) {
                Object obj = map.get(str2);
                if (obj != null) {
                    builder.add(str2, obj.toString());
                }
            }
            a(new Request.Builder().url(str).post(builder.build()).build(), function2);
        }
    }
}
