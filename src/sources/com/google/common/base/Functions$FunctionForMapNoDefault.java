package com.google.common.base;

import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Functions$FunctionForMapNoDefault<K, V> implements g<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    public final Map<K, V> map;

    public Functions$FunctionForMapNoDefault(Map<K, V> map) {
        this.map = (Map) o.r(map);
    }

    @Override // com.google.common.base.g
    public V apply(K k10) {
        V v2 = this.map.get(k10);
        o.m(v2 != null || this.map.containsKey(k10), "Key '%s' not present in map", k10);
        return (V) k.a(v2);
    }

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionForMapNoDefault) {
            return this.map.equals(((Functions$FunctionForMapNoDefault) obj).map);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.map);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
        sb2.append("Functions.forMap(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
