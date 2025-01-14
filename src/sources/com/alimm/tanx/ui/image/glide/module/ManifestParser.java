package com.alimm.tanx.ui.image.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ManifestParser {
    public static final String GLIDE_MODULE_VALUE = "GlideModule";
    public final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    public static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object newInstance = cls.newInstance();
                if (!(newInstance instanceof GlideModule)) {
                    LogUtils.e(GLIDE_MODULE_VALUE, "Expected instanceof GlideModule, but found: " + newInstance);
                    return null;
                }
                return (GlideModule) newInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + ((Object) cls), e2);
            } catch (InstantiationException e10) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + ((Object) cls), e10);
            }
        } catch (ClassNotFoundException e11) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e11);
        }
    }

    public List<GlideModule> parse() {
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                        if (!TextUtils.isEmpty(str) && str.contains("integration.okhttp3.OkHttpGlideModule")) {
                            str = "com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpGlideModule";
                        }
                        GlideModule parseModule = parseModule(str);
                        if (parseModule != null) {
                            arrayList.add(parseModule);
                        }
                    }
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
