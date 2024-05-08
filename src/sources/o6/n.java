package o6;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.bef.effectsdk.RequirementDefine;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.huawei.appgallery.agd.common.grs.GrsConfigObtainer;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.HashMap;
import java.util.Map;
import o6.e;

/* compiled from: DefaultBandwidthMeter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n implements e, v {

    /* renamed from: p, reason: collision with root package name */
    public static final ImmutableListMultimap<String, Integer> f52320p = k();

    /* renamed from: q, reason: collision with root package name */
    public static final ImmutableList<Long> f52321q = ImmutableList.of(6200000L, 3900000L, 2300000L, 1300000L, 620000L);

    /* renamed from: r, reason: collision with root package name */
    public static final ImmutableList<Long> f52322r = ImmutableList.of(248000L, 160000L, 142000L, 127000L, 113000L);

    /* renamed from: s, reason: collision with root package name */
    public static final ImmutableList<Long> f52323s = ImmutableList.of(2200000L, 1300000L, 950000L, 760000L, 520000L);

    /* renamed from: t, reason: collision with root package name */
    public static final ImmutableList<Long> f52324t = ImmutableList.of(4400000L, 2300000L, 1500000L, 1100000L, 640000L);

    /* renamed from: u, reason: collision with root package name */
    public static final ImmutableList<Long> f52325u = ImmutableList.of(10000000L, 7200000L, 5000000L, 2700000L, 1600000L);

    /* renamed from: v, reason: collision with root package name */
    public static final ImmutableList<Long> f52326v = ImmutableList.of(2600000L, 2200000L, 2000000L, 1500000L, 470000L);

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public static n f52327w;

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableMap<Integer, Long> f52328a;

    /* renamed from: b, reason: collision with root package name */
    public final e.a.C0800a f52329b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f52330c;

    /* renamed from: d, reason: collision with root package name */
    public final Clock f52331d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f52332e;

    /* renamed from: f, reason: collision with root package name */
    public int f52333f;

    /* renamed from: g, reason: collision with root package name */
    public long f52334g;

    /* renamed from: h, reason: collision with root package name */
    public long f52335h;

    /* renamed from: i, reason: collision with root package name */
    public int f52336i;

    /* renamed from: j, reason: collision with root package name */
    public long f52337j;

    /* renamed from: k, reason: collision with root package name */
    public long f52338k;

    /* renamed from: l, reason: collision with root package name */
    public long f52339l;

    /* renamed from: m, reason: collision with root package name */
    public long f52340m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f52341n;

    /* renamed from: o, reason: collision with root package name */
    public int f52342o;

    /* compiled from: DefaultBandwidthMeter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Context f52343a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, Long> f52344b;

        /* renamed from: c, reason: collision with root package name */
        public int f52345c;

        /* renamed from: d, reason: collision with root package name */
        public Clock f52346d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f52347e;

        public b(Context context) {
            this.f52343a = context == null ? null : context.getApplicationContext();
            this.f52344b = c(j0.M(context));
            this.f52345c = 2000;
            this.f52346d = Clock.f22902a;
            this.f52347e = true;
        }

        public static ImmutableList<Integer> b(String str) {
            ImmutableList<Integer> immutableList = n.f52320p.get((ImmutableListMultimap<String, Integer>) str);
            return immutableList.isEmpty() ? ImmutableList.of(2, 2, 2, 2, 2, 2) : immutableList;
        }

        public static Map<Integer, Long> c(String str) {
            ImmutableList<Integer> b4 = b(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            ImmutableList<Long> immutableList = n.f52321q;
            hashMap.put(2, immutableList.get(b4.get(0).intValue()));
            hashMap.put(3, n.f52322r.get(b4.get(1).intValue()));
            hashMap.put(4, n.f52323s.get(b4.get(2).intValue()));
            hashMap.put(5, n.f52324t.get(b4.get(3).intValue()));
            hashMap.put(10, n.f52325u.get(b4.get(4).intValue()));
            hashMap.put(9, n.f52326v.get(b4.get(5).intValue()));
            hashMap.put(7, immutableList.get(b4.get(0).intValue()));
            return hashMap;
        }

        public n a() {
            return new n(this.f52343a, this.f52344b, this.f52345c, this.f52346d, this.f52347e);
        }
    }

    public static ImmutableListMultimap<String, Integer> k() {
        return ImmutableListMultimap.builder().m("AD", 1, 2, 0, 0, 2, 2).m("AE", 1, 4, 4, 4, 2, 2).m("AF", 4, 4, 3, 4, 2, 2).m("AG", 4, 2, 1, 4, 2, 2).m("AI", 1, 2, 2, 2, 2, 2).m("AL", 1, 1, 1, 1, 2, 2).m("AM", 2, 2, 1, 3, 2, 2).m("AO", 3, 4, 3, 1, 2, 2).m(RequirementDefine.REQUIREMENT_AR_TAG, 2, 4, 2, 1, 2, 2).m("AS", 2, 2, 3, 3, 2, 2).m("AT", 0, 1, 0, 0, 0, 2).m("AU", 0, 2, 0, 1, 1, 2).m("AW", 1, 2, 0, 4, 2, 2).m("AX", 0, 2, 2, 2, 2, 2).m("AZ", 3, 3, 3, 4, 4, 2).m("BA", 1, 1, 0, 1, 2, 2).m("BB", 0, 2, 0, 0, 2, 2).m(GlobalSetting.BD_SDK_WRAPPER, 2, 0, 3, 3, 2, 2).m("BE", 0, 0, 2, 3, 2, 2).m("BF", 4, 4, 4, 2, 2, 2).m("BG", 0, 1, 0, 0, 2, 2).m("BH", 1, 0, 2, 4, 2, 2).m(GrsConfigObtainer.URL_TYPE_BI, 4, 4, 4, 4, 2, 2).m("BJ", 4, 4, 4, 4, 2, 2).m("BL", 1, 2, 2, 2, 2, 2).m("BM", 0, 2, 0, 0, 2, 2).m("BN", 3, 2, 1, 0, 2, 2).m("BO", 1, 2, 4, 2, 2, 2).m("BQ", 1, 2, 1, 2, 2, 2).m("BR", 2, 4, 3, 2, 2, 2).m("BS", 2, 2, 1, 3, 2, 2).m("BT", 3, 0, 3, 2, 2, 2).m("BW", 3, 4, 1, 1, 2, 2).m("BY", 1, 1, 1, 2, 2, 2).m("BZ", 2, 2, 2, 2, 2, 2).m("CA", 0, 3, 1, 2, 4, 2).m("CD", 4, 2, 2, 1, 2, 2).m("CF", 4, 2, 3, 2, 2, 2).m("CG", 3, 4, 2, 2, 2, 2).m("CH", 0, 0, 0, 0, 1, 2).m("CI", 3, 3, 3, 3, 2, 2).m("CK", 2, 2, 3, 0, 2, 2).m("CL", 1, 1, 2, 2, 2, 2).m("CM", 3, 4, 3, 2, 2, 2).m("CN", 2, 2, 2, 1, 3, 2).m("CO", 2, 3, 4, 2, 2, 2).m("CR", 2, 3, 4, 4, 2, 2).m("CU", 4, 4, 2, 2, 2, 2).m("CV", 2, 3, 1, 0, 2, 2).m("CW", 1, 2, 0, 0, 2, 2).m("CY", 1, 1, 0, 0, 2, 2).m("CZ", 0, 1, 0, 0, 1, 2).m("DE", 0, 0, 1, 1, 0, 2).m("DJ", 4, 0, 4, 4, 2, 2).m("DK", 0, 0, 1, 0, 0, 2).m("DM", 1, 2, 2, 2, 2, 2).m("DO", 3, 4, 4, 4, 2, 2).m("DZ", 3, 3, 4, 4, 2, 4).m("EC", 2, 4, 3, 1, 2, 2).m("EE", 0, 1, 0, 0, 2, 2).m("EG", 3, 4, 3, 3, 2, 2).m("EH", 2, 2, 2, 2, 2, 2).m("ER", 4, 2, 2, 2, 2, 2).m("ES", 0, 1, 1, 1, 2, 2).m("ET", 4, 4, 4, 1, 2, 2).m("FI", 0, 0, 0, 0, 0, 2).m("FJ", 3, 0, 2, 3, 2, 2).m("FK", 4, 2, 2, 2, 2, 2).m("FM", 3, 2, 4, 4, 2, 2).m("FO", 1, 2, 0, 1, 2, 2).m("FR", 1, 1, 2, 0, 1, 2).m("GA", 3, 4, 1, 1, 2, 2).m("GB", 0, 0, 1, 1, 1, 2).m("GD", 1, 2, 2, 2, 2, 2).m("GE", 1, 1, 1, 2, 2, 2).m("GF", 2, 2, 2, 3, 2, 2).m("GG", 1, 2, 0, 0, 2, 2).m("GH", 3, 1, 3, 2, 2, 2).m("GI", 0, 2, 0, 0, 2, 2).m("GL", 1, 2, 0, 0, 2, 2).m("GM", 4, 3, 2, 4, 2, 2).m("GN", 4, 3, 4, 2, 2, 2).m("GP", 2, 1, 2, 3, 2, 2).m("GQ", 4, 2, 2, 4, 2, 2).m("GR", 1, 2, 0, 0, 2, 2).m("GT", 3, 2, 3, 1, 2, 2).m("GU", 1, 2, 3, 4, 2, 2).m("GW", 4, 4, 4, 4, 2, 2).m("GY", 3, 3, 3, 4, 2, 2).m("HK", 0, 1, 2, 3, 2, 0).m("HN", 3, 1, 3, 3, 2, 2).m("HR", 1, 1, 0, 0, 3, 2).m("HT", 4, 4, 4, 4, 2, 2).m("HU", 0, 0, 0, 0, 0, 2).m("ID", 3, 2, 3, 3, 2, 2).m("IE", 0, 0, 1, 1, 3, 2).m("IL", 1, 0, 2, 3, 4, 2).m("IM", 0, 2, 0, 1, 2, 2).m("IN", 2, 1, 3, 3, 2, 2).m("IO", 4, 2, 2, 4, 2, 2).m("IQ", 3, 3, 4, 4, 2, 2).m("IR", 3, 2, 3, 2, 2, 2).m("IS", 0, 2, 0, 0, 2, 2).m("IT", 0, 4, 0, 1, 2, 2).m("JE", 2, 2, 1, 2, 2, 2).m("JM", 3, 3, 4, 4, 2, 2).m("JO", 2, 2, 1, 1, 2, 2).m("JP", 0, 0, 0, 0, 2, 1).m("KE", 3, 4, 2, 2, 2, 2).m("KG", 2, 0, 1, 1, 2, 2).m("KH", 1, 0, 4, 3, 2, 2).m("KI", 4, 2, 4, 3, 2, 2).m("KM", 4, 3, 2, 3, 2, 2).m("KN", 1, 2, 2, 2, 2, 2).m("KP", 4, 2, 2, 2, 2, 2).m("KR", 0, 0, 1, 3, 1, 2).m("KW", 1, 3, 1, 1, 1, 2).m("KY", 1, 2, 0, 2, 2, 2).m("KZ", 2, 2, 2, 3, 2, 2).m("LA", 1, 2, 1, 1, 2, 2).m("LB", 3, 2, 0, 0, 2, 2).m("LC", 1, 2, 0, 0, 2, 2).m("LI", 0, 2, 2, 2, 2, 2).m("LK", 2, 0, 2, 3, 2, 2).m("LR", 3, 4, 4, 3, 2, 2).m("LS", 3, 3, 2, 3, 2, 2).m("LT", 0, 0, 0, 0, 2, 2).m("LU", 1, 0, 1, 1, 2, 2).m("LV", 0, 0, 0, 0, 2, 2).m("LY", 4, 2, 4, 3, 2, 2).m("MA", 3, 2, 2, 1, 2, 2).m("MC", 0, 2, 0, 0, 2, 2).m("MD", 1, 2, 0, 0, 2, 2).m("ME", 1, 2, 0, 1, 2, 2).m("MF", 2, 2, 1, 1, 2, 2).m("MG", 3, 4, 2, 2, 2, 2).m("MH", 4, 2, 2, 4, 2, 2).m("MK", 1, 1, 0, 0, 2, 2).m("ML", 4, 4, 2, 2, 2, 2).m("MM", 2, 3, 3, 3, 2, 2).m("MN", 2, 4, 2, 2, 2, 2).m("MO", 0, 2, 4, 4, 2, 2).m("MP", 0, 2, 2, 2, 2, 2).m("MQ", 2, 2, 2, 3, 2, 2).m("MR", 3, 0, 4, 3, 2, 2).m("MS", 1, 2, 2, 2, 2, 2).m("MT", 0, 2, 0, 0, 2, 2).m("MU", 2, 1, 1, 2, 2, 2).m("MV", 4, 3, 2, 4, 2, 2).m("MW", 4, 2, 1, 0, 2, 2).m("MX", 2, 4, 4, 4, 4, 2).m("MY", 1, 0, 3, 2, 2, 2).m("MZ", 3, 3, 2, 1, 2, 2).m("NA", 4, 3, 3, 2, 2, 2).m("NC", 3, 0, 4, 4, 2, 2).m("NE", 4, 4, 4, 4, 2, 2).m("NF", 2, 2, 2, 2, 2, 2).m("NG", 3, 3, 2, 3, 2, 2).m("NI", 2, 1, 4, 4, 2, 2).m("NL", 0, 2, 3, 2, 0, 2).m("NO", 0, 1, 2, 0, 0, 2).m("NP", 2, 0, 4, 2, 2, 2).m("NR", 3, 2, 3, 1, 2, 2).m("NU", 4, 2, 2, 2, 2, 2).m("NZ", 0, 2, 1, 2, 4, 2).m("OM", 2, 2, 1, 3, 3, 2).m("PA", 1, 3, 3, 3, 2, 2).m("PE", 2, 3, 4, 4, 2, 2).m("PF", 2, 2, 2, 1, 2, 2).m("PG", 4, 4, 3, 2, 2, 2).m("PH", 2, 1, 3, 3, 3, 2).m("PK", 3, 2, 3, 3, 2, 2).m("PL", 1, 0, 1, 2, 3, 2).m("PM", 0, 2, 2, 2, 2, 2).m("PR", 2, 1, 2, 2, 4, 3).m("PS", 3, 3, 2, 2, 2, 2).m("PT", 0, 1, 1, 0, 2, 2).m("PW", 1, 2, 4, 1, 2, 2).m("PY", 2, 0, 3, 2, 2, 2).m("QA", 2, 3, 1, 2, 3, 2).m("RE", 1, 0, 2, 2, 2, 2).m("RO", 0, 1, 0, 1, 0, 2).m("RS", 1, 2, 0, 0, 2, 2).m("RU", 0, 1, 0, 1, 4, 2).m("RW", 3, 3, 3, 1, 2, 2).m("SA", 2, 2, 2, 1, 1, 2).m("SB", 4, 2, 3, 2, 2, 2).m("SC", 4, 2, 1, 3, 2, 2).m("SD", 4, 4, 4, 4, 2, 2).m("SE", 0, 0, 0, 0, 0, 2).m("SG", 1, 0, 1, 2, 3, 2).m("SH", 4, 2, 2, 2, 2, 2).m("SI", 0, 0, 0, 0, 2, 2).m("SJ", 2, 2, 2, 2, 2, 2).m("SK", 0, 1, 0, 0, 2, 2).m("SL", 4, 3, 4, 0, 2, 2).m("SM", 0, 2, 2, 2, 2, 2).m("SN", 4, 4, 4, 4, 2, 2).m("SO", 3, 3, 3, 4, 2, 2).m("SR", 3, 2, 2, 2, 2, 2).m("SS", 4, 4, 3, 3, 2, 2).m("ST", 2, 2, 1, 2, 2, 2).m("SV", 2, 1, 4, 3, 2, 2).m("SX", 2, 2, 1, 0, 2, 2).m("SY", 4, 3, 3, 2, 2, 2).m("SZ", 3, 3, 2, 4, 2, 2).m("TC", 2, 2, 2, 0, 2, 2).m("TD", 4, 3, 4, 4, 2, 2).m("TG", 3, 2, 2, 4, 2, 2).m("TH", 0, 3, 2, 3, 2, 2).m("TJ", 4, 4, 4, 4, 2, 2).m("TL", 4, 0, 4, 4, 2, 2).m("TM", 4, 2, 4, 3, 2, 2).m("TN", 2, 1, 1, 2, 2, 2).m("TO", 3, 3, 4, 3, 2, 2).m("TR", 1, 2, 1, 1, 2, 2).m(GlobalSetting.TT_SDK_WRAPPER, 1, 4, 0, 1, 2, 2).m("TV", 3, 2, 2, 4, 2, 2).m(HomeCountryUtils.HomeCountry.CHINA_TAIWAN, 0, 0, 0, 0, 1, 0).m("TZ", 3, 3, 3, 2, 2, 2).m("UA", 0, 3, 1, 1, 2, 2).m("UG", 3, 2, 3, 3, 2, 2).m("US", 1, 1, 2, 2, 4, 2).m("UY", 2, 2, 1, 1, 2, 2).m("UZ", 2, 1, 3, 4, 2, 2).m("VC", 1, 2, 2, 2, 2, 2).m("VE", 4, 4, 4, 4, 2, 2).m("VG", 2, 2, 1, 1, 2, 2).m("VI", 1, 2, 1, 2, 2, 2).m("VN", 0, 1, 3, 4, 2, 2).m("VU", 4, 0, 3, 1, 2, 2).m("WF", 4, 2, 2, 4, 2, 2).m("WS", 3, 1, 3, 1, 2, 2).m("XK", 0, 1, 1, 0, 2, 2).m("YE", 4, 4, 4, 3, 2, 2).m("YT", 4, 2, 2, 3, 2, 2).m("ZA", 3, 3, 2, 1, 2, 2).m("ZM", 3, 2, 3, 3, 2, 2).m("ZW", 3, 2, 4, 3, 2, 2).h();
    }

    public static synchronized n m(Context context) {
        n nVar;
        synchronized (n.class) {
            if (f52327w == null) {
                f52327w = new b(context).a();
            }
            nVar = f52327w;
        }
        return nVar;
    }

    public static boolean n(com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
        return z10 && !bVar.d(8);
    }

    @Override // o6.e
    public void a(Handler handler, e.a aVar) {
        com.google.android.exoplayer2.util.a.e(handler);
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f52329b.b(handler, aVar);
    }

    @Override // o6.v
    public synchronized void b(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
        if (n(bVar, z10)) {
            com.google.android.exoplayer2.util.a.g(this.f52333f > 0);
            long a10 = this.f52331d.a();
            int i10 = (int) (a10 - this.f52334g);
            this.f52337j += i10;
            long j10 = this.f52338k;
            long j11 = this.f52335h;
            this.f52338k = j10 + j11;
            if (i10 > 0) {
                this.f52330c.c((int) Math.sqrt(j11), (((float) j11) * 8000.0f) / i10);
                if (this.f52337j >= 2000 || this.f52338k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f52339l = this.f52330c.f(0.5f);
                }
                o(i10, this.f52335h, this.f52339l);
                this.f52334g = a10;
                this.f52335h = 0L;
            }
            this.f52333f--;
        }
    }

    @Override // o6.e
    public synchronized long c() {
        return this.f52339l;
    }

    @Override // o6.v
    public synchronized void d(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10, int i10) {
        if (n(bVar, z10)) {
            this.f52335h += i10;
        }
    }

    @Override // o6.v
    public synchronized void e(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
        if (n(bVar, z10)) {
            if (this.f52333f == 0) {
                this.f52334g = this.f52331d.a();
            }
            this.f52333f++;
        }
    }

    @Override // o6.e
    public /* synthetic */ long f() {
        return c.a(this);
    }

    @Override // o6.e
    public void g(e.a aVar) {
        this.f52329b.e(aVar);
    }

    @Override // o6.e
    public v h() {
        return this;
    }

    @Override // o6.v
    public void i(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) {
    }

    public final long l(int i10) {
        Long l10 = this.f52328a.get(Integer.valueOf(i10));
        if (l10 == null) {
            l10 = this.f52328a.get(0);
        }
        if (l10 == null) {
            l10 = 1000000L;
        }
        return l10.longValue();
    }

    public final void o(int i10, long j10, long j11) {
        if (i10 == 0 && j10 == 0 && j11 == this.f52340m) {
            return;
        }
        this.f52340m = j11;
        this.f52329b.c(i10, j10, j11);
    }

    public final synchronized void p(int i10) {
        int i11 = this.f52336i;
        if (i11 == 0 || this.f52332e) {
            if (this.f52341n) {
                i10 = this.f52342o;
            }
            if (i11 == i10) {
                return;
            }
            this.f52336i = i10;
            if (i10 != 1 && i10 != 0 && i10 != 8) {
                this.f52339l = l(i10);
                long a10 = this.f52331d.a();
                o(this.f52333f > 0 ? (int) (a10 - this.f52334g) : 0, this.f52335h, this.f52339l);
                this.f52334g = a10;
                this.f52335h = 0L;
                this.f52338k = 0L;
                this.f52337j = 0L;
                this.f52330c.i();
            }
        }
    }

    public n(@Nullable Context context, Map<Integer, Long> map, int i10, Clock clock, boolean z10) {
        this.f52328a = ImmutableMap.copyOf((Map) map);
        this.f52329b = new e.a.C0800a();
        this.f52330c = new a0(i10);
        this.f52331d = clock;
        this.f52332e = z10;
        if (context != null) {
            com.google.android.exoplayer2.util.s d10 = com.google.android.exoplayer2.util.s.d(context);
            int f10 = d10.f();
            this.f52336i = f10;
            this.f52339l = l(f10);
            d10.i(new s.c() { // from class: o6.m
                @Override // com.google.android.exoplayer2.util.s.c
                public final void a(int i11) {
                    n.this.p(i11);
                }
            });
            return;
        }
        this.f52336i = 0;
        this.f52339l = l(0);
    }
}
