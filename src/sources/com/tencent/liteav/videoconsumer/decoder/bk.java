package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface bk {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        SOFTWARE(0),
        HARDWARE(1),
        CUSTOM(2),
        SOFTWARE_DEVICE(3);

        public int mValue;

        a(int i10) {
            this.mValue = i10;
        }
    }

    boolean decode(EncodedVideoFrame encodedVideoFrame);

    a getDecoderType();

    void initialize();

    void setScene(VideoDecoderDef.ConsumerScene consumerScene);

    void setServerConfig(VideoConsumerServerConfig videoConsumerServerConfig);

    void start(Object obj, bl blVar);

    void stop();

    void uninitialize();
}
