package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.type.PhoneNumber;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface PhoneNumberOrBuilder extends MessageOrBuilder {
    String getE164Number();

    ByteString getE164NumberBytes();

    String getExtension();

    ByteString getExtensionBytes();

    PhoneNumber.KindCase getKindCase();

    PhoneNumber.ShortCode getShortCode();

    PhoneNumber.ShortCodeOrBuilder getShortCodeOrBuilder();

    boolean hasE164Number();

    boolean hasShortCode();
}
