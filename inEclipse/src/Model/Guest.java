package Model;

import java.util.Objects;

public class Guest {
  private Person personalDetails;
   private int numVisit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;
        return getNumVisit() == guest.getNumVisit() && Objects.equals(getPersonalDetails(), guest.getPersonalDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalDetails(), getNumVisit());
    }

    public int getNumVisit() {
        return numVisit;
    }

    public void setNumVisit(int numVisit) {
        this.numVisit = numVisit;
    }

    public Person getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(Person personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Guest(Person personalDetails, int numVisit) {
        this.personalDetails = personalDetails;
        this.numVisit = numVisit;
    }
    public Guest(Person personalDetails) {
        this.personalDetails = personalDetails;
        this.numVisit =1;
    }
}
