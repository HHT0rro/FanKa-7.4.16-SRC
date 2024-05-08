package com.tencent.liteav.base;

import android.text.TextUtils;
import android.util.Patterns;
import androidx.core.app.NotificationCompat;
import com.tencent.liteav.base.annotations.UsedByReflection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PiiElider {
    private static final String[] APP_NAMESPACE;
    private static final String CONSOLE_ELISION = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";
    private static final Pattern CONSOLE_MSG;
    private static final Pattern DOMAIN_NAME;
    private static final String EMAIL_ELISION = "XXX@EMAIL.ELIDED";
    private static final String GOOD_GTLD_CHAR = "a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef";
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef";
    private static final String GTLD = "[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}";
    private static final String HOST_NAME = "([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}";
    private static final Pattern IP_ADDRESS;
    private static final String IRI = "[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}";
    private static final Pattern LIKELY_EXCEPTION_LOG;
    private static final Pattern MAC_ADDRESS;
    private static final String MAC_ELISION = "01:23:45:67:89:AB";
    private static final String[] SYSTEM_NAMESPACE;
    private static final String URL_ELISION = "HTTP://WEBADDRESS.ELIDED";
    private static final Pattern WEB_URL;

    static {
        Pattern compile = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
        IP_ADDRESS = compile;
        Pattern compile2 = Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}|" + ((Object) compile) + ")");
        DOMAIN_NAME = compile2;
        LIKELY_EXCEPTION_LOG = Pattern.compile("\\sat\\sorg\\.chromium\\.[^ ]+.");
        WEB_URL = Pattern.compile("(?:\\b|^)((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + ((Object) compile2) + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        MAC_ADDRESS = Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
        CONSOLE_MSG = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
        APP_NAMESPACE = new String[]{"org.chromium.", "com.google."};
        SYSTEM_NAMESPACE = new String[]{"android.accessibilityservice", "android.accounts", "android.animation", "android.annotation", "android.app", "android.appwidget", "android.bluetooth", "android.content", "android.database", "android.databinding", "android.drm", "android.gesture", "android.graphics", "android.hardware", "android.inputmethodservice", "android.location", "android.media", "android.mtp", "android.net", "android.nfc", "android.opengl", "android.os", "android.preference", "android.print", "android.printservice", "android.provider", "android.renderscript", "android.sax", "android.security", "android.service", "android.speech", "android.support", "android.system", "android.telecom", "android.telephony", "android.test", NotificationCompat.EXTRA_TEXT, "android.transition", "android.util", "android.view", "android.webkit", "android.widget", "com.android.", "dalvik.", "java.", "javax.", "org.apache.", "org.json.", "org.w3c.dom.", "org.xml.", "org.xmlpull."};
    }

    public static String elideConsole(String str) {
        return CONSOLE_MSG.matcher(str).replaceAll(CONSOLE_ELISION);
    }

    public static String elideEmail(String str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).replaceAll(EMAIL_ELISION);
    }

    public static String elideMac(String str) {
        return MAC_ADDRESS.matcher(str).replaceAll(MAC_ELISION);
    }

    public static String elideUrl(String str) {
        if (LIKELY_EXCEPTION_LOG.matcher(str).find()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        Matcher matcher = WEB_URL.matcher(sb2);
        int i10 = 0;
        while (matcher.find(i10)) {
            int start = matcher.start();
            int end = matcher.end();
            String substring = sb2.substring(start, end);
            if (likelyToBeAppNamespace(substring) || likelyToBeSystemNamespace(substring)) {
                i10 = end;
            } else {
                sb2.replace(start, end, URL_ELISION);
                i10 = start + 24;
                matcher = WEB_URL.matcher(sb2);
            }
        }
        return sb2.toString();
    }

    private static boolean likelyToBeAppNamespace(String str) {
        for (String str2 : APP_NAMESPACE) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean likelyToBeSystemNamespace(String str) {
        for (String str2 : SYSTEM_NAMESPACE) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @UsedByReflection("jni_android.cc")
    public static String sanitizeStacktrace(String str) {
        String[] split = str.split("\\n");
        split[0] = elideUrl(split[0]);
        for (int i10 = 1; i10 < split.length; i10++) {
            if (split[i10].startsWith("Caused by:")) {
                split[i10] = elideUrl(split[i10]);
            }
        }
        return TextUtils.join("\n", split);
    }
}
