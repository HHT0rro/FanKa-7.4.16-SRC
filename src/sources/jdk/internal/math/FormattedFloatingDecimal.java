package jdk.internal.math;

import java.util.Arrays;
import jdk.internal.math.FloatingDecimal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FormattedFloatingDecimal {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ThreadLocal<Object> threadLocalCharBuffer = new ThreadLocal<Object>() { // from class: jdk.internal.math.FormattedFloatingDecimal.1
        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return new char[20];
        }
    };
    private int decExponentRounded;
    private char[] exponent;
    private char[] mantissa;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Form {
        SCIENTIFIC,
        COMPATIBLE,
        DECIMAL_FLOAT,
        GENERAL
    }

    public static FormattedFloatingDecimal valueOf(double d10, int precision, Form form) {
        FloatingDecimal.BinaryToASCIIConverter fdConverter = FloatingDecimal.getBinaryToASCIIConverter(d10, form == Form.COMPATIBLE);
        return new FormattedFloatingDecimal(precision, form, fdConverter);
    }

    private static char[] getBuffer() {
        return (char[]) threadLocalCharBuffer.get();
    }

    private FormattedFloatingDecimal(int precision, Form form, FloatingDecimal.BinaryToASCIIConverter fdConverter) {
        if (fdConverter.isExceptional()) {
            this.mantissa = fdConverter.toJavaFormatString().toCharArray();
            this.exponent = null;
            return;
        }
        char[] digits = getBuffer();
        int nDigits = fdConverter.getDigits(digits);
        int decExp = fdConverter.getDecimalExponent();
        boolean isNegative = fdConverter.isNegative();
        switch (AnonymousClass2.$SwitchMap$jdk$internal$math$FormattedFloatingDecimal$Form[form.ordinal()]) {
            case 1:
                this.decExponentRounded = decExp;
                fillCompatible(precision, digits, nDigits, decExp, isNegative);
                return;
            case 2:
                int exp = applyPrecision(decExp, digits, nDigits, decExp + precision);
                fillDecimal(precision, digits, nDigits, exp, isNegative);
                this.decExponentRounded = exp;
                return;
            case 3:
                int exp2 = applyPrecision(decExp, digits, nDigits, precision + 1);
                fillScientific(precision, digits, nDigits, exp2, isNegative);
                this.decExponentRounded = exp2;
                return;
            case 4:
                int exp3 = applyPrecision(decExp, digits, nDigits, precision);
                if (exp3 - 1 < -4 || exp3 - 1 >= precision) {
                    fillScientific(precision - 1, digits, nDigits, exp3, isNegative);
                } else {
                    fillDecimal(precision - exp3, digits, nDigits, exp3, isNegative);
                }
                this.decExponentRounded = exp3;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: jdk.internal.math.FormattedFloatingDecimal$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$jdk$internal$math$FormattedFloatingDecimal$Form;

        static {
            int[] iArr = new int[Form.values().length];
            $SwitchMap$jdk$internal$math$FormattedFloatingDecimal$Form = iArr;
            try {
                iArr[Form.COMPATIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$jdk$internal$math$FormattedFloatingDecimal$Form[Form.DECIMAL_FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$jdk$internal$math$FormattedFloatingDecimal$Form[Form.SCIENTIFIC.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$jdk$internal$math$FormattedFloatingDecimal$Form[Form.GENERAL.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public int getExponentRounded() {
        return this.decExponentRounded - 1;
    }

    public char[] getMantissa() {
        return this.mantissa;
    }

    public char[] getExponent() {
        return this.exponent;
    }

    private static int applyPrecision(int decExp, char[] digits, int nDigits, int prec) {
        if (prec >= nDigits || prec < 0) {
            return decExp;
        }
        if (prec == 0) {
            if (digits[0] >= '5') {
                digits[0] = '1';
                Arrays.fill(digits, 1, nDigits, '0');
                return decExp + 1;
            }
            Arrays.fill(digits, 0, nDigits, '0');
            return decExp;
        }
        if (digits[prec] >= '5') {
            int i10 = prec - 1;
            char c4 = digits[i10];
            if (c4 == '9') {
                while (c4 == '9' && i10 > 0) {
                    i10--;
                    c4 = digits[i10];
                }
                if (c4 == '9') {
                    digits[0] = '1';
                    Arrays.fill(digits, 1, nDigits, '0');
                    return decExp + 1;
                }
            }
            digits[i10] = (char) (c4 + 1);
            Arrays.fill(digits, i10 + 1, nDigits, '0');
        } else {
            Arrays.fill(digits, prec, nDigits, '0');
        }
        return decExp;
    }

    private void fillCompatible(int i10, char[] cArr, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        if (i12 > 0 && i12 < 8) {
            if (i11 < i12) {
                int i15 = i12 - i11;
                char[] create = create(z10, i11 + i15 + 2);
                this.mantissa = create;
                System.arraycopy((Object) cArr, 0, (Object) create, z10 ? 1 : 0, i11);
                Arrays.fill(this.mantissa, (z10 ? 1 : 0) + i11, (z10 ? 1 : 0) + i11 + i15, '0');
                char[] cArr2 = this.mantissa;
                cArr2[(z10 ? 1 : 0) + i11 + i15] = '.';
                cArr2[(z10 ? 1 : 0) + i11 + i15 + 1] = '0';
                return;
            }
            if (i12 < i11) {
                int min = Math.min(i11 - i12, i10);
                char[] create2 = create(z10, i12 + 1 + min);
                this.mantissa = create2;
                System.arraycopy((Object) cArr, 0, (Object) create2, z10 ? 1 : 0, i12);
                char[] cArr3 = this.mantissa;
                cArr3[(z10 ? 1 : 0) + i12] = '.';
                System.arraycopy((Object) cArr, i12, (Object) cArr3, (z10 ? 1 : 0) + i12 + 1, min);
                return;
            }
            char[] create3 = create(z10, i11 + 2);
            this.mantissa = create3;
            System.arraycopy((Object) cArr, 0, (Object) create3, z10 ? 1 : 0, i11);
            char[] cArr4 = this.mantissa;
            cArr4[(z10 ? 1 : 0) + i11] = '.';
            cArr4[(z10 ? 1 : 0) + i11 + 1] = '0';
            return;
        }
        if (i12 <= 0 && i12 > -3) {
            int max = Math.max(0, Math.min(-i12, i10));
            int max2 = Math.max(0, Math.min(i11, i10 + i12));
            if (max > 0) {
                char[] create4 = create(z10, max + 2 + max2);
                this.mantissa = create4;
                create4[z10 ? 1 : 0] = '0';
                create4[(z10 ? 1 : 0) + 1] = '.';
                Arrays.fill(create4, (z10 ? 1 : 0) + 2, (z10 ? 1 : 0) + 2 + max, '0');
                if (max2 > 0) {
                    System.arraycopy((Object) cArr, 0, (Object) this.mantissa, (z10 ? 1 : 0) + 2 + max, max2);
                    return;
                }
                return;
            }
            if (max2 > 0) {
                char[] create5 = create(z10, max + 2 + max2);
                this.mantissa = create5;
                create5[z10 ? 1 : 0] = '0';
                create5[(z10 ? 1 : 0) + 1] = '.';
                System.arraycopy((Object) cArr, 0, (Object) create5, (z10 ? 1 : 0) + 2, max2);
                return;
            }
            char[] create6 = create(z10, 1);
            this.mantissa = create6;
            create6[z10 ? 1 : 0] = '0';
            return;
        }
        if (i11 > 1) {
            char[] create7 = create(z10, i11 + 1);
            this.mantissa = create7;
            create7[z10 ? 1 : 0] = cArr[0];
            create7[(z10 ? 1 : 0) + 1] = '.';
            System.arraycopy((Object) cArr, 1, (Object) create7, (z10 ? 1 : 0) + 2, i11 - 1);
        } else {
            char[] create8 = create(z10, 3);
            this.mantissa = create8;
            create8[z10 ? 1 : 0] = cArr[0];
            create8[(z10 ? 1 : 0) + 1] = '.';
            create8[(z10 ? 1 : 0) + 2] = '0';
        }
        boolean z11 = i12 <= 0;
        if (z11) {
            i13 = (-i12) + 1;
            i14 = 1;
        } else {
            i13 = i12 - 1;
            i14 = 0;
        }
        if (i13 <= 9) {
            char[] create9 = create(z11, 1);
            this.exponent = create9;
            create9[i14] = (char) (i13 + 48);
        } else {
            if (i13 <= 99) {
                char[] create10 = create(z11, 2);
                this.exponent = create10;
                create10[i14] = (char) ((i13 / 10) + 48);
                create10[i14 + 1] = (char) ((i13 % 10) + 48);
                return;
            }
            char[] create11 = create(z11, 3);
            this.exponent = create11;
            create11[i14] = (char) ((i13 / 100) + 48);
            int i16 = i13 % 100;
            create11[i14 + 1] = (char) ((i16 / 10) + 48);
            create11[i14 + 2] = (char) ((i16 % 10) + 48);
        }
    }

    private static char[] create(boolean isNegative, int size) {
        if (isNegative) {
            char[] r10 = new char[size + 1];
            r10[0] = '-';
            return r10;
        }
        return new char[size];
    }

    private void fillDecimal(int i10, char[] cArr, int i11, int i12, boolean z10) {
        if (i12 > 0) {
            if (i11 < i12) {
                char[] create = create(z10, i12);
                this.mantissa = create;
                System.arraycopy((Object) cArr, 0, (Object) create, z10 ? 1 : 0, i11);
                Arrays.fill(this.mantissa, (z10 ? 1 : 0) + i11, (z10 ? 1 : 0) + i12, '0');
                return;
            }
            int min = Math.min(i11 - i12, i10);
            char[] create2 = create(z10, (min > 0 ? min + 1 : 0) + i12);
            this.mantissa = create2;
            System.arraycopy((Object) cArr, 0, (Object) create2, z10 ? 1 : 0, i12);
            if (min > 0) {
                char[] cArr2 = this.mantissa;
                cArr2[(z10 ? 1 : 0) + i12] = '.';
                System.arraycopy((Object) cArr, i12, (Object) cArr2, (z10 ? 1 : 0) + i12 + 1, min);
                return;
            }
            return;
        }
        if (i12 <= 0) {
            int max = Math.max(0, Math.min(-i12, i10));
            int max2 = Math.max(0, Math.min(i11, i10 + i12));
            if (max > 0) {
                char[] create3 = create(z10, max + 2 + max2);
                this.mantissa = create3;
                create3[z10 ? 1 : 0] = '0';
                create3[(z10 ? 1 : 0) + 1] = '.';
                Arrays.fill(create3, (z10 ? 1 : 0) + 2, (z10 ? 1 : 0) + 2 + max, '0');
                if (max2 > 0) {
                    System.arraycopy((Object) cArr, 0, (Object) this.mantissa, (z10 ? 1 : 0) + 2 + max, max2);
                    return;
                }
                return;
            }
            if (max2 > 0) {
                char[] create4 = create(z10, max + 2 + max2);
                this.mantissa = create4;
                create4[z10 ? 1 : 0] = '0';
                create4[(z10 ? 1 : 0) + 1] = '.';
                System.arraycopy((Object) cArr, 0, (Object) create4, (z10 ? 1 : 0) + 2, max2);
                return;
            }
            char[] create5 = create(z10, 1);
            this.mantissa = create5;
            create5[z10 ? 1 : 0] = '0';
        }
    }

    private void fillScientific(int i10, char[] cArr, int i11, int i12, boolean z10) {
        char c4;
        int i13;
        int max = Math.max(0, Math.min(i11 - 1, i10));
        if (max > 0) {
            char[] create = create(z10, max + 2);
            this.mantissa = create;
            create[z10 ? 1 : 0] = cArr[0];
            create[(z10 ? 1 : 0) + 1] = '.';
            System.arraycopy((Object) cArr, 1, (Object) create, (z10 ? 1 : 0) + 2, max);
        } else {
            char[] create2 = create(z10, 1);
            this.mantissa = create2;
            create2[z10 ? 1 : 0] = cArr[0];
        }
        if (i12 <= 0) {
            c4 = '-';
            i13 = (-i12) + 1;
        } else {
            c4 = '+';
            i13 = i12 - 1;
        }
        if (i13 <= 9) {
            this.exponent = new char[]{c4, '0', (char) (i13 + 48)};
        } else {
            if (i13 <= 99) {
                this.exponent = new char[]{c4, (char) ((i13 / 10) + 48), (char) ((i13 % 10) + 48)};
                return;
            }
            char c10 = (char) ((i13 / 100) + 48);
            int i14 = i13 % 100;
            this.exponent = new char[]{c4, c10, (char) ((i14 / 10) + 48), (char) ((i14 % 10) + 48)};
        }
    }
}
