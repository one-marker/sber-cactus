package ru.marker;

class Animals
{

  //  enum Kind {Carnivores, Herbivores};


    private boolean noise = false;
    private boolean sleep = false;

    private String name = "animal";
    public void printName()
    {


        System.out.println("Sleep: " + sleep);
        System.out.println("Noise: " + noise);
        System.out.println("------");
    }

    public String getName() {
        return name;
    }
    public Enum<Zoo.Types> getType() {
        return null;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setNoise(boolean noise) {
        this.noise = noise;
    }

    public boolean isNoise()
    {
        return noise;
    }


    void eat()
    {
        noise = false;
    }
    void sleep()
    {
        noise = false;
        sleep = true;
    }
    void noise()
    {
        noise = true;
        sleep = false;
    }
    void awake()
    {
        sleep = false;
    }

}
