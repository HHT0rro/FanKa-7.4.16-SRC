package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FactoryTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory<? extends O> iFactory;

    public FactoryTransformer(Factory<? extends O> factory) {
        this.iFactory = factory;
    }

    public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> factory) {
        Objects.requireNonNull(factory, "Factory must not be null");
        return new FactoryTransformer(factory);
    }

    public Factory<? extends O> getFactory() {
        return this.iFactory;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i10) {
        return this.iFactory.create();
    }
}
