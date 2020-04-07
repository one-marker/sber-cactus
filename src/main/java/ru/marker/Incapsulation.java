package ru.marker;

//1-ЫЙ ПРИМЕР
class Shop
{

    private double money = 50.0;

    public double getMoney() //Выполняет роль кассира
    {
        return this.money;
    }

}
//2-ОЙ ПРИМЕР
class Marker
{
    private String color;

    public Marker(String setColor)
    {
        this.color = setColor;
    }
    public boolean equalsColor(Marker otherMarker)
    {
        return this.color.equals(otherMarker.color);
    }
}
class Incapsulation
{
    public static void check()
    {
        Shop sber = new Shop();
        System.out.println(sber.getMoney());

        Marker marker1 = new Marker("Красный");
        Marker marker2 = new Marker("Красный");
        System.out.println(marker1.equalsColor(marker2));

    }
}
