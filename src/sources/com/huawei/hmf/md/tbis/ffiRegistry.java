package com.huawei.hmf.md.tbis;

import com.huawei.ffi.api.JavaCall;
import com.huawei.hmf.md.spec.ffi;
import com.huawei.hmf.orb.tbis.TBModuleRegistry;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ffiRegistry extends TBModuleRegistry {
    public static final String name() {
        return ffi.name;
    }

    @Override // com.huawei.hmf.orb.tbis.TBModuleRegistry
    public final String getName() {
        return name();
    }

    @Override // com.huawei.hmf.orb.tbis.TBModuleRegistry
    public final void registry() {
        add("Map", Map.class, ffi.api.HashMap);
        add("Map", Map.class, ffi.api.LinkedHashMap);
        add("List", List.class, ffi.api.ArrayList);
        add("JavaCall", JavaCall.class, ffi.api.javacall);
    }
}
