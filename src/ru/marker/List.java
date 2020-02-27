package ru.marker;

class Node
{

    private Integer data;

    private Node nextElement;

    public Node next()
    {
        return this.nextElement;
    }

    public Node()
    {

    }
    public Node(Integer data)
    {
        this.data = data;
    }

    public Integer getData()
    {
        return this.data;
    }

    public void setData(Integer otherData)
    {
        this.data = otherData;
    }

    public void setNextElement(Node otherNextElement)
    {
        this.nextElement = otherNextElement;
    }

}
class NullNode extends Node
{
    public NullNode()
    {
        super();
    }
    public NullNode(Integer data)
    {
        super(data);
    }

    public Integer getData()
    {
        return null;
    }

}