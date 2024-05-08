package com.alimm.tanx.ui.image.glide.load;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Key {
    public static final String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException;
}
