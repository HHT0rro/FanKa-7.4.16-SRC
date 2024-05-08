package y9;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54691a;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("marketInstall");
        String str = File.separator;
        sb2.append(str);
        sb2.append("download");
        sb2.append(str);
        sb2.append("hiSpace.apk");
        f54691a = sb2.toString();
    }

    public static String a(@NonNull Context context) {
        return ((Object) context.getFilesDir()) + File.separator + f54691a;
    }
}
