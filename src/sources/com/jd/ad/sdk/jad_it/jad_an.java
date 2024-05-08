package com.jd.ad.sdk.jad_it;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_an extends jad_ly<AssetFileDescriptor> {
    public jad_an(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public Class<AssetFileDescriptor> jad_an() {
        return AssetFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_ly
    public void jad_an(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    @Override // com.jd.ad.sdk.jad_it.jad_ly
    public AssetFileDescriptor jad_an(Uri uri, ContentResolver contentResolver) {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.f36226k);
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + ((Object) uri));
    }
}
