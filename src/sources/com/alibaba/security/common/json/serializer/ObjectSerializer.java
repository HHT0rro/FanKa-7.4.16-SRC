package com.alibaba.security.common.json.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ObjectSerializer {
    void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException;
}