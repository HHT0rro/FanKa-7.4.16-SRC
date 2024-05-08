package com.jd.ad.sdk.jad_qb;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_ep.jad_ly;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_hs.jad_kx;
import com.jd.ad.sdk.jad_rc.jad_iv;
import com.jd.ad.sdk.jad_rc.jad_na;
import com.jd.ad.sdk.logger.Logger;
import sun.util.locale.LanguageTag;

@RequiresApi(api = 28)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_an implements ImageDecoder.OnHeaderDecodedListener {
    public final jad_na jad_an = jad_na.jad_an();
    public final int jad_bo;
    public final int jad_cp;
    public final com.jd.ad.sdk.jad_hs.jad_bo jad_dq;
    public final jad_iv jad_er;
    public final boolean jad_fs;
    public final jad_kx jad_jt;

    /* renamed from: com.jd.ad.sdk.jad_qb.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class C0389jad_an implements ImageDecoder.OnPartialImageListener {
        public C0389jad_an(jad_an jad_anVar) {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public jad_an(int i10, int i11, @NonNull jad_jw jad_jwVar) {
        this.jad_bo = i10;
        this.jad_cp = i11;
        this.jad_dq = (com.jd.ad.sdk.jad_hs.jad_bo) jad_jwVar.jad_an(com.jd.ad.sdk.jad_rc.jad_jw.jad_fs);
        this.jad_er = (jad_iv) jad_jwVar.jad_an(jad_iv.jad_dq);
        com.jd.ad.sdk.jad_hs.jad_iv<Boolean> jad_ivVar = com.jd.ad.sdk.jad_rc.jad_jw.jad_iv;
        this.jad_fs = jad_jwVar.jad_an(jad_ivVar) != null && ((Boolean) jad_jwVar.jad_an(jad_ivVar)).booleanValue();
        this.jad_jt = (jad_kx) jad_jwVar.jad_an(com.jd.ad.sdk.jad_rc.jad_jw.jad_jt);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        ColorSpace.Named named;
        boolean z10 = false;
        if (this.jad_an.jad_an(this.jad_bo, this.jad_cp, this.jad_fs, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.jad_dq == com.jd.ad.sdk.jad_hs.jad_bo.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0389jad_an(this));
        Size size = imageInfo.getSize();
        int i10 = this.jad_bo;
        if (i10 == Integer.MIN_VALUE) {
            i10 = size.getWidth();
        }
        int i11 = this.jad_cp;
        if (i11 == Integer.MIN_VALUE) {
            i11 = size.getHeight();
        }
        float jad_bo = this.jad_er.jad_bo(size.getWidth(), size.getHeight(), i10, i11);
        int round = Math.round(size.getWidth() * jad_bo);
        int round2 = Math.round(size.getHeight() * jad_bo);
        if (Log.isLoggable("ImageDecoder", 2)) {
            StringBuilder jad_an = jad_ly.jad_an("Resizing from [");
            jad_an.append(size.getWidth());
            jad_an.append(LanguageTag.PRIVATEUSE);
            jad_an.append(size.getHeight());
            jad_an.append("] to [");
            jad_an.append(round);
            jad_an.append(LanguageTag.PRIVATEUSE);
            jad_an.append(round2);
            jad_an.append("] scaleFactor: ");
            jad_an.append(jad_bo);
            Logger.v("ImageDecoder", jad_an.toString());
        }
        imageDecoder.setTargetSize(round, round2);
        jad_kx jad_kxVar = this.jad_jt;
        if (jad_kxVar != null) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                if (jad_kxVar == jad_kx.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z10 = true;
                }
                if (z10) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                }
            } else if (i12 < 26) {
                return;
            }
            named = ColorSpace.Named.SRGB;
            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
        }
    }
}
