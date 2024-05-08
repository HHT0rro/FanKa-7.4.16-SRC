package com.huawei.appgallery.agd.common.utils;

import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ListUtils {
    public static <V> boolean isEmpty(List<V> list) {
        return list == null || list.isEmpty();
    }

    public static <V, K> boolean isEmpty(Map<V, K> map) {
        return map == null || map.isEmpty();
    }
}
