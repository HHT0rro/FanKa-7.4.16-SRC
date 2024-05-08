package io.grpc;

import com.google.common.base.o;
import io.grpc.ServerStreamTracer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class GlobalInterceptors {
    private static List<ClientInterceptor> clientInterceptors;
    private static boolean isGlobalInterceptorsTracersGet;
    private static boolean isGlobalInterceptorsTracersSet;
    private static List<ServerInterceptor> serverInterceptors;
    private static List<ServerStreamTracer.Factory> serverStreamTracerFactories;

    private GlobalInterceptors() {
    }

    public static synchronized List<ClientInterceptor> getClientInterceptors() {
        List<ClientInterceptor> list;
        synchronized (GlobalInterceptors.class) {
            isGlobalInterceptorsTracersGet = true;
            list = clientInterceptors;
        }
        return list;
    }

    public static synchronized List<ServerInterceptor> getServerInterceptors() {
        List<ServerInterceptor> list;
        synchronized (GlobalInterceptors.class) {
            isGlobalInterceptorsTracersGet = true;
            list = serverInterceptors;
        }
        return list;
    }

    public static synchronized List<ServerStreamTracer.Factory> getServerStreamTracerFactories() {
        List<ServerStreamTracer.Factory> list;
        synchronized (GlobalInterceptors.class) {
            isGlobalInterceptorsTracersGet = true;
            list = serverStreamTracerFactories;
        }
        return list;
    }

    public static synchronized void setInterceptorsTracers(List<ClientInterceptor> list, List<ServerInterceptor> list2, List<ServerStreamTracer.Factory> list3) {
        synchronized (GlobalInterceptors.class) {
            if (!isGlobalInterceptorsTracersGet) {
                if (!isGlobalInterceptorsTracersSet) {
                    o.r(list);
                    o.r(list2);
                    o.r(list3);
                    clientInterceptors = Collections.unmodifiableList(new ArrayList(list));
                    serverInterceptors = Collections.unmodifiableList(new ArrayList(list2));
                    serverStreamTracerFactories = Collections.unmodifiableList(new ArrayList(list3));
                    isGlobalInterceptorsTracersSet = true;
                } else {
                    throw new IllegalStateException("Global interceptors and tracers are already set");
                }
            } else {
                throw new IllegalStateException("Set cannot be called after any get call");
            }
        }
    }
}
