package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.b.a.a;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTImageInfo {
    public String checksum;
    public ArrayList<Float> five_points;
    public String image;

    public YTImageInfo(a aVar) {
        this.image = new String(Base64.encode(aVar.f40596a, 2));
        this.checksum = aVar.f40598c;
        ArrayList<Float> arrayList = new ArrayList<>();
        this.five_points = arrayList;
        float[] fArr = aVar.f40597b;
        if (fArr != null) {
            arrayList.add(Float.valueOf(fArr[176]));
            this.five_points.add(Float.valueOf(aVar.f40597b[177]));
            this.five_points.add(Float.valueOf(aVar.f40597b[178]));
            this.five_points.add(Float.valueOf(aVar.f40597b[179]));
            this.five_points.add(Float.valueOf(aVar.f40597b[64]));
            this.five_points.add(Float.valueOf(aVar.f40597b[65]));
            this.five_points.add(Float.valueOf(aVar.f40597b[90]));
            this.five_points.add(Float.valueOf(aVar.f40597b[91]));
            this.five_points.add(Float.valueOf(aVar.f40597b[102]));
            this.five_points.add(Float.valueOf(aVar.f40597b[103]));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0053 -> B:14:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void createFileWithByte(java.lang.String r3, byte[] r4) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r3 = 0
            boolean r1 = r0.exists()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r1 == 0) goto Lf
            r0.delete()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
        Lf:
            r0.createNewFile()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L36
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L36
            r0.write(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r0.flush()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r1.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r3 = move-exception
            r3.printStackTrace()
        L2a:
            r0.close()     // Catch: java.lang.Exception -> L52
            goto L56
        L2e:
            r4 = move-exception
            goto L34
        L30:
            r4 = move-exception
            goto L38
        L32:
            r4 = move-exception
            r0 = r3
        L34:
            r3 = r1
            goto L58
        L36:
            r4 = move-exception
            r0 = r3
        L38:
            r3 = r1
            goto L3f
        L3a:
            r4 = move-exception
            r0 = r3
            goto L58
        L3d:
            r4 = move-exception
            r0 = r3
        L3f:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L57
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r3 = move-exception
            r3.printStackTrace()
        L4c:
            if (r0 == 0) goto L56
            r0.close()     // Catch: java.lang.Exception -> L52
            goto L56
        L52:
            r3 = move-exception
            r3.printStackTrace()
        L56:
            return
        L57:
            r4 = move-exception
        L58:
            if (r3 == 0) goto L62
            r3.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r3 = move-exception
            r3.printStackTrace()
        L62:
            if (r0 == 0) goto L6c
            r0.close()     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r3 = move-exception
            r3.printStackTrace()
        L6c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo.createFileWithByte(java.lang.String, byte[]):void");
    }

    public String toString() {
        return "YTImageInfo{image='" + this.image + "', five_points=" + ((Object) this.five_points) + ", checksum='" + this.checksum + "'}";
    }
}
