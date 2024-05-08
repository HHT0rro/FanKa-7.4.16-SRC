package com.bef.effectsdk.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bef.effectsdk.text.data.BitmapType;
import com.bef.effectsdk.text.data.CharLayout;
import com.bef.effectsdk.text.data.TextBitmapResult;
import com.bef.effectsdk.text.data.TextLayoutParam;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

@h0.a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TextLayoutUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum COLOR_TYPE {
        COLOR_TYPE_RGBA,
        COLOR_TYPE_ALPHA
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10521a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10522b;

        static {
            int[] iArr = new int[COLOR_TYPE.values().length];
            f10522b = iArr;
            try {
                iArr[COLOR_TYPE.COLOR_TYPE_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10522b[COLOR_TYPE.COLOR_TYPE_RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[BitmapType.values().length];
            f10521a = iArr2;
            try {
                iArr2[BitmapType.TEXT_BITMAP_SHAKE_ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10521a[BitmapType.TEXT_BITMAP_NEON_ALPHA.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x01b3, code lost:
    
        r26 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0344 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0380 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0374  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bef.effectsdk.text.data.TextBitmapResult a(java.lang.String r31, com.bef.effectsdk.text.data.TextLayoutParam r32, com.bef.effectsdk.text.TextLayoutUtils.COLOR_TYPE r33) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bef.effectsdk.text.TextLayoutUtils.a(java.lang.String, com.bef.effectsdk.text.data.TextLayoutParam, com.bef.effectsdk.text.TextLayoutUtils$COLOR_TYPE):com.bef.effectsdk.text.data.TextBitmapResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0199 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bef.effectsdk.text.data.TextBitmapResult b(java.lang.String r26, com.bef.effectsdk.text.data.TextLayoutParam r27, com.bef.effectsdk.text.TextLayoutUtils.COLOR_TYPE r28) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bef.effectsdk.text.TextLayoutUtils.b(java.lang.String, com.bef.effectsdk.text.data.TextLayoutParam, com.bef.effectsdk.text.TextLayoutUtils$COLOR_TYPE):com.bef.effectsdk.text.data.TextBitmapResult");
    }

    @h0.a
    public static TextBitmapResult generateBitmapAtlasAlphaUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return a(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapAtlasAlphaUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return a(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapAtlasRGBAUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return a(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapAtlasRGBAUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return a(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapNeonAlphaUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return generateBitmapNeonAlphaUTF8(new String(iArr, 0, iArr.length), textLayoutParam);
    }

    @h0.a
    public static TextBitmapResult generateBitmapNeonAlphaUTF8(String str, TextLayoutParam textLayoutParam) {
        int i10 = a.f10521a[BitmapType.valueOf(textLayoutParam.bitmapType).ordinal()];
        if (i10 == 1) {
            return generateTextAutoSizedShakeBitmap(str, textLayoutParam);
        }
        if (i10 != 2) {
            return null;
        }
        return generateTextAutoSizedNeonBitmap(str, textLayoutParam);
    }

    @h0.a
    public static TextBitmapResult generateBitmapNormalAlphaUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return b(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapNormalAlphaUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return b(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapNormalRGBAUTF32(int[] iArr, TextLayoutParam textLayoutParam) {
        if (iArr == null || iArr.length < 1) {
            return null;
        }
        return b(new String(iArr, 0, iArr.length), textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    @h0.a
    public static TextBitmapResult generateBitmapNormalRGBAUTF8(String str, TextLayoutParam textLayoutParam) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return b(str, textLayoutParam, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    @h0.a
    public static TextBitmapResult generateTextAutoSizedNeonBitmap(String str, TextLayoutParam textLayoutParam) {
        StaticLayout staticLayout;
        Paint.FontMetrics fontMetrics;
        float f10;
        int[] iArr;
        Canvas canvas;
        float f11;
        float f12;
        float f13;
        String[] splitLyric = splitLyric(str);
        if (TextUtils.isEmpty(str) || textLayoutParam == null) {
            return null;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setAntiAlias(true);
        if (!TextUtils.isEmpty(textLayoutParam.familyName) && !TextUtils.isEmpty(textLayoutParam.fontPath)) {
            textPaint.setTypeface(com.bef.effectsdk.text.a.a(textLayoutParam.fontPath, textLayoutParam.familyName));
        }
        ?? r13 = 0;
        boolean z10 = textPaint.getFontMetrics().top < textPaint.getFontMetrics().ascent;
        TextBitmapResult textBitmapResult = new TextBitmapResult();
        textBitmapResult.channel = 1;
        textBitmapResult.lineCount = splitLyric.length;
        textBitmapResult.type = 0;
        textBitmapResult.charLayouts = new CharLayout[splitLyric.length];
        int[] iArr2 = new int[splitLyric.length];
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < splitLyric.length; i10++) {
            int i11 = 10;
            String str2 = splitLyric[i10];
            textPaint.setTextSize(10);
            for (float measureText = textPaint.measureText(str2, 0, str2.length()); measureText <= textLayoutParam.lineWidth; measureText = textPaint.measureText(str2, 0, str2.length())) {
                i11 += 2;
                textPaint.setTextSize(i11);
            }
            iArr2[i10] = i11 - 2;
            textPaint.setTextSize(iArr2[i10]);
            Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
            if (z10) {
                f12 = fontMetrics2.bottom;
                f13 = fontMetrics2.top;
            } else {
                f12 = fontMetrics2.descent;
                f13 = fontMetrics2.ascent;
            }
            f15 += f12 - f13;
        }
        Bitmap createBitmap = Bitmap.createBitmap(textLayoutParam.lineWidth, (int) f15, Bitmap.Config.ALPHA_8);
        Canvas canvas2 = new Canvas(createBitmap);
        textBitmapResult.bitmap = createBitmap;
        int i12 = 0;
        float f16 = 0.0f;
        while (i12 < splitLyric.length) {
            String str3 = splitLyric[i12];
            textPaint.setTextSize(iArr2[i12]);
            Paint.FontMetrics fontMetrics3 = textPaint.getFontMetrics();
            if (Build.VERSION.SDK_INT >= 23) {
                staticLayout = StaticLayout.Builder.obtain(str3, r13, str3.length(), textPaint, canvas2.getWidth()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f14, 1.0f).setIncludePad(r13).build();
                fontMetrics = fontMetrics3;
                canvas = canvas2;
                f10 = f15;
                iArr = iArr2;
            } else {
                fontMetrics = fontMetrics3;
                f10 = f15;
                iArr = iArr2;
                staticLayout = new StaticLayout(str3, 0, str3.length(), textPaint, canvas2.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                canvas = canvas2;
            }
            staticLayout.draw(canvas);
            CharLayout charLayout = new CharLayout();
            if (z10) {
                float f17 = fontMetrics.bottom;
                float f18 = fontMetrics.top;
                f11 = f17 - f18;
                charLayout.baseline = (f16 - f18) / f10;
            } else {
                float f19 = fontMetrics.descent;
                float f20 = fontMetrics.ascent;
                f11 = f19 - f20;
                charLayout.baseline = (f16 - f20) / f10;
            }
            charLayout.top = f16 / f10;
            f16 += f11;
            charLayout.bottom = f16 / f10;
            charLayout.left = 0.0f;
            charLayout.right = 1.0f;
            textBitmapResult.charLayouts[i12] = charLayout;
            canvas.translate(0.0f, f11);
            i12++;
            canvas2 = canvas;
            f15 = f10;
            iArr2 = iArr;
            f14 = 0.0f;
            r13 = 0;
        }
        return textBitmapResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    @h0.a
    public static TextBitmapResult generateTextAutoSizedShakeBitmap(String str, TextLayoutParam textLayoutParam) {
        String[] strArr;
        StaticLayout staticLayout;
        float f10;
        int i10;
        int i11;
        float f11;
        ArrayList arrayList;
        TextPaint textPaint;
        Paint.FontMetrics fontMetrics;
        String[] lyricShakeSplit = lyricShakeSplit(str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setAntiAlias(true);
        if (!TextUtils.isEmpty(textLayoutParam.familyName) && !TextUtils.isEmpty(textLayoutParam.fontPath)) {
            textPaint2.setTypeface(com.bef.effectsdk.text.a.a(textLayoutParam.fontPath, textLayoutParam.familyName));
        }
        textPaint2.setTextSize(textLayoutParam.fontSize);
        ?? r14 = 0;
        boolean z10 = textPaint2.getFontMetrics().top < textPaint2.getFontMetrics().ascent;
        Paint.FontMetrics fontMetrics2 = textPaint2.getFontMetrics();
        ArrayList arrayList2 = new ArrayList();
        float f12 = textLayoutParam.lineWidth;
        float f13 = 0.0f;
        float f14 = 0.0f;
        int i12 = 0;
        int i13 = 0;
        while (i13 < lyricShakeSplit.length) {
            String str2 = lyricShakeSplit[i13];
            if (Build.VERSION.SDK_INT >= 23) {
                staticLayout = StaticLayout.Builder.obtain(str2, r14, str2.length(), textPaint2, (int) f12).setAlignment(Layout.Alignment.ALIGN_OPPOSITE).setLineSpacing(f13, 1.0f).setIncludePad(r14).build();
                f10 = f14;
                i10 = i12;
                i11 = i13;
                f11 = f12;
                arrayList = arrayList2;
                textPaint = textPaint2;
                fontMetrics = fontMetrics2;
            } else {
                f10 = f14;
                i10 = i12;
                TextPaint textPaint3 = textPaint2;
                i11 = i13;
                f11 = f12;
                arrayList = arrayList2;
                textPaint = textPaint2;
                fontMetrics = fontMetrics2;
                staticLayout = new StaticLayout(str2, 0, str2.length(), textPaint3, (int) f12, Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, false);
            }
            i12 = i10 + staticLayout.getLineCount();
            ArrayList arrayList3 = arrayList;
            arrayList3.add(staticLayout);
            float height = staticLayout.getHeight() + f10;
            i13 = i11 + 1;
            arrayList2 = arrayList3;
            fontMetrics2 = fontMetrics;
            f12 = f11;
            textPaint2 = textPaint;
            f13 = 0.0f;
            r14 = 0;
            f14 = height;
        }
        float f15 = f14;
        int i14 = i12;
        float f16 = f12;
        ArrayList arrayList4 = arrayList2;
        Paint.FontMetrics fontMetrics3 = fontMetrics2;
        TextBitmapResult textBitmapResult = new TextBitmapResult();
        textBitmapResult.channel = 1;
        textBitmapResult.lineCount = i14;
        textBitmapResult.type = 0;
        textBitmapResult.charLayouts = new CharLayout[i14];
        Bitmap createBitmap = Bitmap.createBitmap(textLayoutParam.lineWidth, (int) f15, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(createBitmap);
        textBitmapResult.bitmap = createBitmap;
        int i15 = 0;
        float f17 = 0.0f;
        int i16 = 0;
        while (i15 < lyricShakeSplit.length) {
            float height2 = ((StaticLayout) arrayList4.get(i15)).getHeight();
            float lineCount = height2 / ((StaticLayout) arrayList4.get(i15)).getLineCount();
            int i17 = 0;
            while (i17 < ((StaticLayout) arrayList4.get(i15)).getLineCount()) {
                CharLayout charLayout = new CharLayout();
                float lineWidth = ((StaticLayout) arrayList4.get(i15)).getLineWidth(i17);
                if (z10) {
                    strArr = lyricShakeSplit;
                    charLayout.baseline = (f17 - fontMetrics3.top) / f15;
                } else {
                    strArr = lyricShakeSplit;
                    charLayout.baseline = (f17 - fontMetrics3.ascent) / f15;
                }
                charLayout.top = f17 / f15;
                f17 += lineCount;
                float f18 = lineCount;
                charLayout.bottom = (f17 - (Math.abs(fontMetrics3.bottom - fontMetrics3.descent) / 2.0f)) / f15;
                if (textLayoutParam.textAlign == 0) {
                    charLayout.left = 0.0f;
                    charLayout.right = (f16 - lineWidth) / f16;
                } else {
                    charLayout.left = (f16 - lineWidth) / f16;
                    charLayout.right = 1.0f;
                }
                textBitmapResult.charLayouts[i16] = charLayout;
                i16++;
                i17++;
                lyricShakeSplit = strArr;
                lineCount = f18;
            }
            ((StaticLayout) arrayList4.get(i15)).draw(canvas);
            canvas.translate(0.0f, height2 * ((StaticLayout) arrayList4.get(i15)).getLineCount());
            i15++;
            lyricShakeSplit = lyricShakeSplit;
        }
        return textBitmapResult;
    }

    @h0.a
    public static String[] lyricShakeSplit(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] split = str.replace("\n", " ").replace(",", "").replace(StringUtils.CR, " ").split(" ");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (i10 < split.length) {
            if (!split[i10].isEmpty()) {
                int length = sb2.toString().length();
                if (length == 0) {
                    if (split[i10].length() < 10) {
                        sb2.append(split[i10]);
                    } else if (split[i10].length() == 10) {
                        arrayList.add(split[i10]);
                    } else {
                        arrayList.add(split[i10].substring(0, 10));
                        boolean z10 = (split[i10].length() - 10) % 9 == 0;
                        int length2 = z10 ? (split[i10].length() - 10) / 9 : ((split[i10].length() - 10) / 9) + 1;
                        for (int i11 = 0; i11 < length2; i11++) {
                            if (i11 != 0) {
                                int i12 = ((i11 - 1) * 9) + 19;
                                if (i11 < length2 - 1) {
                                    sb2.append("-");
                                    sb2.append(split[i10].substring(i12, (i11 * 9) + 19));
                                    String sb3 = sb2.toString();
                                    arrayList.add(sb3);
                                    sb2.delete(0, sb3.length());
                                } else if (z10) {
                                    sb2.append("-");
                                    sb2.append(split[i10].substring(i12, (i11 * 9) + 19));
                                    String sb4 = sb2.toString();
                                    arrayList.add(sb4);
                                    sb2.delete(0, sb4.length());
                                } else {
                                    int length3 = split[i10].length();
                                    sb2.append("-");
                                    sb2.append(split[i10].substring(i12, length3));
                                }
                            } else if (z10) {
                                sb2.append("-");
                                sb2.append(split[i10].substring(10, 19));
                                String sb5 = sb2.toString();
                                arrayList.add(sb5);
                                sb2.delete(0, sb5.length());
                            } else if (length2 == 1) {
                                int length4 = split[i10].length();
                                sb2.append("-");
                                sb2.append(split[i10].substring(10, length4));
                            } else {
                                sb2.append("-");
                                sb2.append(split[i10].substring(10, 19));
                                String sb6 = sb2.toString();
                                arrayList.add(sb6);
                                sb2.delete(0, sb6.length());
                            }
                        }
                    }
                } else if (sb2.toString().length() + split[i10].length() + 1 <= 10) {
                    sb2.append(" ");
                    sb2.append(split[i10]);
                } else {
                    arrayList.add(sb2.toString());
                    sb2.delete(0, length);
                    i10--;
                }
            }
            i10++;
        }
        if (sb2.toString().length() != 0) {
            arrayList.add(sb2.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @h0.a
    public static String[] splitLyric(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] split = str.replace("\n", " ").replace(StringUtils.CR, " ").split(" ");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i10 < split.length) {
            StringBuilder sb2 = new StringBuilder();
            int i12 = (i11 % 5) % 3 == 0 ? 6 : 10;
            int i13 = 0;
            while (i10 < split.length && (split[i10].length() + i13 + 1 <= i12 || i13 <= 3)) {
                i13 += split[i10].length() + 1;
                int i14 = i10 + 1;
                sb2.append(split[i10]);
                sb2.append(" ");
                if (i14 == split.length - 1 && split[i14].length() < 3) {
                    sb2.append(split[i14]);
                }
                i10 = i14;
            }
            i11++;
            arrayList.add(sb2.substring(0, sb2.length() - 1));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
