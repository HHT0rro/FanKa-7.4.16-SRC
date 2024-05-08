package com.huawei.hianalytics;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.core.crypto.AesCipher;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.crypto.PBKDF2encrypt;
import com.huawei.hianalytics.core.log.HiLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class q {
    public static q ikl;
    public String klm;
    public String lmn;
    public static final Object ijk = new Object();
    public static final Object hij = new Object();

    public static q lmn() {
        if (ikl == null) {
            synchronized (q.class) {
                if (ikl == null) {
                    ikl = new q();
                }
            }
        }
        return ikl;
    }

    public final void ghi() {
        String klm;
        String klm2;
        String klm3;
        String klm4;
        if (TextUtils.isEmpty(this.lmn)) {
            p pVar = new p();
            long lmn = j0.lmn("Privacy_MY", "assemblyFlash", -1L);
            boolean z10 = true;
            if (-1 == lmn) {
                HiLog.i("ComponentManager", "First init components");
            } else if (System.currentTimeMillis() - lmn <= 31536000000L) {
                z10 = false;
            }
            if (z10) {
                HiLog.i("ComponentManager", "refresh components");
                klm = HexUtil.initRandomKey(128);
                pVar.lmn("aprpap", klm);
                klm2 = HexUtil.initRandomKey(128);
                pVar.lmn("febdoc", klm2);
                klm3 = HexUtil.initRandomKey(128);
                pVar.lmn("marfil", klm3);
                klm4 = HexUtil.initRandomKey(128);
                pVar.lmn("maywnj", klm4);
                j0.klm("Privacy_MY", "assemblyFlash", System.currentTimeMillis());
            } else {
                klm = pVar.klm("aprpap");
                klm2 = pVar.klm("febdoc");
                klm3 = pVar.klm("marfil");
                klm4 = pVar.klm("maywnj");
            }
            byte[] hexString2ByteArray = HexUtil.hexString2ByteArray(klm);
            byte[] hexString2ByteArray2 = HexUtil.hexString2ByteArray(klm2);
            byte[] hexString2ByteArray3 = HexUtil.hexString2ByteArray(klm3);
            byte[] hexString2ByteArray4 = HexUtil.hexString2ByteArray("f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc");
            int length = hexString2ByteArray.length;
            if (length > hexString2ByteArray2.length) {
                length = hexString2ByteArray2.length;
            }
            if (length > hexString2ByteArray3.length) {
                length = hexString2ByteArray3.length;
            }
            if (length > hexString2ByteArray4.length) {
                length = hexString2ByteArray4.length;
            }
            char[] cArr = new char[length];
            for (int i10 = 0; i10 < length; i10++) {
                cArr[i10] = (char) (((hexString2ByteArray[i10] ^ hexString2ByteArray2[i10]) ^ hexString2ByteArray3[i10]) ^ hexString2ByteArray4[i10]);
            }
            this.lmn = HexUtil.byteArray2HexString(PBKDF2encrypt.pbkdf2(cArr, HexUtil.hexString2ByteArray(klm4), 10000, 128));
        }
    }

    public final void hij() {
        String str;
        if (TextUtils.isEmpty(this.klm)) {
            String lmn = j0.lmn("Privacy_MY", "PrivacyData", "");
            if (TextUtils.isEmpty(lmn)) {
                str = HexUtil.initRandomKey(16);
                klm(lmn(str));
            } else {
                String d10 = ijk() ? ua.a.d("analytics_keystore_formal", lmn) : "";
                if (TextUtils.isEmpty(d10)) {
                    HiLog.i("RootKeyManager", "deCrypt work key first");
                    str = AesCipher.decryptCbc(lmn, ikl());
                    if (TextUtils.isEmpty(str)) {
                        str = HexUtil.initRandomKey(16);
                        klm(lmn(str));
                        if (ijk()) {
                            p.lmn();
                        }
                    } else if (ijk()) {
                        klm(lmn(str));
                        p.lmn();
                    }
                } else {
                    str = d10;
                }
            }
            this.klm = str;
        }
    }

    public final boolean ijk() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public final String ikl() {
        if (TextUtils.isEmpty(this.lmn)) {
            synchronized (hij) {
                ghi();
            }
        }
        return this.lmn;
    }

    public String klm() {
        if (TextUtils.isEmpty(this.klm)) {
            synchronized (ijk) {
                hij();
            }
        }
        return this.klm;
    }

    public final String lmn(String str) {
        if (ijk()) {
            HiLog.i("RootKeyManager", "load work key encrypt is gcm ks");
            return ua.a.g("analytics_keystore_formal", str);
        }
        return AesCipher.encryptCbc(str, ikl());
    }

    public final void klm(String str) {
        j0.klm("Privacy_MY", "PrivacyData", str);
        j0.klm("Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    }
}
