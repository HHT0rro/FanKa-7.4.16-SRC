package com.huawei.flexiblelayout;

/* compiled from: SafeAreaCalculator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class x implements v {

    /* compiled from: SafeAreaCalculator.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f28664a = "safe-area-inset-left";

        /* renamed from: b, reason: collision with root package name */
        public static final String f28665b = "safe-area-inset-right";

        /* renamed from: c, reason: collision with root package name */
        public static final String f28666c = "safe-area-inset-top";

        /* renamed from: d, reason: collision with root package name */
        public static final String f28667d = "safe-area-inset-bottom";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        if (r6.equals(com.huawei.flexiblelayout.x.a.f28667d) == false) goto L12;
     */
    @Override // com.huawei.flexiblelayout.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Integer a(java.lang.String r6) {
        /*
            r5 = this;
            com.huawei.flexiblelayout.css.a r0 = com.huawei.flexiblelayout.css.a.b()
            android.content.Context r0 = r0.a()
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            if (r0 != 0) goto L10
            return r2
        L10:
            com.huawei.flexiblelayout.b0 r3 = com.huawei.flexiblelayout.b0.b()
            com.huawei.flexiblelayout.services.safearea.SafeAreaInsets r3 = r3.a()
            com.huawei.flexiblelayout.FLEngine r0 = com.huawei.flexiblelayout.FLEngine.getInstance(r0)
            java.lang.Class<com.huawei.flexiblelayout.services.safearea.SafeAreaService> r4 = com.huawei.flexiblelayout.services.safearea.SafeAreaService.class
            java.lang.Object r0 = r0.getService(r4)
            com.huawei.flexiblelayout.services.safearea.SafeAreaService r0 = (com.huawei.flexiblelayout.services.safearea.SafeAreaService) r0
            com.huawei.flexiblelayout.services.safearea.SafeAreaDelegate r0 = r0.getDelegate()
            if (r0 == 0) goto L2e
            com.huawei.flexiblelayout.services.safearea.SafeAreaInsets r3 = r0.onGetSafeAreaInsets(r3)
        L2e:
            if (r3 != 0) goto L31
            return r2
        L31:
            r6.hashCode()
            r0 = -1
            int r4 = r6.hashCode()
            switch(r4) {
                case -1820160037: goto L5f;
                case -783728201: goto L54;
                case -440915547: goto L49;
                case 1479890540: goto L3e;
                default: goto L3c;
            }
        L3c:
            r1 = -1
            goto L68
        L3e:
            java.lang.String r1 = "safe-area-inset-right"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L47
            goto L3c
        L47:
            r1 = 3
            goto L68
        L49:
            java.lang.String r1 = "safe-area-inset-top"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L52
            goto L3c
        L52:
            r1 = 2
            goto L68
        L54:
            java.lang.String r1 = "safe-area-inset-left"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L5d
            goto L3c
        L5d:
            r1 = 1
            goto L68
        L5f:
            java.lang.String r4 = "safe-area-inset-bottom"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L68
            goto L3c
        L68:
            switch(r1) {
                case 0: goto L7b;
                case 1: goto L76;
                case 2: goto L71;
                case 3: goto L6c;
                default: goto L6b;
            }
        L6b:
            return r2
        L6c:
            java.lang.Integer r6 = r3.getSafeAreaEnd()
            return r6
        L71:
            java.lang.Integer r6 = r3.getSafeAreaTop()
            return r6
        L76:
            java.lang.Integer r6 = r3.getSafeAreaStart()
            return r6
        L7b:
            java.lang.Integer r6 = r3.getSafeAreaBottom()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.flexiblelayout.x.a(java.lang.String):java.lang.Integer");
    }
}
