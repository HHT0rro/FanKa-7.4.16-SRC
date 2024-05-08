package android.view;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ViewTraversalTracingStrings {
    public final String classSimpleName;
    public final String onLayout;
    public final String onMeasure;
    public final String onMeasureBeforeLayout;
    public final String requestLayoutStacktracePrefix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTraversalTracingStrings(View v2) {
        String className = v2.getClass().getSimpleName();
        this.classSimpleName = className;
        this.onMeasureBeforeLayout = getTraceName("onMeasureBeforeLayout", className, v2);
        this.onMeasure = getTraceName("onMeasure", className, v2);
        this.onLayout = getTraceName("onLayout", className, v2);
        this.requestLayoutStacktracePrefix = "requestLayout " + className;
    }

    private String getTraceName(String sectionName, String className, View v2) {
        StringBuilder out = new StringBuilder();
        out.append(sectionName);
        out.append(" ");
        out.append(className);
        v2.appendId(out);
        return out.substring(0, Math.min(out.length() - 1, 126));
    }
}
