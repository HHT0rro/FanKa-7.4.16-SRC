package ea;

import com.alimm.tanx.core.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static String a(int i10) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);
        if (i10 >= 100) {
            i10 = 100;
        }
        return percentInstance.format(i10 / 100.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v33 */
    public static String b(String str, String str2) {
        Throwable th;
        ?? r10;
        Throwable e2;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        String str3;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        r1 = null;
        r1 = null;
        String str4 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (FileNotFoundException unused) {
                    bufferedInputStream = null;
                } catch (IOException e10) {
                    e2 = e10;
                    bufferedInputStream = null;
                } catch (IllegalArgumentException e11) {
                    e2 = e11;
                    bufferedInputStream = null;
                } catch (IndexOutOfBoundsException e12) {
                    e2 = e12;
                    bufferedInputStream = null;
                } catch (NoSuchAlgorithmException e13) {
                    e2 = e13;
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    fileInputStream2 = fileInputStream;
                    r10 = str;
                    c(r10);
                    c(fileInputStream2);
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IOException e14) {
                e2 = e14;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IllegalArgumentException e15) {
                e2 = e15;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IndexOutOfBoundsException e16) {
                e2 = e16;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e17) {
                e2 = e17;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                r10 = 0;
                c(r10);
                c(fileInputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[131072];
                long j10 = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                    j10 += read;
                }
                if (j10 > 0) {
                    str4 = da.a.a(messageDigest.digest());
                }
            } catch (FileNotFoundException unused3) {
                fa.a.c(FileUtils.TAG, "getFileHashData FileNotFoundException");
                c(bufferedInputStream);
                c(fileInputStream);
                return str4;
            } catch (IOException e18) {
                e2 = e18;
                str3 = "getFileHashData IOException";
                fa.a.b(FileUtils.TAG, str3, e2);
                c(bufferedInputStream);
                c(fileInputStream);
                return str4;
            } catch (IllegalArgumentException e19) {
                e2 = e19;
                str3 = "getFileHashData IllegalArgumentException";
                fa.a.b(FileUtils.TAG, str3, e2);
                c(bufferedInputStream);
                c(fileInputStream);
                return str4;
            } catch (IndexOutOfBoundsException e20) {
                e2 = e20;
                str3 = "getFileHashData IndexOutOfBoundsException";
                fa.a.b(FileUtils.TAG, str3, e2);
                c(bufferedInputStream);
                c(fileInputStream);
                return str4;
            } catch (NoSuchAlgorithmException e21) {
                e2 = e21;
                str3 = "getFileHashData NoSuchAlgorithmException";
                fa.a.b(FileUtils.TAG, str3, e2);
                c(bufferedInputStream);
                c(fileInputStream);
                return str4;
            }
            c(bufferedInputStream);
            c(fileInputStream);
            return str4;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
                fa.a.e(FileUtils.TAG, "close stream exception");
            }
        }
    }
}
