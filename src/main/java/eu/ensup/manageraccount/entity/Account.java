package eu.ensup.manageraccount.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account
{
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double discount;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private TypeAccount type;
}
