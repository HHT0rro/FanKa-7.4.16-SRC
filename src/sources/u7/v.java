package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.StructProto;

/* compiled from: MonitoredResourceProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53964a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53965b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53966c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53967d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53968e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53969f;

    /* renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f53970g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53971h;

    /* renamed from: i, reason: collision with root package name */
    public static final Descriptors.Descriptor f53972i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53973j;

    /* renamed from: k, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53974k = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/api/monitored_resource.proto\u0012\ngoogle.api\u001a\u0016google/api/label.proto\u001a\u001dgoogle/api/launch_stage.proto\u001a\u001cgoogle/protobuf/struct.proto\"À\u0001\n\u001bMonitoredResourceDescriptor\u0012\f\n\u0004name\u0018\u0005 \u0001(\t\u0012\f\n\u0004type\u0018\u0001 \u0001(\t\u0012\u0014\n\fdisplay_name\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bdescription\u0018\u0003 \u0001(\t\u0012+\n\u0006labels\u0018\u0004 \u0003(\u000b2\u001b.google.api.LabelDescriptor\u0012-\n\flaunch_stage\u0018\u0007 \u0001(\u000e2\u0017.google.api.LaunchStage\"\u008b\u0001\n\u0011MonitoredResource\u0012\f\n\u0004type\u0018\u0001 \u0001(\t\u00129\n\u0006labels\u0018\u0002 \u0003(\u000b2).google.api.MonitoredResource.LabelsEntry\u001a-\n\u000bLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"Ê\u0001\n\u0019MonitoredResourceMetadata\u0012.\n\rsystem_labels\u0018\u0001 \u0001(\u000b2\u0017.google.protobuf.Struct\u0012J\n\u000buser_labels\u0018\u0002 \u0003(\u000b25.google.api.MonitoredResourceMetadata.UserLabelsEntry\u001a1\n\u000fUserLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001By\n\u000ecom.google.apiB\u0016MonitoredResourceProtoP\u0001ZCgoogle.golang.org/genproto/googleapis/api/monitoredres;monitoredresø\u0001\u0001¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{q.a(), r.a(), StructProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53964a = descriptor;
        f53965b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Name", "Type", "DisplayName", "Description", "Labels", "LaunchStage"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53966c = descriptor2;
        f53967d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Type", "Labels"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        f53968e = descriptor3;
        f53969f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor4 = a().getMessageTypes().get(2);
        f53970g = descriptor4;
        f53971h = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"SystemLabels", "UserLabels"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        f53972i = descriptor5;
        f53973j = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Key", "Value"});
        q.a();
        r.a();
        StructProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53974k;
    }
}
