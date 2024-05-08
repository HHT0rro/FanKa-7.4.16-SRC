package com.alibaba.fastjson.support.springfox;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SwaggerJsonSerializer implements ObjectSerializer {
    public static final SwaggerJsonSerializer instance = new SwaggerJsonSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        jSONSerializer.getWriter().write(((Json) obj).value());
    }
}
