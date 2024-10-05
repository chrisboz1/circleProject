package pkgSlUtils;
import pkgDriver.slSpot;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class slWindowManager {


    private long glfw_win; //winid
    private static slWindowManager my_window;
//    slWindowManager.get().initGLFWWindow(WIN_WIDTH, WIN_HEIGHT, "CSUS CSC133");
    private slWindowManager(int width, int height, String label) {
        if (glfw_win != 0) {
            glfw_win = glfwCreateWindow(width, height, label, NULL, NULL);
        }

    }
    public int[] getCurrentWindowSize() {
        return new int[]{};
    }

    public static slWindowManager get() {
        if(my_window == null) {
            my_window = new slWindowManager(slSpot.WIN_WIDTH, slSpot.WIN_HEIGHT, "CSC 133");
        }
        return my_window;
    }

    public void destroyGlfwWindow() {

    }

    public void swapBuffers() {}

    public boolean isGlfwWindowClosed() {
        return false;
    }

    public long initGLFWWindow(int width, int height, String label) {

        return 0;
    }

    public int[] getWindowSize(){
        return new int[]{};
    }

    public void updateContextToThis() {}




}
