package a1;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.reflect.Array;

/* compiled from: FastBlur.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d {
    public static Bitmap a(Bitmap bitmap, int i10, boolean z10) {
        int[] iArr;
        int i11 = i10;
        Bitmap copy = z10 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i11 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i12 = width * height;
        int[] iArr2 = new int[i12];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = i11 + i11 + 1;
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int[] iArr5 = new int[i12];
        int[] iArr6 = new int[Math.max(width, height)];
        int i16 = (i15 + 1) >> 1;
        int i17 = i16 * i16;
        int i18 = i17 * 256;
        int[] iArr7 = new int[i18];
        for (int i19 = 0; i19 < i18; i19++) {
            iArr7[i19] = i19 / i17;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i15, 3);
        int i20 = i11 + 1;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i21 < height) {
            Bitmap bitmap2 = copy;
            int i24 = height;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = -i11;
            int i34 = 0;
            while (i33 <= i11) {
                int i35 = i14;
                int[] iArr9 = iArr6;
                int i36 = iArr2[i22 + Math.min(i13, Math.max(i33, 0))];
                int[] iArr10 = iArr8[i33 + i11];
                iArr10[0] = (i36 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr10[1] = (i36 & 65280) >> 8;
                iArr10[2] = i36 & 255;
                int abs = i20 - Math.abs(i33);
                i34 += iArr10[0] * abs;
                i25 += iArr10[1] * abs;
                i26 += iArr10[2] * abs;
                if (i33 > 0) {
                    i30 += iArr10[0];
                    i31 += iArr10[1];
                    i32 += iArr10[2];
                } else {
                    i27 += iArr10[0];
                    i28 += iArr10[1];
                    i29 += iArr10[2];
                }
                i33++;
                i14 = i35;
                iArr6 = iArr9;
            }
            int i37 = i14;
            int[] iArr11 = iArr6;
            int i38 = i11;
            int i39 = i34;
            int i40 = 0;
            while (i40 < width) {
                iArr3[i22] = iArr7[i39];
                iArr4[i22] = iArr7[i25];
                iArr5[i22] = iArr7[i26];
                int i41 = i39 - i27;
                int i42 = i25 - i28;
                int i43 = i26 - i29;
                int[] iArr12 = iArr8[((i38 - i11) + i15) % i15];
                int i44 = i27 - iArr12[0];
                int i45 = i28 - iArr12[1];
                int i46 = i29 - iArr12[2];
                if (i21 == 0) {
                    iArr = iArr7;
                    iArr11[i40] = Math.min(i40 + i11 + 1, i13);
                } else {
                    iArr = iArr7;
                }
                int i47 = iArr2[i23 + iArr11[i40]];
                iArr12[0] = (i47 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr12[1] = (i47 & 65280) >> 8;
                iArr12[2] = i47 & 255;
                int i48 = i30 + iArr12[0];
                int i49 = i31 + iArr12[1];
                int i50 = i32 + iArr12[2];
                i39 = i41 + i48;
                i25 = i42 + i49;
                i26 = i43 + i50;
                i38 = (i38 + 1) % i15;
                int[] iArr13 = iArr8[i38 % i15];
                i27 = i44 + iArr13[0];
                i28 = i45 + iArr13[1];
                i29 = i46 + iArr13[2];
                i30 = i48 - iArr13[0];
                i31 = i49 - iArr13[1];
                i32 = i50 - iArr13[2];
                i22++;
                i40++;
                iArr7 = iArr;
            }
            i23 += width;
            i21++;
            copy = bitmap2;
            height = i24;
            i14 = i37;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i51 = i14;
        int[] iArr14 = iArr6;
        int i52 = height;
        int[] iArr15 = iArr7;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i11;
            int i55 = i15;
            int[] iArr16 = iArr2;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i11) {
                int i67 = width;
                int max = Math.max(0, i64) + i53;
                int[] iArr17 = iArr8[i63 + i11];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i20 - Math.abs(i63);
                i65 += iArr3[max] * abs2;
                i66 += iArr4[max] * abs2;
                i56 += iArr5[max] * abs2;
                if (i63 > 0) {
                    i60 += iArr17[0];
                    i61 += iArr17[1];
                    i62 += iArr17[2];
                } else {
                    i57 += iArr17[0];
                    i58 += iArr17[1];
                    i59 += iArr17[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i11;
            int i72 = i53;
            int i73 = i66;
            int i74 = i52;
            int i75 = i65;
            int i76 = 0;
            while (i76 < i74) {
                iArr16[i72] = (iArr16[i72] & (-16777216)) | (iArr15[i75] << 16) | (iArr15[i73] << 8) | iArr15[i56];
                int i77 = i75 - i57;
                int i78 = i73 - i58;
                int i79 = i56 - i59;
                int[] iArr18 = iArr8[((i71 - i11) + i55) % i55];
                int i80 = i57 - iArr18[0];
                int i81 = i58 - iArr18[1];
                int i82 = i59 - iArr18[2];
                if (i53 == 0) {
                    iArr14[i76] = Math.min(i76 + i20, i70) * i69;
                }
                int i83 = iArr14[i76] + i53;
                iArr18[0] = iArr3[i83];
                iArr18[1] = iArr4[i83];
                iArr18[2] = iArr5[i83];
                int i84 = i60 + iArr18[0];
                int i85 = i61 + iArr18[1];
                int i86 = i62 + iArr18[2];
                i75 = i77 + i84;
                i73 = i78 + i85;
                i56 = i79 + i86;
                i71 = (i71 + 1) % i55;
                int[] iArr19 = iArr8[i71];
                i57 = i80 + iArr19[0];
                i58 = i81 + iArr19[1];
                i59 = i82 + iArr19[2];
                i60 = i84 - iArr19[0];
                i61 = i85 - iArr19[1];
                i62 = i86 - iArr19[2];
                i72 += i69;
                i76++;
                i11 = i10;
            }
            i53++;
            i11 = i10;
            i51 = i70;
            i52 = i74;
            i15 = i55;
            iArr2 = iArr16;
            width = i69;
        }
        int i87 = width;
        bitmap3.setPixels(iArr2, 0, i87, 0, 0, i87, i52);
        return bitmap3;
    }
}
