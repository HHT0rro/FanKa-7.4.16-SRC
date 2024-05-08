package com.irisdt.biz;

import com.google.protobuf.Any;
import com.irisdt.StatConfig;
import com.irisdt.apm.ApmProtos;
import com.irisdt.grpc.connect.ApmManager;
import com.irisdt.util.Utils;
import io.grpc.internal.GrpcUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class Apm {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstanceHolder {
        private static final Apm INSTANCE = new Apm();

        private InstanceHolder() {
        }
    }

    public static Apm getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void upload(ApmProtos.Request.Builder builder) {
        builder.setClientTime(System.currentTimeMillis());
        ApmManager.getInstance().record(builder.build());
    }

    public void grpcConnect(int i10, long j10, Throwable th, String str, String str2) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.GRPC_CONNECT).setTakes((int) j10).setCode(i10).setDescription(Utils.getExceptionValue(th)).setExtra(Any.pack(ApmProtos.GrpcConnectTypeProto.newBuilder().setHost(Utils.getStringValue(str)).setPort(GrpcUtil.DEFAULT_PORT_SSL).setServerIp(Utils.getStringValue(str2)).build())));
        } catch (Exception unused) {
        }
    }

    public void grpcRequest(ApmProtos.GrpcRequestTypeProto.BUSINESS business, String str, int i10, long j10, String str2, Throwable th, String str3, String str4) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.GRPC_REQUEST).setCode(i10).setTakes((int) j10).setServerRequestId(Utils.getStringValue(str2)).setDescription(Utils.getExceptionValue(th)).setExtra(Any.pack(ApmProtos.GrpcRequestTypeProto.newBuilder().setBusiness(business).setName(Utils.getStringValue(str)).setHost(Utils.getStringValue(str3)).setPort(GrpcUtil.DEFAULT_PORT_SSL).setServerIp(Utils.getStringValue(str4)).build())));
        } catch (Exception unused) {
        }
    }

    public void httpFailed(String str, int i10, String str2, Throwable th, long j10, String str3) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.HTTP).setCode(i10).setTakes((int) j10).setDescription(Utils.getExceptionValue(th)).setExtra(Any.pack(ApmProtos.HttpTypeProto.newBuilder().setUrl(Utils.getStringValue(str)).setResponseType(Utils.getStringValue(str2)).setServerIp(Utils.getStringValue(str3)).build())));
        } catch (Exception unused) {
        }
    }

    public void httpSuccess(String str, int i10, String str2, long j10, long j11, String str3) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.HTTP).setCode(i10).setTakes((int) j11).setExtra(Any.pack(ApmProtos.HttpTypeProto.newBuilder().setUrl(Utils.getStringValue(str)).setResponseType(Utils.getStringValue(str2)).setResponseLength((int) j10).setServerIp(Utils.getStringValue(str3)).build())));
        } catch (Exception unused) {
        }
    }

    public void imMessageFailed(String str, long j10, String str2, String str3, int i10, String str4) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.IM).setCode(100).setTakes((int) j10).setDescription(Utils.getStringValue(str2)).setExtra(Any.pack(ApmProtos.ImTypeProto.newBuilder().setName(Utils.getStringValue(str)).setHost(Utils.getStringValue(str3)).setPort(i10).setServerIp(Utils.getStringValue(str4)).build())));
        } catch (Exception unused) {
        }
    }

    public void imMessageSuccess(String str, long j10, String str2, int i10, String str3) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.IM).setCode(200).setTakes((int) j10).setExtra(Any.pack(ApmProtos.ImTypeProto.newBuilder().setName(Utils.getStringValue(str)).setHost(Utils.getStringValue(str2)).setPort(i10).setServerIp(Utils.getStringValue(str3)).build())));
        } catch (Exception unused) {
        }
    }

    public void openTime(long j10) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.OPEN_TIME).setTakes((int) j10).setExtra(Any.pack(ApmProtos.OpenTimeTypeProto.newBuilder().build())));
        } catch (Exception unused) {
        }
    }

    public void setEnable(boolean z10) {
        StatConfig.setApmEnable(z10);
    }

    public void setLogEnable(boolean z10) {
        StatConfig.setApmLogEnable(z10);
    }

    public void socketFailed(String str, int i10, String str2, Throwable th, long j10) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.SOCKET).setTakes((int) j10).setCode(100).setDescription(Utils.getExceptionValue(th)).setExtra(Any.pack(ApmProtos.SocketTypeProto.newBuilder().setHost(Utils.getStringValue(str)).setPort(i10).setServerIp(Utils.getStringValue(str2)).build())));
        } catch (Exception unused) {
        }
    }

    public void socketSuccess(String str, int i10, String str2, long j10) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.SOCKET).setCode(200).setTakes((int) j10).setExtra(Any.pack(ApmProtos.SocketTypeProto.newBuilder().setHost(Utils.getStringValue(str)).setPort(i10).setServerIp(Utils.getStringValue(str2)).build())));
        } catch (Exception unused) {
        }
    }

    public void webLoadFailed(String str, long j10, int i10, String str2) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.WEB).setTakes((int) j10).setCode(i10).setDescription(Utils.getStringValue(str2)).setExtra(Any.pack(ApmProtos.WebTypeProto.newBuilder().setUrl(Utils.getStringValue(str)).build())));
        } catch (Exception unused) {
        }
    }

    public void webLoadSuccess(String str, long j10) {
        try {
            upload(ApmProtos.Request.newBuilder().setType(ApmProtos.Type.WEB).setTakes((int) j10).setCode(200).setExtra(Any.pack(ApmProtos.WebTypeProto.newBuilder().setUrl(Utils.getStringValue(str)).build())));
        } catch (Exception unused) {
        }
    }

    private Apm() {
    }
}
