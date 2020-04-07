package ru.marker;



class Carnivores extends Animals
{

    enum Kind {Carnivores, Herbivores};
    private String name = "Carnivores";
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
        return Zoo.Types.Carnivores;
    }


//    @Override
//    public void eat()
//    {
//
//    }
//
//    @Override
//    public void sleep()
//    {
//
//    }
}
