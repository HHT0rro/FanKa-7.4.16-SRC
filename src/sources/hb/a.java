package hb;

import android.graphics.Bitmap;
import java.util.Collection;

/* compiled from: MemoryCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface a {
    boolean a(String str, Bitmap bitmap);

    Bitmap get(String str);

    Collection<String> keys();

    Bitmap remove(String str);
}
