package com.amazing.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.Xml;
import h0.a;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TextMeshUtils {
    @a
    private static Bitmap callIStaticGenerateBitmapForEmoji(byte[] bArr, int i10) {
        String str = new String(bArr);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(i10);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawText(str, -rect.left, -rect.top, textPaint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    @a
    private static Bitmap callIStaticGenerateBitmapFromTextMesh(byte[] bArr, String str, int i10, int i11, int i12, float f10, int i13, float f11, int i14, float f12, float f13, float f14, int i15, int i16, int i17, int i18) {
        Bitmap bitmap;
        Canvas canvas;
        String str2 = new String(bArr);
        Rect rect = new Rect(0, 0, i17, i18);
        Bitmap createBitmap = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        Canvas canvas2 = new Canvas(createBitmap);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(i11);
        float f15 = i10;
        textPaint.setTextSize(f15);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        if (i16 == 0) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else if (i16 == 1) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        if ((i13 & 16) == 16) {
            textPaint.setUnderlineText(true);
        }
        if ((i13 & 32) == 32) {
            textPaint.setStrikeThruText(true);
        }
        if ((i13 & 4) == 4) {
            textPaint.setTextSkewX((-f10) / 90.0f);
        }
        if ((i13 & 8) == 8) {
            textPaint.setFakeBoldText(true);
        }
        if ((i13 & 2) == 2) {
            textPaint.setShadowLayer(f12, f13, f14, i15);
        }
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f16 = fontMetrics.top;
        float f17 = fontMetrics.bottom;
        String[] split = str2.split("\n");
        int length = split.length;
        if ((i13 & 1) == 1) {
            TextPaint textPaint2 = new TextPaint();
            textPaint2.setColor(i14);
            textPaint2.setTextSize(textPaint.getTextSize());
            textPaint2.setAntiAlias(textPaint.isAntiAlias());
            textPaint2.setStyle(Paint.Style.STROKE);
            textPaint2.setStrokeWidth((5.0f * f11) / f15);
            textPaint2.setTextAlign(textPaint.getTextAlign());
            textPaint2.setTextSkewX(textPaint.getTextSkewX());
            textPaint.setFakeBoldText(false);
            textPaint2.setFakeBoldText(true);
            float f18 = i12 / f15;
            float f19 = ((-fontMetrics.ascent) + fontMetrics.descent) * 0.1f;
            bitmap = createBitmap;
            int i19 = 0;
            while (i19 < length) {
                TextPaint textPaint3 = textPaint;
                float f20 = f16;
                float f21 = f17;
                float f22 = f15;
                Canvas canvas3 = canvas2;
                String[] strArr = split;
                int centerY = (int) (((int) ((rect.centerY() - (f16 / 2.0f)) - (f17 / 2.0f))) - ((((length - 1) * 0.5d) - i19) * (f19 + r6)));
                textPaint2.setLetterSpacing(f18);
                if (i16 == 0) {
                    canvas = canvas3;
                    canvas.drawText(strArr[i19], rect.left, centerY, textPaint2);
                } else {
                    canvas = canvas3;
                    if (i16 == 1) {
                        canvas.drawText(strArr[i19], rect.centerX(), centerY, textPaint2);
                    } else {
                        canvas.drawText(strArr[i19], rect.right, centerY, textPaint2);
                    }
                }
                i19++;
                f17 = f21;
                split = strArr;
                textPaint = textPaint3;
                canvas2 = canvas;
                f16 = f20;
                f15 = f22;
            }
        } else {
            bitmap = createBitmap;
        }
        String[] strArr2 = split;
        TextPaint textPaint4 = textPaint;
        float f23 = f15;
        float f24 = f16;
        float f25 = f17;
        Canvas canvas4 = canvas2;
        float f26 = i12 / f23;
        float f27 = 0.1f * ((-fontMetrics.ascent) + fontMetrics.descent);
        int i20 = 0;
        while (i20 < length) {
            int centerY2 = (int) (((int) ((rect.centerY() - (f24 / 2.0f)) - (f25 / 2.0f))) - ((((length - 1) * 0.5d) - i20) * (f27 + r2)));
            TextPaint textPaint5 = textPaint4;
            textPaint5.setLetterSpacing(f26);
            if (i16 == 0) {
                canvas4.drawText(strArr2[i20], rect.left, centerY2, textPaint5);
            } else if (i16 == 1) {
                canvas4.drawText(strArr2[i20], rect.centerX(), centerY2, textPaint5);
            } else {
                canvas4.drawText(strArr2[i20], rect.right, centerY2, textPaint5);
            }
            i20++;
            textPaint4 = textPaint5;
        }
        canvas4.save();
        canvas4.restore();
        return bitmap;
    }

    @a
    private static Bitmap generateImage(String str, float f10, byte[] bArr, int i10, boolean z10, float f11, int i11, boolean z11, float f12, float f13, int i12, float f14) {
        float f15;
        float f16;
        String str2 = new String(bArr);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(i10);
        Rect rect = new Rect();
        float[] fArr = new float[str2.length()];
        textPaint.getTextWidths(str2, fArr);
        textPaint.getTextBounds(str2, 0, str2.length(), rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("paint1 left:");
        sb2.append(rect.left);
        sb2.append(" right:");
        sb2.append(rect.right);
        sb2.append(" bottom:");
        sb2.append(rect.bottom);
        sb2.append(" top:");
        sb2.append(rect.top);
        sb2.append(" advance:");
        sb2.append(fArr[0]);
        float f17 = 0.0f;
        float f18 = !z10 ? 0.0f : f11;
        if (z11) {
            f17 = f12;
            f15 = f13;
            f16 = f14;
        } else {
            f15 = 0.0f;
            f16 = 0.0f;
        }
        float max = Math.max(Math.abs(f17), Math.abs(f15)) + f18;
        TextPaint textPaint2 = new TextPaint();
        if (z10 || z11) {
            textPaint2.setTextSize(f10);
            textPaint2.setAntiAlias(true);
            textPaint2.setStyle(Paint.Style.STROKE);
            textPaint2.setTextAlign(Paint.Align.LEFT);
            textPaint2.setStrokeWidth(f18 * 2.0f * f10);
            textPaint2.setColor(i11);
            if (z11) {
                textPaint2.setShadowLayer(f16 * f10, f17 * f10, f15 * f10, i12);
            }
        }
        float f19 = 2.0f * max * f10;
        Bitmap createBitmap = Bitmap.createBitmap((int) (rect.width() + f19), (int) (rect.height() + f19), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (z10 || z11) {
            float f20 = max * f10;
            canvas.drawText(str2, (-rect.left) + f20, (-rect.top) + f20, textPaint2);
        }
        float f21 = max * f10;
        canvas.drawText(str2, (-rect.left) + f21, (-rect.top) + f21, textPaint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    @a
    private static float[] generateImageSize(String str, float f10, byte[] bArr, int i10, boolean z10, float f11, int i11, boolean z11, float f12, float f13, int i12, float f14) {
        String str2 = new String(bArr);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f10);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(i10);
        Rect rect = new Rect();
        float[] fArr = new float[str2.length()];
        textPaint.getTextWidths(str2, fArr);
        textPaint.getTextBounds(str2, 0, str2.length(), rect);
        if (!z10) {
            f11 = 0.0f;
        }
        if (!z11) {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        return new float[]{rect.left, rect.right, -rect.bottom, -rect.top, fArr[0], (f11 + Math.max(Math.abs(f12), Math.abs(f13))) * f10, textPaint.ascent(), textPaint.descent()};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a
    private static String[] getAndroidSystemFontPaths() {
        FileInputStream fileInputStream;
        Throwable th;
        XmlPullParser newPullParser;
        try {
            newPullParser = Xml.newPullParser();
            fileInputStream = new FileInputStream(new File("/system/etc/fonts.xml"));
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            newPullParser.setInput(fileInputStream, "utf-8");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            String str = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        if (eventType == 4) {
                            str = newPullParser.getText();
                        }
                    } else if ("family".equals(newPullParser.getName())) {
                        int i10 = -1;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= arrayList2.size()) {
                                break;
                            }
                            if (((String) arrayList2.get(i11)).contains("Regular")) {
                                i10 = i11;
                                break;
                            }
                            i11++;
                        }
                        String str2 = new String("/system/fonts/");
                        if (i10 >= 0) {
                            arrayList.add(str2.concat((String) arrayList2.get(i10)));
                        } else {
                            arrayList.add(str2.concat((String) arrayList2.get(0)));
                        }
                    } else if ("font".equals(newPullParser.getName())) {
                        arrayList2.add(str);
                    } else if ("familyset".equals(newPullParser.getName())) {
                        str = "ending";
                    }
                } else if ("family".equals(newPullParser.getName())) {
                    arrayList2.clear();
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return strArr;
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    @a
    private static float getDeviceDpi() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }
}
