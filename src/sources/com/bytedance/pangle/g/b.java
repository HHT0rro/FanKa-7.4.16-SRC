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
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RequiresApi(api = 21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final X509Certificate[][] f10779a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f10780b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f10779a = x509CertificateArr;
            this.f10780b = bArr;
        }
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f29912b);
            try {
                ByteBuffer a10 = f.a(mVar.f10801a);
                int i10 = 0;
                while (a10.hasRemaining()) {
                    i10++;
                    try {
                        arrayList.add(a(f.a(a10), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e2);
                    }
                }
                if (i10 > 0) {
                    if (!arrayMap.isEmpty()) {
                        f.a(arrayMap, randomAccessFile, mVar);
                        return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), arrayMap.containsKey(3) ? f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar) : null);
                    }
                    throw new SecurityException("No content digests found");
                }
                throw new SecurityException("No signers found");
            } catch (IOException e10) {
                throw new SecurityException("Failed to read list of signers", e10);
            }
        } catch (CertificateException e11) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e11);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x004f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        ByteBuffer a10 = f.a(byteBuffer);
        ByteBuffer a11 = f.a(byteBuffer);
        byte[] b4 = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i10 = -1;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (!a11.hasRemaining()) {
                if (i10 == -1) {
                    if (i11 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String c4 = f.c(i10);
                Pair<String, ? extends AlgorithmParameterSpec> d10 = f.d(i10);
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
                    if (signature.verify(bArr2)) {
                        a10.clear();
                        ByteBuffer a12 = f.a(a10);
                        ArrayList arrayList2 = new ArrayList();
                        int i12 = 0;
                        while (a12.hasRemaining()) {
                            i12++;
                            try {
                                ByteBuffer a13 = f.a(a12);
                                if (a13.remaining() >= 8) {
                                    int i13 = a13.getInt();
                                    arrayList2.add(Integer.valueOf(i13));
                                    if (i13 == i10) {
                                        bArr = f.b(a13);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i12)), e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int a14 = f.a(i10);
                            byte[] put = map.put(Integer.valueOf(a14), bArr);
                            if (put != null && !MessageDigest.isEqual(put, bArr)) {
                                throw new SecurityException(f.b(a14) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer a15 = f.a(a10);
                            ArrayList arrayList3 = new ArrayList();
                            int i14 = 0;
                            while (a15.hasRemaining()) {
                                i14++;
                                byte[] b10 = f.b(a15);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b10)), b10));
                                } catch (CertificateException e10) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i14)), e10);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(b4, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    a(f.a(a10));
                                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
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
            i11++;
            try {
                ByteBuffer a16 = f.a(a11);
                if (a16.remaining() >= 8) {
                    int i15 = a16.getInt();
                    arrayList.add(Integer.valueOf(i15));
                    if (i15 != 513 && i15 != 514 && i15 != 769 && i15 != 1057 && i15 != 1059 && i15 != 1061) {
                        switch (i15) {
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
                    if (z10 && (i10 == -1 || f.a(i15, i10) > 0)) {
                        bArr2 = f.b(a16);
                        i10 = i15;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e12) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i11)), e12);
            }
        }
    }

    private static void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a10 = f.a(byteBuffer);
            if (a10.remaining() >= 4) {
                if (a10.getInt() == -1091571699) {
                    if (a10.remaining() >= 4) {
                        if (a10.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + a10.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a10.remaining());
            }
        }
    }
}
