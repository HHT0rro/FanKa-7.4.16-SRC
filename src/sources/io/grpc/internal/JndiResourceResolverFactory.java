package io.grpc.internal;

import com.google.common.base.w;
import io.grpc.internal.DnsNameResolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class JndiResourceResolverFactory implements DnsNameResolver.ResourceResolverFactory {
    private static final Throwable JNDI_UNAVAILABILITY_CAUSE = initJndi();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class JndiResourceResolver implements DnsNameResolver.ResourceResolver {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final Logger logger = Logger.getLogger(JndiResourceResolver.class.getName());
        private static final Pattern whitespace = Pattern.compile("\\s+");
        private final RecordFetcher recordFetcher;

        public JndiResourceResolver(RecordFetcher recordFetcher) {
            this.recordFetcher = recordFetcher;
        }

        public static String unquote(String str) {
            StringBuilder sb2 = new StringBuilder(str.length());
            int i10 = 0;
            boolean z10 = false;
            while (i10 < str.length()) {
                char charAt = str.charAt(i10);
                if (z10) {
                    if (charAt == '\"') {
                        z10 = false;
                    } else {
                        if (charAt == '\\') {
                            i10++;
                            charAt = str.charAt(i10);
                        }
                        sb2.append(charAt);
                    }
                } else if (charAt != ' ') {
                    if (charAt == '\"') {
                        z10 = true;
                    }
                    sb2.append(charAt);
                }
                i10++;
            }
            return sb2.toString();
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<DnsNameResolver.SrvRecord> resolveSrv(String str) throws Exception {
            String[] split;
            Logger logger2 = logger;
            Level level = Level.FINER;
            if (logger2.isLoggable(level)) {
                logger2.log(level, "About to query SRV records for {0}", new Object[]{str});
            }
            List<String> allRecords = this.recordFetcher.getAllRecords("SRV", "dns:///" + str);
            if (logger2.isLoggable(level)) {
                logger2.log(level, "Found {0} SRV records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            RuntimeException runtimeException = null;
            Level level2 = Level.WARNING;
            for (String str2 : allRecords) {
                try {
                    split = whitespace.split(str2, 5);
                    w.a(split.length == 4, "Bad SRV Record: %s", str2);
                } catch (RuntimeException e2) {
                    logger.log(level2, "Failed to construct SRV record " + str2, (Throwable) e2);
                    if (runtimeException == null) {
                        level2 = Level.FINE;
                        runtimeException = e2;
                    }
                }
                if (split[3].endsWith(".")) {
                    arrayList.add(new DnsNameResolver.SrvRecord(split[3], Integer.parseInt(split[2])));
                } else {
                    throw new RuntimeException("Returned SRV host does not end in period: " + split[3]);
                    break;
                }
            }
            if (arrayList.isEmpty() && runtimeException != null) {
                throw runtimeException;
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override // io.grpc.internal.DnsNameResolver.ResourceResolver
        public List<String> resolveTxt(String str) throws NamingException {
            Logger logger2 = logger;
            Level level = Level.FINER;
            if (logger2.isLoggable(level)) {
                logger2.log(level, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> allRecords = this.recordFetcher.getAllRecords("TXT", "dns:///" + str);
            if (logger2.isLoggable(level)) {
                logger2.log(level, "Found {0} TXT records", new Object[]{Integer.valueOf(allRecords.size())});
            }
            ArrayList arrayList = new ArrayList(allRecords.size());
            Iterator<String> iterator2 = allRecords.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(unquote(iterator2.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface RecordFetcher {
        List<String> getAllRecords(String str, String str2) throws NamingException;
    }

    private static Throwable initJndi() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e2) {
            return e2;
        } catch (Error e10) {
            return e10;
        } catch (RuntimeException e11) {
            return e11;
        }
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    public DnsNameResolver.ResourceResolver newResourceResolver() {
        if (unavailabilityCause() != null) {
            return null;
        }
        return new JndiResourceResolver(new JndiRecordFetcher());
    }

    @Override // io.grpc.internal.DnsNameResolver.ResourceResolverFactory
    public Throwable unavailabilityCause() {
        return JNDI_UNAVAILABILITY_CAUSE;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class JndiRecordFetcher implements RecordFetcher {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        private static void checkAvailable() {
            if (JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", JndiResourceResolverFactory.JNDI_UNAVAILABILITY_CAUSE);
            }
        }

        private static void closeThenThrow(NamingEnumeration<?> namingEnumeration, NamingException namingException) throws NamingException {
            try {
                namingEnumeration.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        @Override // io.grpc.internal.JndiResourceResolverFactory.RecordFetcher
        public List<String> getAllRecords(String str, String str2) throws NamingException {
            checkAvailable();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e2) {
                                closeThenThrow((NamingEnumeration<?>) all2, e2);
                            }
                        }
                        all2.close();
                    } catch (NamingException e10) {
                        closeThenThrow((NamingEnumeration<?>) all, e10);
                    }
                }
                all.close();
            } catch (NamingException e11) {
                closeThenThrow((DirContext) initialDirContext, e11);
            }
            initialDirContext.close();
            return arrayList;
        }

        private static void closeThenThrow(DirContext dirContext, NamingException namingException) throws NamingException {
            try {
                dirContext.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }
    }
}
