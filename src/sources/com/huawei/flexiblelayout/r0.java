package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;

/* compiled from: MixedMapModel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class r0 implements MapModel {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final MapModel f28437a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final MapModel f28438b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f28439c;

    public r0(@NonNull MapModel mapModel, @Nullable Map<String, Object> map) {
        this.f28437a = mapModel;
        if (map != null) {
            this.f28438b = new q0(map);
        } else {
            this.f28438b = null;
        }
    }

    private String[] a() {
        if (this.f28439c == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            MapModel mapModel = this.f28438b;
            if (mapModel != null) {
                linkedHashSet.addAll(Arrays.asList(mapModel.keys()));
            }
            linkedHashSet.addAll(Arrays.asList(this.f28437a.keys()));
            this.f28439c = (String[]) linkedHashSet.toArray(new String[0]);
        }
        return this.f28439c;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(String str) {
        MapModel mapModel = this.f28438b;
        if (mapModel != null && mapModel.get(str) != null) {
            return this.f28438b.get(str);
        }
        return this.f28437a.get(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        if (this.f28438b != null) {
            return this.f28437a.isEmpty() && this.f28438b.isEmpty();
        }
        return this.f28437a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public String[] keys() {
        return a();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return a().length;
    }

    public r0(@NonNull MapModel mapModel, @Nullable MapModel mapModel2) {
        this.f28437a = mapModel;
        this.f28438b = mapModel2;
    }
}
