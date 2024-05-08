package ba;

import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Class> f1455a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f1456b;

    static {
        HashMap hashMap = new HashMap();
        f1455a = hashMap;
        if (hashMap.size() <= 0) {
            hashMap.put(z9.a.METHOD, z9.b.class);
        }
        f1456b = new ThreadPoolExecutor(6, 6, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Executors.newFixedThreadPool(1);
    }

    public static b a(RequestBean requestBean, ja.b bVar) {
        b bVar2 = new b(requestBean, bVar);
        bVar2.g(f1456b);
        return bVar2;
    }

    public static ResponseBean b(RequestBean requestBean) {
        return new b(requestBean, null).a(requestBean.getContext());
    }
}
