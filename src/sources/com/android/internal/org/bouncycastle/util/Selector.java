package com.android.internal.org.bouncycastle.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Selector<T> extends Cloneable {
    Object clone();

    boolean match(T t2);
}