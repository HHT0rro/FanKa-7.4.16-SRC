package com.alimm.tanx.core.view.player.cache.videocache;

import android.content.Context;
import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class StorageUtils {
    public static final String INDIVIDUAL_DIR_NAME = "video-cache";
    public static final Logger LOG = LoggerFactory.getLogger("StorageUtils");

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        String[] list = file.list();
        if (list != null) {
            for (String str2 : list) {
                deleteFile(str + File.separator + str2);
            }
        }
        return file.delete();
    }

    public static boolean deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
        }
        return true;
    }

    public static File getCacheDirectory(Context context, boolean z10) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir;
        }
        String str = "/data/data/" + context.getPackageName() + "/cache/";
        LOG.warn("Can't define system cache directory! '" + str + "%s' will be used.");
        return new File(str);
    }

    public static File getIndividualCacheDirectory(Context context) {
        return new File(getCacheDirectory(context, true), "video-cache");
    }
}
