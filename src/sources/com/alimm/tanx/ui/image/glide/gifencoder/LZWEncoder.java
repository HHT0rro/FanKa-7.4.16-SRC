package com.alimm.tanx.ui.image.glide.gifencoder;

import com.huawei.hms.ml.scan.HmsScanBase;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LZWEncoder {
    public static final int BITS = 12;
    public static final int EOF = -1;
    public static final int HSIZE = 5003;
    public int ClearCode;
    public int EOFCode;
    public int a_count;
    public int curPixel;
    public int g_init_bits;
    public int imgH;
    public int imgW;
    public int initCodeSize;
    public int maxcode;
    public int n_bits;
    public byte[] pixAry;
    public int remaining;
    public int maxbits = 12;
    public int maxmaxcode = 4096;
    public int[] htab = new int[5003];
    public int[] codetab = new int[5003];
    public int hsize = 5003;
    public int free_ent = 0;
    public boolean clear_flg = false;
    public int cur_accum = 0;
    public int cur_bits = 0;
    public int[] masks = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, HmsScanBase.ALL_SCAN_TYPE, 16383, 32767, 65535};
    public byte[] accum = new byte[256];

    public LZWEncoder(int i10, int i11, byte[] bArr, int i12) {
        this.imgW = i10;
        this.imgH = i11;
        this.pixAry = bArr;
        this.initCodeSize = Math.max(2, i12);
    }

    private int nextPixel() {
        int i10 = this.remaining;
        if (i10 == 0) {
            return -1;
        }
        this.remaining = i10 - 1;
        byte[] bArr = this.pixAry;
        int i11 = this.curPixel;
        this.curPixel = i11 + 1;
        return bArr[i11] & 255;
    }

    public final int MAXCODE(int i10) {
        return (1 << i10) - 1;
    }

    public void char_out(byte b4, OutputStream outputStream) throws IOException {
        byte[] bArr = this.accum;
        int i10 = this.a_count;
        int i11 = i10 + 1;
        this.a_count = i11;
        bArr[i10] = b4;
        if (i11 >= 254) {
            flush_char(outputStream);
        }
    }

    public void cl_block(OutputStream outputStream) throws IOException {
        cl_hash(this.hsize);
        int i10 = this.ClearCode;
        this.free_ent = i10 + 2;
        this.clear_flg = true;
        output(i10, outputStream);
    }

    public void cl_hash(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.htab[i11] = -1;
        }
    }

    public void compress(int i10, OutputStream outputStream) throws IOException {
        int[] iArr;
        this.g_init_bits = i10;
        int i11 = 0;
        this.clear_flg = false;
        this.n_bits = i10;
        this.maxcode = MAXCODE(i10);
        int i12 = 1 << (i10 - 1);
        this.ClearCode = i12;
        this.EOFCode = i12 + 1;
        this.free_ent = i12 + 2;
        this.a_count = 0;
        int nextPixel = nextPixel();
        for (int i13 = this.hsize; i13 < 65536; i13 *= 2) {
            i11++;
        }
        int i14 = 8 - i11;
        int i15 = this.hsize;
        cl_hash(i15);
        output(this.ClearCode, outputStream);
        while (true) {
            int nextPixel2 = nextPixel();
            if (nextPixel2 != -1) {
                int i16 = (nextPixel2 << this.maxbits) + nextPixel;
                int i17 = (nextPixel2 << i14) ^ nextPixel;
                int[] iArr2 = this.htab;
                if (iArr2[i17] == i16) {
                    nextPixel = this.codetab[i17];
                } else {
                    if (iArr2[i17] >= 0) {
                        int i18 = i15 - i17;
                        if (i17 == 0) {
                            i18 = 1;
                        }
                        do {
                            i17 -= i18;
                            if (i17 < 0) {
                                i17 += i15;
                            }
                            iArr = this.htab;
                            if (iArr[i17] == i16) {
                                nextPixel = this.codetab[i17];
                                break;
                            }
                        } while (iArr[i17] >= 0);
                    }
                    output(nextPixel, outputStream);
                    int i19 = this.free_ent;
                    if (i19 < this.maxmaxcode) {
                        int[] iArr3 = this.codetab;
                        this.free_ent = i19 + 1;
                        iArr3[i17] = i19;
                        this.htab[i17] = i16;
                    } else {
                        cl_block(outputStream);
                    }
                    nextPixel = nextPixel2;
                }
            } else {
                output(nextPixel, outputStream);
                output(this.EOFCode, outputStream);
                return;
            }
        }
    }

    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }

    public void flush_char(OutputStream outputStream) throws IOException {
        int i10 = this.a_count;
        if (i10 > 0) {
            outputStream.write(i10);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    public void output(int i10, OutputStream outputStream) throws IOException {
        int i11 = this.cur_accum;
        int[] iArr = this.masks;
        int i12 = this.cur_bits;
        int i13 = i11 & iArr[i12];
        this.cur_accum = i13;
        if (i12 > 0) {
            this.cur_accum = i13 | (i10 << i12);
        } else {
            this.cur_accum = i10;
        }
        this.cur_bits = i12 + this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & 255), outputStream);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i14 = this.g_init_bits;
                this.n_bits = i14;
                this.maxcode = MAXCODE(i14);
                this.clear_flg = false;
            } else {
                int i15 = this.n_bits + 1;
                this.n_bits = i15;
                if (i15 == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                } else {
                    this.maxcode = MAXCODE(i15);
                }
            }
        }
        if (i10 == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & 255), outputStream);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outputStream);
        }
    }
}
