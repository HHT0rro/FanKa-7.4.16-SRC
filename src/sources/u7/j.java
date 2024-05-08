package u7;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.TimestampProto;

/* compiled from: DistributionProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53905a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53906b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53907c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53908d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53909e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53910f;

    /* renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f53911g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53912h;

    /* renamed from: i, reason: collision with root package name */
    public static final Descriptors.Descriptor f53913i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53914j;

    /* renamed from: k, reason: collision with root package name */
    public static final Descriptors.Descriptor f53915k;

    /* renamed from: l, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53916l;

    /* renamed from: m, reason: collision with root package name */
    public static final Descriptors.Descriptor f53917m;

    /* renamed from: n, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53918n;

    /* renamed from: o, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53919o = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dgoogle/api/distribution.proto\u0012\ngoogle.api\u001a\u0019google/protobuf/any.proto\u001a\u001fgoogle/protobuf/timestamp.proto\"Ù\u0006\n\fDistribution\u0012\r\n\u0005count\u0018\u0001 \u0001(\u0003\u0012\f\n\u0004mean\u0018\u0002 \u0001(\u0001\u0012 \n\u0018sum_of_squared_deviation\u0018\u0003 \u0001(\u0001\u0012-\n\u0005range\u0018\u0004 \u0001(\u000b2\u001e.google.api.Distribution.Range\u0012>\n\u000ebucket_options\u0018\u0006 \u0001(\u000b2&.google.api.Distribution.BucketOptions\u0012\u0015\n\rbucket_counts\u0018\u0007 \u0003(\u0003\u00124\n\texemplars\u0018\n \u0003(\u000b2!.google.api.Distribution.Exemplar\u001a!\n\u0005Range\u0012\u000b\n\u0003min\u0018\u0001 \u0001(\u0001\u0012\u000b\n\u0003max\u0018\u0002 \u0001(\u0001\u001aµ\u0003\n\rBucketOptions\u0012G\n\u000elinear_buckets\u0018\u0001 \u0001(\u000b2-.google.api.Distribution.BucketOptions.LinearH\u0000\u0012Q\n\u0013exponential_buckets\u0018\u0002 \u0001(\u000b22.google.api.Distribution.BucketOptions.ExponentialH\u0000\u0012K\n\u0010explicit_buckets\u0018\u0003 \u0001(\u000b2/.google.api.Distribution.BucketOptions.ExplicitH\u0000\u001aC\n\u0006Linear\u0012\u001a\n\u0012num_finite_buckets\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005width\u0018\u0002 \u0001(\u0001\u0012\u000e\n\u0006offset\u0018\u0003 \u0001(\u0001\u001aO\n\u000bExponential\u0012\u001a\n\u0012num_finite_buckets\u0018\u0001 \u0001(\u0005\u0012\u0015\n\rgrowth_factor\u0018\u0002 \u0001(\u0001\u0012\r\n\u0005scale\u0018\u0003 \u0001(\u0001\u001a\u001a\n\bExplicit\u0012\u000e\n\u0006bounds\u0018\u0001 \u0003(\u0001B\t\n\u0007options\u001as\n\bExemplar\u0012\r\n\u0005value\u0018\u0001 \u0001(\u0001\u0012-\n\ttimestamp\u0018\u0002 \u0001(\u000b2\u001a.google.protobuf.Timestamp\u0012)\n\u000battachments\u0018\u0003 \u0003(\u000b2\u0014.google.protobuf.AnyBq\n\u000ecom.google.apiB\u0011DistributionProtoP\u0001ZCgoogle.golang.org/genproto/googleapis/api/distribution;distribution¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor(), TimestampProto.getDescriptor()});

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53905a = descriptor;
        f53906b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Count", "Mean", "SumOfSquaredDeviation", "Range", "BucketOptions", "BucketCounts", "Exemplars"});
        Descriptors.Descriptor descriptor2 = descriptor.getNestedTypes().get(0);
        f53907c = descriptor2;
        f53908d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Min", "Max"});
        Descriptors.Descriptor descriptor3 = descriptor.getNestedTypes().get(1);
        f53909e = descriptor3;
        f53910f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"LinearBuckets", "ExponentialBuckets", "ExplicitBuckets", "Options"});
        Descriptors.Descriptor descriptor4 = descriptor3.getNestedTypes().get(0);
        f53911g = descriptor4;
        f53912h = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"NumFiniteBuckets", "Width", "Offset"});
        Descriptors.Descriptor descriptor5 = descriptor3.getNestedTypes().get(1);
        f53913i = descriptor5;
        f53914j = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"NumFiniteBuckets", "GrowthFactor", "Scale"});
        Descriptors.Descriptor descriptor6 = descriptor3.getNestedTypes().get(2);
        f53915k = descriptor6;
        f53916l = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"Bounds"});
        Descriptors.Descriptor descriptor7 = descriptor.getNestedTypes().get(2);
        f53917m = descriptor7;
        f53918n = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"Value", "Timestamp", "Attachments"});
        AnyProto.getDescriptor();
        TimestampProto.getDescriptor();
    }

    public static Descriptors.FileDescriptor a() {
        return f53919o;
    }
}
