package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: QuotaProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53980a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53981b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53982c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53983d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53984e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53985f;

    /* renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f53986g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53987h;

    /* renamed from: i, reason: collision with root package name */
    public static final Descriptors.Descriptor f53988i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53989j;

    /* renamed from: k, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53990k = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016google/api/quota.proto\u0012\ngoogle.api\"]\n\u0005Quota\u0012&\n\u0006limits\u0018\u0003 \u0003(\u000b2\u0016.google.api.QuotaLimit\u0012,\n\fmetric_rules\u0018\u0004 \u0003(\u000b2\u0016.google.api.MetricRule\"\u0091\u0001\n\nMetricRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012=\n\fmetric_costs\u0018\u0002 \u0003(\u000b2'.google.api.MetricRule.MetricCostsEntry\u001a2\n\u0010MetricCostsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0003:\u00028\u0001\"\u0095\u0002\n\nQuotaLimit\u0012\f\n\u0004name\u0018\u0006 \u0001(\t\u0012\u0013\n\u000bdescription\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_limit\u0018\u0003 \u0001(\u0003\u0012\u0011\n\tmax_limit\u0018\u0004 \u0001(\u0003\u0012\u0011\n\tfree_tier\u0018\u0007 \u0001(\u0003\u0012\u0010\n\bduration\u0018\u0005 \u0001(\t\u0012\u000e\n\u0006metric\u0018\b \u0001(\t\u0012\f\n\u0004unit\u0018\t \u0001(\t\u00122\n\u0006values\u0018\n \u0003(\u000b2\".google.api.QuotaLimit.ValuesEntry\u0012\u0014\n\fdisplay_name\u0018\f \u0001(\t\u001a-\n\u000bValuesEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0003:\u00028\u0001Bl\n\u000ecom.google.apiB\nQuotaProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53980a = descriptor;
        f53981b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Limits", "MetricRules"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53982c = descriptor2;
        f53983d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "MetricCosts"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        f53984e = descriptor3;
        f53985f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor4 = a().getMessageTypes().get(2);
        f53986g = descriptor4;
        f53987h = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Name", "Description", "DefaultLimit", "MaxLimit", "FreeTier", "Duration", "Metric", "Unit", "Values", "DisplayName"});
        Descriptors.Descriptor descriptor5 = descriptor4.getNestedTypes().get(0);
        f53988i = descriptor5;
        f53989j = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Key", "Value"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53990k;
    }
}
