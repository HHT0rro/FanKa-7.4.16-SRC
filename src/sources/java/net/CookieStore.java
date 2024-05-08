package java.net;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CookieStore {
    void add(URI uri, HttpCookie httpCookie);

    List<HttpCookie> get(URI uri);

    List<HttpCookie> getCookies();

    List<URI> getURIs();

    boolean remove(URI uri, HttpCookie httpCookie);

    boolean removeAll();
}
