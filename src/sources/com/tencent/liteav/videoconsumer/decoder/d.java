package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Long, ConsumerChainTimestamp> f43932a = new HashMap();

    public final void a(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        synchronized (this.f43932a) {
            long timestamp = pixelFrame.getTimestamp();
            Iterator<Map.Entry<Long, ConsumerChainTimestamp>> iterator2 = this.f43932a.entrySet().iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().getKey().longValue() < timestamp) {
                    iterator2.remove();
                }
            }
            ConsumerChainTimestamp consumerChainTimestamp = this.f43932a.get(Long.valueOf(timestamp));
            if (consumerChainTimestamp == null) {
                return;
            }
            pixelFrame.getConsumerChainTimestamp().copy(consumerChainTimestamp);
            pixelFrame.getConsumerChainTimestamp().setDecodeFinishTimestamp(TimeUtil.a());
        }
    }
}
