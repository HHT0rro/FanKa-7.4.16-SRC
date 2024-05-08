package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/5029")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ChannelLogger {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum ChannelLogLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public abstract void log(ChannelLogLevel channelLogLevel, String str);

    public abstract void log(ChannelLogLevel channelLogLevel, String str, Object... objArr);
}
