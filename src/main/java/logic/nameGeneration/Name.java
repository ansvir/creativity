package logic.nameGeneration;

import resource.NameGenerationDefaultSettingsManager;

public class Name {
    private String firstName;
    private String lastName;
    private int nameLength;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNameLength() {
        return nameLength;
    }

    public void setNameLength(int nameLength) {
        this.nameLength = nameLength;
    }

    public static int getDefaultNameLength() {
        return Integer.parseInt(NameGenerationDefaultSettingsManager.getProperty("name.length"));
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nameLength=" + nameLength +
                '}';
    }
}
