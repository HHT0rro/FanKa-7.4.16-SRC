package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.util.LruCache;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SafeKeyGenerator {
    public final LruCache<Key, String> loadIdToSafeHash = new LruCache<>(1000);

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.loadIdToSafeHash) {
            str = this.loadIdToSafeHash.get(key);
        }
        if (str == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                key.updateDiskCacheKey(messageDigest);
                str = Util.sha256BytesToHex(messageDigest.digest());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e10) {
                e10.printStackTrace();
            }
            synchronized (this.loadIdToSafeHash) {
                this.loadIdToSafeHash.put(key, str);
            }
        }
        return str;
    }
}
