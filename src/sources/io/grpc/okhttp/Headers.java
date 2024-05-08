package io.grpc.okhttp;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.o;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class Headers {
    public static final Header CONTENT_TYPE_HEADER;
    public static final Header HTTPS_SCHEME_HEADER;
    public static final Header HTTP_SCHEME_HEADER;
    public static final Header METHOD_GET_HEADER;
    public static final Header METHOD_HEADER;
    public static final Header TE_HEADER;

    static {
        ByteString byteString = Header.TARGET_SCHEME;
        HTTPS_SCHEME_HEADER = new Header(byteString, "https");
        HTTP_SCHEME_HEADER = new Header(byteString, "http");
        ByteString byteString2 = Header.TARGET_METHOD;
        METHOD_HEADER = new Header(byteString2, "POST");
        METHOD_GET_HEADER = new Header(byteString2, "GET");
        CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), GrpcUtil.CONTENT_TYPE_GRPC);
        TE_HEADER = new Header("te", GrpcUtil.TE_TRAILERS);
    }

    private static List<Header> addMetadata(List<Header> list, Metadata metadata) {
        byte[][] http2Headers = TransportFrameUtil.toHttp2Headers(metadata);
        for (int i10 = 0; i10 < http2Headers.length; i10 += 2) {
            ByteString of = ByteString.of(http2Headers[i10]);
            if (of.size() != 0 && of.getByte(0) != 58) {
                list.add(new Header(of, ByteString.of(http2Headers[i10 + 1])));
            }
        }
        return list;
    }

    public static List<Header> createHttpResponseHeaders(int i10, String str, Metadata metadata) {
        ArrayList arrayList = new ArrayList(InternalMetadata.headerCount(metadata) + 2);
        arrayList.add(new Header(Header.RESPONSE_STATUS, "" + i10));
        arrayList.add(new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), str));
        return addMetadata(arrayList, metadata);
    }

    public static List<Header> createRequestHeaders(Metadata metadata, String str, String str2, String str3, boolean z10, boolean z11) {
        o.s(metadata, TTDownloadField.TT_HEADERS);
        o.s(str, "defaultPath");
        o.s(str2, "authority");
        stripNonApplicationHeaders(metadata);
        ArrayList arrayList = new ArrayList(InternalMetadata.headerCount(metadata) + 7);
        if (z11) {
            arrayList.add(HTTP_SCHEME_HEADER);
        } else {
            arrayList.add(HTTPS_SCHEME_HEADER);
        }
        if (z10) {
            arrayList.add(METHOD_GET_HEADER);
        } else {
            arrayList.add(METHOD_HEADER);
        }
        arrayList.add(new Header(Header.TARGET_AUTHORITY, str2));
        arrayList.add(new Header(Header.TARGET_PATH, str));
        arrayList.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), str3));
        arrayList.add(CONTENT_TYPE_HEADER);
        arrayList.add(TE_HEADER);
        return addMetadata(arrayList, metadata);
    }

    public static List<Header> createResponseHeaders(Metadata metadata) {
        stripNonApplicationHeaders(metadata);
        ArrayList arrayList = new ArrayList(InternalMetadata.headerCount(metadata) + 2);
        arrayList.add(new Header(Header.RESPONSE_STATUS, "200"));
        arrayList.add(CONTENT_TYPE_HEADER);
        return addMetadata(arrayList, metadata);
    }

    public static List<Header> createResponseTrailers(Metadata metadata, boolean z10) {
        if (!z10) {
            return createResponseHeaders(metadata);
        }
        stripNonApplicationHeaders(metadata);
        return addMetadata(new ArrayList(InternalMetadata.headerCount(metadata)), metadata);
    }

    private static void stripNonApplicationHeaders(Metadata metadata) {
        metadata.discardAll(GrpcUtil.CONTENT_TYPE_KEY);
        metadata.discardAll(GrpcUtil.TE_HEADER);
        metadata.discardAll(GrpcUtil.USER_AGENT_KEY);
    }
}
