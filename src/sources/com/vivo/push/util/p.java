package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.List;

/* compiled from: ImageDownTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class p extends AsyncTask<String, Void, List<Bitmap>> {

    /* renamed from: a, reason: collision with root package name */
    private Context f46442a;

    /* renamed from: b, reason: collision with root package name */
    private InsideNotificationItem f46443b;

    /* renamed from: c, reason: collision with root package name */
    private long f46444c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46445d;

    /* renamed from: e, reason: collision with root package name */
    private int f46446e = 0;

    /* renamed from: f, reason: collision with root package name */
    private NotifyArriveCallbackByUser f46447f;

    /* renamed from: g, reason: collision with root package name */
    private u.a f46448g;

    public p(Context context, InsideNotificationItem insideNotificationItem, long j10, boolean z10, u.a aVar, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f46442a = context;
        this.f46443b = insideNotificationItem;
        this.f46444c = j10;
        this.f46445d = z10;
        this.f46448g = aVar;
        this.f46447f = notifyArriveCallbackByUser;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        u.c("ImageDownTask", "onPostExecute");
        com.vivo.push.t.c(new q(this, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0097, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008a, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0088, code lost:
    
        if (r5 == null) goto L31;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<android.graphics.Bitmap> doInBackground(java.lang.String... r10) {
        /*
            r9 = this;
            com.vivo.push.model.InsideNotificationItem r0 = r9.f46443b
            int r0 = r0.getNotifyDisplayStatus()
            r9.f46446e = r0
            boolean r0 = r9.f46445d
            r1 = 0
            java.lang.String r2 = "ImageDownTask"
            if (r0 != 0) goto L15
            java.lang.String r10 = "bitmap is not display by forbid net"
            com.vivo.push.util.u.d(r2, r10)
            return r1
        L15:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = 0
            r4 = 0
        L1c:
            r5 = 2
            if (r4 >= r5) goto Lad
            r5 = r10[r4]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "imgUrl="
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r7 = " i="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            com.vivo.push.util.u.d(r2, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto La4
            java.net.URL r6 = new java.net.URL     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            java.net.URLConnection r5 = r6.openConnection()     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            r6 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r6)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            r6 = 1
            r5.setDoInput(r6)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            r5.setUseCaches(r3)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            r5.connect()     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            java.lang.String r7 = "code="
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            java.lang.String r7 = r7.concat(r8)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            com.vivo.push.util.u.c(r2, r7)     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L78
            java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L80 java.io.IOException -> L82 java.net.MalformedURLException -> L8e
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch: java.io.IOException -> L83 java.net.MalformedURLException -> L8f java.lang.Throwable -> L9c
            goto L7a
        L78:
            r5 = r1
            r6 = r5
        L7a:
            if (r5 == 0) goto L98
            r5.close()     // Catch: java.lang.Exception -> L98
            goto L98
        L80:
            r10 = move-exception
            goto L9e
        L82:
            r5 = r1
        L83:
            java.lang.String r6 = "IOException"
            com.vivo.push.util.u.a(r2, r6)     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L97
        L8a:
            r5.close()     // Catch: java.lang.Exception -> L97
            goto L97
        L8e:
            r5 = r1
        L8f:
            java.lang.String r6 = "MalformedURLException"
            com.vivo.push.util.u.a(r2, r6)     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L97
            goto L8a
        L97:
            r6 = r1
        L98:
            r0.add(r6)
            goto La9
        L9c:
            r10 = move-exception
            r1 = r5
        L9e:
            if (r1 == 0) goto La3
            r1.close()     // Catch: java.lang.Exception -> La3
        La3:
            throw r10
        La4:
            if (r4 != 0) goto La9
            r0.add(r1)
        La9:
            int r4 = r4 + 1
            goto L1c
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.p.doInBackground(java.lang.String[]):java.util.List");
    }
}
