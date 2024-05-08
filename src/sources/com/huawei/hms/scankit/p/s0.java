package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Code128Writer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s0 extends h5 {

    /* compiled from: Code128Writer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.huawei.hms.scankit.p.h5, com.huawei.hms.scankit.p.l8
    public s a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + ((Object) barcodeFormat));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x004f. Please report as an issue. */
    @Override // com.huawei.hms.scankit.p.h5
    public boolean[] a(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = str.charAt(i11);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 1;
            while (i12 < length) {
                int a10 = a(str, i12, i14);
                int i16 = 100;
                if (a10 == i14) {
                    switch (str.charAt(i12)) {
                        case 241:
                            i16 = 102;
                            i12++;
                            break;
                        case 242:
                            i16 = 97;
                            i12++;
                            break;
                        case 243:
                            i16 = 96;
                            i12++;
                            break;
                        case 244:
                            i12++;
                            break;
                        default:
                            if (i14 == 100) {
                                i16 = str.charAt(i12) - ' ';
                            } else {
                                try {
                                    i16 = Integer.parseInt(str.substring(i12, i12 + 2));
                                    i12++;
                                } catch (NumberFormatException unused) {
                                    throw new IllegalArgumentException("contents substring can not format integer");
                                }
                            }
                            i12++;
                            break;
                    }
                } else {
                    i16 = i14 == 0 ? a10 == 100 ? 104 : 105 : a10;
                    i14 = a10;
                }
                arrayList.add(r0.f31443a[i16]);
                i13 += i16 * i15;
                if (i12 != 0) {
                    i15++;
                }
            }
            int[][] iArr = r0.f31443a;
            arrayList.add(iArr[i13 % 103]);
            arrayList.add(iArr[106]);
            int i17 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i18 : iArr2) {
                    i17 += i18;
                }
            }
            boolean[] zArr = new boolean[i17];
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                i10 += h5.a(zArr, i10, (int[]) iterator2.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }

    private static a a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i11);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return a.TWO_DIGITS;
        }
        return a.ONE_DIGIT;
    }

    private static int a(CharSequence charSequence, int i10, int i11) {
        a aVar;
        a a10;
        a a11;
        a a12 = a(charSequence, i10);
        a aVar2 = a.UNCODABLE;
        if (a12 != aVar2 && a12 != (aVar = a.ONE_DIGIT)) {
            if (i11 == 99) {
                return 99;
            }
            if (i11 == 100) {
                a aVar3 = a.FNC_1;
                if (a12 == aVar3 || (a10 = a(charSequence, i10 + 2)) == aVar2 || a10 == aVar) {
                    return 100;
                }
                if (a10 == aVar3) {
                    return a(charSequence, i10 + 3) == a.TWO_DIGITS ? 99 : 100;
                }
                int i12 = i10 + 4;
                while (true) {
                    a11 = a(charSequence, i12);
                    if (a11 != a.TWO_DIGITS) {
                        break;
                    }
                    i12 += 2;
                }
                return a11 == a.ONE_DIGIT ? 100 : 99;
            }
            if (a12 == a.FNC_1) {
                a12 = a(charSequence, i10 + 1);
            }
            if (a12 == a.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }
}
