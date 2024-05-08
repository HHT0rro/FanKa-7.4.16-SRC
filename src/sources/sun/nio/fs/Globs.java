package sun.nio.fs;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Globs {
    private static char EOL = 0;
    private static final String globMetaChars = "\\*?[{";
    private static final String regexMetaChars = ".^$+{[]|()";

    private Globs() {
    }

    private static boolean isRegexMeta(char c4) {
        return regexMetaChars.indexOf(c4) != -1;
    }

    private static boolean isGlobMeta(char c4) {
        return globMetaChars.indexOf(c4) != -1;
    }

    private static char next(String glob, int i10) {
        if (i10 < glob.length()) {
            return glob.charAt(i10);
        }
        return EOL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x011b, code lost:
    
        throw new java.util.regex.PatternSyntaxException("Explicit 'name separator' in class", r12, r8 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0104, code lost:
    
        r3 = r10;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0017. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String toRegexPattern(java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.Globs.toRegexPattern(java.lang.String, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toUnixRegexPattern(String globPattern) {
        return toRegexPattern(globPattern, false);
    }

    static String toWindowsRegexPattern(String globPattern) {
        return toRegexPattern(globPattern, true);
    }
}
