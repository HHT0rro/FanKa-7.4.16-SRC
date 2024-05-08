package com.alibaba.security.common.http.ok.internal;

import com.alibaba.security.common.http.ok.Address;
import com.alibaba.security.common.http.ok.ConnectionPool;
import com.alibaba.security.common.http.ok.ConnectionSpec;
import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.Route;
import com.alibaba.security.common.http.ok.internal.cache.InternalCache;
import com.alibaba.security.common.http.ok.internal.connection.RealConnection;
import com.alibaba.security.common.http.ok.internal.connection.RouteDatabase;
import com.alibaba.security.common.http.ok.internal.connection.StreamAllocation;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class Internal {
    public static Internal instance;

    public static void initializeInstanceForTests() {
        new RPHttpClient();
    }

    public abstract void addLenient(Headers.Builder builder, String str);

    public abstract void addLenient(Headers.Builder builder, String str, String str2);

    public abstract void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z10);

    public abstract int code(Response.Builder builder);

    public abstract boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation);

    public abstract boolean equalsNonHost(Address address, Address address2);

    public abstract RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route);

    public abstract boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException);

    public abstract RPCall newWebSocketCall(RPHttpClient rPHttpClient, RPRequest rPRequest);

    public abstract void put(ConnectionPool connectionPool, RealConnection realConnection);

    public abstract RouteDatabase routeDatabase(ConnectionPool connectionPool);

    public abstract void setCache(RPHttpClient.Builder builder, InternalCache internalCache);

    public abstract StreamAllocation streamAllocation(RPCall rPCall);

    public abstract IOException timeoutExit(RPCall rPCall, IOException iOException);
}
