package com.google.common.base;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Functions$FunctionComposition<A, B, C> implements g<A, C>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: f, reason: collision with root package name */
    private final g<A, ? extends B> f25943f;

    /* renamed from: g, reason: collision with root package name */
    private final g<B, C> f25944g;

    public Functions$FunctionComposition(g<B, C> gVar, g<A, ? extends B> gVar2) {
        this.f25944g = (g) o.r(gVar);
        this.f25943f = (g) o.r(gVar2);
    }

    @Override // com.google.common.base.g
    public C apply(A a10) {
        return (C) this.f25944g.apply(this.f25943f.apply(a10));
    }

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        if (!(obj instanceof Functions$FunctionComposition)) {
            return false;
        }
        Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition) obj;
        return this.f25943f.equals(functions$FunctionComposition.f25943f) && this.f25944g.equals(functions$FunctionComposition.f25944g);
    }

    public int hashCode() {
        return this.f25943f.hashCode() ^ this.f25944g.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f25944g);
        String valueOf2 = String.valueOf(this.f25943f);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
