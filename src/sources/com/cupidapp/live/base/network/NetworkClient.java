package com.cupidapp.live.base.network;

import android.content.Context;
import android.os.Build;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.BaseUrlModel;
import com.cupidapp.live.base.network.model.BaseUrlResult;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.safe.ImeiHelper;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wangmai.okhttp.model.HttpHeaders;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.p;

/* compiled from: NetworkClient.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NetworkClient {

    @NotNull
    public static final Lazy A;

    @NotNull
    public static final Lazy B;

    @NotNull
    public static final Lazy C;

    @NotNull
    public static final Lazy D;

    @NotNull
    public static final Lazy E;

    @NotNull
    public static final Lazy F;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NetworkClient f11868a = new NetworkClient();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static BaseUrlModel f11869b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static final String f11870c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Lazy f11871d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Lazy f11872e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Lazy f11873f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final Lazy f11874g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Lazy f11875h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final Lazy f11876i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final Lazy f11877j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final Lazy f11878k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final Lazy f11879l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final Lazy f11880m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final Lazy f11881n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final Lazy f11882o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public static final Lazy f11883p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public static final Lazy f11884q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final Lazy f11885r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final Lazy f11886s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final Lazy f11887t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final Lazy f11888u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final Lazy f11889v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final Lazy f11890w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final Lazy f11891x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public static final Lazy f11892y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public static final Lazy f11893z;

    static {
        p1.g gVar = p1.g.f52734a;
        f11869b = gVar.e().c();
        f11870c = gVar.M().c();
        f11871d = kotlin.c.b(new Function0<Gson>() { // from class: com.cupidapp.live.base.network.NetworkClient$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Gson invoke() {
                return GsonUtil.f12000a.a();
            }
        });
        f11872e = kotlin.c.b(NetworkClient$interceptor$2.INSTANCE);
        f11873f = kotlin.c.b(new Function0<d1.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$logInterceptor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d1.a invoke() {
                return new d1.a();
            }
        });
        f11874g = kotlin.c.b(new Function0<b>() { // from class: com.cupidapp.live.base.network.NetworkClient$timeoutInterceptor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return new b();
            }
        });
        f11875h = kotlin.c.b(new Function0<OkHttpClient>() { // from class: com.cupidapp.live.base.network.NetworkClient$okHttpClient$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OkHttpClient invoke() {
                Interceptor K;
                Interceptor q10;
                Interceptor t2;
                OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
                NetworkClient networkClient = NetworkClient.f11868a;
                K = networkClient.K();
                newBuilder.addInterceptor(K);
                q10 = networkClient.q();
                newBuilder.addInterceptor(q10);
                t2 = networkClient.t();
                newBuilder.addInterceptor(t2);
                TimeUnit timeUnit = TimeUnit.SECONDS;
                newBuilder.connectTimeout(20L, timeUnit);
                newBuilder.readTimeout(20L, timeUnit);
                newBuilder.writeTimeout(20L, timeUnit);
                return newBuilder.build();
            }
        });
        f11876i = kotlin.c.b(new Function0<p>() { // from class: com.cupidapp.live.base.network.NetworkClient$retrofit$2
            @Override // kotlin.jvm.functions.Function0
            public final p invoke() {
                NetworkClient networkClient = NetworkClient.f11868a;
                p.b H = networkClient.H();
                H.b(me.a.b(networkClient.m()));
                H.a(le.f.e(Schedulers.io()));
                return H.e();
            }
        });
        f11877j = kotlin.c.b(new Function0<e1.c>() { // from class: com.cupidapp.live.base.network.NetworkClient$userInfoService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e1.c invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (e1.c) G.b(e1.c.class);
            }
        });
        f11878k = kotlin.c.b(new Function0<b3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$matchService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final b3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (b3.a) G.b(b3.a.class);
            }
        });
        f11879l = kotlin.c.b(new Function0<f2.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$feedService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f2.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (f2.a) G.b(f2.a.class);
            }
        });
        f11880m = kotlin.c.b(new Function0<com.cupidapp.live.base.router.g>() { // from class: com.cupidapp.live.base.network.NetworkClient$iapService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.cupidapp.live.base.router.g invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (com.cupidapp.live.base.router.g) G.b(com.cupidapp.live.base.router.g.class);
            }
        });
        f11881n = kotlin.c.b(new Function0<l3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$pushService$2
            @Override // kotlin.jvm.functions.Function0
            public final l3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (l3.a) G.b(l3.a.class);
            }
        });
        f11882o = kotlin.c.b(new Function0<c1.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$locationService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c1.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (c1.a) G.b(c1.a.class);
            }
        });
        f11883p = kotlin.c.b(new Function0<e1.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$commonService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e1.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (e1.a) G.b(e1.a.class);
            }
        });
        f11884q = kotlin.c.b(new Function0<x1.b>() { // from class: com.cupidapp.live.base.network.NetworkClient$contactService$2
            @Override // kotlin.jvm.functions.Function0
            public final x1.b invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (x1.b) G.b(x1.b.class);
            }
        });
        f11885r = kotlin.c.b(new Function0<com.cupidapp.live.base.safe.d>() { // from class: com.cupidapp.live.base.network.NetworkClient$safeService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.cupidapp.live.base.safe.d invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (com.cupidapp.live.base.safe.d) G.b(com.cupidapp.live.base.safe.d.class);
            }
        });
        f11886s = kotlin.c.b(new Function0<e1.b>() { // from class: com.cupidapp.live.base.network.NetworkClient$signInService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e1.b invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (e1.b) G.b(e1.b.class);
            }
        });
        f11887t = kotlin.c.b(new Function0<x2.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$userService$2
            @Override // kotlin.jvm.functions.Function0
            public final x2.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (x2.a) G.b(x2.a.class);
            }
        });
        f11888u = kotlin.c.b(new Function0<u2.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$liveShowService$2
            @Override // kotlin.jvm.functions.Function0
            public final u2.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (u2.a) G.b(u2.a.class);
            }
        });
        f11889v = kotlin.c.b(new Function0<h3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$notifyService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final h3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (h3.a) G.b(h3.a.class);
            }
        });
        f11890w = kotlin.c.b(new Function0<f3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$publishService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (f3.a) G.b(f3.a.class);
            }
        });
        f11891x = kotlin.c.b(new Function0<n3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$newPushSettingService$2
            @Override // kotlin.jvm.functions.Function0
            public final n3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (n3.a) G.b(n3.a.class);
            }
        });
        f11892y = kotlin.c.b(new Function0<y3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$touristService$2
            @Override // kotlin.jvm.functions.Function0
            public final y3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (y3.a) G.b(y3.a.class);
            }
        });
        f11893z = kotlin.c.b(new Function0<x1.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$chatService$2
            @Override // kotlin.jvm.functions.Function0
            public final x1.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (x1.a) G.b(x1.a.class);
            }
        });
        A = kotlin.c.b(new Function0<z2.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$maskPartyService$2
            @Override // kotlin.jvm.functions.Function0
            public final z2.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (z2.a) G.b(z2.a.class);
            }
        });
        B = kotlin.c.b(new Function0<n3.b>() { // from class: com.cupidapp.live.base.network.NetworkClient$mSettingService$2
            @Override // kotlin.jvm.functions.Function0
            public final n3.b invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (n3.b) G.b(n3.b.class);
            }
        });
        C = kotlin.c.b(new Function0<e4.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$mVoicePartyService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e4.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (e4.a) G.b(e4.a.class);
            }
        });
        D = kotlin.c.b(new Function0<a2.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$mClubService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a2.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (a2.a) G.b(a2.a.class);
            }
        });
        E = kotlin.c.b(new Function0<c2.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$mConsultService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c2.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (c2.a) G.b(c2.a.class);
            }
        });
        F = kotlin.c.b(new Function0<x3.a>() { // from class: com.cupidapp.live.base.network.NetworkClient$mSplashService$2
            @Override // kotlin.jvm.functions.Function0
            public final x3.a invoke() {
                p G;
                G = NetworkClient.f11868a.G();
                return (x3.a) G.b(x3.a.class);
            }
        });
    }

    @NotNull
    public final b3.a A() {
        Object value = f11878k.getValue();
        s.h(value, "<get-matchService>(...)");
        return (b3.a) value;
    }

    @NotNull
    public final n3.a B() {
        Object value = f11891x.getValue();
        s.h(value, "<get-newPushSettingService>(...)");
        return (n3.a) value;
    }

    @NotNull
    public final h3.a C() {
        Object value = f11889v.getValue();
        s.h(value, "<get-notifyService>(...)");
        return (h3.a) value;
    }

    @NotNull
    public final OkHttpClient D() {
        return (OkHttpClient) f11875h.getValue();
    }

    @NotNull
    public final f3.a E() {
        Object value = f11890w.getValue();
        s.h(value, "<get-publishService>(...)");
        return (f3.a) value;
    }

    @NotNull
    public final l3.a F() {
        Object value = f11881n.getValue();
        s.h(value, "<get-pushService>(...)");
        return (l3.a) value;
    }

    public final p G() {
        Object value = f11876i.getValue();
        s.h(value, "<get-retrofit>(...)");
        return (p) value;
    }

    @NotNull
    public final p.b H() {
        p.b bVar = new p.b();
        NetworkClient networkClient = f11868a;
        bVar.c(networkClient.k());
        bVar.g(networkClient.D());
        return bVar;
    }

    @NotNull
    public final com.cupidapp.live.base.safe.d I() {
        Object value = f11885r.getValue();
        s.h(value, "<get-safeService>(...)");
        return (com.cupidapp.live.base.safe.d) value;
    }

    @NotNull
    public final e1.b J() {
        Object value = f11886s.getValue();
        s.h(value, "<get-signInService>(...)");
        return (e1.b) value;
    }

    public final Interceptor K() {
        return (Interceptor) f11874g.getValue();
    }

    @NotNull
    public final y3.a L() {
        Object value = f11892y.getValue();
        s.h(value, "<get-touristService>(...)");
        return (y3.a) value;
    }

    @NotNull
    public final e1.c M() {
        Object value = f11877j.getValue();
        s.h(value, "<get-userInfoService>(...)");
        return (e1.c) value;
    }

    @NotNull
    public final x2.a N() {
        Object value = f11887t.getValue();
        s.h(value, "<get-userService>(...)");
        return (x2.a) value;
    }

    @NotNull
    public final String O() {
        ConstantsUrlModel urlModel;
        String urlWebBase;
        String urlPrefixWww;
        ConstantsUrlModel urlModel2;
        String urlWebBase2;
        if (Q()) {
            ConstantsResult q10 = p1.g.f52734a.q();
            return (q10 == null || (urlModel2 = q10.getUrlModel()) == null || (urlWebBase2 = urlModel2.getUrlWebBase()) == null) ? "https://finka-www.wowkaka.cn" : urlWebBase2;
        }
        BaseUrlModel baseUrlModel = f11869b;
        if (baseUrlModel != null && (urlPrefixWww = baseUrlModel.getUrlPrefixWww()) != null) {
            return urlPrefixWww;
        }
        ConstantsResult q11 = p1.g.f52734a.q();
        return (q11 == null || (urlModel = q11.getUrlModel()) == null || (urlWebBase = urlModel.getUrlWebBase()) == null) ? "https://www.finka.cn" : urlWebBase;
    }

    @Nullable
    public final IWXAPI P(@Nullable Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wxbb62cffc9aa42285");
        createWXAPI.registerApp("wxbb62cffc9aa42285");
        if (createWXAPI.isWXAppInstalled()) {
            return createWXAPI;
        }
        com.cupidapp.live.base.view.h.f12779a.r(context, R$string.install_wechat_please);
        return null;
    }

    public final boolean Q() {
        Boolean I1 = p1.g.f52734a.I1();
        if (I1 == null) {
            return false;
        }
        I1.booleanValue();
        return false;
    }

    public final void R() {
        rd.a.b(false, false, null, null, 0, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.network.NetworkClient$requestRootUrl$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z10;
                BaseUrlResult baseUrlResult;
                BaseUrlModel data;
                try {
                    ResponseBody body = NetworkClient.f11868a.D().newCall(new Request.Builder().url("https://backup.xingqiuren.cn/8d777f385d3.json").build()).execute().body();
                    String string = body != null ? body.string() : null;
                    if (string != null && !kotlin.text.p.t(string)) {
                        z10 = false;
                        if (!z10 || (baseUrlResult = (BaseUrlResult) GsonUtil.f12000a.b().fromJson(string, BaseUrlResult.class)) == null || (data = baseUrlResult.getData()) == null) {
                            return;
                        }
                        p1.g.f52734a.e().d(data);
                        return;
                    }
                    z10 = true;
                    if (z10) {
                    }
                } catch (IOException unused) {
                }
            }
        }, 31, null);
    }

    public final void e(boolean z10) {
        f();
        p1.g.f52734a.T1(Boolean.valueOf(z10));
    }

    public final void f() {
        p1.g gVar = p1.g.f52734a;
        gVar.K3(null);
        gVar.A2(null);
    }

    @Nullable
    public final BaseUrlModel g() {
        return f11869b;
    }

    @NotNull
    public final x1.a h() {
        Object value = f11893z.getValue();
        s.h(value, "<get-chatService>(...)");
        return (x1.a) value;
    }

    @NotNull
    public final e1.a i() {
        Object value = f11883p.getValue();
        s.h(value, "<get-commonService>(...)");
        return (e1.a) value;
    }

    @NotNull
    public final x1.b j() {
        Object value = f11884q.getValue();
        s.h(value, "<get-contactService>(...)");
        return (x1.b) value;
    }

    @NotNull
    public final String k() {
        String urlPrefixApi;
        if (Q()) {
            String str = f11870c;
            return str == null || str.length() == 0 ? "https://finka-api-b.wowkaka.cn" : str;
        }
        BaseUrlModel baseUrlModel = f11869b;
        return (baseUrlModel == null || (urlPrefixApi = baseUrlModel.getUrlPrefixApi()) == null) ? "https://api.finka.cn" : urlPrefixApi;
    }

    @NotNull
    public final f2.a l() {
        Object value = f11879l.getValue();
        s.h(value, "<get-feedService>(...)");
        return (f2.a) value;
    }

    @NotNull
    public final Gson m() {
        return (Gson) f11871d.getValue();
    }

    @NotNull
    public final String n() {
        if (!Q()) {
            return "https://finka-h5.finka.cn";
        }
        String k10 = k();
        return s.d(k10, "https://finka-api-qa.wowkaka.cn") ? "https://finka-h5-qa.wowkaka.cn" : s.d(k10, "https://api.finka.cn") ? "https://finka-h5.finka.cn" : "https://finka-h5.wowkaka.cn";
    }

    @NotNull
    public final Map<String, String> o() {
        Pair[] pairArr = new Pair[21];
        p1.g gVar = p1.g.f52734a;
        pairArr[0] = kotlin.f.a("X-App-Auth", String.valueOf(gVar.G1()));
        a aVar = a.f11902a;
        pairArr[1] = kotlin.f.a("Android-Store", aVar.r());
        String s2 = aVar.s();
        if (s2 == null) {
            s2 = "";
        }
        pairArr[2] = kotlin.f.a("X-App-Device", s2);
        String g3 = gVar.g();
        if (g3 == null) {
            g3 = "";
        }
        pairArr[3] = kotlin.f.a("X-App-GUID", g3);
        String t2 = aVar.t();
        if (t2 == null) {
            t2 = "";
        }
        pairArr[4] = kotlin.f.a("X-App-User", t2);
        pairArr[5] = kotlin.f.a(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, aVar.i());
        pairArr[6] = kotlin.f.a("X-App-Version", "7.4.16");
        pairArr[7] = kotlin.f.a("X-Android-Fingerprint", Build.FINGERPRINT);
        pairArr[8] = kotlin.f.a("X-Screen-Width", String.valueOf(z0.h.l(this)));
        pairArr[9] = kotlin.f.a("X-Screen-Height", String.valueOf(z0.h.k(this)));
        pairArr[10] = kotlin.f.a("X-App-Assid", "");
        pairArr[11] = kotlin.f.a("X-App-Imei", ImeiHelper.f12176a.e());
        pairArr[12] = kotlin.f.a("X-App-Wifi", aVar.q());
        pairArr[13] = kotlin.f.a("X-App-DeviceName", aVar.d());
        pairArr[14] = kotlin.f.a("X-App-Oaid", aVar.o());
        pairArr[15] = kotlin.f.a("X-App-Package", "Finka0a");
        pairArr[16] = kotlin.f.a("X-App-DigitalAlliance-Id", aVar.h());
        pairArr[17] = kotlin.f.a("X-App-BlueDeviceInfo", com.cupidapp.live.base.safe.c.f12183a.d());
        pairArr[18] = kotlin.f.a("X-App-Android-Id", aVar.a());
        pairArr[19] = kotlin.f.a("X-Version-build", "0");
        pairArr[20] = kotlin.f.a("X-App-MacAddress", aVar.j());
        Map<String, String> h10 = i0.h(pairArr);
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (!companion.a().f()) {
            CoordinateModel j10 = companion.a().j();
            h10.put("X-App-Location", j10.getLatitude() + "," + j10.getLongitude());
        }
        return h10;
    }

    @NotNull
    public final com.cupidapp.live.base.router.g p() {
        Object value = f11880m.getValue();
        s.h(value, "<get-iapService>(...)");
        return (com.cupidapp.live.base.router.g) value;
    }

    public final Interceptor q() {
        return (Interceptor) f11872e.getValue();
    }

    @NotNull
    public final u2.a r() {
        Object value = f11888u.getValue();
        s.h(value, "<get-liveShowService>(...)");
        return (u2.a) value;
    }

    @NotNull
    public final c1.a s() {
        Object value = f11882o.getValue();
        s.h(value, "<get-locationService>(...)");
        return (c1.a) value;
    }

    public final Interceptor t() {
        return (Interceptor) f11873f.getValue();
    }

    @NotNull
    public final a2.a u() {
        Object value = D.getValue();
        s.h(value, "<get-mClubService>(...)");
        return (a2.a) value;
    }

    @NotNull
    public final c2.a v() {
        Object value = E.getValue();
        s.h(value, "<get-mConsultService>(...)");
        return (c2.a) value;
    }

    @NotNull
    public final n3.b w() {
        Object value = B.getValue();
        s.h(value, "<get-mSettingService>(...)");
        return (n3.b) value;
    }

    @NotNull
    public final x3.a x() {
        Object value = F.getValue();
        s.h(value, "<get-mSplashService>(...)");
        return (x3.a) value;
    }

    @NotNull
    public final e4.a y() {
        Object value = C.getValue();
        s.h(value, "<get-mVoicePartyService>(...)");
        return (e4.a) value;
    }

    @NotNull
    public final z2.a z() {
        Object value = A.getValue();
        s.h(value, "<get-maskPartyService>(...)");
        return (z2.a) value;
    }
}
