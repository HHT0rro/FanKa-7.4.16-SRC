package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RequiresApi(api = 21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a extends Exception {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<X509Certificate> f10781a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Integer> f10782b;

        public b(List<X509Certificate> list, List<Integer> list2) {
            this.f10781a = list;
            this.f10782b = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.g.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0121c {

        /* renamed from: a, reason: collision with root package name */
        public final X509Certificate[] f10783a;

        /* renamed from: b, reason: collision with root package name */
        public final b f10784b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f10785c;

        public C0121c(X509Certificate[] x509CertificateArr, b bVar) {
            this.f10783a = x509CertificateArr;
            this.f10784b = bVar;
        }
    }

    public static C0121c a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f29912b);
            try {
                ByteBuffer a10 = f.a(mVar.f10801a);
                int i10 = 0;
                C0121c c0121c = null;
                while (a10.hasRemaining()) {
                    try {
                        c0121c = a(f.a(a10), arrayMap, certificateFactory);
                        i10++;
                    } catch (a unused) {
                    } catch (IOException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e);
                    } catch (SecurityException e10) {
                        e = e10;
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e);
                    } catch (BufferUnderflowException e11) {
                        e = e11;
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e);
                    }
                }
                if (i10 <= 0 || c0121c == null) {
                    throw new SecurityException("No signers found");
                }
                if (i10 == 1) {
                    if (!arrayMap.isEmpty()) {
                        f.a(arrayMap, randomAccessFile, mVar);
                        if (arrayMap.containsKey(3)) {
                            c0121c.f10785c = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                        }
                        return c0121c;
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
            } catch (IOException e12) {
                throw new SecurityException("Failed to read list of signers", e12);
            }
        } catch (CertificateException e13) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e13);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0058. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private static C0121c a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        ByteBuffer a10 = f.a(byteBuffer);
        int i10 = byteBuffer.getInt();
        int i11 = byteBuffer.getInt();
        ByteBuffer a11 = f.a(byteBuffer);
        byte[] b4 = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i12 = -1;
        int i13 = 0;
        byte[] bArr = null;
        while (true) {
            int i14 = 8;
            boolean z10 = true;
            if (!a11.hasRemaining()) {
                if (i12 == -1) {
                    if (i13 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String c4 = f.c(i12);
                Pair<String, ? extends AlgorithmParameterSpec> d10 = f.d(i12);
                String str = (String) d10.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d10.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(c4).generatePublic(new X509EncodedKeySpec(b4));
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(a10);
                    if (signature.verify(bArr)) {
                        a10.clear();
                        ByteBuffer a12 = f.a(a10);
                        ArrayList arrayList2 = new ArrayList();
                        byte[] bArr2 = null;
                        int i15 = 0;
                        while (a12.hasRemaining()) {
                            i15++;
                            try {
                                ByteBuffer a13 = f.a(a12);
                                if (a13.remaining() >= i14) {
                                    int i16 = a13.getInt();
                                    arrayList2.add(Integer.valueOf(i16));
                                    if (i16 == i12) {
                                        bArr2 = f.b(a13);
                                    }
                                    i14 = 8;
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i15)), e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int a14 = f.a(i12);
                            byte[] put = map.put(Integer.valueOf(a14), bArr2);
                            if (put != null && !MessageDigest.isEqual(put, bArr2)) {
                                throw new SecurityException(f.b(a14) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer a15 = f.a(a10);
                            ArrayList arrayList3 = new ArrayList();
                            int i17 = 0;
                            while (a15.hasRemaining()) {
                                i17++;
                                byte[] b10 = f.b(a15);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b10)), b10));
                                } catch (CertificateException e10) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i17)), e10);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(b4, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    if (a10.getInt() == i10) {
                                        if (a10.getInt() == i11) {
                                            return a(f.a(a10), arrayList3, certificateFactory);
                                        }
                                        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                    }
                                    throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                }
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                            throw new SecurityException("No certificates listed");
                        }
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    throw new SecurityException(str + " signature did not verify");
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e11) {
                    throw new SecurityException("Failed to verify " + str + " signature", e11);
                }
            }
            i13++;
            try {
                ByteBuffer a16 = f.a(a11);
                if (a16.remaining() >= 8) {
                    int i18 = a16.getInt();
                    arrayList.add(Integer.valueOf(i18));
                    if (i18 != 513 && i18 != 514 && i18 != 769 && i18 != 1057 && i18 != 1059 && i18 != 1061) {
                        switch (i18) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                z10 = false;
                                break;
                        }
                    }
                    if (z10 && (i12 == -1 || f.a(i18, i12) > 0)) {
                        bArr = f.b(a16);
                        i12 = i18;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e12) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i13)), e12);
            }
        }
    }

    private static C0121c a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        b bVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a10 = f.a(byteBuffer);
            if (a10.remaining() >= 4) {
                if (a10.getInt() == 1000370060) {
                    if (bVar == null) {
                        bVar = a(a10, certificateFactory);
                        try {
                            if (bVar.f10781a.size() > 0) {
                                if (!Arrays.equals(bVar.f10781a.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e2) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e2);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a10.remaining());
            }
        }
        return new C0121c(x509CertificateArr, bVar);
    }

    private static b a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i11 = -1;
            p pVar = null;
            while (byteBuffer.hasRemaining()) {
                i10++;
                ByteBuffer a10 = f.a(byteBuffer);
                ByteBuffer a11 = f.a(a10);
                int i12 = a10.getInt();
                int i13 = a10.getInt();
                byte[] b4 = f.b(a10);
                if (pVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> d10 = f.d(i11);
                    PublicKey publicKey = pVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) d10.first);
                    signature.initVerify(publicKey);
                    Object obj = d10.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(a11);
                    if (!signature.verify(b4)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i10 + " using " + ((String) d10.first) + " when verifying Proof-of-rotation record");
                    }
                }
                a11.rewind();
                byte[] b10 = f.b(a11);
                int i14 = a11.getInt();
                if (pVar != null && i11 != i14) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i10 + " when verifying Proof-of-rotation record");
                }
                pVar = new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b10)), b10);
                if (!hashSet.contains(pVar)) {
                    hashSet.add(pVar);
                    arrayList.add(pVar);
                    arrayList2.add(Integer.valueOf(i12));
                    i11 = i13;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i10 + ".  All signing certificates should be unique");
                }
            }
            return new b(arrayList, arrayList2);
        } catch (IOException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e10) {
            e = e10;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e11) {
            e = e11;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e12) {
            e = e12;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e13) {
            e = e13;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e14) {
            e = e14;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e15) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e15);
        }
    }
}
