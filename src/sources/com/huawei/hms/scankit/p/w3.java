package com.huawei.hms.scankit.p;

import android.os.Bundle;
import android.util.SparseArray;
import com.alibaba.security.realidentity.build.cb;
import com.google.android.material.datepicker.UtcDates;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.utils.FileUtil;
import com.huawei.quickcard.base.Attributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HaLog60001.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w3 extends u3 {

    /* renamed from: h, reason: collision with root package name */
    private volatile String f31649h;

    /* renamed from: i, reason: collision with root package name */
    private volatile String f31650i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f31651j;

    /* renamed from: k, reason: collision with root package name */
    private volatile long f31652k;

    /* renamed from: l, reason: collision with root package name */
    public d f31653l;

    /* compiled from: HaLog60001.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends SimpleDateFormat {
        public a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        }
    }

    /* compiled from: HaLog60001.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends SimpleDateFormat {
        public b(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        }
    }

    /* compiled from: HaLog60001.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f31656a;

        /* renamed from: b, reason: collision with root package name */
        private String f31657b;

        /* renamed from: c, reason: collision with root package name */
        private String f31658c;

        /* renamed from: d, reason: collision with root package name */
        private long f31659d;

        /* renamed from: e, reason: collision with root package name */
        private long f31660e;

        /* renamed from: f, reason: collision with root package name */
        private String f31661f;

        /* renamed from: g, reason: collision with root package name */
        private String f31662g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f31663h;

        /* renamed from: i, reason: collision with root package name */
        private int f31664i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f31665j;

        public /* synthetic */ c(long j10, String str, String str2, boolean z10, int i10, int i11, a aVar) {
            this(j10, str, str2, z10, i10, i11);
        }

        private c(long j10, String str, String str2, boolean z10, int i10, int i11) {
            this.f31659d = j10;
            this.f31657b = str;
            this.f31658c = str2;
            this.f31663h = z10;
            this.f31664i = i10;
            this.f31656a = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c b(String str) {
            this.f31662g = str;
            return this;
        }

        public c a(int i10) {
            this.f31656a = i10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(long j10) {
            this.f31660e = j10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(boolean z10) {
            this.f31665j = z10;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c a(String str) {
            this.f31661f = str;
            return this;
        }
    }

    /* compiled from: HaLog60001.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private String f31666a = d.class.getSimpleName();

        /* renamed from: b, reason: collision with root package name */
        public Timer f31667b = new Timer();

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f31668c = true;

        /* renamed from: d, reason: collision with root package name */
        private List<c> f31669d = new ArrayList(10);

        /* renamed from: e, reason: collision with root package name */
        private List<c> f31670e = new ArrayList(10);

        /* compiled from: HaLog60001.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    d.this.f31668c = true;
                    d.this.a();
                } catch (Exception unused) {
                    o4.b(d.this.f31666a, "onLog Exception");
                }
            }
        }

        /* compiled from: HaLog60001.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class b {

            /* renamed from: a, reason: collision with root package name */
            private StringBuilder f31673a;

            /* renamed from: b, reason: collision with root package name */
            private AtomicInteger[] f31674b;

            /* renamed from: c, reason: collision with root package name */
            private String[] f31675c;

            /* renamed from: d, reason: collision with root package name */
            private long[] f31676d;

            private b() {
                this.f31673a = new StringBuilder(100);
                this.f31674b = new AtomicInteger[]{new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger()};
                this.f31675c = new String[]{"lt10K:", "lt100K:", "lt1M:", "lt3M:", "lt10M:", "lt40M:", "gt40M:"};
                this.f31676d = new long[]{FileUtil.LOCAL_REPORT_FILE_MAX_SIZE, cb.f3266l, 1048576, 3145728, 10485760, 41943040, Long.MAX_VALUE};
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb2 = this.f31673a;
                sb2.delete(0, sb2.length());
                this.f31673a.append("{");
                for (int i10 = 0; i10 < this.f31674b.length; i10++) {
                    this.f31673a.append(this.f31675c[i10]);
                    this.f31673a.append((Object) this.f31674b[i10]);
                    this.f31673a.append(",");
                }
                this.f31673a.replace(r0.length() - 1, this.f31673a.length(), com.alipay.sdk.util.i.f4738d);
                return this.f31673a.toString();
            }

            public /* synthetic */ b(d dVar, a aVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i10) {
                int i11 = 0;
                while (true) {
                    AtomicInteger[] atomicIntegerArr = this.f31674b;
                    if (i11 >= atomicIntegerArr.length) {
                        return;
                    }
                    if (i10 <= this.f31676d[i11]) {
                        atomicIntegerArr[i11].addAndGet(1);
                        return;
                    }
                    i11++;
                }
            }
        }

        /* compiled from: HaLog60001.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class c {

            /* renamed from: a, reason: collision with root package name */
            private StringBuilder f31678a;

            /* renamed from: b, reason: collision with root package name */
            private SparseArray<AtomicInteger> f31679b;

            /* compiled from: HaLog60001.java */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
            public class a extends SparseArray<AtomicInteger> {
                public a() {
                    put(0, new AtomicInteger());
                }
            }

            /* compiled from: HaLog60001.java */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
            public class b extends AtomicInteger {
                public b() {
                    addAndGet(1);
                }
            }

            private c() {
                this.f31678a = new StringBuilder(60);
                this.f31679b = new a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i10) {
                if (this.f31679b.get(i10) == null) {
                    this.f31679b.put(i10, new b());
                } else {
                    this.f31679b.get(i10).addAndGet(1);
                }
            }

            public /* synthetic */ c(d dVar, a aVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb2 = this.f31678a;
                sb2.delete(0, sb2.length());
                this.f31678a.append("{");
                for (int i10 = 0; i10 < this.f31679b.size(); i10++) {
                    this.f31678a.append(this.f31679b.keyAt(i10));
                    this.f31678a.append(com.huawei.openalliance.ad.constant.u.bD);
                    this.f31678a.append((Object) this.f31679b.valueAt(i10));
                    this.f31678a.append(",");
                }
                this.f31678a.replace(r0.length() - 1, this.f31678a.length(), com.alipay.sdk.util.i.f4738d);
                return this.f31678a.toString();
            }
        }

        public d() {
        }

        public void b() {
            Timer timer = this.f31667b;
            if (timer != null) {
                timer.cancel();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            if (this.f31669d.size() > 100) {
                return;
            }
            synchronized (this) {
                this.f31669d.add(cVar);
                if (this.f31668c) {
                    this.f31668c = false;
                    this.f31667b.schedule(new a(), 1000L);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.f31669d.size() > 0) {
                synchronized (this) {
                    List<c> list = this.f31669d;
                    List<c> list2 = this.f31670e;
                    this.f31669d = list2;
                    this.f31670e = list;
                    list2.clear();
                }
                a(this.f31670e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r24v2, types: [java.lang.Boolean] */
        private void a(List<c> list) {
            HashSet<String> hashSet = new HashSet();
            Iterator<c> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                hashSet.add(iterator2.next().f31658c);
            }
            for (String str : hashSet) {
                a aVar = null;
                c cVar = new c(this, aVar);
                b bVar = new b(this, aVar);
                long j10 = Long.MAX_VALUE;
                long j11 = Long.MIN_VALUE;
                String str2 = "";
                String str3 = "";
                String str4 = str3;
                long j12 = 0;
                long j13 = 0;
                long j14 = 0;
                long j15 = 0;
                for (c cVar2 : list) {
                    str2 = cVar2.f31657b;
                    str3 = cVar2.f31661f;
                    str4 = cVar2.f31662g;
                    ?? valueOf = Boolean.valueOf(cVar2.f31663h);
                    j13 += cVar2.f31660e - cVar2.f31659d;
                    cVar.a(cVar2.f31656a);
                    bVar.a(cVar2.f31664i);
                    j12++;
                    if (cVar2.f31665j) {
                        j15++;
                    }
                    if (cVar2.f31656a != 0) {
                        j14++;
                    }
                    if (cVar2.f31660e - cVar2.f31659d < j10) {
                        j10 = cVar2.f31660e - cVar2.f31659d;
                    }
                    if (cVar2.f31660e - cVar2.f31659d > j11) {
                        j11 = cVar2.f31660e - cVar2.f31659d;
                    }
                    aVar = valueOf;
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                w3.this.g();
                linkedHashMap.putAll(w3.this.f31577b);
                linkedHashMap.put("result", cVar.a());
                linkedHashMap.put("imgSizeHistogram", bVar.a());
                linkedHashMap.put("callTime", str2);
                linkedHashMap.put("transId", str);
                if (j12 != 0) {
                    j13 /= j12;
                }
                linkedHashMap.put("costTime", String.valueOf(j13));
                linkedHashMap.put("allCnt", String.valueOf(j12));
                linkedHashMap.put("failCnt", String.valueOf(j14));
                linkedHashMap.put("codeCnt", String.valueOf(j15));
                linkedHashMap.put("scanType", str3);
                linkedHashMap.put("sceneType", str4);
                linkedHashMap.put(Attributes.Style.MIN, String.valueOf(j10));
                linkedHashMap.put("max", String.valueOf(j11));
                linkedHashMap.put("algPhotoMode", String.valueOf(aVar));
                a4.b().b("60001", linkedHashMap);
            }
        }
    }

    public w3(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext().getApplicationContext());
        this.f31651j = false;
        this.f31653l = new d();
        this.f31577b.put("apiName", str);
        if (DetailRect.PHOTO_MODE.equals(str)) {
            this.f31651j = true;
        }
    }

    public void a(String str) {
        this.f31577b.put("algapi", str);
    }

    public c a(boolean z10, int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f31651j) {
                return new c(currentTimeMillis, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis)), UUID.randomUUID().toString(), z10, i10, 0, null);
            }
            if (currentTimeMillis - this.f31652k > 1500) {
                String format = new b("yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis));
                String uuid = UUID.randomUUID().toString();
                if (currentTimeMillis - this.f31652k > 1500) {
                    this.f31649h = format;
                    this.f31650i = uuid;
                    this.f31652k = currentTimeMillis;
                }
            }
            return new c(currentTimeMillis, this.f31649h, this.f31650i, z10, i10, 0, null);
        } catch (Exception unused) {
            o4.b("HaLog6001", "exception happens");
            return new c(currentTimeMillis, this.f31649h, this.f31650i, z10, i10, 0, null);
        }
    }

    public void a(HmsScan[] hmsScanArr, c cVar) {
        try {
            String str = u3.f31572d;
            String str2 = u3.f31573e;
            if (a()) {
                boolean z10 = false;
                int i10 = 0;
                z10 = false;
                if (hmsScanArr != null && hmsScanArr.length > 0) {
                    int length = hmsScanArr.length;
                    while (i10 < length) {
                        HmsScan hmsScan = hmsScanArr[i10];
                        String a10 = u3.a(hmsScan.scanType);
                        i10++;
                        str2 = u3.b(hmsScan.scanTypeForm);
                        str = a10;
                    }
                    z10 = true;
                }
                this.f31653l.a(cVar.a(System.currentTimeMillis()).a(z10).a(str).b(str2));
                this.f31652k = cVar.f31660e;
            }
        } catch (NullPointerException unused) {
            o4.b("HaLog60001", "nullPoint");
        } catch (Exception unused2) {
            o4.b("HaLog60001", "logEnd Exception");
        }
    }
}
