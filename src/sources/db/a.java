package db;

import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import pb.c;

/* compiled from: DiskCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface a {
    boolean a(String str, InputStream inputStream, c.a aVar) throws IOException;

    File get(String str);

    boolean save(String str, Bitmap bitmap) throws IOException;
}
