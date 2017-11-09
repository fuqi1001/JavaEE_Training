package DesignPattern.Decorator;

public abstract class WindowDecorator implements Window{
    protected  Window decoratedWindow;
    public WindowDecorator (Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    @Override
    public void draw() {
        decoratedWindow.draw();
    }

    @Override
    public String getDescription() {
        return decoratedWindow.getDescription();
    }
}
