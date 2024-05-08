package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.creator.ObjectCreator;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.task.TaskHandler;
import com.huawei.flexiblelayout.services.task.TaskHandlerRegistryService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TaskHandlerRegistryServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class p1 implements TaskHandlerRegistryService {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28280b = "TaskHandlerRegistryServ";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Class<? extends TaskHandler>> f28281a = new HashMap();

    @Override // com.huawei.flexiblelayout.services.task.TaskHandlerRegistryService
    public TaskHandler create(String str, FLMap fLMap) {
        Class<? extends TaskHandler> cls = this.f28281a.get(str);
        if (cls != null) {
            return (TaskHandler) ObjectCreator.create(cls, new Class[]{FLMap.class}, fLMap);
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.services.task.TaskHandlerRegistryService
    public void register(String str, Class<? extends TaskHandler> cls) {
        if (this.f28281a.get(str) != null) {
            Log.w(f28280b, "TaskHandlerRegistryService.register called multiple times for same name " + str);
        }
        this.f28281a.put(str, cls);
    }
}
