package com.autonavi.base.ae.gmap.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0003l.ab;
import com.amap.api.col.p0003l.dx;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.nio.ByteBuffer;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NativeTextGenerate {

    @JBindingExclude
    private static volatile NativeTextGenerate instance;

    @JBindingExclude
    private TextPaint text_paint_bitmap;

    @JBindingExclude
    private TextPaint text_paint_size;

    @JBindingExclude
    private float density = 1.0f;

    @JBindingExclude
    private final int kTextLayoutLeftToRight = 0;

    @JBindingExclude
    private final int kTextLayoutUpToDown = 1;

    @JBindingExclude
    private final int kTextAlignmentCenter = 0;

    @JBindingExclude
    private final int kTextAlignmentLeft = 1;

    @JBindingExclude
    private final int kTextAlignmentRight = 2;

    @JBindingInclude
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class TextGeneratePOIStyleDesc {
        public int fontSize = 0;
        public int fontColor = 0;
        public int fontBorderColor = 0;
        public int fontBgColor = 0;
        public int boldFont = 0;
    }

    @JBindingInclude
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class TextGenerateTextBitmap {
        public byte[] data;
        public int dataId;
        public int dataLength;
        public double height;
        public BitmapDescriptor imageData;
        public String text;
        public double width;
    }

    @JBindingInclude
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class TextGenerateTextStyle {
        public int singleLineCharaterLimit = 7;
        public int textAlignment = 0;
        public int layoutDirection = 0;
    }

    @JBindingExclude
    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.text_paint_size = new TextPaint();
        this.text_paint_bitmap = new TextPaint();
    }

    @JBindingInclude
    public static NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (NativeTextGenerate.class) {
                if (instance == null) {
                    instance = new NativeTextGenerate();
                }
            }
        }
        return instance;
    }

    @JBindingExclude
    private StaticLayout setPaintStyle(TextPaint textPaint, TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f10 = textGeneratePOIStyleDesc.fontSize * this.density;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f10);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i10 = textGenerateTextStyle.textAlignment;
        if (i10 == 0) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else if (i10 != 2) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i11 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > i11 || length % i11 != 0) {
            int i12 = (length / i11) + 1;
            i11 = (length / i12) + (length % i12 <= 0 ? 0 : 1);
        }
        return new StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f10 * i11), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @JBindingInclude
    public void calculateTextBoundSize(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_size, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        float measureText = this.text_paint_size.measureText(textGenerateTextBitmap.text);
        Paint.FontMetrics fontMetrics = this.text_paint_size.getFontMetrics();
        textGenerateTextBitmap.width = measureText;
        textGenerateTextBitmap.height = fontMetrics.descent - fontMetrics.ascent;
        textGenerateTextBitmap.width = paintStyle.getWidth();
        textGenerateTextBitmap.height = paintStyle.getHeight();
    }

    @JBindingInclude
    public void generateTextBitmap(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_bitmap, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        Bitmap createBitmap = Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i10 = textGenerateTextStyle.textAlignment;
        if (i10 == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (i10 == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        int i11 = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.dataLength = i11;
        textGenerateTextBitmap.data = new byte[i11];
        textGenerateTextBitmap.dataId = dx.b();
        createBitmap.copyPixelsToBuffer(ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    @JBindingInclude
    public BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] uncompress = FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(ab.f4885a, AMapEngineUtils.MAP_MAP_ASSETS_NAME, str + "_"));
            if (uncompress != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
        } catch (Throwable th) {
            dx.a(th);
        }
        return null;
    }

    @JBindingInclude
    public byte[] getMapStyleJsonData() {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssets(ab.f4885a, "map_custom/terrain/terrainStyle.data"));
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    @JBindingExclude
    public void setDensity(float f10) {
        this.density = f10;
    }
}
