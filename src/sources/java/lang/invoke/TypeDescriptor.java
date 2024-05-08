package java.lang.invoke;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface TypeDescriptor {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfField<F extends OfField<F>> extends TypeDescriptor {
        F arrayType();

        F componentType();

        boolean isArray();

        boolean isPrimitive();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface OfMethod<F extends OfField<F>, M extends OfMethod<F, M>> extends TypeDescriptor {
        M changeParameterType(int i10, F f10);

        M changeReturnType(F f10);

        M dropParameterTypes(int i10, int i11);

        M insertParameterTypes(int i10, F... fArr);

        F[] parameterArray();

        int parameterCount();

        List<F> parameterList();

        F parameterType(int i10);

        F returnType();
    }

    String descriptorString();
}
