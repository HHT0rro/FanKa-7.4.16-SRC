package w9;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f54314a = new HashMap(1);

    @Nullable
    public static synchronized String a(Context context, String str) {
        Map<String, String> a10;
        synchronized (k.class) {
            String d10 = i.b().d(context);
            Map<String, Map<String, String>> map = f54314a;
            Map<String, String> map2 = map.get(d10);
            String str2 = map2 != null ? map2.get(str) : "";
            if (TextUtils.isEmpty(str2) && (a10 = j.a(context, "com.huawei.cloud.agdsdkV02")) != null) {
                map.put(d10, a10);
                str2 = a10.get(str);
                b(a10);
            }
            if (TextUtils.isEmpty(str2)) {
                m.d("ServerUrlCache", "get grs url is empty!");
                return str2;
            }
            return str2 + BaseRequestBean.STORE_API;
        }
    }

    public static void b(Map<String, String> map) {
    }
}
