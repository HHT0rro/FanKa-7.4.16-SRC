package com.google.android.gms.internal.vision;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c7 implements Comparable, Map.Entry {

    /* renamed from: b, reason: collision with root package name */
    public final Comparable f25448b;

    /* renamed from: c, reason: collision with root package name */
    public Object f25449c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x6 f25450d;

    public c7(x6 x6Var, Map.Entry entry) {
        this(x6Var, (Comparable) entry.getKey(), entry.getValue());
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((c7) obj).getKey());
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
        return a(this.f25448b, entry.getKey()) && a(this.f25449c, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f25448b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f25449c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f25448b;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f25449c;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f25450d.p();
        Object obj2 = this.f25449c;
        this.f25449c = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f25448b);
        String valueOf2 = String.valueOf(this.f25449c);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public c7(x6 x6Var, Comparable comparable, Object obj) {
        this.f25450d = x6Var;
        this.f25448b = comparable;
        this.f25449c = obj;
    }
}
