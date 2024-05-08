package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeTypeAdapter extends TypeAdaptor2 {

    /* renamed from: a, reason: collision with root package name */
    private WeJson f42403a = new WeJson();

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.TypeAdaptor2
    public <T> T a(String str, Type type) throws WeJsonException {
        return (T) this.f42403a.fromJson(str, type);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.TypeAdapter
    public <T> String to(T t2) {
        return this.f42403a.toJson(t2);
    }
}
