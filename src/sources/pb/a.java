package pb;

import java.io.File;

/* compiled from: DiskCacheUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public static boolean a(String str, db.a aVar) {
        File file = aVar.get(str);
        return file != null && file.exists() && file.delete();
    }
}
