package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.g.c;
import com.kuaishou.weapon.p0.t;
import com.tencent.vasdolly.common.V2SchemeUtil;
import com.tencent.vasdolly.common.V3SchemeUtil;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

@RequiresApi(api = 21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {
    public static o a(String str) {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        RandomAccessFile randomAccessFile2 = null;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, t.f36226k);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    f.a(str, randomAccessFile, V3SchemeUtil.APK_SIGNATURE_SCHEME_V3_BLOCK_ID, V2SchemeUtil.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
                    try {
                        try {
                            try {
                                m mVar = f.f10786a.get(str).get(V3SchemeUtil.APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
                                if (mVar != null) {
                                    c.C0121c a10 = c.a(randomAccessFile, mVar);
                                    Signature[] a11 = a(new Certificate[][]{a10.f10783a});
                                    c.b bVar = a10.f10784b;
                                    if (bVar != null) {
                                        int size = bVar.f10781a.size();
                                        Signature[] signatureArr2 = new Signature[size];
                                        iArr = new int[a10.f10784b.f10782b.size()];
                                        for (int i10 = 0; i10 < size; i10++) {
                                            signatureArr2[i10] = new Signature(a10.f10784b.f10781a.get(i10).getEncoded());
                                            iArr[i10] = a10.f10784b.f10782b.get(i10).intValue();
                                        }
                                        signatureArr = signatureArr2;
                                    } else {
                                        iArr = null;
                                    }
                                    o oVar = new o(a11, 3, signatureArr, iArr);
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused) {
                                    }
                                    return oVar;
                                }
                                throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                            } catch (n unused2) {
                                m mVar2 = f.f10786a.get(str).get(V2SchemeUtil.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
                                if (mVar2 != null) {
                                    o oVar2 = new o(a(b.a(randomAccessFile, mVar2).f10779a));
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception unused3) {
                                    }
                                    return oVar2;
                                }
                                throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            } catch (Exception e2) {
                                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                            }
                        } catch (n unused4) {
                            o a12 = a.a(str);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused5) {
                            }
                            return a12;
                        }
                    } catch (Exception e10) {
                        throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e10);
                    }
                } catch (Exception e11) {
                    throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e11);
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th;
            }
        } catch (Exception unused7) {
            throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
        }
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i10 = 0; i10 < certificateArr.length; i10++) {
            if (Build.VERSION.SDK_INT <= 28) {
                Constructor a10 = com.bytedance.pangle.b.b.a.a((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (a10 != null) {
                    a10.setAccessible(true);
                }
                if (a10 != null && a10.isAccessible()) {
                    try {
                        signatureArr[i10] = (Signature) a10.newInstance(certificateArr[i10]);
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InstantiationException e10) {
                        e10.printStackTrace();
                    } catch (InvocationTargetException e11) {
                        e11.printStackTrace();
                    }
                }
            } else {
                signatureArr[i10] = new Signature(certificateArr[i10][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
