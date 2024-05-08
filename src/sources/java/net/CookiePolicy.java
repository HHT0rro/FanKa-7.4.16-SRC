package java.net;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CookiePolicy {
    public static final CookiePolicy ACCEPT_ALL = new CookiePolicy() { // from class: java.net.CookiePolicy.1
        @Override // java.net.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return true;
        }
    };
    public static final CookiePolicy ACCEPT_NONE = new CookiePolicy() { // from class: java.net.CookiePolicy.2
        @Override // java.net.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return false;
        }
    };
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER = new CookiePolicy() { // from class: java.net.CookiePolicy.3
        @Override // java.net.CookiePolicy
        public boolean shouldAccept(URI uri, HttpCookie cookie) {
            if (uri == null || cookie == null) {
                return false;
            }
            return HttpCookie.domainMatches(cookie.getDomain(), uri.getHost());
        }
    };

    boolean shouldAccept(URI uri, HttpCookie httpCookie);
}
