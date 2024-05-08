package com.alimm.tanx.ui.image.glide.load.model;

import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class AssetUriParser {
    public static final String ASSET_PATH_SEGMENT = "android_asset";
    public static final String ASSET_PREFIX = "file:///android_asset/";
    public static final int ASSET_PREFIX_LENGTH = 22;

    public static boolean isAssetUri(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }

    public static String toAssetPath(Uri uri) {
        return uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
