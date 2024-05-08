package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static String f45286c;

    /* renamed from: a, reason: collision with root package name */
    private String f45287a;

    /* renamed from: b, reason: collision with root package name */
    private d f45288b;

    /* renamed from: d, reason: collision with root package name */
    private long f45289d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f45290e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Activity> f45291f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f45292g = new Runnable() { // from class: com.tencent.open.utils.c.2
        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + l.f(c.this.f45287a) + ".jpg";
            String str2 = c.f45286c + str;
            File file = new File(str2);
            Message obtainMessage = c.this.f45290e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.f45289d));
            } else {
                Bitmap a10 = c.a(c.this.f45287a);
                if (a10 != null) {
                    z10 = c.this.a(a10, str);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z10 = false;
                }
                if (z10) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.f45289d));
            }
            c.this.f45290e.sendMessage(obtainMessage);
        }
    };

    public c(Activity activity) {
        this.f45291f = new WeakReference<>(activity);
        this.f45290e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    c.this.f45288b.a(message.arg1, (String) message.obj);
                } else {
                    c.this.f45288b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!l.a()) {
                dVar.a(2, (String) null);
                return;
            }
            if (this.f45291f.get() != null) {
                Activity activity = this.f45291f.get();
                File h10 = l.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (h10 == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i.c(activity) ? h10.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                    sb2.append("/tmp/");
                    f45286c = sb2.toString();
                }
            }
            this.f45289d = System.currentTimeMillis();
            this.f45287a = str;
            this.f45288b = dVar;
            new Thread(this.f45292g).start();
            return;
        }
        dVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        String str2 = f45286c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.v("AsynLoadImg", "saveFile:" + str);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e10) {
                    e = e10;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e13) {
            e = e13;
        }
    }

    public static Bitmap a(String str) {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
