package com.jpaf.jpaformation.dao;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
//@IdClass(PersonnePK.class)
//@SequenceGenerator(name="PERSONNE_SEQUENCE", sequenceName="PERSONNE_SEQ")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "PERSONNE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONNE_SEQUENCE")
    private int idPerson ;

    @Column(name = "LASTNAME_ID")
    private String nom;

    @Column(name = "FIRSTNAME_ID")
    private String prenom;


    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Address> addresses;

    @Column(name = "ne_pas_tenire_compte")
    @Transient
    private String ignore;

    @Column(name = "created", nullable = false, updatable=false)
   @Temporal(TemporalType.TIME)
   private Date heureNaissance;


    @Embedded
    private SuplimentInformation supInfo;


    private int taille;



    public Person() {
        super();
    }

    public Person(String nom, String prenom, Gender gender, int taille) {
        this.idPerson = idPerson;
        this.nom = nom;
        this.prenom = prenom;
        this.gender = gender;
        this.taille = taille;
    }

    public Person(String nom, String prenom, Gender gender, String images, String s, int i) {
    }

    public Date getHeureNaissance() {
        return heureNaissance;
    }

    public void setHeureNaissance(Date heureNaissance) {
        this.heureNaissance = heureNaissance;
    }
   /* public SuplimentInformation getClePrimaire() {
        return this.naiisance;
    }

    public void setNom(SuplimentInformation clePrimaire) {
        this.naiisance = clePrimaire;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Gender getGenre() {
        return gender;
    }

    public void setGenre(Gender gender) {
        this.gender = gender;
    }

    public int getTaille() {
        return this.taille;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    public boolean equals(Object obj) {
        boolean resultat = false;

        if (obj == this) {
            resultat = true;
        } else {
            if (!(obj instanceof Person)) {
                resultat = false;
            } else {
                Person autre = (Person) obj;
                if (!nom.equals(autre.nom)) {
                    resultat = false;
                } else {
                    if (prenom != autre.prenom) {
                        resultat = false;
                    } else {
                        resultat = true;
                    }
                }
            }
        }
        return resultat;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }

}

