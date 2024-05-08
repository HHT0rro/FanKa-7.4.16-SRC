package ke;

import org.joda.time.DateTime;
import org.joda.time.Period;

/* compiled from: StringConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s extends a implements h, l, g, m, i {

    /* renamed from: a, reason: collision with root package name */
    public static final s f50899a = new s();

    @Override // ke.m
    public void d(org.joda.time.f fVar, Object obj, org.joda.time.a aVar) {
        String str = (String) obj;
        org.joda.time.format.n a10 = org.joda.time.format.j.a();
        fVar.clear();
        int f10 = a10.f(fVar, str, 0);
        if (f10 < str.length()) {
            if (f10 < 0) {
                a10.j(fVar.getPeriodType()).g(str);
            }
            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
        }
    }

    @Override // ke.c
    public Class<?> e() {
        return String.class;
    }

    @Override // ke.a, ke.l
    public int[] f(org.joda.time.k kVar, Object obj, org.joda.time.a aVar, org.joda.time.format.b bVar) {
        if (bVar.e() != null) {
            aVar = aVar.withZone(bVar.e());
        }
        return aVar.get(kVar, bVar.u(aVar).j((String) obj));
    }

    @Override // ke.g
    public long g(Object obj) {
        long parseLong;
        long j10;
        long j11;
        String str = (String) obj;
        int length = str.length();
        if (length >= 4 && ((str.charAt(0) == 'P' || str.charAt(0) == 'p') && (str.charAt(1) == 'T' || str.charAt(1) == 't'))) {
            int i10 = length - 1;
            if (str.charAt(i10) == 'S' || str.charAt(i10) == 's') {
                String substring = str.substring(2, i10);
                int i11 = 0;
                int i12 = -1;
                for (int i13 = 0; i13 < substring.length(); i13++) {
                    if (substring.charAt(i13) < '0' || substring.charAt(i13) > '9') {
                        if (i13 == 0 && substring.charAt(0) == '-') {
                            i11 = 1;
                        } else {
                            if (i13 <= i11 || substring.charAt(i13) != '.' || i12 != -1) {
                                throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
                            }
                            i12 = i13;
                        }
                    }
                }
                if (i12 > 0) {
                    j10 = Long.parseLong(substring.substring(i11, i12));
                    String substring2 = substring.substring(i12 + 1);
                    if (substring2.length() != 3) {
                        substring2 = (substring2 + "000").substring(0, 3);
                    }
                    j11 = Integer.parseInt(substring2);
                } else {
                    if (i11 != 0) {
                        parseLong = Long.parseLong(substring.substring(i11, substring.length()));
                    } else {
                        parseLong = Long.parseLong(substring);
                    }
                    j10 = parseLong;
                    j11 = 0;
                }
                if (i11 != 0) {
                    return org.joda.time.field.e.e(org.joda.time.field.e.i(-j10, 1000), -j11);
                }
                return org.joda.time.field.e.e(org.joda.time.field.e.i(j10, 1000), j11);
            }
        }
        throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
    }

    @Override // ke.i
    public void j(org.joda.time.e eVar, Object obj, org.joda.time.a aVar) {
        Period h10;
        long add;
        String str = (String) obj;
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            if (substring.length() > 0) {
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    org.joda.time.format.b u10 = org.joda.time.format.i.i().u(aVar);
                    org.joda.time.format.n a10 = org.joda.time.format.j.a();
                    long j10 = 0;
                    char charAt = substring.charAt(0);
                    org.joda.time.a aVar2 = null;
                    if (charAt != 'P' && charAt != 'p') {
                        DateTime f10 = u10.f(substring);
                        j10 = f10.getMillis();
                        aVar2 = f10.getChronology();
                        h10 = null;
                    } else {
                        h10 = a10.j(h(substring)).h(substring);
                    }
                    char charAt2 = substring2.charAt(0);
                    if (charAt2 != 'P' && charAt2 != 'p') {
                        DateTime f11 = u10.f(substring2);
                        add = f11.getMillis();
                        if (aVar2 == null) {
                            aVar2 = f11.getChronology();
                        }
                        if (aVar != null) {
                            aVar2 = aVar;
                        }
                        if (h10 != null) {
                            j10 = aVar2.add(h10, add, -1);
                        }
                    } else if (h10 == null) {
                        Period h11 = a10.j(h(substring2)).h(substring2);
                        if (aVar != null) {
                            aVar2 = aVar;
                        }
                        add = aVar2.add(h11, j10, 1);
                    } else {
                        throw new IllegalArgumentException("Interval composed of two durations: " + str);
                    }
                    eVar.setInterval(j10, add);
                    eVar.setChronology(aVar2);
                    return;
                }
                throw new IllegalArgumentException("Format invalid: " + str);
            }
            throw new IllegalArgumentException("Format invalid: " + str);
        }
        throw new IllegalArgumentException("Format requires a '/' separator: " + str);
    }

    @Override // ke.a, ke.h
    public long k(Object obj, org.joda.time.a aVar) {
        return org.joda.time.format.i.i().u(aVar).j((String) obj);
    }
}
