package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Uri.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        s.i(uri, "<this>");
        if (s.d(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + ((Object) uri)).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + ((Object) uri)).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        s.i(str, "<this>");
        Uri parse = Uri.parse(str);
        s.h(parse, "parse(this)");
        return parse;
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        s.i(file, "<this>");
        Uri fromFile = Uri.fromFile(file);
        s.h(fromFile, "fromFile(this)");
        return fromFile;
    }
}
