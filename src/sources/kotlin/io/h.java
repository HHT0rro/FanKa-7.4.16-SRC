package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.zip.ZipUtils;
import kotlin.collections.l;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileReadWrite.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h extends g {
    @NotNull
    public static final byte[] c(@NotNull File file) {
        s.i(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                int i10 = (int) length;
                byte[] bArr = new byte[i10];
                int i11 = i10;
                int i12 = 0;
                while (i11 > 0) {
                    int read = fileInputStream.read(bArr, i12, i11);
                    if (read < 0) {
                        break;
                    }
                    i11 -= read;
                    i12 += read;
                }
                if (i11 > 0) {
                    bArr = Arrays.copyOf(bArr, i12);
                    s.h(bArr, "copyOf(this, newSize)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        d dVar = new d(8193);
                        dVar.write(read2);
                        a.b(fileInputStream, dVar, 0, 2, null);
                        int size = dVar.size() + i10;
                        if (size >= 0) {
                            byte[] a10 = dVar.a();
                            byte[] copyOf = Arrays.copyOf(bArr, size);
                            s.h(copyOf, "copyOf(this, newSize)");
                            bArr = l.e(a10, copyOf, i10, 0, dVar.size());
                        } else {
                            throw new OutOfMemoryError("File " + ((Object) file) + " is too big to fit in memory.");
                        }
                    }
                }
                b.a(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + ((Object) file) + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }
}
