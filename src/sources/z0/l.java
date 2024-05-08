package z0;

import java.io.File;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l {
    public static final long a(@NotNull File file) {
        kotlin.jvm.internal.s.i(file, "<this>");
        if (file.isDirectory()) {
            long j10 = 0;
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                j10 += file2.isDirectory() ? a(file) : file2.length();
            }
            return j10;
        }
        return file.length();
    }
}
