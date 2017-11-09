package DesignPattern.Decorator;

public class HorizontalScrollBar extends WindowDecorator {
    public HorizontalScrollBar(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizontalScrollBar();
    }

    private void drawHorizontalScrollBar() {
        System.out.println("Draw Horizontal ScrollBar");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including horizontal scrollbars";
    }
}
