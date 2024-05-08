package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import sun.security.x509.PolicyMappingsExtension;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JSONObjectCodec implements ObjectSerializer {
    public static final JSONObjectCodec instance = new JSONObjectCodec();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        MapSerializer mapSerializer = MapSerializer.instance;
        try {
            Field declaredField = obj.getClass().getDeclaredField(PolicyMappingsExtension.MAP);
            if (Modifier.isPrivate(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            mapSerializer.write(jSONSerializer, declaredField.get(obj), obj2, type, i10);
        } catch (Exception unused) {
            serializeWriter.writeNull();
        }
    }
}
