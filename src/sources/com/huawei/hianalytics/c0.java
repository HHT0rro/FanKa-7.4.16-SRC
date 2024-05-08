package com.huawei.hianalytics;

import com.huawei.hianalytics.framework.config.ServerAddrGetTask;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c0 implements ServerAddrGetTask {
    public static String[] lmn(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(str.replace(FrameworkConstant.URL_PALCEHOLDER, iterator2.next()));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c8 A[RETURN] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable] */
    @Override // com.huawei.hianalytics.framework.config.ServerAddrGetTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.c0.run():void");
    }
}
