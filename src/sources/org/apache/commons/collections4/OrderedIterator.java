package org.apache.commons.collections4;

import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface OrderedIterator<E> extends Iterator<E> {
    boolean hasPrevious();

    E previous();
}
