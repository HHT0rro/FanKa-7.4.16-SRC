package com.google.cloud.location;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ListLocationsResponseOrBuilder extends MessageOrBuilder {
    Location getLocations(int i10);

    int getLocationsCount();

    List<Location> getLocationsList();

    LocationOrBuilder getLocationsOrBuilder(int i10);

    List<? extends LocationOrBuilder> getLocationsOrBuilderList();

    String getNextPageToken();

    ByteString getNextPageTokenBytes();
}
