package r8;

import com.alibaba.security.realidentity.build.cs;
import com.alipay.sdk.packet.e;
import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DurationProto;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.StructProto;
import com.google.protobuf.TimestampProto;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* compiled from: AttributeContextProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53301a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53302b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53303c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53304d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53305e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53306f;

    /* renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f53307g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53308h;

    /* renamed from: i, reason: collision with root package name */
    public static final Descriptors.Descriptor f53309i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53310j;

    /* renamed from: k, reason: collision with root package name */
    public static final Descriptors.Descriptor f53311k;

    /* renamed from: l, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53312l;

    /* renamed from: m, reason: collision with root package name */
    public static final Descriptors.Descriptor f53313m;

    /* renamed from: n, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53314n;

    /* renamed from: o, reason: collision with root package name */
    public static final Descriptors.Descriptor f53315o;

    /* renamed from: p, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53316p;

    /* renamed from: q, reason: collision with root package name */
    public static final Descriptors.Descriptor f53317q;

    /* renamed from: r, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53318r;

    /* renamed from: s, reason: collision with root package name */
    public static final Descriptors.Descriptor f53319s;

    /* renamed from: t, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53320t;

    /* renamed from: u, reason: collision with root package name */
    public static final Descriptors.Descriptor f53321u;

    /* renamed from: v, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53322v;

    /* renamed from: w, reason: collision with root package name */
    public static final Descriptors.Descriptor f53323w;

    /* renamed from: x, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53324x;

    /* renamed from: y, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53325y = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n*google/rpc/context/attribute_context.proto\u0012\u0012google.rpc.context\u001a\u0019google/protobuf/any.proto\u001a\u001egoogle/protobuf/duration.proto\u001a\u001cgoogle/protobuf/struct.proto\u001a\u001fgoogle/protobuf/timestamp.proto\"\u0083\u0010\n\u0010AttributeContext\u00129\n\u0006origin\u0018\u0007 \u0001(\u000b2).google.rpc.context.AttributeContext.Peer\u00129\n\u0006source\u0018\u0001 \u0001(\u000b2).google.rpc.context.AttributeContext.Peer\u0012>\n\u000bdestination\u0018\u0002 \u0001(\u000b2).google.rpc.context.AttributeContext.Peer\u0012=\n\u0007request\u0018\u0003 \u0001(\u000b2,.google.rpc.context.AttributeContext.Request\u0012?\n\bresponse\u0018\u0004 \u0001(\u000b2-.google.rpc.context.AttributeContext.Response\u0012?\n\bresource\u0018\u0005 \u0001(\u000b2-.google.rpc.context.AttributeContext.Resource\u00125\n\u0003api\u0018\u0006 \u0001(\u000b2(.google.rpc.context.AttributeContext.Api\u0012(\n\nextensions\u0018\b \u0003(\u000b2\u0014.google.protobuf.Any\u001a¾\u0001\n\u0004Peer\u0012\n\n\u0002ip\u0018\u0001 \u0001(\t\u0012\f\n\u0004port\u0018\u0002 \u0001(\u0003\u0012E\n\u0006labels\u0018\u0006 \u0003(\u000b25.google.rpc.context.AttributeContext.Peer.LabelsEntry\u0012\u0011\n\tprincipal\u0018\u0007 \u0001(\t\u0012\u0013\n\u000bregion_code\u0018\b \u0001(\t\u001a-\n\u000bLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001aL\n\u0003Api\u0012\u000f\n\u0007service\u0018\u0001 \u0001(\t\u0012\u0011\n\toperation\u0018\u0002 \u0001(\t\u0012\u0010\n\bprotocol\u0018\u0003 \u0001(\t\u0012\u000f\n\u0007version\u0018\u0004 \u0001(\t\u001a\u007f\n\u0004Auth\u0012\u0011\n\tprincipal\u0018\u0001 \u0001(\t\u0012\u0011\n\taudiences\u0018\u0002 \u0003(\t\u0012\u0011\n\tpresenter\u0018\u0003 \u0001(\t\u0012'\n\u0006claims\u0018\u0004 \u0001(\u000b2\u0017.google.protobuf.Struct\u0012\u0015\n\raccess_levels\u0018\u0005 \u0003(\t\u001aï\u0002\n\u0007Request\u0012\n\n\u0002id\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006method\u0018\u0002 \u0001(\t\u0012J\n\u0007headers\u0018\u0003 \u0003(\u000b29.google.rpc.context.AttributeContext.Request.HeadersEntry\u0012\f\n\u0004path\u0018\u0004 \u0001(\t\u0012\f\n\u0004host\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006scheme\u0018\u0006 \u0001(\t\u0012\r\n\u0005query\u0018\u0007 \u0001(\t\u0012(\n\u0004time\u0018\t \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012\f\n\u0004size\u0018\n \u0001(\u0003\u0012\u0010\n\bprotocol\u0018\u000b \u0001(\t\u0012\u000e\n\u0006reason\u0018\f \u0001(\t\u00127\n\u0004auth\u0018\r \u0001(\u000b2).google.rpc.context.AttributeContext.Auth\u001a.\n\fHeadersEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001a\u0081\u0002\n\bResponse\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0003\u0012\f\n\u0004size\u0018\u0002 \u0001(\u0003\u0012K\n\u0007headers\u0018\u0003 \u0003(\u000b2:.google.rpc.context.AttributeContext.Response.HeadersEntry\u0012(\n\u0004time\u0018\u0004 \u0001(\u000b2\u001a.google.protobuf.Timestamp\u00122\n\u000fbackend_latency\u0018\u0005 \u0001(\u000b2\u0019.google.protobuf.Duration\u001a.\n\fHeadersEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001a\u0090\u0004\n\bResource\u0012\u000f\n\u0007service\u0018\u0001 \u0001(\t\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012\f\n\u0004type\u0018\u0003 \u0001(\t\u0012I\n\u0006labels\u0018\u0004 \u0003(\u000b29.google.rpc.context.AttributeContext.Resource.LabelsEntry\u0012\u000b\n\u0003uid\u0018\u0005 \u0001(\t\u0012S\n\u000bannotations\u0018\u0006 \u0003(\u000b2>.google.rpc.context.AttributeContext.Resource.AnnotationsEntry\u0012\u0014\n\fdisplay_name\u0018\u0007 \u0001(\t\u0012/\n\u000bcreate_time\u0018\b \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012/\n\u000bupdate_time\u0018\t \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012/\n\u000bdelete_time\u0018\n \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012\f\n\u0004etag\u0018\u000b \u0001(\t\u0012\u0010\n\blocation\u0018\f \u0001(\t\u001a-\n\u000bLabelsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\u001a2\n\u0010AnnotationsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001B\u008b\u0001\n\u0016com.google.rpc.contextB\u0015AttributeContextProtoP\u0001ZUgoogle.golang.org/genproto/googleapis/rpc/context/attribute_context;attribute_contextø\u0001\u0001b\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor(), DurationProto.getDescriptor(), StructProto.getDescriptor(), TimestampProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53301a = descriptor;
        f53302b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Origin", "Source", "Destination", "Request", "Response", "Resource", "Api", "Extensions"});
        Descriptors.Descriptor descriptor2 = descriptor.getNestedTypes().get(0);
        f53303c = descriptor2;
        f53304d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Ip", "Port", "Labels", "Principal", "RegionCode"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        f53305e = descriptor3;
        f53306f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor4 = descriptor.getNestedTypes().get(1);
        f53307g = descriptor4;
        f53308h = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Service", "Operation", "Protocol", e.f4633e});
        Descriptors.Descriptor descriptor5 = descriptor.getNestedTypes().get(2);
        f53309i = descriptor5;
        f53310j = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Principal", "Audiences", "Presenter", "Claims", "AccessLevels"});
        Descriptors.Descriptor descriptor6 = descriptor.getNestedTypes().get(3);
        f53311k = descriptor6;
        f53312l = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Id", "Method", "Headers", "Path", cs.U, "Scheme", "Query", "Time", "Size", "Protocol", "Reason", "Auth"});
        Descriptors.Descriptor descriptor7 = descriptor6.getNestedTypes().get(0);
        f53313m = descriptor7;
        f53314n = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor8 = descriptor.getNestedTypes().get(4);
        f53315o = descriptor8;
        f53316p = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"Code", "Size", "Headers", "Time", "BackendLatency"});
        Descriptors.Descriptor descriptor9 = descriptor8.getNestedTypes().get(0);
        f53317q = descriptor9;
        f53318r = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor10 = descriptor.getNestedTypes().get(5);
        f53319s = descriptor10;
        f53320t = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"Service", "Name", "Type", "Labels", "Uid", "Annotations", "DisplayName", "CreateTime", "UpdateTime", "DeleteTime", DownloadUtils.ETAG, "Location"});
        Descriptors.Descriptor descriptor11 = descriptor10.getNestedTypes().get(0);
        f53321u = descriptor11;
        f53322v = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor12 = descriptor10.getNestedTypes().get(1);
        f53323w = descriptor12;
        f53324x = new GeneratedMessageV3.FieldAccessorTable(descriptor12, new String[]{"Key", "Value"});
        AnyProto.getDescriptor();
        DurationProto.getDescriptor();
        StructProto.getDescriptor();
        TimestampProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53325y;
    }
}
