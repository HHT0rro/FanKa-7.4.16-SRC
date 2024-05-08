package com.huawei.flrequest;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.creator.ObjectCreator;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flrequest.api.FLRequestException;
import com.huawei.flrequest.api.FLResponseType;
import com.huawei.flrequest.impl.bean.RequestBean;
import com.huawei.flrequest.impl.bean.ResponseBean;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;
import com.huawei.serverrequest.api.service.HttpResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28721a = "ResponseFactory";

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends RequestBean>, Class<? extends ResponseBean>> f28722b = new ConcurrentHashMap();

    /* compiled from: ResponseFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28723a;

        static {
            int[] iArr = new int[ServerResponse.ResponseType.values().length];
            f28723a = iArr;
            try {
                iArr[ServerResponse.ResponseType.FROM_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28723a[ServerResponse.ResponseType.FROM_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @NonNull
    public static <T extends ResponseBean> T a(@NonNull Class<? extends RequestBean> cls, @NonNull ServerResponse serverResponse) throws FLRequestException {
        T t2 = (T) a(cls);
        t2.setResponseJSON(a(serverResponse.getResponse()));
        int i10 = a.f28723a[serverResponse.getResponseType().ordinal()];
        if (i10 == 1) {
            t2.setResponseType(FLResponseType.FROM_CACHE);
        } else if (i10 == 2) {
            t2.setResponseType(FLResponseType.FROM_SERVER);
        } else {
            throw new RuntimeException("unsupported response type: " + ((Object) serverResponse.getResponseType()));
        }
        return t2;
    }

    @NonNull
    public static Class<? extends ResponseBean> b(@NonNull Class<? extends RequestBean> cls) {
        Map<Class<? extends RequestBean>, Class<? extends ResponseBean>> map = f28722b;
        Class<? extends ResponseBean> cls2 = map.get(cls);
        if (cls2 != null) {
            return cls2;
        }
        com.huawei.flrequest.impl.bean.a aVar = (com.huawei.flrequest.impl.bean.a) cls.getAnnotation(com.huawei.flrequest.impl.bean.a.class);
        if (aVar != null) {
            Class<? extends ResponseBean> value = aVar.value();
            map.put(cls, value);
            return value;
        }
        throw new RuntimeException("requestClass " + cls.getName() + " does not match any response class.");
    }

    private static JSONObject a(HttpResponse httpResponse) throws FLRequestException {
        try {
            String string = httpResponse.string();
            if (string != null) {
                try {
                    Log.v(f28721a, "response from server: " + string);
                    return new JSONObject(string);
                } catch (JSONException e2) {
                    throw new FLRequestException(5, "JSONException when parsing json string. ", e2);
                }
            }
            throw new FLRequestException(5, "null response");
        } catch (HttpException unused) {
            throw new FLRequestException(5, "cannot get response string");
        }
    }

    @NonNull
    public static <T extends ResponseBean> T a(@NonNull Class<? extends RequestBean> cls) {
        Class<? extends ResponseBean> b4 = b(cls);
        T t2 = (T) ObjectCreator.create(b4);
        if (t2 != null) {
            return t2;
        }
        throw new RuntimeException("response must have a public & default constructor: " + ((Object) b4));
    }
}
