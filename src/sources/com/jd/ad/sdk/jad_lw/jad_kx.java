package com.jd.ad.sdk.jad_lw;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.jd.ad.sdk.logger.Logger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_kx implements jad_er {
    public static final Bitmap.Config jad_jw = Bitmap.Config.ARGB_8888;
    public final jad_ly jad_an;
    public final Set<Bitmap.Config> jad_bo;
    public final jad_an jad_cp = new jad_bo();
    public long jad_dq;
    public long jad_er;
    public int jad_fs;
    public int jad_hu;
    public int jad_iv;
    public int jad_jt;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_an {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_bo implements jad_an {
    }

    public jad_kx(long j10, jad_ly jad_lyVar, Set<Bitmap.Config> set) {
        this.jad_dq = j10;
        this.jad_an = jad_lyVar;
        this.jad_bo = set;
    }

    public static Set<Bitmap.Config> jad_dq() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static jad_ly jad_er() {
        return new jad_na();
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    @NonNull
    public Bitmap jad_an(int i10, int i11, Bitmap.Config config) {
        Bitmap jad_cp = jad_cp(i10, i11, config);
        if (jad_cp != null) {
            jad_cp.eraseColor(0);
            return jad_cp;
        }
        if (config == null) {
            config = jad_jw;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    public void jad_an() {
        if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
            Logger.d(LruBitmapPool.TAG, "clearMemory");
        }
        jad_an(0L);
    }

    public final synchronized void jad_an(long j10) {
        while (this.jad_er > j10) {
            Bitmap jad_an2 = this.jad_an.jad_an();
            if (jad_an2 == null) {
                if (Log.isLoggable(LruBitmapPool.TAG, 5)) {
                    Logger.w(LruBitmapPool.TAG, "Size mismatch, resetting");
                    jad_cp();
                }
                this.jad_er = 0L;
                return;
            }
            this.jad_cp.getClass();
            this.jad_er -= this.jad_an.jad_cp(jad_an2);
            this.jad_iv++;
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Evicting bitmap=");
                jad_an3.append(this.jad_an.jad_bo(jad_an2));
                Logger.d(LruBitmapPool.TAG, jad_an3.toString());
            }
            jad_bo();
            jad_an2.recycle();
        }
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    @NonNull
    public Bitmap jad_bo(int i10, int i11, Bitmap.Config config) {
        Bitmap jad_cp = jad_cp(i10, i11, config);
        if (jad_cp != null) {
            return jad_cp;
        }
        if (config == null) {
            config = jad_jw;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public final void jad_bo() {
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            jad_cp();
        }
    }

    @Nullable
    public final synchronized Bitmap jad_cp(int i10, int i11, @Nullable Bitmap.Config config) {
        Bitmap jad_an2;
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + ((Object) config) + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        jad_an2 = this.jad_an.jad_an(i10, i11, config != null ? config : jad_jw);
        if (jad_an2 == null) {
            if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
                StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Missing bitmap=");
                jad_an3.append(this.jad_an.jad_bo(i10, i11, config));
                Logger.d(LruBitmapPool.TAG, jad_an3.toString());
            }
            this.jad_jt++;
        } else {
            this.jad_fs++;
            this.jad_er -= this.jad_an.jad_cp(jad_an2);
            this.jad_cp.getClass();
            jad_an2.setHasAlpha(true);
            jad_an2.setPremultiplied(true);
        }
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Get bitmap=");
            jad_an4.append(this.jad_an.jad_bo(i10, i11, config));
            Logger.v(LruBitmapPool.TAG, jad_an4.toString());
        }
        jad_bo();
        return jad_an2;
    }

    public final void jad_cp() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Hits=");
        jad_an2.append(this.jad_fs);
        jad_an2.append(", misses=");
        jad_an2.append(this.jad_jt);
        jad_an2.append(", puts=");
        jad_an2.append(this.jad_hu);
        jad_an2.append(", evictions=");
        jad_an2.append(this.jad_iv);
        jad_an2.append(", currentSize=");
        jad_an2.append(this.jad_er);
        jad_an2.append(", maxSize=");
        jad_an2.append(this.jad_dq);
        jad_an2.append("\nStrategy=");
        jad_an2.append((Object) this.jad_an);
        Logger.v(LruBitmapPool.TAG, jad_an2.toString());
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    public synchronized void jad_an(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
        if (bitmap.isMutable() && this.jad_an.jad_cp(bitmap) <= this.jad_dq && this.jad_bo.contains(bitmap.getConfig())) {
            int jad_cp = this.jad_an.jad_cp(bitmap);
            this.jad_an.jad_an(bitmap);
            this.jad_cp.getClass();
            this.jad_hu++;
            this.jad_er += jad_cp;
            if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Put bitmap in pool=");
                jad_an2.append(this.jad_an.jad_bo(bitmap));
                Logger.v(LruBitmapPool.TAG, jad_an2.toString());
            }
            jad_bo();
            jad_an(this.jad_dq);
            return;
        }
        if (Log.isLoggable(LruBitmapPool.TAG, 2)) {
            StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Reject bitmap from pool, bitmap: ");
            jad_an3.append(this.jad_an.jad_bo(bitmap));
            jad_an3.append(", is mutable: ");
            jad_an3.append(bitmap.isMutable());
            jad_an3.append(", is allowed config: ");
            jad_an3.append(this.jad_bo.contains(bitmap.getConfig()));
            Logger.v(LruBitmapPool.TAG, jad_an3.toString());
        }
        bitmap.recycle();
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_er
    public void jad_an(int i10) {
        if (Log.isLoggable(LruBitmapPool.TAG, 3)) {
            Logger.d(LruBitmapPool.TAG, "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || (Build.VERSION.SDK_INT >= 23 && i10 >= 20)) {
            jad_an();
        } else if (i10 >= 20 || i10 == 15) {
            jad_an(this.jad_dq / 2);
        }
    }
}
