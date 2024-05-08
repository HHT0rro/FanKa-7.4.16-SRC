package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner;
import com.tencent.cloud.huiyansdkface.okhttp3.Credentials;
import com.tencent.cloud.huiyansdkface.okhttp3.Dispatcher;
import com.tencent.cloud.huiyansdkface.okhttp3.Dns;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.wehttp2.MockInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.RetryInterceptor;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeConfig {

    /* renamed from: a, reason: collision with root package name */
    private static int f42316a = -1;
    private KeyManagerFactory A;
    private WeLog.ILogTag B;
    private Dispatcher C;

    /* renamed from: b, reason: collision with root package name */
    private volatile OkHttpClient f42317b;

    /* renamed from: c, reason: collision with root package name */
    private OkHttpClient.Builder f42318c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42319d;

    /* renamed from: e, reason: collision with root package name */
    private WeConfigLoader f42320e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f42321f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f42322g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f42323h;

    /* renamed from: i, reason: collision with root package name */
    private Object f42324i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f42325j;

    /* renamed from: k, reason: collision with root package name */
    private volatile String f42326k;

    /* renamed from: l, reason: collision with root package name */
    private List<Pin> f42327l;

    /* renamed from: m, reason: collision with root package name */
    private volatile PinProvider f42328m;

    /* renamed from: n, reason: collision with root package name */
    private volatile TypeAdapter f42329n;

    /* renamed from: o, reason: collision with root package name */
    private volatile WeCookie f42330o;

    /* renamed from: p, reason: collision with root package name */
    private volatile WeLog f42331p;

    /* renamed from: q, reason: collision with root package name */
    private volatile WeCookieLog f42332q;

    /* renamed from: r, reason: collision with root package name */
    private volatile MockInterceptor f42333r;

    /* renamed from: s, reason: collision with root package name */
    private volatile RetryInterceptor f42334s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f42335t;

    /* renamed from: u, reason: collision with root package name */
    private volatile IpStrategy f42336u;

    /* renamed from: v, reason: collision with root package name */
    private volatile WeDns f42337v;

    /* renamed from: w, reason: collision with root package name */
    private Context f42338w;

    /* renamed from: x, reason: collision with root package name */
    private String f42339x;

    /* renamed from: y, reason: collision with root package name */
    private String f42340y;

    /* renamed from: z, reason: collision with root package name */
    private String f42341z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum IpStrategy {
        DNS_ORDER,
        IPV4_FIRST,
        IPV6_FIRST
    }

    public WeConfig() {
        this.f42319d = false;
        this.f42322g = new HashMap();
        this.f42323h = new HashMap();
        this.f42324i = new Object();
        this.f42325j = false;
        this.f42327l = new ArrayList();
        this.f42335t = false;
        this.f42336u = IpStrategy.DNS_ORDER;
        this.B = new WeLog.ILogTag() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.ILogTag
            public String tag(HttpUrl httpUrl, Object obj) {
                String str;
                if (obj != null) {
                    return obj.toString();
                }
                List<String> pathSegments = httpUrl.pathSegments();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[");
                if (pathSegments == null || pathSegments.size() <= 0) {
                    str = HiAnalyticsConstant.Direction.REQUEST + WeConfig.a();
                } else {
                    str = pathSegments.get(pathSegments.size() - 1);
                }
                sb2.append(str);
                sb2.append("] ");
                return sb2.toString();
            }
        };
    }

    public WeConfig(Context context, String str) {
        this.f42319d = false;
        this.f42322g = new HashMap();
        this.f42323h = new HashMap();
        this.f42324i = new Object();
        this.f42325j = false;
        this.f42327l = new ArrayList();
        this.f42335t = false;
        this.f42336u = IpStrategy.DNS_ORDER;
        this.B = new WeLog.ILogTag() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.ILogTag
            public String tag(HttpUrl httpUrl, Object obj) {
                String str2;
                if (obj != null) {
                    return obj.toString();
                }
                List<String> pathSegments = httpUrl.pathSegments();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[");
                if (pathSegments == null || pathSegments.size() <= 0) {
                    str2 = HiAnalyticsConstant.Direction.REQUEST + WeConfig.a();
                } else {
                    str2 = pathSegments.get(pathSegments.size() - 1);
                }
                sb2.append(str2);
                sb2.append("] ");
                return sb2.toString();
            }
        };
        Context context2 = context == null ? ContextHelper.getContext() : context.getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("savedConfigName is empty");
        }
        if (context2 != null) {
            this.f42338w = context2;
            WeConfigLoader weConfigLoader = new WeConfigLoader(context2, this, str);
            this.f42320e = weConfigLoader;
            weConfigLoader.loadOnce();
        }
    }

    public WeConfig(WeConfigLoader weConfigLoader) {
        this.f42319d = false;
        this.f42322g = new HashMap();
        this.f42323h = new HashMap();
        this.f42324i = new Object();
        this.f42325j = false;
        this.f42327l = new ArrayList();
        this.f42335t = false;
        this.f42336u = IpStrategy.DNS_ORDER;
        this.B = new WeLog.ILogTag() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.ILogTag
            public String tag(HttpUrl httpUrl, Object obj) {
                String str2;
                if (obj != null) {
                    return obj.toString();
                }
                List<String> pathSegments = httpUrl.pathSegments();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[");
                if (pathSegments == null || pathSegments.size() <= 0) {
                    str2 = HiAnalyticsConstant.Direction.REQUEST + WeConfig.a();
                } else {
                    str2 = pathSegments.get(pathSegments.size() - 1);
                }
                sb2.append(str2);
                sb2.append("] ");
                return sb2.toString();
            }
        };
        if (weConfigLoader == null) {
            throw new IllegalArgumentException("configLoader must not be null");
        }
        weConfigLoader.loadOnce();
        this.f42320e = weConfigLoader;
    }

    public WeConfig(String str) {
        this(null, str);
    }

    public static /* synthetic */ int a() {
        return b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<InetAddress> a(String str) throws UnknownHostException {
        List<InetAddress> lookup = this.f42337v != null ? this.f42337v.lookup(str) : Dns.f41397a.lookup(str);
        if (this.f42336u == null || this.f42336u == IpStrategy.DNS_ORDER || lookup == null || lookup.size() == 0) {
            return lookup;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (InetAddress inetAddress : lookup) {
            if (inetAddress instanceof Inet4Address) {
                arrayList2.add(inetAddress);
            } else {
                arrayList3.add(inetAddress);
            }
        }
        if (this.f42336u == IpStrategy.IPV4_FIRST) {
            arrayList.addAll(arrayList2);
            arrayList.addAll(arrayList3);
        } else if (this.f42336u == IpStrategy.IPV6_FIRST) {
            arrayList.addAll(arrayList3);
            arrayList.addAll(arrayList2);
        } else {
            arrayList.addAll(lookup);
        }
        return arrayList;
    }

    private void a(OkHttpClient.Builder builder, SSLSocketFactory sSLSocketFactory) {
    }

    private static synchronized int b() {
        int i10;
        synchronized (WeConfig.class) {
            i10 = f42316a + 1;
            f42316a = i10;
        }
        return i10;
    }

    private void c() {
        clientConfig().addInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.4
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                WeLog weLog = WeConfig.this.f42331p;
                return weLog == null ? chain.proceed(chain.request()) : weLog.intercept(chain);
            }
        });
        clientConfig().addNetworkInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.5
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return WeConfig.this.f42332q != null ? WeConfig.this.f42332q.intercept(chain) : chain.proceed(chain.request());
            }
        });
    }

    private void d() {
        clientConfig().addInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.6
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return WeConfig.this.f42334s != null ? WeConfig.this.f42334s.intercept(chain) : chain.proceed(chain.request());
            }
        });
    }

    private void e() {
        clientConfig().addInterceptor(new TimeoutInterceptor());
    }

    private void f() {
        clientConfig().addInterceptor(new Interceptor() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.7
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return WeConfig.this.f42333r != null ? WeConfig.this.f42333r.intercept(chain) : chain.proceed(chain.request());
            }
        });
    }

    private X509TrustManager g() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private SSLSocketFactory h() {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            KeyManagerFactory keyManagerFactory = this.A;
            if (keyManagerFactory == null && this.f42339x != null) {
                InputStream open = this.f42338w.getAssets().open(this.f42339x);
                String str = this.f42340y;
                if (str == null) {
                    str = "PKCS12";
                }
                KeyStore keyStore = KeyStore.getInstance(str);
                keyStore.load(open, this.f42341z.toCharArray());
                keyManagerFactory = KeyManagerFactory.getInstance("X509");
                keyManagerFactory.init(keyStore, this.f42341z.toCharArray());
            }
            sSLContext.init(keyManagerFactory == null ? null : keyManagerFactory.getKeyManagers(), null, null);
            return sSLContext.getSocketFactory();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public TypeAdapter adapter() {
        if (this.f42329n == null) {
            synchronized (this) {
                if (this.f42329n == null) {
                    this.f42329n = new WeTypeAdapter();
                }
            }
        }
        return this.f42329n;
    }

    public WeConfig adapter(TypeAdapter typeAdapter) {
        this.f42329n = typeAdapter;
        return this;
    }

    public WeConfig addMock(MockInterceptor.Mock... mockArr) {
        mockConfig();
        for (int length = mockArr.length - 1; length >= 0; length--) {
            this.f42333r.addMock(mockArr[length]);
        }
        return this;
    }

    public WeConfig addPin(Pin... pinArr) {
        if (pinArr != null && pinArr.length > 0) {
            synchronized (this.f42324i) {
                for (Pin pin : pinArr) {
                    if (pin != null && pin.getPattern() != null && pin.getPin() != null) {
                        this.f42327l.add(pin);
                    }
                }
            }
        }
        return this;
    }

    public WeConfig addPin4DefHost(String... strArr) {
        return addPin4Host(this.f42326k, strArr);
    }

    public WeConfig addPin4Host(String str, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return this;
        }
        if (str == null) {
            throw new IllegalArgumentException("host cannot be null");
        }
        synchronized (this.f42324i) {
            if (strArr.length == 1) {
                this.f42327l.add(new Pin(str, strArr[0]));
                return this;
            }
            this.f42327l.addAll(Pin.create(str, strArr));
            return this;
        }
    }

    public WeConfig baseUrl(String str) {
        if (str != null && !str.endsWith("/")) {
            str = str + "/";
        }
        this.f42321f = str;
        return this;
    }

    public WeConfig callTimeoutInMillis(long j10) {
        clientConfig().callTimeout(j10, TimeUnit.MILLISECONDS);
        return this;
    }

    public WeConfig clearPin4Host(String str) {
        synchronized (this.f42324i) {
            Iterator<Pin> iterator2 = this.f42327l.iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().getPattern().equals(str)) {
                    iterator2.remove();
                }
            }
        }
        return this;
    }

    public OkHttpClient client() {
        if (this.f42317b == null) {
            synchronized (this) {
                if (this.f42317b == null) {
                    clientConfig().dns(new Dns() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.2
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.Dns
                        public List<InetAddress> lookup(String str) throws UnknownHostException {
                            return WeConfig.this.a(str);
                        }
                    });
                    clientConfig().certificatePinner(new CertificatePinner.Builder().pinProvider(new CertificatePinner.CertificatePinProvider() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfig.3
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner.CertificatePinProvider
                        public Set<String> getPins(String str) {
                            return WeConfig.this.getPins(str);
                        }

                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.CertificatePinner.CertificatePinProvider
                        public void onPinVerifyFailed(String str, List<String> list) {
                            if (WeConfig.this.f42328m != null) {
                                WeConfig.this.f42328m.onPinVerifyFailed(str, list);
                            }
                        }
                    }).build());
                    e();
                    d();
                    c();
                    f();
                    if (this.f42339x != null) {
                        clientConfig().sslSocketFactory(h(), g());
                    }
                    this.f42317b = clientConfig().build();
                    WeConfigLoader weConfigLoader = this.f42320e;
                    if (weConfigLoader != null) {
                        weConfigLoader.save();
                    }
                    this.f42319d = true;
                }
            }
        }
        return this.f42317b;
    }

    public WeConfig clientCertPath(Context context, String str, String str2, String str3) {
        this.f42339x = str;
        this.f42338w = context.getApplicationContext();
        this.f42340y = str2;
        this.f42341z = str3;
        return this;
    }

    public OkHttpClient.Builder clientConfig() {
        if (this.f42318c == null) {
            this.f42318c = new OkHttpClient.Builder();
        }
        return this.f42318c;
    }

    public WeConfig clientKeyManagerFactory(KeyManagerFactory keyManagerFactory) {
        this.A = keyManagerFactory;
        return this;
    }

    public WeConfig cookie(WeCookie weCookie) {
        this.f42330o = weCookie;
        if (weCookie != null) {
            clientConfig().cookieJar(weCookie);
        }
        return this;
    }

    public WeCookie cookie() {
        return this.f42330o;
    }

    public WeConfig cookieMemory() {
        this.f42330o = new MemoryCookieJar();
        clientConfig().cookieJar(this.f42330o);
        return this;
    }

    public WeConfig cookieWebView(Context context) {
        this.f42330o = new WeWebViewCookie(context);
        clientConfig().cookieJar(this.f42330o);
        return this;
    }

    public WeConfig dispatcherConfig(int i10, int i11, Runnable runnable) {
        if (this.C == null) {
            this.C = new Dispatcher();
            clientConfig().dispatcher(this.C);
        }
        this.C.setIdleCallback(runnable);
        this.C.setMaxRequests(i10);
        this.C.setMaxRequestsPerHost(i11);
        return this;
    }

    public WeConfig dns(WeDns weDns) {
        this.f42337v = weDns;
        return this;
    }

    public String getBaseUrl() {
        return this.f42321f;
    }

    public WeConfigLoader getConfigLoader() {
        return this.f42320e;
    }

    public Map<String, String> getHeaders() {
        return this.f42322g;
    }

    public Map<String, String> getParams() {
        return this.f42323h;
    }

    public List<String> getPin4HostPattern(String str) {
        ArrayList arrayList;
        synchronized (this.f42324i) {
            arrayList = new ArrayList();
            for (Pin pin : this.f42327l) {
                if (pin.getPattern().equals(str)) {
                    arrayList.add(pin.getPin());
                }
            }
        }
        return arrayList;
    }

    public List<Pin> getPinList() {
        List<Pin> unmodifiableList;
        synchronized (this.f42324i) {
            unmodifiableList = Collections.unmodifiableList(this.f42327l);
        }
        return unmodifiableList;
    }

    public Set<String> getPins(String str) {
        Set<String> pinSet;
        if (!this.f42325j) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        if (this.f42328m != null && (pinSet = this.f42328m.getPinSet(str)) != null && pinSet.size() > 0) {
            hashSet.addAll(pinSet);
        }
        synchronized (this.f42324i) {
            for (Pin pin : this.f42327l) {
                if (pin.match(str)) {
                    hashSet.add(pin.getPin());
                }
            }
        }
        return hashSet;
    }

    public String getUrl(String str) {
        if (str == null) {
            return this.f42321f;
        }
        String trim = str.trim();
        if (trim.startsWith("https://") || trim.startsWith("http://")) {
            return trim;
        }
        if (trim.startsWith("/")) {
            trim = trim.substring(1);
        }
        return this.f42321f + trim;
    }

    public WeConfig header(String str, String str2) {
        this.f42322g.put(str, str2);
        return this;
    }

    public WeConfig header(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            this.f42322g.putAll(map);
        }
        return this;
    }

    public WeLog.ILogTag iLogTag() {
        return this.B;
    }

    public WeConfig ipStrategy(IpStrategy ipStrategy) {
        if (ipStrategy != null) {
            this.f42336u = ipStrategy;
        }
        return this;
    }

    public boolean isCertVerify() {
        return this.f42325j;
    }

    public WeConfig log(WeLog.Builder builder) {
        if (this.f42331p != null) {
            this.f42331p.setLevel(builder.f42398e).prettyLog(builder.f42394a).logTag(builder.f42395b).setLogger(builder.f42400g);
            this.f42331p.cutLongStr(builder.f42396c);
            this.f42331p.longStrLength(builder.f42397d);
        }
        this.f42331p = builder.build();
        this.f42332q = new WeCookieLog(this.f42331p);
        WeLog.ILogTag iLogTag = builder.f42399f;
        if (iLogTag != null) {
            this.B = iLogTag;
        }
        return this;
    }

    public WeConfig log(WeLog.Level level) {
        return log(level, WeLog.f42383a);
    }

    public WeConfig log(WeLog.Level level, WeLog.Logger logger) {
        return log(level, false, false, null, logger);
    }

    public WeConfig log(WeLog.Level level, boolean z10, boolean z11, WeLog.ILogTag iLogTag, WeLog.Logger logger) {
        if (this.f42331p != null) {
            this.f42331p.setLevel(level).prettyLog(z10).logTag(z11).setLogger(logger);
            return this;
        }
        this.f42331p = new WeLog.Builder().setLevel(level).setPrettyLog(z10).setLogWithTag(z11).setLogger(logger).build();
        if (iLogTag != null) {
            this.B = iLogTag;
        }
        return this;
    }

    public MockInterceptor mockConfig() {
        if (this.f42333r == null) {
            this.f42333r = new MockInterceptor();
        }
        return this.f42333r;
    }

    public WeConfig params(String str, String str2) {
        this.f42323h.put(str, str2);
        return this;
    }

    public WeConfig params(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.f42323h.putAll(map);
        }
        return this;
    }

    public WeConfig pinCheckHost(String str) {
        if (str == null) {
            return this;
        }
        this.f42326k = str;
        return this;
    }

    public String pinListToString() {
        return pinListToString(null);
    }

    public String pinListToString(String str) {
        String trim;
        synchronized (this.f42324i) {
            HashMap hashMap = new HashMap();
            for (Pin pin : this.f42327l) {
                String pattern = pin.getPattern();
                if (str == null || str.equals(pattern)) {
                    List list = (List) hashMap.get(pattern);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(pattern, list);
                    }
                    list.add(pin.getPin());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : hashMap.entrySet()) {
                sb2.append(((String) entry.getKey()) + ":\n");
                Iterator iterator2 = ((List) entry.getValue()).iterator2();
                while (iterator2.hasNext()) {
                    sb2.append("\t" + ((String) iterator2.next()));
                }
                sb2.append("\n");
            }
            trim = sb2.toString().trim();
        }
        return trim;
    }

    public WeConfig pinProvider(PinProvider pinProvider) {
        this.f42328m = pinProvider;
        return this;
    }

    public WeConfig proxy(String str, int i10, String str2, String str3) {
        clientConfig().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i10)));
        header("Proxy-Authorization", Credentials.basic(str2, str3));
        return this;
    }

    public WeConfig retryConfig(int i10, RetryInterceptor.RetryStrategy retryStrategy) {
        if (this.f42334s == null) {
            this.f42334s = new RetryInterceptor(i10, retryStrategy);
        }
        this.f42334s.setRetryStrategy(retryStrategy);
        this.f42334s.setMaxRetryCount(i10);
        return this;
    }

    public WeConfig retryCount(int i10) {
        return retryConfig(i10, null);
    }

    public WeConfig saveConfig() {
        WeConfigLoader weConfigLoader = this.f42320e;
        if (weConfigLoader == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        weConfigLoader.save();
        return this;
    }

    public WeConfig setCertVerify(boolean z10) {
        this.f42325j = z10;
        return this;
    }

    @Deprecated
    public WeConfig setPin4DefHost(String... strArr) {
        return addPin4DefHost(strArr);
    }

    @Deprecated
    public WeConfig setPin4Host(String str, String... strArr) {
        return addPin4Host(str, strArr);
    }

    public WeConfig supportTls12Before5(boolean z10) {
        this.f42335t = z10;
        return this;
    }

    public WeConfig timeout(long j10, long j11, long j12) {
        OkHttpClient.Builder clientConfig = clientConfig();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        clientConfig.connectTimeout(j10, timeUnit).readTimeout(j11, timeUnit).writeTimeout(j12, timeUnit);
        return this;
    }

    public WeConfig timeoutInMillis(long j10, long j11, long j12) {
        OkHttpClient.Builder clientConfig = clientConfig();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        clientConfig.connectTimeout(j10, timeUnit).readTimeout(j11, timeUnit).writeTimeout(j12, timeUnit);
        return this;
    }
}
