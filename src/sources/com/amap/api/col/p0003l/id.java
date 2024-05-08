package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.col.p0003l.hw;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.inno.innosdk.pb.InnoMain;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Request.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class id {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: d, reason: collision with root package name */
    private String f6415d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6416e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6417f;

    /* renamed from: o, reason: collision with root package name */
    public hw.a f6423o;

    /* renamed from: l, reason: collision with root package name */
    public int f6420l = 20000;

    /* renamed from: m, reason: collision with root package name */
    public int f6421m = 20000;

    /* renamed from: n, reason: collision with root package name */
    public Proxy f6422n = null;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6412a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f6413b = 20000;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6414c = true;

    /* renamed from: g, reason: collision with root package name */
    private a f6418g = a.NORMAL;

    /* renamed from: h, reason: collision with root package name */
    private b f6419h = b.FIRST_NONDEGRADE;

    /* compiled from: Request.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);


        /* renamed from: f, reason: collision with root package name */
        private int f6430f;

        a(int i10) {
            this.f6430f = i10;
        }
    }

    /* compiled from: Request.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);


        /* renamed from: h, reason: collision with root package name */
        private int f6439h;

        b(int i10) {
            this.f6439h = i10;
        }

        public final int a() {
            return this.f6439h;
        }

        public final boolean b() {
            int i10 = this.f6439h;
            return i10 == FIRST_NONDEGRADE.f6439h || i10 == NEVER_GRADE.f6439h || i10 == FIX_NONDEGRADE.f6439h;
        }

        public final boolean c() {
            int i10 = this.f6439h;
            return i10 == DEGRADE_BYERROR.f6439h || i10 == DEGRADE_ONLY.f6439h || i10 == FIX_DEGRADE_BYERROR.f6439h || i10 == FIX_DEGRADE_ONLY.f6439h;
        }

        public final boolean d() {
            int i10 = this.f6439h;
            return i10 == DEGRADE_BYERROR.f6439h || i10 == FIX_DEGRADE_BYERROR.f6439h;
        }

        public final boolean e() {
            return this.f6439h == NEVER_GRADE.f6439h;
        }
    }

    /* compiled from: Request.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum c {
        HTTP(0),
        HTTPS(1);


        /* renamed from: c, reason: collision with root package name */
        private int f6443c;

        c(int i10) {
            this.f6443c = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return a(getURL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.f6420l;
    }

    public a getDegradeAbility() {
        return this.f6418g;
    }

    public b getDegradeType() {
        return this.f6419h;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    public String getNon_degrade_final_Host() {
        return this.f6415d;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.f6422n;
    }

    public int getReal_max_timeout() {
        return this.f6413b;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f6421m;
    }

    public abstract String getURL();

    public hw.a getUrlConnectionImpl() {
        return this.f6423o;
    }

    public boolean isBinary() {
        return this.f6412a;
    }

    public boolean isHostToIP() {
        return this.f6414c;
    }

    public boolean isHttps() {
        return this.f6417f;
    }

    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIPV6Request() {
        return this.f6416e;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public String parseSDKNameFromPlatInfo(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i10 = 0;
                    String str4 = "";
                    while (true) {
                        if (i10 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i10];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains(InnoMain.INNO_KEY_PRODUCT)) {
                            break;
                        }
                        i10++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(gj.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    gj.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            gv.a(th, "ht", "pnfp");
        }
        return str3;
    }

    public String parseSdkNameFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            gv.a(th, "ht", "pnfh");
            return null;
        }
    }

    public String parseSdkNameFromRequest() {
        String str;
        try {
            str = getSDKName();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.f6412a) {
                    str = parseSDKNameFromPlatInfo(((hx) this).g());
                } else {
                    str = parseSdkNameFromHeader(getRequestHead());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gv.a(th, "ht", "pnfr");
            return str;
        }
        return str;
    }

    public void setBinary(boolean z10) {
        this.f6412a = z10;
    }

    public final void setConnectionTimeout(int i10) {
        this.f6420l = i10;
    }

    public void setDegradeAbility(a aVar) {
        this.f6418g = aVar;
    }

    public void setDegradeType(b bVar) {
        this.f6419h = bVar;
    }

    public void setHostToIP(boolean z10) {
        this.f6414c = z10;
    }

    public void setHttpProtocol(c cVar) {
        this.f6417f = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z10) {
        this.f6416e = z10;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f6415d = str;
    }

    public final void setProxy(Proxy proxy) {
        this.f6422n = proxy;
    }

    public void setReal_max_timeout(int i10) {
        this.f6413b = i10;
    }

    public final void setSoTimeout(int i10) {
        this.f6421m = i10;
    }

    public void setUrlConnectionImpl(hw.a aVar) {
        this.f6423o = aVar;
    }

    private String a(String str) {
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0) {
            return str;
        }
        Map<String, String> params = getParams();
        HashMap<String, String> hashMap = hw.f6313e;
        if (hashMap != null) {
            if (params != null) {
                params.putAll(hashMap);
            } else {
                params = hashMap;
            }
        }
        if (params == null) {
            return str;
        }
        String a10 = ia.a(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(SymbolValues.QUESTION_EN_SYMBOL);
        stringBuffer.append(a10);
        return stringBuffer.toString();
    }
}
