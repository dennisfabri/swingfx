/*
 * Created on 08.12.2005
 */
package net.java.swingfx.common;

import java.awt.Component;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public final class EDTUtils {

    private EDTUtils() {
        // Hide
    }

    public static void setVisible(Component w, boolean v) {
        executeOnEDT(new VisibilityRunnable(w, v));
    }

    public static void repaint(Component w) {
        executeOnEDT(new RepaintRunnable(w));
    }

    public static boolean executeOnEDT(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                ExceptionRunnable er = new ExceptionRunnable(r);
                SwingUtilities.invokeAndWait(er);
                if (er.getThrowable() != null) {
                    throw new RuntimeException("An exception occured while in EDT.", er.getThrowable());
                }
            } catch (InterruptedException e) {
                return false;
            } catch (InvocationTargetException e) {
                return false;
            }
        }
        return true;
    }

    private static class ExceptionRunnable implements Runnable {

        private Runnable r = null;
        private Throwable t = null;

        public ExceptionRunnable(Runnable r) {
            this.r = r;
        }

        @Override
        public void run() {
            try {
                r.run();
            } catch (Exception re) {
                t = re;
            }
        }

        public Throwable getThrowable() {
            return t;
        }
    }

    private static class VisibilityRunnable implements Runnable {

        private Component w;
        private boolean v;

        public VisibilityRunnable(Component w, boolean v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public void run() {
            w.setVisible(v);
        }

    }

    private static class RepaintRunnable implements Runnable {

        private Component w;

        public RepaintRunnable(Component w) {
            this.w = w;
        }

        @Override
        public void run() {
            w.repaint();
        }
    }
}