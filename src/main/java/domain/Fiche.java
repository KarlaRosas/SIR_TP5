/**Fiche**/
package domain;

import javax.persistence.*;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fiche {
    private Long id;

    private String name;
    private String url;
    private String lieu;
    private String note;
    //private Date date;

    private Integer tempsMinutes;


    private Section section;

    private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

    private List<Tars> tars = new ArrayList<Tars>();

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="CREATED_TIME")
    private Date creationTime;

    public Fiche() {
    }

    public Fiche(String name, Section section, String url, String lieu, String note, Integer tempsMinutes) {
        this.name = name;
        this.section = section;
        this.lieu = lieu;
        this.url = url;
        this.note =note;
        this.tempsMinutes =tempsMinutes;


    }

    public Fiche(String name) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getTempsMinutes() {
        return tempsMinutes;
    }

    public void setTempsMinutes(Integer tempsMinutes) {
        this.tempsMinutes = tempsMinutes;
    }

    @OneToMany(mappedBy = "fiche", cascade = CascadeType.PERSIST)
    public List<Tars> getTars() {
        return tars;
    }

    public void setTars(List<Tars> tars) {
        this.tars = tars;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToMany(mappedBy = "fiches", cascade = CascadeType.PERSIST)
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }


    @Override
    public String toString() {
        return "Fiche [id=" + id + ", name=" + name + ", section="
                + "]";
    }

}
