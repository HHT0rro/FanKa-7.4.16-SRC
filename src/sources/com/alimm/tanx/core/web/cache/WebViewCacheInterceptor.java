package com.alimm.tanx.core.web.cache;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.web.cache.config.CacheExtensionConfig;
import com.alimm.tanx.core.web.cache.utils.FileUtil;
import com.alimm.tanx.core.web.cache.utils.MimeTypeMapUtils;
import com.alimm.tanx.core.web.cache.utils.NetUtils;
import com.alimm.tanx.core.web.cache.utils.OKHttpFile;
import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class WebViewCacheInterceptor implements WebViewRequestInterceptor {
    public static final String KEY_CACHE = "WebResourceInterceptor-Key-Cache";
    public String mAssetsDir;
    public final CacheExtensionConfig mCacheExtensionConfig;
    public final File mCacheFile;
    public final long mCacheSize;
    public CacheType mCacheType;
    public final long mConnectTimeout;
    public final Context mContext;
    public final boolean mDebug;
    public Dns mDns;
    public final File mDynamicCacheFile;
    public boolean mIsSuffixMod;
    public final long mReadTimeout;
    public final ResourceInterceptor mResourceInterceptor;
    public SSLSocketFactory mSSLSocketFactory;
    public boolean mTrustAllHostname;
    public X509TrustManager mX509TrustManager;
    public final String TAG = "WebViewCacheInterceptor";
    public OkHttpClient mHttpClient = null;
    public String mOrigin = "";
    public String mReferer = "";
    public String mUserAgent = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Builder {
        public File mCacheFile;
        public final Context mContext;
        public File mDynamicCacheFile;
        public ResourceInterceptor mResourceInterceptor;
        public long mCacheSize = 104857600;
        public long mConnectTimeout = 20;
        public long mReadTimeout = 20;
        public boolean mDebug = true;
        public CacheType mCacheType = CacheType.FORCE;
        public boolean mTrustAllHostname = false;
        public SSLSocketFactory mSSLSocketFactory = null;
        public X509TrustManager mX509TrustManager = null;
        public String mAssetsDir = null;
        public boolean mIsSuffixMod = false;
        public Dns mDns = null;
        public CacheExtensionConfig mCacheExtensionConfig = new CacheExtensionConfig();

        public Builder(Context context) {
            this.mContext = context;
            this.mCacheFile = new File(context.getCacheDir().toString(), "CacheWebViewCache");
        }

        public WebViewRequestInterceptor build() {
            return new WebViewCacheInterceptor(this);
        }

        public Builder isAssetsSuffixMod(boolean z10) {
            this.mIsSuffixMod = z10;
            return this;
        }

        public Builder setAssetsDir(String str) {
            if (str != null) {
                this.mAssetsDir = str;
            }
            return this;
        }

        public Builder setCacheExtensionConfig(CacheExtensionConfig cacheExtensionConfig) {
            if (cacheExtensionConfig != null) {
                this.mCacheExtensionConfig = cacheExtensionConfig;
            }
            return this;
        }

        public Builder setCachePath(File file) {
            if (file != null) {
                this.mCacheFile = file;
            }
            return this;
        }

        public Builder setCacheSize(long j10) {
            if (j10 > 1024) {
                this.mCacheSize = j10;
            }
            return this;
        }

        public Builder setCacheType(CacheType cacheType) {
            this.mCacheType = cacheType;
            return this;
        }

        public Builder setConnectTimeoutSecond(long j10) {
            if (j10 >= 0) {
                this.mConnectTimeout = j10;
            }
            return this;
        }

        public Builder setDebug(boolean z10) {
            this.mDebug = z10;
            return this;
        }

        public void setDns(Dns dns) {
            this.mDns = dns;
        }

        public Builder setDynamicCachePath(File file) {
            if (file != null) {
                this.mDynamicCacheFile = file;
            }
            return this;
        }

        public Builder setReadTimeoutSecond(long j10) {
            if (j10 >= 0) {
                this.mReadTimeout = j10;
            }
            return this;
        }

        public void setResourceInterceptor(ResourceInterceptor resourceInterceptor) {
            this.mResourceInterceptor = resourceInterceptor;
        }

        public Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory != null && x509TrustManager != null) {
                this.mSSLSocketFactory = sSLSocketFactory;
                this.mX509TrustManager = x509TrustManager;
            }
            return this;
        }

        public Builder setTrustAllHostname() {
            this.mTrustAllHostname = true;
            return this;
        }
    }

    public WebViewCacheInterceptor(Builder builder) {
        this.mAssetsDir = null;
        this.mTrustAllHostname = false;
        this.mSSLSocketFactory = null;
        this.mX509TrustManager = null;
        this.mDns = null;
        this.mIsSuffixMod = false;
        this.mCacheExtensionConfig = builder.mCacheExtensionConfig;
        this.mCacheFile = builder.mCacheFile;
        this.mDynamicCacheFile = builder.mDynamicCacheFile;
        this.mCacheSize = builder.mCacheSize;
        this.mCacheType = builder.mCacheType;
        this.mConnectTimeout = builder.mConnectTimeout;
        this.mReadTimeout = builder.mReadTimeout;
        this.mContext = builder.mContext;
        this.mDebug = builder.mDebug;
        this.mAssetsDir = builder.mAssetsDir;
        this.mX509TrustManager = builder.mX509TrustManager;
        this.mSSLSocketFactory = builder.mSSLSocketFactory;
        this.mTrustAllHostname = builder.mTrustAllHostname;
        this.mResourceInterceptor = builder.mResourceInterceptor;
        this.mIsSuffixMod = builder.mIsSuffixMod;
        this.mDns = builder.mDns;
        initHttpClient();
        if (isEnableAssets()) {
            initAssetsLoader();
        }
    }

    private Map<String, String> buildHeaders() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.mOrigin)) {
            hashMap.put("Origin", this.mOrigin);
        }
        if (!TextUtils.isEmpty(this.mReferer)) {
            hashMap.put("Referer", this.mReferer);
        }
        if (!TextUtils.isEmpty(this.mUserAgent)) {
            hashMap.put("User-Agent", this.mUserAgent);
        }
        return hashMap;
    }

    private boolean checkUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http")) {
            return false;
        }
        ResourceInterceptor resourceInterceptor = this.mResourceInterceptor;
        if (resourceInterceptor != null && !resourceInterceptor.interceptor(str)) {
            return false;
        }
        String fileExtensionFromUrl = MimeTypeMapUtils.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl) || this.mCacheExtensionConfig.isMedia(fileExtensionFromUrl)) {
            return false;
        }
        return this.mCacheExtensionConfig.canCache(fileExtensionFromUrl);
    }

    private void initAssetsLoader() {
        AssetsLoader.getInstance().init(this.mContext).setDir(this.mAssetsDir).isAssetsSuffixMod(this.mIsSuffixMod);
    }

    private void initHttpClient() {
        X509TrustManager x509TrustManager;
        OkHttpClient.Builder cache = new OkHttpClient.Builder().cache(new Cache(this.mCacheFile, this.mCacheSize));
        long j10 = this.mConnectTimeout;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addNetworkInterceptor = cache.connectTimeout(j10, timeUnit).readTimeout(this.mReadTimeout, timeUnit).addNetworkInterceptor(new HttpCacheInterceptor());
        if (this.mTrustAllHostname) {
            addNetworkInterceptor.hostnameVerifier(new HostnameVerifier() { // from class: com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
        }
        SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
        if (sSLSocketFactory != null && (x509TrustManager = this.mX509TrustManager) != null) {
            addNetworkInterceptor.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        }
        Dns dns = this.mDns;
        if (dns != null) {
            addNetworkInterceptor.dns(dns);
        }
        this.mHttpClient = addNetworkInterceptor.build();
    }

    private boolean isEnableAssets() {
        return this.mAssetsDir != null;
    }

    private boolean isEnableDynamicCache() {
        return this.mDynamicCacheFile != null;
    }

    public void addHeader(Request.Builder builder, Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void clearCache() {
        FileUtil.deleteDirs(this.mCacheFile.getAbsolutePath(), false);
        AssetsLoader.getInstance().clear();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void enableForce(boolean z10) {
        if (z10) {
            this.mCacheType = CacheType.FORCE;
        } else {
            this.mCacheType = CacheType.NORMAL;
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public InputStream getCacheFile(String str) {
        return OKHttpFile.getCacheFile(this.mCacheFile, str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public File getCachePath() {
        return this.mCacheFile;
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void initAssetsData() {
        AssetsLoader.getInstance().initData();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public WebResourceResponse interceptRequest(WebResourceRequest webResourceRequest) {
        return interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }

    public boolean isValidUrl(String str) {
        return URLUtil.isValidUrl(str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(WebView webView, String str) {
        if (isValidUrl(str)) {
            webView.loadUrl(str);
            String url = webView.getUrl();
            this.mReferer = url;
            this.mOrigin = NetUtils.getOriginUrl(url);
            this.mUserAgent = webView.getSettings().getUserAgentString();
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public WebResourceResponse interceptRequest(String str) {
        return interceptRequest(str, buildHeaders());
    }

    private WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        InputStream resByUrl;
        File resByUrl2;
        FileInputStream fileInputStream = null;
        if (this.mCacheType == CacheType.NORMAL || !checkUrl(str)) {
            return null;
        }
        if (isEnableDynamicCache() && (resByUrl2 = DynamicCacheLoader.getInstance().getResByUrl(this.mDynamicCacheFile, str)) != null) {
            LogUtils.d("WebViewCacheInterceptor", String.format("from dynamic file: %s", str));
            String mimeTypeFromUrl = MimeTypeMapUtils.getMimeTypeFromUrl(str);
            try {
                fileInputStream = new FileInputStream(resByUrl2);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            return new WebResourceResponse(mimeTypeFromUrl, "", fileInputStream);
        }
        if (isEnableAssets() && (resByUrl = AssetsLoader.getInstance().getResByUrl(str)) != null) {
            LogUtils.d("WebViewCacheInterceptor", String.format("from assets: %s", str));
            return new WebResourceResponse(MimeTypeMapUtils.getMimeTypeFromUrl(str), "", resByUrl);
        }
        try {
            Request.Builder url = new Request.Builder().url(str);
            if (this.mCacheExtensionConfig.isHtml(MimeTypeMapUtils.getFileExtensionFromUrl(str))) {
                map.put(KEY_CACHE, this.mCacheType.ordinal() + "");
            }
            addHeader(url, map);
            if (!NetUtils.isConnected(this.mContext)) {
                url.cacheControl(CacheControl.FORCE_CACHE);
            }
            Response execute = this.mHttpClient.newCall(url.build()).execute();
            if (execute.cacheResponse() != null) {
                LogUtils.d("WebViewCacheInterceptor", String.format("from cache: %s", str));
            } else {
                LogUtils.d("WebViewCacheInterceptor", String.format("from server: %s", str));
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypeMapUtils.getMimeTypeFromUrl(str), "", execute.body().byteStream());
            if (execute.code() == 504 && !NetUtils.isConnected(this.mContext)) {
                return null;
            }
            String message = execute.message();
            if (TextUtils.isEmpty(message)) {
                message = by.f9988k;
            }
            try {
                webResourceResponse.setStatusCodeAndReasonPhrase(execute.code(), message);
                webResourceResponse.setResponseHeaders(NetUtils.multimapToSingle(execute.headers().toMultimap()));
                return webResourceResponse;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e10) {
            LogUtils.e("WebViewCacheInterceptor", e10);
            return null;
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(String str, String str2) {
        if (isValidUrl(str)) {
            this.mReferer = str;
            this.mOrigin = NetUtils.getOriginUrl(str);
            this.mUserAgent = str2;
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(String str, Map<String, String> map, String str2) {
        if (isValidUrl(str)) {
            this.mReferer = str;
            this.mOrigin = NetUtils.getOriginUrl(str);
            this.mUserAgent = str2;
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(WebView webView, String str, Map<String, String> map) {
        if (isValidUrl(str)) {
            webView.loadUrl(str, map);
            String url = webView.getUrl();
            this.mReferer = url;
            this.mOrigin = NetUtils.getOriginUrl(url);
            this.mUserAgent = webView.getSettings().getUserAgentString();
        }
    }
}
