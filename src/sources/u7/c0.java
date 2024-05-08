package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: SystemParameterProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53855a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53856b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53857c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53858d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53859e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53860f;

    /* renamed from: g, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53861g = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!google/api/system_parameter.proto\u0012\ngoogle.api\"B\n\u0010SystemParameters\u0012.\n\u0005rules\u0018\u0001 \u0003(\u000b2\u001f.google.api.SystemParameterRule\"X\n\u0013SystemParameterRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012/\n\nparameters\u0018\u0002 \u0003(\u000b2\u001b.google.api.SystemParameter\"Q\n\u000fSystemParameter\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0013\n\u000bhttp_header\u0018\u0002 \u0001(\t\u0012\u001b\n\u0013url_query_parameter\u0018\u0003 \u0001(\tBv\n\u000ecom.google.apiB\u0014SystemParameterProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53855a = descriptor;
        f53856b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Rules"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53857c = descriptor2;
        f53858d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "Parameters"});
        Descriptors.Descriptor descriptor3 = a().getMessageTypes().get(2);
        f53859e = descriptor3;
        f53860f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Name", "HttpHeader", "UrlQueryParameter"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53861g;
    }
}
