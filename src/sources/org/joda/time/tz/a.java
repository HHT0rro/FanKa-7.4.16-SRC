package org.joda.time.tz;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: DefaultNameProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<Locale, Map<String, Map<String, Object>>> f52705a = c();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<Locale, Map<String, Map<Boolean, Object>>> f52706b = c();

    @Override // org.joda.time.tz.b
    public String a(Locale locale, String str, String str2) {
        String[] e2 = e(locale, str, str2);
        if (e2 == null) {
            return null;
        }
        return e2[0];
    }

    @Override // org.joda.time.tz.b
    public String b(Locale locale, String str, String str2) {
        String[] e2 = e(locale, str, str2);
        if (e2 == null) {
            return null;
        }
        return e2[1];
    }

    public final HashMap c() {
        return new HashMap(7);
    }

    public String d(Locale locale, String str, String str2, boolean z10) {
        String[] f10 = f(locale, str, str2, z10);
        if (f10 == null) {
            return null;
        }
        return f10[1];
    }

    public final synchronized String[] e(Locale locale, String str, String str2) {
        String[] strArr;
        Object[] objArr = null;
        if (locale == null || str == null || str2 == null) {
            return null;
        }
        Map map = this.f52705a.get(locale);
        if (map == null) {
            HashMap<Locale, Map<String, Map<String, Object>>> hashMap = this.f52705a;
            HashMap c4 = c();
            hashMap.put(locale, c4);
            map = c4;
        }
        Map map2 = (Map) map.get(str);
        if (map2 == null) {
            map2 = c();
            map.put(str, map2);
            String[][] zoneStrings = org.joda.time.c.d(Locale.ENGLISH).getZoneStrings();
            int length = zoneStrings.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    strArr = null;
                    break;
                }
                strArr = zoneStrings[i10];
                if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                    break;
                }
                i10++;
            }
            Object[][] zoneStrings2 = org.joda.time.c.d(locale).getZoneStrings();
            int length2 = zoneStrings2.length;
            int i11 = 0;
            while (true) {
                if (i11 < length2) {
                    Object[] objArr2 = zoneStrings2[i11];
                    if (objArr2 != null && objArr2.length >= 5 && str.equals(objArr2[0])) {
                        objArr = objArr2;
                        break;
                    }
                    i11++;
                } else {
                    break;
                }
            }
            if (strArr != null && objArr != null) {
                map2.put(strArr[2], new String[]{objArr[2], objArr[1]});
                if (strArr[2].equals(strArr[4])) {
                    map2.put(strArr[4] + "-Summer", new String[]{objArr[4], objArr[3]});
                } else {
                    map2.put(strArr[4], new String[]{objArr[4], objArr[3]});
                }
            }
        }
        return (String[]) map2.get(str2);
    }

    public final synchronized String[] f(Locale locale, String str, String str2, boolean z10) {
        String[] strArr;
        String[] strArr2 = null;
        if (locale == null || str == null || str2 == null) {
            return null;
        }
        if (str.startsWith("Etc/")) {
            str = str.substring(4);
        }
        Map map = this.f52706b.get(locale);
        if (map == null) {
            HashMap<Locale, Map<String, Map<Boolean, Object>>> hashMap = this.f52706b;
            HashMap c4 = c();
            hashMap.put(locale, c4);
            map = c4;
        }
        Map map2 = (Map) map.get(str);
        if (map2 == null) {
            map2 = c();
            map.put(str, map2);
            String[][] zoneStrings = org.joda.time.c.d(Locale.ENGLISH).getZoneStrings();
            int length = zoneStrings.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    strArr = null;
                    break;
                }
                strArr = zoneStrings[i10];
                if (strArr != null && strArr.length >= 5 && str.equals(strArr[0])) {
                    break;
                }
                i10++;
            }
            String[][] zoneStrings2 = org.joda.time.c.d(locale).getZoneStrings();
            int length2 = zoneStrings2.length;
            int i11 = 0;
            while (true) {
                if (i11 < length2) {
                    String[] strArr3 = zoneStrings2[i11];
                    if (strArr3 != null && strArr3.length >= 5 && str.equals(strArr3[0])) {
                        strArr2 = strArr3;
                        break;
                    }
                    i11++;
                } else {
                    break;
                }
            }
            if (strArr != null && strArr2 != null) {
                map2.put(Boolean.TRUE, new String[]{strArr2[2], strArr2[1]});
                map2.put(Boolean.FALSE, new String[]{strArr2[4], strArr2[3]});
            }
        }
        return (String[]) map2.get(Boolean.valueOf(z10));
    }

    public String g(Locale locale, String str, String str2, boolean z10) {
        String[] f10 = f(locale, str, str2, z10);
        if (f10 == null) {
            return null;
        }
        return f10[0];
    }
}
