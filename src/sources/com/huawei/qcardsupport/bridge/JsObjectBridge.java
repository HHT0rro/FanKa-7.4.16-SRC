package com.huawei.qcardsupport.bridge;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.jslite.type.JavaObjectProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsObjectBridge implements FLImmutableMap, JavaObjectProxy {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33095c = "JsObjectBridge";

    /* renamed from: a, reason: collision with root package name */
    private final FLImmutableMap f33096a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Object> f33097b = new HashMap();

    public JsObjectBridge(@NonNull FLImmutableMap fLImmutableMap) {
        this.f33096a = fLImmutableMap;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(String str) {
        Object obj = this.f33097b.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f33096a.get(str);
        Object a10 = JsBridges.a(obj2);
        if (a10 != obj2) {
            this.f33097b.put(str, a10);
        }
        return a10;
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public Object getFieldValue(String str) throws NoSuchFieldException {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        throw new NoSuchFieldException();
    }

    public final boolean isArray() {
        return false;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        return this.f33096a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public String[] keys() {
        return this.f33096a.keys();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str) {
        return this.f33096a.optBoolean(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str) {
        return this.f33096a.optDouble(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str) {
        return this.f33096a.optInt(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str) {
        return this.f33096a.optLong(str);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str) {
        return this.f33096a.optString(str);
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public void setFieldValue(String str, Object obj) throws NoSuchFieldException {
        Log.w(f33095c, "attempted to modify read-only data.");
        throw new NoSuchFieldException();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return this.f33096a.size();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public JsArrayBridge optArray(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof JsArrayBridge) {
            return (JsArrayBridge) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str, boolean z10) {
        return this.f33096a.optBoolean(str, z10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str, double d10) {
        return this.f33096a.optDouble(str, d10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str, int i10) {
        return this.f33096a.optInt(str, i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str, long j10) {
        return this.f33096a.optLong(str, j10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public JsObjectBridge optMap(@NonNull String str) {
        Object obj = get(str);
        if (obj instanceof JsObjectBridge) {
            return (JsObjectBridge) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str, String str2) {
        return this.f33096a.optString(str, str2);
    }
}
