package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SwitchTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = -6404460890903469332L;
    private final Transformer<? super I, ? extends O> iDefault;
    private final Predicate<? super I>[] iPredicates;
    private final Transformer<? super I, ? extends O>[] iTransformers;

    private SwitchTransformer(boolean z10, Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this.iPredicates = z10 ? FunctorUtils.copy(predicateArr) : predicateArr;
        this.iTransformers = z10 ? FunctorUtils.copy(transformerArr) : transformerArr;
        this.iDefault = transformer == null ? ConstantTransformer.nullTransformer() : transformer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        FunctorUtils.validate(predicateArr);
        FunctorUtils.validate(transformerArr);
        if (predicateArr.length == transformerArr.length) {
            if (predicateArr.length == 0) {
                return transformer == 0 ? ConstantTransformer.nullTransformer() : transformer;
            }
            return new SwitchTransformer(predicateArr, transformerArr, transformer);
        }
        throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
    }

    public Transformer<? super I, ? extends O> getDefaultTransformer() {
        return this.iDefault;
    }

    public Predicate<? super I>[] getPredicates() {
        return FunctorUtils.copy(this.iPredicates);
    }

    public Transformer<? super I, ? extends O>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i10) {
        int i11 = 0;
        while (true) {
            Predicate<? super I>[] predicateArr = this.iPredicates;
            if (i11 < predicateArr.length) {
                if (predicateArr[i11].evaluate(i10)) {
                    return this.iTransformers[i11].transform(i10);
                }
                i11++;
            } else {
                return this.iDefault.transform(i10);
            }
        }
    }

    public SwitchTransformer(Predicate<? super I>[] predicateArr, Transformer<? super I, ? extends O>[] transformerArr, Transformer<? super I, ? extends O> transformer) {
        this(true, predicateArr, transformerArr, transformer);
    }

    public static <I, O> Transformer<I, O> switchTransformer(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> map) {
        Objects.requireNonNull(map, "The predicate and transformer map must not be null");
        if (map.size() == 0) {
            return ConstantTransformer.nullTransformer();
        }
        Transformer<? super I, ? extends O> remove = map.remove(null);
        int size = map.size();
        if (size == 0) {
            return remove == null ? ConstantTransformer.nullTransformer() : remove;
        }
        Transformer[] transformerArr = new Transformer[size];
        Predicate[] predicateArr = new Predicate[size];
        int i10 = 0;
        for (Map.Entry<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> entry : map.entrySet()) {
            predicateArr[i10] = entry.getKey();
            transformerArr[i10] = entry.getValue();
            i10++;
        }
        return new SwitchTransformer(false, predicateArr, transformerArr, remove);
    }
}
