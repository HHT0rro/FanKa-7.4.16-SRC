package com.google.android.gms.internal.vision;

import android.content.Context;
import com.android.internal.content.NativeLibraryHelper;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j8 {
    public static boolean a(Context context, String str, String str2) {
        String b4 = r0.b(str2);
        if (!"face".equals(str) && !"ica".equals(str) && !"ocr".equals(str) && !"barcode".equals(str)) {
            String.format("Unrecognized engine: %s", str);
            return false;
        }
        int lastIndexOf = b4.lastIndexOf(".so");
        if (lastIndexOf == b4.length() - 3) {
            b4 = b4.substring(0, lastIndexOf);
        }
        if (b4.indexOf(NativeLibraryHelper.LIB_DIR_NAME) == 0) {
            b4 = b4.substring(3);
        }
        boolean a10 = k8.a(str, b4);
        if (!a10) {
            String.format("%s engine not loaded with %s.", str, b4);
        }
        return a10;
    }
}
