package x7;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import u7.e;

/* compiled from: LocationsProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f54563a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54564b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f54565c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54566d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f54567e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54568f;

    /* renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f54569g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54570h;

    /* renamed from: i, reason: collision with root package name */
    public static final Descriptors.Descriptor f54571i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f54572j;

    /* renamed from: k, reason: collision with root package name */
    public static Descriptors.FileDescriptor f54573k = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/cloud/location/locations.proto\u0012\u0015google.cloud.location\u001a\u001cgoogle/api/annotations.proto\u001a\u0019google/protobuf/any.proto\u001a\u0017google/api/client.proto\"[\n\u0014ListLocationsRequest\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006filter\u0018\u0002 \u0001(\t\u0012\u0011\n\tpage_size\u0018\u0003 \u0001(\u0005\u0012\u0012\n\npage_token\u0018\u0004 \u0001(\t\"d\n\u0015ListLocationsResponse\u00122\n\tlocations\u0018\u0001 \u0003(\u000b2\u001f.google.cloud.location.Location\u0012\u0017\n\u000fnext_page_token\u0018\u0002 \u0001(\t\"\"\n\u0012GetLocationRequest\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\"×\u0001\n\bLocation\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0013\n\u000blocation_id\u0018\u0004 \u0001(\t\u0012\u0014\n\fdisplay_name\u0018\u0005 \u0001(\t\u0012;\n\u0006labels\u0018\u0002 \u0003(\u000b2+.google.cloud.location.Location.LabelsEntry\u0012&\n\bmetadata\u0018\u0003 \u0001(\u000b2\u0014.google.protobuf.Any\u001a-\n\u000bLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u00012¤\u0003\n\tLocations\u0012«\u0001\n\rListLocations\u0012+.google.cloud.location.ListLocationsRequest\u001a,.google.cloud.location.ListLocationsResponse\"?\u0082Óä\u0093\u00029\u0012\u0014/v1/{name=locations}Z!\u0012\u001f/v1/{name=projects/*}/locations\u0012\u009e\u0001\n\u000bGetLocation\u0012).google.cloud.location.GetLocationRequest\u001a\u001f.google.cloud.location.Location\"C\u0082Óä\u0093\u0002=\u0012\u0016/v1/{name=locations/*}Z#\u0012!/v1/{name=projects/*/locations/*}\u001aHÊA\u0014cloud.googleapis.comÒA.https://www.googleapis.com/auth/cloud-platformBo\n\u0019com.google.cloud.locationB\u000eLocationsProtoP\u0001Z=google.golang.org/genproto/googleapis/cloud/location;locationø\u0001\u0001b\u0006proto3"}, new Descriptors.FileDescriptor[]{u7.a.a(), AnyProto.getDescriptor(), e.a()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f54563a = descriptor;
        f54564b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Name", "Filter", "PageSize", "PageToken"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f54565c = descriptor2;
        f54566d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Locations", "NextPageToken"});
        Descriptors.Descriptor descriptor3 = a().getMessageTypes().get(2);
        f54567e = descriptor3;
        f54568f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Name"});
        Descriptors.Descriptor descriptor4 = a().getMessageTypes().get(3);
        f54569g = descriptor4;
        f54570h = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Name", "LocationId", "DisplayName", "Labels", "Metadata"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        f54571i = descriptor5;
        f54572j = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Key", "Value"});
        ExtensionRegistry newInstance = ExtensionRegistry.newInstance();
        newInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) e.f53873b);
        newInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) u7.a.f53829a);
        newInstance.add((GeneratedMessage.GeneratedExtension<?, ?>) e.f53874c);
        Descriptors.FileDescriptor.internalUpdateFileDescriptor(f54573k, newInstance);
        u7.a.a();
        AnyProto.getDescriptor();
        e.a();
    }

    public static Descriptors.FileDescriptor a() {
        return f54573k;
    }
}
