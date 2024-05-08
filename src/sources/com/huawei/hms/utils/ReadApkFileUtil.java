package com.huawei.hms.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Base64;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.lang3.StringUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ReadApkFileUtil {
    public static final String EMUI10_PK = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAx4nUogUyMCmzHhaEb420yvpw9zBs+ETzE9Qm77bGxl1Iml9JEkBkNTsUWOstLgUBajNhV+BAMVBHKMEdzoQbL5kIHkTgUVM65yewd+5+BhrcB9OQ3LHp+0BN6aLKZh71T4WvsvHFhfhQpShuGWkRkSaVGLFTHxX70kpWLzeZ3RtqiEUNIufPR2SFCH6EmecJ+HdkmBOh603IblCpGxwSWse0fDI98wZBEmV88RFaiYEgyiezLlWvXzqIj6I/xuyd5nGAegjH2y3cmoDE6CubecoB1jf4KdgACXgdiQ4Oc63MfLGTor3l6RCqeUk4APAMtyhK83jc72W1sdXMd/sj2wIDAQAB";
    public static final String EMUI11_PK = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAqq2eRTMYr2JHLtvuZzfgPrgU8oatD4Rar9fOD7E00es2VhtB3vTyaT2BvYPUPA/nbkHRPak3EZX77CfWj9tzLgSHJE8XLk9C+2ESkdrxCDA6z7I8X+cBDnA05OlCJeZFjnUbjYB8SP8M3BttdrvqtVPxTkEJhchC7UXnMLaJ3kQ3ZPjN7ubjYzO4rv7EtEpqr2bX+qjnSLIZZuUXraxqfdBuhGDIYq62dNsqiyrhX1mfvA3+43N4ZIs3BdfSYII8BNFmFxf+gyf1aoq386R2kAjHcrfOOhjAbZh+R1OAGLWPCqi3E9nB8EsZkeoTW/oIP6pJvgL3bnxq+1viT2dmZyipMgcx/3N6FJqkd67j/sPMtPlHJuq8/s0silzs13jAw1WBV6tWHFkLGpkWGs8jp50wQtndtY8cCPl2XPGmdPN72agH+zsHuKqr/HOB2TuzzaO8rKlGIDQlzZcCSHB28nnvOyBVN9xzLkbYiLnHfd6bTwzNPeqjWrTnPwKyH3BPAgMBAAE=";
    public static final String KEY_SIGNATURE = "Signature:";
    public static final String KEY_SIGNATURE2 = "Signature2:";
    public static final String KEY_SIGNATURE3 = "Signature3:";

    /* renamed from: a, reason: collision with root package name */
    private static final String f31964a = "ReadApkFileUtil";

    /* renamed from: c, reason: collision with root package name */
    private static String f31966c;

    /* renamed from: d, reason: collision with root package name */
    private static String f31967d;

    /* renamed from: e, reason: collision with root package name */
    private static String f31968e;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f31965b = Pattern.compile("\\s*|\t|\r|\n");

    /* renamed from: f, reason: collision with root package name */
    private static String f31969f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f31970g = null;

    private static byte[] a(ZipFile zipFile) {
        return a(zipFile, JarFile.MANIFEST_NAME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    private static void b(byte[] bArr) {
        Throwable th;
        BufferedReader bufferedReader;
        ?? r22;
        InputStream inputStream;
        InputStream inputStream2;
        if (bArr == null) {
            HMSLog.e(f31964a, "manifest is null！");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        f31966c = null;
        f31967d = null;
        f31968e = null;
        try {
            r22 = new ByteArrayInputStream(bArr);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader((InputStream) r22, StandardCharsets.UTF_8));
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                inputStream = r22;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th;
            }
            try {
                String a10 = a(bufferedReader);
                while (a10 != null) {
                    if (a10.length() != 0) {
                        if (a10.startsWith("ApkHash:")) {
                            f31969f = a(a10.substring(a10.indexOf(u.bD) + 1));
                        }
                        if (a10.startsWith(KEY_SIGNATURE)) {
                            f31966c = a(a10.substring(a10.indexOf(u.bD) + 1));
                            a10 = a(bufferedReader);
                        } else if (a10.startsWith(KEY_SIGNATURE2)) {
                            f31967d = a(a10.substring(a10.indexOf(u.bD) + 1));
                            a10 = a(bufferedReader);
                        } else if (a10.startsWith(KEY_SIGNATURE3)) {
                            f31968e = a(a10.substring(a10.indexOf(u.bD) + 1));
                            a10 = a(bufferedReader);
                        } else {
                            stringBuffer.append(a10);
                            stringBuffer.append(org.apache.commons.io.IOUtils.LINE_SEPARATOR_WINDOWS);
                        }
                    }
                    a10 = a(bufferedReader);
                }
                f31970g = stringBuffer.toString();
                inputStream2 = r22;
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                try {
                    HMSLog.e(f31964a, "loadApkCert Exception!");
                    bufferedReader = bufferedReader2;
                    inputStream2 = r22;
                    IOUtils.closeQuietly(inputStream2);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    bufferedReader2 = r22;
                    r22 = bufferedReader2;
                    bufferedReader2 = bufferedReader;
                    inputStream = r22;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((Reader) bufferedReader2);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = bufferedReader;
                inputStream = r22;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((Reader) bufferedReader2);
                throw th;
            }
        } catch (Exception unused3) {
            r22 = 0;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            r22 = bufferedReader2;
            bufferedReader2 = bufferedReader;
            inputStream = r22;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly((Reader) bufferedReader2);
            throw th;
        }
        IOUtils.closeQuietly(inputStream2);
        IOUtils.closeQuietly((Reader) bufferedReader);
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            cArr2[i12] = cArr[i11 >>> 4];
            cArr2[i12 + 1] = cArr[i11 & 15];
        }
        return String.valueOf(cArr2);
    }

    private static boolean c() {
        try {
        } catch (Exception e2) {
            HMSLog.i(f31964a, "verifyMDMSignatureV3 MDM verify Exception!:" + e2.getMessage());
        }
        if (a(Base64.decode(EMUI11_PK, 0), a(f31970g, "SHA-384"), b(f31968e), "SHA384withRSA")) {
            HMSLog.i(f31964a, "verifyMDMSignatureV3 verify successful!");
            return true;
        }
        HMSLog.i(f31964a, "verifyMDMSignatureV3 verify failure!");
        return false;
    }

    public static boolean checkSignature() {
        if (f31968e != null) {
            return c();
        }
        if (f31967d != null) {
            return b();
        }
        if (f31966c != null) {
            return a();
        }
        return false;
    }

    public static String getHmsPath(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.hwid", 128).sourceDir;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e(f31964a, "HMS is not found!");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.StringBuilder] */
    public static boolean isCertFound(String str) {
        ZipFile zipFile;
        boolean z10 = false;
        ZipFile zipFile2 = null;
        ZipFile zipFile3 = null;
        ZipFile zipFile4 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    boolean z11 = zipFile.getEntry("META-INF/HUAWEI.CER") != null;
                    if (z11) {
                        b(a(zipFile, "META-INF/HUAWEI.CER"));
                    }
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        String str2 = f31964a;
                        ?? sb2 = new StringBuilder();
                        sb2.append("zipFile.close Exception!");
                        sb2.append(e2.getMessage());
                        HMSLog.e(str2, sb2.toString());
                        zipFile3 = sb2;
                    }
                    z10 = z11;
                    zipFile2 = zipFile3;
                } catch (Exception e10) {
                    e = e10;
                    zipFile4 = zipFile;
                    HMSLog.e(f31964a, "isCertFound Exception!" + e.getMessage());
                    zipFile2 = zipFile4;
                    if (zipFile4 != null) {
                        try {
                            zipFile4.close();
                            zipFile2 = zipFile4;
                        } catch (IOException e11) {
                            String str3 = f31964a;
                            ?? sb3 = new StringBuilder();
                            sb3.append("zipFile.close Exception!");
                            sb3.append(e11.getMessage());
                            HMSLog.e(str3, sb3.toString());
                            zipFile2 = sb3;
                        }
                    }
                    return z10;
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e12) {
                            HMSLog.e(f31964a, "zipFile.close Exception!" + e12.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
            zipFile = zipFile2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.zip.ZipFile] */
    public static boolean verifyApkHash(String str) {
        ?? r22;
        String str2 = null;
        AutoCloseable autoCloseable = null;
        try {
            try {
                r22 = new ZipFile(str);
                try {
                    byte[] a10 = a((ZipFile) r22);
                    ArrayList<String> a11 = a(a10);
                    if (a11 != null) {
                        a10 = a(a11);
                    }
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(a10);
                    String bytesToString = bytesToString(messageDigest.digest());
                    String str3 = f31969f;
                    if (str3 != null) {
                        if (str3.equals(bytesToString)) {
                            try {
                                r22.close();
                            } catch (Exception e2) {
                                HMSLog.i(f31964a, "close stream Exception!" + e2.getMessage());
                            }
                            return true;
                        }
                    }
                    try {
                        r22.close();
                        return false;
                    } catch (Exception e10) {
                        HMSLog.i(f31964a, "close stream Exception!" + e10.getMessage());
                        return false;
                    }
                } catch (Exception e11) {
                    e = e11;
                    autoCloseable = r22;
                    HMSLog.i(f31964a, "verifyApkHash Exception!" + e.getMessage());
                    if (autoCloseable == null) {
                        return false;
                    }
                    try {
                        autoCloseable.close();
                        return false;
                    } catch (Exception e12) {
                        str2 = f31964a;
                        HMSLog.i(str2, "close stream Exception!" + e12.getMessage());
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r22 != null) {
                        try {
                            r22.close();
                        } catch (Exception e13) {
                            HMSLog.i(f31964a, "close stream Exception!" + e13.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e14) {
                e = e14;
            }
        } catch (Throwable th2) {
            th = th2;
            r22 = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    private static byte[] a(ZipFile zipFile, String str) {
        Throwable th;
        InputStream inputStream;
        Exception e2;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r42;
        OutputStream outputStream;
        OutputStream outputStream2;
        ZipEntry entry = zipFile.getEntry(str);
        OutputStream outputStream3 = null;
        if (entry == null) {
            return null;
        }
        try {
            inputStream = zipFile.getInputStream(entry);
            if (inputStream == null) {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                IOUtils.closeQuietly((OutputStream) null);
                return null;
            }
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
            } catch (Exception e10) {
                e2 = e10;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                r42 = byteArrayOutputStream;
                try {
                    HMSLog.i(f31964a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r42);
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    outputStream2 = r42;
                    bufferedInputStream = bufferedInputStream;
                    outputStream = outputStream2;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                bufferedInputStream = null;
                byteArrayOutputStream = null;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th2;
            }
            try {
                byte[] bArr = new byte[4096];
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    r42 = new BufferedOutputStream(byteArrayOutputStream);
                } catch (Exception e11) {
                    e2 = e11;
                    r42 = 0;
                } catch (Throwable th5) {
                    th2 = th5;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
                try {
                    for (int read = bufferedInputStream.read(bArr, 0, 4096); read > 0; read = bufferedInputStream.read(bArr, 0, 4096)) {
                        r42.write(bArr, 0, read);
                    }
                    r42.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r42);
                    return byteArray;
                } catch (Exception e12) {
                    e2 = e12;
                    HMSLog.i(f31964a, "getManifestBytes Exception!" + e2.getMessage());
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly((OutputStream) r42);
                    return null;
                } catch (Throwable th6) {
                    th2 = th6;
                    outputStream = r42;
                    outputStream3 = outputStream;
                    IOUtils.closeQuietly(inputStream);
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                    IOUtils.closeQuietly(outputStream3);
                    throw th2;
                }
            } catch (Exception e13) {
                e2 = e13;
                byteArrayOutputStream = null;
                r42 = byteArrayOutputStream;
                HMSLog.i(f31964a, "getManifestBytes Exception!" + e2.getMessage());
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly((OutputStream) r42);
                return null;
            } catch (Throwable th7) {
                th2 = th7;
                byteArrayOutputStream = null;
                outputStream2 = null;
                bufferedInputStream = bufferedInputStream;
                outputStream = outputStream2;
                outputStream3 = outputStream;
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly((InputStream) bufferedInputStream);
                IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
                IOUtils.closeQuietly(outputStream3);
                throw th2;
            }
        } catch (Exception e14) {
            e2 = e14;
            inputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    private static ArrayList<String> a(byte[] bArr) {
        if (bArr == null) {
            HMSLog.e(f31964a, "manifest is null！");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream, StandardCharsets.UTF_8));
                try {
                    if (a(bufferedReader, arrayList)) {
                        bufferedReader.close();
                        byteArrayInputStream.close();
                        return arrayList;
                    }
                    bufferedReader.close();
                    byteArrayInputStream.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            HMSLog.e(f31964a, "getManifestLinesArrary IOException!");
            return null;
        }
    }

    private static boolean b() {
        try {
        } catch (Exception e2) {
            HMSLog.i(f31964a, "verifyMDMSignatureV2 MDM verify Exception!:" + e2.getMessage());
        }
        if (a(Base64.decode(EMUI10_PK, 0), a(f31970g, "SHA-256"), b(f31967d), "SHA256withRSA")) {
            HMSLog.i(f31964a, "verifyMDMSignatureV2 verify successful!");
            return true;
        }
        HMSLog.i(f31964a, "verifyMDMSignatureV2 verify failure!");
        return false;
    }

    private static byte[] a(ArrayList<String> arrayList) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8));
        try {
            try {
                Collections.sort(arrayList);
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String str = arrayList.get(i10);
                    bufferedWriter.write(str, 0, str.length());
                    bufferedWriter.write(org.apache.commons.io.IOUtils.LINE_SEPARATOR_WINDOWS, 0, 2);
                }
                bufferedWriter.flush();
            } catch (Exception e2) {
                HMSLog.i(f31964a, "getManifestBytesbySorted Exception!" + e2.getMessage());
            }
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
            IOUtils.closeQuietly((Writer) bufferedWriter);
            throw th;
        }
    }

    private static byte[] b(String str) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 == 0) {
            i10 = length / 2;
        } else {
            i10 = (length / 2) + 1;
        }
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = i11 + 1;
            if (i12 < length) {
                bArr[i11 / 2] = (byte) ((Character.digit(str.charAt(i11), 16) << 4) + Character.digit(str.charAt(i12), 16));
            } else {
                bArr[i11 / 2] = (byte) (Character.digit(str.charAt(i11), 16) << 4);
            }
        }
        return bArr;
    }

    private static boolean a(BufferedReader bufferedReader, ArrayList<String> arrayList) throws IOException {
        String a10 = a(bufferedReader);
        boolean z10 = false;
        while (a10 != null) {
            if (a10.equals("Name: META-INF/HUAWEI.CER")) {
                z10 = true;
                String a11 = a(bufferedReader);
                while (true) {
                    if (a11 == null) {
                        break;
                    }
                    if (a11.startsWith("Name:")) {
                        a10 = a11;
                        break;
                    }
                    a11 = a(bufferedReader);
                }
            }
            if (a10.length() != 0) {
                arrayList.add(a10);
            }
            a10 = a(bufferedReader);
        }
        return z10;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        int read;
        if (bufferedReader == null || (read = bufferedReader.read()) == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(10);
        while (read != -1) {
            char c4 = (char) read;
            if (c4 == '\n') {
                break;
            }
            if (sb2.length() < 4096) {
                sb2.append(c4);
                read = bufferedReader.read();
            } else {
                throw new IOException("cert line is too long!");
            }
        }
        String sb3 = sb2.toString();
        return (sb3.isEmpty() || !sb3.endsWith(StringUtils.CR)) ? sb3 : sb3.substring(0, sb3.length() - 1);
    }

    private static boolean a() {
        try {
            if (a(b("30820122300d06092a864886f70d01010105000382010f003082010a0282010100a3d269348ac59923f65e8111c337605e29a1d1bc54fa96c1445050dd14d8d63b10f9f0230bb87ef348183660bedcabfdec045e235ed96935799fcdb4af5c97717ff3b0954eaf1b723225b3a00f81cbd67ce6dc5a4c07f7741ad3bf1913a480c6e267ab1740f409edd2dc33c8b718a8e30e56d9a93f321723c1d0c9ea62115f996812ceef186954595e39a19b74245542c407f7dddb1d12e6eedcfc0bd7cd945ef7255ad0fc9e796258e0fb5e52a23013d15033a32b4071b65f3f924ae5c5761e22327b4d2ae60f4158a5eb15565ba079de29b81540f5fbb3be101a95357f367fc661d797074ff3826950029c52223e4594673a24a334cae62d63b838ba3df9770203010001"), a(f31970g, "SHA-256"), b(f31966c), "SHA256withRSA")) {
                HMSLog.i(f31964a, "verifyMDMSignatureV1 verify successful!");
                return true;
            }
            HMSLog.i(f31964a, "verifyMDMSignatureV1 verify failure!");
            return false;
        } catch (Exception e2) {
            HMSLog.i(f31964a, "verifyMDMSignatureV1 MDM verify Exception!:" + e2.getMessage());
            return false;
        }
    }

    private static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws Exception {
        Signature signature = Signature.getInstance(str);
        signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr)));
        signature.update(bArr2);
        return signature.verify(bArr3);
    }

    private static byte[] a(String str, String str2) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(str2);
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8.name()));
        return messageDigest.digest();
    }

    private static String a(String str) {
        return str != null ? f31965b.matcher(str).replaceAll("") : "";
    }
}
