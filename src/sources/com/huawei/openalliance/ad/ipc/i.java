package com.huawei.openalliance.ad.ipc;

import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.z;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class i {
    private static final String Code = "RemoteCallUtil";

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T Code(String str, Class<T> cls) {
        if (cls == null || cls == String.class) {
            return str;
        }
        if (!cls.isPrimitive()) {
            return (T) z.V(str, cls, new Class[0]);
        }
        String str2 = "Response type: " + ((Object) cls) + " not supported!";
        gl.I(Code, str2);
        throw new IllegalArgumentException(str2);
    }
}
