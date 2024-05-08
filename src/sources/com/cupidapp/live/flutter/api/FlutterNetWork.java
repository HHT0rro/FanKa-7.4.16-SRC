package com.cupidapp.live.flutter.api;

import android.app.Activity;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ResultException;
import com.cupidapp.live.base.network.j;
import io.flutter.plugin.common.MethodCall;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;

/* compiled from: FlutterNetWork.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FlutterNetWork {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FlutterNetWork f14654a = new FlutterNetWork();

    public static final void f(Activity activity) {
        ((FKBaseActivity) activity).V0();
    }

    public static final void g(ErrorResult errorResult, Activity activity) {
        j.f(j.f12008a, new ResultException(errorResult.getStatus(), errorResult.getMessage(), errorResult.getStyle(), errorResult.getJumpUrl(), errorResult.getButtonName()), activity, null, null, 12, null);
    }

    public static final void i(Activity activity) {
        ((FKBaseActivity) activity).e1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        r5.runOnUiThread(new com.cupidapp.live.flutter.api.c(r2, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String e(boolean r2, java.lang.String r3, java.lang.Boolean r4, final android.app.Activity r5) {
        /*
            r1 = this;
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.s.d(r4, r0)
            if (r4 == 0) goto L17
            boolean r4 = r5 instanceof com.cupidapp.live.base.activity.FKBaseActivity
            if (r4 == 0) goto L17
            r4 = r5
            com.cupidapp.live.base.activity.FKBaseActivity r4 = (com.cupidapp.live.base.activity.FKBaseActivity) r4
            com.cupidapp.live.flutter.api.a r0 = new com.cupidapp.live.flutter.api.a
            r0.<init>()
            r4.runOnUiThread(r0)
        L17:
            if (r2 == 0) goto L43
            if (r3 == 0) goto L43
            com.cupidapp.live.base.network.gson.GsonUtil r2 = com.cupidapp.live.base.network.gson.GsonUtil.f12000a     // Catch: java.lang.Exception -> L47
            com.google.gson.Gson r2 = r2.b()     // Catch: java.lang.Exception -> L47
            java.lang.Class<com.cupidapp.live.flutter.api.FlutterNetWork$ErrorResult> r4 = com.cupidapp.live.flutter.api.FlutterNetWork.ErrorResult.class
            java.lang.Object r2 = r2.fromJson(r3, r4)     // Catch: java.lang.Exception -> L47
            com.cupidapp.live.flutter.api.FlutterNetWork$ErrorResult r2 = (com.cupidapp.live.flutter.api.FlutterNetWork.ErrorResult) r2     // Catch: java.lang.Exception -> L47
            java.lang.Integer r4 = r2.getStatus()     // Catch: java.lang.Exception -> L47
            r0 = 200(0xc8, float:2.8E-43)
            if (r4 != 0) goto L32
            goto L38
        L32:
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L47
            if (r4 == r0) goto L47
        L38:
            if (r5 == 0) goto L47
            com.cupidapp.live.flutter.api.c r4 = new com.cupidapp.live.flutter.api.c     // Catch: java.lang.Exception -> L47
            r4.<init>()     // Catch: java.lang.Exception -> L47
            r5.runOnUiThread(r4)     // Catch: java.lang.Exception -> L47
            goto L47
        L43:
            if (r3 != 0) goto L47
            java.lang.String r3 = "未知错误"
        L47:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.flutter.api.FlutterNetWork.e(boolean, java.lang.String, java.lang.Boolean, android.app.Activity):java.lang.String");
    }

    public final void h(@NotNull MethodCall call, @Nullable final Activity activity, @Nullable final Function1<? super String, p> function1) {
        s.i(call, "call");
        String str = (String) call.argument("path");
        Map<String, ? extends Object> map = (Map) call.argument("params");
        String str2 = (String) call.argument("method");
        Boolean bool = (Boolean) call.argument("showLoading");
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        final boolean booleanValue = bool.booleanValue();
        if (booleanValue && (activity instanceof FKBaseActivity)) {
            ((FKBaseActivity) activity).runOnUiThread(new Runnable() { // from class: com.cupidapp.live.flutter.api.b
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterNetWork.i(activity);
                }
            });
        }
        String str3 = NetworkClient.f11868a.k() + str;
        com.cupidapp.live.base.utils.j.f12332a.a("flutter", "url:" + str3 + ",method:" + str2 + ",params:" + ((Object) map));
        if (s.d(str2, "GET")) {
            if (!(map == null || map.isEmpty())) {
                String str4 = str3;
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    str4 = x.a(str3, entry.getKey(), entry.getValue().toString());
                }
                str3 = str4;
            }
            com.cupidapp.live.base.network.d.f11923a.b(str3, new Function2<Boolean, String, p>() { // from class: com.cupidapp.live.flutter.api.FlutterNetWork$request$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool2, String str5) {
                    invoke(bool2.booleanValue(), str5);
                    return p.f51048a;
                }

                public final void invoke(boolean z10, @Nullable String str5) {
                    String e2;
                    Function1<String, p> function12 = function1;
                    if (function12 != null) {
                        e2 = FlutterNetWork.f14654a.e(z10, str5, Boolean.valueOf(booleanValue), activity);
                        function12.invoke(e2);
                    }
                }
            });
            return;
        }
        if (s.d(str2, "POST")) {
            com.cupidapp.live.base.network.d.f11923a.c(str3, map, new Function2<Boolean, String, p>() { // from class: com.cupidapp.live.flutter.api.FlutterNetWork$request$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool2, String str5) {
                    invoke(bool2.booleanValue(), str5);
                    return p.f51048a;
                }

                public final void invoke(boolean z10, @Nullable String str5) {
                    String e2;
                    Function1<String, p> function12 = function1;
                    if (function12 != null) {
                        e2 = FlutterNetWork.f14654a.e(z10, str5, Boolean.valueOf(booleanValue), activity);
                        function12.invoke(e2);
                    }
                }
            });
        }
    }

    /* compiled from: FlutterNetWork.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ErrorResult {

        @Nullable
        private final String buttonName;

        @Nullable
        private final String jumpUrl;

        @Nullable
        private final String message;

        @Nullable
        private final Integer status;

        @Nullable
        private final String style;

        public ErrorResult(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.status = num;
            this.message = str;
            this.style = str2;
            this.jumpUrl = str3;
            this.buttonName = str4;
        }

        public static /* synthetic */ ErrorResult copy$default(ErrorResult errorResult, Integer num, String str, String str2, String str3, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                num = errorResult.status;
            }
            if ((i10 & 2) != 0) {
                str = errorResult.message;
            }
            String str5 = str;
            if ((i10 & 4) != 0) {
                str2 = errorResult.style;
            }
            String str6 = str2;
            if ((i10 & 8) != 0) {
                str3 = errorResult.jumpUrl;
            }
            String str7 = str3;
            if ((i10 & 16) != 0) {
                str4 = errorResult.buttonName;
            }
            return errorResult.copy(num, str5, str6, str7, str4);
        }

        @Nullable
        public final Integer component1() {
            return this.status;
        }

        @Nullable
        public final String component2() {
            return this.message;
        }

        @Nullable
        public final String component3() {
            return this.style;
        }

        @Nullable
        public final String component4() {
            return this.jumpUrl;
        }

        @Nullable
        public final String component5() {
            return this.buttonName;
        }

        @NotNull
        public final ErrorResult copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            return new ErrorResult(num, str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ErrorResult)) {
                return false;
            }
            ErrorResult errorResult = (ErrorResult) obj;
            return s.d(this.status, errorResult.status) && s.d(this.message, errorResult.message) && s.d(this.style, errorResult.style) && s.d(this.jumpUrl, errorResult.jumpUrl) && s.d(this.buttonName, errorResult.buttonName);
        }

        @Nullable
        public final String getButtonName() {
            return this.buttonName;
        }

        @Nullable
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        public final String getStyle() {
            return this.style;
        }

        public int hashCode() {
            Integer num = this.status;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.message;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.style;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.jumpUrl;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.buttonName;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            Integer num = this.status;
            return "ErrorResult(status=" + ((Object) num) + ", message=" + this.message + ", style=" + this.style + ", jumpUrl=" + this.jumpUrl + ", buttonName=" + this.buttonName + ")";
        }

        public /* synthetic */ ErrorResult(Integer num, String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? -1 : num, (i10 & 2) != 0 ? "服务异常!" : str, str2, str3, str4);
        }
    }
}
