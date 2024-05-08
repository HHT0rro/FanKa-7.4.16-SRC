package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.ej;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l extends LruCache<Long, Bitmap> {

    /* renamed from: m, reason: collision with root package name */
    private final Map<Long, SoftReference<m>> f38511m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class dk {

        /* renamed from: m, reason: collision with root package name */
        private static l f38515m = new l();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface m {
        void m(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dk(int i10, int i11, BitmapFactory.Options options) {
        int i12 = options.outWidth;
        if (i12 > i10 || options.outHeight > i11) {
            return Math.min(Math.round(i12 / i10), Math.round(options.outHeight / i11));
        }
        return 1;
    }

    private l() {
        super(8, 8);
        this.f38511m = new HashMap();
    }

    public static l m() {
        return dk.f38515m;
    }

    public void m(long j10, @NonNull m mVar) {
        if (get(Long.valueOf(j10)) != null) {
            mVar.m(get(Long.valueOf(j10)));
        } else {
            this.f38511m.put(Long.valueOf(j10), new SoftReference<>(mVar));
        }
    }

    public void m(final long j10, final long j11, final String str) {
        if (get(Long.valueOf(j10)) != null) {
            SoftReference<m> remove = this.f38511m.remove(Long.valueOf(j10));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().m(get(Long.valueOf(j10)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            hc.m(12, j11);
        } else {
            com.ss.android.downloadlib.hc.ej.m((ej.m<Object, R>) new ej.m<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.l.2
                @Override // com.ss.android.downloadlib.hc.ej.m
                public Object m(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    IDownloadHttpConnection downloadWithConnection;
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        DownloadUtils.safeClose(bufferedInputStream);
                        throw th;
                    }
                    if (downloadWithConnection == null) {
                        DownloadUtils.safeClose(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(downloadWithConnection.getInputStream());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i10 = options.outWidth;
                            int i11 = options.outHeight;
                            int m10 = ve.m(c.getContext(), 60.0f);
                            options.inSampleSize = l.dk(m10, m10, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i10));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i11));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                            com.ss.android.downloadlib.l.m.m().m("ttd_pref_monitor", jSONObject, j11);
                            l.this.put(Long.valueOf(j10), decodeStream);
                            DownloadUtils.safeClose(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            DownloadUtils.safeClose(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        com.ss.android.downloadlib.np.ej.m().m(e, "BitmapCache loadBitmap");
                        DownloadUtils.safeClose(bufferedInputStream);
                        return null;
                    }
                    return null;
                }
            }, (Object) null).m(new ej.m<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.l.1
                @Override // com.ss.android.downloadlib.hc.ej.m
                public Object m(Object obj) {
                    SoftReference softReference = (SoftReference) l.this.f38511m.remove(Long.valueOf(j10));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((m) softReference.get()).m(l.this.get(Long.valueOf(j10)));
                    return null;
                }
            }).m();
        }
    }
}
