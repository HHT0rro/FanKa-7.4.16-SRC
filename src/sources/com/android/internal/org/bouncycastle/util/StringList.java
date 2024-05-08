package com.android.internal.org.bouncycastle.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface StringList extends Iterable<String> {
    boolean add(String str);

    String get(int i10);

    int size();

    String[] toStringArray();

    String[] toStringArray(int i10, int i11);
}
