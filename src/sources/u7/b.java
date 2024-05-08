package u7;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

/* compiled from: AuthProto.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors.Descriptor f53834a;

    /* renamed from: b, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53835b;

    /* renamed from: c, reason: collision with root package name */
    public static final Descriptors.Descriptor f53836c;

    /* renamed from: d, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53837d;

    /* renamed from: e, reason: collision with root package name */
    public static final Descriptors.Descriptor f53838e;

    /* renamed from: f, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53839f;

    /* renamed from: g, reason: collision with root package name */
    public static final Descriptors.Descriptor f53840g;

    /* renamed from: h, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53841h;

    /* renamed from: i, reason: collision with root package name */
    public static final Descriptors.Descriptor f53842i;

    /* renamed from: j, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53843j;

    /* renamed from: k, reason: collision with root package name */
    public static final Descriptors.Descriptor f53844k;

    /* renamed from: l, reason: collision with root package name */
    public static final GeneratedMessageV3.FieldAccessorTable f53845l;

    /* renamed from: m, reason: collision with root package name */
    public static Descriptors.FileDescriptor f53846m = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015google/api/auth.proto\u0012\ngoogle.api\"l\n\u000eAuthentication\u0012-\n\u0005rules\u0018\u0003 \u0003(\u000b2\u001e.google.api.AuthenticationRule\u0012+\n\tproviders\u0018\u0004 \u0003(\u000b2\u0018.google.api.AuthProvider\"©\u0001\n\u0012AuthenticationRule\u0012\u0010\n\bselector\u0018\u0001 \u0001(\t\u0012,\n\u0005oauth\u0018\u0002 \u0001(\u000b2\u001d.google.api.OAuthRequirements\u0012 \n\u0018allow_without_credential\u0018\u0005 \u0001(\b\u00121\n\frequirements\u0018\u0007 \u0003(\u000b2\u001b.google.api.AuthRequirement\"L\n\u000bJwtLocation\u0012\u0010\n\u0006header\u0018\u0001 \u0001(\tH\u0000\u0012\u000f\n\u0005query\u0018\u0002 \u0001(\tH\u0000\u0012\u0014\n\fvalue_prefix\u0018\u0003 \u0001(\tB\u0004\n\u0002in\"\u009a\u0001\n\fAuthProvider\u0012\n\n\u0002id\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006issuer\u0018\u0002 \u0001(\t\u0012\u0010\n\bjwks_uri\u0018\u0003 \u0001(\t\u0012\u0011\n\taudiences\u0018\u0004 \u0001(\t\u0012\u0019\n\u0011authorization_url\u0018\u0005 \u0001(\t\u0012.\n\rjwt_locations\u0018\u0006 \u0003(\u000b2\u0017.google.api.JwtLocation\"-\n\u0011OAuthRequirements\u0012\u0018\n\u0010canonical_scopes\u0018\u0001 \u0001(\t\"9\n\u000fAuthRequirement\u0012\u0013\n\u000bprovider_id\u0018\u0001 \u0001(\t\u0012\u0011\n\taudiences\u0018\u0002 \u0001(\tBk\n\u000ecom.google.apiB\tAuthProtoP\u0001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\u0002\u0004GAPIb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f53834a = descriptor;
        f53835b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"Rules", "Providers"});
        Descriptors.Descriptor descriptor2 = a().getMessageTypes().get(1);
        f53836c = descriptor2;
        f53837d = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Selector", "Oauth", "AllowWithoutCredential", "Requirements"});
        Descriptors.Descriptor descriptor3 = a().getMessageTypes().get(2);
        f53838e = descriptor3;
        f53839f = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Header", "Query", "ValuePrefix", "In"});
        Descriptors.Descriptor descriptor4 = a().getMessageTypes().get(3);
        f53840g = descriptor4;
        f53841h = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Id", "Issuer", "JwksUri", "Audiences", "AuthorizationUrl", "JwtLocations"});
        Descriptors.Descriptor descriptor5 = a().getMessageTypes().get(4);
        f53842i = descriptor5;
        f53843j = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"CanonicalScopes"});
        Descriptors.Descriptor descriptor6 = a().getMessageTypes().get(5);
        f53844k = descriptor6;
        f53845l = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"ProviderId", "Audiences"});
    }

    public static Descriptors.FileDescriptor a() {
        return f53846m;
    }
}
