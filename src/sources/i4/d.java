package i4;

import h4.e;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class d implements c {
    public abstract InputStream a() throws IOException;

    @Override // i4.c
    public final synchronized h4.d obtain() throws IOException {
        return new e(a());
    }
}
