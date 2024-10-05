package pkgSlRenderer;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import pkgSlUtils.slWindowManager;

import java.util.Random;

import static org.lwjgl.glfw.GLFW.*;
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



    public slRenderEngine() {

    }


    public void initOpenGL(slWindowManager wm) {
        this.my_wm = wm;
        this.my_wm.updateContextToThis();
        GL.createCapabilities();
    }

    private void generateCircleSegmentVertices(float [] center, float[] v1, float[] v2, float radius, float angle1, float angle2) {
        v1[0] = center[0] + radius * (float) Math.cos(angle1);
        v1[1] = center[1] + radius * (float) Math.sin(angle1);
        v1[2] = 0.0f;

        v2[0] = center[0] + radius * (float) Math.cos(angle2);
        v2[1] = center[1] + radius * (float) Math.sin(angle2);
        v2[2] = 0.0f;
    }


    public void render() {
        updateRandVertices();

        final float begin_angle = 0.0f, end_angle = (float) (2.0f * Math.PI);
        final float angleStep = (end_angle - begin_angle)/TRIANGLES_PER_CIRCLE;
        float CC_RED = 0.0f, CC_GREEN = 0.0f, CC_BLUE = 1.0f, CC_ALPHA = 1.0f;
        glClearColor(CC_RED, CC_GREEN, CC_BLUE, CC_ALPHA);
        while (!my_wm.isGlfwWindowClosed()) {
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
            for(int cur_circle = 0; cur_circle < MAX_CIRCLES; cur_circle++) {
                float[] center = rand_coords[cur_circle];
                float[] color = rand_colors[cur_circle];

                glColor4f(color[0], color[1], color[2], color[3]);
                glBegin(GL_TRIANGLES);
                for (int triangle = 0; triangle < TRIANGLES_PER_CIRCLE; triangle++) {
                    float[] v1 = new float[NUM_3D_COORDS];
                    float[] v2 = new float[NUM_3D_COORDS];

                    float angle1 = triangle * angleStep;
                    float angle2 = (triangle + 1) * angleStep;


                    generateCircleSegmentVertices(center, v1, v2, C_RADIUS, angle1, angle2);

                    glVertex3f(center[0], center[1], center[2]);
                    glVertex3f(v1[0], v1[1], v1[2]);
                    glVertex3f(v2[0], v2[1], v2[2]);
                }
                glEnd();
            }
            my_wm.swapBuffers();
            }

        my_wm.destroyGlfwWindow();
    }



}
