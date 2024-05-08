package sun.security.util;

import com.android.internal.content.NativeLibraryHelper;
import java.io.File;
import jdk.internal.util.StaticProperty;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FilePaths {
    public static String cacerts() {
        return StaticProperty.javaHome() + File.separator + NativeLibraryHelper.LIB_DIR_NAME + File.separator + "security" + File.separator + "cacerts";
    }
}
