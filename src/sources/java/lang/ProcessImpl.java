package java.lang;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ProcessImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private ProcessImpl() {
    }

    private static byte[] toCString(String s2) {
        if (s2 == null) {
            return null;
        }
        byte[] bytes = s2.getBytes();
        byte[] result = new byte[bytes.length + 1];
        System.arraycopy((Object) bytes, 0, (Object) result, 0, bytes.length);
        result[result.length - 1] = 0;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Process start(java.lang.String[] r22, java.util.Map<java.lang.String, java.lang.String> r23, java.lang.String r24, java.lang.ProcessBuilder.Redirect[] r25, boolean r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.ProcessImpl.start(java.lang.String[], java.util.Map, java.lang.String, java.lang.ProcessBuilder$Redirect[], boolean):java.lang.Process");
    }
}
