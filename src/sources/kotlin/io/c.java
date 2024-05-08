package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.s;

/* compiled from: Exceptions.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + ((Object) file2));
        }
        if (str != null) {
            sb2.append(": " + str);
        }
        String sb3 = sb2.toString();
        s.h(sb3, "sb.toString()");
        return sb3;
    }
}
