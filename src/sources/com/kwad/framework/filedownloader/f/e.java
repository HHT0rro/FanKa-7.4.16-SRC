package com.kwad.framework.filedownloader.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {
    public final int aim;
    public final long ain;
    public final boolean aio;
    public final boolean aip;
    public final int aiq;
    public final boolean air;
    public final boolean ais;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final e ait = new e(0);
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    public static int bL(int i10) {
        if (i10 > 12) {
            d.d(e.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i10), 12, 12);
            return 12;
        }
        if (i10 > 0) {
            return i10;
        }
        d.d(e.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i10), 1, 1);
        return 1;
    }

    public static e wN() {
        return a.ait;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x007d A[Catch: all -> 0x01cd, TryCatch #8 {all -> 0x01cd, blocks: (B:54:0x0033, B:57:0x003a, B:60:0x003e, B:63:0x0042, B:66:0x0046, B:69:0x004a, B:73:0x0079, B:75:0x007d, B:77:0x0081, B:79:0x0089), top: B:53:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0089 A[Catch: all -> 0x01cd, TRY_LEAVE, TryCatch #8 {all -> 0x01cd, blocks: (B:54:0x0033, B:57:0x003a, B:60:0x003e, B:63:0x0042, B:66:0x0046, B:69:0x004a, B:73:0x0079, B:75:0x007d, B:77:0x0081, B:79:0x0089), top: B:53:0x0033 }] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e() {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.f.e.<init>():void");
    }
}
