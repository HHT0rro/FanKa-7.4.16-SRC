package com.huawei.hmf.orb.tbis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.orb.tbis.TBNativeType;
import com.huawei.hmf.orb.tbis.type.BundleRef;
import com.huawei.hmf.orb.tbis.type.IntentRef;
import com.huawei.hmf.orb.tbis.type.ObjectRef;
import com.huawei.hmf.orb.tbis.type.TaskRef;
import com.huawei.hmf.orb.tbis.type.TaskStreamRef;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.taskstream.TaskStream;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class RegistryInit {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class StringFactory<T> implements TBNativeType.Factory<String, T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
        public /* bridge */ /* synthetic */ String create(Object obj) {
            return create2((StringFactory<T>) obj);
        }

        @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
        /* renamed from: create, reason: avoid collision after fix types in other method */
        public String create2(T t2) {
            return TextCodecFactory.create().toString(t2);
        }
    }

    static {
        TBNativeType.registry(Task.class, null, new TBNativeType.Factory<TaskRef, Task>() { // from class: com.huawei.hmf.orb.tbis.RegistryInit.1
            @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
            public TaskRef create(Task task) {
                return new TaskRef(task);
            }
        });
        TBNativeType.registry(TaskStream.class, null, new TBNativeType.Factory<TaskStreamRef, TaskStream>() { // from class: com.huawei.hmf.orb.tbis.RegistryInit.2
            @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
            public TaskStreamRef create(TaskStream taskStream) {
                return new TaskStreamRef(taskStream);
            }
        });
        TBNativeType.registry(Intent.class, TBNativeType.newUnBoxedFactory(IntentRef.class), new TBNativeType.Factory<IntentRef, Intent>() { // from class: com.huawei.hmf.orb.tbis.RegistryInit.3
            @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
            public IntentRef create(Intent intent) {
                return new IntentRef(intent);
            }
        });
        TBNativeType.registry(Bundle.class, TBNativeType.newUnBoxedFactory(BundleRef.class), new TBNativeType.Factory<BundleRef, Bundle>() { // from class: com.huawei.hmf.orb.tbis.RegistryInit.4
            @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
            public BundleRef create(Bundle bundle) {
                return new BundleRef(bundle);
            }
        });
        TBNativeType.registry(Context.class, ObjectRef.UnBoxedFactory, ObjectRef.BoxedFactory);
        TBNativeType.registry(List.class, null, new StringFactory());
        TBNativeType.registry(Map.class, null, new StringFactory());
    }

    public static void init() {
    }
}
