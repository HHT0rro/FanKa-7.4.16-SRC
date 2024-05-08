package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ResourceLocationOrBuilder extends MessageOrBuilder {
    String getCurrentLocations(int i10);

    ByteString getCurrentLocationsBytes(int i10);

    int getCurrentLocationsCount();

    List<String> getCurrentLocationsList();

    String getOriginalLocations(int i10);

    ByteString getOriginalLocationsBytes(int i10);

    int getOriginalLocationsCount();

    List<String> getOriginalLocationsList();
}
