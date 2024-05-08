package org.apache.commons.collections4;

import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface BoundedCollection<E> extends Collection<E> {
    boolean isFull();

    int maxSize();
}
