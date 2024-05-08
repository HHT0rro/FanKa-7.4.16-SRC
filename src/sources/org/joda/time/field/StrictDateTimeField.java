package org.joda.time.field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StrictDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = 3154803964207950910L;

    public StrictDateTimeField(org.joda.time.b bVar) {
        super(bVar);
    }

    public static org.joda.time.b getInstance(org.joda.time.b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar instanceof LenientDateTimeField) {
            bVar = ((LenientDateTimeField) bVar).getWrappedField();
        }
        return !bVar.isLenient() ? bVar : new StrictDateTimeField(bVar);
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public final boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public long set(long j10, int i10) {
        e.n(this, i10, getMinimumValue(j10), getMaximumValue(j10));
        return super.set(j10, i10);
    }
}
