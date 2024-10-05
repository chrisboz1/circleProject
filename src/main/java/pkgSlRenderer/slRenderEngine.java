package pkgSlRenderer;

import pkgSlUtils.slWindowManager;

import java.util.Random;

import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.opengl.GL11.*;

public class slRenderEngine {

    private final int NUM_RGBA = 4;
    private final int NUM_3D_COORDS = 3;
    private final int TRIANGLES_PER_CIRCLE = 40;
    private final float C_RADIUS = 0.05f;
    private final int MAX_CIRCLES = 100;
    private final int UPDATE_INTERVAL = 30;

    private float[][] rand_colors;
    private float[][] rand_coords;

    private slWindowManager my_wm;
    Random my_rand = new Random();

    private void updateRandVertices() {
        //colors
        final int CR = 0, CG = 1, CB = 2, CA = 3;

        //vertices
        final int CX = 0, CY = 1, CZ = 2;

        rand_colors = new float[MAX_CIRCLES][NUM_RGBA];
        rand_coords = new float[MAX_CIRCLES][NUM_3D_COORDS];

        for (int i = 0; i < MAX_CIRCLES; i++) {
            rand_coords[i][0] = my_rand.nextFloat() * 2.0f-1.0f;
            rand_coords[i][1] = my_rand.nextFloat() * 2.0f-1.0f;
            rand_coords[i][2] = 0.0f;

            rand_colors[i][0] = my_rand.nextFloat();
            rand_colors[i][1] = my_rand.nextFloat();
            rand_colors[i][2] = my_rand.nextFloat();
            rand_colors[i][3] = my_rand.nextFloat();
        }
    }



    }

    public slRenderEngine() {

    }


    public void initOpenGL(slWindowManager wm) {
//        glfwMakeContextCurrent(wm.glfw_win);
    }

    private void generateCircleSegmentVertices(float [] a, float b, float[] c, float d, float e, int f) {

    }


    public void render() {
        updateRandVertices();

        final float begin_angle = 0.0f, end_angle = (float) (2.0f * Math.PI);
        final float angleStep = (end_angle - begin_angle)/TRIANGLES_PER_CIRCLE;

        while (!my_wm.isGlfwWindowClosed()) {
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
            for(int cur_circle = 0; cur_circle < MAX_CIRCLES; cur_circle++) {

            }
            glBegin(GL_TRIANGLES);
            // Each triangle will require color + 3 vertices as below.
            // For each circle you need 40 of these for the assignment.
            glColor4f(..., ..., ..., ...);
            glVertex3f(x0, y0, z0);
            glVertex3f(x1, y1, z1);
            glVertex3f(x2, y2, z2);

            glEnd();
            my_wm.swapBuffers();
    }

//    public static void draw(int Cx, int Cy, float Vx0, float Vy0, float Vx1, float Vy1) {
//        int Z0 = 0;
//        Random rand = new Random();
//        glColor4f(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
//        glBegin(GL_TRIANGLES);
//        glVertex3f(Cx, Cy, Z0);
//        glVertex3f(Vx0, Vy0, Z0);
//        glVertex3f(Vx1, Vy1, Z0);
//        glEnd();
//    }

}
