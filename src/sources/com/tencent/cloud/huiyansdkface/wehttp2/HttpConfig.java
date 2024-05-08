package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.MockInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.WeConfig;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpConfig implements PinProvider {
    private String A;
    private WeDns B;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f42221f;

    /* renamed from: h, reason: collision with root package name */
    private volatile PinVerifyListener f42223h;

    /* renamed from: i, reason: collision with root package name */
    private String f42224i;

    /* renamed from: o, reason: collision with root package name */
    private RetryInterceptor.RetryStrategy f42230o;

    /* renamed from: q, reason: collision with root package name */
    private WeCookie f42232q;

    /* renamed from: r, reason: collision with root package name */
    private TypeAdapter f42233r;

    /* renamed from: s, reason: collision with root package name */
    private Proxy f42234s;

    /* renamed from: t, reason: collision with root package name */
    private List<MockInterceptor.Mock> f42235t;

    /* renamed from: u, reason: collision with root package name */
    private EventListener f42236u;

    /* renamed from: v, reason: collision with root package name */
    private List<Interceptor> f42237v;

    /* renamed from: w, reason: collision with root package name */
    private List<Interceptor> f42238w;

    /* renamed from: x, reason: collision with root package name */
    private Context f42239x;

    /* renamed from: y, reason: collision with root package name */
    private String f42240y;

    /* renamed from: z, reason: collision with root package name */
    private String f42241z;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f42218c = false;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f42219d = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile PinCheckMode f42220e = PinCheckMode.ENABLE;

    /* renamed from: g, reason: collision with root package name */
    private PinManager f42222g = new PinManager();

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f42216a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f42217b = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private int f42225j = 10000;

    /* renamed from: k, reason: collision with root package name */
    private int f42226k = 10000;

    /* renamed from: l, reason: collision with root package name */
    private int f42227l = 10000;

    /* renamed from: m, reason: collision with root package name */
    private int f42228m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f42229n = 0;

    /* renamed from: p, reason: collision with root package name */
    private WeLog.Builder f42231p = new WeLog.Builder();
    private WeConfig.IpStrategy C = WeConfig.IpStrategy.DNS_ORDER;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ConfigInheritSwitch {

        /* renamed from: s, reason: collision with root package name */
        private static ConfigInheritSwitch f42242s = new ConfigInheritSwitch();

        /* renamed from: a, reason: collision with root package name */
        public boolean f42243a = true;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42244b = true;

        /* renamed from: c, reason: collision with root package name */
        public boolean f42245c = true;

        /* renamed from: d, reason: collision with root package name */
        public boolean f42246d = true;

        /* renamed from: e, reason: collision with root package name */
        public boolean f42247e = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f42248f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f42249g = true;

        /* renamed from: h, reason: collision with root package name */
        public boolean f42250h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f42251i = true;

        /* renamed from: j, reason: collision with root package name */
        public boolean f42252j = true;

        /* renamed from: k, reason: collision with root package name */
        public boolean f42253k = true;

        /* renamed from: l, reason: collision with root package name */
        public boolean f42254l = false;

        /* renamed from: m, reason: collision with root package name */
        public boolean f42255m = true;

        /* renamed from: n, reason: collision with root package name */
        public boolean f42256n = true;

        /* renamed from: o, reason: collision with root package name */
        public boolean f42257o = true;

        /* renamed from: p, reason: collision with root package name */
        public boolean f42258p = true;

        /* renamed from: q, reason: collision with root package name */
        public boolean f42259q = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f42260r = true;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class LogConfig {

        /* renamed from: a, reason: collision with root package name */
        private boolean f42261a = false;

        /* renamed from: b, reason: collision with root package name */
        private boolean f42262b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f42263c = false;

        /* renamed from: d, reason: collision with root package name */
        private int f42264d = 3072;

        /* renamed from: e, reason: collision with root package name */
        private WeLog.Level f42265e = WeLog.Level.NONE;

        public WeLog.Level getLevel() {
            return this.f42265e;
        }

        public int getLongStrLength() {
            return this.f42264d;
        }

        public boolean isCutLongStr() {
            return this.f42263c;
        }

        public boolean isLogWithTag() {
            return this.f42262b;
        }

        public boolean isPrettyLog() {
            return this.f42261a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum PinCheckMode {
        DISABLE,
        ENABLE,
        ERROR
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface PinVerifyListener {
        void onPinVerifyFailed(String str, List<String> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Proxy {

        /* renamed from: a, reason: collision with root package name */
        private String f42270a;

        /* renamed from: b, reason: collision with root package name */
        private int f42271b;

        /* renamed from: c, reason: collision with root package name */
        private String f42272c;

        /* renamed from: d, reason: collision with root package name */
        private String f42273d;

        public Proxy setIp(String str) {
            this.f42270a = str;
            return this;
        }

        public Proxy setPassword(String str) {
            this.f42273d = str;
            return this;
        }

        public Proxy setPort(int i10) {
            this.f42271b = i10;
            return this;
        }

        public Proxy setUserName(String str) {
            this.f42272c = str;
            return this;
        }
    }

    private HttpConfig a(Map<String, ?> map, boolean z10) {
        if (z10) {
            this.f42216a.clear();
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                this.f42216a.put(key, value.toString());
            }
        }
        return this;
    }

    private static String a(List<Cookie> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            Cookie cookie = list.get(i10);
            sb2.append(cookie.name());
            sb2.append('=');
            sb2.append(cookie.value());
        }
        return sb2.toString();
    }

    private void a(WeConfig weConfig, String str, ConfigInheritSwitch configInheritSwitch) {
        List<Interceptor> list;
        List<Interceptor> list2;
        List<MockInterceptor.Mock> list3;
        Context context;
        String str2;
        Proxy proxy;
        TypeAdapter typeAdapter;
        WeCookie weCookie;
        String str3;
        Map<String, String> map;
        if (configInheritSwitch == null) {
            configInheritSwitch = ConfigInheritSwitch.f42242s;
        }
        if (configInheritSwitch.f42245c && (map = this.f42217b) != null) {
            weConfig.params(map);
        }
        if (configInheritSwitch.f42244b) {
            weConfig.header(this.f42216a);
        }
        if (configInheritSwitch.f42247e && (str3 = this.f42224i) != null) {
            weConfig.baseUrl(str3);
        }
        if (configInheritSwitch.f42246d) {
            weConfig.setCertVerify(this.f42218c);
            if (this.f42219d) {
                weConfig.pinProvider(this);
            } else if (str == null) {
                weConfig.addPin4Host(this.f42221f, a(this.f42221f));
            } else {
                weConfig.addPin4Host(str, a(str));
            }
        }
        if (configInheritSwitch.f42248f) {
            weConfig.timeoutInMillis(this.f42225j, this.f42226k, this.f42227l);
        }
        if (configInheritSwitch.f42250h) {
            weConfig.retryConfig(this.f42229n, this.f42230o);
        }
        if (configInheritSwitch.f42251i) {
            weConfig.log(this.f42231p);
        }
        if (configInheritSwitch.f42252j && (weCookie = this.f42232q) != null) {
            weConfig.cookie(weCookie);
        }
        if (configInheritSwitch.f42243a && (typeAdapter = this.f42233r) != null) {
            weConfig.adapter(typeAdapter);
        }
        if (configInheritSwitch.f42253k && (proxy = this.f42234s) != null) {
            weConfig.proxy(proxy.f42270a, this.f42234s.f42271b, this.f42234s.f42272c, this.f42234s.f42273d);
        }
        if (configInheritSwitch.f42258p && (context = this.f42239x) != null && (str2 = this.f42240y) != null) {
            weConfig.clientCertPath(context, str2, this.f42241z, this.A);
        }
        if (configInheritSwitch.f42254l && (list3 = this.f42235t) != null && list3.size() > 0) {
            List<MockInterceptor.Mock> list4 = this.f42235t;
            weConfig.addMock((MockInterceptor.Mock[]) list4.toArray(new MockInterceptor.Mock[list4.size()]));
        }
        if (configInheritSwitch.f42255m && this.f42236u != null) {
            weConfig.clientConfig().eventListener(this.f42236u);
        }
        if (configInheritSwitch.f42249g && this.f42228m >= 0) {
            weConfig.clientConfig().callTimeout(this.f42228m, TimeUnit.MILLISECONDS);
        }
        if (configInheritSwitch.f42256n && (list2 = this.f42237v) != null && list2.size() > 0) {
            for (Interceptor interceptor : this.f42237v) {
                if (interceptor != null) {
                    weConfig.clientConfig().addNetworkInterceptor(interceptor);
                }
            }
        }
        if (configInheritSwitch.f42257o && (list = this.f42238w) != null && list.size() > 0) {
            for (Interceptor interceptor2 : this.f42238w) {
                if (interceptor2 != null) {
                    weConfig.clientConfig().addInterceptor(interceptor2);
                }
            }
        }
        if (configInheritSwitch.f42259q) {
            weConfig.dns(this.B);
        }
        if (configInheritSwitch.f42260r) {
            weConfig.ipStrategy(this.C);
        }
    }

    private String[] a(String str) {
        return this.f42222g.getPinArray4HostPattern(str);
    }

    private HttpConfig b(Map<String, ?> map, boolean z10) {
        if (z10) {
            this.f42217b.clear();
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (key != null && value != null) {
                this.f42217b.put(key, value.toString());
            }
        }
        return this;
    }

    public HttpConfig addCommonHeaders(Map<String, ?> map) {
        return a(map, false);
    }

    public HttpConfig addCommonParams(Map<String, ?> map) {
        return b(map, false);
    }

    public HttpConfig addInterceptor(Interceptor... interceptorArr) {
        if (interceptorArr != null && interceptorArr.length != 0) {
            if (this.f42238w == null) {
                this.f42238w = new ArrayList();
            }
            this.f42238w.addAll(Arrays.asList(interceptorArr));
        }
        return this;
    }

    public HttpConfig addMock(MockInterceptor.Mock... mockArr) {
        if (mockArr != null && mockArr.length != 0) {
            if (this.f42235t == null) {
                this.f42235t = new ArrayList();
            }
            for (MockInterceptor.Mock mock : mockArr) {
                if (mock != null) {
                    this.f42235t.add(mock);
                }
            }
        }
        return this;
    }

    public HttpConfig addNetInterceptor(Interceptor... interceptorArr) {
        if (interceptorArr != null && interceptorArr.length != 0) {
            if (this.f42237v == null) {
                this.f42237v = new ArrayList();
            }
            this.f42237v.addAll(Arrays.asList(interceptorArr));
        }
        return this;
    }

    @Deprecated
    public HttpConfig addPins(List<byte[]> list) {
        this.f42222g.addPins4Host(this.f42221f, list);
        return this;
    }

    public HttpConfig clientCertPath(Context context, String str, String str2, String str3) {
        this.f42240y = str;
        this.f42239x = context.getApplicationContext();
        this.f42241z = str2;
        this.A = str3;
        return this;
    }

    public WeOkHttp create() {
        return create((WeOkHttp) null, (String) null, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(WeOkHttp weOkHttp, String str) {
        return create(weOkHttp, str, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(WeOkHttp weOkHttp, String str, ConfigInheritSwitch configInheritSwitch) {
        if (weOkHttp == null) {
            weOkHttp = new WeOkHttp();
        }
        a(weOkHttp.config(), str, configInheritSwitch);
        return weOkHttp;
    }

    public WeOkHttp create(String str) {
        return create((WeOkHttp) null, str, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(String str, String str2) {
        return create(str, str2, (ConfigInheritSwitch) null);
    }

    public WeOkHttp create(String str, String str2, ConfigInheritSwitch configInheritSwitch) {
        WeOkHttp weOkHttp = new WeOkHttp(str);
        a(weOkHttp.config(), str2, configInheritSwitch);
        return weOkHttp;
    }

    public String getBaseUrl() {
        return this.f42224i;
    }

    public int getCallTimeoutInSeconds() {
        return this.f42228m;
    }

    public Map<String, String> getCommonHeaders() {
        return Collections.unmodifiableMap(this.f42216a);
    }

    public Map<String, String> getCommonParams() {
        return Collections.unmodifiableMap(this.f42217b);
    }

    public int getConnectTimeout() {
        return this.f42225j;
    }

    public int getConnectTimeoutInSeconds() {
        return this.f42225j / 1000;
    }

    public WeCookie getCookie() {
        return this.f42232q;
    }

    public String getCookieHeader() {
        return getCookieHeader(getBaseUrl());
    }

    public String getCookieHeader(String str) {
        return a(this.f42232q.loadForRequest(HttpUrl.parse(str)));
    }

    public WeDns getDns() {
        return this.B;
    }

    public WeConfig.IpStrategy getIpStrategy() {
        return this.C;
    }

    public LogConfig getLogConfig() {
        LogConfig logConfig = new LogConfig();
        WeLog.Builder builder = this.f42231p;
        if (builder == null) {
            return logConfig;
        }
        logConfig.f42265e = builder.f42398e;
        logConfig.f42263c = this.f42231p.f42396c;
        logConfig.f42262b = this.f42231p.f42395b;
        logConfig.f42261a = this.f42231p.f42394a;
        logConfig.f42264d = this.f42231p.f42397d;
        return logConfig;
    }

    @Deprecated
    public String[] getPinArray() {
        return getPinArray4DefHost();
    }

    public String[] getPinArray(String str) {
        List<String> pinList = getPinList(str);
        return (String[]) pinList.toArray(new String[pinList.size()]);
    }

    public String[] getPinArray4DefHost() {
        return a(this.f42221f);
    }

    public PinCheckMode getPinCheckMode() {
        return this.f42220e;
    }

    public String getPinDefHost() {
        return this.f42222g.getPinDefHostPattern();
    }

    public List<String> getPinList(String str) {
        return this.f42220e == PinCheckMode.ENABLE ? this.f42222g.getPins(str) : this.f42220e == PinCheckMode.ERROR ? this.f42222g.getErrorPins(str) : Collections.EMPTY_LIST;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.PinProvider
    public Set<String> getPinSet(String str) {
        List<String> pinList = getPinList(str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(pinList);
        return hashSet;
    }

    public List<String> getPins4DefHost() {
        return this.f42222g.getPinList4HostPattern(this.f42221f);
    }

    public Proxy getProxy() {
        return this.f42234s;
    }

    public int getReadTimeOut() {
        return this.f42226k;
    }

    public int getReadTimeOutInSeconds() {
        return this.f42226k / 1000;
    }

    public TypeAdapter getTypeAdaptor() {
        return this.f42233r;
    }

    public int getWriteTimeOut() {
        return this.f42227l;
    }

    public int getWriteTimeOutInSeconds() {
        return this.f42227l / 1000;
    }

    public boolean isCertVerify() {
        return this.f42218c;
    }

    public boolean isUsePinProvider() {
        return this.f42219d;
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.PinProvider
    public void onPinVerifyFailed(String str, List<String> list) {
        PinVerifyListener pinVerifyListener = this.f42223h;
        if (pinVerifyListener != null) {
            pinVerifyListener.onPinVerifyFailed(str, list);
        }
    }

    public PinManager pinManager() {
        return this.f42222g;
    }

    public HttpConfig setBaseUrl(String str) {
        this.f42224i = str;
        return this;
    }

    public HttpConfig setCallTimeoutInSeconds(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f42228m = i10;
        return this;
    }

    public HttpConfig setCertVerify(boolean z10) {
        this.f42218c = z10;
        return this;
    }

    public HttpConfig setCommonHeaders(Map<String, ?> map) {
        return a(map, true);
    }

    public HttpConfig setCommonParams(Map<String, ?> map) {
        return b(map, true);
    }

    public HttpConfig setCookie(WeCookie weCookie) {
        this.f42232q = weCookie;
        return this;
    }

    public HttpConfig setDns(WeDns weDns) {
        this.B = weDns;
        return this;
    }

    public HttpConfig setEventListener(EventListener eventListener) {
        this.f42236u = eventListener;
        return this;
    }

    public HttpConfig setIpStrategy(WeConfig.IpStrategy ipStrategy) {
        this.C = ipStrategy;
        return this;
    }

    public HttpConfig setLogBuilder(WeLog.Builder builder) {
        if (builder != null) {
            this.f42231p = builder;
        }
        return this;
    }

    public HttpConfig setPinCheckMode(PinCheckMode pinCheckMode) {
        if (this.f42220e != null) {
            this.f42220e = pinCheckMode;
        }
        return this;
    }

    public HttpConfig setPinDefHost(String str) {
        this.f42221f = str;
        this.f42222g.setPinDefHostPattern(str);
        return this;
    }

    public void setPinVerifyListener(PinVerifyListener pinVerifyListener) {
        this.f42223h = pinVerifyListener;
    }

    public HttpConfig setProxy(Proxy proxy) {
        this.f42234s = proxy;
        return this;
    }

    public HttpConfig setRetryCount(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f42229n = i10;
        return this;
    }

    public HttpConfig setRetryStrategy(RetryInterceptor.RetryStrategy retryStrategy) {
        this.f42230o = retryStrategy;
        return this;
    }

    public void setToWeHttp() {
        a(WeHttp.config(), this.f42221f, null);
    }

    public HttpConfig setTypeAdaptor(TypeAdapter typeAdapter) {
        this.f42233r = typeAdapter;
        return this;
    }

    public HttpConfig timeoutInSeconds(int i10, int i11, int i12) {
        if (i10 <= 0) {
            i10 = 10;
        }
        if (i11 <= 0) {
            i11 = 10;
        }
        if (i12 <= 0) {
            i12 = 10;
        }
        this.f42225j = i10 * 1000;
        this.f42226k = i11 * 1000;
        this.f42227l = i12 * 1000;
        return this;
    }

    public HttpConfig usePinProvider(boolean z10) {
        this.f42219d = z10;
        return this;
    }
}
