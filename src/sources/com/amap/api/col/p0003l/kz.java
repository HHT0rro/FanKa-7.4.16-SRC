package com.amap.api.col.p0003l;

/* compiled from: Base64.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class kz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f6722a = true;

    /* compiled from: Base64.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f6723a;

        /* renamed from: b, reason: collision with root package name */
        public int f6724b;
    }

    /* compiled from: Base64.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends a {

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f6725c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: d, reason: collision with root package name */
        private static final int[] f6726d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: e, reason: collision with root package name */
        private int f6727e;

        /* renamed from: f, reason: collision with root package name */
        private int f6728f;

        /* renamed from: g, reason: collision with root package name */
        private final int[] f6729g;

        public b(byte[] bArr) {
            this.f6723a = bArr;
            this.f6729g = f6725c;
            this.f6727e = 0;
            this.f6728f = 0;
        }

        public final boolean a(byte[] bArr, int i10) {
            int i11 = this.f6727e;
            if (i11 == 6) {
                return false;
            }
            int i12 = i10 + 0;
            int i13 = this.f6728f;
            byte[] bArr2 = this.f6723a;
            int[] iArr = this.f6729g;
            int i14 = 0;
            int i15 = 0;
            while (i14 < i12) {
                if (i11 == 0) {
                    while (true) {
                        int i16 = i14 + 4;
                        if (i16 > i12) {
                            break;
                        }
                        i13 = iArr[bArr[i14 + 3] & 255] | (iArr[bArr[i14 + 1] & 255] << 12) | (iArr[bArr[i14] & 255] << 18) | (iArr[bArr[i14 + 2] & 255] << 6);
                        if (i13 < 0) {
                            break;
                        }
                        bArr2[i15 + 2] = (byte) i13;
                        bArr2[i15 + 1] = (byte) (i13 >> 8);
                        bArr2[i15] = (byte) (i13 >> 16);
                        i15 += 3;
                        i14 = i16;
                    }
                    if (i14 >= i12) {
                        break;
                    }
                }
                int i17 = i14 + 1;
                int i18 = iArr[bArr[i14] & 255];
                if (i11 != 0) {
                    if (i11 == 1) {
                        if (i18 < 0) {
                            if (i18 != -1) {
                                this.f6727e = 6;
                                return false;
                            }
                        }
                        i13 = (i13 << 6) | i18;
                        i11++;
                    } else if (i11 == 2) {
                        if (i18 < 0) {
                            if (i18 == -2) {
                                bArr2[i15] = (byte) (i13 >> 4);
                                i15++;
                                i14 = i17;
                                i11 = 4;
                            } else if (i18 != -1) {
                                this.f6727e = 6;
                                return false;
                            }
                        }
                        i13 = (i13 << 6) | i18;
                        i11++;
                    } else if (i11 != 3) {
                        if (i11 == 4) {
                            if (i18 != -2) {
                                if (i18 != -1) {
                                    this.f6727e = 6;
                                    return false;
                                }
                            }
                            i11++;
                        } else if (i11 == 5 && i18 != -1) {
                            this.f6727e = 6;
                            return false;
                        }
                    } else if (i18 >= 0) {
                        i13 = (i13 << 6) | i18;
                        bArr2[i15 + 2] = (byte) i13;
                        bArr2[i15 + 1] = (byte) (i13 >> 8);
                        bArr2[i15] = (byte) (i13 >> 16);
                        i15 += 3;
                        i14 = i17;
                        i11 = 0;
                    } else if (i18 == -2) {
                        bArr2[i15 + 1] = (byte) (i13 >> 2);
                        bArr2[i15] = (byte) (i13 >> 10);
                        i15 += 2;
                        i14 = i17;
                        i11 = 5;
                    } else if (i18 != -1) {
                        this.f6727e = 6;
                        return false;
                    }
                } else if (i18 >= 0) {
                    i11++;
                    i13 = i18;
                } else if (i18 != -1) {
                    this.f6727e = 6;
                    return false;
                }
                i14 = i17;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    bArr2[i15] = (byte) (i13 >> 4);
                    i15++;
                } else if (i11 == 3) {
                    int i19 = i15 + 1;
                    bArr2[i15] = (byte) (i13 >> 10);
                    i15 = i19 + 1;
                    bArr2[i19] = (byte) (i13 >> 2);
                } else if (i11 == 4) {
                    this.f6727e = 6;
                    return false;
                }
                this.f6727e = i11;
                this.f6724b = i15;
                return true;
            }
            this.f6727e = 6;
            return false;
        }
    }

    private kz() {
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static byte[] a(byte[] bArr, int i10) {
        b bVar = new b(new byte[(i10 * 3) / 4]);
        if (bVar.a(bArr, i10)) {
            int i11 = bVar.f6724b;
            byte[] bArr2 = bVar.f6723a;
            if (i11 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i11];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i11);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
