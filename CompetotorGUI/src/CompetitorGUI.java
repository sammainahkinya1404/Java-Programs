class XXXCompetitor {
    private int competitorNumber;
    private Name name;
    private String level;
    private String extraAttribute;
    private double overallScore;

    public XXXCompetitor(int competitorNumber, Name name, String level, String extraattribute) {
        this.competitorNumber = competitorNumber;
        this.name = name;
        this.level = level;
        this.extraAttribute = extraattribute;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public Name getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getExtraAttribute() {
        return extraAttribute;
    }

    public double getOverallScore() {
        return 5;
    }

    public String getFullDetails() {
        return "Competitor number " + competitorNumber + ", name " + name.getFullName() + ", " + extraAttribute + "."
                + " " + name.getFirstName() + " is a " + level + " and has an overall score of " + overallScore + ".";
    }

    public String getShortDetails() {
        return "CN " + competitorNumber + " (" + name.getInitials() + ") has overall score " + overallScore + ".";
    }
}

class Name {
    private String firstName;
    private String lastName;
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public String getInitials() {
        return firstName.charAt(0) + "." + lastName.charAt(0) + ".";
    }
    public String getFirstName() {
        return firstName;
    }
    public static void main(String[] args) {
        Name name1 = new Name("Keith", "John");
        Name name2 = new Name("Jane", "Macdonald");
        XXXCompetitor competitor1 = new XXXCompetitor(100, name1, "Novice", "UK");
        XXXCompetitor competitor2 = new XXXCompetitor(101, name2, "Standard", "US");

        System.out.println(competitor1.getFullDetails());
        System.out.println(competitor1.getShortDetails());
        System.out.println("Competitor Number: " + competitor1.getCompetitorNumber());
        System.out.println("Name: " + competitor1.getName().getFullName());
        System.out.println("Level: " + competitor1.getLevel());
        System.out.println("Extra Attribute: " + competitor1.getExtraAttribute());
        System.out.println("Overall Score: " + competitor1.getOverallScore());

        System.out.println(competitor2.getFullDetails());
        System.out.println(competitor2.getShortDetails());
        System.out.println("Competitor Number: " + competitor2.getCompetitorNumber());
        System.out.println("Name: " + competitor2.getName().getFullName());
        System.out.println("Level: " + competitor2.getLevel());
        System.out.println("Extra Attribute: " + competitor2.getExtraAttribute());
        System.out.println("Overall Score: " + competitor2.getOverallScore());
    }


}
