package DesignPattern.Decorator;

public class VerticalScrollBar extends WindowDecorator{

    public VerticalScrollBar(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public void draw() {
        super.draw();
        drawVerticalScrollBar();
    }

    private void drawVerticalScrollBar() {
        System.out.println("Draw Vertical Scrollbar");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", including vertical scrollbars";
    }
}
