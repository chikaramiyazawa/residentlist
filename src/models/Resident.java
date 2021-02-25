package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "resident")
@NamedQueries({
@NamedQuery(
        name = "getAllResident",
        query = "SELECT r FROM Resident AS r ORDER BY r.id DESC"
            ),
@NamedQuery(
        name = "getResidentCount",
        query ="SELECT COUNT(r) FROM Resident AS r"
        ),
@NamedQuery(
        name = "getRoomSearch",
        query = "SELECT r FROM Resident AS r WHERE r.room like :room  ORDER BY r.id DESC"
        ),
@NamedQuery(
        name = "getRoomCount",
        query = "SELECT COUNT(r) FROM Resident AS  r WHERE r.room = :room"
        ),
@NamedQuery(
        name = "getResidentSearch",
        query = "SELECT r FROM Resident AS r WHERE r.resident like :resident ORDER BY r.id DESC"
        ),
@NamedQuery(
        name = "getResidentSearchCount",
        query = "SELECT COUNT(r) FROM Resident AS r WHERE r.resident = :resident"
        ),
@NamedQuery(
        name = "getResidentDateSearch",
        query = "SELECT r FROM Resident AS r WHERE r.date = :date ORDER BY r.id DESC"
        ),
@NamedQuery(
        name = "getResidentDateSearchCount",
        query = "SELECT COUNT(r) FROM Resident AS r WHERE r.date = :date"
        ),
@NamedQuery(
        name = "getBeforeDate",
        query = "SELECT r FROM  Resident AS r WHERE r.date < :date  ORDER BY r.id DESC"
        ),
@NamedQuery(
        name = "getBeforeDateCount",
        query = "SELECT COUNT(r) FROM  Resident  AS r WHERE r.date < :date"
        ),
@NamedQuery(
        name = "getAfterDate",
        query = "SELECT r FROM Resident AS r WHERE r.date > :date  ORDER BY r.id DESC"
        ),
@NamedQuery(
        name = "getAfterDateCount",
        query = "SELECT COUNT(r) FROM  Resident  AS r WHERE r.date > :date "
           )


})

@Entity
public class Resident {


@Id
 @Column(name = "id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(name = "room")
 private String room;

 @Column(name = "resident")
 private String resident;

 @Column(name = "profession")
 private String profession;

 @Column(name = "information")
 private String information;

 @Column(name = "date")
 private Date date;

 @Column(name = "update_at")
 private Timestamp update_at;

 public Integer getId() {
     return id;
 }

 public void setId(Integer id) {
     this.id = id;
 }

 public String getRoom() {
     return room;
 }

 public void setRoom(String room) {
     this.room = room;
 }

 public String getResident() {
     return resident;
 }

 public void setResident(String resident) {
     this.resident = resident;
 }

 public String getProfession() {
     return profession;
 }

 public void setProfession(String profession) {
     this.profession = profession;
 }

 public String getInformation() {
     return information;
 }

 public void setInformation(String information) {
     this.information = information;
 }

 public Date getDate() {
     return date;
 }

 public void setDate(Date date) {
     this.date = date;
 }

 public Timestamp getUpdate_at() {
     return update_at;
 }

 public void setUpdate_at(Timestamp update_at) {
     this.update_at = update_at;
 }

}
