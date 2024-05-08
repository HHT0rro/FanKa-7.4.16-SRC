package com.alibaba.security.biometrics.image;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.ImageUtils;
import com.alibaba.security.common.utils.Md5Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPWebViewMediaCacheManager {
    public static final String ID_CARD = "id_card";
    public static final String INVALID_KEY = "0";
    private static final String KEY_URL_TIMESTAMP = "t";
    private static final String KEY_URL_TYPE = "type";
    public static final String SKIN = "skin";
    private final String BASE_IMAGE_URL_KEY;
    private HashMap<String, PhotoTair> mImageCache;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class HOLDER {
        private static final RPWebViewMediaCacheManager SINGLE = new RPWebViewMediaCacheManager();

        private HOLDER() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class PhotoTair {
        public boolean isAssets;
        public String md5;
        public String path;

        public PhotoTair() {
        }
    }

    private String buildImageUrl(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse("//127.0.0.1/wvcache/photo.jpg?_wvcrc=1").buildUpon();
        buildUpon.appendQueryParameter("type", str);
        buildUpon.appendQueryParameter(KEY_URL_TIMESTAMP, str2);
        return buildUpon.toString();
    }

    private String getCacheDir(Context context) {
        return FileUtils.getCacheDir(context, "caches", "wvimage");
    }

    private FileInputStream getIdCardInputStream(Context context, String str) {
        String removeScheme = removeScheme(str);
        String cacheDir = getCacheDir(context);
        if (TextUtils.isEmpty(cacheDir)) {
            return null;
        }
        try {
            return new FileInputStream(new File(cacheDir + File.separator + Md5Utils.md5ToHex(removeScheme)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static RPWebViewMediaCacheManager getInstance() {
        return HOLDER.SINGLE;
    }

    private InputStream getSkinInputStream(Context context, String str, String str2) {
        PhotoTair photoTair;
        if (!this.mImageCache.isEmpty() && (photoTair = this.mImageCache.get(str2)) != null && photoTair.path != null) {
            try {
                if (photoTair.isAssets) {
                    return context.getAssets().open(photoTair.path);
                }
                return new FileInputStream(photoTair.path);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String getVirtualImageKey(String str, String str2) {
        return buildImageUrl(str, str2);
    }

    private boolean isWebviewCacheEnabled(String str) {
        if (!str.contains("_wvcrc=")) {
            return false;
        }
        Uri parse = Uri.parse(str);
        return (parse != null && parse.isHierarchical() && TextUtils.isEmpty(parse.getQueryParameter("_wvcrc=")) && "0".equals(parse.getQueryParameter("_wvcrc="))) ? false : true;
    }

    private String removeScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replace = str.startsWith("http:") ? str.replace("http:", "") : null;
        if (str.startsWith("https:")) {
            replace = str.replace("https:", "");
        }
        return TextUtils.isEmpty(replace) ? str : replace;
    }

    private Pair<String, String> saveBitmapToCache(Context context, File file) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String virtualImageKey = getVirtualImageKey(ID_CARD, valueOf);
        String md5ToHex = Md5Utils.md5ToHex(getVirtualImageKey(ID_CARD, valueOf));
        String cacheDir = getCacheDir(context);
        if (!TextUtils.isEmpty(cacheDir) && !TextUtils.isEmpty(md5ToHex)) {
            File file2 = new File(cacheDir, md5ToHex);
            if (file != null && file.exists() && FileUtils.copy(file, file2)) {
                return new Pair<>(valueOf, virtualImageKey);
            }
            return new Pair<>("0", virtualImageKey);
        }
        return new Pair<>("0", virtualImageKey);
    }

    public void clear() {
        synchronized (this.mImageCache) {
            this.mImageCache.clear();
        }
    }

    public InputStream genWebViewMediaStream(Context context, String str) {
        if (isWebviewCacheEnabled(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("type");
                String queryParameter2 = parse.getQueryParameter(KEY_URL_TIMESTAMP);
                if (TextUtils.isEmpty(queryParameter)) {
                    return null;
                }
                if (queryParameter.equals(ID_CARD)) {
                    return getIdCardInputStream(context, str);
                }
                if (queryParameter.equals(SKIN)) {
                    return getSkinInputStream(context, str, queryParameter2);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String get(String str) {
        synchronized (this.mImageCache) {
            if (!this.mImageCache.containsKey(str)) {
                return null;
            }
            return this.mImageCache.get(str).path;
        }
    }

    public String getMd5(String str) {
        synchronized (this.mImageCache) {
            if (!this.mImageCache.containsKey(str)) {
                return null;
            }
            return this.mImageCache.get(str).md5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Pair<String, String> putIdCardImage(Context context, String str) {
        Pair<String, String> saveBitmapToCache;
        synchronized (this.mImageCache) {
            File file = new File(str);
            saveBitmapToCache = saveBitmapToCache(context, file);
            String md5File = Md5Utils.md5File(file);
            PhotoTair photoTair = new PhotoTair();
            photoTair.md5 = md5File;
            photoTair.path = str;
            photoTair.isAssets = false;
            this.mImageCache.put(saveBitmapToCache.first, photoTair);
        }
        return saveBitmapToCache;
    }

    public Pair<String, String> putSkinImage(Context context, String str, boolean z10) {
        Pair<String, String> pair;
        synchronized (this.mImageCache) {
            PhotoTair photoTair = new PhotoTair();
            photoTair.path = str;
            photoTair.isAssets = z10;
            this.mImageCache.put(str, photoTair);
            pair = new Pair<>(str, getVirtualImageKey(SKIN, str));
        }
        return pair;
    }

    public void remove(String str) {
        synchronized (this.mImageCache) {
            if (this.mImageCache.containsKey(str)) {
                return;
            }
            this.mImageCache.remove(str);
        }
    }

    private RPWebViewMediaCacheManager() {
        this.BASE_IMAGE_URL_KEY = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1";
        this.mImageCache = new HashMap<>();
    }

    public String putIdCardImage(Context context, String str, String str2) {
        synchronized (this.mImageCache) {
            String decryptImage = ImageUtils.decryptImage(context, str2, str);
            if (decryptImage == null) {
                return "0";
            }
            String valueOf = String.valueOf((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
            String md5File = Md5Utils.md5File(new File(decryptImage));
            if (md5File == null) {
                return "0";
            }
            PhotoTair photoTair = new PhotoTair();
            photoTair.md5 = md5File;
            photoTair.path = decryptImage;
            this.mImageCache.put(valueOf, photoTair);
            return valueOf;
        }
    }
}
