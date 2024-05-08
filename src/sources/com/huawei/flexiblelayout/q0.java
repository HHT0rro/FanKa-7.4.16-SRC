package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import java.util.Map;

/* compiled from: MapWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class q0 implements MapModel {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Map<String, Object> f28433a;

    public q0(@NonNull Map<String, Object> map) {
        this.f28433a = map;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(String str) {
        return this.f28433a.get(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        return this.f28433a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public String[] keys() {
        return (String[]) this.f28433a.h().toArray(new String[0]);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return this.f28433a.size();
    }
}
