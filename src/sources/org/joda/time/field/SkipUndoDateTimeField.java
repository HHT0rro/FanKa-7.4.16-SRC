package org.joda.time.field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SkipUndoDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = -5875876968979L;
    private final org.joda.time.a iChronology;
    private transient int iMinValue;
    private final int iSkip;

    public SkipUndoDateTimeField(org.joda.time.a aVar, org.joda.time.b bVar) {
        this(aVar, bVar, 0);
    }

    private Object readResolve() {
        return getType().getField(this.iChronology);
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public int get(long j10) {
        int i10 = super.get(j10);
        return i10 < this.iSkip ? i10 + 1 : i10;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public int getMinimumValue() {
        return this.iMinValue;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public long set(long j10, int i10) {
        e.n(this, i10, this.iMinValue, getMaximumValue());
        if (i10 <= this.iSkip) {
            i10--;
        }
        return super.set(j10, i10);
    }

    public SkipUndoDateTimeField(org.joda.time.a aVar, org.joda.time.b bVar, int i10) {
        super(bVar);
        this.iChronology = aVar;
        int minimumValue = super.getMinimumValue();
        if (minimumValue < i10) {
            this.iMinValue = minimumValue + 1;
        } else if (minimumValue == i10 + 1) {
            this.iMinValue = i10;
        } else {
            this.iMinValue = minimumValue;
        }
        this.iSkip = i10;
    }
}
