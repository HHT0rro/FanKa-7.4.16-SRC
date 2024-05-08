package com.ss.android.socialbase.appdownloader.np;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {
    private static volatile ej dk = null;

    /* renamed from: m, reason: collision with root package name */
    private static int f38954m = 8;
    private m<Integer, Bitmap> ej;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m<K, T> extends LinkedHashMap<K, T> {

        /* renamed from: m, reason: collision with root package name */
        public final int f38956m;

        public m(int i10, int i11) {
            super(i11, 0.75f, true);
            this.f38956m = i10;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f38956m;
        }
    }

    private ej() {
        this.ej = null;
        int i10 = f38954m;
        this.ej = new m<>(i10, i10 / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream dk(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }

    public static ej m() {
        if (dk == null) {
            synchronized (ej.class) {
                if (dk == null) {
                    dk = new ej();
                }
            }
        }
        return dk;
    }

    public Bitmap m(int i10) {
        return this.ej.get(Integer.valueOf(i10));
    }

    public void m(final int i10, final String str) {
        if (TextUtils.isEmpty(str) || m(i10) != null) {
            return;
        }
        DownloadComponentManager.getIOThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.np.ej.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayOutputStream byteArrayOutputStream;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStream;
                Exception e2;
                IDownloadHttpConnection downloadWithConnection;
                int i11 = 4;
                i11 = 4;
                i11 = 4;
                i11 = 4;
                i11 = 4;
                try {
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e10) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e10;
                        inputStream = null;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th2;
                        inputStream = null;
                    }
                    if (downloadWithConnection == null) {
                        DownloadUtils.safeClose(null, null, null, null);
                        return;
                    }
                    inputStream = downloadWithConnection.getInputStream();
                    try {
                        byteArrayOutputStream = ej.dk(inputStream);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            } catch (Exception e11) {
                                byteArrayInputStream2 = null;
                                e2 = e11;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                                Closeable[] closeableArr = new Closeable[i11];
                                closeableArr[0] = inputStream;
                                closeableArr[1] = byteArrayOutputStream;
                                closeableArr[2] = byteArrayInputStream;
                                closeableArr[3] = byteArrayInputStream2;
                                DownloadUtils.safeClose(closeableArr);
                                throw th;
                            }
                        } catch (Exception e12) {
                            byteArrayInputStream2 = null;
                            e2 = e12;
                            byteArrayInputStream = null;
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e13) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e13;
                        byteArrayOutputStream = null;
                    } catch (Throwable th5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th5;
                        byteArrayOutputStream = null;
                    }
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                        int m10 = com.ss.android.socialbase.appdownloader.ej.m(DownloadComponentManager.getAppContext(), 44.0f);
                        options.inSampleSize = ej.m(m10, m10, options);
                        options.inJustDecodeBounds = false;
                        ej.this.ej.put(Integer.valueOf(i10), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                        Closeable[] closeableArr2 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr2);
                        i11 = closeableArr2;
                    } catch (Exception e14) {
                        e2 = e14;
                        e2.printStackTrace();
                        Closeable[] closeableArr3 = {inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2};
                        DownloadUtils.safeClose(closeableArr3);
                        i11 = closeableArr3;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int m(int i10, int i11, BitmapFactory.Options options) {
        int i12 = options.outWidth;
        if (i12 > i10 || options.outHeight > i11) {
            return Math.min(Math.round(i12 / i10), Math.round(options.outHeight / i11));
        }
        return 1;
    }
}
