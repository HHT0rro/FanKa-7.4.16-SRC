package com.huawei.flrequest.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flrequest.impl.bean.RequestBean;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLRequestConfigService {
    @NonNull
    String getAppId();

    long getCacheExpireTime();

    String getClientVersion();

    String getCustomParam(RequestBean requestBean);

    Map<String, String> getDeviceInfo();

    int getPageSize();

    @Nullable
    Map<String, String> getRequestHeader();

    @NonNull
    String getServerUrl();

    String getServiceCountry();
}
