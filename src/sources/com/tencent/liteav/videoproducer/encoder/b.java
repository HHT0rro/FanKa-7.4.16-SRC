package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Long, ProducerChainTimestamp> f44598a = new HashMap();

    public final void a(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame == null) {
            return;
        }
        synchronized (this.f44598a) {
            if (encodedVideoFrame.nalType == com.tencent.liteav.videobase.common.c.IDR) {
                long j10 = encodedVideoFrame.pts;
                Iterator<Map.Entry<Long, ProducerChainTimestamp>> iterator2 = this.f44598a.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    if (iterator2.next().getKey().longValue() < j10) {
                        iterator2.remove();
                    }
                }
            }
            ProducerChainTimestamp producerChainTimestamp = this.f44598a.get(Long.valueOf(encodedVideoFrame.pts));
            if (producerChainTimestamp == null) {
                return;
            }
            this.f44598a.remove(Long.valueOf(encodedVideoFrame.pts));
            encodedVideoFrame.producerChainTimestamp.copy(producerChainTimestamp);
            encodedVideoFrame.producerChainTimestamp.setEncodeFinishTimestamp(TimeUtil.a());
        }
    }
}
