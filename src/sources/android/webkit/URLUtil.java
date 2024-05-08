package android.webkit;

import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import com.alibaba.security.realidentity.build.bh;
import com.android.internal.midi.MidiConstants;
import com.huawei.quickcard.base.http.ContentType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class URLUtil {
    static final String ASSET_BASE = "file:///android_asset/";
    static final String CONTENT_BASE = "content:";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    static final String FILE_BASE = "file:";
    private static final String LOGTAG = "webkit";
    static final String PROXY_BASE = "file:///cookieless_proxy/";
    static final String RESOURCE_BASE = "file:///android_res/";
    private static final boolean TRACE = false;

    public static String guessUrl(String inUrl) {
        if (inUrl.length() == 0 || inUrl.startsWith("about:") || inUrl.startsWith("data:") || inUrl.startsWith(FILE_BASE) || inUrl.startsWith(bh.f3176j)) {
            return inUrl;
        }
        if (inUrl.endsWith(".")) {
            inUrl = inUrl.substring(0, inUrl.length() - 1);
        }
        try {
            WebAddress webAddress = new WebAddress(inUrl);
            if (webAddress.getHost().indexOf(46) == -1) {
                webAddress.setHost("www." + webAddress.getHost() + ".com");
            }
            return webAddress.toString();
        } catch (ParseException e2) {
            return inUrl;
        }
    }

    public static String composeSearchUrl(String inQuery, String template, String queryPlaceHolder) {
        int placeHolderIndex = template.indexOf(queryPlaceHolder);
        if (placeHolderIndex < 0) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append(template.substring(0, placeHolderIndex));
        try {
            String query = URLEncoder.encode(inQuery, "utf-8");
            buffer.append(query);
            buffer.append(template.substring(queryPlaceHolder.length() + placeHolderIndex));
            return buffer.toString();
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    public static byte[] decode(byte[] url) throws IllegalArgumentException {
        if (url.length == 0) {
            return new byte[0];
        }
        byte[] tempData = new byte[url.length];
        int tempCount = 0;
        int i10 = 0;
        while (i10 < url.length) {
            byte b4 = url[i10];
            if (b4 == 37) {
                if (url.length - i10 > 2) {
                    b4 = (byte) ((parseHex(url[i10 + 1]) * 16) + parseHex(url[i10 + 2]));
                    i10 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid format");
                }
            }
            tempData[tempCount] = b4;
            i10++;
            tempCount++;
        }
        byte[] retData = new byte[tempCount];
        System.arraycopy((Object) tempData, 0, (Object) retData, 0, tempCount);
        return retData;
    }

    static boolean verifyURLEncoding(String url) {
        int count = url.length();
        if (count == 0) {
            return false;
        }
        int index = url.indexOf(37);
        while (index >= 0 && index < count) {
            if (index >= count - 2) {
                return false;
            }
            int index2 = index + 1;
            try {
                parseHex((byte) url.charAt(index2));
                int index3 = index2 + 1;
                parseHex((byte) url.charAt(index3));
                index = url.indexOf(37, index3 + 1);
            } catch (IllegalArgumentException e2) {
                return false;
            }
        }
        return true;
    }

    private static int parseHex(byte b4) {
        if (b4 >= 48 && b4 <= 57) {
            return b4 + MidiConstants.STATUS_CHANNEL_PRESSURE;
        }
        if (b4 >= 65 && b4 <= 70) {
            return (b4 - 65) + 10;
        }
        if (b4 < 97 || b4 > 102) {
            throw new IllegalArgumentException("Invalid hex char '" + ((int) b4) + "'");
        }
        return (b4 - 97) + 10;
    }

    public static boolean isAssetUrl(String url) {
        return url != null && url.startsWith("file:///android_asset/");
    }

    public static boolean isResourceUrl(String url) {
        return url != null && url.startsWith(RESOURCE_BASE);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String url) {
        return url != null && url.startsWith(PROXY_BASE);
    }

    public static boolean isFileUrl(String url) {
        return (url == null || !url.startsWith(FILE_BASE) || url.startsWith("file:///android_asset/") || url.startsWith(PROXY_BASE)) ? false : true;
    }

    public static boolean isAboutUrl(String url) {
        return url != null && url.startsWith("about:");
    }

    public static boolean isDataUrl(String url) {
        return url != null && url.startsWith("data:");
    }

    public static boolean isJavaScriptUrl(String url) {
        return url != null && url.startsWith(bh.f3176j);
    }

    public static boolean isHttpUrl(String url) {
        return url != null && url.length() > 6 && url.substring(0, 7).equalsIgnoreCase("http://");
    }

    public static boolean isHttpsUrl(String url) {
        return url != null && url.length() > 7 && url.substring(0, 8).equalsIgnoreCase("https://");
    }

    public static boolean isNetworkUrl(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        return isHttpUrl(url) || isHttpsUrl(url);
    }

    public static boolean isContentUrl(String url) {
        return url != null && url.startsWith(CONTENT_BASE);
    }

    public static boolean isValidUrl(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        return isAssetUrl(url) || isResourceUrl(url) || isFileUrl(url) || isAboutUrl(url) || isHttpUrl(url) || isHttpsUrl(url) || isJavaScriptUrl(url) || isContentUrl(url);
    }

    public static String stripAnchor(String url) {
        int anchorIndex = url.indexOf(35);
        if (anchorIndex != -1) {
            return url.substring(0, anchorIndex);
        }
        return url;
    }

    public static final String guessFileName(String url, String contentDisposition, String mimeType) {
        String decodedUrl;
        int index;
        int index2;
        String filename = null;
        String extension = null;
        if (contentDisposition != null && (filename = parseContentDisposition(contentDisposition)) != null && (index2 = filename.lastIndexOf(47) + 1) > 0) {
            filename = filename.substring(index2);
        }
        if (filename == null && (decodedUrl = Uri.decode(url)) != null) {
            int queryIndex = decodedUrl.indexOf(63);
            if (queryIndex > 0) {
                decodedUrl = decodedUrl.substring(0, queryIndex);
            }
            if (!decodedUrl.endsWith("/") && (index = decodedUrl.lastIndexOf(47) + 1) > 0) {
                filename = decodedUrl.substring(index);
            }
        }
        if (filename == null) {
            filename = "downloadfile";
        }
        int dotIndex = filename.indexOf(46);
        if (dotIndex < 0) {
            if (mimeType != null && (extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)) != null) {
                extension = "." + extension;
            }
            if (extension == null) {
                if (mimeType != null && mimeType.toLowerCase(Locale.ROOT).startsWith(ContentType.TEXT)) {
                    if (mimeType.equalsIgnoreCase("text/html")) {
                        extension = ".html";
                    } else {
                        extension = ".txt";
                    }
                } else {
                    extension = ".bin";
                }
            }
        } else {
            if (mimeType != null) {
                int lastDotIndex = filename.lastIndexOf(46);
                String typeFromExt = MimeTypeMap.getSingleton().getMimeTypeFromExtension(filename.substring(lastDotIndex + 1));
                if (typeFromExt != null && !typeFromExt.equalsIgnoreCase(mimeType) && (extension = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)) != null) {
                    extension = "." + extension;
                }
            }
            if (extension == null) {
                extension = filename.substring(dotIndex);
            }
            filename = filename.substring(0, dotIndex);
        }
        return filename + extension;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseContentDisposition(String contentDisposition) {
        try {
            Matcher m10 = CONTENT_DISPOSITION_PATTERN.matcher(contentDisposition);
            if (m10.find()) {
                return m10.group(2);
            }
            return null;
        } catch (IllegalStateException e2) {
            return null;
        }
    }
}
