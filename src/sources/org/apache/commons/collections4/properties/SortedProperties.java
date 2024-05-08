package org.apache.commons.collections4.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.collections4.iterators.IteratorEnumeration;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SortedProperties extends Properties {
    private static final long serialVersionUID = 1;

    @Override // java.util.Hashtable, java.util.Dictionary
    public synchronized Enumeration<Object> keys() {
        ArrayList arrayList;
        Set<Object> keySet = keySet();
        arrayList = new ArrayList(keySet.size());
        Iterator<Object> iterator2 = keySet.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().toString());
        }
        Collections.sort(arrayList);
        return new IteratorEnumeration(arrayList.iterator2());
    }
}
