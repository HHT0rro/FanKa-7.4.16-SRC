package com.bytedance.pangle.e;

import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.huawei.openalliance.ad.constant.u;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i10) {
        String a10 = g.a(str, i10);
        String c4 = com.bytedance.pangle.d.c.c(str, i10);
        String[] split = a10.split(u.bD);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(a10));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = false;
        while (true) {
            if (i11 >= length) {
                z10 = z11;
                break;
            }
            String str2 = split[i11];
            if (!a(str2, c4 + File.separator + b.a(str2))) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i11++;
            z11 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z10);
        return z10;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
