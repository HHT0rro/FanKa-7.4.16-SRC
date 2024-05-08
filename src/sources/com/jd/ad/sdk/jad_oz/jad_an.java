package com.jd.ad.sdk.jad_oz;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.alimm.tanx.ui.image.glide.load.model.AssetUriParser;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.io.InputStream;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an<Data> implements jad_na<Uri, Data> {
    public final AssetManager jad_an;
    public final InterfaceC0383jad_an<Data> jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_oz.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0383jad_an<Data> {
        com.jd.ad.sdk.jad_it.jad_dq<Data> jad_an(AssetManager assetManager, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_bo implements jad_ob<Uri, AssetFileDescriptor>, InterfaceC0383jad_an<AssetFileDescriptor> {
        public final AssetManager jad_an;

        public jad_bo(AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_an.InterfaceC0383jad_an
        public com.jd.ad.sdk.jad_it.jad_dq<AssetFileDescriptor> jad_an(AssetManager assetManager, String str) {
            return new com.jd.ad.sdk.jad_it.jad_hu(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Uri, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an, this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_cp implements jad_ob<Uri, InputStream>, InterfaceC0383jad_an<InputStream> {
        public final AssetManager jad_an;

        public jad_cp(AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_an.InterfaceC0383jad_an
        public com.jd.ad.sdk.jad_it.jad_dq<InputStream> jad_an(AssetManager assetManager, String str) {
            return new com.jd.ad.sdk.jad_it.jad_na(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an, this);
        }
    }

    public jad_an(AssetManager assetManager, InterfaceC0383jad_an<Data> interfaceC0383jad_an) {
        this.jad_an = assetManager;
        this.jad_bo = interfaceC0383jad_an;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an jad_an(@NonNull Uri uri, int i10, int i11, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        String substring = uri2.toString().substring(22);
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_fo.jad_bo(uri2), Collections.emptyList(), this.jad_bo.jad_an(this.jad_an, substring));
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        Uri uri2 = uri;
        return "file".equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && AssetUriParser.ASSET_PATH_SEGMENT.equals(uri2.getPathSegments().get(0));
    }
}
