package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface TypeAdapter {
    <T> T from(String str, Class<T> cls) throws WeJsonException;

    <T> String to(T t2);
}
