package sun.net.spi;

import com.alibaba.security.realidentity.build.cs;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import sun.net.NetProperties;
import sun.net.SocksProxy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DefaultProxySelector extends ProxySelector {
    private static final String SOCKS_PROXY_VERSION = "socksProxyVersion";
    static final String[][] props = {new String[]{"http", "http.proxy", "proxy", "socksProxy"}, new String[]{"https", "https.proxy", "proxy", "socksProxy"}, new String[]{"ftp", "ftp.proxy", "ftpProxy", "proxy", "socksProxy"}, new String[]{"gopher", "gopherProxy", "socksProxy"}, new String[]{"socket", "socksProxy"}};
    private static boolean hasSystemProxies = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class NonProxyInfo {
        final String defaultVal;
        String hostsSource;
        Pattern pattern;
        final String property;
        static final String defStringVal = "localhost|127.*|[::1]|0.0.0.0|[::0]";
        static NonProxyInfo ftpNonProxyInfo = new NonProxyInfo("ftp.nonProxyHosts", null, null, defStringVal);
        static NonProxyInfo httpNonProxyInfo = new NonProxyInfo("http.nonProxyHosts", null, null, defStringVal);
        static NonProxyInfo socksNonProxyInfo = new NonProxyInfo("socksNonProxyHosts", null, null, defStringVal);
        static NonProxyInfo httpsNonProxyInfo = new NonProxyInfo("https.nonProxyHosts", null, null, defStringVal);

        NonProxyInfo(String p10, String s2, Pattern pattern, String d10) {
            this.property = p10;
            this.hostsSource = s2;
            this.pattern = pattern;
            this.defaultVal = d10;
        }
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        String auth;
        if (uri == null) {
            throw new IllegalArgumentException("URI can't be null.");
        }
        final String protocol = uri.getScheme();
        String host = uri.getHost();
        if (host == null && (auth = uri.getAuthority()) != null) {
            int i10 = auth.indexOf(64);
            if (i10 >= 0) {
                auth = auth.substring(i10 + 1);
            }
            int i11 = auth.lastIndexOf(58);
            if (i11 >= 0) {
                auth = auth.substring(0, i11);
            }
            host = auth;
        }
        if (protocol == null || host == null) {
            throw new IllegalArgumentException("protocol = " + protocol + " host = " + host);
        }
        List<Proxy> proxyl = new ArrayList<>(1);
        NonProxyInfo pinfo = null;
        if ("http".equalsIgnoreCase(protocol)) {
            pinfo = NonProxyInfo.httpNonProxyInfo;
        } else if ("https".equalsIgnoreCase(protocol)) {
            pinfo = NonProxyInfo.httpsNonProxyInfo;
        } else if ("ftp".equalsIgnoreCase(protocol)) {
            pinfo = NonProxyInfo.ftpNonProxyInfo;
        } else if ("socket".equalsIgnoreCase(protocol)) {
            pinfo = NonProxyInfo.socksNonProxyInfo;
        }
        final NonProxyInfo nprop = pinfo;
        final String urlhost = host.toLowerCase();
        Proxy p10 = (Proxy) AccessController.doPrivileged(new PrivilegedAction<Proxy>() { // from class: sun.net.spi.DefaultProxySelector.1
            @Override // java.security.PrivilegedAction
            public Proxy run() {
                String phost = null;
                for (int i12 = 0; i12 < DefaultProxySelector.props.length; i12++) {
                    if (DefaultProxySelector.props[i12][0].equalsIgnoreCase(protocol)) {
                        int j10 = 1;
                        while (j10 < DefaultProxySelector.props[i12].length && ((phost = NetProperties.get(DefaultProxySelector.props[i12][j10] + cs.U)) == null || phost.length() == 0)) {
                            j10++;
                        }
                        if (phost == null || phost.length() == 0) {
                            return Proxy.NO_PROXY;
                        }
                        NonProxyInfo nonProxyInfo = nprop;
                        if (nonProxyInfo != null) {
                            String nphosts = NetProperties.get(nonProxyInfo.property);
                            synchronized (nprop) {
                                if (nphosts == null) {
                                    if (nprop.defaultVal != null) {
                                        nphosts = nprop.defaultVal;
                                    } else {
                                        nprop.hostsSource = null;
                                        nprop.pattern = null;
                                    }
                                } else if (nphosts.length() != 0) {
                                    nphosts = nphosts + "|localhost|127.*|[::1]|0.0.0.0|[::0]";
                                }
                                if (nphosts != null && !nphosts.equals(nprop.hostsSource)) {
                                    nprop.pattern = DefaultProxySelector.toPattern(nphosts);
                                    nprop.hostsSource = nphosts;
                                }
                                if (DefaultProxySelector.shouldNotUseProxyFor(nprop.pattern, urlhost)) {
                                    return Proxy.NO_PROXY;
                                }
                            }
                        }
                        int pport = NetProperties.getInteger(DefaultProxySelector.props[i12][j10] + "Port", 0).intValue();
                        if (pport == 0 && j10 < DefaultProxySelector.props[i12].length - 1) {
                            for (int k10 = 1; k10 < DefaultProxySelector.props[i12].length - 1; k10++) {
                                if (k10 != j10 && pport == 0) {
                                    pport = NetProperties.getInteger(DefaultProxySelector.props[i12][k10] + "Port", 0).intValue();
                                }
                            }
                        }
                        if (pport <= 0 || pport > 65535) {
                            System.out.println("proxy port out of range or not find ,use default");
                            if (j10 == DefaultProxySelector.props[i12].length - 1) {
                                pport = DefaultProxySelector.this.defaultPort("socket");
                            } else {
                                pport = DefaultProxySelector.this.defaultPort(protocol);
                            }
                        }
                        InetSocketAddress saddr = InetSocketAddress.createUnresolved(phost, pport);
                        if (j10 == DefaultProxySelector.props[i12].length - 1) {
                            int version = NetProperties.getInteger(DefaultProxySelector.SOCKS_PROXY_VERSION, 5).intValue();
                            return SocksProxy.create(saddr, version);
                        }
                        return new Proxy(Proxy.Type.HTTP, saddr);
                    }
                }
                return Proxy.NO_PROXY;
            }
        });
        proxyl.add(p10);
        return proxyl;
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress sa2, IOException ioe) {
        if (uri == null || sa2 == null || ioe == null) {
            throw new IllegalArgumentException("Arguments can't be null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int defaultPort(String protocol) {
        if ("http".equalsIgnoreCase(protocol)) {
            return 80;
        }
        if ("https".equalsIgnoreCase(protocol)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        if ("ftp".equalsIgnoreCase(protocol)) {
            return 80;
        }
        if ("socket".equalsIgnoreCase(protocol)) {
            return 1080;
        }
        return "gopher".equalsIgnoreCase(protocol) ? 80 : -1;
    }

    static boolean shouldNotUseProxyFor(Pattern pattern, String urlhost) {
        if (pattern == null || urlhost.isEmpty()) {
            return false;
        }
        boolean matches = pattern.matcher(urlhost).matches();
        return matches;
    }

    static Pattern toPattern(String mask) {
        boolean disjunctionEmpty = true;
        StringJoiner joiner = new StringJoiner("|");
        for (String disjunct : mask.split("\\|")) {
            if (!disjunct.isEmpty()) {
                disjunctionEmpty = false;
                String regex = disjunctToRegex(disjunct.toLowerCase());
                joiner.add(regex);
            }
        }
        if (disjunctionEmpty) {
            return null;
        }
        return Pattern.compile(joiner.toString());
    }

    static String disjunctToRegex(String disjunct) {
        if (disjunct.startsWith(StringUtils.NO_PRINT_CODE)) {
            String regex = ".*" + Pattern.quote(disjunct.substring(1));
            return regex;
        }
        if (disjunct.endsWith(StringUtils.NO_PRINT_CODE)) {
            String regex2 = Pattern.quote(disjunct.substring(0, disjunct.length() - 1)) + ".*";
            return regex2;
        }
        String regex3 = Pattern.quote(disjunct);
        return regex3;
    }
}
