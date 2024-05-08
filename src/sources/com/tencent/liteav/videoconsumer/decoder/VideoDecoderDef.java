package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoconsumer.decoder.bk;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface VideoDecoderDef {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ConsumerScene {
        UNKNOWN(-1),
        LIVE(0),
        RTC(1);


        /* renamed from: d, reason: collision with root package name */
        private static final ConsumerScene[] f43810d = values();
        private int mValue;

        ConsumerScene(int i10) {
            this.mValue = i10;
        }

        public static ConsumerScene a(int i10) {
            for (ConsumerScene consumerScene : f43810d) {
                if (consumerScene.mValue == i10) {
                    return consumerScene;
                }
            }
            return UNKNOWN;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class DecodeAbility {

        /* renamed from: a, reason: collision with root package name */
        public boolean f43812a = true;

        /* renamed from: b, reason: collision with root package name */
        public boolean f43813b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f43814c = true;

        @CalledByNative("DecodeAbility")
        public boolean isSupportHEVC() {
            return this.f43814c;
        }

        @CalledByNative("DecodeAbility")
        public boolean isSupportRPS() {
            return this.f43812a;
        }

        @CalledByNative("DecodeAbility")
        public boolean isSupportSVC() {
            return this.f43813b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class DecoderProperty {

        /* renamed from: a, reason: collision with root package name */
        public bk.a f43815a;

        /* renamed from: b, reason: collision with root package name */
        public CodecType f43816b;

        public DecoderProperty(bk.a aVar, CodecType codecType) {
            this.f43815a = aVar;
            this.f43816b = codecType;
        }

        @CalledByNative("DecoderProperty")
        public int getCodecType() {
            return this.f43816b.mValue;
        }

        @CalledByNative("DecoderProperty")
        public int getDecoderType() {
            return this.f43815a.mValue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        UNKNOWN(-1),
        NORMAL_WRITABLE(0),
        NORMAL_UNWRITABLE(1),
        FAST_WRITABLE(2),
        FAST_UNWRITABLE(3);

        public final int mValue;

        a(int i10) {
            this.mValue = i10;
        }
    }
}
