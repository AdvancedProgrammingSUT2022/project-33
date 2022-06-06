package Program.Model.Enums;

import Program.Model.SpecialPerson;

public enum SpecialPeoples {



    //easter eggs
    WALTER_WHITE("Walter white", 1000, 2500, 0),
    RICARDO("Ricardo milos", 100, 0, 3),
    ALI_MATIN("Ali matin", -250, -500, 6),
    DOCTOR_OCTOPUS("Doctor octopus", 0, 1500, 0),
    ;

    public final SpecialPerson person;

    SpecialPeoples(String gameName, int gold, int science, int happiness)
    {
        person = new SpecialPerson(gameName, gold, science, happiness);
    }

}
