package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.annotation.NamedMethod;
import com.huawei.hmf.orb.Releasable;
import com.huawei.hmf.orb.RemoteTarget;
import com.huawei.hmf.services.codec.Variant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NamingRemoteTarget<T> extends RemoteTarget<T> {
    public NamingRemoteTarget(T t2) {
        super(t2);
    }

    @Override // com.huawei.hmf.orb.RemoteTarget
    public Class getServiceType() {
        return null;
    }

    @Override // com.huawei.hmf.orb.RemoteTarget
    public String getServiceTypeName() {
        return null;
    }

    @Override // com.huawei.hmf.orb.RemoteTarget
    public Object onTransact(String str, Object... objArr) {
        if (service() == null) {
            return null;
        }
        Class<?>[] interfaces = service().getClass().getInterfaces();
        int length = interfaces.length;
        Object[] objArr2 = objArr;
        for (int i10 = 0; i10 < length; i10++) {
            for (Method method : interfaces[i10].getMethods()) {
                NamedMethod namedMethod = (NamedMethod) method.getAnnotation(NamedMethod.class);
                if (namedMethod != null && namedMethod.value().equals(str)) {
                    try {
                        Type[] genericParameterTypes = method.getGenericParameterTypes();
                        if (genericParameterTypes.length > 0) {
                            Object[] objArr3 = new Object[genericParameterTypes.length];
                            for (int i11 = 0; i11 < genericParameterTypes.length; i11++) {
                                objArr3[i11] = ((Variant) objArr2[i11]).cast(genericParameterTypes[i11]);
                            }
                            objArr2 = objArr3;
                        }
                        return method.invoke(service(), objArr2);
                    } catch (IllegalAccessException | InvocationTargetException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.huawei.hmf.orb.RemoteTarget, com.huawei.hmf.orb.Releasable
    public void release() {
        super.release();
        T service = service();
        if (service == null || !(service instanceof Releasable)) {
            return;
        }
        ((Releasable) service).release();
    }
}
