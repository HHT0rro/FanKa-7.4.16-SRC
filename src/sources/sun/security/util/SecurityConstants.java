package sun.security.util;

import java.lang.reflect.ReflectPermission;
import java.net.NetPermission;
import java.net.SocketPermission;
import java.security.AllPermission;
import java.security.SecurityPermission;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class SecurityConstants {
    public static final String FILE_DELETE_ACTION = "delete";
    public static final String FILE_EXECUTE_ACTION = "execute";
    public static final String FILE_READLINK_ACTION = "readlink";
    public static final String FILE_READ_ACTION = "read";
    public static final String FILE_WRITE_ACTION = "write";
    public static final String PROPERTY_READ_ACTION = "read";
    public static final String PROPERTY_RW_ACTION = "read,write";
    public static final String PROPERTY_WRITE_ACTION = "write";
    public static final String SOCKET_ACCEPT_ACTION = "accept";
    public static final String SOCKET_CONNECT_ACCEPT_ACTION = "connect,accept";
    public static final String SOCKET_CONNECT_ACTION = "connect";
    public static final String SOCKET_RESOLVE_ACTION = "resolve";
    public static final AllPermission ALL_PERMISSION = new AllPermission();
    public static final NetPermission SPECIFY_HANDLER_PERMISSION = new NetPermission("specifyStreamHandler");
    public static final NetPermission SET_PROXYSELECTOR_PERMISSION = new NetPermission("setProxySelector");
    public static final NetPermission GET_PROXYSELECTOR_PERMISSION = new NetPermission("getProxySelector");
    public static final NetPermission SET_COOKIEHANDLER_PERMISSION = new NetPermission("setCookieHandler");
    public static final NetPermission GET_COOKIEHANDLER_PERMISSION = new NetPermission("getCookieHandler");
    public static final NetPermission SET_RESPONSECACHE_PERMISSION = new NetPermission("setResponseCache");
    public static final NetPermission GET_RESPONSECACHE_PERMISSION = new NetPermission("getResponseCache");
    public static final NetPermission SET_SOCKETIMPL_PERMISSION = new NetPermission("setSocketImpl");
    public static final RuntimePermission CREATE_CLASSLOADER_PERMISSION = new RuntimePermission("createClassLoader");
    public static final RuntimePermission CHECK_MEMBER_ACCESS_PERMISSION = new RuntimePermission("accessDeclaredMembers");
    public static final RuntimePermission MODIFY_THREAD_PERMISSION = new RuntimePermission("modifyThread");
    public static final RuntimePermission MODIFY_THREADGROUP_PERMISSION = new RuntimePermission("modifyThreadGroup");
    public static final RuntimePermission GET_PD_PERMISSION = new RuntimePermission("getProtectionDomain");
    public static final RuntimePermission GET_CLASSLOADER_PERMISSION = new RuntimePermission("getClassLoader");
    public static final RuntimePermission STOP_THREAD_PERMISSION = new RuntimePermission("stopThread");
    public static final RuntimePermission GET_STACK_TRACE_PERMISSION = new RuntimePermission("getStackTrace");
    public static final RuntimePermission SUBCLASS_IMPLEMENTATION_PERMISSION = new RuntimePermission("enableContextClassLoaderOverride");
    public static final SecurityPermission CREATE_ACC_PERMISSION = new SecurityPermission("createAccessControlContext");
    public static final SecurityPermission GET_COMBINER_PERMISSION = new SecurityPermission("getDomainCombiner");
    public static final SecurityPermission GET_POLICY_PERMISSION = new SecurityPermission("getPolicy");
    public static final String SOCKET_LISTEN_ACTION = "listen";
    public static final SocketPermission LOCAL_LISTEN_PERMISSION = new SocketPermission("localhost:0", SOCKET_LISTEN_ACTION);
    public static final String PROVIDER_VER = GetPropertyAction.privilegedGetProperty("java.specification.version");
    public static final ReflectPermission ACCESS_PERMISSION = new ReflectPermission("suppressAccessChecks");
    public static final RuntimePermission REFLECTION_FACTORY_ACCESS_PERMISSION = new RuntimePermission("reflectionFactoryAccess");

    private SecurityConstants() {
    }
}
