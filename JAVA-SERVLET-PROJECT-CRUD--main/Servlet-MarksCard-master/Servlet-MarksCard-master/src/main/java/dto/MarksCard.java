package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class MarksCard {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
String standard;
double science;
double maths;
double english;
double percentage;
String result;
}