package java.net;

import com.wangmai.okhttp.model.HttpHeaders;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CookieManager extends CookieHandler {
    private CookieStore cookieJar;
    private CookiePolicy policyCallback;

    public CookieManager() {
        this(null, null);
    }

    public CookieManager(CookieStore store, CookiePolicy cookiePolicy) {
        this.cookieJar = null;
        this.policyCallback = cookiePolicy == null ? CookiePolicy.ACCEPT_ORIGINAL_SERVER : cookiePolicy;
        if (store == null) {
            this.cookieJar = new InMemoryCookieStore();
        } else {
            this.cookieJar = store;
        }
    }

    public void setCookiePolicy(CookiePolicy cookiePolicy) {
        if (cookiePolicy != null) {
            this.policyCallback = cookiePolicy;
        }
    }

    public CookieStore getCookieStore() {
        return this.cookieJar;
    }

    @Override // java.net.CookieHandler
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) throws IOException {
        if (uri == null || requestHeaders == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        if (this.cookieJar == null) {
            return Map.of();
        }
        boolean secureLink = "https".equalsIgnoreCase(uri.getScheme());
        List<HttpCookie> cookies = new ArrayList<>();
        for (HttpCookie cookie : this.cookieJar.get(uri)) {
            if (pathMatches(uri, cookie) && (secureLink || !cookie.getSecure())) {
                String ports = cookie.getPortlist();
                if (ports != null && !ports.isEmpty()) {
                    int port = uri.getPort();
                    if (port == -1) {
                        port = "https".equals(uri.getScheme()) ? GrpcUtil.DEFAULT_PORT_SSL : 80;
                    }
                    if (isInPortList(ports, port)) {
                        cookies.add(cookie);
                    }
                } else {
                    cookies.add(cookie);
                }
            }
        }
        if (cookies.isEmpty()) {
            return Collections.emptyMap();
        }
        List<String> cookieHeader = sortByPath(cookies);
        return Map.of(HttpHeaders.HEAD_KEY_COOKIE, cookieHeader);
    }

    @Override // java.net.CookieHandler
    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
        List<HttpCookie> cookies;
        if (uri == null || responseHeaders == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        if (this.cookieJar == null) {
            return;
        }
        PlatformLogger logger = PlatformLogger.getLogger("java.net.CookieManager");
        for (String headerKey : responseHeaders.h()) {
            if (headerKey != null && (headerKey.equalsIgnoreCase(HttpHeaders.HEAD_KEY_SET_COOKIE2) || headerKey.equalsIgnoreCase(HttpHeaders.HEAD_KEY_SET_COOKIE))) {
                for (String headerValue : responseHeaders.get(headerKey)) {
                    try {
                        cookies = HttpCookie.parse(headerValue);
                    } catch (IllegalArgumentException e2) {
                        List<HttpCookie> cookies2 = Collections.emptyList();
                        if (logger.isLoggable(PlatformLogger.Level.SEVERE)) {
                            logger.severe("Invalid cookie for " + ((Object) uri) + ": " + headerValue);
                        }
                        cookies = cookies2;
                    }
                    for (HttpCookie cookie : cookies) {
                        try {
                            if (cookie.getPath() == null) {
                                String path = uri.getPath();
                                if (!path.endsWith("/")) {
                                    int i10 = path.lastIndexOf(47);
                                    if (i10 <= 0) {
                                        path = "/";
                                    } else {
                                        path = path.substring(0, i10 + 1);
                                    }
                                }
                                cookie.setPath(path);
                            } else if (!pathMatches(uri, cookie)) {
                            }
                            if (cookie.getDomain() == null) {
                                String host = uri.getHost();
                                if (host != null && !host.contains(".")) {
                                    host = host + ".local";
                                }
                                cookie.setDomain(host);
                            }
                            String ports = cookie.getPortlist();
                            if (ports != null) {
                                int port = uri.getPort();
                                if (port == -1) {
                                    port = "https".equals(uri.getScheme()) ? GrpcUtil.DEFAULT_PORT_SSL : 80;
                                }
                                if (ports.isEmpty()) {
                                    cookie.setPortlist("" + port);
                                    if (shouldAcceptInternal(uri, cookie)) {
                                        this.cookieJar.add(uri, cookie);
                                    }
                                } else if (isInPortList(ports, port) && shouldAcceptInternal(uri, cookie)) {
                                    this.cookieJar.add(uri, cookie);
                                }
                            } else if (shouldAcceptInternal(uri, cookie)) {
                                this.cookieJar.add(uri, cookie);
                            }
                        } catch (IllegalArgumentException e10) {
                        }
                    }
                }
            }
        }
    }

    private boolean shouldAcceptInternal(URI uri, HttpCookie cookie) {
        try {
            return this.policyCallback.shouldAccept(uri, cookie);
        } catch (Exception e2) {
            return false;
        }
    }

    private static boolean isInPortList(String lst, int port) {
        int val;
        int i10 = lst.indexOf(44);
        while (i10 > 0) {
            try {
                val = Integer.parseInt(lst.substring(0, i10));
            } catch (NumberFormatException e2) {
            }
            if (val == port) {
                return true;
            }
            lst = lst.substring(i10 + 1);
            i10 = lst.indexOf(44);
        }
        if (!lst.isEmpty()) {
            try {
                int val2 = Integer.parseInt(lst);
                if (val2 == port) {
                    return true;
                }
            } catch (NumberFormatException e10) {
            }
        }
        return false;
    }

    private static boolean pathMatches(URI uri, HttpCookie cookie) {
        return normalizePath(uri.getPath()).startsWith(normalizePath(cookie.getPath()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalizePath(String path) {
        if (path == null) {
            path = "";
        }
        if (!path.endsWith("/")) {
            return path + "/";
        }
        return path;
    }

    private List<String> sortByPath(List<HttpCookie> cookies) {
        Collections.sort(cookies, new CookiePathComparator());
        StringBuilder result = new StringBuilder();
        int minVersion = 1;
        for (HttpCookie cookie : cookies) {
            if (cookie.getVersion() < minVersion) {
                minVersion = cookie.getVersion();
            }
        }
        if (minVersion == 1) {
            result.append("$Version=\"1\"; ");
        }
        for (int i10 = 0; i10 < cookies.size(); i10++) {
            if (i10 != 0) {
                result.append("; ");
            }
            result.append(cookies.get(i10).toString());
        }
        List<String> cookieHeader = new ArrayList<>();
        cookieHeader.add(result.toString());
        return cookieHeader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CookiePathComparator implements Comparator<HttpCookie> {
        CookiePathComparator() {
        }

        @Override // java.util.Comparator
        public int compare(HttpCookie c12, HttpCookie c22) {
            if (c12 == c22) {
                return 0;
            }
            if (c12 == null) {
                return -1;
            }
            if (c22 == null) {
                return 1;
            }
            if (!c12.getName().equals(c22.getName())) {
                return 0;
            }
            String c1Path = CookieManager.normalizePath(c12.getPath());
            String c2Path = CookieManager.normalizePath(c22.getPath());
            if (c1Path.startsWith(c2Path)) {
                return -1;
            }
            if (!c2Path.startsWith(c1Path)) {
                return 0;
            }
            return 1;
        }
    }
}
