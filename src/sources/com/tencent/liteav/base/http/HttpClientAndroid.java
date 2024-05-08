package com.tencent.liteav.base.http;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.security.realidentity.build.cs;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLException;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpClientAndroid {
    private static final int ERROR_CODE_INVALID_REQUEST = 0;
    private static final String HTTPS_PREFIX = "https://";
    private static final String HTTP_PREFIX = "http://";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final int READ_STREAM_SIZE = 8192;
    private static final int REDIRECT_REQUEST_MAX = 3;
    private static final String TAG = "HttpClientAndroid";
    private static c mCustomHttpDNSCallback;
    private static boolean mEnableCustomHttpDNS;
    private static final Object mLock = new Object();
    private HttpURLConnection mConnection;
    private b mHttpConfig;
    private final Handler mHttpHandler;
    private String mLastRequestURL;
    private long mNativeHttpClientAndroidJni;
    private final ConcurrentHashMap<Long, e> mRunningRequestMap = new ConcurrentHashMap<>();
    private final Object mLocker = new Object();
    private volatile d mInternalState = d.NONE;
    private long mTotalReadBytes = 0;
    private long mStartReadTime = 0;
    private boolean mPausedRepeatDownloading = false;
    private h mRepeatDownloadingStatusCode = h.kUnknownError;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends Authenticator {

        /* renamed from: a, reason: collision with root package name */
        public String f42764a;

        /* renamed from: b, reason: collision with root package name */
        public String f42765b;

        public a(String str, String str2) {
            this.f42764a = str;
            this.f42765b = str2;
        }

        @Override // java.net.Authenticator
        public final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.f42764a, this.f42765b.toCharArray());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f42766a;

        /* renamed from: b, reason: collision with root package name */
        public int f42767b;

        /* renamed from: c, reason: collision with root package name */
        public int f42768c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f42769d;

        /* renamed from: e, reason: collision with root package name */
        public int f42770e;

        /* renamed from: f, reason: collision with root package name */
        public int f42771f;

        /* renamed from: g, reason: collision with root package name */
        public String f42772g;

        /* renamed from: h, reason: collision with root package name */
        public String f42773h;

        /* renamed from: i, reason: collision with root package name */
        public String f42774i;

        public b(int i10, int i11, int i12, boolean z10, int i13, int i14, String str, String str2, String str3) {
            this.f42766a = i10;
            this.f42767b = i11;
            this.f42768c = i12;
            this.f42769d = z10;
            this.f42770e = i13;
            this.f42771f = i14;
            this.f42772g = str;
            this.f42773h = str2;
            this.f42774i = str3;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void a(String str, List<String> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum d {
        NONE,
        RUNNING_REPEAT,
        RUNNING_ONCE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public long f42779a;

        /* renamed from: b, reason: collision with root package name */
        public String f42780b;

        /* renamed from: c, reason: collision with root package name */
        public String f42781c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f42782d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f42783e;

        /* renamed from: f, reason: collision with root package name */
        public int f42784f = 0;

        /* renamed from: g, reason: collision with root package name */
        public String f42785g = "";

        public e(String str, String str2, byte[] bArr, Map<String, String> map) {
            this.f42780b = str;
            this.f42781c = str2;
            this.f42782d = bArr;
            this.f42783e = map;
        }

        public final boolean a() {
            if (TextUtils.isEmpty(this.f42780b)) {
                return false;
            }
            return this.f42780b.startsWith(HttpClientAndroid.HTTP_PREFIX) || this.f42780b.startsWith(HttpClientAndroid.HTTPS_PREFIX);
        }

        public final boolean b() {
            byte[] bArr = this.f42782d;
            return bArr != null && bArr.length > 0;
        }

        public final boolean c() {
            return "POST".equals(d()) || HttpClientAndroid.METHOD_PUT.equals(d());
        }

        public final String d() {
            return TextUtils.isEmpty(this.f42781c) ? "" : "POST".equalsIgnoreCase(this.f42781c) ? "POST" : "GET".equalsIgnoreCase(this.f42781c) ? "GET" : HttpClientAndroid.METHOD_PUT.equalsIgnoreCase(this.f42781c) ? HttpClientAndroid.METHOD_PUT : "";
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("Request{requestId=");
            sb2.append(this.f42779a);
            sb2.append(", url='");
            sb2.append(this.f42780b);
            sb2.append('\'');
            sb2.append(", method='");
            sb2.append(this.f42781c);
            sb2.append('\'');
            sb2.append(", body.size=");
            sb2.append(b() ? this.f42782d.length : 0);
            sb2.append(", headers=");
            sb2.append((Object) this.f42783e);
            sb2.append('}');
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f {

        /* renamed from: c, reason: collision with root package name */
        public ByteBuffer f42788c;

        /* renamed from: a, reason: collision with root package name */
        public h f42786a = h.kUnknownError;

        /* renamed from: b, reason: collision with root package name */
        public String f42787b = "";

        /* renamed from: d, reason: collision with root package name */
        public int f42789d = 0;

        /* renamed from: e, reason: collision with root package name */
        public String f42790e = "";

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f42791f = null;

        /* renamed from: g, reason: collision with root package name */
        public int f42792g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f42793h = 0;

        /* renamed from: i, reason: collision with root package name */
        public String f42794i = "";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum g {
        CONNECTED(0),
        DISCONNECTED(1),
        FINISHED(2);

        public int nativeValue;

        g(int i10) {
            this.nativeValue = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum h {
        kHTTP200OK(200),
        kHTTP204NoContent(204),
        kHTTP206PartialContent(206),
        kHTTP301MovedPermanently(301),
        kHTTP302Found(302),
        kHTTP303SeeOther(303),
        kHTTP304NotModified(304),
        kHTTP307TemporaryRedirect(307),
        kHTTP308PermanentRedirect(308),
        kHTTP403Forbidden(403),
        kHTTP404NotFound(404),
        kHTTP405MethodNotAllowed(405),
        kHTTP503ServiceUnavailable(503),
        kSystemFileOpenFailed(1001),
        kSystemFileWriteFailed(1002),
        kSystemUnknownHost(1003),
        kSystemConnectHostFailed(1004),
        kSystemCreateSocketFailed(1005),
        kSystemNetworkDisabled(1006),
        kSystemConnectTimeout(1007),
        kSystemConnectRefused(1008),
        kSystemProtocolError(1009),
        kSystemSSLError(1010),
        kUnknownError(1999);

        public final int nativeValue;

        h(int i10) {
            this.nativeValue = i10;
        }
    }

    @CalledByNative
    public HttpClientAndroid(int i10, int i11, int i12, boolean z10, int i13, int i14, String str, String str2, String str3, long j10) {
        this.mHttpConfig = new b(i10, i11, i12, z10, i13, i14, str, str2, str3);
        this.mNativeHttpClientAndroidJni = j10;
        HandlerThread handlerThread = new HandlerThread("HttpClient_" + hashCode());
        handlerThread.start();
        LiteavLog.i(TAG, "Create http client(" + hashCode() + "). [ThreadName:" + handlerThread.getName() + "][ThreadId:" + handlerThread.getId() + "]");
        this.mHttpHandler = new Handler(handlerThread.getLooper());
    }

    private boolean checkNativeValid() {
        boolean z10;
        synchronized (this.mLocker) {
            z10 = this.mNativeHttpClientAndroidJni != -1;
        }
        return z10;
    }

    private boolean checkRequestValid(long j10) {
        return this.mRunningRequestMap.containsKey(Long.valueOf(j10));
    }

    private void closeConnectionSafely(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private HttpURLConnection createConnection(e eVar) throws Exception {
        Proxy proxy;
        HttpURLConnection createConnectionUseCustomHttpDNS;
        if (!TextUtils.isEmpty(this.mHttpConfig.f42772g) || this.mHttpConfig.f42771f <= 0) {
            proxy = null;
        } else {
            Proxy.Type type = Proxy.Type.SOCKS;
            b bVar = this.mHttpConfig;
            proxy = new Proxy(type, new InetSocketAddress(bVar.f42772g, bVar.f42771f));
            b bVar2 = this.mHttpConfig;
            Authenticator.setDefault(new a(bVar2.f42773h, bVar2.f42774i));
        }
        String replace = eVar.f42780b.replace(" ", "%20");
        URL url = new URL(replace);
        if (proxy != null) {
            createConnectionUseCustomHttpDNS = (HttpURLConnection) url.openConnection(proxy);
        } else {
            if (verifyCustomHttpDNS(url.getHost())) {
                try {
                    createConnectionUseCustomHttpDNS = createConnectionUseCustomHttpDNS(replace, url.getHost());
                } catch (Exception e2) {
                    LiteavLog.w(TAG, "(" + hashCode() + ")createConnectionUseCustomHttpDNS failed. error: " + Log.getStackTraceString(e2));
                }
            }
            createConnectionUseCustomHttpDNS = (HttpURLConnection) url.openConnection();
        }
        createConnectionUseCustomHttpDNS.setInstanceFollowRedirects(false);
        createConnectionUseCustomHttpDNS.setConnectTimeout(this.mHttpConfig.f42766a);
        createConnectionUseCustomHttpDNS.setReadTimeout(this.mHttpConfig.f42767b);
        createConnectionUseCustomHttpDNS.setRequestProperty("Accept-Encoding", "identity");
        createConnectionUseCustomHttpDNS.setRequestMethod(eVar.d());
        if (eVar.c()) {
            createConnectionUseCustomHttpDNS.setDoOutput(true);
        }
        if (this.mHttpConfig.f42769d) {
            createConnectionUseCustomHttpDNS.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
        } else {
            createConnectionUseCustomHttpDNS.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "close");
        }
        Map<String, String> map = eVar.f42783e;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : eVar.f42783e.entrySet()) {
                createConnectionUseCustomHttpDNS.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return createConnectionUseCustomHttpDNS;
    }

    private HttpURLConnection createConnectionUseCustomHttpDNS(String str, String str2) throws Exception {
        String replaceFirst;
        String parseAddressUseCustomHttpDns = parseAddressUseCustomHttpDns(str2);
        if (TextUtils.isEmpty(parseAddressUseCustomHttpDns)) {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        InetAddress byName = InetAddress.getByName(parseAddressUseCustomHttpDns);
        if (byName instanceof Inet4Address) {
            replaceFirst = str.replaceFirst(str2, parseAddressUseCustomHttpDns);
        } else if (byName instanceof Inet6Address) {
            replaceFirst = str.replaceFirst(str2, "[" + parseAddressUseCustomHttpDns + "]");
        } else {
            return (HttpURLConnection) new URL(str).openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(replaceFirst).openConnection();
        httpURLConnection.setRequestProperty(cs.U, str2);
        com.tencent.liteav.base.util.g.a(httpURLConnection, str2);
        LiteavLog.i(TAG, "(" + hashCode() + ")create http conn use httpDns, original url: " + str + " , new url: " + replaceFirst);
        return httpURLConnection;
    }

    private void doCleanById(long j10, boolean z10) {
        synchronized (this.mLocker) {
            this.mRunningRequestMap.remove(Long.valueOf(j10));
            if (this.mRunningRequestMap.size() == 0) {
                this.mInternalState = d.NONE;
            }
        }
        if (z10) {
            closeConnectionSafely(this.mConnection);
            this.mConnection = null;
        }
    }

    private boolean doOnCallback(g gVar, long j10, f fVar) {
        synchronized (this.mLocker) {
            if (checkNativeValid() && checkRequestValid(j10) && fVar != null) {
                return nativeOnCallback(this.mNativeHttpClientAndroidJni, d.RUNNING_REPEAT == this.mInternalState, gVar.nativeValue, j10, fVar.f42786a.nativeValue, fVar.f42787b, fVar.f42792g, fVar.f42788c, fVar.f42790e, fVar.f42791f, fVar.f42789d, fVar.f42793h, fVar.f42794i);
            }
            return false;
        }
    }

    private void doReadData(long j10, f fVar) {
        boolean z10;
        long elapsedRealtime;
        int read;
        if (!checkRequestValid(j10)) {
            LiteavLog.w(TAG, "(" + hashCode() + ")Do read data failed. Invalid request id. id:" + j10);
            return;
        }
        try {
            InputStream inputStream = this.mConnection.getInputStream();
            synchronized (this.mLocker) {
                z10 = this.mInternalState == d.RUNNING_ONCE;
            }
            long j11 = 0;
            if (z10) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                do {
                    try {
                        read = inputStream.read(bArr);
                        if (read > 0) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Catch error when reading.");
                        fVar.f42786a = getStatusCode(e2);
                        fVar.f42787b = e2.toString();
                        doOnCallback(g.DISCONNECTED, j10, fVar);
                        doCleanById(j10, true);
                        return;
                    }
                } while (read > 0 && checkRequestValid(j10));
                int size = byteArrayOutputStream.size();
                if (size > 0) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size);
                    fVar.f42788c = allocateDirect;
                    allocateDirect.put(byteArrayOutputStream.toByteArray(), 0, size);
                    fVar.f42789d = size;
                }
                elapsedRealtime = 0;
            } else {
                byte[] bArr2 = new byte[8192];
                try {
                    int read2 = inputStream.read(bArr2);
                    this.mTotalReadBytes += read2;
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    if (read2 > 0) {
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(read2);
                        fVar.f42788c = allocateDirect2;
                        allocateDirect2.put(bArr2, 0, read2);
                        fVar.f42789d = read2;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Catch error when reading.");
                    fVar.f42786a = getStatusCode(e10);
                    fVar.f42787b = e10.toString();
                    doOnCallback(g.DISCONNECTED, j10, fVar);
                    doCleanById(j10, true);
                    return;
                }
            }
            if (fVar.f42789d == 0 && !z10) {
                LiteavLog.w(TAG, "(" + hashCode() + ")Do read data failed. Rsp size is 0.");
                doOnCallback(g.FINISHED, j10, fVar);
                doCleanById(j10, true);
                return;
            }
            if (z10) {
                doOnCallback(g.FINISHED, j10, fVar);
                doCleanById(j10, !this.mHttpConfig.f42769d);
                return;
            }
            boolean doOnCallback = doOnCallback(g.CONNECTED, j10, fVar);
            this.mPausedRepeatDownloading = doOnCallback;
            this.mRepeatDownloadingStatusCode = fVar.f42786a;
            if (doOnCallback) {
                return;
            }
            int i10 = this.mHttpConfig.f42770e;
            if (i10 > 0) {
                long j12 = this.mStartReadTime;
                long j13 = elapsedRealtime - j12 == 0 ? 1L : elapsedRealtime - j12;
                long j14 = this.mTotalReadBytes;
                if (j14 / j13 > i10 / 1000) {
                    j11 = ((j14 * 1000) / i10) - j13;
                }
            }
            this.mHttpHandler.postDelayed(com.tencent.liteav.base.http.f.a(this, fVar, j10), j11);
        } catch (Exception e11) {
            e11.printStackTrace();
            LiteavLog.e(TAG, "(" + hashCode() + ")Do read data failed. Fail to get InputStream.");
            fVar.f42786a = getStatusCode(e11);
            fVar.f42787b = e11.toString();
            doOnCallback(g.DISCONNECTED, j10, fVar);
            doCleanById(j10, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequest(e eVar) {
        f fVar = null;
        for (int i10 = 0; i10 < 4; i10++) {
            fVar = internalRequest(eVar);
            if (fVar == null) {
                return;
            }
            h hVar = fVar.f42786a;
            if (hVar != h.kHTTP301MovedPermanently && hVar != h.kHTTP302Found) {
                break;
            }
            String headerField = this.mConnection.getHeaderField("Location");
            eVar.f42780b = headerField;
            eVar.f42784f++;
            eVar.f42785g = headerField;
        }
        this.mTotalReadBytes = 0L;
        this.mStartReadTime = SystemClock.elapsedRealtime();
        doReadData(eVar.f42779a, fVar);
    }

    public static void enableCustomHttpDNS(boolean z10, c cVar) {
        synchronized (mLock) {
            mEnableCustomHttpDNS = z10;
            mCustomHttpDNSCallback = cVar;
        }
    }

    @CalledByNative
    public static HashMap getJavaHashMap(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            if (strArr.length != strArr2.length) {
                LiteavLog.w(TAG, "Invalid parameter, keys and values do not match.");
                return new HashMap();
            }
            HashMap hashMap = new HashMap();
            for (int i10 = 0; i10 < strArr.length; i10++) {
                hashMap.put(strArr[i10], strArr2[i10]);
            }
            return hashMap;
        }
        return new HashMap();
    }

    @CalledByNative
    public static String[] getMapKeys(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        Set<String> h10 = map.h();
        return (String[]) h10.toArray(new String[h10.size()]);
    }

    @CalledByNative
    public static String[] getMapValue(Map<String, String> map, String[] strArr) {
        if (map == null || map.isEmpty() || strArr == null || strArr.length == 0) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = map.get(strArr[i10]);
        }
        return strArr2;
    }

    private Map<String, String> getResponseHeaders(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return hashMap;
    }

    private h getStatusCode(int i10) {
        h hVar = h.kUnknownError;
        if (i10 == 200) {
            return h.kHTTP200OK;
        }
        if (i10 == 204) {
            return h.kHTTP204NoContent;
        }
        if (i10 == 206) {
            return h.kHTTP206PartialContent;
        }
        if (i10 == 301) {
            return h.kHTTP301MovedPermanently;
        }
        if (i10 == 302) {
            return h.kHTTP302Found;
        }
        if (i10 == 303) {
            return h.kHTTP303SeeOther;
        }
        if (i10 == 304) {
            return h.kHTTP304NotModified;
        }
        if (i10 == 307) {
            return h.kHTTP307TemporaryRedirect;
        }
        if (i10 == 308) {
            return h.kHTTP308PermanentRedirect;
        }
        if (i10 == 403) {
            return h.kHTTP403Forbidden;
        }
        if (i10 == 404) {
            return h.kHTTP404NotFound;
        }
        if (i10 == 405) {
            return h.kHTTP405MethodNotAllowed;
        }
        if (i10 == 503) {
            return h.kHTTP503ServiceUnavailable;
        }
        Log.w(TAG, "(" + hashCode() + ")Failed to convert status code：", Integer.valueOf(i10));
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.liteav.base.http.HttpClientAndroid.f internalRequest(com.tencent.liteav.base.http.HttpClientAndroid.e r8) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.http.HttpClientAndroid.internalRequest(com.tencent.liteav.base.http.HttpClientAndroid$e):com.tencent.liteav.base.http.HttpClientAndroid$f");
    }

    public static /* synthetic */ void lambda$cancelAll$1(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
    }

    public static /* synthetic */ void lambda$destroy$4(HttpClientAndroid httpClientAndroid) {
        httpClientAndroid.closeConnectionSafely(httpClientAndroid.mConnection);
        httpClientAndroid.mConnection = null;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
            httpClientAndroid.mHttpHandler.getLooper().quitSafely();
        } else {
            httpClientAndroid.mHttpHandler.getLooper().quit();
        }
    }

    public static /* synthetic */ void lambda$doReadData$5(HttpClientAndroid httpClientAndroid, f fVar, long j10) {
        f fVar2 = new f();
        fVar2.f42786a = fVar.f42786a;
        httpClientAndroid.doReadData(j10, fVar2);
    }

    public static /* synthetic */ void lambda$resumeRepeatDownload$2(HttpClientAndroid httpClientAndroid, Long l10) {
        f fVar = new f();
        fVar.f42786a = httpClientAndroid.mRepeatDownloadingStatusCode;
        httpClientAndroid.doReadData(l10.longValue(), fVar);
    }

    public static /* synthetic */ void lambda$resumeRepeatDownload$3(HttpClientAndroid httpClientAndroid, long j10) {
        f fVar = new f();
        fVar.f42786a = httpClientAndroid.mRepeatDownloadingStatusCode;
        httpClientAndroid.doReadData(j10, fVar);
    }

    private static native boolean nativeOnCallback(long j10, boolean z10, int i10, long j11, int i11, String str, int i12, ByteBuffer byteBuffer, String str2, Map map, int i13, int i14, String str3);

    /* JADX WARN: Multi-variable type inference failed */
    private String parseAddressUseCustomHttpDns(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        synchronized (mLock) {
            c cVar = mCustomHttpDNSCallback;
            if (cVar != null) {
                cVar.a(str, arrayList);
            }
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        String str2 = (String) arrayList.get(0);
        LiteavLog.i(TAG, "(" + hashCode() + ")parse host: " + str + " and return ipAddress: " + str2 + " ,costTime: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return str2;
    }

    private String parseHostAddress(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Exception unused) {
            LiteavLog.w(TAG, "(" + hashCode() + ")Parse host error. host:" + str);
            return "";
        }
    }

    private boolean verifyCustomHttpDNS(String str) {
        synchronized (mLock) {
            if (mEnableCustomHttpDNS && mCustomHttpDNSCallback != null) {
                if (com.tencent.liteav.base.util.g.a(str) || com.tencent.liteav.base.util.g.b(str)) {
                    return false;
                }
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property == null || property2 == null) {
                    return true;
                }
                LiteavLog.w(TAG, "(" + hashCode() + ")local proxy is on, don't use httpdns. proxyHost=" + property + " ,proxyPort=" + property2);
                return false;
            }
            return false;
        }
    }

    @CalledByNative
    public void cancel(long j10) {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel request failed. Invalid native handle.");
                return;
            }
            if (this.mRunningRequestMap.size() == 0) {
                return;
            }
            LiteavLog.i(TAG, "(" + hashCode() + ")Cancel request. request:" + ((Object) this.mRunningRequestMap.remove(Long.valueOf(j10))));
            if (this.mRunningRequestMap.size() == 0) {
                this.mInternalState = d.NONE;
            }
        }
    }

    @CalledByNative
    public void cancelAll() {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel all request failed. Invalid native handle.");
                return;
            }
            d dVar = this.mInternalState;
            d dVar2 = d.NONE;
            if (dVar == dVar2) {
                return;
            }
            this.mInternalState = dVar2;
            LiteavLog.i(TAG, "(" + hashCode() + ")Cancel all. size:" + this.mRunningRequestMap.size());
            this.mRunningRequestMap.clear();
            this.mHttpHandler.post(com.tencent.liteav.base.http.b.a(this));
        }
    }

    @CalledByNative
    public void destroy() {
        synchronized (this.mLocker) {
            this.mRunningRequestMap.clear();
            this.mNativeHttpClientAndroidJni = -1L;
            this.mHttpHandler.post(com.tencent.liteav.base.http.e.a(this));
        }
    }

    @CalledByNative
    public void resumeRepeatDownload(long j10) {
        synchronized (this.mLocker) {
            if (!checkNativeValid()) {
                LiteavLog.e(TAG, "(" + hashCode() + ")Cancel request failed. Invalid native handle.");
                return;
            }
            if (this.mRunningRequestMap.size() == 0) {
                return;
            }
            if (this.mInternalState == d.RUNNING_REPEAT && this.mPausedRepeatDownloading) {
                this.mPausedRepeatDownloading = false;
                if (j10 == 0) {
                    Iterator<Long> iterator2 = this.mRunningRequestMap.h().iterator2();
                    while (iterator2.hasNext()) {
                        this.mHttpHandler.post(com.tencent.liteav.base.http.c.a(this, iterator2.next()));
                    }
                } else if (checkRequestValid(j10)) {
                    if (this.mRunningRequestMap.get(Long.valueOf(j10)) == null) {
                    } else {
                        this.mHttpHandler.post(com.tencent.liteav.base.http.d.a(this, j10));
                    }
                }
            }
        }
    }

    @CalledByNative
    public long send(long j10, String str, String str2, byte[] bArr, Map<String, String> map, boolean z10) {
        if (!checkNativeValid()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid native handle.");
            return 0L;
        }
        e eVar = new e(str, str2, bArr, map);
        if (!eVar.a()) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid request url(" + eVar.f42780b + ").");
            return 0L;
        }
        boolean z11 = true;
        if (!(!TextUtils.isEmpty(eVar.d()))) {
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Request method(" + eVar.f42781c + ") is not supported.");
            return 0L;
        }
        synchronized (this.mLocker) {
            if (this.mInternalState == d.NONE) {
                this.mInternalState = z10 ? d.RUNNING_REPEAT : d.RUNNING_ONCE;
            } else if (this.mInternalState != d.RUNNING_ONCE) {
                z11 = false;
            }
            if (z11) {
                eVar.f42779a = j10;
                this.mRunningRequestMap.put(Long.valueOf(j10), eVar);
                this.mHttpHandler.post(com.tencent.liteav.base.http.a.a(this, eVar));
                return eVar.f42779a;
            }
            LiteavLog.e(TAG, "(" + hashCode() + ")Send request failed. Invalid state:" + ((Object) this.mInternalState));
            return 0L;
        }
    }

    @CalledByNative
    public void updateConfig(final int i10, final int i11, final int i12, final boolean z10, final int i13, final int i14, final String str, final String str2, final String str3, long j10) {
        this.mHttpHandler.post(new Runnable() { // from class: com.tencent.liteav.base.http.HttpClientAndroid.1
            @Override // java.lang.Runnable
            public final void run() {
                HttpClientAndroid.this.mHttpConfig = new b(i10, i11, i12, z10, i13, i14, str, str2, str3);
                if (i13 > 0) {
                    HttpClientAndroid.this.mTotalReadBytes = 0L;
                    HttpClientAndroid.this.mStartReadTime = SystemClock.elapsedRealtime();
                }
            }
        });
    }

    private h getStatusCode(Exception exc) {
        h hVar = h.kUnknownError;
        if (exc instanceof FileNotFoundException) {
            return h.kSystemFileOpenFailed;
        }
        if (exc instanceof EOFException) {
            return h.kSystemFileWriteFailed;
        }
        if (exc instanceof UnknownHostException) {
            return h.kSystemUnknownHost;
        }
        if (exc instanceof NoRouteToHostException) {
            return h.kSystemConnectHostFailed;
        }
        if (!(exc instanceof SocketException) && !(exc instanceof MalformedURLException)) {
            if (exc instanceof SocketTimeoutException) {
                return h.kSystemConnectTimeout;
            }
            if (exc instanceof ConnectException) {
                return h.kSystemConnectRefused;
            }
            if (exc instanceof ProtocolException) {
                return h.kSystemProtocolError;
            }
            if (exc instanceof SSLException) {
                return h.kSystemSSLError;
            }
            Log.w(TAG, "(" + hashCode() + ")Failed to convert status code, exception：", exc.toString());
            return hVar;
        }
        return h.kSystemCreateSocketFailed;
    }
}
