package com.google.geo.type;

import com.google.protobuf.MessageOrBuilder;
import com.google.type.LatLng;
import com.google.type.LatLngOrBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ViewportOrBuilder extends MessageOrBuilder {
    LatLng getHigh();

    LatLngOrBuilder getHighOrBuilder();

    LatLng getLow();

    LatLngOrBuilder getLowOrBuilder();

    boolean hasHigh();

    boolean hasLow();
}
