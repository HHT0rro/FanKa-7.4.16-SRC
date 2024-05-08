package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d extends k {
    public d(g<? extends d> gVar) {
        super(gVar);
    }

    public abstract int a();

    public abstract PixelFrame a(Object obj);

    public abstract void a(FrameMetaData frameMetaData);

    public abstract void a(ConsumerChainTimestamp consumerChainTimestamp);

    public abstract void a(ProducerChainTimestamp producerChainTimestamp);

    public abstract int b();

    public abstract int c();

    public abstract FrameMetaData d();

    public abstract ProducerChainTimestamp e();

    public abstract ConsumerChainTimestamp f();

    public abstract void g();
}
