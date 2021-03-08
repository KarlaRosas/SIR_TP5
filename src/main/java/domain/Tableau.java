/**Tableau*/
package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tableau {

    private Long id;

    private String name;

    private List<Section> sections = new ArrayList<Section>();

    public Tableau() {
        super();
    }

    public Tableau(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}



