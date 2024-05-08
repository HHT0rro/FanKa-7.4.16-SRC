package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class TypeAdaptor2 implements TypeAdapter {
    public abstract <T> T a(String str, Type type) throws WeJsonException;

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.TypeAdapter
    public <T> T from(String str, Class<T> cls) throws WeJsonException {
        return (T) a(str, cls);
    }
}
