package com.huawei.quickcard;

import com.alibaba.security.realidentity.build.cs;
import com.huawei.quickcard.base.grs.CardServerConfig;
import com.huawei.quickcard.cardmanager.http.ServerConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r1 implements ServerConfig {
    @Override // com.huawei.quickcard.cardmanager.http.ServerConfig
    public Map<String, String> getPostHeaders() {
        HashMap hashMap = new HashMap();
        if (CardServerConfig.getAgcAuthProvider() != null) {
            hashMap.put(com.alipay.sdk.authjs.a.f4495d, CardServerConfig.getAgcAuthProvider().getClientId());
            hashMap.put("productId", CardServerConfig.getAgcAuthProvider().getProductId());
            hashMap.put(cs.K, "Bearer " + CardServerConfig.getAgcAuthProvider().getClientToken());
        }
        return hashMap;
    }

    @Override // com.huawei.quickcard.cardmanager.http.ServerConfig
    public Map<String, String> getPostParamsForNewCard() {
        HashMap hashMap = new HashMap();
        int mode = CardServerConfig.getMode();
        if (mode == 1) {
            hashMap.put("method", "quickCard.test.card");
        } else if (mode == 0) {
            hashMap.put("method", "quickCard.card");
        }
        return hashMap;
    }
}
