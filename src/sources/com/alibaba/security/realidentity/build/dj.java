package com.alibaba.security.realidentity.build;

import android.text.TextUtils;
import com.alibaba.security.realidentity.oss.common.HttpMethod;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RequestMessage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dj extends dd {

    /* renamed from: a, reason: collision with root package name */
    public URI f3464a;

    /* renamed from: b, reason: collision with root package name */
    public URI f3465b;

    /* renamed from: c, reason: collision with root package name */
    public String f3466c;

    /* renamed from: d, reason: collision with root package name */
    public String f3467d;

    /* renamed from: e, reason: collision with root package name */
    public HttpMethod f3468e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3471h;

    /* renamed from: i, reason: collision with root package name */
    public cj f3472i;

    /* renamed from: l, reason: collision with root package name */
    public String f3475l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f3476m;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3469f = true;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f3470g = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public boolean f3473j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3474k = false;

    private HttpMethod h() {
        return this.f3468e;
    }

    private cj i() {
        return this.f3472i;
    }

    private URI j() {
        return this.f3464a;
    }

    private URI k() {
        return this.f3465b;
    }

    private boolean l() {
        return this.f3473j;
    }

    private String m() {
        return this.f3466c;
    }

    private String n() {
        return this.f3467d;
    }

    private Map<String, String> o() {
        return this.f3470g;
    }

    private String p() {
        return this.f3475l;
    }

    private byte[] q() {
        return this.f3476m;
    }

    private boolean r() {
        return this.f3469f;
    }

    private boolean s() {
        return this.f3474k;
    }

    private boolean t() {
        return this.f3471h;
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ Map a() {
        return super.a();
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ InputStream b() {
        return super.b();
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ long d() {
        return super.d();
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ void e() throws IOException {
        super.e();
    }

    public final String f() {
        OSSUtils.a(this.f3464a != null, "Service haven't been set!");
        String host = this.f3464a.getHost();
        String scheme = this.f3464a.getScheme();
        String str = null;
        if (this.f3473j && scheme.equalsIgnoreCase("http")) {
            str = cu.a().a(host);
        } else {
            cd.b("[buildOSSServiceURL], disable httpdns or http is not need httpdns");
        }
        if (str == null) {
            str = host;
        }
        super.a().put(cs.U, host);
        String str2 = scheme + "://" + str;
        String a10 = OSSUtils.a(this.f3470g, "utf-8");
        if (OSSUtils.a(a10)) {
            return str2;
        }
        return str2 + SymbolValues.QUESTION_EN_SYMBOL + a10;
    }

    public final String g() throws Exception {
        String uri;
        OSSUtils.a(this.f3465b != null, "Endpoint haven't been set!");
        String scheme = this.f3465b.getScheme();
        String host = this.f3465b.getHost();
        int port = this.f3465b.getPort();
        String str = null;
        String valueOf = port != -1 ? String.valueOf(port) : null;
        if (TextUtils.isEmpty(host)) {
            String uri2 = this.f3465b.toString();
            cd.b("endpoint url : ".concat(String.valueOf(uri2)));
            host = uri2.substring((scheme + "://").length(), uri2.length());
        }
        cd.b(" scheme : ".concat(String.valueOf(scheme)));
        cd.b(" originHost : ".concat(String.valueOf(host)));
        cd.b(" port : ".concat(String.valueOf(valueOf)));
        if (!TextUtils.isEmpty(this.f3466c)) {
            if (OSSUtils.b(host)) {
                String str2 = this.f3466c + "." + host;
                if (this.f3473j) {
                    str = cu.a().a(str2);
                } else {
                    cd.b("[buildCannonicalURL], disable httpdns");
                }
                super.a(cs.U, str2);
                uri = !TextUtils.isEmpty(str) ? scheme + "://" + str : scheme + "://" + str2;
            } else if (OSSUtils.d(host)) {
                uri = this.f3465b.toString() + "/" + this.f3466c;
            } else {
                uri = this.f3465b.toString();
            }
        } else {
            uri = this.f3465b.toString();
        }
        if (!TextUtils.isEmpty(this.f3467d)) {
            uri = uri + "/" + ct.a(this.f3467d, "utf-8");
        }
        String a10 = OSSUtils.a(this.f3470g, "utf-8");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("request---------------------\n");
        sb2.append("request url=" + uri + "\n");
        sb2.append("request params=" + a10 + "\n");
        for (String str3 : super.a().h()) {
            sb2.append("requestHeader [" + str3 + "]: ");
            sb2.append(super.a().get(str3) + "\n");
        }
        cd.b(sb2.toString());
        if (OSSUtils.a(a10)) {
            return uri;
        }
        return uri + SymbolValues.QUESTION_EN_SYMBOL + a10;
    }

    private void b(URI uri) {
        this.f3465b = uri;
    }

    private void c(String str) {
        this.f3467d = str;
    }

    private void d(String str) {
        this.f3475l = str;
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ void a(long j10) {
        super.a(j10);
    }

    private void b(String str) {
        this.f3466c = str;
    }

    private void c(Map<String, String> map) {
        this.f3470g = map;
    }

    private void d(boolean z10) {
        this.f3471h = z10;
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ void a(InputStream inputStream) {
        super.a(inputStream);
    }

    private void b(boolean z10) {
        this.f3469f = z10;
    }

    private void c(boolean z10) {
        this.f3474k = z10;
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ void a(String str, String str2) {
        super.a(str, str2);
    }

    public final void b(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<CreateBucketConfiguration>");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
        }
        stringBuffer.append("</CreateBucketConfiguration>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = bytes.length;
        super.a(new ByteArrayInputStream(bytes));
        super.a(length);
    }

    @Override // com.alibaba.security.realidentity.build.dd
    public final /* bridge */ /* synthetic */ void a(Map map) {
        super.a((Map<String, String>) map);
    }

    private void a(HttpMethod httpMethod) {
        this.f3468e = httpMethod;
    }

    private void a(cj cjVar) {
        this.f3472i = cjVar;
    }

    private void a(URI uri) {
        this.f3464a = uri;
    }

    private void a(boolean z10) {
        this.f3473j = z10;
    }

    private void a(byte[] bArr) {
        this.f3476m = bArr;
    }

    public final void a(ArrayList<String> arrayList, boolean z10) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<RefererConfiguration>");
        StringBuilder sb2 = new StringBuilder("<AllowEmptyReferer>");
        sb2.append(z10 ? "true" : "false");
        sb2.append("</AllowEmptyReferer>");
        stringBuffer.append(sb2.toString());
        if (arrayList != null && arrayList.size() > 0) {
            stringBuffer.append("<RefererList>");
            Iterator<String> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                stringBuffer.append("<Referer>" + iterator2.next() + "</Referer>");
            }
            stringBuffer.append("</RefererList>");
        }
        stringBuffer.append("</RefererConfiguration>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = bytes.length;
        super.a(new ByteArrayInputStream(bytes));
        super.a(length);
    }

    private void b(String str, String str2) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<BucketLoggingStatus>");
        if (str != null) {
            stringBuffer.append("<LoggingEnabled><TargetBucket>" + str + "</TargetBucket>");
            if (str2 != null) {
                stringBuffer.append("<TargetPrefix>" + str2 + "</TargetPrefix>");
            }
            stringBuffer.append("</LoggingEnabled>");
        }
        stringBuffer.append("</BucketLoggingStatus>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = bytes.length;
        super.a(new ByteArrayInputStream(bytes));
        super.a(length);
    }

    public final void a(ArrayList<dt> arrayList) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<LifecycleConfiguration>");
        Iterator<dt> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            dt next = iterator2.next();
            stringBuffer.append("<Rule>");
            if (next.f3499a != null) {
                stringBuffer.append("<ID>" + next.f3499a + "</ID>");
            }
            if (next.f3500b != null) {
                stringBuffer.append("<Prefix>" + next.f3500b + "</Prefix>");
            }
            StringBuilder sb2 = new StringBuilder("<Status>");
            sb2.append(next.f3501c ? "Enabled" : "Disabled");
            sb2.append("</Status>");
            stringBuffer.append(sb2.toString());
            if (next.f3502d != null) {
                stringBuffer.append("<Days>" + next.f3502d + "</Days>");
            } else if (next.f3503e != null) {
                stringBuffer.append("<Date>" + next.f3503e + "</Date>");
            }
            if (next.f3504f != null) {
                stringBuffer.append("<AbortMultipartUpload><Days>" + next.f3504f + "</Days></AbortMultipartUpload>");
            } else if (next.f3505g != null) {
                stringBuffer.append("<AbortMultipartUpload><Date>" + next.f3504f + "</Date></AbortMultipartUpload>");
            }
            if (next.f3506h != null) {
                stringBuffer.append("<Transition><Days>" + next.f3506h + "</Days><StorageClass>IA</StorageClass></Transition>");
            } else if (next.f3507i != null) {
                stringBuffer.append("<Transition><Date>" + next.f3507i + "</Date><StorageClass>IA</StorageClass></Transition>");
            } else if (next.f3508j != null) {
                stringBuffer.append("<Transition><Days>" + next.f3508j + "</Days><StorageClass>Archive</StorageClass></Transition>");
            } else if (next.f3509k != null) {
                stringBuffer.append("<Transition><Date>" + next.f3509k + "</Date><StorageClass>Archive</StorageClass></Transition>");
            }
            stringBuffer.append("</Rule>");
        }
        stringBuffer.append("</LifecycleConfiguration>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = bytes.length;
        super.a(new ByteArrayInputStream(bytes));
        super.a(length);
    }

    public final byte[] a(List<String> list, boolean z10) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<Delete>");
        if (z10) {
            stringBuffer.append("<Quiet>true</Quiet>");
        } else {
            stringBuffer.append("<Quiet>false</Quiet>");
        }
        for (String str : list) {
            stringBuffer.append("<Object>");
            stringBuffer.append("<Key>");
            stringBuffer.append(str);
            stringBuffer.append("</Key>");
            stringBuffer.append("</Object>");
        }
        stringBuffer.append("</Delete>");
        byte[] bytes = stringBuffer.toString().getBytes("utf-8");
        long length = bytes.length;
        super.a(new ByteArrayInputStream(bytes));
        super.a(length);
        return bytes;
    }
}
