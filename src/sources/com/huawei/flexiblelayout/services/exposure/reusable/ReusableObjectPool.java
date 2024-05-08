package com.huawei.flexiblelayout.services.exposure.reusable;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReusableObjectPool {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28605b = "ReusableObjectPool";

    /* renamed from: c, reason: collision with root package name */
    private static final ReusableObjectPool f28606c = new ReusableObjectPool();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends ReusableObject>, List<ReusableObject>> f28607a = new HashMap();

    private ReusableObjectPool() {
    }

    private List<ReusableObject> a(Class<? extends ReusableObject> cls) {
        List<ReusableObject> list = this.f28607a.get(cls);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.f28607a.put(cls, arrayList);
        return arrayList;
    }

    public static ReusableObjectPool getInstance() {
        return f28606c;
    }

    @NonNull
    public <T extends ReusableObject> T acquire(Class<T> cls) {
        List<ReusableObject> a10 = a(cls);
        if (a10.isEmpty()) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
                throw new RuntimeException("ReusableObjectPool getObject failed, " + ((Object) cls) + " has no default constructor");
            }
        }
        return (T) a10.remove(a10.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void recycle(@NonNull ReusableObject reusableObject) {
        reusableObject.reset();
        a(reusableObject.getClass()).add(reusableObject);
    }
}
