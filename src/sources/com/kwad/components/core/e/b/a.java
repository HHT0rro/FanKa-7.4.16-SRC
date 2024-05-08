package com.kwad.components.core.e.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0458a {
        private static final c Kb = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long ac(String str) {
        return nn().ad(str);
    }

    private static c nn() {
        return C0458a.Kb;
    }

    public static String t(long j10) {
        String u10 = nn().u(j10);
        return u10.endsWith("=") ? u10.replace("=", "") : u10;
    }
}
