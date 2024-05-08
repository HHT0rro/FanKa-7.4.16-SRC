package com.google.common.base;

import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Functions$ForMapWithDefault<K, V> implements g<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    public final V defaultValue;
    public final Map<K, ? extends V> map;

    public Functions$ForMapWithDefault(Map<K, ? extends V> map, V v2) {
        this.map = (Map) o.r(map);
        this.defaultValue = v2;
    }

    @Override // com.google.common.base.g
    public V apply(K k10) {
        V v2 = this.map.get(k10);
        if (v2 == null && !this.map.containsKey(k10)) {
            return this.defaultValue;
        }
        return (V) k.a(v2);
    }

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        if (!(obj instanceof Functions$ForMapWithDefault)) {
            return false;
        }
        Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault) obj;
        return this.map.equals(functions$ForMapWithDefault.map) && l.a(this.defaultValue, functions$ForMapWithDefault.defaultValue);
    }

    public int hashCode() {
        return l.b(this.map, this.defaultValue);
    }

    public String toString() {
        String valueOf = String.valueOf(this.map);
        String valueOf2 = String.valueOf(this.defaultValue);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 33 + valueOf2.length());
        sb2.append("Functions.forMap(");
        sb2.append(valueOf);
        sb2.append(", defaultValue=");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
