package com.alibaba.fastjson.serializer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface PropertyPreFilter extends SerializeFilter {
    boolean apply(JSONSerializer jSONSerializer, Object obj, String str);
}
