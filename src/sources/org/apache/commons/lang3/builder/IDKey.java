package org.apache.commons.lang3.builder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class IDKey {

    /* renamed from: id, reason: collision with root package name */
    private final int f52397id;
    private final Object value;

    public IDKey(Object obj) {
        this.f52397id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f52397id == iDKey.f52397id && this.value == iDKey.value;
    }

    public int hashCode() {
        return this.f52397id;
    }
}
