package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.hardware.Camera;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.b> {
    public static int a(Camera.Parameters parameters, int i10) {
        int parseInt;
        Iterator<int[]> iterator2 = parameters.getSupportedPreviewFpsRange().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                int[] iArr = new int[2];
                parameters.getPreviewFpsRange(iArr);
                if (iArr[0] == iArr[1]) {
                    i10 = iArr[0];
                } else {
                    if (i10 > iArr[1]) {
                        i10 = iArr[1];
                    }
                    if (i10 < iArr[0]) {
                        i10 = iArr[0];
                    }
                }
                String str = parameters.get("preview-frame-rate-values");
                if (!TextUtils.isEmpty(str)) {
                    if (!str.contains("" + (i10 / 1000))) {
                        String[] split = str.split(",");
                        for (String str2 : split) {
                            int parseInt2 = Integer.parseInt(str2) * 1000;
                            if (i10 < parseInt2) {
                                parameters.setPreviewFrameRate(parseInt2 / 1000);
                                return parseInt2;
                            }
                        }
                        if (split.length > 0 && i10 > (parseInt = Integer.parseInt(split[split.length - 1]) * 1000)) {
                            i10 = parseInt;
                        }
                    }
                }
                parameters.setPreviewFrameRate(i10 / 1000);
                return i10;
            }
            int[] next = iterator2.next();
            com.tencent.cloud.huiyansdkface.a.d.a.b("V1FpsSelector", "entry: " + next[0] + " - " + next[1], new Object[0]);
            if (next[0] == next[1] && next[0] == i10) {
                parameters.setPreviewFpsRange(next[0], next[1]);
                com.tencent.cloud.huiyansdkface.a.d.a.b("V1FpsSelector", "use preview fps range: " + next[0] + " " + next[1], new Object[0]);
                return next[0];
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.cloud.huiyansdkface.a.a.a.b b(List<com.tencent.cloud.huiyansdkface.a.a.a.b> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        Object a10 = dVar.a();
        if (!(a10 instanceof Camera)) {
            throw new IllegalStateException("this fps selector only be valid for v1 camera.");
        }
        a(((Camera) a10).getParameters(), 30000);
        return null;
    }
}
