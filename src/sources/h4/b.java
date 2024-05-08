package h4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: FileReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b extends c {

    /* renamed from: c, reason: collision with root package name */
    public final File f49497c;

    public b(File file) throws IOException {
        super(new e(new FileInputStream(file)));
        this.f49497c = file;
    }

    @Override // h4.c, h4.d
    public void reset() throws IOException {
        this.f49498b.close();
        this.f49498b = new e(new FileInputStream(this.f49497c));
    }
}
