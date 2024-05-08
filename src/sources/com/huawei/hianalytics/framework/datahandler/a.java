package com.huawei.hianalytics.framework.datahandler;

import com.huawei.hianalytics.core.crypto.AesCipher;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.framework.config.CipherType;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: com.huawei.hianalytics.framework.datahandler.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class C0275a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28794a;

        static {
            int[] iArr = new int[CipherType.values().length];
            f28794a = iArr;
            try {
                iArr[CipherType.AESGCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28794a[CipherType.AESC_BC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static String a(String str, IMandatoryParameters iMandatoryParameters) {
        if (iMandatoryParameters == null) {
            return "";
        }
        int i10 = C0275a.f28794a[iMandatoryParameters.getCipherType().ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? "" : AesCipher.decryptCbc(str, iMandatoryParameters.getLoadWorkKey());
        }
        return sa.b.c(AesCipher.getEncryptWord(str), iMandatoryParameters.getLoadWorkKey(), AesCipher.getGCMIv(str));
    }

    public static String b(String str, IMandatoryParameters iMandatoryParameters) {
        if (iMandatoryParameters == null) {
            return "";
        }
        String loadWorkKey = iMandatoryParameters.getLoadWorkKey();
        int i10 = C0275a.f28794a[iMandatoryParameters.getCipherType().ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? "" : AesCipher.encryptCbc(str, loadWorkKey);
        }
        String initRandomKey = HexUtil.initRandomKey(12);
        StringBuilder b4 = e9.a.b(initRandomKey);
        b4.append(sa.b.f(str, loadWorkKey, initRandomKey));
        return b4.toString();
    }
}
