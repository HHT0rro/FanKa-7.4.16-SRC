package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.s;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.p;

/* compiled from: TypesJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TypesJVMKt {
    public static final String b(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                kotlin.sequences.g e2 = SequencesKt__SequencesKt.e(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                name = ((Class) SequencesKt___SequencesKt.q(e2)).getName() + p.w("[]", SequencesKt___SequencesKt.h(e2));
            } else {
                name = cls.getName();
            }
            s.h(name, "{\n        if (type.isArr…   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }
}
