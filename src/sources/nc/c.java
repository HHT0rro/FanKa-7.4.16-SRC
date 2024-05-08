package nc;

import android.content.Context;

/* compiled from: DisplayUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c {
    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
