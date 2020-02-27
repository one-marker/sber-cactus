package ru.marker;


class List
{
    Node head;

    public List()
    {
        head = null;
    }

    public void push(Node newElement)
    {
        newElement.setNextElement(head);
        head = newElement;
    }
    public void pop()
    {
        if (head != null)
            head = head.next();
    }

    public void push_back(Node newElement)
    {
        Node iterator = head;
        if (iterator == null)
            this.push(newElement);
        else
        {
            while (iterator.next() != null)
                iterator = iterator.next();

            iterator.setNextElement(newElement);
        }
    }

    public void pop_back()
    {
        Node iterator = head;

        if (iterator != null)
        {
            if (iterator.next() == null)
            {
                this.pop();
                return;
            }

            while (iterator.next().next() != null)
                iterator = iterator.next();

            iterator.setNextElement(null);

        }

    }

    public void print()
    {
        Node iterator = head;
        while (iterator != null)
        {
            System.out.println(iterator.getData());
            iterator = iterator.next();
        }

    }
    public void combineList(List secondList, Node newElement)
    {
        if (this.head == null && secondList.head == null)
        {
            secondList.push(newElement);
            this.head = secondList.head;
            return;
        }

        this.push_back(newElement);

        Node iterator2 = secondList.head;
        while (iterator2.next() != null)
            iterator2 = iterator2.next();

        if (newElement != iterator2)
        {
            iterator2.setNextElement(newElement);
            return;
        }

        return;

    }
    public int size()
    {
        int size = 0;

        Node iterator = head;
        while (iterator != null)
        {
            iterator = iterator.next();
            size++;
        }
        return size;
    }
    public Node findCommonNode(List secondList)
    {
        int odds = this.size() - secondList.size();

        Node iterator = head;
        Node iterator2 = secondList.head;

        if (odds >= 0)
            for (int i=0; i<odds; i++)
                iterator = iterator.next();
        else
            for (int i=0; i<odds*(-1); i++)
                iterator2 = iterator2.next();

        while (iterator != null)
        {
            if (iterator == iterator2)
                return iterator;

            iterator = iterator.next();
            iterator2 = iterator2.next();
        }

        return new NullNode();
    }

    public Node byIndex(int searchIndex)
    {
        int index = 0;
        Node iterator = head;
        while (iterator!= null)
        {
            if (index == searchIndex)
                return iterator;

            iterator = iterator.next();
            index++;

        }
        return new NullNode();
    }
    public boolean removeAt(int searchIndex)
    {
        int index = 1;
        Node iterator = head;

        while (iterator != null)
        {
            if (searchIndex == 0)
            {
                this.pop();
                return true;
            }

            if (searchIndex == index)
            {
                if (iterator.next() == null)
                {
                    return false;
                }
                else
                {
                    Node tmp = iterator.next().next();
                    iterator.setNextElement(tmp);
                    return true;
                }



            }

            iterator = iterator.next();
            index++;
        }
        return false;

    }

    public boolean insertAt(int searchIndex, Node newElement)
    {
        int index = 1;
        Node iterator = head;

        while (iterator != null)
        {
            if (searchIndex == 0)
            {
                this.push(newElement);
                return true;
            }

            if (searchIndex == index)
            {
                Node tmp = iterator.next();
                iterator.setNextElement(newElement);
                newElement.setNextElement(tmp);
                return true;
            }

            iterator = iterator.next();
            index++;
        }
        return false;

    }
    public boolean swap(int index1, int index2)
    {
        Node newElement1 = this.byIndex(index1);
        Node newElement2 = this.byIndex(index2);


        int index = 0;
        Node iterator = head;
        while (iterator!= null)
        {
            if (index == index2)
                iterator.setData(newElement1.getData());
            if (index == index1)
                iterator.setData(newElement2.getData());

            iterator = iterator.next();
            index++;

        }





//        while (iterator != null)
//        {
//            if (index1 == index)
//            {
//                Node tmp = iterator.next();
//                iterator.setNextElement(newElement1);
//                newElement1.setNextElement(tmp);
//                return true;
//            }
//            if (index2 == index)
//            {
//                Node tmp = iterator.next();
//                iterator.setNextElement(newElement2);
//                newElement2.setNextElement(tmp);
//                return true;
//            }
//
//            iterator = iterator.next();
//            index++;
//        }
        return false;
    }

    public int byValue(Node searchValue)
    {

        int index = 0;
        Node iterator = head;
        while (iterator!= null)
        {
            if (iterator.getData().equals(searchValue.getData()))
                return index;

            iterator = iterator.next();
            index++;

        }
        return -1;

    }



}
