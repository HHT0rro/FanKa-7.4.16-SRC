package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformerClosure<E> implements Closure<E>, Serializable {
    private static final long serialVersionUID = -5194992589193388969L;
    private final Transformer<? super E, ?> iTransformer;

    public TransformerClosure(Transformer<? super E, ?> transformer) {
        this.iTransformer = transformer;
    }

    public static <E> Closure<E> transformerClosure(Transformer<? super E, ?> transformer) {
        if (transformer == null) {
            return NOPClosure.nopClosure();
        }
        return new TransformerClosure(transformer);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e2) {
        this.iTransformer.transform(e2);
    }

    public Transformer<? super E, ?> getTransformer() {
        return this.iTransformer;
    }
}
