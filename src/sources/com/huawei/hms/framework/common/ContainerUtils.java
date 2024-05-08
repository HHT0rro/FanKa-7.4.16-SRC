package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        boolean z10;
        if (map == map2) {
            return true;
        }
        if (map != null && map2 != null && map.size() == map2.size()) {
            Iterator<Map.Entry<K, V>> iterator2 = map.entrySet().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    z10 = false;
                    break;
                }
                Map.Entry<K, V> next = iterator2.next();
                if (map2.get(next.getKey()) != next.getValue()) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return true;
            }
        }
        return false;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append("&");
            }
            sb2.append(entry.getKey().toString());
            sb2.append("=");
            sb2.append(entry.getValue().toString());
            i10 = i11;
        }
        return sb2.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (K k10 : set) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append("&");
            }
            sb2.append(k10.toString());
            i10 = i11;
        }
        return sb2.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (K k10 : list) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append("&");
            }
            sb2.append(k10.toString());
            i10 = i11;
        }
        return sb2.toString();
    }
}
