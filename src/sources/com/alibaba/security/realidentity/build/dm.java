package com.alibaba.security.realidentity.build;

import android.text.TextUtils;
import android.util.Xml;
import com.alibaba.security.realidentity.oss.ClientException;
import com.alibaba.security.realidentity.oss.ServiceException;
import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import com.alibaba.security.realidentity.oss.model.CannedAccessControlList;
import com.alibaba.security.realidentity.oss.model.Owner;
import com.huawei.quickcard.base.http.ContentType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResponseParsers.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dm {

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a extends cz<dq> {
        private static dq a(dq dqVar) throws Exception {
            return dqVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ dq a(dk dkVar, dq dqVar) throws Exception {
            return dqVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class aa extends cz<ga> {
        private static ga a(ga gaVar) throws Exception {
            return gaVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ ga a(dk dkVar, ga gaVar) throws Exception {
            return gaVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class ab extends cz<gc> {
        private static gc a(gc gcVar) throws Exception {
            return gcVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ gc a(dk dkVar, gc gcVar) throws Exception {
            return gcVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class ad extends cz<gg> {
        private static gg a(gg ggVar) throws Exception {
            return ggVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ gg a(dk dkVar, gg ggVar) throws Exception {
            return ggVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class ae extends cz<gj> {
        private static gj a(gj gjVar) throws Exception {
            return gjVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ gj a(dk dkVar, gj gjVar) throws Exception {
            return gjVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class f extends cz<eb> {
        private static eb a(eb ebVar) throws Exception {
            return ebVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ eb a(dk dkVar, eb ebVar) throws Exception {
            return ebVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class g extends cz<ed> {
        private static ed a(ed edVar) throws Exception {
            return edVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ ed a(dk dkVar, ed edVar) throws Exception {
            return edVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class h extends cz<ef> {
        private static ef a(ef efVar) throws Exception {
            return efVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ ef a(dk dkVar, ef efVar) throws Exception {
            return efVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class j extends cz<ej> {
        private static ej a(ej ejVar) throws Exception {
            return ejVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ ej a(dk dkVar, ej ejVar) throws Exception {
            return ejVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class t extends cz<fe> {
        private static fe a(fe feVar) throws Exception {
            return feVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ fe a(dk dkVar, fe feVar) throws Exception {
            return feVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class z extends cz<fy> {
        private static fy a(fy fyVar) throws Exception {
            return fyVar;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ fy a(dk dkVar, fy fyVar) throws Exception {
            return fyVar;
        }
    }

    private static dx a(InputStream inputStream, dx dxVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LastModified".equals(name)) {
                    dxVar.f3533b = cr.b(newPullParser.nextText());
                } else if ("ETag".equals(name)) {
                    dxVar.f3532a = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return dxVar;
    }

    private static /* synthetic */ ew b(InputStream inputStream, ew ewVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    ewVar.f3577b = CannedAccessControlList.parseACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    ewVar.f3576a.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    ewVar.f3576a.setDisplayName(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return ewVar;
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class ag extends cz<gp> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ gp a(dk dkVar, gp gpVar) throws Exception {
            gp gpVar2 = gpVar;
            gpVar2.f3753a = dm.a((String) dkVar.a().get("ETag"));
            return gpVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static gp a2(dk dkVar, gp gpVar) throws Exception {
            gpVar.f3753a = dm.a((String) dkVar.a().get("ETag"));
            return gpVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class r extends cz<fa> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ fa a(dk dkVar, fa faVar) throws Exception {
            fa faVar2 = faVar;
            faVar2.f3589a = (String) dkVar.a().get(cc.f3277f);
            return faVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static fa a2(dk dkVar, fa faVar) throws Exception {
            faVar.f3589a = (String) dkVar.a().get(cc.f3277f);
            return faVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class s extends cz<fc> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* bridge */ /* synthetic */ fc a(dk dkVar, fc fcVar) throws Exception {
            fc fcVar2 = fcVar;
            fcVar2.f3592a = dm.a(fcVar2.f3697m);
            return fcVar2;
        }

        private static fc a(fc fcVar) throws Exception {
            fcVar.f3592a = dm.a(fcVar.f3697m);
            return fcVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class af extends cz<gn> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ gn a(dk dkVar, gn gnVar) throws Exception {
            gn gnVar2 = gnVar;
            String string = dkVar.f3477a.body().string();
            if (!TextUtils.isEmpty(string)) {
                gnVar2.f3745a = string;
            }
            return gnVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static gn a2(dk dkVar, gn gnVar) throws Exception {
            String string = dkVar.f3477a.body().string();
            if (!TextUtils.isEmpty(string)) {
                gnVar.f3745a = string;
            }
            return gnVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class e extends cz<dz> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ dz a(dk dkVar, dz dzVar) throws Exception {
            dz dzVar2 = dzVar;
            if (dzVar2.f3697m.containsKey("Location")) {
                dzVar2.f3540a = dzVar2.f3697m.get("Location");
            }
            return dzVar2;
        }

        private static dz a(dz dzVar) throws Exception {
            if (dzVar.f3697m.containsKey("Location")) {
                dzVar.f3540a = dzVar.f3697m.get("Location");
            }
            return dzVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class b extends cz<ds> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ ds a(dk dkVar, ds dsVar) throws Exception {
            ds dsVar2 = dsVar;
            String str = (String) dkVar.a().get(cc.H);
            if (str != null) {
                dsVar2.f3497a = Long.valueOf(str).longValue();
            }
            dsVar2.f3498b = (String) dkVar.a().get(cc.I);
            return dsVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static ds a2(dk dkVar, ds dsVar) throws IOException {
            String str = (String) dkVar.a().get(cc.H);
            if (str != null) {
                dsVar.f3497a = Long.valueOf(str).longValue();
            }
            dsVar.f3498b = (String) dkVar.a().get(cc.I);
            return dsVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class ac extends cz<ge> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ ge a(dk dkVar, ge geVar) throws Exception {
            ge geVar2 = geVar;
            geVar2.f3728a = dm.a((String) dkVar.a().get("ETag"));
            String string = dkVar.f3477a.body().string();
            if (!TextUtils.isEmpty(string)) {
                geVar2.f3729b = string;
            }
            return geVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static ge a2(dk dkVar, ge geVar) throws IOException {
            geVar.f3728a = dm.a((String) dkVar.a().get("ETag"));
            String string = dkVar.f3477a.body().string();
            if (!TextUtils.isEmpty(string)) {
                geVar.f3729b = string;
            }
            return geVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class i extends cz<eh> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ eh a(dk dkVar, eh ehVar) throws Exception {
            eh ehVar2 = ehVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2 && "Key".equals(newPullParser.getName())) {
                    String nextText = newPullParser.nextText();
                    if (ehVar2.f3547a == null) {
                        ehVar2.f3547a = new ArrayList();
                    }
                    ehVar2.f3547a.add(nextText);
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return ehVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static eh a2(dk dkVar, eh ehVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2 && "Key".equals(newPullParser.getName())) {
                    String nextText = newPullParser.nextText();
                    if (ehVar.f3547a == null) {
                        ehVar.f3547a = new ArrayList();
                    }
                    ehVar.f3547a.add(nextText);
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return ehVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class o extends cz<eu> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ eu a(dk dkVar, eu euVar) throws Exception {
            eu euVar2 = euVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2 && "Referer".equals(newPullParser.getName())) {
                    String nextText = newPullParser.nextText();
                    if (euVar2.f3572a == null) {
                        euVar2.f3572a = new ArrayList<>();
                    }
                    euVar2.f3572a.add(nextText);
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return euVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static eu a2(dk dkVar, eu euVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2 && "Referer".equals(newPullParser.getName())) {
                    String nextText = newPullParser.nextText();
                    if (euVar.f3572a == null) {
                        euVar.f3572a = new ArrayList<>();
                    }
                    euVar.f3572a.add(nextText);
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return euVar;
        }
    }

    private static fo a(InputStream inputStream, fo foVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        fw fwVar = null;
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3 && "Part".equals(newPullParser.getName())) {
                    arrayList.add(fwVar);
                }
            } else {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    foVar.f3657a = newPullParser.nextText();
                } else if ("Key".equals(name)) {
                    foVar.f3658b = newPullParser.nextText();
                } else if ("UploadId".equals(name)) {
                    foVar.f3659c = newPullParser.nextText();
                } else if ("PartNumberMarker".equals(name)) {
                    String nextText = newPullParser.nextText();
                    if (!OSSUtils.a(nextText)) {
                        foVar.f3661e = Integer.parseInt(nextText);
                    }
                } else if ("NextPartNumberMarker".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText2)) {
                        foVar.f3664h = Integer.parseInt(nextText2);
                    }
                } else if ("MaxParts".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText3)) {
                        foVar.f3660d = Integer.parseInt(nextText3);
                    }
                } else if ("IsTruncated".equals(name)) {
                    String nextText4 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText4)) {
                        foVar.f3663g = Boolean.valueOf(nextText4).booleanValue();
                    }
                } else if (dy.f3535b.equals(name)) {
                    foVar.f3662f = newPullParser.nextText();
                } else if ("Part".equals(name)) {
                    fwVar = new fw();
                } else if ("PartNumber".equals(name)) {
                    String nextText5 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText5)) {
                        fwVar.f3707a = Integer.valueOf(nextText5).intValue();
                    }
                } else if ("LastModified".equals(name)) {
                    fwVar.f3708b = cr.b(newPullParser.nextText());
                } else if ("ETag".equals(name)) {
                    fwVar.f3709c = newPullParser.nextText();
                } else if ("Size".equals(name)) {
                    String nextText6 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText6)) {
                        fwVar.f3710d = Long.valueOf(nextText6).longValue();
                    }
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            foVar.f3665i.clear();
            if (!arrayList.isEmpty()) {
                foVar.f3665i.addAll(arrayList);
            }
        }
        return foVar;
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class d extends cz<dx> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ dx a(dk dkVar, dx dxVar) throws Exception {
            dx dxVar2 = dxVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("LastModified".equals(name)) {
                        dxVar2.f3533b = cr.b(newPullParser.nextText());
                    } else if ("ETag".equals(name)) {
                        dxVar2.f3532a = newPullParser.nextText();
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return dxVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static dx a2(dk dkVar, dx dxVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("LastModified".equals(name)) {
                        dxVar.f3533b = cr.b(newPullParser.nextText());
                    } else if ("ETag".equals(name)) {
                        dxVar.f3532a = newPullParser.nextText();
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return dxVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class n extends cz<es> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ es a(dk dkVar, es esVar) throws Exception {
            es esVar2 = esVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("LoggingEnabled".equals(name)) {
                        esVar2.f3570c = true;
                    } else if ("TargetBucket".equals(name)) {
                        esVar2.f3568a = newPullParser.nextText();
                    } else if ("TargetPrefix".equals(name)) {
                        esVar2.f3569b = newPullParser.nextText();
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return esVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static es a2(dk dkVar, es esVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("LoggingEnabled".equals(name)) {
                        esVar.f3570c = true;
                    } else if ("TargetBucket".equals(name)) {
                        esVar.f3568a = newPullParser.nextText();
                    } else if ("TargetPrefix".equals(name)) {
                        esVar.f3569b = newPullParser.nextText();
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return esVar;
        }
    }

    private static /* synthetic */ dx b(InputStream inputStream, dx dxVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LastModified".equals(name)) {
                    dxVar.f3533b = cr.b(newPullParser.nextText());
                } else if ("ETag".equals(name)) {
                    dxVar.f3532a = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return dxVar;
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class k extends cz<em> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ em a(dk dkVar, em emVar) throws Exception {
            em emVar2 = emVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Grant".equals(name)) {
                        emVar2.f3562b = CannedAccessControlList.parseACL(newPullParser.nextText());
                    } else if ("ID".equals(name)) {
                        emVar2.f3561a.setId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        emVar2.f3561a.setDisplayName(newPullParser.nextText());
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return emVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static em a2(dk dkVar, em emVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Grant".equals(name)) {
                        emVar.f3562b = CannedAccessControlList.parseACL(newPullParser.nextText());
                    } else if ("ID".equals(name)) {
                        emVar.f3561a.setId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        emVar.f3561a.setDisplayName(newPullParser.nextText());
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return emVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class p extends cz<ew> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ ew a(dk dkVar, ew ewVar) throws Exception {
            ew ewVar2 = ewVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Grant".equals(name)) {
                        ewVar2.f3577b = CannedAccessControlList.parseACL(newPullParser.nextText());
                    } else if ("ID".equals(name)) {
                        ewVar2.f3576a.setId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        ewVar2.f3576a.setDisplayName(newPullParser.nextText());
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return ewVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static ew a2(dk dkVar, ew ewVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Grant".equals(name)) {
                        ewVar.f3577b = CannedAccessControlList.parseACL(newPullParser.nextText());
                    } else if ("ID".equals(name)) {
                        ewVar.f3576a.setId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        ewVar.f3576a.setDisplayName(newPullParser.nextText());
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return ewVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class q extends cz<ey> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ ey a(dk dkVar, ey eyVar) throws Exception {
            ey eyVar2 = eyVar;
            eyVar2.f3584a = dm.a(eyVar2.f3697m);
            eyVar2.f3585b = dkVar.d();
            if (dkVar.f3478b.f3471h) {
                eyVar2.f3586c = new db(dkVar.b(), new cq(), dkVar.d(), eyVar2.f3699o.longValue(), eyVar2.f3698n);
            } else {
                eyVar2.f3586c = dkVar.b();
            }
            return eyVar2;
        }

        @Override // com.alibaba.security.realidentity.build.cz
        public final boolean a() {
            return false;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static ey a2(dk dkVar, ey eyVar) throws Exception {
            eyVar.f3584a = dm.a(eyVar.f3697m);
            eyVar.f3585b = dkVar.d();
            if (dkVar.f3478b.f3471h) {
                eyVar.f3586c = new db(dkVar.b(), new cq(), dkVar.d(), eyVar.f3699o.longValue(), eyVar.f3698n);
            } else {
                eyVar.f3586c = dkVar.b();
            }
            return eyVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class u extends cz<fg> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ fg a(dk dkVar, fg fgVar) throws Exception {
            fg fgVar2 = fgVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Bucket".equals(name)) {
                        fgVar2.f3602a = newPullParser.nextText();
                    } else if ("Key".equals(name)) {
                        fgVar2.f3603b = newPullParser.nextText();
                    } else if ("UploadId".equals(name)) {
                        fgVar2.f3604c = newPullParser.nextText();
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return fgVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static fg a2(dk dkVar, fg fgVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Bucket".equals(name)) {
                        fgVar.f3602a = newPullParser.nextText();
                    } else if ("Key".equals(name)) {
                        fgVar.f3603b = newPullParser.nextText();
                    } else if ("UploadId".equals(name)) {
                        fgVar.f3604c = newPullParser.nextText();
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return fgVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class c extends cz<dv> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ dv a(dk dkVar, dv dvVar) throws Exception {
            dv dvVar2 = dvVar;
            if (((String) dkVar.a().get("Content-Type")).equals(ContentType.XML)) {
                InputStream b4 = dkVar.b();
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(b4, "utf-8");
                int eventType = newPullParser.getEventType();
                while (eventType != 1) {
                    if (eventType == 2) {
                        String name = newPullParser.getName();
                        if ("Location".equals(name)) {
                            dvVar2.f3519c = newPullParser.nextText();
                        } else if ("Bucket".equals(name)) {
                            dvVar2.f3517a = newPullParser.nextText();
                        } else if ("Key".equals(name)) {
                            dvVar2.f3518b = newPullParser.nextText();
                        } else if ("ETag".equals(name)) {
                            dvVar2.f3520d = newPullParser.nextText();
                        }
                    }
                    eventType = newPullParser.next();
                    if (eventType == 4) {
                        eventType = newPullParser.next();
                    }
                }
            } else {
                String string = dkVar.f3477a.body().string();
                if (!TextUtils.isEmpty(string)) {
                    dvVar2.f3521e = string;
                }
            }
            return dvVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static dv a2(dk dkVar, dv dvVar) throws Exception {
            if (((String) dkVar.a().get("Content-Type")).equals(ContentType.XML)) {
                InputStream b4 = dkVar.b();
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(b4, "utf-8");
                int eventType = newPullParser.getEventType();
                while (eventType != 1) {
                    if (eventType == 2) {
                        String name = newPullParser.getName();
                        if ("Location".equals(name)) {
                            dvVar.f3519c = newPullParser.nextText();
                        } else if ("Bucket".equals(name)) {
                            dvVar.f3517a = newPullParser.nextText();
                        } else if ("Key".equals(name)) {
                            dvVar.f3518b = newPullParser.nextText();
                        } else if ("ETag".equals(name)) {
                            dvVar.f3520d = newPullParser.nextText();
                        }
                    }
                    eventType = newPullParser.next();
                    if (eventType == 4) {
                        eventType = newPullParser.next();
                    }
                }
            } else {
                String string = dkVar.f3477a.body().string();
                if (!TextUtils.isEmpty(string)) {
                    dvVar.f3521e = string;
                }
            }
            return dvVar;
        }
    }

    private static /* synthetic */ eo b(InputStream inputStream, eo eoVar) throws Exception {
        String name;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        fr frVar = null;
        Owner owner = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name2 = newPullParser.getName();
                if (name2 != null) {
                    if ("Owner".equals(name2)) {
                        owner = new Owner();
                    } else if ("ID".equals(name2)) {
                        if (owner != null) {
                            owner.setId(newPullParser.nextText());
                        }
                    } else if ("DisplayName".equals(name2)) {
                        if (owner != null) {
                            owner.setDisplayName(newPullParser.nextText());
                        }
                    } else if ("Bucket".equals(name2)) {
                        frVar = new fr();
                    } else if ("CreationDate".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3681c = cr.b(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3683e = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3684f = newPullParser.nextText();
                        }
                    } else if ("Location".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3682d = newPullParser.nextText();
                        }
                    } else if ("Name".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3679a = newPullParser.nextText();
                        }
                    } else if (dy.f3535b.equals(name2)) {
                        if (frVar != null) {
                            frVar.f3685g = newPullParser.nextText();
                        }
                    } else if ("Grant".equals(name2) && frVar != null) {
                        frVar.f3686h = CannedAccessControlList.parseACL(newPullParser.nextText());
                    }
                }
            } else if (eventType == 3 && (name = newPullParser.getName()) != null) {
                if ("Bucket".equals(name)) {
                    if (frVar != null) {
                        eoVar.f3564a = frVar;
                    }
                } else if ("Owner".equals(name) && frVar != null) {
                    frVar.f3680b = owner;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return eoVar;
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class l extends cz<eo> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ eo a(dk dkVar, eo eoVar) throws Exception {
            String name;
            eo eoVar2 = eoVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            fr frVar = null;
            Owner owner = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name2 = newPullParser.getName();
                    if (name2 != null) {
                        if ("Owner".equals(name2)) {
                            owner = new Owner();
                        } else if ("ID".equals(name2)) {
                            if (owner != null) {
                                owner.setId(newPullParser.nextText());
                            }
                        } else if ("DisplayName".equals(name2)) {
                            if (owner != null) {
                                owner.setDisplayName(newPullParser.nextText());
                            }
                        } else if ("Bucket".equals(name2)) {
                            frVar = new fr();
                        } else if ("CreationDate".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3681c = cr.b(newPullParser.nextText());
                            }
                        } else if ("ExtranetEndpoint".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3683e = newPullParser.nextText();
                            }
                        } else if ("IntranetEndpoint".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3684f = newPullParser.nextText();
                            }
                        } else if ("Location".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3682d = newPullParser.nextText();
                            }
                        } else if ("Name".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3679a = newPullParser.nextText();
                            }
                        } else if (dy.f3535b.equals(name2)) {
                            if (frVar != null) {
                                frVar.f3685g = newPullParser.nextText();
                            }
                        } else if ("Grant".equals(name2) && frVar != null) {
                            frVar.f3686h = CannedAccessControlList.parseACL(newPullParser.nextText());
                        }
                    }
                } else if (eventType == 3 && (name = newPullParser.getName()) != null) {
                    if ("Bucket".equals(name)) {
                        if (frVar != null) {
                            eoVar2.f3564a = frVar;
                        }
                    } else if ("Owner".equals(name) && frVar != null) {
                        frVar.f3680b = owner;
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return eoVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static eo a2(dk dkVar, eo eoVar) throws Exception {
            String name;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            fr frVar = null;
            Owner owner = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name2 = newPullParser.getName();
                    if (name2 != null) {
                        if ("Owner".equals(name2)) {
                            owner = new Owner();
                        } else if ("ID".equals(name2)) {
                            if (owner != null) {
                                owner.setId(newPullParser.nextText());
                            }
                        } else if ("DisplayName".equals(name2)) {
                            if (owner != null) {
                                owner.setDisplayName(newPullParser.nextText());
                            }
                        } else if ("Bucket".equals(name2)) {
                            frVar = new fr();
                        } else if ("CreationDate".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3681c = cr.b(newPullParser.nextText());
                            }
                        } else if ("ExtranetEndpoint".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3683e = newPullParser.nextText();
                            }
                        } else if ("IntranetEndpoint".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3684f = newPullParser.nextText();
                            }
                        } else if ("Location".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3682d = newPullParser.nextText();
                            }
                        } else if ("Name".equals(name2)) {
                            if (frVar != null) {
                                frVar.f3679a = newPullParser.nextText();
                            }
                        } else if (dy.f3535b.equals(name2)) {
                            if (frVar != null) {
                                frVar.f3685g = newPullParser.nextText();
                            }
                        } else if ("Grant".equals(name2) && frVar != null) {
                            frVar.f3686h = CannedAccessControlList.parseACL(newPullParser.nextText());
                        }
                    }
                } else if (eventType == 3 && (name = newPullParser.getName()) != null) {
                    if ("Bucket".equals(name)) {
                        if (frVar != null) {
                            eoVar.f3564a = frVar;
                        }
                    } else if ("Owner".equals(name) && frVar != null) {
                        frVar.f3680b = owner;
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return eoVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class v extends cz<fi> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ fi a(dk dkVar, fi fiVar) throws Exception {
            fi fiVar2 = fiVar;
            InputStream b4 = dkVar.b();
            fiVar2.f3616h.clear();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            fr frVar = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "Bucket".equals(newPullParser.getName()) && frVar != null) {
                        fiVar2.f3616h.add(frVar);
                    }
                } else {
                    String name = newPullParser.getName();
                    if (name != null) {
                        if ("Prefix".equals(name)) {
                            fiVar2.f3609a = newPullParser.nextText();
                        } else if ("Marker".equals(name)) {
                            fiVar2.f3610b = newPullParser.nextText();
                        } else if ("MaxKeys".equals(name)) {
                            String nextText = newPullParser.nextText();
                            if (nextText != null) {
                                fiVar2.f3611c = Integer.valueOf(nextText).intValue();
                            }
                        } else if ("IsTruncated".equals(name)) {
                            String nextText2 = newPullParser.nextText();
                            if (nextText2 != null) {
                                fiVar2.f3612d = Boolean.valueOf(nextText2).booleanValue();
                            }
                        } else if ("NextMarker".equals(name)) {
                            fiVar2.f3613e = newPullParser.nextText();
                        } else if ("ID".equals(name)) {
                            fiVar2.f3614f = newPullParser.nextText();
                        } else if ("DisplayName".equals(name)) {
                            fiVar2.f3615g = newPullParser.nextText();
                        } else if ("Bucket".equals(name)) {
                            frVar = new fr();
                        } else if ("CreationDate".equals(name)) {
                            if (frVar != null) {
                                frVar.f3681c = cr.b(newPullParser.nextText());
                            }
                        } else if ("ExtranetEndpoint".equals(name)) {
                            if (frVar != null) {
                                frVar.f3683e = newPullParser.nextText();
                            }
                        } else if ("IntranetEndpoint".equals(name)) {
                            if (frVar != null) {
                                frVar.f3684f = newPullParser.nextText();
                            }
                        } else if ("Location".equals(name)) {
                            if (frVar != null) {
                                frVar.f3682d = newPullParser.nextText();
                            }
                        } else if ("Name".equals(name)) {
                            if (frVar != null) {
                                frVar.f3679a = newPullParser.nextText();
                            }
                        } else if (dy.f3535b.equals(name) && frVar != null) {
                            frVar.f3685g = newPullParser.nextText();
                        }
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return fiVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static fi a2(dk dkVar, fi fiVar) throws Exception {
            InputStream b4 = dkVar.b();
            fiVar.f3616h.clear();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            fr frVar = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "Bucket".equals(newPullParser.getName()) && frVar != null) {
                        fiVar.f3616h.add(frVar);
                    }
                } else {
                    String name = newPullParser.getName();
                    if (name != null) {
                        if ("Prefix".equals(name)) {
                            fiVar.f3609a = newPullParser.nextText();
                        } else if ("Marker".equals(name)) {
                            fiVar.f3610b = newPullParser.nextText();
                        } else if ("MaxKeys".equals(name)) {
                            String nextText = newPullParser.nextText();
                            if (nextText != null) {
                                fiVar.f3611c = Integer.valueOf(nextText).intValue();
                            }
                        } else if ("IsTruncated".equals(name)) {
                            String nextText2 = newPullParser.nextText();
                            if (nextText2 != null) {
                                fiVar.f3612d = Boolean.valueOf(nextText2).booleanValue();
                            }
                        } else if ("NextMarker".equals(name)) {
                            fiVar.f3613e = newPullParser.nextText();
                        } else if ("ID".equals(name)) {
                            fiVar.f3614f = newPullParser.nextText();
                        } else if ("DisplayName".equals(name)) {
                            fiVar.f3615g = newPullParser.nextText();
                        } else if ("Bucket".equals(name)) {
                            frVar = new fr();
                        } else if ("CreationDate".equals(name)) {
                            if (frVar != null) {
                                frVar.f3681c = cr.b(newPullParser.nextText());
                            }
                        } else if ("ExtranetEndpoint".equals(name)) {
                            if (frVar != null) {
                                frVar.f3683e = newPullParser.nextText();
                            }
                        } else if ("IntranetEndpoint".equals(name)) {
                            if (frVar != null) {
                                frVar.f3684f = newPullParser.nextText();
                            }
                        } else if ("Location".equals(name)) {
                            if (frVar != null) {
                                frVar.f3682d = newPullParser.nextText();
                            }
                        } else if ("Name".equals(name)) {
                            if (frVar != null) {
                                frVar.f3679a = newPullParser.nextText();
                            }
                        } else if (dy.f3535b.equals(name) && frVar != null) {
                            frVar.f3685g = newPullParser.nextText();
                        }
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return fiVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class m extends cz<eq> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ eq a(dk dkVar, eq eqVar) throws Exception {
            eq eqVar2 = eqVar;
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            dt dtVar = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Rule".equals(name)) {
                        dtVar = new dt();
                    } else if ("ID".equals(name)) {
                        dtVar.f3499a = newPullParser.nextText();
                    } else if ("Prefix".equals(name)) {
                        dtVar.f3500b = newPullParser.nextText();
                    } else if ("Status".equals(name)) {
                        if ("Enabled".equals(newPullParser.nextText())) {
                            dtVar.f3501c = true;
                        } else {
                            dtVar.f3501c = false;
                        }
                    } else if ("Expiration".equals(name)) {
                        z10 = true;
                    } else if ("AbortMultipartUpload".equals(name)) {
                        z11 = true;
                    } else if ("Transition".equals(name)) {
                        z12 = true;
                    } else if ("Days".equals(name)) {
                        str = newPullParser.nextText();
                        if (dtVar != null) {
                            if (z10) {
                                dtVar.f3502d = str;
                            } else if (z11) {
                                dtVar.f3504f = str;
                            } else if (z12 && str3 != null) {
                                if ("IA".equals(str3)) {
                                    dtVar.f3506h = str;
                                } else if ("Archive".equals(str3)) {
                                    dtVar.f3508j = str;
                                }
                            }
                        }
                    } else if ("Date".equals(name)) {
                        str2 = newPullParser.nextText();
                        if (dtVar != null) {
                            if (z10) {
                                dtVar.f3503e = str2;
                            } else if (z11) {
                                dtVar.f3505g = str2;
                            } else if (z12 && str3 != null) {
                                if ("IA".equals(str3)) {
                                    dtVar.f3507i = str2;
                                } else if ("Archive".equals(str3)) {
                                    dtVar.f3509k = str2;
                                }
                            }
                        }
                    } else if (dy.f3535b.equals(name)) {
                        str3 = newPullParser.nextText();
                        if (dtVar != null) {
                            if ("IA".equals(str3)) {
                                dtVar.f3506h = str;
                                dtVar.f3507i = str2;
                            } else if ("Archive".equals(str3)) {
                                dtVar.f3508j = str2;
                                dtVar.f3509k = str2;
                            }
                        }
                    }
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if ("Rule".equals(name2)) {
                        if (eqVar2.f3566a == null) {
                            eqVar2.f3566a = new ArrayList<>();
                        }
                        eqVar2.f3566a.add(dtVar);
                    } else if ("Expiration".equals(name2)) {
                        z10 = false;
                    } else if ("AbortMultipartUpload".equals(name2)) {
                        z11 = false;
                    } else if ("Transition".equals(name2)) {
                        z12 = false;
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return eqVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static eq a2(dk dkVar, eq eqVar) throws Exception {
            InputStream b4 = dkVar.b();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            dt dtVar = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Rule".equals(name)) {
                        dtVar = new dt();
                    } else if ("ID".equals(name)) {
                        dtVar.f3499a = newPullParser.nextText();
                    } else if ("Prefix".equals(name)) {
                        dtVar.f3500b = newPullParser.nextText();
                    } else if ("Status".equals(name)) {
                        if ("Enabled".equals(newPullParser.nextText())) {
                            dtVar.f3501c = true;
                        } else {
                            dtVar.f3501c = false;
                        }
                    } else if ("Expiration".equals(name)) {
                        z10 = true;
                    } else if ("AbortMultipartUpload".equals(name)) {
                        z11 = true;
                    } else if ("Transition".equals(name)) {
                        z12 = true;
                    } else if ("Days".equals(name)) {
                        str = newPullParser.nextText();
                        if (dtVar != null) {
                            if (z10) {
                                dtVar.f3502d = str;
                            } else if (z11) {
                                dtVar.f3504f = str;
                            } else if (z12 && str3 != null) {
                                if ("IA".equals(str3)) {
                                    dtVar.f3506h = str;
                                } else if ("Archive".equals(str3)) {
                                    dtVar.f3508j = str;
                                }
                            }
                        }
                    } else if ("Date".equals(name)) {
                        str2 = newPullParser.nextText();
                        if (dtVar != null) {
                            if (z10) {
                                dtVar.f3503e = str2;
                            } else if (z11) {
                                dtVar.f3505g = str2;
                            } else if (z12 && str3 != null) {
                                if ("IA".equals(str3)) {
                                    dtVar.f3507i = str2;
                                } else if ("Archive".equals(str3)) {
                                    dtVar.f3509k = str2;
                                }
                            }
                        }
                    } else if (dy.f3535b.equals(name)) {
                        str3 = newPullParser.nextText();
                        if (dtVar != null) {
                            if ("IA".equals(str3)) {
                                dtVar.f3506h = str;
                                dtVar.f3507i = str2;
                            } else if ("Archive".equals(str3)) {
                                dtVar.f3508j = str2;
                                dtVar.f3509k = str2;
                            }
                        }
                    }
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if ("Rule".equals(name2)) {
                        if (eqVar.f3566a == null) {
                            eqVar.f3566a = new ArrayList<>();
                        }
                        eqVar.f3566a.add(dtVar);
                    } else if ("Expiration".equals(name2)) {
                        z10 = false;
                    } else if ("AbortMultipartUpload".equals(name2)) {
                        z11 = false;
                    } else if ("Transition".equals(name2)) {
                        z12 = false;
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return eqVar;
        }
    }

    private static /* synthetic */ em b(InputStream inputStream, em emVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    emVar.f3562b = CannedAccessControlList.parseACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    emVar.f3561a.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    emVar.f3561a.setDisplayName(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return emVar;
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class w extends cz<fk> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ fk a(dk dkVar, fk fkVar) throws Exception {
            fk fkVar2 = fkVar;
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
                        fkVar2.f3624a = newPullParser.nextText();
                    } else if ("Delimiter".equals(name)) {
                        fkVar2.f3626c = newPullParser.nextText();
                    } else if ("Prefix".equals(name)) {
                        if (z10) {
                            String nextText = newPullParser.nextText();
                            if (!OSSUtils.a(nextText)) {
                                fkVar2.f3634k.add(nextText);
                            }
                        } else {
                            fkVar2.f3627d = newPullParser.nextText();
                        }
                    } else if ("MaxUploads".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText2)) {
                            fkVar2.f3629f = Integer.valueOf(nextText2).intValue();
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText3 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText3)) {
                            fkVar2.f3630g = Boolean.valueOf(nextText3).booleanValue();
                        }
                    } else if ("KeyMarker".equals(name)) {
                        fkVar2.f3625b = newPullParser.nextText();
                    } else if ("UploadIdMarker".equals(name)) {
                        fkVar2.f3628e = newPullParser.nextText();
                    } else if ("NextKeyMarker".equals(name)) {
                        fkVar2.f3631h = newPullParser.nextText();
                    } else if ("NextUploadIdMarker".equals(name)) {
                        fkVar2.f3632i = newPullParser.nextText();
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
                fkVar2.f3633j.clear();
                if (!arrayList.isEmpty()) {
                    fkVar2.f3633j.addAll(arrayList);
                }
            }
            return fkVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static fk a2(dk dkVar, fk fkVar) throws Exception {
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
                        fkVar.f3624a = newPullParser.nextText();
                    } else if ("Delimiter".equals(name)) {
                        fkVar.f3626c = newPullParser.nextText();
                    } else if ("Prefix".equals(name)) {
                        if (z10) {
                            String nextText = newPullParser.nextText();
                            if (!OSSUtils.a(nextText)) {
                                fkVar.f3634k.add(nextText);
                            }
                        } else {
                            fkVar.f3627d = newPullParser.nextText();
                        }
                    } else if ("MaxUploads".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText2)) {
                            fkVar.f3629f = Integer.valueOf(nextText2).intValue();
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText3 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText3)) {
                            fkVar.f3630g = Boolean.valueOf(nextText3).booleanValue();
                        }
                    } else if ("KeyMarker".equals(name)) {
                        fkVar.f3625b = newPullParser.nextText();
                    } else if ("UploadIdMarker".equals(name)) {
                        fkVar.f3628e = newPullParser.nextText();
                    } else if ("NextKeyMarker".equals(name)) {
                        fkVar.f3631h = newPullParser.nextText();
                    } else if ("NextUploadIdMarker".equals(name)) {
                        fkVar.f3632i = newPullParser.nextText();
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
                fkVar.f3633j.clear();
                if (!arrayList.isEmpty()) {
                    fkVar.f3633j.addAll(arrayList);
                }
            }
            return fkVar;
        }
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class y extends cz<fo> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ fo a(dk dkVar, fo foVar) throws Exception {
            fo foVar2 = foVar;
            InputStream b4 = dkVar.b();
            ArrayList arrayList = new ArrayList();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            fw fwVar = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "Part".equals(newPullParser.getName())) {
                        arrayList.add(fwVar);
                    }
                } else {
                    String name = newPullParser.getName();
                    if ("Bucket".equals(name)) {
                        foVar2.f3657a = newPullParser.nextText();
                    } else if ("Key".equals(name)) {
                        foVar2.f3658b = newPullParser.nextText();
                    } else if ("UploadId".equals(name)) {
                        foVar2.f3659c = newPullParser.nextText();
                    } else if ("PartNumberMarker".equals(name)) {
                        String nextText = newPullParser.nextText();
                        if (!OSSUtils.a(nextText)) {
                            foVar2.f3661e = Integer.parseInt(nextText);
                        }
                    } else if ("NextPartNumberMarker".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText2)) {
                            foVar2.f3664h = Integer.parseInt(nextText2);
                        }
                    } else if ("MaxParts".equals(name)) {
                        String nextText3 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText3)) {
                            foVar2.f3660d = Integer.parseInt(nextText3);
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText4 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText4)) {
                            foVar2.f3663g = Boolean.valueOf(nextText4).booleanValue();
                        }
                    } else if (dy.f3535b.equals(name)) {
                        foVar2.f3662f = newPullParser.nextText();
                    } else if ("Part".equals(name)) {
                        fwVar = new fw();
                    } else if ("PartNumber".equals(name)) {
                        String nextText5 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText5)) {
                            fwVar.f3707a = Integer.valueOf(nextText5).intValue();
                        }
                    } else if ("LastModified".equals(name)) {
                        fwVar.f3708b = cr.b(newPullParser.nextText());
                    } else if ("ETag".equals(name)) {
                        fwVar.f3709c = newPullParser.nextText();
                    } else if ("Size".equals(name)) {
                        String nextText6 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText6)) {
                            fwVar.f3710d = Long.valueOf(nextText6).longValue();
                        }
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            if (arrayList.size() > 0) {
                foVar2.f3665i.clear();
                if (!arrayList.isEmpty()) {
                    foVar2.f3665i.addAll(arrayList);
                }
            }
            return foVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static fo a2(dk dkVar, fo foVar) throws Exception {
            InputStream b4 = dkVar.b();
            ArrayList arrayList = new ArrayList();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            fw fwVar = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "Part".equals(newPullParser.getName())) {
                        arrayList.add(fwVar);
                    }
                } else {
                    String name = newPullParser.getName();
                    if ("Bucket".equals(name)) {
                        foVar.f3657a = newPullParser.nextText();
                    } else if ("Key".equals(name)) {
                        foVar.f3658b = newPullParser.nextText();
                    } else if ("UploadId".equals(name)) {
                        foVar.f3659c = newPullParser.nextText();
                    } else if ("PartNumberMarker".equals(name)) {
                        String nextText = newPullParser.nextText();
                        if (!OSSUtils.a(nextText)) {
                            foVar.f3661e = Integer.parseInt(nextText);
                        }
                    } else if ("NextPartNumberMarker".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText2)) {
                            foVar.f3664h = Integer.parseInt(nextText2);
                        }
                    } else if ("MaxParts".equals(name)) {
                        String nextText3 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText3)) {
                            foVar.f3660d = Integer.parseInt(nextText3);
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText4 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText4)) {
                            foVar.f3663g = Boolean.valueOf(nextText4).booleanValue();
                        }
                    } else if (dy.f3535b.equals(name)) {
                        foVar.f3662f = newPullParser.nextText();
                    } else if ("Part".equals(name)) {
                        fwVar = new fw();
                    } else if ("PartNumber".equals(name)) {
                        String nextText5 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText5)) {
                            fwVar.f3707a = Integer.valueOf(nextText5).intValue();
                        }
                    } else if ("LastModified".equals(name)) {
                        fwVar.f3708b = cr.b(newPullParser.nextText());
                    } else if ("ETag".equals(name)) {
                        fwVar.f3709c = newPullParser.nextText();
                    } else if ("Size".equals(name)) {
                        String nextText6 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText6)) {
                            fwVar.f3710d = Long.valueOf(nextText6).longValue();
                        }
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            if (arrayList.size() > 0) {
                foVar.f3665i.clear();
                if (!arrayList.isEmpty()) {
                    foVar.f3665i.addAll(arrayList);
                }
            }
            return foVar;
        }
    }

    private static dv a(InputStream inputStream, dv dvVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Location".equals(name)) {
                    dvVar.f3519c = newPullParser.nextText();
                } else if ("Bucket".equals(name)) {
                    dvVar.f3517a = newPullParser.nextText();
                } else if ("Key".equals(name)) {
                    dvVar.f3518b = newPullParser.nextText();
                } else if ("ETag".equals(name)) {
                    dvVar.f3520d = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return dvVar;
    }

    private static /* synthetic */ eu b(InputStream inputStream, eu euVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Referer".equals(newPullParser.getName())) {
                String nextText = newPullParser.nextText();
                if (euVar.f3572a == null) {
                    euVar.f3572a = new ArrayList<>();
                }
                euVar.f3572a.add(nextText);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return euVar;
    }

    /* compiled from: ResponseParsers.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class x extends cz<fm> {
        @Override // com.alibaba.security.realidentity.build.cz
        public final /* synthetic */ fm a(dk dkVar, fm fmVar) throws Exception {
            fm fmVar2 = fmVar;
            InputStream b4 = dkVar.b();
            fmVar2.f3643b.clear();
            fmVar2.f3642a.clear();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            Owner owner = null;
            fs fsVar = null;
            boolean z10 = false;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Name".equals(name)) {
                        fmVar2.f3644c = newPullParser.nextText();
                    } else if ("Prefix".equals(name)) {
                        if (z10) {
                            String nextText = newPullParser.nextText();
                            if (!OSSUtils.a(nextText)) {
                                fmVar2.f3643b.add(nextText);
                            }
                        } else {
                            fmVar2.f3647f = newPullParser.nextText();
                        }
                    } else if ("Marker".equals(name)) {
                        fmVar2.f3648g = newPullParser.nextText();
                    } else if ("Delimiter".equals(name)) {
                        fmVar2.f3650i = newPullParser.nextText();
                    } else if ("EncodingType".equals(name)) {
                        fmVar2.f3651j = newPullParser.nextText();
                    } else if ("MaxKeys".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText2)) {
                            fmVar2.f3649h = Integer.valueOf(nextText2).intValue();
                        }
                    } else if ("NextMarker".equals(name)) {
                        fmVar2.f3645d = newPullParser.nextText();
                    } else if ("IsTruncated".equals(name)) {
                        String nextText3 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText3)) {
                            fmVar2.f3646e = Boolean.valueOf(nextText3).booleanValue();
                        }
                    } else if ("Contents".equals(name)) {
                        fsVar = new fs();
                    } else if ("Key".equals(name)) {
                        fsVar.f3688b = newPullParser.nextText();
                    } else if ("LastModified".equals(name)) {
                        fsVar.f3692f = cr.b(newPullParser.nextText());
                    } else if ("Size".equals(name)) {
                        String nextText4 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText4)) {
                            fsVar.f3691e = Long.valueOf(nextText4).longValue();
                        }
                    } else if ("ETag".equals(name)) {
                        fsVar.f3690d = newPullParser.nextText();
                    } else if ("Type".equals(name)) {
                        fsVar.f3689c = newPullParser.nextText();
                    } else if (dy.f3535b.equals(name)) {
                        fsVar.f3693g = newPullParser.nextText();
                    } else if ("Owner".equals(name)) {
                        owner = new Owner();
                    } else if ("ID".equals(name)) {
                        owner.setId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        owner.setDisplayName(newPullParser.nextText());
                    } else if ("CommonPrefixes".equals(name)) {
                        z10 = true;
                    }
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if ("Owner".equals(newPullParser.getName())) {
                        if (owner != null) {
                            fsVar.f3694h = owner;
                        }
                    } else if ("Contents".equals(name2)) {
                        if (fsVar != null) {
                            fsVar.f3687a = fmVar2.f3644c;
                            fmVar2.f3642a.add(fsVar);
                        }
                    } else if ("CommonPrefixes".equals(name2)) {
                        z10 = false;
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return fmVar2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static fm a2(dk dkVar, fm fmVar) throws Exception {
            InputStream b4 = dkVar.b();
            fmVar.f3643b.clear();
            fmVar.f3642a.clear();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(b4, "utf-8");
            int eventType = newPullParser.getEventType();
            Owner owner = null;
            fs fsVar = null;
            boolean z10 = false;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("Name".equals(name)) {
                        fmVar.f3644c = newPullParser.nextText();
                    } else if ("Prefix".equals(name)) {
                        if (z10) {
                            String nextText = newPullParser.nextText();
                            if (!OSSUtils.a(nextText)) {
                                fmVar.f3643b.add(nextText);
                            }
                        } else {
                            fmVar.f3647f = newPullParser.nextText();
                        }
                    } else if ("Marker".equals(name)) {
                        fmVar.f3648g = newPullParser.nextText();
                    } else if ("Delimiter".equals(name)) {
                        fmVar.f3650i = newPullParser.nextText();
                    } else if ("EncodingType".equals(name)) {
                        fmVar.f3651j = newPullParser.nextText();
                    } else if ("MaxKeys".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText2)) {
                            fmVar.f3649h = Integer.valueOf(nextText2).intValue();
                        }
                    } else if ("NextMarker".equals(name)) {
                        fmVar.f3645d = newPullParser.nextText();
                    } else if ("IsTruncated".equals(name)) {
                        String nextText3 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText3)) {
                            fmVar.f3646e = Boolean.valueOf(nextText3).booleanValue();
                        }
                    } else if ("Contents".equals(name)) {
                        fsVar = new fs();
                    } else if ("Key".equals(name)) {
                        fsVar.f3688b = newPullParser.nextText();
                    } else if ("LastModified".equals(name)) {
                        fsVar.f3692f = cr.b(newPullParser.nextText());
                    } else if ("Size".equals(name)) {
                        String nextText4 = newPullParser.nextText();
                        if (!OSSUtils.a(nextText4)) {
                            fsVar.f3691e = Long.valueOf(nextText4).longValue();
                        }
                    } else if ("ETag".equals(name)) {
                        fsVar.f3690d = newPullParser.nextText();
                    } else if ("Type".equals(name)) {
                        fsVar.f3689c = newPullParser.nextText();
                    } else if (dy.f3535b.equals(name)) {
                        fsVar.f3693g = newPullParser.nextText();
                    } else if ("Owner".equals(name)) {
                        owner = new Owner();
                    } else if ("ID".equals(name)) {
                        owner.setId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        owner.setDisplayName(newPullParser.nextText());
                    } else if ("CommonPrefixes".equals(name)) {
                        z10 = true;
                    }
                } else if (eventType == 3) {
                    String name2 = newPullParser.getName();
                    if ("Owner".equals(newPullParser.getName())) {
                        if (owner != null) {
                            fsVar.f3694h = owner;
                        }
                    } else if ("Contents".equals(name2)) {
                        if (fsVar != null) {
                            fsVar.f3687a = fmVar.f3644c;
                            fmVar.f3642a.add(fsVar);
                        }
                    } else if ("CommonPrefixes".equals(name2)) {
                        z10 = false;
                    }
                }
                eventType = newPullParser.next();
                if (eventType == 4) {
                    eventType = newPullParser.next();
                }
            }
            return fmVar;
        }
    }

    private static /* synthetic */ es b(InputStream inputStream, es esVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LoggingEnabled".equals(name)) {
                    esVar.f3570c = true;
                } else if ("TargetBucket".equals(name)) {
                    esVar.f3568a = newPullParser.nextText();
                } else if ("TargetPrefix".equals(name)) {
                    esVar.f3569b = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return esVar;
    }

    private static fg a(InputStream inputStream, fg fgVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    fgVar.f3602a = newPullParser.nextText();
                } else if ("Key".equals(name)) {
                    fgVar.f3603b = newPullParser.nextText();
                } else if ("UploadId".equals(name)) {
                    fgVar.f3604c = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return fgVar;
    }

    private static /* synthetic */ eq b(InputStream inputStream, eq eqVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        dt dtVar = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Rule".equals(name)) {
                    dtVar = new dt();
                } else if ("ID".equals(name)) {
                    dtVar.f3499a = newPullParser.nextText();
                } else if ("Prefix".equals(name)) {
                    dtVar.f3500b = newPullParser.nextText();
                } else if ("Status".equals(name)) {
                    if ("Enabled".equals(newPullParser.nextText())) {
                        dtVar.f3501c = true;
                    } else {
                        dtVar.f3501c = false;
                    }
                } else if ("Expiration".equals(name)) {
                    z10 = true;
                } else if ("AbortMultipartUpload".equals(name)) {
                    z11 = true;
                } else if ("Transition".equals(name)) {
                    z12 = true;
                } else if ("Days".equals(name)) {
                    str = newPullParser.nextText();
                    if (dtVar != null) {
                        if (z10) {
                            dtVar.f3502d = str;
                        } else if (z11) {
                            dtVar.f3504f = str;
                        } else if (z12 && str3 != null) {
                            if ("IA".equals(str3)) {
                                dtVar.f3506h = str;
                            } else if ("Archive".equals(str3)) {
                                dtVar.f3508j = str;
                            }
                        }
                    }
                } else if ("Date".equals(name)) {
                    str2 = newPullParser.nextText();
                    if (dtVar != null) {
                        if (z10) {
                            dtVar.f3503e = str2;
                        } else if (z11) {
                            dtVar.f3505g = str2;
                        } else if (z12 && str3 != null) {
                            if ("IA".equals(str3)) {
                                dtVar.f3507i = str2;
                            } else if ("Archive".equals(str3)) {
                                dtVar.f3509k = str2;
                            }
                        }
                    }
                } else if (dy.f3535b.equals(name)) {
                    str3 = newPullParser.nextText();
                    if (dtVar != null) {
                        if ("IA".equals(str3)) {
                            dtVar.f3506h = str;
                            dtVar.f3507i = str2;
                        } else if ("Archive".equals(str3)) {
                            dtVar.f3508j = str2;
                            dtVar.f3509k = str2;
                        }
                    }
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if ("Rule".equals(name2)) {
                    if (eqVar.f3566a == null) {
                        eqVar.f3566a = new ArrayList<>();
                    }
                    eqVar.f3566a.add(dtVar);
                } else if ("Expiration".equals(name2)) {
                    z10 = false;
                } else if ("AbortMultipartUpload".equals(name2)) {
                    z11 = false;
                } else if ("Transition".equals(name2)) {
                    z12 = false;
                    str = null;
                    str2 = null;
                    str3 = null;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return eqVar;
    }

    private static ew a(InputStream inputStream, ew ewVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    ewVar.f3577b = CannedAccessControlList.parseACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    ewVar.f3576a.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    ewVar.f3576a.setDisplayName(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return ewVar;
    }

    private static eo a(InputStream inputStream, eo eoVar) throws Exception {
        String name;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        fr frVar = null;
        Owner owner = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name2 = newPullParser.getName();
                if (name2 != null) {
                    if ("Owner".equals(name2)) {
                        owner = new Owner();
                    } else if ("ID".equals(name2)) {
                        if (owner != null) {
                            owner.setId(newPullParser.nextText());
                        }
                    } else if ("DisplayName".equals(name2)) {
                        if (owner != null) {
                            owner.setDisplayName(newPullParser.nextText());
                        }
                    } else if ("Bucket".equals(name2)) {
                        frVar = new fr();
                    } else if ("CreationDate".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3681c = cr.b(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3683e = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3684f = newPullParser.nextText();
                        }
                    } else if ("Location".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3682d = newPullParser.nextText();
                        }
                    } else if ("Name".equals(name2)) {
                        if (frVar != null) {
                            frVar.f3679a = newPullParser.nextText();
                        }
                    } else if (dy.f3535b.equals(name2)) {
                        if (frVar != null) {
                            frVar.f3685g = newPullParser.nextText();
                        }
                    } else if ("Grant".equals(name2) && frVar != null) {
                        frVar.f3686h = CannedAccessControlList.parseACL(newPullParser.nextText());
                    }
                }
            } else if (eventType == 3 && (name = newPullParser.getName()) != null) {
                if ("Bucket".equals(name)) {
                    if (frVar != null) {
                        eoVar.f3564a = frVar;
                    }
                } else if ("Owner".equals(name) && frVar != null) {
                    frVar.f3680b = owner;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return eoVar;
    }

    private static /* synthetic */ eh b(InputStream inputStream, eh ehVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Key".equals(newPullParser.getName())) {
                String nextText = newPullParser.nextText();
                if (ehVar.f3547a == null) {
                    ehVar.f3547a = new ArrayList();
                }
                ehVar.f3547a.add(nextText);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return ehVar;
    }

    private static em a(InputStream inputStream, em emVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    emVar.f3562b = CannedAccessControlList.parseACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    emVar.f3561a.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    emVar.f3561a.setDisplayName(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return emVar;
    }

    private static /* synthetic */ fm b(InputStream inputStream, fm fmVar) throws Exception {
        fmVar.f3643b.clear();
        fmVar.f3642a.clear();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        Owner owner = null;
        fs fsVar = null;
        boolean z10 = false;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Name".equals(name)) {
                    fmVar.f3644c = newPullParser.nextText();
                } else if ("Prefix".equals(name)) {
                    if (z10) {
                        String nextText = newPullParser.nextText();
                        if (!OSSUtils.a(nextText)) {
                            fmVar.f3643b.add(nextText);
                        }
                    } else {
                        fmVar.f3647f = newPullParser.nextText();
                    }
                } else if ("Marker".equals(name)) {
                    fmVar.f3648g = newPullParser.nextText();
                } else if ("Delimiter".equals(name)) {
                    fmVar.f3650i = newPullParser.nextText();
                } else if ("EncodingType".equals(name)) {
                    fmVar.f3651j = newPullParser.nextText();
                } else if ("MaxKeys".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText2)) {
                        fmVar.f3649h = Integer.valueOf(nextText2).intValue();
                    }
                } else if ("NextMarker".equals(name)) {
                    fmVar.f3645d = newPullParser.nextText();
                } else if ("IsTruncated".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText3)) {
                        fmVar.f3646e = Boolean.valueOf(nextText3).booleanValue();
                    }
                } else if ("Contents".equals(name)) {
                    fsVar = new fs();
                } else if ("Key".equals(name)) {
                    fsVar.f3688b = newPullParser.nextText();
                } else if ("LastModified".equals(name)) {
                    fsVar.f3692f = cr.b(newPullParser.nextText());
                } else if ("Size".equals(name)) {
                    String nextText4 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText4)) {
                        fsVar.f3691e = Long.valueOf(nextText4).longValue();
                    }
                } else if ("ETag".equals(name)) {
                    fsVar.f3690d = newPullParser.nextText();
                } else if ("Type".equals(name)) {
                    fsVar.f3689c = newPullParser.nextText();
                } else if (dy.f3535b.equals(name)) {
                    fsVar.f3693g = newPullParser.nextText();
                } else if ("Owner".equals(name)) {
                    owner = new Owner();
                } else if ("ID".equals(name)) {
                    owner.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    owner.setDisplayName(newPullParser.nextText());
                } else if ("CommonPrefixes".equals(name)) {
                    z10 = true;
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if ("Owner".equals(newPullParser.getName())) {
                    if (owner != null) {
                        fsVar.f3694h = owner;
                    }
                } else if ("Contents".equals(name2)) {
                    if (fsVar != null) {
                        fsVar.f3687a = fmVar.f3644c;
                        fmVar.f3642a.add(fsVar);
                    }
                } else if ("CommonPrefixes".equals(name2)) {
                    z10 = false;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return fmVar;
    }

    private static eu a(InputStream inputStream, eu euVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Referer".equals(newPullParser.getName())) {
                String nextText = newPullParser.nextText();
                if (euVar.f3572a == null) {
                    euVar.f3572a = new ArrayList<>();
                }
                euVar.f3572a.add(nextText);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return euVar;
    }

    private static es a(InputStream inputStream, es esVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LoggingEnabled".equals(name)) {
                    esVar.f3570c = true;
                } else if ("TargetBucket".equals(name)) {
                    esVar.f3568a = newPullParser.nextText();
                } else if ("TargetPrefix".equals(name)) {
                    esVar.f3569b = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return esVar;
    }

    private static eq a(InputStream inputStream, eq eqVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        dt dtVar = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Rule".equals(name)) {
                    dtVar = new dt();
                } else if ("ID".equals(name)) {
                    dtVar.f3499a = newPullParser.nextText();
                } else if ("Prefix".equals(name)) {
                    dtVar.f3500b = newPullParser.nextText();
                } else if ("Status".equals(name)) {
                    if ("Enabled".equals(newPullParser.nextText())) {
                        dtVar.f3501c = true;
                    } else {
                        dtVar.f3501c = false;
                    }
                } else if ("Expiration".equals(name)) {
                    z10 = true;
                } else if ("AbortMultipartUpload".equals(name)) {
                    z11 = true;
                } else if ("Transition".equals(name)) {
                    z12 = true;
                } else if ("Days".equals(name)) {
                    str = newPullParser.nextText();
                    if (dtVar != null) {
                        if (z10) {
                            dtVar.f3502d = str;
                        } else if (z11) {
                            dtVar.f3504f = str;
                        } else if (z12 && str3 != null) {
                            if ("IA".equals(str3)) {
                                dtVar.f3506h = str;
                            } else if ("Archive".equals(str3)) {
                                dtVar.f3508j = str;
                            }
                        }
                    }
                } else if ("Date".equals(name)) {
                    str2 = newPullParser.nextText();
                    if (dtVar != null) {
                        if (z10) {
                            dtVar.f3503e = str2;
                        } else if (z11) {
                            dtVar.f3505g = str2;
                        } else if (z12 && str3 != null) {
                            if ("IA".equals(str3)) {
                                dtVar.f3507i = str2;
                            } else if ("Archive".equals(str3)) {
                                dtVar.f3509k = str2;
                            }
                        }
                    }
                } else if (dy.f3535b.equals(name)) {
                    str3 = newPullParser.nextText();
                    if (dtVar != null) {
                        if ("IA".equals(str3)) {
                            dtVar.f3506h = str;
                            dtVar.f3507i = str2;
                        } else if ("Archive".equals(str3)) {
                            dtVar.f3508j = str2;
                            dtVar.f3509k = str2;
                        }
                    }
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if ("Rule".equals(name2)) {
                    if (eqVar.f3566a == null) {
                        eqVar.f3566a = new ArrayList<>();
                    }
                    eqVar.f3566a.add(dtVar);
                } else if ("Expiration".equals(name2)) {
                    z10 = false;
                } else if ("AbortMultipartUpload".equals(name2)) {
                    z11 = false;
                } else if ("Transition".equals(name2)) {
                    z12 = false;
                    str = null;
                    str2 = null;
                    str3 = null;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return eqVar;
    }

    private static /* synthetic */ fi b(InputStream inputStream, fi fiVar) throws Exception {
        fiVar.f3616h.clear();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        fr frVar = null;
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3 && "Bucket".equals(newPullParser.getName()) && frVar != null) {
                    fiVar.f3616h.add(frVar);
                }
            } else {
                String name = newPullParser.getName();
                if (name != null) {
                    if ("Prefix".equals(name)) {
                        fiVar.f3609a = newPullParser.nextText();
                    } else if ("Marker".equals(name)) {
                        fiVar.f3610b = newPullParser.nextText();
                    } else if ("MaxKeys".equals(name)) {
                        String nextText = newPullParser.nextText();
                        if (nextText != null) {
                            fiVar.f3611c = Integer.valueOf(nextText).intValue();
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (nextText2 != null) {
                            fiVar.f3612d = Boolean.valueOf(nextText2).booleanValue();
                        }
                    } else if ("NextMarker".equals(name)) {
                        fiVar.f3613e = newPullParser.nextText();
                    } else if ("ID".equals(name)) {
                        fiVar.f3614f = newPullParser.nextText();
                    } else if ("DisplayName".equals(name)) {
                        fiVar.f3615g = newPullParser.nextText();
                    } else if ("Bucket".equals(name)) {
                        frVar = new fr();
                    } else if ("CreationDate".equals(name)) {
                        if (frVar != null) {
                            frVar.f3681c = cr.b(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name)) {
                        if (frVar != null) {
                            frVar.f3683e = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name)) {
                        if (frVar != null) {
                            frVar.f3684f = newPullParser.nextText();
                        }
                    } else if ("Location".equals(name)) {
                        if (frVar != null) {
                            frVar.f3682d = newPullParser.nextText();
                        }
                    } else if ("Name".equals(name)) {
                        if (frVar != null) {
                            frVar.f3679a = newPullParser.nextText();
                        }
                    } else if (dy.f3535b.equals(name) && frVar != null) {
                        frVar.f3685g = newPullParser.nextText();
                    }
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return fiVar;
    }

    private static eh a(InputStream inputStream, eh ehVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Key".equals(newPullParser.getName())) {
                String nextText = newPullParser.nextText();
                if (ehVar.f3547a == null) {
                    ehVar.f3547a = new ArrayList();
                }
                ehVar.f3547a.add(nextText);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return ehVar;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }

    public static fu a(Map<String, String> map) throws Exception {
        try {
            fu fuVar = new fu();
            for (String str : map.h()) {
                if (str.indexOf(cc.f3273b) >= 0) {
                    fuVar.f3701b.put(str, map.get(str));
                } else {
                    if (!str.equalsIgnoreCase("Last-Modified") && !str.equalsIgnoreCase("Date")) {
                        if (str.equalsIgnoreCase("Content-Length")) {
                            fuVar.a(str, Long.valueOf(map.get(str)));
                        } else if (str.equalsIgnoreCase("ETag")) {
                            fuVar.a(str, (Object) a(map.get(str)));
                        } else {
                            fuVar.a(str, (Object) map.get(str));
                        }
                    }
                    try {
                        fuVar.a(str, cr.a(map.get(str)));
                    } catch (ParseException e2) {
                        throw new IOException(e2.getMessage(), e2);
                    }
                }
            }
            return fuVar;
        } catch (Exception e10) {
            throw new IOException(e10.getMessage(), e10);
        }
    }

    private static fi a(InputStream inputStream, fi fiVar) throws Exception {
        fiVar.f3616h.clear();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        fr frVar = null;
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3 && "Bucket".equals(newPullParser.getName()) && frVar != null) {
                    fiVar.f3616h.add(frVar);
                }
            } else {
                String name = newPullParser.getName();
                if (name != null) {
                    if ("Prefix".equals(name)) {
                        fiVar.f3609a = newPullParser.nextText();
                    } else if ("Marker".equals(name)) {
                        fiVar.f3610b = newPullParser.nextText();
                    } else if ("MaxKeys".equals(name)) {
                        String nextText = newPullParser.nextText();
                        if (nextText != null) {
                            fiVar.f3611c = Integer.valueOf(nextText).intValue();
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (nextText2 != null) {
                            fiVar.f3612d = Boolean.valueOf(nextText2).booleanValue();
                        }
                    } else if ("NextMarker".equals(name)) {
                        fiVar.f3613e = newPullParser.nextText();
                    } else if ("ID".equals(name)) {
                        fiVar.f3614f = newPullParser.nextText();
                    } else if ("DisplayName".equals(name)) {
                        fiVar.f3615g = newPullParser.nextText();
                    } else if ("Bucket".equals(name)) {
                        frVar = new fr();
                    } else if ("CreationDate".equals(name)) {
                        if (frVar != null) {
                            frVar.f3681c = cr.b(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name)) {
                        if (frVar != null) {
                            frVar.f3683e = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name)) {
                        if (frVar != null) {
                            frVar.f3684f = newPullParser.nextText();
                        }
                    } else if ("Location".equals(name)) {
                        if (frVar != null) {
                            frVar.f3682d = newPullParser.nextText();
                        }
                    } else if ("Name".equals(name)) {
                        if (frVar != null) {
                            frVar.f3679a = newPullParser.nextText();
                        }
                    } else if (dy.f3535b.equals(name) && frVar != null) {
                        frVar.f3685g = newPullParser.nextText();
                    }
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return fiVar;
    }

    private static /* synthetic */ fg b(InputStream inputStream, fg fgVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    fgVar.f3602a = newPullParser.nextText();
                } else if ("Key".equals(name)) {
                    fgVar.f3603b = newPullParser.nextText();
                } else if ("UploadId".equals(name)) {
                    fgVar.f3604c = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return fgVar;
    }

    private static /* synthetic */ dv b(InputStream inputStream, dv dvVar) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Location".equals(name)) {
                    dvVar.f3519c = newPullParser.nextText();
                } else if ("Bucket".equals(name)) {
                    dvVar.f3517a = newPullParser.nextText();
                } else if ("Key".equals(name)) {
                    dvVar.f3518b = newPullParser.nextText();
                } else if ("ETag".equals(name)) {
                    dvVar.f3520d = newPullParser.nextText();
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return dvVar;
    }

    private static /* synthetic */ fo b(InputStream inputStream, fo foVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        fw fwVar = null;
        while (eventType != 1) {
            if (eventType != 2) {
                if (eventType == 3 && "Part".equals(newPullParser.getName())) {
                    arrayList.add(fwVar);
                }
            } else {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    foVar.f3657a = newPullParser.nextText();
                } else if ("Key".equals(name)) {
                    foVar.f3658b = newPullParser.nextText();
                } else if ("UploadId".equals(name)) {
                    foVar.f3659c = newPullParser.nextText();
                } else if ("PartNumberMarker".equals(name)) {
                    String nextText = newPullParser.nextText();
                    if (!OSSUtils.a(nextText)) {
                        foVar.f3661e = Integer.parseInt(nextText);
                    }
                } else if ("NextPartNumberMarker".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText2)) {
                        foVar.f3664h = Integer.parseInt(nextText2);
                    }
                } else if ("MaxParts".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText3)) {
                        foVar.f3660d = Integer.parseInt(nextText3);
                    }
                } else if ("IsTruncated".equals(name)) {
                    String nextText4 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText4)) {
                        foVar.f3663g = Boolean.valueOf(nextText4).booleanValue();
                    }
                } else if (dy.f3535b.equals(name)) {
                    foVar.f3662f = newPullParser.nextText();
                } else if ("Part".equals(name)) {
                    fwVar = new fw();
                } else if ("PartNumber".equals(name)) {
                    String nextText5 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText5)) {
                        fwVar.f3707a = Integer.valueOf(nextText5).intValue();
                    }
                } else if ("LastModified".equals(name)) {
                    fwVar.f3708b = cr.b(newPullParser.nextText());
                } else if ("ETag".equals(name)) {
                    fwVar.f3709c = newPullParser.nextText();
                } else if ("Size".equals(name)) {
                    String nextText6 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText6)) {
                        fwVar.f3710d = Long.valueOf(nextText6).longValue();
                    }
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            foVar.f3665i.clear();
            if (!arrayList.isEmpty()) {
                foVar.f3665i.addAll(arrayList);
            }
        }
        return foVar;
    }

    private static fm a(InputStream inputStream, fm fmVar) throws Exception {
        fmVar.f3643b.clear();
        fmVar.f3642a.clear();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        Owner owner = null;
        fs fsVar = null;
        boolean z10 = false;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Name".equals(name)) {
                    fmVar.f3644c = newPullParser.nextText();
                } else if ("Prefix".equals(name)) {
                    if (z10) {
                        String nextText = newPullParser.nextText();
                        if (!OSSUtils.a(nextText)) {
                            fmVar.f3643b.add(nextText);
                        }
                    } else {
                        fmVar.f3647f = newPullParser.nextText();
                    }
                } else if ("Marker".equals(name)) {
                    fmVar.f3648g = newPullParser.nextText();
                } else if ("Delimiter".equals(name)) {
                    fmVar.f3650i = newPullParser.nextText();
                } else if ("EncodingType".equals(name)) {
                    fmVar.f3651j = newPullParser.nextText();
                } else if ("MaxKeys".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText2)) {
                        fmVar.f3649h = Integer.valueOf(nextText2).intValue();
                    }
                } else if ("NextMarker".equals(name)) {
                    fmVar.f3645d = newPullParser.nextText();
                } else if ("IsTruncated".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText3)) {
                        fmVar.f3646e = Boolean.valueOf(nextText3).booleanValue();
                    }
                } else if ("Contents".equals(name)) {
                    fsVar = new fs();
                } else if ("Key".equals(name)) {
                    fsVar.f3688b = newPullParser.nextText();
                } else if ("LastModified".equals(name)) {
                    fsVar.f3692f = cr.b(newPullParser.nextText());
                } else if ("Size".equals(name)) {
                    String nextText4 = newPullParser.nextText();
                    if (!OSSUtils.a(nextText4)) {
                        fsVar.f3691e = Long.valueOf(nextText4).longValue();
                    }
                } else if ("ETag".equals(name)) {
                    fsVar.f3690d = newPullParser.nextText();
                } else if ("Type".equals(name)) {
                    fsVar.f3689c = newPullParser.nextText();
                } else if (dy.f3535b.equals(name)) {
                    fsVar.f3693g = newPullParser.nextText();
                } else if ("Owner".equals(name)) {
                    owner = new Owner();
                } else if ("ID".equals(name)) {
                    owner.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    owner.setDisplayName(newPullParser.nextText());
                } else if ("CommonPrefixes".equals(name)) {
                    z10 = true;
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if ("Owner".equals(newPullParser.getName())) {
                    if (owner != null) {
                        fsVar.f3694h = owner;
                    }
                } else if ("Contents".equals(name2)) {
                    if (fsVar != null) {
                        fsVar.f3687a = fmVar.f3644c;
                        fmVar.f3642a.add(fsVar);
                    }
                } else if ("CommonPrefixes".equals(name2)) {
                    z10 = false;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return fmVar;
    }

    public static ServiceException a(dk dkVar, boolean z10) throws ClientException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i10 = dkVar.f3479c;
        String header = dkVar.f3477a.header(cc.f3295x);
        String str7 = null;
        if (z10) {
            str4 = header;
            str6 = null;
            str3 = null;
            str = null;
            str5 = null;
            str2 = null;
        } else {
            try {
                String string = dkVar.f3477a.body().string();
                cd.b("errorMessage  ：  \n ".concat(String.valueOf(string)));
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(byteArrayInputStream, "utf-8");
                int eventType = newPullParser.getEventType();
                String str8 = null;
                str = null;
                String str9 = null;
                str2 = null;
                while (eventType != 1) {
                    if (eventType == 2) {
                        if ("Code".equals(newPullParser.getName())) {
                            str7 = newPullParser.nextText();
                        } else if ("Message".equals(newPullParser.getName())) {
                            str8 = newPullParser.nextText();
                        } else if ("RequestId".equals(newPullParser.getName())) {
                            header = newPullParser.nextText();
                        } else if ("HostId".equals(newPullParser.getName())) {
                            str = newPullParser.nextText();
                        } else if ("PartNumber".equals(newPullParser.getName())) {
                            str9 = newPullParser.nextText();
                        } else if ("PartEtag".equals(newPullParser.getName())) {
                            str2 = newPullParser.nextText();
                        }
                    }
                    eventType = newPullParser.next();
                    if (eventType == 4) {
                        eventType = newPullParser.next();
                    }
                }
                str3 = str7;
                str7 = str8;
                str4 = header;
                String str10 = str9;
                str5 = string;
                str6 = str10;
            } catch (IOException e2) {
                throw new ClientException(e2);
            } catch (XmlPullParserException e10) {
                throw new ClientException(e10);
            }
        }
        ServiceException serviceException = new ServiceException(i10, str7, str3, str4, str, str5);
        if (!TextUtils.isEmpty(str2)) {
            serviceException.setPartEtag(str2);
        }
        if (!TextUtils.isEmpty(str6)) {
            serviceException.setPartNumber(str6);
        }
        return serviceException;
    }
}
