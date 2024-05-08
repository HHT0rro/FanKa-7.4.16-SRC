package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.ZipConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {
    public static d a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, t.f36226k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() >= 22) {
                d dVar = new d(str);
                long length = randomAccessFile.length();
                if (length >= 22) {
                    long j10 = length - 22;
                    randomAccessFile.seek(j10);
                    if (dVar.f10990c.a(randomAccessFile) != ZipConstants.ENDSIG) {
                        j10 = b(randomAccessFile, dVar);
                    }
                    randomAccessFile.seek(j10 + 4);
                    com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
                    randomAccessFile.skipBytes(6);
                    bVar.f10976a = dVar.f10990c.b(randomAccessFile);
                    randomAccessFile.skipBytes(4);
                    bVar.f10977b = dVar.f10990c.a(randomAccessFile);
                    dVar.f10989b = bVar;
                    if (bVar.f10976a == 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return dVar;
                    }
                    a(randomAccessFile, dVar);
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return dVar;
                }
                throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
            }
            throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private static long b(RandomAccessFile randomAccessFile, d dVar) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.f10990c.a(randomAccessFile) == ZipConstants.ENDSIG) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private static void a(RandomAccessFile randomAccessFile, d dVar) {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        ArrayList arrayList = new ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.f10989b;
        long j10 = bVar.f10977b;
        long j11 = bVar.f10976a;
        randomAccessFile.seek(j10);
        for (int i10 = 0; i10 < j11; i10++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.f10990c.a(randomAccessFile) == ZipConstants.CENSIG) {
                randomAccessFile.skipBytes(6);
                cVar.f10978a = dVar.f10990c.b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                cVar.f10979b = dVar.f10990c.a(randomAccessFile);
                cVar.f10980c = dVar.f10990c.a(randomAccessFile);
                cVar.f10981d = dVar.f10990c.a(randomAccessFile);
                int b4 = dVar.f10990c.b(randomAccessFile);
                cVar.f10982e = b4;
                cVar.f10983f = dVar.f10990c.b(randomAccessFile);
                int b10 = dVar.f10990c.b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                cVar.f10986i = dVar.f10990c.a(randomAccessFile);
                if (b4 > 0) {
                    byte[] bArr = new byte[b4];
                    randomAccessFile.readFully(bArr);
                    cVar.f10985h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(cVar.f10983f);
                    if (b10 > 0) {
                        randomAccessFile.skipBytes(b10);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(cVar.f10986i + 28);
                    cVar.f10984g = dVar.f10990c.b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(cVar);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i10 + 1) + ")");
            }
        }
        aVar.f10975a = arrayList;
        dVar.f10988a = aVar;
    }
}
