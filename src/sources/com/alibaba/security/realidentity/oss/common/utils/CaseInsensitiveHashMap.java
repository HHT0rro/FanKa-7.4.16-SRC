package com.alibaba.security.realidentity.oss.common.utils;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CaseInsensitiveHashMap<k, v> extends HashMap<k, v> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public v get(Object obj) {
        if (obj != null && !containsKey(obj) && (obj instanceof String)) {
            String lowerCase = ((String) obj).toLowerCase();
            if (containsKey(lowerCase)) {
                return get(lowerCase);
            }
            return null;
        }
        return (v) super.get(obj);
    }
}