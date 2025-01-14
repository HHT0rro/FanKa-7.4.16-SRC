package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e2);
        }
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        if (options.mCancel || i12 == -1 || i13 == -1) {
            return false;
        }
        int i14 = i12 > i13 ? i12 : i13;
        if (i12 >= i13) {
            i12 = i13;
        }
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i14 + "shortSide=" + i12);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i14 > i11 || i12 > i10;
    }

    public static final void a(final Context context, final String str, final d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!l.a()) {
            dVar.a(2, (String) null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i10 = message.what;
                    if (i10 == 101) {
                        dVar.a(0, (ArrayList<String>) message.obj);
                    } else if (i10 != 102) {
                        super.handleMessage(message);
                    } else {
                        dVar.a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String str3;
                    try {
                        Bitmap a10 = a.a(String.this, 840);
                        if (a10 != null) {
                            File a11 = f.a("Images");
                            String str4 = null;
                            if (a11 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(a11.getAbsolutePath());
                                String str5 = File.separator;
                                sb2.append(str5);
                                sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb2.append(str5);
                                str3 = sb2.toString();
                                str2 = null;
                            } else {
                                File d10 = f.d();
                                if (d10 == null) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message obtainMessage = handler.obtainMessage();
                                    obtainMessage.arg1 = 102;
                                    handler.sendMessage(obtainMessage);
                                    return;
                                }
                                String absolutePath = d10.getAbsolutePath();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(absolutePath);
                                String str6 = File.separator;
                                sb3.append(str6);
                                sb3.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb3.append(str6);
                                String sb4 = sb3.toString();
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + sb4);
                                str2 = absolutePath;
                                str3 = sb4;
                            }
                            String str7 = "share2qq_temp" + l.f(String.this) + ".jpg";
                            String str8 = String.this;
                            if (!a.b(str8, 840, 840)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            } else {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                String a12 = a.a(a10, str3, str7);
                                if (!TextUtils.isEmpty(a12)) {
                                    str8 = a12;
                                }
                            }
                            boolean n10 = l.n(str8);
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + n10);
                            ArrayList arrayList = new ArrayList(2);
                            if (n10) {
                                str4 = str8;
                            } else if (TextUtils.isEmpty(str2)) {
                                String str9 = str3 + str7;
                                boolean a13 = l.a(context, str8, str9);
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str9 + ",isSuccess=" + a13);
                                if (a13) {
                                    str4 = str9;
                                }
                            }
                            arrayList.add(str8);
                            arrayList.add(str4);
                            if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                                Message obtainMessage2 = handler.obtainMessage(101);
                                obtainMessage2.obj = arrayList;
                                handler.sendMessage(obtainMessage2);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e2);
                    }
                    SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message obtainMessage3 = handler.obtainMessage(102);
                    obtainMessage3.arg1 = 3;
                    handler.sendMessage(obtainMessage3);
                }
            }).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f10 = i10 / width;
        matrix.postScale(f10, f10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static int b(BitmapFactory.Options options, int i10, int i11) {
        int min;
        double d10 = options.outWidth;
        double d11 = options.outHeight;
        int ceil = i11 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d10 * d11) / i11));
        if (i10 == -1) {
            min = 128;
        } else {
            double d12 = i10;
            min = (int) Math.min(Math.floor(d10 / d12), Math.floor(d11 / d12));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i11 == -1 && i10 == -1) {
            return 1;
        }
        return i10 == -1 ? ceil : min;
    }

    public static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return stringBuffer2;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap a(java.lang.String r6, int r7) {
        /*
            java.lang.String r0 = "openSDK_LOG.AsynScaleCompressImage"
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r3 = 1
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L16
            goto L1c
        L16:
            r3 = move-exception
            java.lang.String r4 = "scaleBitmap exception1:"
            com.tencent.open.log.SLog.e(r0, r4, r3)
        L1c:
            int r3 = r1.outWidth
            int r4 = r1.outHeight
            boolean r5 = r1.mCancel
            if (r5 != 0) goto L69
            r5 = -1
            if (r3 == r5) goto L69
            if (r4 != r5) goto L2a
            goto L69
        L2a:
            if (r3 <= r4) goto L2d
            goto L2e
        L2d:
            r3 = r4
        L2e:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            r1.inPreferredConfig = r4
            if (r3 <= r7) goto L3c
            int r3 = r7 * r7
            int r3 = a(r1, r5, r3)
            r1.inSampleSize = r3
        L3c:
            r3 = 0
            r1.inJustDecodeBounds = r3
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeFile(r6, r1)     // Catch: java.lang.OutOfMemoryError -> L44 java.lang.Exception -> L4b
            goto L52
        L44:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap OutOfMemoryError:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
            goto L51
        L4b:
            r6 = move-exception
            java.lang.String r3 = "scaleBitmap exception2:"
            com.tencent.open.log.SLog.e(r0, r3, r6)
        L51:
            r6 = r2
        L52:
            if (r6 != 0) goto L5a
            java.lang.String r6 = "scaleBitmap return null"
            com.tencent.open.log.SLog.e(r0, r6)
            return r2
        L5a:
            int r0 = r1.outWidth
            int r1 = r1.outHeight
            if (r0 <= r1) goto L61
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 <= r7) goto L68
            android.graphics.Bitmap r6 = a(r6, r7)
        L68:
            return r6
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.a.a(java.lang.String, int):android.graphics.Bitmap");
    }

    public static final int a(BitmapFactory.Options options, int i10, int i11) {
        int b4 = b(options, i10, i11);
        if (b4 > 8) {
            return ((b4 + 7) / 8) * 8;
        }
        int i12 = 1;
        while (i12 < b4) {
            i12 <<= 1;
        }
        return i12;
    }
}
