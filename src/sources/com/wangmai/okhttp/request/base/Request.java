package com.wangmai.okhttp.request.base;

import android.text.TextUtils;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.adapter.AdapterParam;
import com.wangmai.okhttp.adapter.CacheCall;
import com.wangmai.okhttp.adapter.Call;
import com.wangmai.okhttp.adapter.CallAdapter;
import com.wangmai.okhttp.cache.CacheMode;
import com.wangmai.okhttp.cache.policy.CachePolicy;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.convert.Converter;
import com.wangmai.okhttp.model.HttpHeaders;
import com.wangmai.okhttp.model.HttpMethod;
import com.wangmai.okhttp.model.HttpParams;
import com.wangmai.okhttp.request.base.ProgressRequestBody;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.HttpUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class Request<T, R extends Request> implements Serializable {
    public static final String TAG = "WM_Request";
    public static final long serialVersionUID = -7174118653689916252L;
    public String baseUrl;
    public String cacheKey;
    public CacheMode cacheMode;
    public transient CachePolicy<T> cachePolicy;
    public long cacheTime;
    public transient Call<T> call;
    public transient Callback<T> callback;
    public transient OkHttpClient client;
    public transient Converter<T> converter;
    public transient okhttp3.Request mRequest;
    public int retryCount;
    public transient Object tag;
    public transient ProgressRequestBody.UploadInterceptor uploadInterceptor;
    public String url;
    public HttpParams params = new HttpParams();
    public HttpHeaders headers = new HttpHeaders();

    public Request(String str) {
        try {
            this.url = str;
            this.baseUrl = str;
            OkHttp okHttp = OkHttp.getInstance();
            String acceptLanguage = HttpHeaders.getAcceptLanguage();
            if (!TextUtils.isEmpty(acceptLanguage)) {
                headers(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, acceptLanguage);
            }
            String userAgent = HttpHeaders.getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                headers("User-Agent", userAgent);
            }
            if (okHttp.getCommonParams() != null) {
                params(okHttp.getCommonParams());
            }
            if (okHttp.getCommonHeaders() != null) {
                headers(okHttp.getCommonHeaders());
            }
            this.retryCount = okHttp.getRetryCount();
            this.cacheMode = okHttp.getCacheMode();
            this.cacheTime = okHttp.getCacheTime();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Call<T> adapt() {
        Call<T> call = this.call;
        return call == null ? new CacheCall(this) : call;
    }

    public R addUrlParams(String str, List<String> list) {
        this.params.putUrlParams(str, list);
        return this;
    }

    public R cacheKey(String str) {
        HttpUtils.checkNotNull(str, "cacheKey == null");
        this.cacheKey = str;
        return this;
    }

    public R cacheMode(CacheMode cacheMode) {
        this.cacheMode = cacheMode;
        return this;
    }

    public R cachePolicy(CachePolicy<T> cachePolicy) {
        HttpUtils.checkNotNull(cachePolicy, "cachePolicy == null");
        this.cachePolicy = cachePolicy;
        return this;
    }

    public R cacheTime(long j10) {
        if (j10 <= -1) {
            j10 = -1;
        }
        this.cacheTime = j10;
        return this;
    }

    public R call(Call<T> call) {
        HttpUtils.checkNotNull(call, "call == null");
        this.call = call;
        return this;
    }

    public R client(OkHttpClient okHttpClient) {
        HttpUtils.checkNotNull(okHttpClient, "OkHttpClient == null");
        this.client = okHttpClient;
        return this;
    }

    public R converter(Converter<T> converter) {
        HttpUtils.checkNotNull(converter, "converter == null");
        this.converter = converter;
        return this;
    }

    public Response execute() throws IOException {
        return getRawCall().execute();
    }

    public abstract okhttp3.Request generateRequest(RequestBody requestBody);

    public abstract RequestBody generateRequestBody();

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public CacheMode getCacheMode() {
        return this.cacheMode;
    }

    public CachePolicy<T> getCachePolicy() {
        return this.cachePolicy;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public Converter<T> getConverter() {
        if (this.converter == null) {
            this.converter = this.callback;
        }
        HttpUtils.checkNotNull(this.converter, "converter == null, do you forget to call Request#converter(Converter<T>) ?");
        return this.converter;
    }

    public HttpParams.FileWrapper getFileParam(String str) {
        List<HttpParams.FileWrapper> list = this.params.fileParamsMap.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public HttpHeaders getHeaders() {
        return this.headers;
    }

    public abstract HttpMethod getMethod();

    public HttpParams getParams() {
        return this.params;
    }

    public okhttp3.Call getRawCall() {
        RequestBody generateRequestBody = generateRequestBody();
        if (generateRequestBody != null) {
            ProgressRequestBody progressRequestBody = new ProgressRequestBody(generateRequestBody, this.callback);
            progressRequestBody.setInterceptor(this.uploadInterceptor);
            this.mRequest = generateRequest(progressRequestBody);
        } else {
            this.mRequest = generateRequest(null);
        }
        if (this.client == null) {
            this.client = OkHttp.getInstance().getOkHttpClient();
        }
        return this.client.newCall(this.mRequest);
    }

    public okhttp3.Request getRequest() {
        return this.mRequest;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlParam(String str) {
        List<String> list = this.params.urlParamsMap.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public R headers(HttpHeaders httpHeaders) {
        this.headers.put(httpHeaders);
        return this;
    }

    public R params(HttpParams httpParams) {
        this.params.put(httpParams);
        return this;
    }

    public R removeAllHeaders() {
        this.headers.clear();
        return this;
    }

    public R removeAllParams() {
        this.params.clear();
        return this;
    }

    public R removeHeader(String str) {
        this.headers.remove(str);
        return this;
    }

    public R removeParam(String str) {
        this.params.remove(str);
        return this;
    }

    public R retryCount(int i10) {
        if (i10 >= 0) {
            this.retryCount = i10;
            return this;
        }
        throw new IllegalArgumentException("retryCount must > 0");
    }

    public void setCallback(Callback<T> callback) {
        this.callback = callback;
    }

    public R tag(Object obj) {
        this.tag = obj;
        return this;
    }

    public R uploadInterceptor(ProgressRequestBody.UploadInterceptor uploadInterceptor) {
        this.uploadInterceptor = uploadInterceptor;
        return this;
    }

    public void execute(Callback<T> callback) {
        HttpUtils.checkNotNull(callback, "callback == null");
        this.callback = callback;
        adapt().execute(callback);
    }

    public R headers(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public R params(Map<String, String> map, boolean... zArr) {
        this.params.put(map, zArr);
        return this;
    }

    public <E> E adapt(CallAdapter<T, E> callAdapter) {
        Call<T> call = this.call;
        if (call == null) {
            call = new CacheCall<>(this);
        }
        return callAdapter.adapt(call, null);
    }

    public R params(String str, String str2, boolean... zArr) {
        this.params.put(str, str2, zArr);
        return this;
    }

    public R params(String str, int i10, boolean... zArr) {
        this.params.put(str, i10, zArr);
        return this;
    }

    public R params(String str, float f10, boolean... zArr) {
        this.params.put(str, f10, zArr);
        return this;
    }

    public <E> E adapt(AdapterParam adapterParam, CallAdapter<T, E> callAdapter) {
        Call<T> call = this.call;
        if (call == null) {
            call = new CacheCall<>(this);
        }
        return callAdapter.adapt(call, adapterParam);
    }

    public R params(String str, double d10, boolean... zArr) {
        this.params.put(str, d10, zArr);
        return this;
    }

    public R params(String str, long j10, boolean... zArr) {
        this.params.put(str, j10, zArr);
        return this;
    }

    public R params(String str, char c4, boolean... zArr) {
        this.params.put(str, c4, zArr);
        return this;
    }

    public R params(String str, boolean z10, boolean... zArr) {
        this.params.put(str, z10, zArr);
        return this;
    }
}
