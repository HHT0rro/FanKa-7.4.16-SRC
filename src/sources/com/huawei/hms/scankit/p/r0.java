package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Code128Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class r0 extends g5 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f31443a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static boolean a(r rVar, int i10, int i11) {
        return rVar.a(i10, i11, false, false);
    }

    private static float b(r rVar, int[] iArr, int i10) {
        int[] iArr2 = new int[7];
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
        for (int i11 : iArr) {
            i10 += i11;
        }
        boolean z10 = true;
        int i12 = 0;
        while (z10 && i10 < rVar.e()) {
            if (rVar.b(i10)) {
                i12++;
                i10++;
            } else {
                iArr2[6] = i12;
                z10 = false;
            }
        }
        int[][] iArr3 = f31443a;
        return g5.a(iArr2, iArr3[iArr3.length - 1], 0.7f);
    }

    private int[] c(StringBuilder sb2, int[] iArr) throws a {
        int i10 = iArr[0];
        int i11 = iArr[1] == 1 ? 1 : 0;
        int i12 = iArr[2] == 1 ? 1 : 0;
        int i13 = iArr[3] == 1 ? 1 : 0;
        int i14 = iArr[4];
        int i15 = iArr[5] == 1 ? 1 : 0;
        int i16 = iArr[6] == 1 ? 1 : 0;
        if (i10 < 100) {
            if (i10 < 10) {
                sb2.append('0');
            }
            sb2.append(i10);
        } else {
            if (i10 != 106) {
                i13 = 0;
            }
            if (i10 != 106) {
                switch (i10) {
                    case 100:
                        i14 = 100;
                        break;
                    case 101:
                        i14 = 101;
                        break;
                    case 102:
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i16 = 1;
            }
        }
        return new int[]{i10, i11, i12, i13, i14, i15, i16};
    }

    private static int[] a(r rVar) throws a {
        int e2 = rVar.e();
        int c4 = rVar.c(0);
        int[] iArr = new int[6];
        int i10 = c4;
        boolean z10 = false;
        int i11 = 0;
        while (c4 < e2) {
            if (rVar.b(c4) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == 5) {
                    float f10 = 0.25f;
                    int i12 = -1;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float a10 = g5.a(iArr, f31443a[i13], 0.7f);
                        if (a10 < f10) {
                            i12 = i13;
                            f10 = a10;
                        }
                    }
                    if (i12 >= 0) {
                        return new int[]{i10, c4, i12};
                    }
                    i10 += iArr[0] + iArr[1];
                    int i14 = i11 - 1;
                    System.arraycopy((Object) iArr, 2, (Object) iArr, 0, i14);
                    iArr[i14] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            c4++;
        }
        throw a.a();
    }

    private int[] b(StringBuilder sb2, int[] iArr) throws a {
        int i10 = iArr[0];
        int i11 = iArr[1] == 1 ? 1 : 0;
        int i12 = iArr[2] == 1 ? 1 : 0;
        int i13 = iArr[3] == 1 ? 1 : 0;
        int i14 = iArr[4];
        int i15 = iArr[5] == 1 ? 1 : 0;
        int i16 = iArr[6] == 1 ? 1 : 0;
        if (i10 < 96) {
            if (i11 == i12) {
                sb2.append((char) (i10 + 32));
            } else {
                sb2.append((char) (i10 + 32 + 128));
            }
            i11 = 0;
        } else {
            if (i10 != 106) {
                i13 = 0;
            }
            if (i10 != 106) {
                switch (i10) {
                    case 96:
                    case 97:
                    case 102:
                        break;
                    case 98:
                        i14 = 101;
                        i15 = 1;
                        break;
                    case 99:
                        i14 = 99;
                        break;
                    case 100:
                        if (i12 == 0 && i11 != 0) {
                            i11 = 0;
                            i12 = 1;
                            break;
                        } else if (i12 != 0 && i11 != 0) {
                            i11 = 0;
                            i12 = 0;
                            break;
                        } else {
                            i11 = 1;
                            break;
                        }
                    case 101:
                        i14 = 101;
                        break;
                    default:
                        throw a.a();
                }
            } else {
                i16 = 1;
            }
        }
        return new int[]{i10, i11, i12, i13, i14, i15, i16};
    }

    private static int a(r rVar, int[] iArr, int i10) throws a {
        float a10;
        g5.a(rVar, i10, iArr);
        float f10 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f31443a;
            if (i12 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i12];
            if (i12 == iArr2.length - 1) {
                a10 = b(rVar, iArr, i10);
            } else {
                a10 = g5.a(iArr, iArr3, 0.7f);
            }
            if (a10 < f10) {
                i11 = i12;
                f10 = a10;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.g5
    public s6 a(int i10, r rVar, Map<l1, ?> map) throws a {
        int[] a10 = a(rVar);
        int i11 = a10[0] - (((a10[1] - a10[0]) / 11) * 10);
        if (i11 > 0 && i11 < a10[0]) {
            if (!a(rVar, i11, a10[0])) {
                throw a.a();
            }
        }
        int i12 = a10[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i12));
        int i13 = i12 == 103 ? 101 : i12 == 104 ? 100 : i12 == 105 ? 99 : 0;
        if (i13 != 0) {
            StringBuilder sb2 = new StringBuilder(20);
            int[] iArr = new int[7];
            iArr[6] = i13;
            a(sb2, a10, iArr, i12, rVar, arrayList);
            int i14 = iArr[0];
            int i15 = iArr[1];
            int i16 = iArr[2];
            int i17 = iArr[3];
            int i18 = iArr[4];
            boolean z10 = iArr[5] == 1;
            int i19 = iArr[6];
            int i20 = i15 - i14;
            if ((i17 - (i18 * i16)) % 103 == i16) {
                int length = sb2.length();
                if (length != 0) {
                    if (length > 0 && z10) {
                        if (i19 == 99) {
                            sb2.delete(length - 2, length);
                        } else {
                            sb2.delete(length - 1, length);
                        }
                    }
                    float f10 = a10[0];
                    float f11 = i14 + ((i20 * 13) / 11);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i21 = 0; i21 < size; i21++) {
                        bArr[i21] = arrayList.get(i21).byteValue();
                    }
                    float f12 = i10;
                    return new s6(sb2.toString(), bArr, new u6[]{new u6(f10, f12), new u6(f11, f12)}, BarcodeFormat.CODE_128);
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private void a(StringBuilder sb2, int[] iArr, int[] iArr2, int i10, r rVar, List<Byte> list) throws a {
        r0 r0Var = this;
        int i11 = iArr[0];
        int i12 = iArr[1];
        int[] iArr3 = new int[6];
        int i13 = iArr2[6];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        int i18 = 0;
        int i19 = 0;
        boolean z10 = false;
        int i20 = 0;
        int i21 = i12;
        int i22 = i11;
        int i23 = i10;
        while (i14 == 0) {
            int a10 = a(rVar, iArr3, i21);
            list.add(Byte.valueOf((byte) a10));
            if (a10 != 106) {
                i16++;
                i23 += i16 * a10;
                i17 = 1;
            }
            int i24 = i21;
            for (int i25 = 0; i25 < 6; i25++) {
                i24 += iArr3[i25];
            }
            if (a10 != 105) {
                int[] iArr4 = {a10, i18, i19, i17, i13, 0, i14};
                if (i13 == 101) {
                    iArr4 = r0Var.a(sb2, iArr4);
                } else if (i13 == 100) {
                    iArr4 = r0Var.b(sb2, iArr4);
                } else if (i13 == 99) {
                    iArr4 = r0Var.c(sb2, iArr4);
                }
                int i26 = iArr4[0];
                i18 = iArr4[1] == 1 ? 1 : 0;
                i19 = iArr4[2] == 1 ? 1 : 0;
                int i27 = iArr4[3] == 1 ? 1 : 0;
                boolean z11 = iArr4[5] == 1;
                int i28 = iArr4[6] == 1 ? 1 : 0;
                if (z10) {
                    i13 = iArr4[4] == 101 ? 100 : 101;
                } else {
                    i13 = iArr4[4];
                }
                z10 = z11;
                i15 = i20;
                i14 = i28;
                i20 = i26;
                r0Var = this;
                i17 = i27;
                i22 = i21;
                i21 = i24;
            } else {
                throw a.a();
            }
        }
        iArr2[0] = i22;
        iArr2[1] = i21;
        iArr2[2] = i15;
        iArr2[3] = i23;
        iArr2[4] = i16;
        iArr2[5] = i17;
        iArr2[6] = i13;
    }

    private int[] a(StringBuilder sb2, int[] iArr) throws a {
        int i10 = iArr[0];
        int i11 = iArr[1] == 1 ? 1 : 0;
        int i12 = iArr[2] == 1 ? 1 : 0;
        int i13 = iArr[3] == 1 ? 1 : 0;
        int i14 = iArr[4];
        int i15 = iArr[5] == 1 ? 1 : 0;
        int i16 = iArr[6] == 1 ? 1 : 0;
        if (i10 < 64) {
            if (i11 == i12) {
                sb2.append((char) (i10 + 32));
            } else {
                sb2.append((char) (i10 + 32 + 128));
            }
        } else {
            if (i10 >= 96) {
                if (i10 != 106) {
                    i13 = 0;
                }
                if (i10 != 106) {
                    switch (i10) {
                        case 96:
                        case 97:
                        case 102:
                            break;
                        case 98:
                            i14 = 100;
                            i15 = 1;
                            break;
                        case 99:
                            i14 = 99;
                            break;
                        case 100:
                            i14 = 100;
                            break;
                        case 101:
                            if (i12 == 0 && i11 != 0) {
                                i11 = 0;
                                i12 = 1;
                                break;
                            } else if (i12 != 0 && i11 != 0) {
                                i11 = 0;
                                i12 = 0;
                                break;
                            } else {
                                i11 = 1;
                                break;
                            }
                        default:
                            throw a.a();
                    }
                } else {
                    i16 = 1;
                }
                return new int[]{i10, i11, i12, i13, i14, i15, i16};
            }
            if (i11 == i12) {
                sb2.append((char) (i10 - 64));
            } else {
                sb2.append((char) (i10 + 64));
            }
        }
        i11 = 0;
        return new int[]{i10, i11, i12, i13, i14, i15, i16};
    }
}
