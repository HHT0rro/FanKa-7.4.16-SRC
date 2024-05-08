package com.huawei.hmf.orb;

import com.huawei.hmf.annotation.NamedMethod;
import com.huawei.hmf.orb.aidl.NamingRemoteProxy;
import com.huawei.hmf.orb.aidl.request.InvokeService;
import com.huawei.hmf.orb.aidl.request.TypeKind;
import com.huawei.hmf.orb.bridge.Bridge;
import com.huawei.hmf.orb.bridge.RemoteBridgeFactory;
import com.huawei.hmf.orb.exception.InvocationException;
import com.huawei.hmf.services.codec.TypeToken;
import com.huawei.hmf.services.codec.Variant;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteProxy {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    private RemoteInvoker mRemote;
    private long mSequence = -1;

    public RemoteProxy(RemoteInvoker remoteInvoker) {
        this.mRemote = remoteInvoker;
    }

    private Object[] assemblyArgument(Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_ARRAY;
        }
        Object[] objArr2 = new Object[objArr.length + 1];
        objArr2[0] = Long.valueOf(this.mSequence);
        if (objArr.length > 0) {
            System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
        }
        return objArr2;
    }

    public Object send(String str, String str2, TypeToken typeToken, Object... objArr) {
        Class rawType;
        Bridge bridge;
        if (typeToken != null && (rawType = typeToken.getRawType()) != null && (bridge = RemoteBridgeFactory.getBridge(rawType)) != null) {
            return bridge.send(this.mRemote, this.mRemote.post(str, str2, assemblyArgument(objArr)), typeToken);
        }
        Class rawType2 = typeToken != null ? typeToken.getRawType() : null;
        TypeKind typeKind = TypeKind.CLASS;
        if (rawType2 != null && rawType2.isInterface()) {
            Method[] methods = rawType2.getMethods();
            int length = methods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (methods[i10].getAnnotation(NamedMethod.class) != null) {
                    typeKind = TypeKind.NamedClass;
                    break;
                }
                i10++;
            }
        }
        InvokeService.Response send = this.mRemote.send(str, str2, typeKind, assemblyArgument(objArr));
        if (typeToken == null) {
            return null;
        }
        if (send != null) {
            if (send.isSuccessful()) {
                return typeKind == TypeKind.NamedClass ? NamingRemoteProxy.create(this.mRemote, (Class<?>[]) new Class[]{typeToken.getRawType()}, Long.valueOf(((Long) send.ret.cast(Long.class)).longValue())) : send.ret.cast(typeToken.getType());
            }
            Variant<?> variant = send.ret;
            throw new InvocationException("Invoke failed, error code " + (variant == null ? "unknown" : variant.cast(Integer.TYPE)));
        }
        throw new InvocationException("Unexpected null value returned.");
    }

    public void setSequence(long j10) {
        this.mSequence = j10;
    }
}
