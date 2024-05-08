package com.google.common.collect;

import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SortedLists {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return i10 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return i10;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i10) {
                return ~i10;
            }
        };

        public abstract int resultIndex(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i10) {
                return i10;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i10) {
                int size = list.size() - 1;
                while (i10 < size) {
                    int i11 = ((i10 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i11), e2) > 0) {
                        size = i11 - 1;
                    } else {
                        i10 = i11;
                    }
                }
                return i10;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i10) {
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (i11 + i10) >>> 1;
                    if (comparator.compare(list.get(i12), e2) < 0) {
                        i11 = i12 + 1;
                    } else {
                        i10 = i12;
                    }
                }
                return i11;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i10) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e2, list, i10) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i10) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e2, list, i10) - 1;
            }
        };

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i10);
    }

    public static <E, K extends Comparable> int a(List<E> list, com.google.common.base.g<? super E, K> gVar, K k10, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        com.google.common.base.o.r(k10);
        return b(list, gVar, k10, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, com.google.common.base.g<? super E, K> gVar, K k10, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.p(list, gVar), k10, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int c(List<? extends E> list, E e2, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        com.google.common.base.o.r(comparator);
        com.google.common.base.o.r(list);
        com.google.common.base.o.r(keyPresentBehavior);
        com.google.common.base.o.r(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.k(list);
        }
        int i10 = 0;
        int size = list.size() - 1;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int compare = comparator.compare(e2, list.get(i11));
            if (compare < 0) {
                size = i11 - 1;
            } else {
                if (compare <= 0) {
                    return i10 + keyPresentBehavior.resultIndex(comparator, e2, list.subList(i10, size + 1), i11 - i10);
                }
                i10 = i11 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i10);
    }
}
