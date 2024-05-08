package java.net;

import dalvik.system.VMRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InMemoryCookieStore implements CookieStore {
    private final boolean applyMCompatibility;
    private ReentrantLock lock;
    private Map<URI, List<HttpCookie>> uriIndex;

    public InMemoryCookieStore() {
        this(VMRuntime.getRuntime().getTargetSdkVersion());
    }

    public InMemoryCookieStore(int targetSdkVersion) {
        this.uriIndex = null;
        this.lock = null;
        this.uriIndex = new HashMap();
        this.lock = new ReentrantLock(false);
        this.applyMCompatibility = targetSdkVersion <= 23;
    }

    @Override // java.net.CookieStore
    public void add(URI uri, HttpCookie cookie) {
        if (cookie == null) {
            throw new NullPointerException("cookie is null");
        }
        this.lock.lock();
        try {
            addIndex(this.uriIndex, getEffectiveURI(uri), cookie);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> get(URI uri) {
        if (uri == null) {
            throw new NullPointerException("uri is null");
        }
        List<HttpCookie> cookies = new ArrayList<>();
        this.lock.lock();
        try {
            getInternal1(cookies, this.uriIndex, uri.getHost());
            getInternal2(cookies, this.uriIndex, getEffectiveURI(uri));
            return cookies;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.net.CookieStore
    public List<HttpCookie> getCookies() {
        List<HttpCookie> rt = new ArrayList<>();
        this.lock.lock();
        try {
            for (List<HttpCookie> list : this.uriIndex.values()) {
                Iterator<HttpCookie> it = list.iterator2();
                while (it.hasNext()) {
                    HttpCookie cookie = it.next();
                    if (cookie.hasExpired()) {
                        it.remove();
                    } else if (!rt.contains(cookie)) {
                        rt.add(cookie);
                    }
                }
            }
            return Collections.unmodifiableList(rt);
        } finally {
            Collections.unmodifiableList(rt);
            this.lock.unlock();
        }
    }

    @Override // java.net.CookieStore
    public List<URI> getURIs() {
        this.lock.lock();
        try {
            List<URI> result = new ArrayList<>(this.uriIndex.h());
            result.remove((Object) null);
            return Collections.unmodifiableList(result);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.net.CookieStore
    public boolean remove(URI uri, HttpCookie ck) {
        if (ck == null) {
            throw new NullPointerException("cookie is null");
        }
        this.lock.lock();
        try {
            URI uri2 = getEffectiveURI(uri);
            if (this.uriIndex.get(uri2) == null) {
                return false;
            }
            List<HttpCookie> cookies = this.uriIndex.get(uri2);
            if (cookies != null) {
                return cookies.remove(ck);
            }
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.net.CookieStore
    public boolean removeAll() {
        this.lock.lock();
        try {
            boolean result = !this.uriIndex.isEmpty();
            this.uriIndex.clear();
            return result;
        } finally {
            this.lock.unlock();
        }
    }

    private boolean netscapeDomainMatches(String domain, String host) {
        if (domain == null || host == null) {
            return false;
        }
        boolean isLocalDomain = ".local".equalsIgnoreCase(domain);
        int embeddedDotInDomain = domain.indexOf(46);
        if (embeddedDotInDomain == 0) {
            embeddedDotInDomain = domain.indexOf(46, 1);
        }
        if (!isLocalDomain && (embeddedDotInDomain == -1 || embeddedDotInDomain == domain.length() - 1)) {
            return false;
        }
        int firstDotInHost = host.indexOf(46);
        if (firstDotInHost == -1 && isLocalDomain) {
            return true;
        }
        int domainLength = domain.length();
        int lengthDiff = host.length() - domainLength;
        if (lengthDiff == 0) {
            return host.equalsIgnoreCase(domain);
        }
        if (lengthDiff > 0) {
            String D = host.substring(lengthDiff);
            if (this.applyMCompatibility && !domain.startsWith(".")) {
                return false;
            }
            return D.equalsIgnoreCase(domain);
        }
        if (lengthDiff != -1 || domain.charAt(0) != '.' || !host.equalsIgnoreCase(domain.substring(1))) {
            return false;
        }
        return true;
    }

    private void getInternal1(List<HttpCookie> cookies, Map<URI, List<HttpCookie>> cookieIndex, String host) {
        ArrayList<HttpCookie> toRemove = new ArrayList<>();
        for (Map.Entry<URI, List<HttpCookie>> entry : cookieIndex.entrySet()) {
            List<HttpCookie> lst = entry.getValue();
            for (HttpCookie c4 : lst) {
                String domain = c4.getDomain();
                if ((c4.getVersion() == 0 && netscapeDomainMatches(domain, host)) || (c4.getVersion() == 1 && HttpCookie.domainMatches(domain, host))) {
                    if (!c4.hasExpired()) {
                        if (!cookies.contains(c4)) {
                            cookies.add(c4);
                        }
                    } else {
                        toRemove.add(c4);
                    }
                }
            }
            Iterator<HttpCookie> iterator2 = toRemove.iterator2();
            while (iterator2.hasNext()) {
                lst.remove(iterator2.next());
            }
            toRemove.clear();
        }
    }

    private <T extends Comparable<T>> void getInternal2(List<HttpCookie> cookies, Map<T, List<HttpCookie>> cookieIndex, T comparator) {
        for (T index : cookieIndex.h()) {
            if (index == comparator || (index != null && comparator.compareTo(index) == 0)) {
                List<HttpCookie> indexedCookies = cookieIndex.get(index);
                if (indexedCookies != null) {
                    Iterator<HttpCookie> it = indexedCookies.iterator2();
                    while (it.hasNext()) {
                        HttpCookie ck = it.next();
                        if (!ck.hasExpired()) {
                            if (!cookies.contains(ck)) {
                                cookies.add(ck);
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private <T> void addIndex(Map<T, List<HttpCookie>> indexStore, T index, HttpCookie cookie) {
        List<HttpCookie> cookies = indexStore.get(index);
        if (cookies != null) {
            cookies.remove(cookie);
            cookies.add(cookie);
        } else {
            List<HttpCookie> cookies2 = new ArrayList<>();
            cookies2.add(cookie);
            indexStore.put(index, cookies2);
        }
    }

    private URI getEffectiveURI(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            URI effectiveURI = new URI("http", uri.getHost(), null, null, null);
            return effectiveURI;
        } catch (URISyntaxException e2) {
            return uri;
        }
    }
}
