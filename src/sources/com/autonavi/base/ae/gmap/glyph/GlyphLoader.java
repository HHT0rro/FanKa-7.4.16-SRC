package com.autonavi.base.ae.gmap.glyph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap = new HashMap();

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static String decodeUnicode(short s2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s2);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j10) {
        nativeDestroyGlyphLoader(j10);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i10 = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i11 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i11);
            i10 = i11 + 16;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i10 + 4, GLConvertUtil.getInt(bArr, i10));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i10 = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i10);
        int i11 = i10 + 4;
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i11);
        int i12 = i11 + 4;
        font.nFontSize = GLConvertUtil.getInt(bArr, i12);
        int i13 = i12 + 4;
        int i14 = GLConvertUtil.getInt(bArr, i13);
        int i15 = i13 + 4;
        font.strName = new String(bArr, i15, i14);
        int i16 = i15 + i14;
        FontMetrics fontMetrics = new FontMetrics();
        int i17 = GLConvertUtil.getInt(bArr, i16);
        int i18 = i16 + 4;
        fontMetrics.fAscent = i17 * 0.001f;
        int i19 = GLConvertUtil.getInt(bArr, i18);
        int i20 = i18 + 4;
        fontMetrics.fDescent = i19 * 0.001f;
        int i21 = GLConvertUtil.getInt(bArr, i20);
        int i22 = i20 + 4;
        fontMetrics.fLeading = i21 * 0.001f;
        int i23 = GLConvertUtil.getInt(bArr, i22);
        int i24 = i22 + 4;
        fontMetrics.fHeight = i23 * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i24);
        int i25 = i24 + 4;
        int i26 = GLConvertUtil.getInt(bArr, i25);
        int i27 = i25 + 4;
        glyphRequestParam.strokeWidth = i26 * 0.001f;
        int i28 = GLConvertUtil.getInt(bArr, i27);
        int i29 = i27 + 4;
        glyphRequestParam.languageArr = new String(bArr, i29, i28);
        glyphRequestParam.isEmoji = GLConvertUtil.getInt(bArr, i29);
        int i30 = i29 + 4;
        glyphRequestParam.isSDF = GLConvertUtil.getInt(bArr, i30);
        int i31 = i30 + 4;
        int i32 = GLConvertUtil.getInt(bArr, i31);
        int i33 = i31 + 4;
        if (1 == i32) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i33);
            int i34 = i33 + 4;
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i34);
            int i35 = i34 + 4;
            int i36 = GLConvertUtil.getInt(bArr, i35);
            int i37 = i35 + 4;
            glyphMetrics.fLeft = i36 * 0.001f;
            glyphMetrics.fTop = GLConvertUtil.getInt(bArr, i37) * 0.001f;
            glyphMetrics.fAdvance = GLConvertUtil.getInt(bArr, i37 + 4) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        TextPaint newTextPaint = newTextPaint(new FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.strName, false, 0.0f);
        Paint.FontMetrics fontMetrics = newTextPaint.getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        newTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        boolean z10 = genGlyphRequestParam.drawingMode != 0;
        return loadGlyphMetrics(genGlyphRequestParam.strBuffer, fontStyle, r5.nFontSize, genGlyphRequestParam.font.strName, z10, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        int i10 = genGlyphRequestParam.drawingMode;
        boolean z10 = i10 != 0;
        if (i10 == 3) {
            return loadPathRaster(genGlyphRequestParam.strBuffer, fontStyle, r2.nFontSize, genGlyphRequestParam.font.strName, z10, genGlyphRequestParam.strokeWidth * 2.0f);
        }
        return loadGlyphRaster(genGlyphRequestParam.strBuffer, fontStyle, r5.nFontSize, genGlyphRequestParam.font.strName, z10, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f10, String str2, boolean z10, float f11, boolean z11, boolean z12) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            if (!z11) {
                TextPaint newTextPaint = newTextPaint(fontStyle, f10, str2, z10, f11);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float measureText = newTextPaint.measureText(" ", 0, 1);
                    float abs = Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) measureText;
                    rect.bottom = (int) abs;
                }
                if (z10 && f11 > 0.0f) {
                    float f12 = f11 / 2.0f;
                    rect.top = (int) (rect.top - f12);
                    rect.left = (int) (rect.left - f12);
                    rect.right = (int) (rect.right + f12);
                    rect.bottom = (int) (rect.bottom + f12);
                }
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = newTextPaint.measureText(str);
                newTextPaint.setTypeface(null);
            } else {
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = 0.0f;
                glyphMetrics.fTop = 0.0f;
                int i10 = (int) f10;
                glyphMetrics.nWidth = i10;
                glyphMetrics.nHeight = i10;
                glyphMetrics.fAdvance = f10;
            }
        } catch (Exception unused) {
            glyphMetrics.bSuccess = false;
        }
        return glyphMetrics;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:8|(2:9|10)|(9:12|14|15|(1:19)|(1:23)|24|(9:26|(7:30|(1:32)(1:50)|33|(4:35|(4:37|(2:40|38)|41|42)|43|44)|45|(1:47)(1:49)|48)|51|(0)(0)|33|(0)|45|(0)(0)|48)|52|53)|56|14|15|(2:17|19)|(2:21|23)|24|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0131, code lost:
    
        r0.bSuccess = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121 A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.base.ae.gmap.glyph.GlyphRaster loadGlyphRaster(java.lang.String r8, com.autonavi.base.ae.gmap.glyph.FontStyle r9, float r10, java.lang.String r11, boolean r12, float r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.loadGlyphRaster(java.lang.String, com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float, boolean, boolean):com.autonavi.base.ae.gmap.glyph.GlyphRaster");
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f10, String str2, boolean z10, float f11) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f10, str2, false, 0.0f);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            new Canvas(Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ALPHA_8)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
            TextPaint newTextPaint2 = newTextPaint(fontStyle, f10, str2, z10, f11);
            Rect rect2 = new Rect();
            newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
            if (z10 && f11 > 0.0f) {
                float f12 = 0.5f * f11;
                rect2.top = (int) (rect2.top - f12);
                rect2.left = (int) (rect2.left - f12);
                rect2.right = (int) (rect2.right + f12);
                rect2.bottom = (int) (rect2.bottom + f12);
            }
            if (!rect2.isEmpty()) {
                Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ALPHA_8);
                Canvas canvas = new Canvas(createBitmap);
                float f13 = 0 - rect2.left;
                float f14 = 0 - rect2.top;
                Path path = new Path();
                newTextPaint.getTextPath(str, 0, str.length(), f13, f14, path);
                canvas.drawPath(path, newTextPaint2);
                int width = rect2.width() * rect2.height();
                byte[] bArr = new byte[width];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect2.width();
                glyphRaster.bitmapHeight = rect2.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = width;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
                glyphRaster.bSuccess = true;
            }
            newTextPaint.setTypeface(null);
            newTextPaint2.setTypeface(null);
        } catch (Exception unused) {
            glyphRaster.bSuccess = false;
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j10);

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0054, code lost:
    
        if (r3 != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.text.TextPaint newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle r2, float r3, java.lang.String r4, boolean r5, float r6) {
        /*
            android.text.TextPaint r0 = new android.text.TextPaint
            r0.<init>()
            if (r2 != 0) goto L8
            return r0
        L8:
            r1 = -1
            r0.setColor(r1)
            r1 = 1
            r0.setAntiAlias(r1)
            r0.setFilterBitmap(r1)
            r0.setTextSize(r3)
            android.graphics.Paint$Align r3 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r3)
            if (r5 == 0) goto L26
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            r0.setStrokeWidth(r6)
            goto L2b
        L26:
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r0.setStyle(r3)
        L2b:
            int r3 = r2.getSlant()
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L3a
            if (r3 == r1) goto L38
            if (r3 == r5) goto L38
            goto L3a
        L38:
            r3 = 1
            goto L3b
        L3a:
            r3 = 0
        L3b:
            int r2 = r2.getWeight()
            switch(r2) {
                case 0: goto L45;
                case 100: goto L45;
                case 200: goto L45;
                case 300: goto L45;
                case 400: goto L45;
                case 500: goto L43;
                case 600: goto L43;
                case 700: goto L43;
                case 800: goto L43;
                case 900: goto L43;
                case 1000: goto L43;
                default: goto L42;
            }
        L42:
            goto L45
        L43:
            r2 = 1
            goto L46
        L45:
            r2 = 0
        L46:
            if (r2 == 0) goto L4e
            if (r3 == 0) goto L4e
            r0.setFakeBoldText(r1)
            goto L57
        L4e:
            if (r2 == 0) goto L54
            r0.setFakeBoldText(r1)
            goto L57
        L54:
            if (r3 == 0) goto L57
            goto L58
        L57:
            r5 = 0
        L58:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NumberFormatException -> L60
            r3 = 23
            if (r2 < r3) goto L61
            r1 = 0
            goto L61
        L60:
        L61:
            boolean r2 = r4.isEmpty()
            if (r2 != 0) goto L8c
            if (r1 == 0) goto L6a
            goto L8c
        L6a:
            java.util.Map<java.lang.String, android.graphics.Typeface> r2 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Exception -> L85
            monitor-enter(r2)     // Catch: java.lang.Exception -> L85
            java.util.Map<java.lang.String, android.graphics.Typeface> r3 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L82
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L82
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3     // Catch: java.lang.Throwable -> L82
            if (r3 != 0) goto L80
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromFile(r4)     // Catch: java.lang.Throwable -> L82
            java.util.Map<java.lang.String, android.graphics.Typeface> r6 = com.autonavi.base.ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L82
            r6.put(r4, r3)     // Catch: java.lang.Throwable -> L82
        L80:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L82
            goto L92
        L82:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L82
            throw r3     // Catch: java.lang.Exception -> L85
        L85:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r2, r5)
            goto L92
        L8c:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r2, r5)
        L92:
            r0.setTypeface(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float):android.text.TextPaint");
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
