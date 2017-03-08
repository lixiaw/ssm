package com.lucifer.ssm.system;

/**
 * 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
 * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
 * Created by nelucifer on 2017/3/5.
 */
public class SessionStore {
    private static ThreadLocal<Object> threadLocal = new ThreadLocal();

    public static ThreadLocal<Object> getThreadLocal() {
        return threadLocal;
    }

    public static void setThreadLocal(ThreadLocal<Object> threadLocal) {
        SessionStore.threadLocal = threadLocal;
    }
}
