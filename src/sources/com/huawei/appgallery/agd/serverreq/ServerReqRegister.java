package com.huawei.appgallery.agd.serverreq;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.appgallery.agd.serverreq.bean.ResponseBean;
import com.huawei.appgallery.agd.serverreq.store.SignSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ServerReqRegister {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Class> f27520a = new ConcurrentHashMap(16);

    public static ResponseBean createResponseBean(String str) throws InstantiationException, IllegalAccessException {
        Class cls = str != null ? f27520a.get(str) : null;
        if (cls != null) {
            return (ResponseBean) cls.newInstance();
        }
        throw new InstantiationException("ResponseBean class not found, method:" + str);
    }

    public static void registerResponse(String str, Class cls) {
        f27520a.put(str, cls);
    }

    public static <T extends BaseRequestBean> void registerSignProvider(@NonNull SignSession.ISignProvider iSignProvider) {
        SignSession.getInstance().setSignProvider(iSignProvider);
    }
}
