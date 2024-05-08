package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Utils.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(@NotNull File file) {
        super(file, null, null, 6, null);
        s.i(file, "file");
    }
}
