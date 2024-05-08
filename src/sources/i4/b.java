package i4;

import java.io.File;
import java.io.IOException;

/* compiled from: FileLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final File f49721a;

    public b(String str) {
        this.f49721a = new File(str);
    }

    @Override // i4.c
    public synchronized h4.d obtain() throws IOException {
        return new h4.b(this.f49721a);
    }
}
