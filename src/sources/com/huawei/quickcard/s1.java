package com.huawei.quickcard;

import android.content.Context;
import com.huawei.quickcard.base.grs.CardServerConfig;
import com.huawei.quickcard.base.utils.CardServerUtil;
import com.huawei.quickcard.cardmanager.http.CardServer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s1 implements CardServer {
    @Override // com.huawei.quickcard.cardmanager.http.CardServer
    public String getPostUrl(Context context) {
        if (CardServerConfig.getAgcAuthProvider() != null) {
            return CardServerUtil.getAgcPostUrl(context);
        }
        return CardServerUtil.getStorePostUrl(context);
    }

    @Override // com.huawei.quickcard.cardmanager.http.CardServer
    public boolean isNetworkAccess() {
        return CardServerUtil.isNetworkAccess();
    }
}
