package Model;

public enum NaturalWanderTypes {
    TEST(1, 2),
    TEST1(2, 2),
    TEST2(3, 3);
    //TODO: choosing naturalWanders


    final NaturalWander naturalWander;

    NaturalWanderTypes(int happiness, int gold)
    {
        this.naturalWander = new NaturalWander(happiness, gold, this.toString());
    }
}
