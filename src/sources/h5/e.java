package h5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.m;
import com.google.common.collect.ImmutableList;
import com.huawei.openalliance.ad.constant.bb;
import h5.b;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: XmpMotionPhotoDescriptionParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f49521a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f49522b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f49523c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static b a(String str) throws IOException {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            m.h("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    @Nullable
    public static b b(String str) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (k0.f(newPullParser, "x:xmpmeta")) {
            long j10 = -9223372036854775807L;
            ImmutableList<b.a> of = ImmutableList.of();
            do {
                newPullParser.next();
                if (k0.f(newPullParser, "rdf:Description")) {
                    if (!d(newPullParser)) {
                        return null;
                    }
                    j10 = e(newPullParser);
                    of = c(newPullParser);
                } else if (k0.f(newPullParser, "Container:Directory")) {
                    of = f(newPullParser, "Container", "Item");
                } else if (k0.f(newPullParser, "GContainer:Directory")) {
                    of = f(newPullParser, "GContainer", "GContainerItem");
                }
            } while (!k0.d(newPullParser, "x:xmpmeta"));
            if (of.isEmpty()) {
                return null;
            }
            return new b(j10, of);
        }
        throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
    }

    public static ImmutableList<b.a> c(XmlPullParser xmlPullParser) {
        for (String str : f49523c) {
            String a10 = k0.a(xmlPullParser, str);
            if (a10 != null) {
                return ImmutableList.of(new b.a(bb.V, "Primary", 0L, 0L), new b.a(bb.Code, "MotionPhoto", Long.parseLong(a10), 0L));
            }
        }
        return ImmutableList.of();
    }

    public static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f49521a) {
            String a10 = k0.a(xmlPullParser, str);
            if (a10 != null) {
                return Integer.parseInt(a10) == 1;
            }
        }
        return false;
    }

    public static long e(XmlPullParser xmlPullParser) {
        for (String str : f49522b) {
            String a10 = k0.a(xmlPullParser, str);
            if (a10 != null) {
                long parseLong = Long.parseLong(a10);
                if (parseLong == -1) {
                    return -9223372036854775807L;
                }
                return parseLong;
            }
        }
        return -9223372036854775807L;
    }

    public static ImmutableList<b.a> f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        ImmutableList.a builder = ImmutableList.builder();
        String concat = String.valueOf(str).concat(":Item");
        String concat2 = String.valueOf(str).concat(":Directory");
        do {
            xmlPullParser.next();
            if (k0.f(xmlPullParser, concat)) {
                String concat3 = String.valueOf(str2).concat(":Mime");
                String concat4 = String.valueOf(str2).concat(":Semantic");
                String concat5 = String.valueOf(str2).concat(":Length");
                String concat6 = String.valueOf(str2).concat(":Padding");
                String a10 = k0.a(xmlPullParser, concat3);
                String a11 = k0.a(xmlPullParser, concat4);
                String a12 = k0.a(xmlPullParser, concat5);
                String a13 = k0.a(xmlPullParser, concat6);
                if (a10 != null && a11 != null) {
                    builder.a(new b.a(a10, a11, a12 != null ? Long.parseLong(a12) : 0L, a13 != null ? Long.parseLong(a13) : 0L));
                } else {
                    return ImmutableList.of();
                }
            }
        } while (!k0.d(xmlPullParser, concat2));
        return builder.k();
    }
}
