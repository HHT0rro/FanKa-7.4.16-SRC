package b6;

import b6.a;
import b6.z;
import com.google.android.exoplayer2.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SessionDescriptionParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f1294a = Pattern.compile("([a-z])=\\s?(.+)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f1295b = Pattern.compile("([0-9A-Za-z-]+)(?::(.*))?");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f1296c = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    public static void a(z.b bVar, a.b bVar2) throws ParserException {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x019d, code lost:
    
        r0.r(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01a1, code lost:
    
        r0.y(android.net.Uri.parse(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a9, code lost:
    
        if (r5 != null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ab, code lost:
    
        r0.v(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01af, code lost:
    
        r5.n(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01b3, code lost:
    
        r0.w(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01b7, code lost:
    
        r0.t(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01c1, code lost:
    
        if ("0".equals(r7) == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d2, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedManifest(java.lang.String.format("SDP version %s is not supported.", r7), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01d3, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0105, code lost:
    
        switch(r11) {
            case 0: goto L103;
            case 1: goto L102;
            case 2: goto L101;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L92;
            case 8: goto L84;
            case 9: goto L83;
            case 10: goto L80;
            case 11: goto L68;
            case 12: goto L65;
            default: goto L142;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010a, code lost:
    
        if (r5 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010c, code lost:
    
        a(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
    
        r5 = c(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0115, code lost:
    
        r7 = b6.a0.f1295b.matcher(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011f, code lost:
    
        if (r7.matches() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013d, code lost:
    
        r6 = (java.lang.String) com.google.android.exoplayer2.util.a.e(r7.group(1));
        r7 = com.google.common.base.s.e(r7.group(2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014f, code lost:
    
        if (r5 != null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0151, code lost:
    
        r0.m(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0156, code lost:
    
        r5.i(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0121, code lost:
    
        r0 = java.lang.String.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012b, code lost:
    
        if (r0.length() == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012d, code lost:
    
        r13 = "Malformed Attribute line: ".concat(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x013c, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedManifest(r13, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0132, code lost:
    
        r13 = new java.lang.String("Malformed Attribute line: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015b, code lost:
    
        if (r5 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015d, code lost:
    
        r0.s(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0162, code lost:
    
        r5.m(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0167, code lost:
    
        r0.x(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x016c, code lost:
    
        r6 = com.google.android.exoplayer2.util.j0.M0(r7, ":\\s?");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0173, code lost:
    
        if (r6.length != 2) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0175, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0178, code lost:
    
        com.google.android.exoplayer2.util.a.a(r7);
        r6 = java.lang.Integer.parseInt(r6[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0181, code lost:
    
        if (r5 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0183, code lost:
    
        r0.p(r6 * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0189, code lost:
    
        r5.k(r6 * 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0177, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018f, code lost:
    
        if (r5 != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0191, code lost:
    
        r0.q(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0195, code lost:
    
        r5.l(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0199, code lost:
    
        r0.u(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static b6.z b(java.lang.String r13) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.a0.b(java.lang.String):b6.z");
    }

    public static a.b c(String str) throws ParserException {
        Matcher matcher = f1296c.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Malformed SDP media description line: ".concat(valueOf) : new String("Malformed SDP media description line: "), null);
        }
        try {
            return new a.b((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), (String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(4))));
        } catch (NumberFormatException e2) {
            String valueOf2 = String.valueOf(str);
            throw ParserException.createForMalformedManifest(valueOf2.length() != 0 ? "Malformed SDP media description line: ".concat(valueOf2) : new String("Malformed SDP media description line: "), e2);
        }
    }
}
