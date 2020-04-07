package ru.marker;

class Herbivores extends Animals
{


    private String name = "Herbivores";
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void printName()
    {
        System.out.println(this.name);
        super.printName();
    }

    @Override
    public Enum<Zoo.Types> getType() {
        return Zoo.Types.Herbivores;
    }

}