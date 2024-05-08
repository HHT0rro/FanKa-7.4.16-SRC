package com.huawei.openalliance.ad.beans.parameter;

import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.b;
import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.beans.metadata.Video;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.utils.af;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdSlotParam {
    private static final String TAG = "AdSlotParam";
    private Integer adHeight;
    private List<String> adIds;
    private int adType;
    private Integer adWidth;
    private Integer adsLocSwitch;
    private String agcAaid;
    private Integer allowMobileTraffic;
    private App appInfo;
    private Integer bannerRefFlag;
    private String belongCountry;
    private Integer brand;
    private String contentBundle;

    @d
    private Map<String, String> contentBundleMap;
    private String contentUrl;
    private List<String> detailedCreativeTypeList;
    private int deviceType;
    private Integer endMode;
    private int gender;
    private Integer gpsSwitch;
    private int height;
    private Integer imageOrientation;
    private boolean isPreload;
    private boolean isRequestMultipleImages;
    private Integer isSmart;
    private Set<String> keyWordsSet;
    private Integer linkedMode;
    private Location location;
    private int maxCount;
    private Integer mediaGpsSwitch;
    private boolean needDownloadImage;
    private int orientation;
    private String requestAgent;
    private String requestId;
    private RequestOptions requestOptions;
    private String requestSequence;
    private Integer requestType;
    private Integer sdkType;
    private boolean sharePd;
    private Integer splashStartMode;
    private Integer splashType;
    private boolean supportTptAd;
    private boolean test;
    private String testDeviceId;
    private int totalDuration;
    private String uiEngineVer;
    private Map<String, Integer> unsupportedTags;
    private Video video;
    private int width;

    @b
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {
        private Map<String, Integer> A;
        private Video D;
        private String S;

        /* renamed from: a, reason: collision with root package name */
        private android.location.Location f32148a;

        /* renamed from: b, reason: collision with root package name */
        private RequestOptions f32149b;

        /* renamed from: c, reason: collision with root package name */
        private int f32150c;

        /* renamed from: d, reason: collision with root package name */
        private String f32151d;

        /* renamed from: e, reason: collision with root package name */
        private String f32152e;

        /* renamed from: f, reason: collision with root package name */
        private Set<String> f32153f;

        /* renamed from: g, reason: collision with root package name */
        private int f32154g;

        /* renamed from: h, reason: collision with root package name */
        private Integer f32155h;

        /* renamed from: j, reason: collision with root package name */
        private Integer f32157j;

        /* renamed from: k, reason: collision with root package name */
        private String f32158k;

        /* renamed from: m, reason: collision with root package name */
        private Integer f32160m;

        /* renamed from: n, reason: collision with root package name */
        private Integer f32161n;

        /* renamed from: o, reason: collision with root package name */
        private Integer f32162o;

        /* renamed from: p, reason: collision with root package name */
        private App f32163p;

        /* renamed from: q, reason: collision with root package name */
        private int f32164q;

        /* renamed from: r, reason: collision with root package name */
        private Integer f32165r;

        /* renamed from: s, reason: collision with root package name */
        private Integer f32166s;

        /* renamed from: t, reason: collision with root package name */
        private String f32167t;

        /* renamed from: u, reason: collision with root package name */
        private List<String> f32168u;

        /* renamed from: v, reason: collision with root package name */
        private Integer f32169v;

        /* renamed from: w, reason: collision with root package name */
        private String f32170w;

        /* renamed from: x, reason: collision with root package name */
        private Map<String, String> f32171x;

        /* renamed from: y, reason: collision with root package name */
        private String f32172y;

        /* renamed from: z, reason: collision with root package name */
        private Integer f32173z;
        private List<String> Code = new ArrayList(0);
        private int V = 1;
        private boolean I = false;
        private int Z = 4;
        private int B = 0;
        private int C = 0;
        private boolean F = false;
        private int L = 3;

        /* renamed from: i, reason: collision with root package name */
        private boolean f32156i = true;

        /* renamed from: l, reason: collision with root package name */
        private boolean f32159l = true;
        private boolean E = false;

        @b
        public a B(int i10) {
            this.f32154g = i10;
            return this;
        }

        public a B(String str) {
            this.f32167t = str;
            return this;
        }

        public Integer B() {
            return this.f32160m;
        }

        public void B(Integer num) {
            this.f32165r = num;
        }

        @b
        public a C(int i10) {
            this.L = i10;
            return this;
        }

        public a C(Integer num) {
            this.f32166s = num;
            return this;
        }

        @b
        public a C(String str) {
            Map<String, String> map = (Map) z.V(str, Map.class, new Class[0]);
            if (af.Code(map)) {
                gl.I(AdSlotParam.TAG, "contentBundle info is empty or not json string");
            } else {
                String V = AdSlotParam.V(map);
                this.f32171x = map;
                this.f32170w = V;
            }
            return this;
        }

        public Integer C() {
            return this.f32161n;
        }

        public Location Code() {
            android.location.Location location = this.f32148a;
            if (location == null) {
                return null;
            }
            return new Location(Double.valueOf(location.getLongitude()), Double.valueOf(this.f32148a.getLatitude()));
        }

        @b
        public a Code(int i10) {
            this.V = i10;
            return this;
        }

        @b
        public a Code(android.location.Location location) {
            this.f32148a = location;
            return this;
        }

        public a Code(App app) {
            this.f32163p = app;
            return this;
        }

        @b
        public a Code(RequestOptions requestOptions) {
            this.f32149b = requestOptions;
            return this;
        }

        @b
        public a Code(Boolean bool) {
            this.F = bool.booleanValue();
            return this;
        }

        @b
        public a Code(Integer num) {
            this.f32155h = num;
            return this;
        }

        @b
        public a Code(String str) {
            this.S = str;
            return this;
        }

        @b
        public a Code(List<String> list) {
            this.Code = list;
            return this;
        }

        @b
        public a Code(Map<String, Integer> map) {
            this.A = map;
            return this;
        }

        @b
        public a Code(Set<String> set) {
            this.f32153f = set;
            return this;
        }

        @b
        public a Code(boolean z10) {
            this.I = z10;
            return this;
        }

        @b
        public void Code(Video video) {
            this.D = video;
        }

        @b
        public a D(int i10) {
            this.f32164q = i10;
            return this;
        }

        public String D() {
            return this.f32167t;
        }

        @b
        public a F(int i10) {
            this.f32157j = Integer.valueOf(i10);
            return this;
        }

        public Integer F() {
            return this.f32165r;
        }

        @b
        public a I(int i10) {
            this.B = i10;
            return this;
        }

        @b
        public a I(Integer num) {
            this.f32161n = num;
            return this;
        }

        @b
        public a I(String str) {
            this.f32152e = str;
            return this;
        }

        @b
        public void I(boolean z10) {
            this.f32159l = z10;
        }

        public boolean I() {
            return this.f32159l;
        }

        public a L(int i10) {
            this.f32162o = Integer.valueOf(i10);
            return this;
        }

        public Integer L() {
            return this.f32169v;
        }

        @b
        public a S(int i10) {
            this.f32150c = i10;
            return this;
        }

        public a S(String str) {
            this.f32172y = str;
            return this;
        }

        @b
        public AdSlotParam S() {
            return new AdSlotParam(this);
        }

        public void S(Integer num) {
            this.f32169v = num;
        }

        public RequestOptions V() {
            return this.f32149b;
        }

        @b
        public a V(int i10) {
            this.Z = i10;
            return this;
        }

        @b
        public a V(Integer num) {
            this.f32160m = num;
            return this;
        }

        @b
        public a V(String str) {
            this.f32151d = str;
            return this;
        }

        @b
        public a V(List<Integer> list) {
            if (list == null) {
                return this;
            }
            if (list.size() > 100) {
                list = list.subList(0, 100);
            }
            this.f32168u = new ArrayList(list.size());
            Iterator<Integer> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                this.f32168u.add(Integer.toString(iterator2.next().intValue()));
            }
            return this;
        }

        @b
        public a V(boolean z10) {
            this.f32156i = z10;
            return this;
        }

        @b
        public a Z(int i10) {
            this.C = i10;
            return this;
        }

        @b
        public a Z(Integer num) {
            this.f32173z = num;
            return this;
        }

        @b
        public a Z(String str) {
            this.f32158k = str;
            return this;
        }

        public a Z(boolean z10) {
            this.E = z10;
            return this;
        }

        public List<String> Z() {
            return this.f32168u;
        }

        public String a() {
            return this.f32172y;
        }
    }

    @b
    public AdSlotParam() {
        this.isPreload = false;
        this.sharePd = true;
        this.adType = 3;
        this.needDownloadImage = false;
        this.isRequestMultipleImages = true;
        this.supportTptAd = false;
    }

    private AdSlotParam(a aVar) {
        this.isPreload = false;
        this.sharePd = true;
        this.adType = 3;
        this.needDownloadImage = false;
        this.isRequestMultipleImages = true;
        this.supportTptAd = false;
        this.adIds = aVar.Code;
        this.orientation = aVar.V;
        this.test = aVar.I;
        this.deviceType = aVar.Z;
        this.width = aVar.B;
        this.height = aVar.C;
        this.requestSequence = aVar.S;
        this.video = aVar.D;
        this.isPreload = aVar.F;
        this.adType = aVar.L;
        this.requestOptions = aVar.f32149b;
        this.location = aVar.Code();
        this.gender = aVar.f32150c;
        this.contentUrl = aVar.f32151d;
        this.requestAgent = aVar.f32152e;
        this.keyWordsSet = aVar.f32153f;
        this.maxCount = aVar.f32154g;
        this.isSmart = aVar.f32155h;
        this.needDownloadImage = aVar.f32156i;
        this.imageOrientation = aVar.f32157j;
        this.testDeviceId = aVar.f32158k;
        this.isRequestMultipleImages = aVar.f32159l;
        this.adWidth = aVar.f32160m;
        this.adHeight = aVar.f32161n;
        this.allowMobileTraffic = aVar.f32162o;
        this.appInfo = aVar.f32163p;
        this.totalDuration = aVar.f32164q;
        this.brand = aVar.f32165r;
        this.bannerRefFlag = aVar.f32166s;
        this.requestId = aVar.f32167t;
        this.detailedCreativeTypeList = aVar.f32168u;
        this.requestType = aVar.f32169v;
        this.contentBundle = aVar.f32170w;
        this.contentBundleMap = aVar.f32171x;
        this.agcAaid = aVar.f32172y;
        this.endMode = aVar.f32173z;
        this.unsupportedTags = aVar.A;
        this.supportTptAd = aVar.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String V(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new ImpEX(entry.getKey(), au.S(entry.getValue())));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contentBundle", arrayList);
        return z.V(hashMap);
    }

    public RequestOptions B() {
        return this.requestOptions;
    }

    public void B(int i10) {
        this.height = i10;
    }

    public void B(Integer num) {
        this.splashStartMode = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void B(String str) {
        Map<String, String> map;
        Map map2 = (Map) z.V(str, Map.class, new Class[0]);
        if (af.Code(map2) || af.Code(this.contentBundleMap)) {
            if (af.Code(map2)) {
                return;
            }
            gl.Code(TAG, "set auto content Bundle");
            map = (Map) z.V(str, Map.class, new Class[0]);
            if (af.Code(map)) {
                gl.I(TAG, "auto contentBundle info is empty or not json string");
                return;
            }
        } else {
            gl.Code(TAG, "merge auto content Bundle");
            for (Map.Entry entry : map2.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                if (!this.contentBundleMap.containsKey(str2) && !au.Code(str3)) {
                    this.contentBundleMap.put(str2, map2.get(str2));
                }
            }
            if (this.contentBundleMap.containsKey("content") && this.contentBundleMap.containsKey(u.cg)) {
                this.contentBundleMap.remove(u.cg);
            }
            map = this.contentBundleMap;
        }
        this.contentBundle = V(map);
    }

    public Integer C() {
        return this.allowMobileTraffic;
    }

    public void C(Integer num) {
        this.adsLocSwitch = num;
    }

    public List<String> Code() {
        return this.adIds;
    }

    public void Code(int i10) {
        this.adType = i10;
    }

    public void Code(App app) {
        this.appInfo = app;
    }

    public void Code(RequestOptions requestOptions) {
        this.requestOptions = requestOptions;
    }

    public void Code(Location location) {
        this.location = location;
    }

    public void Code(Integer num) {
        this.adWidth = num;
    }

    public void Code(String str) {
        this.belongCountry = str;
    }

    public void Code(boolean z10) {
        this.isPreload = z10;
    }

    public Integer D() {
        return this.adsLocSwitch;
    }

    public void D(Integer num) {
        this.brand = num;
    }

    public Integer F() {
        return this.splashStartMode;
    }

    public void F(Integer num) {
        this.mediaGpsSwitch = num;
    }

    public int I() {
        return this.deviceType;
    }

    public void I(int i10) {
        this.deviceType = i10;
    }

    public void I(Integer num) {
        this.allowMobileTraffic = num;
    }

    public void I(String str) {
        this.agcAaid = str;
    }

    public Integer L() {
        return this.gpsSwitch;
    }

    public void L(Integer num) {
        this.linkedMode = num;
    }

    public Integer S() {
        return this.splashType;
    }

    public void S(Integer num) {
        this.gpsSwitch = num;
    }

    public int V() {
        return this.orientation;
    }

    public void V(int i10) {
        this.orientation = i10;
    }

    public void V(Integer num) {
        this.adHeight = num;
    }

    public void V(String str) {
        this.requestId = str;
    }

    public void V(boolean z10) {
        this.sharePd = z10;
    }

    public Location Z() {
        return this.location;
    }

    public void Z(int i10) {
        this.width = i10;
    }

    public void Z(Integer num) {
        this.splashType = num;
    }

    public void Z(String str) {
        this.uiEngineVer = str;
    }

    public Integer a() {
        return this.mediaGpsSwitch;
    }

    public void a(Integer num) {
        this.sdkType = num;
    }

    public Integer b() {
        return this.brand;
    }

    public String c() {
        return this.requestId;
    }

    public List<String> d() {
        return this.detailedCreativeTypeList;
    }

    public String e() {
        return this.agcAaid;
    }

    public Integer f() {
        return this.endMode;
    }

    public AdSlotParam g() {
        AdSlotParam adSlotParam = new AdSlotParam();
        adSlotParam.adIds = this.adIds;
        adSlotParam.orientation = this.orientation;
        adSlotParam.test = this.test;
        adSlotParam.deviceType = this.deviceType;
        adSlotParam.width = this.width;
        adSlotParam.height = this.height;
        adSlotParam.requestSequence = this.requestSequence;
        adSlotParam.video = this.video;
        adSlotParam.isPreload = this.isPreload;
        adSlotParam.sharePd = this.sharePd;
        adSlotParam.requestOptions = this.requestOptions;
        adSlotParam.location = this.location;
        adSlotParam.gender = this.gender;
        adSlotParam.contentUrl = this.contentUrl;
        adSlotParam.requestAgent = this.requestAgent;
        adSlotParam.keyWordsSet = this.keyWordsSet;
        adSlotParam.maxCount = this.maxCount;
        adSlotParam.belongCountry = this.belongCountry;
        adSlotParam.isSmart = this.isSmart;
        adSlotParam.needDownloadImage = this.needDownloadImage;
        adSlotParam.imageOrientation = this.imageOrientation;
        adSlotParam.isRequestMultipleImages = this.isRequestMultipleImages;
        adSlotParam.adWidth = this.adWidth;
        adSlotParam.adHeight = this.adHeight;
        adSlotParam.allowMobileTraffic = this.allowMobileTraffic;
        adSlotParam.totalDuration = this.totalDuration;
        adSlotParam.splashStartMode = this.splashStartMode;
        adSlotParam.splashType = this.splashType;
        adSlotParam.adsLocSwitch = this.adsLocSwitch;
        adSlotParam.gpsSwitch = this.gpsSwitch;
        adSlotParam.mediaGpsSwitch = this.mediaGpsSwitch;
        adSlotParam.brand = this.brand;
        adSlotParam.bannerRefFlag = this.bannerRefFlag;
        adSlotParam.detailedCreativeTypeList = this.detailedCreativeTypeList;
        adSlotParam.requestType = this.requestType;
        adSlotParam.contentBundle = this.contentBundle;
        adSlotParam.contentBundleMap = this.contentBundleMap;
        adSlotParam.agcAaid = this.agcAaid;
        adSlotParam.endMode = this.endMode;
        adSlotParam.unsupportedTags = this.unsupportedTags;
        adSlotParam.supportTptAd = this.supportTptAd;
        return adSlotParam;
    }

    public Integer h() {
        return this.linkedMode;
    }
}
