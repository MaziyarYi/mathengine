package model;

public class Section {

    private final String section;

    public Section(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "model.Section{" +
                "section='" + section + '\'' +
                '}';
    }

    public String getSection() {
        return section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Section section = (Section) o;
        return this.section != null ? this.section.equals(section.toString()) : section.section == null;
    }

    @Override
    public int hashCode() {
        return section != null ? section.hashCode() : 0;
    }

}
