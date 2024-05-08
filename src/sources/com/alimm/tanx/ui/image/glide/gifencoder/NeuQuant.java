package com.alimm.tanx.ui.image.glide.gifencoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NeuQuant {
    public static final int alphabiasshift = 10;
    public static final int alpharadbias = 262144;
    public static final int alpharadbshift = 18;
    public static final int beta = 64;
    public static final int betagamma = 65536;
    public static final int betashift = 10;
    public static final int gamma = 1024;
    public static final int gammashift = 10;
    public static final int initalpha = 1024;
    public static final int initrad = 32;
    public static final int initradius = 2048;
    public static final int intbias = 65536;
    public static final int intbiasshift = 16;
    public static final int maxnetpos = 255;
    public static final int minpicturebytes = 1509;
    public static final int ncycles = 100;
    public static final int netbiasshift = 4;
    public static final int netsize = 256;
    public static final int prime1 = 499;
    public static final int prime2 = 491;
    public static final int prime3 = 487;
    public static final int prime4 = 503;
    public static final int radbias = 256;
    public static final int radbiasshift = 8;
    public static final int radiusbias = 64;
    public static final int radiusbiasshift = 6;
    public static final int radiusdec = 30;
    public int alphadec;
    public int lengthcount;
    public int samplefac;
    public byte[] thepicture;
    public int[] netindex = new int[256];
    public int[] bias = new int[256];
    public int[] freq = new int[256];
    public int[] radpower = new int[32];
    public int[][] network = new int[256];

    public NeuQuant(byte[] bArr, int i10, int i11) {
        this.thepicture = bArr;
        this.lengthcount = i10;
        this.samplefac = i11;
        for (int i12 = 0; i12 < 256; i12++) {
            int[][] iArr = this.network;
            iArr[i12] = new int[4];
            int[] iArr2 = iArr[i12];
            int i13 = (i12 << 12) / 256;
            iArr2[2] = i13;
            iArr2[1] = i13;
            iArr2[0] = i13;
            this.freq[i12] = 256;
            this.bias[i12] = 0;
        }
    }

    public void alterneigh(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i11 - i10;
        if (i15 < -1) {
            i15 = -1;
        }
        int i16 = i11 + i10;
        if (i16 > 256) {
            i16 = 256;
        }
        int i17 = i11 + 1;
        int i18 = i11 - 1;
        int i19 = 1;
        while (true) {
            if (i17 >= i16 && i18 <= i15) {
                return;
            }
            int i20 = i19 + 1;
            int i21 = this.radpower[i19];
            if (i17 < i16) {
                int i22 = i17 + 1;
                int[] iArr = this.network[i17];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i12) * i21) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i13) * i21) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i14) * i21) / 262144);
                } catch (Exception unused) {
                }
                i17 = i22;
            }
            if (i18 > i15) {
                int i23 = i18 - 1;
                int[] iArr2 = this.network[i18];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i12) * i21) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i13) * i21) / 262144);
                    iArr2[2] = iArr2[2] - (((iArr2[2] - i14) * i21) / 262144);
                } catch (Exception unused2) {
                }
                i19 = i20;
                i18 = i23;
            } else {
                i19 = i20;
            }
        }
    }

    public void altersingle(int i10, int i11, int i12, int i13, int i14) {
        int[] iArr = this.network[i11];
        iArr[0] = iArr[0] - (((iArr[0] - i12) * i10) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i13) * i10) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i14) * i10) / 1024);
    }

    public byte[] colorMap() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr[this.network[i10][3]] = i10;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < 256) {
            int i13 = iArr[i11];
            int i14 = i12 + 1;
            int[][] iArr2 = this.network;
            bArr[i12] = (byte) iArr2[i13][0];
            int i15 = i14 + 1;
            bArr[i14] = (byte) iArr2[i13][1];
            bArr[i15] = (byte) iArr2[i13][2];
            i11++;
            i12 = i15 + 1;
        }
        return bArr;
    }

    public int contest(int i10, int i11, int i12) {
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MAX_VALUE;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < 256; i17++) {
            int[] iArr = this.network[i17];
            int i18 = iArr[0] - i10;
            if (i18 < 0) {
                i18 = -i18;
            }
            int i19 = iArr[1] - i11;
            if (i19 < 0) {
                i19 = -i19;
            }
            int i20 = i18 + i19;
            int i21 = iArr[2] - i12;
            if (i21 < 0) {
                i21 = -i21;
            }
            int i22 = i20 + i21;
            if (i22 < i13) {
                i16 = i17;
                i13 = i22;
            }
            int[] iArr2 = this.bias;
            int i23 = i22 - (iArr2[i17] >> 12);
            if (i23 < i14) {
                i15 = i17;
                i14 = i23;
            }
            int[] iArr3 = this.freq;
            int i24 = iArr3[i17] >> 10;
            iArr3[i17] = iArr3[i17] - i24;
            iArr2[i17] = iArr2[i17] + (i24 << 10);
        }
        int[] iArr4 = this.freq;
        iArr4[i16] = iArr4[i16] + 64;
        int[] iArr5 = this.bias;
        iArr5[i16] = iArr5[i16] - 65536;
        return i15;
    }

    public void inxbuild() {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < 256) {
            int[] iArr = this.network[i10];
            int i13 = iArr[1];
            int i14 = i10 + 1;
            int i15 = i10;
            for (int i16 = i14; i16 < 256; i16++) {
                int[] iArr2 = this.network[i16];
                if (iArr2[1] < i13) {
                    i13 = iArr2[1];
                    i15 = i16;
                }
            }
            int[] iArr3 = this.network[i15];
            if (i10 != i15) {
                int i17 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i17;
                int i18 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i18;
                int i19 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i19;
                int i20 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i20;
            }
            if (i13 != i11) {
                this.netindex[i11] = (i12 + i10) >> 1;
                while (true) {
                    i11++;
                    if (i11 >= i13) {
                        break;
                    } else {
                        this.netindex[i11] = i10;
                    }
                }
                i12 = i10;
                i11 = i13;
            }
            i10 = i14;
        }
        this.netindex[i11] = (i12 + 255) >> 1;
        for (int i21 = i11 + 1; i21 < 256; i21++) {
            this.netindex[i21] = 255;
        }
    }

    public void learn() {
        int i10;
        int i11 = this.lengthcount;
        if (i11 < 1509) {
            this.samplefac = 1;
        }
        int i12 = this.samplefac;
        this.alphadec = ((i12 - 1) / 3) + 30;
        byte[] bArr = this.thepicture;
        int i13 = i11 / (i12 * 3);
        int i14 = i13 / 100;
        for (int i15 = 0; i15 < 32; i15++) {
            this.radpower[i15] = (((1024 - (i15 * i15)) * 256) / 1024) * 1024;
        }
        int i16 = this.lengthcount;
        if (i16 < 1509) {
            i10 = 3;
        } else if (i16 % 499 != 0) {
            i10 = 1497;
        } else if (i16 % 491 != 0) {
            i10 = 1473;
        } else {
            i10 = i16 % 487 != 0 ? 1461 : 1509;
        }
        int i17 = i14;
        int i18 = 0;
        int i19 = 2048;
        int i20 = 32;
        int i21 = 1024;
        int i22 = 0;
        while (i18 < i13) {
            int i23 = (bArr[i22 + 0] & 255) << 4;
            int i24 = (bArr[i22 + 1] & 255) << 4;
            int i25 = (bArr[i22 + 2] & 255) << 4;
            int contest = contest(i23, i24, i25);
            int i26 = i18;
            altersingle(i21, contest, i23, i24, i25);
            if (i20 != 0) {
                alterneigh(i20, contest, i23, i24, i25);
            }
            int i27 = i22 + i10;
            if (i27 >= i11) {
                i27 -= this.lengthcount;
            }
            i22 = i27;
            i18 = i26 + 1;
            if (i17 == 0) {
                i17 = 1;
            }
            if (i18 % i17 == 0) {
                i21 -= i21 / this.alphadec;
                i19 -= i19 / 30;
                int i28 = i19 >> 6;
                i20 = i28 <= 1 ? 0 : i28;
                for (int i29 = 0; i29 < i20; i29++) {
                    int i30 = i20 * i20;
                    this.radpower[i29] = (((i30 - (i29 * i29)) * 256) / i30) * i21;
                }
            }
        }
    }

    public int map(int i10, int i11, int i12) {
        int i13 = this.netindex[i11];
        int i14 = i13 - 1;
        int i15 = 1000;
        int i16 = -1;
        while (true) {
            if (i13 >= 256 && i14 < 0) {
                return i16;
            }
            if (i13 < 256) {
                int[] iArr = this.network[i13];
                int i17 = iArr[1] - i11;
                if (i17 >= i15) {
                    i13 = 256;
                } else {
                    i13++;
                    if (i17 < 0) {
                        i17 = -i17;
                    }
                    int i18 = iArr[0] - i10;
                    if (i18 < 0) {
                        i18 = -i18;
                    }
                    int i19 = i17 + i18;
                    if (i19 < i15) {
                        int i20 = iArr[2] - i12;
                        if (i20 < 0) {
                            i20 = -i20;
                        }
                        int i21 = i19 + i20;
                        if (i21 < i15) {
                            i16 = iArr[3];
                            i15 = i21;
                        }
                    }
                }
            }
            if (i14 >= 0) {
                int[] iArr2 = this.network[i14];
                int i22 = i11 - iArr2[1];
                if (i22 >= i15) {
                    i14 = -1;
                } else {
                    i14--;
                    if (i22 < 0) {
                        i22 = -i22;
                    }
                    int i23 = iArr2[0] - i10;
                    if (i23 < 0) {
                        i23 = -i23;
                    }
                    int i24 = i22 + i23;
                    if (i24 < i15) {
                        int i25 = iArr2[2] - i12;
                        if (i25 < 0) {
                            i25 = -i25;
                        }
                        int i26 = i25 + i24;
                        if (i26 < i15) {
                            i16 = iArr2[3];
                            i15 = i26;
                        }
                    }
                }
            }
        }
    }

    public byte[] process() {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public void unbiasnet() {
        for (int i10 = 0; i10 < 256; i10++) {
            int[][] iArr = this.network;
            int[] iArr2 = iArr[i10];
            iArr2[0] = iArr2[0] >> 4;
            int[] iArr3 = iArr[i10];
            iArr3[1] = iArr3[1] >> 4;
            int[] iArr4 = iArr[i10];
            iArr4[2] = iArr4[2] >> 4;
            iArr[i10][3] = i10;
        }
    }
}
