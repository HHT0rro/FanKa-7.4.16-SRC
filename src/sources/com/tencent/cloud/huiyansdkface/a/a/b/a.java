package com.tencent.cloud.huiyansdkface.a.a.b;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a<T> implements com.tencent.cloud.huiyansdkface.a.a.g<T> {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.g<T>[] f40297a;

    public a(com.tencent.cloud.huiyansdkface.a.a.g<T>[] gVarArr) {
        this.f40297a = gVarArr;
        if (gVarArr == null || gVarArr.length == 0) {
            throw new IllegalArgumentException("priorities must 1 element at least");
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    public T b(List<T> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        T b4;
        for (com.tencent.cloud.huiyansdkface.a.a.g<T> gVar : this.f40297a) {
            if (gVar != null && (b4 = gVar.b(list, dVar)) != null) {
                return b4;
            }
        }
        return null;
    }
}
