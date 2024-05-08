package com.kwad.sdk.crash;

import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static final double aFD = Runtime.getRuntime().maxMemory();
    public static final Pattern aFE = Pattern.compile("/data/user");
    public static final Pattern aFF = Pattern.compile("/data");
    public static final Pattern aFG = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aFH = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aFI = 20;
    public static String aFJ = "sessionId";
}
