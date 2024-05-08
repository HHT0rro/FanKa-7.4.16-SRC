package java.lang;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ProcessBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private List<String> command;
    private File directory;
    private Map<String, String> environment;
    private boolean redirectErrorStream;
    private Redirect[] redirects;

    public ProcessBuilder(List<String> command) {
        if (command == null) {
            throw new NullPointerException();
        }
        this.command = command;
    }

    public ProcessBuilder(String... command) {
        this.command = new ArrayList(command.length);
        for (String arg : command) {
            this.command.add(arg);
        }
    }

    public ProcessBuilder command(List<String> command) {
        if (command == null) {
            throw new NullPointerException();
        }
        this.command = command;
        return this;
    }

    public ProcessBuilder command(String... command) {
        this.command = new ArrayList(command.length);
        for (String arg : command) {
            this.command.add(arg);
        }
        return this;
    }

    public List<String> command() {
        return this.command;
    }

    public Map<String, String> environment() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(new RuntimePermission("getenv.*"));
        }
        if (this.environment == null) {
            this.environment = ProcessEnvironment.environment();
        }
        return this.environment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcessBuilder environment(String[] envp) {
        if (envp != null) {
            this.environment = ProcessEnvironment.emptyEnvironment(envp.length);
            for (String envstring : envp) {
                if (envstring.indexOf(0) != -1) {
                    envstring = envstring.replaceFirst("\u0000.*", "");
                }
                int eqlsign = envstring.indexOf(61, 0);
                if (eqlsign != -1) {
                    this.environment.put(envstring.substring(0, eqlsign), envstring.substring(eqlsign + 1));
                }
            }
        }
        return this;
    }

    public File directory() {
        return this.directory;
    }

    public ProcessBuilder directory(File directory) {
        this.directory = directory;
        return this;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class NullInputStream extends InputStream {
        static final NullInputStream INSTANCE = new NullInputStream();

        private NullInputStream() {
        }

        @Override // java.io.InputStream
        public int read() {
            return -1;
        }

        @Override // java.io.InputStream
        public int available() {
            return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class NullOutputStream extends OutputStream {
        static final NullOutputStream INSTANCE = new NullOutputStream();

        private NullOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int b4) throws IOException {
            throw new IOException("Stream closed");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Redirect {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final Redirect PIPE = new Redirect() { // from class: java.lang.ProcessBuilder.Redirect.1
            @Override // java.lang.ProcessBuilder.Redirect
            public Type type() {
                return Type.PIPE;
            }

            public String toString() {
                return type().toString();
            }
        };
        public static final Redirect INHERIT = new Redirect() { // from class: java.lang.ProcessBuilder.Redirect.2
            @Override // java.lang.ProcessBuilder.Redirect
            public Type type() {
                return Type.INHERIT;
            }

            public String toString() {
                return type().toString();
            }
        };

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public enum Type {
            PIPE,
            INHERIT,
            READ,
            WRITE,
            APPEND
        }

        public abstract Type type();

        public File file() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean append() {
            throw new UnsupportedOperationException();
        }

        public static Redirect from(final File file) {
            if (file == null) {
                throw new NullPointerException();
            }
            return new Redirect() { // from class: java.lang.ProcessBuilder.Redirect.3
                {
                    super();
                }

                @Override // java.lang.ProcessBuilder.Redirect
                public Type type() {
                    return Type.READ;
                }

                @Override // java.lang.ProcessBuilder.Redirect
                public File file() {
                    return File.this;
                }

                public String toString() {
                    return "redirect to read from file \"" + ((Object) File.this) + "\"";
                }
            };
        }

        public static Redirect to(final File file) {
            if (file == null) {
                throw new NullPointerException();
            }
            return new Redirect() { // from class: java.lang.ProcessBuilder.Redirect.4
                {
                    super();
                }

                @Override // java.lang.ProcessBuilder.Redirect
                public Type type() {
                    return Type.WRITE;
                }

                @Override // java.lang.ProcessBuilder.Redirect
                public File file() {
                    return File.this;
                }

                public String toString() {
                    return "redirect to write to file \"" + ((Object) File.this) + "\"";
                }

                @Override // java.lang.ProcessBuilder.Redirect
                boolean append() {
                    return false;
                }
            };
        }

        public static Redirect appendTo(final File file) {
            if (file == null) {
                throw new NullPointerException();
            }
            return new Redirect() { // from class: java.lang.ProcessBuilder.Redirect.5
                {
                    super();
                }

                @Override // java.lang.ProcessBuilder.Redirect
                public Type type() {
                    return Type.APPEND;
                }

                @Override // java.lang.ProcessBuilder.Redirect
                public File file() {
                    return File.this;
                }

                public String toString() {
                    return "redirect to append to file \"" + ((Object) File.this) + "\"";
                }

                @Override // java.lang.ProcessBuilder.Redirect
                boolean append() {
                    return true;
                }
            };
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Redirect)) {
                return false;
            }
            Redirect r10 = (Redirect) obj;
            if (r10.type() != type()) {
                return false;
            }
            return file().equals(r10.file());
        }

        public int hashCode() {
            File file = file();
            if (file == null) {
                return super.hashCode();
            }
            return file.hashCode();
        }

        private Redirect() {
        }
    }

    private Redirect[] redirects() {
        if (this.redirects == null) {
            this.redirects = new Redirect[]{Redirect.PIPE, Redirect.PIPE, Redirect.PIPE};
        }
        return this.redirects;
    }

    public ProcessBuilder redirectInput(Redirect source) {
        if (source.type() == Redirect.Type.WRITE || source.type() == Redirect.Type.APPEND) {
            throw new IllegalArgumentException("Redirect invalid for reading: " + ((Object) source));
        }
        redirects()[0] = source;
        return this;
    }

    public ProcessBuilder redirectOutput(Redirect destination) {
        if (destination.type() == Redirect.Type.READ) {
            throw new IllegalArgumentException("Redirect invalid for writing: " + ((Object) destination));
        }
        redirects()[1] = destination;
        return this;
    }

    public ProcessBuilder redirectError(Redirect destination) {
        if (destination.type() == Redirect.Type.READ) {
            throw new IllegalArgumentException("Redirect invalid for writing: " + ((Object) destination));
        }
        redirects()[2] = destination;
        return this;
    }

    public ProcessBuilder redirectInput(File file) {
        return redirectInput(Redirect.from(file));
    }

    public ProcessBuilder redirectOutput(File file) {
        return redirectOutput(Redirect.to(file));
    }

    public ProcessBuilder redirectError(File file) {
        return redirectError(Redirect.to(file));
    }

    public Redirect redirectInput() {
        Redirect[] redirectArr = this.redirects;
        return redirectArr == null ? Redirect.PIPE : redirectArr[0];
    }

    public Redirect redirectOutput() {
        Redirect[] redirectArr = this.redirects;
        return redirectArr == null ? Redirect.PIPE : redirectArr[1];
    }

    public Redirect redirectError() {
        Redirect[] redirectArr = this.redirects;
        return redirectArr == null ? Redirect.PIPE : redirectArr[2];
    }

    public ProcessBuilder inheritIO() {
        Arrays.fill(redirects(), Redirect.INHERIT);
        return this;
    }

    public boolean redirectErrorStream() {
        return this.redirectErrorStream;
    }

    public ProcessBuilder redirectErrorStream(boolean redirectErrorStream) {
        this.redirectErrorStream = redirectErrorStream;
        return this;
    }

    public Process start() throws IOException {
        List<String> list = this.command;
        String[] cmdarray = (String[]) ((String[]) list.toArray(new String[list.size()])).clone();
        for (String arg : cmdarray) {
            if (arg == null) {
                throw new NullPointerException();
            }
        }
        String prog = cmdarray[0];
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkExec(prog);
        }
        File file = this.directory;
        String dir = file == null ? null : file.toString();
        for (int i10 = 1; i10 < cmdarray.length; i10++) {
            if (cmdarray[i10].indexOf(0) >= 0) {
                throw new IOException("invalid null character in command");
            }
        }
        try {
            return ProcessImpl.start(cmdarray, this.environment, dir, this.redirects, this.redirectErrorStream);
        } catch (IOException | IllegalArgumentException e2) {
            String exceptionInfo = ": " + e2.getMessage();
            Throwable cause = e2;
            if ((e2 instanceof IOException) && security != null) {
                try {
                    security.checkRead(prog);
                } catch (SecurityException se) {
                    exceptionInfo = "";
                    cause = se;
                }
            }
            throw new IOException("Cannot run program \"" + prog + "\"" + (dir == null ? "" : " (in directory \"" + dir + "\")") + exceptionInfo, cause);
        }
    }
}
