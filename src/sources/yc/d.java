package yc;

import android.content.Context;
import java.io.File;

/* compiled from: ContextCompat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f54809a = new Object();

    public static File[] a(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] b(Context context) {
        return context.getExternalCacheDirs();
    }
}
