package com.jd.ad.sdk.jad_it;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_iv extends jad_ly<ParcelFileDescriptor> {
    public jad_iv(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public Class<ParcelFileDescriptor> jad_an() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_ly
    public void jad_an(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    @Override // com.jd.ad.sdk.jad_it.jad_ly
    public ParcelFileDescriptor jad_an(Uri uri, ContentResolver contentResolver) {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.f36226k);
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + ((Object) uri));
    }
}
