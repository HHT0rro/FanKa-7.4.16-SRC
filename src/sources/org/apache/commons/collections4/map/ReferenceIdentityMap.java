package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import org.apache.commons.collections4.map.AbstractReferenceMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ReferenceIdentityMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    public ReferenceIdentityMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractReferenceMap
    public int hashEntry(Object obj, Object obj2) {
        return System.identityHashCode(obj) ^ System.identityHashCode(obj2);
    }

    @Override // org.apache.commons.collections4.map.AbstractReferenceMap, org.apache.commons.collections4.map.AbstractHashedMap
    public boolean isEqualKey(Object obj, Object obj2) {
        if (!isKeyType(AbstractReferenceMap.ReferenceStrength.HARD)) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, boolean z10) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, z10);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i10, float f10) {
        super(referenceStrength, referenceStrength2, i10, f10, false);
    }

    public ReferenceIdentityMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i10, float f10, boolean z10) {
        super(referenceStrength, referenceStrength2, i10, f10, z10);
    }
}
