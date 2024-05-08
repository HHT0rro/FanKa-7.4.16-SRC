package org.apache.commons.collections4.comparators;

import com.android.internal.logging.nano.MetricsProto;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformingComparator<I, O> implements Comparator<I>, Serializable {
    private static final long serialVersionUID = 3456940356043606220L;
    private final Comparator<O> decorated;
    private final Transformer<? super I, ? extends O> transformer;

    public TransformingComparator(Transformer<? super I, ? extends O> transformer) {
        this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
    }

    @Override // java.util.Comparator
    public int compare(I i10, I i11) {
        return this.decorated.compare(this.transformer.transform(i10), this.transformer.transform(i11));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TransformingComparator transformingComparator = (TransformingComparator) obj;
        Comparator<O> comparator = this.decorated;
        if (comparator != null ? comparator.equals(transformingComparator.decorated) : transformingComparator.decorated == null) {
            Transformer<? super I, ? extends O> transformer = this.transformer;
            Transformer<? super I, ? extends O> transformer2 = transformingComparator.transformer;
            if (transformer == null) {
                if (transformer2 == null) {
                    return true;
                }
            } else if (transformer.equals(transformer2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Comparator<O> comparator = this.decorated;
        int hashCode = (MetricsProto.MetricsEvent.TEXT_LONGPRESS + (comparator == null ? 0 : comparator.hashCode())) * 37;
        Transformer<? super I, ? extends O> transformer = this.transformer;
        return hashCode + (transformer != null ? transformer.hashCode() : 0);
    }

    public TransformingComparator(Transformer<? super I, ? extends O> transformer, Comparator<O> comparator) {
        this.decorated = comparator;
        this.transformer = transformer;
    }
}
