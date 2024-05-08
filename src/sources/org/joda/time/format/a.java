package org.joda.time.format;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.joda.time.DateTime;

/* compiled from: DateTimeFormat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f52576a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceArray<b> f52577b = new AtomicReferenceArray<>(25);

    public static b a(String str) {
        b putIfAbsent;
        if (str != null && str.length() != 0) {
            ConcurrentHashMap<String, b> concurrentHashMap = f52576a;
            b bVar = concurrentHashMap.get(str);
            if (bVar != null) {
                return bVar;
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            d(dateTimeFormatterBuilder, str);
            b e02 = dateTimeFormatterBuilder.e0();
            return (concurrentHashMap.size() >= 500 || (putIfAbsent = concurrentHashMap.putIfAbsent(str, e02)) == null) ? e02 : putIfAbsent;
        }
        throw new IllegalArgumentException("Invalid pattern specification");
    }

    public static b b(String str) {
        return a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r3) {
        /*
            int r0 = r3.length()
            r1 = 0
            if (r0 <= 0) goto L14
            char r3 = r3.charAt(r1)
            r2 = 1
            switch(r3) {
                case 67: goto L13;
                case 68: goto L13;
                case 70: goto L13;
                case 72: goto L13;
                case 75: goto L13;
                case 77: goto L10;
                case 83: goto L13;
                case 87: goto L13;
                case 89: goto L13;
                case 99: goto L13;
                case 100: goto L13;
                case 101: goto L13;
                case 104: goto L13;
                case 107: goto L13;
                case 109: goto L13;
                case 115: goto L13;
                case 119: goto L13;
                case 120: goto L13;
                case 121: goto L13;
                default: goto Lf;
            }
        Lf:
            goto L14
        L10:
            r3 = 2
            if (r0 > r3) goto L14
        L13:
            return r2
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.a.c(java.lang.String):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x005d. Please report as an issue. */
    public static void d(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        boolean z10;
        int length = str.length();
        int[] iArr = new int[1];
        int i10 = 0;
        while (i10 < length) {
            iArr[0] = i10;
            String e2 = e(str, iArr);
            int i11 = iArr[0];
            int length2 = e2.length();
            if (length2 == 0) {
                return;
            }
            char charAt = e2.charAt(0);
            if (charAt == '\'') {
                String substring = e2.substring(1);
                if (substring.length() == 1) {
                    dateTimeFormatterBuilder.x(substring.charAt(0));
                } else {
                    dateTimeFormatterBuilder.y(new String(substring));
                }
            } else if (charAt == 'K') {
                dateTimeFormatterBuilder.w(length2);
            } else if (charAt != 'M') {
                if (charAt == 'S') {
                    dateTimeFormatterBuilder.t(length2, length2);
                } else if (charAt == 'a') {
                    dateTimeFormatterBuilder.u();
                } else if (charAt == 'h') {
                    dateTimeFormatterBuilder.h(length2);
                } else if (charAt == 'k') {
                    dateTimeFormatterBuilder.g(length2);
                } else if (charAt == 'm') {
                    dateTimeFormatterBuilder.A(length2);
                } else if (charAt == 's') {
                    dateTimeFormatterBuilder.F(length2);
                } else if (charAt == 'G') {
                    dateTimeFormatterBuilder.o();
                } else if (charAt != 'H') {
                    if (charAt != 'Y') {
                        if (charAt != 'Z') {
                            if (charAt == 'd') {
                                dateTimeFormatterBuilder.i(length2);
                            } else if (charAt != 'e') {
                                switch (charAt) {
                                    case 'C':
                                        dateTimeFormatterBuilder.f(length2, length2);
                                        break;
                                    case 'D':
                                        dateTimeFormatterBuilder.m(length2);
                                        break;
                                    case 'E':
                                        if (length2 >= 4) {
                                            dateTimeFormatterBuilder.l();
                                            break;
                                        } else {
                                            dateTimeFormatterBuilder.k();
                                            break;
                                        }
                                    default:
                                        switch (charAt) {
                                            case 'w':
                                                dateTimeFormatterBuilder.R(length2);
                                                break;
                                            case 'x':
                                            case 'y':
                                                break;
                                            case 'z':
                                                if (length2 >= 4) {
                                                    dateTimeFormatterBuilder.K();
                                                    break;
                                                } else {
                                                    dateTimeFormatterBuilder.N(null);
                                                    break;
                                                }
                                            default:
                                                throw new IllegalArgumentException("Illegal pattern component: " + e2);
                                        }
                                }
                            } else {
                                dateTimeFormatterBuilder.j(length2);
                            }
                        } else if (length2 == 1) {
                            dateTimeFormatterBuilder.L(null, "Z", false, 2, 2);
                        } else if (length2 == 2) {
                            dateTimeFormatterBuilder.L(null, "Z", true, 2, 2);
                        } else {
                            dateTimeFormatterBuilder.J();
                        }
                    }
                    if (length2 == 2) {
                        if (i11 + 1 < length) {
                            iArr[0] = iArr[0] + 1;
                            z10 = !c(e(str, iArr));
                            iArr[0] = iArr[0] - 1;
                        } else {
                            z10 = true;
                        }
                        if (charAt != 'x') {
                            dateTimeFormatterBuilder.P(new DateTime().getYear() - 30, z10);
                        } else {
                            dateTimeFormatterBuilder.O(new DateTime().getWeekyear() - 30, z10);
                        }
                    } else {
                        if (i11 + 1 < length) {
                            iArr[0] = iArr[0] + 1;
                            r3 = c(e(str, iArr)) ? length2 : 9;
                            iArr[0] = iArr[0] - 1;
                        }
                        if (charAt == 'Y') {
                            dateTimeFormatterBuilder.U(length2, r3);
                        } else if (charAt == 'x') {
                            dateTimeFormatterBuilder.S(length2, r3);
                        } else if (charAt == 'y') {
                            dateTimeFormatterBuilder.T(length2, r3);
                        }
                    }
                } else {
                    dateTimeFormatterBuilder.v(length2);
                }
            } else if (length2 < 3) {
                dateTimeFormatterBuilder.B(length2);
            } else if (length2 >= 4) {
                dateTimeFormatterBuilder.D();
            } else {
                dateTimeFormatterBuilder.C();
            }
            i10 = i11 + 1;
        }
    }

    public static String e(String str, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i10);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb2.append(charAt);
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= length || str.charAt(i11) != charAt) {
                    break;
                }
                sb2.append(charAt);
                i10 = i11;
            }
        } else {
            sb2.append('\'');
            boolean z10 = false;
            while (i10 < length) {
                char charAt2 = str.charAt(i10);
                if (charAt2 != '\'') {
                    if (!z10 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i10--;
                        break;
                    }
                    sb2.append(charAt2);
                } else {
                    int i12 = i10 + 1;
                    if (i12 >= length || str.charAt(i12) != '\'') {
                        z10 = !z10;
                    } else {
                        sb2.append(charAt2);
                        i10 = i12;
                    }
                }
                i10++;
            }
        }
        iArr[0] = i10;
        return sb2.toString();
    }
}
