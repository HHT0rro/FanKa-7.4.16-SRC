package com.huawei.flexiblelayout.parser.directive;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FormulaMap implements FLMap {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final FLMap f28364a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final MapModel f28365b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final b f28366c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Map<String, Object> f28367d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Set<String> f28368e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<String> f28369f;

    public FormulaMap(@Nullable FLMap fLMap, @NonNull b bVar) {
        if (fLMap instanceof ModelBinding) {
            ModelBinding modelBinding = (ModelBinding) fLMap;
            FLMap json = Jsons.toJson(modelBinding.getScope().evaluate(bVar));
            this.f28364a = modelBinding.getData();
            this.f28365b = new FormulaMap(json, bVar);
        } else {
            this.f28364a = fLMap;
            this.f28365b = bVar.a();
        }
        this.f28366c = bVar;
        this.f28367d = new HashMap();
        this.f28368e = new HashSet();
        HashSet hashSet = new HashSet();
        this.f28369f = hashSet;
        FLMap fLMap2 = this.f28364a;
        if (fLMap2 != null) {
            hashSet.addAll(Arrays.asList(fLMap2.keys()));
        }
        hashSet.addAll(Arrays.asList(this.f28365b.keys()));
        b();
        a();
    }

    public void a() {
        FLMap fLMap = this.f28364a;
        if (fLMap != null) {
            for (String str : fLMap.keys()) {
                Object obj = this.f28364a.get(str);
                if (obj instanceof VarFormula) {
                    VarFormula varFormula = (VarFormula) obj;
                    if (varFormula.getPhase(this.f28366c) == 1) {
                        this.f28367d.put(str, a(varFormula, this.f28366c));
                    }
                }
            }
        }
    }

    public void b() {
        DataParserExtend.register();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(@NonNull String str) {
        if (this.f28368e.contains(str)) {
            return null;
        }
        Object obj = this.f28367d.get(str);
        if (obj != null) {
            return obj;
        }
        FLMap fLMap = this.f28364a;
        Object obj2 = fLMap != null ? fLMap.get(str) : null;
        if (obj2 == null) {
            return this.f28365b.get(str);
        }
        if (!(obj2 instanceof VarFormula)) {
            return obj2;
        }
        Object a10 = a((VarFormula) obj2, this.f28366c);
        this.f28367d.put(str, a10);
        return a10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        return false;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    @NonNull
    public String[] keys() {
        return (String[]) this.f28369f.toArray(new String[0]);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str) {
        return optBoolean(str, false);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str) {
        return optDouble(str, ShadowDrawableWrapper.COS_45);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str) {
        return optInt(str, 0);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str) {
        return optLong(str, 0L);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str) {
        return optString(str, "");
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    @NonNull
    public FLMap put(@NonNull String str, Object obj) {
        if (obj == null) {
            remove(str);
            return this;
        }
        this.f28368e.remove(str);
        this.f28369f.add(str);
        this.f28367d.put(str, Jsons.toJsonIf(obj));
        return this;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    public Object remove(@NonNull String str) {
        Object obj = get(str);
        if (obj != null) {
            this.f28368e.add(str);
            this.f28369f.remove(str);
            this.f28367d.remove(str);
        }
        return obj;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return this.f28369f.size();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLArray optArray(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof FLArray) {
            return (FLArray) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str, boolean z10) {
        Boolean a10 = com.huawei.flexiblelayout.json.a.a(get(str));
        return a10 != null ? a10.booleanValue() : z10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str, double d10) {
        Double b4 = com.huawei.flexiblelayout.json.a.b(get(str));
        return b4 != null ? b4.doubleValue() : d10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str, int i10) {
        Integer c4 = com.huawei.flexiblelayout.json.a.c(get(str));
        return c4 != null ? c4.intValue() : i10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str, long j10) {
        Long d10 = com.huawei.flexiblelayout.json.a.d(get(str));
        return d10 != null ? d10.longValue() : j10;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLMap optMap(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof FLMap) {
            return (FLMap) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str, String str2) {
        String e2 = com.huawei.flexiblelayout.json.a.e(get(str));
        return e2 != null ? e2 : str2;
    }

    public static Object a(VarFormula varFormula, b bVar) {
        final AtomicReference atomicReference = new AtomicReference();
        varFormula.process(bVar, new ProcessorResult() { // from class: com.huawei.flexiblelayout.parser.directive.FormulaMap.1
            @Override // com.huawei.flexiblelayout.parser.expr.ProcessorResult
            public void processed(Object obj) {
                AtomicReference.this.set(obj);
            }
        });
        return Jsons.toJsonIf(atomicReference.get());
    }
}
