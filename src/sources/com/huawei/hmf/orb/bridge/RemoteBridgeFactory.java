package com.huawei.hmf.orb.bridge;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.taskstream.TaskStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteBridgeFactory {
    private static Map<Class, Class<? extends Bridge>> mFactoryMap;

    static {
        HashMap hashMap = new HashMap();
        mFactoryMap = hashMap;
        hashMap.put(TaskStream.class, TaskStreamBridge.class);
        mFactoryMap.put(Task.class, TaskBridge.class);
    }

    private RemoteBridgeFactory() {
    }

    public static Bridge getBridge(Class<?> cls) {
        for (Map.Entry<Class, Class<? extends Bridge>> entry : mFactoryMap.entrySet()) {
            if (entry.getKey().isAssignableFrom(cls)) {
                try {
                    return entry.getValue().newInstance();
                } catch (Exception unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static void register(Class<?> cls, Class<? extends Bridge> cls2) {
        mFactoryMap.put(cls, cls2);
    }
}
