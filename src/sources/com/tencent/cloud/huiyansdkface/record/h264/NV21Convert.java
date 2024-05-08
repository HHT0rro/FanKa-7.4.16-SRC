package com.tencent.cloud.huiyansdkface.record.h264;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NV21Convert {

    /* renamed from: a, reason: collision with root package name */
    private int f42165a;

    /* renamed from: b, reason: collision with root package name */
    private int f42166b;

    /* renamed from: c, reason: collision with root package name */
    private int f42167c;

    /* renamed from: d, reason: collision with root package name */
    private int f42168d;

    /* renamed from: e, reason: collision with root package name */
    private int f42169e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f42170f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f42171g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f42172h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f42173i;

    public void convert(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.put(convert(bArr), 0, byteBuffer.capacity() < bArr.length ? byteBuffer.capacity() : bArr.length);
    }

    public byte[] convert(byte[] bArr) {
        byte[] bArr2 = this.f42173i;
        if (bArr2 == null || bArr2.length != (((this.f42165a * 3) * this.f42167c) / 2) + this.f42172h) {
            this.f42173i = new byte[(((this.f42165a * 3) * this.f42167c) / 2) + this.f42172h];
        }
        if (!this.f42170f) {
            if (this.f42165a == this.f42166b && this.f42167c == this.f42168d) {
                if (!this.f42171g) {
                    int i10 = this.f42169e;
                    while (true) {
                        int i11 = this.f42169e;
                        if (i10 >= i11 + (i11 / 2)) {
                            break;
                        }
                        byte[] bArr3 = this.f42173i;
                        int i12 = i10 + 1;
                        bArr3[0] = bArr[i12];
                        bArr[i12] = bArr[i10];
                        bArr[i10] = bArr3[0];
                        i10 += 2;
                    }
                }
                if (this.f42172h <= 0) {
                    return bArr;
                }
                System.arraycopy((Object) bArr, 0, (Object) this.f42173i, 0, this.f42169e);
                int i13 = this.f42169e;
                System.arraycopy((Object) bArr, i13, (Object) this.f42173i, this.f42172h + i13, i13 / 2);
                return this.f42173i;
            }
            return bArr;
        }
        if (this.f42165a == this.f42166b && this.f42167c == this.f42168d) {
            if (!this.f42171g) {
                int i14 = 0;
                while (true) {
                    int i15 = this.f42169e;
                    if (i14 >= i15 / 4) {
                        break;
                    }
                    byte[] bArr4 = this.f42173i;
                    int i16 = i14 * 2;
                    bArr4[i14] = bArr[i15 + i16 + 1];
                    bArr4[(i15 / 4) + i14] = bArr[i15 + i16];
                    i14++;
                }
            } else {
                int i17 = 0;
                while (true) {
                    int i18 = this.f42169e;
                    if (i17 >= i18 / 4) {
                        break;
                    }
                    byte[] bArr5 = this.f42173i;
                    int i19 = i17 * 2;
                    bArr5[i17] = bArr[i18 + i19];
                    bArr5[(i18 / 4) + i17] = bArr[i18 + i19 + 1];
                    i17++;
                }
            }
            if (this.f42172h == 0) {
                byte[] bArr6 = this.f42173i;
                int i20 = this.f42169e;
                System.arraycopy((Object) bArr6, 0, (Object) bArr, i20, i20 / 2);
                return bArr;
            }
            System.arraycopy((Object) bArr, 0, (Object) this.f42173i, 0, this.f42169e);
            byte[] bArr7 = this.f42173i;
            int i21 = this.f42169e;
            System.arraycopy((Object) bArr7, 0, (Object) bArr7, this.f42172h + i21, i21 / 2);
            return this.f42173i;
        }
        return bArr;
    }

    public void destory() {
        this.f42173i = null;
    }

    public int getBufferSize() {
        return (this.f42169e * 3) / 2;
    }

    public boolean getPlanar() {
        return this.f42170f;
    }

    public int getSliceHeight() {
        return this.f42165a;
    }

    public int getStride() {
        return this.f42167c;
    }

    public boolean getUVPanesReversed() {
        return this.f42171g;
    }

    public int getYPadding() {
        return this.f42172h;
    }

    public void setColorPanesReversed(boolean z10) {
        this.f42171g = z10;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public void setEncoderColorFormat(int i10) {
        boolean z10;
        if (i10 != 39 && i10 != 2130706688) {
            switch (i10) {
                case 19:
                case 20:
                    z10 = true;
                    setPlanar(z10);
                case 21:
                    break;
                default:
                    return;
            }
        }
        z10 = false;
        setPlanar(z10);
    }

    public void setPlanar(boolean z10) {
        this.f42170f = z10;
    }

    public void setSize(int i10, int i11) {
        this.f42166b = i11;
        this.f42168d = i10;
        this.f42165a = i11;
        this.f42167c = i10;
        this.f42169e = i10 * i11;
    }

    public void setSliceHeight(int i10) {
        this.f42165a = i10;
    }

    public void setStride(int i10) {
        this.f42167c = i10;
    }

    public void setYPadding(int i10) {
        this.f42172h = i10;
    }
}
