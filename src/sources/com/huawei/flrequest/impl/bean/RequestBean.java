package com.huawei.flrequest.impl.bean;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.security.realidentity.build.aq;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.json.codec.JsonException;
import com.huawei.flexiblelayout.json.codec.JsonPacked;
import com.huawei.flrequest.api.FLRequestConfigService;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.flrequest.api.FLRequestType;
import com.huawei.flrequest.d;
import com.huawei.serverrequest.api.ServerRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RequestBean extends JsonBean implements ServerRequest {
    private static final String HEADERS_KEY = "layout-context";
    private static final String HEADER_APPID_VALUE = "leagueAppId";
    private static final String HEADER_LAYOUT = "layout/";
    private static final AtomicInteger sRequestId = new AtomicInteger(0);

    @JsonPacked("businessParam")
    private String mBusinessParam;
    private long mCacheExpireTime;

    @JsonPacked("clientVer")
    private final String mClientVer;

    @JsonPacked(aq.F)
    private final Map<String, String> mDeviceInfo;
    public Object mExtra;
    private Map<String, String> mHeaderMap;

    @JsonPacked("locale")
    private final String mLocale;
    private FLRequestConfigService mRequestConfig;
    private String mRequestId;
    public FLRequestType mRequestType = FLRequestType.REQUEST_SERVER;
    private final String mServerUrl;

    @JsonPacked("zone")
    private final String mZone;

    public RequestBean(Context context) throws FLRequestException {
        FLRequestConfigService fLRequestConfigService = (FLRequestConfigService) FLEngine.getInstance(context).getService(FLRequestConfigService.class);
        if (fLRequestConfigService != null) {
            this.mRequestConfig = fLRequestConfigService;
            this.mServerUrl = a(fLRequestConfigService.getServerUrl(), fLRequestConfigService.getAppId());
            this.mZone = fLRequestConfigService.getServiceCountry();
            this.mClientVer = fLRequestConfigService.getClientVersion();
            this.mCacheExpireTime = fLRequestConfigService.getCacheExpireTime();
            Map<String, String> requestHeader = fLRequestConfigService.getRequestHeader();
            this.mHeaderMap = requestHeader;
            if (requestHeader == null) {
                this.mHeaderMap = new HashMap();
            }
            if (!this.mHeaderMap.containsKey(HEADERS_KEY)) {
                this.mHeaderMap.put(HEADERS_KEY, a(fLRequestConfigService.getAppId()));
            }
            this.mLocale = d.a();
            this.mRequestId = d();
            this.mDeviceInfo = fLRequestConfigService.getDeviceInfo();
            return;
        }
        throw new FLRequestException(-1, "failed to get FLRequestConfigService.");
    }

    private String d() {
        return String.format(Locale.ENGLISH, "%06d", Integer.valueOf(sRequestId.incrementAndGet()));
    }

    public void a(long j10) {
        this.mCacheExpireTime = j10;
    }

    public String b() {
        return this.mLocale;
    }

    public String c() {
        return this.mZone;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String getBody() throws JsonException {
        this.mBusinessParam = a(this.mRequestConfig);
        return serialize();
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public long getCacheExpireTime() {
        return this.mCacheExpireTime;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public String getCacheId() {
        return "";
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @Nullable
    public String getContentType() {
        return "application/json; charset=utf-8";
    }

    public Object getExtra() {
        return this.mExtra;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public Map<String, String> getHeaders() {
        return this.mHeaderMap;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public String getId() {
        return this.mRequestId;
    }

    public abstract String getMethod();

    @Override // com.huawei.serverrequest.api.ServerRequest
    public ServerRequest.RequestType getRequestType() {
        FLRequestType fLRequestType = FLRequestType.REQUEST_SERVER;
        FLRequestType fLRequestType2 = this.mRequestType;
        if (fLRequestType == fLRequestType2) {
            return ServerRequest.RequestType.REQUEST_SERVER;
        }
        if (FLRequestType.REQUEST_CACHE == fLRequestType2) {
            return ServerRequest.RequestType.REQUEST_CACHE;
        }
        if (FLRequestType.REQUEST_CACHE_OTHERWISE_SERVER == fLRequestType2) {
            return ServerRequest.RequestType.REQUEST_CACHE_OTHERWISE_SERVER;
        }
        throw new RuntimeException("unsupported request type: " + ((Object) this.mRequestType));
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String getUrl() {
        return this.mServerUrl + getMethod();
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String method() {
        return "POST";
    }

    public void setExtra(Object obj) {
        this.mExtra = obj;
    }

    public void setRequestType(FLRequestType fLRequestType) {
        this.mRequestType = fLRequestType;
    }

    public String a() {
        return this.mClientVer;
    }

    public String a(@NonNull FLRequestConfigService fLRequestConfigService) {
        return fLRequestConfigService.getCustomParam(this);
    }

    public static String a(String str, String str2) throws FLRequestException {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                return str + HEADER_LAYOUT + str2 + "/";
            }
            throw new FLRequestException(4, "leagueAppId must not be null or empty.");
        }
        throw new FLRequestException(6, "serverUrl must not be null or empty.");
    }

    public static String a(String str) throws FLRequestException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(HEADER_APPID_VALUE, str);
                return jSONObject.toString();
            } catch (JSONException e2) {
                throw new FLRequestException(4, "unreachable, failed to make XCSEContext", e2);
            }
        }
        throw new FLRequestException(4, "leagueAppId must not be null or empty.");
    }
}
