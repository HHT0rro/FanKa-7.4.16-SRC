package sun.misc;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CompoundEnumeration<E> implements Enumeration<E> {
    private Enumeration<E>[] enums;
    private int index = 0;

    public CompoundEnumeration(Enumeration<E>[] enums) {
        this.enums = enums;
    }

    private boolean next() {
        while (true) {
            int i10 = this.index;
            Enumeration<E>[] enumerationArr = this.enums;
            if (i10 < enumerationArr.length) {
                Enumeration<E> enumeration = enumerationArr[i10];
                if (enumeration != null && enumeration.hasMoreElements()) {
                    return true;
                }
                this.index++;
            } else {
                return false;
            }
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return next();
    }

    @Override // java.util.Enumeration
    public E nextElement() {
        if (!next()) {
            throw new NoSuchElementException();
        }
        return this.enums[this.index].nextElement();
    }
}
