package com.alibaba.security.realidentity.build;

import android.util.Xml;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: ListMultipartUploadsResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fk extends ft {

    /* renamed from: a, reason: collision with root package name */
    public String f3624a;

    /* renamed from: b, reason: collision with root package name */
    public String f3625b;

    /* renamed from: c, reason: collision with root package name */
    public String f3626c;

    /* renamed from: d, reason: collision with root package name */
    public String f3627d;

    /* renamed from: e, reason: collision with root package name */
    public String f3628e;

    /* renamed from: f, reason: collision with root package name */
    public int f3629f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3630g;

    /* renamed from: h, reason: collision with root package name */
    public String f3631h;

    /* renamed from: i, reason: collision with root package name */
    public String f3632i;

    /* renamed from: j, reason: collision with root package name */
    public List<fp> f3633j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public List<String> f3634k = new ArrayList();

    private void a(String str) {
        this.f3624a = str;
    }

    private String b() {
        return this.f3624a;
    }

    private String c() {
        return this.f3625b;
    }

    private String d() {
        return this.f3628e;
    }

    private String e() {
        return this.f3631h;
    }

    private String f() {
        return this.f3632i;
    }

    private int g() {
        return this.f3629f;
    }

    private boolean h() {
        return this.f3630g;
    }

    private List<fp> i() {
        return this.f3633j;
    }

    private String j() {
        return this.f3626c;
    }

    private String k() {
        return this.f3627d;
    }

    private List<String> l() {
        return this.f3634k;
    }

    private void a(int i10) {
        this.f3629f = i10;
    }

    private void b(String str) {
        this.f3625b = str;
    }

    private void c(String str) {
        this.f3628e = str;
    }

    private void d(String str) {
        this.f3631h = str;
    }

    private void e(String str) {
        this.f3632i = str;
    }

    private void f(String str) {
        this.f3626c = str;
    }

    private void g(String str) {
        this.f3627d = str;
    }

    private void h(String str) {
        this.f3634k.add(str);
    }

    private void a(boolean z10) {
        this.f3630g = z10;
    }

    private void b(List<String> list) {
        this.f3634k.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f3634k.addAll(list);
    }

    private void a(List<fp> list) {
        this.f3633j.clear();
        if (list.isEmpty()) {
            return;
        }
        this.f3633j.addAll(list);
    }

    private void a(fp fpVar) {
        this.f3633j.add(fpVar);
    }

    private fk a(dk dkVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(dkVar.b(), "utf-8");
        int eventType = newPullParser.getEventType();
        fp fpVar = null;
        boolean z10 = false;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    this.f3624a = newPullParser.nextText();
                } else if ("Delimiter".equals(name)) {
                    this.f3626c = newPullParser.nextText();
                } else if ("Prefix".equals(name)) {
                    if (z10) {
                        String nextText = newPullParser.nextText();
                        if (!OSSUtils.a(nextText)) {
                            this.f3634k.add(nextText);
                        }
                    } else {
                        this.f3627d = newPullParser.nextText();
                    }
                } else if ("MaxUploads".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText2)) {
                        this.f3629f = Integer.valueOf(nextText2).intValue();
                    }
                } else if ("IsTruncated".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText3)) {
                        this.f3630g = Boolean.valueOf(nextText3).booleanValue();
                    }
                } else if ("KeyMarker".equals(name)) {
                    this.f3625b = newPullParser.nextText();
                } else if ("UploadIdMarker".equals(name)) {
                    this.f3628e = newPullParser.nextText();
                } else if ("NextKeyMarker".equals(name)) {
                    this.f3631h = newPullParser.nextText();
                } else if ("NextUploadIdMarker".equals(name)) {
                    this.f3632i = newPullParser.nextText();
                } else if ("Upload".equals(name)) {
                    fpVar = new fp();
                } else if ("Key".equals(name)) {
                    fpVar.f3666a = newPullParser.nextText();
                } else if ("UploadId".equals(name)) {
                    fpVar.f3667b = newPullParser.nextText();
                } else if ("Initiated".equals(name)) {
                    fpVar.f3669d = cr.b(newPullParser.nextText());
                } else if (dy.f3535b.equals(name)) {
                    fpVar.f3668c = newPullParser.nextText();
                } else if ("CommonPrefixes".equals(name)) {
                    z10 = true;
                }
            } else if (eventType == 3) {
                if ("Upload".equals(newPullParser.getName())) {
                    arrayList.add(fpVar);
                } else if ("CommonPrefixes".equals(newPullParser.getName())) {
                    z10 = false;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            this.f3633j.clear();
            if (!arrayList.isEmpty()) {
                this.f3633j.addAll(arrayList);
            }
        }
        return this;
    }
}
