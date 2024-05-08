package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JSONSerializerMap extends SerializeConfig {
    public final boolean put(Class<?> cls, ObjectSerializer objectSerializer) {
        return super.put((Type) cls, objectSerializer);
    }
}
