package com.tencent.cloud.huiyansdkface.a.a.b;

import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g<T> implements com.tencent.cloud.huiyansdkface.a.a.g<T> {

    /* renamed from: a, reason: collision with root package name */
    private T f40299a;

    public g(T t2) {
        this.f40299a = t2;
        if (t2 == null) {
            throw new IllegalArgumentException("target cannot be null");
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    public T b(List<T> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        if (list != null && list.size() != 0) {
            Iterator<T> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (this.f40299a.equals(iterator2.next())) {
                    return this.f40299a;
                }
            }
        }
        return null;
    }
}
