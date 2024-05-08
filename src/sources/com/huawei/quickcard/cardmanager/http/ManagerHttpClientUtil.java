package com.huawei.quickcard.cardmanager.http;

import android.content.Context;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ManagerHttpClientUtil {

    /* renamed from: a, reason: collision with root package name */
    private static ManagerHttpClient f33549a;

    public static ManagerHttpResponse request(Context context, ManagerHttpRequest managerHttpRequest) throws IOException {
        ManagerHttpClient managerHttpClient = f33549a;
        if (managerHttpClient == null) {
            ManagerLogUtil.w("CardHttpClientUtil does not set httpClient");
            return null;
        }
        return managerHttpClient.request(context, managerHttpRequest);
    }

    public static void setHttpClient(ManagerHttpClient managerHttpClient) {
        f33549a = managerHttpClient;
    }
}
