package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b3 implements Comparable, Map.Entry {

    /* renamed from: b, reason: collision with root package name */
    public final Comparable f23821b;

    /* renamed from: c, reason: collision with root package name */
    public Object f23822c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u2 f23823d;

    public b3(u2 u2Var, Comparable comparable, Object obj) {
        this.f23823d = u2Var;
        this.f23821b = comparable;
        this.f23822c = obj;
    }

    public b3(u2 u2Var, Map.Entry entry) {
        this(u2Var, (Comparable) entry.getKey(), entry.getValue());
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((b3) obj).getKey());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f23821b, entry.getKey()) && a(this.f23822c, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f23821b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f23822c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f23821b;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f23822c;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f23823d.o();
        Object obj2 = this.f23822c;
        this.f23822c = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f23821b);
        String valueOf2 = String.valueOf(this.f23822c);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }
}
