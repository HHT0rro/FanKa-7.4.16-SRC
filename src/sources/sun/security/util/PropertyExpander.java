package sun.security.util;

import java.security.GeneralSecurityException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PropertyExpander {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ExpandException extends GeneralSecurityException {
        private static final long serialVersionUID = -7941948581406161702L;

        public ExpandException(String msg) {
            super(msg);
        }
    }

    public static String expand(String value) throws ExpandException {
        return expand(value, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:8:0x001d->B:27:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String expand(java.lang.String r10, boolean r11) throws sun.security.util.PropertyExpander.ExpandException {
        /*
            if (r10 != 0) goto L4
            r0 = 0
            return r0
        L4:
            r0 = 0
            java.lang.String r1 = "${"
            int r0 = r10.indexOf(r1, r0)
            r2 = -1
            if (r0 != r2) goto Lf
            return r10
        Lf:
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            int r4 = r10.length()
            r3.<init>(r4)
            int r4 = r10.length()
            r5 = 0
        L1d:
            if (r0 >= r4) goto Ld6
            if (r0 <= r5) goto L29
            java.lang.String r6 = r10.substring(r5, r0)
            r3.append(r6)
            r5 = r0
        L29:
            int r6 = r0 + 2
            if (r6 >= r4) goto L57
            char r7 = r10.charAt(r6)
            r8 = 123(0x7b, float:1.72E-43)
            if (r7 != r8) goto L57
            java.lang.String r7 = "}}"
            int r6 = r10.indexOf(r7, r6)
            if (r6 == r2) goto L4e
            int r7 = r6 + 2
            if (r7 != r4) goto L42
            goto L4e
        L42:
            int r6 = r6 + 1
            int r7 = r6 + 1
            java.lang.String r7 = r10.substring(r0, r7)
            r3.append(r7)
            goto La9
        L4e:
            java.lang.String r1 = r10.substring(r0)
            r3.append(r1)
            goto Ld6
        L57:
            if (r6 >= r4) goto L64
            char r7 = r10.charAt(r6)
            r8 = 125(0x7d, float:1.75E-43)
            if (r7 == r8) goto L64
            int r6 = r6 + 1
            goto L57
        L64:
            if (r6 != r4) goto L6e
            java.lang.String r1 = r10.substring(r0, r6)
            r3.append(r1)
            goto Ld6
        L6e:
            int r7 = r0 + 2
            java.lang.String r7 = r10.substring(r7, r6)
            java.lang.String r8 = "/"
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L82
            char r8 = java.io.File.separatorChar
            r3.append(r8)
            goto La9
        L82:
            java.lang.String r8 = java.lang.System.getProperty(r7)
            if (r8 == 0) goto Lbd
            if (r11 == 0) goto La6
            int r9 = r3.length()     // Catch: java.net.URISyntaxException -> La1
            if (r9 > 0) goto L9b
            java.net.URI r9 = new java.net.URI     // Catch: java.net.URISyntaxException -> La1
            r9.<init>(r8)     // Catch: java.net.URISyntaxException -> La1
            boolean r9 = r9.isAbsolute()     // Catch: java.net.URISyntaxException -> La1
            if (r9 != 0) goto La0
        L9b:
            java.lang.String r9 = sun.net.www.ParseUtil.encodePath(r8)     // Catch: java.net.URISyntaxException -> La1
            r8 = r9
        La0:
            goto La6
        La1:
            r9 = move-exception
            java.lang.String r8 = sun.net.www.ParseUtil.encodePath(r8)
        La6:
            r3.append(r8)
        La9:
            int r5 = r6 + 1
            int r0 = r10.indexOf(r1, r5)
            if (r0 != r2) goto Lbb
            if (r5 >= r4) goto Ld6
            java.lang.String r1 = r10.substring(r5, r4)
            r3.append(r1)
            goto Ld6
        Lbb:
            goto L1d
        Lbd:
            sun.security.util.PropertyExpander$ExpandException r1 = new sun.security.util.PropertyExpander$ExpandException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r9 = "unable to expand property "
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        Ld6:
            java.lang.String r1 = r3.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.util.PropertyExpander.expand(java.lang.String, boolean):java.lang.String");
    }
}
