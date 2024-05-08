package com.wangmai.okhttp.interceptor;

import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.WeakHashMap;
import java.util.zip.ZipUtils;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SameRequestFilterInterceptor implements Interceptor {
    public static final int MAX_RETRY_NUM = 5;
    public static final String TAG = "RequestFilter";
    public Charset UTF_8 = Charset.forName("UTF-8");
    public IConfig config;
    public boolean enableFilter;
    public Handler handler;
    public static WeakHashMap<String, ResonseForClone> responseWeakHashMap = new WeakHashMap<>();
    public static WeakHashMap<String, WeakReference<Call>> calls = new WeakHashMap<>();
    public static boolean logEnable = false;
    public static SameRequestFilterInterceptor INTERCEPTOR = new SameRequestFilterInterceptor(true, new IConfig() { // from class: com.wangmai.okhttp.interceptor.SameRequestFilterInterceptor.1
        @Override // com.wangmai.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public String generateCacheKey(Request request) {
            String replaceAll = (request.toString() + "&headers:" + ((Object) request.headers()) + "&body:" + ((Object) request.body())).replaceAll("\\s*", "");
            return SameRequestFilterInterceptor.logEnable ? replaceAll : SameRequestFilterInterceptor.getMD5(replaceAll);
        }

        @Override // com.wangmai.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public long responseCacheTimeInMills() {
            return 1000L;
        }

        @Override // com.wangmai.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public boolean shouldFilter(String str) {
            return true;
        }
    });

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface IConfig {
        String generateCacheKey(Request request);

        long responseCacheTimeInMills();

        boolean shouldFilter(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ResonseForClone {
        public String body;
        public Response response;

        public ResonseForClone(String str, Response response) {
            this.body = str;
            this.response = response;
        }

        public Response getClonedResonse() {
            return new Response.Builder().code(this.response.code()).protocol(this.response.protocol()).message(this.response.message()).body(ResponseBody.create(this.response.body().contentType(), this.body)).headers(this.response.headers()).header("cachedResonse", "yes").request(this.response.request()).build();
        }
    }

    public SameRequestFilterInterceptor(boolean z10, IConfig iConfig) {
        this.config = iConfig;
        this.enableFilter = z10;
    }

    private Response check(Interceptor.Chain chain, Request request, String str) throws IOException {
        try {
            if (!needwait(str)) {
                if (responseWeakHashMap.containsKey(str)) {
                    return responseWeakHashMap.get(str).getClonedResonse();
                }
                return realExceute(chain, request, str);
            }
            for (int i10 = 0; i10 < 5; i10++) {
                Thread.sleep(500L);
                if (!needwait(str)) {
                    if (responseWeakHashMap.containsKey(str)) {
                        return responseWeakHashMap.get(str).getClonedResonse();
                    }
                    return realExceute(chain, request, str);
                }
            }
            return new Response.Builder().code(504).protocol(Protocol.HTTP_2).message("request time out").body(ResponseBody.create((MediaType) null, "")).headers(request.headers()).header("cachedResonse", "yes").request(request).build();
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("intercept check error:");
            sb2.append(th.toString());
            if (responseWeakHashMap.containsKey(str)) {
                return responseWeakHashMap.get(str).getClonedResonse();
            }
            return realExceute(chain, request, str);
        }
    }

    private String generateKey(Request request) {
        return this.config.generateCacheKey(request);
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16).toUpperCase();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Handler getMainHandler() {
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        return this.handler;
    }

    public static void log(String str) {
    }

    private synchronized boolean needwait(String str) {
        if (responseWeakHashMap.containsKey(str)) {
            log("有缓存的response,直接去读缓存,并组装新的response:" + str);
            return false;
        }
        if (calls.containsKey(str)) {
            WeakReference<Call> weakReference = calls.get(str);
            if (weakReference == null) {
                log("不需要等待,直接发请求 call WeakReference not exist:");
                return false;
            }
            Call call = weakReference.get();
            if (call != null && !call.isCanceled()) {
                log("请求可能正在等待或正在执行-needwait call is running:" + ((Object) call));
                return true;
            }
            log("不需要等待,直接发请求 call not exist or is canceld:" + ((Object) call));
            return false;
        }
        log("任何地方都没有,不需要等,直接执行请求:" + str);
        return false;
    }

    private Response realExceute(Interceptor.Chain chain, Request request, final String str) throws IOException {
        calls.put(str, new WeakReference<>(chain.call()));
        if ("898CB257F817B793217DBEC7962F800C".equals(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("加载图片，睡眠10秒查看效果\t thread:");
            sb2.append(Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Response proceed = chain.proceed(request);
        if (proceed != null) {
            try {
                if (proceed.isSuccessful() && proceed.body() != null) {
                    ResponseBody body = proceed.body();
                    if (body.contentLength() <= 4096) {
                        BufferedSource source = body.source();
                        source.request(body.contentLength() > 0 ? body.contentLength() : ZipUtils.UPPER_UNIXTIME_BOUND);
                        Buffer buffer = source.buffer();
                        Charset charset = this.UTF_8;
                        MediaType contentType = body.contentType();
                        if (contentType != null) {
                            charset = contentType.charset(this.UTF_8);
                        }
                        String readString = buffer.clone().readString(charset);
                        responseWeakHashMap.put(str, new ResonseForClone(readString, new Response.Builder().code(proceed.code()).protocol(proceed.protocol()).message(proceed.message()).body(ResponseBody.create(proceed.body().contentType(), readString)).headers(proceed.headers()).header("cachedResonse", "yes").request(request).build()));
                        getMainHandler().postDelayed(new Runnable() { // from class: com.wangmai.okhttp.interceptor.SameRequestFilterInterceptor.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SameRequestFilterInterceptor.responseWeakHashMap.remove(str);
                            }
                        }, this.config.responseCacheTimeInMills());
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        calls.remove(str);
        return proceed;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (!this.enableFilter) {
            return chain.proceed(request);
        }
        IConfig iConfig = this.config;
        if (iConfig == null) {
            return chain.proceed(request);
        }
        if (!iConfig.shouldFilter(request.url().toString())) {
            return chain.proceed(request);
        }
        return check(chain, request, generateKey(request));
    }
}
