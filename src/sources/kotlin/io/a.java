package kotlin.io;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: IOStreams.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {
    public static final long a(@NotNull InputStream inputStream, @NotNull OutputStream out, int i10) {
        s.i(inputStream, "<this>");
        s.i(out, "out");
        byte[] bArr = new byte[i10];
        int read = inputStream.read(bArr);
        long j10 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j10 += read;
            read = inputStream.read(bArr);
        }
        return j10;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8192;
        }
        return a(inputStream, outputStream, i10);
    }
}
