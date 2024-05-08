package com.alimm.tanx.core.view.player.cache.videocache.log;

import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LoggerFactory {
    public static Logger getLogger(String str) {
        return new Logger(str);
    }

    public static void log(String... strArr) {
        LogUtils.d("VideoCache", strArr);
    }
}
