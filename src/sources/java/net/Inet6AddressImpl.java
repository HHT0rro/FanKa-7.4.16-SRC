package java.net;

import android.system.ErrnoException;
import android.system.GaiException;
import android.system.OsConstants;
import android.system.StructAddrinfo;
import dalvik.system.BlockGuard;
import java.io.IOException;
import java.util.Enumeration;
import libcore.io.Libcore;
import libcore.net.InetAddressUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class Inet6AddressImpl implements InetAddressImpl {
    private static final AddressCache addressCache = new AddressCache();
    private static InetAddress anyLocalAddress;
    private static InetAddress[] loopbackAddresses;

    @Override // java.net.InetAddressImpl
    public InetAddress[] lookupAllHostAddr(String host, int netId) throws UnknownHostException {
        if (host == null || host.isEmpty()) {
            return loopbackAddresses();
        }
        InetAddress result = InetAddressUtils.parseNumericAddressNoThrowStripOptionalBrackets(host);
        if (result != null) {
            return new InetAddress[]{result};
        }
        return lookupHostByName(host, netId);
    }

    private static InetAddress[] lookupHostByName(String host, int netId) throws UnknownHostException {
        int errno;
        BlockGuard.getThreadPolicy().onNetwork();
        Object cachedResult = addressCache.get(host, netId);
        if (cachedResult != null) {
            if (cachedResult instanceof InetAddress[]) {
                return (InetAddress[]) cachedResult;
            }
            throw new UnknownHostException((String) cachedResult);
        }
        try {
            StructAddrinfo hints = new StructAddrinfo();
            hints.ai_flags = OsConstants.AI_ADDRCONFIG;
            hints.ai_family = OsConstants.AF_UNSPEC;
            hints.ai_socktype = OsConstants.SOCK_STREAM;
            InetAddress[] addresses = Libcore.os.android_getaddrinfo(host, hints, netId);
            for (InetAddress address : addresses) {
                address.holder().hostName = host;
                address.holder().originalHostName = host;
            }
            addressCache.put(host, netId, addresses);
            return addresses;
        } catch (GaiException gaiException) {
            if ((gaiException.getCause() instanceof ErrnoException) && ((errno = ((ErrnoException) gaiException.getCause()).errno) == OsConstants.EACCES || errno == OsConstants.EPERM)) {
                throw new SecurityException("Permission denied (missing INTERNET permission?)", gaiException);
            }
            String detailMessage = "Unable to resolve host \"" + host + "\": " + Libcore.os.gai_strerror(gaiException.error);
            addressCache.putUnknownHost(host, netId, detailMessage);
            throw gaiException.rethrowAsUnknownHostException(detailMessage);
        }
    }

    @Override // java.net.InetAddressImpl
    public String getHostByAddr(byte[] addr) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        return getHostByAddr0(addr);
    }

    @Override // java.net.InetAddressImpl
    public void clearAddressCache() {
        addressCache.clear();
    }

    @Override // java.net.InetAddressImpl
    public boolean isReachable(InetAddress addr, int timeout, NetworkInterface netif, int ttl) throws IOException {
        InetAddress sourceAddr = null;
        if (netif != null) {
            Enumeration<InetAddress> it = netif.getInetAddresses();
            while (true) {
                if (!it.hasMoreElements()) {
                    break;
                }
                InetAddress inetaddr = it.nextElement();
                if (inetaddr.getClass().isInstance(addr)) {
                    sourceAddr = inetaddr;
                    break;
                }
            }
            if (sourceAddr == null) {
                return false;
            }
        }
        if (icmpEcho(addr, timeout, sourceAddr, ttl)) {
            return true;
        }
        return tcpEcho(addr, timeout, sourceAddr, ttl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (((android.system.ErrnoException) r4).errno == android.system.OsConstants.ECONNREFUSED) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean tcpEcho(java.net.InetAddress r8, int r9, java.net.InetAddress r10, int r11) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            int r3 = android.system.OsConstants.AF_INET6     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            int r4 = android.system.OsConstants.SOCK_STREAM     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            java.io.FileDescriptor r3 = libcore.io.IoBridge.socket(r3, r4, r2)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            r0 = r3
            if (r11 <= 0) goto L17
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            r4 = 25
            libcore.io.IoBridge.setSocketOption(r0, r4, r3)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
        L17:
            if (r10 == 0) goto L1c
            libcore.io.IoBridge.bind(r0, r10, r2)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
        L1c:
            r3 = 7
            libcore.io.IoBridge.connect(r0, r8, r3, r9)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L27
            libcore.io.IoBridge.closeAndSignalBlockedThreads(r0)
            return r1
        L25:
            r1 = move-exception
            goto L3f
        L27:
            r3 = move-exception
            java.lang.Throwable r4 = r3.getCause()     // Catch: java.lang.Throwable -> L25
            boolean r5 = r4 instanceof android.system.ErrnoException     // Catch: java.lang.Throwable -> L25
            if (r5 == 0) goto L3a
            r5 = r4
            android.system.ErrnoException r5 = (android.system.ErrnoException) r5     // Catch: java.lang.Throwable -> L25
            int r5 = r5.errno     // Catch: java.lang.Throwable -> L25
            int r6 = android.system.OsConstants.ECONNREFUSED     // Catch: java.lang.Throwable -> L25
            if (r5 != r6) goto L3a
            goto L3b
        L3a:
            r1 = r2
        L3b:
            libcore.io.IoBridge.closeAndSignalBlockedThreads(r0)
            return r1
        L3f:
            libcore.io.IoBridge.closeAndSignalBlockedThreads(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.Inet6AddressImpl.tcpEcho(java.net.InetAddress, int, java.net.InetAddress, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean icmpEcho(java.net.InetAddress r25, int r26, java.net.InetAddress r27, int r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.Inet6AddressImpl.icmpEcho(java.net.InetAddress, int, java.net.InetAddress, int):boolean");
    }

    @Override // java.net.InetAddressImpl
    public InetAddress anyLocalAddress() {
        InetAddress inetAddress;
        synchronized (Inet6AddressImpl.class) {
            if (anyLocalAddress == null) {
                Inet6Address anyAddress = new Inet6Address();
                anyAddress.holder().hostName = "::";
                anyLocalAddress = anyAddress;
            }
            inetAddress = anyLocalAddress;
        }
        return inetAddress;
    }

    @Override // java.net.InetAddressImpl
    public InetAddress[] loopbackAddresses() {
        InetAddress[] inetAddressArr;
        synchronized (Inet6AddressImpl.class) {
            if (loopbackAddresses == null) {
                loopbackAddresses = new InetAddress[]{Inet6Address.LOOPBACK, Inet4Address.LOOPBACK};
            }
            inetAddressArr = loopbackAddresses;
        }
        return inetAddressArr;
    }

    private String getHostByAddr0(byte[] addr) throws UnknownHostException {
        InetAddress hostaddr = InetAddress.getByAddress(addr);
        try {
            return Libcore.os.getnameinfo(hostaddr, OsConstants.NI_NAMEREQD);
        } catch (GaiException e2) {
            UnknownHostException uhe = new UnknownHostException(hostaddr.toString());
            uhe.initCause(e2);
            throw uhe;
        }
    }
}
