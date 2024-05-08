package com.huawei.qcardsupport.bridge;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLImmutableArray;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.jslite.type.JavaObjectProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsArrayBridge implements FLImmutableArray, JavaObjectProxy {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33092c = "JsArrayBridge";

    /* renamed from: a, reason: collision with root package name */
    private final FLImmutableArray f33093a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, Object> f33094b = new HashMap();

    public JsArrayBridge(@NonNull FLImmutableArray fLImmutableArray) {
        this.f33093a = fLImmutableArray;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public Object get(int i10) {
        Object obj = this.f33094b.get(Integer.valueOf(i10));
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f33093a.get(i10);
        Object a10 = JsBridges.a(obj2);
        if (a10 != obj2) {
            this.f33094b.put(Integer.valueOf(i10), a10);
        }
        return a10;
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public Object getFieldValue(String str) throws NoSuchFieldException {
        try {
            Object obj = get(Integer.parseInt(str));
            if (obj != null) {
                return obj;
            }
        } catch (NumberFormatException unused) {
        }
        throw new NoSuchFieldException();
    }

    public final boolean isArray() {
        return true;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public boolean isEmpty() {
        return this.f33093a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public boolean optBoolean(int i10) {
        return this.f33093a.optBoolean(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public double optDouble(int i10) {
        return this.f33093a.optDouble(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public int optInt(int i10) {
        return this.f33093a.optInt(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public long optLong(int i10) {
        return this.f33093a.optLong(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public String optString(int i10) {
        return this.f33093a.optString(i10);
    }

    @Override // com.huawei.jslite.type.JavaObjectProxy
    public void setFieldValue(String str, Object obj) throws NoSuchFieldException {
        Log.w(f33092c, "attempted to modify read-only data.");
        throw new NoSuchFieldException();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public int size() {
        return this.f33093a.size();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public JsArrayBridge optArray(int i10) {
        Object obj = get(i10);
        if (obj instanceof JsArrayBridge) {
            return (JsArrayBridge) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public boolean optBoolean(int i10, boolean z10) {
        return this.f33093a.optBoolean(i10, z10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public double optDouble(int i10, double d10) {
        return this.f33093a.optDouble(i10, d10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public int optInt(int i10, int i11) {
        return this.f33093a.optInt(i10, i11);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public long optLong(int i10, long j10) {
        return this.f33093a.optLong(i10, j10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public JsObjectBridge optMap(int i10) {
        Object obj = get(i10);
        if (obj instanceof JsObjectBridge) {
            return (JsObjectBridge) obj;
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableArray
    public String optString(int i10, String str) {
        return this.f33093a.optString(i10, str);
    }
}
