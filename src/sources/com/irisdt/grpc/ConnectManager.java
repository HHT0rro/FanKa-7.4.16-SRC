package com.irisdt.grpc;

import com.irisdt.OnHostNameResolver;
import com.irisdt.util.DnsResolver;
import com.irisdt.util.Utils;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ConnectManager {
    private static ManagedChannel channel;
    private static String host;
    private static int port;
    private static ConcurrentHashMap<String, String> headerMap = new ConcurrentHashMap<>();
    private static Metadata headerData = new Metadata();
    private static DnsResolver dnsResolver = null;

    public static <T extends AbstractStub<T>> T attachHeaders(T t2) {
        return (T) Utils.attachHeaders(t2, headerData);
    }

    public static void createChannel(String str, int i10, OnHostNameResolver onHostNameResolver) {
        host = str;
        port = i10;
        if (onHostNameResolver != null) {
            if (dnsResolver == null) {
                dnsResolver = new DnsResolver();
            }
            dnsResolver.start(str, i10, onHostNameResolver);
        }
        channel = Utils.newOkHttpChannelBuilder(str, i10).build();
    }

    public static Channel getChannel() {
        return channel;
    }

    public static boolean isInit() {
        return channel != null;
    }

    public static void setHeader(String str, String str2) {
        headerData = Utils.addHeader(headerMap, headerData, str, str2);
    }
}
