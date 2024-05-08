package ke;

import org.joda.time.DateTimeZone;

/* compiled from: ReadablePartialConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q extends a implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final q f50897a = new q();

    @Override // ke.a, ke.h, ke.l
    public org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        return aVar == null ? org.joda.time.c.c(((org.joda.time.k) obj).getChronology()) : aVar;
    }

    @Override // ke.a, ke.h, ke.l
    public org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        return a(obj, null).withZone(dateTimeZone);
    }

    @Override // ke.c
    public Class<?> e() {
        return org.joda.time.k.class;
    }

    @Override // ke.a, ke.l
    public int[] i(org.joda.time.k kVar, Object obj, org.joda.time.a aVar) {
        org.joda.time.k kVar2 = (org.joda.time.k) obj;
        int size = kVar.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = kVar2.get(kVar.getFieldType(i10));
        }
        aVar.validate(kVar, iArr);
        return iArr;
    }
}
