package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AuthProviderOrBuilder extends MessageOrBuilder {
    String getAudiences();

    ByteString getAudiencesBytes();

    String getAuthorizationUrl();

    ByteString getAuthorizationUrlBytes();

    String getId();

    ByteString getIdBytes();

    String getIssuer();

    ByteString getIssuerBytes();

    String getJwksUri();

    ByteString getJwksUriBytes();

    JwtLocation getJwtLocations(int i10);

    int getJwtLocationsCount();

    List<JwtLocation> getJwtLocationsList();

    JwtLocationOrBuilder getJwtLocationsOrBuilder(int i10);

    List<? extends JwtLocationOrBuilder> getJwtLocationsOrBuilderList();
}
