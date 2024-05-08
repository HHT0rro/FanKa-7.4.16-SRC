package sun.net.ext;

import java.io.FileDescriptor;
import java.net.SocketException;
import java.net.SocketOption;
import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ExtendedSocketOptions {
    public static final short SOCK_DGRAM = 2;
    public static final short SOCK_STREAM = 1;
    private static volatile ExtendedSocketOptions instance;
    private final Set<SocketOption<?>> options;

    public abstract Object getOption(FileDescriptor fileDescriptor, SocketOption<?> socketOption) throws SocketException;

    public abstract void setOption(FileDescriptor fileDescriptor, SocketOption<?> socketOption, Object obj) throws SocketException;

    public final boolean isOptionSupported(SocketOption<?> option) {
        return options().contains(option);
    }

    public final Set<SocketOption<?>> options() {
        return this.options;
    }

    public static final Set<SocketOption<?>> options(short type) {
        return getInstance().options0(type);
    }

    private Set<SocketOption<?>> options0(short type) {
        switch (type) {
            case 1:
                Set<SocketOption<?>> extOptions = (Set) this.options.stream().filter(new Predicate() { // from class: sun.net.ext.ExtendedSocketOptions$$ExternalSyntheticLambda1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ExtendedSocketOptions.lambda$options0$1((SocketOption) obj);
                    }
                }).collect(Collectors.toUnmodifiableSet());
                return extOptions;
            case 2:
                Set<SocketOption<?>> extOptions2 = (Set) this.options.stream().filter(new Predicate() { // from class: sun.net.ext.ExtendedSocketOptions$$ExternalSyntheticLambda0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return ExtendedSocketOptions.lambda$options0$0((SocketOption) obj);
                    }
                }).collect(Collectors.toUnmodifiableSet());
                return extOptions2;
            default:
                throw new IllegalArgumentException("Invalid socket option type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$options0$0(SocketOption option) {
        return !option.name().startsWith("TCP_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$options0$1(SocketOption option) {
        return !option.name().startsWith("UDP_");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ExtendedSocketOptions(Set<SocketOption<?>> options) {
        this.options = options;
    }

    public static final ExtendedSocketOptions getInstance() {
        return instance;
    }

    public static final void register(ExtendedSocketOptions extOptions) {
        if (instance != null) {
            throw new InternalError("Attempting to reregister extended options");
        }
        instance = extOptions;
    }

    static {
        try {
            Class.forName("jdk.net.ExtendedSocketOptions");
        } catch (ClassNotFoundException e2) {
            instance = new NoExtendedSocketOptions();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class NoExtendedSocketOptions extends ExtendedSocketOptions {
        NoExtendedSocketOptions() {
            super(Collections.emptySet());
        }

        @Override // sun.net.ext.ExtendedSocketOptions
        public void setOption(FileDescriptor fd2, SocketOption<?> option, Object value) throws SocketException {
            throw new UnsupportedOperationException("no extended options: " + option.name());
        }

        @Override // sun.net.ext.ExtendedSocketOptions
        public Object getOption(FileDescriptor fd2, SocketOption<?> option) throws SocketException {
            throw new UnsupportedOperationException("no extended options: " + option.name());
        }
    }
}
