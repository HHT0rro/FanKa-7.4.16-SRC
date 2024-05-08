package com.huawei.hmf.orb.aidl.communicate;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.services.internal.GenericTypeReflector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AIDLRequest<R extends IMessageEntity> {
    private static final String TAG = "AIDLRequest";
    public ClientIdentity clientIdentity;
    public AIDLResponse response;

    private Class<R> getParamType() {
        Class<?> cls = getClass();
        Type genericSuperclass = cls.getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            cls = cls.getSuperclass();
            genericSuperclass = cls.getGenericSuperclass();
        }
        return (Class<R>) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public int checkPermission(R r10) {
        return 0;
    }

    public final void execute(R r10) {
        ClientIdentity clientIdentity = this.clientIdentity;
        if (clientIdentity != null && clientIdentity.isValid()) {
            int checkPermission = this.clientIdentity.isCore() ? 0 : checkPermission(r10);
            if (checkPermission <= 0) {
                onRequest(r10);
                return;
            } else {
                this.response.failure(checkPermission);
                return;
            }
        }
        this.response.failure(207135000);
    }

    public R makeParam() {
        try {
            return getParamType().newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public abstract void onRequest(R r10);
}
