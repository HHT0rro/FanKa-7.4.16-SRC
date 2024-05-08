package s8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: PostalAddressProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53669a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53670b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53671c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n google/type/postal_address.proto\u0012\u000bgoogle.type\"ý\u0001\n\rPostalAddress\u0012\u0010\n\brevision\u0018\u0001 \u0001(\u0005\u0012\u0013\n\u000bregion_code\u0018\u0002 \u0001(\t\u0012\u0015\n\rlanguage_code\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bpostal_code\u0018\u0004 \u0001(\t\u0012\u0014\n\fsorting_code\u0018\u0005 \u0001(\t\u0012\u001b\n\u0013administrative_area\u0018\u0006 \u0001(\t\u0012\u0010\n\blocality\u0018\u0007 \u0001(\t\u0012\u0013\n\u000bsublocality\u0018\b \u0001(\t\u0012\u0015\n\raddress_lines\u0018\t \u0003(\t\u0012\u0012\n\nrecipients\u0018\n \u0003(\t\u0012\u0014\n\forganization\u0018\u000b \u0001(\tBx\n\u000fcom.google.typeB\u0012PostalAddressProtoP\u0001ZFgoogle.golang.org/genproto/googleapis/type/postaladdress;postaladdressø\u0001\u0001¢\u0002\u0003GTPb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53669a = descriptor;
        f53670b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Revision", "RegionCode", "LanguageCode", "PostalCode", "SortingCode", "AdministrativeArea", "Locality", "Sublocality", "AddressLines", "Recipients", "Organization"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53671c;
    }
}
