package sun.net.ftp.impl;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.Attributes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectStreamConstants;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Utf8;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.time.TimeZones;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpDirEntry;
import sun.net.ftp.FtpDirParser;
import sun.net.ftp.FtpProtocolException;
import sun.net.ftp.FtpReplyCode;
import sun.security.util.DerValue;
import sun.util.logging.PlatformLogger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FtpClient extends sun.net.ftp.FtpClient {
    private static String[] MDTMformats;
    private static SimpleDateFormat[] dateFormats;
    private static int defaultConnectTimeout;
    private static int defaultSoTimeout;
    private static String encoding;
    private static Pattern epsvPat;
    private static Pattern pasvPat;
    private static Pattern[] patterns;
    private static Pattern transPat;
    private InputStream in;
    private String lastFileName;
    private Socket oldSocket;
    private PrintStream out;
    private Proxy proxy;
    private Socket server;
    private InetSocketAddress serverAddr;
    private SSLSocketFactory sslFact;
    private String welcomeMsg;
    private static final PlatformLogger logger = PlatformLogger.getLogger("sun.net.ftp.FtpClient");
    private static String[] patStrings = {"([\\-ld](?:[r\\-][w\\-][x\\-]){3})\\s*\\d+ (\\w+)\\s*(\\w+)\\s*(\\d+)\\s*([A-Z][a-z][a-z]\\s*\\d+)\\s*(\\d\\d:\\d\\d)\\s*(\\p{Print}*)", "([\\-ld](?:[r\\-][w\\-][x\\-]){3})\\s*\\d+ (\\w+)\\s*(\\w+)\\s*(\\d+)\\s*([A-Z][a-z][a-z]\\s*\\d+)\\s*(\\d{4})\\s*(\\p{Print}*)", "(\\d{2}/\\d{2}/\\d{4})\\s*(\\d{2}:\\d{2}[ap])\\s*((?:[0-9,]+)|(?:<DIR>))\\s*(\\p{Graph}*)", "(\\d{2}-\\d{2}-\\d{2})\\s*(\\d{2}:\\d{2}[AP]M)\\s*((?:[0-9,]+)|(?:<DIR>))\\s*(\\p{Graph}*)"};
    private static int[][] patternGroups = {new int[]{7, 4, 5, 6, 0, 1, 2, 3}, new int[]{7, 4, 5, 0, 6, 1, 2, 3}, new int[]{4, 3, 1, 2, 0, 0, 0, 0}, new int[]{4, 3, 1, 2, 0, 0, 0, 0}};
    private static Pattern linkp = Pattern.compile("(\\p{Print}+) \\-\\> (\\p{Print}+)$");
    private int readTimeout = -1;
    private int connectTimeout = -1;
    private boolean replyPending = false;
    private boolean loggedIn = false;
    private boolean useCrypto = false;
    private Vector<String> serverResponse = new Vector<>(1);
    private FtpReplyCode lastReplyCode = null;
    private final boolean passiveMode = true;
    private FtpClient.TransferType type = FtpClient.TransferType.BINARY;
    private long restartOffset = 0;
    private long lastTransSize = -1;
    private DateFormat df = DateFormat.getDateInstance(2, Locale.US);
    private FtpDirParser parser = new DefaultParser();
    private FtpDirParser mlsxParser = new MLSxParser();

    static {
        encoding = "ISO8859_1";
        final int[] vals = {0, 0};
        final String[] encs = {null};
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: sun.net.ftp.impl.FtpClient.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                vals[0] = Integer.getInteger("sun.net.client.defaultReadTimeout", 0).intValue();
                vals[1] = Integer.getInteger("sun.net.client.defaultConnectTimeout", 0).intValue();
                encs[0] = System.getProperty("file.encoding", "ISO8859_1");
                return null;
            }
        });
        if (vals[0] == 0) {
            defaultSoTimeout = -1;
        } else {
            defaultSoTimeout = vals[0];
        }
        if (vals[1] == 0) {
            defaultConnectTimeout = -1;
        } else {
            defaultConnectTimeout = vals[1];
        }
        String str = encs[0];
        encoding = str;
        try {
            if (!isASCIISuperset(str)) {
                encoding = "ISO8859_1";
            }
        } catch (Exception e2) {
            encoding = "ISO8859_1";
        }
        patterns = new Pattern[patStrings.length];
        int i10 = 0;
        while (true) {
            String[] strArr = patStrings;
            if (i10 >= strArr.length) {
                break;
            }
            patterns[i10] = Pattern.compile(strArr[i10]);
            i10++;
        }
        transPat = null;
        epsvPat = null;
        pasvPat = null;
        String[] strArr2 = {"yyyyMMddHHmmss.SSS", "yyyyMMddHHmmss"};
        MDTMformats = strArr2;
        dateFormats = new SimpleDateFormat[strArr2.length];
        for (int i11 = 0; i11 < MDTMformats.length; i11++) {
            dateFormats[i11] = new SimpleDateFormat(MDTMformats[i11]);
            dateFormats[i11].setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        }
    }

    private static boolean isASCIISuperset(String encoding2) throws Exception {
        byte[] chkB = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 45, 95, 46, 33, 126, ExifInterface.START_CODE, 39, 40, 41, 59, 47, Utf8.REPLACEMENT_BYTE, 58, DerValue.TAG_APPLICATION, 38, 61, 43, 36, 44};
        byte[] b4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_.!~*'();/?:@&=+$,".getBytes(encoding2);
        return Arrays.equals(b4, chkB);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class DefaultParser implements FtpDirParser {
        private DefaultParser() {
        }

        @Override // sun.net.ftp.FtpDirParser
        public FtpDirEntry parseLine(String line) {
            Date d10;
            Date d11;
            FtpDirEntry.Type type;
            Calendar now = Calendar.getInstance();
            int year = now.get(1);
            String fdate = null;
            boolean dir = false;
            String groupname = null;
            String username = null;
            String permstring = null;
            String filename = null;
            String time = null;
            String fsize = null;
            for (int j10 = 0; j10 < FtpClient.patterns.length; j10++) {
                Matcher m10 = FtpClient.patterns[j10].matcher(line);
                if (m10.find()) {
                    filename = m10.group(FtpClient.patternGroups[j10][0]);
                    fsize = m10.group(FtpClient.patternGroups[j10][1]);
                    fdate = m10.group(FtpClient.patternGroups[j10][2]);
                    if (FtpClient.patternGroups[j10][4] > 0) {
                        fdate = fdate + ", " + m10.group(FtpClient.patternGroups[j10][4]);
                    } else if (FtpClient.patternGroups[j10][3] > 0) {
                        fdate = fdate + ", " + String.valueOf(year);
                    }
                    if (FtpClient.patternGroups[j10][3] > 0) {
                        time = m10.group(FtpClient.patternGroups[j10][3]);
                    }
                    if (FtpClient.patternGroups[j10][5] > 0) {
                        permstring = m10.group(FtpClient.patternGroups[j10][5]);
                        dir = permstring.startsWith("d");
                    }
                    if (FtpClient.patternGroups[j10][6] > 0) {
                        username = m10.group(FtpClient.patternGroups[j10][6]);
                    }
                    if (FtpClient.patternGroups[j10][7] > 0) {
                        groupname = m10.group(FtpClient.patternGroups[j10][7]);
                    }
                    if ("<DIR>".equals(fsize)) {
                        fsize = null;
                        dir = true;
                    }
                }
            }
            if (filename != null) {
                try {
                    d10 = FtpClient.this.df.parse(fdate);
                } catch (Exception e2) {
                    d10 = null;
                }
                if (d10 != null && time != null) {
                    int c4 = time.indexOf(u.bD);
                    now.setTime(d10);
                    now.set(10, Integer.parseInt(time.substring(0, c4)));
                    now.set(12, Integer.parseInt(time.substring(c4 + 1)));
                    d11 = now.getTime();
                } else {
                    d11 = d10;
                }
                Matcher m22 = FtpClient.linkp.matcher(filename);
                if (m22.find()) {
                    filename = m22.group(1);
                }
                boolean[][] perms = (boolean[][]) Array.newInstance(Boolean.TYPE, 3, 3);
                int i10 = 0;
                while (true) {
                    String time2 = time;
                    if (i10 >= 3) {
                        break;
                    }
                    Calendar now2 = now;
                    int j11 = 0;
                    for (int i11 = 3; j11 < i11; i11 = 3) {
                        String permstring2 = permstring;
                        perms[i10][j11] = permstring.charAt((i10 * 3) + j11) != '-';
                        j11++;
                        permstring = permstring2;
                    }
                    i10++;
                    time = time2;
                    now = now2;
                }
                FtpDirEntry file = new FtpDirEntry(filename);
                file.setUser(username).setGroup(groupname);
                file.setSize(Long.parseLong(fsize)).setLastModified(d11);
                file.setPermissions(perms);
                if (dir) {
                    type = FtpDirEntry.Type.DIR;
                } else {
                    type = line.charAt(0) == 'l' ? FtpDirEntry.Type.LINK : FtpDirEntry.Type.FILE;
                }
                file.setType(type);
                return file;
            }
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class MLSxParser implements FtpDirParser {
        private SimpleDateFormat df;

        private MLSxParser() {
            this.df = new SimpleDateFormat("yyyyMMddhhmmss");
        }

        @Override // sun.net.ftp.FtpDirParser
        public FtpDirEntry parseLine(String line) {
            String name;
            String line2;
            String s2;
            int i10 = line.lastIndexOf(";");
            if (i10 > 0) {
                name = line.substring(i10 + 1).trim();
                line2 = line.substring(0, i10);
            } else {
                name = line.trim();
                line2 = "";
            }
            FtpDirEntry file = new FtpDirEntry(name);
            while (!line2.isEmpty()) {
                int i11 = line2.indexOf(";");
                if (i11 > 0) {
                    s2 = line2.substring(0, i11);
                    line2 = line2.substring(i11 + 1);
                } else {
                    s2 = line2;
                    line2 = "";
                }
                int i12 = s2.indexOf("=");
                if (i12 > 0) {
                    String fact = s2.substring(0, i12);
                    String value = s2.substring(i12 + 1);
                    file.addFact(fact, value);
                }
            }
            String s10 = file.getFact("Size");
            if (s10 != null) {
                file.setSize(Long.parseLong(s10));
            }
            String s11 = file.getFact("Modify");
            if (s11 != null) {
                Date d10 = null;
                try {
                    d10 = this.df.parse(s11);
                } catch (ParseException e2) {
                }
                if (d10 != null) {
                    file.setLastModified(d10);
                }
            }
            String s12 = file.getFact("Create");
            if (s12 != null) {
                Date d11 = null;
                try {
                    d11 = this.df.parse(s12);
                } catch (ParseException e10) {
                }
                if (d11 != null) {
                    file.setCreated(d11);
                }
            }
            String s13 = file.getFact("Type");
            if (s13 != null) {
                if (s13.equalsIgnoreCase("file")) {
                    file.setType(FtpDirEntry.Type.FILE);
                }
                if (s13.equalsIgnoreCase(Attributes.Style.DIR)) {
                    file.setType(FtpDirEntry.Type.DIR);
                }
                if (s13.equalsIgnoreCase("cdir")) {
                    file.setType(FtpDirEntry.Type.CDIR);
                }
                if (s13.equalsIgnoreCase("pdir")) {
                    file.setType(FtpDirEntry.Type.PDIR);
                }
            }
            return file;
        }
    }

    private void getTransferSize() {
        this.lastTransSize = -1L;
        String response = getLastResponseString();
        if (transPat == null) {
            transPat = Pattern.compile("150 Opening .*\\((\\d+) bytes\\).");
        }
        Matcher m10 = transPat.matcher(response);
        if (m10.find()) {
            String s2 = m10.group(1);
            this.lastTransSize = Long.parseLong(s2);
        }
    }

    private void getTransferName() {
        this.lastFileName = null;
        String response = getLastResponseString();
        int i10 = response.indexOf("unique file name:");
        int e2 = response.lastIndexOf(41);
        if (i10 >= 0) {
            this.lastFileName = response.substring(i10 + 17, e2);
        }
    }

    private int readServerResponse() throws IOException {
        int code;
        StringBuffer replyBuf = new StringBuffer(32);
        int continuingCode = -1;
        this.serverResponse.setSize(0);
        while (true) {
            int read = this.in.read();
            int c4 = read;
            if (read != -1) {
                if (c4 == 13) {
                    int read2 = this.in.read();
                    c4 = read2;
                    if (read2 != 10) {
                        replyBuf.append(CharUtils.CR);
                    }
                }
                replyBuf.append((char) c4);
                if (c4 != 10) {
                    continue;
                }
            }
            String response = replyBuf.toString();
            replyBuf.setLength(0);
            PlatformLogger platformLogger = logger;
            if (platformLogger.isLoggable(PlatformLogger.Level.FINEST)) {
                platformLogger.finest("Server [" + ((Object) this.serverAddr) + "] --> " + response);
            }
            if (response.length() == 0) {
                code = -1;
            } else {
                try {
                    code = Integer.parseInt(response.substring(0, 3));
                } catch (NumberFormatException e2) {
                    code = -1;
                } catch (StringIndexOutOfBoundsException e10) {
                }
            }
            this.serverResponse.addElement(response);
            if (continuingCode != -1) {
                if (code == continuingCode && (response.length() < 4 || response.charAt(3) != '-')) {
                    break;
                }
            } else {
                if (response.length() < 4 || response.charAt(3) != '-') {
                    break;
                }
                continuingCode = code;
            }
        }
        return code;
    }

    private void sendServer(String cmd) {
        this.out.print(cmd);
        PlatformLogger platformLogger = logger;
        if (platformLogger.isLoggable(PlatformLogger.Level.FINEST)) {
            platformLogger.finest("Server [" + ((Object) this.serverAddr) + "] <-- " + cmd);
        }
    }

    private String getResponseString() {
        return this.serverResponse.elementAt(0);
    }

    private Vector<String> getResponseStrings() {
        return this.serverResponse;
    }

    private boolean readReply() throws IOException {
        FtpReplyCode find = FtpReplyCode.find(readServerResponse());
        this.lastReplyCode = find;
        if (find.isPositivePreliminary()) {
            this.replyPending = true;
            return true;
        }
        if (this.lastReplyCode.isPositiveCompletion() || this.lastReplyCode.isPositiveIntermediate()) {
            if (this.lastReplyCode == FtpReplyCode.CLOSING_DATA_CONNECTION) {
                getTransferName();
            }
            return true;
        }
        return false;
    }

    private boolean issueCommand(String cmd) throws IOException, FtpProtocolException {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected");
        }
        if (this.replyPending) {
            try {
                completePending();
            } catch (FtpProtocolException e2) {
            }
        }
        if (cmd.indexOf(10) != -1) {
            FtpProtocolException ex = new FtpProtocolException("Illegal FTP command");
            ex.initCause(new IllegalArgumentException("Illegal carriage return"));
            throw ex;
        }
        sendServer(cmd + IOUtils.LINE_SEPARATOR_WINDOWS);
        return readReply();
    }

    private void issueCommandCheck(String cmd) throws FtpProtocolException, IOException {
        if (!issueCommand(cmd)) {
            throw new FtpProtocolException(cmd + u.bD + getResponseString(), getLastReplyCode());
        }
    }

    private Socket openPassiveDataConnection(String cmd) throws FtpProtocolException, IOException {
        InetSocketAddress dest;
        Socket s2;
        if (issueCommand("EPSV ALL")) {
            issueCommandCheck("EPSV");
            String serverAnswer = getResponseString();
            if (epsvPat == null) {
                epsvPat = Pattern.compile("^229 .* \\(\\|\\|\\|(\\d+)\\|\\)");
            }
            Matcher m10 = epsvPat.matcher(serverAnswer);
            if (!m10.find()) {
                throw new FtpProtocolException("EPSV failed : " + serverAnswer);
            }
            String s10 = m10.group(1);
            int port = Integer.parseInt(s10);
            InetAddress add = this.server.getInetAddress();
            if (add != null) {
                dest = new InetSocketAddress(add, port);
            } else {
                dest = InetSocketAddress.createUnresolved(this.serverAddr.getHostName(), port);
            }
        } else {
            issueCommandCheck("PASV");
            String serverAnswer2 = getResponseString();
            if (pasvPat == null) {
                pasvPat = Pattern.compile("227 .* \\(?(\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)?");
            }
            Matcher m11 = pasvPat.matcher(serverAnswer2);
            if (!m11.find()) {
                throw new FtpProtocolException("PASV failed : " + serverAnswer2);
            }
            int port2 = (Integer.parseInt(m11.group(2)) << 8) + Integer.parseInt(m11.group(3));
            String s11 = m11.group(1).replace(',', '.');
            dest = new InetSocketAddress(s11, port2);
        }
        Proxy proxy = this.proxy;
        if (proxy != null) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                s2 = (Socket) AccessController.doPrivileged(new PrivilegedAction<Socket>() { // from class: sun.net.ftp.impl.FtpClient.2
                    @Override // java.security.PrivilegedAction
                    public Socket run() {
                        return new Socket(FtpClient.this.proxy);
                    }
                });
            } else {
                s2 = new Socket(Proxy.NO_PROXY);
            }
        } else {
            s2 = new Socket();
        }
        InetAddress serverAddress = (InetAddress) AccessController.doPrivileged(new PrivilegedAction<InetAddress>() { // from class: sun.net.ftp.impl.FtpClient.3
            @Override // java.security.PrivilegedAction
            public InetAddress run() {
                return FtpClient.this.server.getLocalAddress();
            }
        });
        s2.bind(new InetSocketAddress(serverAddress, 0));
        int i10 = this.connectTimeout;
        if (i10 >= 0) {
            s2.connect(dest, i10);
        } else {
            int i11 = defaultConnectTimeout;
            if (i11 > 0) {
                s2.connect(dest, i11);
            } else {
                s2.connect(dest);
            }
        }
        int i12 = this.readTimeout;
        if (i12 >= 0) {
            s2.setSoTimeout(i12);
        } else {
            int i13 = defaultSoTimeout;
            if (i13 > 0) {
                s2.setSoTimeout(i13);
            }
        }
        if (this.useCrypto) {
            try {
                s2 = this.sslFact.createSocket(s2, dest.getHostName(), dest.getPort(), true);
            } catch (Exception e2) {
                throw new FtpProtocolException("Can't open secure data channel: " + ((Object) e2));
            }
        }
        if (!issueCommand(cmd)) {
            s2.close();
            if (getLastReplyCode() == FtpReplyCode.FILE_UNAVAILABLE) {
                throw new FileNotFoundException(cmd);
            }
            throw new FtpProtocolException(cmd + u.bD + getResponseString(), getLastReplyCode());
        }
        return s2;
    }

    private Socket openDataConnection(String cmd) throws FtpProtocolException, IOException {
        try {
            return openPassiveDataConnection(cmd);
        } catch (FtpProtocolException e2) {
            String errmsg = e2.getMessage();
            if (!errmsg.startsWith("PASV") && !errmsg.startsWith("EPSV")) {
                throw e2;
            }
            Proxy proxy = this.proxy;
            if (proxy != null && proxy.type() == Proxy.Type.SOCKS) {
                throw new FtpProtocolException("Passive mode failed");
            }
            ServerSocket portSocket = new ServerSocket(0, 1, this.server.getLocalAddress());
            try {
                InetAddress myAddress = portSocket.getInetAddress();
                if (myAddress.isAnyLocalAddress()) {
                    myAddress = this.server.getLocalAddress();
                }
                String portCmd = "EPRT |" + (myAddress instanceof Inet6Address ? "2" : "1") + "|" + myAddress.getHostAddress() + "|" + portSocket.getLocalPort() + "|";
                if (!issueCommand(portCmd) || !issueCommand(cmd)) {
                    String portCmd2 = "PORT ";
                    byte[] addr = myAddress.getAddress();
                    for (byte b4 : addr) {
                        portCmd2 = portCmd2 + (b4 & 255) + ",";
                    }
                    issueCommandCheck(portCmd2 + ((portSocket.getLocalPort() >>> 8) & 255) + "," + (portSocket.getLocalPort() & 255));
                    issueCommandCheck(cmd);
                }
                int i10 = this.connectTimeout;
                if (i10 >= 0) {
                    portSocket.setSoTimeout(i10);
                } else {
                    int i11 = defaultConnectTimeout;
                    if (i11 > 0) {
                        portSocket.setSoTimeout(i11);
                    }
                }
                Socket clientSocket = portSocket.accept();
                int i12 = this.readTimeout;
                if (i12 >= 0) {
                    clientSocket.setSoTimeout(i12);
                } else {
                    int i13 = defaultSoTimeout;
                    if (i13 > 0) {
                        clientSocket.setSoTimeout(i13);
                    }
                }
                portSocket.close();
                if (this.useCrypto) {
                    try {
                        return this.sslFact.createSocket(clientSocket, this.serverAddr.getHostName(), this.serverAddr.getPort(), true);
                    } catch (Exception ex) {
                        throw new IOException(ex.getLocalizedMessage());
                    }
                }
                return clientSocket;
            } catch (Throwable th) {
                portSocket.close();
                throw th;
            }
        }
    }

    private InputStream createInputStream(InputStream in) {
        if (this.type == FtpClient.TransferType.ASCII) {
            return new TelnetInputStream(in, false);
        }
        return in;
    }

    private OutputStream createOutputStream(OutputStream out) {
        if (this.type == FtpClient.TransferType.ASCII) {
            return new TelnetOutputStream(out, false);
        }
        return out;
    }

    protected FtpClient() {
    }

    public static sun.net.ftp.FtpClient create() {
        return new FtpClient();
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient enablePassiveMode(boolean passive) {
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public boolean isPassiveModeEnabled() {
        return true;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient setConnectTimeout(int timeout) {
        this.connectTimeout = timeout;
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient setReadTimeout(int timeout) {
        this.readTimeout = timeout;
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public int getReadTimeout() {
        return this.readTimeout;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient setProxy(Proxy p10) {
        this.proxy = p10;
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public Proxy getProxy() {
        return this.proxy;
    }

    private void tryConnect(InetSocketAddress dest, int timeout) throws IOException {
        if (isConnected()) {
            disconnect();
        }
        Socket doConnect = doConnect(dest, timeout);
        this.server = doConnect;
        try {
            this.out = new PrintStream((OutputStream) new BufferedOutputStream(doConnect.getOutputStream()), true, encoding);
            this.in = new BufferedInputStream(this.server.getInputStream());
        } catch (UnsupportedEncodingException e2) {
            throw new InternalError(encoding + "encoding not found", e2);
        }
    }

    private Socket doConnect(InetSocketAddress dest, int timeout) throws IOException {
        Socket s2;
        Proxy proxy = this.proxy;
        if (proxy != null) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                s2 = (Socket) AccessController.doPrivileged(new PrivilegedAction<Socket>() { // from class: sun.net.ftp.impl.FtpClient.4
                    @Override // java.security.PrivilegedAction
                    public Socket run() {
                        return new Socket(FtpClient.this.proxy);
                    }
                });
            } else {
                s2 = new Socket(Proxy.NO_PROXY);
            }
        } else {
            s2 = new Socket();
        }
        if (timeout >= 0) {
            s2.connect(dest, timeout);
        } else {
            int i10 = this.connectTimeout;
            if (i10 >= 0) {
                s2.connect(dest, i10);
            } else {
                int i11 = defaultConnectTimeout;
                if (i11 > 0) {
                    s2.connect(dest, i11);
                } else {
                    s2.connect(dest);
                }
            }
        }
        int i12 = this.readTimeout;
        if (i12 >= 0) {
            s2.setSoTimeout(i12);
        } else {
            int i13 = defaultSoTimeout;
            if (i13 > 0) {
                s2.setSoTimeout(i13);
            }
        }
        return s2;
    }

    private void disconnect() throws IOException {
        if (isConnected()) {
            this.server.close();
        }
        this.server = null;
        this.in = null;
        this.out = null;
        this.lastTransSize = -1L;
        this.lastFileName = null;
        this.restartOffset = 0L;
        this.welcomeMsg = null;
        this.lastReplyCode = null;
        this.serverResponse.setSize(0);
    }

    @Override // sun.net.ftp.FtpClient
    public boolean isConnected() {
        return this.server != null;
    }

    @Override // sun.net.ftp.FtpClient
    public SocketAddress getServerAddress() {
        Socket socket = this.server;
        if (socket == null) {
            return null;
        }
        return socket.getRemoteSocketAddress();
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient connect(SocketAddress dest) throws FtpProtocolException, IOException {
        return connect(dest, -1);
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient connect(SocketAddress dest, int timeout) throws FtpProtocolException, IOException {
        if (!(dest instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Wrong address type");
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) dest;
        this.serverAddr = inetSocketAddress;
        tryConnect(inetSocketAddress, timeout);
        if (!readReply()) {
            throw new FtpProtocolException("Welcome message: " + getResponseString(), this.lastReplyCode);
        }
        this.welcomeMsg = getResponseString().substring(4);
        return this;
    }

    private void tryLogin(String user, char[] password) throws FtpProtocolException, IOException {
        issueCommandCheck("USER " + user);
        if (this.lastReplyCode == FtpReplyCode.NEED_PASSWORD && password != null && password.length > 0) {
            issueCommandCheck("PASS " + String.valueOf(password));
        }
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient login(String user, char[] password) throws FtpProtocolException, IOException {
        if (!isConnected()) {
            throw new FtpProtocolException("Not connected yet", FtpReplyCode.BAD_SEQUENCE);
        }
        if (user == null || user.length() == 0) {
            throw new IllegalArgumentException("User name can't be null or empty");
        }
        tryLogin(user, password);
        StringBuffer sb2 = new StringBuffer();
        for (int i10 = 0; i10 < this.serverResponse.size(); i10++) {
            String l10 = this.serverResponse.elementAt(i10);
            if (l10 != null) {
                if (l10.length() >= 4 && l10.startsWith("230")) {
                    l10 = l10.substring(4);
                }
                sb2.append(l10);
            }
        }
        this.welcomeMsg = sb2.toString();
        this.loggedIn = true;
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient login(String user, char[] password, String account) throws FtpProtocolException, IOException {
        if (!isConnected()) {
            throw new FtpProtocolException("Not connected yet", FtpReplyCode.BAD_SEQUENCE);
        }
        if (user == null || user.length() == 0) {
            throw new IllegalArgumentException("User name can't be null or empty");
        }
        tryLogin(user, password);
        if (this.lastReplyCode == FtpReplyCode.NEED_ACCOUNT) {
            issueCommandCheck("ACCT " + account);
        }
        StringBuffer sb2 = new StringBuffer();
        Vector<String> vector = this.serverResponse;
        if (vector != null) {
            Iterator<String> iterator2 = vector.iterator2();
            while (iterator2.hasNext()) {
                String l10 = iterator2.next();
                if (l10 != null) {
                    if (l10.length() >= 4 && l10.startsWith("230")) {
                        l10 = l10.substring(4);
                    }
                    sb2.append(l10);
                }
            }
        }
        this.welcomeMsg = sb2.toString();
        this.loggedIn = true;
        return this;
    }

    @Override // sun.net.ftp.FtpClient, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (isConnected()) {
            try {
                issueCommand("QUIT");
            } catch (FtpProtocolException e2) {
            }
            this.loggedIn = false;
        }
        disconnect();
    }

    @Override // sun.net.ftp.FtpClient
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient changeDirectory(String remoteDirectory) throws FtpProtocolException, IOException {
        if (remoteDirectory == null || "".equals(remoteDirectory)) {
            throw new IllegalArgumentException("directory can't be null or empty");
        }
        issueCommandCheck("CWD " + remoteDirectory);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient changeToParentDirectory() throws FtpProtocolException, IOException {
        issueCommandCheck("CDUP");
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public String getWorkingDirectory() throws FtpProtocolException, IOException {
        issueCommandCheck("PWD");
        String answ = getResponseString();
        if (!answ.startsWith("257")) {
            return null;
        }
        return answ.substring(5, answ.lastIndexOf(34));
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient setRestartOffset(long offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("offset can't be negative");
        }
        this.restartOffset = offset;
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient getFile(String name, OutputStream local) throws FtpProtocolException, IOException {
        if (this.restartOffset > 0) {
            try {
                Socket s2 = openDataConnection("REST " + this.restartOffset);
                this.restartOffset = 0L;
                issueCommandCheck("RETR " + name);
                getTransferSize();
                InputStream remote = createInputStream(s2.getInputStream());
                byte[] buf = new byte[1500 * 10];
                while (true) {
                    int l10 = remote.read(buf);
                    if (l10 < 0) {
                        break;
                    }
                    if (l10 > 0) {
                        local.write(buf, 0, l10);
                    }
                }
                remote.close();
            } catch (Throwable th) {
                this.restartOffset = 0L;
                throw th;
            }
        } else {
            Socket s10 = openDataConnection("RETR " + name);
            getTransferSize();
            InputStream remote2 = createInputStream(s10.getInputStream());
            byte[] buf2 = new byte[1500 * 10];
            while (true) {
                int l11 = remote2.read(buf2);
                if (l11 < 0) {
                    break;
                }
                if (l11 > 0) {
                    local.write(buf2, 0, l11);
                }
            }
            remote2.close();
        }
        return completePending();
    }

    @Override // sun.net.ftp.FtpClient
    public InputStream getFileStream(String name) throws FtpProtocolException, IOException {
        if (this.restartOffset > 0) {
            try {
                Socket s2 = openDataConnection("REST " + this.restartOffset);
                if (s2 == null) {
                    return null;
                }
                issueCommandCheck("RETR " + name);
                getTransferSize();
                return createInputStream(s2.getInputStream());
            } finally {
                this.restartOffset = 0L;
            }
        }
        Socket s10 = openDataConnection("RETR " + name);
        if (s10 == null) {
            return null;
        }
        getTransferSize();
        return createInputStream(s10.getInputStream());
    }

    @Override // sun.net.ftp.FtpClient
    public OutputStream putFileStream(String name, boolean unique) throws FtpProtocolException, IOException {
        String cmd = unique ? "STOU " : "STOR ";
        Socket s2 = openDataConnection(cmd + name);
        if (s2 == null) {
            return null;
        }
        boolean bm = this.type == FtpClient.TransferType.BINARY;
        return new TelnetOutputStream(s2.getOutputStream(), bm);
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient putFile(String name, InputStream local, boolean unique) throws FtpProtocolException, IOException {
        String cmd = unique ? "STOU " : "STOR ";
        if (this.type == FtpClient.TransferType.BINARY) {
            Socket s2 = openDataConnection(cmd + name);
            OutputStream remote = createOutputStream(s2.getOutputStream());
            byte[] buf = new byte[1500 * 10];
            while (true) {
                int l10 = local.read(buf);
                if (l10 < 0) {
                    break;
                }
                if (l10 > 0) {
                    remote.write(buf, 0, l10);
                }
            }
            remote.close();
        }
        return completePending();
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient appendFile(String name, InputStream local) throws FtpProtocolException, IOException {
        Socket s2 = openDataConnection("APPE " + name);
        OutputStream remote = createOutputStream(s2.getOutputStream());
        byte[] buf = new byte[1500 * 10];
        while (true) {
            int l10 = local.read(buf);
            if (l10 >= 0) {
                if (l10 > 0) {
                    remote.write(buf, 0, l10);
                }
            } else {
                remote.close();
                return completePending();
            }
        }
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient rename(String from, String to) throws FtpProtocolException, IOException {
        issueCommandCheck("RNFR " + from);
        issueCommandCheck("RNTO " + to);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient deleteFile(String name) throws FtpProtocolException, IOException {
        issueCommandCheck("DELE " + name);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient makeDirectory(String name) throws FtpProtocolException, IOException {
        issueCommandCheck("MKD " + name);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient removeDirectory(String name) throws FtpProtocolException, IOException {
        issueCommandCheck("RMD " + name);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient noop() throws FtpProtocolException, IOException {
        issueCommandCheck("NOOP");
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public String getStatus(String name) throws FtpProtocolException, IOException {
        issueCommandCheck(name == null ? "STAT" : "STAT " + name);
        Vector<String> resp = getResponseStrings();
        StringBuffer sb2 = new StringBuffer();
        for (int i10 = 1; i10 < resp.size() - 1; i10++) {
            sb2.append(resp.get(i10));
        }
        return sb2.toString();
    }

    @Override // sun.net.ftp.FtpClient
    public List<String> getFeatures() throws FtpProtocolException, IOException {
        ArrayList<String> features = new ArrayList<>();
        issueCommandCheck("FEAT");
        Vector<String> resp = getResponseStrings();
        for (int i10 = 1; i10 < resp.size() - 1; i10++) {
            String s2 = resp.get(i10);
            features.add(s2.substring(1, s2.length() - 1));
        }
        return features;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient abort() throws FtpProtocolException, IOException {
        issueCommandCheck("ABOR");
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient completePending() throws FtpProtocolException, IOException {
        while (this.replyPending) {
            this.replyPending = false;
            if (!readReply()) {
                throw new FtpProtocolException(getLastResponseString(), this.lastReplyCode);
            }
        }
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient reInit() throws FtpProtocolException, IOException {
        issueCommandCheck("REIN");
        this.loggedIn = false;
        if (this.useCrypto) {
            Socket socket = this.server;
            if (socket instanceof SSLSocket) {
                SSLSession session = ((SSLSocket) socket).getSession();
                session.invalidate();
                Socket socket2 = this.oldSocket;
                this.server = socket2;
                this.oldSocket = null;
                try {
                    this.out = new PrintStream((OutputStream) new BufferedOutputStream(socket2.getOutputStream()), true, encoding);
                    this.in = new BufferedInputStream(this.server.getInputStream());
                } catch (UnsupportedEncodingException e2) {
                    throw new InternalError(encoding + "encoding not found", e2);
                }
            }
        }
        this.useCrypto = false;
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient setType(FtpClient.TransferType type) throws FtpProtocolException, IOException {
        String cmd = "NOOP";
        this.type = type;
        if (type == FtpClient.TransferType.ASCII) {
            cmd = "TYPE A";
        }
        if (type == FtpClient.TransferType.BINARY) {
            cmd = "TYPE I";
        }
        if (type == FtpClient.TransferType.EBCDIC) {
            cmd = "TYPE E";
        }
        issueCommandCheck(cmd);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public InputStream list(String path) throws FtpProtocolException, IOException {
        Socket s2 = openDataConnection(path == null ? "LIST" : "LIST " + path);
        if (s2 != null) {
            return createInputStream(s2.getInputStream());
        }
        return null;
    }

    @Override // sun.net.ftp.FtpClient
    public InputStream nameList(String path) throws FtpProtocolException, IOException {
        Socket s2 = openDataConnection(path == null ? "NLST" : "NLST " + path);
        if (s2 != null) {
            return createInputStream(s2.getInputStream());
        }
        return null;
    }

    @Override // sun.net.ftp.FtpClient
    public long getSize(String path) throws FtpProtocolException, IOException {
        if (path == null || path.length() == 0) {
            throw new IllegalArgumentException("path can't be null or empty");
        }
        issueCommandCheck("SIZE " + path);
        if (this.lastReplyCode == FtpReplyCode.FILE_STATUS) {
            String s2 = getResponseString();
            return Long.parseLong(s2.substring(4, s2.length() - 1));
        }
        return -1L;
    }

    @Override // sun.net.ftp.FtpClient
    public Date getLastModified(String path) throws FtpProtocolException, IOException {
        issueCommandCheck("MDTM " + path);
        if (this.lastReplyCode == FtpReplyCode.FILE_STATUS) {
            String s2 = getResponseString().substring(4);
            Date d10 = null;
            for (SimpleDateFormat dateFormat : dateFormats) {
                try {
                    d10 = dateFormat.parse(s2);
                } catch (ParseException e2) {
                }
                if (d10 != null) {
                    return d10;
                }
            }
            return null;
        }
        return null;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient setDirParser(FtpDirParser p10) {
        this.parser = p10;
        return this;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class FtpFileIterator implements Iterator<FtpDirEntry>, Closeable {
        private FtpDirParser fparser;
        private BufferedReader in;
        private FtpDirEntry nextFile = null;
        private boolean eof = false;

        public FtpFileIterator(FtpDirParser p10, BufferedReader in) {
            this.in = null;
            this.fparser = null;
            this.in = in;
            this.fparser = p10;
            readNext();
        }

        private void readNext() {
            String line;
            this.nextFile = null;
            if (this.eof) {
                return;
            }
            do {
                try {
                    line = this.in.readLine();
                    if (line != null) {
                        FtpDirEntry parseLine = this.fparser.parseLine(line);
                        this.nextFile = parseLine;
                        if (parseLine != null) {
                            return;
                        }
                    }
                } catch (IOException e2) {
                }
            } while (line != null);
            this.in.close();
            this.eof = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextFile != null;
        }

        @Override // java.util.Iterator
        public FtpDirEntry next() {
            FtpDirEntry ret = this.nextFile;
            readNext();
            return ret;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            BufferedReader bufferedReader = this.in;
            if (bufferedReader != null && !this.eof) {
                bufferedReader.close();
            }
            this.eof = true;
            this.nextFile = null;
        }
    }

    @Override // sun.net.ftp.FtpClient
    public Iterator<FtpDirEntry> listFiles(String path) throws FtpProtocolException, IOException {
        String str;
        Socket s2 = null;
        if (path == null) {
            str = "MLSD";
        } else {
            try {
                str = "MLSD " + path;
            } catch (FtpProtocolException e2) {
            }
        }
        s2 = openDataConnection(str);
        if (s2 != null) {
            BufferedReader sin = new BufferedReader(new InputStreamReader(s2.getInputStream()));
            return new FtpFileIterator(this.mlsxParser, sin);
        }
        Socket s10 = openDataConnection(path == null ? "LIST" : "LIST " + path);
        if (s10 != null) {
            BufferedReader sin2 = new BufferedReader(new InputStreamReader(s10.getInputStream()));
            return new FtpFileIterator(this.parser, sin2);
        }
        return null;
    }

    private boolean sendSecurityData(byte[] buf) throws IOException, FtpProtocolException {
        BASE64Encoder encoder = new BASE64Encoder();
        String s2 = encoder.encode(buf);
        return issueCommand("ADAT " + s2);
    }

    private byte[] getSecurityData() {
        String s2 = getLastResponseString();
        if (s2.substring(4, 9).equalsIgnoreCase("ADAT=")) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                return decoder.decodeBuffer(s2.substring(9, s2.length() - 1));
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient useKerberos() throws FtpProtocolException, IOException {
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public String getWelcomeMsg() {
        return this.welcomeMsg;
    }

    @Override // sun.net.ftp.FtpClient
    public FtpReplyCode getLastReplyCode() {
        return this.lastReplyCode;
    }

    @Override // sun.net.ftp.FtpClient
    public String getLastResponseString() {
        StringBuffer sb2 = new StringBuffer();
        Vector<String> vector = this.serverResponse;
        if (vector != null) {
            Iterator<String> iterator2 = vector.iterator2();
            while (iterator2.hasNext()) {
                String l10 = iterator2.next();
                if (l10 != null) {
                    sb2.append(l10);
                }
            }
        }
        return sb2.toString();
    }

    @Override // sun.net.ftp.FtpClient
    public long getLastTransferSize() {
        return this.lastTransSize;
    }

    @Override // sun.net.ftp.FtpClient
    public String getLastFileName() {
        return this.lastFileName;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient startSecureSession() throws FtpProtocolException, IOException {
        if (!isConnected()) {
            throw new FtpProtocolException("Not connected yet", FtpReplyCode.BAD_SEQUENCE);
        }
        if (this.sslFact == null) {
            try {
                this.sslFact = (SSLSocketFactory) SSLSocketFactory.getDefault();
            } catch (Exception e2) {
                throw new IOException(e2.getLocalizedMessage());
            }
        }
        issueCommandCheck("AUTH TLS");
        try {
            Socket s2 = this.sslFact.createSocket(this.server, this.serverAddr.getHostName(), this.serverAddr.getPort(), true);
            this.oldSocket = this.server;
            this.server = s2;
            try {
                this.out = new PrintStream((OutputStream) new BufferedOutputStream(s2.getOutputStream()), true, encoding);
                this.in = new BufferedInputStream(this.server.getInputStream());
                issueCommandCheck("PBSZ 0");
                issueCommandCheck("PROT P");
                this.useCrypto = true;
                return this;
            } catch (UnsupportedEncodingException e10) {
                throw new InternalError(encoding + "encoding not found", e10);
            }
        } catch (SSLException ssle) {
            try {
                disconnect();
            } catch (Exception e11) {
            }
            throw ssle;
        }
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient endSecureSession() throws FtpProtocolException, IOException {
        if (!this.useCrypto) {
            return this;
        }
        issueCommandCheck("CCC");
        issueCommandCheck("PROT C");
        this.useCrypto = false;
        Socket socket = this.oldSocket;
        this.server = socket;
        this.oldSocket = null;
        try {
            this.out = new PrintStream((OutputStream) new BufferedOutputStream(socket.getOutputStream()), true, encoding);
            this.in = new BufferedInputStream(this.server.getInputStream());
            return this;
        } catch (UnsupportedEncodingException e2) {
            throw new InternalError(encoding + "encoding not found", e2);
        }
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient allocate(long size) throws FtpProtocolException, IOException {
        issueCommandCheck("ALLO " + size);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient structureMount(String struct) throws FtpProtocolException, IOException {
        issueCommandCheck("SMNT " + struct);
        return this;
    }

    @Override // sun.net.ftp.FtpClient
    public String getSystem() throws FtpProtocolException, IOException {
        issueCommandCheck("SYST");
        String resp = getResponseString();
        return resp.substring(4);
    }

    @Override // sun.net.ftp.FtpClient
    public String getHelp(String cmd) throws FtpProtocolException, IOException {
        issueCommandCheck("HELP " + cmd);
        Vector<String> resp = getResponseStrings();
        if (resp.size() == 1) {
            return resp.get(0).substring(4);
        }
        StringBuffer sb2 = new StringBuffer();
        for (int i10 = 1; i10 < resp.size() - 1; i10++) {
            sb2.append(resp.get(i10).substring(3));
        }
        return sb2.toString();
    }

    @Override // sun.net.ftp.FtpClient
    public sun.net.ftp.FtpClient siteCmd(String cmd) throws FtpProtocolException, IOException {
        issueCommandCheck("SITE " + cmd);
        return this;
    }
}
