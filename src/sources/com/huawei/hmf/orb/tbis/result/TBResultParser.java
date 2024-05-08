package com.huawei.hmf.orb.tbis.result;

import com.huawei.hmf.orb.tbis.TBNativeType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TBResultParser {
    private static Map<Type, TBNativeType.Factory> typeAdapterMap = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SimpleResult extends TBResult {
        private final Object object;

        private SimpleResult(Object obj) {
            this.object = obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TBResult valueOf(Object obj) {
            return new SimpleResult(obj);
        }

        @Override // com.huawei.hmf.orb.tbis.result.TBResult
        public Object getValue() {
            return this.object;
        }
    }

    public static TBResult parser(Class<?> cls, Object obj) {
        TBNativeType.Factory factory = typeAdapterMap.get(cls);
        if (factory != null) {
            return SimpleResult.valueOf(obj == null ? null : factory.create(obj));
        }
        if (cls.isInterface()) {
            return SimpleResult.valueOf(obj);
        }
        return new DefaultResult(obj);
    }

    public static void registry(Type type, TBNativeType.Factory factory) {
        typeAdapterMap.put(type, factory);
    }
}
