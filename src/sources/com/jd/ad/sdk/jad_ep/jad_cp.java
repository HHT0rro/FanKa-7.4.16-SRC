package com.jd.ad.sdk.jad_ep;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.ui.image.glide.Glide;
import com.bumptech.glide.Registry;
import com.jd.ad.sdk.jad_ep.jad_dq;
import com.jd.ad.sdk.jad_ep.jad_fs;
import com.jd.ad.sdk.jad_it.jad_er;
import com.jd.ad.sdk.jad_it.jad_kx;
import com.jd.ad.sdk.jad_it.jad_mz;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_mx.jad_iv;
import com.jd.ad.sdk.jad_ny.jad_an;
import com.jd.ad.sdk.jad_oz.jad_an;
import com.jd.ad.sdk.jad_oz.jad_bo;
import com.jd.ad.sdk.jad_oz.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_er;
import com.jd.ad.sdk.jad_oz.jad_fs;
import com.jd.ad.sdk.jad_oz.jad_kx;
import com.jd.ad.sdk.jad_oz.jad_ob;
import com.jd.ad.sdk.jad_oz.jad_sf;
import com.jd.ad.sdk.jad_oz.jad_tg;
import com.jd.ad.sdk.jad_oz.jad_uh;
import com.jd.ad.sdk.jad_oz.jad_vi;
import com.jd.ad.sdk.jad_oz.jad_wj;
import com.jd.ad.sdk.jad_oz.jad_xk;
import com.jd.ad.sdk.jad_pa.jad_an;
import com.jd.ad.sdk.jad_pa.jad_bo;
import com.jd.ad.sdk.jad_pa.jad_cp;
import com.jd.ad.sdk.jad_pa.jad_dq;
import com.jd.ad.sdk.jad_pa.jad_er;
import com.jd.ad.sdk.jad_rc.jad_re;
import com.jd.ad.sdk.jad_rc.jad_uh;
import com.jd.ad.sdk.jad_rc.jad_wj;
import com.jd.ad.sdk.jad_rc.jad_xk;
import com.jd.ad.sdk.jad_sd.jad_an;
import com.jd.ad.sdk.jad_xi.jad_pc;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp implements ComponentCallbacks2 {

    @GuardedBy("Glide.class")
    public static volatile jad_cp jad_iv;
    public static volatile boolean jad_jw;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_an;
    public final com.jd.ad.sdk.jad_mx.jad_hu jad_bo;
    public final jad_er jad_cp;
    public final jad_hu jad_dq;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_er;
    public final jad_pc jad_fs;

    @GuardedBy("managers")
    public final List<jad_jw> jad_hu = new ArrayList();
    public final com.jd.ad.sdk.jad_xi.jad_dq jad_jt;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_an {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v2, types: [com.jd.ad.sdk.jad_rc.jad_jt] */
    public jad_cp(@NonNull Context context, @NonNull jad_mz jad_mzVar, @NonNull com.jd.ad.sdk.jad_mx.jad_hu jad_huVar, @NonNull com.jd.ad.sdk.jad_lw.jad_er jad_erVar, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, @NonNull jad_pc jad_pcVar, @NonNull com.jd.ad.sdk.jad_xi.jad_dq jad_dqVar, int i10, @NonNull jad_an jad_anVar, @NonNull Map<Class<?>, jad_kx<?, ?>> map, @NonNull List<com.jd.ad.sdk.jad_al.jad_jt<Object>> list, jad_fs jad_fsVar) {
        Object obj;
        com.jd.ad.sdk.jad_hs.jad_ly jad_uhVar;
        com.jd.ad.sdk.jad_rc.jad_fs jad_fsVar2;
        int i11;
        jad_hu jad_huVar2;
        this.jad_an = jad_erVar;
        this.jad_er = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_fs = jad_pcVar;
        this.jad_jt = jad_dqVar;
        Resources resources = context.getResources();
        jad_hu jad_huVar3 = new jad_hu();
        this.jad_dq = jad_huVar3;
        jad_huVar3.jad_an((com.jd.ad.sdk.jad_hs.jad_fs) new com.jd.ad.sdk.jad_rc.jad_hu());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 27) {
            jad_huVar3.jad_an((com.jd.ad.sdk.jad_hs.jad_fs) new com.jd.ad.sdk.jad_rc.jad_mz());
        }
        List<com.jd.ad.sdk.jad_hs.jad_fs> jad_an2 = jad_huVar3.jad_an();
        com.jd.ad.sdk.jad_vg.jad_an jad_anVar2 = new com.jd.ad.sdk.jad_vg.jad_an(context, jad_an2, jad_erVar, jad_boVar);
        com.jd.ad.sdk.jad_hs.jad_ly<ParcelFileDescriptor, Bitmap> jad_cp = jad_xk.jad_cp(jad_erVar);
        com.jd.ad.sdk.jad_rc.jad_jw jad_jwVar = new com.jd.ad.sdk.jad_rc.jad_jw(jad_huVar3.jad_an(), resources.getDisplayMetrics(), jad_erVar, jad_boVar);
        if (i12 < 28 || !jad_fsVar.jad_an(jad_dq.jad_cp.class)) {
            com.jd.ad.sdk.jad_rc.jad_fs jad_fsVar3 = new com.jd.ad.sdk.jad_rc.jad_fs(jad_jwVar);
            obj = String.class;
            jad_uhVar = new jad_uh(jad_jwVar, jad_boVar);
            jad_fsVar2 = jad_fsVar3;
        } else {
            jad_uhVar = new com.jd.ad.sdk.jad_rc.jad_pc();
            jad_fsVar2 = new com.jd.ad.sdk.jad_rc.jad_jt();
            obj = String.class;
        }
        if (i12 < 28 || !jad_fsVar.jad_an(jad_dq.jad_bo.class)) {
            i11 = i12;
        } else {
            i11 = i12;
            jad_huVar3.jad_an("Animation", InputStream.class, Drawable.class, com.jd.ad.sdk.jad_te.jad_an.jad_bo(jad_an2, jad_boVar));
            jad_huVar3.jad_an("Animation", ByteBuffer.class, Drawable.class, com.jd.ad.sdk.jad_te.jad_an.jad_an(jad_an2, jad_boVar));
        }
        com.jd.ad.sdk.jad_te.jad_er jad_erVar2 = new com.jd.ad.sdk.jad_te.jad_er(context);
        jad_sf.jad_cp jad_cpVar = new jad_sf.jad_cp(resources);
        jad_sf.jad_dq jad_dqVar2 = new jad_sf.jad_dq(resources);
        jad_sf.jad_bo jad_boVar2 = new jad_sf.jad_bo(resources);
        jad_sf.jad_an jad_anVar3 = new jad_sf.jad_an(resources);
        com.jd.ad.sdk.jad_rc.jad_cp jad_cpVar2 = new com.jd.ad.sdk.jad_rc.jad_cp(jad_boVar);
        com.jd.ad.sdk.jad_wh.jad_an jad_anVar4 = new com.jd.ad.sdk.jad_wh.jad_an();
        com.jd.ad.sdk.jad_wh.jad_dq jad_dqVar3 = new com.jd.ad.sdk.jad_wh.jad_dq();
        ContentResolver contentResolver = context.getContentResolver();
        jad_huVar3.jad_an(ByteBuffer.class, new com.jd.ad.sdk.jad_oz.jad_cp()).jad_an(InputStream.class, new jad_tg(jad_boVar)).jad_an(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, jad_fsVar2).jad_an(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, jad_uhVar);
        if (com.jd.ad.sdk.jad_it.jad_mz.jad_cp()) {
            jad_huVar3.jad_an(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new jad_re(jad_jwVar));
        }
        jad_hu jad_an3 = jad_huVar3.jad_an(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, jad_cp).jad_an(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, jad_xk.jad_an(jad_erVar));
        jad_vi.jad_an<?> jad_anVar5 = jad_vi.jad_an.jad_an;
        jad_an3.jad_an(Bitmap.class, Bitmap.class, jad_anVar5).jad_an(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new jad_wj()).jad_an(Bitmap.class, (com.jd.ad.sdk.jad_hs.jad_mz) jad_cpVar2).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_fsVar2)).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_uhVar)).jad_an(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_cp)).jad_an(BitmapDrawable.class, (com.jd.ad.sdk.jad_hs.jad_mz) new com.jd.ad.sdk.jad_rc.jad_bo(jad_erVar, jad_cpVar2)).jad_an("Animation", InputStream.class, com.jd.ad.sdk.jad_vg.jad_cp.class, new com.jd.ad.sdk.jad_vg.jad_jw(jad_an2, jad_anVar2, jad_boVar)).jad_an("Animation", ByteBuffer.class, com.jd.ad.sdk.jad_vg.jad_cp.class, jad_anVar2).jad_an(com.jd.ad.sdk.jad_vg.jad_cp.class, (com.jd.ad.sdk.jad_hs.jad_mz) new com.jd.ad.sdk.jad_vg.jad_dq()).jad_an(com.jd.ad.sdk.jad_gr.jad_an.class, com.jd.ad.sdk.jad_gr.jad_an.class, jad_anVar5).jad_an(Registry.BUCKET_BITMAP, com.jd.ad.sdk.jad_gr.jad_an.class, Bitmap.class, new com.jd.ad.sdk.jad_vg.jad_hu(jad_erVar)).jad_an(Uri.class, Drawable.class, jad_erVar2).jad_an(Uri.class, Bitmap.class, new com.jd.ad.sdk.jad_rc.jad_tg(jad_erVar2, jad_erVar)).jad_an((jad_er.jad_an<?>) new jad_an.C0391jad_an()).jad_an(File.class, ByteBuffer.class, new jad_dq.jad_bo()).jad_an(File.class, InputStream.class, new jad_fs.jad_er()).jad_an(File.class, File.class, new com.jd.ad.sdk.jad_uf.jad_an()).jad_an(File.class, ParcelFileDescriptor.class, new jad_fs.jad_bo()).jad_an(File.class, File.class, jad_anVar5).jad_an((jad_er.jad_an<?>) new jad_kx.jad_an(jad_boVar));
        if (com.jd.ad.sdk.jad_it.jad_mz.jad_cp()) {
            jad_huVar2 = jad_huVar3;
            jad_huVar2.jad_an((jad_er.jad_an<?>) new jad_mz.jad_an());
        } else {
            jad_huVar2 = jad_huVar3;
        }
        Class<Integer> cls = Integer.TYPE;
        Object obj2 = obj;
        jad_huVar2.jad_an(cls, InputStream.class, jad_cpVar).jad_an(cls, ParcelFileDescriptor.class, jad_boVar2).jad_an(Integer.class, InputStream.class, jad_cpVar).jad_an(Integer.class, ParcelFileDescriptor.class, jad_boVar2).jad_an(Integer.class, Uri.class, jad_dqVar2).jad_an(cls, AssetFileDescriptor.class, jad_anVar3).jad_an(Integer.class, AssetFileDescriptor.class, jad_anVar3).jad_an(cls, Uri.class, jad_dqVar2).jad_an((Class) obj2, InputStream.class, (jad_ob) new jad_er.jad_cp()).jad_an(Uri.class, InputStream.class, new jad_er.jad_cp()).jad_an((Class) obj2, InputStream.class, (jad_ob) new jad_uh.jad_cp()).jad_an((Class) obj2, ParcelFileDescriptor.class, (jad_ob) new jad_uh.jad_bo()).jad_an((Class) obj2, AssetFileDescriptor.class, (jad_ob) new jad_uh.jad_an()).jad_an(Uri.class, InputStream.class, new jad_an.jad_cp(context.getAssets())).jad_an(Uri.class, AssetFileDescriptor.class, new jad_an.jad_bo(context.getAssets())).jad_an(Uri.class, InputStream.class, new jad_bo.jad_an(context)).jad_an(Uri.class, InputStream.class, new jad_cp.jad_an(context));
        int i13 = i11;
        if (i13 >= 29) {
            jad_huVar2.jad_an(Uri.class, InputStream.class, new jad_dq.jad_cp(context));
            jad_huVar2.jad_an(Uri.class, ParcelFileDescriptor.class, new jad_dq.jad_bo(context));
        }
        jad_huVar2.jad_an(Uri.class, InputStream.class, new jad_wj.jad_dq(contentResolver)).jad_an(Uri.class, ParcelFileDescriptor.class, new jad_wj.jad_bo(contentResolver)).jad_an(Uri.class, AssetFileDescriptor.class, new jad_wj.jad_an(contentResolver)).jad_an(Uri.class, InputStream.class, new jad_xk.jad_an()).jad_an(URL.class, InputStream.class, new jad_er.jad_an()).jad_an(Uri.class, File.class, new jad_kx.jad_an(context)).jad_an(com.jd.ad.sdk.jad_oz.jad_jt.class, InputStream.class, new jad_an.C0387jad_an()).jad_an(byte[].class, ByteBuffer.class, new jad_bo.jad_an()).jad_an(byte[].class, InputStream.class, new jad_bo.jad_dq()).jad_an(Uri.class, Uri.class, jad_anVar5).jad_an(Drawable.class, Drawable.class, jad_anVar5).jad_an(Drawable.class, Drawable.class, new com.jd.ad.sdk.jad_te.jad_fs()).jad_an(Bitmap.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_wh.jad_bo(resources)).jad_an(Bitmap.class, byte[].class, jad_anVar4).jad_an(Drawable.class, byte[].class, new com.jd.ad.sdk.jad_wh.jad_cp(jad_erVar, jad_anVar4, jad_dqVar3)).jad_an(com.jd.ad.sdk.jad_vg.jad_cp.class, byte[].class, jad_dqVar3);
        if (i13 >= 23) {
            com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Bitmap> jad_bo = com.jd.ad.sdk.jad_rc.jad_xk.jad_bo(jad_erVar);
            jad_huVar2.jad_an(ByteBuffer.class, Bitmap.class, jad_bo);
            jad_huVar2.jad_an(ByteBuffer.class, BitmapDrawable.class, new com.jd.ad.sdk.jad_rc.jad_an(resources, jad_bo));
        }
        this.jad_cp = new jad_er(context, jad_boVar, jad_huVar2, new com.jd.ad.sdk.jad_bm.jad_bo(), jad_anVar, map, list, jad_mzVar, jad_fsVar, i10);
    }

    @GuardedBy("Glide.class")
    public static void jad_an(@NonNull Context context, @Nullable com.jd.ad.sdk.jad_ep.jad_an jad_anVar) {
        if (jad_jw) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        jad_jw = true;
        jad_dq jad_dqVar = new jad_dq();
        Context applicationContext = context.getApplicationContext();
        List<com.jd.ad.sdk.jad_yj.jad_bo> emptyList = Collections.emptyList();
        if (jad_anVar != null && !jad_anVar.jad_an().isEmpty()) {
            Set<Class<?>> jad_an2 = jad_anVar.jad_an();
            Iterator iterator2 = emptyList.iterator2();
            while (iterator2.hasNext()) {
                com.jd.ad.sdk.jad_yj.jad_bo jad_boVar = (com.jd.ad.sdk.jad_yj.jad_bo) iterator2.next();
                if (jad_an2.contains(jad_boVar.getClass())) {
                    if (Log.isLoggable(Glide.TAG, 3)) {
                        Logger.d(Glide.TAG, "AppGlideModule excludes manifest GlideModule: " + ((Object) jad_boVar));
                    }
                    iterator2.remove();
                }
            }
        }
        if (Log.isLoggable(Glide.TAG, 3)) {
            for (com.jd.ad.sdk.jad_yj.jad_bo jad_boVar2 : emptyList) {
                StringBuilder jad_an3 = jad_ly.jad_an("Discovered GlideModule from manifest: ");
                jad_an3.append((Object) jad_boVar2.getClass());
                Logger.d(Glide.TAG, jad_an3.toString());
            }
        }
        jad_dqVar.jad_na = null;
        Iterator iterator22 = emptyList.iterator2();
        while (iterator22.hasNext()) {
            ((com.jd.ad.sdk.jad_yj.jad_bo) iterator22.next()).jad_an(applicationContext, jad_dqVar);
        }
        if (jad_dqVar.jad_jt == null) {
            jad_an.ThreadFactoryC0378jad_an threadFactoryC0378jad_an = new jad_an.ThreadFactoryC0378jad_an();
            int jad_an4 = com.jd.ad.sdk.jad_ny.jad_an.jad_an();
            if (!TextUtils.isEmpty("source")) {
                jad_dqVar.jad_jt = new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(jad_an4, jad_an4, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jad_an.jad_bo(threadFactoryC0378jad_an, "source", jad_an.jad_cp.jad_an, false)));
            } else {
                StringBuilder jad_an5 = jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an5.append("source");
                throw new IllegalArgumentException(jad_an5.toString());
            }
        }
        if (jad_dqVar.jad_hu == null) {
            int i10 = com.jd.ad.sdk.jad_ny.jad_an.jad_cp;
            jad_an.ThreadFactoryC0378jad_an threadFactoryC0378jad_an2 = new jad_an.ThreadFactoryC0378jad_an();
            if (!TextUtils.isEmpty("disk-cache")) {
                jad_dqVar.jad_hu = new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jad_an.jad_bo(threadFactoryC0378jad_an2, "disk-cache", jad_an.jad_cp.jad_an, true)));
            } else {
                StringBuilder jad_an6 = jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an6.append("disk-cache");
                throw new IllegalArgumentException(jad_an6.toString());
            }
        }
        if (jad_dqVar.jad_ob == null) {
            int i11 = com.jd.ad.sdk.jad_ny.jad_an.jad_an() >= 4 ? 2 : 1;
            jad_an.ThreadFactoryC0378jad_an threadFactoryC0378jad_an3 = new jad_an.ThreadFactoryC0378jad_an();
            if (!TextUtils.isEmpty("animation")) {
                jad_dqVar.jad_ob = new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(i11, i11, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new jad_an.jad_bo(threadFactoryC0378jad_an3, "animation", jad_an.jad_cp.jad_an, true)));
            } else {
                StringBuilder jad_an7 = jad_ly.jad_an("Name must be non-null and non-empty, but given: ");
                jad_an7.append("animation");
                throw new IllegalArgumentException(jad_an7.toString());
            }
        }
        if (jad_dqVar.jad_jw == null) {
            jad_dqVar.jad_jw = new com.jd.ad.sdk.jad_mx.jad_iv(new jad_iv.jad_an(applicationContext));
        }
        if (jad_dqVar.jad_kx == null) {
            jad_dqVar.jad_kx = new com.jd.ad.sdk.jad_xi.jad_fs();
        }
        if (jad_dqVar.jad_dq == null) {
            int i12 = jad_dqVar.jad_jw.jad_an;
            if (i12 > 0) {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_lw.jad_kx(i12, com.jd.ad.sdk.jad_lw.jad_kx.jad_er(), com.jd.ad.sdk.jad_lw.jad_kx.jad_dq());
            } else {
                jad_dqVar.jad_dq = new com.jd.ad.sdk.jad_lw.jad_fs();
            }
        }
        if (jad_dqVar.jad_er == null) {
            jad_dqVar.jad_er = new com.jd.ad.sdk.jad_lw.jad_jw(jad_dqVar.jad_jw.jad_dq);
        }
        if (jad_dqVar.jad_fs == null) {
            jad_dqVar.jad_fs = new com.jd.ad.sdk.jad_mx.jad_jt(jad_dqVar.jad_jw.jad_bo);
        }
        if (jad_dqVar.jad_iv == null) {
            jad_dqVar.jad_iv = new com.jd.ad.sdk.jad_mx.jad_fs(applicationContext, "image_manager_disk_cache", 262144000L);
        }
        if (jad_dqVar.jad_cp == null) {
            jad_dqVar.jad_cp = new com.jd.ad.sdk.jad_kv.jad_mz(jad_dqVar.jad_fs, jad_dqVar.jad_iv, jad_dqVar.jad_hu, jad_dqVar.jad_jt, new com.jd.ad.sdk.jad_ny.jad_an(new ThreadPoolExecutor(0, Integer.MAX_VALUE, com.jd.ad.sdk.jad_ny.jad_an.jad_bo, TimeUnit.MILLISECONDS, new SynchronousQueue(), new jad_an.jad_bo(new jad_an.ThreadFactoryC0378jad_an(), "source-unlimited", jad_an.jad_cp.jad_an, false))), jad_dqVar.jad_ob, null, null, null, null, null, null, false);
        }
        List<com.jd.ad.sdk.jad_al.jad_jt<Object>> list = jad_dqVar.jad_pc;
        jad_dqVar.jad_pc = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        jad_fs.jad_an jad_anVar2 = jad_dqVar.jad_bo;
        jad_anVar2.getClass();
        jad_fs jad_fsVar = new jad_fs(jad_anVar2);
        jad_cp jad_cpVar = new jad_cp(applicationContext, jad_dqVar.jad_cp, jad_dqVar.jad_fs, jad_dqVar.jad_dq, jad_dqVar.jad_er, new jad_pc(jad_dqVar.jad_na, jad_fsVar), jad_dqVar.jad_kx, jad_dqVar.jad_ly, jad_dqVar.jad_mz, jad_dqVar.jad_an, jad_dqVar.jad_pc, jad_fsVar);
        for (com.jd.ad.sdk.jad_yj.jad_bo jad_boVar3 : emptyList) {
            try {
                jad_boVar3.jad_an(applicationContext, jad_cpVar, jad_cpVar.jad_dq);
            } catch (AbstractMethodError e2) {
                StringBuilder jad_an8 = jad_ly.jad_an("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                jad_an8.append(jad_boVar3.getClass().getName());
                throw new IllegalStateException(jad_an8.toString(), e2);
            }
        }
        applicationContext.registerComponentCallbacks(jad_cpVar);
        jad_iv = jad_cpVar;
        jad_jw = false;
    }

    public static void jad_an(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static jad_jw jad_bo(@NonNull Context context) {
        Objects.requireNonNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return jad_an(context).jad_fs.jad_bo(context);
    }

    @NonNull
    public com.jd.ad.sdk.jad_lw.jad_er jad_an() {
        return this.jad_an;
    }

    public void jad_an(jad_jw jad_jwVar) {
        synchronized (this.jad_hu) {
            if (this.jad_hu.contains(jad_jwVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.jad_hu.add(jad_jwVar);
        }
    }

    public com.jd.ad.sdk.jad_xi.jad_dq jad_bo() {
        return this.jad_jt;
    }

    @NonNull
    public Context jad_cp() {
        return this.jad_cp.getBaseContext();
    }

    @NonNull
    public jad_er jad_dq() {
        return this.jad_cp;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        com.jd.ad.sdk.jad_gp.jad_ly.jad_an();
        ((com.jd.ad.sdk.jad_gp.jad_hu) this.jad_bo).jad_an(0L);
        this.jad_an.jad_an();
        this.jad_er.jad_an();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        long j10;
        com.jd.ad.sdk.jad_gp.jad_ly.jad_an();
        synchronized (this.jad_hu) {
            Iterator<jad_jw> iterator2 = this.jad_hu.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().getClass();
            }
        }
        com.jd.ad.sdk.jad_mx.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_mx.jad_jt) this.jad_bo;
        jad_jtVar.getClass();
        if (i10 >= 40) {
            jad_jtVar.jad_an(0L);
        } else if (i10 >= 20 || i10 == 15) {
            synchronized (jad_jtVar) {
                j10 = jad_jtVar.jad_bo;
            }
            jad_jtVar.jad_an(j10 / 2);
        }
        this.jad_an.jad_an(i10);
        this.jad_er.jad_an(i10);
    }

    @NonNull
    public static jad_cp jad_an(@NonNull Context context) {
        if (jad_iv == null) {
            com.jd.ad.sdk.jad_ep.jad_an jad_anVar = null;
            try {
                jad_anVar = (com.jd.ad.sdk.jad_ep.jad_an) Class.forName("com.jd.ad.sdk.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable(Glide.TAG, 5)) {
                    Logger.w(Glide.TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (IllegalAccessException e2) {
                jad_an(e2);
                throw null;
            } catch (InstantiationException e10) {
                jad_an(e10);
                throw null;
            } catch (NoSuchMethodException e11) {
                jad_an(e11);
                throw null;
            } catch (InvocationTargetException e12) {
                jad_an(e12);
                throw null;
            }
            synchronized (jad_cp.class) {
                if (jad_iv == null) {
                    jad_an(context, jad_anVar);
                }
            }
        }
        return jad_iv;
    }
}
