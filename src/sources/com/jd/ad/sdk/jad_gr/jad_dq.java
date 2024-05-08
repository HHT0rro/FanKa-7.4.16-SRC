package com.jd.ad.sdk.jad_gr;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser;
import com.jd.ad.sdk.logger.Logger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq {
    public ByteBuffer jad_bo;
    public jad_cp jad_cp;
    public final byte[] jad_an = new byte[256];
    public int jad_dq = 0;

    public final boolean jad_an() {
        return this.jad_cp.jad_bo != 0;
    }

    @Nullable
    public final int[] jad_an(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.jad_bo.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i11 + 1;
                iArr[i11] = ((bArr[i12] & 255) << 16) | (-16777216) | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                i12 = i15;
                i11 = i16;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                Logger.d(GifHeaderParser.TAG, "Format Error Reading Color Table", e2);
            }
            this.jad_cp.jad_bo = 1;
        }
        return iArr;
    }

    @NonNull
    public jad_cp jad_bo() {
        if (this.jad_bo == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (jad_an()) {
            return this.jad_cp;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) jad_cp());
        }
        if (sb2.toString().startsWith("GIF")) {
            this.jad_cp.jad_fs = this.jad_bo.getShort();
            this.jad_cp.jad_jt = this.jad_bo.getShort();
            int jad_cp = jad_cp();
            jad_cp jad_cpVar = this.jad_cp;
            jad_cpVar.jad_hu = (jad_cp & 128) != 0;
            jad_cpVar.jad_iv = (int) Math.pow(2.0d, (jad_cp & 7) + 1);
            this.jad_cp.jad_jw = jad_cp();
            jad_cp jad_cpVar2 = this.jad_cp;
            jad_cp();
            jad_cpVar2.getClass();
            if (this.jad_cp.jad_hu && !jad_an()) {
                jad_cp jad_cpVar3 = this.jad_cp;
                jad_cpVar3.jad_an = jad_an(jad_cpVar3.jad_iv);
                jad_cp jad_cpVar4 = this.jad_cp;
                jad_cpVar4.jad_kx = jad_cpVar4.jad_an[jad_cpVar4.jad_jw];
            }
        } else {
            this.jad_cp.jad_bo = 1;
        }
        if (!jad_an()) {
            boolean z10 = false;
            while (!z10 && !jad_an() && this.jad_cp.jad_cp <= Integer.MAX_VALUE) {
                int jad_cp2 = jad_cp();
                if (jad_cp2 == 33) {
                    int jad_cp3 = jad_cp();
                    if (jad_cp3 != 1) {
                        if (jad_cp3 == 249) {
                            this.jad_cp.jad_dq = new jad_bo();
                            jad_cp();
                            int jad_cp4 = jad_cp();
                            jad_bo jad_boVar = this.jad_cp.jad_dq;
                            int i11 = (jad_cp4 & 28) >> 2;
                            jad_boVar.jad_jt = i11;
                            if (i11 == 0) {
                                jad_boVar.jad_jt = 1;
                            }
                            jad_boVar.jad_fs = (jad_cp4 & 1) != 0;
                            short s2 = this.jad_bo.getShort();
                            if (s2 < 2) {
                                s2 = 10;
                            }
                            jad_bo jad_boVar2 = this.jad_cp.jad_dq;
                            jad_boVar2.jad_iv = s2 * 10;
                            jad_boVar2.jad_hu = jad_cp();
                            jad_cp();
                        } else if (jad_cp3 != 254 && jad_cp3 == 255) {
                            jad_dq();
                            StringBuilder sb3 = new StringBuilder();
                            for (int i12 = 0; i12 < 11; i12++) {
                                sb3.append((char) this.jad_an[i12]);
                            }
                            if (sb3.toString().equals("NETSCAPE2.0")) {
                                do {
                                    jad_dq();
                                    byte[] bArr = this.jad_an;
                                    if (bArr[0] == 1) {
                                        byte b4 = bArr[1];
                                        byte b10 = bArr[2];
                                        this.jad_cp.getClass();
                                    }
                                    if (this.jad_dq > 0) {
                                    }
                                } while (!jad_an());
                            }
                        }
                    }
                    jad_er();
                } else if (jad_cp2 == 44) {
                    jad_cp jad_cpVar5 = this.jad_cp;
                    if (jad_cpVar5.jad_dq == null) {
                        jad_cpVar5.jad_dq = new jad_bo();
                    }
                    jad_cpVar5.jad_dq.jad_an = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_bo = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_cp = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_dq = this.jad_bo.getShort();
                    int jad_cp5 = jad_cp();
                    boolean z11 = (jad_cp5 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (jad_cp5 & 7) + 1);
                    jad_bo jad_boVar3 = this.jad_cp.jad_dq;
                    jad_boVar3.jad_er = (jad_cp5 & 64) != 0;
                    if (z11) {
                        jad_boVar3.jad_kx = jad_an(pow);
                    } else {
                        jad_boVar3.jad_kx = null;
                    }
                    this.jad_cp.jad_dq.jad_jw = this.jad_bo.position();
                    jad_cp();
                    jad_er();
                    if (!jad_an()) {
                        jad_cp jad_cpVar6 = this.jad_cp;
                        jad_cpVar6.jad_cp++;
                        jad_cpVar6.jad_er.add(jad_cpVar6.jad_dq);
                    }
                } else if (jad_cp2 != 59) {
                    this.jad_cp.jad_bo = 1;
                } else {
                    z10 = true;
                }
            }
            jad_cp jad_cpVar7 = this.jad_cp;
            if (jad_cpVar7.jad_cp < 0) {
                jad_cpVar7.jad_bo = 1;
            }
        }
        return this.jad_cp;
    }

    public final int jad_cp() {
        try {
            return this.jad_bo.get() & 255;
        } catch (Exception unused) {
            this.jad_cp.jad_bo = 1;
            return 0;
        }
    }

    public final void jad_dq() {
        int jad_cp = jad_cp();
        this.jad_dq = jad_cp;
        if (jad_cp <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            try {
                i11 = this.jad_dq;
                if (i10 >= i11) {
                    return;
                }
                i11 -= i10;
                this.jad_bo.get(this.jad_an, i10, i11);
                i10 += i11;
            } catch (Exception e2) {
                if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                    Logger.d(GifHeaderParser.TAG, "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.jad_dq, e2);
                }
                this.jad_cp.jad_bo = 1;
                return;
            }
        }
    }

    public final void jad_er() {
        int jad_cp;
        do {
            jad_cp = jad_cp();
            this.jad_bo.position(Math.min(this.jad_bo.position() + jad_cp, this.jad_bo.limit()));
        } while (jad_cp > 0);
    }
}
