package Lab1.task1;

public class Display {
    private int width, height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getPpi() {
        return ppi;
    }

    public String getModel() {
        return model;
    }

    void compareSize(Display m) {
        String s = (this.width * this.height) > (m.getWidth() * m.getHeight()) ? this.model + " is bigger\n" : (this.width * this.height) < (m.getWidth() * m.getHeight()) ? m.getModel() + " is bigger" : "The displays are equal";
        System.out.println(s);
    }

    void compareSharpness(Display m) {
        String s = (this.ppi) > (m.getPpi()) ? this.model + " is sharper\n" : (this.ppi) < (m.getPpi()) ? m.getModel() + " is sharper" : "The displays have equal sharpness";
        System.out.println(s);
    }

    void compareWithMonitor(Display m) {
        compareSize(m);
        compareSharpness(m);

    }
}
