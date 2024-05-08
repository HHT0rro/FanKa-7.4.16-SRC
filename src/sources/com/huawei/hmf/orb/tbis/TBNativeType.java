package com.huawei.hmf.orb.tbis;

import com.huawei.hmf.orb.tbis.result.TBResultParser;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TBNativeType {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Factory<T, R> {
        T create(R r10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface UnboxFactory<R> extends Factory<Object, R> {
        Class<R> getType();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Unboxable<T> {
        T unboxing();
    }

    public static <T extends Unboxable> Factory newUnBoxedFactory(final Class<T> cls) {
        return new UnboxFactory<T>() { // from class: com.huawei.hmf.orb.tbis.TBNativeType.1
            @Override // com.huawei.hmf.orb.tbis.TBNativeType.UnboxFactory
            public Class<T> getType() {
                return Class.this;
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Object; */
            @Override // com.huawei.hmf.orb.tbis.TBNativeType.Factory
            public Object create(Unboxable unboxable) {
                if (unboxable == null) {
                    return null;
                }
                return unboxable.unboxing();
            }
        };
    }

    public static void registry(Type type, Factory factory, Factory factory2) {
        if (factory != null) {
            NativeTypeBridge.registry(type, factory);
        }
        if (factory2 != null) {
            TBResultParser.registry(type, factory2);
        }
    }
}
