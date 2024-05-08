package org.joda.time.field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LenientDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = 8714085824173290599L;
    private final org.joda.time.a iBase;

    public LenientDateTimeField(org.joda.time.b bVar, org.joda.time.a aVar) {
        super(bVar);
        this.iBase = aVar;
    }

    public static org.joda.time.b getInstance(org.joda.time.b bVar, org.joda.time.a aVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar instanceof StrictDateTimeField) {
            bVar = ((StrictDateTimeField) bVar).getWrappedField();
        }
        return bVar.isLenient() ? bVar : new LenientDateTimeField(bVar, aVar);
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public final boolean isLenient() {
        return true;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public long set(long j10, int i10) {
        return this.iBase.getZone().convertLocalToUTC(getType().getField(this.iBase.withUTC()).add(this.iBase.getZone().convertUTCToLocal(j10), e.l(i10, get(j10))), false, j10);
    }
}
