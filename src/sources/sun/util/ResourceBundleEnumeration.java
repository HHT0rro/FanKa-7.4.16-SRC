package sun.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ResourceBundleEnumeration implements Enumeration<String> {
    Enumeration<String> enumeration;
    Iterator<String> iterator;
    String next = null;
    Set<String> set;

    public ResourceBundleEnumeration(Set<String> set, Enumeration<String> enumeration) {
        this.set = set;
        this.iterator = set.iterator2();
        this.enumeration = enumeration;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        if (this.next == null) {
            if (this.iterator.hasNext()) {
                this.next = this.iterator.next();
            } else if (this.enumeration != null) {
                while (this.next == null && this.enumeration.hasMoreElements()) {
                    String nextElement = this.enumeration.nextElement();
                    this.next = nextElement;
                    if (this.set.contains(nextElement)) {
                        this.next = null;
                    }
                }
            }
        }
        return this.next != null;
    }

    @Override // java.util.Enumeration
    public String nextElement() {
        if (hasMoreElements()) {
            String result = this.next;
            this.next = null;
            return result;
        }
        throw new NoSuchElementException();
    }
}
