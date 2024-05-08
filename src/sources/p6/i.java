package p6;

import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: ContentMetadata.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class i {
    public static long a(j jVar) {
        return jVar.a("exo_len", -1L);
    }

    @Nullable
    public static Uri b(j jVar) {
        String str = jVar.get("exo_redir", null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }
}
