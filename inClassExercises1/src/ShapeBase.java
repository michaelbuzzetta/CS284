public abstract class ShapeBase extends ShapeInterface {
    private int offset;

    public ShapeBase(int newOffset)
    {
        offset=newOffset;
    }

    public void setOffset(int offset)
    {
        this.offset=offset;
    }

    public void drawAt(int lineNumber)
    {
        drawHere();
    }

    public abstract void drawHere();


}
