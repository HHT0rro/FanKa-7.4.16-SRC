package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CompositeFileComparator extends AbstractFileComparator implements Serializable {
    private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
    private final Comparator<File>[] delegates;

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Comparator<java.io.File>[], java.util.Comparator<?>[]] */
    public CompositeFileComparator(Comparator<File>... comparatorArr) {
        if (comparatorArr == null) {
            this.delegates = NO_COMPARATORS;
            return;
        }
        Comparator<File>[] comparatorArr2 = new Comparator[comparatorArr.length];
        this.delegates = comparatorArr2;
        System.arraycopy(comparatorArr, 0, comparatorArr2, 0, comparatorArr.length);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort((List<File>) list);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append('{');
        for (int i10 = 0; i10 < this.delegates.length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append((Object) this.delegates[i10]);
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        int i10 = 0;
        for (Comparator<File> comparator : this.delegates) {
            i10 = comparator.compare(file, file2);
            if (i10 != 0) {
                break;
            }
        }
        return i10;
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.Comparator<java.io.File>[], java.util.Comparator<?>[]] */
    public CompositeFileComparator(Iterable<Comparator<File>> iterable) {
        if (iterable == null) {
            this.delegates = NO_COMPARATORS;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Comparator<File>> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        this.delegates = (Comparator[]) arrayList.toArray(new Comparator[arrayList.size()]);
    }
}
