package kotlin.collections;

import java.util.Iterator;

/* compiled from: PrimitiveIterators.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class q implements Iterator<Character>, zd.a {
    public abstract char a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
