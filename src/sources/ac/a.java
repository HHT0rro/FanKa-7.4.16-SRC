package ac;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static float f724a;

    /* renamed from: b, reason: collision with root package name */
    public static DisplayMetrics f725b;

    /* renamed from: c, reason: collision with root package name */
    public static float f726c;

    public static void a(Context context) {
        f725b = new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        f725b = displayMetrics;
        float f10 = displayMetrics.densityDpi;
        f724a = f10;
        f726c = f10 / 160.0f;
    }
}
