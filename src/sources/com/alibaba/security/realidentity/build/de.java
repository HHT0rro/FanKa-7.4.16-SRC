package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.common.http.ok.RPDispatcher;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.realidentity.build.dm;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.common.HttpMethod;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.alibaba.security.realidentity.oss.exception.InconsistentException;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: InternalRequestOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class de {

    /* renamed from: e, reason: collision with root package name */
    private static final int f3431e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static final int f3432f = 10000;

    /* renamed from: g, reason: collision with root package name */
    private static ExecutorService f3433g = Executors.newFixedThreadPool(5, new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.de.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-api-thread");
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public RPHttpClient f3434a;

    /* renamed from: b, reason: collision with root package name */
    public Context f3435b;

    /* renamed from: c, reason: collision with root package name */
    public cj f3436c;

    /* renamed from: d, reason: collision with root package name */
    public bt f3437d;

    /* renamed from: h, reason: collision with root package name */
    private volatile URI f3438h;

    /* renamed from: i, reason: collision with root package name */
    private URI f3439i;

    /* renamed from: j, reason: collision with root package name */
    private int f3440j;

    public de(Context context, final URI uri, cj cjVar, bt btVar) {
        this.f3440j = 2;
        this.f3435b = context;
        this.f3438h = uri;
        this.f3436c = cjVar;
        this.f3437d = btVar;
        RPHttpClient.Builder hostnameVerifier = new RPHttpClient.Builder().followRedirects(false).followSslRedirects(false).retryOnConnectionFailure(false).cache(null).hostnameVerifier(new HostnameVerifier() { // from class: com.alibaba.security.realidentity.build.de.2
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(uri.getHost(), sSLSession);
            }
        });
        if (btVar != null) {
            RPDispatcher rPDispatcher = new RPDispatcher();
            rPDispatcher.setMaxRequests(btVar.f3205a);
            long j10 = btVar.f3207c;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            hostnameVerifier.connectTimeout(j10, timeUnit).readTimeout(btVar.f3206b, timeUnit).writeTimeout(btVar.f3206b, timeUnit).dispatcher(rPDispatcher);
            if (btVar.f3211g != null && btVar.f3212h != 0) {
                hostnameVerifier.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(btVar.f3211g, btVar.f3212h)));
            }
            this.f3440j = btVar.f3209e;
        }
        this.f3434a = hostnameVerifier.build();
    }

    private static <Request extends OSSRequest, Result extends ft> void b(Request request, Result result, bx<Request, Result> bxVar) {
        try {
            a(request, result);
            if (bxVar != null) {
                bxVar.a(request, result);
            }
        } catch (ClientException e2) {
            if (bxVar != null) {
                bxVar.a(request, e2, null);
            }
        }
    }

    private bt c() {
        return this.f3437d;
    }

    private ge a(gd gdVar) throws ClientException, ServiceException {
        ge b4 = a(gdVar, (bx<gd, ge>) null).b();
        a(gdVar, b4);
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long b(List<fv> list) {
        long j10 = 0;
        for (fv fvVar : list) {
            long j11 = fvVar.f3706d;
            if (j11 != 0) {
                long j12 = fvVar.f3705c;
                if (j12 > 0) {
                    j10 = cq.a(j10, j11, j12);
                }
            }
            return 0L;
        }
        return j10;
    }

    public final dg<ge> a(gd gdVar, final bx<gd, ge> bxVar) {
        cd.b(" Internal putObject Start ");
        dj djVar = new dj();
        djVar.f3469f = gdVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = gdVar.f3719a;
        djVar.f3467d = gdVar.f3720b;
        byte[] bArr = gdVar.f3722d;
        if (bArr != null) {
            djVar.f3476m = bArr;
        }
        String str = gdVar.f3721c;
        if (str != null) {
            djVar.f3475l = str;
        }
        if (gdVar.f3724f != null) {
            djVar.a().put("x-oss-callback", OSSUtils.a(gdVar.f3724f));
        }
        if (gdVar.f3725g != null) {
            djVar.a().put("x-oss-callback-var", OSSUtils.a(gdVar.f3725g));
        }
        cd.b(" populateRequestMetadata ");
        OSSUtils.a((Map<String, String>) djVar.a(), gdVar.f3723e);
        cd.b(" canonicalizeRequestMessage ");
        a(djVar, gdVar);
        cd.b(" ExecutionContext ");
        gr grVar = new gr(this.f3434a, gdVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = new bx<gd, ge>() { // from class: com.alibaba.security.realidentity.build.de.4
                @Override // com.alibaba.security.realidentity.build.bx
                public final /* bridge */ /* synthetic */ void a(gd gdVar2, ge geVar) {
                    de.a(gdVar2, geVar, bxVar);
                }

                @Override // com.alibaba.security.realidentity.build.bx
                public final /* bridge */ /* synthetic */ void a(gd gdVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(gdVar2, clientException, serviceException);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(gd gdVar2, ge geVar) {
                    de.a(gdVar2, geVar, bxVar);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(gd gdVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(gdVar2, clientException, serviceException);
                }
            };
        }
        bz bzVar = gdVar.f3727i;
        if (bzVar != null) {
            grVar.f3762g = bzVar;
        }
        grVar.f3761f = gdVar.f3726h;
        gt gtVar = new gt(djVar, new dm.ac(), grVar, this.f3440j);
        cd.b(" call OSSRequestTask ");
        return dg.a(f3433g.submit(gtVar), grVar);
    }

    private Context b() {
        return this.f3435b;
    }

    public de(Context context, cj cjVar, bt btVar) {
        this.f3440j = 2;
        try {
            this.f3439i = new URI("http://oss.aliyuncs.com");
            this.f3438h = new URI("http://127.0.0.1");
            this.f3435b = context;
            this.f3436c = cjVar;
            this.f3437d = btVar;
            RPHttpClient.Builder hostnameVerifier = new RPHttpClient.Builder().followRedirects(false).followSslRedirects(false).retryOnConnectionFailure(false).cache(null).hostnameVerifier(new HostnameVerifier() { // from class: com.alibaba.security.realidentity.build.de.3
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(de.this.f3439i.getHost(), sSLSession);
                }
            });
            if (btVar != null) {
                RPDispatcher rPDispatcher = new RPDispatcher();
                rPDispatcher.setMaxRequests(btVar.f3205a);
                long j10 = btVar.f3207c;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                hostnameVerifier.connectTimeout(j10, timeUnit).readTimeout(btVar.f3206b, timeUnit).writeTimeout(btVar.f3206b, timeUnit).dispatcher(rPDispatcher);
                if (btVar.f3211g != null && btVar.f3212h != 0) {
                    hostnameVerifier.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(btVar.f3211g, btVar.f3212h)));
                }
                this.f3440j = btVar.f3209e;
            }
            this.f3434a = hostnameVerifier.build();
        } catch (Exception unused) {
            throw new IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    public final dg<dz> a(dy dyVar, bx<dy, dz> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = dyVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = dyVar.f3536c;
        if (dyVar.f3537d != null) {
            djVar.a().put(cc.f3274c, dyVar.f3537d.toString());
        }
        try {
            HashMap hashMap = new HashMap();
            String str = dyVar.f3538e;
            if (str != null) {
                hashMap.put(dy.f3534a, str);
            }
            hashMap.put(dy.f3535b, dyVar.f3539f.toString());
            djVar.b(hashMap);
            a(djVar, dyVar);
            gr grVar = new gr(this.f3434a, dyVar, this.f3435b);
            if (bxVar != null) {
                grVar.f3760e = bxVar;
            }
            return dg.a(f3433g.submit(new gt(djVar, new dm.e(), grVar, this.f3440j)), grVar);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final dg<ef> a(ee eeVar, bx<ee, ef> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = eeVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.DELETE;
        djVar.f3466c = eeVar.f3543a;
        a(djVar, eeVar);
        gr grVar = new gr(this.f3434a, eeVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.h(), grVar, this.f3440j)), grVar);
    }

    public final dg<eo> a(en enVar, bx<en, eo> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3311a, "");
        djVar.f3469f = enVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = enVar.f3563a;
        djVar.f3470g = linkedHashMap;
        a(djVar, enVar);
        gr grVar = new gr(this.f3434a, enVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.l(), grVar, this.f3440j)), grVar);
    }

    public final dg<em> a(el elVar, bx<el, em> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3312b, "");
        djVar.f3469f = elVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = elVar.f3560a;
        djVar.f3470g = linkedHashMap;
        a(djVar, elVar);
        gr grVar = new gr(this.f3434a, elVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.k(), grVar, this.f3440j)), grVar);
    }

    public final dg<gc> a(gb gbVar, bx<gb, gc> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3313c, "");
        djVar.f3469f = gbVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = gbVar.f3716a;
        djVar.f3470g = linkedHashMap;
        try {
            djVar.a(gbVar.f3718c, gbVar.f3717b);
            a(djVar, gbVar);
            gr grVar = new gr(this.f3434a, gbVar, this.f3435b);
            if (bxVar != null) {
                grVar.f3760e = bxVar;
            }
            return dg.a(f3433g.submit(new gt(djVar, new dm.ab(), grVar, this.f3440j)), grVar);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final dg<eu> a(et etVar, bx<et, eu> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3313c, "");
        djVar.f3469f = etVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = etVar.f3571a;
        djVar.f3470g = linkedHashMap;
        a(djVar, etVar);
        gr grVar = new gr(this.f3434a, etVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.o(), grVar, this.f3440j)), grVar);
    }

    public final dg<ga> a(fz fzVar, bx<fz, ga> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3315e, "");
        djVar.f3469f = fzVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = fzVar.f3713a;
        djVar.f3470g = linkedHashMap;
        try {
            String str = fzVar.f3714b;
            String str2 = fzVar.f3715c;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<BucketLoggingStatus>");
            if (str != null) {
                stringBuffer.append("<LoggingEnabled><TargetBucket>" + str + "</TargetBucket>");
                if (str2 != null) {
                    stringBuffer.append("<TargetPrefix>" + str2 + "</TargetPrefix>");
                }
                stringBuffer.append("</LoggingEnabled>");
            }
            stringBuffer.append("</BucketLoggingStatus>");
            byte[] bytes = stringBuffer.toString().getBytes("utf-8");
            long length = bytes.length;
            djVar.a(new ByteArrayInputStream(bytes));
            djVar.a(length);
            a(djVar, fzVar);
            gr grVar = new gr(this.f3434a, fzVar, this.f3435b);
            if (bxVar != null) {
                grVar.f3760e = bxVar;
            }
            return dg.a(f3433g.submit(new gt(djVar, new dm.aa(), grVar, this.f3440j)), grVar);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final dg<es> a(er erVar, bx<er, es> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3315e, "");
        djVar.f3469f = erVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = erVar.f3567a;
        djVar.f3470g = linkedHashMap;
        a(djVar, erVar);
        gr grVar = new gr(this.f3434a, erVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.n(), grVar, this.f3440j)), grVar);
    }

    public final dg<ed> a(ec ecVar, bx<ec, ed> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3315e, "");
        djVar.f3469f = ecVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.DELETE;
        djVar.f3466c = ecVar.f3542a;
        djVar.f3470g = linkedHashMap;
        a(djVar, ecVar);
        gr grVar = new gr(this.f3434a, ecVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.g(), grVar, this.f3440j)), grVar);
    }

    public final dg<fy> a(fx fxVar, bx<fx, fy> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3317g, "");
        djVar.f3469f = fxVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = fxVar.f3711a;
        djVar.f3470g = linkedHashMap;
        try {
            djVar.a(fxVar.f3712b);
            a(djVar, fxVar);
            gr grVar = new gr(this.f3434a, fxVar, this.f3435b);
            if (bxVar != null) {
                grVar.f3760e = bxVar;
            }
            return dg.a(f3433g.submit(new gt(djVar, new dm.z(), grVar, this.f3440j)), grVar);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final dg<eq> a(ep epVar, bx<ep, eq> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3317g, "");
        djVar.f3469f = epVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = epVar.f3565a;
        djVar.f3470g = linkedHashMap;
        a(djVar, epVar);
        gr grVar = new gr(this.f3434a, epVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.m(), grVar, this.f3440j)), grVar);
    }

    public final dg<eb> a(ea eaVar, bx<ea, eb> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3317g, "");
        djVar.f3469f = eaVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.DELETE;
        djVar.f3466c = eaVar.f3541a;
        djVar.f3470g = linkedHashMap;
        a(djVar, eaVar);
        gr grVar = new gr(this.f3434a, eaVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.f(), grVar, this.f3440j)), grVar);
    }

    private ds a(dr drVar) throws ClientException, ServiceException {
        ds b4 = a(drVar, (bx<dr, ds>) null).b();
        boolean z10 = drVar.f4050l == OSSRequest.CRC64Config.YES;
        Long l10 = drVar.f3496h;
        if (l10 != null && z10) {
            b4.a(Long.valueOf(cq.a(l10.longValue(), b4.a().longValue(), b4.f3497a - drVar.f3495g)));
        }
        a(drVar, b4);
        return b4;
    }

    public final dg<ds> a(dr drVar, final bx<dr, ds> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = drVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = drVar.f3489a;
        djVar.f3467d = drVar.f3490b;
        byte[] bArr = drVar.f3492d;
        if (bArr != null) {
            djVar.f3476m = bArr;
        }
        String str = drVar.f3491c;
        if (str != null) {
            djVar.f3475l = str;
        }
        djVar.f3470g.put(cg.f3321k, "");
        djVar.f3470g.put("position", String.valueOf(drVar.f3495g));
        OSSUtils.a((Map<String, String>) djVar.a(), drVar.f3493e);
        a(djVar, drVar);
        gr grVar = new gr(this.f3434a, drVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = new bx<dr, ds>() { // from class: com.alibaba.security.realidentity.build.de.5
                @Override // com.alibaba.security.realidentity.build.bx
                public final /* synthetic */ void a(dr drVar2, ds dsVar) {
                    dr drVar3 = drVar2;
                    ds dsVar2 = dsVar;
                    boolean z10 = drVar3.f4050l == OSSRequest.CRC64Config.YES;
                    Long l10 = drVar3.f3496h;
                    if (l10 != null && z10) {
                        dsVar2.a(Long.valueOf(cq.a(l10.longValue(), dsVar2.a().longValue(), dsVar2.f3497a - drVar3.f3495g)));
                    }
                    de.a(drVar3, dsVar2, bxVar);
                }

                @Override // com.alibaba.security.realidentity.build.bx
                public final /* bridge */ /* synthetic */ void a(dr drVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(drVar2, clientException, serviceException);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(dr drVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(drVar2, clientException, serviceException);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(dr drVar2, ds dsVar) {
                    boolean z10 = drVar2.f4050l == OSSRequest.CRC64Config.YES;
                    Long l10 = drVar2.f3496h;
                    if (l10 != null && z10) {
                        dsVar.a(Long.valueOf(cq.a(l10.longValue(), dsVar.a().longValue(), dsVar.f3497a - drVar2.f3495g)));
                    }
                    de.a(drVar2, dsVar, bxVar);
                }
            };
        }
        grVar.f3761f = drVar.f3494f;
        return dg.a(f3433g.submit(new gt(djVar, new dm.b(), grVar, this.f3440j)), grVar);
    }

    public final dg<fc> a(fb fbVar, bx<fb, fc> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = fbVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.HEAD;
        djVar.f3466c = fbVar.f3590a;
        djVar.f3467d = fbVar.f3591b;
        a(djVar, fbVar);
        gr grVar = new gr(this.f3434a, fbVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.s(), grVar, this.f3440j)), grVar);
    }

    public final dg<ey> a(ex exVar, bx<ex, ey> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = exVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = exVar.f3578a;
        djVar.f3467d = exVar.f3579b;
        if (exVar.f3580c != null) {
            djVar.a().put("Range", exVar.f3580c.toString());
        }
        String str = exVar.f3581d;
        if (str != null) {
            djVar.f3470g.put(cg.I, str);
        }
        a(djVar, exVar);
        Map<String, String> map = exVar.f3583f;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                djVar.a().put(entry.getKey(), entry.getValue());
            }
        }
        gr grVar = new gr(this.f3434a, exVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        grVar.f3761f = exVar.f3582e;
        return dg.a(f3433g.submit(new gt(djVar, new dm.q(), grVar, this.f3440j)), grVar);
    }

    public final dg<ew> a(ev evVar, bx<ev, ew> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.f3312b, "");
        djVar.f3469f = evVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3470g = linkedHashMap;
        djVar.f3466c = evVar.f3574a;
        djVar.f3467d = evVar.f3575b;
        a(djVar, evVar);
        gr grVar = new gr(this.f3434a, evVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.p(), grVar, this.f3440j)), grVar);
    }

    public final dg<dx> a(dw dwVar, bx<dw, dx> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = dwVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = dwVar.f3524c;
        djVar.f3467d = dwVar.f3525d;
        OSSUtils.a(dwVar, (Map<String, String>) djVar.a());
        a(djVar, dwVar);
        gr grVar = new gr(this.f3434a, dwVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.d(), grVar, this.f3440j)), grVar);
    }

    public final dg<ej> a(ei eiVar, bx<ei, ej> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = eiVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.DELETE;
        djVar.f3466c = eiVar.f3550a;
        djVar.f3467d = eiVar.f3551b;
        a(djVar, eiVar);
        gr grVar = new gr(this.f3434a, eiVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.j(), grVar, this.f3440j)), grVar);
    }

    public final dg<eh> a(eg egVar, bx<eg, eh> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("delete", "");
        djVar.f3469f = egVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = egVar.f3544a;
        djVar.f3470g = linkedHashMap;
        try {
            byte[] a10 = djVar.a(egVar.f3545b, egVar.f3546c);
            if (a10 != null && a10.length > 0) {
                djVar.a().put(cs.P, cp.a(cp.b(a10)));
                djVar.a().put("Content-Length", String.valueOf(a10.length));
            }
            a(djVar, egVar);
            gr grVar = new gr(this.f3434a, egVar, this.f3435b);
            if (bxVar != null) {
                grVar.f3760e = bxVar;
            }
            return dg.a(f3433g.submit(new gt(djVar, new dm.i(), grVar, this.f3440j)), grVar);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final dg<fi> a(fh fhVar, bx<fh, fi> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = fhVar.f4049k;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3464a = this.f3439i;
        djVar.f3465b = this.f3438h;
        a(djVar, fhVar);
        OSSUtils.a(fhVar, djVar.f3470g);
        gr grVar = new gr(this.f3434a, fhVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.v(), grVar, this.f3440j)), grVar);
    }

    public final dg<fm> a(fl flVar, bx<fl, fm> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = flVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = flVar.f3636a;
        a(djVar, flVar);
        OSSUtils.a(flVar, djVar.f3470g);
        gr grVar = new gr(this.f3434a, flVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.x(), grVar, this.f3440j)), grVar);
    }

    public final dg<fg> a(ff ffVar, bx<ff, fg> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = ffVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = ffVar.f3599b;
        djVar.f3467d = ffVar.f3600c;
        djVar.f3470g.put(cg.f3318h, "");
        if (ffVar.f3598a) {
            djVar.f3470g.put(cg.f3322l, "");
        }
        OSSUtils.a((Map<String, String>) djVar.a(), ffVar.f3601d);
        a(djVar, ffVar);
        gr grVar = new gr(this.f3434a, ffVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.u(), grVar, this.f3440j)), grVar);
    }

    public final gp a(go goVar) throws ClientException, ServiceException {
        gp b4 = a(goVar, (bx<go, gp>) null).b();
        a(goVar, b4);
        return b4;
    }

    public final dg<gp> a(go goVar, final bx<go, gp> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = goVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = goVar.f3746a;
        djVar.f3467d = goVar.f3747b;
        djVar.f3470g.put(cg.f3328r, goVar.f3748c);
        djVar.f3470g.put(cg.f3329s, String.valueOf(goVar.f3749d));
        djVar.f3476m = goVar.f3750e;
        if (goVar.f3752g != null) {
            djVar.a().put(cs.P, goVar.f3752g);
        }
        a(djVar, goVar);
        gr grVar = new gr(this.f3434a, goVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = new bx<go, gp>() { // from class: com.alibaba.security.realidentity.build.de.6
                @Override // com.alibaba.security.realidentity.build.bx
                public final /* bridge */ /* synthetic */ void a(go goVar2, gp gpVar) {
                    de.a(goVar2, gpVar, bxVar);
                }

                @Override // com.alibaba.security.realidentity.build.bx
                public final /* bridge */ /* synthetic */ void a(go goVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(goVar2, clientException, serviceException);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(go goVar2, gp gpVar) {
                    de.a(goVar2, gpVar, bxVar);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(go goVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(goVar2, clientException, serviceException);
                }
            };
        }
        grVar.f3761f = goVar.f3751f;
        return dg.a(f3433g.submit(new gt(djVar, new dm.ag(), grVar, this.f3440j)), grVar);
    }

    public final dv a(du duVar) throws ClientException, ServiceException {
        dv b4 = a(duVar, (bx<du, dv>) null).b();
        if (b4.f3699o != null) {
            b4.a(Long.valueOf(b(duVar.f3513d)));
        }
        a(duVar, b4);
        return b4;
    }

    public final dg<dv> a(du duVar, final bx<du, dv> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = duVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = duVar.f3510a;
        djVar.f3467d = duVar.f3511b;
        djVar.a(OSSUtils.a(duVar.f3513d));
        djVar.f3470g.put(cg.f3328r, duVar.f3512c);
        if (duVar.f3514e != null) {
            djVar.a().put("x-oss-callback", OSSUtils.a(duVar.f3514e));
        }
        if (duVar.f3515f != null) {
            djVar.a().put("x-oss-callback-var", OSSUtils.a(duVar.f3515f));
        }
        OSSUtils.a((Map<String, String>) djVar.a(), duVar.f3516g);
        a(djVar, duVar);
        gr grVar = new gr(this.f3434a, duVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = new bx<du, dv>() { // from class: com.alibaba.security.realidentity.build.de.7
                @Override // com.alibaba.security.realidentity.build.bx
                public final /* synthetic */ void a(du duVar2, dv dvVar) {
                    du duVar3 = duVar2;
                    dv dvVar2 = dvVar;
                    if (dvVar2.f3699o != null) {
                        dvVar2.a(Long.valueOf(de.b(duVar3.f3513d)));
                    }
                    de.a(duVar3, dvVar2, bxVar);
                }

                @Override // com.alibaba.security.realidentity.build.bx
                public final /* bridge */ /* synthetic */ void a(du duVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(duVar2, clientException, serviceException);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(du duVar2, ClientException clientException, ServiceException serviceException) {
                    bxVar.a(duVar2, clientException, serviceException);
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(du duVar2, dv dvVar) {
                    if (dvVar.f3699o != null) {
                        dvVar.a(Long.valueOf(de.b(duVar2.f3513d)));
                    }
                    de.a(duVar2, dvVar, bxVar);
                }
            };
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.c(), grVar, this.f3440j)), grVar);
    }

    public final dg<dq> a(dp dpVar, bx<dp, dq> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = dpVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.DELETE;
        djVar.f3466c = dpVar.f3486a;
        djVar.f3467d = dpVar.f3487b;
        djVar.f3470g.put(cg.f3328r, dpVar.f3488c);
        a(djVar, dpVar);
        gr grVar = new gr(this.f3434a, dpVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.a(), grVar, this.f3440j)), grVar);
    }

    public final dg<fo> a(fn fnVar, bx<fn, fo> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = fnVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = fnVar.f3652a;
        djVar.f3467d = fnVar.f3653b;
        djVar.f3470g.put(cg.f3328r, fnVar.f3654c);
        Integer num = fnVar.f3655d;
        if (num != null) {
            if (OSSUtils.a(num.intValue(), true, 1000L)) {
                djVar.f3470g.put(cg.f3333w, num.toString());
            } else {
                throw new IllegalArgumentException("MaxPartsOutOfRange: 1000");
            }
        }
        Integer num2 = fnVar.f3656e;
        if (num2 != null) {
            if (OSSUtils.a(num2.intValue(), false, 10000L)) {
                djVar.f3470g.put(cg.f3334x, num2.toString());
            } else {
                throw new IllegalArgumentException("PartNumberMarkerOutOfRange: 10000");
            }
        }
        a(djVar, fnVar);
        gr grVar = new gr(this.f3434a, fnVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.y(), grVar, this.f3440j)), grVar);
    }

    public final dg<fk> a(fj fjVar, bx<fj, fk> bxVar) {
        dj djVar = new dj();
        djVar.f3469f = fjVar.f4049k;
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = fjVar.f3617a;
        djVar.f3470g.put(cg.f3318h, "");
        OSSUtils.a(fjVar, djVar.f3470g);
        a(djVar, fjVar);
        gr grVar = new gr(this.f3434a, fjVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.w(), grVar, this.f3440j)), grVar);
    }

    private boolean a(boolean z10) {
        if (!z10 || this.f3435b == null) {
            return false;
        }
        String property = System.getProperty("http.proxyHost");
        String str = this.f3437d.f3211g;
        if (!TextUtils.isEmpty(str)) {
            property = str;
        }
        return TextUtils.isEmpty(property);
    }

    private RPHttpClient a() {
        return this.f3434a;
    }

    private void a(dj djVar, OSSRequest oSSRequest) {
        Map a10 = djVar.a();
        if (a10.get("Date") == null) {
            a10.put("Date", cr.b());
        }
        HttpMethod httpMethod = djVar.f3468e;
        if ((httpMethod == HttpMethod.POST || httpMethod == HttpMethod.PUT) && OSSUtils.a((String) a10.get("Content-Type"))) {
            a10.put("Content-Type", OSSUtils.a(djVar.f3475l, djVar.f3467d));
        }
        djVar.f3473j = a(this.f3437d.f3214j);
        djVar.f3472i = this.f3436c;
        djVar.a().put("User-Agent", cy.a(this.f3437d.f3213i));
        boolean z10 = false;
        if (djVar.a().containsKey("Range") || djVar.f3470g.containsKey(cg.I)) {
            djVar.f3471h = false;
        }
        djVar.f3474k = OSSUtils.a(this.f3438h.getHost(), (List<String>) Collections.unmodifiableList(this.f3437d.f3210f));
        Enum r02 = oSSRequest.f4050l;
        if (r02 != OSSRequest.CRC64Config.NULL) {
            if (r02 == OSSRequest.CRC64Config.YES) {
                z10 = true;
            }
        } else {
            z10 = this.f3437d.f3215k;
        }
        djVar.f3471h = z10;
        oSSRequest.f4050l = z10 ? OSSRequest.CRC64Config.YES : OSSRequest.CRC64Config.NO;
    }

    private void a(cj cjVar) {
        this.f3436c = cjVar;
    }

    public final dg<gn> a(gm gmVar, bx<gm, gn> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.I, "");
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = gmVar.f3741a;
        djVar.f3467d = gmVar.f3742b;
        djVar.f3470g = linkedHashMap;
        String a10 = OSSUtils.a(gmVar.f3743c, gmVar.f3744d);
        djVar.a(a10);
        djVar.a().put(cs.P, cp.a(cp.b(a10.getBytes())));
        a(djVar, gmVar);
        gr grVar = new gr(this.f3434a, gmVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.af(), grVar, this.f3440j)), grVar);
    }

    private gn a(gm gmVar) throws ClientException, ServiceException {
        return a(gmVar, (bx<gm, gn>) null).b();
    }

    public final dg<fe> a(fd fdVar, bx<fd, fe> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.I, "");
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = fdVar.f3593a;
        djVar.f3467d = fdVar.f3594b;
        djVar.f3470g = linkedHashMap;
        djVar.a(OSSUtils.b(fdVar.f3595c, fdVar.f3596d, fdVar.f3597e));
        a(djVar, fdVar);
        gr grVar = new gr(this.f3434a, fdVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.t(), grVar, this.f3440j)), grVar);
    }

    private gg a(gf gfVar) throws ClientException, ServiceException {
        return a(gfVar, (bx<gf, gg>) null).b();
    }

    public final dg<gg> a(gf gfVar, bx<gf, gg> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.J, "");
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.PUT;
        djVar.f3466c = gfVar.f3730a;
        djVar.f3467d = gfVar.f3731b;
        djVar.f3470g = linkedHashMap;
        if (!OSSUtils.a(gfVar.f3732c)) {
            djVar.a().put(cc.f3277f, ct.a(gfVar.f3732c, "utf-8"));
        }
        OSSUtils.a((Map<String, String>) djVar.a(), gfVar.f3733d);
        a(djVar, gfVar);
        gr grVar = new gr(this.f3434a, gfVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.ad(), grVar, this.f3440j)), grVar);
    }

    private fa a(ez ezVar) throws ClientException, ServiceException {
        return a(ezVar, (bx<ez, fa>) null).b();
    }

    public final dg<fa> a(ez ezVar, bx<ez, fa> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.J, "");
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.GET;
        djVar.f3466c = ezVar.f3587a;
        djVar.f3467d = ezVar.f3588b;
        djVar.f3470g = linkedHashMap;
        a(djVar, ezVar);
        gr grVar = new gr(this.f3434a, ezVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.r(), grVar, this.f3440j)), grVar);
    }

    private gj a(gi giVar) throws ClientException, ServiceException {
        return a(giVar, (bx<gi, gj>) null).b();
    }

    public final dg<gj> a(gi giVar, bx<gi, gj> bxVar) {
        dj djVar = new dj();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(cg.K, "");
        djVar.f3465b = this.f3438h;
        djVar.f3468e = HttpMethod.POST;
        djVar.f3466c = giVar.f3737a;
        djVar.f3467d = giVar.f3738b;
        djVar.f3470g = linkedHashMap;
        a(djVar, giVar);
        gr grVar = new gr(this.f3434a, giVar, this.f3435b);
        if (bxVar != null) {
            grVar.f3760e = bxVar;
        }
        return dg.a(f3433g.submit(new gt(djVar, new dm.ae(), grVar, this.f3440j)), grVar);
    }

    public static <Request extends OSSRequest, Result extends ft> void a(Request request, Result result) throws ClientException {
        if (request.f4050l == OSSRequest.CRC64Config.YES) {
            try {
                OSSUtils.a(result.a(), result.f3699o, result.f3698n);
            } catch (InconsistentException e2) {
                throw new ClientException(e2.getMessage(), e2);
            }
        }
    }

    public static /* synthetic */ void a(OSSRequest oSSRequest, ft ftVar, bx bxVar) {
        try {
            a(oSSRequest, ftVar);
            if (bxVar != null) {
                bxVar.a(oSSRequest, ftVar);
            }
        } catch (ClientException e2) {
            if (bxVar != null) {
                bxVar.a(oSSRequest, e2, null);
            }
        }
    }
}
