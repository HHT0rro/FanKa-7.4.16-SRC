package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static final String f29935i = "c";

    /* renamed from: j, reason: collision with root package name */
    private static final ExecutorService f29936j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* renamed from: k, reason: collision with root package name */
    private static long f29937k = 0;

    /* renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f29938a;

    /* renamed from: b, reason: collision with root package name */
    private Context f29939b;

    /* renamed from: c, reason: collision with root package name */
    private g f29940c;

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f29941d;

    /* renamed from: e, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f29942e;

    /* renamed from: f, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f29943f;

    /* renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f29944g;

    /* renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f29945h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f29946a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GrsBaseInfo f29947b;

        public a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f29946a = context;
            this.f29947b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.f29940c = new g();
            c.this.f29942e = new com.huawei.hms.framework.network.grs.e.c(this.f29946a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            c.this.f29943f = new com.huawei.hms.framework.network.grs.e.c(this.f29946a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.f29941d = new com.huawei.hms.framework.network.grs.e.a(cVar.f29942e, c.this.f29943f, c.this.f29940c);
            c cVar2 = c.this;
            cVar2.f29944g = new com.huawei.hms.framework.network.grs.a(cVar2.f29938a, c.this.f29941d, c.this.f29940c, c.this.f29943f);
            if (com.huawei.hms.framework.network.grs.f.b.a(this.f29946a.getPackageName()) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.f29946a, true);
            }
            String c4 = new com.huawei.hms.framework.network.grs.g.j.c(this.f29947b, this.f29946a).c();
            Logger.v(c.f29935i, "scan serviceSet is: " + c4);
            String a10 = c.this.f29943f.a("services", "");
            String a11 = h.a(a10, c4);
            if (!TextUtils.isEmpty(a11)) {
                c.this.f29943f.b("services", a11);
                Logger.i(c.f29935i, "postList is:" + StringUtils.anonymizeMessage(a11));
                Logger.d(c.f29935i, "currentServices:" + StringUtils.anonymizeMessage(a10));
                if (!a11.equals(a10)) {
                    c.this.f29940c.a(c.this.f29938a.getGrsParasKey(true, true, this.f29946a));
                    c.this.f29940c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f29947b, this.f29946a), null, null, c.this.f29943f, c.this.f29938a.getQueryTimeout());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - c.f29937k;
            if (c.f29937k == 0 || TimeUnit.MILLISECONDS.toHours(elapsedRealtime) > 24) {
                Logger.i(c.f29935i, "Try to clear unUsed sp data.");
                long unused = c.f29937k = SystemClock.elapsedRealtime();
                c cVar3 = c.this;
                cVar3.a(cVar3.f29942e.a());
            }
            c.this.f29941d.b(this.f29947b, this.f29946a);
            return Boolean.TRUE;
        }
    }

    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f29945h = null;
        this.f29939b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f29938a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f29939b, grsBaseInfo2));
        this.f29945h = futureTask;
        f29936j.execute(futureTask);
        Logger.i(f29935i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    public c(GrsBaseInfo grsBaseInfo) {
        this.f29945h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f29938a = grsBaseInfo.m2860clone();
        } catch (CloneNotSupportedException e2) {
            Logger.w(f29935i, "GrsClient catch CloneNotSupportedException", e2);
            this.f29938a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f29935i, "sp's content is empty.");
            return;
        }
        Set<String> h10 = map.h();
        for (String str : h10) {
            if (str.endsWith(this.f29939b.getPackageName() + "time")) {
                String a10 = this.f29942e.a(str, "");
                long j10 = 0;
                if (!TextUtils.isEmpty(a10) && a10.matches("\\d+")) {
                    try {
                        j10 = Long.parseLong(a10);
                    } catch (NumberFormatException e2) {
                        Logger.w(f29935i, "convert expire time from String to Long catch NumberFormatException.", e2);
                    }
                }
                String substring = str.substring(0, str.length() - 4);
                String str2 = substring + "ETag";
                if (!b(j10) || !h10.contains(substring) || !h10.contains(str2)) {
                    Logger.i(f29935i, "init interface auto clear some invalid sp's data: " + str);
                    this.f29942e.a(substring);
                    this.f29942e.a(str);
                    this.f29942e.a(str2);
                }
            }
        }
    }

    private boolean b(long j10) {
        return System.currentTimeMillis() - j10 <= bk.f9895d;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f29945h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e2) {
            e = e2;
            str = f29935i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f29935i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e10) {
            e = e10;
            str = f29935i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f29935i, "init compute task timed out");
            return false;
        } catch (Exception e11) {
            e = e11;
            str = f29935i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    public String a(String str, String str2, int i10) {
        if (this.f29938a == null || str == null || str2 == null) {
            Logger.w(f29935i, "invalid para!");
            return null;
        }
        if (e()) {
            return this.f29944g.a(str, str2, this.f29939b, i10);
        }
        return null;
    }

    public Map<String, String> a(String str, int i10) {
        if (this.f29938a != null && str != null) {
            return e() ? this.f29944g.a(str, this.f29939b, i10) : new HashMap();
        }
        Logger.w(f29935i, "invalid para!");
        return new HashMap();
    }

    public void a() {
        if (e()) {
            String grsParasKey = this.f29938a.getGrsParasKey(true, true, this.f29939b);
            this.f29942e.a(grsParasKey);
            this.f29942e.a(grsParasKey + "time");
            this.f29942e.a(grsParasKey + "ETag");
            this.f29940c.a(grsParasKey);
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i10) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f29935i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f29938a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f29944g.a(str, iQueryUrlsCallBack, this.f29939b, i10);
        } else {
            Logger.i(f29935i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i10) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f29935i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f29938a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f29944g.a(str, str2, iQueryUrlCallBack, this.f29939b, i10);
        } else {
            Logger.i(f29935i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.f29938a.compare(((c) obj).f29938a);
        }
        return false;
    }

    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.f29938a) == null || (context = this.f29939b) == null) {
            return false;
        }
        this.f29941d.a(grsBaseInfo, context);
        return true;
    }
}
