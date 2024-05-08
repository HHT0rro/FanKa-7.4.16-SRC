package com.alimm.tanx.ui.image.glide.signature;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class EmptySignature implements Key {
    public static final EmptySignature EMPTY_KEY = new EmptySignature();

    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
    }
}
