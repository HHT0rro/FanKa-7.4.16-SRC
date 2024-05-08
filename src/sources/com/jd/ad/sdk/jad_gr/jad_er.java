package com.jd.ad.sdk.jad_gr;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_gr.jad_an;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_er implements jad_an {

    @ColorInt
    public int[] jad_an;
    public final jad_an.InterfaceC0362jad_an jad_cp;
    public ByteBuffer jad_dq;
    public byte[] jad_er;
    public short[] jad_fs;
    public byte[] jad_hu;
    public byte[] jad_iv;
    public byte[] jad_jt;

    @ColorInt
    public int[] jad_jw;
    public int jad_kx;
    public Bitmap jad_mz;
    public boolean jad_na;
    public int jad_ob;
    public int jad_pc;
    public int jad_qd;
    public int jad_re;

    @Nullable
    public Boolean jad_sf;

    @ColorInt
    public final int[] jad_bo = new int[256];

    @NonNull
    public Bitmap.Config jad_tg = Bitmap.Config.ARGB_8888;
    public jad_cp jad_ly = new jad_cp();

    public jad_er(@NonNull jad_an.InterfaceC0362jad_an interfaceC0362jad_an) {
        this.jad_cp = interfaceC0362jad_an;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public void clear() {
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar3;
        this.jad_ly = null;
        byte[] bArr = this.jad_iv;
        if (bArr != null && (jad_boVar3 = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar3.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
        }
        int[] iArr = this.jad_jw;
        if (iArr != null && (jad_boVar2 = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar2.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) iArr);
        }
        Bitmap bitmap = this.jad_mz;
        if (bitmap != null) {
            ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_an.jad_an(bitmap);
        }
        this.jad_mz = null;
        this.jad_dq = null;
        this.jad_sf = null;
        byte[] bArr2 = this.jad_er;
        if (bArr2 == null || (jad_boVar = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_bo) == null) {
            return;
        }
        jad_boVar.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr2);
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_an() {
        return this.jad_kx;
    }

    public void jad_an(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.jad_tg = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + ((Object) config) + ", must be one of " + ((Object) Bitmap.Config.ARGB_8888) + " or " + ((Object) Bitmap.Config.RGB_565));
    }

    public synchronized void jad_an(@NonNull jad_cp jad_cpVar, @NonNull ByteBuffer byteBuffer, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
        int highestOneBit = Integer.highestOneBit(i10);
        this.jad_ob = 0;
        this.jad_ly = jad_cpVar;
        this.jad_kx = -1;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.jad_dq = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.jad_dq.order(ByteOrder.LITTLE_ENDIAN);
        this.jad_na = false;
        Iterator<jad_bo> iterator2 = jad_cpVar.jad_er.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            } else if (iterator2.next().jad_jt == 3) {
                this.jad_na = true;
                break;
            }
        }
        this.jad_pc = highestOneBit;
        int i11 = jad_cpVar.jad_fs;
        this.jad_re = i11 / highestOneBit;
        int i12 = jad_cpVar.jad_jt;
        this.jad_qd = i12 / highestOneBit;
        this.jad_iv = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_an(i11 * i12);
        jad_an.InterfaceC0362jad_an interfaceC0362jad_an = this.jad_cp;
        int i13 = this.jad_re * this.jad_qd;
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar = ((com.jd.ad.sdk.jad_vg.jad_bo) interfaceC0362jad_an).jad_bo;
        this.jad_jw = jad_boVar == null ? new int[i13] : (int[]) jad_boVar.jad_an(i13, int[].class);
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_bo() {
        return this.jad_ly.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_cp() {
        return (this.jad_jw.length * 4) + this.jad_dq.limit() + this.jad_iv.length;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public int jad_dq() {
        int i10;
        jad_cp jad_cpVar = this.jad_ly;
        int i11 = jad_cpVar.jad_cp;
        if (i11 <= 0 || (i10 = this.jad_kx) < 0) {
            return 0;
        }
        if (i10 < 0 || i10 >= i11) {
            return -1;
        }
        return jad_cpVar.jad_er.get(i10).jad_iv;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    @NonNull
    public ByteBuffer jad_er() {
        return this.jad_dq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fd, code lost:
    
        if (r5.jad_jw == r0.jad_hu) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04f7 A[Catch: all -> 0x054b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:8:0x003c, B:13:0x0046, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:40:0x00c6, B:42:0x00ca, B:43:0x00d3, B:45:0x00da, B:47:0x00de, B:49:0x00e2, B:51:0x00e7, B:54:0x00ed, B:56:0x00f1, B:58:0x00f9, B:60:0x0100, B:62:0x0118, B:64:0x011d, B:66:0x0122, B:70:0x0128, B:72:0x012c, B:73:0x013c, B:75:0x014d, B:77:0x015a, B:79:0x0162, B:80:0x0166, B:82:0x016c, B:83:0x0170, B:85:0x0176, B:86:0x017c, B:88:0x0193, B:90:0x019d, B:94:0x01bc, B:148:0x01e0, B:99:0x01ee, B:101:0x020c, B:135:0x0239, B:110:0x024c, B:113:0x0256, B:115:0x025f, B:116:0x0269, B:118:0x026f, B:122:0x027c, B:126:0x028b, B:311:0x01ca, B:149:0x02bb, B:151:0x02c5, B:154:0x02cc, B:157:0x02dd, B:159:0x02e7, B:162:0x02f5, B:164:0x02fb, B:166:0x0305, B:168:0x0309, B:170:0x030d, B:175:0x0316, B:177:0x031d, B:179:0x0321, B:182:0x0333, B:183:0x04e8, B:185:0x04ec, B:189:0x04f3, B:191:0x04f7, B:192:0x04fd, B:193:0x0510, B:196:0x0327, B:203:0x033d, B:206:0x0354, B:208:0x0369, B:211:0x0371, B:218:0x0393, B:219:0x039a, B:223:0x03a3, B:226:0x03af, B:230:0x03bf, B:232:0x03cc, B:234:0x03d6, B:237:0x03d3, B:245:0x04c0, B:246:0x03ec, B:248:0x03fb, B:249:0x040c, B:251:0x0411, B:254:0x041a, B:256:0x0425, B:258:0x0441, B:262:0x044a, B:263:0x044e, B:265:0x0453, B:268:0x045a, B:270:0x0465, B:272:0x047a, B:279:0x0497, B:281:0x04a1, B:284:0x049e, B:288:0x0483, B:304:0x04d4, B:308:0x04e2, B:309:0x04de, B:314:0x0150, B:315:0x007a, B:317:0x0528, B:319:0x0531, B:322:0x0010, B:324:0x0018, B:325:0x003a), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0118 A[Catch: all -> 0x054b, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:8:0x003c, B:13:0x0046, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:40:0x00c6, B:42:0x00ca, B:43:0x00d3, B:45:0x00da, B:47:0x00de, B:49:0x00e2, B:51:0x00e7, B:54:0x00ed, B:56:0x00f1, B:58:0x00f9, B:60:0x0100, B:62:0x0118, B:64:0x011d, B:66:0x0122, B:70:0x0128, B:72:0x012c, B:73:0x013c, B:75:0x014d, B:77:0x015a, B:79:0x0162, B:80:0x0166, B:82:0x016c, B:83:0x0170, B:85:0x0176, B:86:0x017c, B:88:0x0193, B:90:0x019d, B:94:0x01bc, B:148:0x01e0, B:99:0x01ee, B:101:0x020c, B:135:0x0239, B:110:0x024c, B:113:0x0256, B:115:0x025f, B:116:0x0269, B:118:0x026f, B:122:0x027c, B:126:0x028b, B:311:0x01ca, B:149:0x02bb, B:151:0x02c5, B:154:0x02cc, B:157:0x02dd, B:159:0x02e7, B:162:0x02f5, B:164:0x02fb, B:166:0x0305, B:168:0x0309, B:170:0x030d, B:175:0x0316, B:177:0x031d, B:179:0x0321, B:182:0x0333, B:183:0x04e8, B:185:0x04ec, B:189:0x04f3, B:191:0x04f7, B:192:0x04fd, B:193:0x0510, B:196:0x0327, B:203:0x033d, B:206:0x0354, B:208:0x0369, B:211:0x0371, B:218:0x0393, B:219:0x039a, B:223:0x03a3, B:226:0x03af, B:230:0x03bf, B:232:0x03cc, B:234:0x03d6, B:237:0x03d3, B:245:0x04c0, B:246:0x03ec, B:248:0x03fb, B:249:0x040c, B:251:0x0411, B:254:0x041a, B:256:0x0425, B:258:0x0441, B:262:0x044a, B:263:0x044e, B:265:0x0453, B:268:0x045a, B:270:0x0465, B:272:0x047a, B:279:0x0497, B:281:0x04a1, B:284:0x049e, B:288:0x0483, B:304:0x04d4, B:308:0x04e2, B:309:0x04de, B:314:0x0150, B:315:0x007a, B:317:0x0528, B:319:0x0531, B:322:0x0010, B:324:0x0018, B:325:0x003a), top: B:3:0x0003 }] */
    @Override // com.jd.ad.sdk.jad_gr.jad_an
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.graphics.Bitmap jad_fs() {
        /*
            Method dump skipped, instructions count: 1358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_gr.jad_er.jad_fs():android.graphics.Bitmap");
    }

    public final Bitmap jad_hu() {
        Boolean bool = this.jad_sf;
        Bitmap.Config config = (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.jad_tg;
        Bitmap jad_bo = ((com.jd.ad.sdk.jad_vg.jad_bo) this.jad_cp).jad_an.jad_bo(this.jad_re, this.jad_qd, config);
        jad_bo.setHasAlpha(true);
        return jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_gr.jad_an
    public void jad_jt() {
        this.jad_kx = (this.jad_kx + 1) % this.jad_ly.jad_cp;
    }
}
