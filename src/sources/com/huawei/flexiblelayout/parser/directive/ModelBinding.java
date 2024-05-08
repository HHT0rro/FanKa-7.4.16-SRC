package com.huawei.flexiblelayout.parser.directive;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ModelBinding implements FLMap {

    /* renamed from: a, reason: collision with root package name */
    private final FLMap f28377a;

    /* renamed from: b, reason: collision with root package name */
    private final VarFormula f28378b;

    public ModelBinding(@NonNull FLMap fLMap, @NonNull VarFormula varFormula) {
        this.f28377a = fLMap;
        this.f28378b = varFormula;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(String str) {
        throw new RuntimeException("Not supported");
    }

    @NonNull
    public FLMap getData() {
        return this.f28377a;
    }

    @NonNull
    public VarFormula getScope() {
        return this.f28378b;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public String[] keys() {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    @NonNull
    public FLMap put(@NonNull String str, Object obj) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    public Object remove(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLArray optArray(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str, boolean z10) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str, double d10) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str, int i10) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str, long j10) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLMap optMap(@NonNull String str) {
        throw new RuntimeException("Not supported");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str, String str2) {
        throw new RuntimeException("Not supported");
    }
}
