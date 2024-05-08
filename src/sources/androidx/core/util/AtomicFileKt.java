package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: AtomicFile.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile atomicFile) {
        s.i(atomicFile, "<this>");
        byte[] readFully = atomicFile.readFully();
        s.h(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile atomicFile, @NotNull Charset charset) {
        s.i(atomicFile, "<this>");
        s.i(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        s.h(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = kotlin.text.c.f51097b;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull android.util.AtomicFile atomicFile, @NotNull Function1<? super FileOutputStream, p> block) {
        s.i(atomicFile, "<this>");
        s.i(block, "block");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            s.h(stream, "stream");
            block.invoke(stream);
            r.b(1);
            atomicFile.finishWrite(stream);
            r.a(1);
        } catch (Throwable th) {
            r.b(1);
            atomicFile.failWrite(stream);
            r.a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull android.util.AtomicFile atomicFile, @NotNull byte[] array) {
        s.i(atomicFile, "<this>");
        s.i(array, "array");
        FileOutputStream stream = atomicFile.startWrite();
        try {
            s.h(stream, "stream");
            stream.write(array);
            atomicFile.finishWrite(stream);
        } catch (Throwable th) {
            atomicFile.failWrite(stream);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull android.util.AtomicFile atomicFile, @NotNull String text, @NotNull Charset charset) {
        s.i(atomicFile, "<this>");
        s.i(text, "text");
        s.i(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        s.h(bytes, "this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = kotlin.text.c.f51097b;
        }
        writeText(atomicFile, str, charset);
    }
}
