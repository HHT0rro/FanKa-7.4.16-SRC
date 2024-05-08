package q0;

import com.kuaishou.weapon.p0.t;
import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f53000a = {108, ObjectStreamConstants.TC_STRING, 108, 111, ObjectStreamConstants.TC_CLASS, 101, ObjectStreamConstants.TC_BLOCKDATALONG, 104};

    public static String a(File file) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        long length;
        RandomAccessFile randomAccessFile2 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        String str = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, t.f36226k);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (UnsupportedEncodingException e10) {
                    e = e10;
                    randomAccessFile = null;
                } catch (IOException e11) {
                    e = e11;
                    randomAccessFile = null;
                } catch (Exception e12) {
                    e = e12;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    long length2 = randomAccessFile.length();
                    bArr = new byte[f53000a.length];
                    length = length2 - r7.length;
                    randomAccessFile.seek(length);
                    randomAccessFile.readFully(bArr);
                } catch (FileNotFoundException e14) {
                    e = e14;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (UnsupportedEncodingException e15) {
                    e = e15;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (IOException e16) {
                    e = e16;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (Exception e17) {
                    e = e17;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            if (!c(bArr)) {
                try {
                    randomAccessFile.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                return "";
            }
            long j10 = length - 2;
            randomAccessFile.seek(j10);
            int b4 = b(randomAccessFile);
            if (b4 <= 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e20) {
                    e20.printStackTrace();
                }
                return "";
            }
            randomAccessFile.seek(j10 - b4);
            byte[] bArr2 = new byte[b4];
            randomAccessFile.readFully(bArr2);
            String str2 = new String(bArr2, "UTF-8");
            try {
                randomAccessFile.close();
            } catch (IOException e21) {
                e21.printStackTrace();
            }
            str = str2;
            return str;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
        }
    }

    public static short b(DataInput dataInput) {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    public static boolean c(byte[] bArr) {
        if (bArr.length != f53000a.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f53000a;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }
}
