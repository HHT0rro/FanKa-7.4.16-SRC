package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileReadWrite.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d extends ByteArrayOutputStream {
    public d(int i10) {
        super(i10);
    }

    @NotNull
    public final byte[] a() {
        byte[] buf = this.buf;
        s.h(buf, "buf");
        return buf;
    }
}
