package ru.marker;


import java.util.ArrayList;

//1-ЫЙ ПРИМЕР
interface Readable
{
    void read();
}

class Book implements Readable
{
    @Override
    public void read()
    {
        System.out.println("Читаю книгу");
    }
}
class Comics implements Readable
{
    @Override
    public void read()
    {
        System.out.println("Читаю комикс");
    }
}


//2-ОЙ ПРИМЕР
class Character
{
    String name() { return "Персонаж"; }
}
class Ashe extends Character
{
    @Override
    String name() { return "Ashe"; }
}
class Widow extends Character
{
    @Override
    String name() { return "Widow"; }
}
class Diva extends Character
{
    @Override
    String name() { return "Diva"; }
}

class Polimorfism
{
    static void check()
    {
        Character[] characters = new Character[] { new Ashe(), new Widow(), new Diva() };

        for (Character character:characters)
        {
            System.out.println(character.name());
        }

        ArrayList<Readable> arr = new ArrayList<Readable>();
        arr.add(new Book());
        arr.add(new Comics());

        for (Readable element:arr)
        {
            element.read();
        }
    }
}