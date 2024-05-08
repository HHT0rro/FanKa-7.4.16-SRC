package sun.net.www.protocol.jar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import sun.net.www.ParseUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Handler extends URLStreamHandler {
    private static final String separator = "!/";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL u10) throws IOException {
        return new JarURLConnection(u10, this);
    }

    private static int indexOfBangSlash(String spec) {
        int indexOfBang = spec.length();
        while (true) {
            int indexOfBang2 = spec.lastIndexOf(33, indexOfBang);
            if (indexOfBang2 == -1) {
                return -1;
            }
            if (indexOfBang2 != spec.length() - 1 && spec.charAt(indexOfBang2 + 1) == '/') {
                return indexOfBang2 + 1;
            }
            indexOfBang = indexOfBang2 - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public boolean sameFile(URL u12, URL u22) {
        if (!u12.getProtocol().equals("jar") || !u22.getProtocol().equals("jar")) {
            return false;
        }
        String file1 = u12.getFile();
        String file2 = u22.getFile();
        int sep1 = file1.indexOf(separator);
        int sep2 = file2.indexOf(separator);
        if (sep1 == -1 || sep2 == -1) {
            return super.sameFile(u12, u22);
        }
        String entry1 = file1.substring(sep1 + 2);
        String entry2 = file2.substring(sep2 + 2);
        if (!entry1.equals(entry2)) {
            return false;
        }
        try {
            URL enclosedURL1 = new URL(file1.substring(0, sep1));
            URL enclosedURL2 = new URL(file2.substring(0, sep2));
            return super.sameFile(enclosedURL1, enclosedURL2);
        } catch (MalformedURLException e2) {
            return super.sameFile(u12, u22);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public int hashCode(URL u10) {
        int h10;
        String protocol = u10.getProtocol();
        int h11 = protocol != null ? 0 + protocol.hashCode() : 0;
        String file = u10.getFile();
        int sep = file.indexOf(separator);
        if (sep == -1) {
            return file.hashCode() + h11;
        }
        String fileWithoutEntry = file.substring(0, sep);
        try {
            URL enclosedURL = new URL(fileWithoutEntry);
            h10 = h11 + enclosedURL.hashCode();
        } catch (MalformedURLException e2) {
            h10 = h11 + fileWithoutEntry.hashCode();
        }
        String entry = file.substring(sep + 2);
        return h10 + entry.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public void parseURL(URL url, String spec, int start, int limit) {
        String ref;
        boolean absoluteSpec;
        String file;
        String file2 = null;
        int refPos = spec.indexOf(35, limit);
        boolean refOnly = refPos == start;
        if (refPos <= -1) {
            ref = null;
        } else {
            String ref2 = spec.substring(refPos + 1, spec.length());
            if (!refOnly) {
                ref = ref2;
            } else {
                file2 = url.getFile();
                ref = ref2;
            }
        }
        if (spec.length() < 4) {
            absoluteSpec = false;
        } else {
            boolean absoluteSpec2 = spec.substring(0, 4).equalsIgnoreCase("jar:");
            absoluteSpec = absoluteSpec2;
        }
        String spec2 = spec.substring(start, limit);
        if (absoluteSpec) {
            file = parseAbsoluteSpec(spec2);
        } else if (refOnly) {
            file = file2;
        } else {
            String file3 = parseContextSpec(url, spec2);
            int bangSlash = indexOfBangSlash(file3);
            String toBangSlash = file3.substring(0, bangSlash);
            String afterBangSlash = file3.substring(bangSlash);
            ParseUtil canonizer = new ParseUtil();
            file = toBangSlash + canonizer.canonizeString(afterBangSlash);
        }
        setURL(url, "jar", "", -1, file, ref);
    }

    private String parseAbsoluteSpec(String spec) {
        int index = indexOfBangSlash(spec);
        if (index == -1) {
            throw new NullPointerException("no !/ in spec");
        }
        try {
            String innerSpec = spec.substring(0, index - 1);
            new URL(innerSpec);
            return spec;
        } catch (MalformedURLException e2) {
            throw new NullPointerException("invalid url: " + spec + " (" + ((Object) e2) + ")");
        }
    }

    private String parseContextSpec(URL url, String spec) {
        String ctxFile = url.getFile();
        if (spec.startsWith("/")) {
            int bangSlash = indexOfBangSlash(ctxFile);
            if (bangSlash == -1) {
                throw new NullPointerException("malformed context url:" + ((Object) url) + ": no !/");
            }
            ctxFile = ctxFile.substring(0, bangSlash);
        }
        if (!ctxFile.endsWith("/") && !spec.startsWith("/")) {
            int lastSlash = ctxFile.lastIndexOf(47);
            if (lastSlash == -1) {
                throw new NullPointerException("malformed context url:" + ((Object) url));
            }
            ctxFile = ctxFile.substring(0, lastSlash + 1);
        }
        return ctxFile + spec;
    }
}
