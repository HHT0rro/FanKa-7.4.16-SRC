package appa.appa.appf;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AppResourceHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {

    /* renamed from: appa, reason: collision with root package name */
    private ContextThemeWrapper f1015appa;

    private appa(Context context, Resources resources) {
        this.f1015appa = new ContextThemeWrapper(context, 0);
        try {
            Field declaredField = ContextThemeWrapper.class.getDeclaredField("mResources");
            declaredField.setAccessible(true);
            declaredField.set(this.f1015appa, resources);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ContextThemeWrapper appa() {
        return this.f1015appa;
    }

    public static ContextThemeWrapper appa(Context context, Resources resources) {
        return new appa(context, resources).appa();
    }
}
