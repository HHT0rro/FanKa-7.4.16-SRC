package com.alimm.tanx.core.image;

import android.app.Activity;
import android.content.Context;
import com.alimm.tanx.core.TanxCoreInstanceConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageManager implements NotConfused {
    public static ILoader loader;

    public static ILoader getLoader() {
        if (loader == null) {
            loader = TanxCoreInstanceConfig.getInstance().getImageLoader();
        }
        return loader;
    }

    public static boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static void setLoader(ILoader iLoader) {
        loader = iLoader;
    }

    public static ImageConfig.Builder with(Context context) {
        if (isValidContextForGlide(context)) {
            return new ImageConfig.Builder(context);
        }
        return new ImageConfig.Builder(context.getApplicationContext());
    }
}
