package b0;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class c implements FileFilter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f1233b;

    public c(b bVar) {
        this.f1233b = bVar;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
