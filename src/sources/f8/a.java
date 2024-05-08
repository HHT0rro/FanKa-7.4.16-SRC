package f8;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import s8.j;

/* compiled from: ViewportProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f49230a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f49231b;

    /* renamed from: c, reason: collision with root package name */
    public static Descriptors.FileDescriptor f49232c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001egoogle/geo/type/viewport.proto\u0012\u000fgoogle.geo.type\u001a\u0018google/type/latlng.proto\"O\n\bViewport\u0012 \n\u0003low\u0018\u0001 \u0001(\u000b2\u0013.google.type.LatLng\u0012!\n\u0004high\u0018\u0002 \u0001(\u000b2\u0013.google.type.LatLngBo\n\u0013com.google.geo.typeB\rViewportProtoP\u0001Z@google.golang.org/genproto/googleapis/geo/type/viewport;viewport¢\u0002\u0004GGTPb\u0006proto3"}, new Descriptors.FileDescriptor[]{j.a()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f49230a = descriptor;
        f49231b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Low", "High"});
        j.a();
    }

    public static Descriptors.FileDescriptor a() {
        return f49232c;
    }
}
