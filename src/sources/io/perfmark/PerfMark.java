package io.perfmark;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class PerfMark {
    private static final Impl impl;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            java.lang.String r2 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb
            r3 = r1
            goto Le
        Lb:
            r2 = move-exception
            r3 = r2
            r2 = r1
        Le:
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L31
            java.lang.Class<io.perfmark.Impl> r6 = io.perfmark.Impl.class
            java.lang.Class r2 = r2.asSubclass(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L2f
            java.lang.Class<io.perfmark.Tag> r7 = io.perfmark.Tag.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L2f
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L2f
            io.perfmark.Tag r7 = io.perfmark.Impl.NO_TAG     // Catch: java.lang.Throwable -> L2f
            r6[r4] = r7     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r2 = r2.newInstance(r6)     // Catch: java.lang.Throwable -> L2f
            io.perfmark.Impl r2 = (io.perfmark.Impl) r2     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r2 = move-exception
            r3 = r2
        L31:
            r2 = r1
        L32:
            if (r2 == 0) goto L37
            io.perfmark.PerfMark.impl = r2
            goto L40
        L37:
            io.perfmark.Impl r2 = new io.perfmark.Impl
            io.perfmark.Tag r6 = io.perfmark.Impl.NO_TAG
            r2.<init>(r6)
            io.perfmark.PerfMark.impl = r2
        L40:
            if (r3 == 0) goto L97
            java.lang.String r2 = "io.perfmark.PerfMark.debug"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L97
            java.lang.String r2 = "java.util.logging.Logger"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = "getLogger"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L97
            r7[r4] = r0     // Catch: java.lang.Throwable -> L97
            java.lang.reflect.Method r6 = r2.getMethod(r6, r7)     // Catch: java.lang.Throwable -> L97
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L97
            java.lang.Class<io.perfmark.PerfMark> r8 = io.perfmark.PerfMark.class
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> L97
            r7[r4] = r8     // Catch: java.lang.Throwable -> L97
            java.lang.Object r6 = r6.invoke(r1, r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "java.util.logging.Level"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = "FINE"
            java.lang.reflect.Field r8 = r7.getField(r8)     // Catch: java.lang.Throwable -> L97
            java.lang.Object r1 = r8.get(r1)     // Catch: java.lang.Throwable -> L97
            java.lang.String r8 = "log"
            r9 = 3
            java.lang.Class[] r10 = new java.lang.Class[r9]     // Catch: java.lang.Throwable -> L97
            r10[r4] = r7     // Catch: java.lang.Throwable -> L97
            r10[r5] = r0     // Catch: java.lang.Throwable -> L97
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            r7 = 2
            r10[r7] = r0     // Catch: java.lang.Throwable -> L97
            java.lang.reflect.Method r0 = r2.getMethod(r8, r10)     // Catch: java.lang.Throwable -> L97
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> L97
            r2[r4] = r1     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = "Error during PerfMark.<clinit>"
            r2[r5] = r1     // Catch: java.lang.Throwable -> L97
            r2[r7] = r3     // Catch: java.lang.Throwable -> L97
            r0.invoke(r6, r2)     // Catch: java.lang.Throwable -> L97
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.perfmark.PerfMark.<clinit>():void");
    }

    private PerfMark() {
    }

    public static void attachTag(Tag tag) {
        impl.attachTag(tag);
    }

    public static Tag createTag() {
        return Impl.NO_TAG;
    }

    public static void event(String str, Tag tag) {
        impl.event(str, tag);
    }

    @Deprecated
    public static Link link() {
        return Impl.NO_LINK;
    }

    public static void linkIn(Link link) {
        impl.linkIn(link);
    }

    public static Link linkOut() {
        return impl.linkOut();
    }

    public static void setEnabled(boolean z10) {
        impl.setEnabled(z10);
    }

    public static void startTask(String str, Tag tag) {
        impl.startTask(str, tag);
    }

    public static void stopTask() {
        impl.stopTask();
    }

    public static TaskCloseable traceTask(String str) {
        impl.startTask(str);
        return TaskCloseable.INSTANCE;
    }

    public static void attachTag(String str, String str2) {
        impl.attachTag(str, str2);
    }

    public static Tag createTag(long j10) {
        return impl.createTag("", j10);
    }

    public static void event(String str) {
        impl.event(str);
    }

    public static void startTask(String str) {
        impl.startTask(str);
    }

    public static void stopTask(String str, Tag tag) {
        impl.stopTask(str, tag);
    }

    public static void attachTag(String str, long j10) {
        impl.attachTag(str, j10);
    }

    public static Tag createTag(String str) {
        return impl.createTag(str, Long.MIN_VALUE);
    }

    public static void event(String str, String str2) {
        impl.event(str, str2);
    }

    public static <T> void startTask(T t2, StringFunction<? super T> stringFunction) {
        impl.startTask((Impl) t2, (StringFunction<? super Impl>) stringFunction);
    }

    public static void stopTask(String str) {
        impl.stopTask(str);
    }

    public static <T> TaskCloseable traceTask(T t2, StringFunction<? super T> stringFunction) {
        impl.startTask((Impl) t2, (StringFunction<? super Impl>) stringFunction);
        return TaskCloseable.INSTANCE;
    }

    public static void attachTag(String str, long j10, long j11) {
        impl.attachTag(str, j10, j11);
    }

    public static Tag createTag(String str, long j10) {
        return impl.createTag(str, j10);
    }

    public static void startTask(String str, String str2) {
        impl.startTask(str, str2);
    }

    public static void stopTask(String str, String str2) {
        impl.stopTask(str, str2);
    }

    public static <T> void attachTag(String str, T t2, StringFunction<? super T> stringFunction) {
        impl.attachTag(str, (String) t2, (StringFunction<? super String>) stringFunction);
    }
}
