package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.col.p0003l.dx;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    public static final int AN_LABEL_MAXCHARINLINE = 7;
    public static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i10) {
        int i11 = 1;
        while (i10 > i11) {
            i11 *= 2;
        }
        return i11;
    }

    private void createTextParam() {
        float f10;
        float f11;
        Paint.FontMetrics fontMetrics;
        int i10 = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i10;
        Paint newPaint = newPaint(null, i10, 49);
        this.text_paint = newPaint;
        float f12 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f12;
        try {
            fontMetrics = newPaint.getFontMetrics();
            f10 = fontMetrics.descent;
        } catch (Exception unused) {
            f10 = 7.3242188f;
        }
        try {
            f11 = fontMetrics.ascent;
        } catch (Exception unused2) {
            f11 = -27.832031f;
            this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f10 + f11)) / 2.0f) + f12 + 0.5f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f10 + f11)) / 2.0f) + f12 + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private static Paint newPaint(String str, int i10, int i11) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i10);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i11) {
            case 49:
                textPaint.setTextAlign(Paint.Align.LEFT);
                return textPaint;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                return textPaint;
            case 51:
                textPaint.setTextAlign(Paint.Align.CENTER);
                return textPaint;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                return textPaint;
        }
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        for (int i10 = 0; i10 < length; i10++) {
            Paint paint = this.text_paint;
            StringBuilder sb2 = new StringBuilder();
            sb2.append((char) iArr[i10]);
            fArr[0] = paint.measureText(sb2.toString());
            bArr[i10] = (byte) (fArr[0] + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i10, int i11) {
        if (this.TEXT_FONTSIZE != i11) {
            this.TEXT_FONTSIZE = i11;
            createTextParam();
        }
        try {
            char c4 = (char) i10;
            char[] cArr = {c4};
            float f10 = this.base_line;
            int i12 = this.TEXT_FONTSIZE;
            Bitmap createBitmap = Bitmap.createBitmap(i12, i12, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            int i13 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[i13 * i13];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c4));
            if (cArr[0] > 0 && cArr[0] < 256) {
                f10 -= 1.5f;
            }
            float f11 = f10;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f12 = measureText - this.TEXT_FONTSIZE_TRUE;
            Paint.Align align = Paint.Align.CENTER;
            if (textAlign != align && f12 >= 4.0f) {
                this.text_paint.setTextAlign(align);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f12);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f12) / 2.0f, f11, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            } else {
                canvas.drawText(cArr, 0, 1, this.start_x, f11, this.text_paint);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            dx.a(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
