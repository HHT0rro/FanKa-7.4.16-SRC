package org.apache.commons.collections4;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Put<K, V> {
    void clear();

    Object put(K k10, V v2);

    void putAll(Map<? extends K, ? extends V> map);
}
