package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AuthRequestModel extends BaseGrpcRequestModel {

    @NotNull
    private final String appPackage;

    @Nullable
    private final String clientGuid;

    @Nullable
    private final String clientVersion;

    @Nullable
    private final Integer deviceType;

    @Nullable
    private final String language;
    private final int pushPermission;

    @NotNull
    private final String ticket;

    public /* synthetic */ AuthRequestModel(String str, String str2, String str3, Integer num, String str4, String str5, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? "Finka0a" : str5, i10);
    }

    @NotNull
    public final String getAppPackage() {
        return this.appPackage;
    }

    @Nullable
    public final String getClientGuid() {
        return this.clientGuid;
    }

    @Nullable
    public final String getClientVersion() {
        return this.clientVersion;
    }

    @Nullable
    public final Integer getDeviceType() {
        return this.deviceType;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Override // com.cupidapp.live.base.grpc.BaseGrpcRequestModel
    @NotNull
    public CuConnectorOuterClass.MessageType getMessageType() {
        return CuConnectorOuterClass.MessageType.Auth;
    }

    public final int getPushPermission() {
        return this.pushPermission;
    }

    @NotNull
    public final String getTicket() {
        return this.ticket;
    }

    public AuthRequestModel(@NotNull String ticket, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @NotNull String appPackage, int i10) {
        kotlin.jvm.internal.s.i(ticket, "ticket");
        kotlin.jvm.internal.s.i(appPackage, "appPackage");
        this.ticket = ticket;
        this.clientVersion = str;
        this.clientGuid = str2;
        this.deviceType = num;
        this.language = str3;
        this.appPackage = appPackage;
        this.pushPermission = i10;
    }
}
