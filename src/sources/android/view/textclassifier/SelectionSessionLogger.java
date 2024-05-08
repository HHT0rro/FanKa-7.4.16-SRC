package android.view.textclassifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SelectionSessionLogger {
    private static final String CLASSIFIER_ID = "androidtc";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isPlatformLocalTextClassifierSmartSelection(String signature) {
        return "androidtc".equals(SignatureParser.getClassifierId(signature));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class SignatureParser {
        static String getClassifierId(String signature) {
            int end;
            if (signature == null || (end = signature.indexOf("|")) < 0) {
                return "";
            }
            return signature.substring(0, end);
        }
    }
}
